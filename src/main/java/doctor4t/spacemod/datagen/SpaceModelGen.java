package doctor4t.spacemod.datagen;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.block.BarBlock;
import doctor4t.spacemod.block.BranchBlock;
import doctor4t.spacemod.block.CabinetBlock;
import doctor4t.spacemod.block.CanisterBlock;
import doctor4t.spacemod.block.CargoBoxBlock;
import doctor4t.spacemod.block.CouchBlock;
import doctor4t.spacemod.block.DiagonalRailingBlock;
import doctor4t.spacemod.block.OrnamentBlock;
import doctor4t.spacemod.block.PanelStripesBlock;
import doctor4t.spacemod.block.PrivacyGlassBlock;
import doctor4t.spacemod.block.PrivacyGlassPanelBlock;
import doctor4t.spacemod.block.TrimmedBedBlock;
import doctor4t.spacemod.block.TrimmedLanternBlock;
import doctor4t.spacemod.block.TrimmedStairsBlock;
import doctor4t.spacemod.block.VentHatchBlock;
import doctor4t.spacemod.block.WalkwayBlock;
import doctor4t.spacemod.block.WallLampBlock;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.SpaceModItems;
import doctor4t.spacemod.mixin.BlockTexturePoolAccessor;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2341;
import net.minecraft.class_2350;
import net.minecraft.class_2429;
import net.minecraft.class_2738;
import net.minecraft.class_2741;
import net.minecraft.class_2742;
import net.minecraft.class_2746;
import net.minecraft.class_2756;
import net.minecraft.class_2760;
import net.minecraft.class_2769;
import net.minecraft.class_2960;
import net.minecraft.class_4910;
import net.minecraft.class_4915;
import net.minecraft.class_4918;
import net.minecraft.class_4922;
import net.minecraft.class_4925;
import net.minecraft.class_4926;
import net.minecraft.class_4935;
import net.minecraft.class_4936;
import net.minecraft.class_4938;
import net.minecraft.class_4941;
import net.minecraft.class_4942;
import net.minecraft.class_4943;
import net.minecraft.class_4944;
import net.minecraft.class_4945;
import net.minecraft.class_4946;
import net.minecraft.class_5794;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_2350.class_2352;
import net.minecraft.class_2350.class_2353;
import net.minecraft.class_4910.class_4912;
import net.minecraft.class_4918.class_4921;
import net.minecraft.class_4936.class_4937;

