package doctor4t.spacemod.mixin.marshmallows;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.item.MarshmallowStickItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.class_2540;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_310.class)
public class SendHoldMarshmallowPacketMinecraftClientMixin {
   @Shadow
   @Final
   public class_315 field_1690;
   @Shadow
   @Nullable
   public class_746 field_1724;
   @Unique
   private boolean spacemod$holding = false;

   @WrapOperation(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;handleBlockBreaking(Z)V"))
   private void spacemod$holding(class_310 instance, boolean bl, Operation<Void> original) {
      boolean holding = this.field_1690.field_1886.method_1434();
      if (holding != this.spacemod$holding) {
         this.spacemod$holding = holding;
         class_2540 buf = PacketByteBufs.create();
         buf.writeBoolean(holding);
         ClientPlayNetworking.send(SpaceMod.SERVERBOUND_HOLD_MARSHMALLOW_PACKET, buf);
      }

      if (this.field_1724 == null || !(this.field_1724.method_6047().method_7909() instanceof MarshmallowStickItem)) {
         original.call(new Object[]{instance, bl});
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
