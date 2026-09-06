package doctor4t.spacemod.mixin.hungerdisable;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.minecraft.class_1657;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1657.class)
public class DisableFoodWithSpaceHelmetOrWhenHealingPlayerEntityMixin {
   @ModifyReturnValue(method = "canConsume", at = @At("RETURN"))
   public boolean spacemod$disableEatingWithAHelmetOrWhileHealing(boolean original) {
      return !((PlayerSpaceComponent)SpaceModComponents.SPACE.get(this)).isWearingSpaceHelmet()
         && ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(this)).getHealingTicks() <= 0;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
