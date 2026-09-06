package doctor4t.spacemod.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.PocketStarEntity;
import doctor4t.spacemod.index.SpaceModEntities;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_1792.class_1793;

public class PocketStarItem extends class_1792 {
   public PocketStarItem(class_1793 settings) {
      super(settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      if (world.field_9236) {
         return class_1271.method_22428(user.method_5998(hand));
      }

      PocketStarEntity pocketStarEntity = (PocketStarEntity)SpaceModEntities.POCKET_STAR.method_5883(world);
      if (pocketStarEntity == null) {
         return class_1271.method_22431(user.method_5998(hand));
      }

      pocketStarEntity.method_5808(user.method_23317(), user.method_23320(), user.method_23321(), 0.0F, 0.0F);
      pocketStarEntity.impulse(user.method_5720());
      world.method_8649(pocketStarEntity);
      user.method_5998(hand).method_7934(1);
      return class_1271.method_22427(user.method_5998(hand));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
