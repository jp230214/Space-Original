package doctor4t.spacemod.index.world;

import com.google.common.collect.ImmutableMap;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.util.PlanetProperties;
import java.util.Map;
import java.util.OptionalLong;
import net.minecraft.class_1937;
import net.minecraft.class_1959;
import net.minecraft.class_1992;
import net.minecraft.class_2874;
import net.minecraft.class_3481;
import net.minecraft.class_3754;
import net.minecraft.class_5284;
import net.minecraft.class_5321;
import net.minecraft.class_5363;
import net.minecraft.class_6016;
import net.minecraft.class_7134;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_2874.class_7512;

public class SpaceModDimensions {
   public static final class_5321<class_1937> SPACE = class_5321.method_29179(class_7924.field_41223, SpaceMod.id("space"));
   public static final class_5321<class_1937> JANUS = class_5321.method_29179(class_7924.field_41223, SpaceMod.id("janus"));
   public static final int JANUS_MIN_Y = 0;
   public static final int JANUS_HEIGHT = 384;
   public static final int JANUS_LIQUID_HEIGHT = 40;
   public static final class_5321<class_5363> JANUS_DIMENSION_OPTIONS = createOptions("janus");
   public static final class_5321<class_2874> JANUS_DIMENSION_TYPE = createType("janus");
   protected static final Map<class_5321<class_1937>, PlanetProperties> PLANET_PROPERTIES = ImmutableMap.builder()
      .put(JANUS, new PlanetProperties(0.333F, false))
      .build();

   public static PlanetProperties getPlanetProperties(class_1937 world) {
      return PLANET_PROPERTIES.getOrDefault(world.method_27983(), PlanetProperties.DEFAULT);
   }

   public static float getGravityScale(class_1937 world) {
      return world == null ? 1.0F : getPlanetProperties(world).gravityScale();
   }

   public static boolean hasOxygen(class_1937 world) {
      return getPlanetProperties(world).hasOxygen();
   }

   public static void bootstrapDimensionOptions(class_7891<class_5363> registerable) {
      class_7871<class_2874> dimensionTypeLookup = registerable.method_46799(class_7924.field_41241);
      class_7871<class_1959> biomeLookup = registerable.method_46799(class_7924.field_41236);
      class_7871<class_5284> settingsLookup = registerable.method_46799(class_7924.field_41243);
      registerable.method_46838(
         JANUS_DIMENSION_OPTIONS,
         new class_5363(
            dimensionTypeLookup.method_46747(JANUS_DIMENSION_TYPE),
            new class_3754(new class_1992(biomeLookup.method_46747(SpaceModBiomes.JANUS)), settingsLookup.method_46747(SpaceModChunkGeneratorSettings.JANUS))
         )
      );
   }

   public static void bootstrapDimensionTypes(class_7891<class_2874> registerable) {
      registerable.method_46838(
         JANUS_DIMENSION_TYPE,
         new class_2874(
            OptionalLong.of(18000L),
            true,
            false,
            false,
            true,
            1.0,
            true,
            false,
            0,
            384,
            384,
            class_3481.field_25588,
            class_7134.field_37670,
            0.0F,
            new class_7512(false, false, class_6016.method_34998(0), 0)
         )
      );
   }

   public static class_5321<class_5363> createOptions(String name) {
      return class_5321.method_29179(class_7924.field_41224, SpaceMod.id(name));
   }

   public static class_5321<class_2874> createType(String name) {
      return class_5321.method_29179(class_7924.field_41241, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
