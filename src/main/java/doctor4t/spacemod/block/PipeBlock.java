package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class PipeBlock extends class_2318 {
   public PipeBlock(class_2251 settings) {
      super(settings);
      this.method_9590((class_2680)super.method_9564().method_11657(field_10927, class_2350.field_11036));
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      return (class_2680)this.method_9564().method_11657(field_10927, ctx.method_7715().method_10153());
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_10927});
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
