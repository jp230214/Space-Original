package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.TrimmedBedBlock;
import doctor4t.spacemod.block.VentShaftBlock;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.tag.SpaceModBlockTags;
import doctor4t.spacemod.index.tag.SpaceModFluidTags;
import doctor4t.spacemod.mixinducks.LivingEntityDuck;
import net.minecraft.class_1309;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3611;
import net.minecraft.class_6862;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_1309.class)
public abstract class LivingEntityMixin extends EntityMixin implements LivingEntityDuck {
   @Unique
   protected boolean livingTouchingLiquid = false;

   @Inject(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isFireImmune()Z", shift = Shift.BEFORE))
   private void spacemod$setLivingTouchingLiquid(CallbackInfo ci) {
      this.livingTouchingLiquid = this.touchingLiquid;
   }

   @ModifyExpressionValue(
      method = "isClimbing",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z")
   )
   private boolean spacemod$onlyClimbVerticalVents(boolean original, @Local class_2680 state) {
      return original && state.method_26164(SpaceModBlockTags.VENT_SHAFTS) && state.method_11654(VentShaftBlock.UP) && state.method_11654(VentShaftBlock.DOWN)
         ? false
         : original;
   }

   @WrapOperation(method = "canEnterTrapdoor", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
   private boolean spacemod$metalLaddersAreLaddersToo(class_2680 state, class_2248 block, Operation<Boolean> original) {
      return (Boolean)original.call(new Object[]{state, block}) || state.method_27852(SpaceModBlocks.METAL_LADDER);
   }

   @ModifyExpressionValue(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isTouchingWater()Z"))
   private boolean spacemod$touchingLiquid(boolean original) {
      return original || this.touchingLiquid;
   }

   @WrapOperation(
      method = "tickMovement",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getFluidHeight(Lnet/minecraft/registry/tag/TagKey;)D", ordinal = 1)
   )
   private double spacemod$liquidHeight(class_1309 entity, class_6862<class_3611> tag, Operation<Double> original) {
      return this.touchingLiquid ? (Double)original.call(new Object[]{entity, SpaceModFluidTags.LIQUIDS}) : (Double)original.call(new Object[]{entity, tag});
   }

   @ModifyExpressionValue(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isTouchingWater()Z"))
   private boolean spacemod$touchingLiquidToo(boolean original) {
      return original || this.touchingLiquid;
   }

   @WrapOperation(
      method = "tickMovement",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;swimUpward(Lnet/minecraft/registry/tag/TagKey;)V", ordinal = 1)
   )
   private void spacemod$swimUpwardInLiquid(class_1309 entity, class_6862<class_3611> tag, Operation<Void> original) {
      original.call(new Object[]{entity, this.touchingLiquid ? SpaceModFluidTags.LIQUIDS : tag});
   }

   @ModifyReturnValue(method = "method_18405", at = @At("RETURN"))
   private Boolean spacemod$sleepingInTrimmedBed(Boolean original, class_2338 pos) {
      return original || this.method_37908().method_8320(pos).method_26204() instanceof TrimmedBedBlock;
   }

   @Inject(method = "method_18404", at = @At("HEAD"), cancellable = true)
   private void spacemod$wakeUpInTrimmedBed(class_2338 pos, CallbackInfo ci) {
      class_2680 state = this.method_37908().method_8320(pos);
      if (state.method_26204() instanceof TrimmedBedBlock) {
         class_2350 facing = (class_2350)state.method_11654(TrimmedBedBlock.field_11177);
         this.method_37908().method_8652(pos, (class_2680)state.method_11657(TrimmedBedBlock.OCCUPIED, false), 3);
         class_243 wakeUpPos = TrimmedBedBlock.findWakeUpPosition(this.method_5864(), this.method_37908(), pos, facing, this.method_36454())
            .orElseGet(() -> class_243.method_24955(pos.method_10084()).method_1031(0.0, 0.1, 0.0));
         class_243 centeredPos = class_243.method_24955(pos).method_1020(wakeUpPos).method_1029();
         float yaw = (float)class_3532.method_15338(class_3532.method_15349(centeredPos.field_1350, centeredPos.field_1352) * 180.0F / (float)Math.PI - 90.0);
         this.method_5814(wakeUpPos.field_1352, wakeUpPos.field_1351, wakeUpPos.field_1350);
         this.method_36456(yaw);
         this.method_36457(0.0F);
         ci.cancel();
      }
   }

   @WrapOperation(
      method = "getSleepingDirection",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/block/BedBlock;getDirection(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/math/Direction;"
      )
   )
   private class_2350 spacemod$trimmedBedSleepingDirection(class_1922 world, class_2338 pos, Operation<class_2350> original) {
      class_2350 direction = (class_2350)original.call(new Object[]{world, pos});
      return direction == null ? TrimmedBedBlock.getDirection(world, pos) : direction;
   }

   @Override
   public boolean getLivingTouchingLiquid() {
      return this.livingTouchingLiquid;
   }

   @ModifyExpressionValue(method = "travel", at = @At(value = "CONSTANT", args = "doubleValue=0.08d", ordinal = 0))
   private double spacemod$scaleGravity(double value) {
      return value * this.gravityScale;
   }

   @ModifyExpressionValue(method = "computeFallDamage", at = @At(value = "CONSTANT", args = "floatValue=3.0F", ordinal = 0))
   private float spacemod$scaleFallDamage(float value) {
      return value / this.gravityScale;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
