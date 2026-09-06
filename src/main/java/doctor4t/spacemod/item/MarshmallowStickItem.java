package doctor4t.spacemod.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModItems;
import doctor4t.spacemod.index.SpaceModTags;
import doctor4t.spacemod.util.BlockCastFinder;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_174;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1836;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_3222;
import net.minecraft.class_3419;
import net.minecraft.class_3468;
import net.minecraft.class_4174;
import net.minecraft.class_5712;
import net.minecraft.class_1792.class_1793;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MarshmallowStickItem extends class_1792 {
   public MarshmallowStickItem(class_1793 settings) {
      super(settings);
   }

   static class_2561 withColor(@NotNull class_2561 text, int color) {
      List<class_2561> textList = text.method_36136(text.method_10866().method_36139(color));
      if (textList.isEmpty()) {
         return class_2561.method_43470("");
      }

      class_2561 first = textList.get(0);

      for (int i = 1; i < textList.size(); i++) {
         first = first.method_27661().method_10852(textList.get(i));
      }

      return first;
   }

   public void method_7888(class_1799 stack, class_1937 world, class_1297 entity, int slot, boolean selected) {
      if (entity instanceof class_1657 player) {
         boolean main = player.method_6047().method_7909() == this;
         boolean off = player.method_6079().method_7909() == this;
         if (!main && !off) {
            return;
         }

         if (player.spacemod$isHoldingAttack()) {
            List<class_2338> blocks = BlockCastFinder.castRayForGridPoints(player.method_19538(), player.method_5720(), 2.0, 2.0);
            float headDistance = -1.0F;

            for (class_2338 block : blocks) {
               class_2680 state = world.method_8320(block);
               if (state.method_26164(SpaceModTags.HEAT_SOURCES)
                  && (!state.method_28501().contains(class_2741.field_12548) || (Boolean)state.method_11654(class_2741.field_12548))) {
                  headDistance = (float)player.method_19538().method_1022(class_243.method_24953(block));
                  break;
               }
            }

            if (headDistance >= 0.0F) {
               class_1799[] stacks = new class_1799[2];
               if (main) {
                  stacks[0] = player.method_6047();
               }

               if (off) {
                  stacks[1] = player.method_6079();
               }

               for (class_1799 heldStack : stacks) {
                  if (heldStack != null) {
                     class_2487 nbt = heldStack.method_7948();
                     float ticks = nbt.method_10583("RoastTicks");
                     if (ticks < MarshmallowStickItem.CookState.BURNT.cookTime + 60) {
                        float growth = 1.5F;
                        nbt.method_10548("RoastTicks", ticks + growth);
                     }
                  }
               }
            }
         }
      }
   }

   public class_1799 method_7861(class_1799 stack, @NotNull class_1937 world, @NotNull class_1309 user) {
      AtomicReference<class_1799> itemStack = new AtomicReference<>(stack);
      if (user instanceof class_3222 player) {
         class_4174 foodComponent = SpaceModItems.MARSHMALLOW.method_19264();
         if (foodComponent != null) {
            player.method_7344().method_7585(foodComponent.method_19230(), foodComponent.method_19231());
         }

         player.method_7259(class_3468.field_15372.method_14956(stack.method_7909()));
         class_174.field_1198.method_8821(player, stack);
      }

      world.method_43128(
         null,
         user.method_23317(),
         user.method_23318(),
         user.method_23321(),
         user.method_18869(stack),
         class_3419.field_15254,
         1.0F,
         1.0F + (world.field_9229.method_43057() - world.field_9229.method_43057()) * 0.4F
      );
      if (user instanceof class_1657 player && !player.method_31549().field_7477) {
         stack.method_7956(1, user, entity -> itemStack.set(new class_1799(class_1802.field_8600)));
      }

      user.method_32876(class_5712.field_28735);
      return itemStack.get();
   }

   public class_1271<class_1799> method_7836(class_1937 world, @NotNull class_1657 user, class_1268 hand) {
      class_1799 itemStack = user.method_5998(hand);
      user.method_6019(hand);
      return class_1271.method_22428(itemStack);
   }

   public int method_7881(class_1799 stack) {
      return 24;
   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, @NotNull List<class_2561> tooltip, class_1836 context) {
      tooltip.add(
         withColor(
            class_2561.method_43471("tooltip.spacemod.cook_level." + MarshmallowStickItem.CookState.getCookState(stack).name().toLowerCase()),
            MarshmallowStickItem.CookState.getCookState(stack).color
         )
      );
      super.method_7851(stack, world, tooltip, context);
   }

   public class_1839 method_7853(class_1799 stack) {
      return class_1839.field_8950;
   }

   public boolean method_7885(class_2680 state, class_1937 world, class_2338 pos, class_1657 miner) {
      return false;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }

   public enum CookState {
      RAW(0, -1, 10659489),
      SLIGHTLY_COOKED(40, 0, 13218184),
      COOKED(200, 1, 15252582),
      PERFECT(330, 2, 16762660),
      BURNT(340, -1, 4668708);

      public final int cookTime;
      public final boolean givesEffect;
      public final int effectAmplifier;
      public final int color;

      CookState(int cookTime, int effectAmplifier, int color) {
         this.cookTime = cookTime;
         this.givesEffect = effectAmplifier >= 0;
         this.effectAmplifier = effectAmplifier;
         this.color = color;
      }

      public static MarshmallowStickItem.CookState getCookState(@NotNull class_1799 stack) {
         return getCookState(stack.method_7948().method_10583("RoastTicks"));
      }

      public static MarshmallowStickItem.CookState getCookState(float roastTicks) {
         if (roastTicks < SLIGHTLY_COOKED.cookTime) {
            return RAW;
         } else if (roastTicks < COOKED.cookTime) {
            return SLIGHTLY_COOKED;
         } else if (roastTicks < PERFECT.cookTime) {
            return COOKED;
         } else {
            return roastTicks < BURNT.cookTime ? PERFECT : BURNT;
         }
      }

      public MarshmallowStickItem.CookState next() {
         return switch (this) {
            case RAW -> SLIGHTLY_COOKED;
            case SLIGHTLY_COOKED -> COOKED;
            case COOKED -> PERFECT;
            case PERFECT, BURNT -> BURNT;
         };
      }

      static {
         SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
      }
   }
}
