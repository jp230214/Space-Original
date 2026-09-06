package doctor4t.spacemod.renderer.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block_entity.SpaceHelmetBlockEntity;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.renderer.block_entity.SpaceHelmetBlockEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer;
import net.minecraft.class_1799;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_811;

@Environment(EnvType.CLIENT)
public class SpaceHelmetDynamicItemRenderer implements DynamicItemRenderer {
   public void render(class_1799 stack, class_811 mode, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
      if (mode != class_811.field_4316) {
         PlayerSpaceComponent.Type type = SpaceHelmetBlockEntity.getSpaceSuitType(stack);
         SpaceHelmetBlockEntityRenderer.render(type, 180.0F, false, matrices, vertexConsumers, light);
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
