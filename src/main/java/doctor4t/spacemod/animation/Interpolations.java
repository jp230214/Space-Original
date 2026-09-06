package doctor4t.spacemod.animation;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_3532;
import net.minecraft.class_7179.class_7180;
import net.minecraft.class_7179.class_7181;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class Interpolations {
   public static final class_7180 LINEAR = class_7181.field_37884;
   public static final Interpolations.InterpolationCreator STEP = steps -> easing(step(steps));
   public static final class_7180 EASE_IN_QUADRATIC = easing(easeIn(Interpolations::quadratic));
   public static final class_7180 EASE_OUT_QUADRATIC = easing(easeOut(Interpolations::quadratic));
   public static final class_7180 EASE_IN_OUT_QUADRATIC = easing(easeInOut(Interpolations::quadratic));
   public static final class_7180 EASE_IN_CUBIC = easing(easeIn(Interpolations::cubic));
   public static final class_7180 EASE_OUT_CUBIC = easing(easeOut(Interpolations::cubic));
   public static final class_7180 EASE_IN_OUT_CUBIC = easing(easeInOut(Interpolations::cubic));
   public static final class_7180 EASE_IN_QUARTIC = easing(easeIn(pow(4.0F)));
   public static final class_7180 EASE_OUT_QUARTIC = easing(easeOut(pow(4.0F)));
   public static final class_7180 EASE_IN_OUT_QUARTIC = easing(easeInOut(pow(4.0F)));
   public static final class_7180 EASE_IN_QUINTIC = easing(easeIn(pow(5.0F)));
   public static final class_7180 EASE_OUT_QUINTIC = easing(easeOut(pow(5.0F)));
   public static final class_7180 EASE_IN_OUT_QUINTIC = easing(easeInOut(pow(5.0F)));
   public static final class_7180 EASE_IN_EXPO = easing(easeIn(Interpolations::exp));
   public static final class_7180 EASE_OUT_EXPO = easing(easeOut(Interpolations::exp));
   public static final class_7180 EASE_IN_OUT_EXPO = easing(easeInOut(Interpolations::exp));
   public static final class_7180 EASE_IN_CIRCLE = easing(easeIn(Interpolations::circle));
   public static final class_7180 EASE_OUT_CIRCLE = easing(easeOut(Interpolations::circle));
   public static final class_7180 EASE_IN_OUT_CIRCLE = easing(easeInOut(Interpolations::circle));
   public static final Interpolations.InterpolationCreator EASE_IN_BACK = overshoot -> easing(back(overshoot));
   public static final Interpolations.InterpolationCreator EASE_OUT_BACK = overshoot -> easing(back(overshoot));
   public static final Interpolations.InterpolationCreator EASE_IN_OUT_BACK = overshoot -> easing(back(overshoot));
   public static final Interpolations.InterpolationCreator EASE_IN_BOUNCE = bounciness -> easing(bounce(bounciness));
   public static final Interpolations.InterpolationCreator EASE_OUT_BOUNCE = bounciness -> easing(bounce(bounciness));
   public static final Interpolations.InterpolationCreator EASE_IN_OUT_BOUNCE = bounciness -> easing(bounce(bounciness));
   private static final float HALF_PI = (float) (Math.PI / 2);
   public static final class_7180 EASE_IN_SINE = easing(easeIn(Interpolations::sine));
   public static final class_7180 EASE_OUT_SINE = easing(easeOut(Interpolations::sine));
   public static final class_7180 EASE_IN_OUT_SINE = easing(easeInOut(Interpolations::sine));
   public static final Interpolations.InterpolationCreator EASE_IN_ELASTIC = bounciness -> easing(elastic(bounciness));
   public static final Interpolations.InterpolationCreator EASE_OUT_ELASTIC = bounciness -> easing(elastic(bounciness));
   public static final Interpolations.InterpolationCreator EASE_IN_OUT_ELASTIC = bounciness -> easing(elastic(bounciness));

   private static class_7180 easing(Float2FloatFunction easing) {
      return (output, delta, keyframes, currentFrame, targetFrame, strength) -> {
         Vector3f vector3f = keyframes[currentFrame].comp_601();
         Vector3f vector3f2 = keyframes[targetFrame].comp_601();
         float eased = delta <= 0.0F ? 0.0F : (delta >= 1.0F ? 1.0F : (Float)easing.apply(delta));
         output.set(
            class_3532.method_16439(eased, vector3f.x(), vector3f2.x()),
            class_3532.method_16439(eased, vector3f.y(), vector3f2.y()),
            class_3532.method_16439(eased, vector3f.z(), vector3f2.z())
         );
         return output;
      };
   }

   private static Float2FloatFunction easeIn(Float2FloatFunction easing) {
      return easing;
   }

   private static Float2FloatFunction easeOut(Float2FloatFunction easing) {
      return delta -> 1.0F - (Float)easing.apply(1.0F - delta);
   }

   private static Float2FloatFunction easeInOut(Float2FloatFunction easing) {
      return delta -> delta < 0.5 ? (Float)easing.apply(delta * 2.0F) * 0.5F : 1.0F - (Float)easing.apply((1.0F - delta) * 2.0F) * 0.5F;
   }

   private static float quadratic(float delta) {
      return delta * delta;
   }

   private static float cubic(float delta) {
      return delta * delta * delta;
   }

   private static float sine(float delta) {
      return 1.0F - (float)Math.cos(delta * (float) (Math.PI / 2));
   }

   private static float circle(float delta) {
      return 1.0F - (float)Math.sqrt(1.0F - delta * delta);
   }

   private static float exp(float delta) {
      return (float)Math.pow(2.0, 10.0F * (delta - 1.0F));
   }

   private static Float2FloatFunction elastic(float bounciness) {
      return delta -> (float)(1.0 - Math.pow(Math.cos(delta * (float) (Math.PI / 2)), 3.0) * Math.cos(delta * bounciness * Math.PI));
   }

   private static Float2FloatFunction bounce(float bounciness) {
      return delta -> (float)Math.min(
         Math.min(7.5625F * delta * delta, 30.25F * bounciness * Math.pow(delta - 0.54545456F, 2.0) + 1.0 - bounciness),
         Math.min(
            121.0F * bounciness * bounciness * Math.pow(delta - 0.8181818F, 2.0) + 1.0 - bounciness * bounciness,
            484.0F * bounciness * bounciness * bounciness * Math.pow(delta - 0.95454544F, 2.0) + 1.0 - bounciness * bounciness * bounciness
         )
      );
   }

   private static Float2FloatFunction back(float overshoot) {
      float n = overshoot * 1.70158F;
      return delta -> delta * delta * ((n + 1.0F) * delta - n);
   }

   private static Float2FloatFunction pow(float exponent) {
      return delta -> (float)Math.pow(delta, exponent);
   }

   private static Float2FloatFunction step(float steps) {
      float s = Math.max(1.0F, steps);
      return delta -> (float)(Math.floor(delta * s) / s);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }

   @Environment(EnvType.CLIENT)
   interface InterpolationCreator {
      class_7180 configure(float var1);
   }
}
