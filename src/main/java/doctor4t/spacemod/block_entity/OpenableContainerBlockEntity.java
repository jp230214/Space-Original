package doctor4t.spacemod.block_entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import doctor4t.spacemod.index.SpaceModSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.minecraft.class_1262;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2591;
import net.minecraft.class_2621;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_5561;

public class OpenableContainerBlockEntity extends class_2621 {
   private final int size;
   private final class_2561 containerName;
   private final class_3414 openSound;
   private final class_3414 closeSound;
   private final class_5561 stateManager = new class_5561() {
      protected void method_31681(class_1937 world, class_2338 pos, class_2680 state) {
         OpenableContainerBlockEntity.this.playSound(state, OpenableContainerBlockEntity.this.openSound);
         OpenableContainerBlockEntity.this.setOpen(state, true);
      }

      protected void method_31683(class_1937 world, class_2338 pos, class_2680 state) {
         OpenableContainerBlockEntity.this.playSound(state, OpenableContainerBlockEntity.this.closeSound);
         OpenableContainerBlockEntity.this.setOpen(state, false);
      }

      protected void method_31682(class_1937 world, class_2338 pos, class_2680 state, int oldViewerCount, int newViewerCount) {
      }

      protected boolean method_31679(class_1657 player) {
         return player.field_7512 instanceof class_1707 screenHandler && screenHandler.method_7629().equals(OpenableContainerBlockEntity.this);
      }

      static {
         SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
      }
   };
   private class_2371<class_1799> inventory;

   protected OpenableContainerBlockEntity(
      class_2591<?> type, int rows, class_2561 containerName, class_3414 openSound, class_3414 closeSound, class_2338 pos, class_2680 state
   ) {
      super(type, pos, state);
      this.size = rows * 9;
      this.containerName = containerName;
      this.inventory = class_2371.method_10213(this.size, class_1799.field_8037);
      this.openSound = openSound;
      this.closeSound = closeSound;
   }

   public static Factory<OpenableContainerBlockEntity> cabinetFactory() {
      return (pos, state) -> new OpenableContainerBlockEntity(
         SpaceModBlockEntities.CABINET, 3, class_2561.method_43471("container.cabinet"), class_3417.field_17604, class_3417.field_17603, pos, state
      );
   }

   public static Factory<OpenableContainerBlockEntity> cargoBoxFactory() {
      return (pos, state) -> new OpenableContainerBlockEntity(
         SpaceModBlockEntities.CARGO_BOX,
         3,
         class_2561.method_43471("container.cargo_box"),
         SpaceModSounds.BLOCK_CARGO_BOX_OPEN,
         SpaceModSounds.BLOCK_CARGO_BOX_CLOSE,
         pos,
         state
      );
   }

   protected class_2371<class_1799> method_11282() {
      return this.inventory;
   }

   protected void method_11281(class_2371<class_1799> list) {
      this.inventory = list;
   }

   protected class_2561 method_17823() {
      return this.containerName;
   }

   protected class_1703 method_5465(int syncId, class_1661 playerInventory) {
      return class_1707.method_19245(syncId, playerInventory, this);
   }

   public void method_5435(class_1657 player) {
      if (!this.field_11865 && !player.method_7325()) {
         this.stateManager.method_31684(player, this.method_10997(), this.method_11016(), this.method_11010());
      }
   }

   public void method_5432(class_1657 player) {
      if (!this.field_11865 && !player.method_7325()) {
         this.stateManager.method_31685(player, this.method_10997(), this.method_11016(), this.method_11010());
      }
   }

   public void tick() {
      if (!this.field_11865) {
         this.stateManager.method_31686(this.method_10997(), this.method_11016(), this.method_11010());
      }
   }

   public void method_11014(class_2487 nbt) {
      super.method_11014(nbt);
      this.inventory = class_2371.method_10213(this.method_5439(), class_1799.field_8037);
      if (!this.method_11283(nbt)) {
         class_1262.method_5429(nbt, this.inventory);
      }
   }

   protected void method_11007(class_2487 nbt) {
      super.method_11007(nbt);
      if (!this.method_11286(nbt)) {
         class_1262.method_5426(nbt, this.inventory);
      }
   }

   private void setOpen(class_2680 state, boolean open) {
      if (this.field_11863 != null) {
         this.field_11863.method_8652(this.method_11016(), (class_2680)state.method_11657(class_2741.field_12537, open), 3);
      }
   }

   void playSound(class_2680 state, class_3414 soundEvent) {
      if (this.field_11863 != null) {
         class_2350 facing = state.method_28498(class_2741.field_12481)
            ? (class_2350)state.method_11654(class_2741.field_12481)
            : (state.method_28498(class_2741.field_12525) ? (class_2350)state.method_11654(class_2741.field_12525) : class_2350.field_11036);
         double x = this.field_11867.method_10263() + 0.5 + facing.method_10148() * 0.5;
         double y = this.field_11867.method_10264() + 0.5 + facing.method_10164() * 0.5;
         double z = this.field_11867.method_10260() + 0.5 + facing.method_10165() * 0.5;
         this.field_11863.method_43128(null, x, y, z, soundEvent, class_3419.field_15245, 0.5F, this.field_11863.field_9229.method_43057() * 0.1F + 0.9F);
      }
   }

   public int method_5439() {
      return this.size;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
