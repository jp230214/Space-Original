package doctor4t.spacemod.imgui;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import foundry.veil.api.client.editor.SingleWindowEditor;
import imgui.ImGui;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FadeEditor extends SingleWindowEditor {
   protected void renderComponents() {
      float[] f = new float[]{SpaceModClient.fade};
      ImGui.sliderFloat("Fade", f, 0.0F, 1.0F);
      SpaceModClient.fade = f[0];
   }

   public String getDisplayName() {
      return "Fade";
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
