package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.SprinklerEntity;
import doctor4t.spacemod.index.SpaceModEntities;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2341;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2738;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_4538;
import net.minecraft.class_5819;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class SprinklerBlock extends class_2341 implements class_3737 {
   public static final class_2746 POWERED = class_2741.field_12484;
   public static final class_2753 FACING = class_2741.field_12481;
   public static final class_2746 WATERLOGGED = class_2741.field_12508;
   protected static final class_265 UP_SHAPE = class_2248.method_9541(3.0, 0.0, 3.0, 13.0, 3.0, 13.0);
   protected static final class_265 DOWN_SHAPE = class_2248.method_9541(3.0, 13.0, 3.0, 13.0, 16.0, 13.0);
   protected static final class_265 EAST_SHAPE = class_2248.method_9541(0.0, 3.0, 3.0, 3.0, 13.0, 13.0);
   protected static final class_265 WEST_SHAPE = class_2248.method_9541(13.0, 3.0, 3.0, 16.0, 13.0, 13.0);
   protected static final class_265 SOUTH_SHAPE = class_2248.method_9541(3.0, 3.0, 0.0, 13.0, 13.0, 3.0);
   protected static final class_265 NORTH_SHAPE = class_2248.method_9541(3.0, 3.0, 13.0, 13.0, 13.0, 16.0);

   public SprinklerBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)((class_2680)((class_2680)this.method_9595().method_11664()).method_11657(POWERED, false))
                  .method_11657(FACING, class_2350.field_11043))
               .method_11657(WATERLOGGED, false))
            .method_11657(field_11007, class_2738.field_12471)
      );
   }

   public static class_2350 getDirection(class_2680 state) {
      switch ((class_2738)state.method_11654(field_11007)) {
         case field_12473:
            return class_2350.field_11033;
         case field_12475:
            return class_2350.field_11036;
         default:
            return (class_2350)state.method_11654(FACING);
      }
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      if (state.method_11654(field_11007) == class_2738.field_12473) {
         return DOWN_SHAPE;
      }

      if (state.method_11654(field_11007) == class_2738.field_12475) {
         return UP_SHAPE;
      }

      return switch ((class_2350)state.method_11654(FACING)) {
         case field_11035 -> SOUTH_SHAPE;
         case field_11039 -> WEST_SHAPE;
         case field_11034 -> EAST_SHAPE;
         default -> NORTH_SHAPE;
      };
   }

   public boolean method_9558(class_2680 state, class_4538 world, class_2338 pos) {
      return true;
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_2680 state = super.method_9605(ctx);
      return state != null
         ? (class_2680)((class_2680)state.method_11657(POWERED, ctx.method_8045().method_49803(ctx.method_8037())))
            .method_11657(WATERLOGGED, ctx.method_8045().method_8316(ctx.method_8037()).method_15772() == class_3612.field_15910)
         : null;
   }

   public void method_9612(class_2680 state, class_1937 world, class_2338 pos, class_2248 block, class_2338 fromPos, boolean notify) {
      if (!world.field_9236 && (world.method_49803(pos) || world.method_49803(fromPos))) {
         world.method_39279(pos, this, 4);
      }
   }

   public void method_9588(class_2680 state, class_3218 world, class_2338 pos, class_5819 random) {
      class_2680 cycle = (class_2680)state.method_28493(POWERED);
      world.method_8652(pos, cycle, 2);
      if ((Boolean)cycle.method_11654(POWERED)) {
         SprinklerEntity sprinklerEntity = (SprinklerEntity)SpaceModEntities.SPRINKLER.method_5883(world);
         if (sprinklerEntity == null) {
            return;
         }

         sprinklerEntity.method_5808(pos.method_10263() + 0.5F, pos.method_10264(), pos.method_10260() + 0.5F, 0.0F, 0.0F);
         world.method_8649(sprinklerEntity);
      }
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{POWERED, FACING, WATERLOGGED, field_11007});
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   public boolean method_10311(class_1936 world, class_2338 pos, class_2680 state, class_3610 fluidState) {
      return super.method_10311(world, pos, state, fluidState);
   }

   public boolean method_10310(class_1922 world, class_2338 pos, class_2680 state, class_3611 fluid) {
      return super.method_10310(world, pos, state, fluid);
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
