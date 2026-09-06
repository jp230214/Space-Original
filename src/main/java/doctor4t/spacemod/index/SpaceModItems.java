package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.index.tag.SpaceModPaintingVariantTags;
import doctor4t.spacemod.item.MarshmallowStickItem;
import doctor4t.spacemod.item.PocketStarItem;
import doctor4t.spacemod.item.SpaceDoorItem;
import doctor4t.spacemod.item.StimItem;
import doctor4t.spacemod.item.TelescopeItem;
import doctor4t.spacemod.mixin.ItemGroupsAccessor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries;
import net.minecraft.class_1535;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2378;
import net.minecraft.class_2487;
import net.minecraft.class_2960;
import net.minecraft.class_4176;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import net.minecraft.class_1761.class_7705;
import net.minecraft.class_1792.class_1793;
import net.minecraft.class_4174.class_4175;
import net.minecraft.class_7225.class_7226;

public class SpaceModItems {
   protected static final Map<class_1792, class_2960> ITEMS = new LinkedHashMap<>();
   public static final class_1792 BIG_DOOR = create("big_door", new SpaceDoorItem(SpaceModEntities.BIG_DOOR, new class_1793()));
   public static final class_1792 SMALL_GLASS_DOOR = create("small_glass_door", new SpaceDoorItem(SpaceModEntities.SMALL_GLASS_DOOR, new class_1793()));
   public static final class_1792 SMALL_WOOD_DOOR = create("small_wood_door", new SpaceDoorItem(SpaceModEntities.SMALL_WOOD_DOOR, new class_1793()));
   public static final class_1792 AIRLOCK = create("airlock", new SpaceDoorItem(SpaceModEntities.AIRLOCK, new class_1793()));
   public static final class_1792 MARSHMALLOW = create(
      "marshmallow",
      new class_1792(new FabricItemSettings().food(new class_4175().method_19241().method_19238(2).method_19237(0.1F).method_19240().method_19242()))
   );
   public static final class_1792 MARSHMALLOW_STICK = create("marshmallow_stick", new MarshmallowStickItem(new FabricItemSettings().maxCount(1).maxDamage(1)));
   public static final class_1792 STIM = create("stim", new StimItem(new FabricItemSettings()));
   public static final class_1792 RATION = create("ration", new class_1792(new FabricItemSettings().food(class_4176.field_18648)));
   public static final class_1792 TELESCOPE = create("telescope", new TelescopeItem(new FabricItemSettings()));
   public static final class_1792 POCKET_STAR = create("pocket_star", new PocketStarItem(new FabricItemSettings()));

   protected static <T extends class_1792> T create(String name, T item) {
      ITEMS.put(item, SpaceMod.id(name));
      return item;
   }

   public static void initialize() {
      ITEMS.forEach((item, id) -> class_2378.method_10230(class_7923.field_41178, id, item));
      Map<class_1792, Consumer<FabricItemGroupEntries>> stackAppenders = new HashMap<>();
      stackAppenders.put(SpaceModBlocks.SPACE_HELMET.method_8389(), spaceSuitPartStackAppender(SpaceModBlocks.SPACE_HELMET.method_8389()));
      stackAppenders.put(SpaceModBlocks.JETPACK.method_8389(), spaceSuitPartStackAppender(SpaceModBlocks.JETPACK.method_8389()));
      ItemGroupEvents.modifyEntriesEvent(SpaceMod.ITEM_GROUP).register((ModifyEntries)entries -> addItemGroupEntries(entries, stackAppenders));
   }

   private static Consumer<FabricItemGroupEntries> spaceSuitPartStackAppender(class_1792 item) {
      return entries -> {
         for (PlayerSpaceComponent.Type type : PlayerSpaceComponent.Type.values()) {
            class_1799 stack = new class_1799(item);
            class_2487 nbt = new class_2487();
            nbt.method_10582("space_suit_type", type.name);
            stack.method_7959("BlockEntityTag", nbt);
            entries.method_45420(stack);
         }
      };
   }

   private static void addItemGroupEntries(FabricItemGroupEntries entries, Map<class_1792, Consumer<FabricItemGroupEntries>> stackAppenders) {
      ITEMS.keySet().forEach(item -> stackAppenders.getOrDefault(item, itemGroupEntries -> itemGroupEntries.method_45421(item)).accept(entries));
      entries.getContext()
         .comp_1253()
         .method_46759(class_7924.field_41209)
         .ifPresent(
            wrapper -> ItemGroupsAccessor.invokeAddPaintings(
               entries,
               (class_7226<class_1535>)wrapper,
               entry -> entry.method_40220(SpaceModPaintingVariantTags.FROM_REACH_FOR_THE_STARS),
               class_7705.field_40191
            )
         );
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
