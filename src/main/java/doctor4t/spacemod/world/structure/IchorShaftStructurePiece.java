package doctor4t.spacemod.world.structure;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.index.world.SpaceModStructurePieceTypes;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2470;
import net.minecraft.class_2487;
import net.minecraft.class_2794;
import net.minecraft.class_2960;
import net.minecraft.class_3341;
import net.minecraft.class_3470;
import net.minecraft.class_3485;
import net.minecraft.class_3492;
import net.minecraft.class_5138;
import net.minecraft.class_5281;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import net.minecraft.class_6625;

public class IchorShaftStructurePiece extends class_3470 {
   public IchorShaftStructurePiece(class_3485 manager, String template, class_2338 pos) {
      super(SpaceModStructurePieceTypes.ICHOR_SHAFT, 0, manager, getId(template), template, createPlacementData(), pos);
   }

   public IchorShaftStructurePiece(class_3485 manager, class_2487 nbt) {
      super(SpaceModStructurePieceTypes.ICHOR_SHAFT, nbt, manager, id -> createPlacementData());
   }

   private static class_2960 getId(String template) {
      return SpaceMod.id("ichor_shaft/" + template);
   }

   private static class_3492 createPlacementData() {
      return new class_3492().method_15133(true).method_15123(class_2470.field_11467);
   }

   public void method_14931(
      class_5281 world, class_5138 structureAccessor, class_2794 chunkGenerator, class_5819 random, class_3341 chunkBox, class_1923 chunkPos, class_2338 pivot
   ) {
      super.method_14931(world, structureAccessor, chunkGenerator, random, chunkBox, chunkPos, pivot);
   }

   protected class_2960 method_35470() {
      return getId(this.field_31664);
   }

   protected void method_14943(class_6625 context, class_2487 nbt) {
      super.method_14943(context, nbt);
   }

   protected void method_15026(String metadata, class_2338 pos, class_5425 world, class_5819 random, class_3341 boundingBox) {
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
