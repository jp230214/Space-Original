#include veil:camera
#include veil:deferred_utils
#include veil:common

#define PLANET_TEXTURE_COUNT 32

uniform sampler2D DiffuseSampler0;
uniform sampler2D DiffuseDepthSampler;

uniform sampler2D StarsTexture;
uniform sampler2D SunTexture;
uniform sampler2D SaturnRingTexture;
uniform sampler2D UranusRingTexture;
uniform sampler2D NoiseTexture;
uniform sampler2D PlanetTextures[MAX_PLANETS];
uniform sampler2D EarthCloudsTexture;
uniform sampler2D EarthNightTexture;

uniform vec2 InSize;
uniform float Time;
uniform vec3 ShipCenter;
uniform vec3 ShipPosition;
uniform vec4 ShipRotation;
uniform int UnrenderedPlanet;
uniform float SunFac;

/** ATMOSPHERE SETTINGS! **/
struct Atmosphere { // all comments courtesy of Cappin! Thank you <333
    float size;
    float falloff;// the rate that the atmosphere blends into space. higher values = sharper blending
    float density;// you'll have to lower this if you increase the atmosphere's radius.
    float densityMultiplier;// this adjusts the amount that the original color is blended away.
    vec3 scatteringWavelengthCoefficients;// this controls the color of the atmosphere.
    float brightnessMultiplier;// punch up the brightness! make it pop... thumbnail material
// the higher the wavelength of a particular channel (R, G, B), the more it scatters.
// if they're all equal, it will appear gray or white.
};

struct PlanetData {
    vec3 position;
    float radius;
    int id;
    float padding1;
    float padding2;
    float padding3;
    Atmosphere atmosphere;
};

layout(std140) uniform PlanetsBuffer {
    PlanetData[MAX_PLANETS] planets;
    int planetCount;
};

#define NoiseSteps 4
#define NoiseAmplitude 0.08
#define NoiseFrequency 48.0

in vec2 texCoord;

out vec4 fragColor;

float Pi = 3.14159265;
vec2 res = vec2(8192.0, 4096.0);

const vec3  sunColor1 = vec3(1.0, 0.8, 0.8);
const vec3  sunColor2 = vec3(1.0, 0.7, 0.7);

// shape and light
//float earthRadius = 20.0;
float sunRadius = 300.0;
float scaling = 0.000001;
//float elevationScale = earthRadius * 0.015;

// position and spin
//vec3 earthPosition = vec3(200.0, 0.0, 0.0);
vec3 sunPosition = vec3(0.0, 0.0, 0.0);
vec2 earthSpin = vec2(Time / 5000.0, 0.0);
vec2 earthCloudsSpin = vec2(Time / 2500.0, 0.0);

// for ray marching with multiple objects
float combinedDepth = 0.0;
vec3 combinedColor = vec3(0.0);

/////////////////////////////////////////////////////////////////////////
/*                              UTILS                                 */
///////////////////////////////////////////////////////////////////////
// noise
float mod289(float x){ return x - floor(x * (1.0 / 289.0)) * 289.0; }
vec4 mod289(vec4 x){ return x - floor(x * (1.0 / 289.0)) * 289.0; }
vec4 perm(vec4 x){ return mod289(((x * 34.0) + 1.0) * x); }

float noise(vec3 p){
    vec3 a = floor(p);
    vec3 d = p - a;
    d = d * d * (3.0 - 2.0 * d);

    vec4 b = a.xxyy + vec4(0.0, 1.0, 0.0, 1.0);
    vec4 k1 = perm(b.xyxy);
    vec4 k2 = perm(k1.xyxy + b.zzww);

    vec4 c = k2 + a.zzzz;
    vec4 k3 = perm(c);
    vec4 k4 = perm(c + 1.0);

    vec4 o1 = fract(k3 * (1.0 / 41.0));
    vec4 o2 = fract(k4 * (1.0 / 41.0));

    vec4 o3 = o2 * d.z + o1 * (1.0 - d.z);
    vec2 o4 = o3.yw * d.x + o3.xz * (1.0 - d.x);

    return o4.y * d.y + o4.x * (1.0 - d.y);
}

vec4 cubic (float v) {
    vec4 n = vec4(1.0, 2.0, 3.0, 4.0) - v;
    vec4 s = n * n * n;
    float x = s.x;
    float y = s.y - 4.0 * s.x;
    float z = s.z - 4.0 * s.y + 6.0 * s.x;
    float w = 6.0 - x - y - z;
    return vec4(x, y, z, w) * (1.0 / 6.0);
}

