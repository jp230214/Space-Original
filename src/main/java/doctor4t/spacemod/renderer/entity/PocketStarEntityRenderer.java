package doctor4t.spacemod.renderer.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.entity.PocketStarEntity;
import doctor4t.spacemod.model.entity.PocketStarEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1921;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import net.minecraft.class_5617.class_5618;
import org.joml.Vector3d;

@Environment(EnvType.CLIENT)
public class PocketStarEntityRenderer extends class_897<PocketStarEntity> {
   private static final class_2960 TEXTURE = SpaceMod.id("textures/entity/pocket_star.png");
   private final PocketStarEntityModel model;

   public PocketStarEntityRenderer(class_5618 ctx) {
      super(ctx);
      this.model = new PocketStarEntityModel(ctx.method_32167(SpaceModClient.POCKET_STAR));
   }

   public void render(PocketStarEntity pocketStarEntity, float yaw, float tickDelta, class_4587 matrixStack, class_4597 vertexConsumerProvider, int light) {
      Vector3d renderPos = pocketStarEntity.getRenderPosition(tickDelta);
      class_243 curRenderPos = pocketStarEntity.method_30950(tickDelta);
      matrixStack.method_22904(renderPos.x - curRenderPos.field_1352, renderPos.y - curRenderPos.field_1351, renderPos.z - curRenderPos.field_1350);
      matrixStack.method_22903();
      matrixStack.method_22907(pocketStarEntity.getRenderQuaternion(tickDelta));
      matrixStack.method_22907(class_7833.field_40714.rotationDegrees(180.0F));
      matrixStack.method_22904(0.0, 0.125, 0.0);
      matrixStack.method_22904(0.0, -1.5, 0.0);
      this.model
         .method_2828(matrixStack, vertexConsumerProvider.getBuffer(class_1921.method_23578(TEXTURE)), light, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStack.method_22909();
      super.method_3936(pocketStarEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
   }

   public class_2960 getTexture(PocketStarEntity pocketStarEntity) {
      return TEXTURE;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
