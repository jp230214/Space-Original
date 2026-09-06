package doctor4t.spacemod.entity;

import com.mojang.datafixers.util.Either;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.block.CanisterBlock;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.block.PipeBlock;
import doctor4t.spacemod.block.PumpBlock;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.SpaceModLiquids;
import doctor4t.spacemod.index.SpaceModSounds;
import doctor4t.spacemod.index.tag.SpaceModFluidTags;
import doctor4t.spacemod.util.liquid.LiquidState;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2487;
import net.minecraft.class_2509;
import net.minecraft.class_2520;
import net.minecraft.class_2680;
import net.minecraft.class_2756;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3419;
import net.minecraft.class_3902;
import net.minecraft.class_6903;
import net.minecraft.class_2338.class_2339;
import org.slf4j.Logger;

public class PumpEntity extends class_1297 {
   public static final Codec<Deque<Either<class_3902, LiquidState>>> LIQUID_QUEUE_CODEC = LiquidState.EITHER_CODEC
      .listOf()
      .xmap(ArrayDeque::new, ArrayList::new);
   private static final Logger LOGGER = LogUtils.getLogger();
   private static final class_2940<Integer> STATUS = class_2945.method_12791(PumpEntity.class, class_2943.field_13327);
   public int pipeProgress = 1;
   private Deque<Either<class_3902, LiquidState>> liquidQueue = new ArrayDeque<>();

   public PumpEntity(class_1299<? extends class_1297> type, class_1937 world) {
      super(type, world);
   }

   public static boolean shouldPlayAudio(class_1937 world, class_2338 blockPos) {
      class_2680 state = world.method_8320(blockPos);
      return state.method_27852(SpaceModBlocks.PUMP) && !(Boolean)state.method_11654(PumpBlock.UNBREAKABLE);
   }

   protected void method_5693() {
      this.field_6011.method_12784(STATUS, 0);
   }

   public PumpEntity.Status getStatus() {
      return PumpEntity.Status.values()[this.field_6011.method_12789(STATUS)];
   }

   public void setStatus(PumpEntity.Status status) {
      this.field_6011.method_12778(STATUS, status.ordinal());
   }

