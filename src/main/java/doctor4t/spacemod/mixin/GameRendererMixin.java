package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.cca.ShipWorldComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.entity.DrivingSeatEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_746;
import net.minecraft.class_757;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_757.class)
public abstract class GameRendererMixin {
   @Inject(
      method = "renderWorld",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;multiply(Lorg/joml/Quaternionf;)V", ordinal = 3, shift = Shift.AFTER)
   )
   private void mulPose(float tickDelta, long limitTime, class_4587 matrices, CallbackInfo ci) {
      class_310 mc = class_310.method_1551();
      class_746 player = mc.field_1724;
      ShipWorldComponent component = (ShipWorldComponent)SpaceModComponents.SHIP.get(player.method_37908());
      if (player.method_5765() && player.method_5854() instanceof DrivingSeatEntity) {
         matrices.method_22907(new Quaternionf(component.getOrientationLagBehind(mc.method_1488(), new Quaterniond())));
      }
   }

   @Inject(method = "renderWorld", at = @At("TAIL"))
   private void renderWorldTail(float tickDelta, long limitTime, class_4587 matrices, CallbackInfo ci) {
      SpaceModClient.renderFadePipeline(tickDelta);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
