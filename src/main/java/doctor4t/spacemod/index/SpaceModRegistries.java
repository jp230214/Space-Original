package doctor4t.spacemod.index;

import com.mojang.serialization.Lifecycle;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.util.liquid.Liquid;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.class_2370;
import net.minecraft.class_2378;
import net.minecraft.class_5321;

public class SpaceModRegistries {
   public static final class_5321<class_2378<Liquid>> LIQUID_KEY = key("liquid");
   public static final class_2378<Liquid> LIQUID = FabricRegistryBuilder.from(new class_2370(LIQUID_KEY, Lifecycle.stable(), true))
      .attribute(RegistryAttribute.SYNCED)
      .buildAndRegister();

   public static void initialize() {
   }

   protected static <T> class_5321<class_2378<T>> key(String id) {
      return class_5321.method_29180(SpaceMod.id(id));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