   public void method_5773() {
      super.method_5773();
      if (!this.method_37908().field_9236) {
         class_2680 blockState = this.method_36601();
         if (blockState.method_27852(SpaceModBlocks.PUMP)) {
            class_2350 facing = (class_2350)blockState.method_11654(PipeBlock.field_10927);
            if (this.getStatus() == PumpEntity.Status.DEPLOYING) {
               if (this.field_6012 % 5 == 0) {
                  class_2338 offsetPosition = this.method_24515().method_10079(facing, this.pipeProgress);
                  class_2680 offsetState = this.method_37908().method_8320(offsetPosition);
                  if (this.canReplace(offsetState)) {
                     this.method_37908().method_8501(offsetPosition, (class_2680)SpaceModBlocks.PIPE.method_9564().method_11657(PipeBlock.field_10927, facing));
                     this.method_37908()
                        .method_8396(null, offsetPosition, SpaceModSounds.BLOCK_PIPE_EXTEND, class_3419.field_15245, 2.0F, 1.0F + this.pipeProgress / 200.0F);
                  } else {
                     this.setStatus(PumpEntity.Status.DEPLOYED);
                  }

                  if (this.pipeProgress++ >= 20) {
                     this.setStatus(PumpEntity.Status.DEPLOYED);
                  }
               }
            } else if (this.getStatus() == PumpEntity.Status.RETRACTING) {
               if (this.field_6012 % 5 == 0) {
                  class_2338 offsetPosition = this.method_24515().method_10079(facing, this.pipeProgress);
                  class_2680 offsetState = this.method_37908().method_8320(offsetPosition);
                  if (offsetState.method_27852(SpaceModBlocks.PIPE)) {
                     this.method_37908().method_8501(offsetPosition, class_2246.field_10124.method_9564());
                     this.method_37908()
                        .method_8396(null, offsetPosition, SpaceModSounds.BLOCK_PIPE_EXTEND, class_3419.field_15245, 2.0F, 1.0F + this.pipeProgress / 200.0F);
                  } else if (offsetState.method_27852(SpaceModBlocks.PUMP) && this.pipeProgress == 0) {
                     this.method_37908().method_22352(offsetPosition, false);
                     PumpBlock.method_9577(this.method_37908(), offsetPosition, SpaceModBlocks.PUMP.method_8389().method_7854());
                  }

                  this.pipeProgress--;
               }
            } else if (this.getStatus() == PumpEntity.Status.DEPLOYED && this.field_6012 % 3 == 0) {
               if (this.canIntake(facing)) {
                  class_2350 intakeDirection = facing == class_2350.field_11036
                     ? class_2350.field_11035
                     : (facing == class_2350.field_11033 ? class_2350.field_11043 : class_2350.field_11036);
                  class_2338 intakeBlockPos = this.method_24515().method_10093(intakeDirection);
                  class_2680 intakeState = this.method_37908().method_8320(intakeBlockPos);
                  if (intakeState.method_26204() instanceof LiquidBlock liquidBlock) {
                     this.intakeLiquid(liquidBlock.getLiquidState(this.method_37908(), intakeBlockPos, intakeState));
                     this.method_37908().method_8501(intakeBlockPos, class_2246.field_10124.method_9564());
                     if (this.field_6012 % 9 == 0) {
                        this.method_37908().method_8396(null, intakeBlockPos, SpaceModSounds.BLOCK_ICHOR_GULP, class_3419.field_15245, 1.0F, 0.8F);
                     }
                  }

                  if (intakeState.method_27852(SpaceModBlocks.CANISTER) && (Integer)intakeState.method_11654(CanisterBlock.LEVEL) > 0) {
                     this.intakeLiquid(LiquidState.of(SpaceModLiquids.ICHOR, 64));
                     Integer newLevel = (Integer)this.method_37908().method_8320(intakeBlockPos).method_11654(CanisterBlock.LEVEL) - 1;
                     this.method_37908().method_8501(intakeBlockPos, (class_2680)intakeState.method_11657(CanisterBlock.LEVEL, newLevel));
                     class_2338 otherPos = intakeState.method_11654(CanisterBlock.HALF) == class_2756.field_12609
                        ? intakeBlockPos.method_10074()
                        : intakeBlockPos.method_10084();
                     this.method_37908()
                        .method_8501(otherPos, (class_2680)this.method_37908().method_8320(otherPos).method_11657(CanisterBlock.LEVEL, newLevel));
                     if (this.field_6012 % 9 == 0) {
                        this.method_37908().method_8396(null, intakeBlockPos, SpaceModSounds.BLOCK_ICHOR_GULP, class_3419.field_15245, 1.0F, 0.8F);
                     }
                  } else {
                     this.intakeAir();
                  }
               }

               class_2339 mutable = this.method_24515().method_10093(facing).method_25503();

               int length;
               for (length = 1; this.isPipeFacing(this.method_37908().method_8320(mutable), facing); length++) {
                  mutable.method_10098(facing);
               }

               if (this.liquidQueue.size() >= length) {
                  class_2680 stateAtPipeEnd = this.method_37908().method_8320(mutable);
                  Either<class_3902, LiquidState> output = this.liquidQueue.removeFirst();
                  List<PumpEntity> pumpEntities = this.method_37908().method_8390(PumpEntity.class, new class_238(mutable), PumpEntity::canReceive);
                  if (stateAtPipeEnd.method_27852(SpaceModBlocks.PUMP) && !pumpEntities.isEmpty()) {
                     PumpEntity pumpEntity = pumpEntities.get(0);
                     output.ifLeft(unit -> pumpEntity.intakeAir()).ifRight(pumpEntity::intakeLiquid);
                  } else if (output.right().isPresent() && this.canReplace(stateAtPipeEnd)) {
                     class_2680 outputState = ((LiquidState)output.right().get()).getBlockState();
                     if (stateAtPipeEnd.method_27852(outputState.method_26204())) {
                        int level = Math.min(64, (Integer)stateAtPipeEnd.method_11654(LiquidBlock.LEVEL) + (Integer)outputState.method_11654(LiquidBlock.LEVEL));
                        this.method_37908().method_8501(mutable, (class_2680)outputState.method_11657(LiquidBlock.LEVEL, level));
                     } else {
                        this.method_37908().method_8501(mutable, outputState);
                     }

                     if (this.field_6012 % 9 == 0) {
                        this.method_37908().method_8396(null, mutable, SpaceModSounds.BLOCK_ICHOR_GULP, class_3419.field_15245, 1.0F, 1.0F);
                     }
                  }
               }
            }
         } else {
            this.method_31472();
         }
      }
   }

