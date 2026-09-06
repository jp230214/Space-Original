package doctor4t.spacemod.sound.integration.voicechat;

import de.maxhenkel.voicechat.api.Position;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.audiochannel.ClientLocationalAudioChannel;
import de.maxhenkel.voicechat.api.events.ClientSoundEvent;
import de.maxhenkel.voicechat.api.events.ClientVoicechatConnectionEvent;
import de.maxhenkel.voicechat.api.events.CreateOpenALContextEvent;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.OpenALSoundEvent;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.sound.AudioFilters;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_243;
import org.lwjgl.openal.EXTThreadLocalContext;

@Environment(EnvType.CLIENT)
public class SimpleVoiceChatPlugin implements VoicechatPlugin {
   private static final UUID OWN_VOICE_ID = UUID.randomUUID();
   private final Map<UUID, AudioChannel> audioChannels = new HashMap<>();
   private ClientLocationalAudioChannel locationalAudioChannel;

   public String getPluginId() {
      return "spacemod";
   }

   public void initialize(VoicechatApi api) {
      this.audioChannels.clear();
   }

   public void registerEvents(EventRegistration registration) {
      registration.registerEvent(CreateOpenALContextEvent.class, this::onCreateALContext);
      registration.registerEvent(OpenALSoundEvent.class, this::onOpenALSound);
      registration.registerEvent(ClientVoicechatConnectionEvent.class, this::onConnection);
      registration.registerEvent(ClientSoundEvent.class, this::onClientSound);
   }

   private void onClientSound(ClientSoundEvent event) {
      if (this.locationalAudioChannel != null) {
         ;
      }
   }

   private void onCreateALContext(CreateOpenALContextEvent event) {
      long oldContext = EXTThreadLocalContext.alcGetThreadContext();
      EXTThreadLocalContext.alcSetThreadContext(event.getContext());
      AudioFilters.init();
      EXTThreadLocalContext.alcSetThreadContext(oldContext);
   }

   private void onConnection(ClientVoicechatConnectionEvent event) {
      this.audioChannels.values().removeIf(AudioChannel::canBeRemoved);
      this.locationalAudioChannel = event.getVoicechat().createLocationalAudioChannel(OWN_VOICE_ID, event.getVoicechat().createPosition(0.0, 0.0, 0.0));
   }

   private void onOpenALSound(OpenALSoundEvent event) {
      Position position = event.getPosition();
      UUID channelId = event.getChannelId();
      if (channelId != null) {
         boolean auxOnly = false;
         AudioChannel audioChannel = this.audioChannels.get(channelId);
         if (audioChannel == null) {
            audioChannel = new AudioChannel(channelId);
            this.audioChannels.put(channelId, audioChannel);
         }

         audioChannel.onSound(
            event.getSource(), position == null ? null : new class_243(position.getX(), position.getY(), position.getZ()), auxOnly, event.getCategory()
         );
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
