package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_315;
import net.minecraft.class_4063;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(class_315.class)
public class DisableCloudsGameOptionsMixin {
   @Inject(method = "getCloudRenderModeValue", at = @At("RETURN"), cancellable = true)
   public void getCloudRenderModeValue(CallbackInfoReturnable<class_4063> cir) {
      cir.setReturnValue(class_4063.field_18162);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