bool sphere(vec3 offset, vec3 ray, float radius, out float T) {
    float A = dot(ray, ray);
    float B = dot(offset, ray);
    float C = dot(offset, offset)-radius*radius;
    float disc = B*B-A*C;
    if (disc>0.0)
    T=(-B-sqrt(disc))/A;
    else
    T = -B/A;
    return disc>0.0 && dot(ray, -offset) > 0.0;
}

float lengthSquared(vec3 v) {
    return dot(v, v);
}

vec2 raySphere(vec3 rayOrigin, vec3 rayDir, float sphereRadius, out bool hit) {
    vec3 offset = rayOrigin;
    float a = 1.0;
    float b = 2.0 * dot(offset, rayDir);
    float c = dot (offset, offset) - sphereRadius * sphereRadius;
    float num = b * b - 4.0 * a * c;

    if (num > 0.0) {
        float s = sqrt(num);
        float dstToSphereNear = max(0.0, (-b - s) / (2.0 * a));
        float dstToSphereFar = (-b + s) / (2.0 * a);

        if (dstToSphereFar >= 0.0) {
            hit = true;
            return vec2(dstToSphereNear, dstToSphereFar);
        }
    }

    hit = false;
    return vec2(0.0);
}

vec4 qMult(vec4 A, vec4 B) {
    float r1 = A.x;
    float r2 = B.x;
    vec3 v1 = A.yzw;
    vec3 v2 = B.yzw;
    return vec4(r1*r2-dot(v1, v2), r1*v2+r2*v1+cross(v1, v2));
}

vec4 conjQ(vec4 Q) {
    return vec4(Q.x, -Q.yzw);
}

vec3 rotateQ(vec3 V, vec4 Q) {
    return qMult(qMult(conjQ(Q), vec4(0.0, V)), Q).yzw;
}

vec2 worldToSpherical(vec3 flatCoord, vec2 spin) {
    float r = length(flatCoord);
    return vec2(1.0 - atan(flatCoord.y, flatCoord.x) / (PI * 2.0), 1.0 - acos(flatCoord.z / r) / PI) + spin;
}

vec3 lightDirection(vec3 position) {
    return normalize(sunPosition-position);
}

////////////////////////////////////////////////////////////////
/*                             PLANET                         */
////////////////////////////////////////////////////////////////

vec3 colorOnPlanet(vec3 position, vec3 normal, PlanetData planet, sampler2D samplerTexture) {
    float light = max(0.0, (dot(normal, lightDirection(planet.position))+1.0)/2.0);// from -1 to 1
    float terminatorLight = dot(normalize(position), lightDirection(planet.position));
    terminatorLight = mapClamped(terminatorLight, -0.2, 0.3, 0.0, 1.0);
    terminatorLight = smoothstep(0.0, 1.0, terminatorLight);

    vec3 p = position / planet.radius;

    vec2 planetTextureCoordinates = worldToSpherical(p, earthSpin);
    planetTextureCoordinates.y = planetTextureCoordinates.y/2.0;//+.5;
    vec4 planetColor = texture(samplerTexture, planetTextureCoordinates);

    vec3 finalColor = vec3(0.0);
    if (planet.id == 2) {
        vec2 atmosTextureCoordinates = worldToSpherical(p, earthCloudsSpin);
        vec4 atmosColor = texture(EarthCloudsTexture, atmosTextureCoordinates);
        vec4 nightColor = texture(EarthNightTexture, worldToSpherical(p, earthSpin));
        finalColor = ((planetColor.rgb) + (atmosColor.rgb * .75 * atmosColor.a)) * (terminatorLight * light) + ((1-(terminatorLight * light)) * nightColor.rgb) * planetColor.a;
    } else {
        finalColor = (planetColor.rgb) * terminatorLight * light * planetColor.a;
    }


    return finalColor;
}

vec3 colorOnStar(vec3 position, vec3 normal, float radius, sampler2D samplerTexture) {
    vec3 p = position / radius;

    vec2 planetTextureCoordinates = worldToSpherical(p, earthSpin);
    vec4 planetColor = texture(samplerTexture, planetTextureCoordinates);

    vec3 finalColor = (planetColor.rgb) * planetColor.a;

    return finalColor;
}

float distance(vec3 p, float radius, sampler2D planetTexture) {
    vec2 coordinates = worldToSpherical(normalize(p), earthSpin);
    coordinates.y = coordinates.y/2.0+.5;
    vec4 elevation = texture(planetTexture, coordinates);

    float f = length(p) - radius;

    float elevationScale = radius * 0.000;
    return f - length(elevation.rgb) * elevationScale;
}

