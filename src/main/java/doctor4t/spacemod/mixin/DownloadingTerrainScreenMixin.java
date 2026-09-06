package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_332;
import net.minecraft.class_434;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_434.class)
public class DownloadingTerrainScreenMixin {
   @Inject(method = "render", at = @At("HEAD"), cancellable = true)
   private void render(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
      ci.cancel();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
