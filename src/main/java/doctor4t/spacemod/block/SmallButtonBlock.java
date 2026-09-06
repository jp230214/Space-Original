package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2738;
import net.minecraft.class_3726;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_4970.class_2251;

public class SmallButtonBlock extends SpaceButtonBlock {
   protected static final class_265 NORTH_SHAPE = class_2248.method_9541(6.0, 6.0, 14.0, 10.0, 10.0, 16.0);
   protected static final class_265 NORTH_PRESSED_SHAPE = class_2248.method_9541(6.0, 6.0, 15.0, 10.0, 10.0, 16.0);
   protected static final class_265 EAST_SHAPE = class_2248.method_9541(0.0, 6.0, 6.0, 2.0, 10.0, 10.0);
   protected static final class_265 EAST_PRESSED_SHAPE = class_2248.method_9541(0.0, 6.0, 6.0, 1.0, 10.0, 10.0);
   protected static final class_265 SOUTH_SHAPE = class_2248.method_9541(6.0, 6.0, 0.0, 10.0, 10.0, 2.0);
   protected static final class_265 SOUTH_PRESSED_SHAPE = class_2248.method_9541(6.0, 6.0, 0.0, 10.0, 10.0, 1.0);
   protected static final class_265 WEST_SHAPE = class_2248.method_9541(14.0, 6.0, 6.0, 16.0, 10.0, 10.0);
   protected static final class_265 WEST_PRESSED_SHAPE = class_2248.method_9541(15.0, 6.0, 6.0, 16.0, 10.0, 10.0);
   protected static final class_265 FLOOR_X_SHAPE = class_2248.method_9541(6.0, 0.0, 6.0, 10.0, 2.0, 10.0);
   protected static final class_265 FLOOR_X_PRESSED_SHAPE = class_2248.method_9541(6.0, 0.0, 6.0, 10.0, 1.0, 10.0);
   protected static final class_265 FLOOR_Z_SHAPE = class_2248.method_9541(6.0, 0.0, 6.0, 10.0, 2.0, 10.0);
   protected static final class_265 FLOOR_Z_PRESSED_SHAPE = class_2248.method_9541(6.0, 0.0, 6.0, 10.0, 1.0, 10.0);
   protected static final class_265 CEILING_X_SHAPE = class_2248.method_9541(6.0, 14.0, 6.0, 10.0, 16.0, 10.0);
   protected static final class_265 CEILING_X_PRESSED_SHAPE = class_2248.method_9541(6.0, 15.0, 6.0, 10.0, 16.0, 10.0);
   protected static final class_265 CEILING_Z_SHAPE = class_2248.method_9541(6.0, 14.0, 6.0, 10.0, 16.0, 10.0);
   protected static final class_265 CEILING_Z_PRESSED_SHAPE = class_2248.method_9541(6.0, 15.0, 6.0, 10.0, 16.0, 10.0);

   public SmallButtonBlock(class_2251 settings) {
      super(settings);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      boolean pressed = (Boolean)state.method_11654(field_10729);
      class_2350 facing = (class_2350)state.method_11654(field_11177);
      class_2738 face = (class_2738)state.method_11654(field_11007);
      boolean xAxis = facing.method_10166() == class_2351.field_11048;

      return switch (face) {
         case field_12473 -> xAxis ? (pressed ? CEILING_X_PRESSED_SHAPE : CEILING_X_SHAPE) : (pressed ? CEILING_Z_PRESSED_SHAPE : CEILING_Z_SHAPE);
         case field_12471 -> {
            switch (facing) {
               case field_11043:
                  yield pressed ? NORTH_PRESSED_SHAPE : NORTH_SHAPE;
               case field_11034:
                  yield pressed ? EAST_PRESSED_SHAPE : EAST_SHAPE;
               case field_11035:
                  yield pressed ? SOUTH_PRESSED_SHAPE : SOUTH_SHAPE;
               default:
                  yield pressed ? WEST_PRESSED_SHAPE : WEST_SHAPE;
            }
         }
         case field_12475 -> xAxis ? (pressed ? FLOOR_X_PRESSED_SHAPE : FLOOR_X_SHAPE) : (pressed ? FLOOR_Z_PRESSED_SHAPE : FLOOR_Z_SHAPE);
         default -> throw new IncompatibleClassChangeError();
      };
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