vec3 computeNormal(vec3 p, float radius, sampler2D texture) { // based on inigo quilez sdfs
    const float eps = 1.0;
    const vec2 h = vec2(eps, 0.0);
    return normalize(vec3(distance(p+h.xyy, radius, texture) - distance(p-h.xyy, radius, texture), distance(p+h.yxy, radius, texture) - distance(p-h.yxy, radius, texture), distance(p+h.yyx, radius, texture) - distance(p-h.yyx, radius, texture)));
}

void elevatedSphere(vec3 cameraPos, vec3 rayDirection, float radius, out vec3 hitPosition, out vec3 normal, out bool hit, out float totalTravel, PlanetData planet, sampler2D samplerTexture) {
    vec3 travelPos = cameraPos;
    float closestDistance = 100000000.0;

    float elevationPrecision = 0.00001;
    int steps = 0;
    int maxSteps = 400;

    float dist = dot(travelPos, travelPos) + 1.0;// initial distance

    totalTravel = 0.0;

    while (closestDistance > elevationPrecision && steps++ <= maxSteps) {
        closestDistance = distance(travelPos, radius, samplerTexture);

        float cameraDist = dot(cameraPos - travelPos, cameraPos - travelPos);

        elevationPrecision = 0.00001 + clamp(cameraDist / 40.0, 0.0, 0.0075);

        if (closestDistance <= 0.0) {
            break;
        }

        totalTravel += closestDistance;
        travelPos = travelPos + rayDirection * closestDistance;

        // stop rays from escaping and beefing up performance
        if (dot(travelPos, travelPos) > dist * 1.25) {
            hit = false;
            return;
        }
    }

    if (closestDistance <= elevationPrecision + 0.001) {
        // we know we've collided with the sphere!!!!!
        hitPosition = travelPos;

        vec3 p = travelPos / planet.radius;

        normal = normalize(travelPos);
        // we need to overlay the normal texture coordinates on top of the planet texture coordinates
        // but taking into account the tangent/bitangent

        vec3 tangent = normalize(normal * vec3(1.0, 0.0, 1.0));
        tangent.xz = vec2(tangent.z, -tangent.x);

        vec3 bitangent = -cross(normal, tangent);

        vec2 normalTextureCoordinates = worldToSpherical(p, earthSpin);
        normalTextureCoordinates.y = normalTextureCoordinates.y / 2.0 + .5;

        vec3 texSample = texture(samplerTexture, normalTextureCoordinates).rgb * 2.0 - 1.0;
        normal = normalize(tangent * texSample.x + bitangent * texSample.y + normal * texSample.z);
        //        normal = normalize(normal + tangent * texSample.x + bitangent * texSample.y);


        hit = true;
    } else {
        hit = false;
    }
}

void elevatedSphereManualNormal(vec3 cameraPos, vec3 rayDirection, float radius, out vec3 hitPosition, out vec3 normal, out bool hit, out float totalTravel, sampler2D texture, bool isSun) {
    vec3 travelPos = cameraPos;
    float closestDistance = 100000000.0;

    float elevationPrecision = 0.00001;
    int steps = 0;
    int maxSteps = 400;

    float dist = dot(travelPos, travelPos) + 1.0;// initial distance

    totalTravel = 0.0;

    while (closestDistance > elevationPrecision && steps++ <= maxSteps) {
        closestDistance = distance(travelPos, radius, texture);

        float cameraDist = dot(cameraPos - travelPos, cameraPos - travelPos);

        elevationPrecision = 0.00001 + clamp(cameraDist / 40.0, 0.0, 0.0075);

        if (closestDistance <= 0.0) {
            break;
        }

        totalTravel += closestDistance;
        travelPos = travelPos + rayDirection * closestDistance;

        // stop rays from escaping and beefing up performance
        if (dot(travelPos, travelPos) > dist * 1.25) {
            hit = false;
            return;
        }
    }

    if (closestDistance <= elevationPrecision + 0.001) {
        // we know we've collided with the sphere!!!!!
        hitPosition = travelPos;

        normal = computeNormal(travelPos, radius, texture);// previous, manual calculation of normal
        hit = true;
    } else {
        hit = false;
    }
}

// thanks iq
// disk center c, normal n, radius r
float discIntersect(in vec3 RayStart, in vec3 CameraDir, vec3 Center, vec3 Normal) {
    return -dot(Normal, RayStart - Center) / dot(CameraDir, Normal);
}


