package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(class_1309.class)
public abstract class JetpackAirMovementLivingEntityMixin {
   @ModifyArg(
      method = "applyMovementInput",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V")
   )
   private float enchancement$multiplyMovementSpeed(float value) {
      return this instanceof class_1657 player && ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(player)).isJetpackOn() ? value * 1.5F : value;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
