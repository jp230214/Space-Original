package doctor4t.spacemod.sound;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.SprinklerEntity;
import doctor4t.spacemod.index.SpaceModSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1101;
import net.minecraft.class_3419;
import net.minecraft.class_5819;

@Environment(EnvType.CLIENT)
public class SprinklerSoundInstance extends class_1101 {
   private final SprinklerEntity sprinklerEntity;

   public SprinklerSoundInstance(SprinklerEntity sprinklerEntity) {
      super(SpaceModSounds.ENTITY_SPRINKLER_RUN, class_3419.field_15245, class_5819.method_43047());
      this.sprinklerEntity = sprinklerEntity;
      this.field_5446 = true;
      this.field_5451 = 0;
      this.field_5442 = 0.0F;
      this.field_5439 = (float)sprinklerEntity.method_23317();
      this.field_5450 = (float)sprinklerEntity.method_23318();
      this.field_5449 = (float)sprinklerEntity.method_23321();
   }

   public boolean method_26273() {
      return !this.sprinklerEntity.method_5701();
   }

   public boolean method_4785() {
      return true;
   }

   public void method_16896() {
      if (this.sprinklerEntity.method_31481()) {
         this.field_5442 = Math.max(this.field_5442 - 0.1F, 0.0F);
         if (this.field_5442 <= 0.0F) {
            this.method_24876();
         }
      } else {
         this.field_5439 = (float)this.sprinklerEntity.method_23317();
         this.field_5450 = (float)this.sprinklerEntity.method_23318();
         this.field_5449 = (float)this.sprinklerEntity.method_23321();
         this.field_5442 = Math.min(this.field_5442 + 0.1F, 1.0F);
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
