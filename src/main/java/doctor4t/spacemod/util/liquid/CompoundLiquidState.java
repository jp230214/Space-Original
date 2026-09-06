package doctor4t.spacemod.util.liquid;

import com.mojang.serialization.Codec;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.class_2246;
import net.minecraft.class_2680;
import net.minecraft.class_6862;
import org.jetbrains.annotations.Nullable;

public class CompoundLiquidState implements LiquidState {
   public static final Codec<CompoundLiquidState> CODEC = SingleLiquidState.CODEC.listOf().xmap(LiquidState::of, CompoundLiquidState::getLiquidStates);
   private final List<SingleLiquidState> liquidStates;
   private int level = 0;
   private int flowRate = 0;

   CompoundLiquidState(List<SingleLiquidState> liquidStates) {
      this.liquidStates = liquidStates;
      this.validateLiquidStates();
      this.sort();
      this.updateValues();
      this.validate();
   }

   protected void sort() {
      List<SingleLiquidState> list = new ArrayList<>(this.liquidStates);
      this.liquidStates.clear();
      list.sort(SingleLiquidState.COMPARATOR);
      int j = -1;

      for (SingleLiquidState state : list) {
         if (j > -1) {
            SingleLiquidState lastState = this.liquidStates.get(j);
            if (lastState.isOf(state.getLiquid())) {
               this.liquidStates.set(j, LiquidState.of(lastState.getLiquid(), lastState.getLevel() + state.getLevel()));
               continue;
            }
         }

         this.liquidStates.add(state);
         j++;
      }
   }

   protected void updateValues() {
      this.level = 0;
      this.flowRate = Integer.MAX_VALUE;

      for (SingleLiquidState state : this.liquidStates) {
         this.level = this.level + state.getLevel();
         this.flowRate = Math.min(this.flowRate, state.getFlowRate());
      }
   }

   @Override
   public Collection<Liquid> getLiquids() {
      return this.liquidStates.stream().map(SingleLiquidState::getLiquid).toList();
   }

   @Override
   public Liquid getLiquidAt(int level) {
      if (level > this.getLevel()) {
         return this.liquidStates.get(this.liquidStates.size() - 1).getLiquid();
      }

      int i = 0;

      for (SingleLiquidState state : this.liquidStates) {
         i += state.getLevel();
         if (level <= i) {
            return state.getLiquid();
         }
      }

      return this.liquidStates.get(0).getLiquid();
   }

   @Override
   public boolean isOf(Liquid liquid) {
      return this.liquidStates.stream().anyMatch(state -> state.isOf(liquid));
   }

   @Override
   public boolean isIn(class_6862<Liquid> tagKey) {
      return this.liquidStates.stream().anyMatch(state -> state.isIn(tagKey));
   }

   @Override
   public int getFlowRate() {
      return this.flowRate;
   }

   @Override
   public int getLevel() {
      return this.level;
   }

   @Nullable
   @Override
   public LiquidBlock getBlock() {
      return null;
   }

   @Override
   public class_2680 getBlockState() {
      return class_2246.field_10124.method_9564();
   }

   @Override
   public LiquidState withLevel(int level) {
      SingleLiquidState firstState = this.liquidStates.get(0);
      if (level <= firstState.getLevel()) {
         return firstState.withLevel(level);
      }

      List<SingleLiquidState> list = new ArrayList<>();
      list.add(firstState);
      int currentLevel = firstState.getLevel();
      int prevLevel = currentLevel;

      for (int i = 1; i < this.liquidStates.size(); i++) {
         SingleLiquidState state = this.liquidStates.get(i);
         currentLevel += state.getLevel();
         if (currentLevel == level) {
            list.add(state);
            break;
         }

         if (currentLevel > level) {
            list.add(LiquidState.of(state.getLiquid(), level - prevLevel));
            break;
         }

         list.add(state);
         prevLevel = currentLevel;
      }

      return LiquidState.of(list);
   }

   public List<SingleLiquidState> getLiquidStates() {
      return this.liquidStates;
   }

   @Override
   public void validate() {
      LiquidState.super.validate();
      this.validateLiquidStates();
   }

   protected void validateLiquidStates() {
      if (this.liquidStates.isEmpty()) {
         throw new IllegalArgumentException("Liquid States must not be empty");
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
