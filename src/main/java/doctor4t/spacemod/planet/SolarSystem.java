package doctor4t.spacemod.planet;

import dev.upcraft.sdrm.api.SDRMVerifier;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Collection;
import net.minecraft.class_2540;

public class SolarSystem {
   private final Int2ObjectLinkedOpenHashMap<Planet> planets = new Int2ObjectLinkedOpenHashMap();

   public void writeToPacket(class_2540 buffer) {
      buffer.writeInt(this.planets.size());
      ObjectIterator var2 = this.planets.values().iterator();

      while (var2.hasNext()) {
         Planet planet = (Planet)var2.next();
         planet.writeToPacket(buffer);
      }
   }

   public void readFromPacketClient(class_2540 buffer) {
      int size = buffer.readInt();

      for (int i = 0; i < size; i++) {
         Planet planet = new Planet();
         planet.readFromPacket(buffer);
         Planet existing = (Planet)this.planets.get(planet.getId());
         if (existing != null) {
            existing.setTargetPosition(planet.getPosition());
         } else {
            this.planets.put(planet.getId(), planet);
         }
      }
   }

   public void addPlanet(Planet planet) {
      this.planets.put(planet.getId(), planet);
   }

   public void removePlanet(Planet planet) {
      this.planets.remove(planet);
   }

   public Collection<Planet> getAllPlanets() {
      return this.planets.values();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
