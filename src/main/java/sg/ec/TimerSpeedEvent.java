// Original binary: sg/ec/6iAJvmqAH1P7zdIu
package sg.ec;

import net.minecraft.client.DeltaTracker.Timer;
import sg.mx.DeltaTracker$TimerMixin_1312;

// $VF: Compiled from s
public class TimerSpeedEvent extends Event {
   public static final TimerSpeedEvent field03562 = new TimerSpeedEvent();
   private float field03563;

   public float method01449(Timer var1, float var2) {
      if (var1 == null) {
         return var2;
      }

      DeltaTracker$TimerMixin_1312 var3 = (DeltaTracker$TimerMixin_1312)var1;
      float var4 = var3.tickTime();
      this.field03563 = 1.0F;
      super.method03208();
      return this.method05694() ? var4 / this.field03563 : var2;
   }

   public void method01450(float var1) {
      this.field03563 = var1;
   }

   public float method01451() {
      return this.field03563;
   }
}
