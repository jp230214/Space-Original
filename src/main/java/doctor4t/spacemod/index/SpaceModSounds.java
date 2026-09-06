package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.class_2378;
import net.minecraft.class_2498;
import net.minecraft.class_3414;
import net.minecraft.class_7923;

public class SpaceModSounds {
   protected static final List<class_3414> SOUND_EVENTS = new LinkedList<>();
   public static final class_3414 BLOCK_CARGO_BOX_OPEN = create("block.cargo_box.open");
   public static final class_3414 BLOCK_CARGO_BOX_CLOSE = create("block.cargo_box.close");
   public static final class_3414 BLOCK_LIGHT_TOGGLE = create("block.light.toggle");
   public static final class_3414 BLOCK_PRIVACY_PANEL_TOGGLE = create("block.privacy_panel.toggle");
   public static final class_3414 BLOCK_SPACE_BUTTON_TOGGLE = create("block.space_button.toggle");
   public static final class_3414 BLOCK_PIPE_EXTEND = create("block.pipe.extend");
   public static final class_3414 BLOCK_ICHOR_GULP = create("block.ichor.gulp");
   public static final class_3414 BLOCK_MAUVE_PLUSH_HONK = create("block.mauve_plush.honk");
   public static final class_3414 MARSHMALLOW_CAN_STORE = create("block.marshmallow_can.store");
   public static final class_3414 MARSHMALLOW_CAN_TAKE = create("block.marshmallow_can.take");
   public static final class_3414 ENTITY_DOOR_TOGGLE = create("entity.door.toggle");
   public static final class_3414 ENTITY_FLASHLIGHT_TOGGLE = create("entity.flashlight.toggle");
   public static final class_3414 ENTITY_SPRINKLER_RUN = create("entity.sprinkler.run");
   public static final class_3414 ENTITY_JETPACK_FLY = create("entity.jetpack.fly");
   public static final class_3414 ENTITY_JETPACK_START = create("entity.jetpack.start");
   public static final class_3414 ENTITY_PUMP_RUN = create("entity.pump.run");
   public static final class_3414 ENTITY_AIRLOCK_CYCLE = create("entity.airlock.cycle");
   public static final class_3414 ENTITY_PLAYER_BREATHE = create("entity.player.breathe");
   public static final class_3414 ENTITY_PLAYER_CHOKE = create("entity.player.choke");
   public static final class_3414 ENTITY_PLAYER_REVIVE = create("entity.player.revive");
   public static final class_3414 AMBIENT_SPACE = create("ambient.space");
   public static final class_3414 AMBIENT_SHIP = create("ambient.ship");
   public static final class_3414 ITEM_STIM_USE = create("item.stim.use");
   public static final class_3414 ITEM_TELESCOPE_ZOOM_IN = create("item.telescope.zoom_in");
   public static final class_3414 ITEM_TELESCOPE_ZOOM_OUT = create("item.telescope.zoom_out");
   public static final class_3414 UI_WARNING_LOW = create("ui.warning.low");
   public static final class_3414 UI_WARNING_CRITICAL = create("ui.warning.critical");

   protected static class_3414 create(String name) {
      class_3414 soundEvent = class_3414.method_47908(SpaceMod.id(name));
      SOUND_EVENTS.add(soundEvent);
      return soundEvent;
   }

   protected static class_2498 createBlockSoundGroup(String name, float volume, float pitch) {
      return new class_2498(
         volume,
         pitch,
         create("block." + name + ".break"),
         create("block." + name + ".step"),
         create("block." + name + ".place"),
         create("block." + name + ".hit"),
         create("block." + name + ".fall")
      );
   }

   protected static class_2498 copyBlockSoundGroup(class_2498 blockSoundGroup, float volume, float pitch) {
      return new class_2498(
         volume,
         pitch,
         blockSoundGroup.method_10595(),
         blockSoundGroup.method_10594(),
         blockSoundGroup.method_10598(),
         blockSoundGroup.method_10596(),
         blockSoundGroup.method_10593()
      );
   }

   public static void initialize() {
      SOUND_EVENTS.forEach(soundEvent -> class_2378.method_10230(class_7923.field_41172, soundEvent.method_14833(), soundEvent));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
