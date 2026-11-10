// Original binary: sg/mx/6tRwW0nY5SHe5ppf
package sg.mx;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ProxyScreen;
import sg.ec.MultiplayerServerListAccess;
import sg.ec.BotSessionManager;

// $VF: Compiled from s
@Mixin(JoinMultiplayerScreen.class)
public class JoinMultiplayerScreenMixin {
   @Shadow
   protected ServerSelectionList serverSelectionList;
   @Shadow
   private Button editButton;
   @Shadow
   private Button deleteButton;

   @Inject(method = "init()V", at = @At("TAIL"))
   private void hex$addProxyButton(CallbackInfo var1) {
      Screen var2 = (Screen)(Object)this;
      ((ScreenMixin)(Object)var2).IaddDrawableChild(ProxyScreen.createMenuButton(var2));
   }

   @Inject(method = "onSelectedChange", at = @At("TAIL"))
   private void hex$lockPromotedServers(CallbackInfo var1) {
      if (this.serverSelectionList.getSelected() instanceof MultiplayerServerListAccess var2 && var2.hex$promoted()) {
         this.editButton.active = false;
         this.deleteButton.active = false;
      }
   }

   @Inject(method = "join", at = @At("HEAD"), cancellable = true)
   private void onJoin(ServerData var1, CallbackInfo var2) {
      if (var1 != null && BotSessionManager.INSTANCE.method08742(var1.ip)) {
         var2.cancel();
      }
   }
}
