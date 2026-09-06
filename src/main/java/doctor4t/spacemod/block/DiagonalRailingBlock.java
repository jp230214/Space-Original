package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2510;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2746;
import net.minecraft.class_2760;
import net.minecraft.class_2769;
import net.minecraft.class_2778;
import net.minecraft.class_3726;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class DiagonalRailingBlock extends AbstractRailingBlock {
   public static final class_2746 LEFT = class_2746.method_11825("left");
   protected static final class_265 NORTH_LEFT_SHAPE = createShape(16, 8, 2, 0, 0, 8, 0);
   protected static final class_265 NORTH_RIGHT_SHAPE = createShape(16, 8, 2, 8, 0, 0, 0);
   protected static final class_265 EAST_LEFT_SHAPE = createShape(16, 2, 8, 14, 0, 14, 8);
   protected static final class_265 EAST_RIGHT_SHAPE = createShape(16, 2, 8, 14, 8, 14, 0);
   protected static final class_265 SOUTH_LEFT_SHAPE = createShape(16, 8, 2, 8, 14, 0, 14);
   protected static final class_265 SOUTH_RIGHT_SHAPE = createShape(16, 8, 2, 0, 14, 8, 14);
   protected static final class_265 WEST_LEFT_SHAPE = createShape(16, 2, 8, 0, 8, 0, 0);
   protected static final class_265 WEST_RIGHT_SHAPE = createShape(16, 2, 8, 0, 0, 0, 8);
   protected static final class_265 NORTH_LEFT_COLLISION_SHAPE = createShape(24, 8, 2, 0, 0, 8, 0);
   protected static final class_265 NORTH_RIGHT_COLLISION_SHAPE = createShape(24, 8, 2, 8, 0, 0, 0);
   protected static final class_265 EAST_LEFT_COLLISION_SHAPE = createShape(24, 2, 8, 14, 0, 14, 8);
   protected static final class_265 EAST_RIGHT_COLLISION_SHAPE = createShape(24, 2, 8, 14, 8, 14, 0);
   protected static final class_265 SOUTH_LEFT_COLLISION_SHAPE = createShape(24, 8, 2, 8, 14, 0, 14);
   protected static final class_265 SOUTH_RIGHT_COLLISION_SHAPE = createShape(24, 8, 2, 0, 14, 8, 14);
   protected static final class_265 WEST_LEFT_COLLISION_SHAPE = createShape(24, 2, 8, 0, 8, 0, 0);
   protected static final class_265 WEST_RIGHT_COLLISION_SHAPE = createShape(24, 2, 8, 0, 0, 0, 8);

   public DiagonalRailingBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)super.method_9564().method_11657(LEFT, false));
   }

   protected static class_265 createShape(int height, int sizeX, int sizeZ, int x1, int z1, int x2, int z2) {
      return class_259.method_1084(
         class_2248.method_9541(x1, 0.0, z1, x1 + sizeX, height, z1 + sizeZ), class_2248.method_9541(x2, -8.0, z2, x2 + sizeX, height - 8, z2 + sizeZ)
      );
   }

   @Nullable
   @Override
   public class_2680 method_9605(class_1750 ctx) {
      class_2680 state = super.method_9605(ctx);
      if (state == null) {
         return null;
      }

      class_2350 facing = (class_2350)state.method_11654(field_11177);
      class_2680 stairsState = ctx.method_8045().method_8320(ctx.method_8037().method_10074());
      if (stairsState.method_26204() instanceof class_2510) {
         if (stairsState.method_11654(class_2510.field_11572) == class_2760.field_12619) {
            return null;
         }

         class_2350 stairsFacing = (class_2350)stairsState.method_11654(class_2510.field_11571);
         class_2778 shape = (class_2778)stairsState.method_11654(class_2510.field_11565);
         if (stairsFacing.method_10170() == facing) {
            if (shape != class_2778.field_12713 && shape != class_2778.field_12708) {
               return (class_2680)state.method_11657(LEFT, true);
            }
         } else if (stairsFacing.method_10160() == facing) {
            if (shape != class_2778.field_12712 && shape != class_2778.field_12709) {
               return (class_2680)state.method_11657(LEFT, false);
            }
         } else if (stairsFacing == facing) {
            if (shape == class_2778.field_12708) {
               return (class_2680)state.method_11657(LEFT, true);
            }

            if (shape == class_2778.field_12709) {
               return (class_2680)state.method_11657(LEFT, false);
            }
         } else if (stairsFacing.method_10153() == facing) {
            if (shape == class_2778.field_12712) {
               return (class_2680)state.method_11657(LEFT, false);
            }

            if (shape == class_2778.field_12713) {
               return (class_2680)state.method_11657(LEFT, true);
            }
         }
      } else if (stairsState.method_26204() instanceof TrimmedStairsBlock) {
         class_2350 stairsFacing = (class_2350)stairsState.method_11654(TrimmedStairsBlock.field_11177);
         if (stairsFacing.method_10170() == facing) {
            return (class_2680)state.method_11657(LEFT, false);
         }

         if (stairsFacing.method_10160() == facing) {
            return (class_2680)state.method_11657(LEFT, true);
         }
      }

      return null;
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      if ((Boolean)state.method_11654(LEFT)) {
         return switch ((class_2350)state.method_11654(field_11177)) {
            case field_11043 -> NORTH_LEFT_SHAPE;
            case field_11034 -> EAST_LEFT_SHAPE;
            case field_11035 -> SOUTH_LEFT_SHAPE;
            default -> WEST_LEFT_SHAPE;
         };
      } else {
         return switch ((class_2350)state.method_11654(field_11177)) {
            case field_11043 -> NORTH_RIGHT_SHAPE;
            case field_11034 -> EAST_RIGHT_SHAPE;
            case field_11035 -> SOUTH_RIGHT_SHAPE;
            default -> WEST_RIGHT_SHAPE;
         };
      }
   }

   public class_265 method_9549(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      if ((Boolean)state.method_11654(LEFT)) {
         return switch ((class_2350)state.method_11654(field_11177)) {
            case field_11043 -> NORTH_LEFT_COLLISION_SHAPE;
            case field_11034 -> EAST_LEFT_COLLISION_SHAPE;
            case field_11035 -> SOUTH_LEFT_COLLISION_SHAPE;
            default -> WEST_LEFT_COLLISION_SHAPE;
         };
      } else {
         return switch ((class_2350)state.method_11654(field_11177)) {
            case field_11043 -> NORTH_RIGHT_COLLISION_SHAPE;
            case field_11034 -> EAST_RIGHT_COLLISION_SHAPE;
            case field_11035 -> SOUTH_RIGHT_COLLISION_SHAPE;
            default -> WEST_RIGHT_COLLISION_SHAPE;
         };
      }
   }

   @Override
   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{LEFT});
      super.method_9515(builder);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
