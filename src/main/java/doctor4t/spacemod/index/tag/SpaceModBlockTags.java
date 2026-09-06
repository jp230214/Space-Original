package doctor4t.spacemod.index.tag;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import net.minecraft.class_2248;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public class SpaceModBlockTags {
   public static final class_6862<class_2248> BRANCHES = create("branches");
   public static final class_6862<class_2248> VENT_SHAFTS = create("vent_shafts");
   public static final class_6862<class_2248> NITROGEN_ICE = create("nitrogen_ice");
   public static final class_6862<class_2248> SPRINKLERS = create("sprinklers");

   private static class_6862<class_2248> create(String id) {
      return class_6862.method_40092(class_7924.field_41254, SpaceMod.id(id));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
