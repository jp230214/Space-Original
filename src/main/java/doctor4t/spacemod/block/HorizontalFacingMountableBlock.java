package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public abstract class HorizontalFacingMountableBlock extends MountableBlock {
   public static final class_2753 FACING = class_2741.field_12481;

   public HorizontalFacingMountableBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)super.method_9564().method_11657(FACING, class_2350.field_11043));
   }

   @Override
   public class_243 getSitPos(class_1937 world, class_2680 state, class_2338 pos) {
      class_243 sitPos = this.getNorthFacingSitPos(world, state, pos);

      return switch ((class_2350)state.method_11654(FACING)) {
         case field_11034 -> new class_243(sitPos.field_1350, sitPos.field_1351, 1.0 - sitPos.field_1352);
         case field_11035 -> new class_243(1.0 - sitPos.field_1352, sitPos.field_1351, 1.0 - sitPos.field_1350);
         case field_11039 -> new class_243(1.0 - sitPos.field_1350, sitPos.field_1351, sitPos.field_1352);
         default -> sitPos;
      };
   }

   public abstract class_243 getNorthFacingSitPos(class_1937 var1, class_2680 var2, class_2338 var3);

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      return (class_2680)this.method_9564().method_11657(FACING, ctx.method_8042().method_10153());
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{FACING});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
