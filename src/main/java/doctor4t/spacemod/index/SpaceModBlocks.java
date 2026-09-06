package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.block.BarBlock;
import doctor4t.spacemod.block.BarStoolBlock;
import doctor4t.spacemod.block.BarTableBlock;
import doctor4t.spacemod.block.BranchBlock;
import doctor4t.spacemod.block.CabinetBlock;
import doctor4t.spacemod.block.CanisterBlock;
import doctor4t.spacemod.block.CargoBoxBlock;
import doctor4t.spacemod.block.CoffeeTableBlock;
import doctor4t.spacemod.block.CullingBlock;
import doctor4t.spacemod.block.CullingGlassBlock;
import doctor4t.spacemod.block.DiagonalRailingBlock;
import doctor4t.spacemod.block.DoorBarrierBlock;
import doctor4t.spacemod.block.DrivingSeatBlock;
import doctor4t.spacemod.block.ElevatorButtonBlock;
import doctor4t.spacemod.block.GlassPanelBlock;
import doctor4t.spacemod.block.JetpackBlock;
import doctor4t.spacemod.block.LeatherCouch;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.block.LoungeCouch;
import doctor4t.spacemod.block.MarshmallowCanBlock;
import doctor4t.spacemod.block.OrnamentBlock;
import doctor4t.spacemod.block.OttomanBlock;
import doctor4t.spacemod.block.PanelBlock;
import doctor4t.spacemod.block.PanelStripesBlock;
import doctor4t.spacemod.block.PipeBlock;
import doctor4t.spacemod.block.PlushBlock;
import doctor4t.spacemod.block.PrivacyGlassBlock;
import doctor4t.spacemod.block.PrivacyGlassPanelBlock;
import doctor4t.spacemod.block.PumpBlock;
import doctor4t.spacemod.block.RailingBlock;
import doctor4t.spacemod.block.RailingPostBlock;
import doctor4t.spacemod.block.SmallButtonBlock;
import doctor4t.spacemod.block.SpaceHelmetBlock;
import doctor4t.spacemod.block.SprinklerBlock;
import doctor4t.spacemod.block.ThrusterBlock;
import doctor4t.spacemod.block.TrimmedBedBlock;
import doctor4t.spacemod.block.TrimmedLanternBlock;
import doctor4t.spacemod.block.TrimmedStairsBlock;
import doctor4t.spacemod.block.VentHatchBlock;
import doctor4t.spacemod.block.VentShaftBlock;
import doctor4t.spacemod.block.WalkwayBlock;
import doctor4t.spacemod.block.WallLampBlock;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.class_1747;
import net.minecraft.class_1767;
import net.minecraft.class_2213;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2323;
import net.minecraft.class_2366;
import net.minecraft.class_2378;
import net.minecraft.class_2399;
import net.minecraft.class_2465;
import net.minecraft.class_2482;
import net.minecraft.class_2498;
import net.minecraft.class_2506;
import net.minecraft.class_2510;
import net.minecraft.class_2544;
import net.minecraft.class_2766;
import net.minecraft.class_2960;
import net.minecraft.class_3417;
import net.minecraft.class_3619;
import net.minecraft.class_3620;
import net.minecraft.class_5794;
import net.minecraft.class_7923;
import net.minecraft.class_8177;
import net.minecraft.class_4970.class_2251;
import net.minecraft.class_5794.class_5795;

