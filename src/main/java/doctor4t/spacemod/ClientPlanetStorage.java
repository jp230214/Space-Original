package doctor4t.spacemod;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.SolarSystemComponent;
import doctor4t.spacemod.planet.Planet;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.post.PostPipeline.Context;
import foundry.veil.api.client.render.shader.definition.ShaderBlock;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1060;
import net.minecraft.class_310;
import org.joml.Vector3dc;
import org.lwjgl.system.NativeResource;

@Environment(EnvType.CLIENT)
public class ClientPlanetStorage implements NativeResource {
   private static final int SIZE = 64;
   private final ShaderBlock<ClientPlanetStorage> block;
   private final List<Planet> planets;
   private final int elements = VeilRenderSystem.shaderLimits(35632).maxTextureImageUnits() - 9;

   public ClientPlanetStorage() {
      this.block = ShaderBlock.withSize(35345, 4 + 64 * this.elements, ClientPlanetStorage::write);
      this.planets = new LinkedList<>();
   }

   public void copyFrom(SolarSystemComponent system) {
      this.planets.clear();
      this.planets.addAll(system.getAllPlanets());
   }

   public void tick() {
      this.planets.forEach(Planet::tick);
   }

   private void write(ByteBuffer buffer) {
      int count = 0;
      int planetCount = Math.min(this.planets.size(), this.elements);

      for (int i = this.planets.size() - planetCount; i < this.planets.size(); i++) {
         buffer.position(count * 64);
         this.planets.get(i).writeToShader(buffer, class_310.method_1551().method_1488());
         count++;
      }

      buffer.putInt(64 * this.elements, count);
   }

   public void updatePlanets(Vector3dc cameraPos) {
      this.planets.sort(Comparator.comparingDouble(data -> -data.getPosition().distanceSquared(cameraPos)));
      this.block.set(this);
      VeilRenderSystem.bind("PlanetsBuffer", this.block);
      VeilRenderSystem.renderer().getShaderDefinitions().define("MAX_PLANETS", Integer.toString(this.elements));
   }

   public void unbind() {
      VeilRenderSystem.unbind(this.block);
   }

   public List<Planet> getPlanets() {
      return this.planets;
   }

   public void uploadTextures(Context access) {
      class_1060 textureManager = class_310.method_1551().method_1531();

      for (Planet planet : this.planets) {
         int id = planet.getId();
         access.setSampler("PlanetTextures[" + id + "]", textureManager.method_4619(planet.getTexture()).method_4624());
      }
   }

   public void free() {
      this.block.free();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
