package doctor4t.spacemod.mixin.marshmallows;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.item.MarshmallowStickItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_1309.class)
public abstract class NoHandSwingWithMarshmallowStickLivingEntityMixin {
   @Shadow
   public abstract class_1799 method_5998(class_1268 var1);

   @Inject(method = "swingHand(Lnet/minecraft/util/Hand;Z)V", at = @At("HEAD"), cancellable = true)
   private void spacemod$swingHand(class_1268 hand, boolean fromServerPlayer, CallbackInfo ci) {
      class_1799 stack = this.method_5998(hand);
      if (stack.method_7909() instanceof MarshmallowStickItem
         && (
            !((class_1309)this).method_5667().equals(class_310.method_1551().field_1724.method_5667())
               || !class_310.method_1551().field_1690.method_31044().method_31034()
         )) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
