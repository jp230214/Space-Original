package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2383;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class TrimmedStairsBlock extends class_2383 implements class_3737 {
   public static final class_2746 SUPPORT = class_2746.method_11825("support");
   public static final class_2746 LEFT = class_2746.method_11825("left");
   public static final class_2746 RIGHT = class_2746.method_11825("right");
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   public static final class_265 BOTTOM = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 6.0, 16.0);
   public static final class_265 NORTH_SHAPE = class_259.method_1084(
      class_2248.method_9541(0.0, 6.0, -2.0, 16.0, 8.0, 8.0), class_2248.method_9541(0.0, 14.0, 6.0, 16.0, 16.0, 16.0)
   );
   public static final class_265 NORTH_SUPPORTED_SHAPE = class_259.method_17786(
      NORTH_SHAPE, new class_265[]{BOTTOM, class_2248.method_9541(0.0, 6.0, 8.0, 16.0, 14.0, 16.0)}
   );
   public static final class_265 EAST_SHAPE = class_259.method_1084(
      class_2248.method_9541(8.0, 6.0, 0.0, 18.0, 8.0, 16.0), class_2248.method_9541(0.0, 14.0, 0.0, 10.0, 16.0, 16.0)
   );
   public static final class_265 EAST_SUPPORTED_SHAPE = class_259.method_17786(
      EAST_SHAPE, new class_265[]{BOTTOM, class_2248.method_9541(0.0, 6.0, 0.0, 8.0, 14.0, 16.0)}
   );
   public static final class_265 SOUTH_SHAPE = class_259.method_1084(
      class_2248.method_9541(0.0, 6.0, 8.0, 16.0, 8.0, 18.0), class_2248.method_9541(0.0, 14.0, 0.0, 16.0, 16.0, 10.0)
   );
   public static final class_265 SOUTH_SUPPORTED_SHAPE = class_259.method_17786(
      SOUTH_SHAPE, new class_265[]{BOTTOM, class_2248.method_9541(0.0, 6.0, 0.0, 16.0, 14.0, 8.0)}
   );
   public static final class_265 WEST_SHAPE = class_259.method_1084(
      class_2248.method_9541(-2.0, 6.0, 0.0, 8.0, 8.0, 16.0), class_2248.method_9541(6.0, 14.0, 0.0, 16.0, 16.0, 16.0)
   );
   public static final class_265 WEST_SUPPORTED_SHAPE = class_259.method_17786(
      WEST_SHAPE, new class_265[]{BOTTOM, class_2248.method_9541(8.0, 6.0, 0.0, 16.0, 14.0, 16.0)}
   );

   public TrimmedStairsBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)((class_2680)((class_2680)super.method_9564().method_11657(field_11177, class_2350.field_11043))
                     .method_11657(SUPPORT, false))
                  .method_11657(LEFT, true))
               .method_11657(RIGHT, true))
            .method_11657(WATERLOGGED, false)
      );
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      class_2350 facing = (class_2350)state.method_11654(field_11177);
      if (direction == facing.method_10170() && (Boolean)state.method_11654(LEFT)) {
         return (class_2680)state.method_11657(LEFT, !neighborState.method_27852(this) || neighborState.method_11654(field_11177) != facing);
      } else {
         return direction == facing.method_10160() && state.method_11654(RIGHT)
            ? (class_2680)state.method_11657(RIGHT, !neighborState.method_27852(this) || neighborState.method_11654(field_11177) != facing)
            : state;
      }
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_1937 world = ctx.method_8045();
      class_2338 pos = ctx.method_8037();
      class_2350 facing = ctx.method_8042().method_10153();
      class_2680 leftState = world.method_8320(pos.method_10093(facing.method_10170()));
      class_2680 rightState = world.method_8320(pos.method_10093(facing.method_10160()));
      return (class_2680)((class_2680)((class_2680)((class_2680)((class_2680)this.method_9564()
                     .method_11657(WATERLOGGED, world.method_8316(pos).method_39360(class_3612.field_15910)))
                  .method_11657(SUPPORT, ctx.method_8046()))
               .method_11657(field_11177, facing))
            .method_11657(LEFT, !leftState.method_27852(this) || leftState.method_11654(field_11177) != facing))
         .method_11657(RIGHT, !rightState.method_27852(this) || rightState.method_11654(field_11177) != facing);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      boolean support = (Boolean)state.method_11654(SUPPORT);

      return switch ((class_2350)state.method_11654(field_11177)) {
         case field_11043 -> support ? NORTH_SUPPORTED_SHAPE : NORTH_SHAPE;
         case field_11034 -> support ? EAST_SUPPORTED_SHAPE : EAST_SHAPE;
         case field_11035 -> support ? SOUTH_SUPPORTED_SHAPE : SOUTH_SHAPE;
         default -> support ? WEST_SUPPORTED_SHAPE : WEST_SHAPE;
      };
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_11177, SUPPORT, LEFT, RIGHT, WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
