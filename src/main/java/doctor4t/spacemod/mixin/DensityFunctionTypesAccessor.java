package doctor4t.spacemod.mixin;


import net.minecraft.class_6910;
import net.minecraft.class_6916;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_6916.class)
public interface DensityFunctionTypesAccessor {
   @Invoker("mapRange")
   static class_6910 mapRange(class_6910 function, double min, double max) {
      throw new AssertionError();
   }


}
