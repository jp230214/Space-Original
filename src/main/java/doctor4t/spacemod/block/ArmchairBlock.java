package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970.class_2251;

public class ArmchairBlock extends HorizontalFacingMountableBlock {
   public static final class_243 SIT_POS = new class_243(0.5, 0.5, 0.5);
   protected static final class_265 SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 10.0, 16.0);

   public ArmchairBlock(class_2251 settings) {
      super(settings);
   }

   @Override
   public class_243 getNorthFacingSitPos(class_1937 world, class_2680 state, class_2338 pos) {
      return SIT_POS;
   }

   @Override
   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
