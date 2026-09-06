package doctor4t.spacemod.mixin.disablechat;

import com.mojang.brigadier.context.CommandContext;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_2168;
import net.minecraft.class_3045;
import net.minecraft.class_7471;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_3045.class)
public class MeCommandMixin {
   @Inject(method = "method_43645", at = @At("HEAD"), cancellable = true)
   private static void spacemod$noChatting(@NotNull CommandContext<class_2168> commandContext, class_7471 message, CallbackInfo ci) {
      if (!((class_2168)commandContext.getSource()).method_9259(2)) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
