package doctor4t.spacemod.sound;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.PumpEntity;
import doctor4t.spacemod.index.SpaceModSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1101;
import net.minecraft.class_3419;
import net.minecraft.class_5819;

@Environment(EnvType.CLIENT)
public class PumpSoundInstance extends class_1101 {
   private final PumpEntity pumpEntity;

   public PumpSoundInstance(PumpEntity pumpEntity) {
      super(SpaceModSounds.ENTITY_PUMP_RUN, class_3419.field_15245, class_5819.method_43047());
      this.pumpEntity = pumpEntity;
      this.field_5446 = true;
      this.field_5451 = 0;
      this.field_5442 = 0.0F;
      this.field_5441 = 0.5F;
      this.field_5439 = (float)pumpEntity.method_23317();
      this.field_5450 = (float)pumpEntity.method_23318();
      this.field_5449 = (float)pumpEntity.method_23321();
   }

   public boolean method_26273() {
      return !this.pumpEntity.method_5701();
   }

   public boolean method_4785() {
      return true;
   }

   public void method_16896() {
      if (!this.pumpEntity.method_31481()
         && PumpEntity.shouldPlayAudio(this.pumpEntity.method_37908(), this.pumpEntity.method_24515())
         && this.pumpEntity.getStatus() != PumpEntity.Status.RETRACTING) {
         this.field_5439 = (float)this.pumpEntity.method_23317();
         this.field_5450 = (float)this.pumpEntity.method_23318();
         this.field_5449 = (float)this.pumpEntity.method_23321();
         if (this.pumpEntity.getStatus() == PumpEntity.Status.DEPLOYED) {
            this.field_5442 = Math.min(this.field_5442 + 0.01F, 1.0F);
            this.field_5441 = Math.min(this.field_5441 + 0.01F, 1.0F);
         }
      } else {
         this.field_5442 = Math.max(this.field_5442 - 0.01F, 0.0F);
         this.field_5441 = Math.max(this.field_5441 - 0.01F, 0.5F);
         if (this.field_5442 <= 0.0F) {
            this.method_24876();
         }
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
