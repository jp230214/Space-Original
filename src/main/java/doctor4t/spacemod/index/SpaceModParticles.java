package doctor4t.spacemod.index;

import com.mojang.serialization.Codec;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.particle.FlowParticleEffect;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.class_2378;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2400;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import net.minecraft.class_2394.class_2395;

public class SpaceModParticles {
   protected static final Map<class_2396<? extends class_2394>, class_2960> PARTICLE_TYPES = new LinkedHashMap<>();
   public static final class_2396<FlowParticleEffect> ICHOR_FLOW = create("ichor_flow", FlowParticleEffect.FACTORY, FlowParticleEffect::createCodec);

   protected static class_2400 create(String name) {
      class_2400 particleType = FabricParticleTypes.simple(true);
      PARTICLE_TYPES.put(particleType, SpaceMod.id(name));
      return particleType;
   }

   protected static <T extends class_2394> class_2396<T> create(String name, class_2395<T> factory, Function<class_2396<T>, Codec<T>> codecGetter) {
      class_2396<T> particleType = new class_2396<T>(true, factory) {
         public Codec<T> method_29138() {
            return codecGetter.apply(this);
         }

         static {
            SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
         }
      };
      PARTICLE_TYPES.put(particleType, SpaceMod.id(name));
      return particleType;
   }

   public static void initialize() {
      PARTICLE_TYPES.forEach((particleType, id) -> class_2378.method_10230(class_7923.field_41180, id, particleType));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
