package doctor4t.spacemod.mixin.disablerecipebook;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_332;
import net.minecraft.class_507;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(class_507.class)
public class FuckTheRecipeBookWidgetMixin {
   @Inject(method = "render", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookRender(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
      ci.cancel();
   }

   @Inject(method = "update", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookUpdate(CallbackInfo ci) {
      ci.cancel();
   }

   @Inject(method = "drawTooltip", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookTooltip(CallbackInfo ci) {
      ci.cancel();
   }

   @Inject(method = "toggleOpen", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookToggleOpen(CallbackInfo ci) {
      ci.cancel();
   }

   @Inject(method = "mouseClicked", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookMouseClicked(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
      cir.setReturnValue(false);
   }

   @Inject(method = "refreshInputs", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookRefreshInputs(CallbackInfo ci) {
      ci.cancel();
   }

   @Inject(method = "isMouseOver", at = @At("HEAD"), cancellable = true)
   public void spacemod$disableRecipeBookMouseOver(double mouseX, double mouseY, CallbackInfoReturnable<Boolean> cir) {
      cir.setReturnValue(false);
   }

   @Inject(method = "isOpen", at = @At("HEAD"), cancellable = true)
   public void spacemod$closeRecipeBook(CallbackInfoReturnable<Boolean> cir) {
      cir.setReturnValue(false);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
