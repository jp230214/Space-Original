package doctor4t.spacemod.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.MountableBlock;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2512;
import org.jetbrains.annotations.Nullable;

public class SeatEntity extends class_1297 {
   @Nullable
   class_2338 seatPos;

   public SeatEntity(class_1299<?> type, class_1937 world) {
      super(type, world);
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

   public void method_5773() {
      if (!this.method_37908().field_9236
         && (this.getSeatPos() == null || !this.method_5782() || !(this.method_37908().method_8320(this.getSeatPos()).method_26204() instanceof MountableBlock))
         )
       {
         this.method_5772();
         this.method_31472();
      }

      super.method_5773();
   }

   public double method_5621() {
      return super.method_5621();
   }

   public boolean method_5727(double cameraX, double cameraY, double cameraZ) {
      return false;
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
