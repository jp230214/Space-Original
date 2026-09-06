package doctor4t.spacemod;

import com.google.common.collect.ImmutableMap;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.ShipWorldComponent;
import doctor4t.spacemod.cca.SolarSystemComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.duck.ClientPlayerEntityDuck;
import doctor4t.spacemod.entity.DrivingSeatEntity;
import doctor4t.spacemod.entity.PocketStarEntity;
import doctor4t.spacemod.entity.PumpEntity;
import doctor4t.spacemod.entity.SprinklerEntity;
import doctor4t.spacemod.imgui.FadeEditor;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.SpaceModEntities;
import doctor4t.spacemod.index.SpaceModItems;
import doctor4t.spacemod.index.SpaceModParticles;
import doctor4t.spacemod.index.SpaceModSounds;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import doctor4t.spacemod.item.MarshmallowStickItem;
import doctor4t.spacemod.mixin.LivingEntityAccessor;
import doctor4t.spacemod.model.LiquidBlockModel;
import doctor4t.spacemod.model.entity.AirlockDoorEntityModel;
import doctor4t.spacemod.model.entity.BigDoorEntityModel;
import doctor4t.spacemod.model.entity.JetpackModel;
import doctor4t.spacemod.model.entity.PocketStarEntityModel;
import doctor4t.spacemod.model.entity.SmallDoorEntityModel;
import doctor4t.spacemod.model.entity.SpaceHelmetModel;
import doctor4t.spacemod.particle.FlowParticle;
import doctor4t.spacemod.planet.Planet;
import doctor4t.spacemod.renderer.block_entity.JetpackBlockEntityRenderer;
import doctor4t.spacemod.renderer.block_entity.SpaceHelmetBlockEntityRenderer;
import doctor4t.spacemod.renderer.debris_field.DebrisRenderer;
import doctor4t.spacemod.renderer.entity.AirlockEntityRenderer;
import doctor4t.spacemod.renderer.entity.BigDoorEntityRenderer;
import doctor4t.spacemod.renderer.entity.PocketStarEntityRenderer;
import doctor4t.spacemod.renderer.entity.SmallDoorEntityRenderer;
import doctor4t.spacemod.renderer.item.JetpackDynamicItemRenderer;
import doctor4t.spacemod.renderer.item.SpaceHelmetDynamicItemRenderer;
import doctor4t.spacemod.renderer.item.TelescopeDynamicItemRenderer;
import doctor4t.spacemod.renderer.ui.SpaceSuitBarsRenderer;
import doctor4t.spacemod.sound.DirectToClientSoundInstance;
import doctor4t.spacemod.sound.JetpackSoundInstance;
import doctor4t.spacemod.sound.PumpSoundInstance;
import doctor4t.spacemod.sound.SprinklerSoundInstance;
import doctor4t.spacemod.util.BufferUtils;
import foundry.veil.api.client.editor.EditorManager;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.deferred.light.AreaLight;
import foundry.veil.api.client.render.deferred.light.PointLight;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.post.PostProcessingManager;
import foundry.veil.api.event.VeilRenderLevelStageEvent.Stage;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import foundry.veil.platform.VeilEventPlatform;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents.Load;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.EndTick;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.EndWorldTick;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin.Context;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier.OnLoad;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.Disconnect;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.class_1091;
import net.minecraft.class_1100;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_243;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import net.minecraft.class_3532;
import net.minecraft.class_5272;
import net.minecraft.class_5601;
import net.minecraft.class_5616;
import net.minecraft.class_6344;
import net.minecraft.class_742;
import net.minecraft.class_744;
import net.minecraft.class_746;
import net.minecraft.class_7923;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;

