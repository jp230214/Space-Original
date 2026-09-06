package doctor4t.spacemod.block_entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.cca.ShipWorldComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import doctor4t.spacemod.particle.quasarmodules.InitVelocityModule;
import doctor4t.spacemod.particle.quasarmodules.UpdateSizeModule;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.data.EmitterShapeSettings;
import foundry.veil.api.quasar.emitters.shape.EmitterShape.Shape;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2622;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3f;

public class ThrusterBlockEntity extends class_2586 {
   public static class_2960 THRUSTER_FLAME_PARTICLE = SpaceMod.id("thruster_flame");
   public static class_2960 THRUSTER_SMOKE_PARTICLE = SpaceMod.id("thruster_smoke");
   private int size = 1;

   public ThrusterBlockEntity(class_2338 pos, class_2680 state) {
      super(SpaceModBlockEntities.THRUSTER, pos, state);
   }

   public int getSize() {
      return this.size;
   }

   public void setSize(int size) {
      this.size = size;
      this.sync();
   }

   public void sync() {
      this.method_5431();
      if (this.method_10997() != null) {
         this.method_10997().method_8413(this.method_11016(), this.method_11010(), this.method_11010(), 3);
      }
   }

   public class_2487 method_16887() {
      return this.method_38244();
   }

   @Nullable
   public class_2596<class_2602> method_38235() {
      return class_2622.method_38585(this);
   }

   public void method_11014(class_2487 nbt) {
      super.method_11014(nbt);
      this.setSize(nbt.method_10550("size"));
   }

   protected void method_11007(class_2487 nbt) {
      super.method_11007(nbt);
      nbt.method_10569("size", this.getSize());
   }

   public static void tickClient(class_1937 world, class_2338 pos, class_2680 state, ThrusterBlockEntity thrusterBE) {
      if (((ShipWorldComponent)SpaceModComponents.SHIP.get(world)).getLatestLinearImpulse().length() > 0.1) {
         ParticleSystemManager particleManager = VeilRenderSystem.renderer().getParticleManager();
         ParticleEmitter flameEmitter = particleManager.createEmitter(THRUSTER_FLAME_PARTICLE);
         if (flameEmitter != null) {
            flameEmitter.setPosition(
               thrusterBE.method_11016().method_10263() + 0.5, thrusterBE.method_11016().method_10264() + 0.5, thrusterBE.method_11016().method_10260() + 0.5
            );
            flameEmitter.addCodeModule(builder -> builder.addModule(new InitVelocityModule(new Vector3d(0.0, 0.0, -thrusterBE.getSize() / 3.2F))));
            flameEmitter.addCodeModule(builder -> builder.addModule(new UpdateSizeModule(thrusterBE.getSize())));
            flameEmitter.setEmitterShapeSettings(new EmitterShapeSettings(Shape.SPHERE, new Vector3f(thrusterBE.getSize() / 2.0F), new Vector3f(), false));
            flameEmitter.setForceSpawn(true);
            particleManager.addParticleSystem(flameEmitter);
         }
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
