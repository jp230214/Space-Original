package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import dev.upcraft.sdrm.api.SDRMVerifier;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2680;
import net.minecraft.class_2874;
import net.minecraft.class_3481;
import net.minecraft.class_3695;
import net.minecraft.class_5269;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_5819;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import net.minecraft.class_2338.class_2339;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_638.class)
public abstract class ClientWorldMixin extends class_1937 {
   protected ClientWorldMixin(
      class_5269 properties,
      class_5321<class_1937> registryRef,
      class_5455 registryManager,
      class_6880<class_2874> dimensionEntry,
      Supplier<class_3695> profiler,
      boolean isClient,
      boolean debugWorld,
      long biomeAccess,
      int maxChainedNeighborUpdates
   ) {
      super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
   }

   @WrapWithCondition(
      method = "randomBlockDisplayTick",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/world/ClientWorld;addParticle(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/particle/ParticleEffect;Z)V"
      )
   )
   private boolean angling$noDrippingInsideImpermeableBlocks(
      class_638 world,
      class_2338 pos,
      class_2680 state,
      class_2394 parameters,
      boolean solidBelow,
      int centerX,
      int centerY,
      int centerZ,
      int radius,
      class_5819 random,
      @Nullable class_2248 block,
      class_2339 mutable
   ) {
      return !world.method_8320(mutable).method_26164(class_3481.field_15490);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
