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

public class RailingBlock extends AbstractRailingBlock {
   protected static final class_265 NORTH_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 16.0, 2.0);
   protected static final class_265 EAST_SHAPE = class_2248.method_9541(14.0, 0.0, 0.0, 16.0, 16.0, 16.0);
   protected static final class_265 SOUTH_SHAPE = class_2248.method_9541(0.0, 0.0, 14.0, 16.0, 16.0, 16.0);
   protected static final class_265 WEST_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 2.0, 16.0, 16.0);
   protected static final class_265 NORTH_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 24.0, 2.0);
   protected static final class_265 EAST_COLLISION_SHAPE = class_2248.method_9541(14.0, 0.0, 0.0, 16.0, 24.0, 16.0);
   protected static final class_265 SOUTH_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 14.0, 16.0, 24.0, 16.0);
   protected static final class_265 WEST_COLLISION_SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 2.0, 24.0, 16.0);
   private final class_2248 diagonalRailingBlock;
   private final class_2248 postBlock;

   public RailingBlock(class_2248 diagonalRailingBlock, class_2248 postBlock, class_2251 settings) {
      super(settings);
      this.diagonalRailingBlock = diagonalRailingBlock;
      this.postBlock = postBlock;
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
      if (state == null) {
         return null;
      }

      if (ctx.method_8046()) {
         return this.postBlock.method_9605(ctx);
      }

      class_2680 diagonalState = this.diagonalRailingBlock.method_9605(ctx);
      return diagonalState == null ? state : diagonalState;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
