package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.AirlockEntity;
import doctor4t.spacemod.entity.SpaceDoorEntity;
import doctor4t.spacemod.index.SpaceModSounds;
import net.minecraft.class_1657;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2269;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_8177;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public abstract class SpaceButtonBlock extends class_2269 {
   public SpaceButtonBlock(class_2251 settings) {
      super(settings, class_8177.field_42819, 20, true);
   }

   public void method_21845(class_2680 state, class_1937 world, class_2338 pos) {
      if (!world.field_9236) {
         for (SpaceDoorEntity door : world.method_8390(SpaceDoorEntity.class, class_238.method_30048(pos.method_46558(), 4.0, 0.0, 4.0), doorx -> true)) {
            door.setOpen(!door.isOpen());
         }

         for (AirlockEntity airlock : world.method_8390(
            AirlockEntity.class, class_238.method_30048(pos.method_46558(), 4.0, 0.0, 4.0), airlockx -> !airlockx.isOpening()
         )) {
            airlock.setOpening(true);
         }
      }

      super.method_21845(state, world, pos);
   }

   protected void method_9714(@Nullable class_1657 player, class_1936 world, class_2338 pos, boolean powered) {
      world.method_8396(powered ? player : null, pos, this.method_9712(powered), class_3419.field_15245, 0.5F, powered ? 1.0F : 1.5F);
   }

   protected class_3414 method_9712(boolean powered) {
      return SpaceModSounds.BLOCK_SPACE_BUTTON_TOGGLE;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
