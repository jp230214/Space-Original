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

public class WallLampBlock extends ToggleableFacingLightBlock {
   public static final class_265 FLOOR_SHAPE = class_259.method_1084(
      class_2248.method_9541(6.0, 0.0, 6.0, 10.0, 10.0, 10.0), class_2248.method_9541(5.0, 1.0, 5.0, 11.0, 9.0, 11.0)
   );
   public static final class_265 CEILING_SHAPE = class_259.method_1084(
      class_2248.method_9541(6.0, 6.0, 6.0, 10.0, 16.0, 10.0), class_2248.method_9541(5.0, 7.0, 5.0, 11.0, 15.0, 11.0)
   );
   public static final class_265 NORTH_SHAPE = class_259.method_1084(
      class_2248.method_9541(6.0, 3.0, 11.0, 10.0, 13.0, 15.0), class_2248.method_9541(5.0, 4.0, 10.0, 11.0, 12.0, 16.0)
   );
   public static final class_265 EAST_SHAPE = class_259.method_1084(
      class_2248.method_9541(1.0, 3.0, 6.0, 5.0, 13.0, 10.0), class_2248.method_9541(0.0, 4.0, 5.0, 6.0, 12.0, 11.0)
   );
   public static final class_265 SOUTH_SHAPE = class_259.method_1084(
      class_2248.method_9541(6.0, 3.0, 1.0, 10.0, 13.0, 5.0), class_2248.method_9541(5.0, 4.0, 0.0, 11.0, 12.0, 6.0)
   );
   public static final class_265 WEST_SHAPE = class_259.method_1084(
      class_2248.method_9541(11.0, 3.0, 6.0, 15.0, 13.0, 10.0), class_2248.method_9541(10.0, 4.0, 5.0, 16.0, 12.0, 11.0)
   );

   public WallLampBlock(class_2251 settings) {
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
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
