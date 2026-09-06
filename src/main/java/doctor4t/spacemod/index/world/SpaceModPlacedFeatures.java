package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.tag.SpaceModBlockTags;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2975;
import net.minecraft.class_5321;
import net.minecraft.class_5450;
import net.minecraft.class_6646;
import net.minecraft.class_6658;
import net.minecraft.class_6792;
import net.minecraft.class_6793;
import net.minecraft.class_6796;
import net.minecraft.class_6797;
import net.minecraft.class_6817;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_2350.class_2353;

public class SpaceModPlacedFeatures {
   public static final class_5321<class_6796> NITROGEN_ICE_SLAB = create("nitrogen_ice_slab");
   public static final class_5321<class_6796> THOLIN_POOR_NITROGEN_ICE_SLAB = create("tholin_poor_nitrogen_ice_slab");
   public static final class_5321<class_6796> THOLIN_RICH_NITROGEN_ICE_SLAB = create("tholin_rich_nitrogen_ice_slab");

   public static void bootstrap(class_7891<class_6796> registerable) {
      class_7871<class_2975<?, ?>> configuredFeatureLookup = registerable.method_46799(class_7924.field_41239);
      class_6817.method_40370(
         registerable,
         NITROGEN_ICE_SLAB,
         configuredFeatureLookup.method_46747(SpaceModConfiguredFeatures.NITROGEN_ICE_SLAB),
         new class_6797[]{
            class_6793.method_39623(64),
            class_5450.method_39639(),
            class_6817.field_36078,
            class_6658.method_39618(nitrogenIceSlabPredicate(SpaceModBlocks.NITROGEN_ICE)),
            class_6792.method_39614()
         }
      );
      class_6817.method_40370(
         registerable,
         THOLIN_POOR_NITROGEN_ICE_SLAB,
         configuredFeatureLookup.method_46747(SpaceModConfiguredFeatures.THOLIN_POOR_NITROGEN_ICE_SLAB),
         new class_6797[]{
            class_6793.method_39623(64),
            class_5450.method_39639(),
            class_6817.field_36078,
            class_6658.method_39618(nitrogenIceSlabPredicate(SpaceModBlocks.THOLIN_POOR_NITROGEN_ICE)),
            class_6792.method_39614()
         }
      );
      class_6817.method_40370(
         registerable,
         THOLIN_RICH_NITROGEN_ICE_SLAB,
         configuredFeatureLookup.method_46747(SpaceModConfiguredFeatures.THOLIN_RICH_NITROGEN_ICE_SLAB),
         new class_6797[]{
            class_6793.method_39623(64),
            class_5450.method_39639(),
            class_6817.field_36078,
            class_6658.method_39618(nitrogenIceSlabPredicate(SpaceModBlocks.THOLIN_RICH_NITROGEN_ICE)),
            class_6792.method_39614()
         }
      );
   }

   private static class_6646 nitrogenIceSlabPredicate(class_2248 block) {
      List<class_6646> list = new ArrayList<>();

      for (class_2350 direction : class_2353.field_11062) {
         list.add(
            class_6646.method_38882(
               new class_6646[]{
                  class_6646.method_39908(direction.method_10163(), SpaceModBlockTags.NITROGEN_ICE),
                  class_6646.method_39908(direction.method_10170().method_10163(), SpaceModBlockTags.NITROGEN_ICE),
                  class_6646.method_39908(direction.method_10153().method_10163().method_23228(), SpaceModBlockTags.NITROGEN_ICE),
                  class_6646.method_39908(direction.method_10160().method_10163().method_23228(), SpaceModBlockTags.NITROGEN_ICE)
               }
            )
         );
      }

      return class_6646.method_38882(
         new class_6646[]{class_6646.method_43288(class_2350.field_11033.method_10163(), new class_2248[]{block}), class_6646.method_38885(list)}
      );
   }

   public static class_5321<class_6796> create(String name) {
      return class_5321.method_29179(class_7924.field_41245, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
