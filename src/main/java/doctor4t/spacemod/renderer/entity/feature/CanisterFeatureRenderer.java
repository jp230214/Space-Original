package doctor4t.spacemod.renderer.entity.feature;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.CanisterBlock;
import doctor4t.spacemod.index.SpaceModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1087;
import net.minecraft.class_1304;
import net.minecraft.class_1921;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_4696;
import net.minecraft.class_591;
import net.minecraft.class_742;
import net.minecraft.class_776;
import net.minecraft.class_7833;
import net.minecraft.class_5617.class_5618;

@Environment(EnvType.CLIENT)
public class CanisterFeatureRenderer extends class_3887<class_742, class_591<class_742>> {
   private final class_776 blockRenderManager;

   public CanisterFeatureRenderer(class_3883<class_742, class_591<class_742>> featureRendererContext, class_5618 loader) {
      super(featureRendererContext);
      this.blockRenderManager = loader.method_43337();
   }

   public static boolean shouldRender(class_742 entity) {
      return entity.method_6118(class_1304.field_6174).method_31574(SpaceModBlocks.CANISTER.method_8389());
   }

   public void render(
      class_4587 matrices,
      class_4597 vertexConsumers,
      int light,
      class_742 entity,
      float limbAngle,
      float limbDistance,
      float tickDelta,
      float animationProgress,
      float headYaw,
      float headPitch
   ) {
      if (shouldRender(entity)) {
         matrices.method_22903();
         float scale = 1.0F;
         matrices.method_22905(scale, scale, scale);
         matrices.method_22907(class_7833.field_40714.rotationDegrees(180.0F));
         matrices.method_22904(-0.5, -1.0, -1.0);
         if (entity.method_18276()) {
            matrices.method_22904(0.0, 0.2, -0.3);
         }

         ((class_591)this.method_17165()).field_3391.method_22703(matrices);
         class_2487 nbt = entity.method_6118(class_1304.field_6174).method_7969();
         class_2680 ichorState = (class_2680)SpaceModBlocks.CANISTER
            .method_9564()
            .method_11657(CanisterBlock.LEVEL, nbt != null && nbt.method_10545("ichorState") ? nbt.method_10550("ichorState") : 0);
         class_1087 canisterModel = this.blockRenderManager.method_3349(ichorState);
         class_1921 renderLayer = class_4696.method_23679(ichorState);
         class_4588 vertexConsumer = vertexConsumers.getBuffer(renderLayer);
         this.blockRenderManager
            .method_3350()
            .method_3374(
               entity.method_37908(),
               canisterModel,
               ichorState,
               entity.method_24515(),
               matrices,
               vertexConsumer,
               false,
               entity.method_6051(),
               0L,
               class_4608.field_21444
            );
         matrices.method_22909();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
