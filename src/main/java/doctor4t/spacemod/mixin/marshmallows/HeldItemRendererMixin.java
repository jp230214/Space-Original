package doctor4t.spacemod.mixin.marshmallows;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.item.MarshmallowStickItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_759;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_759.class)
public abstract class HeldItemRendererMixin {
   @Unique
   private int roastTicks;

   @Inject(method = "updateHeldItems", at = @At("HEAD"))
   private void spacemod$roasting(CallbackInfo ci) {
      class_746 player = class_310.method_1551().field_1724;
      if (player != null) {
         class_1799 stack = player.method_6047();
         if (stack.method_7909() instanceof MarshmallowStickItem) {
            if (player.spacemod$isHoldingAttack()) {
               this.roastTicks++;
            } else {
               this.roastTicks = 0;
            }
         }
      }
   }

   @WrapOperation(
      method = "renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderFirstPersonItem(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/util/Hand;FLnet/minecraft/item/ItemStack;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"
      )
   )
   private void spacemod$marshmallowProgress(
      class_759 instance,
      @NotNull class_742 player,
      float tickDelta,
      float pitch,
      class_1268 hand,
      float swingProgress,
      @NotNull class_1799 item,
      float equipProgress,
      class_4587 matrices,
      class_4597 vertexConsumers,
      int light,
      @NotNull Operation<Void> original
   ) {
      boolean marsh = item.method_7909() instanceof MarshmallowStickItem;
      boolean holding = player.spacemod$isHoldingAttack();
      boolean both = marsh && holding;
      original.call(
         new Object[]{
            instance,
            player,
            tickDelta,
            pitch,
            hand,
            both ? this.spacemod$swingRoasting(tickDelta) : swingProgress,
            item,
            marsh ? (holding ? this.spacemod$equipRoasting(tickDelta) : 0.0F) : equipProgress,
            matrices,
            vertexConsumers,
            light
         }
      );
   }

   @Unique
   private float spacemod$swingRoasting(float tickDelta) {
      float delta = this.doubleDelta(class_3532.method_15363(this.roastTicks / 6.0F, 0.0F, 1.0F));
      float prevDelta = this.doubleDelta(class_3532.method_15363((this.roastTicks - 1) / 6.0F, 0.0F, 1.0F));
      float current = 1.0F - delta * 0.06F;
      float prev = 1.0F - prevDelta * 0.06F;
      return 1.0F - (prev + tickDelta * (current - prev));
   }

   @Unique
   private float spacemod$equipRoasting(float tickDelta) {
      float delta3 = this.doubleDelta(class_3532.method_15363(this.roastTicks / 3.0F, 0.0F, 1.0F));
      float delta6 = this.doubleDelta(class_3532.method_15363(this.roastTicks / 6.0F, 0.0F, 1.0F));
      float prevDelta3 = this.doubleDelta(class_3532.method_15363((this.roastTicks - 1) / 3.0F, 0.0F, 1.0F));
      float prevDelta6 = this.doubleDelta(class_3532.method_15363((this.roastTicks - 1) / 6.0F, 0.0F, 1.0F));
      float current = delta3 * 0.1F + delta6 * 0.2F;
      float prev = prevDelta3 * 0.1F + prevDelta6 * 0.2F;
      return 0.5F - (prev + tickDelta * (current - prev));
   }

   @Unique
   private float doubleDelta(float delta) {
      return delta * delta * delta * delta;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
