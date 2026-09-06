package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.cca.entity.HoldingComponent;
import doctor4t.spacemod.item.MarshmallowStickItem;
import doctor4t.spacemod.util.PlayerAttackHeld;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_1657.class)
public abstract class ResetMarshmallowAttackPlayerEntityMixin extends class_1309 implements PlayerAttackHeld {
   protected ResetMarshmallowAttackPlayerEntityMixin(class_1299<? extends class_1309> entityType, class_1937 world) {
      super(entityType, world);
   }

   @Override
   public boolean spacemod$isHoldingAttack() {
      return ((HoldingComponent)SpaceModComponents.HOLDING.get(this)).isHolding();
   }

   @Override
   public void spacemod$setHoldingAttack(boolean attackHeld) {
      ((HoldingComponent)SpaceModComponents.HOLDING.get(this)).setHolding(attackHeld);
   }

   @Inject(method = "resetLastAttackedTicks", at = @At("HEAD"), cancellable = true)
   private void spacemod$resetMarshmallowAttack(CallbackInfo ci) {
      if (this.method_6047().method_7909() instanceof MarshmallowStickItem) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
