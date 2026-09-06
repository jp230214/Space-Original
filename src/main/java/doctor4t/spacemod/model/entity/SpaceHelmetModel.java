package doctor4t.spacemod.model.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1921;
import net.minecraft.class_3879;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(EnvType.CLIENT)
public class SpaceHelmetModel extends class_3879 {
   public final class_630 helmet;
   public final class_630 body;
   public final class_630 flashlightoff;
   public final class_630 flashlighton;

   public SpaceHelmetModel(class_630 root) {
      super(class_1921::method_23580);
      this.helmet = root.method_32086("helmet");
      this.body = root.method_32086("body");
      this.flashlighton = this.helmet.method_32086("head").method_32086("flashlighton");
      this.flashlightoff = this.helmet.method_32086("head").method_32086("flashlightoff");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      class_5610 helmet = modelPartData.method_32117("helmet", class_5606.method_32108(), class_5603.method_32090(0.0F, 24.0F, 0.0F));
      class_5610 head = helmet.method_32117(
         "head",
         class_5606.method_32108()
            .method_32101(0, 0)
            .method_32098(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new class_5605(0.05F))
            .method_32101(24, 0)
            .method_32098(4.0F, -6.0F, -2.0F, 1.0F, 4.0F, 4.0F, new class_5605(0.0F))
            .method_32101(94, 30)
            .method_32098(-5.0F, -6.0F, -2.0F, 1.0F, 4.0F, 4.0F, new class_5605(0.0F))
            .method_32101(0, -3)
            .method_32098(4.5F, -9.0F, -1.5F, 0.0F, 3.0F, 3.0F, new class_5605(0.0F))
            .method_32101(32, 0)
            .method_32098(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new class_5605(0.5F))
            .method_32101(96, 0)
            .method_32098(-1.0F, -5.0F, 4.0F, 2.0F, 7.0F, 2.0F, new class_5605(0.1F))
            .method_32101(104, 0)
            .method_32098(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F, new class_5605(0.0F)),
         class_5603.method_32090(0.0F, 0.0F, 0.0F)
      );
      class_5610 oxygen_tube_r1 = head.method_32117(
         "oxygen_tube_r1",
         class_5606.method_32108().method_32101(88, 1).method_32098(0.0F, -2.0F, -3.95F, 0.0F, 2.0F, 8.0F, new class_5605(0.0F)),
         class_5603.method_32091(4.4F, -0.1F, -1.1F, 0.0F, 0.0F, -0.3054F)
      );
      class_5610 oxygen_tank_r1 = head.method_32117(
         "oxygen_tank_r1",
         class_5606.method_32108().method_32101(57, 0).method_32098(-5.0F, -1.5F, -1.5F, 10.0F, 3.0F, 3.0F, new class_5605(0.1F)),
         class_5603.method_32091(0.0F, -0.5F, 3.5F, -0.7854F, 0.0F, 0.0F)
      );
      class_5610 flashlightoff = head.method_32117(
         "flashlightoff",
         class_5606.method_32108()
            .method_32101(116, 13)
            .method_32098(-2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 4.0F, new class_5605(0.15F))
            .method_32101(116, 6)
            .method_32098(-2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 4.0F, new class_5605(0.0F)),
         class_5603.method_32090(-4.0F, -5.0F, 0.0F)
      );
      class_5610 flashlighton = head.method_32117(
         "flashlighton",
         class_5606.method_32108()
            .method_32101(104, 13)
            .method_32098(-2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 4.0F, new class_5605(0.15F))
            .method_32101(104, 6)
            .method_32098(-2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 4.0F, new class_5605(0.0F))
            .method_32101(96, 26)
            .method_32098(2.0F, -2.0F, -4.52F, 4.0F, 4.0F, 0.0F, new class_5605(0.0F)),
         class_5603.method_32090(-4.0F, -5.0F, 0.0F)
      );
      class_5610 body = modelPartData.method_32117(
         "body",
         class_5606.method_32108().method_32101(64, 6).method_32098(-3.0F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F, new class_5605(0.26F)),
         class_5603.method_32090(0.0F, 0.0F, 0.0F)
      );
      return class_5607.method_32110(modelData, 128, 128);
   }

   public void method_2828(class_4587 matrices, class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
      this.helmet.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
      this.body.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
   }

   public void setRotation(float yaw, float pitch, boolean showBody, boolean isFlashlightOn) {
      this.helmet.field_3657 = 0.0F;
      this.helmet.field_3656 = 0.0F;
      this.body.field_3657 = 0.0F;
      this.body.field_3656 = 0.0F;
      this.helmet.field_3675 = yaw * (float) (Math.PI / 180.0);
      this.helmet.field_3654 = pitch * (float) (Math.PI / 180.0);
      this.body.field_3665 = showBody;
      this.flashlighton.field_3665 = isFlashlightOn;
      this.flashlightoff.field_3665 = !isFlashlightOn;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
