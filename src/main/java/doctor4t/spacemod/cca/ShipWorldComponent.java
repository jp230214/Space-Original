package doctor4t.spacemod.cca;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ClientTickingComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import doctor4t.spacemod.planet.Planet;
import doctor4t.spacemod.util.BufferUtils;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

public class ShipWorldComponent implements AutoSyncedComponent, ClientTickingComponent, ServerTickingComponent, CommonTickingComponent {
   private double linearMultiplier = 50000.0;
   private double angularMultiplier = 0.001;
   private final class_1937 world;
   private final Vector3d networkedPosition;
   private final Vector3d previousPosition;
   private final Vector3d position;
   private final Vector3d clampedVelocity;
   private final Vector3d velocity;
   private final Vector3d latestLinearImpulse;
   private final Quaterniond networkedOrientation;
   private final Quaterniond previousOrientation;
   private final Quaterniond orientation;
   private final Quaterniond lagBehindOrientation;
   private final Quaterniond previousLagBehindOrientation;
   private final Vector3d angularVelocity;
   private boolean isStabilizing;
   private int planetRelativeId = -1;

   public ShipWorldComponent(class_1937 world) {
      this.world = world;
      this.position = new Vector3d(0.0, 200.0, 40.0);
      this.previousPosition = new Vector3d().set(this.position);
      this.networkedPosition = new Vector3d().set(this.position);
      this.orientation = new Quaterniond();
      this.previousOrientation = new Quaterniond().set(this.orientation);
      this.networkedOrientation = new Quaterniond().set(this.orientation);
      this.previousLagBehindOrientation = new Quaterniond().set(this.orientation);
      this.lagBehindOrientation = new Quaterniond().set(this.orientation);
      this.latestLinearImpulse = new Vector3d();
      this.velocity = new Vector3d(0.0, 0.0, 0.0);
      this.clampedVelocity = new Vector3d(0.0, 0.0, 0.0);
      this.angularVelocity = new Vector3d(0.0, 0.0, 0.0);
      this.setStabilizing(false);
   }

   public void sync() {
      SpaceModComponents.SHIP.sync(this.world);
   }

   public double getAngularMultiplier() {
      return this.angularMultiplier;
   }

   public void setAngularMultiplier(double angularMultiplier) {
      this.angularMultiplier = angularMultiplier;
      this.sync();
   }

   public double getLinearMultiplier() {
      return this.linearMultiplier;
   }

   public void setLinearMultiplier(double linearMultiplier) {
      this.linearMultiplier = linearMultiplier;
      this.sync();
   }

   public Vector3d getLatestLinearImpulse() {
      return this.latestLinearImpulse;
   }

   public Vector3d getPosition() {
      return this.position;
   }

   public void setPosition(Vector3dc position) {
      this.position.set(position);
      SpaceModComponents.SHIP.sync(this.world);
   }

   public Vector3dc getPreviousPosition() {
      return this.previousPosition;
   }

   public Vector3d getVelocity() {
      return this.velocity;
   }

   public void setVelocity(Vector3dc velocity) {
      this.velocity.set(velocity);
      SpaceModComponents.SHIP.sync(this.world);
   }

   public Quaterniond getOrientation() {
      return this.orientation;
   }

   public void setOrientation(Quaterniondc orientation) {
      this.orientation.set(orientation);
      SpaceModComponents.SHIP.sync(this.world);
   }

   public Quaterniondc getPreviousOrientation() {
      return this.previousOrientation;
   }

   public Vector3d getAngularVelocity() {
      return this.angularVelocity;
   }

   public void setAngularVelocity(Vector3dc angularVelocity) {
      this.angularVelocity.set(angularVelocity);
      SpaceModComponents.SHIP.sync(this.world);
   }

   public void setNetworkPosition(Vector3d position) {
      this.networkedPosition.set(position);
   }

   public void setNetworkOrientation(Quaterniond orientation) {
      this.networkedOrientation.set(orientation);
   }

   public boolean isStabilizing() {
      return this.isStabilizing;
   }

   public void setStabilizing(boolean stabilizing) {
      this.isStabilizing = stabilizing;
   }

