package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class RailingPostBlock extends AbstractRailingBlock {
   protected static final class_265 NORTH_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 2.0, 16.0, 2.0);
   protected static final class_265 EAST_SHAPE = class_2248.method_9541(14.0, 0.0, 0.0, 16.0, 16.0, 2.0);
   protected static final class_265 SOUTH_SHAPE = class_2248.method_9541(14.0, 0.0, 14.0, 16.0, 16.0, 16.0);
   protected static final class_265 WEST_SHAPE = class_2248.method_9541(0.0, 0.0, 14.0, 2.0, 16.0, 16.0);
   protected static final class_265 NORTH_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 2.0, 24.0, 2.0);
   protected static final class_265 EAST_COLLISION_SHAPE = class_2248.method_9541(14.0, 0.0, 0.0, 16.0, 24.0, 2.0);
   protected static final class_265 SOUTH_COLLISION_SHAPE = class_2248.method_9541(14.0, 0.0, 14.0, 16.0, 24.0, 16.0);
   protected static final class_265 WEST_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 14.0, 2.0, 24.0, 16.0);

   public RailingPostBlock(class_2251 settings) {
      super(settings);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return switch ((class_2350)state.method_11654(field_11177)) {
         case field_11043 -> NORTH_SHAPE;
         case field_11034 -> EAST_SHAPE;
         case field_11035 -> SOUTH_SHAPE;
         default -> WEST_SHAPE;
      };
   }

   public class_265 method_9549(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return switch ((class_2350)state.method_11654(field_11177)) {
         case field_11043 -> NORTH_COLLISION_SHAPE;
         case field_11034 -> EAST_COLLISION_SHAPE;
         case field_11035 -> SOUTH_COLLISION_SHAPE;
         default -> WEST_COLLISION_SHAPE;
      };
   }

   @Nullable
   @Override
   public class_2680 method_9605(class_1750 ctx) {
      class_2680 state = super.method_9605(ctx);
      return state == null ? null : (class_2680)state.method_11657(field_11177, class_2350.method_10150(ctx.method_8044() + 45.0));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
