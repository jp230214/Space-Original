package doctor4t.spacemod.util;

import dev.upcraft.sdrm.api.SDRMVerifier;

public record PlanetProperties(float gravityScale, boolean hasOxygen) {
   public static final PlanetProperties DEFAULT = new PlanetProperties(1.0F, true);

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
