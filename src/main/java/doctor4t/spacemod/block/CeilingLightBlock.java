package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_4538;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class CeilingLightBlock extends class_2248 implements class_3737 {
   public static final class_2754<class_2351> AXIS = class_2741.field_12529;
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   public static final class_265 X_SHAPE = class_2248.method_9541(0.0, 9.0, 6.0, 16.0, 16.0, 10.0);
   public static final class_265 Z_SHAPE = class_2248.method_9541(6.0, 9.0, 0.0, 10.0, 16.0, 16.0);

   public CeilingLightBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)super.method_9564().method_11657(AXIS, class_2351.field_11051)).method_11657(WATERLOGGED, false));
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return state.method_11654(AXIS) == class_2351.field_11048 ? X_SHAPE : Z_SHAPE;
   }

   public boolean method_9558(class_2680 state, class_4538 world, class_2338 pos) {
      class_2338 ceilingPos = pos.method_10084();
      class_2680 ceilingState = world.method_8320(ceilingPos);
      return class_2248.method_9501(ceilingState.method_26222(world, ceilingPos), class_2350.field_11033);
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_3610 fluidState = ctx.method_8045().method_8316(ctx.method_8037());
      return (class_2680)((class_2680)this.method_9564().method_11657(AXIS, ctx.method_8042().method_10166()))
         .method_11657(WATERLOGGED, fluidState.method_39360(class_3612.field_15910));
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return direction == class_2350.field_11036 && !this.method_9558(state, world, pos)
         ? class_2246.field_10124.method_9564()
         : super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{AXIS});
      builder.method_11667(new class_2769[]{WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
