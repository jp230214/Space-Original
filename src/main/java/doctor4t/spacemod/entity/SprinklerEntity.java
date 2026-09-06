package doctor4t.spacemod.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.SprinklerBlock;
import doctor4t.spacemod.index.tag.SpaceModBlockTags;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2350;
import net.minecraft.class_2398;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2350.class_2351;

public class SprinklerEntity extends class_1297 {
   public SprinklerEntity(class_1299<? extends class_1297> type, class_1937 world) {
      super(type, world);
   }

   public void method_5773() {
      super.method_5773();
      class_2680 blockState = this.method_37908().method_8320(this.method_24515());
      if (blockState.method_26164(SpaceModBlockTags.SPRINKLERS) && (Boolean)blockState.method_11654(SprinklerBlock.POWERED)) {
         class_2350 direction = SprinklerBlock.getDirection(blockState);
         float offsetScale = 0.2F;
         float randomOffsetScale = 0.2F;
         float velScale = 0.5F;

         for (int i = 0; i < 5; i++) {
            this.method_37908()
               .method_8406(
                  direction == class_2350.field_11033 ? class_2398.field_18306 : class_2398.field_11202,
                  this.method_23317()
                     - direction.method_10148() * offsetScale
                     + (this.field_5974.method_43057() * 2.0F - 1.0F) * (direction.method_10166() != class_2351.field_11048 ? randomOffsetScale : 0.0F),
                  (direction == class_2350.field_11033 ? 0.5 : 0.6)
                     + this.method_23318()
                     - direction.method_10164() * offsetScale
                     + (this.field_5974.method_43057() * 2.0F - 1.0F) * (direction.method_10166() != class_2351.field_11052 ? randomOffsetScale : 0.0F),
                  this.method_23321()
                     - direction.method_10165() * offsetScale
                     + (this.field_5974.method_43057() * 2.0F - 1.0F) * (direction.method_10166() != class_2351.field_11051 ? randomOffsetScale : 0.0F),
                  direction.method_10148() * velScale,
                  direction.method_10164() * velScale * (direction == class_2350.field_11036 ? 20.0F : 0.0F),
                  direction.method_10165() * velScale
               );
         }
      } else if (!this.method_37908().field_9236) {
         this.method_31472();
      }
   }

   protected void method_5693() {
   }

   protected void method_5749(class_2487 nbt) {
   }

   protected void method_5652(class_2487 nbt) {
   }

   public boolean method_5727(double cameraX, double cameraY, double cameraZ) {
      return false;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
