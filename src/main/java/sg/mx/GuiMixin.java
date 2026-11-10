// Original binary: sg/mx/eR8yNf3kaAFmC8eE
package sg.mx;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.realms.RealmsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(Gui.class)
public class GuiMixin {
   @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
   private void hex$blockRealmsScreens(Screen var1, CallbackInfo var2) {
      if (var1 instanceof RealmsScreen) {
         var2.cancel();
      }
   }
}
