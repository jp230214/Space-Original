package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.PumpEntity;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import doctor4t.spacemod.index.SpaceModEntities;
import java.util.List;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2586;
import net.minecraft.class_2680;

public class PumpBlockEntity extends class_2586 {
   public PumpBlockEntity(class_2338 pos, class_2680 state) {
      super(SpaceModBlockEntities.PUMP, pos, state);
   }

   public static <E extends class_2586> void tick(class_1937 world, class_2338 pos, class_2680 state, E be) {
      if (world.method_8510() % 5L == 0L) {
         List<PumpEntity> entities = world.method_8390(PumpEntity.class, new class_238(pos), x -> true);
         if (entities.isEmpty()) {
            PumpEntity pumpEntity = (PumpEntity)SpaceModEntities.PUMP.method_5883(world);
            if (pumpEntity == null) {
               return;
            }

            pumpEntity.method_5814(pos.method_10263() + 0.5F, pos.method_10264(), pos.method_10260() + 0.5F);
            world.method_8649(pumpEntity);
         }
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
