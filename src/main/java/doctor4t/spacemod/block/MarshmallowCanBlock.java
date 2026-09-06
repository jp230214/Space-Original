package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModItems;
import doctor4t.spacemod.index.SpaceModSounds;
import net.minecraft.class_10;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2464;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4538;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.NotNull;

public class MarshmallowCanBlock extends class_2248 {
   public static final class_2758 LEVEL = class_2758.method_11867("level", 0, 8);
   protected static final class_265 SHAPE = class_2248.method_9541(4.0, 0.0, 4.0, 12.0, 10.0, 12.0);

   public MarshmallowCanBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)((class_2680)this.field_10647.method_11664()).method_11657(LEVEL, 8));
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   public class_265 method_9571(class_2680 state, class_1922 world, class_2338 pos) {
      return class_259.method_1073();
   }

   public class_2464 method_9604(class_2680 state) {
      return class_2464.field_11458;
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (player.method_5998(hand).method_31574(class_1802.field_8600)) {
         if (player.method_5998(hand).method_7947() == 1) {
            player.method_6122(hand, new class_1799(SpaceModItems.MARSHMALLOW_STICK));
         } else {
            player.method_5998(hand).method_7934(1);
            player.method_7270(SpaceModItems.MARSHMALLOW_STICK.method_7854());
         }

         player.method_5783(SpaceModSounds.MARSHMALLOW_CAN_TAKE, 0.5F, (float)(1.0 + world.field_9229.method_43059() / 20.0));
         return class_1269.field_5812;
      } else {
         return super.method_9534(state, world, pos, player, hand, hit);
      }
   }

   protected void method_9515(@NotNull class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{LEVEL});
   }

   public class_2680 method_9605(@NotNull class_1750 ctx) {
      return (class_2680)this.method_9564().method_11657(LEVEL, (int)Math.ceil(ctx.method_8041().method_7948().method_10550("marshmallowCount") / 8.0));
   }

   public boolean method_9558(class_2680 state, class_4538 world, class_2338 pos) {
      class_2350 direction = class_2350.field_11033;
      return class_2248.method_20044(world, pos.method_10093(direction), direction.method_10153());
   }

   public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
      return class_2350.field_11033 == direction && !state.method_26184(world, pos)
         ? class_2246.field_10124.method_9564()
         : super.method_9559(state, direction, neighborState, world, pos, neighborPos);
   }

   public boolean method_9516(class_2680 state, class_1922 world, class_2338 pos, class_10 type) {
      return false;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
