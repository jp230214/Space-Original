package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.util.liquid.Liquid;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class SpaceModLiquids {
   protected static final Map<Liquid, class_2960> LIQUIDS = new LinkedHashMap<>();
   public static final Liquid ICHOR = create("ichor", new Liquid(329223, 1, 10.0F, SpaceModParticles.ICHOR_FLOW));

   protected static Liquid create(String name, Liquid liquid) {
      LIQUIDS.put(liquid, SpaceMod.id(name));
      return liquid;
   }

   public static void initialize() {
      LIQUIDS.forEach((liquid, id) -> class_2378.method_10230(SpaceModRegistries.LIQUID, id, liquid));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
