// Original binary: sg/mx/WWaNud6zEl96WJFQ
package sg.mx;

import net.minecraft.client.multiplayer.prediction.BlockStatePredictionHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(BlockStatePredictionHandler.class)
public interface BlockStatePredictionHandlerMixin {
   @Accessor("currentSequenceNr")
   int getCurrentSequence();

   @Accessor("currentSequenceNr")
   void setCurrentSequence(int var1);
}
