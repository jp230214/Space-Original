package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import net.minecraft.class_3195;
import net.minecraft.class_5321;
import net.minecraft.class_6872;
import net.minecraft.class_6873;
import net.minecraft.class_7059;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class SpaceModStructureSets {
   public static class_5321<class_7059> ICHOR_SHAFT = create("ichor_shaft");

   public static void bootstrap(class_7891<class_7059> registerable) {
      class_7871<class_3195> structureLookup = registerable.method_46799(class_7924.field_41246);
      registerable.method_46838(
         ICHOR_SHAFT, new class_7059(structureLookup.method_46747(SpaceModStructures.ICHOR_SHAFT), new class_6872(50, 35, class_6873.field_36421, 1703521845))
      );
   }

   public static class_5321<class_7059> create(String name) {
      return class_5321.method_29179(class_7924.field_41248, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
