package doctor4t.spacemod.cca;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ClientTickingComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import doctor4t.spacemod.planet.Atmosphere;
import doctor4t.spacemod.planet.Planet;
import doctor4t.spacemod.planet.SolarSystem;
import java.util.Collection;
import java.util.Random;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import org.joml.Quaterniond;
import org.joml.Vector3d;

public class SolarSystemComponent implements AutoSyncedComponent, ServerTickingComponent, ClientTickingComponent {
   private final class_1937 world;
   private final SolarSystem system;
   public static Vector3d earthPos = new Vector3d();

   public SolarSystemComponent(class_1937 world) {
      this.world = world;
      this.system = new SolarSystem();
      if (!world.field_9236 && this.isSpace()) {
         this.addDefaultPlanets();
      }
   }

   private boolean isSpace() {
      return this.world.method_27983().equals(SpaceModDimensions.SPACE);
   }

   private void addDefaultPlanets() {
      float distScale = 1.0F;
      this.system.addPlanet(new Planet(0, SpaceMod.id("textures/space/mercury.jpg"), 4.879F, 800.0F * distScale, 159763.0F, new Vector3d(800.0, 0.0, 0.0)));
      this.system
         .addPlanet(
            new Planet(
               1,
               SpaceMod.id("textures/space/venus_atmosphere.jpg"),
               12.104F,
               900.0F * distScale,
               984371.0F,
               new Vector3d(900.0, 0.0, 0.0),
               new Atmosphere(2.542F, 5.53F, 0.25F, 449.0F, 494.0F, 550.0F, 2.0F, 2.66F)
            )
         );
      this.system
         .addPlanet(
            new Planet(
               2,
               SpaceMod.id("textures/space/earth.jpg"),
               12.765F,
               1000.0F * distScale,
               581306.0F,
               new Vector3d(1000.0, 0.0, 0.0),
               new Atmosphere(2.206F, 1.18F, 0.28F, 600.0F, 530.0F, 440.0F, 2.0F, 0.11F)
            )
         );
      this.system
         .addPlanet(
            new Planet(
               3,
               SpaceMod.id("textures/space/mars.jpg"),
               6.779F,
               1100.0F * distScale,
               456123.0F,
               new Vector3d(1100.0, 0.0, 0.0),
               new Atmosphere(0.5F, 0.87F, 0.84F, 467.0F, 653.0F, 709.0F, 1.6F, 0.2F)
            )
         );
      this.system
         .addPlanet(
            new Planet(
               4,
               SpaceMod.id("textures/space/jupiter.jpg"),
               142.984F,
               1500.0F * distScale,
               783045.0F,
               new Vector3d(1500.0, 0.0, 0.0),
               new Atmosphere(57.194F, 21.448F, 0.15F, 600.0F, 530.0F, 440.0F, 2.0F, 0.2F)
            )
         );
      this.system
         .addPlanet(
            new Planet(
               5,
               SpaceMod.id("textures/space/saturn.jpg"),
               120.536F,
               2300.0F * distScale,
               946128.0F,
               new Vector3d(2300.0, 0.0, 0.0),
               new Atmosphere(5.3F, 1.8F, 0.21F, 673.0F, 636.0F, 422.0F, 1.0F, 0.2F)
            )
         );
      this.system
         .addPlanet(
            new Planet(
               6,
               SpaceMod.id("textures/space/uranus.jpg"),
               50.724F,
               3000.0F * distScale,
               845622.0F,
               new Vector3d(3000.0, 0.0, 0.0),
               new Atmosphere(25.89F, 16.25F, 0.08F, 482.0F, 395.0F, 352.0F, 2.0F, 0.2F)
            )
         );
      this.system
         .addPlanet(
            new Planet(
               7,
               SpaceMod.id("textures/space/neptune.jpg"),
               49.244F,
               3400.0F * distScale,
               777789.0F,
               new Vector3d(3400.0, 0.0, 0.0),
               new Atmosphere(17.59F, 6.15F, 0.04F, 627.0F, 461.0F, 343.0F, 1.9F, 0.2F)
            )
         );
      this.system.addPlanet(new Planet(8, SpaceMod.id("textures/space/moon.jpg"), 3.475F, 35.0F * distScale, 134687.0F, new Vector3d(1000.0, 35.0, 0.0)));
      this.system
         .addPlanet(
            new Planet(
               9,
               SpaceMod.id("textures/space/janus.jpg"),
               8.286F,
               4000.0F * distScale,
               987623.0F,
               new Vector3d(4000.0, 0.0, 0.0),
               new Atmosphere(6.9F, 25.41F, 0.47F, 540.0F, 550.0F, 500.0F, 1.2F, 0.2F)
            )
         );
   }

   public void clientTick() {
   }

   public void serverTick() {
      if (this.isSpace()) {
         this.repositionPlanets();

         for (class_3222 serverPlayerEntity : ((class_3218)this.world).method_8503().method_3760().method_14571()) {
            boolean isSpace = serverPlayerEntity.method_37908().method_27983().equals(SpaceModDimensions.SPACE);
            boolean isJanus = serverPlayerEntity.method_37908().method_27983().equals(SpaceModDimensions.JANUS);
            if (isSpace || isJanus) {
               class_2540 packet = PacketByteBufs.create();
               this.writeSyncPacket(packet, serverPlayerEntity);
               ServerPlayNetworking.send(serverPlayerEntity, SpaceMod.CLIENTBOUND_SOLAR_SYSTEM_PACKET, packet);
            }
         }
      }
   }

   public void repositionPlanets() {
      for (Planet planet : this.getAllPlanets()) {
         Random rand = new Random();
         rand.setSeed(planet.getId());
         planet.getLastPosition().set(planet.getPosition());
         float speedModifier = 3.90625E-6F / planet.getDistance() * 256.0F * (planet.getId() == 9 ? 1000.0F : 100.0F);
         if (planet.getId() == 8) {
            speedModifier = (float)(speedModifier / 64.0);
         }

         float value = (float)this.world.method_8532() + planet.getRandomOffset();
         if (planet.getId() == 8) {
            planet.getPosition()
               .set(
                  earthPos.x + Math.sin(value * speedModifier) * planet.getDistance(),
                  earthPos.y + Math.cos(value * speedModifier) * planet.getDistance(),
                  earthPos.z
               );
         } else {
            planet.getPosition().set(Math.sin(value * speedModifier) * planet.getDistance(), Math.cos(value * speedModifier) * planet.getDistance(), 0.0);
            new Quaterniond()
               .rotateXYZ(rand.nextFloat() * Math.toRadians(15.0), rand.nextFloat() * Math.toRadians(15.0), rand.nextFloat() * Math.toRadians(15.0))
               .transform(planet.getPosition());
         }

         if (planet.getId() == 2) {
            earthPos = planet.getPosition();
         }
      }
   }

   public void writeSyncPacket(class_2540 buf, class_3222 recipient) {
      this.system.writeToPacket(buf);
   }

   public void applySyncPacket(class_2540 buf) {
      this.system.readFromPacketClient(buf);
   }

   public void readFromNbt(class_2487 tag) {
   }

   public void writeToNbt(class_2487 tag) {
   }

   public Collection<Planet> getAllPlanets() {
      return this.system.getAllPlanets();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
