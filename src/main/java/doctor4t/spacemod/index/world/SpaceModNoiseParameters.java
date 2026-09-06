package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import net.minecraft.class_5321;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_5216.class_5487;

public class SpaceModNoiseParameters {
   public static final class_5321<class_5487> LARGE_CRATERS = create("large_craters");
   public static final class_5321<class_5487> MEDIUM_CRATERS = create("medium_craters");
   public static final class_5321<class_5487> SMALL_CRATERS = create("small_craters");
   public static final class_5321<class_5487> JANUS_SURFACE_ROUGHNESS = create("janus_surface_roughness");
   public static final class_5321<class_5487> JANUS_SURFACE_STATE_SELECTOR = create("janus_surface_state_selector");
   public static final class_5321<class_5487> JANUS_CAVES_STATE_SELECTOR = create("janus_caves_state_selector");
   public static final class_5321<class_5487> JANUS_CAVES = create("janus_caves");
   public static final class_5321<class_5487> JANUS_CAVE_PILLARS = create("janus_cave_pillars");
   public static final class_5321<class_5487> JANUS_SMALL_CAVE_PILLARS = create("janus_small_cave_pillars");
   public static final class_5321<class_5487> JANUS_CAVE_PILLAR_THICKNESS = create("janus_cave_pillar_thickness");

   public static void bootstrap(class_7891<class_5487> registerable) {
      register(registerable, LARGE_CRATERS, -4, 1.0);
      register(registerable, MEDIUM_CRATERS, -3, 1.0);
      register(registerable, SMALL_CRATERS, -2, 1.0);
      register(registerable, JANUS_SURFACE_ROUGHNESS, -5, 0.5, 1.0, 1.0);
      register(registerable, JANUS_CAVES, -7, 0.5, 1.0, 2.0, 1.0, 2.0);
      register(registerable, JANUS_SURFACE_STATE_SELECTOR, -4, 1.0, 1.0, 2.0, 2.0);
      register(registerable, JANUS_CAVES_STATE_SELECTOR, -3, 1.0, 1.0);
      register(registerable, JANUS_CAVE_PILLARS, -5, 1.0);
      register(registerable, JANUS_SMALL_CAVE_PILLARS, -3, 1.0, 1.0);
      register(registerable, JANUS_CAVE_PILLAR_THICKNESS, -6, 1.0);
   }

   private static void register(class_7891<class_5487> registerable, class_5321<class_5487> key, int firstOctave, double firstAmplitude, double... amplitudes) {
      registerable.method_46838(key, new class_5487(firstOctave, firstAmplitude, amplitudes));
   }

   public static class_5321<class_5487> create(String name) {
      return class_5321.method_29179(class_7924.field_41244, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
