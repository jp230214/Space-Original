package doctor4t.spacemod.mixin;

import net.minecraft.class_2960;
import net.minecraft.class_4910.class_4912;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_4912.class)
public interface BlockTexturePoolAccessor {
   @Accessor
   void setBaseModelId(class_2960 var1);
}
