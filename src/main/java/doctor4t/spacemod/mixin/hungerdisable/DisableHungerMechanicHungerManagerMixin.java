package doctor4t.spacemod.mixin.hungerdisable;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1657;
import net.minecraft.class_1702;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_1702.class)
public abstract class DisableHungerMechanicHungerManagerMixin {
   @Shadow
   public abstract void method_7580(int var1);

   @Inject(method = "update", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableHunger(class_1657 player, CallbackInfo ci) {
      this.method_7580(20);
      ci.cancel();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
