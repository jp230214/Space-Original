package doctor4t.spacemod.renderer.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_1799;
import net.minecraft.class_308;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_811;

@Environment(EnvType.CLIENT)
public class PocketStarDynamicItemRenderer implements DynamicItemRenderer {
   public static final class_1091 POCKET_STAR = new class_1091(SpaceMod.id("pocket_star_inventory"), "inventory");
   public static final class_1091 POCKET_STAR_IN_HAND = new class_1091(SpaceMod.id("pocket_star_in_hand"), "inventory");

   public void render(class_1799 stack, class_811 mode, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
      boolean inHand = mode.method_29998() || mode == class_811.field_4323 || mode == class_811.field_4320 || mode == class_811.field_4316;
      matrices.method_22903();
      matrices.method_22904(0.5, 0.5, 0.5);
      class_1087 model = class_310.method_1551().method_1554().method_4742(inHand ? POCKET_STAR_IN_HAND : POCKET_STAR);
      if (!inHand) {
         class_308.method_24211();
      }

      class_310.method_1551().method_1480().method_23179(stack, mode, false, matrices, vertexConsumers, light, overlay, model);
      if (!inHand) {
         class_308.method_24210();
      }

      matrices.method_22909();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
