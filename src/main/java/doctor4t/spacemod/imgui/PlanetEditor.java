package doctor4t.spacemod.imgui;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.ClientPlanetStorage;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.planet.Planet;
import foundry.veil.api.client.editor.SingleWindowEditor;
import imgui.ImGui;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class PlanetEditor extends SingleWindowEditor {
   protected void renderComponents() {
      ClientPlanetStorage storage = SpaceModClient.clientPlanetStorage;

      for (Planet planet : storage.getPlanets()) {
         if (ImGui.collapsingHeader("Planet " + planet.getId())) {
            ImGui.pushID(planet.getId());
            ImGui.popID();
         }
      }
   }

   public String getDisplayName() {
      return "Planets";
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
