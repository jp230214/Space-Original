package doctor4t.spacemod.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_572;
import net.minecraft.class_630;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Environment(EnvType.CLIENT)
@Mixin(class_572.class)
public interface BipedEntityModelAccessor {
   @Invoker("getHeadParts")
   Iterable<class_630> spacemod$getHeadParts();

   @Invoker("getBodyParts")
   Iterable<class_630> spacemod$getBodyParts();
}