float distanceToLine(vec3 p, vec3 a, vec3 b) {
    vec3 pa = p - a, ba = b - a;
    float h = clamp(dot(pa, ba) / dot(ba, ba), 0.0, 1.0);
    return length(pa - ba*h);
}

/////////////////////////////////////////////////////////////////////////
/*                        RAYLEIGH ATMOSPHERE                         */
///////////////////////////////////////////////////////////////////////
// rat! -
// this is the atmospheric density at any given
// point. for now we're just calculating one planet,
// but later we'll probably want to feed them in
// through like a buffer or something idk. --cappin
float atmosphericDensityAtPosition(vec3 pos, PlanetData planet, Atmosphere atmosphere) {
    float heightAboveSurface = length(pos) - planet.radius;
    float normalizedHeight = heightAboveSurface / (atmosphere.size);
    if (normalizedHeight > 1.0) return 0.0;
    return exp(-normalizedHeight * atmosphere.falloff) * (1.0 - normalizedHeight) * atmosphere.density;
}

float atmosphericDensityAlongPath(vec3 origin, vec3 end, PlanetData planet, Atmosphere atmosphere) {
    int samplePoints = 10;
    float rayLength = length(origin - end);
    float delta = rayLength / samplePoints;

    float previousDensity = atmosphericDensityAtPosition(origin, planet, atmosphere);
    float totalDensity = 0.0;
    for (int i = 1; i < samplePoints; i++) {
        vec3 samplePos = mix(origin, end, float(i) / float(samplePoints));
        float density = atmosphericDensityAtPosition(samplePos, planet, atmosphere);
        totalDensity += (previousDensity + density) * 0.5 * delta;
        previousDensity = density;
    }

    return totalDensity;
}

float rayleighPhaseFunction(float angle) {
    float angleCos = cos(angle);
    return (3.0 * (1.0 + angleCos*angleCos)) / 16.0 * PI;
}

vec3 scatteringCoefficients(Atmosphere atmosphere) {
    vec3 wavelengths = atmosphere.scatteringWavelengthCoefficients;
    vec3 scatteringCoefficients = vec3(
    pow(400.0 / wavelengths.r, 4.0),
    pow(400.0 / wavelengths.g, 4.0),
    pow(400.0 / wavelengths.b, 4.0));
    scatteringCoefficients *= 1.0;
    return scatteringCoefficients;
}

vec4 scatteredLightAtPosition(vec3 pos, float delta, vec3 rayOrigin, vec3 rayDirection, float densityAlongPath, PlanetData planet, Atmosphere atmosphere) {
    bool hit = false;
    float sunRayOpticalDepth = atmosphericDensityAlongPath(pos, lightDirection(planet.position) * (planet.radius + atmosphere.size) * 2, planet, atmosphere);
    float density = atmosphericDensityAtPosition(pos, planet, atmosphere);
    float totalDensityDiff = density * delta;

    vec3 transmittance = exp(- (sunRayOpticalDepth + densityAlongPath + totalDensityDiff) * scatteringCoefficients(atmosphere));

    vec3 color = density * transmittance * scatteringCoefficients(atmosphere) * rayleighPhaseFunction(acos(dot(rayDirection, lightDirection(planet.position))));
    return vec4(color, totalDensityDiff);
}

vec3 lightAlongPath(vec3 origin, vec3 end, out float densityAlongPath, PlanetData planet, Atmosphere atmosphere) {
    int samplePoints = 16;
    vec3 rayDir = normalize(end-origin);
    float rayLength = length(end-origin);
    float delta = rayLength / float(samplePoints);

    vec3 scatteringCoefficients = scatteringCoefficients(atmosphere);
    vec4 previousLightRes = scatteredLightAtPosition(origin, delta, origin, rayDir, 0.0, planet, atmosphere);
    vec3 previousLight = previousLightRes.rgb;
    float totalDensity = previousLightRes.a;
    vec3 totalLight = vec3(0.0);

    for (int i = 1; i < samplePoints; i++) {
        vec3 samplePos = mix(origin, end, float(i) / float(samplePoints));

        vec4 lightRes = scatteredLightAtPosition(samplePos, delta, origin, rayDir, totalDensity, planet, atmosphere);
        totalDensity += lightRes.a;
        vec3 light = lightRes.rgb;

        totalLight += (light + previousLight) * 0.5 * delta;
        previousLight = light;
    }

    densityAlongPath = totalDensity;
    return totalLight;
}

