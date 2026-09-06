package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1309;
import net.minecraft.class_1921;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_583;
import net.minecraft.class_742;
import net.minecraft.class_922;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_922.class)
public abstract class LivingEntityRendererMixin<T extends class_1309, M extends class_583<T>> {
   @Shadow
   public abstract M method_4038();

   @Shadow
   protected abstract boolean method_4056(T var1);

   @Shadow
   @Nullable
   protected abstract class_1921 method_24302(T var1, boolean var2, boolean var3, boolean var4);

   @WrapWithCondition(
      method = "render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
      )
   )
   private boolean spacemod$overrideModelRender(
      M model,
      class_4587 matrices,
      class_4588 vertices,
      int light,
      int overlay,
      float red,
      float green,
      float blue,
      float alpha,
      T entity,
      float yaw,
      float tickDelta,
      class_4587 matrixStack,
      class_4597 vertexConsumerProvider,
      int light2
   ) {
      return entity.method_31747() && entity instanceof class_742 player
         ? this.spacemod$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider)
         : this.spacemod$overrideModelRender(null, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
   }

   @Unique
   protected boolean spacemod$overrideModelRender(
      @Nullable class_742 player,
      class_4587 matrices,
      int light,
      int overlay,
      float red,
      float green,
      float blue,
      float alpha,
      float yaw,
      float tickDelta,
      class_4587 matrixStack,
      class_4597 vertexConsumerProvider
   ) {
      return true;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
