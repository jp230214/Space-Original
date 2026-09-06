package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModSounds;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;

public abstract class ToggleableFacingLightBlock extends FacingLightBlock {
   public static final class_2746 LIT = class_2741.field_12548;

   public ToggleableFacingLightBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)super.method_9564().method_11657(LIT, true));
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (!player.method_21823()) {
         boolean lit = (Boolean)state.method_11654(LIT);
         world.method_8652(pos, (class_2680)state.method_11657(LIT, !lit), 3);
         world.method_8396(null, pos, SpaceModSounds.BLOCK_LIGHT_TOGGLE, class_3419.field_15245, 0.5F, lit ? 1.0F : 1.2F);
         return class_1269.method_29236(world.field_9236);
      } else {
         return super.method_9534(state, world, pos, player, hand, hit);
      }
   }

   @Override
   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{LIT});
      super.method_9515(builder);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
