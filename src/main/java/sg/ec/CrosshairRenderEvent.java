// Original binary: sg/ec/h7MS7pFmwCR2MU77
package sg.ec;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class CrosshairRenderEvent extends Event {
   public static final CrosshairRenderEvent field19710 = new CrosshairRenderEvent();
   private DeltaTracker field19711;
   private GuiGraphics field19712;

   public DeltaTracker method08625() {
      return this.field19711;
   }

   public void method08626(DeltaTracker var1) {
      this.field19711 = var1;
   }

   public void method08627(GuiGraphics var1, DeltaTracker var2, CallbackInfo var3) {
      this.field19712 = var1;
      this.field19711 = var2;
      super.method03208();
      if (this.method05694()) {
         var3.cancel();
      }
   }

   public void method08628(GuiGraphics var1) {
      this.field19712 = var1;
   }

   public GuiGraphics method08629() {
      return this.field19712;
   }
}
