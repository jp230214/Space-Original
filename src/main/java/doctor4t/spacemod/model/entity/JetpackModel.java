package doctor4t.spacemod.model.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;

@Environment(EnvType.CLIENT)
public class JetpackModel extends class_583<class_1297> {
   public final class_630 jetpack;

   public JetpackModel(class_630 root) {
      this.jetpack = root.method_32086("Jetpackbody");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      class_5610 jetpackBody = modelPartData.method_32117("Jetpackbody", class_5606.method_32108(), class_5603.method_32090(0.0F, 0.0F, 0.0F));
      class_5610 jetpack = jetpackBody.method_32117(
         "Jetpack",
         class_5606.method_32108()
            .method_32101(104, 20)
            .method_32098(-4.0F, -6.0F, -3.0F, 6.0F, 12.0F, 6.0F, new class_5605(0.01F))
            .method_32101(96, 11)
            .method_32098(-6.0F, -8.0F, -1.0F, 2.0F, 12.0F, 2.0F, new class_5605(0.0F))
            .method_32101(72, 14)
            .method_32098(-4.0F, -8.0F, -1.0F, 4.0F, 2.0F, 2.0F, new class_5605(0.0F)),
         class_5603.method_32091(1.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F)
      );
      jetpack.method_32117(
         "Valve_r1",
         class_5606.method_32108().method_32101(118, 0).method_32098(-1.7F, -1.5F, -2.1F, 3.0F, 3.0F, 2.0F, new class_5605(0.0F)),
         class_5603.method_32091(5.4696F, 0.1159F, 0.9553F, 0.8893F, 0.367F, 1.0915F)
      );
      jetpack.method_32117(
         "Thruster_r1",
         class_5606.method_32108().method_32101(84, 0).method_32098(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, new class_5605(0.0F)),
         class_5603.method_32091(-1.0F, -2.5F, 3.0F, 0.6109F, 0.0F, 0.0F)
      );
      jetpack.method_32117(
         "Oxygen_Tank_r2",
         class_5606.method_32108().method_32101(84, 11).method_32098(-1.5F, -3.5F, -1.5F, 3.0F, 7.0F, 3.0F, new class_5605(0.0F)),
         class_5603.method_32091(3.5F, 0.5F, -0.5F, 0.2618F, 0.0F, 0.0F)
      );
      return class_5607.method_32110(modelData, 128, 128);
   }

   public void method_2819(class_1297 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.jetpack.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }

   public void setRotation(float yaw, float pitch) {
      this.jetpack.field_3657 = 0.0F;
      this.jetpack.field_3656 = 0.0F;
      this.jetpack.field_3675 = yaw * (float) (Math.PI / 180.0);
      this.jetpack.field_3654 = pitch * (float) (Math.PI / 180.0);
      this.jetpack.field_3665 = true;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
