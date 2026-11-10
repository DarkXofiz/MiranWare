// Original binary: sg/mx/8l5Z4192GCchtGAy
package sg.mx;

import io.netty.channel.Channel;
import net.minecraft.network.Connection;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ProxyConfig;
import sg.ec.ProxyManager;
import sg.ec.BotConnectionAccess;
import sg.ec.SocksProxyConnector;

// $VF: Compiled from s
@Mixin(targets = "net/minecraft/network/Connection$1")
public class Connection$1Mixin {
   @Shadow(remap = false)
   @Final
   Connection val$connection;

   @Inject(method = "initChannel(Lio/netty/channel/Channel;)V", at = @At("HEAD"))
   private void hex$installProxy(Channel var1, CallbackInfo var2) {
      BotConnectionAccess var3 = (BotConnectionAccess)(Object)this.val$connection;
      ProxyConfig var4 = var3.isBotConnection() ? var3.getProxy() : ProxyManager.INSTANCE.method05228();
      SocksProxyConnector.method05689(var1, var4);
   }
}
