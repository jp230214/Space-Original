package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1682;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1682.class)
public abstract class ThrownEntityMixin extends EntityMixin {
   @ModifyReturnValue(method = "getGravity", at = @At("RETURN"))
   private float spacemod$scaleGravity(float original) {
      return original * this.gravityScale;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
