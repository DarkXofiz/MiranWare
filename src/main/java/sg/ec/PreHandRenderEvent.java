// Original binary: sg/ec/Bn9vclE2AEdW7Zuz
package sg.ec;

import net.minecraft.client.DeltaTracker;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class PreHandRenderEvent extends Event {
   public static final PreHandRenderEvent field06545 = new PreHandRenderEvent();
   private DeltaTracker field06546;

   public void method02812(DeltaTracker var1) {
      this.field06546 = var1;
   }

   public boolean method02813(DeltaTracker var1) {
      this.field06546 = var1;
      super.method03208();
      return this.method05694();
   }

   public void method02814(DeltaTracker var1, CallbackInfo var2) {
      if (this.method02813(var1)) {
         var2.cancel();
      }
   }

   public DeltaTracker method02815() {
      return this.field06546;
   }
}