/////////////////////////////////////////////////////////////////////////
/*                              SUN                                   */
///////////////////////////////////////////////////////////////////////
// https://www.shadertoy.com/view/4tlSzl
vec3 firePalette(float i){
    float T = 1500. + 1400.*i;// Temperature range (in Kelvin).
    vec3 L = vec3(7.4, 5.1, 4.4);// Red, green, blue wavelengths (in hundreds of nanometers).
    L = pow(L, vec3(5.0)) * (exp(1.43876719683e5/(T*L))-1.0);
    return 1.0-exp(-5e8/L);// Exposure level. Set to "50." For "70," change the "5" to a "7," etc.
}
vec3 whiteSunPalette(float i){
    float T = 1500. + 1400.*i;// Temperature range (in Kelvin).
    vec3 L = vec3(5.5, 5.25, 5.0);// Red, green, blue wavelengths (in hundreds of nanometers).
    L = pow(L, vec3(5.0)) * (exp(1.43876719683e5/(T*L))-1.0);
    return 1.0-exp(-5e8/L);// Exposure level. Set to "50." For "70," change the "5" to a "7," etc.
}

vec3 temp(float i) {
        return i * whiteSunPalette(mix(0.4, 1.0, clamp(i, 0.0, 1.0)));
//    return mix(i * firePalette(mix(0.4, 1.0, clamp(i, 0.0, 1.0))), vec3(i * 0.175), (SunFac - 1.0) / 3.5);
}

vec3 doMainStar(in vec2 uv, in vec2 sp) {
    float t = atan(uv.x - sp.x, uv.y - sp.y);
    float n = 2.0 + noise(vec3(10.0 * t, 0.0 /*t*/, 0.0));
    float d = length(uv - sp) * 25.0;
    return ((1.0 + n) / (d * d * d)) * vec3(1.0, 0.95, 0.95);
}

vec3 tanh3(vec3 c) {
    return vec3(tanh(c.x), tanh(c.y), tanh(c.z));
}

vec3 scaleCol(vec3 c, float s, float r) {
    float o = sqrt(s/r);
    float i = s/o;
    return tanh3(c*i)*o;
}
float rnd(vec2 p)
{
    float f = fract(sin(dot(p, vec2(12.1234, 72.8392))*45123.2));
    return f;
}

float rnd(float w)
{
    float f = fract(sin(w)*1000.);
    return f;
}

float regShape(vec2 p, int N)
{
    float f;


    float a=atan(p.x, p.y)+.2;
    float b=6.28319/float(N);
    f=smoothstep(.5, .51, cos(floor(.5+a/b)*b-a)*length(p.xy));


    return f;
}
vec3 circle(vec2 p, float size, float decay, vec3 color, vec3 color2, float dist, vec2 mouse) {


    //l is used for making rings.I get the length and pass it through a sinwave
    //but I also use a pow function. pow function + sin function , from 0 and up, = a pulse, at least
    //if you return the max of that and 0.0.

    float l = length(p + mouse*(dist*4.))+size/2.;

    //l2 is used in the rings as well...somehow...
    float l2 = length(p + mouse*(dist*4.))+size/3.;

    ///these are circles, big, rings, and  tiny respectively
    float c = max(00.01-pow(length(p + mouse*dist), size*1.4), 0.0)*50.;
    float c1 = max(0.001-pow(l-0.3, 1./40.)+sin(l*30.), 0.0)*3.;
    float c2 =  max(0.04/pow(length(p-mouse*dist/2. + 0.09)*1., 1.), 0.0)/20.;
    float s = max(00.01-pow(regShape(p*5. + mouse*dist*5. + 0.9, 6), 1.), 0.0)*5.;

    color = 0.5+0.5*sin(color);
    color = cos(vec3(0.44, .24, .2)*8. + dist*4.)*0.5+.5;
    vec3 f = c*color;
    f += c1*color;

    f += c2*color;
    f +=  s*color;
    return f-0.01;
}

