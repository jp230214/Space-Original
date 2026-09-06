package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.renderer.entity.feature.CanisterFeatureRenderer;
import doctor4t.spacemod.renderer.entity.feature.JetpackFeatureRenderer;
import doctor4t.spacemod.renderer.entity.feature.SpaceHelmetFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1007;
import net.minecraft.class_591;
import net.minecraft.class_742;
import net.minecraft.class_922;
import net.minecraft.class_5617.class_5618;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_1007.class)
public abstract class PlayerEntityRendererMixin extends class_922<class_742, class_591<class_742>> {
   public PlayerEntityRendererMixin(class_5618 ctx, class_591<class_742> model, float shadowRadius) {
      super(ctx, model, shadowRadius);
   }

   @Inject(method = "<init>", at = @At("TAIL"))
   private void spacemod$appendFeatures(class_5618 ctx, boolean slim, CallbackInfo callbackInfo) {
      this.method_4046(new SpaceHelmetFeatureRenderer(this, ctx));
      this.method_4046(new JetpackFeatureRenderer(this, ctx));
      this.method_4046(new CanisterFeatureRenderer(this, ctx));
   }

   @Inject(method = "setModelPose", at = @At("TAIL"))
   private void spacemod$hidePlayerHeadWithHelmet(class_742 player, CallbackInfo ci) {
      boolean showHead = !SpaceHelmetFeatureRenderer.shouldRender(player);
      ((class_591)this.method_4038()).field_3398.field_3665 &= showHead;
      ((class_591)this.method_4038()).field_3394.field_3665 &= showHead;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
