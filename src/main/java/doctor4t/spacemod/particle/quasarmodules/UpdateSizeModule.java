package doctor4t.spacemod.particle.quasarmodules;

import dev.upcraft.sdrm.api.SDRMVerifier;
import foundry.veil.api.quasar.emitters.module.InitParticleModule;
import foundry.veil.api.quasar.emitters.module.UpdateParticleModule;
import foundry.veil.api.quasar.particle.QuasarParticle;

public class UpdateSizeModule implements InitParticleModule, UpdateParticleModule {
   private final float size;

   public UpdateSizeModule(float size) {
      this.size = size;
   }

   public void init(QuasarParticle particle) {
      particle.getEnvironment().edit().setQuery("spacemod_size", this.size);
   }

   public void update(QuasarParticle particle) {
      particle.setRadius((1.0F - (float)particle.getAge() / particle.getLifetime()) * (this.size * 0.75F));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
