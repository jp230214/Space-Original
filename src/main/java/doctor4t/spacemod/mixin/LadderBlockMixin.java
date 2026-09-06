package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1936;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2399;
import net.minecraft.class_2680;
import net.minecraft.class_2753;
import net.minecraft.class_4538;
import net.minecraft.class_4970.class_2251;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_2399.class)
public abstract class LadderBlockMixin extends class_2248 {
   @Shadow
   @Final
   public static class_2753 field_11253;

   protected LadderBlockMixin(class_2251 settings) {
      super(settings);
   }

   @ModifyReturnValue(method = "canPlaceAt", at = @At("RETURN"))
   private boolean spacemod$moreLadderPlacementOptions(boolean original, class_2680 state, class_4538 world, class_2338 pos) {
      if (original) {
         return true;
      }

      class_2350 facing = (class_2350)state.method_11654(field_11253);
      class_2680 aboveState = world.method_8320(pos.method_10084());
      return aboveState.method_27852(this) && aboveState.method_11654(field_11253) == facing;
   }

   @Inject(method = "getStateForNeighborUpdate", at = @At("HEAD"), cancellable = true)
   private void spacemod$verticalNeighborChecks(
      class_2680 state,
      class_2350 direction,
      class_2680 neighborState,
      class_1936 world,
      class_2338 pos,
      class_2338 neighborPos,
      CallbackInfoReturnable<class_2680> cir
   ) {
      if (direction.method_10166().method_10178() && !state.method_26184(world, pos)) {
         cir.setReturnValue(class_2246.field_10124.method_9564());
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
