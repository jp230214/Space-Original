package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.block_entity.SpaceSuitPartBlockEntity;
import java.util.List;
import net.minecraft.class_10;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_156;
import net.minecraft.class_1657;
import net.minecraft.class_1747;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2415;
import net.minecraft.class_2470;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_259;
import net.minecraft.class_2591;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3965;
import net.minecraft.class_5151;
import net.minecraft.class_7718;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public abstract class SpaceSuitPartBlock extends class_2237 implements class_5151 {
   public static final int MAX_ROTATION_INDEX = class_7718.method_45478();
   public static final class_2758 ROTATION = class_2741.field_12532;
   private static final int MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;

   public SpaceSuitPartBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)this.field_10647.method_11664()).method_11657(ROTATION, 0));
   }

   public abstract class_2591<? extends SpaceSuitPartBlockEntity> getBlockEntityType();

   public void method_9567(class_1937 world, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 itemStack) {
      if (world.field_9236) {
         world.method_35230(pos, this.getBlockEntityType()).ifPresent(entity -> entity.readFrom(itemStack));
      }
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      class_1304 slot = this.method_7685();
      if (player.method_6118(slot).method_7960() && player.method_5998(hand).method_7960()) {
         class_1799 stack = this.getItemStack(world, pos);
         player.method_5673(this.method_7685(), stack);
         player.method_6116(this.method_7685(), class_1799.field_8037, stack);
         world.method_8652(pos, class_2246.field_10124.method_9564(), 3);
         return class_1269.method_29236(world.field_9236);
      } else {
         return super.method_9534(state, world, pos, player, hand, hit);
      }
   }

   public class_1799 getItemStack(class_1936 world, class_2338 pos) {
      return world.method_35230(pos, this.getBlockEntityType()).map(entity -> {
         class_1799 stack = new class_1799(this.method_8389());
         class_2487 nbt = new class_2487();
         nbt.method_10582("space_suit_type", entity.getSpaceSuitType().name);
         stack.method_7959("BlockEntityTag", nbt);
         return stack;
      }).orElse(class_1799.field_8037);
   }

   @Nullable
   public class_2586 method_10123(class_2338 pos, class_2680 state) {
      return this.getBlockEntityType().method_11032(pos, state);
   }

   public boolean method_9516(class_2680 state, class_1922 world, class_2338 pos, class_10 type) {
      return false;
   }

   public class_265 method_9571(class_2680 state, class_1922 world, class_2338 pos) {
      return class_259.method_1073();
   }

   public class_2680 method_9605(class_1750 ctx) {
      return (class_2680)this.method_9564().method_11657(ROTATION, class_7718.method_45479(ctx.method_8044()));
   }

   public class_2680 method_9598(class_2680 state, class_2470 rotation) {
      return (class_2680)state.method_11657(ROTATION, rotation.method_10502((Integer)state.method_11654(ROTATION), MAX_ROTATIONS));
   }

   public class_2680 method_9569(class_2680 state, class_2415 mirror) {
      return (class_2680)state.method_11657(ROTATION, mirror.method_10344((Integer)state.method_11654(ROTATION), MAX_ROTATIONS));
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{ROTATION});
   }

   public class_3414 method_31570() {
      return class_3417.field_21866;
   }

   public void method_9568(class_1799 stack, @Nullable class_1922 world, List<class_2561> tooltip, class_1836 options) {
      super.method_9568(stack, world, tooltip, options);
      class_2487 nbt = class_1747.method_38072(stack);
      if (nbt != null && nbt.method_10573("space_suit_type", 8)) {
         String type = nbt.method_10558("space_suit_type");
         if (type.equals("default")) {
            return;
         }

         String key = class_156.method_646("space_suit_type", SpaceMod.id(type));
         tooltip.add(class_2561.method_43471(key).method_27692(class_124.field_1080));
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
