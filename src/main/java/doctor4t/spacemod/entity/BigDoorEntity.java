package doctor4t.spacemod.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.SpaceModSounds;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2940;

public class BigDoorEntity extends SpaceDoorEntity {
   public BigDoorEntity(class_1299<? extends class_1297> entityType, class_1937 world) {
      super(entityType, world);
   }

   public void method_5674(class_2940<?> data) {
      if (data.equals(OPEN)) {
         this.method_5783(SpaceModSounds.ENTITY_DOOR_TOGGLE, 1.0F, 1.0F);
         if (this.method_37908().field_9236) {
            this.openAnimationState.method_41322(this.field_6012);
         } else {
            class_2350 facing = class_2350.method_10150(this.method_36454());
            class_2350 side = facing.method_10170();
            class_2680 state = this.isOpen()
               ? class_2246.field_10124.method_9564()
               : (class_2680)SpaceModBlocks.DOOR_BARRIER.method_9564().method_11657(class_2741.field_12529, facing.method_10166());
            int offsetX = Math.abs(side.method_10148());
            int offsetZ = Math.abs(side.method_10165());
            class_2338.method_17962(-offsetX, 0, -offsetZ, offsetX, 3, offsetZ)
               .forEach(pos -> this.method_37908().method_8501(pos.method_10081(this.method_24515()), state));
         }
      }

      super.method_5674(data);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
