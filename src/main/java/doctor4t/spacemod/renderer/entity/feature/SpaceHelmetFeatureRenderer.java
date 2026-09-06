package doctor4t.spacemod.renderer.entity.feature;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block_entity.SpaceHelmetBlockEntity;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.model.entity.SpaceHelmetModel;
import doctor4t.spacemod.renderer.block_entity.SpaceHelmetBlockEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1304;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_591;
import net.minecraft.class_742;
import net.minecraft.class_5617.class_5618;

@Environment(EnvType.CLIENT)
public class SpaceHelmetFeatureRenderer extends class_3887<class_742, class_591<class_742>> {
   public SpaceHelmetFeatureRenderer(class_3883<class_742, class_591<class_742>> featureRendererContext, class_5618 loader) {
      super(featureRendererContext);
   }

   public static boolean shouldRender(class_742 entity) {
      return entity.method_6118(class_1304.field_6169).method_31574(SpaceModBlocks.SPACE_HELMET.method_8389());
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
         PlayerSpaceComponent.Type type = SpaceHelmetBlockEntity.getSpaceSuitType(entity.method_6118(class_1304.field_6169));
         SpaceHelmetModel model = SpaceHelmetBlockEntityRenderer.MODELS.get(type);
         class_2960 texture = type.texture;
         ((class_591)this.method_17165()).field_3398.field_3665 = false;
         model.helmet.field_3657 = ((class_591)this.method_17165()).field_3398.field_3657;
         model.helmet.field_3656 = ((class_591)this.method_17165()).field_3398.field_3656;
         model.helmet.field_3654 = ((class_591)this.method_17165()).field_3398.field_3654;
         model.helmet.field_3675 = ((class_591)this.method_17165()).field_3398.field_3675;
         model.body.field_3657 = ((class_591)this.method_17165()).field_3391.field_3657;
         model.body.field_3656 = ((class_591)this.method_17165()).field_3391.field_3656;
         model.body.field_3654 = ((class_591)this.method_17165()).field_3391.field_3654;
         model.body.field_3675 = ((class_591)this.method_17165()).field_3391.field_3675;
         model.body.field_3665 = true;
         boolean isFlashlightOn = ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(entity)).isFlashlightOn();
         model.flashlighton.field_3665 = isFlashlightOn;
         model.flashlightoff.field_3665 = !isFlashlightOn;
         matrices.method_22903();
         float scale = 1.05F;
         matrices.method_22905(scale, scale, scale);
         model.method_2828(matrices, vertexConsumers.getBuffer(model.method_23500(texture)), light, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
         matrices.method_22909();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
