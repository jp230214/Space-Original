package doctor4t.spacemod.sound.integration.voicechat;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.sound.AudioFilters;
import java.util.UUID;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_243;
import net.minecraft.class_3419;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class AudioChannel {
   private static final String CATEGORY_TEMPLATE = "voicechat:%s";
   private static final String CATEGORY_VOICECHAT = "voicechat";
   private final UUID channelId;
   private long lastUpdate;
   private class_243 lastPos;

   public AudioChannel(UUID channelId) {
      this.channelId = channelId;
   }

   public void onSound(int source, @Nullable class_243 soundPos, boolean auxOnly, @Nullable String category) {
      if (soundPos == null) {
         AudioFilters.setDefaultEnvironment(source, auxOnly);
      } else {
         long time = System.currentTimeMillis();
         if (time - this.lastUpdate >= 500L || this.lastPos == null || !(this.lastPos.method_1022(soundPos) < 1.0)) {
            if (category == null) {
               AudioFilters.setLastSoundCategoryAndName(class_3419.field_15248, "voicechat:%s".formatted("voicechat"));
            } else {
               AudioFilters.setLastSoundCategoryAndName(class_3419.field_15250, "voicechat:%s".formatted(category));
            }

            if (!auxOnly) {
               AudioFilters.onPlaySound(soundPos.method_10216(), soundPos.method_10214(), soundPos.method_10215(), source);
            }

            this.lastUpdate = time;
            this.lastPos = soundPos;
         }
      }
   }

   public UUID getChannelId() {
      return this.channelId;
   }

   public boolean canBeRemoved() {
      return System.currentTimeMillis() - this.lastUpdate > 5000L;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
