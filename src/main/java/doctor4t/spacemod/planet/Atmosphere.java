package doctor4t.spacemod.planet;

import dev.upcraft.sdrm.api.SDRMVerifier;

public class Atmosphere {
   private float size;
   private float falloff;
   private float density;
   private float redScatter;
   private float greenScatter;
   private float blueScatter;
   private float brightnessMultiplier;
   private float densityMultiplier;

   public Atmosphere(
      float size, float falloff, float density, float redScatter, float greenScatter, float blueScatter, float brightnessMultiplier, float densityMultiplier
   ) {
      this.size = size;
      this.falloff = falloff;
      this.density = density;
      this.redScatter = redScatter;
      this.greenScatter = greenScatter;
      this.blueScatter = blueScatter;
      this.brightnessMultiplier = brightnessMultiplier;
      this.densityMultiplier = densityMultiplier;
   }

   public float getSize() {
      return this.size;
   }

   public void setSize(float size) {
      this.size = size;
   }

   public float getFalloff() {
      return this.falloff;
   }

   public void setFalloff(float falloff) {
      this.falloff = falloff;
   }

   public float getDensity() {
      return this.density;
   }

   public void setDensity(float density) {
      this.density = density;
   }

   public float getRedScatter() {
      return this.redScatter;
   }

   public void setRedScatter(float redScatter) {
      this.redScatter = redScatter;
   }

   public float getGreenScatter() {
      return this.greenScatter;
   }

   public void setGreenScatter(float greenScatter) {
      this.greenScatter = greenScatter;
   }

   public float getBlueScatter() {
      return this.blueScatter;
   }

   public void setBlueScatter(float blueScatter) {
      this.blueScatter = blueScatter;
   }

   public float getBrightnessMultiplier() {
      return this.brightnessMultiplier;
   }

   public void setBrightnessMultiplier(float brightnessMultiplier) {
      this.brightnessMultiplier = brightnessMultiplier;
   }

   public float getDensityMultiplier() {
      return this.densityMultiplier;
   }

   public void setDensityMultiplier(float densityMultiplier) {
      this.densityMultiplier = densityMultiplier;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
