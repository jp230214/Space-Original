package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.world.density_function.CraterDensityFunction;
import net.minecraft.class_2378;
import net.minecraft.class_5321;
import net.minecraft.class_6910;
import net.minecraft.class_6916;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import net.minecraft.class_5216.class_5487;

public class SpaceModDensityFunctions {
   public static final class_5321<class_6910> LARGE_CRATERS = create("large_craters");
   public static final class_5321<class_6910> MEDIUM_CRATERS = create("medium_craters");
   public static final class_5321<class_6910> SMALL_CRATERS = create("small_craters");

   public static void bootstrap(class_7891<class_6910> registerable) {
      class_7871<class_5487> noiseLookup = registerable.method_46799(class_7924.field_41244);
      registerCrater(registerable, LARGE_CRATERS, noiseLookup, SpaceModNoiseParameters.LARGE_CRATERS, 24, 0.975F);
      registerCrater(registerable, MEDIUM_CRATERS, noiseLookup, SpaceModNoiseParameters.MEDIUM_CRATERS, 12, 0.9625F);
      registerCrater(registerable, SMALL_CRATERS, noiseLookup, SpaceModNoiseParameters.SMALL_CRATERS, 6, 0.85F);
   }

   public static void registerCrater(
      class_7891<class_6910> registerable,
      class_5321<class_6910> key,
      class_7871<class_5487> noiseLookup,
      class_5321<class_5487> noiseKey,
      int range,
      float threshold
   ) {
      registerable.method_46838(
         key,
         class_6916.method_40499(
            new CraterDensityFunction(class_6916.method_40499(class_6916.method_40493(noiseLookup.method_46747(noiseKey))), range, threshold)
         )
      );
   }

   public static void initialize() {
      class_2378.method_10230(class_7923.field_41160, SpaceMod.id("crater"), CraterDensityFunction.CODEC_HOLDER.comp_640());
   }

   public static class_5321<class_6910> create(String name) {
      return class_5321.method_29179(class_7924.field_41240, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
