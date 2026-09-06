package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2464;
import net.minecraft.class_2680;
import net.minecraft.class_702;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_702.class)
public abstract class ParticleManagerMixin {
   @WrapOperation(
      method = "addBlockBreakingParticles",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getRenderType()Lnet/minecraft/block/BlockRenderType;")
   )
   private class_2464 spacemod$noLiquidBreakParticles(class_2680 state, Operation<class_2464> original) {
      return state.method_26204() instanceof LiquidBlock ? class_2464.field_11455 : (class_2464)original.call(new Object[]{state});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
