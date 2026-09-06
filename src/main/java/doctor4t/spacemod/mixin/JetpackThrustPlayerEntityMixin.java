package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_1657.class)
public abstract class JetpackThrustPlayerEntityMixin extends class_1309 {
   protected JetpackThrustPlayerEntityMixin(class_1299<? extends class_1309> entityType, class_1937 world) {
      super(entityType, world);
   }

   @Shadow
   public abstract class_1799 method_6118(class_1304 var1);

   @Inject(method = "tickMovement", at = @At("TAIL"))
   public void tickMovement(CallbackInfo ci) {
      if (((PlayerSpaceComponent)SpaceModComponents.SPACE.get(this)).isJetpackOn()) {
         this.method_18800(this.method_18798().method_10216(), Math.min(this.method_18798().method_10214() + 0.1F, 0.5), this.method_18798().method_10215());
         if (this.method_18798().method_10214() >= -0.5) {
            this.field_6017 = 0.0F;
         }
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
