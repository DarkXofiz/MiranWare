// Original binary: sg/ec/F4WOU5lB8uFtW5Nj
package sg.ec;

import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class ScreenChangeEvent extends Event {
   public static final ScreenChangeEvent field07239 = new ScreenChangeEvent();
   private Screen field07240;

   public void method03321(Screen var1, CallbackInfo var2) {
      this.field07240 = var1;
      super.method03208();
      if (this.method05694()) {
         var2.cancel();
      }
   }

   public Screen method03322() {
      return this.field07240;
   }
}