vec3 sunBloom(vec3 cameraPos, vec3 dir) {
    vec3 adjustedPos = cameraPos - sunPosition;
    vec3 col = vec3(0.0);
    bool hitBloom = false;
    vec2 sunBloomRay = raySphere(adjustedPos, dir, sunRadius*10, hitBloom);
    if (hitBloom && (sunBloomRay.y < combinedDepth)) {
        float diff = max((dot(dir, normalize(-adjustedPos))), 0.0);
        float dist = length(cameraPos - sunPosition) / 2000.0;
        col += scaleCol(temp(pow(diff, dist*dist*200.0)), 10.0*(dist), 0.25);
        col += scaleCol(temp(pow(diff, dist*dist*100.0)), 10.0*(dist), 0.25);
/*
        if (SunFac > 1.0) {
            vec2 uv = texCoord;
            //uv=uv*2.-1.0;
            uv.x*=res.x/res.y;

            vec2 mm = vec2(0.5,0.5);//.xy/res.xy - 0.5;
            mm.x *= res.x/res.y;

            //        if(iMouse.z<1.0) {
            //            mm = vec2(0,0)/2.;
            //        }
            vec3 circColor = vec3(0.9, 0.2, 0.1);
            vec3 circColor2 = vec3(0.3, 0.1, 0.9);

            //now to make the sky not black
            vec3 color = vec3(0.0);

            //this calls the function which adds three circle types every time through the loop based on parameters I
            //got by trying things out. rnd i*2000. and rnd i*20 are just to help randomize things more
            for (float i=0.;i<10.;i++){
                color += circle(uv, pow(rnd(i*2000.)*1.8, 2.)+1.41, 0.0, circColor+i, circColor2+i, rnd(i*20.)*3.+0.2-.5, mm);
            }
            //get angle and length of the sun (uv - mouse)
            float a = atan(uv.y-mm.y, uv.x-mm.x);
            float l = max(1.0-length(uv-mm)-0.84, 0.0);

            float bright = 0.1;//+0.1/abs(sin(iTime/3.))/3.;//add brightness based on how the sun moves so that it is brightest
            //when it is lined up with the center

            //add the sun with the frill things
            color += max(0.1/pow(length(uv-mm)*5., 5.), 0.0)*abs(sin(a*5.+cos(a*9.)))/20.;
            color += max(0.1/pow(length(uv-mm)*10., 1./20.), .0)+abs(sin(a*3.+cos(a*9.)))/8.*(abs(sin(a*9.)))/1.;
            //add another sun in the middle (to make it brighter)  with thecolor I want, and bright as the numerator.
            color += (max(bright/pow(length(uv-mm)*4., 1./2.), 0.0)*4.)*vec3(0.25, 0.21, 0.2)*10.;
            // * (0.5+.5*sin(vec3(0.4, 0.2, 0.1) + vec3(a*2., 00., a*3.)+1.3));

            //multiply by the exponetial e^x ? of 1.0-length which kind of masks the brightness more so that
            //there is a sharper roll of of the light decay from the sun.
            color*= exp(1.0-length(uv-mm))/5.;

            return color;
        }
        */
    }
return col;
//    return col * mix(SunFac, 1.0, 0.35);
}

void sun(vec3 cameraPos, vec3 dir) {
    vec3 adjustedPos = cameraPos - sunPosition;

    combinedColor += sunBloom(cameraPos, dir);

    vec3 hitPosition = vec3(0.0);
    vec3 normal = vec3(0.0);
    bool hitSphere = false;
    float travelDistance;

    elevatedSphereManualNormal(adjustedPos, dir, sunRadius, hitPosition, normal, hitSphere, travelDistance, SunTexture, true);

    if (hitSphere && travelDistance < combinedDepth) {
        combinedColor = vec3(1.0);

        combinedDepth = min(travelDistance, combinedDepth);
    }
}

/////////////////////////////////////////////////////////////////////////
/*                              EARTH                                 */
///////////////////////////////////////////////////////////////////////
//void earth(vec3 cameraPos, vec3 dir) {
//    vec3 adjustedPos = cameraPos - earthPosition;
//    vec3 hitPosition = vec3(0.0);
//    vec3 normal = vec3(0.0);
//    bool hit = false;
//    float travelDistance;
//
//    elevatedSphere(adjustedPos, dir, earthRadius, hitPosition, normal, hit, travelDistance);
//
//    if (hit && travelDistance < combinedDepth) {
//        combinedColor = colorOnPlanet(hitPosition, normal);
//        combinedDepth = min(travelDistance, combinedDepth);
//    }
//
//    // atmosphere!
//    bool hitAtmosphere = false;
//    vec2 atmosphereRay = raySphere(adjustedPos, dir, earthRadius + earthAtmosphere.size, hitAtmosphere);
//
//    if (hitAtmosphere && (atmosphereRay.x < combinedDepth)) {
//        const float epsilon = 0.001;
//        float minAtmosphereDistance = atmosphereRay.x;
//        float maxAtmosphereDistance = min(atmosphereRay.y, combinedDepth);
//
//        vec3 atmoRayOrigin = adjustedPos + dir * (minAtmosphereDistance + epsilon);
//        vec3 atmoRayEnd = adjustedPos + dir * (maxAtmosphereDistance - epsilon);
//        float density = 0.0;
//        vec3 light = lightAlongPath(atmoRayOrigin, atmoRayEnd, density, earthAtmosphere);
//
//
//        combinedColor = clamp(combinedColor * exp(-density * scatteringCoefficients(earthAtmosphere) * earthAtmosphere.densityMultiplier), 0.0, 1.0) + light * earthAtmosphere.brightnessMultiplier;
//    }
//}

