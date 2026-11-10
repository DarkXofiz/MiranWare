// Original binary: sg/mx/22wWqqYyM8CHkGfA
package sg.mx;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ProxyConfig;
import sg.ec.BotConnectionAccess;
import sg.ec.ConnectionHooks;

// $VF: Compiled from s
@Mixin(Connection.class)
public abstract class ConnectionMixin implements BotConnectionAccess {
   @Unique
   private ConnectionHooks hex$packets;
   @Unique
   private volatile ProxyConfig hex$proxy;

   @Shadow
   public abstract void send(Packet<?> var1);

   @Inject(method = "<init>", at = @At("RETURN"))
   private void hex$initPackets(CallbackInfo var1) {
      this.hex$packets = new ConnectionHooks();
   }

   @Inject(method = "channelActive", at = @At("HEAD"))
   private void onChannelActive(ChannelHandlerContext var1, CallbackInfo var2) {
      this.hex$packets.method05707((Connection)(Object)this);
   }

   @Inject(method = "channelInactive", at = @At("HEAD"))
   private void onChannelInactive(ChannelHandlerContext var1, CallbackInfo var2) {
      this.hex$packets.method05702((Connection)(Object)this);
   }

   @Inject(method = "channelRead0*", at = @At("HEAD"), cancellable = true)
   protected void channelRead0(ChannelHandlerContext var1, Packet<?> var2, CallbackInfo var3) {
      this.hex$packets.method05703((Connection)(Object)this, var2, var3);
   }

   @Inject(method = "send(Lnet/minecraft/network/protocol/Packet;Lio/netty/channel/ChannelFutureListener;Z)V", at = @At("HEAD"), cancellable = true)
   private void onSendPacketPre(Packet<?> var1, @Nullable ChannelFutureListener var2, boolean var3, CallbackInfo var4) {
      this.hex$packets.method05704((Connection)(Object)this, var1, var4);
   }

   @Override
   public void sendPacket(Packet<?> var1) {
      this.hex$packets.method05705((Connection)(Object)this, var1);
   }

   @Override
   public void setBotConnection(boolean var1) {
      this.hex$packets.method05699(var1);
   }

   @Override
   public boolean isBotConnection() {
      return this.hex$packets.method05706();
   }

   @Override
   public void setProxy(ProxyConfig var1) {
      this.hex$proxy = var1;
   }

   @Override
   public ProxyConfig getProxy() {
      return this.hex$proxy;
   }
}
