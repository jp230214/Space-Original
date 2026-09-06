package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1530;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1530.class)
public abstract class AbstractDecorationEntityMixin extends class_1297 {
   public AbstractDecorationEntityMixin(class_1299<?> type, class_1937 world) {
      super(type, world);
   }

   @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
   private void spacemod$invulnerablePaintings(class_1282 source, float amount, CallbackInfoReturnable<Boolean> cir) {
      if (this.method_5864().equals(class_1299.field_6120) && !source.method_5530()) {
         cir.setReturnValue(false);
      }
   }

   @Inject(method = "canStayAttached", at = @At("HEAD"), cancellable = true)
   public void spacemod$canStayAttached(CallbackInfoReturnable<Boolean> cir) {
      cir.setReturnValue(true);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
