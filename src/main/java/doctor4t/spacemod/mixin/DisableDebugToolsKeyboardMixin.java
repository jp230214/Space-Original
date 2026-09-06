package doctor4t.spacemod.mixin;

import com.google.common.base.MoreObjects;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1934;
import net.minecraft.class_2561;
import net.minecraft.class_309;
import net.minecraft.class_310;
import net.minecraft.class_5289;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(class_309.class)
public abstract class DisableDebugToolsKeyboardMixin {
   @Shadow
   @Final
   private class_310 field_1678;

   @Shadow
   protected abstract void method_37272(class_2561 var1);

   @Inject(method = "processF3", at = @At("HEAD"), cancellable = true)
   private void processF3(int key, CallbackInfoReturnable<Boolean> cir) {
      if (SpaceModClient.shouldDisableHudAndDebug()) {
         if (key == 68 && this.field_1678.field_1705 != null) {
            this.field_1678.field_1705.method_1743().method_1808(false);
         }

         if (key == 84) {
            this.method_37272(class_2561.method_43471("debug.reload_resourcepacks.message"));
            this.field_1678.method_1521();
            cir.setReturnValue(true);
         }

         if (key == 78) {
            if (!this.field_1678.field_1724.method_5687(2)) {
               this.method_37272(class_2561.method_43471("debug.creative_spectator.error"));
            } else if (!this.field_1678.field_1724.method_7325()) {
               this.field_1678.field_1724.field_3944.method_45731("gamemode spectator");
            } else {
               this.field_1678
                  .field_1724
                  .field_3944
                  .method_45731(
                     "gamemode " + ((class_1934)MoreObjects.firstNonNull(this.field_1678.field_1761.method_28107(), class_1934.field_9220)).method_8381()
                  );
            }

            cir.setReturnValue(true);
         }

         if (key == 293) {
            if (!this.field_1678.field_1724.method_5687(2)) {
               this.method_37272(class_2561.method_43471("debug.gamemodes.error"));
            } else {
               this.field_1678.method_1507(new class_5289());
            }

            cir.setReturnValue(true);
         }

         cir.setReturnValue(false);
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
