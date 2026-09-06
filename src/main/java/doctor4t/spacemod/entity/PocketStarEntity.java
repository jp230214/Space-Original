package doctor4t.spacemod.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModItems;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;

public class PocketStarEntity extends class_1297 {
   private final Quaterniond previousChasingOrientation = new Quaterniond();
   private final Quaterniond chasingOrientation = new Quaterniond();
   private final Quaterniond goalOrientation = new Quaterniond();
   private final Vector3d chasingPosition = new Vector3d();
   private final Vector3d previousChasingPosition = new Vector3d();
   private final Vector3d goalPosition = new Vector3d();

   public PocketStarEntity(class_1299<?> type, class_1937 world) {
      super(type, world);
   }

   protected void method_5693() {
   }

   protected void method_5749(class_2487 nbt) {
   }

   protected void method_5652(class_2487 nbt) {
   }

   public void method_5773() {
      super.method_5773();
      if (this.method_37908().field_9236) {
         if (this.chasingPosition.lengthSquared() <= 0.0) {
            this.chasingPosition.set(this.goalPosition);
            this.chasingOrientation.set(this.goalOrientation);
         }

         this.previousChasingOrientation.set(this.chasingOrientation);
         this.chasingOrientation.slerp(this.goalOrientation, 0.5);
         this.previousChasingPosition.set(this.chasingPosition);
         this.chasingPosition.lerp(this.goalPosition, 0.5);
         this.method_23327(this.chasingPosition.x, this.chasingPosition.y, this.chasingPosition.z);
      } else if (this.method_37908() instanceof class_3218 serverWorld) {
         this.method_23311();
      }
   }

   public class_1269 method_5688(class_1657 player, class_1268 hand) {
      System.out.println(player.method_37908().field_9236);
      if (player.method_5998(hand).method_7960()) {
         if (!player.method_37908().field_9236) {
            player.method_7270(new class_1799(SpaceModItems.POCKET_STAR));
            player.method_17356(class_3417.field_15197, class_3419.field_15248, 0.1F, 1.5F);
            this.method_31472();
         }

         return class_1269.method_29236(player.method_37908().field_9236);
      } else {
         return class_1269.field_5811;
      }
   }

   public boolean method_5863() {
      return true;
   }

   public boolean method_5655() {
      return true;
   }

   public Quaternionf getRenderQuaternion(float partialTicks) {
      return new Quaternionf(this.previousChasingOrientation.slerp(this.chasingOrientation, partialTicks, new Quaterniond()));
   }

   public Vector3d getRenderPosition(float partialTicks) {
      return new Vector3d(this.previousChasingPosition.lerp(this.chasingPosition, partialTicks, new Vector3d()));
   }

   public void chase(Quaterniond orientation, Vector3d position) {
      this.goalOrientation.set(orientation);
      this.goalPosition.set(position);
   }

   public void impulse(class_243 rotationVector) {
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
