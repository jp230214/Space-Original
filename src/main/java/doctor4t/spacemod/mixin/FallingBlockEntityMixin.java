package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1540;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1540.class)
public abstract class FallingBlockEntityMixin extends EntityMixin {
   @ModifyExpressionValue(method = "tick", at = @At(value = "CONSTANT", args = "doubleValue=-0.04d", ordinal = 0))
   private double spacemod$scaleGravity(double value) {
      return value * this.gravityScale;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
