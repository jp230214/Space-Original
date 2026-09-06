package doctor4t.spacemod.mixin.incapacitated;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_304;
import net.minecraft.class_312;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_312.class)
public abstract class MouseMixin {
   @Inject(method = "onMouseButton", at = @At("HEAD"), cancellable = true)
   private void onMouseButton(long window, int button, int action, int mods, CallbackInfo callbackInfo) {
      if (SpaceModClient.shouldLockInPlace()) {
         class_304.method_1437();
         callbackInfo.cancel();
      }
   }

   @Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
   private void onMouseScroll(long window, double horizontal, double vertical, CallbackInfo callbackInfo) {
      if (SpaceModClient.shouldLockInPlace()) {
         class_304.method_1437();
         callbackInfo.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
