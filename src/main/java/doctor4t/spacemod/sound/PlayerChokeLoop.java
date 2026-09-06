package doctor4t.spacemod.sound;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1101;
import net.minecraft.class_1113;
import net.minecraft.class_1657;
import net.minecraft.class_3419;

@Environment(EnvType.CLIENT)
public class PlayerChokeLoop extends class_1101 {
   protected final class_1657 player;

   public PlayerChokeLoop(class_1657 entity) {
      super(SpaceModSounds.ENTITY_PLAYER_CHOKE, class_3419.field_15248, class_1113.method_43221());
      this.player = entity;
      this.field_5439 = (float)entity.method_23317();
      this.field_5450 = (float)entity.method_23318();
      this.field_5449 = (float)entity.method_23321();
      this.field_5446 = false;
      this.field_5451 = 1;
      this.field_5442 = 0.5F;
      this.field_5441 = 1.0F;
   }

   public void method_16896() {
      if (!shouldPlay(this.player)) {
         this.method_24876();
      } else {
         this.field_5439 = (float)this.player.method_23317();
         this.field_5450 = (float)this.player.method_23318();
         this.field_5449 = (float)this.player.method_23321();
      }
   }

   public boolean method_4785() {
      return true;
   }

   public boolean method_26273() {
      return !this.player.method_5701() && shouldPlay(this.player);
   }

   public static boolean shouldPlay(class_1657 player) {
      PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
      return !player.method_31481() && playerSpaceComponent.getOxygen() <= 0 && !playerSpaceComponent.isDead();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
