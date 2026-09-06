package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import java.util.Optional;
import net.minecraft.class_10;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_1941;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2383;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2742;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_5275;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4732.class_4733;
import net.minecraft.class_4970.class_2251;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

public class TrimmedBedBlock extends class_2383 {
   public static final class_2754<class_2742> PART = class_2741.field_12483;
   public static final class_2746 OCCUPIED = class_2741.field_12528;
   public static final class_265 SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);

   public TrimmedBedBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)this.field_10647.method_11664()).method_11657(PART, class_2742.field_12557)).method_11657(OCCUPIED, false)
      );
   }

   @Nullable
   public static class_2350 getDirection(class_1922 world, class_2338 pos) {
      class_2680 blockState = world.method_8320(pos);
      return blockState.method_26204() instanceof TrimmedBedBlock ? (class_2350)blockState.method_11654(field_11177) : null;
   }

   private static class_2350 getDirectionTowardsOtherPart(class_2742 part, class_2350 direction) {
      return part == class_2742.field_12557 ? direction : direction.method_10153();
   }

   public static class_2350 getOppositePartDirection(class_2680 state) {
      class_2350 direction = (class_2350)state.method_11654(field_11177);
      return state.method_11654(PART) == class_2742.field_12560 ? direction.method_10153() : direction;
   }

   public static class_4733 getBedPart(class_2680 state) {
      class_2742 bedPart = (class_2742)state.method_11654(PART);
      return bedPart == class_2742.field_12560 ? class_4733.field_21784 : class_4733.field_21785;
   }

   private static boolean isBedBelow(class_1922 world, class_2338 pos) {
      return world.method_8320(pos.method_10074()).method_26204() instanceof TrimmedBedBlock;
   }

   public static Optional<class_243> findWakeUpPosition(class_1299<?> type, class_1941 world, class_2338 pos, class_2350 bedDirection, float spawnAngle) {
      class_2350 direction = bedDirection.method_10170();
      class_2350 direction2 = direction.method_30928(spawnAngle) ? direction.method_10153() : direction;
      if (isBedBelow(world, pos)) {
         return findWakeUpPosition(type, world, pos, bedDirection, direction2);
      }

      int[][] is = getAroundAndOnBedOffsets(bedDirection, direction2);
      Optional<class_243> optional = findWakeUpPosition(type, world, pos, is, true);
      return optional.isPresent() ? optional : findWakeUpPosition(type, world, pos, is, false);
   }

   private static Optional<class_243> findWakeUpPosition(
      class_1299<?> type, class_1941 world, class_2338 pos, class_2350 bedDirection, class_2350 respawnDirection
   ) {
      int[][] is = getAroundBedOffsets(bedDirection, respawnDirection);
      Optional<class_243> optional = findWakeUpPosition(type, world, pos, is, true);
      if (optional.isPresent()) {
         return optional;
      }

      class_2338 blockPos = pos.method_10074();
      Optional<class_243> optional2 = findWakeUpPosition(type, world, blockPos, is, true);
      if (optional2.isPresent()) {
         return optional2;
      }

      int[][] js = getOnBedOffsets(bedDirection);
      Optional<class_243> optional3 = findWakeUpPosition(type, world, pos, js, true);
      if (optional3.isPresent()) {
         return optional3;
      }

      Optional<class_243> optional4 = findWakeUpPosition(type, world, pos, is, false);
      if (optional4.isPresent()) {
         return optional4;
      }

      Optional<class_243> optional5 = findWakeUpPosition(type, world, blockPos, is, false);
      return optional5.isPresent() ? optional5 : findWakeUpPosition(type, world, pos, js, false);
   }

   private static Optional<class_243> findWakeUpPosition(
      class_1299<?> type, class_1941 world, class_2338 pos, int[][] possibleOffsets, boolean ignoreInvalidPos
   ) {
      class_2339 mutable = new class_2339();

      for (int[] is : possibleOffsets) {
         mutable.method_10103(pos.method_10263() + is[0], pos.method_10264(), pos.method_10260() + is[1]);
         class_243 vec3d = class_5275.method_30769(type, world, mutable, ignoreInvalidPos);
         if (vec3d != null) {
            return Optional.of(vec3d);
         }
      }

      return Optional.empty();
   }

   private static int[][] getAroundAndOnBedOffsets(class_2350 bedDirection, class_2350 respawnDirection) {
      return (int[][])ArrayUtils.addAll(getAroundBedOffsets(bedDirection, respawnDirection), getOnBedOffsets(bedDirection));
   }

   private static int[][] getAroundBedOffsets(class_2350 bedDirection, class_2350 respawnDirection) {
      return new int[][]{
         {respawnDirection.method_10148(), respawnDirection.method_10165()},
         {respawnDirection.method_10148() - bedDirection.method_10148(), respawnDirection.method_10165() - bedDirection.method_10165()},
         {respawnDirection.method_10148() - bedDirection.method_10148() * 2, respawnDirection.method_10165() - bedDirection.method_10165() * 2},
         {-bedDirection.method_10148() * 2, -bedDirection.method_10165() * 2},
         {-respawnDirection.method_10148() - bedDirection.method_10148() * 2, -respawnDirection.method_10165() - bedDirection.method_10165() * 2},
         {-respawnDirection.method_10148() - bedDirection.method_10148(), -respawnDirection.method_10165() - bedDirection.method_10165()},
         {-respawnDirection.method_10148(), -respawnDirection.method_10165()},
         {-respawnDirection.method_10148() + bedDirection.method_10148(), -respawnDirection.method_10165() + bedDirection.method_10165()},
         {bedDirection.method_10148(), bedDirection.method_10165()},
         {respawnDirection.method_10148() + bedDirection.method_10148(), respawnDirection.method_10165() + bedDirection.method_10165()}
      };
   }

   private static int[][] getOnBedOffsets(class_2350 bedDirection) {
      return new int[][]{{0, 0}, {-bedDirection.method_10148(), -bedDirection.method_10165()}};
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (world.field_9236) {
         return class_1269.field_21466;
      } else if (state.method_11654(PART) != class_2742.field_12560
         && !(state = world.method_8320(pos = pos.method_10093((class_2350)state.method_11654(field_11177)))).method_27852(this)) {
         return class_1269.field_21466;
      } else if ((Boolean)state.method_11654(OCCUPIED)) {
         player.method_7353(class_2561.method_43471("block.minecraft.bed.occupied"), true);
         return class_1269.field_5814;
      } else {
         player.method_7269(pos).ifLeft(reason -> {
            if (reason.method_19206() != null) {
               player.method_7353(reason.method_19206(), true);
            }
         });
         return class_1269.field_5812;
      }
   }

   public void method_9554(class_1937 world, class_2680 state, class_2338 pos, class_1297 entity, float fallDistance) {
      super.method_9554(world, state, pos, entity, fallDistance * 0.5F);
   }

   public void method_9502(class_1922 world, class_1297 entity) {
      if (entity.method_21750()) {
         super.method_9502(world, entity);
      } else {
         this.bounceEntity(entity);
      }
   }

   private void bounceEntity(class_1297 entity) {
      class_243 vec3d = entity.method_18798();
      if (vec3d.field_1351 < 0.0) {
         double d = entity instanceof class_1309 ? 1.0 : 0.8;
         entity.method_18800(vec3d.field_1352, -vec3d.field_1351 * 0.66F * d, vec3d.field_1350);
      }
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if (direction == getDirectionTowardsOtherPart((class_2742)state.method_11654(PART), (class_2350)state.method_11654(field_11177))) {
         return neighborState.method_27852(this) && neighborState.method_11654(PART) != state.method_11654(PART)
            ? (class_2680)state.method_11657(OCCUPIED, (Boolean)neighborState.method_11654(OCCUPIED))
            : class_2246.field_10124.method_9564();
      } else {
         return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
      }
   }

   public void method_9576(class_1937 world, class_2338 pos, class_2680 state, class_1657 player) {
      class_2338 blockPos;
      class_2680 blockState;
      class_2742 bedPart;
      if (!world.field_9236
         && player.method_7337()
         && (bedPart = (class_2742)state.method_11654(PART)) == class_2742.field_12557
         && (blockState = world.method_8320(blockPos = pos.method_10093(getDirectionTowardsOtherPart(bedPart, (class_2350)state.method_11654(field_11177)))))
            .method_27852(this)
         && blockState.method_11654(PART) == class_2742.field_12560) {
         world.method_8652(blockPos, class_2246.field_10124.method_9564(), 35);
         world.method_8444(player, 2001, blockPos, class_2248.method_9507(blockState));
      }

      super.method_9576(world, pos, state, player);
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_2350 direction = ctx.method_8042();
      class_2338 blockPos = ctx.method_8037();
      class_2338 blockPos2 = blockPos.method_10093(direction);
      class_1937 world = ctx.method_8045();
      return world.method_8320(blockPos2).method_26166(ctx) && world.method_8621().method_11952(blockPos2)
         ? (class_2680)this.method_9564().method_11657(field_11177, direction)
         : null;
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_11177, PART, OCCUPIED});
   }

   public void method_9567(class_1937 world, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 itemStack) {
      super.method_9567(world, pos, state, placer, itemStack);
      if (!world.field_9236) {
         class_2338 blockPos = pos.method_10093((class_2350)state.method_11654(field_11177));
         world.method_8652(blockPos, (class_2680)state.method_11657(PART, class_2742.field_12560), 3);
         world.method_8408(pos, class_2246.field_10124);
         state.method_30101(world, pos, 3);
      }
   }

   public boolean method_9516(class_2680 state, class_1922 world, class_2338 pos, class_10 type) {
      return false;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
