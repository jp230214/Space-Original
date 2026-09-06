package doctor4t.spacemod.renderer.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.entity.SmallDoorEntity;
import doctor4t.spacemod.model.entity.SmallDoorEntityModel;
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
public class SmallDoorEntityRenderer extends class_897<SmallDoorEntity> {
   private final SmallDoorEntityModel model;
   private final class_2960 texture;

   public SmallDoorEntityRenderer(class_5618 ctx, class_2960 texture) {
      super(ctx);
      this.model = new SmallDoorEntityModel(ctx.method_32167(SpaceModClient.SMALL_DOOR));
      this.texture = texture;
   }

   public void render(SmallDoorEntity smallDoorEntity, float yaw, float tickDelta, class_4587 matrixStack, class_4597 vertexConsumerProvider, int light) {
      matrixStack.method_22903();
      matrixStack.method_22907(class_7833.field_40714.rotationDegrees(180.0F));
      matrixStack.method_22904(0.0, -1.5, 0.0);
      matrixStack.method_22907(class_7833.field_40716.rotationDegrees(smallDoorEntity.method_36454()));
      this.model.setAngles(smallDoorEntity, 0.0F, 0.0F, smallDoorEntity.field_6012 + tickDelta, 0.0F, 0.0F);
      this.model
         .method_2828(
            matrixStack,
            vertexConsumerProvider.getBuffer(class_1921.method_23578(this.getTexture(smallDoorEntity))),
            light,
            class_4608.field_21444,
            1.0F,
            1.0F,
            1.0F,
            1.0F
         );
      matrixStack.method_22909();
      super.method_3936(smallDoorEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
   }

   public class_2960 getTexture(SmallDoorEntity smallDoorEntity) {
      return this.texture;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
