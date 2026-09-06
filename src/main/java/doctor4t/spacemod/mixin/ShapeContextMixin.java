package doctor4t.spacemod.mixin;


import net.minecraft.class_1297;
import net.minecraft.class_3726;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_3726.class)
public interface ShapeContextMixin {
   @Shadow
   static class_3726 method_16194() {
      return null;
   }

   @Inject(method = "of", at = @At("HEAD"), cancellable = true)
   private static void of(class_1297 entity, CallbackInfoReturnable<class_3726> cir) {
      if (entity == null) {
         cir.setReturnValue(method_16194());
      }
   }


}
