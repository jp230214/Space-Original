package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModFluids;
import doctor4t.spacemod.particle.FlowParticleEffect;
import doctor4t.spacemod.util.liquid.Liquid;
import doctor4t.spacemod.util.liquid.LiquidState;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3532;
import net.minecraft.class_3610;
import net.minecraft.class_3726;
import net.minecraft.class_5819;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_2350.class_2353;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class LiquidBlock extends class_2248 {
   public static final class_265[] SHAPES = createShapes();
   public static final class_2758 LEVEL = class_2758.method_11867("level", 1, 64);
   private static final Map<Liquid, LiquidBlock> LIQUID_FROM_BLOCK = new HashMap<>();
   private final Liquid liquid;

   public LiquidBlock(Liquid liquid, class_2251 settings) {
      super(settings);
      this.liquid = liquid;
      this.method_9590((class_2680)super.method_9564().method_11657(LEVEL, 64));
      LIQUID_FROM_BLOCK.put(liquid, this);
   }

   @Nullable
   public static LiquidBlock fromLiquid(Liquid liquid) {
      return LIQUID_FROM_BLOCK.getOrDefault(liquid, null);
   }

   public static class_265[] createShapes() {
      class_265[] shapes = new class_265[64];

      for (int i = 0; i < 64; i++) {
         shapes[i] = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, (i + 1) / 4.0F, 16.0);
      }

      return shapes;
   }

   public Liquid getLiquid() {
      return this.liquid;
   }

   public int getFlowRate(class_1922 world, class_2338 pos) {
      return this.getLiquid().getFlowRate();
   }

   public LiquidState getLiquidState(class_1922 world, class_2338 pos, class_2680 state) {
      return LiquidState.of(this.liquid, (Integer)state.method_11654(LEVEL));
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return !context.method_17785(this.method_8389()) && !context.method_17785(class_1802.field_8688)
         ? class_259.method_1073()
         : SHAPES[state.method_11654(LEVEL) - 1];
   }

   public class_265 method_9549(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return class_259.method_1073();
   }

   public boolean method_9579(class_2680 state, class_1922 world, class_2338 pos) {
      return true;
   }

   public void method_9615(class_2680 state, class_1937 world, class_2338 pos, class_2680 oldState, boolean notify) {
      world.method_39279(pos, this, this.getFlowRate(world, pos));
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      world.method_39279(pos, this, this.getFlowRate(world, pos));
      return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   public class_3610 method_9545(class_2680 state) {
      return SpaceModFluids.LIQUID.withLevel((Integer)state.method_11654(LEVEL));
   }

   public void method_9588(class_2680 state, class_3218 world, class_2338 pos, class_5819 random) {
      int level = (Integer)state.method_11654(LEVEL);
      if (!this.tryFlowDown(world, pos, pos, state, level, class_2350.field_11033)) {
         for (class_2350 direction : class_2353.field_11062.method_43342(random)) {
            class_2338 flowPos = pos.method_10093(direction);
            class_2680 flowState = world.method_8320(flowPos);
            if (flowState.method_27852(this)) {
               int flowLevel = (Integer)flowState.method_11654(LEVEL);
               if (flowLevel + 1 < level) {
                  this.flow(world, pos, state, flowPos, (level + flowLevel) / 2.0F);
                  return;
               }
            } else if (this.canFlowTo(flowState)) {
               if (this.tryFlowDown(world, pos, flowPos, state, level, direction)) {
                  return;
               }

               this.flow(world, pos, state, flowPos, level / 2.0F);
               return;
            }
         }
      }
   }

   public boolean tryFlowDown(class_3218 world, class_2338 sourcePos, class_2338 pos, class_2680 state, int level, class_2350 direction) {
      class_2339 belowPos = pos.method_25503();

      while (!world.method_31606(belowPos.method_10074()) && this.canFlowOrMerge(world.method_8320(belowPos.method_10074()))) {
         belowPos.method_10098(class_2350.field_11033);
      }

      class_2680 belowState = world.method_8320(belowPos);
      if (world.method_31606(belowPos.method_10074())) {
         world.method_8652(sourcePos, class_2246.field_10124.method_9564(), 3);
         this.spawnFlowParticle(world, pos, direction, belowPos, level);
         return true;
      }

      if (pos.equals(belowPos)) {
         return false;
      }

      if (this.canFlowTo(belowState)) {
         this.flowDown(world, sourcePos, pos, state, belowPos, level, 0, direction);
         return true;
      }

      if (belowState.method_27852(this)) {
         int belowLevel = (Integer)belowState.method_11654(LEVEL);
         if (belowLevel < 64) {
            this.flowDown(world, sourcePos, pos, state, belowPos, level, (Integer)belowState.method_11654(LEVEL), direction);
            return true;
         }
      }

      return false;
   }

   public void flowDown(
      class_3218 world, class_2338 pos, class_2338 particlePos, class_2680 state, class_2338 belowPos, int level, int belowLevel, class_2350 direction
   ) {
      if (belowLevel < 64 && level > 0) {
         int combinedLevel = level + belowLevel;
         if (combinedLevel <= 64) {
            world.method_8652(pos, class_2246.field_10124.method_9564(), 3);
            world.method_8652(belowPos, (class_2680)state.method_11657(LEVEL, combinedLevel), 3);
         } else {
            world.method_8652(pos, (class_2680)state.method_11657(LEVEL, combinedLevel % 64), 3);
            world.method_39279(pos, this, this.getFlowRate(world, pos));
            world.method_8652(belowPos, (class_2680)state.method_11657(LEVEL, 64), 3);
         }

         world.method_39279(belowPos, this, this.getFlowRate(world, pos));
         this.spawnFlowParticle(world, particlePos, direction, belowPos, level);
      }
   }

   public void flow(class_3218 world, class_2338 pos, class_2680 state, class_2338 flowPos, float level) {
      int newLevel = class_3532.method_15386(level);
      int flowLevel = class_3532.method_15375(level);
      if (newLevel <= 0) {
         world.method_8652(pos, class_2246.field_10124.method_9564(), 3);
      } else {
         world.method_8652(pos, (class_2680)state.method_11657(LEVEL, newLevel), 3);
         world.method_39279(pos, this, this.getFlowRate(world, pos));
      }

      if (flowLevel <= 0) {
         world.method_8652(flowPos, class_2246.field_10124.method_9564(), 3);
      } else {
         world.method_8652(flowPos, (class_2680)state.method_11657(LEVEL, flowLevel), 3);
         world.method_39279(flowPos, this, this.getFlowRate(world, pos));
      }
   }

   public boolean canFlowTo(class_2680 state) {
      return (state.method_26215() || state.method_45474()) && !(state.method_26204() instanceof LiquidBlock);
   }

   public boolean canFlowOrMerge(class_2680 state) {
      return state.method_27852(this) && (Integer)state.method_11654(LEVEL) != 64 || this.canFlowTo(state);
   }

   public void spawnFlowParticle(class_3218 world, class_2338 pos, class_2350 direction, class_2338 destination, int level) {
      if (pos.method_10264() - destination.method_10264() > 1 && !world.method_8320(pos).method_27852(this)) {
         double y = pos.method_10264() + class_3532.method_15350(level / 64.0, 0.15, 0.85);
         world.method_14199(
            new FlowParticleEffect(this.getLiquid().getFlowParticle(), direction, destination),
            pos.method_10263() + 0.5,
            y,
            pos.method_10260() + 0.5,
            1,
            0.0,
            0.0,
            0.0,
            0.0
         );
      }
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{LEVEL});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
