// Original binary: sg/mx/qnMX7OHM3xdhg7fk
package sg.mx;

import com.mojang.blaze3d.platform.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.DragManager;

// $VF: Compiled from s
@Mixin(Window.class)
public class WindowMixin_1298 {
   @Inject(method = "refreshFramebufferSize", at = @At("TAIL"))
   private void onUpdateFramebufferSize(CallbackInfo var1) {
      DragManager.INSTANCE.method05203((Window)(Object)this);
   }

   @Inject(method = "onResize", at = @At("TAIL"))
   private void onWindowSizeChanged(long var1, int var2, int var3, CallbackInfo var4) {
      DragManager.INSTANCE.method05203((Window)(Object)this);
   }
}
