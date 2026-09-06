#include veil:camera
#include veil:deferred_utils
#include veil:common

uniform sampler2D DiffuseSampler0;
uniform sampler2D DiffuseDepthSampler;
uniform sampler2D HandDepthTexture;

uniform vec2 InSize;
uniform float Fade;
uniform vec3 FadeColor;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec3 color = texture(DiffuseSampler0, texCoord).rgb;
    float depth = texture(DiffuseDepthSampler, texCoord).r;
    vec3 positionVS = viewPosFromDepthSample(depth, texCoord);

    float worldDepth = length(positionVS);

    vec3 combinedColor = color;
    float combinedDepth = worldDepth;

    // Don't try to overwrite the hand
        if (depth >= 1.0) {
            combinedDepth = 32000000.0;
            combinedColor = mix(combinedColor, FadeColor, Fade);
        }

        float threshold =  100.0 - Fade * 104.0;
        if (worldDepth > threshold) {
            float roundedFac = min((worldDepth - threshold) / 4.0, 1.0);

            combinedColor = mix(combinedColor, FadeColor, roundedFac * Fade);
        }
//combinedColor = vec3(combinedDepth / 10.0);

//fragColor = vec4(vec3(0.0, 0.0, 1.0), 1.0);
    fragColor = vec4(combinedColor, 1.0);
}