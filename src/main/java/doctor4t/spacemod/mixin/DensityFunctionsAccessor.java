package doctor4t.spacemod.mixin;


import net.minecraft.class_5321;
import net.minecraft.class_6910;
import net.minecraft.class_6954;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_6954.class)
public interface DensityFunctionsAccessor {
   @Invoker("applyBlendDensity")
   static class_6910 applyBlendDensity(class_6910 density) {
      throw new AssertionError();
   }

   @Accessor("SHIFT_X")
   static class_5321<class_6910> getShiftX() {
      throw new AssertionError();
   }

   @Accessor("SHIFT_Z")
   static class_5321<class_6910> getShiftZ() {
      throw new AssertionError();
   }


}
