package doctor4t.spacemod.util;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_2540;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

public class BufferUtils {
   @NotNull
   public static Quaterniond readQuaternion(class_2540 buf, Quaterniond dest) {
      double rotX = buf.readDouble();
      double rotY = buf.readDouble();
      double rotZ = buf.readDouble();
      double rotW = buf.readDouble();
      return dest.set(rotX, rotY, rotZ, rotW);
   }

   @NotNull
   public static Vector3d readVector(class_2540 buf, Vector3d dest) {
      double velX = buf.readDouble();
      double velY = buf.readDouble();
      double velZ = buf.readDouble();
      return dest.set(velX, velY, velZ);
   }

   public static void writeQuaternion(class_2540 buf, Quaterniondc quaternion) {
      buf.writeDouble(quaternion.x());
      buf.writeDouble(quaternion.y());
      buf.writeDouble(quaternion.z());
      buf.writeDouble(quaternion.w());
   }

   public static void writeVector(class_2540 buf, Vector3dc vector) {
      buf.writeDouble(vector.x());
      buf.writeDouble(vector.y());
      buf.writeDouble(vector.z());
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
