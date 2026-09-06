#include veil:camera

layout (location = 0) in vec3 Position;
layout (location = 1) in vec2 UV0;
layout (location = 2) in vec3 Normal;

uniform sampler2D SaturnRingTexture;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

uniform float PlanetRadius;
uniform float Time;
uniform mat4 ShipPose;
uniform vec3 Offset;

out float dist;
out vec2 texCoord;
out vec4 vertexColor;


uint triple32(uint x)
{
    x ^= x >> 17;
    x *= 0xed5ad4bbU;
    x ^= x >> 11;
    x *= 0xac4c1b51U;
    x ^= x >> 15;
    x *= 0x31848babU;
    x ^= x >> 14;
    return x;
}

float hash(int x) {
    return float(triple32(x)) / float(0xffffffffU);
}

vec2 rotate(vec2 v, float a) {
    float s = sin(a);
    float c = cos(a);
    mat2 m = mat2(c, s, -s, c);
    return m * v;
}

vec4 ringColor(float distFromPlanet) {
    float ringUV = (distFromPlanet - PlanetRadius - 10.0) / 300.0;
        //return vec4(vec3(ringUV, 0.0, 0.0), 1.0);

        if (ringUV < 0.0 || ringUV > 1.0) {
            return vec4(0.0, 0.0, 0.0, 0.0);
        }
return texture(SaturnRingTexture, vec2(ringUV, 0.0));
}

void main() {

    float scale = 1500.0;
    vec3 offset = vec3(hash(gl_InstanceID), (pow((hash(gl_InstanceID * 2 + 100000) - 0.5) * 2.0, 2.0) / 2.0 + 0.5), hash(gl_InstanceID * 3 + 100000));
    float bmod = hash(gl_InstanceID * 4);

    offset *= vec3(scale, scale, scale);
    offset -= scale / 2.0;
    offset *= vec3(1.0, 200.0 / 1500.0, 1.0);

    vec3 rotPos = Position;
    rotPos.xz = rotate(rotPos.xz + 0.5, bmod * 20.0 + Time * bmod / 20.0) - 0.5;

    offset.x += Time / 20.0;
    offset.y -= scale / 2.0;

    float close = 0.0;


offset -= Offset * 50.0;
//        vec4 ringCol = vec4(length(offset.xz) / 300.0, 0.0, 0.0, 1.0);
        //vec4 ringCol = vec4(1.0, 0.0, 0.0, 1.0);
    offset.xz = (fract(offset.xz / scale)) * scale - vec2(scale / 2.0);
vec4 ringCol = ringColor(length(Offset.xz + offset.xz / 50.0));




    vec3 n = (ShipPose * vec4((offset), 1.0)).xyz;
    //n -= VeilCamera.CameraPosition;

    if (dot(n, n) < 70.0 * 70.0) {
        n = normalize(n) * 70.0;
    }

    n += (ShipPose * vec4(rotPos, 1.0)).rgb;
    vec3 WorldPosition = n;


    texCoord = UV0;

    gl_Position = VeilCamera.ProjMat * (VeilCamera.ViewMat * vec4(WorldPosition, 1.0));


    // Determine if the entry is a tall hatch based on the presence of the 16th bit
    //gl_Position = VeilCamera.ViewMat * VeilCamera.ProjMat *  vec4(Position, 1.0);
    //gl_Position = vec4(vec3(Position.xz, 0.5), 1.0);
    //vertexColor = vec4(float(x), float(y), float(z), 1.0);
    vec3 brightness = vec3(1.0);

    if (Normal.x > 0.0) {
        brightness = vec3(0.8);
    }
    else if (Normal.y < 0.0) {
        brightness = vec3(0.7);
    }
    else if (Normal.z < 0.0) {
        brightness = vec3(0.75);
    }

    dist = length(WorldPosition);


        vertexColor = vec4(ringCol.rgb * brightness, ringCol.a);
}
