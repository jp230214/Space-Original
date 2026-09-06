package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block_entity.OpenableContainerBlockEntity;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import net.minecraft.class_1263;
import net.minecraft.class_1264;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3908;
import net.minecraft.class_3965;
import net.minecraft.class_4838;
import net.minecraft.class_5819;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class CargoBoxBlock extends class_2318 implements class_2343 {
   public static final class_2746 OPEN = class_2741.field_12537;

   public CargoBoxBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)super.method_9564().method_11657(field_10927, class_2350.field_11036)).method_11657(OPEN, false));
   }

   @Nullable
   public class_3908 method_17454(class_2680 state, class_1937 world, class_2338 pos) {
      return (class_3908)world.method_35230(pos, SpaceModBlockEntities.CARGO_BOX).orElse(null);
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      return (class_2680)this.method_9564().method_11657(field_10927, ctx.method_7715().method_10153());
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_10927, OPEN});
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (world.field_9236) {
         return class_1269.field_5812;
      }

      if (world.method_8321(pos) instanceof OpenableContainerBlockEntity entity) {
         player.method_17355(entity);
         class_4838.method_24733(player, true);
      }

      return class_1269.field_21466;
   }

   public void method_9536(class_2680 state, class_1937 world, class_2338 pos, class_2680 newState, boolean moved) {
      if (!state.method_27852(newState.method_26204())) {
         if (world.method_8321(pos) instanceof class_1263 inventory) {
            class_1264.method_5451(world, pos, inventory);
         }

         super.method_9536(state, world, pos, newState, moved);
      }
   }

   public void method_9588(class_2680 state, class_3218 world, class_2338 pos, class_5819 random) {
      world.method_35230(pos, SpaceModBlockEntities.CARGO_BOX).ifPresent(OpenableContainerBlockEntity::tick);
   }

   public void method_9567(class_1937 world, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 stack) {
      if (stack.method_7938()) {
         if (world.method_8321(pos) instanceof OpenableContainerBlockEntity entity) {
            entity.method_17488(stack.method_7964());
         }
      }
   }

   @Nullable
   public class_2586 method_10123(class_2338 pos, class_2680 state) {
      return SpaceModBlockEntities.CARGO_BOX.method_11032(pos, state);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
