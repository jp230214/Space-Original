package doctor4t.spacemod.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_7094;

public class SpaceDoorEntity extends class_1297 {
   public static final class_2940<Boolean> OPEN = class_2945.method_12791(SpaceDoorEntity.class, class_2943.field_13323);
   public final class_7094 openAnimationState = new class_7094();

   public SpaceDoorEntity(class_1299<? extends class_1297> entityType, class_1937 world) {
      super(entityType, world);
   }

   public static boolean canCollide(class_1297 entity, class_1297 other) {
      return other.method_30948() || other.method_5810();
   }

   protected void method_5693() {
      this.field_6011.method_12784(OPEN, false);
   }

   public boolean isOpen() {
      return (Boolean)this.field_6011.method_12789(OPEN);
   }

   public void setOpen(boolean open) {
      this.field_6011.method_12778(OPEN, open);
   }

   public boolean method_30949(class_1297 other) {
      return canCollide(this, other);
   }

   public boolean method_30948() {
      return false;
   }

   public boolean method_5810() {
      return false;
   }

   public boolean method_5863() {
      return false;
   }

   public boolean method_5655() {
      return true;
   }

   public boolean method_5740() {
      return true;
   }

   protected void method_5749(class_2487 nbt) {
      this.setOpen(nbt.method_10577("open"));
   }

   protected void method_5652(class_2487 nbt) {
      nbt.method_10556("open", this.isOpen());
   }

   public class_1269 method_5688(class_1657 player, class_1268 hand) {
      this.setOpen(!this.isOpen());
      return class_1269.method_29236(this.method_37908().field_9236);
   }

   public void method_5773() {
      super.method_5773();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
