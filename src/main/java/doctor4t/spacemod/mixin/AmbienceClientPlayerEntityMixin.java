package doctor4t.spacemod.mixin;

import com.mojang.authlib.GameProfile;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.sound.PlayerBreatheLoop;
import doctor4t.spacemod.sound.PlayerChokeLoop;
import doctor4t.spacemod.sound.ShipAmbientLoop;
import doctor4t.spacemod.sound.SpaceAmbientLoop;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1113;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_746.class)
public abstract class AmbienceClientPlayerEntityMixin extends class_742 {
   @Shadow
   @Final
   protected class_310 field_3937;
   @Unique
   class_1113 spaceAmbience;
   @Unique
   class_1113 shipAmbience;
   @Unique
   class_1113 breatheAmbience;
   @Unique
   class_1113 chokeAmbience;

   public AmbienceClientPlayerEntityMixin(class_638 world, GameProfile gameProfile) {
      super(world, gameProfile);
   }

   @Shadow
   public abstract boolean method_5869();

   @Inject(method = "tick", at = @At("HEAD"))
   private void rfts$playAmbience(CallbackInfo ci) {
      class_746 player = (class_746)this;
      if (player != null) {
         PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
         if (playerSpaceComponent.isInSpace()) {
            if (this.spaceAmbience == null || !this.field_3937.method_1483().method_4877(this.spaceAmbience)) {
               this.spaceAmbience = new SpaceAmbientLoop(player);
               this.field_3937.method_1483().method_4873(this.spaceAmbience);
            }

            if (this.breatheAmbience == null || PlayerBreatheLoop.shouldPlay(player) && !this.field_3937.method_1483().method_4877(this.breatheAmbience)) {
               this.breatheAmbience = new PlayerBreatheLoop(player);
               this.field_3937.method_1483().method_4873(this.breatheAmbience);
            }

            if (this.chokeAmbience == null || PlayerChokeLoop.shouldPlay(player) && !this.field_3937.method_1483().method_4877(this.chokeAmbience)) {
               this.chokeAmbience = new PlayerChokeLoop(player);
               this.field_3937.method_1483().method_4873(this.chokeAmbience);
            }
         } else if (this.shipAmbience == null || !this.field_3937.method_1483().method_4877(this.shipAmbience)) {
            this.shipAmbience = new ShipAmbientLoop(player);
            this.field_3937.method_1483().method_4873(this.shipAmbience);
         }
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
