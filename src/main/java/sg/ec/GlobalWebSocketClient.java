// Original binary: sg/ec/SsmAE1SSza3xl421
package sg.ec;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Function;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public class GlobalWebSocketClient extends WebSocketClient {
   private final GlobalPlayer field11957;
   private final GlobalPacketRegistry field11958;
   private final String field11959;
   private static final String field11960 = "UNKNOWN";
   private static final String field11961 = "Пользователь";
   private static final String field11962 = "Пользователь";
   private static final String field11963 = "Handshake failed";
   private static final String field11964 = "Unexpected text frame";
   private static final String field11965 = "Handshake failed";
   private static final String field11966 = "globals-player";

   public String getRole() {
      return this.field11959;
   }

   public GlobalWebSocketClient(URI var1, Function<GlobalWebSocketClient, AbstractGlobalPacketHandler> var2, String var3) {
      this(var1, var2, var3, var3);
   }

   public GlobalPacketRegistry getManager() {
      return this.field11958;
   }

   public GlobalWebSocketClient(
      URI var1,
      Function<GlobalWebSocketClient, AbstractGlobalPacketHandler> var2,
      String var3,
      String var4,
      String var5,
      String var6,
      boolean var7,
      String var8,
      String var9
   ) {
      super(var1);
      this.setConnectionLostTimeout(0);
      this.setTcpNoDelay(true);
      this.field11958 = new GlobalPacketRegistry((AbstractGlobalPacketHandler)var2.apply(this));
      this.field11957 = new GlobalPlayer(var3, var4, createStableUuid(var3), var5);
      this.field11959 = var6 == null ? field11962 : var6;
      if (var8 == null) {
         String var10001 = "";
      }

      if (var9 == null) {
         String var10 = "";
      }
   }

   @Override
   public void onOpen(ServerHandshake var1) {
      this.field11958.method01835();
      byte[] var2 = this.field11958.method01861();
      if (var2 == null) {
         this.closeConnection(4009, field11963);
      } else {
         this.send(var2);
      }
   }

   public GlobalWebSocketClient(
      URI var1, Function<GlobalWebSocketClient, AbstractGlobalPacketHandler> var2, String var3, String var4, String var5, String var6, boolean var7, String var8
   ) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, "");
   }

   public GlobalWebSocketClient(URI var1, Function<GlobalWebSocketClient, AbstractGlobalPacketHandler> var2, String var3, String var4, String var5) {
      this(var1, var2, var3, var4, var5, field11961, false, "", "");
   }

   public void refreshIdentity() {
      String var1 = ProfileAPI.get().getModel().getName();
      if (var1 != null && !var1.isBlank() && !var1.equals(this.field11957.method07586())) {
         this.field11957.method07568(var1);
      }

      String var2 = MinecraftAccess.mc != null && MinecraftAccess.mc.getUser() != null ? MinecraftAccess.mc.getUser().getName() : null;
      if (var2 != null && !var2.isBlank() && !var2.equals(this.field11957.method07580())) {
         this.field11957.method07567(var2);
      }

      String var3 = GlobalConnectionManager.field08653;
      if (var3 != null && !var3.isBlank() && !var3.equals(this.field11957.method07584())) {
         this.field11957.method07577(var3);
      }

      if (MinecraftAccess.mc != null && MinecraftAccess.mc.player != null) {
         this.field11957.method07582().field03984 = (float)MinecraftAccess.mc.player.getX();
         this.field11957.method07582().field03985 = (float)MinecraftAccess.mc.player.getY();
         this.field11957.method07582().field03986 = (float)MinecraftAccess.mc.player.getZ();
      } else {
         this.field11957.method07582().field03984 = Float.NaN;
         this.field11957.method07582().field03985 = Float.NaN;
         this.field11957.method07582().field03986 = Float.NaN;
      }
   }

   @Override
   public void onClose(int var1, String var2, boolean var3) {
      this.field11958.method01811();
      GlobalConnectionManager.method03855();
   }

   @Override
   public void onMessage(ByteBuffer var1) {
      if (this.field11958.method01877()) {
         if (!this.field11958.method01783(var1)) {
            this.closeConnection(4009, field11965);
         } else {
            this.refreshIdentity();
            this.field11958.method01823(new JoinC2SPacket(this.field11957, this.field11959, false, null, null));
            OnlinePlayerState.INSTANCE.method09291();
            if (!GlobalConnectionManager.method03845()) {
               this.field11958.method01858();
            }
         }
      } else {
         this.field11958.method01794(var1);
      }
   }

   private static String createStableUuid(String var0) {
      String var1 = var0 == null ? field11966 : var0.trim().toLowerCase(Locale.ROOT);
      return UUID.nameUUIDFromBytes(("globals:" + var1).getBytes(StandardCharsets.UTF_8)).toString();
   }

   public GlobalWebSocketClient(URI var1, Function<GlobalWebSocketClient, AbstractGlobalPacketHandler> var2, String var3, String var4) {
      this(var1, var2, var3, var4, field11960);
   }

   @Override
   public void onError(Exception var1) {
      this.field11958.method01811();
      GlobalConnectionManager.method03856();
   }

   public GlobalPlayer getClientPlayer() {
      return this.field11957;
   }

   @Override
   public void onMessage(String var1) {
      this.closeConnection(4009, field11964);
   }
}
