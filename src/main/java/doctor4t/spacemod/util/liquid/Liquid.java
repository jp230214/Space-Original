package doctor4t.spacemod.util.liquid;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.index.SpaceModRegistries;
import doctor4t.spacemod.particle.FlowParticleEffect;
import net.minecraft.class_2396;
import net.minecraft.class_6880;
import org.jetbrains.annotations.Nullable;

public class Liquid {
   private final class_6880<Liquid> registryEntry = SpaceModRegistries.LIQUID.method_40269(this);
   private final int color;
   private final int flowRate;
   private final float density;
   private final class_2396<FlowParticleEffect> flowParticle;

   public Liquid(int color, int flowRate, float density, class_2396<FlowParticleEffect> flowParticle) {
      this.color = color;
      this.flowRate = flowRate;
      this.density = density;
      this.flowParticle = flowParticle;
   }

   @Nullable
   public LiquidBlock getBlock() {
      return LiquidBlock.fromLiquid(this);
   }

   public class_6880<Liquid> getRegistryEntry() {
      return this.registryEntry;
   }

   public int getColor() {
      return this.color;
   }

   public int getFlowRate() {
      return this.flowRate;
   }

   public float getDensity() {
      return this.density;
   }

   public class_2396<FlowParticleEffect> getFlowParticle() {
      return this.flowParticle;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
