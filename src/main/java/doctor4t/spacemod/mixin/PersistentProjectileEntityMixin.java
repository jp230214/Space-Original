package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1665;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1665.class)
public abstract class PersistentProjectileEntityMixin extends EntityMixin {
   @ModifyExpressionValue(method = "tick", at = @At(value = "CONSTANT", args = "floatValue=0.05F", ordinal = 0))
   private float spacemod$scaleGravity(float value) {
      return value * this.gravityScale;
   }

   @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;setVelocity(DDD)V"))
   private void spacemod$scaleGravity(class_1665 instance, double x, double y, double z, Operation<Void> original) {
      original.call(new Object[]{instance, x, y + 0.05F - 0.05F * this.gravityScale, z});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
