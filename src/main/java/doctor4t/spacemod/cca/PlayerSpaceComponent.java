package doctor4t.spacemod.cca;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.SpaceMod;
import doctor4t.spacemod.block.LiquidBlock;
import doctor4t.spacemod.index.SpaceModBlocks;
import doctor4t.spacemod.index.SpaceModItems;
import doctor4t.spacemod.index.SpaceModSounds;
import doctor4t.spacemod.index.world.SpaceModDimensions;
import java.util.UUID;
import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3419;
import net.minecraft.class_3532;
import org.jetbrains.annotations.Nullable;

public class PlayerSpaceComponent implements AutoSyncedComponent, ServerTickingComponent {
   public static final int MAX_OXYGEN = 24000;
   public static final int MAX_FUEL = 3600;
   public static final int OXYGEN_BREATHING_COST = 1;
   public static final int OXYGEN_REGAIN_RATE = 1000;
   public static final int OXYGEN_JETPACK_COST = 10;
   public static final int FUEL_JETPACK_COST = 1;
   public static final int FUEL_PER_ICHOR_LAYER = 50;
   public static final int MAX_SUFFOCATION = 400;
   public static final int SUFFOCATION_DAMAGE_THRESHOLD = 200;
   public static final int SUFFOCATION_REGAIN_RATE = 5;
   private final class_1657 player;
   private PlayerSpaceComponent.Type spaceSuitType = PlayerSpaceComponent.Type.DEFAULT;
   private boolean isInSpace = false;
   private boolean isFlashlightOn = false;
   private boolean isJetpackOn = false;
   private int oxygen = 24000;
   private int fuel = 3600;
   private int suckedUpFuel = 0;
   private boolean dead;
   private int suffocation = 0;
   private int maxHealingTicks = 0;
   private int healingTicks = 0;

   public PlayerSpaceComponent(class_1657 player) {
      this.player = player;
   }

   public PlayerSpaceComponent.Type getSpaceSuitType() {
      if (this.spaceSuitType == null || this.player.method_7334() != null) {
         for (PlayerSpaceComponent.Type spacesuitType : PlayerSpaceComponent.Type.values()) {
            if (spacesuitType.uuid != null && spacesuitType.uuid.equals(this.player.method_5667())) {
               this.setSpaceSuitType(spacesuitType);
               return this.spaceSuitType;
            }
         }
      }

      return this.spaceSuitType != null ? this.spaceSuitType : PlayerSpaceComponent.Type.DEFAULT;
   }

   public boolean isInSpace() {
      return this.isInSpace;
   }

   public void setInSpace(boolean inSpace) {
      this.isInSpace = inSpace;
      this.sync();
   }

   public boolean isFlashlightOn() {
      return this.isWearingSpaceHelmet() && this.isFlashlightOn;
   }

   public boolean isHoldingPocketStar() {
      return this.player.method_5998(class_1268.field_5808).method_31574(SpaceModItems.POCKET_STAR)
         || this.player.method_5998(class_1268.field_5810).method_31574(SpaceModItems.POCKET_STAR);
   }

   public void setFlashlightOn(boolean flashlightOn) {
      this.isFlashlightOn = flashlightOn;
   }

   public boolean isJetpackOn() {
      return this.isWearingJetpack() && this.isJetpackOn && !this.player.method_5765();
   }

   public void setJetpackOn(boolean jetpackOn) {
      this.isJetpackOn = jetpackOn;
   }

   public boolean isWearingSpaceHelmet() {
      return this.player.method_6118(class_1304.field_6169).method_31574(SpaceModBlocks.SPACE_HELMET.method_8389());
   }

   public boolean isWearingJetpack() {
      return this.player.method_6118(class_1304.field_6174).method_31574(SpaceModBlocks.JETPACK.method_8389());
   }

   public boolean isWearingCanister() {
      return this.player.method_6118(class_1304.field_6174).method_31574(SpaceModBlocks.CANISTER.method_8389());
   }

   public int getCanisterLevel() {
      class_2487 nbt = this.player.method_6118(class_1304.field_6174).method_7969();
      return nbt != null && nbt.method_10545("ichorState") ? nbt.method_10550("ichorState") : 0;
   }

   public void setCanisterLevel(int level) {
      class_2487 nbt = this.player.method_6118(class_1304.field_6174).method_7948();
      nbt.method_10569("ichorState", level);
   }

   public int getOxygen() {
      return this.oxygen;
   }

   public void setOxygen(int oxygen) {
      this.oxygen = class_3532.method_15340(oxygen, 0, 24000);
   }

   public int getFuel() {
      return this.fuel;
   }

   public void setFuel(int fuel) {
      this.fuel = class_3532.method_15340(fuel, 0, 3600);
   }

   public int getOxygenBarLength(int width) {
      return (int)(this.getOxygen() / 24000.0F * width);
   }

   public int getFuelBarLength(int width) {
      return (int)(this.getFuel() / 3600.0F * width);
   }

   public int getSuckedUpFuel() {
      return this.suckedUpFuel;
   }

   public void setSuckedUpFuel(int suckedUpFuel) {
      this.suckedUpFuel = suckedUpFuel;
   }

