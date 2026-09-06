package doctor4t.spacemod.renderer.block_entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.block.JetpackBlock;
import doctor4t.spacemod.block_entity.JetpackBlockEntity;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.model.entity.JetpackModel;
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
import net.minecraft.class_7833;
import net.minecraft.class_827;
import net.minecraft.class_5614.class_5615;

@Environment(EnvType.CLIENT)
public class JetpackBlockEntityRenderer implements class_827<JetpackBlockEntity> {
   public static final EnumMap<PlayerSpaceComponent.Type, JetpackModel> MODELS = new EnumMap<>(PlayerSpaceComponent.Type.class);

   public JetpackBlockEntityRenderer(class_5615 ctx) {
      for (PlayerSpaceComponent.Type type : PlayerSpaceComponent.Type.values()) {
         MODELS.put(type, new JetpackModel(ctx.method_32140((class_5601)SpaceModClient.JETPACK_LAYERS.get(type))));
      }
   }

   public static void render(PlayerSpaceComponent.Type type, float yaw, class_4587 matrices, class_4597 vertexConsumers, int light) {
      JetpackModel model = MODELS.get(type);
      matrices.method_22903();
      matrices.method_46416(0.5F, 0.75F, 0.5F);
      matrices.method_22907(class_7833.field_40716.rotationDegrees(180.0F - yaw));
      matrices.method_46416(0.0F, 0.0F, -0.4F);
      matrices.method_22905(-1.0F, -1.0F, 1.0F);
      class_4588 vertexConsumer = vertexConsumers.getBuffer(class_1921.method_23580(type.texture));
      model.setRotation(0.0F, 0.0F);
      model.method_2828(matrices, vertexConsumer, light, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
      matrices.method_22909();
   }

   public void render(JetpackBlockEntity entity, float f, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
      class_2680 state = entity.method_11010();
      PlayerSpaceComponent.Type type = entity.getSpaceSuitType();
      float yaw = class_7718.method_45482((Integer)state.method_11654(JetpackBlock.ROTATION));
      render(type, yaw, matrices, vertexConsumers, light);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
