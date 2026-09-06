package doctor4t.spacemod.model.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.animation.AirlockDoorEntityAnimations;
import doctor4t.spacemod.entity.AirlockEntity;
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
import net.minecraft.class_7184;

@Environment(EnvType.CLIENT)
public class AirlockDoorEntityModel extends class_5597<AirlockEntity> {
   private final class_630 root;
   private final class_630 door;
   private boolean isInterior = false;

   public AirlockDoorEntityModel(class_630 root) {
      this.root = root;
      this.door = root.method_32086("door");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      class_5610 door = modelPartData.method_32117(
         "door",
         class_5606.method_32108()
            .method_32101(0, 0)
            .method_32098(-40.0F, -80.0F, -8.0F, 80.0F, 80.0F, 16.0F, new class_5605(0.0F))
            .method_32101(0, 96)
            .method_32098(-17.0F, -57.0F, -8.0F, 34.0F, 34.0F, 16.0F, new class_5605(0.0F)),
         class_5603.method_32090(0.0F, 24.0F, 0.0F)
      );
      class_5610 cube_r1 = door.method_32117(
         "cube_r1",
         class_5606.method_32108().method_32101(0, 96).method_32098(-17.0F, -17.0F, -8.0F, 34.0F, 34.0F, 16.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, -40.0F, 0.0F, 0.0F, 0.0F, -2.3562F)
      );
      return class_5607.method_32110(modelData, 256, 256);
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.door.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }

   public boolean isInterior() {
      return this.isInterior;
   }

   public void setInterior(boolean interior) {
      this.isInterior = interior;
   }

   public void setAngles(AirlockEntity airlockDoor, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.method_32008().method_32088().forEach(class_630::method_41923);
      class_7184 animation;
      if (airlockDoor.isOpening()) {
         animation = AirlockDoorEntityAnimations.CLOSE;
      } else if (airlockDoor.isOpenToExterior()) {
         animation = this.isInterior ? AirlockDoorEntityAnimations.CLOSE : AirlockDoorEntityAnimations.OPEN;
      } else {
         animation = this.isInterior ? AirlockDoorEntityAnimations.OPEN : AirlockDoorEntityAnimations.CLOSE;
      }

      this.method_43781(this.isInterior ? airlockDoor.interiorDoorOpenAnimationState : airlockDoor.exteriorDoorOpenAnimationState, animation, ageInTicks);
   }

   public class_630 method_32008() {
      return this.root;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
