out vec4 fragColor;

uniform sampler2D Sampler0;

in float dist;
in vec2 texCoord;
in vec4 vertexColor;

void main() {
    vec4 color = texture(Sampler0, texCoord);
    if (color.a == 0.0) {
        discard;
    }

    float opacity = min(1.0, max(0.2, 1.0 - (dist - 50.0) / 150.0));

    opacity *= 1.0 - min(1.0, (dist - 650.0) / 100.0);

        fragColor = vec4(vertexColor.rgb * color.rgb, opacity * vertexColor.a);
//        fragColor = vec4(vertexColor.rgb, 1.0);
}