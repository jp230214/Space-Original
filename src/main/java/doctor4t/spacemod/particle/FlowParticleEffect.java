package doctor4t.spacemod.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.SpaceModParticles;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2540;
import net.minecraft.class_7923;
import net.minecraft.class_2394.class_2395;

public record FlowParticleEffect(class_2396<FlowParticleEffect> type, class_2350 direction, class_2338 destination) implements class_2394 {
   public static final class_2395<FlowParticleEffect> FACTORY = new class_2395<FlowParticleEffect>() {
      public FlowParticleEffect read(class_2396<FlowParticleEffect> type, StringReader reader) throws CommandSyntaxException {
         reader.expect(' ');
         class_2350 direction = (class_2350)class_2350.field_29502.method_47920(reader.readUnquotedString(), class_2350.field_11033);
         reader.expect(' ');
         int x = reader.readInt();
         reader.expect(' ');
         int y = reader.readInt();
         reader.expect(' ');
         int z = reader.readInt();
         return new FlowParticleEffect(type, direction, new class_2338(x, y, z));
      }

      public FlowParticleEffect read(class_2396<FlowParticleEffect> type, class_2540 buf) {
         class_2350 direction = (class_2350)buf.method_10818(class_2350.class);
         class_2338 pos = buf.method_10811();
         return new FlowParticleEffect(type, direction, pos);
      }

      static {
         SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
      }
   };

   public static Codec<FlowParticleEffect> createCodec(class_2396<FlowParticleEffect> type) {
      return RecordCodecBuilder.create(
         instance -> instance.group(
               class_2350.field_29502.fieldOf("direction").forGetter(FlowParticleEffect::direction),
               class_2338.field_25064.fieldOf("destination").forGetter(FlowParticleEffect::destination)
            )
            .apply(instance, (direction, pos) -> new FlowParticleEffect(type, direction, pos))
      );
   }

   public class_2396<?> method_10295() {
      return SpaceModParticles.ICHOR_FLOW;
   }

   public void method_10294(class_2540 buf) {
      buf.method_10817(this.direction);
      buf.method_10807(this.destination);
   }

   public String method_10293() {
      return class_7923.field_41180.method_10221(this.method_10295())
         + " "
         + this.direction.method_15434()
         + " "
         + this.destination.method_10263()
         + " "
         + this.destination.method_10264()
         + " "
         + this.destination.method_10260();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
