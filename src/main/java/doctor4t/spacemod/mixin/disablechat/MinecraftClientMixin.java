package doctor4t.spacemod.mixin.disablechat;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_310;
import net.minecraft.class_634;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_310.class)
public abstract class MinecraftClientMixin {
   @Shadow
   @Nullable
   public abstract class_634 method_1562();

   @Inject(method = "openChatScreen", at = @At("HEAD"), cancellable = true)
   private void spacemod$noTextChat(String text, @NotNull CallbackInfo ci) {
      if ("".equals(text) && this.method_1562() != null && !this.method_1562().method_2875().method_9259(2)) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
