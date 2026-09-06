package doctor4t.spacemod.model.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.PocketStarEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
public class PocketStarEntityModel extends class_583<PocketStarEntity> {
   private final class_630 bone;

   public PocketStarEntityModel(class_630 root) {
      this.bone = root.method_32086("bone");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      class_5610 bone = modelPartData.method_32117(
         "bone",
         class_5606.method_32108().method_32101(0, 0).method_32098(-10.0F, -4.0F, 6.0F, 4.0F, 4.0F, 4.0F, new class_5605(0.0F)),
         class_5603.method_32090(8.0F, 24.0F, -8.0F)
      );
      return class_5607.method_32110(modelData, 16, 16);
   }

   public void setAngles(PocketStarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.bone.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
