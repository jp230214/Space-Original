package doctor4t.spacemod.duck;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public interface ClientPlayerEntityDuck {
   void freeze();

}