@Environment(EnvType.CLIENT)
public class SpaceModClient implements ClientModInitializer {
   public static final boolean HEAR_SELF = false;
   public static final class_5601 BIG_DOOR = new class_5601(SpaceMod.id("big_door"), "main");
   public static final class_5601 AIRLOCK_DOOR = new class_5601(SpaceMod.id("airlock_door"), "main");
   public static final class_5601 SMALL_DOOR = new class_5601(SpaceMod.id("small_door"), "main");
   public static final class_5601 SPACE_HELMET = new class_5601(SpaceMod.id("space_helmet"), "main");
   public static final class_5601 JETPACK = new class_5601(SpaceMod.id("jetpack"), "main");
   public static final class_5601 POCKET_STAR = new class_5601(SpaceMod.id("pocket_star"), "main");
   public static final ImmutableMap<PlayerSpaceComponent.Type, class_5601> SPACE_SUIT_HELMET_LAYERS = ImmutableMap.builder()
      .put(PlayerSpaceComponent.Type.DEFAULT, SPACE_HELMET)
      .put(PlayerSpaceComponent.Type.RAT, SPACE_HELMET)
      .put(PlayerSpaceComponent.Type.WINSWEEP, SPACE_HELMET)
      .put(PlayerSpaceComponent.Type.EIGHT, SPACE_HELMET)
      .put(PlayerSpaceComponent.Type.RYAN, SPACE_HELMET)
      .put(PlayerSpaceComponent.Type.LUX, SPACE_HELMET)
      .put(PlayerSpaceComponent.Type.SILVER, SPACE_HELMET)
      .put(PlayerSpaceComponent.Type.BOBA, SPACE_HELMET)
      .build();
   public static final ImmutableMap<PlayerSpaceComponent.Type, class_5601> JETPACK_LAYERS = ImmutableMap.builder()
      .put(PlayerSpaceComponent.Type.DEFAULT, JETPACK)
      .put(PlayerSpaceComponent.Type.RAT, JETPACK)
      .put(PlayerSpaceComponent.Type.WINSWEEP, JETPACK)
      .put(PlayerSpaceComponent.Type.EIGHT, JETPACK)
      .put(PlayerSpaceComponent.Type.RYAN, JETPACK)
      .put(PlayerSpaceComponent.Type.LUX, JETPACK)
      .put(PlayerSpaceComponent.Type.SILVER, JETPACK)
      .put(PlayerSpaceComponent.Type.BOBA, JETPACK)
      .build();
   public static final class_2960 JANUS_SHADER_LOCATION = SpaceMod.id("janus");
   private static final class_2960 SPACE_SHADER_LOCATION = SpaceMod.id("space");
   private static final class_2960 FADE_SHADER_LOCATION = SpaceMod.id("fade");
   private static final class_2960 LIQUID_FOG_LOCATION = SpaceMod.id("liquid_fog");
   public static boolean ryanMode;
   public static boolean frozen;
   public static long time = 0L;
   public static long heartTime = 0L;
   public static Vector3d rotationFromMouse = new Vector3d();
   public static float lastTickFade = 0.0F;
   public static float fade = 0.0F;
   public static boolean goingDown = false;
   public static ClientPlanetStorage clientPlanetStorage;
   public static Map<UUID, AreaLight> flashLights = new Object2ObjectOpenHashMap();
   public static Map<Integer, PointLight> pocketStars = new Object2ObjectOpenHashMap();
   public static Map<UUID, PointLight> heldPocketStars = new Object2ObjectOpenHashMap();
   public static Map<UUID, JetpackSoundInstance> jetpackSounds = new Object2ObjectOpenHashMap();
   public static class_2960 JETPACK_FLAME_PARTICLE = SpaceMod.id("jetpack_flame");
   public static class_2960 JETPACK_SMOKE_PARTICLE = SpaceMod.id("jetpack_smoke");
   @Nullable
   public static LiquidBlock submergedLiquid = null;
   public static float lightmapScale = 0.0F;
   public static float spaceTimer = 0.0F;
   public static float shipTimer = 0.0F;
   public static float lowpassScale = 1.0F;
   private final Vector3d linearImpulse = new Vector3d();
   private final Vector3d angularImpulse = new Vector3d();
   private final Vector3d smoothPos = new Vector3d();
   private final Quaterniond smoothOrientation = new Quaterniond();
   public boolean prevJetpackStatus = false;
   public boolean hasPlayedLowIchorWarning = false;
   public boolean hasPlayedLowO2Warning = false;
   public boolean hasPlayedLowHealthWarning = false;
   public boolean hasPlayedCriticalIchorWarning = false;
   public boolean hasPlayedCriticalO2Warning = false;
   public boolean hasPlayedCriticalHealthWarning = false;

   private static float getPartialTick() {
      class_310 client = class_310.method_1551();
      float partialTick = client.method_1488();
      if (client.method_1493()) {
         partialTick = 1.0F;
      }

      return partialTick;
   }

   public static boolean shouldDisableHudAndDebug() {
      class_310 client = class_310.method_1551();
      return client == null || !client.field_1724.method_7337() && !client.field_1724.method_7325();
   }

