package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2368;
import net.minecraft.class_2381;
import net.minecraft.class_2680;
import net.minecraft.class_4970.class_2251;

public class CullingBlock extends class_2381 {
   public CullingBlock(class_2251 settings) {
      super(settings);
   }

   public boolean method_9522(class_2680 state, class_2680 stateFrom, class_2350 direction) {
      return stateFrom.method_26204() instanceof GlassPanelBlock && stateFrom.method_11654(GlassPanelBlock.field_10927) == direction
         ? true
         : stateFrom.method_26204() instanceof CullingBlock || stateFrom.method_26204() instanceof class_2368;
   }

   public boolean method_9579(class_2680 state, class_1922 world, class_2338 pos) {
      return false;
   }

   public int method_9505(class_2680 state, class_1922 world, class_2338 pos) {
      return world.method_8315();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
