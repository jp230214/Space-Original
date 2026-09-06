package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2341;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2738;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_3965;
import net.minecraft.class_4538;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class VentHatchBlock extends class_2341 implements class_3737 {
   public static final class_2746 OPEN = class_2741.field_12537;
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   protected static final class_265 NORTH_SHAPE = class_2248.method_9541(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
   protected static final class_265 EAST_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
   protected static final class_265 SOUTH_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
   protected static final class_265 WEST_SHAPE = class_2248.method_9541(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
   protected static final class_265 UP_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
   protected static final class_265 DOWN_SHAPE = class_2248.method_9541(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);

   public VentHatchBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)super.method_9564().method_11657(OPEN, false)).method_11657(WATERLOGGED, false));
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      boolean open = (Boolean)state.method_11654(OPEN);
      world.method_8501(pos, (class_2680)state.method_11657(OPEN, !open));
      class_3414 sound = open ? class_3417.field_15131 : class_3417.field_15082;
      world.method_8396(null, pos, sound, class_3419.field_15245, 1.0F, 1.125F);
      return class_1269.method_29236(world.field_9236);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      if ((Boolean)state.method_11654(OPEN)) {
         class_2738 face = (class_2738)state.method_11654(field_11007);
         class_2350 facing = (class_2350)state.method_11654(field_11177);

         return switch (face) {
            case field_12473 -> this.getShapeForState((class_2680)state.method_11657(field_11007, class_2738.field_12471));
            case field_12471 -> DOWN_SHAPE;
            case field_12475 -> this.getShapeForState(
               (class_2680)((class_2680)state.method_11657(field_11177, facing.method_10153())).method_11657(field_11007, class_2738.field_12471)
            );
            default -> throw new IncompatibleClassChangeError();
         };
      } else {
         return this.getShapeForState(state);
      }
   }

   public class_265 getShapeForState(class_2680 state) {
      return switch (method_10119(state)) {
         case field_11033 -> DOWN_SHAPE;
         case field_11036 -> UP_SHAPE;
         case field_11043 -> NORTH_SHAPE;
         case field_11035 -> SOUTH_SHAPE;
         case field_11039 -> WEST_SHAPE;
         case field_11034 -> EAST_SHAPE;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_2680 state = super.method_9605(ctx);
      if (state == null) {
         return null;
      }

      class_3610 fluidState = ctx.method_8045().method_8316(ctx.method_8037());
      return (class_2680)state.method_11657(WATERLOGGED, fluidState.method_39360(class_3612.field_15910));
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   public boolean method_9558(class_2680 state, class_4538 world, class_2338 pos) {
      return true;
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_11007, field_11177, OPEN, WATERLOGGED});
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
