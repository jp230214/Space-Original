package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_4970.class_2251;

public class LoungeCouch extends CouchBlock {
   public LoungeCouch(class_2251 settings) {
      super(settings);
   }

   @Override
   public class_243 getNorthFacingSitPos(class_1937 world, class_2680 state, class_2338 pos) {
      return new class_243(0.5, -0.5, 0.6F);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
