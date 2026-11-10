// Original binary: sg/ec/Y28aZFDuMjeMwkjk
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class PlayerTickEvent extends Event {
   public static final PlayerTickEvent field14709 = new PlayerTickEvent();

   public void method06522(CallbackInfo var1) {
      super.method03208();
      if (this.method05694()) {
         var1.cancel();
      }
   }
}
