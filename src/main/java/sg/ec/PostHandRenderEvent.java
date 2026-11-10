// Original binary: sg/ec/FUNlS4rkp4jPt1iC
package sg.ec;

import net.minecraft.client.DeltaTracker;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class PostHandRenderEvent extends Event {
   public static final PostHandRenderEvent field07600 = new PostHandRenderEvent();
   private DeltaTracker field07601;

   public boolean method03415(DeltaTracker var1) {
      this.field07601 = var1;
      super.method03208();
      return this.method05694();
   }

   public void method03416(DeltaTracker var1, CallbackInfo var2) {
      if (this.method03415(var1) && var2 != null) {
         var2.cancel();
      }
   }

   public void method03417(DeltaTracker var1) {
      this.field07601 = var1;
   }

   public DeltaTracker method03418() {
      return this.field07601;
   }
}
