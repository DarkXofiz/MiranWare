// Original binary: sg/mx/OazDLVgOJ7bkSFLZ
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.AbstractContainerEventHandler;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.ClickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ScreenInitEvent;
import sg.ec.CloudConfigManager;

// $VF: Compiled from s
@Mixin(Screen.class)
public abstract class ScreenMixin_1196 extends AbstractContainerEventHandler implements Renderable {
   @Inject(method = "init(II)V", at = @At("TAIL"))
   private void init(CallbackInfo var1) {
      ScreenInitEvent.field15048.method06770((Screen)(Object)this);
   }

   @Inject(method = "defaultHandleClickEvent", at = @At("HEAD"))
   private static void hexKeyCopy(ClickEvent var0, Minecraft var1, Screen var2, CallbackInfo var3) {
      CloudConfigManager.method11762(var0);
   }
}