   public void readFromNbt(class_2487 nbtCompound) {
      this.setLinearMultiplier(nbtCompound.method_10574("linearMultiplier"));
      this.setAngularMultiplier(nbtCompound.method_10574("angularMultiplier"));
      this.position.set(nbtCompound.method_10574("posX"), nbtCompound.method_10574("posY"), nbtCompound.method_10574("posZ"));
      this.velocity.set(nbtCompound.method_10574("velX"), nbtCompound.method_10574("velY"), nbtCompound.method_10574("velZ"));
      this.orientation
         .set(nbtCompound.method_10574("rotX"), nbtCompound.method_10574("rotY"), nbtCompound.method_10574("rotZ"), nbtCompound.method_10574("rotW"));
      this.angularVelocity.set(nbtCompound.method_10574("rotVelX"), nbtCompound.method_10574("rotVelY"), nbtCompound.method_10574("rotVelZ"));
   }

   public void writeToNbt(class_2487 nbtCompound) {
      nbtCompound.method_10549("linearMultiplier", this.getLinearMultiplier());
      nbtCompound.method_10549("angularMultiplier", this.getAngularMultiplier());
      nbtCompound.method_10549("posX", this.position.x());
      nbtCompound.method_10549("posY", this.position.y());
      nbtCompound.method_10549("posZ", this.position.z());
      nbtCompound.method_10549("velX", this.velocity.x());
      nbtCompound.method_10549("velY", this.velocity.y());
      nbtCompound.method_10549("velZ", this.velocity.z());
      nbtCompound.method_10549("rotX", this.orientation.x());
      nbtCompound.method_10549("rotY", this.orientation.y());
      nbtCompound.method_10549("rotZ", this.orientation.z());
      nbtCompound.method_10549("rotW", this.orientation.w());
      nbtCompound.method_10549("rotVelX", this.angularVelocity.x());
      nbtCompound.method_10549("rotVelY", this.angularVelocity.y());
      nbtCompound.method_10549("rotVelZ", this.angularVelocity.z());
   }

   public void clientTick() {
      this.previousPosition.set(this.position);
      this.previousOrientation.set(this.orientation);
      this.position.lerp(this.networkedPosition, 0.1);
      this.orientation.slerp(this.networkedOrientation, 0.5);
      this.previousLagBehindOrientation.set(this.lagBehindOrientation);
      this.lagBehindOrientation.slerp(this.orientation.conjugate(new Quaterniond()), 0.6);
   }

   public Quaterniond getOrientationLagBehind(float partialTick, Quaterniond dest) {
      return this.previousLagBehindOrientation
         .slerp(this.lagBehindOrientation, partialTick, new Quaterniond())
         .div(this.getOrientation(partialTick, new Quaterniond()).conjugate(), dest);
   }

