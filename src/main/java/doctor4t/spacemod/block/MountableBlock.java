package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.SeatEntity;
import doctor4t.spacemod.index.SpaceModEntities;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1747;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4970.class_2251;

public abstract class MountableBlock extends class_2248 {
   public MountableBlock(class_2251 settings) {
      super(settings);
   }

   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return super.method_9530(state, world, pos, context);
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      float radius = 1.0F;
      if (player.method_5715()
         || player.method_5998(hand).method_7909() instanceof class_1747 blockItem && blockItem.method_7711() instanceof MountableBlock
         || !world.method_8390(SeatEntity.class, class_238.method_30048(pos.method_46558(), radius, radius, radius), class_1297::method_5805).isEmpty()) {
         return class_1269.field_5811;
      }

      if (world.field_9236) {
         return class_1269.method_29236(true);
      }

      SeatEntity seatEntity = (SeatEntity)SpaceModEntities.SEAT.method_5883(world);
      if (seatEntity == null) {
         return class_1269.field_5811;
      }

      class_243 sitPos = this.getSitPos(world, state, pos);
      class_243 vec3d = class_243.method_24954(pos).method_1019(sitPos);
      seatEntity.method_5808(vec3d.field_1352, vec3d.field_1351, vec3d.field_1350, 0.0F, 0.0F);
      seatEntity.setSeatPos(pos);
      world.method_8649(seatEntity);
      player.method_5804(seatEntity);
      return class_1269.method_29236(false);
   }

   public abstract class_243 getSitPos(class_1937 var1, class_2680 var2, class_2338 var3);

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
