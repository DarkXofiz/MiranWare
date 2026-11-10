// Original binary: sg/mx/wuDllwq2XDqeiK1h
package sg.mx;

import net.minecraft.client.DeltaTracker.Timer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(Timer.class)
public interface DeltaTracker$TimerMixin_1312 {
   @Accessor("deltaTickResidual")
   float tickDelta();

   @Final
   @Accessor("msPerTick")
   float tickTime();
}
