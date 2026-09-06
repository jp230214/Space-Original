package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.world.structure.IchorShaftStructure;
import java.util.Map;
import net.minecraft.class_1959;
import net.minecraft.class_3195;
import net.minecraft.class_5321;
import net.minecraft.class_5847;
import net.minecraft.class_6880;
import net.minecraft.class_6885;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_2893.class_2895;
import net.minecraft.class_3195.class_7302;

public class SpaceModStructures {
   public static class_5321<class_3195> ICHOR_SHAFT = create("ichor_shaft");

   public static void bootstrap(class_7891<class_3195> registerable) {
      class_7871<class_1959> biomeLookup = registerable.method_46799(class_7924.field_41236);
      registerable.method_46838(
         ICHOR_SHAFT,
         new IchorShaftStructure(
            new class_7302(
               class_6885.method_40246(new class_6880[]{biomeLookup.method_46747(SpaceModBiomes.JANUS)}),
               Map.of(),
               class_2895.field_13173,
               class_5847.field_28922
            )
         )
      );
   }

   public static class_5321<class_3195> create(String name) {
      return class_5321.method_29179(class_7924.field_41246, SpaceMod.id(name));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
