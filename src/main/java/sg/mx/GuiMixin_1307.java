// Original binary: sg/mx/u8oH9OUdeWzaYjZh
package sg.mx;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.HudRenderTargetHooks;

// $VF: Compiled from s
@Mixin(Gui.class)
public class GuiMixin_1307 {
   @Inject(method = "extractRenderState(Lnet/minecraft/client/DeltaTracker;ZZ)V", at = @At("HEAD"), cancellable = true)
   private void hex$throttleExtract(DeltaTracker var1, boolean var2, boolean var3, CallbackInfo var4) {
      HudRenderTargetHooks.method06927(var4);
   }
}
