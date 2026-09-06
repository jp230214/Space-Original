package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970.class_2251;

public class BarTableBlock extends class_2248 {
   protected static final class_265 SHAPE = class_259.method_17786(
      class_2248.method_9541(4.0, 0.0, 4.0, 12.0, 1.0, 12.0),
      new class_265[]{class_2248.method_9541(5.0, 1.0, 5.0, 11.0, 14.0, 11.0), class_2248.method_9541(0.0, 14.0, 0.0, 16.0, 16.0, 16.0)}
   );

   public BarTableBlock(class_2251 settings) {
      super(settings);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
