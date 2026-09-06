package doctor4t.spacemod.mixin;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_765;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(class_765.class)
public class PitchBlackDarknessLightmapTextureManagerMixin {
   @Redirect(method = "update", at = @At(value = "INVOKE", target = "Lorg/joml/Vector3f;lerp(Lorg/joml/Vector3fc;F)Lorg/joml/Vector3f;", ordinal = 0))
   private Vector3f spacemod$fuckYourBlueAssHueMojang(Vector3f vec3_ff1, Vector3fc vec3_111, float f_035) {
      class_310 client = class_310.method_1551();
      class_638 world = client.field_1687;
      if (client.field_1724 != null && world != null && world.method_27983().equals(SpaceModDimensions.JANUS)) {
         float f = class_310.method_1551().field_1687.method_23783(1.0F);
         float absLight = Math.abs(SpaceModClient.lightmapScale);
         float l = (float)class_3532.method_16436(1.0 - Math.pow(0.01, absLight), 1.0, f);
         return new Vector3f(f, f, l).lerp(vec3_111, f_035);
      } else {
         return vec3_ff1.lerp(vec3_111, f_035);
      }
   }

   @Redirect(method = "update", at = @At(value = "INVOKE", target = "Lorg/joml/Vector3f;lerp(Lorg/joml/Vector3fc;F)Lorg/joml/Vector3f;", ordinal = 6))
   private Vector3f spacemod$trueDarknessAndSunLight(Vector3f vector3f2, Vector3fc other, float t) {
      class_310 client = class_310.method_1551();
      class_638 world = client.field_1687;
      return client.field_1724 != null && world != null && world.method_27983().equals(SpaceModDimensions.JANUS)
         ? vector3f2.lerp(new Vector3f(1.0F, 1.0F, 1.0F), SpaceModClient.lightmapScale)
         : vector3f2.lerp(other, t);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
