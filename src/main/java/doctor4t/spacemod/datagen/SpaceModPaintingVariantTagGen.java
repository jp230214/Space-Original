package doctor4t.spacemod.datagen;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModPaintingVariants;
import doctor4t.spacemod.index.tag.SpaceModPaintingVariantTags;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_1535;
import net.minecraft.class_7406;
import net.minecraft.class_7924;
import net.minecraft.class_7225.class_7874;

public class SpaceModPaintingVariantTagGen extends FabricTagProvider<class_1535> {
   public SpaceModPaintingVariantTagGen(FabricDataOutput output, CompletableFuture<class_7874> registriesFuture) {
      super(output, class_7924.field_41209, registriesFuture);
   }

   protected void method_10514(class_7874 arg) {
      this.getOrCreateTagBuilder(SpaceModPaintingVariantTags.FROM_REACH_FOR_THE_STARS)
         .add(SpaceModPaintingVariants.MARIANNE)
         .add(SpaceModPaintingVariants.MAUVE)
         .add(SpaceModPaintingVariants.VANITY)
         .add(SpaceModPaintingVariants.TWINS)
         .add(SpaceModPaintingVariants.LUXURY_JOURNEY)
         .add(SpaceModPaintingVariants.LE_BALLON);
      this.getOrCreateTagBuilder(class_7406.field_38929).forceAddTag(SpaceModPaintingVariantTags.FROM_REACH_FOR_THE_STARS);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
