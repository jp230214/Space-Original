package doctor4t.spacemod.mixin.marshmallows;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.cca.entity.HoldingComponent;
import doctor4t.spacemod.item.MarshmallowStickItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1007;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_742;
import net.minecraft.class_572.class_573;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(class_1007.class)
public class HoldMarshmallowPosePlayerEntityRendererMixin {
   @Inject(method = "getArmPose", at = @At("HEAD"), cancellable = true)
   private static void getArmPose(@NotNull class_742 abstractClientPlayerEntity, class_1268 hand, CallbackInfoReturnable<class_573> cir) {
      class_1799 stackInHand = abstractClientPlayerEntity.method_5998(hand);
      HoldingComponent component = (HoldingComponent)SpaceModComponents.HOLDING.get(abstractClientPlayerEntity);
      if (stackInHand.method_7909() instanceof MarshmallowStickItem && component.isHolding()) {
         cir.setReturnValue(class_573.field_3406);
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
