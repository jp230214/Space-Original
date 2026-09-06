package doctor4t.spacemod.datagen;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.OrnamentBlock;
import doctor4t.spacemod.block.PanelBlock;
import doctor4t.spacemod.index.SpaceModBlocks;
import java.util.function.Consumer;
import java.util.function.Function;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.class_141;
import net.minecraft.class_212;
import net.minecraft.class_2244;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2742;
import net.minecraft.class_3837;
import net.minecraft.class_44;
import net.minecraft.class_52;
import net.minecraft.class_55;
import net.minecraft.class_5646;
import net.minecraft.class_5794;
import net.minecraft.class_77;
import net.minecraft.class_4559.class_4560;
import net.minecraft.class_52.class_53;
import net.minecraft.class_55.class_56;
import net.minecraft.class_79.class_80;
import net.minecraft.class_85.class_86;

public class SpaceModBlockLootTableGen extends FabricBlockLootTableProvider {
   public SpaceModBlockLootTableGen(FabricDataOutput dataOutput) {
      super(dataOutput);
   }

   public void method_10379() {
      this.addSelfDrop(SpaceModBlocks.METAL_VENT_SHAFT);
      this.addSelfDrop(SpaceModBlocks.METAL_VENT_HATCH);
      this.addSelfDrop(SpaceModBlocks.CAST_VENT_SHAFT);
      this.addSelfDrop(SpaceModBlocks.CAST_VENT_HATCH);
      this.addSelfDrop(SpaceModBlocks.TARNISHED_GOLD_VENT_SHAFT);
      this.addSelfDrop(SpaceModBlocks.TARNISHED_GOLD_VENT_HATCH);
      this.addFamily(SpaceModBlocks.Family.TARNISHED_GOLD);
      this.addSelfDrop(SpaceModBlocks.TARNISHED_GOLD_PILLAR);
      this.addFamily(SpaceModBlocks.Family.GOLD);
      this.addSelfDrop(SpaceModBlocks.GOLD_PILLAR);
      this.addFamily(SpaceModBlocks.Family.PRISTINE_GOLD);
      this.addSelfDrop(SpaceModBlocks.PRISTINE_GOLD_PILLAR);
      this.addFamily(SpaceModBlocks.Family.WHITE_HULL);
      this.addSelfDrop(SpaceModBlocks.CULLING_WHITE_HULL);
      this.addFamily(SpaceModBlocks.Family.BLACK_HULL);
      this.addSelfDrop(SpaceModBlocks.CULLING_BLACK_HULL);
      this.addFamily(SpaceModBlocks.Family.BLACK_HULL_SHEET);
      this.addSelfDrop(SpaceModBlocks.METAL_SHEET);
      this.addSelfDrop(SpaceModBlocks.METAL_SHEET_STAIRS);
      this.addSelfDrop(SpaceModBlocks.METAL_SHEET_SLAB);
      this.addSelfDrop(SpaceModBlocks.METAL_SHEET_WALL);
      this.addSelfDrop(SpaceModBlocks.METAL_SHEET_DOOR, this::method_46022);
      this.addSelfDrop(SpaceModBlocks.METAL_SHEET_WALKWAY);
      this.addSelfDrop(SpaceModBlocks.METAL_LADDER);
      this.addFamily(SpaceModBlocks.Family.STAINLESS_STEEL);
      this.addSelfDrop(SpaceModBlocks.STAINLESS_STEEL_WALKWAY);
      this.addSelfDrop(SpaceModBlocks.STAINLESS_STEEL_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STAINLESS_STEEL_PILLAR);
      this.addSelfDrop(SpaceModBlocks.GOLDEN_GLASS_PANEL);
      this.addSelfDrop(SpaceModBlocks.CULLING_GLASS);
      this.addSelfDrop(SpaceModBlocks.RHOMBUS_GLASS);
      this.addSelfDrop(SpaceModBlocks.HULL_GLASS);
      this.addSelfDrop(SpaceModBlocks.PRIVACY_GLASS_PANEL);
      this.addFamily(SpaceModBlocks.Family.MARBLE);
      this.addSelfDrop(SpaceModBlocks.MARBLE_MOSAIC);
      this.addFamily(SpaceModBlocks.Family.MARBLE_TILE);
      this.addFamily(SpaceModBlocks.Family.DARK_MARBLE);
      this.addFamily(SpaceModBlocks.Family.MAHOGANY);
      this.addFamily(SpaceModBlocks.Family.MAHOGANY_HERRINGBONE);
      this.addFamily(SpaceModBlocks.Family.SMOOTH_MAHOGANY);
      this.addSelfDrop(SpaceModBlocks.MAHOGANY_PANEL, this::panelDrops);
      this.addSelfDrop(SpaceModBlocks.MAHOGANY_CABINET, this::method_45996);
      this.addSelfDrop(SpaceModBlocks.MAHOGANY_BOOKSHELF);
      this.addFamily(SpaceModBlocks.Family.BUBINGA);
      this.addFamily(SpaceModBlocks.Family.BUBINGA_HERRINGBONE);
      this.addFamily(SpaceModBlocks.Family.SMOOTH_BUBINGA);
      this.addSelfDrop(SpaceModBlocks.BUBINGA_PANEL, this::panelDrops);
      this.addSelfDrop(SpaceModBlocks.BUBINGA_CABINET, this::method_45996);
      this.addSelfDrop(SpaceModBlocks.BUBINGA_BOOKSHELF);
      this.addFamily(SpaceModBlocks.Family.EBONY);
      this.addFamily(SpaceModBlocks.Family.EBONY_HERRINGBONE);
      this.addFamily(SpaceModBlocks.Family.SMOOTH_EBONY);
      this.addSelfDrop(SpaceModBlocks.EBONY_PANEL, this::panelDrops);
      this.addSelfDrop(SpaceModBlocks.EBONY_CABINET, this::method_45996);
      this.addSelfDrop(SpaceModBlocks.TRIMMED_EBONY_STAIRS);
      this.addSelfDrop(SpaceModBlocks.EBONY_BOOKSHELF);
      this.addSelfDrop(SpaceModBlocks.OAK_BRANCH);
      this.addSelfDrop(SpaceModBlocks.SPRUCE_BRANCH);
      this.addSelfDrop(SpaceModBlocks.BIRCH_BRANCH);
      this.addSelfDrop(SpaceModBlocks.JUNGLE_BRANCH);
      this.addSelfDrop(SpaceModBlocks.ACACIA_BRANCH);
      this.addSelfDrop(SpaceModBlocks.DARK_OAK_BRANCH);
      this.addSelfDrop(SpaceModBlocks.MANGROVE_BRANCH);
      this.addSelfDrop(SpaceModBlocks.CHERRY_BRANCH);
      this.addSelfDrop(SpaceModBlocks.BAMBOO_POLE);
      this.addSelfDrop(SpaceModBlocks.CRIMSON_STIPE);
      this.addSelfDrop(SpaceModBlocks.WARPED_STIPE);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_OAK_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_SPRUCE_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_BIRCH_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_JUNGLE_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_ACACIA_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_DARK_OAK_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_MANGROVE_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_CHERRY_BRANCH);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_BAMBOO_POLE);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_CRIMSON_STIPE);
      this.addSelfDrop(SpaceModBlocks.STRIPPED_WARPED_STIPE);
      this.addSelfDrop(SpaceModBlocks.PANEL_STRIPES);
      this.addSelfDrop(SpaceModBlocks.TRIMMED_RAILING_POST, block -> this.method_45976(SpaceModBlocks.TRIMMED_RAILING));
      this.addSelfDrop(SpaceModBlocks.DIAGONAL_TRIMMED_RAILING, block -> this.method_45976(SpaceModBlocks.TRIMMED_RAILING));
      this.addSelfDrop(SpaceModBlocks.TRIMMED_RAILING);
      this.addSelfDrop(SpaceModBlocks.CARGO_BOX, this::method_45996);
      this.addSelfDrop(SpaceModBlocks.WHITE_LOUNGE_COUCH);
      this.addSelfDrop(SpaceModBlocks.DRIVING_SEAT);
      this.addSelfDrop(SpaceModBlocks.WHITE_OTTOMAN);
      this.addSelfDrop(SpaceModBlocks.WHITE_TRIMMED_BED, block -> this.method_45987(block, class_2244.field_9967, class_2742.field_12560));
      this.addSelfDrop(SpaceModBlocks.RED_TRIMMED_BED, block -> this.method_45987(block, class_2244.field_9967, class_2742.field_12560));
      this.addSelfDrop(SpaceModBlocks.BLUE_LOUNGE_COUCH);
      this.addSelfDrop(SpaceModBlocks.GREEN_LOUNGE_COUCH);
      this.addSelfDrop(SpaceModBlocks.RED_LEATHER_COUCH);
      this.addSelfDrop(SpaceModBlocks.BROWN_LEATHER_COUCH);
      this.addSelfDrop(SpaceModBlocks.BEIGE_LEATHER_COUCH);
      this.addSelfDrop(SpaceModBlocks.COFFEE_TABLE);
      this.addSelfDrop(SpaceModBlocks.BAR_TABLE);
      this.addSelfDrop(SpaceModBlocks.BAR_STOOL);
      this.addSelfDrop(SpaceModBlocks.GOLD_BAR);
      this.addSelfDrop(SpaceModBlocks.TRIMMED_LANTERN);
      this.addSelfDrop(SpaceModBlocks.METAL_SPRINKLER);
      this.addSelfDrop(SpaceModBlocks.GOLD_SPRINKLER);
      this.addSelfDrop(SpaceModBlocks.WALL_LAMP);
      this.addSelfDrop(SpaceModBlocks.NEON_PILLAR);
      this.addSelfDrop(SpaceModBlocks.MAUVE_PLUSH);
      this.addSelfDrop(SpaceModBlocks.SMALL_BUTTON);
      this.addSelfDrop(SpaceModBlocks.ELEVATOR_BUTTON);
      this.addSelfDrop(SpaceModBlocks.MARSHMALLOW_CAN);
      this.addSelfDrop(SpaceModBlocks.GOLD_ORNAMENT, this::ornamentDrops);
      this.addFamily(SpaceModBlocks.Family.NITROGEN_ICE);
      this.addFamily(SpaceModBlocks.Family.THOLIN_POOR_NITROGEN_ICE);
      this.addFamily(SpaceModBlocks.Family.THOLIN_RICH_NITROGEN_ICE);
      this.addSelfDrop(SpaceModBlocks.DENSE_NITROGEN_ICE);
      this.addSelfDrop(SpaceModBlocks.DENSE_ICHOR_POOR_NITROGEN_ICE);
      this.addSelfDrop(SpaceModBlocks.DENSE_ICHOR_RICH_NITROGEN_ICE);
      this.addNothingDrop(SpaceModBlocks.LIQUID_ICHOR);
      this.addNothingDrop(SpaceModBlocks.DOOR_BARRIER);
      this.addSelfDrop(SpaceModBlocks.SPACE_HELMET, this::spaceSuitPartDrops);
      this.addSelfDrop(SpaceModBlocks.JETPACK, this::spaceSuitPartDrops);
   }

   protected void addFamily(class_5794 family) {
      this.addFamily(family, this::addSelfDrop);
   }

   protected void addFamily(class_5794 family, Consumer<class_2248> consumer) {
      family.method_33474().values().forEach(consumer);
      consumer.accept(family.method_33469());
   }

   protected void addSelfDrop(class_2248 block) {
      this.addSelfDrop(block, this::method_45976);
   }

   protected void addSelfDrop(class_2248 block, Function<class_2248, class_53> function) {
      if (block.method_36555() == -1.0F) {
         this.method_45988(block, method_45975());
      } else {
         this.method_45994(block, function);
      }
   }

   protected void addNothingDrop(class_2248 block) {
      this.method_45988(block, method_45975());
   }

   protected class_44 count(float value) {
      return class_44.method_32448(value);
   }

   protected class_53 panelDrops(class_2248 block) {
      return class_52.method_324()
         .method_336(
            class_55.method_347()
               .method_351(
                  ((class_86)((class_86)this.method_45978(block, class_77.method_411(block)))
                        .method_43740(
                           class_2350.values(),
                           direction -> class_141.method_35540(this.count(1.0F), true)
                              .method_524(
                                 class_212.method_900(block).method_22584(class_4560.method_22523().method_22527(PanelBlock.method_33374(direction), true))
                              )
                        ))
                     .method_438(class_141.method_35540(this.count(-1.0F), true))
               )
         );
   }

   protected class_53 ornamentDrops(class_2248 block) {
      return class_52.method_324()
         .method_336(
            class_55.method_347()
               .method_351(
                  (class_80)((class_86)this.method_45978(block, class_77.method_411(block)))
                     .method_43740(
                        OrnamentBlock.OrnamentShape.values(),
                        shape -> class_141.method_35540(this.count(shape.getCount()), false)
                           .method_524(class_212.method_900(block).method_22584(class_4560.method_22523().method_22525(OrnamentBlock.SHAPE, shape)))
                     )
               )
         );
   }

   protected class_53 spaceSuitPartDrops(class_2248 block) {
      return class_52.method_324()
         .method_336(
            (class_56)this.method_45978(
               block,
               class_55.method_347()
                  .method_352(this.count(1.0F))
                  .method_351(
                     class_77.method_411(block)
                        .method_438(class_3837.method_16848(class_5646.field_27914).method_16856("space_suit_type", "BlockEntityTag.space_suit_type"))
                  )
            )
         );
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
