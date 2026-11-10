// Original binary: hex/dscRPC/JDiscordIPC
package hex.dscRPC;

import hex.dscRPC.activity.ActivityManager;
import hex.dscRPC.activity.model.Activity;
import hex.dscRPC.builder.JDiscordIPCBuilder;
import hex.dscRPC.event.DiscordEventListener;
import hex.dscRPC.event.model.Event;
import hex.dscRPC.event.model.ReadyEvent;
import hex.dscRPC.exception.JDiscordIPCException;
import hex.dscRPC.internal.util.CollectionsUtil;
import hex.dscRPC.internal.util.SystemUtil;
import hex.dscRPC.packet.Packet;
import hex.dscRPC.packet.PacketHandler;
import hex.dscRPC.packet.PacketManager;
import hex.dscRPC.packet.impl.HandshakePacket;
import hex.dscRPC.packet.impl.PingPacket;
import hex.dscRPC.packet.impl.PongPacket;
import hex.dscRPC.packet.impl.frame.incoming.DispatchEventPacket;
import hex.dscRPC.socket.SystemSocket;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

// $VF: Compiled from s
public class JDiscordIPC implements DiscordEventListener, PacketHandler {
   private static final Set<String> EXTRA_DISCORD_TEMP_PATHS = CollectionsUtil.setOf(
      JDiscordIPC.衣3, JDiscordIPC.衣Ь, JDiscordIPC.衣1, JDiscordIPC.衣я, JDiscordIPC.衣I
   );
   private JDiscordIPCState state;
   private final ActivityManager activityManager;
   private final long clientId;
   private final List<DiscordEventListener> eventListeners;
   private final PacketManager packetManager;
   private final ReconnectPolicy reconnectPolicy;
   private final SystemSocket systemSocket;
   private static final String 衣Ф = "衣Ф";
   private static final String 衣3 = "衣3";
   private static final String 衣Ь = "衣Ь";
   private static final String 衣1 = "衣1";
   private static final String 衣я = "衣я";
   private static final String 衣I = "衣I";

   @Override
   public void handleEOF() {
      this.state = JDiscordIPCState.DISCONNECTED;
      if (this.reconnectPolicy == ReconnectPolicy.NEVER) {
         this.packetManager.stopReadingIncomingPackets();

         try {
            this.systemSocket.close();
         } catch (IOException var2) {
         }
      }
   }

   public void connect() throws JDiscordIPCException.DiscordClientUnavailableException {
      this.connect(ConnectOptions.builder().build());
   }

   private Path getIpcFilePath(ConnectOptions var1, Path var2) {
      Integer var3 = var1.socketIndex();
      if (var3 != null) {
         Path sx = var2.resolve("discord-ipc-" + var3);
         return Files.exists(sx) ? sx : null;
      }

      for (int sx = 0; sx <= 9; sx++) {
         Path sxx = var2.resolve("discord-ipc-" + sx);
         if (Files.exists(sxx)) {
            return sxx;
         }
      }

      return null;
   }

   public JDiscordIPCState state() {
      return this.state;
   }

   public void disconnect() {
      this.state = JDiscordIPCState.DISCONNECTED;
      this.packetManager.stopReadingIncomingPackets();

      try {
         this.systemSocket.close();
      } catch (IOException var2) {
      }
   }

   private Path getIpcFilePath(ConnectOptions var1) throws JDiscordIPCException.DiscordClientUnavailableException {
      Path var3 = var1.temporaryDirectory();
      Path sx;
      if (var3 != null) {
         sx = var3;
      } else if (SystemUtil.isWindows()) {
         sx = Paths.get(衣Ф);
      } else {
         sx = SystemUtil.getTemporaryDirectory();
      }

      Stream<Path> sxx;
      if (SystemUtil.isWindows()) {
         sxx = Stream.of(sx);
      } else {
         sxx = Stream.concat(Stream.of(sx), EXTRA_DISCORD_TEMP_PATHS.stream().map(sx::resolve));
      }

      Path sxxx = sxx.map(var2x -> this.getIpcFilePath(var1, var2x)).filter(Objects::nonNull).findFirst().orElse(null);
      if (sxxx != null) {
         return sxxx;
      } else {
         throw new JDiscordIPCException.DiscordClientUnavailableException(null);
      }
   }

   public void connect(ConnectOptions var1) throws JDiscordIPCException.DiscordClientUnavailableException {
      try {
         this.state = JDiscordIPCState.CONNECTING;
         Path var2 = this.getIpcFilePath(var1);
         this.systemSocket.connect(var2);
         this.packetManager.sendPacket(new HandshakePacket(this.clientId));
         this.packetManager.startReadingIncomingPackets();
      } catch (IOException var3) {
         this.state = JDiscordIPCState.DISCONNECTED;
         throw new JDiscordIPCException.DiscordClientUnavailableException(var3);
      }
   }


   public JDiscordIPC(long var1, ReconnectPolicy var3, SystemSocket var4) {
      this.clientId = var1;
      this.reconnectPolicy = var3;
      this.state = JDiscordIPCState.DISCONNECTED;
      this.systemSocket = var4;
      this.eventListeners = new ArrayList<>();
      this.eventListeners.add(this);
      this.packetManager = new PacketManager(this, this.systemSocket);
      this.activityManager = new ActivityManager(this, this.packetManager);
   }

   @Override
   public void onReadyEvent(ReadyEvent var1) {
      this.state = JDiscordIPCState.READY;
   }

   @Override
   public void handlePacket(Packet var1) {
      if (var1 instanceof PingPacket) {
         var var2 = ((PingPacket)var1).properties();
         this.packetManager.sendPacket(new PongPacket(var2));
      } else if (var1 instanceof DispatchEventPacket) {
         Event var5 = ((DispatchEventPacket)var1).data();

         try {
            this.eventListeners.forEach(var1x -> var1x.onEvent(var5));
         } catch (Exception var4) {
         }
      }
   }

   public static JDiscordIPCBuilder builder(long var0) {
      return new JDiscordIPCBuilder(var0);
   }

   public void registerEventListener(DiscordEventListener var1) {
      this.eventListeners.add(var1);
   }

   public void updateActivity(Activity var1) {
      this.activityManager.updateActivity(var1);
   }
}
