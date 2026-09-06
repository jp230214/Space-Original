package doctor4t.spacemod.model;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.LiquidBlock;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.material.MaterialFinder;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.class_1058;
import net.minecraft.class_1059;
import net.minecraft.class_1087;
import net.minecraft.class_1100;
import net.minecraft.class_1920;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3665;
import net.minecraft.class_4730;
import net.minecraft.class_4944;
import net.minecraft.class_5819;
import net.minecraft.class_777;
import net.minecraft.class_7775;
import net.minecraft.class_806;
import net.minecraft.class_809;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class LiquidBlockModel implements FabricBakedModel, class_1100, class_1087 {
   private final class_4730 spriteId;
   private class_1058 sprite;

   public LiquidBlockModel(class_2248 liquid) {
      this.spriteId = new class_4730(class_1059.field_5275, class_4944.method_25860(liquid));
   }

   public void emitBlockQuads(class_1920 blockView, class_2680 state, class_2338 pos, Supplier<class_5819> randomSupplier, RenderContext context) {
      Renderer renderer = RendererAccess.INSTANCE.getRenderer();
      if (renderer != null) {
         MaterialFinder materialFinder = renderer.materialFinder();
         MeshBuilder meshBuilder = renderer.meshBuilder();
         QuadEmitter emitter = meshBuilder.getEmitter();
         materialFinder.clear();
         materialFinder.ambientOcclusion(TriState.FALSE);
         materialFinder.disableDiffuse(true);
         RenderMaterial material = materialFinder.find();
         if (this.isLiquid(blockView.method_8320(pos.method_10084()))) {
            this.emitSides(emitter, material, blockView, pos, 1.0F, 1.0F, 1.0F, 1.0F);
         } else {
            boolean topCovered = this.sideCulled(blockView, pos, class_2350.field_11036);
            int level = (Integer)state.method_11654(LiquidBlock.LEVEL);
            int northLevel = this.getLevel(blockView, pos, class_2350.field_11043);
            int eastLevel = this.getLevel(blockView, pos, class_2350.field_11034);
            int southLevel = this.getLevel(blockView, pos, class_2350.field_11035);
            int westLevel = this.getLevel(blockView, pos, class_2350.field_11039);
            float northEastHeight = this.getLevel(blockView, level, northLevel, eastLevel, topCovered, pos, class_2350.field_11043, class_2350.field_11034)
               / 64.0F;
            float southEastHeight = this.getLevel(blockView, level, southLevel, eastLevel, topCovered, pos, class_2350.field_11035, class_2350.field_11034)
               / 64.0F;
            float northWestHeight = this.getLevel(blockView, level, northLevel, westLevel, topCovered, pos, class_2350.field_11043, class_2350.field_11039)
               / 64.0F;
            float southWestHeight = this.getLevel(blockView, level, southLevel, westLevel, topCovered, pos, class_2350.field_11035, class_2350.field_11039)
               / 64.0F;
            float height = level / 64.0F;
            this.emit(emitter, material, topCovered, height, 0.0F, northWestHeight, 0.0F, 0.0F, southWestHeight, 1.0F);
            this.emit(emitter, material, topCovered, height, 0.0F, southWestHeight, 1.0F, 1.0F, southEastHeight, 1.0F);
            this.emit(emitter, material, topCovered, height, 1.0F, southEastHeight, 1.0F, 1.0F, northEastHeight, 0.0F);
            this.emit(emitter, material, topCovered, height, 1.0F, northEastHeight, 0.0F, 0.0F, northWestHeight, 0.0F);
            if (!topCovered || height != 1.0F) {
               this.emit(
                  emitter, material, 0.25F, height - 0.001F, 0.25F, 0.25F, height - 0.001F, 0.75F, 0.75F, height - 0.001F, 0.75F, 0.75F, height - 0.001F, 0.25F
               );
            }

            this.emitSides(emitter, material, blockView, pos, northEastHeight, southEastHeight, southWestHeight, northWestHeight);
         }

         Mesh mesh = meshBuilder.build();
         mesh.outputTo(context.getEmitter());
      }
   }

   private void emit(QuadEmitter emitter, RenderMaterial material, boolean topCovered, float height, float aX, float aY, float aZ, float bX, float bY, float bZ) {
      if (!topCovered || height != 1.0F || aY != 1.0F || bY != 1.0F) {
         this.emit(
            emitter,
            material,
            aX * 0.5F + 0.25F,
            Math.max(0.0F, height - 0.001F),
            aZ * 0.5F + 0.25F,
            aX,
            Math.max(0.0F, aY - 0.001F),
            aZ,
            bX,
            Math.max(0.0F, bY - 0.001F),
            bZ,
            bX * 0.5F + 0.25F,
            Math.max(0.0F, height - 0.001F),
            bZ * 0.5F + 0.25F
         );
      }
   }

   private void emitFace(
      QuadEmitter emitter,
      RenderMaterial material,
      class_2350 nominalFace,
      float aX,
      float aY,
      float aZ,
      float bX,
      float bY,
      float bZ,
      float cX,
      float cY,
      float cZ,
      float dX,
      float dY,
      float dZ
   ) {
      emitter.nominalFace(nominalFace);
      emitter.pos(0, aX, aY, aZ);
      emitter.pos(1, bX, bY, bZ);
      emitter.pos(2, cX, cY, cZ);
      emitter.pos(3, dX, dY, dZ);
      emitter.material(material);
      emitter.spriteBake(this.sprite, 4);
      emitter.color(-1, -1, -1, -1);
      emitter.emit();
   }

   private void emitSide(
      QuadEmitter emitter,
      RenderMaterial material,
      class_1920 blockView,
      class_2338 pos,
      class_2350 direction,
      float aX,
      float aHeight,
      float aZ,
      float bX,
      float bHeight,
      float bZ
   ) {
      if ((aHeight != 0.0F || bHeight != 0.0F) && !this.sideCulled(blockView, pos, direction)) {
         this.emitFace(emitter, material, direction, aX, 0.0F, aZ, aX, aHeight, aZ, bX, bHeight, bZ, bX, 0.0F, bZ);
         this.emitFace(emitter, material, direction.method_10153(), aX, 0.0F, aZ, bX, 0.0F, bZ, bX, bHeight, bZ, aX, aHeight, aZ);
      }
   }

   private void emitSides(
      QuadEmitter emitter,
      RenderMaterial material,
      class_1920 blockView,
      class_2338 pos,
      float northEastHeight,
      float southEastHeight,
      float southWestHeight,
      float northWestHeight
   ) {
      if (!this.sideCulled(blockView, pos, class_2350.field_11033)) {
         this.emitFace(emitter, material, class_2350.field_11033, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F);
         this.emitFace(emitter, material, class_2350.field_11033, 0.0F, 0.001F, 0.0F, 0.0F, 0.001F, 1.0F, 1.0F, 0.001F, 1.0F, 1.0F, 0.001F, 0.0F);
      }

      this.emitSide(emitter, material, blockView, pos, class_2350.field_11043, 0.0F, northWestHeight, 0.001F, 1.0F, northEastHeight, 0.001F);
      this.emitSide(emitter, material, blockView, pos, class_2350.field_11034, 0.999F, northEastHeight, 0.0F, 0.999F, southEastHeight, 1.0F);
      this.emitSide(emitter, material, blockView, pos, class_2350.field_11035, 1.0F, southEastHeight, 0.999F, 0.0F, southWestHeight, 0.999F);
      this.emitSide(emitter, material, blockView, pos, class_2350.field_11039, 0.001F, southWestHeight, 1.0F, 0.001F, northWestHeight, 0.0F);
   }

   private void emit(
      QuadEmitter emitter,
      RenderMaterial material,
      float aX,
      float aY,
      float aZ,
      float bX,
      float bY,
      float bZ,
      float cX,
      float cY,
      float cZ,
      float dX,
      float dY,
      float dZ
   ) {
      this.emitFace(emitter, material, class_2350.field_11036, aX, aY, aZ, bX, bY, bZ, cX, cY, cZ, dX, dY, dZ);
      this.emitFace(emitter, material, class_2350.field_11033, aX, aY, aZ, dX, dY, dZ, cX, cY, cZ, bX, bY, bZ);
   }

   private int getLevel(class_1920 blockView, class_2338 pos, class_2350 direction) {
      class_2338 blockPos = pos.method_10093(direction);
      class_2680 state = blockView.method_8320(blockPos);
      if (this.isLiquid(state)) {
         return (Integer)state.method_11654(LiquidBlock.LEVEL);
      } else {
         return this.sideCovered(blockView, blockPos, state, direction) ? -1 : 0;
      }
   }

   private int getLevel(class_1920 blockView, int level, int sideA, int sideB, boolean topCovered, class_2338 pos, class_2350 directionA, class_2350 directionB) {
      class_2338 cornerPos = pos.method_10093(directionA).method_10093(directionB);
      class_2338 sideAPos = pos.method_10093(directionA);
      class_2338 sideBPos = pos.method_10093(directionB);
      if (topCovered
         || sideA == -1 && sideB == -1
         || !this.isLiquid(blockView.method_8320(cornerPos.method_10084()))
            && !this.isLiquid(blockView.method_8320(sideAPos.method_10084()))
            && !this.isLiquid(blockView.method_8320(sideBPos.method_10084()))) {
         if (sideA == 0 || sideB == 0) {
            return 0;
         }

         if (sideA == -1 && sideB == -1) {
            return level;
         }

         if (sideA == -1) {
            class_2680 sideAState = blockView.method_8320(sideAPos);
            if (!this.sideCovered(blockView, sideAPos, sideAState, directionB.method_10153())) {
               return 0;
            }
         }

         if (sideB == -1) {
            class_2680 sideBState = blockView.method_8320(sideBPos);
            if (!this.sideCovered(blockView, sideBPos, sideBState, directionA.method_10153())) {
               return 0;
            }
         }

         int sideLevel = Math.max(sideA, sideB);
         class_2680 cornerState = blockView.method_8320(cornerPos);
         if ((sideA == -1 || sideB == -1) && this.isLiquid(cornerState)) {
            return Math.min((Integer)cornerState.method_11654(LiquidBlock.LEVEL), sideLevel);
         } else if (this.isLiquid(cornerState)) {
            int cornerLevel = (Integer)cornerState.method_11654(LiquidBlock.LEVEL);
            return Math.min(Math.max(cornerLevel, level), sideLevel);
         } else {
            return this.sidesCovered(blockView, cornerPos, cornerState, directionA, directionB) ? Math.min(level, sideLevel) : 0;
         }
      } else {
         return 64;
      }
   }

   private boolean sidesCovered(class_1920 blockView, class_2338 pos, class_2680 state, class_2350... directions) {
      class_265 sidesShape = state.method_26222(blockView, pos);
      class_265 collisionShape = state.method_26220(blockView, pos);

      for (class_2350 direction : directions) {
         if (!class_2248.method_9501(sidesShape, direction.method_10153()) && !class_2248.method_9501(collisionShape, direction.method_10153())) {
            return false;
         }
      }

      return true;
   }

   private boolean sideCovered(class_1920 blockView, class_2338 pos, class_2680 state, class_2350 direction) {
      return class_2248.method_9501(state.method_26222(blockView, pos), direction.method_10153())
         || class_2248.method_9501(state.method_26220(blockView, pos), direction.method_10153());
   }

   private boolean sideCulled(class_1920 blockView, class_2338 pos, class_2680 state, class_2350 direction) {
      return this.isLiquid(state) || state.method_26225() && this.sideCovered(blockView, pos, state, direction);
   }

   private boolean sideCulled(class_1920 blockView, class_2338 pos, class_2350 direction) {
      class_2338 blockPos = pos.method_10093(direction);
      return this.sideCulled(blockView, blockPos, blockView.method_8320(blockPos), direction);
   }

   private boolean isLiquid(class_2680 state) {
      return state.method_28498(LiquidBlock.LEVEL);
   }

   public List<class_777> method_4707(@Nullable class_2680 state, @Nullable class_2350 face, class_5819 random) {
      return List.of();
   }

   public boolean isVanillaAdapter() {
      return false;
   }

   public boolean method_4708() {
      return true;
   }

   public boolean method_4712() {
      return false;
   }

   public boolean method_24304() {
      return false;
   }

   public boolean method_4713() {
      return false;
   }

   public class_1058 method_4711() {
      return this.sprite;
   }

   public class_809 method_4709() {
      return null;
   }

   public class_806 method_4710() {
      return null;
   }

   public Collection<class_2960> method_4755() {
      return List.of();
   }

   public void method_45785(Function<class_2960, class_1100> modelLoader) {
   }

   @Nullable
   public class_1087 method_4753(class_7775 baker, Function<class_4730, class_1058> textureGetter, class_3665 rotationContainer, class_2960 modelId) {
      this.sprite = textureGetter.apply(this.spriteId);
      return this;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