public class SpaceModelGen extends FabricModelProvider {
   protected static final class_4942 BRANCH_FACE = new class_4942(
      Optional.of(SpaceMod.id("block/template_branch_face")), Optional.of("_face"), new class_4945[]{class_4945.field_23018}
   );
   protected static final class_4942 BRANCH_FACE_HORIZONTAL = new class_4942(
      Optional.of(SpaceMod.id("block/template_branch_face_horizontal")), Optional.of("_face_horizontal"), new class_4945[]{class_4945.field_23018}
   );
   protected static final class_4942 BRANCH_FRONT = new class_4942(
      Optional.of(SpaceMod.id("block/template_branch_front")), Optional.of("_front"), new class_4945[]{class_4945.field_23015, class_4945.field_23018}
   );
   protected static final class_4942 BRANCH_BACK = new class_4942(
      Optional.of(SpaceMod.id("block/template_branch_back")), Optional.of("_back"), new class_4945[]{class_4945.field_23015, class_4945.field_23018}
   );
   protected static final class_4942 BRANCH_INVENTORY = new class_4942(
      Optional.of(SpaceMod.id("block/template_branch_inventory")), Optional.of("_inventory"), new class_4945[]{class_4945.field_23015, class_4945.field_23018}
   );
   protected static final class_4942 VENT_SHAFT_SIDE = new class_4942(
      Optional.of(SpaceMod.id("block/template_vent_shaft_side")), Optional.of("_side"), new class_4945[]{class_4945.field_23018, class_4945.field_27791}
   );
   protected static final class_4942 VENT_SHAFT_SIDE_OPENING = new class_4942(
      Optional.of(SpaceMod.id("block/template_vent_shaft_side_opening")), Optional.of("_side_opening"), new class_4945[]{class_4945.field_23018}
   );
   protected static final class_4942 VENT_SHAFT_INVENTORY = new class_4942(
      Optional.of(SpaceMod.id("block/template_vent_shaft_inventory")),
      Optional.of("_inventory"),
      new class_4945[]{class_4945.field_23018, class_4945.field_23013, class_4945.field_27791, class_4945.field_23014, class_4945.field_23015}
   );
   protected static final class_4942 WALKWAY_TOP = new class_4942(
      Optional.of(SpaceMod.id("block/template_walkway_top")), Optional.of("_top"), new class_4945[]{class_4945.field_23018, class_4945.field_23015}
   );
   protected static final class_4942 WALKWAY_BOTTOM = new class_4942(
      Optional.of(SpaceMod.id("block/template_walkway_bottom")), Optional.of("_bottom"), new class_4945[]{class_4945.field_23018, class_4945.field_23015}
   );
   protected static final class_4942 LOUNGE_COUCH_LEFT = new class_4942(
      Optional.of(SpaceMod.id("block/template_lounge_couch_left")), Optional.of("_left"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 LOUNGE_COUCH_RIGHT = new class_4942(
      Optional.of(SpaceMod.id("block/template_lounge_couch_right")), Optional.of("_right"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 LOUNGE_COUCH_SINGLE = new class_4942(
      Optional.of(SpaceMod.id("block/template_lounge_couch_single")), Optional.of("_single"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 LOUNGE_COUCH_NO_ARMS = new class_4942(
      Optional.of(SpaceMod.id("block/template_lounge_couch_no_arms")), Optional.of("_no_arms"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 TRIMMED_STAIR_SUPPORT = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_stair_support")), Optional.of("_support"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 TRIMMED_STAIRS = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_stairs")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 PANEL = new class_4942(
      Optional.of(SpaceMod.id("block/template_panel")), Optional.empty(), new class_4945[]{class_4945.field_23010}
   );
   protected static final class_4942 LADDER = new class_4942(
      Optional.of(new class_2960("block/ladder")), Optional.empty(), new class_4945[]{class_4945.field_23011, class_4945.field_23012}
   );
   protected static final class_4942 TRIMMED_LANTERN_FLOOR = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_lantern_floor")),
      Optional.empty(),
      new class_4945[]{class_4945.field_23015, class_4945.field_23014, class_4945.field_23018}
   );
   protected static final class_4942 TRIMMED_LANTERN_CEILING = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_lantern_ceiling")),
      Optional.empty(),
      new class_4945[]{class_4945.field_23015, class_4945.field_23014, class_4945.field_23018}
   );
   protected static final class_4942 TRIMMED_LANTERN_WALL = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_lantern_wall")),
      Optional.empty(),
      new class_4945[]{class_4945.field_23015, class_4945.field_23014, class_4945.field_23018}
   );
   protected static final class_4942 WALL_LAMP_FLOOR = new class_4942(
      Optional.of(SpaceMod.id("block/template_wall_lamp_floor")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 WALL_LAMP_CEILING = new class_4942(
      Optional.of(SpaceMod.id("block/template_wall_lamp_ceiling")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 WALL_LAMP_WALL = new class_4942(
      Optional.of(SpaceMod.id("block/template_wall_lamp_wall")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 CARGO_BOX = new class_4942(
      Optional.of(SpaceMod.id("block/template_cargo_box")),
      Optional.empty(),
      new class_4945[]{class_4945.field_23015, class_4945.field_23018, class_4945.field_23014}
   );
   protected static final class_4942 GLASS_PANEL = new class_4942(
      Optional.of(SpaceMod.id("block/template_glass_panel")), Optional.empty(), new class_4945[]{class_4945.field_23031, class_4945.field_23032}
   );
   protected static final class_4942 LEATHER_COUCH_LEFT = new class_4942(
      Optional.of(SpaceMod.id("block/template_leather_couch_left")), Optional.of("_left"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 LEATHER_COUCH_RIGHT = new class_4942(
      Optional.of(SpaceMod.id("block/template_leather_couch_right")), Optional.of("_right"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 LEATHER_COUCH = new class_4942(
      Optional.of(SpaceMod.id("block/template_leather_couch")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 LEATHER_COUCH_MIDDLE = new class_4942(
      Optional.of(SpaceMod.id("block/template_leather_couch_middle")), Optional.of("_middle"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 ORNAMENT_R0 = new class_4942(
      Optional.of(SpaceMod.id("block/template_ornament_r0")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 ORNAMENT_R90 = new class_4942(
      Optional.of(SpaceMod.id("block/template_ornament_r90")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 ORNAMENT_R180 = new class_4942(
      Optional.of(SpaceMod.id("block/template_ornament_r180")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 ORNAMENT_R270 = new class_4942(
      Optional.of(SpaceMod.id("block/template_ornament_r270")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 TRIMMED_BED_FOOT = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_bed_foot")), Optional.of("_foot"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 TRIMMED_BED_HEAD = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_bed_head")), Optional.of("_head"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 TRIMMED_BED_INVENTORY = new class_4942(
      Optional.of(SpaceMod.id("block/template_trimmed_bed_inventory")), Optional.of("_inventory"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 SPRINKLER = new class_4942(
      Optional.of(SpaceMod.id("block/template_sprinkler")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 VENT_HATCH = new class_4942(
      Optional.of(SpaceMod.id("block/template_vent_hatch")), Optional.empty(), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4942 VENT_HATCH_OPEN = new class_4942(
      Optional.of(SpaceMod.id("block/template_vent_hatch_open")), Optional.of("_open"), new class_4945[]{class_4945.field_23011}
   );
   protected static final class_4945 SPYGLASS_KEY = class_4945.method_27043("spyglass");
   protected static final class_4942 SPYGLASS_IN_HAND = new class_4942(
      Optional.of(new class_2960("item/spyglass_in_hand")), Optional.empty(), new class_4945[]{SPYGLASS_KEY}
   );
   protected final Map<class_2248, class_4946> uniqueModels = ImmutableMap.builder().build();

   public SpaceModelGen(FabricDataOutput output) {
      super(output);
   }

   public void generateBlockStateModels(class_4910 generator) {
      this.registerVentShaft(generator, SpaceModBlocks.METAL_VENT_SHAFT);
      this.registerVentHatch(generator, SpaceModBlocks.METAL_VENT_HATCH);
      this.registerVentShaft(generator, SpaceModBlocks.CAST_VENT_SHAFT);
      this.registerVentHatch(generator, SpaceModBlocks.CAST_VENT_HATCH);
      this.registerVentShaft(generator, SpaceModBlocks.TARNISHED_GOLD_VENT_SHAFT);
      this.registerVentHatch(generator, SpaceModBlocks.TARNISHED_GOLD_VENT_HATCH);
      this.registerFamily(generator, SpaceModBlocks.Family.TARNISHED_GOLD);
      this.registerFamily(generator, SpaceModBlocks.Family.GOLD);
      this.registerFamily(generator, SpaceModBlocks.Family.PRISTINE_GOLD);
      generator.method_25554(SpaceModBlocks.TARNISHED_GOLD_PILLAR, class_4946.field_23055, class_4946.field_23056);
      generator.method_25554(SpaceModBlocks.GOLD_PILLAR, class_4946.field_23055, class_4946.field_23056);
      generator.method_25554(SpaceModBlocks.PRISTINE_GOLD_PILLAR, class_4946.field_23055, class_4946.field_23056);
      this.registerFamily(generator, SpaceModBlocks.Family.METAL_SHEET);
      generator.method_25658(SpaceModBlocks.COCKPIT_DOOR);
      this.registerWalkway(generator, SpaceModBlocks.METAL_SHEET_WALKWAY);
      this.registerLadder(generator, SpaceModBlocks.METAL_LADDER);
      this.registerFamily(generator, SpaceModBlocks.Family.STAINLESS_STEEL);
      this.registerWalkway(generator, SpaceModBlocks.STAINLESS_STEEL_WALKWAY);
      this.registerBranch(generator, SpaceModBlocks.STAINLESS_STEEL_BRANCH, SpaceModBlocks.STAINLESS_STEEL);
      generator.method_25554(SpaceModBlocks.STAINLESS_STEEL_PILLAR, class_4946.field_23055, class_4946.field_23056);
      this.registerFamily(generator, SpaceModBlocks.Family.DARK_STEEL);
      this.registerWalkway(generator, SpaceModBlocks.DARK_STEEL_WALKWAY);
      this.registerBranch(generator, SpaceModBlocks.DARK_STEEL_BRANCH, SpaceModBlocks.DARK_STEEL);
      generator.method_25554(SpaceModBlocks.DARK_STEEL_PILLAR, class_4946.field_23055, class_4946.field_23056);
      generator.method_25641(SpaceModBlocks.RHOMBUS_GLASS);
      this.registerGlassPanel(generator, SpaceModBlocks.GOLDEN_GLASS_PANEL);
      this.registerCullingGlass(generator);
      this.registerFamily(generator, SpaceModBlocks.Family.MARBLE);
      this.registerFamily(generator, SpaceModBlocks.Family.MARBLE_TILE);
      this.registerFamily(generator, SpaceModBlocks.Family.DARK_MARBLE);
      generator.method_25614(class_4946.field_23045, new class_2248[]{SpaceModBlocks.MARBLE_MOSAIC});
      this.registerFamily(generator, SpaceModBlocks.Family.WHITE_HULL);
      this.registerCulledBlock(generator, SpaceModBlocks.CULLING_WHITE_HULL, SpaceModBlocks.WHITE_HULL);
      this.registerFamily(generator, SpaceModBlocks.Family.BLACK_HULL);
      this.registerCulledBlock(generator, SpaceModBlocks.CULLING_BLACK_HULL, SpaceModBlocks.BLACK_HULL);
      this.registerFamily(generator, SpaceModBlocks.Family.BLACK_HULL_SHEET);
      this.registerFamily(generator, SpaceModBlocks.Family.MAHOGANY);
      this.registerFamily(generator, SpaceModBlocks.Family.MAHOGANY_HERRINGBONE);
      this.registerFamily(generator, SpaceModBlocks.Family.SMOOTH_MAHOGANY);
      this.registerPanel(generator, SpaceModBlocks.MAHOGANY_PANEL, SpaceModBlocks.SMOOTH_MAHOGANY);
      this.registerCabinet(generator, SpaceModBlocks.MAHOGANY_CABINET);
      this.registerVariedBookshelf(generator, SpaceModBlocks.MAHOGANY_BOOKSHELF, SpaceModBlocks.MAHOGANY_PLANKS);
      this.registerFamily(generator, SpaceModBlocks.Family.BUBINGA);
      this.registerFamily(generator, SpaceModBlocks.Family.BUBINGA_HERRINGBONE);
      this.registerFamily(generator, SpaceModBlocks.Family.SMOOTH_BUBINGA);
      this.registerPanel(generator, SpaceModBlocks.BUBINGA_PANEL, SpaceModBlocks.SMOOTH_BUBINGA);
      this.registerCabinet(generator, SpaceModBlocks.BUBINGA_CABINET);
      this.registerVariedBookshelf(generator, SpaceModBlocks.BUBINGA_BOOKSHELF, SpaceModBlocks.BUBINGA_PLANKS);
      this.registerFamily(generator, SpaceModBlocks.Family.EBONY);
      this.registerFamily(generator, SpaceModBlocks.Family.EBONY_HERRINGBONE);
      this.registerFamily(generator, SpaceModBlocks.Family.SMOOTH_EBONY);
      this.registerPanel(generator, SpaceModBlocks.EBONY_PANEL, SpaceModBlocks.SMOOTH_EBONY);
      this.registerCabinet(generator, SpaceModBlocks.EBONY_CABINET);
      this.registerTrimmedStairs(generator, SpaceModBlocks.TRIMMED_EBONY_STAIRS);
      this.registerVariedBookshelf(generator, SpaceModBlocks.EBONY_BOOKSHELF, SpaceModBlocks.EBONY_PLANKS);
      this.registerBranch(generator, SpaceModBlocks.OAK_BRANCH, class_2246.field_10431);
      this.registerBranch(generator, SpaceModBlocks.SPRUCE_BRANCH, class_2246.field_10037);
      this.registerBranch(generator, SpaceModBlocks.BIRCH_BRANCH, class_2246.field_10511);
      this.registerBranch(generator, SpaceModBlocks.JUNGLE_BRANCH, class_2246.field_10306);
      this.registerBranch(generator, SpaceModBlocks.ACACIA_BRANCH, class_2246.field_10533);
      this.registerBranch(generator, SpaceModBlocks.DARK_OAK_BRANCH, class_2246.field_10010);
      this.registerBranch(generator, SpaceModBlocks.MANGROVE_BRANCH, class_2246.field_37545);
      this.registerBranch(generator, SpaceModBlocks.CHERRY_BRANCH, class_2246.field_42729);
      this.registerPole(generator, SpaceModBlocks.BAMBOO_POLE, class_2246.field_41072);
      this.registerBranch(generator, SpaceModBlocks.CRIMSON_STIPE, class_2246.field_22118);
      this.registerBranch(generator, SpaceModBlocks.WARPED_STIPE, class_2246.field_22111);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_OAK_BRANCH, class_2246.field_10519);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_SPRUCE_BRANCH, class_2246.field_10436);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_BIRCH_BRANCH, class_2246.field_10366);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_JUNGLE_BRANCH, class_2246.field_10254);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_ACACIA_BRANCH, class_2246.field_10622);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_DARK_OAK_BRANCH, class_2246.field_10244);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_MANGROVE_BRANCH, class_2246.field_37548);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_CHERRY_BRANCH, class_2246.field_42732);
      this.registerPole(generator, SpaceModBlocks.STRIPPED_BAMBOO_POLE, class_2246.field_41073);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_CRIMSON_STIPE, class_2246.field_22119);
      this.registerBranch(generator, SpaceModBlocks.STRIPPED_WARPED_STIPE, class_2246.field_22112);
      this.registerPanelStripes(generator);
      this.registerRailing(generator, SpaceModBlocks.TRIMMED_RAILING, SpaceModBlocks.TRIMMED_RAILING_POST, SpaceModBlocks.DIAGONAL_TRIMMED_RAILING);
      this.registerCargoBox(generator, SpaceModBlocks.CARGO_BOX);
      this.registerLoungeCouch(generator, SpaceModBlocks.WHITE_LOUNGE_COUCH);
      generator.method_25708(SpaceModBlocks.DRIVING_SEAT);
      generator.method_25708(SpaceModBlocks.WHITE_OTTOMAN);
      this.registerBed(generator, SpaceModBlocks.WHITE_TRIMMED_BED);
      this.registerBed(generator, SpaceModBlocks.RED_TRIMMED_BED);
      this.registerLoungeCouch(generator, SpaceModBlocks.BLUE_LOUNGE_COUCH);
      this.registerLoungeCouch(generator, SpaceModBlocks.GREEN_LOUNGE_COUCH);
      this.registerLeatherCouch(generator, SpaceModBlocks.RED_LEATHER_COUCH);
      this.registerLeatherCouch(generator, SpaceModBlocks.BROWN_LEATHER_COUCH);
      this.registerLeatherCouch(generator, SpaceModBlocks.BEIGE_LEATHER_COUCH);
      generator.method_25681(SpaceModBlocks.COFFEE_TABLE);
      generator.method_25681(SpaceModBlocks.BAR_TABLE);
      generator.method_25681(SpaceModBlocks.BAR_STOOL);
      this.registerBar(generator, SpaceModBlocks.GOLD_BAR);
      this.registerTrimmedLantern(generator);
      this.registerSprinkler(generator, SpaceModBlocks.METAL_SPRINKLER);
      this.registerSprinkler(generator, SpaceModBlocks.GOLD_SPRINKLER);
      this.registerWallLamp(generator);
      generator.method_25554(SpaceModBlocks.NEON_PILLAR, class_4946.field_23055, class_4946.field_23056);
      generator.method_25708(SpaceModBlocks.MAUVE_PLUSH);
      this.registerButton(generator, SpaceModBlocks.SMALL_BUTTON);
      this.registerButton(generator, SpaceModBlocks.ELEVATOR_BUTTON);
      this.registerOrnament(generator, SpaceModBlocks.GOLD_ORNAMENT);
      this.registerFamily(generator, SpaceModBlocks.Family.NITROGEN_ICE);
      this.registerFamily(generator, SpaceModBlocks.Family.THOLIN_POOR_NITROGEN_ICE);
      this.registerFamily(generator, SpaceModBlocks.Family.THOLIN_RICH_NITROGEN_ICE);
      this.registerColumn(generator, SpaceModBlocks.DENSE_NITROGEN_ICE);
      this.registerColumn(generator, SpaceModBlocks.DENSE_ICHOR_POOR_NITROGEN_ICE);
      this.registerColumn(generator, SpaceModBlocks.DENSE_ICHOR_RICH_NITROGEN_ICE);
      this.registerLiquid(generator, SpaceModBlocks.LIQUID_ICHOR);
      generator.method_25542(SpaceModBlocks.DOOR_BARRIER, class_1802.field_8077);
      this.registerSpaceHelmet(generator, SpaceModBlocks.SPACE_HELMET);
      this.registerSpaceHelmet(generator, SpaceModBlocks.JETPACK);
      this.registerHullGlass(generator, SpaceModBlocks.HULL_GLASS);
      this.registerPrivacyGlassPanel(generator, SpaceModBlocks.PRIVACY_GLASS_PANEL);
      this.registerPump(generator, SpaceModBlocks.PUMP);
      this.registerPipe(generator, SpaceModBlocks.PIPE);
      this.registerCanister(generator, SpaceModBlocks.CANISTER);
      this.registerTelescopeModel(generator);
   }

   public void generateItemModels(class_4915 generator) {
      generator.method_25733(SpaceModItems.STIM, class_4943.field_22938);
      generator.method_25733(SpaceModItems.RATION, class_4943.field_22938);
   }

   protected class_4935 variant() {
      return class_4935.method_25824();
   }

   protected <T> class_4935 variant(class_4938<T> variantSetting, T value) {
      return this.variant().method_25828(variantSetting, value);
   }

   protected <T> class_4935 variant(class_2960 model, class_4938<T> variantSetting, T value) {
      return this.model(model).method_25828(variantSetting, value);
   }

   protected class_4935 model(class_2960 model) {
      return this.variant(class_4936.field_22887, model);
   }

   private void registerBranch(class_4910 generator, class_2248 branch, class_2248 log) {
      this.registerBranch(generator, branch, log, class_4944.method_25866(branch, "_top"));
   }

   private void registerPole(class_4910 generator, class_2248 pole, class_2248 block) {
      this.registerBranch(generator, pole, block, class_4944.method_25866(block, "_top"));
   }

   private void registerBranch(class_4910 generator, class_2248 branch, class_2248 log, class_2960 topTexture) {
      class_4944 faceMap = new class_4944().method_25868(class_4945.field_23018, class_4944.method_25860(log));
      class_4944 map = faceMap.method_25879(class_4945.field_23015, topTexture);
      class_2960 face = BRANCH_FACE.method_25846(branch, faceMap, generator.field_22831);
      class_2960 faceHorizontal = BRANCH_FACE_HORIZONTAL.method_25846(branch, faceMap, generator.field_22831);
      class_2960 front = BRANCH_FRONT.method_25846(branch, map, generator.field_22831);
      class_2960 back = BRANCH_BACK.method_25846(branch, map, generator.field_22831);
      class_2960 inventory = BRANCH_INVENTORY.method_25846(branch, map, generator.field_22831);
      generator.method_25623(branch, inventory);
      class_4922 blockStateSupplier = class_4922.method_25758(branch);

      for (class_2350 side : class_2350.values()) {
         this.addBranchSide(blockStateSupplier, side, face, faceHorizontal, front, back);
      }

      generator.field_22830.accept(blockStateSupplier);
   }

   private class_4935 rotateBranchSide(class_4935 variant, class_2350 side) {
      return switch (side.method_10166()) {
         case field_11048 -> variant.method_25828(class_4936.field_22886, class_4937.field_22891);
         case field_11052 -> variant.method_25828(class_4936.field_22885, class_4937.field_22893);
         case field_11051 -> variant;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   private void addBranchSide(class_4922 blockStateSupplier, class_2350 side, class_2960 face, class_2960 faceHorizontal, class_2960 front, class_2960 back) {
      class_2746 sideProperty = (class_2746)BranchBlock.field_11329.get(side);
      class_2746 horizontalProperty1 = (class_2746)BranchBlock.field_11329
         .get(side.method_10166().method_10178() ? class_2350.field_11034 : side.method_10170());
      class_2746 horizontalProperty2 = (class_2746)BranchBlock.field_11329
         .get(side.method_10166().method_10178() ? class_2350.field_11039 : side.method_10160());
      boolean isFront = side.method_10171() == (side.method_10166().equals(class_2351.field_11051) ? class_2352.field_11060 : class_2352.field_11056);
      blockStateSupplier.method_25760(
            class_4918.method_25744().method_25751(sideProperty, true),
            this.rotateBranchSide(class_4935.method_25824().method_25828(class_4936.field_22887, isFront ? front : back), side)
         )
         .method_25760(
            class_4918.method_25744().method_25751(sideProperty, false).method_25751(horizontalProperty1, false).method_25751(horizontalProperty2, false),
            this.rotateForFace(class_4935.method_25824().method_25828(class_4936.field_22887, face), side, false)
         )
         .method_25760(
            class_4918.method_25744().method_25751(sideProperty, false).method_25751(horizontalProperty1, true).method_25751(horizontalProperty2, false),
            this.rotateForFace(class_4935.method_25824().method_25828(class_4936.field_22887, face), side, false)
         )
         .method_25760(
            class_4918.method_25744().method_25751(sideProperty, false).method_25751(horizontalProperty1, false).method_25751(horizontalProperty2, true),
            this.rotateForFace(class_4935.method_25824().method_25828(class_4936.field_22887, face), side, false)
         )
         .method_25760(
            class_4918.method_25744().method_25751(sideProperty, false).method_25751(horizontalProperty1, true).method_25751(horizontalProperty2, true),
            this.rotateForFace(class_4935.method_25824().method_25828(class_4936.field_22887, faceHorizontal), side, false)
         );
   }

   protected class_4935 rotateForFace(class_4935 variant, class_2350 direction, boolean uvlock) {
      if (uvlock) {
         variant.method_25828(class_4936.field_22888, true);
      }

      switch (direction) {
         case field_11034:
            variant.method_25828(class_4936.field_22886, class_4937.field_22891);
            break;
         case field_11035:
            variant.method_25828(class_4936.field_22886, class_4937.field_22892);
            break;
         case field_11039:
            variant.method_25828(class_4936.field_22886, class_4937.field_22893);
            break;
         case field_11036:
            variant.method_25828(class_4936.field_22885, class_4937.field_22893);
            break;
         case field_11033:
            variant.method_25828(class_4936.field_22885, class_4937.field_22891);
      }

      return variant;
   }

   protected void registerVentShaft(class_4910 generator, class_2248 block) {
      class_2960 openingModel = VENT_SHAFT_SIDE_OPENING.method_25846(
         block, new class_4944().method_25868(class_4945.field_23018, class_4944.method_25866(block, "_opening")), generator.field_22831
      );
      class_2960 sideHorizontalModel = this.uploadVentModel(generator, block, "side", "inside", "horizontal");
      class_2960 sideVerticalModel = this.uploadVentModel(generator, block, "side", "vertical");
      class_2960 sideJunctionModel = this.uploadVentModel(generator, block, "side", "inside", "junction");
      class_2960 topHorizontalModel = this.uploadVentModel(generator, block, "top", "bottom", "horizontal");
      class_2960 topVerticalModel = this.uploadVentModel(generator, block, "top", "bottom", "vertical");
      class_2960 topJunctionModel = this.uploadVentModel(generator, block, "top", "bottom", "junction");
      class_2960 bottomHorizontalModel = this.uploadVentModel(generator, block, "bottom", "horizontal");
      class_2960 bottomVerticalModel = this.uploadVentModel(generator, block, "bottom", "vertical");
      class_2960 bottomJunctionModel = this.uploadVentModel(generator, block, "bottom", "junction");
      class_2960 inventoryModel = VENT_SHAFT_INVENTORY.method_25846(
         block,
         new class_4944()
            .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side_horizontal"))
            .method_25868(class_4945.field_27791, class_4944.method_25866(block, "_inside_horizontal"))
            .method_25868(class_4945.field_23013, class_4944.method_25866(block, "_opening"))
            .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_top_horizontal"))
            .method_25868(class_4945.field_23014, class_4944.method_25866(block, "_bottom_horizontal")),
         generator.field_22831
      );
      generator.method_25623(block, inventoryModel);
      class_4922 blockStateSupplier = class_4922.method_25758(block);

      for (class_2350 direction : class_2350.values()) {
         boolean horizontalAxis = direction.method_10166().method_10179();
         boolean isUp = direction == class_2350.field_11036;
         class_2350 leftDirection = horizontalAxis ? direction.method_10170() : class_2350.field_11034;
         class_2350 topDirection = horizontalAxis ? class_2350.field_11036 : (isUp ? class_2350.field_11035 : class_2350.field_11043);
         class_2746 property = (class_2746)class_2429.field_11329.get(direction);
         class_2746 left = (class_2746)class_2429.field_11329.get(leftDirection);
         class_2746 right = (class_2746)class_2429.field_11329.get(leftDirection.method_10153());
         class_2746 top = (class_2746)class_2429.field_11329.get(topDirection);
         class_2746 bottom = (class_2746)class_2429.field_11329.get(topDirection.method_10153());
         class_2960 horizontalModel = horizontalAxis ? sideHorizontalModel : (isUp ? topHorizontalModel : bottomHorizontalModel);
         class_2960 verticalModel = horizontalAxis ? sideVerticalModel : (isUp ? topVerticalModel : bottomVerticalModel);
         class_2960 junctionModel = horizontalAxis ? sideJunctionModel : (isUp ? topJunctionModel : bottomJunctionModel);
         class_4918 whenSide = class_4918.method_25744().method_25751(property, true);
         class_4918 whenVertical = class_4918.method_35870(
            new class_4918[]{class_4918.method_25744().method_25751(top, false), class_4918.method_25744().method_25751(bottom, false)}
         );
         class_4918 whenNotVertical = class_4918.method_35870(
            new class_4918[]{class_4918.method_25744().method_25751(top, true), class_4918.method_25744().method_25751(bottom, true)}
         );
         class_4918 whenHorizontal = class_4918.method_35870(
            new class_4918[]{class_4918.method_25744().method_25751(left, false), class_4918.method_25744().method_25751(right, false)}
         );
         class_4918 whenNotHorizontal = class_4918.method_35870(
            new class_4918[]{class_4918.method_25744().method_25751(left, true), class_4918.method_25744().method_25751(right, true)}
         );
         this.addVentSide(blockStateSupplier, direction, openingModel, class_4918.method_25744().method_25751(property, false));
         this.addVentSide(blockStateSupplier, direction, horizontalModel, class_4918.method_35870(new class_4918[]{whenSide, whenHorizontal, whenNotVertical}));
         this.addVentSide(blockStateSupplier, direction, verticalModel, class_4918.method_35870(new class_4918[]{whenSide, whenVertical, whenNotHorizontal}));
         this.addVentSide(
            blockStateSupplier,
            direction,
            junctionModel,
            class_4918.method_35870(
               new class_4918[]{
                  whenSide,
                  class_4918.method_25746(
                     new class_4918[]{
                        class_4918.method_25744().method_25751(top, true).method_25751(bottom, false).method_25751(left, false).method_25751(right, false),
                        class_4918.method_25744().method_25751(top, false).method_25751(bottom, true).method_25751(left, false).method_25751(right, false),
                        class_4918.method_25744().method_25751(top, false).method_25751(bottom, false).method_25751(left, true).method_25751(right, false),
                        class_4918.method_25744().method_25751(top, false).method_25751(bottom, false).method_25751(left, false).method_25751(right, true),
                        class_4918.method_25744().method_25751(top, false).method_25751(bottom, false).method_25751(left, false).method_25751(right, false),
                        class_4918.method_35870(
                           new class_4918[]{
                              class_4918.method_25746(
                                 new class_4918[]{class_4918.method_25744().method_25751(top, true), class_4918.method_25744().method_25751(bottom, true)}
                              ),
                              class_4918.method_25746(
                                 new class_4918[]{class_4918.method_25744().method_25751(left, true), class_4918.method_25744().method_25751(right, true)}
                              )
                           }
                        )
                     }
                  )
               }
            )
         );
      }

      generator.field_22830.accept(blockStateSupplier);
   }

   protected void addVentSide(class_4922 blockStateSupplier, class_2350 direction, class_2960 model, class_4918 when) {
      blockStateSupplier.method_25760(when, this.rotateForFace(class_4935.method_25824().method_25828(class_4936.field_22887, model), direction, false));
   }

   protected class_2960 uploadVentModel(class_4910 generator, class_2248 block, String side, String shape) {
      return this.uploadVentModel(generator, block, side, side, shape);
   }

   protected class_2960 uploadVentModel(class_4910 generator, class_2248 block, String side, String inside, String shape) {
      String suffix = "_" + side + "_" + shape;
      class_4944 textureMap = new class_4944()
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, suffix))
         .method_25868(class_4945.field_27791, class_4944.method_25866(block, "_" + inside + "_" + shape));
      return VENT_SHAFT_SIDE.method_25847(block, suffix, textureMap, generator.field_22831);
   }

   protected void registerItemParticleBlock(class_4910 generator, class_2248 block) {
      class_2960 model = class_4943.field_22908
         .method_25852(class_4941.method_25842(block), class_4944.method_25862(block.method_8389()), generator.field_22831);
      generator.field_22830.accept(class_4910.method_25644(block, model));
   }

   protected void registerFamily(class_4910 generator, class_5794 family) {
      class_4946 texturedModel = this.uniqueModels.getOrDefault(family.method_33469(), class_4946.field_23036.get(family.method_33469()));
      Objects.requireNonNull(generator);
      new class_4912(generator, texturedModel.method_25921()).method_25718(family.method_33469(), texturedModel.method_25914()).method_33522(family);
   }

   protected void registerFamilyWithoutBase(class_4910 generator, class_5794 family) {
      class_4946 texturedModel = this.uniqueModels.getOrDefault(family.method_33469(), class_4946.field_23036.get(family.method_33469()));
      Objects.requireNonNull(generator);
      class_4912 pool = new class_4912(generator, texturedModel.method_25921());
      ((BlockTexturePoolAccessor)pool).setBaseModelId(class_4941.method_25842(family.method_33469()));
      pool.method_33522(family);
   }

   protected void registerWalkway(class_4910 generator, class_2248 block) {
      class_4944 textureMap = new class_4944()
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side"))
         .method_25868(class_4945.field_23015, class_4944.method_25860(block));
      class_2960 top = WALKWAY_TOP.method_25847(block, "_top", textureMap, generator.field_22831);
      class_2960 bottom = WALKWAY_BOTTOM.method_25847(block, "_bottom", textureMap, generator.field_22831);
      generator.method_25623(block, bottom);
      generator.field_22830
         .accept(
            class_4925.method_25769(block)
               .method_25775(
                  class_4926.method_25783(WalkwayBlock.HALF)
                     .method_25793(class_2760.field_12619, class_4935.method_25824().method_25828(class_4936.field_22887, top))
                     .method_25793(class_2760.field_12617, class_4935.method_25824().method_25828(class_4936.field_22887, bottom))
               )
         );
   }

   protected void registerCouch(class_4910 generator, class_2248 block, class_4942 left, class_4942 right, class_4942 single, class_4942 noArms) {
      class_4944 textureMap = new class_4944().method_25868(class_4945.field_23011, class_4944.method_25860(block));
      class_2960 leftModel = left.method_25846(block, textureMap, generator.field_22831);
      class_2960 rightModel = right.method_25846(block, textureMap, generator.field_22831);
      class_2960 singleModel = single.method_25846(block, textureMap, generator.field_22831);
      class_2960 noArmsModel = noArms.method_25846(block, textureMap, generator.field_22831);
      generator.method_25623(block, singleModel);
      generator.field_22830
         .accept(
            class_4925.method_25769(block)
               .method_25775(
                  class_4926.method_25783(CouchBlock.ARMS)
                     .method_25793(CouchBlock.CouchArms.LEFT, class_4935.method_25824().method_25828(class_4936.field_22887, leftModel))
                     .method_25793(CouchBlock.CouchArms.RIGHT, class_4935.method_25824().method_25828(class_4936.field_22887, rightModel))
                     .method_25793(CouchBlock.CouchArms.SINGLE, class_4935.method_25824().method_25828(class_4936.field_22887, singleModel))
                     .method_25793(CouchBlock.CouchArms.NO_ARMS, class_4935.method_25824().method_25828(class_4936.field_22887, noArmsModel))
               )
               .method_25775(class_4910.method_25599())
         );
   }

   protected void registerLoungeCouch(class_4910 generator, class_2248 block) {
      this.registerCouch(generator, block, LOUNGE_COUCH_LEFT, LOUNGE_COUCH_RIGHT, LOUNGE_COUCH_SINGLE, LOUNGE_COUCH_NO_ARMS);
   }

   protected void registerLeatherCouch(class_4910 generator, class_2248 block) {
      this.registerCouch(generator, block, LEATHER_COUCH_LEFT, LEATHER_COUCH_RIGHT, LEATHER_COUCH, LEATHER_COUCH_MIDDLE);
   }

   protected void registerTrimmedStairs(class_4910 generator, class_2248 block) {
      class_4944 supportTexture = class_4944.method_25869(class_4941.method_25843(block, "_support"));
      class_4944 singleTexture = class_4944.method_25869(class_4941.method_25843(block, "_single"));
      class_4944 leftTexture = class_4944.method_25869(class_4941.method_25843(block, "_left"));
      class_4944 rightTexture = class_4944.method_25869(class_4941.method_25843(block, "_right"));
      class_4944 middleTexture = class_4944.method_25869(class_4941.method_25843(block, "_middle"));
      class_2960 support = TRIMMED_STAIR_SUPPORT.method_25846(block, supportTexture, generator.field_22831);
      class_2960 single = TRIMMED_STAIRS.method_25847(block, "_single", singleTexture, generator.field_22831);
      class_2960 left = TRIMMED_STAIRS.method_25847(block, "_left", leftTexture, generator.field_22831);
      class_2960 right = TRIMMED_STAIRS.method_25847(block, "_right", rightTexture, generator.field_22831);
      class_2960 middle = TRIMMED_STAIRS.method_25847(block, "_middle", middleTexture, generator.field_22831);
      class_4922 blockStateSupplier = class_4922.method_25758(block);

      for (class_2350 direction : class_2353.field_11062) {
         blockStateSupplier.method_25760(
            class_4918.method_25744()
               .method_25751(TrimmedStairsBlock.field_11177, direction)
               .method_25751(TrimmedStairsBlock.LEFT, false)
               .method_25751(TrimmedStairsBlock.RIGHT, false),
            this.rotateForFace(this.model(middle), direction, false)
         );
         blockStateSupplier.method_25760(
            class_4918.method_25744()
               .method_25751(TrimmedStairsBlock.field_11177, direction)
               .method_25751(TrimmedStairsBlock.LEFT, true)
               .method_25751(TrimmedStairsBlock.RIGHT, false),
            this.rotateForFace(this.model(left), direction, false)
         );
         blockStateSupplier.method_25760(
            class_4918.method_25744()
               .method_25751(TrimmedStairsBlock.field_11177, direction)
               .method_25751(TrimmedStairsBlock.LEFT, false)
               .method_25751(TrimmedStairsBlock.RIGHT, true),
            this.rotateForFace(this.model(right), direction, false)
         );
         blockStateSupplier.method_25760(
            class_4918.method_25744()
               .method_25751(TrimmedStairsBlock.field_11177, direction)
               .method_25751(TrimmedStairsBlock.LEFT, true)
               .method_25751(TrimmedStairsBlock.RIGHT, true),
            this.rotateForFace(this.model(single), direction, false)
         );
         blockStateSupplier.method_25760(
            class_4918.method_25744().method_25751(TrimmedStairsBlock.field_11177, direction).method_25751(TrimmedStairsBlock.SUPPORT, true),
            this.rotateForFace(this.model(support), direction, false)
         );
      }

      generator.method_25623(block, single);
      generator.field_22830.accept(blockStateSupplier);
   }

   protected void registerLiquid(class_4910 generator, class_2248 block) {
      class_2960 inventory = class_4943.field_22972.method_25847(block, "_inventory", class_4944.method_25864(block), generator.field_22831);
      generator.method_25623(block, inventory);
      generator.method_25681(SpaceModBlocks.LIQUID_ICHOR);
   }

   protected void registerColumn(class_4910 generator, class_2248 block) {
      class_4944 textureMap = class_4944.method_25894(block);
      class_2960 model = class_4943.field_22974.method_25846(block, textureMap, generator.field_22831);
      generator.field_22830.accept(class_4910.method_25644(block, model));
   }

   protected void registerVariedBookshelf(class_4910 generator, class_2248 block, class_2248 planks) {
      class_4944 textureMap = new class_4944()
         .method_25868(class_4945.field_23013, class_4944.method_25860(planks))
         .method_25868(class_4945.field_23018, class_4944.method_25860(block));
      class_4944 altTextureMap = new class_4944()
         .method_25868(class_4945.field_23013, class_4944.method_25860(planks))
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_alt"));
      class_2960 model = class_4943.field_22974.method_25846(block, textureMap, generator.field_22831);
      class_2960 altModel = class_4943.field_22974.method_25847(block, "_alt", altTextureMap, generator.field_22831);
      List<class_2960> models = List.of(model, altModel);
      generator.method_25623(block, model);
      generator.field_22830.accept(class_4925.method_25771(block, class_4910.method_25583(models, variant -> variant).toArray(class_4935[]::new)));
   }

   protected void registerCabinet(class_4910 generator, class_2248 block) {
      class_4944 closedTexture = new class_4944()
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side"))
         .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_side"))
         .method_25868(class_4945.field_23016, class_4944.method_25866(block, "_front"));
      class_4944 openTexture = new class_4944()
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side"))
         .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_side"))
         .method_25868(class_4945.field_23016, class_4944.method_25866(block, "_front_open"));
      class_2960 closedModel = class_4943.field_22978.method_25846(block, closedTexture, generator.field_22831);
      class_2960 openModel = class_4943.field_22978.method_25847(block, "_open", openTexture, generator.field_22831);
      generator.method_25623(block, closedModel);
      generator.field_22830
         .accept(
            class_4925.method_25769(block)
               .method_25775(class_4910.method_25565(CabinetBlock.OPEN, openModel, closedModel))
               .method_25775(class_4910.method_25599())
         );
   }

   protected void registerPanel(class_4910 generator, class_2248 block, class_2248 textureBlock) {
      class_4943.field_22938
         .method_25852(class_4941.method_25840(block.method_8389()), class_4944.method_25895(class_4944.method_25860(textureBlock)), generator.field_22831);
      class_2960 model = PANEL.method_25846(block, class_4944.method_25864(textureBlock), generator.field_22831);
      class_4922 blockStateSupplier = class_4922.method_25758(block);
      class_4921 propertyCondition = class_4918.method_25744();
      class_4910.field_28548.stream().<class_2746>map(Pair::getFirst).forEach(property -> propertyCondition.method_25751(property, false));

      for (Pair<class_2746, Function<class_2960, class_4935>> pair : class_4910.field_28548) {
         class_2746 facingProperty = (class_2746)pair.getFirst();
         class_4935 variant = (class_4935)((Function)pair.getSecond()).apply(model);
         blockStateSupplier.method_25760(class_4918.method_25744().method_25751(facingProperty, true), variant);
         blockStateSupplier.method_25760(propertyCondition, variant);
      }

      generator.field_22830.accept(blockStateSupplier);
   }

   protected class_4935 rotateForAxis(class_4935 variant, class_2351 axis) {
      return switch (axis) {
         case field_11048 -> variant.method_25828(class_4936.field_22886, class_4937.field_22893);
         case field_11052 -> variant.method_25828(class_4936.field_22885, class_4937.field_22891);
         case field_11051 -> variant;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   protected void registerBar(class_4910 generator, class_2248 block) {
      class_2960 model = class_4941.method_25842(block);
      class_2960 topModel = class_4941.method_25843(block, "_top");
      class_2960 bottomModel = class_4941.method_25843(block, "_bottom");
      generator.method_25537(block.method_8389());
      class_4922 blockStateSupplier = class_4922.method_25758(block);

      for (class_2351 axis : class_2351.values()) {
         blockStateSupplier.method_25760(class_4918.method_25744().method_25751(BarBlock.field_11459, axis), this.rotateForAxis(this.model(model), axis))
            .method_25760(
               class_4918.method_25744().method_25751(BarBlock.field_11459, axis).method_25751(BarBlock.TOP, true),
               this.rotateForAxis(this.model(topModel), axis)
            )
            .method_25760(
               class_4918.method_25744().method_25751(BarBlock.field_11459, axis).method_25751(BarBlock.BOTTOM, true),
               this.rotateForAxis(this.model(bottomModel), axis)
            );
      }

      generator.field_22830.accept(blockStateSupplier);
   }

   protected void registerLadder(class_4910 generator, class_2248 block) {
      class_4944 textureMap = class_4944.method_25872(block).method_25868(class_4945.field_23012, class_4944.method_25860(block));
      LADDER.method_25846(block, textureMap, generator.field_22831);
      generator.method_25600(block);
      generator.method_25708(block);
   }

   protected void registerTrimmedLantern(class_4910 generator) {
      class_2248 block = SpaceModBlocks.TRIMMED_LANTERN;
      class_4944 onTexture = new class_4944()
         .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_top"))
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side_on"))
         .method_25868(class_4945.field_23014, class_4944.method_25866(block, "_bottom_on"));
      class_4944 offTexture = new class_4944()
         .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_top"))
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side_off"))
         .method_25868(class_4945.field_23014, class_4944.method_25866(block, "_bottom_off"));
      class_2960 onCeiling = TRIMMED_LANTERN_CEILING.method_25847(block, "_ceiling_on", onTexture, generator.field_22831);
      class_2960 onWall = TRIMMED_LANTERN_WALL.method_25847(block, "_wall_on", onTexture, generator.field_22831);
      class_2960 onFloor = TRIMMED_LANTERN_FLOOR.method_25847(block, "_floor_on", onTexture, generator.field_22831);
      class_2960 offCeiling = TRIMMED_LANTERN_CEILING.method_25847(block, "_ceiling_off", offTexture, generator.field_22831);
      class_2960 offWall = TRIMMED_LANTERN_WALL.method_25847(block, "_wall_off", offTexture, generator.field_22831);
      class_2960 offFloor = TRIMMED_LANTERN_FLOOR.method_25847(block, "_floor_off", offTexture, generator.field_22831);
      generator.method_25623(block, onFloor);
      class_4925 blockStateSupplier = class_4925.method_25769(block);
      blockStateSupplier.method_25775(
         class_4926.method_25784(TrimmedLanternBlock.field_10927, TrimmedLanternBlock.LIT)
            .method_25797(class_2350.field_11043, false, this.model(offWall))
            .method_25797(class_2350.field_11034, false, this.rotateForFace(this.model(offWall), class_2350.field_11034, false))
            .method_25797(class_2350.field_11035, false, this.rotateForFace(this.model(offWall), class_2350.field_11035, false))
            .method_25797(class_2350.field_11039, false, this.rotateForFace(this.model(offWall), class_2350.field_11039, false))
            .method_25797(class_2350.field_11036, false, this.model(offFloor))
            .method_25797(class_2350.field_11033, false, this.model(offCeiling))
            .method_25797(class_2350.field_11043, true, this.model(onWall))
            .method_25797(class_2350.field_11034, true, this.rotateForFace(this.model(onWall), class_2350.field_11034, false))
            .method_25797(class_2350.field_11035, true, this.rotateForFace(this.model(onWall), class_2350.field_11035, false))
            .method_25797(class_2350.field_11039, true, this.rotateForFace(this.model(onWall), class_2350.field_11039, false))
            .method_25797(class_2350.field_11036, true, this.model(onFloor))
            .method_25797(class_2350.field_11033, true, this.model(onCeiling))
      );
      generator.field_22830.accept(blockStateSupplier);
   }

   protected class_4926 wallMountedVariantMap(class_2960 model) {
      return class_4926.method_25784(class_2341.field_11177, class_2341.field_11007)
         .method_25800(
            (facing, face) -> face == class_2738.field_12471
               ? this.rotateForFace(this.model(model), facing, false)
               : this.rotateForFace(
                  this.rotateForFace(this.model(model), face == class_2738.field_12475 ? class_2350.field_11036 : class_2350.field_11033, false),
                  facing.method_10153(),
                  false
               )
         );
   }

   protected class_4926 wallMountedVariantMap(class_2746 booleanProperty, class_2960 trueModel, class_2960 falseModel) {
      return class_4926.method_25785(class_2341.field_11177, class_2341.field_11007, booleanProperty)
         .method_25805(
            (facing, face, bl) -> {
               class_2960 model = bl ? trueModel : falseModel;
               return face == class_2738.field_12471
                  ? this.rotateForFace(this.model(model), facing, false)
                  : this.rotateForFace(
                     this.rotateForFace(this.model(model), face == class_2738.field_12475 ? class_2350.field_11036 : class_2350.field_11033, false),
                     facing.method_10153(),
                     false
                  );
            }
         );
   }

   protected void registerSprinkler(class_4910 generator, class_2248 block) {
      class_2960 model = SPRINKLER.method_25846(block, class_4944.method_25872(block), generator.field_22831);
      generator.method_25623(block, model);
      generator.field_22830.accept(class_4925.method_25769(block).method_25775(this.wallMountedVariantMap(model)));
   }

   protected void registerWallLamp(class_4910 generator) {
      class_2248 block = SpaceModBlocks.WALL_LAMP;
      class_4944 onTexture = class_4944.method_25872(block);
      class_4944 offTexture = class_4944.method_25869(class_4944.method_25866(block, "_off"));
      class_2960 onCeiling = WALL_LAMP_CEILING.method_25847(block, "_ceiling_on", onTexture, generator.field_22831);
      class_2960 onWall = WALL_LAMP_WALL.method_25847(block, "_wall_on", onTexture, generator.field_22831);
      class_2960 onFloor = WALL_LAMP_FLOOR.method_25847(block, "_floor_on", onTexture, generator.field_22831);
      class_2960 offCeiling = WALL_LAMP_CEILING.method_25847(block, "_ceiling_off", offTexture, generator.field_22831);
      class_2960 offWall = WALL_LAMP_WALL.method_25847(block, "_wall_off", offTexture, generator.field_22831);
      class_2960 offFloor = WALL_LAMP_FLOOR.method_25847(block, "_floor_off", offTexture, generator.field_22831);
      generator.method_25623(block, onFloor);
      class_4925 blockStateSupplier = class_4925.method_25769(block);
      blockStateSupplier.method_25775(
         class_4926.method_25784(WallLampBlock.field_10927, WallLampBlock.LIT)
            .method_25797(class_2350.field_11043, false, this.model(offWall))
            .method_25797(class_2350.field_11034, false, this.rotateForFace(this.model(offWall), class_2350.field_11034, false))
            .method_25797(class_2350.field_11035, false, this.rotateForFace(this.model(offWall), class_2350.field_11035, false))
            .method_25797(class_2350.field_11039, false, this.rotateForFace(this.model(offWall), class_2350.field_11039, false))
            .method_25797(class_2350.field_11036, false, this.model(offFloor))
            .method_25797(class_2350.field_11033, false, this.model(offCeiling))
            .method_25797(class_2350.field_11043, true, this.model(onWall))
            .method_25797(class_2350.field_11034, true, this.rotateForFace(this.model(onWall), class_2350.field_11034, false))
            .method_25797(class_2350.field_11035, true, this.rotateForFace(this.model(onWall), class_2350.field_11035, false))
            .method_25797(class_2350.field_11039, true, this.rotateForFace(this.model(onWall), class_2350.field_11039, false))
            .method_25797(class_2350.field_11036, true, this.model(onFloor))
            .method_25797(class_2350.field_11033, true, this.model(onCeiling))
      );
      generator.field_22830.accept(blockStateSupplier);
   }

   protected void registerCargoBox(class_4910 generator, class_2248 block) {
      class_4944 closedTexture = new class_4944()
         .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_top"))
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side"))
         .method_25868(class_4945.field_23014, class_4944.method_25866(block, "_bottom"));
      class_4944 openTexture = new class_4944()
         .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_top_open"))
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side"))
         .method_25868(class_4945.field_23014, class_4944.method_25866(block, "_bottom"));
      class_2960 closedModel = CARGO_BOX.method_25846(block, closedTexture, generator.field_22831);
      class_2960 openModel = CARGO_BOX.method_25847(block, "_open", openTexture, generator.field_22831);
      class_2960 inventoryModel = class_4943.field_22977.method_25847(block, "_inventory", closedTexture, generator.field_22831);
      generator.method_25623(block, inventoryModel);
      class_4925 blockStateSupplier = class_4925.method_25769(block);
      blockStateSupplier.method_25775(
         class_4926.method_25784(CargoBoxBlock.field_10927, CargoBoxBlock.OPEN)
            .method_25800((facing, open) -> this.rotateForFace(this.model(open ? openModel : closedModel), facing, false))
      );
      generator.field_22830.accept(blockStateSupplier);
   }

   protected void registerGlassPanel(class_4910 generator, class_2248 block) {
      generator.method_25556(block, "_trim");
      class_4944 textureMap = new class_4944()
         .method_25868(class_4945.field_23031, class_4944.method_25860(block))
         .method_25868(class_4945.field_23032, class_4944.method_25866(block, "_trim"));
      class_2960 model = GLASS_PANEL.method_25846(block, textureMap, generator.field_22831);
      generator.field_22830
         .accept(
            class_4925.method_25770(block, this.model(model))
               .method_25775(
                  class_4926.method_25783(class_2741.field_12525)
                     .method_25793(class_2350.field_11036, this.variant(class_4936.field_22885, class_4937.field_22891))
                     .method_25793(class_2350.field_11033, this.variant(class_4936.field_22885, class_4937.field_22893))
                     .method_25793(class_2350.field_11035, this.variant())
                     .method_25793(class_2350.field_11043, this.variant(class_4936.field_22886, class_4937.field_22892))
                     .method_25793(class_2350.field_11034, this.variant(class_4936.field_22886, class_4937.field_22893))
                     .method_25793(class_2350.field_11039, this.variant(class_4936.field_22886, class_4937.field_22891))
               )
         );
   }

   protected void registerCullingGlass(class_4910 generator) {
      class_2248 block = SpaceModBlocks.CULLING_GLASS;
      generator.method_25600(block);
      class_2960 model = class_4941.method_25842(block);
      generator.field_22830
         .accept(
            class_4925.method_25770(block, this.model(model))
               .method_25775(
                  class_4926.method_25783(class_2741.field_12525)
                     .method_25793(class_2350.field_11036, this.variant(class_4936.field_22885, class_4937.field_22891))
                     .method_25793(class_2350.field_11033, this.variant(class_4936.field_22885, class_4937.field_22893))
                     .method_25793(class_2350.field_11035, this.variant())
                     .method_25793(class_2350.field_11043, this.variant(class_4936.field_22886, class_4937.field_22892))
                     .method_25793(class_2350.field_11034, this.variant(class_4936.field_22886, class_4937.field_22893))
                     .method_25793(class_2350.field_11039, this.variant(class_4936.field_22886, class_4937.field_22891))
               )
         );
   }

   protected void registerPanelStripes(class_4910 generator) {
      class_2248 block = SpaceModBlocks.PANEL_STRIPES;
      generator.method_25600(block);
      class_2960 model = class_4941.method_25842(block);
      generator.field_22830
         .accept(
            class_4925.method_25769(block)
               .method_25775(
                  class_4926.method_25783(PanelStripesBlock.AXIS)
                     .method_25793(class_2351.field_11048, this.model(model).method_25828(class_4936.field_22886, class_4937.field_22891))
                     .method_25793(class_2351.field_11051, this.model(model))
               )
         );
   }

   protected void registerButton(class_4910 generator, class_2248 block) {
      class_2960 model = class_4941.method_25842(block);
      class_2960 pressedModel = class_4941.method_25843(block, "_pressed");
      generator.method_25623(block, model);
      generator.field_22830.accept(class_4925.method_25769(block).method_25775(this.wallMountedVariantMap(class_2269.field_10729, pressedModel, model)));
   }

   protected void registerCulledBlock(class_4910 generator, class_2248 block, class_2248 textureBlock) {
      class_2960 model = class_4943.field_22937.method_25846(block, class_4944.method_25872(textureBlock), generator.field_22831);
      class_2960 modelGlass = class_4943.field_22937
         .method_25847(block, "_glass", class_4944.method_25869(class_4944.method_25860(SpaceModBlocks.HULL_GLASS)), generator.field_22831);
      class_4943.field_22938.method_25852(class_4941.method_25840(block.method_8389()), class_4944.method_25911(textureBlock), generator.field_22831);
      class_4922 blockStateSupplier = class_4922.method_25758(block);

      for (class_2350 direction : class_2350.values()) {
         blockStateSupplier.method_25760(
            class_4918.method_25744().method_25751((class_2769)class_2429.field_11329.get(direction), true),
            this.rotateForFace(this.model(model), direction, true)
         );
         blockStateSupplier.method_25760(
            class_4918.method_25744().method_25751((class_2769)class_2429.field_11329.get(direction), false),
            this.rotateForFace(this.model(modelGlass), direction, true)
         );
      }

      generator.field_22830.accept(blockStateSupplier);
   }

   protected void registerOrnament(class_4910 generator, class_2248 block) {
      class_4944 allTexture = class_4944.method_25869(class_4944.method_25866(block, "_all"));
      class_4944 endTexture = class_4944.method_25869(class_4944.method_25866(block, "_end"));
      class_4944 sideTexture = class_4944.method_25869(class_4944.method_25866(block, "_side"));
      class_4944 cornerTexture = class_4944.method_25869(class_4944.method_25866(block, "_corner"));
      class_4944 sidesTexture = class_4944.method_25869(class_4944.method_25866(block, "_sides"));
      class_4944 centerTexture = class_4944.method_25869(class_4944.method_25866(block, "_center"));
      class_4944 sidesCenterTexture = class_4944.method_25869(class_4944.method_25866(block, "_sides_center"));
      ORNAMENT_R0.method_25847(block, "_all", allTexture, generator.field_22831);
      ORNAMENT_R0.method_25847(block, "_center", centerTexture, generator.field_22831);
      ORNAMENT_R0.method_25847(block, "_left_right_center", sidesCenterTexture, generator.field_22831);
      ORNAMENT_R0.method_25847(block, "_left", sideTexture, generator.field_22831);
      ORNAMENT_R90.method_25847(block, "_top", sideTexture, generator.field_22831);
      ORNAMENT_R180.method_25847(block, "_right", sideTexture, generator.field_22831);
      ORNAMENT_R270.method_25847(block, "_bottom", sideTexture, generator.field_22831);
      ORNAMENT_R0.method_25847(block, "_left_bottom", cornerTexture, generator.field_22831);
      ORNAMENT_R90.method_25847(block, "_left_top", cornerTexture, generator.field_22831);
      ORNAMENT_R180.method_25847(block, "_right_top", cornerTexture, generator.field_22831);
      ORNAMENT_R270.method_25847(block, "_right_bottom", cornerTexture, generator.field_22831);
      ORNAMENT_R0.method_25847(block, "_left_right", sidesTexture, generator.field_22831);
      ORNAMENT_R90.method_25847(block, "_top_bottom", sidesTexture, generator.field_22831);
      ORNAMENT_R0.method_25847(block, "_left_right_top", endTexture, generator.field_22831);
      ORNAMENT_R90.method_25847(block, "_right_top_bottom", endTexture, generator.field_22831);
      ORNAMENT_R180.method_25847(block, "_left_right_bottom", endTexture, generator.field_22831);
      ORNAMENT_R270.method_25847(block, "_left_top_bottom", endTexture, generator.field_22831);
      generator.method_25556(block, "_all");
      class_4926 map = class_4926.method_25784(OrnamentBlock.field_10927, OrnamentBlock.SHAPE)
         .method_25800((facing, shape) -> this.rotateForFace(this.model(class_4941.method_25843(block, "_" + shape.method_15434())), facing, false));
      generator.field_22830.accept(class_4925.method_25769(block).method_25775(map));
   }

   protected void registerSpaceHelmet(class_4910 generator, class_2248 block) {
      generator.method_25538(block.method_8389(), new class_2960("item/template_skull"));
      class_2960 model = class_4943.field_22908.method_25846(block, class_4944.method_25901(SpaceModBlocks.STAINLESS_STEEL), generator.field_22831);
      generator.field_22830.accept(class_4910.method_25644(block, model));
   }

   protected void registerHullGlass(class_4910 generator, class_2248 block) {
      class_2960 model = class_4943.field_22972.method_25846(block, class_4944.method_25864(block), generator.field_22831);
      class_2960 opaqueModel = class_4943.field_22972
         .method_25847(block, "_opaque", class_4944.method_25875(class_4944.method_25866(block, "_opaque")), generator.field_22831);
      generator.field_22830.accept(class_4925.method_25769(block).method_25775(class_4910.method_25565(PrivacyGlassBlock.OPAQUE, opaqueModel, model)));
      generator.method_25623(block, model);
   }

   protected void registerPrivacyGlassPanel(class_4910 generator, class_2248 block) {
      generator.method_25556(block, "_trim");
      class_4944 textureMap = new class_4944()
         .method_25868(class_4945.field_23031, class_4944.method_25860(block))
         .method_25868(class_4945.field_23032, class_4944.method_25866(block, "_trim"));
      class_4944 opaqueTextureMap = new class_4944()
         .method_25868(class_4945.field_23031, class_4944.method_25866(block, "_opaque"))
         .method_25868(class_4945.field_23032, class_4944.method_25866(block, "_trim"));
      class_2960 model = GLASS_PANEL.method_25846(block, textureMap, generator.field_22831);
      class_2960 opaqueModel = GLASS_PANEL.method_25847(block, "_opaque", opaqueTextureMap, generator.field_22831);
      generator.field_22830
         .accept(
            class_4925.method_25769(block)
               .method_25775(
                  class_4926.method_25784(class_2741.field_12525, PrivacyGlassPanelBlock.OPAQUE)
                     .method_25797(class_2350.field_11036, true, this.variant(opaqueModel, class_4936.field_22885, class_4937.field_22891))
                     .method_25797(class_2350.field_11036, false, this.variant(model, class_4936.field_22885, class_4937.field_22891))
                     .method_25797(class_2350.field_11033, true, this.variant(opaqueModel, class_4936.field_22885, class_4937.field_22893))
                     .method_25797(class_2350.field_11033, false, this.variant(model, class_4936.field_22885, class_4937.field_22893))
                     .method_25797(class_2350.field_11035, true, this.model(opaqueModel))
                     .method_25797(class_2350.field_11035, false, this.model(model))
                     .method_25797(class_2350.field_11043, true, this.variant(opaqueModel, class_4936.field_22886, class_4937.field_22892))
                     .method_25797(class_2350.field_11043, false, this.variant(model, class_4936.field_22886, class_4937.field_22892))
                     .method_25797(class_2350.field_11034, true, this.variant(opaqueModel, class_4936.field_22886, class_4937.field_22893))
                     .method_25797(class_2350.field_11034, false, this.variant(model, class_4936.field_22886, class_4937.field_22893))
                     .method_25797(class_2350.field_11039, true, this.variant(opaqueModel, class_4936.field_22886, class_4937.field_22891))
                     .method_25797(class_2350.field_11039, false, this.variant(model, class_4936.field_22886, class_4937.field_22891))
               )
         );
   }

   protected void registerRailing(class_4910 generator, class_2248 block, class_2248 post, class_2248 diagonal) {
      class_2960 model = class_4941.method_25842(block);
      class_2960 inventoryModel = class_4941.method_25843(block, "_inventory");
      class_2960 diagonalLeftModel = class_4941.method_25843(block, "_diagonal_left");
      class_2960 diagonalRightModel = class_4941.method_25843(block, "_diagonal_right");
      class_2960 postModel = class_4941.method_25843(block, "_post");
      generator.method_25623(block, inventoryModel);
      generator.field_22830.accept(class_4925.method_25770(block, this.model(model)).method_25775(class_4910.method_25599()));
      generator.field_22830.accept(class_4925.method_25770(post, this.model(postModel)).method_25775(class_4910.method_25599()));
      generator.field_22830
         .accept(
            class_4925.method_25769(diagonal)
               .method_25775(
                  class_4926.method_25784(DiagonalRailingBlock.field_11177, DiagonalRailingBlock.LEFT)
                     .method_25800(
                        (facing, left) -> this.rotateForFace(
                           this.model(left ? diagonalLeftModel : diagonalRightModel), left ? facing : facing.method_10153(), false
                        )
                     )
               )
         );
   }

   protected void registerBed(class_4910 generator, class_2248 block) {
      class_4944 textureMap = class_4944.method_25872(block);
      class_2960 inventoryModel = TRIMMED_BED_INVENTORY.method_25846(block, textureMap, generator.field_22831);
      class_2960 headModel = TRIMMED_BED_HEAD.method_25846(block, textureMap, generator.field_22831);
      class_2960 footModel = TRIMMED_BED_FOOT.method_25846(block, textureMap, generator.field_22831);
      generator.method_25623(block, inventoryModel);
      generator.field_22830
         .accept(
            class_4925.method_25769(block)
               .method_25775(
                  class_4926.method_25784(TrimmedBedBlock.field_11177, TrimmedBedBlock.PART)
                     .method_25800((facing, part) -> this.rotateForFace(this.model(part == class_2742.field_12560 ? headModel : footModel), facing, false))
               )
         );
   }

   protected void registerPipe(class_4910 generator, class_2248 block) {
      class_4944 textureMap = new class_4944()
         .method_25868(class_4945.field_23015, class_4944.method_25866(block, "_top"))
         .method_25868(class_4945.field_23014, class_4944.method_25866(block, "_top"))
         .method_25868(class_4945.field_23018, class_4944.method_25866(block, "_side"));
      class_2960 model = CARGO_BOX.method_25846(block, textureMap, generator.field_22831);
      class_2960 inventoryModel = class_4943.field_22977.method_25847(block, "_inventory", textureMap, generator.field_22831);
      generator.method_25623(block, inventoryModel);
      generator.field_22830.accept(class_4925.method_25770(block, this.model(model)).method_25775(class_4910.method_25640()));
   }

   protected void registerPump(class_4910 generator, class_2248 block) {
      class_2960 model = class_4941.method_25842(block);
      generator.method_25623(block, model);
      generator.field_22830.accept(class_4925.method_25770(block, this.model(model)).method_25775(class_4910.method_25640()));
   }

   protected void registerVentHatch(class_4910 generator, class_2248 block) {
      class_4944 textureMap = class_4944.method_25872(block);
      class_2960 model = VENT_HATCH.method_25846(block, textureMap, generator.field_22831);
      class_2960 openModel = VENT_HATCH_OPEN.method_25846(block, textureMap, generator.field_22831);
      generator.method_25600(block);
      generator.field_22830.accept(class_4925.method_25769(block).method_25775(this.wallMountedVariantMap(VentHatchBlock.OPEN, openModel, model)));
   }

   protected void registerCanister(class_4910 generator, class_2248 block) {
      class_2960 canisterModel = class_4941.method_25842(block);
      class_4922 blockStateSupplier = class_4922.method_25758(block);

      for (class_2350 direction : class_2353.field_11062) {
         blockStateSupplier.method_25760(
            class_4918.method_25744().method_25751(CanisterBlock.field_11177, direction).method_25751(CanisterBlock.HALF, class_2756.field_12607),
            this.rotateForFace(this.model(canisterModel), direction, false)
         );
      }

      for (Integer value : CanisterBlock.LEVEL.method_11898()) {
         if (value != 0) {
            blockStateSupplier.method_25760(
               class_4918.method_25744().method_25751(CanisterBlock.LEVEL, value).method_25751(CanisterBlock.HALF, class_2756.field_12607),
               this.model(class_4941.method_25843(block, "_ichor_" + value))
            );
         }
      }

      generator.method_25623(block, canisterModel);
      generator.field_22830.accept(blockStateSupplier);
   }

   protected void registerTelescopeModel(class_4910 generator) {
      class_4943.field_22938
         .method_25852(class_4941.method_25841(SpaceModItems.TELESCOPE, "_inventory"), class_4944.method_25871(SpaceModItems.TELESCOPE), generator.field_22831);
      generator.method_25538(SpaceModItems.TELESCOPE, new class_2960("builtin/entity"));
      SPYGLASS_IN_HAND.method_25852(
         class_4941.method_25841(SpaceModItems.TELESCOPE, "_in_hand"),
         new class_4944().method_25868(SPYGLASS_KEY, class_4944.method_25863(SpaceModItems.TELESCOPE, "_model")),
         generator.field_22831
      );
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
