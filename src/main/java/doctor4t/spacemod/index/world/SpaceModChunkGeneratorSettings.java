package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.mixin.DensityFunctionTypesAccessor;
import doctor4t.spacemod.mixin.DensityFunctionsAccessor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_5284;
import net.minecraft.class_5309;
import net.minecraft.class_5321;
import net.minecraft.class_5843;
import net.minecraft.class_6492;
import net.minecraft.class_6501;
import net.minecraft.class_6686;
import net.minecraft.class_6880;
import net.minecraft.class_6910;
import net.minecraft.class_6916;
import net.minecraft.class_6953;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_5216.class_5487;
import net.minecraft.class_6686.class_6708;
import net.minecraft.class_6916.class_7051;
import net.minecraft.class_6916.class_7076.class_7135;

public class SpaceModChunkGeneratorSettings {
   public static final class_5321<class_5284> JANUS = create("janus");

   public static void bootstrap(class_7891<class_5284> registerable) {
      class_7871<class_5487> noiseLookup = registerable.method_46799(class_7924.field_41244);
      class_7871<class_6910> densityFunctionLookup = registerable.method_46799(class_7924.field_41240);
      registerable.method_46838(
         JANUS,
         new class_5284(
            class_5309.method_32994(0, 384, 1, 2),
            SpaceModBlocks.NITROGEN_ICE.method_9564(),
            class_2246.field_10124.method_9564(),
            new class_6953(
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479(),
               createJanusSurface(noiseLookup, densityFunctionLookup, false),
               DensityFunctionsAccessor.applyBlendDensity(createJanusDensity(registerable)),
               class_6916.method_40479(),
               class_6916.method_40479(),
               class_6916.method_40479()
            ),
            createJanusMaterialRule(),
            List.of(),
            0,
            false,
            false,
            false,
            false
         )
      );
   }

   public static class_5321<class_5284> create(String name) {
      return class_5321.method_29179(class_7924.field_41243, SpaceMod.id(name));
   }

   public static class_6910 createJanusDensity(class_7891<class_5284> registerable) {
      class_7871<class_5487> noiseLookup = registerable.method_46799(class_7924.field_41244);
      class_7871<class_6910> densityFunctionLookup = registerable.method_46799(class_7924.field_41240);
      class_6910 surface = createJanusSurface(noiseLookup, densityFunctionLookup, true);
      class_6910 caves = createJanusCaves(noiseLookup);
      return class_6916.method_40485(class_6916.method_40481(210, 230, -1.0, 1.0), -1.0, 0.0, caves, surface);
   }

   public static class_6910 createJanusSurface(class_7871<class_5487> noiseLookup, class_7871<class_6910> densityFunctionLookup, boolean craterSpline) {
      class_6910 surfaceRoughness = class_6916.method_40504(
         class_6916.method_40500(
            class_6916.method_40502(noiseLookup.method_46747(SpaceModNoiseParameters.JANUS_SURFACE_ROUGHNESS), 0.75, 1.0), class_6916.method_40480(0.0625)
         )
      );
      class_6910 craters = class_6916.method_40486(
         crater(densityFunctionLookup, SpaceModDensityFunctions.LARGE_CRATERS, 0.125, craterSpline),
         class_6916.method_40486(
            crater(densityFunctionLookup, SpaceModDensityFunctions.MEDIUM_CRATERS, 0.0625, craterSpline),
            crater(densityFunctionLookup, SpaceModDensityFunctions.SMALL_CRATERS, 0.03125, craterSpline)
         )
      );
      return class_6916.method_40486(class_6916.method_40481(0, 384, 2.0, -1.0), class_6916.method_40486(craters, surfaceRoughness));
   }

   public static class_6910 createJanusCaves(class_7871<class_5487> noiseLookup) {
      class_6910 cheese = class_6916.method_40502(noiseLookup.method_46747(SpaceModNoiseParameters.JANUS_CAVES), 0.5, 0.625);
      class_6910 caveGradient = class_6916.method_40486(class_6916.method_40481(0, 20, 1.0, 0.0), class_6916.method_40481(200, 220, 0.0, 1.0));
      return class_6916.method_40486(cheese, class_6916.method_40486(createCavePillars(noiseLookup), caveGradient));
   }

