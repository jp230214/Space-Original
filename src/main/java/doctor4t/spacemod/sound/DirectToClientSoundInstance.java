package doctor4t.spacemod.sound;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1101;
import net.minecraft.class_1113;
import net.minecraft.class_3414;
import net.minecraft.class_3419;

@Environment(EnvType.CLIENT)
public class DirectToClientSoundInstance extends class_1101 {
   public DirectToClientSoundInstance(class_3414 soundEvent, class_3419 soundCategory) {
      super(soundEvent, soundCategory, class_1113.method_43221());
      this.field_5446 = false;
      this.field_5451 = 0;
      this.field_5442 = 1.0F;
      this.field_18936 = true;
   }

   public void method_16896() {
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
