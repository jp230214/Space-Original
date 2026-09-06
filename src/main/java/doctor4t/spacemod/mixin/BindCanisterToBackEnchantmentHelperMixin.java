package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModBlocks;
import net.minecraft.class_1799;
import net.minecraft.class_1890;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_1890.class)
public class BindCanisterToBackEnchantmentHelperMixin {
   @ModifyReturnValue(method = "hasBindingCurse", at = @At("RETURN"))
   private static boolean hasBindingCurse(boolean original, class_1799 stack) {
      return original || stack.method_31574(SpaceModBlocks.CANISTER.method_8389());
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
