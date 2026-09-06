package doctor4t.spacemod.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.DrivingSeatBlock;
import doctor4t.spacemod.index.SpaceModEntities;
import net.fabricmc.fabric.api.entity.FakePlayer;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1321;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2512;
import net.minecraft.class_1297.class_4738;
import org.jetbrains.annotations.Nullable;

public class DrivingSeatEntity extends class_1297 {
   @Nullable
   class_2338 seatPos;

   public DrivingSeatEntity(class_1299<?> type, class_1937 world) {
      super(type, world);
      this.field_5960 = true;
   }

   public DrivingSeatEntity(class_1937 world, class_2338 pos) {
      this(SpaceModEntities.DRIVING_SEAT, world);
      this.field_5960 = true;
   }

   public class_1269 method_5688(class_1657 player, class_1268 hand) {
      if (player.method_37908().field_9236) {
         return class_1269.field_5812;
      }

      player.method_5873(this, true);
      return class_1269.field_5812;
   }

   public void method_5814(double x, double y, double z) {
      super.method_5814(x, y, z);
   }

   public boolean method_5863() {
      return true;
   }

   protected void method_5865(class_1297 passenger, class_4738 positionUpdater) {
      if (this.method_5626(passenger)) {
         double d0 = this.method_23318() + this.method_5621() + passenger.method_5678();
         positionUpdater.accept(passenger, this.method_23317(), d0, this.method_23321());
      }
   }

   public void method_18799(class_243 velocity) {
   }

   public void method_5773() {
      class_1937 world = this.method_37908();
      if (!world.field_9236
         && (
            this.getSeatPos() == null
               || !this.method_5782()
               || !(this.method_37908().method_8320(this.getSeatPos()).method_26204() instanceof DrivingSeatBlock)
         )) {
         this.method_5772();
         this.method_31472();
      }
   }

   protected boolean method_5860(class_1297 entity) {
      return !(entity instanceof class_1657 player && player instanceof FakePlayer);
   }

   protected void method_5793(class_1297 entity) {
      super.method_5793(entity);
      if (entity instanceof class_1321 ta) {
         ta.method_6179(false);
      }
   }

   public boolean method_5727(double cameraX, double cameraY, double cameraZ) {
      return false;
   }

   public class_243 method_24829(class_1309 passenger) {
      return super.method_24829(passenger).method_1031(0.0, 0.5, 0.0);
   }

   protected void method_5693() {
   }

   protected void method_5749(class_2487 nbt) {
      if (nbt.method_10573("seatPos", 10)) {
         this.setSeatPos(class_2512.method_10691(nbt.method_10562("seatPos")));
      }
   }

   protected void method_5652(class_2487 nbt) {
      if (this.getSeatPos() != null) {
         nbt.method_10566("seatPos", class_2512.method_10692(this.getSeatPos()));
      }
   }

   public double method_5621() {
      return super.method_5621();
   }

   @Nullable
   public class_2338 getSeatPos() {
      return this.seatPos;
   }

   public void setSeatPos(@Nullable class_2338 seatPos) {
      this.seatPos = seatPos;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
