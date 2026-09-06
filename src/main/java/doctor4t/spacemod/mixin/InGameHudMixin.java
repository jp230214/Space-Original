package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1297;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_329.class)
public abstract class InGameHudMixin {
   @Unique
   private static final class_2960 TELESCOPE_TEXTURE = SpaceMod.id("textures/misc/telescope_scope.png");

   @WrapOperation(
      method = "renderVignetteOverlay",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIFFIIII)V")
   )
   private void spacemod$renderSuffocationVignette(
      class_332 instance,
      class_2960 texture,
      int x,
      int y,
      int z,
      float u,
      float v,
      int width,
      int height,
      int textureWidth,
      int textureHeight,
      Operation<Void> original,
      class_332 context,
      class_1297 entity
   ) {
      class_746 player = class_310.method_1551().field_1724;
      if (player != null) {
         PlayerSpaceComponent component = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
         int suffocation = component.getSuffocation();
         if (suffocation > 0) {
            float f = suffocation / 400.0F;
            context.method_51422(f * 6.0F, f * 6.0F, f * 5.0F, 1.0F);
         }
      }

      original.call(new Object[]{instance, texture, x, y, z, u, v, width, height, textureWidth, textureHeight});
   }

   @Inject(method = "renderStatusBars", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableStatusBars(class_332 context, CallbackInfo ci) {
      ci.cancel();
   }

   @Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableExperienceBar(class_332 context, int x, CallbackInfo ci) {
      ci.cancel();
   }

   @WrapOperation(
      method = "renderSpyglassOverlay",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIFFIIII)V")
   )
   public void spacemod$telescopeOverlay(
      class_332 instance,
      class_2960 texture,
      int x,
      int y,
      int z,
      float u,
      float v,
      int width,
      int height,
      int textureWidth,
      int textureHeight,
      Operation<Void> original
   ) {
      if (class_310.method_1551().field_1724 != null && class_310.method_1551().field_1724.method_6030().method_31574(SpaceModItems.TELESCOPE)) {
         original.call(new Object[]{instance, TELESCOPE_TEXTURE, x, y, z, u, v, width, height, textureWidth, textureHeight});
      } else {
         original.call(new Object[]{instance, texture, x, y, z, u, v, width, height, textureWidth, textureHeight});
      }
   }


}
