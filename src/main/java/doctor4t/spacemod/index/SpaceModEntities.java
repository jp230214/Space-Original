package doctor4t.spacemod.index;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.entity.AirlockEntity;
import doctor4t.spacemod.entity.BigDoorEntity;
import doctor4t.spacemod.entity.DrivingSeatEntity;
import doctor4t.spacemod.entity.PocketStarEntity;
import doctor4t.spacemod.entity.PumpEntity;
import doctor4t.spacemod.entity.SeatEntity;
import doctor4t.spacemod.entity.SmallDoorEntity;
import doctor4t.spacemod.entity.SprinklerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_2378;
import net.minecraft.class_4048;
import net.minecraft.class_7923;

public class SpaceModEntities {
   public static class_1299<DrivingSeatEntity> DRIVING_SEAT;
   public static class_1299<BigDoorEntity> BIG_DOOR;
   public static class_1299<AirlockEntity> AIRLOCK;
   public static class_1299<SmallDoorEntity> SMALL_GLASS_DOOR;
   public static class_1299<SmallDoorEntity> SMALL_WOOD_DOOR;
   public static class_1299<SprinklerEntity> SPRINKLER;
   public static class_1299<SeatEntity> SEAT;
   public static class_1299<PumpEntity> PUMP;
   public static class_1299<PocketStarEntity> POCKET_STAR;

   public static void initialize() {
      DRIVING_SEAT = registerEntity(
         "driving_seat",
         FabricEntityTypeBuilder.create(class_1311.field_17715, DrivingSeatEntity::new)
            .dimensions(class_4048.method_18385(1.0F, 1.0F))
            .trackRangeChunks(5)
            .forceTrackedVelocityUpdates(false)
            .trackedUpdateRate(Integer.MAX_VALUE)
            .build()
      );
      BIG_DOOR = registerEntity(
         "big_door",
         FabricEntityTypeBuilder.create(class_1311.field_17715, BigDoorEntity::new)
            .dimensions(class_4048.method_18385(3.0F, 4.0F))
            .trackRangeChunks(128)
            .disableSummon()
            .build()
      );
      SMALL_GLASS_DOOR = registerEntity(
         "small_glass_door",
         FabricEntityTypeBuilder.create(class_1311.field_17715, SmallDoorEntity::new)
            .dimensions(class_4048.method_18385(1.0F, 2.0F))
            .trackRangeChunks(128)
            .disableSummon()
            .build()
      );
      SMALL_WOOD_DOOR = registerEntity(
         "small_wood_door",
         FabricEntityTypeBuilder.create(class_1311.field_17715, SmallDoorEntity::new)
            .dimensions(class_4048.method_18385(1.0F, 2.0F))
            .trackRangeChunks(128)
            .disableSummon()
            .build()
      );
      SPRINKLER = registerEntity(
         "sprinkler",
         FabricEntityTypeBuilder.create(class_1311.field_17715, SprinklerEntity::new)
            .dimensions(class_4048.method_18385(1.0F, 1.0F))
            .trackRangeChunks(128)
            .disableSummon()
            .build()
      );
      SEAT = registerEntity(
         "seat",
         FabricEntityTypeBuilder.create(class_1311.field_17715, SeatEntity::new)
            .dimensions(class_4048.method_18385(1.0F, 1.0F))
            .trackRangeChunks(128)
            .disableSummon()
            .build()
      );
      PUMP = registerEntity(
         "pump",
         FabricEntityTypeBuilder.create(class_1311.field_17715, PumpEntity::new)
            .dimensions(class_4048.method_18385(1.0F, 1.0F))
            .trackRangeChunks(128)
            .disableSummon()
            .build()
      );
      AIRLOCK = registerEntity(
         "airlock",
         FabricEntityTypeBuilder.create(class_1311.field_17715, AirlockEntity::new)
            .dimensions(class_4048.method_18385(8.0F, 5.0F))
            .trackRangeChunks(128)
            .disableSummon()
            .build()
      );
      POCKET_STAR = registerEntity(
         "pocket_star",
         FabricEntityTypeBuilder.create(class_1311.field_17715, PocketStarEntity::new)
            .dimensions(class_4048.method_18385(0.25F, 0.25F))
            .trackRangeChunks(128)
            .build()
      );
   }

   private static <T extends class_1297> class_1299<T> registerEntity(String name, class_1299<T> entityType) {
      return (class_1299<T>)class_2378.method_10230(class_7923.field_41177, SpaceMod.id(name), entityType);
   }

   static {
      SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
   }
}
