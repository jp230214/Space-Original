package doctor4t.spacemod.renderer.block_entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.block.SpaceHelmetBlock;
import doctor4t.spacemod.block_entity.SpaceHelmetBlockEntity;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.model.entity.SpaceHelmetModel;
import java.util.EnumMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1921;
import net.minecraft.class_2680;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5601;
import net.minecraft.class_7718;
import net.minecraft.class_827;
import net.minecraft.class_5614.class_5615;

@Environment(EnvType.CLIENT)
public class SpaceHelmetBlockEntityRenderer implements class_827<SpaceHelmetBlockEntity> {
   public static final EnumMap<PlayerSpaceComponent.Type, SpaceHelmetModel> MODELS = new EnumMap<>(PlayerSpaceComponent.Type.class);

   public SpaceHelmetBlockEntityRenderer(class_5615 ctx) {
      for (PlayerSpaceComponent.Type type : PlayerSpaceComponent.Type.values()) {
         MODELS.put(type, new SpaceHelmetModel(ctx.method_32140((class_5601)SpaceModClient.SPACE_SUIT_HELMET_LAYERS.get(type))));
      }
   }

   public static void render(PlayerSpaceComponent.Type type, float yaw, boolean showBody, class_4587 matrices, class_4597 vertexConsumers, int light) {
      SpaceHelmetModel model = MODELS.get(type);
      matrices.method_22903();
      matrices.method_46416(0.5F, 0.0F, 0.5F);
      matrices.method_22905(-1.0F, -1.0F, 1.0F);
      class_4588 vertexConsumer = vertexConsumers.getBuffer(class_1921.method_23580(type.texture));
      model.setRotation(yaw, 0.0F, showBody, false);
      model.method_2828(matrices, vertexConsumer, light, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
      matrices.method_22909();
   }

   public void render(SpaceHelmetBlockEntity entity, float f, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
      class_2680 state = entity.method_11010();
      PlayerSpaceComponent.Type type = entity.getSpaceSuitType();
      float yaw = class_7718.method_45482((Integer)state.method_11654(SpaceHelmetBlock.ROTATION));
      render(type, yaw, false, matrices, vertexConsumers, light);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
