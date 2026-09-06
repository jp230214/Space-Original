package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.tag.SpaceModPaintingVariantTags;
import net.minecraft.class_1535;
import net.minecraft.class_6880;
import net.minecraft.class_7706;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_7706.class)
public abstract class ItemGroupsMixin {
   @ModifyReturnValue(method = "method_51320", at = @At("RETURN"))
   private static boolean spacemod$excludeCustomPaintings(boolean original, class_6880<class_1535> registryEntry) {
      return original && !registryEntry.method_40220(SpaceModPaintingVariantTags.FROM_REACH_FOR_THE_STARS);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
