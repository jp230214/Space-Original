package doctor4t.spacemod.renderer.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.SpaceModClient;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.mixin.InGameHudAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_746;

@Environment(EnvType.CLIENT)
public class SpaceSuitBarsRenderer implements HudRenderCallback {
   public static final int BAR_LENGTH = 83;
   public static final int VITALS_LENGTH = 29;
   private static final int MARGIN = 18;
   public static final int WARNING_THRESHOLD = 18;
   public static final int CRITICAL_THRESHOLD = 10;
   private static final class_2960 TEXTURE = SpaceMod.id("textures/gui/bars.png");
   private static final class_2960 HEALTH_TEXTURE = SpaceMod.id("textures/gui/health.png");

   public void onHudRender(class_332 drawContext, float tickDelta) {
      class_746 player = class_310.method_1551().field_1724;
      if (player != null) {
         PlayerSpaceComponent component = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
         boolean showFuel = component.isWearingJetpack();
         class_329 inGameHud = class_310.method_1551().field_1705;
         int scaledHeight = ((InGameHudAccessor)inGameHud).getScaledHeight();
         int scaledWidth = ((InGameHudAccessor)inGameHud).getScaledWidth();
         if (!player.method_7337() && !player.method_7325()) {
            this.drawHealth(drawContext, 0, scaledWidth / 2 - 14 + 110, scaledHeight - 18 - 5);
         }

         if (component.isWearingSpaceHelmet()) {
            this.drawBar(drawContext, 0, 38, scaledHeight - 18 - 80, component.getOxygenBarLength(83));
            if (showFuel) {
               this.drawBar(drawContext, 1, 18, scaledHeight - 18 - 90, component.getFuelBarLength(83));
            }
         }
      }
   }

   private void drawBar(class_332 drawContext, int offset, int x, int y, int length) {
      class_4587 stack = drawContext.method_51448();
      stack.method_22903();
      stack.method_46416(x, y, 0.0F);
      int o = offset * 32;
      class_746 player = class_310.method_1551().field_1724;
      boolean isLow = length <= 18;
      boolean isCritical = length <= 10;
      int iconOffset = isLow ? 12 : 0;
      int barVerticalOffset = isLow ? 96 : 0;
      stack.method_22903();
      stack.method_22904(-3.5, 75.0, 0.0);
      RenderSystem.enableBlend();
      drawContext.method_51422(1.0F, 1.0F, 1.0F, isLow ? (float)(Math.sin((float)SpaceModClient.time / (isCritical ? 2.0F : 5.0F)) + 1.0) / 2.0F : 0.5F);
      drawContext.method_25290(TEXTURE, 0, 0, o + 16, iconOffset, 16, 12, 96, 192);
      stack.method_22909();
      stack.method_46416(0.0F, -12.0F, 0.0F);
      drawContext.method_51422(1.0F, 1.0F, 1.0F, 0.5F);
      drawContext.method_25290(TEXTURE, 0, 0, isLow ? 96 : o, barVerticalOffset, 9, 83, 96, 192);
      stack.method_22904(0.0, 83 - length, 0.0);
      drawContext.method_51422(1.0F, 1.0F, 1.0F, isCritical ? (float)(Math.sin((float)SpaceModClient.time / 2.0F) + 1.0) / 2.0F : 1.0F);
      drawContext.method_25290(TEXTURE, 0, 0, isLow ? 104 : o + 8, 83 - length + barVerticalOffset, 7, length, 96, 192);
      drawContext.method_51422(1.0F, 1.0F, 1.0F, 1.0F);
      stack.method_22909();
   }

   private void drawHealth(class_332 drawContext, int offset, int x, int y) {
      class_4587 stack = drawContext.method_51448();
      stack.method_22903();
      stack.method_46416(x, y, 0.0F);
      class_746 player = class_310.method_1551().field_1724;
      if (player != null) {
         PlayerSpaceComponent playerSpaceComponent = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
         RenderSystem.enableBlend();
         int textureWidth = 32;
         int textureHeight = 96;
         int maxWidth = 32;
         int maxHeight = 23;
         int barWidth = 23;
         int progress = (int)(SpaceModClient.heartTime % maxWidth);
         drawContext.method_51422(1.0F, 1.0F, 1.0F, 1.0F);
         drawContext.method_25290(HEALTH_TEXTURE, 0, 0, 0.0F, 0.0F, maxWidth, maxHeight, textureWidth, textureHeight);
         if (playerSpaceComponent.getHealingTicks() > 0 && playerSpaceComponent.getMaxHealingTicks() > 0 && !class_310.method_1551().method_1493()) {
            int healingProgress = (int)((float)playerSpaceComponent.getHealingTicks() / playerSpaceComponent.getMaxHealingTicks() * maxWidth);
            drawContext.method_51422(1.0F, 1.0F, 1.0F, 1.0F);
            drawContext.method_25290(HEALTH_TEXTURE, 0, 0, 0.0F, maxHeight * 3, healingProgress, maxHeight, textureWidth, textureHeight);
         }

         float translucency = 0.1F + (player.method_6063() - player.method_6032()) / player.method_6063();
         float minRed = 0.2F;
         float red = minRed + (player.method_6063() - player.method_6032()) / player.method_6063();
         float green = player.method_6032() / player.method_6063() - minRed;
         drawContext.method_51422(red, green, 0.0F, 0.5F);
         drawContext.method_25290(HEALTH_TEXTURE, 0, 0, 0.0F, maxHeight, maxWidth, maxHeight, textureWidth, textureHeight);

         for (int i = 0; i <= barWidth; i++) {
            int prog = progress + i + 1;
            drawContext.method_51422(red, green, 0.0F, (float)i / barWidth * translucency);
            drawContext.method_25290(
               HEALTH_TEXTURE, prog - (progress + i >= maxWidth ? maxWidth : 0), 0, prog, maxHeight * 2, 1, maxHeight, textureWidth, textureHeight
            );
         }

         drawContext.method_51422(1.0F, 1.0F, 1.0F, 1.0F);
         stack.method_22909();
      }
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
