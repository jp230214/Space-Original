package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_638;
import net.minecraft.class_703;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_703.class)
public abstract class ParticleMixin {
   @Unique
   protected float gravityScale = 1.0F;

   @Inject(method = "<init>(Lnet/minecraft/client/world/ClientWorld;DDD)V", at = @At("TAIL"))
   private void spacemod$setGravityScale(class_638 world, double x, double y, double z, CallbackInfo ci) {
      this.gravityScale = SpaceModDimensions.getGravityScale(world);
   }

   @ModifyExpressionValue(method = "tick", at = @At(value = "CONSTANT", args = "doubleValue=0.04d", ordinal = 0))
   private double spacemod$scaleGravity(double value) {
      return value * this.gravityScale;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
