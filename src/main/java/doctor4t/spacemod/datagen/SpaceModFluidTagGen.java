package doctor4t.spacemod.datagen;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModFluids;
import doctor4t.spacemod.index.tag.SpaceModFluidTags;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.FluidTagProvider;
import net.minecraft.class_7225.class_7874;

public class SpaceModFluidTagGen extends FluidTagProvider {
   public SpaceModFluidTagGen(FabricDataOutput output, CompletableFuture<class_7874> completableFuture) {
      super(output, completableFuture);
   }

   protected void method_10514(class_7874 arg) {
      this.getOrCreateTagBuilder(SpaceModFluidTags.LIQUIDS).add(SpaceModFluids.LIQUID);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
