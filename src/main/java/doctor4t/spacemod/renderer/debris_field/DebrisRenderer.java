package doctor4t.spacemod.renderer.debris_field;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.cca.ShipWorldComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import doctor4t.spacemod.planet.Planet;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.event.VeilRenderLevelStageEvent.Stage;
import foundry.veil.fabric.event.FabricVeilRenderLevelStageEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.Disconnect;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2350;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_291;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4604;
import net.minecraft.class_746;
import net.minecraft.class_761;
import net.minecraft.class_291.class_8555;
import net.minecraft.class_293.class_5596;
import net.minecraft.class_4597.class_4598;
import org.joml.Matrix4f;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.lwjgl.system.NativeResource;

@Environment(EnvType.CLIENT)
public class DebrisRenderer implements NativeResource {
   public static final class_293 DEBRIS_FORMAT = new class_293(
      ImmutableMap.builder().put("Position", class_290.field_1587).put("UV0", class_290.field_1591).put("Normal", class_290.field_1579).build()
   );
   private static DebrisRenderer INSTANCE;
   private final class_291 vbo = new class_291(class_8555.field_44793);

   public DebrisRenderer() {
      class_289 tesselator = RenderSystem.renderThreadTesselator();
      class_287 builder = tesselator.method_1349();
      builder.method_1328(class_5596.field_27382, DEBRIS_FORMAT);
      class_4587 matrixStack = new class_4587();

      for (class_2350 dir : class_2350.values()) {
         matrixStack.method_22903();
         matrixStack.method_22904(0.5, 0.5, 0.5);
         matrixStack.method_22907(dir.method_23224());
         matrixStack.method_22907(new Quaternionf().rotateX((float) (Math.PI / 2)));
         matrixStack.method_22904(-0.5, -0.5, -0.5);
         quad(matrixStack.method_23760().method_23761(), builder, dir.method_10148(), dir.method_10164(), dir.method_10165());
         matrixStack.method_22909();
      }

      this.vbo.method_1353();
      this.vbo.method_1352(builder.method_1326());
      class_291.method_1354();
   }

   public static void init() {
      FabricVeilRenderLevelStageEvent.EVENT.register(DebrisRenderer::onRenderLevelStage);
      ClientPlayConnectionEvents.DISCONNECT.register((Disconnect)(handler, client) -> {
         if (INSTANCE != null) {
            INSTANCE.free();
            INSTANCE = null;
         }
      });
   }

   public static void onRenderLevelStage(
      Stage stage,
      class_761 levelRenderer,
      class_4598 bufferSource,
      class_4587 poseStack,
      Matrix4f projectionMatrix,
      int renderTick,
      float partialTicks,
      class_4184 camera,
      class_4604 frustum
   ) {
      if (stage == Stage.AFTER_ENTITIES) {
         if (INSTANCE == null) {
            INSTANCE = new DebrisRenderer();
         }

         INSTANCE.render();
      }
   }

   private static void quad(Matrix4f positionMatrix, class_287 builder, float normalX, float normalY, float normalZ) {
      float uvMin = 0.0F;
      float uvMax = 1.0F;
      builder.method_22918(positionMatrix, 0.0F, 1.0F, 0.0F).method_22913(uvMin, 0.0F).method_22914(normalX, normalY, normalZ).method_1344();
      builder.method_22918(positionMatrix, 1.0F, 1.0F, 0.0F).method_22913(uvMax, 0.0F).method_22914(normalX, normalY, normalZ).method_1344();
      builder.method_22918(positionMatrix, 1.0F, 0.0F, 0.0F).method_22913(uvMax, 1.0F).method_22914(normalX, normalY, normalZ).method_1344();
      builder.method_22918(positionMatrix, 0.0F, 0.0F, 0.0F).method_22913(uvMin, 1.0F).method_22914(normalX, normalY, normalZ).method_1344();
   }

   private void render() {
      class_310 mc = class_310.method_1551();
      class_746 player = mc.field_1724;
      if (player != null) {
         float partialTick = mc.method_1493() ? 1.0F : mc.method_1488();
         class_1937 world = player.method_37908();
         if (world != null && world.method_27983().equals(SpaceModDimensions.SPACE)) {
            ShaderProgram shader = VeilRenderSystem.setShader(SpaceMod.id("debris_instance"));
            if (shader == null) {
               return;
            }

            Planet planet = null;

            for (Planet p : SpaceModClient.clientPlanetStorage.getPlanets()) {
               if (p.getId() == 5) {
                  planet = p;
                  break;
               }
            }

            if (planet == null) {
               return;
            }

            ShipWorldComponent shipWorldComponent = (ShipWorldComponent)SpaceModComponents.SHIP.get(world);
            Vector3d shipPosition = shipWorldComponent.getPosition(partialTick, new Vector3d());
            Quaternionf ringRot = new Quaternionf().rotateX((float) (-Math.PI / 2)).rotateZ(0.09869633F);
            shipPosition.sub(planet.getPosition(partialTick, new Vector3d()).mul(1000000.0));
            ringRot.transformInverse(shipPosition);
            shipPosition.div(1000000.0).sub(0.0, 14.0, 0.0);
            Vector3f off = new Vector3f((float)shipPosition.x, (float)shipPosition.y, (float)shipPosition.z);
            if (off.x * off.x + off.z * off.z > Math.pow(440.0, 2.0)) {
               return;
            }

            if (Math.abs(off.y) < 31.0) {
               Quaterniond shipOrientation = shipWorldComponent.getOrientation(partialTick, new Quaterniond()).conjugate();
               class_4587 stack = new class_4587();
               stack.method_22907(new Quaternionf(shipOrientation));
               stack.method_22907(ringRot);
               Matrix4f mat = stack.method_23760().method_23761();
               shader.setMatrix("ShipPose", mat);
               shader.setFloat("PlanetRadius", planet.getRadius());
               RenderSystem.setShaderTexture(0, SpaceMod.id("textures/space/debris.png"));
               shader.applyRenderSystem();
               shader.applyShaderSamplers(0);
               shader.addRenderSystemTextures();
               shader.setFloat("Time", player.field_6012 + partialTick);
               shader.setVector("Offset", off);
               class_1921.method_23583().method_23516();
               this.vbo.method_1353();
               shader.bind();
               VeilRenderSystem.drawInstanced(this.vbo, 900000);
               class_291.method_1354();
               ShaderProgram.unbind();
               class_1921.method_23583().method_23518();
            }
         }
      }
   }

   public void free() {
      this.vbo.close();
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
