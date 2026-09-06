package doctor4t.spacemod.cca.entity;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.minecraft.class_1657;
import net.minecraft.class_2487;
import org.jetbrains.annotations.NotNull;

public class HoldingComponent implements AutoSyncedComponent {
   private final class_1657 player;
   private boolean holding = false;

   public HoldingComponent(class_1657 player) {
      this.player = player;
   }

   public void sync() {
      SpaceModComponents.HOLDING.sync(this.player);
   }

   public boolean isHolding() {
      return this.holding;
   }

   public void setHolding(boolean holding) {
      this.holding = holding;
      this.sync();
   }

   public void readFromNbt(@NotNull class_2487 tag) {
      this.holding = tag.method_10577("holding");
   }

   public void writeToNbt(@NotNull class_2487 tag) {
      tag.method_10556("holding", this.holding);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
