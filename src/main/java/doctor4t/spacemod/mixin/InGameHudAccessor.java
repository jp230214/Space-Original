package doctor4t.spacemod.mixin;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_329;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(EnvType.CLIENT)
@Mixin(class_329.class)
public interface InGameHudAccessor {
   @Accessor("scaledWidth")
   int getScaledWidth();

   @Accessor("scaledHeight")
   int getScaledHeight();

}
