package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3965;
import net.minecraft.class_5819;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;

public class PrivacyGlassPanelBlock extends GlassPanelBlock implements PrivacyBlock {
   public PrivacyGlassPanelBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)super.method_9564().method_11657(OPAQUE, false)).method_11657(INTERACTION_COOLDOWN, false));
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (!player.method_21823() && !player.method_5998(hand).method_31574(this.method_8389()) && this.canInteract(state, pos, world, player, hand)) {
         this.toggle(state, world, pos);
         return class_1269.method_29236(world.field_9236);
      } else {
         return super.method_9534(state, world, pos, player, hand, hit);
      }
   }

   public void method_9588(class_2680 state, class_3218 world, class_2338 pos, class_5819 random) {
      this.toggle(state, world, pos);
   }

   @Override
   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{OPAQUE, INTERACTION_COOLDOWN});
      super.method_9515(builder);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