   public boolean isDead() {
      return this.dead;
   }

   public void setDead(boolean dead) {
      if (this.dead && !dead) {
         this.player.method_17356(SpaceModSounds.ENTITY_PLAYER_REVIVE, class_3419.field_15248, 0.5F, 1.0F);
      }

      this.dead = dead;
      this.sync();
   }

   public int getSuffocation() {
      return this.suffocation;
   }

   public void setSuffocation(int suffocation) {
      this.suffocation = class_3532.method_15340(suffocation, 0, 400);
   }

   public void setSpaceSuitType(PlayerSpaceComponent.Type spaceSuitType) {
      this.spaceSuitType = spaceSuitType;
   }

   public int getMaxHealingTicks() {
      return this.maxHealingTicks;
   }

   public void setMaxHealingTicks(int maxHealingTicks) {
      this.maxHealingTicks = maxHealingTicks;
   }

   public int getHealingTicks() {
      return this.healingTicks;
   }

   public void setHealingTicks(int healingTicks) {
      if (healingTicks <= 0) {
         this.setMaxHealingTicks(0);
      }

      this.healingTicks = healingTicks;
   }

   public void sync() {
      SpaceModComponents.SPACE.sync(this.player);
   }

   public boolean shouldBreatheOxygen(boolean planetHasOxygen) {
      return !planetHasOxygen && this.isInSpace && this.getOxygen() > 0 && this.isWearingSpaceHelmet()
         ? !this.player.method_7337() && !this.player.method_7325()
         : false;
   }

   public boolean shouldRegainOxygen(boolean planetHasOxygen) {
      return planetHasOxygen || !this.isInSpace;
   }

   public void readFromNbt(class_2487 nbt) {
      this.isInSpace = nbt.method_10577("isInSpace");
      this.isFlashlightOn = nbt.method_10577("isFlashlightOn");
      this.isJetpackOn = nbt.method_10577("isJetpackOn");
      this.oxygen = nbt.method_10573("oxygen", 3) ? nbt.method_10550("oxygen") : 24000;
      this.fuel = nbt.method_10573("fuel", 3) ? nbt.method_10550("fuel") : 3600;
      this.suckedUpFuel = nbt.method_10550("suckedUpFuel");
      this.dead = nbt.method_10577("dead");
      this.suffocation = nbt.method_10550("suffocation");
      this.maxHealingTicks = nbt.method_10550("maxHealingTicks");
      this.healingTicks = nbt.method_10550("healingTicks");
   }

   public void writeToNbt(class_2487 nbt) {
      nbt.method_10556("isInSpace", this.isInSpace);
      nbt.method_10556("isFlashlightOn", this.isFlashlightOn);
      nbt.method_10556("isJetpackOn", this.isJetpackOn);
      nbt.method_10569("oxygen", this.oxygen);
      nbt.method_10569("fuel", this.fuel);
      nbt.method_10569("suckedUpFuel", this.suckedUpFuel);
      nbt.method_10556("dead", this.dead);
      nbt.method_10569("suffocation", this.suffocation);
      nbt.method_10569("maxHealingTicks", this.maxHealingTicks);
      nbt.method_10569("healingTicks", this.healingTicks);
   }

   public void serverTick() {
      boolean sync = false;
      boolean planetHasOxygen = SpaceModDimensions.hasOxygen(this.player.method_37908());
      if (this.isDead()) {
         this.setHealingTicks(0);
         sync = true;
      }

      if (this.getHealingTicks() > 0) {
         this.setHealingTicks(this.getHealingTicks() - 1);
         this.player.method_6025(0.05F);
         sync = true;
      }

      if (this.isJetpackOn()) {
         if (!planetHasOxygen) {
            this.setOxygen(this.getOxygen() - 10);
         }

         this.setFuel(this.getFuel() - 1);
         sync = true;
      } else if (this.isWearingJetpack() && this.getFuel() < 3600 && this.collectIchor()) {
         sync = true;
      } else if (this.isWearingCanister() && this.getCanisterLevel() < 8 && this.collectIchor()) {
         this.setSuckedUpFuel(this.getSuckedUpFuel() + 1);
         if (this.getSuckedUpFuel() >= 64) {
            this.setSuckedUpFuel(0);
            this.setCanisterLevel(this.getCanisterLevel() + 1);
         }

         sync = true;
      }

      if (this.getOxygen() > 0 && this.getSuffocation() > 0) {
         this.setSuffocation(this.getSuffocation() - 5);
         sync = true;
      }

      if (this.isInSpace() && !this.isWearingSpaceHelmet() && !this.isDead() && !this.player.method_7337() && !this.player.method_7325()) {
         this.player.method_5768();
         sync = true;
      }

      if (this.shouldBreatheOxygen(planetHasOxygen)) {
         this.setOxygen(this.getOxygen() - 1);
         sync = true;
      } else if (this.shouldRegainOxygen(planetHasOxygen)) {
         if (this.getOxygen() < 24000) {
            this.setOxygen(this.getOxygen() + 1000);
            sync = true;
         }
      } else if (this.getOxygen() <= 0) {
         if (this.getSuffocation() < 400) {
            this.setSuffocation(this.getSuffocation() + 1);
            sync = true;
         }

         if (!this.isDead() && this.getSuffocation() >= 200) {
            this.player.method_5643(this.player.method_48923().method_48822(), 1.0F);
         }
      }

      if (this.isJetpackOn && (this.getFuel() <= 0 || this.getOxygen() <= 0)) {
         this.setJetpackOn(false);
         this.player.method_17356(SpaceModSounds.ENTITY_JETPACK_START, class_3419.field_15248, 1.0F, 1.0F);
      }

      if (sync) {
         this.sync();
      }
   }

