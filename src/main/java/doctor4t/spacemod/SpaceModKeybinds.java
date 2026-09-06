package doctor4t.spacemod;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_304;
import net.minecraft.class_3675.class_307;

@Environment(EnvType.CLIENT)
public class SpaceModKeybinds {
   public static class_304 spaceshipRoll;
   public static class_304 spaceshipDismount;
   public static class_304 toggleFlashlight;

   public static void initialize() {
      spaceshipRoll = KeyBindingHelper.registerKeyBinding(new class_304("key.spacemod.spaceshipRoll", class_307.field_1668, 82, "category.spacemod"));
      spaceshipDismount = KeyBindingHelper.registerKeyBinding(new class_304("key.spacemod.spaceshipDismount", class_307.field_1668, 345, "category.spacemod"));
      toggleFlashlight = KeyBindingHelper.registerKeyBinding(new class_304("key.spacemod.toggleFlashlight", class_307.field_1668, 84, "category.spacemod"));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
