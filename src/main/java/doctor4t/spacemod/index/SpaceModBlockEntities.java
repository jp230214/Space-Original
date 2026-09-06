package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.block.PumpBlockEntity;
import doctor4t.spacemod.block_entity.JetpackBlockEntity;
import doctor4t.spacemod.block_entity.OpenableContainerBlockEntity;
import doctor4t.spacemod.block_entity.SpaceHelmetBlockEntity;
import doctor4t.spacemod.block_entity.ThrusterBlockEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class SpaceModBlockEntities {
   protected static final Map<class_2591<?>, class_2960> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
   public static final class_2591<OpenableContainerBlockEntity> CABINET = create(
      "cabinet",
      FabricBlockEntityTypeBuilder.create(OpenableContainerBlockEntity.cabinetFactory(), new class_2248[0])
         .addBlocks(new class_2248[]{SpaceModBlocks.MAHOGANY_CABINET, SpaceModBlocks.BUBINGA_CABINET, SpaceModBlocks.EBONY_CABINET})
         .build()
   );
   public static final class_2591<OpenableContainerBlockEntity> CARGO_BOX = create(
      "cargo_box",
      FabricBlockEntityTypeBuilder.create(OpenableContainerBlockEntity.cargoBoxFactory(), new class_2248[0])
         .addBlocks(new class_2248[]{SpaceModBlocks.CARGO_BOX})
         .build()
   );
   public static final class_2591<SpaceHelmetBlockEntity> SPACE_HELMET = create(
      "space_helmet",
      FabricBlockEntityTypeBuilder.create(SpaceHelmetBlockEntity::new, new class_2248[0]).addBlocks(new class_2248[]{SpaceModBlocks.SPACE_HELMET}).build()
   );
   public static final class_2591<JetpackBlockEntity> JETPACK = create(
      "jetpack", FabricBlockEntityTypeBuilder.create(JetpackBlockEntity::new, new class_2248[0]).addBlocks(new class_2248[]{SpaceModBlocks.JETPACK}).build()
   );
   public static final class_2591<ThrusterBlockEntity> THRUSTER = create(
      "thruster", FabricBlockEntityTypeBuilder.create(ThrusterBlockEntity::new, new class_2248[0]).addBlocks(new class_2248[]{SpaceModBlocks.THRUSTER}).build()
   );
   public static final class_2591<PumpBlockEntity> PUMP = create(
      "pump", FabricBlockEntityTypeBuilder.create(PumpBlockEntity::new, new class_2248[0]).addBlocks(new class_2248[]{SpaceModBlocks.PUMP}).build()
   );

   protected static <T extends class_2586> class_2591<T> create(String name, class_2591<T> blockEntityType) {
      BLOCK_ENTITY_TYPES.put(blockEntityType, SpaceMod.id(name));
      return blockEntityType;
   }

   public static void initialize() {
      BLOCK_ENTITY_TYPES.forEach((blockEntityType, id) -> class_2378.method_10230(class_7923.field_41181, id, blockEntityType));
   }

   static {
      SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
   }
}
