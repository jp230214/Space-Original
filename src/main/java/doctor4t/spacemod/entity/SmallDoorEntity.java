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

public class SmallDoorEntity extends SpaceDoorEntity {
   public SmallDoorEntity(class_1299<? extends class_1297> entityType, class_1937 world) {
      super(entityType, world);
   }

   public void method_5674(class_2940<?> data) {
      if (data.equals(OPEN)) {
         this.method_5783(SpaceModSounds.ENTITY_DOOR_TOGGLE, 1.0F, 1.0F);
         if (this.method_37908().field_9236) {
            this.openAnimationState.method_41322(this.field_6012);
         }

         class_2350 facing = class_2350.method_10150(this.method_36454());
         class_2680 state = this.isOpen()
            ? class_2246.field_10124.method_9564()
            : (class_2680)SpaceModBlocks.DOOR_BARRIER.method_9564().method_11657(class_2741.field_12529, facing.method_10166());
         class_2338.method_17962(0, 0, 0, 0, 1, 0).forEach(pos -> this.method_37908().method_8501(pos.method_10081(this.method_24515()), state));
      }

      super.method_5674(data);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