   public static class_6910 createCavePillars(class_7871<class_5487> noiseLookup) {
      class_6910 pillarGradient = class_6916.method_40486(class_6916.method_40481(0, 220, -2.0, 2.0).method_40472(), class_6916.method_40480(-2.5));
      class_6910 pillars = class_6916.method_40504(
         class_6916.method_40500(
            class_6916.method_40486(
               DensityFunctionTypesAccessor.mapRange(
                  class_6916.method_40494(noiseLookup.method_46747(SpaceModNoiseParameters.JANUS_CAVE_PILLAR_THICKNESS), 0.0), -0.5, 0.5
               ),
               class_6916.method_40502(noiseLookup.method_46747(SpaceModNoiseParameters.JANUS_SMALL_CAVE_PILLARS), 1.0, 0.0)
            ),
            class_6916.method_40480(3.0)
         )
      );
      return class_6916.method_40508(class_6916.method_40486(pillars, pillarGradient), class_6916.method_40479());
   }

   public static class_6910 crater(class_7871<class_6910> densityFunctionLookup, class_5321<class_6910> craterKey, double scale, boolean spline) {
      class_6880<class_6910> crater = densityFunctionLookup.method_46747(craterKey);
      return spline
         ? class_6916.method_40500(
            class_6916.method_41528(
               class_6492.method_39502(new class_7135(crater), class_6501.field_37409)
                  .method_41294(-1.0F, 0.0F)
                  .method_37924(0.0F, 0.0F, 0.0F)
                  .method_37924(0.25F, 0.75F, 0.8F)
                  .method_37924(0.5F, -0.15F, -0.5F)
                  .method_37924(0.975F, -1.0F, 0.0F)
                  .method_37924(1.0F, -0.95F, 0.0F)
                  .method_37923()
            ),
            class_6916.method_40480(scale)
         )
         : class_6916.method_40500(new class_7051(crater), class_6916.method_40480(2.0));
   }

   public static class_6708 blockRule(class_2248 block) {
      return class_6686.method_39047(block.method_9564());
   }

   public static void addJanusLayers(int y, int range, int height, class_2248 block, List<class_6708> rules) {
      for (int i = -range; i <= range; i++) {
         rules.add(
            i == -range
               ? class_6686.method_39049(class_6686.method_39051(class_5843.method_33841(y - i), 0), blockRule(block))
               : class_6686.method_39049(
                  class_6686.method_39051(class_5843.method_33841(y - i), 0),
                  class_6686.method_39049(class_6686.method_39052(SpaceModNoiseParameters.JANUS_CAVES_STATE_SELECTOR, (float)i / height), blockRule(block))
               )
         );
      }
   }

   public static class_6708[] janusCaveLayers() {
      List<class_6708> rules = new ArrayList<>();
      int height = 12;
      int range = 8;
      addJanusLayers(200, range, height, SpaceModBlocks.NITROGEN_ICE, rules);
      addJanusLayers(150, range, height, SpaceModBlocks.DENSE_NITROGEN_ICE, rules);
      addJanusLayers(100, range, height, SpaceModBlocks.DENSE_ICHOR_POOR_NITROGEN_ICE, rules);
      addJanusLayers(60, range, height, SpaceModBlocks.DENSE_ICHOR_RICH_NITROGEN_ICE, rules);
      rules.add(blockRule(SpaceModBlocks.DENSE_ICHOR_RICH_NITROGEN_ICE));
      return rules.toArray(class_6708[]::new);
   }

   public static class_6708 createJanusMaterialRule() {
      class_6708 tholinIce = class_6686.method_39050(
         new class_6708[]{
            class_6686.method_39049(
               class_6686.method_39052(SpaceModNoiseParameters.JANUS_SURFACE_STATE_SELECTOR, -0.15), blockRule(SpaceModBlocks.THOLIN_RICH_NITROGEN_ICE)
            ),
            class_6686.method_39049(
               class_6686.method_39052(SpaceModNoiseParameters.JANUS_SURFACE_STATE_SELECTOR, -0.325), blockRule(SpaceModBlocks.THOLIN_POOR_NITROGEN_ICE)
            )
         }
      );
      class_6708 poorTholinIce = class_6686.method_39049(
         class_6686.method_39053(SpaceModNoiseParameters.JANUS_SURFACE_STATE_SELECTOR, 0.25, 0.5), blockRule(SpaceModBlocks.THOLIN_POOR_NITROGEN_ICE)
      );
      return class_6686.method_39050(
         new class_6708[]{
            class_6686.method_39049(
               class_6686.method_39472("bedrock_floor", class_5843.method_33840(), class_5843.method_33846(5)), blockRule(class_2246.field_9987)
            ),
            class_6686.method_39049(
               class_6686.method_39048(class_6686.method_39051(class_5843.method_33841(220), 0)), class_6686.method_39050(janusCaveLayers())
            ),
            class_6686.method_39049(
               class_6686.field_35223, class_6686.method_39050(new class_6708[]{class_6686.method_39049(class_6686.method_39473(), tholinIce), poorTholinIce})
            ),
            blockRule(SpaceModBlocks.NITROGEN_ICE)
         }
      );
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
