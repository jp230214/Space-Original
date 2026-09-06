package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.fluid.LiquidFluid;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3611;
import net.minecraft.class_7923;

public class SpaceModFluids {
   protected static final Map<class_3611, class_2960> FLUIDS = new LinkedHashMap<>();
   public static final LiquidFluid LIQUID = create("liquid", new LiquidFluid());

   protected static <T extends class_3611> T create(String name, T fluid) {
      FLUIDS.put(fluid, SpaceMod.id(name));
      return fluid;
   }

   public static void initialize() {
      FLUIDS.forEach((fluid, id) -> class_2378.method_10230(class_7923.field_41173, id, fluid));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
