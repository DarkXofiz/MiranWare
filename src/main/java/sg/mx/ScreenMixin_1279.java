// Original binary: sg/mx/kkkVFrgruXpQLLlg
package sg.mx;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.IBaritoneChatControl;
import hex.api.baritone.api.event.events.ChatEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(Screen.class)
public abstract class ScreenMixin_1279 {
   @Inject(method = "defaultHandleGameClickEvent", at = @At("HEAD"), cancellable = true)
   private static void hex$baritoneClickEvent(ClickEvent var0, Minecraft var1, Screen var2, CallbackInfo var3) {
      if (var0 instanceof RunCommand(String var4)) {
         if (var4.startsWith(IBaritoneChatControl.FORCE_COMMAND_PREFIX)) {
            IBaritone var8 = BaritoneAPI.getProvider().getPrimaryBaritone();
            if (var8 != null) {
               var8.getGameEventHandler().onSendChatMessage(new ChatEvent(var4));
            }

            var3.cancel();
         }
      }
   }
}
