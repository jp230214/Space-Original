package doctor4t.spacemod.util;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;

public interface BlockCastFinder {
   @NotNull
   static List<class_2338> castRayForGridPoints(class_243 startPosition, @NotNull class_243 direction, double radius, double maxDistance) {
      Set<class_2338> intersectedPoints = new HashSet<>();
      class_243 normalizedDirection = direction.method_1029();

      for (double d = 0.0; d <= maxDistance; d += 0.2) {
         class_243 currentPosition = startPosition.method_1019(normalizedDirection.method_1021(d));
         addGridPointsWithinRadius(currentPosition, radius, intersectedPoints);
      }

      return new ArrayList<>(intersectedPoints);
   }

   static void addGridPointsWithinRadius(@NotNull class_243 position, double radius, Set<class_2338> intersectedPoints) {
      int minX = (int)Math.floor(position.field_1352 - radius);
      int maxX = (int)Math.ceil(position.field_1352 + radius);
      int minY = (int)Math.floor(position.field_1351 - radius);
      int maxY = (int)Math.ceil(position.field_1351 + radius);
      int minZ = (int)Math.floor(position.field_1350 - radius);
      int maxZ = (int)Math.ceil(position.field_1350 + radius);

      for (int x = minX; x <= maxX; x++) {
         for (int y = minY; y <= maxY; y++) {
            for (int z = minZ; z <= maxZ; z++) {
               class_2338 gridPoint = new class_2338(x, y, z);
               if (isWithinRadius(position, gridPoint, radius)) {
                  intersectedPoints.add(gridPoint);
               }
            }
         }
      }
   }

   static boolean isWithinRadius(@NotNull class_243 position, @NotNull class_2338 gridPoint, double radius) {
      double dx = position.field_1352 - (gridPoint.method_10263() + 0.5);
      double dy = position.field_1351 - (gridPoint.method_10264() + 0.5);
      double dz = position.field_1350 - (gridPoint.method_10260() + 0.5);
      double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
      return distance <= radius;
   }


}
