package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2383;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2756;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_3965;
import net.minecraft.class_5151;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class CanisterBlock extends class_2383 implements class_3737, class_5151 {
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   public static final class_2758 LEVEL = class_2758.method_11867("level", 0, 8);
   public static final class_2754<class_2756> HALF = class_2741.field_12533;
   protected static final class_265 BOTTOM_SHAPE = class_259.method_1084(
      class_2248.method_9541(1.0, 0.0, 1.0, 15.0, 4.0, 15.0), class_2248.method_9541(2.0, 4.0, 2.0, 14.0, 16.0, 14.0)
   );
   protected static final class_265 TOP_SHAPE = class_259.method_17786(
      class_2248.method_9541(2.0, 0.0, 2.0, 14.0, 4.0, 14.0),
      new class_265[]{
         class_2248.method_9541(1.0, 4.0, 1.0, 15.0, 8.0, 15.0),
         class_2248.method_9541(5.0, 8.0, 5.0, 11.0, 10.0, 11.0),
         class_2248.method_9541(6.0, 10.0, 6.0, 10.0, 16.0, 10.0)
      }
   );

   public CanisterBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)((class_2680)super.method_9564().method_11657(field_11177, class_2350.field_11043)).method_11657(LEVEL, 0))
               .method_11657(HALF, class_2756.field_12607))
            .method_11657(WATERLOGGED, false)
      );
   }

   public class_1304 method_7685() {
      return class_1304.field_6174;
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return state.method_11654(HALF) == class_2756.field_12609 ? TOP_SHAPE : BOTTOM_SHAPE;
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_3610 fluidState = ctx.method_8045().method_8316(ctx.method_8037());
      return (class_2680)((class_2680)((class_2680)this.method_9564().method_11657(field_11177, ctx.method_8042().method_10153()))
            .method_11657(HALF, class_2756.field_12607))
         .method_11657(WATERLOGGED, fluidState.method_39360(class_3612.field_15910));
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_11177, LEVEL, WATERLOGGED, HALF});
   }

   public void method_9567(class_1937 world, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 itemStack) {
      if (world.method_8320(pos.method_10084()).method_26215()) {
         world.method_8501(pos.method_10084(), (class_2680)state.method_11657(HALF, class_2756.field_12609));
      } else {
         world.method_8501(pos, class_2246.field_10124.method_9564());
      }

      super.method_9567(world, pos, state, placer, itemStack);
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (player.method_5998(hand).method_7960()) {
         class_1799 stack = this.getItemStack(state);
         if (stack.method_7969().method_10550("ichorState") > 0) {
            if (!player.method_6118(this.method_7685()).method_7960()) {
               return class_1269.field_5811;
            }

            player.method_5673(this.method_7685(), stack);
            player.method_6116(this.method_7685(), class_1799.field_8037, stack);
         } else {
            player.method_7270(stack);
            player.method_37908()
               .method_43128(
                  null, player.method_23317(), player.method_23318(), player.method_23321(), class_3417.field_21866, class_3419.field_15248, 1.0F, 1.0F
               );
         }

         if (state.method_11654(HALF) == class_2756.field_12607) {
            world.method_8501(pos, class_2246.field_10124.method_9564());
            world.method_8501(pos.method_10084(), class_2246.field_10124.method_9564());
         } else {
            world.method_8501(pos, class_2246.field_10124.method_9564());
            world.method_8501(pos.method_10074(), class_2246.field_10124.method_9564());
         }

         return class_1269.method_29236(world.field_9236);
      } else {
         return super.method_9534(state, world, pos, player, hand, hit);
      }
   }

   public void method_9536(class_2680 state, class_1937 world, class_2338 pos, class_2680 newState, boolean moved) {
      if (!newState.method_27852(state.method_26204())) {
         class_2338 other = state.method_11654(HALF) == class_2756.field_12609 ? pos.method_10074() : pos.method_10084();
         if (world.method_8320(other).method_27852(this)) {
            world.method_8501(other, class_2246.field_10124.method_9564());
         }
      }

      super.method_9536(state, world, pos, newState, moved);
   }

   public class_1799 getItemStack(class_2680 state) {
      if (state.method_27852(this)) {
         class_1799 ret = new class_1799(this);
         ret.method_7948().method_10569("ichorState", (Integer)state.method_11654(LEVEL));
         return ret;
      } else {
         return class_1799.field_8037;
      }
   }

   public class_3414 method_31570() {
      return class_3417.field_21866;
   }

   public class_265 method_9584(class_2680 state, class_1922 world, class_2338 pos) {
      return class_259.method_1077();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
