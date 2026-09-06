package doctor4t.spacemod.mixin;


import java.util.function.Predicate;
import net.minecraft.class_1535;
import net.minecraft.class_6880;
import net.minecraft.class_7706;
import net.minecraft.class_1761.class_7704;
import net.minecraft.class_1761.class_7705;
import net.minecraft.class_7225.class_7226;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_7706.class)
public interface ItemGroupsAccessor {
   @Invoker("addPaintings")
   static void invokeAddPaintings(
      class_7704 entries, class_7226<class_1535> registryWrapper, Predicate<class_6880<class_1535>> predicate, class_7705 visibility
   ) {
      throw new AssertionError();
   }


}
