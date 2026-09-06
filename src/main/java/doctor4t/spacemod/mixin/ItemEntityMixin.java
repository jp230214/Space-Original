package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1542;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1542.class)
public abstract class ItemEntityMixin extends EntityMixin {
   @ModifyExpressionValue(method = "tick", at = @At(value = "CONSTANT", args = "doubleValue=-0.04d", ordinal = 0))
   private double spacemod$scaleGravity(double value) {
      return value * this.gravityScale;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
