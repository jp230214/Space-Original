package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import net.minecraft.class_1959;
import net.minecraft.class_5321;
import net.minecraft.class_6796;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_1959.class_1960;
import net.minecraft.class_2893.class_2895;
import net.minecraft.class_4763.class_4764;
import net.minecraft.class_5483.class_5496;
import net.minecraft.class_5485.class_7868;

public class SpaceModBiomes {
   public static final class_5321<class_1959> JANUS = create("janus");

   public static void bootstrap(class_7891<class_1959> registerable) {
      class_7871<class_6796> placedFeatureLookup = registerable.method_46799(class_7924.field_41245);
      registerable.method_46838(
         JANUS,
         new class_1960()
            .method_48164(false)
            .method_8727(0.0F)
            .method_8747(0.0F)
            .method_30974(new class_5496().method_31007())
            .method_30973(
               new class_7868()
                  .method_46676(class_2895.field_13179, placedFeatureLookup.method_46747(SpaceModPlacedFeatures.NITROGEN_ICE_SLAB))
                  .method_46676(class_2895.field_13179, placedFeatureLookup.method_46747(SpaceModPlacedFeatures.THOLIN_POOR_NITROGEN_ICE_SLAB))
                  .method_46676(class_2895.field_13179, placedFeatureLookup.method_46747(SpaceModPlacedFeatures.THOLIN_RICH_NITROGEN_ICE_SLAB))
                  .method_46671()
            )
            .method_24379(new class_4764().method_24395(4159204).method_24397(329011).method_24392(10518688).method_30820(0).method_24391())
            .method_30972()
      );
   }

   public static class_5321<class_1959> create(String name) {
      return class_5321.method_29179(class_7924.field_41236, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
