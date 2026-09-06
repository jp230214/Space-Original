package doctor4t.spacemod.mixin.incapacitated;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_304;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(class_304.class)
public abstract class KeyBindingMixin {
   @Shadow
   public abstract String method_1423();

   @Inject(method = "isPressed", at = @At("HEAD"), cancellable = true)
   private void isPressed(CallbackInfoReturnable<Boolean> cir) {
      if (SpaceModClient.shouldLockInPlace() && !this.method_1423().equals("key.categories.ui") && !this.method_1423().equals("key.categories.multiplayer")) {
         cir.setReturnValue(false);
      }
   }

   @Inject(method = "wasPressed", at = @At("HEAD"), cancellable = true)
   private void wasPressed(CallbackInfoReturnable<Boolean> cir) {
      if (SpaceModClient.shouldLockInPlace() && !this.method_1423().equals("key.categories.ui") && !this.method_1423().equals("key.categories.multiplayer")) {
         cir.setReturnValue(false);
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
