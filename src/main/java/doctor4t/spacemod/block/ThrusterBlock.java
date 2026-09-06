package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block_entity.ThrusterBlockEntity;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_3965;
import net.minecraft.class_5558;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class ThrusterBlock extends class_2237 {
   public ThrusterBlock(class_2251 settings) {
      super(settings);
   }

   @Nullable
   public class_2586 method_10123(class_2338 pos, class_2680 state) {
      return new ThrusterBlockEntity(pos, state);
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if (player.method_7337() && world.method_8321(pos) instanceof ThrusterBlockEntity thrusterBlockEntity) {
         thrusterBlockEntity.setSize(thrusterBlockEntity.getSize() + (player.method_5715() ? -1 : 1));
         player.method_7353(class_2561.method_43470(String.valueOf(thrusterBlockEntity.getSize())), true);
         return class_1269.method_29236(world.field_9236);
      } else {
         return super.method_9534(state, world, pos, player, hand, hit);
      }
   }

   @Nullable
   public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
      return world.method_8608() ? method_31618(type, SpaceModBlockEntities.THRUSTER, ThrusterBlockEntity::tickClient) : null;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
