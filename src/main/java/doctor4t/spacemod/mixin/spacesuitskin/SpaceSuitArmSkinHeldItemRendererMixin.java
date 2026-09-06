package doctor4t.spacemod.mixin.spacesuitskin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_759;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(class_759.class)
public class SpaceSuitArmSkinHeldItemRendererMixin {
   @Redirect(
      method = "renderArm",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getSkinTexture()Lnet/minecraft/util/Identifier;")
   )
   private class_2960 spacemod$armSkin(class_746 instance) {
      return ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(instance)).getSpaceSuitType().skinTexture;
   }

   @Redirect(
      method = "renderArmHoldingItem",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;getSkinTexture()Lnet/minecraft/util/Identifier;")
   )
   private class_2960 spacemod$armSkin(class_742 instance) {
      return ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(instance)).getSpaceSuitType().skinTexture;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
