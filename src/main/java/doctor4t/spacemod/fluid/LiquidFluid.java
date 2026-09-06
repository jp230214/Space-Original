package doctor4t.spacemod.fluid;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3576;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_2350.class_2353;
import net.minecraft.class_2689.class_2690;

public class LiquidFluid extends class_3576 {
   public static final class_2758 LEVEL = LiquidBlock.LEVEL;

   public LiquidFluid() {
      this.method_15781((class_3610)super.method_15785().method_11657(LEVEL, 64));
   }

   public class_3610 withLevel(int level) {
      return (class_3610)this.method_15785().method_11657(LEVEL, level);
   }

   public class_243 method_15782(class_1922 world, class_2338 pos, class_3610 state) {
      double velocityX = 0.0;
      double velocityZ = 0.0;
      double height = this.method_15788(state, world, pos);
      class_2680 aboveState = world.method_8320(pos.method_10084());

      for (class_2350 direction : class_2353.field_11062) {
         double neighborHeight = this.getNeighborHeight(world, pos.method_10093(direction), height);
         double downwardsFlow = this.downwardsFlow(world, pos.method_10093(direction).method_10074()) ? 0.5 : 0.0;
         double aboveFlow = height != 1.0 && this.aboveFlow(world, pos.method_10093(direction).method_10084(), aboveState) ? 0.5 : 0.0;
         double difference = height - neighborHeight + downwardsFlow - aboveFlow;
         if (!(Math.abs(difference) <= 0.015625)) {
            velocityX += direction.method_10148() * difference;
            velocityZ += direction.method_10165() * difference;
         }
      }

      return new class_243(velocityX, 0.0, velocityZ).method_1029().method_1021(height);
   }

   protected double getNeighborHeight(class_1922 world, class_2338 pos, double height) {
      class_3610 fluidState = world.method_8316(pos);
      if (fluidState.method_39360(this)) {
         return fluidState.method_15763(world, pos);
      }

      class_2680 state = world.method_8320(pos);
      return !state.method_45474() && !state.method_26215() ? height : 0.0;
   }

   protected boolean downwardsFlow(class_1922 world, class_2338 pos) {
      class_3610 fluidState = world.method_8316(pos);
      if (fluidState.method_39360(this)) {
         return fluidState.method_15763(world, pos) < 1.0F;
      }

      class_2680 state = world.method_8320(pos);
      return state.method_26215() || state.method_45474();
   }

   protected boolean aboveFlow(class_1922 world, class_2338 aboveSidePos, class_2680 aboveState) {
      return !aboveState.method_45474() && !aboveState.method_26215() ? false : world.method_8316(aboveSidePos).method_39360(this);
   }

   protected boolean aboveFluidMatches(class_3610 state, class_1922 world, class_2338 pos) {
      return state.method_39360(world.method_8316(pos.method_10084()).method_15772());
   }

   public int method_15779(class_3610 state) {
      return (Integer)state.method_11654(LEVEL);
   }

   public boolean method_15793(class_3610 state) {
      return true;
   }

   public float method_20784(class_3610 state) {
      return this.method_15779(state) / 64.0F;
   }

   public float method_15788(class_3610 state, class_1922 world, class_2338 pos) {
      int level = this.method_15779(state);
      return level != 64 && !this.aboveFluidMatches(state, world, pos) ? level / 64.0F : 1.0F;
   }

   public class_265 method_17775(class_3610 state, class_1922 world, class_2338 pos) {
      int level = this.method_15779(state);
      return level != 64 && !this.aboveFluidMatches(state, world, pos) ? LiquidBlock.SHAPES[level - 1] : class_259.method_1077();
   }

   protected void method_15775(class_2690<class_3611, class_3610> builder) {
      builder.method_11667(new class_2769[]{LEVEL});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
