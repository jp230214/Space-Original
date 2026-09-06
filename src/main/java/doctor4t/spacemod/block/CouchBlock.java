package doctor4t.spacemod.block;

import dev.upcraft.sdrm.api.SDRMVerifier;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3542;
import net.minecraft.class_3726;
import net.minecraft.class_2689.class_2690;
import net.minecraft.class_4970.class_2251;
import org.jetbrains.annotations.Nullable;

public class CouchBlock extends HorizontalFacingMountableBlock {
   public static final class_265 SHAPE = class_2248.method_9541(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
   public static final class_2754<CouchBlock.CouchArms> ARMS = class_2754.method_11850("arms", CouchBlock.CouchArms.class);

   public CouchBlock(class_2251 settings) {
      super(settings);
      this.method_9590(
         (class_2680)((class_2680)super.method_9564().method_11657(ARMS, CouchBlock.CouchArms.SINGLE))
            .method_11657(class_2741.field_12481, class_2350.field_11043)
      );
   }

   @Override
   protected void method_9515(class_2690<class_2248, class_2680> builder) {
      builder.method_11667(new class_2769[]{ARMS, class_2741.field_12481});
   }

   @Override
   public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
      return SHAPE;
   }

   @Override
   public class_243 getNorthFacingSitPos(class_1937 world, class_2680 state, class_2338 pos) {
      return new class_243(0.5, 0.5, 0.375);
   }

   @Nullable
   @Override
   public class_2680 method_9605(class_1750 ctx) {
      class_2680 state = (class_2680)super.method_9605(ctx).method_11657(ARMS, CouchBlock.CouchArms.NO_ARMS);
      class_2680 clickedBlockState = ctx.method_8045().method_8320(ctx.method_8037().method_10093(ctx.method_8038().method_10153()));
      if (ctx.method_8046()) {
         state = (class_2680)state.method_11657(ARMS, CouchBlock.CouchArms.SINGLE);
      } else if (clickedBlockState.method_26204() instanceof CouchBlock
         && ((class_2350)clickedBlockState.method_11654(class_2741.field_12481)).equals(state.method_11654(class_2741.field_12481))) {
         if (((class_2350)clickedBlockState.method_11654(class_2741.field_12481)).method_10170().equals(ctx.method_8038())) {
            state = (class_2680)state.method_11657(ARMS, CouchBlock.CouchArms.RIGHT);
         } else if (((class_2350)clickedBlockState.method_11654(class_2741.field_12481)).method_10160().equals(ctx.method_8038())) {
            state = (class_2680)state.method_11657(ARMS, CouchBlock.CouchArms.LEFT);
         }
      }

      return state;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "d674a1fe-657f-4f2a-bfeb-60c1e68f4721");
   }

   public enum CouchArms implements class_3542 {
      LEFT("left"),
      RIGHT("right"),
      SINGLE("single"),
      NO_ARMS("no_arms");

      private final String name;

      CouchArms(String name) {
         this.name = name;
      }

      @Override
      public String toString() {
         return this.name;
      }

      public String method_15434() {
         return this.name;
      }

      static {
         SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
      }
   }
}
