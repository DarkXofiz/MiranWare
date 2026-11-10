// Original binary: sg/mx/aZQmdwkyd9qgzz3o
package sg.mx;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientLevel.ClientLevelData;
import net.minecraft.client.multiplayer.prediction.BlockStatePredictionHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ClientLevel.class)
public interface ClientLevelMixin_1241 {
   @Accessor("clientLevelData")
   ClientLevelData clientWorldProperties();

   @Accessor("blockStatePredictionHandler")
   BlockStatePredictionHandler predictionHandler();
}
