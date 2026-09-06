package doctor4t.spacemod.mixin.disablechat;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_2797;
import net.minecraft.class_3222;
import net.minecraft.class_3244;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_3244.class)
public class ServerPlayNetworkHandlerMixin {
   @Shadow
   public class_3222 field_14140;

   @Inject(method = "onChatMessage", at = @At("HEAD"), cancellable = true)
   private void spacemod$noChatting(class_2797 packet, @NotNull CallbackInfo ci) {
      if (!this.field_14140.method_5687(2)) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