   protected boolean collectIchor() {
      class_238 box = this.player.method_5829().method_1011(1.0E-6);
      int minX = class_3532.method_15357(box.field_1323);
      int minY = class_3532.method_15357(box.field_1322);
      int minZ = class_3532.method_15357(box.field_1321);
      int maxX = class_3532.method_15357(box.field_1320);
      int maxY = class_3532.method_15357(box.field_1325);
      int maxZ = class_3532.method_15357(box.field_1324);
      if (this.player.method_37908().method_22341(minX, minY, minZ, maxX, maxY, maxZ)) {
         for (class_2338 pos : class_2338.method_10094(minX, minY, minZ, maxX, maxY, maxZ)) {
            class_2680 state = this.player.method_37908().method_8320(pos);
            if (state.method_27852(SpaceModBlocks.LIQUID_ICHOR)) {
               float fluidHeight = state.method_26227().method_15763(this.player.method_37908(), pos);
               if (this.player.method_23318() + 0.5 < pos.method_10264() + fluidHeight) {
                  int level = (Integer)state.method_11654(LiquidBlock.LEVEL);
                  if (level == 1) {
                     this.player.method_37908().method_8501(pos, class_2246.field_10124.method_9564());
                  } else {
                     this.player.method_37908().method_8501(pos, (class_2680)state.method_11657(LiquidBlock.LEVEL, level - 1));
                  }

                  this.setFuel(this.getFuel() + 50);
                  if (this.player.method_37908().method_8510() % 10L == 0L) {
                     this.player.method_17356(SpaceModSounds.BLOCK_ICHOR_GULP, class_3419.field_15248, 1.0F, 1.2F);
                  }

                  return true;
               }
            }
         }
      }

      return false;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }

   public enum Type {
      DEFAULT("default", false, "textures/entity/spacesuit.png", "textures/entity/spacesuit_skin.png"),
      RAT("rat", false, "1b44461a-f605-4b29-a7a9-04e649d1981c", "textures/entity/spacesuit_rat.png", "textures/entity/spacesuit_skin_rat.png"),
      WINSWEEP(
         "winsweep", false, "d93dde4b-7b15-4e7f-a860-03a760f2aad7", "textures/entity/spacesuit_winsweep.png", "textures/entity/spacesuit_skin_winsweep.png"
      ),
      EIGHT("eight", true, "5af5642b-7b08-45f7-bd85-de3fa80916a2", "textures/entity/spacesuit_eight.png", "textures/entity/spacesuit_skin_eight.png"),
      RYAN("ryan", true, "7c86a219-cdab-49a9-bd44-e34279bd590b", "textures/entity/spacesuit_ryan.png", "textures/entity/spacesuit_skin_ryan.png"),
      LUX("lux", true, "9ff98de6-2261-411e-b554-e5318d286528", "textures/entity/spacesuit_lux.png", "textures/entity/spacesuit_skin_lux.png"),
      SILVER("silver", false, "e21c8855-99fc-4217-8e5a-9015d0ed0a3c", "textures/entity/spacesuit_silver.png", "textures/entity/spacesuit_skin_silver.png"),
      BOBA("boba", true, "62ab0e45-9863-48a6-bc1f-cb5b6d3aa0d7", "textures/entity/spacesuit_boba.png", "textures/entity/spacesuit_skin_boba.png");

      public final String name;
      @Nullable
      public final UUID uuid;
      public final class_2960 texture;
      public final class_2960 skinTexture;
      public final boolean slim;

      Type(String name, boolean slim, @Nullable UUID uuid, class_2960 texture, class_2960 skinTexture) {
         this.name = name;
         this.slim = slim;
         this.uuid = uuid;
         this.texture = texture;
         this.skinTexture = skinTexture;
      }

      Type(String name, boolean slim, String texture, String skinTexture) {
         this(name, slim, null, SpaceMod.id(texture), SpaceMod.id(skinTexture));
      }

      Type(String name, boolean slim, String uuid, String texture, String skinTexture) {
         this(name, slim, UUID.fromString(uuid), SpaceMod.id(texture), SpaceMod.id(skinTexture));
      }

      @Nullable
      public static PlayerSpaceComponent.Type fromString(String name) {
         for (PlayerSpaceComponent.Type type : values()) {
            if (type.name.equals(name)) {
               return type;
            }
         }

         return null;
      }

      static {
         SDRMVerifier.checkKey("spacemod", "e6a9bd8e-d1f8-439e-9132-4a7503cac591");
      }
   }
}
