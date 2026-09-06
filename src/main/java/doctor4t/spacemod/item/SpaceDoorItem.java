package doctor4t.spacemod.item;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1792;
import net.minecraft.class_1838;
import net.minecraft.class_243;
import net.minecraft.class_1792.class_1793;

public class SpaceDoorItem extends class_1792 {
   private final class_1299<?> entityType;

   public SpaceDoorItem(class_1299<?> entityType, class_1793 settings) {
      super(settings);
      this.entityType = entityType;
   }

   public class_1269 method_7884(class_1838 context) {
      if (!context.method_8045().field_9236) {
         class_1297 spaceDoorEntity = this.entityType.method_5883(context.method_8045());
         if (spaceDoorEntity == null) {
            return class_1269.field_5814;
         }

         class_243 vec3d = class_243.method_24955(context.method_8037().method_10093(context.method_8038()));
         spaceDoorEntity.method_5814(vec3d.field_1352, vec3d.field_1351, vec3d.field_1350);
         spaceDoorEntity.method_36456(context.method_8042().method_10144());
         spaceDoorEntity.method_36457(0.0F);
         context.method_8045().method_8649(spaceDoorEntity);
      }

      return class_1269.method_29236(context.method_8045().method_8608());
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
