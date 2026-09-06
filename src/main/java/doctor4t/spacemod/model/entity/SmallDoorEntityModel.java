package doctor4t.spacemod.model.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.animation.SmallDoorEntityAnimations;
import doctor4t.spacemod.entity.SmallDoorEntity;
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
public class SmallDoorEntityModel extends class_5597<SmallDoorEntity> {
   private final class_630 root;
   private final class_630 Door;

   public SmallDoorEntityModel(class_630 root) {
      this.root = root;
      this.Door = root.method_32086("Door");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      modelPartData.method_32117(
         "Door",
         class_5606.method_32108()
            .method_32101(28, 56)
            .method_32098(-8.0F, -2.0F, -1.0F, 16.0F, 2.0F, 2.0F, new class_5605(0.0F))
            .method_32101(28, 60)
            .method_32098(-8.0F, -32.0F, -1.0F, 16.0F, 2.0F, 2.0F, new class_5605(0.0F))
            .method_32101(0, 0)
            .method_32098(-6.0F, -30.0F, 0.0F, 12.0F, 28.0F, 0.0F, new class_5605(0.01F))
            .method_32101(0, 34)
            .method_32098(-8.0F, -30.0F, -1.0F, 2.0F, 28.0F, 2.0F, new class_5605(0.0F))
            .method_32101(8, 34)
            .method_32098(6.0F, -30.0F, -1.0F, 2.0F, 28.0F, 2.0F, new class_5605(0.0F))
            .method_32101(28, 0)
            .method_32098(-8.0F, -32.0F, -1.0F, 16.0F, 32.0F, 2.0F, new class_5605(0.0F)),
         class_5603.method_32090(0.0F, 24.0F, 0.0F)
      );
      return class_5607.method_32110(modelData, 64, 64);
   }

   public void setAngles(SmallDoorEntity smallDoorEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.method_32008().method_32088().forEach(class_630::method_41923);
      this.method_43781(
         smallDoorEntity.openAnimationState, smallDoorEntity.isOpen() ? SmallDoorEntityAnimations.OPEN : SmallDoorEntityAnimations.CLOSE, ageInTicks
      );
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.Door.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }

   public class_630 method_32008() {
      return this.root;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
