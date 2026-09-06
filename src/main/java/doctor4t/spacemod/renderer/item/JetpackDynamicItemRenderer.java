package doctor4t.spacemod.renderer.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block_entity.JetpackBlockEntity;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.renderer.block_entity.JetpackBlockEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer;
import net.minecraft.class_1799;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_811;

@Environment(EnvType.CLIENT)
public class JetpackDynamicItemRenderer implements DynamicItemRenderer {
   public void render(class_1799 stack, class_811 mode, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
      PlayerSpaceComponent.Type type = JetpackBlockEntity.getSpaceSuitType(stack);
      matrices.method_22903();
      matrices.method_22904(0.0, -0.15, 0.0);
      JetpackBlockEntityRenderer.render(type, 180.0F, matrices, vertexConsumers, light);
      matrices.method_22909();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
