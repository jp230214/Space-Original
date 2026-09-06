package doctor4t.spacemod.util.liquid;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.index.SpaceModRegistries;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.class_156;
import net.minecraft.class_2246;
import net.minecraft.class_2680;
import net.minecraft.class_5699;
import net.minecraft.class_6862;
import org.jetbrains.annotations.Nullable;

public class SingleLiquidState implements LiquidState {
   static final Int2ObjectMap<SingleLiquidState> CACHE = (Int2ObjectMap<SingleLiquidState>)class_156.method_654(
      new Int2ObjectOpenHashMap(), map -> map.defaultReturnValue(null)
   );
   static final Comparator<SingleLiquidState> COMPARATOR = Collections.reverseOrder(Comparator.comparing(state -> state.getLiquid().getDensity()));
   public static Codec<SingleLiquidState> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
            SpaceModRegistries.LIQUID.method_39673().fieldOf("liquid").forGetter(SingleLiquidState::getLiquid),
            class_5699.method_48766(1, 64).fieldOf("level").forGetter(SingleLiquidState::getLevel)
         )
         .apply(instance, LiquidState::of)
   );
   private final Liquid liquid;
   private final int level;

   SingleLiquidState(Liquid liquid, int level) {
      this.liquid = liquid;
      this.level = level;
      this.validate();
   }

   public static int getCacheId(Liquid liquid, int level) {
      return SpaceModRegistries.LIQUID.method_10206(liquid) << 6 | level - 1 & 63;
   }

   @Override
   public Collection<Liquid> getLiquids() {
      return List.of(this.liquid);
   }

   @Override
   public Liquid getLiquidAt(int level) {
      return this.liquid;
   }

   @Override
   public boolean isOf(Liquid liquid) {
      return this.liquid == liquid;
   }

   @Override
   public boolean isIn(class_6862<Liquid> tagKey) {
      return this.liquid.getRegistryEntry().method_40220(tagKey);
   }

   @Override
   public int getFlowRate() {
      return this.liquid.getFlowRate();
   }

   @Override
   public int getLevel() {
      return this.level;
   }

   @Nullable
   @Override
   public LiquidBlock getBlock() {
      return this.liquid.getBlock();
   }

   @Override
   public class_2680 getBlockState() {
      LiquidBlock liquidBlock = this.getBlock();
      return liquidBlock == null
         ? class_2246.field_10124.method_9564()
         : (class_2680)liquidBlock.method_9564().method_11657(LiquidBlock.LEVEL, this.getLevel());
   }

   public Liquid getLiquid() {
      return this.liquid;
   }

   @Override
   public LiquidState withLevel(int level) {
      return LiquidState.of(this.liquid, level);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
