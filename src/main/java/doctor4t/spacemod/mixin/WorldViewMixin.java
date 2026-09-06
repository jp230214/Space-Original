package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import doctor4t.spacemod.index.tag.SpaceModFluidTags;
import net.minecraft.class_3610;
import net.minecraft.class_4538;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_4538.class)
public interface WorldViewMixin {
   @WrapOperation(method = "containsFluid", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isEmpty()Z"))
   private boolean spacemod$pretendLiquidIsNotEmptyEvenThoughItIs(class_3610 state, Operation<Boolean> original) {
      return (Boolean)original.call(new Object[]{state}) && !state.method_15767(SpaceModFluidTags.LIQUIDS);
   }


}
