package doctor4t.spacemod;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.CanisterBlock;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.ShipWorldComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.command.RFTSCommand;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.SpaceModEntities;
import doctor4t.spacemod.index.SpaceModFluids;
import doctor4t.spacemod.index.SpaceModItems;
import doctor4t.spacemod.index.SpaceModLiquids;
import doctor4t.spacemod.index.SpaceModPaintingVariants;
import doctor4t.spacemod.index.SpaceModParticles;
import doctor4t.spacemod.index.SpaceModRegistries;
import doctor4t.spacemod.index.SpaceModSounds;
import doctor4t.spacemod.index.world.SpaceModDensityFunctions;
import doctor4t.spacemod.index.world.SpaceModStructurePieceTypes;
import doctor4t.spacemod.index.world.SpaceModStructureTypes;
import doctor4t.spacemod.util.BufferUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDeath;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1269;
import net.minecraft.class_1304;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2378;
import net.minecraft.class_2487;
import net.minecraft.class_2498;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2756;
import net.minecraft.class_2960;
import net.minecraft.class_3222;
import net.minecraft.class_3419;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import org.joml.Vector3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceMod implements ModInitializer {
   public static final String MOD_ID = "spacemod";
   public static final Logger LOGGER = LoggerFactory.getLogger("spacemod");
   public static final class_2960 SERVERBOUND_IMPULSE_PACKET = id("serverbound_impulse_packet");
   public static final class_2960 SERVERBOUND_FLASHLIGHT_PACKET = id("serverbound_flashlight_sync");
   public static final class_2960 SERVERBOUND_JETPACK_PACKET = id("serverbound_jetpack_sync");
   public static final class_2960 SERVERBOUND_HOLD_MARSHMALLOW_PACKET = id("holding_marshmallow");
   public static final class_2960 CLIENTBOUND_SHIP_POSE_PACKET = id("clientbound_ship_pose_packet");
   public static final class_2960 CLIENTBOUND_SOLAR_SYSTEM_PACKET = id("clientbound_solar_system_sync");
   public static final class_2960 CLIENTBOUND_FREEZE_PACKET = id("clientbound_freeze");
   public static final class_2960 CLIENTBOUND_POCKET_STAR_SYNC_PACKET = id("clientbound_pocket_star_sync");
   public static final class_5321<class_1761> ITEM_GROUP = class_5321.method_29179(class_7924.field_44688, id("main"));

   public static class_2960 id(String name) {
      return new class_2960("spacemod", name);
   }

   public void onInitialize() {
      class_2378.method_39197(
         class_7923.field_44687,
         ITEM_GROUP,
         FabricItemGroup.builder()
            .method_47321(class_2561.method_43471("itemGroup.spacemod.main"))
            .method_47320(() -> new class_1799(SpaceModBlocks.SPACE_HELMET))
            .method_47324()
      );
      SpaceModRegistries.initialize();
      SpaceModParticles.initialize();
      SpaceModLiquids.initialize();
      SpaceModPaintingVariants.initialize();
      SpaceModSounds.initialize();
      SpaceModEntities.initialize();
      SpaceModFluids.initialize();
      SpaceModBlocks.initialize();
      SpaceModItems.initialize();
      SpaceModBlockEntities.initialize();
      SpaceModDensityFunctions.initialize();
      SpaceModStructureTypes.initialize();
      SpaceModStructurePieceTypes.initialize();
      CommandRegistrationCallback.EVENT
         .register((CommandRegistrationCallback)(dispatcher, registryAccess, environment) -> RFTSCommand.register(dispatcher, registryAccess));
      ServerPlayNetworking.registerGlobalReceiver(
         SERVERBOUND_IMPULSE_PACKET,
         (server, player, handler, buf, responseSender) -> {
            Vector3d linearImpulse = BufferUtils.readVector(buf, new Vector3d());
            Vector3d angularImpulse = BufferUtils.readVector(buf, new Vector3d());
            boolean stabilizing = buf.readBoolean();
            server.execute(
               () -> {
                  ShipWorldComponent component = (ShipWorldComponent)SpaceModComponents.SHIP.get(player.method_37908());
                  component.getLatestLinearImpulse().set(linearImpulse);
                  component.getVelocity()
                     .add(
                        component.getOrientation()
                           .transform(linearImpulse.mul(((ShipWorldComponent)SpaceModComponents.SHIP.get(player.method_37908())).getLinearMultiplier()))
                     );
                  component.getAngularVelocity()
                     .add(
                        component.getOrientation()
                           .transform(angularImpulse.mul(((ShipWorldComponent)SpaceModComponents.SHIP.get(player.method_37908())).getAngularMultiplier()))
                     );
                  component.setStabilizing(stabilizing);
               }
            );
         }
      );
      ServerPlayNetworking.registerGlobalReceiver(SERVERBOUND_FLASHLIGHT_PACKET, (server, player, handler, buf, responseSender) -> {
         boolean isFlashlightOn = buf.readBoolean();
         server.execute(() -> {
            PlayerSpaceComponent component = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
            component.setFlashlightOn(isFlashlightOn);
            component.sync();
         });
      });
      ServerPlayNetworking.registerGlobalReceiver(SERVERBOUND_JETPACK_PACKET, (server, player, handler, buf, responseSender) -> {
         boolean isJetpackOn = buf.readBoolean();
         server.execute(() -> {
            PlayerSpaceComponent component = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
            component.setJetpackOn(isJetpackOn);
            component.sync();
         });
      });
      ServerPlayNetworking.registerGlobalReceiver(SERVERBOUND_HOLD_MARSHMALLOW_PACKET, (server, player, handler, buf, responseSender) -> {
         boolean holding = buf.readBoolean();
         server.execute(() -> player.spacemod$setHoldingAttack(holding));
      });
      UseBlockCallback.EVENT
         .register(
            (UseBlockCallback)(player, world, hand, hitResult) -> {
               if (player.method_6118(class_1304.field_6174).method_31574(SpaceModBlocks.CANISTER.method_8389())
                  && player.method_5998(hand).method_7960()
                  && player.method_5715()) {
                  class_1799 canisterStack = player.method_6118(class_1304.field_6174);
                  class_2487 nbt = canisterStack.method_7969();
                  class_2338 placePosition = hitResult.method_17777().method_10093(hitResult.method_17780());
                  class_3610 fluidState = world.method_8316(placePosition);
                  class_2680 placementState = (class_2680)((class_2680)((class_2680)SpaceModBlocks.CANISTER
                           .method_9564()
                           .method_11657(CanisterBlock.field_11177, player.method_5735().method_10153()))
                        .method_11657(CanisterBlock.WATERLOGGED, fluidState.method_39360(class_3612.field_15910)))
                     .method_11657(CanisterBlock.LEVEL, nbt != null && nbt.method_10545("ichorState") ? nbt.method_10550("ichorState") : 0);
                  if (!world.method_8320(placePosition.method_10084()).method_26215()
                     && world.method_8320(placePosition).method_26215()
                     && world.method_8320(placePosition.method_10074()).method_26215()) {
                     world.method_8501(placePosition, (class_2680)placementState.method_11657(CanisterBlock.HALF, class_2756.field_12609));
                     world.method_8501(placePosition.method_10074(), (class_2680)placementState.method_11657(CanisterBlock.HALF, class_2756.field_12607));
                  } else {
                     if (!world.method_8320(placePosition).method_26215() || !world.method_8320(placePosition.method_10084()).method_26215()) {
                        return class_1269.field_5811;
                     }

                     world.method_8501(placePosition, (class_2680)placementState.method_11657(CanisterBlock.HALF, class_2756.field_12607));
                     world.method_8501(placePosition.method_10084(), (class_2680)placementState.method_11657(CanisterBlock.HALF, class_2756.field_12609));
                  }

                  player.method_5673(class_1304.field_6174, class_1799.field_8037);
                  class_2498 blockSoundGroup = placementState.method_26231();
                  world.method_8396(
                     player,
                     placePosition,
                     blockSoundGroup.method_10598(),
                     class_3419.field_15245,
                     (blockSoundGroup.field_11540 + 1.0F) / 2.0F,
                     blockSoundGroup.method_10599() * 0.8F
                  );
                  return class_1269.method_29236(world.field_9236);
               } else {
                  return class_1269.field_5811;
               }
            }
         );
      ServerLivingEntityEvents.ALLOW_DEATH.register((AllowDeath)(entity, damageSource, damageAmount) -> {
         if (entity instanceof class_3222 serverPlayer) {
            ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(serverPlayer)).setDead(true);
            serverPlayer.method_6033(1.0F);
            return false;
         } else {
            return true;
         }
      });
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
