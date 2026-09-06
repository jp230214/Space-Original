package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2760;
import net.minecraft.class_2769;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class WalkwayBlock extends class_2248 implements class_3737 {
   public static final class_2754<class_2760> HALF = class_2741.field_12518;
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   protected static final class_265 TOP_SHAPE = class_2248.method_9541(0.0, 13.0, 0.0, 16.0, 16.0, 16.0);
   protected static final class_265 BOTTOM_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);

   public WalkwayBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)super.method_9564().method_11657(HALF, class_2760.field_12619)).method_11657(WATERLOGGED, false));
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_2350 direction = ctx.method_8038();
      class_2760 half = direction == class_2350.field_11036 ? class_2760.field_12617 : class_2760.field_12619;
      if (!ctx.method_7717() && direction.method_10166().method_10179()) {
         half = ctx.method_17698().field_1351 - ctx.method_8037().method_10264() > 0.5 ? class_2760.field_12619 : class_2760.field_12617;
      }

      return (class_2680)((class_2680)this.method_9564().method_11657(HALF, half))
         .method_11657(WATERLOGGED, ctx.method_8045().method_8316(ctx.method_8037()).method_39360(class_3612.field_15910));
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return state.method_11654(HALF) == class_2760.field_12619 ? TOP_SHAPE : BOTTOM_SHAPE;
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
      builder.method_11667(new class_2769[]{HALF, WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
