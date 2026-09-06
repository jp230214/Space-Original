package doctor4t.spacemod.mixin.lowpass;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.sound.AudioFilters;
import java.util.Iterator;
import java.util.Map.Entry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1111;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import net.minecraft.class_1146;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import net.minecraft.class_4235.class_4236;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Environment(EnvType.CLIENT)
@Mixin(class_1140.class)
public class SoundSystemMixin {
   @Unique
   private final class_310 minecraft = class_310.method_1551();

   @Inject(method = "start", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/SoundListener;init()V"))
   private void loadLibrary(CallbackInfo ci) {
      AudioFilters.init();
   }

   @Inject(
      method = "play(Lnet/minecraft/client/sound/SoundInstance;)V",
      at = @At(value = "FIELD", target = "Lnet/minecraft/client/sound/SoundSystem;sounds:Lcom/google/common/collect/Multimap;"),
      locals = LocalCapture.CAPTURE_FAILHARD
   )
   private void play(
      class_1113 sound, CallbackInfo ci, class_1146 weightedSoundSet, class_2960 identifier, class_1111 sound2, float f, float g, class_3419 soundCategory
   ) {
      AudioFilters.setLastSoundCategoryAndName(soundCategory, sound.method_4775().toString());
   }

   @Inject(
      method = "tick()V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/GameOptions;getSoundVolume(Lnet/minecraft/sound/SoundCategory;)F"),
      locals = LocalCapture.CAPTURE_FAILHARD
   )
   private void tickNonPaused(CallbackInfo ci, Iterator<?> iterator, Entry<class_1113, class_4236> map, class_4236 channelHandle, class_1113 sound) {
      if (this.minecraft.field_1687 != null && (this.minecraft.field_1687.method_8510() + sound.hashCode()) % 5L == 0L) {
         channelHandle.method_19735(
            channel -> AudioFilters.processSound(
               ((ChannelAccessor)channel).getPointer(),
               sound.method_4784(),
               sound.method_4779(),
               sound.method_4778(),
               sound.method_4774(),
               sound.method_4775().toString()
            )
         );
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