/////////////////////////////////////////////////////////////////////////
/*                              SPACE                                 */
///////////////////////////////////////////////////////////////////////

void testPlanet(vec3 cameraPos, vec3 dir, PlanetData planet, sampler2D texture) {
    Atmosphere atmosphere = planet.atmosphere;
    vec3 adjustedPos = cameraPos - (planet.position);
    vec3 hitPosition = vec3(0.0);
    vec3 normal = vec3(0.0);
    bool hit = false;
    float travelDistance;

    if (planet.id != UnrenderedPlanet) {
        elevatedSphere(adjustedPos, dir, planet.radius, hitPosition, normal, hit, travelDistance, planet, texture);
    }

    if (hit && travelDistance < combinedDepth) {
        combinedColor = colorOnPlanet(hitPosition, normal, planet, texture);
        combinedDepth = min(travelDistance, combinedDepth);
    }


    // Don't calculate the atmosphere if it doesn't exist
    if (atmosphere.size <= 0.001) {
        return;
    }

    // atmosphere!
    bool hitAtmosphere = false;
    vec2 atmosphereRay = raySphere(adjustedPos, dir, planet.radius + atmosphere.size, hitAtmosphere);

    if (hitAtmosphere && (atmosphereRay.x < combinedDepth)) {
        const float epsilon = 0.001;
        float minAtmosphereDistance = atmosphereRay.x;
        float maxAtmosphereDistance = min(atmosphereRay.y, combinedDepth);

        vec3 atmoRayOrigin = adjustedPos + dir * (minAtmosphereDistance + epsilon);
        vec3 atmoRayEnd = adjustedPos + dir * (maxAtmosphereDistance - epsilon);
        float density = 0.0;
        vec3 light = lightAlongPath(atmoRayOrigin, atmoRayEnd, density, planet, atmosphere);

        combinedColor = clamp(combinedColor * exp(-density * scatteringCoefficients(atmosphere) * atmosphere.densityMultiplier), 0.0, 1.0) + light * atmosphere.brightnessMultiplier;
    }
}

void drawRing(vec3 cameraPos, vec3 pixelDirection, PlanetData planet, sampler2D ringTexture, bool inFrontOfPlanet, vec3 axis) {
    float ringDist = discIntersect(cameraPos, pixelDirection, planet.position, axis);

    float distToPlanet = length(cameraPos - planet.position);
    float atmosphereRadius = (planet.atmosphere.size + planet.radius);

    vec3 frontTestPosition = planet.position + normalize(cameraPos - planet.position) * atmosphereRadius;
    vec3 ringPosition = cameraPos + pixelDirection * ringDist;
    float dt = dot(ringPosition - frontTestPosition, cameraPos - frontTestPosition);

    bool shouldRender = dt > 0.0 == inFrontOfPlanet;
    if (distToPlanet < atmosphereRadius) { shouldRender = !inFrontOfPlanet; }

    vec3 planeNormal = axis;
    if (dot(planeNormal, ringPosition - cameraPos) > 0.0) { planeNormal = -axis; }

    if (shouldRender) {
        if (ringDist > 0 && ringDist < combinedDepth) {
            float distanceFromPlanet = length(ringPosition - planet.position);
            float ringUV = (distanceFromPlanet - planet.radius - 10.0) / 300.0;

            if (ringUV > 0.0 && ringUV < 1.0) {
                float ringShadow = distanceToLine(ringPosition, planet.position + lightDirection(ringPosition) * -1000.0, planet.position);
                float shadowSoftness = (distanceFromPlanet - planet.radius) * 0.1;
                ringShadow = mapClamped(ringShadow, planet.radius - shadowSoftness, planet.radius + shadowSoftness, 0.0, 1.0);
                ringShadow = smoothstep(0.0, 1.0, ringShadow);
                vec4 ringColor = texture(ringTexture, vec2(ringUV, 0.0));


                float ringFade = (ringDist - 4.0) / 8.0;


                ringColor.w *= pow(max(0.0, min(ringFade, 1.0)), 0.5);
                //                ringColor.w *= min((ringDist) / 20.0, 1.0);

                combinedColor = mix(clamp(combinedColor, vec3(0.0), vec3(1.0)) + max(sunBloom(cameraPos, pixelDirection) - vec3(1.0), vec3(0.0)), // clamped it to fix atmospheres but removed the cool sun blooming, so added that back in manually :P
                ringColor.rgb * ringShadow,
                ringColor.a);
            }
        }
    }
}

