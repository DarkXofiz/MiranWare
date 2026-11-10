// Original binary: sg/mx/kLI00K4xUXLmKg1z
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.network.Connection;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.KeepAliveScheduler;
import sg.ec.BotConnectionAccess;
import sg.ec.ResourcePackRequestEvent;
import sg.ec.BotSessionManager;

// $VF: Compiled from s
@Mixin(ClientCommonPacketListenerImpl.class)
public abstract class ClientCommonPacketListenerImplMixin {
   private static final Logger LOGGER = LoggerFactory.getLogger(ClientCommonPacketListenerImplMixin.field28036);
   @Shadow
   @Final
   protected Connection connection;
   @Shadow
   @Final
   protected Minecraft minecraft;
   private static final String field28035 = "field28035";
   private static final String field28036 = "MiranWare";

   @Inject(method = "handleResourcePackPush", at = @At("HEAD"), cancellable = true)
   private void onResourcePackSend(ClientboundResourcePackPushPacket var1, CallbackInfo var2) {
      ResourcePackRequestEvent.field15679.method06961(this.connection, this.minecraft, var1, var2);
   }

   @Inject(method = "onPacketError", at = @At("HEAD"), cancellable = true)
   private void onRecoverablePacketError(Packet<?> var1, Exception var2, CallbackInfo var3) {
      if (BotSessionManager.INSTANCE.method08749()) {
         LOGGER.error(field28035, var1, var2.toString());
         var3.cancel();
      }
   }

   @Inject(method = "onDisconnect", at = @At("HEAD"))
   private void onSessionDisconnect(DisconnectionDetails var1, CallbackInfo var2) {
      BotSessionManager.INSTANCE.method08758(this.connection);
      KeepAliveScheduler.INSTANCE.method03311(this.connection);
   }

   @Inject(method = "handleKeepAlive", at = @At("HEAD"), cancellable = true)
   private void onKeepAlive(ClientboundKeepAlivePacket var1, CallbackInfo var2) {
      var2.cancel();
      ServerboundKeepAlivePacket var3 = new ServerboundKeepAlivePacket(var1.getId());
      if (!KeepAliveScheduler.INSTANCE.method03308(this.connection, var3)) {
         ((BotConnectionAccess)(Object)this.connection).sendPacket(var3);
      }
   }

}
