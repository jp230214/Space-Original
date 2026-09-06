package doctor4t.spacemod.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModSounds;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1271;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_1792.class_1793;

public class StimItem extends class_1792 {
   public StimItem(class_1793 settings) {
      super(settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(user);
      if (playerSpaceComponent.isDead()) {
         restorePlayer(user);
         user.method_5998(hand).method_7934(1);
         user.method_5783(SpaceModSounds.ITEM_STIM_USE, 1.0F, 1.0F);
         return class_1271.method_29237(user.method_5998(hand), world.field_9236);
      } else {
         return super.method_7836(world, user, hand);
      }
   }

   public class_1269 method_7847(class_1799 stack, class_1657 user, class_1309 entity, class_1268 hand) {
      if (entity instanceof class_1657 player) {
         PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
         if (playerSpaceComponent.isDead()) {
            stack.method_7934(1);
            user.method_5783(SpaceModSounds.ITEM_STIM_USE, 1.0F, 1.0F);
            restorePlayer(player);
            return class_1269.method_29236(user.method_37908().field_9236);
         }
      }

      return super.method_7847(stack, user, entity, hand);
   }

   public static void restorePlayer(class_1657 player) {
      PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
      playerSpaceComponent.setDead(false);
      if (playerSpaceComponent.getOxygen() <= 0) {
         playerSpaceComponent.setOxygen(6000);
         playerSpaceComponent.sync();
      }

      player.method_6033(5.0F);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
