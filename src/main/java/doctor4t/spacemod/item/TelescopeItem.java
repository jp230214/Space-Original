package doctor4t.spacemod.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModSounds;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_3468;
import net.minecraft.class_5328;
import net.minecraft.class_5538;
import net.minecraft.class_1792.class_1793;

public class TelescopeItem extends class_5538 {
   public TelescopeItem(class_1793 settings) {
      super(settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      user.method_5783(SpaceModSounds.ITEM_TELESCOPE_ZOOM_IN, 1.0F, 1.0F);
      user.method_7259(class_3468.field_15372.method_14956(this));
      return class_5328.method_29282(world, user, hand);
   }

   public class_1799 method_7861(class_1799 stack, class_1937 world, class_1309 user) {
      this.playStopUsingSound(user);
      return stack;
   }

   public void method_7840(class_1799 stack, class_1937 world, class_1309 user, int remainingUseTicks) {
      this.playStopUsingSound(user);
   }

   private void playStopUsingSound(class_1309 user) {
      user.method_5783(SpaceModSounds.ITEM_TELESCOPE_ZOOM_OUT, 1.0F, 1.0F);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
