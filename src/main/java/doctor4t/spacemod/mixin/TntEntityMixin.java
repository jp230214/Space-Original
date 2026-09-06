package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1541;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1541.class)
public abstract class TntEntityMixin extends EntityMixin {
   @ModifyExpressionValue(method = "tick", at = @At(value = "CONSTANT", args = "doubleValue=-0.04d", ordinal = 0))
   private double spacemod$scaleGravity(double value) {
      return value * this.gravityScale;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
