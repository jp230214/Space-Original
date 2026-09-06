package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.world.SpaceModBiomes;
import net.minecraft.class_1959;
import net.minecraft.class_2378;
import net.minecraft.class_2680;
import net.minecraft.class_2791;
import net.minecraft.class_4543;
import net.minecraft.class_5868;
import net.minecraft.class_6557;
import net.minecraft.class_6568;
import net.minecraft.class_6724;
import net.minecraft.class_6880;
import net.minecraft.class_7138;
import net.minecraft.class_6686.class_6708;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_6724.class)
public abstract class SurfaceBuilderMixin {
   @Inject(
      method = "buildSurface",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/registry/entry/RegistryEntry;matchesKey(Lnet/minecraft/registry/RegistryKey;)Z",
         ordinal = 1,
         shift = Shift.BEFORE
      )
   )
   private void spacemod$customSurface(
      class_7138 noiseConfig,
      class_4543 biomeAccess,
      class_2378<class_1959> biomeRegistry,
      boolean useLegacyRandom,
      class_5868 heightContext,
      class_2791 chunk,
      class_6568 chunkNoiseSampler,
      class_6708 surfaceRule,
      CallbackInfo ci,
      @Local class_6880<class_1959> entry,
      @Local class_6557 blockColumn,
      @Local(ordinal = 4) int x,
      @Local(ordinal = 5) int z,
      @Local(ordinal = 6) int surfaceHeight
   ) {
      if (entry.method_40225(SpaceModBiomes.JANUS)) {
         for (int y = heightContext.method_30462(); y <= 40; y++) {
            if (blockColumn.method_32892(y).method_26215()) {
               blockColumn.method_38092(y, (class_2680)SpaceModBlocks.LIQUID_ICHOR.method_9564().method_11657(LiquidBlock.LEVEL, y == 40 ? 48 : 64));
            }
         }
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
