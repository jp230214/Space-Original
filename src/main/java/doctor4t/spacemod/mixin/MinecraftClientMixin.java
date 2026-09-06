package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(class_310.class)
public abstract class MinecraftClientMixin {
   @Shadow
   protected abstract void method_18098(class_437 var1);

   @Redirect(
      method = "joinWorld",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;reset(Lnet/minecraft/client/gui/screen/Screen;)V")
   )
   private void reset(class_310 instance, class_437 screen) {
      this.method_18098(null);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
