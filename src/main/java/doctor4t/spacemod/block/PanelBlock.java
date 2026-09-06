package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import java.util.Arrays;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3737;
import net.minecraft.class_4538;
import net.minecraft.class_5778;
import net.minecraft.class_7118;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class PanelBlock extends class_5778 implements class_3737 {
   public static final class_2746 WATERLOGGED = class_2741.field_12508;

   public PanelBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)this.method_9564().method_11657(WATERLOGGED, false));
   }

   public boolean method_9558(class_2680 state, class_4538 world, class_2338 pos) {
      return true;
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_2680 state = super.method_9605(ctx);
      return state == null
         ? null
         : (class_2680)state.method_11657(WATERLOGGED, ctx.method_8045().method_8316(ctx.method_8037()).method_39360(class_3612.field_15910));
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return state;
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   public boolean method_41438(class_1922 world, class_2680 state, class_2338 pos, class_2350 direction) {
      return this.method_33369(direction) && (!state.method_27852(this) || !method_33366(state, direction));
   }

   public boolean method_9616(class_2680 state, class_1750 context) {
      return context.method_8041().method_31574(this.method_8389())
         && Arrays.stream(field_28421).anyMatch(direction -> !method_33366(state, direction))
         && !context.method_8046();
   }

   public class_7118 method_41432() {
      return null;
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      super.method_9515(builder);
      builder.method_11667(new class_2769[]{WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