public class SpaceModBlocks {
   protected static final Map<class_2248, class_2960> BLOCKS = new LinkedHashMap<>();
   public static final class_2248 METAL_VENT_SHAFT = createWithItem(
      "metal_vent_shaft",
      new VentShaftBlock(FabricBlockSettings.create().strength(1.0F).sounds(class_2498.field_27204).mapColor(class_3620.field_15978).notSolid())
   );
   public static final class_2248 METAL_VENT_HATCH = createWithItem(
      "metal_vent_hatch", new VentHatchBlock(FabricBlockSettings.copyOf(METAL_VENT_SHAFT).nonOpaque())
   );
   public static final class_2248 CAST_VENT_HATCH = createWithItem("cast_vent_hatch", new VentHatchBlock(FabricBlockSettings.copyOf(METAL_VENT_HATCH)));
   public static final class_2248 TARNISHED_GOLD_VENT_HATCH = createWithItem(
      "tarnished_gold_vent_hatch", new VentHatchBlock(FabricBlockSettings.copyOf(METAL_VENT_HATCH))
   );
   public static final class_2248 CAST_VENT_SHAFT = createWithItem("cast_vent_shaft", new VentShaftBlock(FabricBlockSettings.copyOf(METAL_VENT_SHAFT)));
   public static final class_2248 TARNISHED_GOLD_VENT_SHAFT = createWithItem(
      "tarnished_gold_vent_shaft", new VentShaftBlock(FabricBlockSettings.copyOf(METAL_VENT_SHAFT))
   );
   public static final class_2248 TARNISHED_GOLD = createWithItem(
      "tarnished_gold", new class_2248(FabricBlockSettings.create().strength(-1.0F, 3600000.0F).sounds(class_2498.field_22150))
   );
   public static final class_2248 TARNISHED_GOLD_STAIRS = createWithItem(
      "tarnished_gold_stairs", new class_2510(TARNISHED_GOLD.method_9564(), FabricBlockSettings.copyOf(TARNISHED_GOLD))
   );
   public static final class_2248 TARNISHED_GOLD_SLAB = createWithItem("tarnished_gold_slab", new class_2482(FabricBlockSettings.copyOf(TARNISHED_GOLD)));
   public static final class_2248 TARNISHED_GOLD_WALL = createWithItem(
      "tarnished_gold_wall", new class_2544(FabricBlockSettings.copyOf(TARNISHED_GOLD).solid())
   );
   public static final class_2248 TARNISHED_GOLD_PILLAR = createWithItem("tarnished_gold_pillar", new class_2465(FabricBlockSettings.copyOf(TARNISHED_GOLD)));
   public static final class_2248 GOLD = createWithItem("gold", new class_2248(FabricBlockSettings.copyOf(TARNISHED_GOLD)));
   public static final class_2248 GOLD_STAIRS = createWithItem("gold_stairs", new class_2510(GOLD.method_9564(), FabricBlockSettings.copyOf(GOLD)));
   public static final class_2248 GOLD_SLAB = createWithItem("gold_slab", new class_2482(FabricBlockSettings.copyOf(GOLD)));
   public static final class_2248 GOLD_WALL = createWithItem("gold_wall", new class_2544(FabricBlockSettings.copyOf(GOLD).solid()));
   public static final class_2248 GOLD_PILLAR = createWithItem("gold_pillar", new class_2465(FabricBlockSettings.copyOf(GOLD)));
   public static final class_2248 PRISTINE_GOLD = createWithItem("pristine_gold", new class_2248(FabricBlockSettings.copyOf(TARNISHED_GOLD)));
   public static final class_2248 PRISTINE_GOLD_STAIRS = createWithItem(
      "pristine_gold_stairs", new class_2510(PRISTINE_GOLD.method_9564(), FabricBlockSettings.copyOf(PRISTINE_GOLD))
   );
   public static final class_2248 PRISTINE_GOLD_SLAB = createWithItem("pristine_gold_slab", new class_2482(FabricBlockSettings.copyOf(PRISTINE_GOLD)));
   public static final class_2248 PRISTINE_GOLD_WALL = createWithItem("pristine_gold_wall", new class_2544(FabricBlockSettings.copyOf(PRISTINE_GOLD).solid()));
   public static final class_2248 PRISTINE_GOLD_PILLAR = createWithItem("pristine_gold_pillar", new class_2465(FabricBlockSettings.copyOf(PRISTINE_GOLD)));
   public static final class_2248 WHITE_HULL = createWithItem(
      "white_hull", new class_2248(FabricBlockSettings.copyOf(TARNISHED_GOLD).mapColor(class_3620.field_16022))
   );
   public static final class_2248 WHITE_HULL_STAIRS = createWithItem(
      "white_hull_stairs", new class_2510(WHITE_HULL.method_9564(), FabricBlockSettings.copyOf(WHITE_HULL))
   );
   public static final class_2248 WHITE_HULL_SLAB = createWithItem("white_hull_slab", new class_2482(FabricBlockSettings.copyOf(WHITE_HULL)));
   public static final class_2248 WHITE_HULL_WALL = createWithItem("white_hull_wall", new class_2544(FabricBlockSettings.copyOf(WHITE_HULL).solid()));
   public static final class_2248 CULLING_WHITE_HULL = createWithItem(
      "culling_white_hull", new CullingBlock(FabricBlockSettings.copyOf(WHITE_HULL).nonOpaque())
   );
   public static final class_2248 BLACK_HULL = createWithItem(
      "black_hull", new class_2248(FabricBlockSettings.copyOf(WHITE_HULL).mapColor(class_3620.field_16009))
   );
   public static final class_2248 BLACK_HULL_STAIRS = createWithItem(
      "black_hull_stairs", new class_2510(BLACK_HULL.method_9564(), FabricBlockSettings.copyOf(BLACK_HULL))
   );
   public static final class_2248 BLACK_HULL_SLAB = createWithItem("black_hull_slab", new class_2482(FabricBlockSettings.copyOf(BLACK_HULL)));
   public static final class_2248 BLACK_HULL_WALL = createWithItem("black_hull_wall", new class_2544(FabricBlockSettings.copyOf(BLACK_HULL).solid()));
   public static final class_2248 CULLING_BLACK_HULL = createWithItem(
      "culling_black_hull", new CullingBlock(FabricBlockSettings.copyOf(BLACK_HULL).nonOpaque())
   );
   public static final class_2248 BLACK_HULL_SHEETS = createWithItem("black_hull_sheets", new class_2248(FabricBlockSettings.copyOf(BLACK_HULL)));
   public static final class_2248 BLACK_HULL_SHEET_STAIRS = createWithItem(
      "black_hull_sheet_stairs", new class_2510(BLACK_HULL_SHEETS.method_9564(), FabricBlockSettings.copyOf(BLACK_HULL_SHEETS))
   );
   public static final class_2248 BLACK_HULL_SHEET_SLAB = createWithItem("black_hull_sheet_slab", new class_2482(FabricBlockSettings.copyOf(BLACK_HULL_SHEETS)));
   public static final class_2248 BLACK_HULL_SHEET_WALL = createWithItem(
      "black_hull_sheet_wall", new class_2544(FabricBlockSettings.copyOf(BLACK_HULL_SHEETS).solid())
   );
   public static final class_2248 PUMP = createWithItem("pump", new PumpBlock(FabricBlockSettings.copyOf(BLACK_HULL)));
   public static final class_2248 PIPE = createWithItem("pipe", new PipeBlock(FabricBlockSettings.copyOf(PUMP)));
   public static final class_2248 GOLD_BAR = createWithItem("gold_bar", new BarBlock(FabricBlockSettings.copyOf(TARNISHED_GOLD).nonOpaque().strength(0.5F)));
   public static final class_2248 METAL_SHEET = createWithItem(
      "metal_sheet", new class_2248(FabricBlockSettings.create().strength(2.0F).sounds(class_2498.field_27204))
   );
   public static final class_2248 METAL_SHEET_STAIRS = createWithItem(
      "metal_sheet_stairs", new class_2510(METAL_SHEET.method_9564(), FabricBlockSettings.copyOf(METAL_SHEET))
   );
   public static final class_2248 METAL_SHEET_SLAB = createWithItem("metal_sheet_slab", new class_2482(FabricBlockSettings.copyOf(METAL_SHEET)));
   public static final class_2248 METAL_SHEET_WALL = createWithItem("metal_sheet_wall", new class_2544(FabricBlockSettings.copyOf(METAL_SHEET).solid()));
   public static final class_2248 METAL_SHEET_WALKWAY = createWithItem(
      "metal_sheet_walkway", new WalkwayBlock(FabricBlockSettings.copyOf(METAL_SHEET).nonOpaque())
   );
   public static final class_2248 METAL_SHEET_DOOR = createWithItem(
      "metal_sheet_door",
      new class_2323(
         FabricBlockSettings.create().requiresTool().strength(5.0F).nonOpaque().sounds(class_2498.field_27204).pistonBehavior(class_3619.field_15971),
         SpaceModBlocks.SetType.METAL_SHEET
      )
   );
   public static final class_2248 COCKPIT_DOOR = createWithItem(
      "cockpit_door", new class_2323(FabricBlockSettings.copyOf(METAL_SHEET_DOOR), SpaceModBlocks.SetType.METAL_SHEET)
   );
   public static final class_2248 METAL_LADDER = createWithItem(
      "metal_ladder", new class_2399(FabricBlockSettings.create().nonOpaque().strength(0.5F).sounds(class_2498.field_17734))
   );
   public static final class_2248 STAINLESS_STEEL = createWithItem(
      "stainless_steel", new class_2248(FabricBlockSettings.create().strength(-1.0F, 3600000.0F).sounds(class_2498.field_27204).requiresTool())
   );
   public static final class_2248 STAINLESS_STEEL_STAIRS = createWithItem(
      "stainless_steel_stairs", new class_2510(STAINLESS_STEEL.method_9564(), FabricBlockSettings.copyOf(STAINLESS_STEEL))
   );
   public static final class_2248 STAINLESS_STEEL_SLAB = createWithItem("stainless_steel_slab", new class_2482(FabricBlockSettings.copyOf(STAINLESS_STEEL)));
   public static final class_2248 STAINLESS_STEEL_WALL = createWithItem(
      "stainless_steel_wall", new class_2544(FabricBlockSettings.copyOf(STAINLESS_STEEL).solid())
   );
   public static final class_2248 STAINLESS_STEEL_WALKWAY = createWithItem(
      "stainless_steel_walkway", new WalkwayBlock(FabricBlockSettings.copyOf(STAINLESS_STEEL).nonOpaque())
   );
   public static final class_2248 STAINLESS_STEEL_BRANCH = createBranch("stainless_steel_branch", STAINLESS_STEEL);
   public static final class_2248 STAINLESS_STEEL_PILLAR = createWithItem("stainless_steel_pillar", new class_2465(FabricBlockSettings.copyOf(STAINLESS_STEEL)));
   public static final class_2248 DARK_STEEL = createWithItem("dark_steel", new class_2248(FabricBlockSettings.copyOf(STAINLESS_STEEL)));
   public static final class_2248 DARK_STEEL_STAIRS = createWithItem(
      "dark_steel_stairs", new class_2510(DARK_STEEL.method_9564(), FabricBlockSettings.copyOf(DARK_STEEL))
   );
   public static final class_2248 DARK_STEEL_SLAB = createWithItem("dark_steel_slab", new class_2482(FabricBlockSettings.copyOf(DARK_STEEL)));
   public static final class_2248 DARK_STEEL_WALL = createWithItem("dark_steel_wall", new class_2544(FabricBlockSettings.copyOf(DARK_STEEL).solid()));
   public static final class_2248 DARK_STEEL_WALKWAY = createWithItem(
      "dark_steel_walkway", new WalkwayBlock(FabricBlockSettings.copyOf(DARK_STEEL).nonOpaque())
   );
   public static final class_2248 DARK_STEEL_BRANCH = createBranch("dark_steel_branch", DARK_STEEL);
   public static final class_2248 DARK_STEEL_PILLAR = createWithItem("dark_steel_pillar", new class_2465(FabricBlockSettings.copyOf(DARK_STEEL)));
   public static final class_2248 GOLDEN_GLASS_PANEL = createWithItem(
      "golden_glass_panel",
      new GlassPanelBlock(
         FabricBlockSettings.create()
            .instrument(class_2766.field_12645)
            .strength(0.3F)
            .sounds(class_2498.field_11537)
            .nonOpaque()
            .allowsSpawning(class_2246::method_26114)
      )
   );
   public static final class_2248 CULLING_GLASS = createWithItem(
      "culling_glass",
      new CullingGlassBlock(
         FabricBlockSettings.create().solid().strength(-1.0F, 3600000.0F).allowsSpawning(class_2246::method_26114).sounds(class_2498.field_11537)
      )
   );
   public static final class_2248 RHOMBUS_GLASS = createWithItem(
      "rhombus_glass", new class_2506(class_1767.field_7963, FabricBlockSettings.copyOf(class_2246.field_9997).strength(-1.0F, 3600000.0F))
   );
   public static final class_2248 HULL_GLASS = createWithItem(
      "hull_glass", new PrivacyGlassBlock(FabricBlockSettings.copyOf(class_2246.field_9997).strength(-1.0F, 3600000.0F))
   );
   public static final class_2248 PRIVACY_GLASS_PANEL = createWithItem(
      "privacy_glass_panel",
      new PrivacyGlassPanelBlock(
         FabricBlockSettings.create()
            .instrument(class_2766.field_12645)
            .strength(0.3F)
            .sounds(class_2498.field_11537)
            .nonOpaque()
            .allowsSpawning(class_2246::method_26114)
      )
   );
   public static final class_2248 MARBLE = createWithItem("marble", new class_2248(FabricBlockSettings.create().strength(2.0F).sounds(class_2498.field_27203)));
   public static final class_2248 MARBLE_STAIRS = createWithItem("marble_stairs", new class_2510(MARBLE.method_9564(), FabricBlockSettings.copyOf(MARBLE)));
   public static final class_2248 MARBLE_SLAB = createWithItem("marble_slab", new class_2482(FabricBlockSettings.copyOf(MARBLE)));
   public static final class_2248 MARBLE_WALL = createWithItem("marble_wall", new class_2544(FabricBlockSettings.copyOf(MARBLE).solid()));
   public static final class_2248 MARBLE_MOSAIC = createWithItem("marble_mosaic", new class_2366(FabricBlockSettings.copyOf(MARBLE)));
   public static final class_2248 DARK_MARBLE = createWithItem("dark_marble", new class_2248(FabricBlockSettings.copyOf(MARBLE)));
   public static final class_2248 DARK_MARBLE_STAIRS = createWithItem(
      "dark_marble_stairs", new class_2510(DARK_MARBLE.method_9564(), FabricBlockSettings.copyOf(DARK_MARBLE))
   );
   public static final class_2248 DARK_MARBLE_SLAB = createWithItem("dark_marble_slab", new class_2482(FabricBlockSettings.copyOf(DARK_MARBLE)));
   public static final class_2248 DARK_MARBLE_WALL = createWithItem("dark_marble_wall", new class_2544(FabricBlockSettings.copyOf(DARK_MARBLE).solid()));
   public static final class_2248 MARBLE_TILES = createWithItem(
      "marble_tiles", new class_2248(FabricBlockSettings.create().strength(2.0F).sounds(class_2498.field_27203))
   );
   public static final class_2248 MARBLE_TILE_STAIRS = createWithItem(
      "marble_tile_stairs", new class_2510(MARBLE_TILES.method_9564(), FabricBlockSettings.copyOf(MARBLE_TILES))
   );
   public static final class_2248 MARBLE_TILE_SLAB = createWithItem("marble_tile_slab", new class_2482(FabricBlockSettings.copyOf(MARBLE_TILES)));
   public static final class_2248 MARBLE_TILE_WALL = createWithItem("marble_tile_wall", new class_2544(FabricBlockSettings.copyOf(MARBLE_TILES).solid()));
   public static final class_2248 MAHOGANY_PLANKS = createWithItem(
      "mahogany_planks", new class_2248(FabricBlockSettings.copyOf(class_2246.field_37577).sounds(class_2498.field_42766))
   );
   public static final class_2248 MAHOGANY_STAIRS = createWithItem(
      "mahogany_stairs", new class_2510(MAHOGANY_PLANKS.method_9564(), FabricBlockSettings.copyOf(MAHOGANY_PLANKS))
   );
   public static final class_2248 MAHOGANY_SLAB = createWithItem("mahogany_slab", new class_2482(FabricBlockSettings.copyOf(MAHOGANY_PLANKS)));
   public static final class_2248 MAHOGANY_HERRINGBONE = createWithItem("mahogany_herringbone", new class_2248(FabricBlockSettings.copyOf(MAHOGANY_PLANKS)));
   public static final class_2248 MAHOGANY_HERRINGBONE_STAIRS = createWithItem(
      "mahogany_herringbone_stairs", new class_2510(MAHOGANY_HERRINGBONE.method_9564(), FabricBlockSettings.copyOf(MAHOGANY_HERRINGBONE))
   );
   public static final class_2248 MAHOGANY_HERRINGBONE_SLAB = createWithItem(
      "mahogany_herringbone_slab", new class_2482(FabricBlockSettings.copyOf(MAHOGANY_HERRINGBONE))
   );
   public static final class_2248 SMOOTH_MAHOGANY = createWithItem("smooth_mahogany", new class_2248(FabricBlockSettings.copyOf(MAHOGANY_PLANKS)));
   public static final class_2248 SMOOTH_MAHOGANY_STAIRS = createWithItem(
      "smooth_mahogany_stairs", new class_2510(SMOOTH_MAHOGANY.method_9564(), FabricBlockSettings.copyOf(SMOOTH_MAHOGANY))
   );
   public static final class_2248 SMOOTH_MAHOGANY_SLAB = createWithItem("smooth_mahogany_slab", new class_2482(FabricBlockSettings.copyOf(SMOOTH_MAHOGANY)));
   public static final class_2248 MAHOGANY_PANEL = createWithItem("mahogany_panel", new PanelBlock(FabricBlockSettings.copyOf(MAHOGANY_PLANKS)));
   public static final class_2248 MAHOGANY_CABINET = createWithItem("mahogany_cabinet", new CabinetBlock(FabricBlockSettings.copyOf(MAHOGANY_PLANKS)));
   public static final class_2248 MAHOGANY_BOOKSHELF = createWithItem("mahogany_bookshelf", new class_2248(FabricBlockSettings.copyOf(MAHOGANY_PLANKS)));
   public static final class_2248 BUBINGA_PLANKS = createWithItem(
      "bubinga_planks", new class_2248(FabricBlockSettings.copyOf(class_2246.field_10218).sounds(class_2498.field_42766))
   );
   public static final class_2248 BUBINGA_STAIRS = createWithItem(
      "bubinga_stairs", new class_2510(BUBINGA_PLANKS.method_9564(), FabricBlockSettings.copyOf(BUBINGA_PLANKS))
   );
   public static final class_2248 BUBINGA_SLAB = createWithItem("bubinga_slab", new class_2482(FabricBlockSettings.copyOf(BUBINGA_PLANKS)));
   public static final class_2248 BUBINGA_HERRINGBONE = createWithItem("bubinga_herringbone", new class_2248(FabricBlockSettings.copyOf(BUBINGA_PLANKS)));
   public static final class_2248 BUBINGA_HERRINGBONE_STAIRS = createWithItem(
      "bubinga_herringbone_stairs", new class_2510(BUBINGA_HERRINGBONE.method_9564(), FabricBlockSettings.copyOf(MAHOGANY_HERRINGBONE))
   );
   public static final class_2248 BUBINGA_HERRINGBONE_SLAB = createWithItem(
      "bubinga_herringbone_slab", new class_2482(FabricBlockSettings.copyOf(BUBINGA_HERRINGBONE))
   );
   public static final class_2248 SMOOTH_BUBINGA = createWithItem("smooth_bubinga", new class_2248(FabricBlockSettings.copyOf(BUBINGA_PLANKS)));
   public static final class_2248 SMOOTH_BUBINGA_STAIRS = createWithItem(
      "smooth_bubinga_stairs", new class_2510(SMOOTH_BUBINGA.method_9564(), FabricBlockSettings.copyOf(SMOOTH_BUBINGA))
   );
   public static final class_2248 SMOOTH_BUBINGA_SLAB = createWithItem("smooth_bubinga_slab", new class_2482(FabricBlockSettings.copyOf(SMOOTH_BUBINGA)));
   public static final class_2248 BUBINGA_PANEL = createWithItem("bubinga_panel", new PanelBlock(FabricBlockSettings.copyOf(BUBINGA_PLANKS)));
   public static final class_2248 BUBINGA_CABINET = createWithItem("bubinga_cabinet", new CabinetBlock(FabricBlockSettings.copyOf(BUBINGA_PLANKS)));
   public static final class_2248 BUBINGA_BOOKSHELF = createWithItem("bubinga_bookshelf", new class_2248(FabricBlockSettings.copyOf(BUBINGA_PLANKS)));
   public static final class_2248 EBONY_PLANKS = createWithItem(
      "ebony_planks", new class_2248(FabricBlockSettings.copyOf(class_2246.field_10075).sounds(class_2498.field_42766))
   );
   public static final class_2248 EBONY_STAIRS = createWithItem(
      "ebony_stairs", new class_2510(EBONY_PLANKS.method_9564(), FabricBlockSettings.copyOf(EBONY_PLANKS))
   );
   public static final class_2248 EBONY_SLAB = createWithItem("ebony_slab", new class_2482(FabricBlockSettings.copyOf(EBONY_PLANKS)));
   public static final class_2248 EBONY_HERRINGBONE = createWithItem("ebony_herringbone", new class_2248(FabricBlockSettings.copyOf(EBONY_PLANKS)));
   public static final class_2248 EBONY_HERRINGBONE_STAIRS = createWithItem(
      "ebony_herringbone_stairs", new class_2510(EBONY_HERRINGBONE.method_9564(), FabricBlockSettings.copyOf(MAHOGANY_HERRINGBONE))
   );
   public static final class_2248 EBONY_HERRINGBONE_SLAB = createWithItem(
      "ebony_herringbone_slab", new class_2482(FabricBlockSettings.copyOf(EBONY_HERRINGBONE))
   );
   public static final class_2248 SMOOTH_EBONY = createWithItem("smooth_ebony", new class_2248(FabricBlockSettings.copyOf(EBONY_PLANKS)));
   public static final class_2248 SMOOTH_EBONY_STAIRS = createWithItem(
      "smooth_ebony_stairs", new class_2510(SMOOTH_EBONY.method_9564(), FabricBlockSettings.copyOf(SMOOTH_EBONY))
   );
   public static final class_2248 SMOOTH_EBONY_SLAB = createWithItem("smooth_ebony_slab", new class_2482(FabricBlockSettings.copyOf(SMOOTH_EBONY)));
   public static final class_2248 EBONY_PANEL = createWithItem("ebony_panel", new PanelBlock(FabricBlockSettings.copyOf(EBONY_PLANKS)));
   public static final class_2248 EBONY_CABINET = createWithItem("ebony_cabinet", new CabinetBlock(FabricBlockSettings.copyOf(EBONY_PLANKS)));
   public static final class_2248 TRIMMED_EBONY_STAIRS = createWithItem(
      "trimmed_ebony_stairs", new TrimmedStairsBlock(FabricBlockSettings.copyOf(EBONY_PLANKS))
   );
   public static final class_2248 EBONY_BOOKSHELF = createWithItem("ebony_bookshelf", new class_2248(FabricBlockSettings.copyOf(EBONY_PLANKS)));
   public static final class_2248 OAK_BRANCH = createBranch("oak_branch", class_2246.field_10126);
   public static final class_2248 SPRUCE_BRANCH = createBranch("spruce_branch", class_2246.field_10155);
   public static final class_2248 BIRCH_BRANCH = createBranch("birch_branch", class_2246.field_10307);
   public static final class_2248 JUNGLE_BRANCH = createBranch("jungle_branch", class_2246.field_10303);
   public static final class_2248 ACACIA_BRANCH = createBranch("acacia_branch", class_2246.field_9999);
   public static final class_2248 DARK_OAK_BRANCH = createBranch("dark_oak_branch", class_2246.field_10178);
   public static final class_2248 MANGROVE_BRANCH = createBranch("mangrove_branch", class_2246.field_37549);
   public static final class_2248 CHERRY_BRANCH = createBranch("cherry_branch", class_2246.field_42733);
   public static final class_2248 BAMBOO_POLE = createBranch("bamboo_pole", class_2246.field_41072);
   public static final class_2248 CRIMSON_STIPE = createBranch("crimson_stipe", class_2246.field_22505);
   public static final class_2248 WARPED_STIPE = createBranch("warped_stipe", class_2246.field_22503);
   public static final class_2248 STRIPPED_OAK_BRANCH = createBranch("stripped_oak_branch", class_2246.field_10250);
   public static final class_2248 STRIPPED_SPRUCE_BRANCH = createBranch("stripped_spruce_branch", class_2246.field_10558);
   public static final class_2248 STRIPPED_BIRCH_BRANCH = createBranch("stripped_birch_branch", class_2246.field_10204);
   public static final class_2248 STRIPPED_JUNGLE_BRANCH = createBranch("stripped_jungle_branch", class_2246.field_10084);
   public static final class_2248 STRIPPED_ACACIA_BRANCH = createBranch("stripped_acacia_branch", class_2246.field_10103);
   public static final class_2248 STRIPPED_DARK_OAK_BRANCH = createBranch("stripped_dark_oak_branch", class_2246.field_10374);
   public static final class_2248 STRIPPED_MANGROVE_BRANCH = createBranch("stripped_mangrove_branch", class_2246.field_37550);
   public static final class_2248 STRIPPED_CHERRY_BRANCH = createBranch("stripped_cherry_branch", class_2246.field_42730);
   public static final class_2248 STRIPPED_BAMBOO_POLE = createBranch("stripped_bamboo_pole", class_2246.field_41073);
   public static final class_2248 STRIPPED_CRIMSON_STIPE = createBranch("stripped_crimson_stipe", class_2246.field_22506);
   public static final class_2248 STRIPPED_WARPED_STIPE = createBranch("stripped_warped_stipe", class_2246.field_22504);
   public static final class_2248 PANEL_STRIPES = createWithItem(
      "panel_stripes", new PanelStripesBlock(FabricBlockSettings.create().sounds(class_2498.field_41085).strength(0.5F).nonOpaque())
   );
   public static final class_2248 TRIMMED_RAILING_POST = create(
      "trimmed_railing_post", new RailingPostBlock(FabricBlockSettings.create().sounds(class_2498.field_42769).strength(1.0F).nonOpaque())
   );
   public static final class_2248 DIAGONAL_TRIMMED_RAILING = create(
      "diagonal_trimmed_railing", new DiagonalRailingBlock(FabricBlockSettings.copyOf(TRIMMED_RAILING_POST))
   );
   public static final class_2248 TRIMMED_RAILING = createWithItem(
      "trimmed_railing", new RailingBlock(DIAGONAL_TRIMMED_RAILING, TRIMMED_RAILING_POST, FabricBlockSettings.copyOf(TRIMMED_RAILING_POST))
   );
   public static final class_2248 CARGO_BOX = createWithItem(
      "cargo_box", new CargoBoxBlock(FabricBlockSettings.create().strength(1.0F).sounds(class_2498.field_27204).mapColor(class_3620.field_15978).notSolid())
   );
   public static final class_2248 WHITE_LOUNGE_COUCH = createWithItem(
      "white_lounge_couch", new LoungeCouch(FabricBlockSettings.create().nonOpaque().strength(0.5F).sounds(class_2498.field_41085))
   );
   public static final class_2248 WHITE_OTTOMAN = createWithItem("white_ottoman", new OttomanBlock(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 BLUE_LOUNGE_COUCH = createWithItem("blue_lounge_couch", new LoungeCouch(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 GREEN_LOUNGE_COUCH = createWithItem("green_lounge_couch", new LoungeCouch(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 RED_LEATHER_COUCH = createWithItem("red_leather_couch", new LeatherCouch(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 BROWN_LEATHER_COUCH = createWithItem("brown_leather_couch", new LeatherCouch(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 BEIGE_LEATHER_COUCH = createWithItem("beige_leather_couch", new LeatherCouch(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 COFFEE_TABLE = createWithItem("coffee_table", new CoffeeTableBlock(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 BAR_TABLE = createWithItem("bar_table", new BarTableBlock(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 BAR_STOOL = createWithItem("bar_stool", new BarStoolBlock(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 WHITE_TRIMMED_BED = createWithItem("white_trimmed_bed", new TrimmedBedBlock(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 RED_TRIMMED_BED = createWithItem("red_trimmed_bed", new TrimmedBedBlock(FabricBlockSettings.copyOf(WHITE_LOUNGE_COUCH)));
   public static final class_2248 TRIMMED_LANTERN = createWithItem(
      "trimmed_lantern",
      new TrimmedLanternBlock(FabricBlockSettings.create().strength(0.5F).nonOpaque().luminance(class_2246.method_26107(15)).sounds(class_2498.field_17734))
   );
   public static final class_2248 WALL_LAMP = createWithItem(
      "wall_lamp", new WallLampBlock(FabricBlockSettings.copyOf(TRIMMED_LANTERN).luminance(class_2246.method_26107(15)))
   );
   public static final class_2248 NEON_PILLAR = createWithItem(
      "neon_pillar", new class_2465(FabricBlockSettings.create().strength(1.5F).sounds(class_2498.field_11537).luminance(15))
   );
   public static final class_2248 MAUVE_PLUSH = createWithItem("mauve_plush", new PlushBlock(FabricBlockSettings.copyOf(class_2246.field_10215).nonOpaque()));
   public static final class_2248 SMALL_BUTTON = createWithItem(
      "small_button", new SmallButtonBlock(FabricBlockSettings.create().sounds(class_2498.field_42766).nonOpaque().noCollision().strength(-1.0F, 3600000.0F))
   );
   public static final class_2248 ELEVATOR_BUTTON = createWithItem("elevator_button", new ElevatorButtonBlock(FabricBlockSettings.copyOf(SMALL_BUTTON)));
   public static final class_2248 METAL_SPRINKLER = createWithItem(
      "metal_sprinkler", new SprinklerBlock(FabricBlockSettings.create().strength(0.5F).nonOpaque().sounds(class_2498.field_17734))
   );
   public static final class_2248 GOLD_SPRINKLER = createWithItem("gold_sprinkler", new SprinklerBlock(FabricBlockSettings.copyOf(METAL_SPRINKLER)));
   public static final class_2248 GOLD_ORNAMENT = createWithItem(
      "gold_ornament", new OrnamentBlock(FabricBlockSettings.create().nonOpaque().notSolid().noCollision().strength(0.25F).sounds(class_2498.field_27204))
   );
   public static final class_2248 NITROGEN_ICE = createWithItem(
      "nitrogen_ice", new class_2248(FabricBlockSettings.create().mapColor(class_3620.field_16022).sounds(class_2498.field_29033).strength(1.0F))
   );
   public static final class_2248 NITROGEN_ICE_STAIRS = createWithItem(
      "nitrogen_ice_stairs", new class_2510(NITROGEN_ICE.method_9564(), FabricBlockSettings.copyOf(NITROGEN_ICE))
   );
   public static final class_2248 NITROGEN_ICE_SLAB = createWithItem("nitrogen_ice_slab", new class_2482(FabricBlockSettings.copyOf(NITROGEN_ICE)));
   public static final class_2248 THOLIN_POOR_NITROGEN_ICE = createWithItem(
      "tholin_poor_nitrogen_ice", new class_2248(FabricBlockSettings.copyOf(NITROGEN_ICE))
   );
   public static final class_2248 THOLIN_POOR_NITROGEN_ICE_STAIRS = createWithItem(
      "tholin_poor_nitrogen_ice_stairs", new class_2510(THOLIN_POOR_NITROGEN_ICE.method_9564(), FabricBlockSettings.copyOf(THOLIN_POOR_NITROGEN_ICE))
   );
   public static final class_2248 THOLIN_POOR_NITROGEN_ICE_SLAB = createWithItem(
      "tholin_poor_nitrogen_ice_slab", new class_2482(FabricBlockSettings.copyOf(THOLIN_POOR_NITROGEN_ICE))
   );
   public static final class_2248 THOLIN_RICH_NITROGEN_ICE = createWithItem(
      "tholin_rich_nitrogen_ice", new class_2248(FabricBlockSettings.copyOf(NITROGEN_ICE).mapColor(class_3620.field_25704))
   );
   public static final class_2248 THOLIN_RICH_NITROGEN_ICE_STAIRS = createWithItem(
      "tholin_rich_nitrogen_ice_stairs", new class_2510(THOLIN_RICH_NITROGEN_ICE.method_9564(), FabricBlockSettings.copyOf(THOLIN_RICH_NITROGEN_ICE))
   );
   public static final class_2248 THOLIN_RICH_NITROGEN_ICE_SLAB = createWithItem(
      "tholin_rich_nitrogen_ice_slab", new class_2482(FabricBlockSettings.copyOf(THOLIN_RICH_NITROGEN_ICE))
   );
   public static final class_2248 DENSE_NITROGEN_ICE = createWithItem(
      "dense_nitrogen_ice", new class_2248(FabricBlockSettings.copyOf(NITROGEN_ICE).strength(1.5F))
   );
   public static final class_2248 DENSE_ICHOR_POOR_NITROGEN_ICE = createWithItem(
      "dense_ichor_poor_nitrogen_ice", new class_2248(FabricBlockSettings.copyOf(DENSE_NITROGEN_ICE).mapColor(class_3620.field_15993))
   );
   public static final class_2248 DENSE_ICHOR_RICH_NITROGEN_ICE = createWithItem(
      "dense_ichor_rich_nitrogen_ice", new class_2248(FabricBlockSettings.copyOf(DENSE_NITROGEN_ICE).mapColor(class_3620.field_15978))
   );
   public static final class_2248 LIQUID_ICHOR = createWithItem(
      "liquid_ichor",
      new LiquidBlock(
         SpaceModLiquids.ICHOR,
         FabricBlockSettings.create()
            .strength(100.0F)
            .replaceable()
            .sounds(class_2498.field_44608)
            .pistonBehavior(class_3619.field_15971)
            .mapColor(class_3620.field_16009)
            .noCollision()
            .dynamicBounds()
      )
   );
   public static final class_2248 DRIVING_SEAT = createWithItem(
      "driving_seat", new DrivingSeatBlock(FabricBlockSettings.create().nonOpaque().strength(-1.0F, 3600000.0F).sounds(class_2498.field_41085))
   );
   public static final class_2248 DOOR_BARRIER = create("door_barrier", new DoorBarrierBlock(FabricBlockSettings.copyOf(class_2246.field_10499)));
   public static final class_2248 AIRLOCK_BARRIER = create("airlock_barrier", new class_2213(FabricBlockSettings.copyOf(class_2246.field_10499)));
   public static final class_2248 SPACE_HELMET = createWithItem(
      "space_helmet",
      new SpaceHelmetBlock(class_2251.method_9637().method_9618().method_50012(class_3619.field_15971).method_9626(class_2498.field_22150)),
      new FabricItemSettings().maxCount(1).fireproof()
   );
   public static final class_2248 JETPACK = createWithItem(
      "jetpack",
      new JetpackBlock(class_2251.method_9637().method_9618().method_50012(class_3619.field_15971).method_9626(class_2498.field_22150)),
      new FabricItemSettings().maxCount(1).fireproof()
   );
   public static final class_2248 MARSHMALLOW_CAN = createWithItem(
      "marshmallow_can",
      new MarshmallowCanBlock(
         FabricBlockSettings.create()
            .mapColor(class_3620.field_15978)
            .breakInstantly()
            .sounds(class_2498.field_17734)
            .nonOpaque()
            .pistonBehavior(class_3619.field_15971)
      )
   );
   public static final class_2248 CANISTER = createWithItem(
      "canister", new CanisterBlock(FabricBlockSettings.copyOf(BLACK_HULL)), new FabricItemSettings().maxCount(1)
   );
   public static final class_2248 THRUSTER = createWithItem("thruster", new ThrusterBlock(FabricBlockSettings.copyOf(BLACK_HULL)));

   protected static <T extends class_2248> T create(String name, T block) {
      BLOCKS.put(block, SpaceMod.id(name));
      return block;
   }

   protected static <T extends class_2248> T createWithItem(String name, T block) {
      return createWithItem(name, block, new FabricItemSettings());
   }

   protected static <T extends class_2248> T createWithItem(String name, T block, FabricItemSettings settings) {
      return createWithItem(name, block, b -> new class_1747(b, settings));
   }

   protected static <T extends class_2248> T createWithItem(String name, T block, Function<T, class_1747> itemGenerator) {
      SpaceModItems.create(name, (T)((class_1747)itemGenerator.apply(block)));
      return create(name, block);
   }

   protected static class_2248 createBranch(String name, class_2248 wood) {
      return createWithItem(name, new BranchBlock(FabricBlockSettings.copyOf(wood).mapColor(wood.method_26403())));
   }

   public static void initialize() {
      BLOCKS.forEach((block, id) -> class_2378.method_10230(class_7923.field_41175, id, block));
      BranchBlock.STRIPPED_BRANCHES.put(STAINLESS_STEEL_BRANCH, STAINLESS_STEEL);
      BranchBlock.STRIPPED_BRANCHES.put(OAK_BRANCH, STRIPPED_OAK_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(SPRUCE_BRANCH, STRIPPED_SPRUCE_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(BIRCH_BRANCH, STRIPPED_BIRCH_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(JUNGLE_BRANCH, STRIPPED_JUNGLE_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(ACACIA_BRANCH, STRIPPED_ACACIA_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(DARK_OAK_BRANCH, STRIPPED_DARK_OAK_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(MANGROVE_BRANCH, STRIPPED_MANGROVE_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(CHERRY_BRANCH, STRIPPED_CHERRY_BRANCH);
      BranchBlock.STRIPPED_BRANCHES.put(BAMBOO_POLE, STRIPPED_BAMBOO_POLE);
      BranchBlock.STRIPPED_BRANCHES.put(CRIMSON_STIPE, STRIPPED_CRIMSON_STIPE);
      BranchBlock.STRIPPED_BRANCHES.put(WARPED_STIPE, STRIPPED_WARPED_STIPE);
      FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
      flammableBlockRegistry.add(OAK_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_OAK_BRANCH, 5, 20);
      flammableBlockRegistry.add(SPRUCE_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_SPRUCE_BRANCH, 5, 20);
      flammableBlockRegistry.add(BIRCH_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_BIRCH_BRANCH, 5, 20);
      flammableBlockRegistry.add(JUNGLE_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_JUNGLE_BRANCH, 5, 20);
      flammableBlockRegistry.add(ACACIA_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_ACACIA_BRANCH, 5, 20);
      flammableBlockRegistry.add(DARK_OAK_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_DARK_OAK_BRANCH, 5, 20);
      flammableBlockRegistry.add(MANGROVE_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_MANGROVE_BRANCH, 5, 20);
      flammableBlockRegistry.add(CHERRY_BRANCH, 5, 20);
      flammableBlockRegistry.add(STRIPPED_CHERRY_BRANCH, 5, 20);
      flammableBlockRegistry.add(BAMBOO_POLE, 5, 20);
      flammableBlockRegistry.add(STRIPPED_BAMBOO_POLE, 5, 20);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }

   public static class Family {
      public static final class_5794 TARNISHED_GOLD = new class_5795(SpaceModBlocks.TARNISHED_GOLD)
         .method_33493(SpaceModBlocks.TARNISHED_GOLD_STAIRS)
         .method_33492(SpaceModBlocks.TARNISHED_GOLD_SLAB)
         .method_33497(SpaceModBlocks.TARNISHED_GOLD_WALL)
         .method_33481();
      public static final class_5794 GOLD = new class_5795(SpaceModBlocks.GOLD)
         .method_33493(SpaceModBlocks.GOLD_STAIRS)
         .method_33492(SpaceModBlocks.GOLD_SLAB)
         .method_33497(SpaceModBlocks.GOLD_WALL)
         .method_33481();
      public static final class_5794 PRISTINE_GOLD = new class_5795(SpaceModBlocks.PRISTINE_GOLD)
         .method_33493(SpaceModBlocks.PRISTINE_GOLD_STAIRS)
         .method_33492(SpaceModBlocks.PRISTINE_GOLD_SLAB)
         .method_33497(SpaceModBlocks.PRISTINE_GOLD_WALL)
         .method_33481();
      public static final class_5794 METAL_SHEET = new class_5795(SpaceModBlocks.METAL_SHEET)
         .method_33493(SpaceModBlocks.METAL_SHEET_STAIRS)
         .method_33492(SpaceModBlocks.METAL_SHEET_SLAB)
         .method_33497(SpaceModBlocks.METAL_SHEET_WALL)
         .method_33489(SpaceModBlocks.METAL_SHEET_DOOR)
         .method_33481();
      public static final class_5794 STAINLESS_STEEL = new class_5795(SpaceModBlocks.STAINLESS_STEEL)
         .method_33493(SpaceModBlocks.STAINLESS_STEEL_STAIRS)
         .method_33492(SpaceModBlocks.STAINLESS_STEEL_SLAB)
         .method_33497(SpaceModBlocks.STAINLESS_STEEL_WALL)
         .method_33481();
      public static final class_5794 DARK_STEEL = new class_5795(SpaceModBlocks.DARK_STEEL)
         .method_33493(SpaceModBlocks.DARK_STEEL_STAIRS)
         .method_33492(SpaceModBlocks.DARK_STEEL_SLAB)
         .method_33497(SpaceModBlocks.DARK_STEEL_WALL)
         .method_33481();
      public static final class_5794 MARBLE = new class_5795(SpaceModBlocks.MARBLE)
         .method_33493(SpaceModBlocks.MARBLE_STAIRS)
         .method_33492(SpaceModBlocks.MARBLE_SLAB)
         .method_33497(SpaceModBlocks.MARBLE_WALL)
         .method_33481();
      public static final class_5794 MARBLE_TILE = new class_5795(SpaceModBlocks.MARBLE_TILES)
         .method_33493(SpaceModBlocks.MARBLE_TILE_STAIRS)
         .method_33492(SpaceModBlocks.MARBLE_TILE_SLAB)
         .method_33497(SpaceModBlocks.MARBLE_TILE_WALL)
         .method_33481();
      public static final class_5794 DARK_MARBLE = new class_5795(SpaceModBlocks.DARK_MARBLE)
         .method_33493(SpaceModBlocks.DARK_MARBLE_STAIRS)
         .method_33492(SpaceModBlocks.DARK_MARBLE_SLAB)
         .method_33497(SpaceModBlocks.DARK_MARBLE_WALL)
         .method_33481();
      public static final class_5794 WHITE_HULL = new class_5795(SpaceModBlocks.WHITE_HULL)
         .method_33493(SpaceModBlocks.WHITE_HULL_STAIRS)
         .method_33492(SpaceModBlocks.WHITE_HULL_SLAB)
         .method_33497(SpaceModBlocks.WHITE_HULL_WALL)
         .method_33481();
      public static final class_5794 BLACK_HULL = new class_5795(SpaceModBlocks.BLACK_HULL)
         .method_33493(SpaceModBlocks.BLACK_HULL_STAIRS)
         .method_33492(SpaceModBlocks.BLACK_HULL_SLAB)
         .method_33497(SpaceModBlocks.BLACK_HULL_WALL)
         .method_33481();
      public static final class_5794 BLACK_HULL_SHEET = new class_5795(SpaceModBlocks.BLACK_HULL_SHEETS)
         .method_33493(SpaceModBlocks.BLACK_HULL_SHEET_STAIRS)
         .method_33492(SpaceModBlocks.BLACK_HULL_SHEET_SLAB)
         .method_33497(SpaceModBlocks.BLACK_HULL_SHEET_WALL)
         .method_33481();
      public static final class_5794 MAHOGANY = new class_5795(SpaceModBlocks.MAHOGANY_PLANKS)
         .method_33493(SpaceModBlocks.MAHOGANY_STAIRS)
         .method_33492(SpaceModBlocks.MAHOGANY_SLAB)
         .method_33481();
      public static final class_5794 MAHOGANY_HERRINGBONE = new class_5795(SpaceModBlocks.MAHOGANY_HERRINGBONE)
         .method_33493(SpaceModBlocks.MAHOGANY_HERRINGBONE_STAIRS)
         .method_33492(SpaceModBlocks.MAHOGANY_HERRINGBONE_SLAB)
         .method_33481();
      public static final class_5794 SMOOTH_MAHOGANY = new class_5795(SpaceModBlocks.SMOOTH_MAHOGANY)
         .method_33493(SpaceModBlocks.SMOOTH_MAHOGANY_STAIRS)
         .method_33492(SpaceModBlocks.SMOOTH_MAHOGANY_SLAB)
         .method_33481();
      public static final class_5794 BUBINGA = new class_5795(SpaceModBlocks.BUBINGA_PLANKS)
         .method_33493(SpaceModBlocks.BUBINGA_STAIRS)
         .method_33492(SpaceModBlocks.BUBINGA_SLAB)
         .method_33481();
      public static final class_5794 BUBINGA_HERRINGBONE = new class_5795(SpaceModBlocks.BUBINGA_HERRINGBONE)
         .method_33493(SpaceModBlocks.BUBINGA_HERRINGBONE_STAIRS)
         .method_33492(SpaceModBlocks.BUBINGA_HERRINGBONE_SLAB)
         .method_33481();
      public static final class_5794 SMOOTH_BUBINGA = new class_5795(SpaceModBlocks.SMOOTH_BUBINGA)
         .method_33493(SpaceModBlocks.SMOOTH_BUBINGA_STAIRS)
         .method_33492(SpaceModBlocks.SMOOTH_BUBINGA_SLAB)
         .method_33481();
      public static final class_5794 EBONY = new class_5795(SpaceModBlocks.EBONY_PLANKS)
         .method_33493(SpaceModBlocks.EBONY_STAIRS)
         .method_33492(SpaceModBlocks.EBONY_SLAB)
         .method_33481();
      public static final class_5794 EBONY_HERRINGBONE = new class_5795(SpaceModBlocks.EBONY_HERRINGBONE)
         .method_33493(SpaceModBlocks.EBONY_HERRINGBONE_STAIRS)
         .method_33492(SpaceModBlocks.EBONY_HERRINGBONE_SLAB)
         .method_33481();
      public static final class_5794 SMOOTH_EBONY = new class_5795(SpaceModBlocks.SMOOTH_EBONY)
         .method_33493(SpaceModBlocks.SMOOTH_EBONY_STAIRS)
         .method_33492(SpaceModBlocks.SMOOTH_EBONY_SLAB)
         .method_33481();
      public static final class_5794 NITROGEN_ICE = new class_5795(SpaceModBlocks.NITROGEN_ICE)
         .method_33493(SpaceModBlocks.NITROGEN_ICE_STAIRS)
         .method_33492(SpaceModBlocks.NITROGEN_ICE_SLAB)
         .method_33481();
      public static final class_5794 THOLIN_POOR_NITROGEN_ICE = new class_5795(SpaceModBlocks.THOLIN_POOR_NITROGEN_ICE)
         .method_33493(SpaceModBlocks.THOLIN_POOR_NITROGEN_ICE_STAIRS)
         .method_33492(SpaceModBlocks.THOLIN_POOR_NITROGEN_ICE_SLAB)
         .method_33481();
      public static final class_5794 THOLIN_RICH_NITROGEN_ICE = new class_5795(SpaceModBlocks.THOLIN_RICH_NITROGEN_ICE)
         .method_33493(SpaceModBlocks.THOLIN_RICH_NITROGEN_ICE_STAIRS)
         .method_33492(SpaceModBlocks.THOLIN_RICH_NITROGEN_ICE_SLAB)
         .method_33481();

      static {
         SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
      }
   }

   public static class SetType {
      public static final class_8177 METAL_SHEET = new class_8177(
         "metal_sheet",
         true,
         class_2498.field_11533,
         class_3417.field_14819,
         class_3417.field_14567,
         class_3417.field_15131,
         class_3417.field_15082,
         class_3417.field_15100,
         class_3417.field_14988,
         class_3417.field_14954,
         class_3417.field_14791
      );

      static {
         SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
      }
   }
}
