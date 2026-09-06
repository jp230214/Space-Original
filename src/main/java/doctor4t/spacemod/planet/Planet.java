package doctor4t.spacemod.planet;

import dev.upcraft.sdrm.api.SDRMVerifier;
import java.nio.ByteBuffer;
import net.minecraft.class_2540;
import net.minecraft.class_2960;
import org.joml.Vector3d;
import org.joml.Vector3dc;

public class Planet {
   private final Vector3d position = new Vector3d();
   private final Vector3d targetPosition = new Vector3d();
   private final Vector3d lastPosition = new Vector3d();
   private final Vector3d smoothedPos = new Vector3d();
   private int id;
   private class_2960 texture;
   private float radius;
   private float distance;
   private float randomOffset;
   private Atmosphere atmosphere = new Atmosphere(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

   public Planet() {
   }

   public Planet(int id, class_2960 texture, float radius, float distance, float randomOffset, Vector3dc position) {
      this(id, texture, radius, distance, randomOffset, position, new Atmosphere(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
   }

   public Planet(int id, class_2960 texture, float radius, float distance, float randomOffset, Vector3dc position, Atmosphere atmosphere) {
      this.id = id;
      this.texture = texture;
      this.radius = radius;
      this.distance = distance;
      this.randomOffset = randomOffset;
      this.position.set(position);
      this.atmosphere = atmosphere;
   }

   public void writeToShader(ByteBuffer buffer, float partialTick) {
      Vector3d pos = this.getPosition(partialTick, this.smoothedPos);
      buffer.putFloat((float)pos.x());
      buffer.putFloat((float)pos.y());
      buffer.putFloat((float)pos.z());
      buffer.putFloat(this.radius);
      buffer.putInt(this.id);
      buffer.putInt(0);
      buffer.putFloat(0.0F);
      buffer.putFloat(0.0F);
      buffer.putFloat(this.atmosphere.getSize());
      buffer.putFloat(this.atmosphere.getFalloff());
      buffer.putFloat(this.atmosphere.getDensity());
      buffer.putFloat(this.atmosphere.getDensityMultiplier());
      buffer.putFloat(this.atmosphere.getRedScatter());
      buffer.putFloat(this.atmosphere.getGreenScatter());
      buffer.putFloat(this.atmosphere.getBlueScatter());
      buffer.putFloat(this.atmosphere.getBrightnessMultiplier());
   }

   public void writeToPacket(class_2540 buffer) {
      buffer.writeInt(this.id);
      buffer.writeFloat((float)this.position.x);
      buffer.writeFloat((float)this.position.y);
      buffer.writeFloat((float)this.position.z);
      buffer.writeFloat(this.radius);
      buffer.writeFloat(this.distance);
      buffer.writeFloat(this.randomOffset);
      buffer.writeFloat(this.atmosphere.getSize());
      buffer.writeFloat(this.atmosphere.getFalloff());
      buffer.writeFloat(this.atmosphere.getDensity());
      buffer.writeFloat(this.atmosphere.getRedScatter());
      buffer.writeFloat(this.atmosphere.getGreenScatter());
      buffer.writeFloat(this.atmosphere.getBlueScatter());
      buffer.writeFloat(this.atmosphere.getBrightnessMultiplier());
      buffer.writeFloat(this.atmosphere.getDensityMultiplier());
      buffer.writeInt(this.texture.toString().length());
      buffer.method_10814(this.texture.toString());
   }

   public void readFromPacket(class_2540 buffer) {
      this.id = buffer.readInt();
      this.position.set(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
      this.radius = buffer.readFloat();
      this.distance = buffer.readFloat();
      this.randomOffset = buffer.readFloat();
      this.atmosphere.setSize(buffer.readFloat());
      this.atmosphere.setFalloff(buffer.readFloat());
      this.atmosphere.setDensity(buffer.readFloat());
      this.atmosphere.setRedScatter(buffer.readFloat());
      this.atmosphere.setGreenScatter(buffer.readFloat());
      this.atmosphere.setBlueScatter(buffer.readFloat());
      this.atmosphere.setBrightnessMultiplier(buffer.readFloat());
      this.atmosphere.setDensityMultiplier(buffer.readFloat());
      int size = buffer.readInt();
      this.texture = new class_2960(buffer.method_10800(size));
   }

   public void read(ByteBuffer buffer) {
      this.position.set(buffer.getFloat(), buffer.getFloat(), buffer.getFloat());
      this.radius = buffer.getFloat();
   }

   public int getId() {
      return this.id;
   }

   public class_2960 getTexture() {
      return this.texture;
   }

   public void setTexture(class_2960 texture) {
      this.texture = texture;
   }

   public float getRadius() {
      return this.radius;
   }

   public void setRadius(float radius) {
      this.radius = radius;
   }

   public float getDistance() {
      return this.distance;
   }

   public void setDistance(float distance) {
      this.distance = distance;
   }

   public float getRandomOffset() {
      return this.randomOffset;
   }

   public void setRandomOffset(float randomOffset) {
      this.randomOffset = randomOffset;
   }

   public Vector3d getPosition() {
      return this.position;
   }

   public Atmosphere getAtmosphere() {
      return this.atmosphere;
   }

   public void setAtmosphere(Atmosphere atmosphere) {
      this.atmosphere = atmosphere;
   }

   public Vector3d getTargetPosition() {
      return this.targetPosition;
   }

   public void setTargetPosition(Vector3d position) {
      this.targetPosition.set(position);
   }

   public void tick() {
      this.lastPosition.set(this.position);
      this.position.lerp(this.targetPosition, 0.1);
   }

   public Vector3d getPosition(float partialTick, Vector3d dest) {
      return dest.set(this.lastPosition).lerp(this.position, partialTick);
   }

   public Vector3d getLastPosition() {
      return this.lastPosition;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
