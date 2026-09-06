package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1959;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1959.class)
public abstract class BiomeMixin {
   @Shadow
   public abstract boolean method_48163();

   @ModifyReturnValue(method = "doesNotSnow", at = @At("RETURN"))
   private boolean spacemod$disableSnowWhenNoPrecipitation(boolean original) {
      return !this.method_48163() ? true : original;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
