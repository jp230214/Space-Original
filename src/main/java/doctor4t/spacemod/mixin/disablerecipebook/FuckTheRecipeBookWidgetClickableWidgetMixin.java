package doctor4t.spacemod.mixin.disablerecipebook;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_339;
import net.minecraft.class_507;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(class_339.class)
public class FuckTheRecipeBookWidgetClickableWidgetMixin {
   @Inject(method = "clicked", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookClicked(double mouseX, double mouseY, CallbackInfoReturnable<Boolean> cir) {
      if (this instanceof class_507) {
         cir.setReturnValue(false);
      }
   }

   @Inject(method = "onClick", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookOnClick(double mouseX, double mouseY, CallbackInfo ci) {
      if (this instanceof class_507) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
