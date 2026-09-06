package doctor4t.spacemod.sound;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import java.util.regex.Pattern;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.EXTEfx;

@Environment(EnvType.CLIENT)
public class AudioFilters {
   private static final Pattern AMBIENT_PATTERN = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+:ambient\\..*$");
   private static final Pattern BLOCK_PATTERN = Pattern.compile(".*block..*");
   private static final Pattern VOICECHAT_PATTERN = Pattern.compile("^voicechat:.*$");
   private static int auxFXSlot0;
   private static int auxFXSlot1;
   private static int auxFXSlot2;
   private static int auxFXSlot3;
   private static int directFilter0;
   private static int sendFilter0;
   private static int sendFilter1;
   private static int sendFilter2;
   private static int sendFilter3;
   private static class_310 mc;
   private static class_3419 lastSoundCategory;
   private static String lastSoundName;
   private static int maxAuxSends;

   public static void init() {
      setupEFX();
      mc = class_310.method_1551();
   }

   static void setupEFX() {
      long currentContext = ALC10.alcGetCurrentContext();
      long currentDevice = ALC10.alcGetContextsDevice(currentContext);
      if (!ALC10.alcIsExtensionPresent(currentDevice, "ALC_EXT_EFX")) {
         System.out.println("EFX Extension not found on current device. Aborting.");
      } else {
         maxAuxSends = ALC10.alcGetInteger(currentDevice, 131075);
         auxFXSlot0 = EXTEfx.alGenAuxiliaryEffectSlots();
         EXTEfx.alAuxiliaryEffectSloti(auxFXSlot0, 3, 1);
         auxFXSlot1 = EXTEfx.alGenAuxiliaryEffectSlots();
         EXTEfx.alAuxiliaryEffectSloti(auxFXSlot1, 3, 1);
         auxFXSlot2 = EXTEfx.alGenAuxiliaryEffectSlots();
         EXTEfx.alAuxiliaryEffectSloti(auxFXSlot2, 3, 1);
         auxFXSlot3 = EXTEfx.alGenAuxiliaryEffectSlots();
         EXTEfx.alAuxiliaryEffectSloti(auxFXSlot3, 3, 1);
         directFilter0 = EXTEfx.alGenFilters();
         EXTEfx.alFilteri(directFilter0, 32769, 1);
         sendFilter0 = EXTEfx.alGenFilters();
         EXTEfx.alFilteri(sendFilter0, 32769, 1);
         sendFilter1 = EXTEfx.alGenFilters();
         EXTEfx.alFilteri(sendFilter1, 32769, 1);
         sendFilter2 = EXTEfx.alGenFilters();
         EXTEfx.alFilteri(sendFilter2, 32769, 1);
         sendFilter3 = EXTEfx.alGenFilters();
         EXTEfx.alFilteri(sendFilter3, 32769, 1);
      }
   }

   public static void setLastSoundCategoryAndName(class_3419 sc, String name) {
      lastSoundCategory = sc;
      lastSoundName = name;
   }

   public static void onPlaySound(double posX, double posY, double posZ, int sourceID) {
      processSound(sourceID, posX, posY, posZ, lastSoundCategory, lastSoundName, false);
   }

   public static void processSound(int source, double posX, double posY, double posZ, class_3419 category, String sound) {
      applyLowpass(source, posX, posY, posZ, category, sound, false);
   }

   @Nullable
   public static void processSound(int source, double posX, double posY, double posZ, class_3419 category, String sound, boolean auxOnly) {
      applyLowpass(source, posX, posY, posZ, category, sound, auxOnly);
   }

   @Nullable
   private static void applyLowpass(int sourceID, double posX, double posY, double posZ, class_3419 category, String sound, boolean auxOnly) {
      if (mc.field_1724 != null && mc.field_1687 != null && (posX != 0.0 || posY != 0.0 || posZ != 0.0)) {
         float directCutoff = 1.0F;
         float directGain = auxOnly ? 0.0F : (float)Math.pow(directCutoff, 0.1);
         float sendGain0 = 0.0F;
         float sendGain1 = 0.0F;
         float sendGain2 = 0.0F;
         float sendGain3 = 0.0F;
         float sendCutoff0 = 1.0F;
         float sendCutoff1 = 1.0F;
         float sendCutoff2 = 1.0F;
         float sendCutoff3 = 1.0F;
         if (category != class_3419.field_15250) {
            directCutoff = SpaceModClient.lowpassScale;
         }

         setEnvironment(sourceID, sendGain0, sendGain1, sendGain2, sendGain3, sendCutoff0, sendCutoff1, sendCutoff2, sendCutoff3, directCutoff, directGain);
      } else {
         setDefaultEnvironment(sourceID, auxOnly);
      }
   }

   public static boolean isVoicechatSound(String sound) {
      return VOICECHAT_PATTERN.matcher(sound).matches();
   }

   public static boolean isAmbientSound(String sound) {
      return AMBIENT_PATTERN.matcher(sound).matches();
   }

   public static void setDefaultEnvironment(int sourceID, boolean auxOnly) {
      setEnvironment(sourceID, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, auxOnly ? 0.0F : 1.0F);
   }

   public static void setEnvironment(
      int sourceID,
      float sendGain0,
      float sendGain1,
      float sendGain2,
      float sendGain3,
      float sendCutoff0,
      float sendCutoff1,
      float sendCutoff2,
      float sendCutoff3,
      float directCutoff,
      float directGain
   ) {
      if (maxAuxSends >= 4) {
         EXTEfx.alFilterf(sendFilter0, 1, sendGain0);
         EXTEfx.alFilterf(sendFilter0, 2, sendCutoff0);
         AL11.alSource3i(sourceID, 131078, auxFXSlot0, 3, sendFilter0);
      }

      if (maxAuxSends >= 3) {
         EXTEfx.alFilterf(sendFilter1, 1, sendGain1);
         EXTEfx.alFilterf(sendFilter1, 2, sendCutoff1);
         AL11.alSource3i(sourceID, 131078, auxFXSlot1, 2, sendFilter1);
      }

      if (maxAuxSends >= 2) {
         EXTEfx.alFilterf(sendFilter2, 1, sendGain2);
         EXTEfx.alFilterf(sendFilter2, 2, sendCutoff2);
         AL11.alSource3i(sourceID, 131078, auxFXSlot2, 1, sendFilter2);
      }

      if (maxAuxSends >= 1) {
         EXTEfx.alFilterf(sendFilter3, 1, sendGain3);
         EXTEfx.alFilterf(sendFilter3, 2, sendCutoff3);
         AL11.alSource3i(sourceID, 131078, auxFXSlot3, 0, sendFilter3);
      }

      EXTEfx.alFilterf(directFilter0, 1, directGain);
      EXTEfx.alFilterf(directFilter0, 2, directCutoff);
      AL11.alSourcei(sourceID, 131077, directFilter0);
      AL11.alSourcef(sourceID, 131079, 1.0F);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
