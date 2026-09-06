package doctor4t.spacemod.renderer.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.entity.AirlockEntity;
import doctor4t.spacemod.model.entity.AirlockDoorEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1921;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_765;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import net.minecraft.class_5617.class_5618;

@Environment(EnvType.CLIENT)
public class AirlockEntityRenderer extends class_897<AirlockEntity> {
   private static final class_2960 TEXTURE = SpaceMod.id("textures/entity/airlock_door.png");
   private final AirlockDoorEntityModel model;

   public AirlockEntityRenderer(class_5618 ctx) {
      super(ctx);
      this.model = new AirlockDoorEntityModel(ctx.method_32167(SpaceModClient.AIRLOCK_DOOR));
   }

   public void render(AirlockEntity airlockEntity, float yaw, float tickDelta, class_4587 matrixStack, class_4597 vertexConsumerProvider, int light) {
      matrixStack.method_22903();
      class_2350 direction = class_2350.method_10150(airlockEntity.method_36454());
      class_2382 rotVec = direction.method_10163();
      class_2338 exteriorDoorPos = airlockEntity.method_24515().method_10081(rotVec.method_35862(4)).method_10069(0, 2, 0);
      class_2338 interiorDoorPos = airlockEntity.method_24515().method_10081(rotVec.method_35862(-4)).method_10069(0, 2, 0);
      int extLight = class_765.method_23687(this.method_24087(airlockEntity, exteriorDoorPos), this.method_27950(airlockEntity, exteriorDoorPos));
      int intLight = class_765.method_23687(this.method_24087(airlockEntity, interiorDoorPos), this.method_27950(airlockEntity, interiorDoorPos));
      matrixStack.method_22907(class_7833.field_40714.rotationDegrees(180.0F));
      matrixStack.method_22904(0.0, -1.5, 0.0);
      matrixStack.method_22907(class_7833.field_40715.rotationDegrees(airlockEntity.method_36454()));
      if (direction == class_2350.field_11043 || direction == class_2350.field_11035) {
         matrixStack.method_22907(class_7833.field_40715.rotationDegrees(180.0F));
      }

      matrixStack.method_46416(0.0F, 0.0F, -4.0F);
      this.model.setInterior(false);
      this.model.setAngles(airlockEntity, 0.0F, 0.0F, airlockEntity.field_6012 + tickDelta, 0.0F, 0.0F);
      this.model
         .method_2828(matrixStack, vertexConsumerProvider.getBuffer(class_1921.method_23578(TEXTURE)), extLight, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStack.method_46416(0.0F, 0.0F, 8.0F);
      this.model.setInterior(true);
      this.model.setAngles(airlockEntity, 0.0F, 0.0F, airlockEntity.field_6012 + tickDelta, 0.0F, 0.0F);
      this.model
         .method_2828(matrixStack, vertexConsumerProvider.getBuffer(class_1921.method_23578(TEXTURE)), intLight, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStack.method_22909();
      super.method_3936(airlockEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
   }

   public class_2960 getTexture(AirlockEntity BigDoorEntity) {
      return TEXTURE;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
