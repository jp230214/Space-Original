package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_10;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
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

public class GlassPanelBlock extends class_2318 implements class_3737 {
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   public static final class_265 NORTH_SHAPE = class_2248.method_9541(0.0, 0.0, 12.0, 16.0, 16.0, 16.0);
   public static final class_265 NORTH_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
   public static final class_265 EAST_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 4.0, 16.0, 16.0);
   public static final class_265 EAST_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
   public static final class_265 SOUTH_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 16.0, 4.0);
   public static final class_265 SOUTH_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
   public static final class_265 WEST_SHAPE = class_2248.method_9541(12.0, 0.0, 0.0, 16.0, 16.0, 16.0);
   public static final class_265 WEST_COLLISION_SHAPE = class_2248.method_9541(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
   public static final class_265 UP_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);
   public static final class_265 UP_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
   public static final class_265 DOWN_SHAPE = class_2248.method_9541(0.0, 12.0, 0.0, 16.0, 16.0, 16.0);
   public static final class_265 DOWN_COLLISION_SHAPE = class_2248.method_9541(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);

   public GlassPanelBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)super.method_9564().method_11657(WATERLOGGED, false)).method_11657(field_10927, class_2350.field_11035));
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      if (context.method_17785(this.method_8389())) {
         return switch ((class_2350)state.method_11654(field_10927)) {
            case field_11043 -> NORTH_SHAPE;
            case field_11034 -> EAST_SHAPE;
            case field_11035 -> SOUTH_SHAPE;
            case field_11039 -> WEST_SHAPE;
            case field_11036 -> UP_SHAPE;
            case field_11033 -> DOWN_SHAPE;
            default -> throw new IncompatibleClassChangeError();
         };
      } else {
         return this.method_9549(state, world, pos, context);
      }
   }

   public class_265 method_9549(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return switch ((class_2350)state.method_11654(field_10927)) {
         case field_11043 -> NORTH_COLLISION_SHAPE;
         case field_11034 -> EAST_COLLISION_SHAPE;
         case field_11035 -> SOUTH_COLLISION_SHAPE;
         case field_11039 -> WEST_COLLISION_SHAPE;
         case field_11036 -> UP_COLLISION_SHAPE;
         case field_11033 -> DOWN_COLLISION_SHAPE;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   public class_265 method_26159(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return class_259.method_1073();
   }

   public class_265 method_9571(class_2680 state, class_1922 world, class_2338 pos) {
      return class_259.method_1073();
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_1936 world = ctx.method_8045();
      class_2338 pos = ctx.method_8037();
      class_2350 facing = ctx.method_8038();
      class_2680 neighborState = world.method_8320(pos.method_10093(facing.method_10153()));
      if (!ctx.method_8046() && neighborState.method_27852(this)) {
         class_2350 neighborFacing = (class_2350)neighborState.method_11654(field_10927);
         if (!neighborFacing.method_10166().equals(facing.method_10166())) {
            facing = neighborFacing;
         }
      }

      return (class_2680)((class_2680)this.method_9564().method_11657(field_10927, facing))
         .method_11657(WATERLOGGED, world.method_8316(pos).method_15772().equals(class_3612.field_15910));
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_10927, WATERLOGGED});
   }

   public boolean method_9522(class_2680 state, class_2680 stateFrom, class_2350 direction) {
      class_2350 facing = (class_2350)state.method_11654(field_10927);
      if (stateFrom.method_27852(this)) {
         class_2350 fromFacing = (class_2350)stateFrom.method_11654(field_10927);
         if (fromFacing.equals(direction)) {
            return facing.equals(direction.method_10153());
         }

         if (fromFacing.equals(direction.method_10153())) {
            return facing.equals(direction);
         }

         if (fromFacing.equals(facing)) {
            return true;
         }
      }

      return super.method_9522(state, stateFrom, direction);
   }

   public boolean method_9516(class_2680 state, class_1922 world, class_2338 pos, class_10 type) {
      return false;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
