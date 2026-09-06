package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2338;
import net.minecraft.class_638;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(class_761.class)
public class WorldRendererMixin {
   @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;isOutOfHeightLimit(I)Z"))
   public boolean isOutOfHeightLimit(class_638 instance, int i) {
      return false;
   }

   @WrapOperation(
      method = "render",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;isRenderingReady(Lnet/minecraft/util/math/BlockPos;)Z")
   )
   public boolean isRenderingReady(class_761 instance, class_2338 pos, Operation<Boolean> original) {
      return true;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
