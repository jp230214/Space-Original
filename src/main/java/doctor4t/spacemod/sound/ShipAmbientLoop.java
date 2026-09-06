package doctor4t.spacemod.sound;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1101;
import net.minecraft.class_1113;
import net.minecraft.class_3419;
import net.minecraft.class_746;

@Environment(EnvType.CLIENT)
public class ShipAmbientLoop extends class_1101 {
   private static final int TRANSITION_TIME = 40;
   private final class_746 player;
   private int transitionTimer;

   public ShipAmbientLoop(class_746 player) {
      super(SpaceModSounds.AMBIENT_SHIP, class_3419.field_15256, class_1113.method_43221());
      this.player = player;
      this.field_5446 = true;
      this.field_5451 = 0;
      this.field_5442 = 1.0F;
      this.field_18936 = true;
   }

   public void method_16896() {
      if (!this.player.method_31481() && this.transitionTimer >= 0) {
         PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(this.player);
         if (!playerSpaceComponent.isInSpace()) {
            if (SpaceModClient.shipTimer >= 40.0F) {
               this.transitionTimer++;
            }
         } else {
            this.transitionTimer--;
         }

         this.transitionTimer = Math.min(this.transitionTimer, 40);
         this.field_5442 = Math.max(0.0F, Math.min(this.transitionTimer / 40.0F, 1.0F));
      } else {
         this.method_24876();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