   public void onInitializeClient() {
      EntityRendererRegistry.register(SpaceModEntities.DRIVING_SEAT, class_6344::new);
      EntityRendererRegistry.register(SpaceModEntities.BIG_DOOR, BigDoorEntityRenderer::new);
      EntityRendererRegistry.register(SpaceModEntities.AIRLOCK, AirlockEntityRenderer::new);
      EntityRendererRegistry.register(
         SpaceModEntities.SMALL_GLASS_DOOR, ctx -> new SmallDoorEntityRenderer(ctx, SpaceMod.id("textures/entity/small_glass_door.png"))
      );
      EntityRendererRegistry.register(
         SpaceModEntities.SMALL_WOOD_DOOR, ctx -> new SmallDoorEntityRenderer(ctx, SpaceMod.id("textures/entity/small_wood_door.png"))
      );
      EntityRendererRegistry.register(SpaceModEntities.SPRINKLER, class_6344::new);
      EntityRendererRegistry.register(SpaceModEntities.SEAT, class_6344::new);
      EntityRendererRegistry.register(SpaceModEntities.PUMP, class_6344::new);
      EntityRendererRegistry.register(SpaceModEntities.POCKET_STAR, PocketStarEntityRenderer::new);
      SpaceModKeybinds.initialize();
      BlockRenderLayerMap.INSTANCE
         .putBlocks(
            class_1921.method_23581(),
            new class_2248[]{
               SpaceModBlocks.METAL_VENT_HATCH,
               SpaceModBlocks.CAST_VENT_HATCH,
               SpaceModBlocks.TARNISHED_GOLD_VENT_HATCH,
               SpaceModBlocks.METAL_SHEET_WALKWAY,
               SpaceModBlocks.METAL_LADDER,
               SpaceModBlocks.COCKPIT_DOOR,
               SpaceModBlocks.METAL_SHEET_DOOR,
               SpaceModBlocks.GOLDEN_GLASS_PANEL,
               SpaceModBlocks.CULLING_GLASS,
               SpaceModBlocks.STAINLESS_STEEL_WALKWAY,
               SpaceModBlocks.DARK_STEEL_WALKWAY,
               SpaceModBlocks.PANEL_STRIPES,
               SpaceModBlocks.TRIMMED_RAILING_POST,
               SpaceModBlocks.DIAGONAL_TRIMMED_RAILING,
               SpaceModBlocks.TRIMMED_RAILING,
               SpaceModBlocks.TRIMMED_EBONY_STAIRS,
               SpaceModBlocks.WHITE_LOUNGE_COUCH,
               SpaceModBlocks.DRIVING_SEAT,
               SpaceModBlocks.WHITE_OTTOMAN,
               SpaceModBlocks.WHITE_TRIMMED_BED,
               SpaceModBlocks.BLUE_LOUNGE_COUCH,
               SpaceModBlocks.GREEN_LOUNGE_COUCH,
               SpaceModBlocks.BAR_STOOL,
               SpaceModBlocks.WALL_LAMP,
               SpaceModBlocks.SMALL_BUTTON,
               SpaceModBlocks.ELEVATOR_BUTTON,
               SpaceModBlocks.METAL_SPRINKLER,
               SpaceModBlocks.GOLD_SPRINKLER,
               SpaceModBlocks.GOLD_ORNAMENT,
               SpaceModBlocks.MAUVE_PLUSH,
               SpaceModBlocks.MARSHMALLOW_CAN,
               SpaceModBlocks.CANISTER,
               SpaceModBlocks.THRUSTER
            }
         );
      BlockRenderLayerMap.INSTANCE
         .putBlocks(
            class_1921.method_23583(),
            new class_2248[]{
               SpaceModBlocks.RHOMBUS_GLASS,
               SpaceModBlocks.PRIVACY_GLASS_PANEL,
               SpaceModBlocks.CULLING_BLACK_HULL,
               SpaceModBlocks.CULLING_WHITE_HULL,
               SpaceModBlocks.HULL_GLASS
            }
         );
      SpaceModClient.CustomModelProvider customModelProvider = new SpaceModClient.CustomModelProvider();
      customModelProvider.registerLiquid(SpaceModBlocks.LIQUID_ICHOR);
      ModelLoadingPlugin.register(customModelProvider);
      EntityModelLayerRegistry.registerModelLayer(BIG_DOOR, BigDoorEntityModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(AIRLOCK_DOOR, AirlockDoorEntityModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(SMALL_DOOR, SmallDoorEntityModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(SPACE_HELMET, SpaceHelmetModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JETPACK, JetpackModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(POCKET_STAR, PocketStarEntityModel::getTexturedModelData);
      class_5616.method_32144(SpaceModBlockEntities.SPACE_HELMET, SpaceHelmetBlockEntityRenderer::new);
      class_5616.method_32144(SpaceModBlockEntities.JETPACK, JetpackBlockEntityRenderer::new);
      BuiltinItemRendererRegistry.INSTANCE.register(SpaceModBlocks.SPACE_HELMET, new SpaceHelmetDynamicItemRenderer());
      BuiltinItemRendererRegistry.INSTANCE.register(SpaceModBlocks.JETPACK, new JetpackDynamicItemRenderer());
      BuiltinItemRendererRegistry.INSTANCE.register(SpaceModItems.TELESCOPE, new TelescopeDynamicItemRenderer());
      ModelLoadingPlugin.register(
         pluginContext -> pluginContext.addModels(new class_2960[]{TelescopeDynamicItemRenderer.TELESCOPE, TelescopeDynamicItemRenderer.TELESCOPE_IN_HAND})
      );
      ParticleFactoryRegistry.getInstance().register(SpaceModParticles.ICHOR_FLOW, FlowParticle.Factory::new);
      VeilEventPlatform.INSTANCE.onVeilRendererAvailable(renderer -> clientPlanetStorage = new ClientPlanetStorage());
      Vector3d adjustedPos = new Vector3d();
      VeilEventPlatform.INSTANCE
         .onVeilRenderTypeStageRender(
            (stage, levelRenderer, bufferSource, poseStack, projectionMatrix, renderTick, partialTicks, camera, frustum) -> {
               if (stage == Stage.AFTER_LEVEL) {
                  class_310 client = class_310.method_1551();
                  if (client.field_1687 != null && client.field_1724 != null) {
                     PostProcessingManager postProcessingManager = VeilRenderSystem.renderer().getPostProcessingManager();
                     PostPipeline liquidFogPipeline = postProcessingManager.getPipeline(LIQUID_FOG_LOCATION);
                     if (liquidFogPipeline != null) {
                        int liquidColor;
                        if (submergedLiquid != null) {
                           liquidColor = submergedLiquid.getLiquid().getColor();
                        } else {
                           if (!((PlayerSpaceComponent)SpaceModComponents.SPACE.get(client.field_1724)).isDead()) {
                              return;
                           }

                           liquidColor = 0;
                        }

                        liquidFogPipeline.setVector(
                           "liquidColor", ((liquidColor & 0xFF0000) >> 16) / 255.0F, ((liquidColor & 0xFF00) >> 8) / 255.0F, (liquidColor & 0xFF) / 255.0F
                        );
                        postProcessingManager.runPipeline(liquidFogPipeline, false);
                     }
                  }
               }
            }
         );
      VeilEventPlatform.INSTANCE
         .onVeilRenderTypeStageRender(
            (stage, levelRenderer, bufferSource, poseStack, projectionMatrix, renderTick, partialTicks, camera, frustum) -> {
               PostProcessingManager postProcessingManager = VeilRenderSystem.renderer().getPostProcessingManager();
               if (stage == Stage.AFTER_BLOCK_ENTITIES) {
                  renderFadePipeline(partialTicks);
               }

               if (stage == Stage.AFTER_CUTOUT_BLOCKS) {
                  class_310 client = class_310.method_1551();
                  class_1937 world = client.field_1687;
                  float partialTick = getPartialTick();
                  if (client.field_1687 != null) {
                     PostPipeline janusFogPipeline = postProcessingManager.getPipeline(JANUS_SHADER_LOCATION);
                     if (janusFogPipeline != null) {
                        PostPipeline spacePipeline = postProcessingManager.getPipeline(SPACE_SHADER_LOCATION);
                        if (spacePipeline != null) {
                           if (client.method_1493()) {
                              partialTick = 1.0F;
                           }

                           boolean isSpace = world.method_27983().equals(SpaceModDimensions.SPACE);
                           boolean isJanus = world.method_27983().equals(SpaceModDimensions.JANUS);
                           if (isSpace || isJanus) {
                              spacePipeline.setInt("UnrenderedPlanet", -1);
                              ShipWorldComponent shipWorldComponent = (ShipWorldComponent)SpaceModComponents.SHIP.get(world);
                              spacePipeline.setFloat("Time", ((float)world.method_8510() + partialTick) / 20.0F);
                              spacePipeline.setVector("ShipCenter", 0.5F, 0.5F, 0.5F);
                              shipWorldComponent.getPosition(partialTick, this.smoothPos);
                              shipWorldComponent.getOrientation(partialTick, this.smoothOrientation).conjugate();
                              if (isJanus) {
                                 int janusId = 9;
                                 Planet janusData = null;

                                 for (Planet planet : clientPlanetStorage.getPlanets()) {
                                    if (planet.getId() == janusId) {
                                       janusData = planet;
                                       break;
                                    }
                                 }

                                 if (janusData != null) {
                                    Vector3d janusPos = new Vector3d(janusData.getPosition(partialTick, this.smoothPos));
                                    Vector3d janusRelativePosition = new Vector3d(1.0, 0.0, 0.0).normalize().mul(janusData.getRadius());
                                    double t = 0.0;
                                    janusPos.add(janusRelativePosition);
                                    this.smoothPos.set(janusPos).mul(1000000.0);
                                    this.smoothOrientation.set(new Quaterniond().rotateZ(Math.toRadians(90.0)));
                                    double x = new Vector3d(0.0).sub(this.smoothPos).normalize().x;
                                    lightmapScale = (float)class_3532.method_16436((x + 1.0) / 2.0, -1.0, -0.2F);
                                    spacePipeline.setInt("UnrenderedPlanet", janusId);
                                 }
                              }

                              PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(client.field_1724);
                              spacePipeline.setFloat("SunFac", playerSpaceComponent.isInSpace() ? 2.5F : 1.0F);
                              spacePipeline.setVector("ShipPosition", (float)this.smoothPos.x, (float)this.smoothPos.y, (float)this.smoothPos.z);
                              spacePipeline.setVector(
                                 "ShipRotation",
                                 (float)this.smoothOrientation.w,
                                 (float)this.smoothOrientation.x,
                                 (float)this.smoothOrientation.y,
                                 (float)this.smoothOrientation.z
                              );
                              class_243 cameraPos = client.field_1773.method_19418().method_19326();
                              adjustedPos.set(cameraPos.field_1352 - 0.5, cameraPos.field_1351 - 0.5, cameraPos.field_1350 - 0.5);
                              this.smoothOrientation.transform(adjustedPos);
                              adjustedPos.add(this.smoothPos);
                              adjustedPos.mul(1.0E-6);
                              clientPlanetStorage.updatePlanets(adjustedPos);
                              clientPlanetStorage.uploadTextures(postProcessingManager.getContext());
                              postProcessingManager.runPipeline(spacePipeline, false);
                              if (isJanus) {
                                 postProcessingManager.runPipeline(janusFogPipeline, false);
                              }

                              clientPlanetStorage.unbind();
                           }
                        }
                     }
                  }
               }
            }
         );
      ClientPlayConnectionEvents.DISCONNECT.register((Disconnect)(handler, client) -> client.execute(() -> {
         flashLights.clear();
         pocketStars.clear();
         heldPocketStars.clear();
         jetpackSounds.clear();
      }));
      VeilEventPlatform.INSTANCE
         .onVeilRenderTypeStageRender(
            (stage, levelRenderer, bufferSource, poseStack, projectionMatrix, renderTick, partialTicks, camera, frustum) -> {
               if (stage == Stage.AFTER_SKY) {
                  for (class_742 player : class_310.method_1551().field_1687.method_18456()) {
                     if (player != null) {
                        PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
                        if (playerSpaceComponent.isFlashlightOn()) {
                           class_243 cameraPosVec = player.method_5836(partialTicks).method_1020(player.method_5828(partialTicks).method_1021(0.3F));
                           if (!flashLights.containsKey(player.method_5667())) {
                              AreaLight flashLight = new AreaLight();
                              flashLight.setBrightness(1.5F);
                              flashLight.setColor(16777215);
                              flashLight.setDistance(150.0F);
                              flashLight.setAngle(1.0F);
                              flashLight.setSize(0.5, 0.5);
                              flashLight.setPosition(cameraPosVec.method_10216(), cameraPosVec.method_10214(), cameraPosVec.method_10215());
                              flashLight.getOrientation()
                                 .identity()
                                 .rotateXYZ(
                                    (float)(-Math.toRadians(player.method_5695(class_310.method_1551().method_1488()))),
                                    (float)Math.toRadians(player.method_5705(class_310.method_1551().method_1488())),
                                    player.method_6003()
                                 );
                              player.method_5783(SpaceModSounds.ENTITY_FLASHLIGHT_TOGGLE, 0.5F, 1.0F);
                              flashLights.put(player.method_5667(), flashLight);
                              VeilRenderSystem.renderer().getDeferredRenderer().getLightRenderer().addLight(flashLight);
                           }

                           AreaLight flashLight = flashLights.get(player.method_5667());
                           Vector3d p = flashLight.getPosition()
                              .lerp(new Vector3d(cameraPosVec.method_10216(), cameraPosVec.method_10214(), cameraPosVec.method_10215()), 0.1F, new Vector3d());
                           flashLight.setPosition(p);
                           Quaternionf goal = new Quaternionf()
                              .rotateXYZ(
                                 (float)(-Math.toRadians(player.method_5695(class_310.method_1551().method_1488()))),
                                 (float)Math.toRadians(player.method_5705(class_310.method_1551().method_1488())),
                                 player.method_6003()
                              );
                           flashLight.getOrientation().slerp(goal, 0.1F);
                        }

                        if (playerSpaceComponent.isHoldingPocketStar()) {
                           class_243 cameraPosVec = player.method_5836(partialTicks).method_1020(player.method_5828(partialTicks).method_1021(0.3F));
                           if (!heldPocketStars.containsKey(player.method_5667())) {
                              PointLight light = new PointLight();
                              light.setBrightness(2.0F);
                              light.setColor(9887829);
                              light.setRadius(10.0F);
                              light.setPosition(cameraPosVec.method_10216(), cameraPosVec.method_10214(), cameraPosVec.method_10215());
                              heldPocketStars.put(player.method_5667(), light);
                              VeilRenderSystem.renderer().getDeferredRenderer().getLightRenderer().addLight(light);
                           }

                           PointLight light = heldPocketStars.get(player.method_5667());
                           light.setPosition(cameraPosVec.method_10216(), cameraPosVec.method_10214(), cameraPosVec.method_10215());
                           Quaternionf var43 = new Quaternionf()
                              .rotateXYZ(
                                 (float)(-Math.toRadians(player.method_5695(class_310.method_1551().method_1488()))),
                                 (float)Math.toRadians(player.method_5705(class_310.method_1551().method_1488())),
                                 player.method_6003()
                              );
                        }
                     }
                  }

                  for (class_1297 entity : class_310.method_1551().field_1687.method_18112()) {
                     if (entity instanceof PocketStarEntity pocketStar) {
                        Vector3d renderPosition = pocketStar.getRenderPosition(partialTicks);
                        if (!pocketStars.containsKey(pocketStar.method_5628())) {
                           PointLight light = new PointLight();
                           light.setBrightness(2.0F);
                           light.setColor(9887829);
                           light.setRadius(10.0F);
                           light.setPosition(renderPosition.x(), renderPosition.y(), renderPosition.z());
                           pocketStars.put(pocketStar.method_5628(), light);
                           VeilRenderSystem.renderer().getDeferredRenderer().getLightRenderer().addLight(light);
                        }

                        PointLight light = pocketStars.get(pocketStar.method_5628());
                        light.setPosition(renderPosition.x(), renderPosition.y(), renderPosition.z());
                     }
                  }

                  ArrayList<UUID> flashlightsToRemove = new ArrayList<>();

                  for (UUID uuid : flashLights.keySet()) {
                     class_1657 playerByUuid = class_310.method_1551().field_1687.method_18470(uuid);
                     if (playerByUuid != null && !((PlayerSpaceComponent)SpaceModComponents.SPACE.get(playerByUuid)).isFlashlightOn()) {
                        flashlightsToRemove.add(uuid);
                        playerByUuid.method_5783(SpaceModSounds.ENTITY_FLASHLIGHT_TOGGLE, 0.5F, 0.8F);
                     }

                     if (playerByUuid == null) {
                        flashlightsToRemove.add(uuid);
                     }
                  }

                  for (UUID uuid : flashlightsToRemove) {
                     VeilRenderSystem.renderer().getDeferredRenderer().getLightRenderer().removeLight(flashLights.get(uuid));
                     flashLights.remove(uuid);
                  }

                  ArrayList<UUID> heldPocketStarsToRemove = new ArrayList<>();

                  for (UUID uuid : heldPocketStars.keySet()) {
                     class_1657 playerByUuid = class_310.method_1551().field_1687.method_18470(uuid);
                     if (playerByUuid != null && !((PlayerSpaceComponent)SpaceModComponents.SPACE.get(playerByUuid)).isHoldingPocketStar()) {
                        heldPocketStarsToRemove.add(uuid);
                     }

                     if (playerByUuid == null) {
                        heldPocketStarsToRemove.add(uuid);
                     }
                  }

                  for (UUID uuid : heldPocketStarsToRemove) {
                     VeilRenderSystem.renderer().getDeferredRenderer().getLightRenderer().removeLight(heldPocketStars.get(uuid));
                     heldPocketStars.remove(uuid);
                  }

                  ArrayList<Integer> pocketStarsToRemove = new ArrayList<>();

                  for (Integer uuid : pocketStars.keySet()) {
                     class_1297 entity = class_310.method_1551().field_1687.method_8469(uuid);
                     if (entity == null) {
                        pocketStarsToRemove.add(uuid);
                     }
                  }

                  for (Integer uuid : pocketStarsToRemove) {
                     VeilRenderSystem.renderer().getDeferredRenderer().getLightRenderer().removeLight(pocketStars.get(uuid));
                     pocketStars.remove(uuid);
                  }
               }
            }
         );
      VeilEventPlatform.INSTANCE.onVeilRendererAvailable(renderer -> {
         EditorManager man = renderer.getEditorManager();
         man.add(new FadeEditor());
         if (ryanMode) {
         }
      });
      VeilEventPlatform.INSTANCE.onFreeNativeResources(() -> clientPlanetStorage.free());
      ClientTickEvents.END_CLIENT_TICK
         .register(
            (EndTick)client -> {
               ryanMode = class_310.field_1703;
               if (!client.method_1493()) {
                  time++;
               }

               Vector3d temp = new Vector3d();
               if (client.field_1724 != null && client.field_1687 != null) {
                  if (!client.method_1493()) {
                     heartTime = (long)(
                        (float)heartTime
                           + (1.0F + (client.field_1724.method_6063() - client.field_1724.method_6032()) / client.field_1724.method_6063() * 2.0F)
                     );
                  }

                  SolarSystemComponent clientSolarSystem = (SolarSystemComponent)SpaceModComponents.SOLAR_SYSTEM.get(client.field_1687);
                  ShipWorldComponent clientShip = (ShipWorldComponent)SpaceModComponents.SHIP.get(client.field_1687);
                  clientPlanetStorage.copyFrom(clientSolarSystem);
                  clientPlanetStorage.tick();
                  lastTickFade = fade;
                  float fadeDecayScale = 0.2F + (1.0F - fade) * 0.8F;
                  float fadeDecayAmount = fade * 0.03F * fadeDecayScale;
                  if (!frozen) {
                     fade -= fadeDecayAmount;
                  }

                  if (client.field_1687.method_27983().equals(SpaceModDimensions.SPACE)) {
                     for (Planet planet : clientSolarSystem.getAllPlanets()) {
                        double dist = clientShip.getPosition(getPartialTick(), new Vector3d())
                           .distance(planet.getPosition(getPartialTick(), new Vector3d()).mul(1000000.0, temp));
                        float planetRadius = planet.getRadius();
                        float planetSlowRadius = planetRadius * 1000000.0F * 1.0F;
                        double distFromSurface = dist - planetSlowRadius * 1.017;
                        double maxDistFromSurface = planetSlowRadius * 0.05;
                        if (distFromSurface < maxDistFromSurface) {
                           double proximity = Math.pow(Math.max(0.0, Math.min((maxDistFromSurface - distFromSurface) / maxDistFromSurface * 1.35, 1.0)), 2.0);
                           fade = Math.max((float)proximity, fade);
                        }
                     }
                  }
               }

               if (client.field_1724 != null
                  && client.field_1687 != null
                  && client.field_1724.method_5765()
                  && client.field_1724.method_5854() instanceof DrivingSeatEntity drivingSeatEntity) {
                  this.linearImpulse.set(0.0);
                  this.angularImpulse.set(0.0);
                  class_744 input = client.field_1724.field_3913;
                  client.field_1724.method_36457(0.0F);
                  client.field_1724.method_36456(drivingSeatEntity.method_36454());
                  client.field_1724.method_5636(drivingSeatEntity.method_36454());
                  this.angularImpulse.add(rotationFromMouse);
                  if (!input.field_3904) {
                     if (input.field_3910) {
                        this.linearImpulse.add(0.0, 0.0, 1.0);
                     }

                     if (input.field_3909) {
                        this.linearImpulse.add(0.0, 0.0, -1.0);
                     }

                     if (input.field_3908) {
                        this.linearImpulse.add(1.0, 0.0, 0.0);
                     }

                     if (input.field_3906) {
                        this.linearImpulse.add(-1.0, 0.0, 0.0);
                     }

                     if (goingDown) {
                        this.linearImpulse.add(0.0, -1.0, 0.0);
                     }

                     if (client.field_1690.field_1867.method_1434()) {
                        this.linearImpulse.add(0.0, 1.0, 0.0);
                     }
                  }

                  this.linearImpulse.rotateY(Math.toRadians(-client.field_1724.method_5705(getPartialTick())));
                  this.angularImpulse.rotateY(Math.toRadians(-client.field_1724.method_5705(getPartialTick())));
                  class_2540 packet = PacketByteBufs.create();
                  BufferUtils.writeVector(packet, this.linearImpulse);
                  BufferUtils.writeVector(packet, this.angularImpulse);
                  packet.writeBoolean(input.field_3904);
                  ClientPlayNetworking.send(SpaceMod.SERVERBOUND_IMPULSE_PACKET, packet);
                  rotationFromMouse.zero();
               }
            }
         );
      class_5272.method_27879(
         SpaceModItems.MARSHMALLOW_STICK,
         SpaceMod.id("marshmallow"),
         (stack, world, entity, seed) -> (float)MarshmallowStickItem.CookState.getCookState(stack).ordinal() / MarshmallowStickItem.CookState.values().length
      );
      class_5272.method_27879(
         SpaceModItems.POCKET_STAR,
         SpaceMod.id("pocket_star"),
         (stack, world, entity, seed) -> (float)MarshmallowStickItem.CookState.getCookState(stack).ordinal() / MarshmallowStickItem.CookState.values().length
      );
      ClientPlayNetworking.registerGlobalReceiver(SpaceMod.CLIENTBOUND_SHIP_POSE_PACKET, (client, handler, buf, responseSender) -> {
         int planetRelativeId = buf.readInt();
         Vector3d position = BufferUtils.readVector(buf, new Vector3d());
         Quaterniond rotation = BufferUtils.readQuaternion(buf, new Quaterniond());
         Vector3d latestLinearImpulse = BufferUtils.readVector(buf, new Vector3d());
         client.execute(() -> {
            ShipWorldComponent component = (ShipWorldComponent)SpaceModComponents.SHIP.get(client.field_1724.method_37908());
            component.setPlanetRelativeId(planetRelativeId);
            component.setNetworkPosition(position);
            component.setNetworkOrientation(rotation);
            component.getLatestLinearImpulse().set(latestLinearImpulse);
         });
      });
      ClientPlayNetworking.registerGlobalReceiver(SpaceMod.CLIENTBOUND_SOLAR_SYSTEM_PACKET, (client, handler, buf, responseSender) -> {
         if (client.field_1724 != null) {
            SolarSystemComponent system = (SolarSystemComponent)SpaceModComponents.SOLAR_SYSTEM.get(client.field_1724.method_37908());
            system.applySyncPacket(buf);
         }
      });
      ClientPlayNetworking.registerGlobalReceiver(SpaceMod.CLIENTBOUND_FREEZE_PACKET, (client, handler, buf, responseSender) -> {
         if (client.field_1724 != null) {
            ((ClientPlayerEntityDuck)client.field_1724).freeze();
         }
      });
      ClientTickEvents.END_WORLD_TICK.register((EndWorldTick)client -> {
         class_746 player = class_310.method_1551().field_1724;
         if (player != null && player.method_37908() != null && SpaceModKeybinds.toggleFlashlight.method_1436()) {
            class_2540 packet = PacketByteBufs.create();
            packet.writeBoolean(!((PlayerSpaceComponent)SpaceModComponents.SPACE.get(player)).isFlashlightOn());
            ClientPlayNetworking.send(SpaceMod.SERVERBOUND_FLASHLIGHT_PACKET, packet);
         }
      });
      ClientTickEvents.END_WORLD_TICK
         .register(
            (EndWorldTick)client -> {
               class_746 player = class_310.method_1551().field_1724;
               if (player != null
                  && !player.method_7325()
                  && !player.method_31549().field_7479
                  && player.method_6118(class_1304.field_6174).method_31574(SpaceModBlocks.JETPACK.method_8389())) {
                  boolean isJetpackOn = class_310.method_1551().field_1690.field_1903.method_1434()
                     && !player.method_24828()
                     && ((LivingEntityAccessor)player).getJumpingCooldown() <= 6;
                  if (isJetpackOn != this.prevJetpackStatus) {
                     class_2540 packet = PacketByteBufs.create();
                     packet.writeBoolean(isJetpackOn);
                     ClientPlayNetworking.send(SpaceMod.SERVERBOUND_JETPACK_PACKET, packet);
                     this.prevJetpackStatus = isJetpackOn;
                  }
               }
            }
         );
      ClientTickEvents.END_WORLD_TICK.register((EndWorldTick)client -> {
         for (class_742 player : class_310.method_1551().field_1687.method_18456()) {
            PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
            if (playerSpaceComponent.isJetpackOn() && playerSpaceComponent.getOxygen() > 0 && playerSpaceComponent.getFuel() > 0) {
               ParticleSystemManager particleManager = VeilRenderSystem.renderer().getParticleManager();
               ParticleEmitter flameEmitter = particleManager.createEmitter(JETPACK_FLAME_PARTICLE);
               ParticleEmitter smokeEmitter = particleManager.createEmitter(JETPACK_SMOKE_PARTICLE);
               float dist = 0.4F;
               float y = 0.9F;
               if (flameEmitter != null) {
                  flameEmitter.setPosition(Math.sin(Math.toRadians(player.field_6283)) * dist, y, -Math.cos(Math.toRadians(player.field_6283)) * dist);
                  flameEmitter.setAttachedEntity(player);
                  particleManager.addParticleSystem(flameEmitter);
               }

               if (smokeEmitter != null) {
                  smokeEmitter.setPosition(Math.sin(Math.toRadians(player.field_6283)) * dist, y, -Math.cos(Math.toRadians(player.field_6283)) * dist);
                  smokeEmitter.setAttachedEntity(player);
                  particleManager.addParticleSystem(smokeEmitter);
               }

               if (!jetpackSounds.containsKey(player.method_5667())) {
                  JetpackSoundInstance jetpackSoundInstance = new JetpackSoundInstance(player);
                  jetpackSounds.put(player.method_5667(), jetpackSoundInstance);
                  player.method_5783(SpaceModSounds.ENTITY_JETPACK_START, 1.0F, 0.8F);
                  class_310.method_1551().method_1483().method_22140(jetpackSoundInstance);
               }
            }
         }

         ArrayList<UUID> jetpackSoundsToRemove = new ArrayList<>();

         for (UUID uuid : jetpackSounds.keySet()) {
            class_1657 playerByUuid = class_310.method_1551().field_1687.method_18470(uuid);
            if (playerByUuid == null || !((PlayerSpaceComponent)SpaceModComponents.SPACE.get(playerByUuid)).isJetpackOn()) {
               jetpackSoundsToRemove.add(uuid);
            }
         }

         for (UUID uuid : jetpackSoundsToRemove) {
            jetpackSounds.get(uuid).setDirty(true);
            jetpackSounds.remove(uuid);
         }
      });
      ClientTickEvents.END_CLIENT_TICK.register((EndTick)client -> {
         if (client.field_1724 != null) {
            boolean inSpace = ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(client.field_1724)).isInSpace();
            if (inSpace) {
               spaceTimer++;
               shipTimer = 0.0F;
            } else {
               spaceTimer = 0.0F;
               shipTimer++;
            }

            lowpassScale = class_3532.method_15363(lowpassScale - (inSpace ? 0.02F : -0.02F), 0.1F, 1.0F);
         }
      });
      ClientTickEvents.END_WORLD_TICK
         .register(
            (EndWorldTick)world -> {
               class_310 client = class_310.method_1551();
               if (client.field_1724 != null) {
                  PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(client.field_1724);
                  if (playerSpaceComponent.getOxygenBarLength(83) <= 10 && !this.hasPlayedCriticalO2Warning) {
                     this.hasPlayedLowO2Warning = true;
                     this.hasPlayedCriticalO2Warning = true;
                     client.field_1724
                        .method_7353(
                           class_2561.method_43471("warning.spacemod.oxygen.critical").method_10862(class_2583.field_24360.method_36139(16711680)), true
                        );
                     client.method_1483().method_4873(new DirectToClientSoundInstance(SpaceModSounds.UI_WARNING_CRITICAL, class_3419.field_15250));
                  } else if (playerSpaceComponent.getOxygenBarLength(83) <= 18 && !this.hasPlayedLowO2Warning) {
                     this.hasPlayedLowO2Warning = true;
                     client.field_1724
                        .method_7353(class_2561.method_43471("warning.spacemod.oxygen.low").method_10862(class_2583.field_24360.method_36139(16711680)), true);
                     client.method_1483().method_4873(new DirectToClientSoundInstance(SpaceModSounds.UI_WARNING_LOW, class_3419.field_15250));
                  }

                  if (playerSpaceComponent.getFuelBarLength(83) <= 10 && !this.hasPlayedCriticalIchorWarning) {
                     this.hasPlayedLowIchorWarning = true;
                     this.hasPlayedCriticalIchorWarning = true;
                     client.field_1724
                        .method_7353(
                           class_2561.method_43471("warning.spacemod.ichor.critical").method_10862(class_2583.field_24360.method_36139(16711680)), true
                        );
                     client.method_1483().method_4873(new DirectToClientSoundInstance(SpaceModSounds.UI_WARNING_CRITICAL, class_3419.field_15250));
                  } else if (playerSpaceComponent.getFuelBarLength(83) <= 18 && !this.hasPlayedLowIchorWarning) {
                     this.hasPlayedLowIchorWarning = true;
                     client.field_1724
                        .method_7353(class_2561.method_43471("warning.spacemod.ichor.low").method_10862(class_2583.field_24360.method_36139(16711680)), true);
                     client.method_1483().method_4873(new DirectToClientSoundInstance(SpaceModSounds.UI_WARNING_LOW, class_3419.field_15250));
                  }

                  if (client.field_1724.method_6032() <= client.field_1724.method_6063() / 5.0F && !this.hasPlayedCriticalHealthWarning) {
                     this.hasPlayedLowHealthWarning = true;
                     this.hasPlayedCriticalHealthWarning = true;
                     client.field_1724
                        .method_7353(
                           class_2561.method_43471("warning.spacemod.health.critical").method_10862(class_2583.field_24360.method_36139(16711680)), true
                        );
                     client.method_1483().method_4873(new DirectToClientSoundInstance(SpaceModSounds.UI_WARNING_CRITICAL, class_3419.field_15250));
                  } else if (client.field_1724.method_6032() <= client.field_1724.method_6063() / 2.5 && !this.hasPlayedLowHealthWarning) {
                     this.hasPlayedLowHealthWarning = true;
                     client.field_1724
                        .method_7353(class_2561.method_43471("warning.spacemod.health.low").method_10862(class_2583.field_24360.method_36139(16711680)), true);
                     client.method_1483().method_4873(new DirectToClientSoundInstance(SpaceModSounds.UI_WARNING_LOW, class_3419.field_15250));
                  }

                  if (playerSpaceComponent.getOxygenBarLength(83) > 18 && this.hasPlayedLowO2Warning) {
                     this.hasPlayedLowO2Warning = false;
                     this.hasPlayedCriticalO2Warning = false;
                  }

                  if (playerSpaceComponent.getFuelBarLength(83) > 18 && this.hasPlayedLowIchorWarning) {
                     this.hasPlayedLowIchorWarning = false;
                     this.hasPlayedCriticalIchorWarning = false;
                  }

                  if (client.field_1724.method_6032() > client.field_1724.method_6063() / 2.5 && this.hasPlayedLowHealthWarning) {
                     this.hasPlayedLowHealthWarning = false;
                     this.hasPlayedCriticalHealthWarning = false;
                  }
               }
            }
         );
      ClientEntityEvents.ENTITY_LOAD.register((Load)(entity, world) -> {
         if (entity instanceof SprinklerEntity) {
            class_310.method_1551().method_1483().method_22140(new SprinklerSoundInstance((SprinklerEntity)entity));
         }

         if (entity instanceof PumpEntity && PumpEntity.shouldPlayAudio(world, entity.method_24515())) {
            class_310.method_1551().method_1483().method_22140(new PumpSoundInstance((PumpEntity)entity));
         }
      });
      HudRenderCallback.EVENT.register(new SpaceSuitBarsRenderer());
      DebrisRenderer.init();
   }

   public static void renderFadePipeline(float partialTicks) {
      PostProcessingManager postProcessingManager = VeilRenderSystem.renderer().getPostProcessingManager();
      PostPipeline fadePipeline = postProcessingManager.getPipeline(FADE_SHADER_LOCATION);
      if (fadePipeline != null) {
         fadePipeline.setFloat("Fade", lastTickFade + (fade - lastTickFade) * partialTicks);
         fadePipeline.setVector("FadeColor", 0.6862745F, 0.6431373F, 0.7411765F);
         postProcessingManager.runPipeline(fadePipeline, false);
      }
   }

   public static boolean shouldLockInPlace() {
      return class_310.method_1551().field_1724 != null
         && ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(class_310.method_1551().field_1724)).isDead()
         && !class_310.method_1551().field_1724.method_7325()
         && !class_310.method_1551().field_1724.method_7337()
         && !class_310.method_1551().method_1493();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }

   @Environment(EnvType.CLIENT)
   public static class CustomModelProvider implements ModelLoadingPlugin {
      private final Map<class_2960, class_1100> modelIdToBlock = new LinkedHashMap<>();

      public void registerLiquid(class_2248... blocks) {
         for (class_2248 block : blocks) {
            this.modelIdToBlock.put(class_7923.field_41175.method_10221(block), new LiquidBlockModel(block));
         }
      }

      public void onInitializeModelLoader(Context ctx) {
         ctx.modifyModelOnLoad().register((OnLoad)(model, context) -> {
            if (context.id() instanceof class_1091 modelIdentifier && modelIdentifier.method_4740().equals("inventory")) {
               return model;
            } else {
               class_2960 id = new class_2960(context.id().method_12836(), context.id().method_12832());
               return this.modelIdToBlock.containsKey(id) ? this.modelIdToBlock.get(id) : model;
            }
         });
      }

      static {
         SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
      }
   }
}
