package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970.class_2251;

public class BarStoolBlock extends MountableBlock {
   protected static final class_243 SIT_POS = new class_243(0.5, -0.2F, 0.5);
   protected static final class_265 SHAPE = class_259.method_17786(
      class_2248.method_9541(6.0, 0.0, 6.0, 10.0, 1.0, 10.0),
      new class_265[]{
         class_2248.method_9541(7.0, 1.0, 7.0, 9.0, 9.0, 9.0),
         class_2248.method_9541(4.0, 4.0, 4.0, 12.0, 5.0, 12.0),
         class_2248.method_9541(3.0, 9.0, 3.0, 13.0, 12.0, 13.0)
      }
   );

   public BarStoolBlock(class_2251 settings) {
      super(settings);
   }

   @Override
   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   @Override
   public class_243 getSitPos(class_1937 world, class_2680 state, class_2338 pos) {
      return SIT_POS;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
