package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.SpaceModKeybinds;
import doctor4t.spacemod.duck.ClientPlayerEntityDuck;
import doctor4t.spacemod.entity.DrivingSeatEntity;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import doctor4t.spacemod.mixinducks.LivingEntityDuck;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_4076;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_746.class)
public abstract class ClientPlayerEntityMixin extends class_1309 implements ClientPlayerEntityDuck {
   @Shadow
   @Final
   protected class_310 field_3937;

   protected ClientPlayerEntityMixin(class_1299<? extends class_1309> entityType, class_1937 world) {
      super(entityType, world);
   }

   @ModifyExpressionValue(
      method = "tickMovement",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isTouchingWater()Z", ordinal = 3)
   )
   private boolean spacemod$touchingLiquid(boolean original) {
      return original || ((LivingEntityDuck)this).getLivingTouchingLiquid();
   }

   @Inject(method = "tickMovement", at = @At("HEAD"), cancellable = true)
   public void tickMovement(CallbackInfo ci) {
      if (SpaceModClient.frozen) {
         ci.cancel();
         if (!this.method_37908().method_27983().equals(SpaceModDimensions.JANUS)) {
            class_4076 sectionPos = class_4076.method_18680(this.method_19538());
            if (this.method_37908().method_8398().method_12123(sectionPos.method_10263(), sectionPos.method_10260())) {
               SpaceModClient.frozen = false;
            }
         }
      }
   }

   public void method_5872(double cursorDeltaX, double cursorDeltaY) {
      if (this instanceof class_746 clientPlayerEntity) {
         if (clientPlayerEntity.method_5765() && clientPlayerEntity.method_5854() instanceof DrivingSeatEntity) {
            if (SpaceModKeybinds.spaceshipRoll.method_1434()) {
               SpaceModClient.rotationFromMouse.add(0.0, 0.0, cursorDeltaX);
            } else {
               SpaceModClient.rotationFromMouse.add(cursorDeltaY, -cursorDeltaX, 0.0);
            }

            return;
         }

         if (SpaceModClient.shouldLockInPlace()) {
            clientPlayerEntity.method_36457(45.0F);
            return;
         }
      }

      super.method_5872(cursorDeltaX, cursorDeltaY);
   }

   @Override
   public void freeze() {
      SpaceModClient.frozen = true;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
