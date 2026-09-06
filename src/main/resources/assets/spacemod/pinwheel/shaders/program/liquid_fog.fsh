#include veil:camera
#include veil:deferred_utils
#include veil:common

uniform sampler2D DiffuseSampler0;
uniform sampler2D DiffuseDepthSampler;
uniform sampler2D HandDepthTexture;

uniform vec3 liquidColor;

in vec2 texCoord;

out vec4 fragColor;

float fogEnd = 2.0;

void main() {
    vec3 color = texture(DiffuseSampler0, texCoord).rgb;
    float zdepth = texture(DiffuseDepthSampler, texCoord).r;
    vec3 positionVS = viewPosFromDepthSample(zdepth, texCoord);

    vec3 dir = viewDirFromUv(texCoord);
    float depth = length(positionVS);

    vec3 worldPos = VeilCamera.CameraPosition + dir * min(200.0, depth);
    depth /= fogEnd;
    depth = clamp(depth, 0.0, 1.0);

    color = mix(color, liquidColor, smoothstep(0.0, 1.0, depth));

    fragColor = vec4(color, 1.0);
}