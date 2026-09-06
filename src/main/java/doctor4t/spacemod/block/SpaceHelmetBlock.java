package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block_entity.SpaceSuitPartBlockEntity;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import net.minecraft.class_1304;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2591;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970.class_2251;

public class SpaceHelmetBlock extends SpaceSuitPartBlock {
   protected static final class_265 SHAPE = class_2248.method_9541(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);

   public SpaceHelmetBlock(class_2251 settings) {
      super(settings);
   }

   @Override
   public class_2591<? extends SpaceSuitPartBlockEntity> getBlockEntityType() {
      return SpaceModBlockEntities.SPACE_HELMET;
   }

   public class_1304 method_7685() {
      return class_1304.field_6169;
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
