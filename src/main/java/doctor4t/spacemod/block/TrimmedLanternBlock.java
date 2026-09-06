package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970.class_2251;

public class TrimmedLanternBlock extends ToggleableFacingLightBlock {
   protected static final class_265 FLOOR_SHAPE = class_259.method_1084(
      class_2248.method_9541(3.0, 0.0, 3.0, 13.0, 10.0, 13.0), class_2248.method_9541(2.0, 4.0, 2.0, 14.0, 6.0, 14.0)
   );
   protected static final class_265 CEILING_SHAPE = class_259.method_1084(
      class_2248.method_9541(3.0, 6.0, 3.0, 13.0, 16.0, 13.0), class_2248.method_9541(2.0, 10.0, 2.0, 14.0, 12.0, 14.0)
   );
   protected static final class_265 NORTH_SHAPE = class_259.method_1084(
      class_2248.method_9541(3.0, 3.0, 10.0, 13.0, 13.0, 14.0), class_2248.method_9541(2.0, 2.0, 14.0, 14.0, 14.0, 16.0)
   );
   protected static final class_265 EAST_SHAPE = class_259.method_1084(
      class_2248.method_9541(2.0, 3.0, 3.0, 6.0, 13.0, 13.0), class_2248.method_9541(0.0, 2.0, 2.0, 2.0, 14.0, 14.0)
   );
   protected static final class_265 SOUTH_SHAPE = class_259.method_1084(
      class_2248.method_9541(3.0, 3.0, 2.0, 13.0, 13.0, 6.0), class_2248.method_9541(2.0, 2.0, 0.0, 14.0, 14.0, 2.0)
   );
   protected static final class_265 WEST_SHAPE = class_259.method_1084(
      class_2248.method_9541(10.0, 3.0, 3.0, 14.0, 13.0, 13.0), class_2248.method_9541(14.0, 2.0, 2.0, 16.0, 14.0, 14.0)
   );

   public TrimmedLanternBlock(class_2251 settings) {
      super(settings);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return switch ((class_2350)state.method_11654(field_10927)) {
         case field_11043 -> NORTH_SHAPE;
         case field_11034 -> EAST_SHAPE;
         case field_11035 -> SOUTH_SHAPE;
         case field_11039 -> WEST_SHAPE;
         case field_11036 -> FLOOR_SHAPE;
         case field_11033 -> CEILING_SHAPE;
         default -> throw new IncompatibleClassChangeError();
      };
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
