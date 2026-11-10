// Original binary: sg/ec/lJHfZMoX98gJgmLH
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class ServerHeldSlotEvent extends Event {
   public static final ServerHeldSlotEvent field21251 = new ServerHeldSlotEvent();
   private int field21252 = -1;

   public int method09334() {
      return this.field21252;
   }

   public void method09335(int var1, CallbackInfo var2) {
      this.field21252 = var1;
      super.method03208();
      if (this.method05694()) {
         var2.cancel();
      }
   }

   public void method09336(int var1) {
      this.field21252 = var1;
   }
}
