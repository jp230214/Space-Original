package doctor4t.spacemod.block;

import doctor4t.spacemod.index.SpaceModSounds;
import java.util.EnumSet;
import java.util.Set;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2746;
import net.minecraft.class_3419;
import net.minecraft.class_5538;

public interface PrivacyBlock {
   class_2746 OPAQUE = class_2746.method_11825("opaque");
   class_2746 INTERACTION_COOLDOWN = class_2746.method_11825("interaction_cooldown");
   class_2350[][] DIAGONALS = new class_2350[][]{
      {class_2350.field_11043, class_2350.field_11034},
      {class_2350.field_11035, class_2350.field_11034},
      {class_2350.field_11035, class_2350.field_11039},
      {class_2350.field_11043, class_2350.field_11039},
      {class_2350.field_11036, class_2350.field_11043},
      {class_2350.field_11036, class_2350.field_11034},
      {class_2350.field_11036, class_2350.field_11035},
      {class_2350.field_11036, class_2350.field_11039},
      {class_2350.field_11033, class_2350.field_11043},
      {class_2350.field_11033, class_2350.field_11034},
      {class_2350.field_11033, class_2350.field_11035},
      {class_2350.field_11033, class_2350.field_11039}
   };
   int DELAY = 1;
   int COOLDOWN = 20;

   default void toggle(class_2680 state, class_1937 world, class_2338 pos) {
      boolean opaque = !(Boolean)state.method_11654(OPAQUE);
      if ((Boolean)state.method_11654(INTERACTION_COOLDOWN)) {
         world.method_8501(pos, (class_2680)state.method_11657(INTERACTION_COOLDOWN, false));
      } else {
         world.method_8396(null, pos, SpaceModSounds.BLOCK_PRIVACY_PANEL_TOGGLE, class_3419.field_15245, 0.1F, opaque ? 1.0F : 1.2F);
         world.method_8501(pos, (class_2680)((class_2680)state.method_11657(OPAQUE, opaque)).method_11657(INTERACTION_COOLDOWN, true));
         world.method_39279(pos, state.method_26204(), 20);
         Set<class_2350> changedDirections = EnumSet.noneOf(class_2350.class);

         for (class_2350 direction : class_2350.values()) {
            class_2338 sidePos = pos.method_10093(direction);
            class_2680 sideState = world.method_8320(sidePos);
            if (this.canToggle(sideState) && (Boolean)sideState.method_11654(OPAQUE) != opaque) {
               changedDirections.add(direction);
               world.method_39279(sidePos, sideState.method_26204(), 1);
            }
         }

         for (class_2350[] diagonal : DIAGONALS) {
            if (!this.diagonalHasAdjacentBlock(diagonal, changedDirections)) {
               class_2338 diagonalPos = this.offsetDiagonal(pos, diagonal);
               class_2680 diagonalState = world.method_8320(diagonalPos);
               if (this.canToggle(diagonalState) && (Boolean)diagonalState.method_11654(OPAQUE) != opaque) {
                  world.method_39279(diagonalPos, diagonalState.method_26204(), 1);
               }
            }
         }
      }
   }

   default boolean diagonalHasAdjacentBlock(class_2350[] diagonal, Set<class_2350> changedDirections) {
      return changedDirections.contains(diagonal[0]) || changedDirections.contains(diagonal[1]);
   }

   default class_2338 offsetDiagonal(class_2338 pos, class_2350[] diagonal) {
      return pos.method_10093(diagonal[0]).method_10093(diagonal[1]);
   }

   default boolean canInteract(class_2680 state, class_2338 pos, class_1937 world, class_1657 player, class_1268 hand) {
      if ((Boolean)state.method_11654(INTERACTION_COOLDOWN)) {
         return false;
      }

      if (player.method_5998(hand).method_7909() instanceof class_5538) {
         return false;
      }

      for (class_2350 direction : class_2350.values()) {
         class_2680 sideState = world.method_8320(pos.method_10093(direction));
         if (sideState.method_28498(INTERACTION_COOLDOWN) && (Boolean)sideState.method_11654(INTERACTION_COOLDOWN)) {
            return false;
         }
      }

      for (class_2350[] diagonal : DIAGONALS) {
         class_2338 diagonalPos = this.offsetDiagonal(pos, diagonal);
         class_2680 diagonalState = world.method_8320(diagonalPos);
         if (diagonalState.method_28498(INTERACTION_COOLDOWN) && (Boolean)diagonalState.method_11654(INTERACTION_COOLDOWN)) {
            return false;
         }
      }

      return true;
   }

   default boolean canToggle(class_2680 state) {
      return state.method_26204() instanceof PrivacyBlock;
   }

}
