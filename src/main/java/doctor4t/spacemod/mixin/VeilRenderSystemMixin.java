package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import foundry.veil.api.client.render.VeilRenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_291;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(VeilRenderSystem.class)
public class VeilRenderSystemMixin {
   @Inject(method = "drawIndirect", at = @At("HEAD"), cancellable = true)
   private static void spacemod$drawIndirect(class_291 vbo, long indirect, int drawCount, int stride, CallbackInfo ci) {
      if (SpaceModClient.ryanMode) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
