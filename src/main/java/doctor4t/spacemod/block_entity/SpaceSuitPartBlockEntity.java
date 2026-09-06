package doctor4t.spacemod.block_entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import net.minecraft.class_1747;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.jetbrains.annotations.Nullable;

public abstract class SpaceSuitPartBlockEntity extends class_2586 {
   protected PlayerSpaceComponent.Type spaceSuitType = PlayerSpaceComponent.Type.DEFAULT;

   public SpaceSuitPartBlockEntity(class_2591<?> type, class_2338 pos, class_2680 state) {
      super(type, pos, state);
   }

   public static PlayerSpaceComponent.Type readSpaceSuitType(@Nullable class_2487 nbt) {
      if (nbt != null && nbt.method_10573("space_suit_type", 8)) {
         PlayerSpaceComponent.Type type = PlayerSpaceComponent.Type.fromString(nbt.method_10558("space_suit_type"));
         return type == null ? PlayerSpaceComponent.Type.DEFAULT : type;
      } else {
         return PlayerSpaceComponent.Type.DEFAULT;
      }
   }

   public static PlayerSpaceComponent.Type getSpaceSuitType(class_1799 stack) {
      return readSpaceSuitType(class_1747.method_38072(stack));
   }

   public PlayerSpaceComponent.Type getSpaceSuitType() {
      return this.spaceSuitType;
   }

   public void setSpaceSuitType(PlayerSpaceComponent.Type spaceSuitType) {
      this.spaceSuitType = spaceSuitType;
   }

   public class_2487 method_16887() {
      return this.method_38244();
   }

   protected void method_11007(class_2487 nbt) {
      nbt.method_10582("space_suit_type", this.spaceSuitType.name);
   }

   public void method_11014(class_2487 nbt) {
      this.spaceSuitType = readSpaceSuitType(nbt);
   }

   public void readFrom(class_1799 stack) {
      this.spaceSuitType = getSpaceSuitType(stack);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
