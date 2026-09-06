package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_2213;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;

public class DoorBarrierBlock extends class_2213 {
   public static final class_2754<class_2351> AXIS = class_2741.field_12529;
   protected static final class_265 X_SHAPE = class_2248.method_9541(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);
   protected static final class_265 Z_SHAPE = class_2248.method_9541(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);

   public DoorBarrierBlock(class_2251 settings) {
      super(settings);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return state.method_11654(AXIS) == class_2351.field_11048 ? X_SHAPE : Z_SHAPE;
   }

   public class_265 method_9549(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return state.method_11654(AXIS) == class_2351.field_11048 ? X_SHAPE : Z_SHAPE;
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{AXIS});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
