package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModSounds;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2383;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_3965;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class PlushBlock extends class_2383 implements class_3737 {
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   protected static final class_265 SHAPE = class_2248.method_9541(3.0, 0.0, 3.0, 13.0, 15.0, 13.0);

   public PlushBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)super.method_9564().method_11657(field_11177, class_2350.field_11043)).method_11657(WATERLOGGED, false));
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      class_243 mid = class_243.method_24953(pos);
      if (!world.field_9236) {
         class_3414 honk = SpaceModSounds.BLOCK_MAUVE_PLUSH_HONK;
         world.method_43128(null, mid.method_10216(), mid.method_10214(), mid.method_10215(), honk, class_3419.field_15245, 1.0F, 1.0F);
      }

      return class_1269.field_5812;
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_3610 fluidState = ctx.method_8045().method_8316(ctx.method_8037());
      return (class_2680)((class_2680)this.method_9564().method_11657(field_11177, ctx.method_8042().method_10153()))
         .method_11657(WATERLOGGED, fluidState.method_39360(class_3612.field_15910));
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_11177, WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
