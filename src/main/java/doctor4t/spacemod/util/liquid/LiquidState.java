package doctor4t.spacemod.util.liquid;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;

import doctor4t.spacemod.block.LiquidBlock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import net.minecraft.class_2680;
import net.minecraft.class_3902;
import net.minecraft.class_5699;
import net.minecraft.class_6862;
import org.jetbrains.annotations.Nullable;

public interface LiquidState {
   Codec<LiquidState> CODEC = class_5699.method_33817(SingleLiquidState.CODEC, CompoundLiquidState.CODEC)
      .xmap(
         either -> (LiquidState)either.map(Function.identity(), Function.identity()),
         state -> state instanceof SingleLiquidState singleLiquidState ? Either.left(singleLiquidState) : Either.right((CompoundLiquidState)state)
      );
   Codec<Either<class_3902, LiquidState>> EITHER_CODEC = Codec.either(Codec.unit(class_3902.field_17274), CODEC);

   static SingleLiquidState of(Liquid liquid, int level) {
      int id = SingleLiquidState.getCacheId(liquid, level);
      SingleLiquidState singleLiquidState = (SingleLiquidState)SingleLiquidState.CACHE.get(id);
      if (singleLiquidState == null) {
         SingleLiquidState state = new SingleLiquidState(liquid, level);
         SingleLiquidState.CACHE.put(id, state);
         return state;
      } else {
         return singleLiquidState;
      }
   }

   static CompoundLiquidState of(List<SingleLiquidState> liquidStates) {
      return new CompoundLiquidState(new ArrayList<>(liquidStates));
   }

   static CompoundLiquidState of(SingleLiquidState... liquidStates) {
      return of(Arrays.asList(liquidStates));
   }

   Collection<Liquid> getLiquids();

   Liquid getLiquidAt(int var1);

   boolean isOf(Liquid var1);

   boolean isIn(class_6862<Liquid> var1);

   int getFlowRate();

   int getLevel();

   LiquidState withLevel(int var1);

   @Nullable
   LiquidBlock getBlock();

   class_2680 getBlockState();

   default void validate() {
      int level = this.getLevel();
      if (level < 1 || level > 64) {
         throw new IllegalArgumentException("Liquid State of level " + level + " must have a level between 1 and 64");
      }
   }


}
