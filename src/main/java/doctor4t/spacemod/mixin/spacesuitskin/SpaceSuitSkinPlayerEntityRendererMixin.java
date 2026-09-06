package doctor4t.spacemod.mixin.spacesuitskin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.mixin.BipedEntityModelAccessor;
import doctor4t.spacemod.mixin.LivingEntityRendererMixin;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1007;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_742;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(class_1007.class)
public abstract class SpaceSuitSkinPlayerEntityRendererMixin extends LivingEntityRendererMixin<class_742, class_591<class_742>> {
   @Redirect(
      method = "renderArm",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;getSkinTexture()Lnet/minecraft/util/Identifier;")
   )
   private class_2960 spacemod$armSkin(class_742 instance) {
      return ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(instance)).getSpaceSuitType().skinTexture;
   }

   @Override
   protected boolean spacemod$overrideModelRender(
      @Nullable class_742 player,
      class_4587 matrices,
      int light,
      int overlay,
      float red,
      float green,
      float blue,
      float alpha,
      float yaw,
      float tickDelta,
      class_4587 matrixStack,
      class_4597 vertexConsumerProvider
   ) {
      if (player == null) {
         return true;
      } else {
         boolean showBody = this.method_4056(player);
         boolean translucent = !showBody && !player.method_5756(class_310.method_1551().field_1724);
         boolean showOutline = class_310.method_1551().method_27022(player);
         class_1921 renderLayer = this.method_24302(player, showBody, translucent, showOutline);
         class_1921 spaceSuitRenderLayer = this.spacemod$getSpaceSuitRenderLayer(player, showBody, translucent, showOutline);
         if (renderLayer != null && spaceSuitRenderLayer != null) {
            class_4588 vertices = vertexConsumerProvider.getBuffer(renderLayer);
            this.method_4038().field_3398.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
            this.method_4038().field_3394.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
            class_4588 spaceSuitVertices = vertexConsumerProvider.getBuffer(spaceSuitRenderLayer);
            ((BipedEntityModelAccessor)this.method_4038())
               .spacemod$getBodyParts()
               .forEach(modelPart -> this.spacemod$renderBodyPart(modelPart, matrices, spaceSuitVertices, light, overlay, red, green, blue, alpha));
            return false;
         } else {
            return true;
         }
      }
   }

   @Unique
   protected void spacemod$renderBodyPart(
      class_630 modelPart, class_4587 matrices, class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha
   ) {
      if (!modelPart.equals(this.method_4038().field_3394)) {
         modelPart.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
      }
   }

   @Unique
   @Nullable
   protected class_1921 spacemod$getSpaceSuitRenderLayer(class_742 player, boolean showBody, boolean translucent, boolean showOutline) {
      class_2960 texture = ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(player)).getSpaceSuitType().skinTexture;
      if (translucent) {
         return class_1921.method_29379(texture);
      } else if (showBody) {
         return this.method_4038().method_23500(texture);
      } else {
         return showOutline ? class_1921.method_23287(texture) : null;
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
