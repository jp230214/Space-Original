package doctor4t.spacemod.model.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.animation.BigDoorEntityAnimations;
import doctor4t.spacemod.entity.BigDoorEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(EnvType.CLIENT)
public class BigDoorEntityModel extends class_5597<BigDoorEntity> {
   private final class_630 root;
   private final class_630 LeftDoor;
   private final class_630 RightDoor;

   public BigDoorEntityModel(class_630 root) {
      this.root = root;
      this.LeftDoor = root.method_32086("LeftDoor");
      this.RightDoor = root.method_32086("RightDoor");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      modelPartData.method_32117(
         "LeftDoor",
         class_5606.method_32108()
            .method_32101(0, 18)
            .method_32098(-32.0F, -59.0F, 6.0F, 3.0F, 54.0F, 4.0F, new class_5605(0.0F))
            .method_32101(14, 18)
            .method_32098(-10.0F, -59.0F, 6.0F, 2.0F, 54.0F, 4.0F, new class_5605(0.0F))
            .method_32101(0, 0)
            .method_32098(-32.0F, -64.0F, 6.0F, 24.0F, 5.0F, 4.0F, new class_5605(0.0F))
            .method_32101(0, 9)
            .method_32098(-32.0F, -5.0F, 6.0F, 24.0F, 5.0F, 4.0F, new class_5605(0.0F))
            .method_32101(26, 18)
            .method_32098(-29.0F, -59.0F, 8.0F, 19.0F, 54.0F, 0.0F, new class_5605(0.01F)),
         class_5603.method_32090(8.0F, 24.0F, -8.0F)
      );
      modelPartData.method_32117(
         "RightDoor",
         class_5606.method_32108()
            .method_32101(0, 18)
            .method_32096()
            .method_32098(29.0F, -59.0F, 6.0F, 3.0F, 54.0F, 4.0F, new class_5605(0.0F))
            .method_32106(false)
            .method_32101(14, 18)
            .method_32096()
            .method_32098(8.0F, -59.0F, 6.0F, 2.0F, 54.0F, 4.0F, new class_5605(0.0F))
            .method_32106(false)
            .method_32101(0, 0)
            .method_32096()
            .method_32098(8.0F, -64.0F, 6.0F, 24.0F, 5.0F, 4.0F, new class_5605(0.0F))
            .method_32106(false)
            .method_32101(0, 9)
            .method_32096()
            .method_32098(8.0F, -5.0F, 6.0F, 24.0F, 5.0F, 4.0F, new class_5605(0.0F))
            .method_32106(false)
            .method_32101(26, 18)
            .method_32096()
            .method_32098(10.0F, -59.0F, 8.0F, 19.0F, 54.0F, 0.0F, new class_5605(0.01F))
            .method_32106(false),
         class_5603.method_32090(-8.0F, 24.0F, -8.0F)
      );
      return class_5607.method_32110(modelData, 128, 128);
   }

   public void setAngles(BigDoorEntity bigDoorEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.method_32008().method_32088().forEach(class_630::method_41923);
      this.method_43781(bigDoorEntity.openAnimationState, bigDoorEntity.isOpen() ? BigDoorEntityAnimations.OPEN : BigDoorEntityAnimations.CLOSE, ageInTicks);
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.LeftDoor.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
      this.RightDoor.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }

   public class_630 method_32008() {
      return this.root;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
