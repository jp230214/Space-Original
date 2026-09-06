package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_1309.class)
public abstract class NoVoidDamageInSpaceLivingEntityMixin extends class_1297 {
   public NoVoidDamageInSpaceLivingEntityMixin(class_1299<?> type, class_1937 world) {
      super(type, world);
   }

   @Inject(method = "tickInVoid", at = @At("HEAD"), cancellable = true)
   protected void tickInVoid(CallbackInfo ci) {
      if (this.method_37908().method_27983().equals(SpaceModDimensions.SPACE)) {
         ci.cancel();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
