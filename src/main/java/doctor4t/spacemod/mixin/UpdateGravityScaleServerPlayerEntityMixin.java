package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(class_3222.class)
public abstract class UpdateGravityScaleServerPlayerEntityMixin extends EntityMixin {
   @Inject(method = "setServerWorld", at = @At("RETURN"))
   private void spacemod$updateGravityScale(class_3218 world, CallbackInfo ci) {
      super.spacemod$updateGravityScale(world);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