   public void serverTick() {
      double timeStep = 0.05;
      SolarSystemComponent system = (SolarSystemComponent)SpaceModComponents.SOLAR_SYSTEM.get(this.world);
      Vector3d temp = new Vector3d();
      this.clampedVelocity.set(this.velocity);
      int followingPlanet = -1;
      Planet followingPlanetObj = null;
      if (this.world.method_27983().equals(SpaceModDimensions.SPACE)) {
         for (Planet planet : system.getAllPlanets()) {
            if (planet.getId() != 8) {
               double dist = this.position.distance(planet.getPosition().mul(1000000.0, temp));
               float planetRadius = planet.getRadius();
               float planetSlowRadius = planetRadius * 1000000.0F * 1.0F;
               double distFromSurface = dist - planetSlowRadius * 1.01;
               double maxDistFromSurface = planetSlowRadius * 0.4;
               if (distFromSurface < maxDistFromSurface) {
                  double proximity = Math.pow(Math.max(0.0, Math.min((maxDistFromSurface - distFromSurface) / maxDistFromSurface, 1.0)), 2.0);
                  Vector3d dir = this.position.sub(planet.getPosition().mul(1000000.0, temp), temp).normalize();
                  double d = this.clampedVelocity.dot(dir);
                  d = Math.max(d, 0.0);
                  this.clampedVelocity.lerp(new Vector3d(dir).mul(d), proximity);
               }

               if (dist / 1000000.0 / 100.0 < 3.0) {
                  this.position.add(planet.getPosition().sub(planet.getLastPosition(), temp).mul(1000000.0));
                  followingPlanet = planet.getId();
                  followingPlanetObj = planet;
               }
            }
         }
      }

      this.position.fma(timeStep, this.clampedVelocity);
      this.addAngularPosition(this.angularVelocity, timeStep);
      this.angularVelocity.mul(0.9);
      if (this.isStabilizing()) {
         Vector3d stabilizedVelocity = new Vector3d(this.getVelocity());
         stabilizedVelocity.negate();
         double maxStabilizeSpeed = ((ShipWorldComponent)SpaceModComponents.SHIP.get(this.world)).getLinearMultiplier() * 7.0;
         if (stabilizedVelocity.lengthSquared() > maxStabilizeSpeed * maxStabilizeSpeed) {
            stabilizedVelocity.normalize().mul(maxStabilizeSpeed);
         }

         stabilizedVelocity.mul(0.95);
         this.velocity.add(stabilizedVelocity);
      }

      if (this.world instanceof class_3218 sworld) {
         class_2540 buf = PacketByteBufs.create();
         buf.writeInt(followingPlanet);
         Vector3d planetPos = new Vector3d();
         if (followingPlanetObj != null) {
            followingPlanetObj.getPosition().mul(1000000.0, planetPos);
         }

         BufferUtils.writeVector(buf, this.position.sub(planetPos, planetPos));
         BufferUtils.writeQuaternion(buf, this.orientation);
         BufferUtils.writeVector(buf, this.latestLinearImpulse);

         for (class_3222 player : sworld.method_18456()) {
            ServerPlayNetworking.send(player, SpaceMod.CLIENTBOUND_SHIP_POSE_PACKET, buf);
         }
      }
   }

   public void tick() {
   }

   private void addAngularPosition(Vector3dc angularVelocity, double amt) {
      double angle = angularVelocity.length() * amt;
      if (angle != 0.0) {
         Quaterniond newOrientation = new Quaterniond();
         newOrientation.rotateAxis(angle, angularVelocity);
         newOrientation.mul(this.orientation);
         newOrientation.normalize();
         this.orientation.set(newOrientation);
      }
   }

   public void setPlanetRelativeId(int planetRelativeId) {
      if (this.planetRelativeId == -1 && planetRelativeId != -1) {
         this.planetRelativeId = planetRelativeId;
         SolarSystemComponent system = (SolarSystemComponent)SpaceModComponents.SOLAR_SYSTEM.get(this.world);
         Vector3d planetPos = new Vector3d();
         this.getPlanet(planetPos, system, 1.0F);
         this.previousPosition.sub(planetPos);
         this.position.sub(planetPos);
      }

      if (this.planetRelativeId != -1 && planetRelativeId == -1) {
         SolarSystemComponent system = (SolarSystemComponent)SpaceModComponents.SOLAR_SYSTEM.get(this.world);
         Vector3d planetPos = new Vector3d();
         this.getPlanet(planetPos, system, 1.0F);
         this.previousPosition.add(planetPos);
         this.position.add(planetPos);
      }

      this.planetRelativeId = planetRelativeId;
   }

   public Vector3d getPosition(float partialTick, Vector3d smoothPos) {
      if (this.planetRelativeId == -1) {
         smoothPos.set(this.getPreviousPosition()).lerp(this.getPosition(), partialTick);
         return smoothPos;
      } else {
         SolarSystemComponent system = (SolarSystemComponent)SpaceModComponents.SOLAR_SYSTEM.get(this.world);
         this.getPlanet(smoothPos, system, partialTick);
         smoothPos.add(this.getPreviousPosition().lerp(this.getPosition(), partialTick, new Vector3d()));
         return smoothPos;
      }
   }

   private void getPlanet(Vector3d smoothPos, SolarSystemComponent system, float partialTick) {
      for (Planet p : system.getAllPlanets()) {
         if (p.getId() == this.planetRelativeId) {
            Planet planet = p;
            planet.getPosition(partialTick, smoothPos).mul(1000000.0);
         }
      }
   }

   public Quaterniond getOrientation(float partialTick, Quaterniond smoothRot) {
      smoothRot.set(this.getPreviousOrientation()).slerp(this.getOrientation(), partialTick);
      return smoothRot;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
