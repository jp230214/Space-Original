package doctor4t.spacemod.mixin.lowpass;

import dev.upcraft.sdrm.api.SDRMVerifier;
import java.nio.IntBuffer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_4225;
import org.lwjgl.openal.ALC10;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(class_4225.class)
public class LibraryMixin {
   @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lorg/lwjgl/openal/ALC10;alcCreateContext(JLjava/nio/IntBuffer;)J"))
   private long requestAuxSends(long deviceHandle, IntBuffer attrList) {
      return ALC10.alcCreateContext(deviceHandle, new int[]{131075, 4, 0, 0});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