float getLayeredNoise(vec2 uv) {
    float a = texture(NoiseTexture, uv).r;
    float b = texture(NoiseTexture, uv * 1.5).g;
    float c1 = texture(NoiseTexture, uv * 0.1).b;
    float c2 = texture(NoiseTexture, uv * 0.5 + c1).b;

    // FUCK ME
    c2 = smoothstep(0.0, 1.0, c2);
    c2 = smoothstep(0.0, 1.0, c2);
    c2 = smoothstep(0.0, 1.0, c2);
    c2 = smoothstep(0.0, 1.0, c2);

    return mix(a, b, c2);
}

float triplanarNoise(vec3 p, vec3 n, float sharpness) {
    vec3 blending = abs(n);
    blending = normalize(max(blending, 0.00001));

    float mx = max(max(blending.x, blending.y), blending.z);

    if (mx - blending.x < 0.001) {
        return getLayeredNoise(p.yz);
    }
    if (mx - blending.y < 0.001) {
        return getLayeredNoise(p.xz);
    }

    return getLayeredNoise(p.xy);
}

vec3 skyboxColor(vec3 rayDirection) {
    float starNoise = triplanarNoise(rayDirection * 5.0, rayDirection, 1.0);
    starNoise = mapClamped(starNoise, 0.8, 0.85, 0.0, 1.0);
    float starNoise2 = triplanarNoise(rayDirection * 10.0, rayDirection, 1.0);
    starNoise += mapClamped(starNoise2, 0.8, 0.85, 0.0, 0.5);

    float starNoise3 = triplanarNoise(rayDirection * 2.0, rayDirection, 1.0);
    vec3 starColor = starNoise * mix(vec3(1.0), vec3(0.55, 0.62, 1.0), starNoise3);

    vec2 skyboxTextureCoordinates = worldToSpherical(rayDirection, vec2(0.0, 0.0));
    vec3 galaxyClouds = texture(StarsTexture, skyboxTextureCoordinates).rgb;
    return galaxyClouds + starColor;
}

void ray(vec3 cameraPos, vec3 direction) {

    for (int i = 0; i < min(planetCount, planets.length()); i++) {
        PlanetData planet = planets[i];

        // saturn
        if (planet.id == 5) {
            vec3 saturnAxis = normalize(vec3(0.1, 0.0, 1.01));
            drawRing(cameraPos, direction, planet, SaturnRingTexture, false, saturnAxis);
            testPlanet(cameraPos, direction, planet, PlanetTextures[planet.id]);
            drawRing(cameraPos, direction, planet, SaturnRingTexture, true, saturnAxis);
        } if (planet.id == 6) {
            vec3 uranusAxis = normalize(vec3(0.3, 0.0, 0.0));
            drawRing(cameraPos, direction, planet, UranusRingTexture, false, uranusAxis);
            testPlanet(cameraPos, direction, planet, PlanetTextures[planet.id]);
            drawRing(cameraPos, direction, planet, UranusRingTexture, true, uranusAxis);
        } else {
            testPlanet(cameraPos, direction, planet, PlanetTextures[planet.id]);
        }
    }
    sun(cameraPos, direction);
}

void main() {
    vec3 color = texture(DiffuseSampler0, texCoord).rgb;
    float depth = texture(DiffuseDepthSampler, texCoord).r;
    vec3 positionVS = viewPosFromDepthSample(depth, texCoord);

    float worldDepth = length(positionVS) * scaling;

    vec3 dir = rotateQ(viewDirFromUv(texCoord), ShipRotation);
    vec3 adjustedPos = (rotateQ(VeilCamera.CameraPosition - ShipCenter, ShipRotation) + ShipPosition) * scaling;

    combinedColor = color;
    combinedDepth = worldDepth;

    if (depth >= 1.0) {
        combinedDepth = 32000000.0;

        // skybox
        combinedColor = skyboxColor(dir);
    }

    ray(adjustedPos, dir);

    gl_FragDepth = combinedDepth;
    fragColor = vec4(combinedColor, 1.0);
}