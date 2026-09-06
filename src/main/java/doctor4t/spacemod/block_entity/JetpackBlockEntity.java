package doctor4t.spacemod.block_entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import net.minecraft.class_2338;
import net.minecraft.class_2680;

public class JetpackBlockEntity extends SpaceSuitPartBlockEntity {
   public JetpackBlockEntity(class_2338 pos, class_2680 state) {
      super(SpaceModBlockEntities.JETPACK, pos, state);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
