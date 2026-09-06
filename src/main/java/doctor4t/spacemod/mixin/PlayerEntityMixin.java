package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.TrimmedBedBlock;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModItems;
import doctor4t.spacemod.index.tag.SpaceModBlockTags;
import java.util.Optional;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1657.class)
public abstract class PlayerEntityMixin extends class_1309 {
   protected PlayerEntityMixin(class_1299<? extends class_1309> entityType, class_1937 world) {
      super(entityType, world);
   }

   @Inject(method = "findRespawnPosition", at = @At("HEAD"), cancellable = true)
   private static void spacemod$trimmedBedRespawnPosition(
      class_3218 world, class_2338 pos, float angle, boolean forced, boolean alive, CallbackInfoReturnable<Optional<class_243>> cir
   ) {
      class_2680 state = world.method_8320(pos);
      if (state.method_26204() instanceof TrimmedBedBlock) {
         cir.setReturnValue(
            TrimmedBedBlock.findWakeUpPosition(class_1299.field_6097, world, pos, (class_2350)state.method_11654(TrimmedBedBlock.field_11177), angle)
         );
      }
   }

   @Shadow
   public abstract void method_17356(class_3414 var1, class_3419 var2, float var3, float var4);

   @ModifyExpressionValue(method = "updatePose", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSwimming()Z"))
   private boolean spacemod$crawlInVentsOrWhenDead(boolean original) {
      return original
         || !this.method_7325() && !this.method_5765() && this.method_36601().method_26164(SpaceModBlockTags.VENT_SHAFTS)
         || ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(this)).isDead();
   }

   @ModifyReturnValue(method = "isUsingSpyglass", at = @At("RETURN"))
   public boolean isUsingSpyglass(boolean original) {
      return original || this.method_6115() && this.method_6030().method_31574(SpaceModItems.TELESCOPE);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
