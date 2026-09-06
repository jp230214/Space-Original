package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.tag.SpaceModBlockTags;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2429;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3737;
import net.minecraft.class_3965;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class BranchBlock extends class_2429 implements class_3737 {
   public static final Map<class_2248, class_2248> STRIPPED_BRANCHES = new Object2ObjectOpenHashMap();
   public static final class_2746 WATERLOGGED = class_2741.field_12508;

   public BranchBlock(class_2251 settings) {
      super(0.25F, settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)((class_2680)((class_2680)((class_2680)((class_2680)super.method_9564().method_11657(field_11332, false))
                           .method_11657(field_11335, false))
                        .method_11657(field_11331, false))
                     .method_11657(field_11328, false))
                  .method_11657(field_11327, false))
               .method_11657(field_11330, false))
            .method_11657(WATERLOGGED, false)
      );
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      class_2680 state = super.method_9605(ctx);
      class_1937 world = ctx.method_8045();
      class_2338 pos = ctx.method_8037();
      class_2350 side = ctx.method_8038();
      return state != null
         ? this.connectState(
            (class_2680)((class_2680)((class_2680)state.method_11657((class_2769)field_11329.get(side), ctx.method_8046()))
                  .method_11657((class_2769)field_11329.get(side.method_10153()), true))
               .method_11657(WATERLOGGED, world.method_8316(pos).method_39360(class_3612.field_15910)),
            pos,
            world
         )
         : null;
   }

   public class_2680 connectState(class_2680 state, class_2338 pos, class_1936 world) {
      class_2680 blockState = state;

      for (class_2350 direction : class_2350.values()) {
         blockState = this.connectState(blockState, pos, world, direction);
      }

      return blockState;
   }

   public class_2680 connectState(class_2680 state, class_2338 pos, class_1936 world, class_2350 direction) {
      class_2680 sideState = world.method_8320(pos.method_10093(direction));
      if (!sideState.method_26164(SpaceModBlockTags.BRANCHES)) {
         return state;
      }

      class_2746 sideProperty = (class_2746)field_11329.get(direction.method_10153());
      return sideState.method_28498(sideProperty) && sideState.method_11654(sideProperty)
         ? (class_2680)state.method_11657((class_2769)field_11329.get(direction), true)
         : state;
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      if ((Boolean)state.method_11654(WATERLOGGED)) {
         world.method_39281(pos, class_3612.field_15910, class_3612.field_15910.method_15789(world));
      }

      return this.connectState(super.method_9559(state, direction, neighborState, world, pos, neighborPos), pos, world, direction);
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      class_1799 stack = player.method_5998(hand);
      if (!stack.method_31574(class_1802.field_8868)) {
         return super.method_9534(state, world, pos, player, hand, hit);
      }

      boolean success = false;
      class_243 hitPos = hit.method_17784().method_1023(pos.method_10263(), pos.method_10264(), pos.method_10260());
      class_2350 direction = null;
      if (hitPos.field_1352 < 0.25) {
         direction = class_2350.field_11039;
      } else if (hitPos.field_1352 > 0.75) {
         direction = class_2350.field_11034;
      } else if (hitPos.field_1351 < 0.25) {
         direction = class_2350.field_11033;
      } else if (hitPos.field_1351 > 0.75) {
         direction = class_2350.field_11036;
      } else if (hitPos.field_1350 < 0.25) {
         direction = class_2350.field_11043;
      } else if (hitPos.field_1350 > 0.75) {
         direction = class_2350.field_11035;
      }

      if (direction != null) {
         class_2746 property = (class_2746)field_11329.get(direction);
         if ((Boolean)state.method_11654(property)) {
            world.method_8652(pos, (class_2680)state.method_11657(property, false), 3);
            class_2338 sidePos = pos.method_10093(direction);
            class_2680 sideState = world.method_8320(sidePos);
            class_2746 oppositeProperty = (class_2746)field_11329.get(direction.method_10153());
            if (sideState.method_26164(SpaceModBlockTags.BRANCHES)
               && sideState.method_28498(oppositeProperty)
               && (Boolean)sideState.method_11654(oppositeProperty)) {
               world.method_8652(sidePos, (class_2680)sideState.method_11657(oppositeProperty, false), 3);
            }

            success = true;
         }
      }

      class_2350 side = hit.method_17780();
      class_2746 property = (class_2746)field_11329.get(side);
      if (!success && !(Boolean)state.method_11654(property)) {
         world.method_8652(pos, (class_2680)state.method_11657(property, true), 3);
         success = true;
      }

      if (success) {
         world.method_8396(player, pos, class_3417.field_14619, class_3419.field_15245, 1.0F, 1.0F);
         if (!player.method_31549().field_7477) {
            stack.method_7956(1, player, p -> p.method_20236(hand));
         }

         return class_1269.method_29236(world.field_9236);
      } else {
         return super.method_9534(state, world, pos, player, hand, hit);
      }
   }

   public class_3610 method_9545(class_2680 state) {
      return state.method_11654(WATERLOGGED) ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_11332, field_11335, field_11331, field_11328, field_11327, field_11330, WATERLOGGED});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
