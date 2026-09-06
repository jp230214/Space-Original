package doctor4t.spacemod.index.world;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.world.structure.IchorShaftStructurePiece;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3773;
import net.minecraft.class_7923;
import net.minecraft.class_3773.class_6615;
import net.minecraft.class_3773.class_6616;

public class SpaceModStructurePieceTypes {
   public static final Map<class_3773, class_2960> STRUCTURE_PIECE_TYPES = new LinkedHashMap<>();
   public static final class_3773 ICHOR_SHAFT = create("ichor_shaft", IchorShaftStructurePiece::new);

   public static void initialize() {
      STRUCTURE_PIECE_TYPES.forEach((structurePieceType, id) -> class_2378.method_10230(class_7923.field_41146, id, structurePieceType));
   }

   protected static class_3773 create(String name, class_6615 structurePieceType) {
      STRUCTURE_PIECE_TYPES.put(structurePieceType, SpaceMod.id(name));
      return structurePieceType;
   }

   protected static class_3773 create(String name, class_6616 structurePieceType) {
      STRUCTURE_PIECE_TYPES.put(structurePieceType, SpaceMod.id(name));
      return structurePieceType;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
