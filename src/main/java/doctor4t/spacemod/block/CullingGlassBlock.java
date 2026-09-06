package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_4970.class_2251;

public class CullingGlassBlock extends GlassPanelBlock {
   public CullingGlassBlock(class_2251 settings) {
      super(settings);
   }

   @Override
   public class_265 method_9571(class_2680 state, class_1922 world, class_2338 pos) {
      return switch ((class_2350)state.method_11654(field_10927)) {
         case field_11043 -> NORTH_COLLISION_SHAPE;
         case field_11034 -> EAST_COLLISION_SHAPE;
         case field_11035 -> SOUTH_COLLISION_SHAPE;
         case field_11039 -> WEST_COLLISION_SHAPE;
         case field_11036 -> UP_COLLISION_SHAPE;
         case field_11033 -> DOWN_COLLISION_SHAPE;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
