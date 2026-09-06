package doctor4t.spacemod.animation;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_7179;
import net.minecraft.class_7184;
import net.minecraft.class_7186;
import net.minecraft.class_7187;
import net.minecraft.class_7179.class_7183;
import net.minecraft.class_7184.class_7185;

@Environment(EnvType.CLIENT)
public class SmallDoorEntityAnimations {
   public static final class_7184 OPEN = class_7185.method_41818(1.0F)
      .method_41820(
         "Door",
         new class_7179(
            class_7183.field_37886,
            new class_7186[]{
               new class_7186(0.1F, class_7187.method_41823(0.0F, 0.0F, 0.0F), Interpolations.EASE_OUT_EXPO),
               new class_7186(0.7F, class_7187.method_41823(14.0F, 0.0F, 0.0F), Interpolations.EASE_OUT_EXPO)
            }
         )
      )
      .method_41821();
   public static final class_7184 CLOSE = class_7185.method_41818(1.0F)
      .method_41820(
         "Door",
         new class_7179(
            class_7183.field_37886,
            new class_7186[]{
               new class_7186(0.1F, class_7187.method_41823(14.0F, 0.0F, 0.0F), Interpolations.EASE_OUT_EXPO),
               new class_7186(0.7F, class_7187.method_41823(0.0F, 0.0F, 0.0F), Interpolations.EASE_OUT_EXPO)
            }
         )
      )
      .method_41821();

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
