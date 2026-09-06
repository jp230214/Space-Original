package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;

public class OttomanBlock extends HorizontalFacingMountableBlock {
   public static final class_265 SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);

   public OttomanBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)super.method_9564().method_11657(class_2741.field_12481, class_2350.field_11043));
   }

   @Override
   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{class_2741.field_12481});
   }

   @Override
   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   @Override
   public class_243 getNorthFacingSitPos(class_1937 world, class_2680 state, class_2338 pos) {
      return new class_243(0.5, -0.5, 0.5);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
