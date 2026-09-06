package doctor4t.spacemod.mixin.disablechat;

import dev.upcraft.sdrm.api.SDRMVerifier;
import java.util.Collection;
import net.minecraft.class_2168;
import net.minecraft.class_3082;
import net.minecraft.class_3222;
import net.minecraft.class_7471;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_3082.class)
public class MessageCommandMixin {
   @Inject(method = "execute", at = @At("HEAD"), cancellable = true)
   private static void spacemod$noChatting(@NotNull class_2168 source, Collection<class_3222> targets, class_7471 message, CallbackInfo ci) {
      if (!source.method_9259(2)) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
