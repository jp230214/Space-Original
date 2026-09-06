package doctor4t.spacemod.sound;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1101;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import net.minecraft.class_5819;

@Environment(EnvType.CLIENT)
public class JetpackSoundInstance extends class_1101 {
   private final class_1657 playerEntity;
   private boolean dirty;

   public JetpackSoundInstance(class_1657 playerEntity) {
      super(SpaceModSounds.ENTITY_JETPACK_FLY, class_3419.field_15245, class_5819.method_43047());
      this.playerEntity = playerEntity;
      this.field_5446 = true;
      this.field_5451 = 0;
      this.field_5442 = 1.0F;
      this.field_5439 = (float)playerEntity.method_23317();
      this.field_5450 = (float)playerEntity.method_23318();
      this.field_5449 = (float)playerEntity.method_23321();
   }

   public boolean method_26273() {
      return !this.playerEntity.method_5701();
   }

   public boolean method_4785() {
      return true;
   }

   public void method_16896() {
      if (!this.playerEntity.method_31481() && !this.isDirty()) {
         if (this.method_4793()) {
            class_310.method_1551().method_1483().method_22140(new JetpackSoundInstance(this.playerEntity));
            this.method_24876();
         }

         this.field_5439 = (float)this.playerEntity.method_23317();
         this.field_5450 = (float)this.playerEntity.method_23318();
         this.field_5449 = (float)this.playerEntity.method_23321();
      } else {
         this.field_5442 = Math.max(this.field_5442 - 0.2F, 0.0F);
         if (this.field_5442 <= 0.0F) {
            this.method_24876();
         }
      }
   }

   public boolean isDirty() {
      return this.dirty;
   }

   public void setDirty(boolean dirty) {
      this.dirty = dirty;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
