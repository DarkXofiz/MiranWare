// Original binary: sg/ec/HJAflgcoV2YIbvne
package sg.ec;

import net.minecraft.client.DeltaTracker;

// $VF: Compiled from s
public class FrameUpdateEvent extends Event {
   public static final FrameUpdateEvent field08522 = new FrameUpdateEvent();
   private DeltaTracker field08523;

   public void method03781(DeltaTracker var1) {
      this.field08523 = var1;
      super.method03208();
   }

   public DeltaTracker method03782() {
      return this.field08523;
   }

   public void method03783(DeltaTracker var1) {
      this.field08523 = var1;
   }
}
