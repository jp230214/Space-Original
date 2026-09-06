package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.index.tag.SpaceModFluidTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3610;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(class_4184.class)
public abstract class CameraMixin {
   @Shadow
   private class_1922 field_18710;

   @Inject(method = "getSubmersionType", at = @At("HEAD"))
   private void spacemod$resetLiquidSubmersionType(CallbackInfoReturnable<class_5636> cir) {
      SpaceModClient.submergedLiquid = null;
   }

   @Inject(
      method = "getSubmersionType",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", shift = Shift.BEFORE),
      cancellable = true
   )
   private void spacemod$liquidSubmersionType(
      CallbackInfoReturnable<class_5636> cir,
      @Local(ordinal = 1) class_3610 fluidState,
      @Local class_2680 state,
      @Local class_2338 blockPos,
      @Local(ordinal = 1) class_243 pos
   ) {
      if (fluidState.method_15767(SpaceModFluidTags.LIQUIDS)
         && pos.field_1351 <= fluidState.method_15763(this.field_18710, blockPos) + blockPos.method_10264()
         && state.method_26204() instanceof LiquidBlock liquidBlock) {
         SpaceModClient.submergedLiquid = liquidBlock;
         cir.setReturnValue(class_5636.field_27887);
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
