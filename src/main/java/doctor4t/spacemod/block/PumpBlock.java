package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.entity.PumpEntity;
import doctor4t.spacemod.index.SpaceModBlockEntities;
import doctor4t.spacemod.index.SpaceModEntities;
import java.util.List;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3965;
import net.minecraft.class_5558;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class PumpBlock extends class_2318 implements class_2343 {
   public static final class_2746 FULL = class_2746.method_11825("full");
   public static final class_2746 UNBREAKABLE = class_2746.method_11825("unbreakable");

   public PumpBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)((class_2680)super.method_9564().method_11657(field_10927, class_2350.field_11043)).method_11657(FULL, false))
            .method_11657(UNBREAKABLE, false)
      );
   }

   @Nullable
   public class_2680 method_9605(class_1750 ctx) {
      return (class_2680)this.method_9564().method_11657(field_10927, ctx.method_8036().method_5715() ? ctx.method_7715().method_10153() : ctx.method_7715());
   }

   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{field_10927, FULL, UNBREAKABLE});
   }

   public void method_9567(class_1937 world, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 itemStack) {
      PumpEntity pumpEntity = (PumpEntity)SpaceModEntities.PUMP.method_5883(world);
      if (pumpEntity != null) {
         pumpEntity.method_5814(pos.method_10263() + 0.5F, pos.method_10264(), pos.method_10260() + 0.5F);
         world.method_8649(pumpEntity);
         super.method_9567(world, pos, state, placer, itemStack);
      }
   }

   public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
      if ((Boolean)state.method_11654(UNBREAKABLE)) {
         return class_1269.field_5811;
      }

      if (player.method_5998(hand).method_7960()) {
         if (world.field_9236) {
            return class_1269.field_5812;
         }

         List<PumpEntity> pumpEntities = world.method_8390(PumpEntity.class, new class_238(pos), class_1297::method_5805);
         if (!pumpEntities.isEmpty()) {
            if (pumpEntities.get(0).getStatus() == PumpEntity.Status.DEPLOYED) {
               pumpEntities.get(0).setStatus(PumpEntity.Status.RETRACTING);
            } else if (pumpEntities.get(0).getStatus() == PumpEntity.Status.DEPLOYING) {
               pumpEntities.get(0).setStatus(PumpEntity.Status.DEPLOYED);
            }
         }

         return class_1269.field_21466;
      } else {
         return class_1269.field_5811;
      }
   }

   @Nullable
   public class_2586 method_10123(class_2338 pos, class_2680 state) {
      return SpaceModBlockEntities.PUMP.method_11032(pos, state);
   }

   @Nullable
   public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
      return PumpBlockEntity::tick;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }
}
