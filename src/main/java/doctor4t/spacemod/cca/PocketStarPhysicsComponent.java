package doctor4t.spacemod.cca;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.PocketStarEntity;
import net.minecraft.class_2487;
import org.joml.Quaternionf;

public class PocketStarPhysicsComponent implements AutoSyncedComponent {
   private final PocketStarEntity pocketStar;
   private Quaternionf orientation = new Quaternionf();

   public PocketStarPhysicsComponent(PocketStarEntity pocketStar) {
      this.pocketStar = pocketStar;
   }

   public Quaternionf getOrientation() {
      return this.orientation;
   }

   public void setOrientation(Quaternionf orientation) {
      this.orientation = orientation;
      this.sync();
   }

   public void sync() {
      SpaceModComponents.POCKET_STAR_PHYSICS.sync(this.pocketStar);
   }

   public void readFromNbt(class_2487 nbt) {
      this.setOrientation(
         new Quaternionf(nbt.method_10574("orientationX"), nbt.method_10574("orientationY"), nbt.method_10574("orientationZ"), nbt.method_10574("orientationW"))
      );
   }

   public void writeToNbt(class_2487 nbt) {
      nbt.method_10549("orientationX", this.getOrientation().x());
      nbt.method_10549("orientationY", this.getOrientation().y());
      nbt.method_10549("orientationZ", this.getOrientation().z());
      nbt.method_10549("orientationW", this.getOrientation().w());
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
