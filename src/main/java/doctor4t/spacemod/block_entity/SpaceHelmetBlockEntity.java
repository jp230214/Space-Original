package doctor4t.spacemod.block_entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import net.minecraft.class_2338;
import net.minecraft.class_2680;

public class SpaceHelmetBlockEntity extends SpaceSuitPartBlockEntity {
   public SpaceHelmetBlockEntity(class_2338 pos, class_2680 state) {
      super(SpaceModBlockEntities.SPACE_HELMET, pos, state);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
