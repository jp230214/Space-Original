package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.SpaceModKeybinds;
import doctor4t.spacemod.entity.DrivingSeatEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_743;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_743.class)
public abstract class KeyboardInputMixin {
   @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 5))
   public boolean isSneakPressed(class_304 instance, Operation<Boolean> original) {
      if (!class_310.method_1551().method_1493()
         && class_310.method_1551().field_1724.method_5765()
         && class_310.method_1551().field_1724.method_5854() instanceof DrivingSeatEntity) {
         SpaceModClient.goingDown = (Boolean)original.call(new Object[]{instance});
         return SpaceModKeybinds.spaceshipDismount.method_1434();
      } else {
         return (Boolean)original.call(new Object[]{instance});
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
