package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2465;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;

public class BarBlock extends class_2465 implements class_3737 {
   public static final class_2746 TOP = class_2746.method_11825("top");
   public static final class_2746 BOTTOM = class_2746.method_11825("bottom");
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   protected static final class_265 X_SHAPE = class_2248.method_9541(0.0, 6.0, 6.0, 16.0, 10.0, 10.0);
   protected static final class_265 Y_SHAPE = class_2248.method_9541(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
   protected static final class_265 Z_SHAPE = class_2248.method_9541(6.0, 6.0, 0.0, 10.0, 10.0, 16.0);

   public BarBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)((class_2680)super.method_9564().method_11657(field_11459, class_2351.field_11052)).method_11657(TOP, true))
               .method_11657(BOTTOM, true))
            .method_11657(WATERLOGGED, false)
      );
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      class_2351 axis = (class_2351)state.method_11654(field_11459);
      return direction.method_10166() == axis
         ? (class_2680)state.method_11657(direction == this.getTopDirection(axis) ? TOP : BOTTOM, !this.isConnectedBar(neighborState, axis))
         : super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   public class_2680 method_9605(class_1750 ctx) {
      class_1937 world = ctx.method_8045();
      class_2338 pos = ctx.method_8037();
      class_2351 axis = ctx.method_8038().method_10166();
      class_2350 topDirection = this.getTopDirection(axis);
      return (class_2680)((class_2680)((class_2680)((class_2680)this.method_9564().method_11657(field_11459, ctx.method_8038().method_10166()))
               .method_11657(TOP, !this.isConnectedBar(world.method_8320(pos.method_10093(topDirection)), axis)))
            .method_11657(BOTTOM, !this.isConnectedBar(world.method_8320(pos.method_10093(topDirection.method_10153())), axis)))
         .method_11657(WATERLOGGED, world.method_8316(pos).method_39360(class_3612.field_15910));
   }

   protected boolean isConnectedBar(class_2680 state, class_2351 axis) {
      return state.method_27852(this) && state.method_11654(field_11459) == axis;
   }

   protected class_2350 getTopDirection(class_2351 axis) {
      return switch (axis) {
         case field_11048 -> class_2350.field_11034;
         case field_11052 -> class_2350.field_11036;
         case field_11051 -> class_2350.field_11035;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return switch ((class_2351)state.method_11654(field_11459)) {
         case field_11048 -> X_SHAPE;
         case field_11052 -> Y_SHAPE;
         case field_11051 -> Z_SHAPE;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_11459, TOP, BOTTOM, WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
