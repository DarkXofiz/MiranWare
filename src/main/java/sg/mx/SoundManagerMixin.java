// Original binary: sg/mx/9HFu584e1997t7IK
package sg.mx;

import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.SoundManagerClosedEvent;

// $VF: Compiled from s
@Mixin(SoundManager.class)
public class SoundManagerMixin {
   @Inject(method = "destroy", at = @At("HEAD"))
   public void close(CallbackInfo var1) {
      SoundManagerClosedEvent.field07002.method03208();
   }
}
