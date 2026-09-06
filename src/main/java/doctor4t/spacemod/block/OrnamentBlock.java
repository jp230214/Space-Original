package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.util.BlockUtils;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_241;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3542;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class OrnamentBlock extends class_2318 implements class_3737 {
   public static final class_2754<OrnamentBlock.OrnamentShape> SHAPE = class_2754.method_11850("shape", OrnamentBlock.OrnamentShape.class);
   public static final class_2746 WATERLOGGED = class_2741.field_12508;

   public OrnamentBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)super.method_9564().method_11657(field_10927, class_2350.field_11043))
               .method_11657(SHAPE, OrnamentBlock.OrnamentShape.CENTER))
            .method_11657(WATERLOGGED, false)
      );
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_2338 pos = ctx.method_8037();
      class_2350 side = ctx.method_8038();
      class_1937 world = ctx.method_8045();
      class_2680 state = world.method_8320(pos);
      class_241 hit = BlockUtils.get2DHit(ctx.method_17698(), pos, side);
      boolean topRight = hit.field_1343 + hit.field_1342 > 1.0F;
      boolean bottomRight = hit.field_1343 - hit.field_1342 > 0.0F;
      boolean center = ctx.method_8046();
      OrnamentBlock.OrnamentShape shape = center
         ? OrnamentBlock.OrnamentShape.CENTER
         : (
            topRight && bottomRight
               ? OrnamentBlock.OrnamentShape.RIGHT
               : (topRight ? OrnamentBlock.OrnamentShape.TOP : (!bottomRight ? OrnamentBlock.OrnamentShape.LEFT : OrnamentBlock.OrnamentShape.BOTTOM))
         );
      if (state.method_27852(this)) {
         OrnamentBlock.OrnamentShape originalShape = (OrnamentBlock.OrnamentShape)state.method_11654(SHAPE);
         OrnamentBlock.OrnamentShape newShape = originalShape.with(shape);
         return originalShape == newShape ? null : (class_2680)state.method_11657(SHAPE, newShape);
      } else {
         class_3610 fluidState = world.method_8316(pos);
         return (class_2680)((class_2680)((class_2680)this.method_9564().method_11657(field_10927, side)).method_11657(SHAPE, shape))
            .method_11657(WATERLOGGED, fluidState.method_39360(class_3612.field_15910));
      }
   }

   public boolean method_9616(class_2680 state, class_1750 context) {
      return context.method_8041().method_31574(this.method_8389()) || super.method_9616(state, context);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return switch ((class_2350)state.method_11654(field_10927)) {
         case field_11043 -> GlassPanelBlock.NORTH_COLLISION_SHAPE;
         case field_11034 -> GlassPanelBlock.EAST_COLLISION_SHAPE;
         case field_11035 -> GlassPanelBlock.SOUTH_COLLISION_SHAPE;
         case field_11039 -> GlassPanelBlock.WEST_COLLISION_SHAPE;
         case field_11036 -> GlassPanelBlock.UP_COLLISION_SHAPE;
         case field_11033 -> GlassPanelBlock.DOWN_COLLISION_SHAPE;
         default -> throw new IncompatibleClassChangeError();
      };
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
      builder.method_11667(new class_2769[]{field_10927, SHAPE, WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }

   public enum OrnamentShape implements class_3542 {
      LEFT("left", 16),
      RIGHT("right", 8),
      TOP("top", 4),
      BOTTOM("bottom", 2),
      CENTER("center", 1),
      LEFT_RIGHT("left_right", 24),
      LEFT_RIGHT_CENTER("left_right_center", 25),
      LEFT_TOP("left_top", 20),
      LEFT_BOTTOM("left_bottom", 18),
      RIGHT_TOP("right_top", 12),
      RIGHT_BOTTOM("right_bottom", 10),
      TOP_BOTTOM("top_bottom", 6),
      LEFT_RIGHT_TOP("left_right_top", 28),
      LEFT_RIGHT_BOTTOM("left_right_bottom", 26),
      LEFT_TOP_BOTTOM("left_top_bottom", 22),
      RIGHT_TOP_BOTTOM("right_top_bottom", 14),
      ALL("all", 30);

      private final String name;
      private final int flags;

      OrnamentShape(String name, int flags) {
         this.name = name;
         this.flags = flags;
      }

      public OrnamentBlock.OrnamentShape with(OrnamentBlock.OrnamentShape shape) {
         int combinedFlags = this.flags | shape.flags;

         for (OrnamentBlock.OrnamentShape ornamentShape : values()) {
            if (ornamentShape.flags == combinedFlags) {
               return ornamentShape;
            }
         }

         return this;
      }

      public int getCount() {
         return (this.flags & 1) + (this.flags >> 1 & 1) + (this.flags >> 2 & 1) + (this.flags >> 3 & 1) + (this.flags >> 4 & 1);
      }

      public String method_15434() {
         return this.name;
      }

      static {
         SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
      }
   }
}
