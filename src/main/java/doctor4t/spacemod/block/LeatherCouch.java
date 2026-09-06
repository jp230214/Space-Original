package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_4970.class_2251;

public class LeatherCouch extends CouchBlock {
   public LeatherCouch(class_2251 settings) {
      super(settings);
   }

   @Override
   public class_243 getNorthFacingSitPos(class_1937 world, class_2680 state, class_2338 pos) {
      return new class_243(0.5, -0.55F, 0.5);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
