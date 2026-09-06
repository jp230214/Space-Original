package doctor4t.spacemod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_744;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_1309.class)
public abstract class ClimbLaddersFasterLivingEntityMixin extends class_1297 {
   public ClimbLaddersFasterLivingEntityMixin(class_1299<?> type, class_1937 world) {
      super(type, world);
   }

   @ModifyExpressionValue(method = "applyClimbingSpeed", at = @At(value = "NEW", target = "(DDD)Lnet/minecraft/util/math/Vec3d;"))
   private class_243 spacemod$fasterClimbing(class_243 original) {
      if (class_310.method_1551().field_1724 == null) {
         return original;
      }

      class_744 input = class_310.method_1551().field_1724.field_3913;
      boolean moving = input.field_3910 || input.field_3909 || input.field_3908 || input.field_3906 || input.field_3904;
      int sprintBonus = class_310.method_1551().field_1690.field_1867.method_1434() ? 3 : 1;
      return new class_243(original.field_1352, class_3532.method_15350(original.field_1351 * sprintBonus, -1.0, moving ? 1.0 : 0.0), original.field_1350);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
