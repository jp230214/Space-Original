package doctor4t.spacemod.particle;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3999;
import net.minecraft.class_4002;
import net.minecraft.class_4003;
import net.minecraft.class_4184;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;
import net.minecraft.class_7833;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class FlowParticle extends class_4003 {
   private final class_2350 direction;
   private final class_243 startPos;
   private final class_243 endPos;

   protected FlowParticle(class_638 clientWorld, class_2350 direction, class_2338 destination, double x, double y, double z) {
      super(clientWorld, x, y, z);
      this.direction = direction;
      this.startPos = new class_243(this.field_3874, this.field_3854, this.field_3871);
      this.endPos = class_243.method_24953(destination);
      this.method_34753(0.0, 0.0, 0.0);
      this.field_3862 = false;
      this.field_17867 = 0.5F;
      this.field_3847 = (int)(4.0F / SpaceModDimensions.getGravityScale(clientWorld))
         * (int)Math.sqrt(Math.abs(this.startPos.method_10214() - this.endPos.method_10214()));
   }

   public void method_3070() {
      this.field_3858 = this.field_3874;
      this.field_3838 = this.field_3854;
      this.field_3856 = this.field_3871;
      if (this.field_3866++ >= this.field_3847) {
         this.method_3085();
      }

      float delta = class_3532.method_27285((float)this.field_3866 / this.field_3847);
      this.field_3874 = class_3532.method_16436(delta, this.startPos.method_10216(), this.endPos.method_10216());
      this.field_3854 = class_3532.method_16436(delta, this.startPos.method_10214(), this.endPos.method_10214());
      this.field_3871 = class_3532.method_16436(delta, this.startPos.method_10215(), this.endPos.method_10215());
   }

   public void method_3074(class_4588 vertexConsumer, class_4184 camera, float tickDelta) {
      class_243 cameraPos = camera.method_19326();
      float offsetX = this.direction.method_10148() * 0.48F;
      float offsetZ = this.direction.method_10165() * 0.48F;
      float x = (float)(class_3532.method_16436(tickDelta, this.field_3858, this.field_3874) - cameraPos.method_10216()) - offsetX;
      float y = (float)(class_3532.method_16436(tickDelta, this.field_3838, this.field_3854) - cameraPos.method_10214());
      float z = (float)(class_3532.method_16436(tickDelta, this.field_3856, this.field_3871) - cameraPos.method_10215()) - offsetZ;
      float yaw = this.direction.method_10166().method_10178() ? -camera.method_19330() : this.direction.method_10144();
      Quaternionf quaternion = class_7833.field_40716.rotationDegrees(yaw).mul(class_7833.field_40714.rotationDegrees(-1.0F));
      Quaternionf flip = class_7833.field_40716.rotationDegrees(yaw + 180.0F).mul(class_7833.field_40714.rotationDegrees(-1.0F));
      float size = this.method_18132(tickDelta);
      float sizeY = size - 0.25F + (this.field_3866 + tickDelta) * 0.05F;
      float minU = this.method_18133();
      float maxU = this.method_18134();
      float minV = this.method_18135();
      float maxV = this.method_18136();
      int light = this.method_3068(tickDelta);
      this.renderFace(vertexConsumer, quaternion, x, y, z, size, sizeY, size, minU, maxU, minV, maxV, light);
      this.renderFace(vertexConsumer, flip, x, y, z, size, sizeY, size, minU, maxU, minV, maxV, light);
   }

   private void renderFace(
      class_4588 vertexConsumer,
      Quaternionf quaternion,
      float x,
      float y,
      float z,
      float sizeX,
      float sizeY,
      float sizeZ,
      float minU,
      float maxU,
      float minV,
      float maxV,
      int light
   ) {
      Vector3f[] vec3fs = new Vector3f[]{
         new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)
      };

      for (int k = 0; k < 4; k++) {
         Vector3f vec3f2 = vec3fs[k];
         vec3f2.add(0.0F, -1.0F, 0.0F);
         vec3f2.rotate(quaternion);
         vec3f2.mul(sizeX, sizeY, sizeZ);
         vec3f2.add(x, y, z);
      }

      vertexConsumer.method_22912(vec3fs[0].x, vec3fs[0].y, vec3fs[0].z)
         .method_22913(maxU, maxV)
         .method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841)
         .method_22916(light)
         .method_1344();
      vertexConsumer.method_22912(vec3fs[1].x, vec3fs[1].y, vec3fs[1].z)
         .method_22913(maxU, minV)
         .method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841)
         .method_22916(light)
         .method_1344();
      vertexConsumer.method_22912(vec3fs[2].x, vec3fs[2].y, vec3fs[2].z)
         .method_22913(minU, minV)
         .method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841)
         .method_22916(light)
         .method_1344();
      vertexConsumer.method_22912(vec3fs[3].x, vec3fs[3].y, vec3fs[3].z)
         .method_22913(minU, maxV)
         .method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841)
         .method_22916(light)
         .method_1344();
   }

   public class_3999 method_18122() {
      return class_3999.field_17829;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }

   @Environment(EnvType.CLIENT)
   public static class Factory implements class_707<FlowParticleEffect> {
      private final class_4002 spriteProvider;

      public Factory(class_4002 spriteProvider) {
         this.spriteProvider = spriteProvider;
      }

      @Nullable
      public class_703 createParticle(
         FlowParticleEffect parameters, class_638 world, double x, double y, double z, double velocityX, double velocityY, double velocityZ
      ) {
         FlowParticle particle = new FlowParticle(world, parameters.direction(), parameters.destination(), x, y, z);
         particle.method_18140(this.spriteProvider);
         return particle;
      }

      static {
         SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
      }
   }
}
