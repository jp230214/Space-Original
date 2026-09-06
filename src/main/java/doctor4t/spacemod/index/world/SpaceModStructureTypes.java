package doctor4t.spacemod.index.world;

import com.mojang.serialization.Codec;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.world.structure.IchorShaftStructure;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3195;
import net.minecraft.class_7151;
import net.minecraft.class_7923;

public class SpaceModStructureTypes {
   protected static final Map<class_7151<? extends class_3195>, class_2960> STRUCTURE_TYPES = new LinkedHashMap<>();
   public static final class_7151<IchorShaftStructure> ICHOR_SHAFT = create("ichor_shaft", IchorShaftStructure.CODEC);

   public static void initialize() {
      STRUCTURE_TYPES.forEach((structureType, id) -> class_2378.method_10230(class_7923.field_41147, id, structureType));
   }

   public static <T extends class_3195> class_7151<T> create(String name, Codec<T> codec) {
      class_7151<T> structureType = () -> codec;
      STRUCTURE_TYPES.put(structureType, SpaceMod.id(name));
      return structureType;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }
}
