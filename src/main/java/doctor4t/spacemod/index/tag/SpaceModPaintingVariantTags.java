package doctor4t.spacemod.index.tag;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import net.minecraft.class_1535;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public class SpaceModPaintingVariantTags {
   public static final class_6862<class_1535> FROM_REACH_FOR_THE_STARS = create("from_reach_for_the_stars");

   private static class_6862<class_1535> create(String id) {
      return class_6862.method_40092(class_7924.field_41209, SpaceMod.id(id));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
