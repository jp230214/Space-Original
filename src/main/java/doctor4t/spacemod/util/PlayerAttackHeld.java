package doctor4t.spacemod.util;

public interface PlayerAttackHeld {
   default boolean spacemod$isHoldingAttack() {
      return false;
   }

   default void spacemod$setHoldingAttack(boolean attackHeld) {
   }
}
