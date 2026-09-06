package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.BranchBlock;
import java.util.Optional;
import net.minecraft.class_1743;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1743.class)
public abstract class AxeItemMixin {
   @Inject(method = "getStrippedState", at = @At("HEAD"), cancellable = true)
   private void spacemod$branchState(class_2680 state, CallbackInfoReturnable<Optional<class_2680>> cir) {
      if (BranchBlock.STRIPPED_BRANCHES.containsKey(state.method_26204())) {
         cir.setReturnValue(Optional.ofNullable(BranchBlock.STRIPPED_BRANCHES.get(state.method_26204())).map(block -> block.method_34725(state)));
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
