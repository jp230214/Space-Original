package doctor4t.spacemod.world.structure;

import com.mojang.serialization.Codec;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.index.world.SpaceModStructureTypes;
import java.util.Optional;
import net.minecraft.class_2338;
import net.minecraft.class_3195;
import net.minecraft.class_3485;
import net.minecraft.class_6626;
import net.minecraft.class_7151;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_3195.class_7149;
import net.minecraft.class_3195.class_7150;
import net.minecraft.class_3195.class_7302;

public class IchorShaftStructure extends class_3195 {
   public static final Codec<IchorShaftStructure> CODEC = method_42699(IchorShaftStructure::new);
   protected static final int TOP_HEIGHT = 15;
   protected static final int TOP_WIDTH = 27;
   protected static final int SHAFT_HEIGHT = 11;
   protected static final int SHAFT_WIDTH = 15;
   protected static final int BOTTOM_HEIGHT = 14;
   protected static final int BOTTOM_WIDTH = 17;

   public IchorShaftStructure(class_7302 config) {
      super(config);
   }

   protected Optional<class_7150> method_38676(class_7149 context) {
      return Optional.of(new class_7150(this.getStartPos(context), collector -> this.addPieces(collector, context)));
   }

   private void addPieces(class_6626 collector, class_7149 context) {
      class_3485 manager = context.comp_565();
      class_2339 mutable = this.getStartPos(context).method_25503();
      this.addPiece(collector, manager, "top", mutable, 27);

      while (this.canPlaceShaft(mutable.method_10264())) {
         mutable.method_10100(0, -11, 0);
         this.addPiece(collector, manager, "shaft", mutable, 15);
      }

      mutable.method_10100(0, -14, 0);
      this.addPiece(collector, manager, "bottom", mutable, 17);
   }

   private void addPiece(class_6626 collector, class_3485 manager, String name, class_2339 mutable, int width) {
      collector.method_35462(new IchorShaftStructurePiece(manager, name, mutable.method_10069(-width / 2, 0, -width / 2)));
   }

   private class_2338 getStartPos(class_7149 context) {
      return new class_2338(context.comp_568().method_33940(), context.comp_569().method_31600() - 15, context.comp_568().method_33942());
   }

   private boolean canPlaceShaft(int y) {
      return y >= 151;
   }

   public class_7151<?> method_41618() {
      return SpaceModStructureTypes.ICHOR_SHAFT;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
