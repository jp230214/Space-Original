package doctor4t.spacemod.world.density_function;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_5699;
import net.minecraft.class_6910;
import net.minecraft.class_7243;
import net.minecraft.class_6910.class_6911;
import net.minecraft.class_6910.class_6912;
import net.minecraft.class_6910.class_6914;
import net.minecraft.class_6910.class_6915;

public class CraterDensityFunction implements class_6910 {
   public static final class_7243<CraterDensityFunction> CODEC_HOLDER = class_7243.method_42115(
      RecordCodecBuilder.create(
         instance -> instance.group(
               class_6910.field_37057.fieldOf("input").forGetter(CraterDensityFunction::getInput),
               class_5699.field_33442.fieldOf("range").forGetter(CraterDensityFunction::getRange),
               class_5699.field_34387.fieldOf("threshold").forGetter(CraterDensityFunction::getThreshold)
            )
            .apply(instance, CraterDensityFunction::new)
      )
   );
   private static final int INCREMENT = 4;
   private final class_6910 input;
   private final int range;
   private final double sqRange;
   private final float threshold;

   public CraterDensityFunction(class_6910 input, int range, float threshold) {
      this.input = input;
      this.range = range;
      this.threshold = threshold;
      this.sqRange = this.range * this.range;
   }

   public double method_40464(class_6912 pos) {
      int sqDist = Integer.MAX_VALUE;
      int blockX = pos.comp_371();
      int blockZ = pos.comp_373();

      for (int x = -this.range; x <= this.range; x++) {
         for (int z = -this.range; z <= this.range; z++) {
            int dist = x * x + z * z;
            if (!(dist > this.sqRange)) {
               class_6914 samplePos = new class_6914(blockX + x * 4, 0, blockZ + z * 4);
               if (!(this.input.method_40464(samplePos) < this.threshold)) {
                  sqDist = Math.min(sqDist, dist);
               }
            }
         }
      }

      return sqDist == Integer.MAX_VALUE ? 0.0 : 1.0 - sqDist / this.sqRange;
   }

   public void method_40470(double[] densities, class_6911 applier) {
      applier.method_40478(densities, this);
   }

   public class_6910 method_40469(class_6915 visitor) {
      return new CraterDensityFunction(this.input.method_40469(visitor), this.range, this.threshold);
   }

   public double comp_377() {
      return 0.0;
   }

   public double comp_378() {
      return 1.0;
   }

   public class_6910 getInput() {
      return this.input;
   }

   public int getRange() {
      return this.range;
   }

   public float getThreshold() {
      return this.threshold;
   }

   public class_7243<? extends class_6910> method_41062() {
      return CODEC_HOLDER;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
