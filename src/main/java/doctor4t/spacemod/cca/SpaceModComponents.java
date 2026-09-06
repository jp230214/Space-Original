package doctor4t.spacemod.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.cca.entity.HoldingComponent;
import doctor4t.spacemod.entity.PocketStarEntity;

public class SpaceModComponents implements WorldComponentInitializer, EntityComponentInitializer {
   public static final ComponentKey<SolarSystemComponent> SOLAR_SYSTEM = ComponentRegistry.getOrCreate(SpaceMod.id("solar_system"), SolarSystemComponent.class);
   public static final ComponentKey<ShipWorldComponent> SHIP = ComponentRegistry.getOrCreate(SpaceMod.id("ship"), ShipWorldComponent.class);
   public static final ComponentKey<PlayerSpaceComponent> SPACE = ComponentRegistry.getOrCreate(SpaceMod.id("space"), PlayerSpaceComponent.class);
   public static final ComponentKey<HoldingComponent> HOLDING = ComponentRegistry.getOrCreate(
      SpaceMod.SERVERBOUND_HOLD_MARSHMALLOW_PACKET, HoldingComponent.class
   );
   public static final ComponentKey<PocketStarPhysicsComponent> POCKET_STAR_PHYSICS = ComponentRegistry.getOrCreate(
      SpaceMod.id("pocket_star_physics"), PocketStarPhysicsComponent.class
   );

   public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
      registry.register(SOLAR_SYSTEM, SolarSystemComponent::new);
      registry.register(SHIP, ShipWorldComponent::new);
   }

   public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
      registry.registerForPlayers(SPACE, PlayerSpaceComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
      registry.registerForPlayers(HOLDING, HoldingComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
      registry.registerFor(PocketStarEntity.class, POCKET_STAR_PHYSICS, PocketStarPhysicsComponent::new);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
