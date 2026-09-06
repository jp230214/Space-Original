package doctor4t.spacemod.mixin.spacesuitskin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.authlib.GameProfile;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_742;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(class_742.class)
public abstract class SpaceSuitArmAbstractClientPlayerEntityMixin extends class_1657 {
   protected SpaceSuitArmAbstractClientPlayerEntityMixin(class_1937 world, class_2338 pos, float yaw, GameProfile gameProfile) {
      super(world, pos, yaw, gameProfile);
   }

   @ModifyReturnValue(method = "getModel", at = @At("RETURN"))
   private String spacemod$slimnessFromPlayerSpaceSuit(String original) {
      return ((PlayerSpaceComponent)SpaceModComponents.SPACE.get(this)).getSpaceSuitType().slim ? "slim" : "default";
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
