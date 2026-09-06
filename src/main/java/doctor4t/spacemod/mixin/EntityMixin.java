package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.index.tag.SpaceModFluidTags;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2464;
import net.minecraft.class_2680;
import net.minecraft.class_3611;
import net.minecraft.class_6862;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(class_1297.class)
public abstract class EntityMixin {
   @Unique
   protected boolean touchingLiquid = false;
   @Unique
   protected float gravityScale = 1.0F;

   @Shadow
   public abstract boolean method_5692(class_6862<class_3611> var1, double var2);

   @Shadow
   public abstract void method_38785();

   @Shadow
   public abstract class_1937 method_37908();

   @Shadow
   public abstract class_1299<?> method_5864();

   @Shadow
   public abstract float method_36454();

   @Shadow
   public abstract void method_36456(float var1);

   @Shadow
   public abstract void method_5814(double var1, double var3, double var5);

   @Shadow
   public abstract void method_36457(float var1);

   @Unique
   protected void spacemod$updateGravityScale(class_1937 world) {
      this.gravityScale = SpaceModDimensions.getGravityScale(world);
   }

   @Inject(method = "<init>", at = @At("TAIL"))
   private void spacemod$setGravityScale(class_1299<?> type, class_1937 world, CallbackInfo ci) {
      this.spacemod$updateGravityScale(world);
   }

   @ModifyExpressionValue(
      method = "updateWaterState",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;updateMovementInFluid(Lnet/minecraft/registry/tag/TagKey;D)Z")
   )
   private boolean spacemod$movementInLiquid(boolean original) {
      this.touchingLiquid = this.method_5692(SpaceModFluidTags.LIQUIDS, 0.02F);
      if (this.touchingLiquid) {
         this.method_38785();
         return true;
      } else {
         return original;
      }
   }

   @WrapOperation(
      method = "spawnSprintingParticles",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getRenderType()Lnet/minecraft/block/BlockRenderType;")
   )
   private class_2464 spacemod$noLiquidSprintParticles(class_2680 state, Operation<class_2464> original) {
      return state.method_26204() instanceof LiquidBlock ? class_2464.field_11455 : (class_2464)original.call(new Object[]{state});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
