package doctor4t.spacemod.datagen;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.world.SpaceModBiomes;
import doctor4t.spacemod.index.world.SpaceModChunkGeneratorSettings;
import doctor4t.spacemod.index.world.SpaceModConfiguredFeatures;
import doctor4t.spacemod.index.world.SpaceModDensityFunctions;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import doctor4t.spacemod.index.world.SpaceModNoiseParameters;
import doctor4t.spacemod.index.world.SpaceModPlacedFeatures;
import doctor4t.spacemod.index.world.SpaceModStructureSets;
import doctor4t.spacemod.index.world.SpaceModStructures;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider.Entries;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.class_2378;
import net.minecraft.class_5321;
import net.minecraft.class_5363;
import net.minecraft.class_7877;
import net.minecraft.class_7924;
import net.minecraft.class_7225.class_7226;
import net.minecraft.class_7225.class_7874;

public class SpaceModDatagen implements DataGeneratorEntrypoint {
   public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
      DynamicRegistries.register(class_7924.field_41224, class_5363.field_25411);
      Pack pack = dataGenerator.createPack();
      pack.addProvider(SpaceModelGen::new);
      pack.addProvider(SpaceModBlockTagGen::new);
      pack.addProvider(SpaceModFluidTagGen::new);
      pack.addProvider(SpaceModPaintingVariantTagGen::new);
      pack.addProvider(SpaceModLangGen::new);
      pack.addProvider(SpaceModBlockLootTableGen::new);
      pack.addProvider(SpaceModDatagen.DynamicRegistryGen::new);
   }

   public void buildRegistry(class_7877 registryBuilder) {
      registryBuilder.method_46777(class_7924.field_41244, SpaceModNoiseParameters::bootstrap);
      registryBuilder.method_46777(class_7924.field_41236, SpaceModBiomes::bootstrap);
      registryBuilder.method_46777(class_7924.field_41239, SpaceModConfiguredFeatures::bootstrap);
      registryBuilder.method_46777(class_7924.field_41245, SpaceModPlacedFeatures::bootstrap);
      registryBuilder.method_46777(class_7924.field_41240, SpaceModDensityFunctions::bootstrap);
      registryBuilder.method_46777(class_7924.field_41243, SpaceModChunkGeneratorSettings::bootstrap);
      registryBuilder.method_46777(class_7924.field_41224, SpaceModDimensions::bootstrapDimensionOptions);
      registryBuilder.method_46777(class_7924.field_41241, SpaceModDimensions::bootstrapDimensionTypes);
      registryBuilder.method_46777(class_7924.field_41246, SpaceModStructures::bootstrap);
      registryBuilder.method_46777(class_7924.field_41248, SpaceModStructureSets::bootstrap);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }

   public static class DynamicRegistryGen extends FabricDynamicRegistryProvider {
      public DynamicRegistryGen(FabricDataOutput output, CompletableFuture<class_7874> registriesFuture) {
         super(output, registriesFuture);
      }

      private static <T> void add(Entries entries, class_5321<class_2378<T>> key) {
         entries.addAll((class_7226)entries.getLookup(key));
      }

      protected void configure(class_7874 registries, Entries entries) {
         add(entries, class_7924.field_41244);
         add(entries, class_7924.field_41236);
         add(entries, class_7924.field_41239);
         add(entries, class_7924.field_41245);
         add(entries, class_7924.field_41240);
         add(entries, class_7924.field_41243);
         add(entries, class_7924.field_41224);
         add(entries, class_7924.field_41241);
         add(entries, class_7924.field_41246);
         add(entries, class_7924.field_41248);
      }

      public String method_10321() {
         return "spacemod_dynamic_registry";
      }

      static {
         SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
      }
   }
}