   protected boolean canReceive() {
      return this.method_5805() && this.getStatus() == PumpEntity.Status.DEPLOYED;
   }

   protected boolean canIntake(class_2350 facing) {
      boolean hasPipeIntake = false;

      for (class_2350 direction : class_2350.values()) {
         if (direction != facing) {
            class_2680 state = this.method_37908().method_8320(this.method_24515().method_10093(direction));
            if (this.hasPipeIntake(state, direction)) {
               hasPipeIntake = true;
               break;
            }
         }
      }

      return !hasPipeIntake;
   }

   protected void intakeAir() {
      this.liquidQueue.add(Either.left(class_3902.field_17274));
   }

   protected void intakeLiquid(LiquidState liquidState) {
      this.liquidQueue.add(Either.right(liquidState));
   }

   protected boolean hasPipeIntake(class_2680 state, class_2350 direction) {
      return !state.method_27852(SpaceModBlocks.PIPE) && !state.method_27852(SpaceModBlocks.PUMP)
         ? false
         : state.method_11654(class_2318.field_10927) == direction.method_10153();
   }

   protected boolean hasCanisterIntake(class_2680 state) {
      return state.method_27852(SpaceModBlocks.CANISTER);
   }

   protected boolean isPipeFacing(class_2680 state, class_2350 direction) {
      return state.method_27852(SpaceModBlocks.PIPE) && state.method_11654(PipeBlock.field_10927) == direction;
   }

   protected boolean canReplace(class_2680 state) {
      return state.method_26215() || state.method_45474() || state.method_26227().method_15767(SpaceModFluidTags.LIQUIDS);
   }

   public boolean method_5727(double cameraX, double cameraY, double cameraZ) {
      return false;
   }

   protected void method_5749(class_2487 nbt) {
      this.pipeProgress = nbt.method_10550("pipeProgress");
      this.setStatus(PumpEntity.Status.values()[nbt.method_10550("status")]);
      this.liquidQueue.clear();
      if (nbt.method_10545("liquid_queue")) {
         class_2520 nbtElement = nbt.method_10580("liquid_queue");
         LIQUID_QUEUE_CODEC.parse(this.getOps(), nbtElement)
            .resultOrPartial(LOGGER::error)
            .ifPresent(liquidQueue -> this.liquidQueue = (Deque<Either<class_3902, LiquidState>>)liquidQueue);
      }
   }

   protected void method_5652(class_2487 nbt) {
      nbt.method_10569("pipeProgress", this.pipeProgress);
      nbt.method_10569("status", this.getStatus().ordinal());
      LIQUID_QUEUE_CODEC.encodeStart(this.getOps(), this.liquidQueue)
         .resultOrPartial(LOGGER::error)
         .ifPresent(nbtElement -> nbt.method_10566("liquid_queue", nbtElement));
   }

   protected DynamicOps<class_2520> getOps() {
      return class_6903.method_46632(class_2509.field_11560, this.method_37908().method_30349());
   }

   static {
      SDRMVerifier.checkKey("spacemod", "9ddfc3bd-7ba0-48bf-bac0-e57de1661804");
   }

   public enum Status {
      DEPLOYING,
      DEPLOYED,
      RETRACTING;

      static {
         SDRMVerifier.checkKey("spacemod", "8906a2a9-bf15-4b94-9fa0-3f5b7883ff97");
      }
   }
}
