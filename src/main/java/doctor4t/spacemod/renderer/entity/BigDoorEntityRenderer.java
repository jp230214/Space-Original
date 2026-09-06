package doctor4t.spacemod.renderer.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.entity.BigDoorEntity;
import doctor4t.spacemod.model.entity.BigDoorEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import net.minecraft.class_5617.class_5618;

@Environment(EnvType.CLIENT)
public class BigDoorEntityRenderer extends class_897<BigDoorEntity> {
   private static final class_2960 TEXTURE = SpaceMod.id("textures/entity/big_glass_door.png");
   private final BigDoorEntityModel model;

   public BigDoorEntityRenderer(class_5618 ctx) {
      super(ctx);
      this.model = new BigDoorEntityModel(ctx.method_32167(SpaceModClient.BIG_DOOR));
   }

   public void render(BigDoorEntity bigDoorEntity, float yaw, float tickDelta, class_4587 matrixStack, class_4597 vertexConsumerProvider, int light) {
      matrixStack.method_22903();
      matrixStack.method_22907(class_7833.field_40714.rotationDegrees(180.0F));
      matrixStack.method_22904(0.0, -1.5, 0.0);
      matrixStack.method_22907(class_7833.field_40716.rotationDegrees(bigDoorEntity.method_36454()));
      this.model.setAngles(bigDoorEntity, 0.0F, 0.0F, bigDoorEntity.field_6012 + tickDelta, 0.0F, 0.0F);
      this.model
         .method_2828(matrixStack, vertexConsumerProvider.getBuffer(class_1921.method_23578(TEXTURE)), light, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStack.method_22909();
      super.method_3936(bigDoorEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
   }

   public class_2960 getTexture(BigDoorEntity BigDoorEntity) {
      return TEXTURE;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
