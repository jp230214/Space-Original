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

public class JetpackBlock extends SpaceSuitPartBlock {
   protected static final class_265 SHAPE = class_2248.method_9541(4.0, 0.0, 4.0, 12.0, 14.0, 12.0);

   public JetpackBlock(class_2251 settings) {
      super(settings);
   }

   public class_1304 method_7685() {
      return class_1304.field_6174;
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   @Override
   public class_2591<? extends SpaceSuitPartBlockEntity> getBlockEntityType() {
      return SpaceModBlockEntities.JETPACK;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
