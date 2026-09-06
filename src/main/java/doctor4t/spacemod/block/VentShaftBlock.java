package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import java.util.function.Function;
import net.minecraft.class_156;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2429;
import net.minecraft.class_247;
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

public class VentShaftBlock extends class_2248 implements class_3737 {
   public static final class_2746 NORTH = class_2741.field_12489;
   public static final class_2746 EAST = class_2741.field_12487;
   public static final class_2746 SOUTH = class_2741.field_12540;
   public static final class_2746 WEST = class_2741.field_12527;
   public static final class_2746 UP = class_2741.field_12519;
   public static final class_2746 DOWN = class_2741.field_12546;
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   protected static final class_265 BASE_SHAPE = class_259.method_1072(
      class_259.method_1077(), class_2248.method_9541(2.0, 2.0, 2.0, 14.0, 14.0, 14.0), class_247.field_16886
   );
   protected static final class_265 NORTH_OPENING = class_2248.method_9541(2.0, 2.0, 0.0, 14.0, 14.0, 2.0);
   protected static final class_265 EAST_OPENING = class_2248.method_9541(14.0, 2.0, 2.0, 16.0, 14.0, 14.0);
   protected static final class_265 SOUTH_OPENING = class_2248.method_9541(2.0, 2.0, 14.0, 14.0, 14.0, 16.0);
   protected static final class_265 WEST_OPENING = class_2248.method_9541(0.0, 2.0, 2.0, 2.0, 14.0, 14.0);
   protected static final class_265 UP_OPENING = class_2248.method_9541(2.0, 14.0, 2.0, 14.0, 16.0, 14.0);
   protected static final class_265 DOWN_OPENING = class_2248.method_9541(2.0, 0.0, 2.0, 14.0, 2.0, 14.0);
   protected static final Function<class_2680, class_265> STATE_TO_SHAPE = class_156.method_34866(VentShaftBlock::calculateShape);

   public VentShaftBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)((class_2680)((class_2680)((class_2680)((class_2680)super.method_9564().method_11657(NORTH, true))
                           .method_11657(EAST, true))
                        .method_11657(SOUTH, true))
                     .method_11657(WEST, true))
                  .method_11657(UP, true))
               .method_11657(DOWN, true))
            .method_11657(WATERLOGGED, false)
      );
   }

   private static class_265 calculateShape(class_2680 state) {
      class_265 shape = BASE_SHAPE;

      for (class_2350 direction : class_2350.values()) {
         if (!(Boolean)state.method_11654((class_2769)class_2429.field_11329.get(direction))) {
            shape = class_259.method_1072(shape, getOpeningShape(direction), class_247.field_16886);
         }
      }

      return shape;
   }

   private static class_265 getOpeningShape(class_2350 direction) {
      return switch (direction) {
         case field_11033 -> DOWN_OPENING;
         case field_11036 -> UP_OPENING;
         case field_11043 -> NORTH_OPENING;
         case field_11035 -> SOUTH_OPENING;
         case field_11039 -> WEST_OPENING;
         case field_11034 -> EAST_OPENING;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return STATE_TO_SHAPE.apply(state);
   }

   public class_265 method_9584(class_2680 state, class_1922 world, class_2338 pos) {
      return class_259.method_1077();
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_1937 world = ctx.method_8045();
      class_2338 pos = ctx.method_8037();
      class_2680 state = this.method_9564();
      class_3610 fluidState = world.method_8316(pos);

      for (class_2350 direction : class_2350.values()) {
         if (world.method_8320(pos.method_10093(direction)).method_27852(this)) {
            state = (class_2680)state.method_11657((class_2769)class_2429.field_11329.get(direction), false);
         }
      }

      return (class_2680)state.method_11657(WATERLOGGED, fluidState.method_39360(class_3612.field_15910));
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return neighborState.method_27852(this) ? (class_2680)state.method_11657((class_2769)class_2429.field_11329.get(direction), false) : state;
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{NORTH, EAST, SOUTH, WEST, UP, DOWN, WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
