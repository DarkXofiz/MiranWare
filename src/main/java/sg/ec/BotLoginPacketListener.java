// Original binary: sg/ec/28kA4RJKn2tBktVo
package sg.ec;

import com.mojang.authlib.exceptions.AuthenticationException;
import java.math.BigInteger;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.protocol.common.ServerboundClientInformationPacket;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.BrandPayload;
import net.minecraft.network.protocol.configuration.ConfigurationProtocols;
import net.minecraft.network.protocol.cookie.ClientboundCookieRequestPacket;
import net.minecraft.network.protocol.cookie.ServerboundCookieResponsePacket;
import net.minecraft.network.protocol.login.ClientLoginPacketListener;
import net.minecraft.network.protocol.login.ClientboundCustomQueryPacket;
import net.minecraft.network.protocol.login.ClientboundHelloPacket;
import net.minecraft.network.protocol.login.ClientboundLoginCompressionPacket;
import net.minecraft.network.protocol.login.ClientboundLoginDisconnectPacket;
import net.minecraft.network.protocol.login.ClientboundLoginFinishedPacket;
import net.minecraft.network.protocol.login.ServerboundCustomQueryAnswerPacket;
import net.minecraft.network.protocol.login.ServerboundKeyPacket;
import net.minecraft.network.protocol.login.ServerboundLoginAcknowledgedPacket;
import net.minecraft.util.Crypt;
import net.minecraft.util.Util;

// $VF: Compiled from s
public final class BotLoginPacketListener implements ClientLoginPacketListener, MinecraftAccess {
   private final BotClient field00729;
   private final Connection field00730;
   private static final String field00731 = "Ошибка шифрования";
   private static final String field00732 = "Protocol error";
   private static final String field00733 = "Сервер в online-mode, нужен токен аккаунта";
   private static final String field00734 = "LOGIN";
   private static final String field00735 = "KICK-LOGIN";
   private static final String field00736 = "AUTH";

   @Override
   public void handleLoginFinished(ClientboundLoginFinishedPacket var1) {
      String.valueOf("профиль принят: " + var1.gameProfile().name());
      this.field00729.method00070().method08015(var1.gameProfile());
      this.field00729.method00070().method07959(var1.sessionId());
      this.field00729.method00074(BotConnectionState.CONFIGURING);
      this.field00730.setupInboundProtocol(ConfigurationProtocols.CLIENTBOUND, new BotConfigurationPacketListener(this.field00729, this.field00730));
      this.field00730.send(ServerboundLoginAcknowledgedPacket.INSTANCE);
      this.field00730.setupOutboundProtocol(ConfigurationProtocols.SERVERBOUND);
      this.field00730.send(new ServerboundCustomPayloadPacket(new BrandPayload(ClientBrandRetriever.getClientModName())));
      this.field00730.send(new ServerboundClientInformationPacket(ClientLanguage.method00599()));
      BotCustomPayloadCache.method09896(this.field00729.method00156(), this.field00730, ConnectionProtocol.CONFIGURATION);
   }

   @Override
   public void handleDisconnect(ClientboundLoginDisconnectPacket var1) {
      var1.reason().getString();
      this.field00729.method00126(var1.reason().getString());
      this.field00729.method00102(var1.reason().getString());
   }

   public BotLoginPacketListener(BotClient var1, Connection var2) {
      this.field00729 = var1;
      this.field00730 = var2;
   }

   @Override
   public void onDisconnect(DisconnectionDetails var1) {
      this.field00729.method00119(var1.reason().getString());
   }

   private void setEncryption(ServerboundKeyPacket var1, Cipher var2, Cipher var3) {
      this.field00730.send(var1, PacketSendListener.thenRun(() -> this.field00730.setEncryptionKey(var2, var3)));
   }

   @Override
   public void handleHello(ClientboundHelloPacket var1) {
      this.field00729.method00074(BotConnectionState.LOGGING_IN);

      Cipher var2;
      Cipher var3;
      String var4;
      ServerboundKeyPacket var5;
      try {
         SecretKey var6 = Crypt.generateSecretKey();
         PublicKey var7 = var1.getPublicKey();
         var4 = new BigInteger(Crypt.digestData(var1.getServerId(), var7, var6)).toString(16);
         var2 = Crypt.getCipher(2, var6);
         var3 = Crypt.getCipher(1, var6);
         var5 = new ServerboundKeyPacket(var6, var7, var1.getChallenge());
      } catch (Exception var8) {
         this.field00729.method00075(field00731);
         this.field00729.method00102(field00732);
         return;
      }

      if (var1.shouldAuthenticate()) {
         Util.ioPool().execute(() -> {
            String var5x = this.authenticate(var4);
            if (var5x != null) {
               this.field00729.method00075(var5x);
               this.field00729.method00102(var5x);
            } else {
               this.setEncryption(var5, var2, var3);
            }
         });
      } else {
         this.setEncryption(var5, var2, var3);
      }
   }

   @Override
   public void handleCustomQuery(ClientboundCustomQueryPacket var1) {
      this.field00730.send(new ServerboundCustomQueryAnswerPacket(var1.transactionId(), null));
   }

   private String authenticate(String var1) {
      if (!this.field00729.method00137().method00489()) {
         return field00733;
      }

      try {
         mc.services().sessionService().joinServer(this.field00729.method00137().method00494(), this.field00729.method00137().method00479(), var1);
         return null;
      } catch (AuthenticationException var3) {
         return "Сессия отклонена: " + var3.getMessage();
      }
   }

   @Override
   public void handleRequestCookie(ClientboundCookieRequestPacket var1) {
      this.field00730.send(new ServerboundCookieResponsePacket(var1.key(), this.field00729.method00168(var1.key())));
   }

   @Override
   public void handleCompression(ClientboundLoginCompressionPacket var1) {
      this.field00730.setupCompression(var1.getCompressionThreshold(), false);
   }

   @Override
   public boolean isAcceptingMessages() {
      return this.field00730.isConnected();
   }
}
