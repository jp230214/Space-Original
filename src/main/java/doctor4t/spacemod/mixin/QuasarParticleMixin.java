package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import foundry.veil.api.quasar.particle.QuasarParticle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1920;
import net.minecraft.class_1944;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_638;
import net.minecraft.class_2338.class_2339;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(QuasarParticle.class)
public class QuasarParticleMixin {
   @Shadow
   @Final
   private class_2339 blockPosition;
   @Shadow
   @Final
   private class_638 level;

   @Redirect(
      method = "getLightColor",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/WorldRenderer;getLightmapCoordinates(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/util/math/BlockPos;)I"
      )
   )
   public int getLightmapCoordinates(class_1920 world, class_2338 pos) {
      class_2680 state = world.method_8320(pos);
      int maxSkyLight = 0;
      int maxBlockLight = 0;
      if (state.method_26208(world, pos)) {
         return 15728880;
      }

      int skyLight = world.method_8314(class_1944.field_9284, pos);
      int blockLight = world.method_8314(class_1944.field_9282, pos);
      int k = state.method_26213();
      if (blockLight < k) {
         blockLight = k;
      }

      maxSkyLight = Math.max(maxSkyLight, skyLight);
      maxBlockLight = Math.max(maxBlockLight, blockLight);
      return maxSkyLight << 20 | maxBlockLight << 4;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
