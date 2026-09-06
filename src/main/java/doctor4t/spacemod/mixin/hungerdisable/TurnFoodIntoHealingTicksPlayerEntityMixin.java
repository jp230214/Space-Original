package doctor4t.spacemod.mixin.hungerdisable;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1702;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1657.class)
public abstract class TurnFoodIntoHealingTicksPlayerEntityMixin extends class_1309 {
   protected TurnFoodIntoHealingTicksPlayerEntityMixin(class_1299<? extends class_1309> entityType, class_1937 world) {
      super(entityType, world);
   }

   @Shadow
   public abstract class_1702 method_7344();

   @Inject(method = "eatFood", at = @At("TAIL"))
   public void eatFood(class_1937 world, class_1799 stack, CallbackInfoReturnable<class_1799> cir) {
      if (stack.method_7909().method_19263()) {
         int healingTicks = stack.method_7909().method_19264().method_19230() * 20;
         ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(this)).setMaxHealingTicks(healingTicks);
         ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(this)).setHealingTicks(healingTicks);
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
