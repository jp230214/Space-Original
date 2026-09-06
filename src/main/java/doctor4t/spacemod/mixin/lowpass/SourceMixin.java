package doctor4t.spacemod.mixin.lowpass;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.sound.AudioFilters;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_243;
import net.minecraft.class_4224;
import org.lwjgl.openal.AL10;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_4224.class)
public class SourceMixin {
   @Shadow
   @Final
   private int field_18893;
   @Unique
   private class_243 pos;

   @Inject(method = "setPosition", at = @At("HEAD"))
   private void setSelfPosition(class_243 poss, CallbackInfo ci) {
      this.pos = poss;
   }

   @Inject(method = "play", at = @At("HEAD"))
   private void play(CallbackInfo ci) {
      AudioFilters.onPlaySound(this.pos.field_1352, this.pos.field_1351, this.pos.field_1350, this.field_18893);
   }

   @ModifyVariable(method = "setAttenuation", at = @At("HEAD"), ordinal = 0, argsOnly = true)
   private float injected(float attenuation) {
      return attenuation;
   }

   @Inject(method = "setAttenuation", at = @At("RETURN"))
   private void linearAttenuation2(float attenuation, CallbackInfo ci) {
      AL10.alSourcef(this.field_18893, 4128, attenuation / 2.0F);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
