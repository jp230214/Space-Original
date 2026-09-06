package doctor4t.spacemod.entity;

import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.SpaceModSounds;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_2960;
import net.minecraft.class_7094;

public class AirlockEntity extends class_1297 {
   public static final class_2940<Boolean> OPEN_TO_EXTERIOR = class_2945.method_12791(AirlockEntity.class, class_2943.field_13323);
   public static final class_2940<Boolean> OPENING = class_2945.method_12791(AirlockEntity.class, class_2943.field_13323);
   public static final class_2940<Integer> OPENING_TIMER = class_2945.method_12791(AirlockEntity.class, class_2943.field_13327);
   public static class_2960 AIRLOCK_PUFF_PRESSURIZE_PARTICLE = SpaceMod.id("airlock_puff_pressurize");
   public static class_2960 AIRLOCK_PUFF_DEPRESSURIZE_PARTICLE = SpaceMod.id("airlock_puff_depressurize");
   public final class_7094 exteriorDoorOpenAnimationState = new class_7094();
   public final class_7094 interiorDoorOpenAnimationState = new class_7094();

   public AirlockEntity(class_1299<? extends class_1297> entityType, class_1937 world) {
      super(entityType, world);
   }

   public static boolean canCollide(class_1297 entity, class_1297 other) {
      return other.method_30948() || other.method_5810();
   }

   protected void method_5693() {
      this.field_6011.method_12784(OPEN_TO_EXTERIOR, false);
      this.field_6011.method_12784(OPENING, false);
      this.field_6011.method_12784(OPENING_TIMER, 0);
   }

   public boolean isOpenToExterior() {
      return (Boolean)this.field_6011.method_12789(OPEN_TO_EXTERIOR);
   }

   public void setOpenToExterior(boolean opening) {
      this.field_6011.method_12778(OPEN_TO_EXTERIOR, opening);
   }

   public boolean isOpening() {
      return (Boolean)this.field_6011.method_12789(OPENING);
   }

   public void setOpening(boolean opening) {
      this.field_6011.method_12778(OPENING, opening);
   }

   public int getOpeningTimer() {
      return (Integer)this.field_6011.method_12789(OPENING_TIMER);
   }

   public void setOpeningTimer(int openingTimer) {
      this.field_6011.method_12778(OPENING_TIMER, openingTimer);
   }

   public boolean method_30949(class_1297 other) {
      return SpaceDoorEntity.canCollide(this, other);
   }

   public boolean method_30948() {
      return false;
   }

   public boolean method_5810() {
      return false;
   }

   public boolean method_5863() {
      return false;
   }

   public boolean method_5655() {
      return true;
   }

   public boolean method_5740() {
      return true;
   }

   protected void method_5749(class_2487 nbt) {
      this.setOpenToExterior(nbt.method_10577("openToExterior"));
      this.setOpening(nbt.method_10577("opening"));
      this.setOpeningTimer(nbt.method_10550("openingTimer"));
   }

   protected void method_5652(class_2487 nbt) {
      nbt.method_10556("openToExterior", this.isOpenToExterior());
      nbt.method_10556("opening", this.isOpening());
      nbt.method_10569("openingTimer", this.getOpeningTimer());
   }

   public class_1269 method_5688(class_1657 player, class_1268 hand) {
      return class_1269.field_5811;
   }

   public void method_5773() {
      super.method_5773();
      if (this.field_6012 <= 1 && this.method_37908().field_9236) {
         this.interiorDoorOpenAnimationState.method_41322(-99);
         this.exteriorDoorOpenAnimationState.method_41322(-99);
      }

      if (this.isOpening()) {
         this.setOpeningTimer(this.getOpeningTimer() + 1);
         if (this.getOpeningTimer() >= 40) {
            if (this.method_37908().field_9236) {
               (this.isOpenToExterior() ? this.interiorDoorOpenAnimationState : this.exteriorDoorOpenAnimationState).method_41322(this.field_6012);
            } else {
               this.fillDoorWithBlockstate(class_2246.field_10124.method_9564(), this.isOpenToExterior());
            }

            this.setOpenToExterior(!this.isOpenToExterior());
            this.setOpeningTimer(0);
            this.setOpening(false);
         }
      }
   }

   public void method_5674(class_2940<?> data) {
      if (data.equals(OPENING) && this.isOpening()) {
         if (this.method_37908().field_9236) {
            ParticleSystemManager particleManager = VeilRenderSystem.renderer().getParticleManager();

            for (int x = -2; x <= 2; x += 2) {
               for (int z = -1; z <= 1; z += 2) {
                  ParticleEmitter puffEmitter = particleManager.createEmitter(
                     this.isOpenToExterior() ? AIRLOCK_PUFF_PRESSURIZE_PARTICLE : AIRLOCK_PUFF_DEPRESSURIZE_PARTICLE
                  );
                  if (puffEmitter != null) {
                     class_2350 direction = class_2350.method_10150(this.method_36454());
                     if (direction != class_2350.field_11043 && direction != class_2350.field_11035) {
                        class_243 puffPos = new class_243(x, this.isOpenToExterior() ? 2.0F : -0.5F, z).method_1019(this.method_19538());
                        puffEmitter.setPosition(puffPos);
                     } else {
                        class_243 puffPos = new class_243(z, this.isOpenToExterior() ? 2.0F : -0.5F, x).method_1019(this.method_19538());
                        puffEmitter.setPosition(puffPos);
                     }

                     particleManager.addParticleSystem(puffEmitter);
                  }
               }
            }
         }

         (this.isOpenToExterior() ? this.exteriorDoorOpenAnimationState : this.interiorDoorOpenAnimationState).method_41322(this.field_6012);
         this.fillDoorWithBlockstate(SpaceModBlocks.AIRLOCK_BARRIER.method_9564(), !this.isOpenToExterior());
         this.method_5783(SpaceModSounds.ENTITY_AIRLOCK_CYCLE, 3.0F, 1.0F);

         for (class_1657 playerInAirlock : this.method_37908()
            .method_8390(class_1657.class, this.method_5829(), player -> player.method_5805() && !player.method_7325())) {
            ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(playerInAirlock)).setInSpace(this.isOpenToExterior());
         }
      }

      super.method_5674(data);
   }

   public void fillDoorWithBlockstate(class_2680 blockState, boolean fillExitDoor) {
      class_2350 facing = class_2350.method_10150(this.method_36454());
      class_2350 side = facing.method_10170();
      int offsetX = Math.abs(side.method_10148());
      int offsetZ = Math.abs(side.method_10165());
      class_2382 rotVec = class_2350.method_10150(this.method_36454()).method_10163();
      class_2338.method_17962(-offsetX * 2, 0, -offsetZ * 2, offsetX * 2, 4, offsetZ * 2)
         .forEach(
            pos -> this.method_37908().method_8501(pos.method_10081(rotVec.method_35862(fillExitDoor ? 4 : -4)).method_10081(this.method_24515()), blockState)
         );
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
