package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.index.SpaceModBlocks;
import net.minecraft.class_2975;
import net.minecraft.class_3031;
import net.minecraft.class_3175;
import net.minecraft.class_4651;
import net.minecraft.class_5321;
import net.minecraft.class_6803;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class SpaceModConfiguredFeatures {
   public static final class_5321<class_2975<?, ?>> NITROGEN_ICE_SLAB = create("nitrogen_ice_slab");
   public static final class_5321<class_2975<?, ?>> THOLIN_POOR_NITROGEN_ICE_SLAB = create("tholin_poor_nitrogen_ice_slab");
   public static final class_5321<class_2975<?, ?>> THOLIN_RICH_NITROGEN_ICE_SLAB = create("tholin_rich_nitrogen_ice_slab");

   public static void bootstrap(class_7891<class_2975<?, ?>> registerable) {
      class_6803.method_39708(
         registerable, NITROGEN_ICE_SLAB, class_3031.field_13518, new class_3175(class_4651.method_38432(SpaceModBlocks.NITROGEN_ICE_SLAB))
      );
      class_6803.method_39708(
         registerable,
         THOLIN_POOR_NITROGEN_ICE_SLAB,
         class_3031.field_13518,
         new class_3175(class_4651.method_38432(SpaceModBlocks.THOLIN_POOR_NITROGEN_ICE_SLAB))
      );
      class_6803.method_39708(
         registerable,
         THOLIN_RICH_NITROGEN_ICE_SLAB,
         class_3031.field_13518,
         new class_3175(class_4651.method_38432(SpaceModBlocks.THOLIN_RICH_NITROGEN_ICE_SLAB))
      );
   }

   public static class_5321<class_2975<?, ?>> create(String name) {
      return class_5321.method_29179(class_7924.field_41239, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
