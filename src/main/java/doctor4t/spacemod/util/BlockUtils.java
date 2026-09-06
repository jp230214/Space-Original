package doctor4t.spacemod.util;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_241;
import net.minecraft.class_243;

public class BlockUtils {
   public static class_241 get2DHit(class_243 hitPos, class_2338 blockPos, class_2350 side) {
      class_243 pos = hitPos.method_1023(blockPos.method_10263(), blockPos.method_10264(), blockPos.method_10260());
      float x = (float)pos.field_1352;
      float y = (float)pos.field_1351;
      float z = (float)pos.field_1350;

      return switch (side) {
         case field_11043 -> new class_241(1.0F - x, y);
         case field_11034 -> new class_241(1.0F - z, y);
         case field_11035 -> new class_241(x, y);
         case field_11039 -> new class_241(z, y);
         case field_11036 -> new class_241(1.0F - x, z);
         case field_11033 -> new class_241(1.0F - x, 1.0F - z);
         default -> throw new IncompatibleClassChangeError();
      };
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
