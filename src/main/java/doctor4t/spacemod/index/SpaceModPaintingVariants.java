package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.class_1535;
import net.minecraft.class_2378;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;

public class SpaceModPaintingVariants {
   public static final Map<class_5321<class_1535>, class_1535> PAINTING_VARIANTS = new LinkedHashMap<>();
   public static final class_5321<class_1535> MARIANNE = create("marianne", 1, 2);
   public static final class_5321<class_1535> LE_BALLON = create("le_ballon", 4, 4);
   public static final class_5321<class_1535> VANITY = create("vanity", 8, 5);
   public static final class_5321<class_1535> MAUVE = create("mauve", 7, 6);
   public static final class_5321<class_1535> TWINS = create("twins", 2, 4);
   public static final class_5321<class_1535> LUXURY_JOURNEY = create("luxury_journey", 6, 4);

   protected static class_5321<class_1535> create(String name, int width, int height) {
      class_5321<class_1535> registryKey = class_5321.method_29179(class_7924.field_41209, SpaceMod.id(name));
      PAINTING_VARIANTS.put(registryKey, new class_1535(width * 16, height * 16));
      return registryKey;
   }

   public static void initialize() {
      PAINTING_VARIANTS.forEach((registryKey, paintingVariant) -> class_2378.method_39197(class_7923.field_41182, registryKey, paintingVariant));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
