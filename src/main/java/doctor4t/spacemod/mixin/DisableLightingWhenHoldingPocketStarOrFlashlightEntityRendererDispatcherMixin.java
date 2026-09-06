package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_898;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_898.class)
public class DisableLightingWhenHoldingPocketStarOrFlashlightEntityRendererDispatcherMixin {
   @ModifyReturnValue(method = "getLight", at = @At("RETURN"))
   public <E extends class_1297> int getLight(int original, E entity, float tickDelta) {
      if (entity instanceof class_1657 player) {
         PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
         if (playerSpaceComponent.isFlashlightOn() || playerSpaceComponent.isHoldingPocketStar()) {
            return 15728880;
         }
      }

      return original;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
