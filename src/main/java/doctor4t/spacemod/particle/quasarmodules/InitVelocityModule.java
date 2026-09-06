package doctor4t.spacemod.particle.quasarmodules;

import dev.upcraft.sdrm.api.SDRMVerifier;
import foundry.veil.api.quasar.emitters.module.InitParticleModule;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3d;
import org.joml.Vector3dc;

public class InitVelocityModule implements InitParticleModule {
   private final Vector3d velocity;

   public InitVelocityModule(Vector3dc velocity) {
      this.velocity = new Vector3d(velocity);
   }

   public void init(QuasarParticle particle) {
      Vector3d dir = new Vector3d(this.velocity).mul(17.0).sub(particle.getPosition().sub(particle.getEmitter().getPosition(), new Vector3d())).normalize();
      particle.getVelocity().set(dir.mul(this.velocity.length()));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
