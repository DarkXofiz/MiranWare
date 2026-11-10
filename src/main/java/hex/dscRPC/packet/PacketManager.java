// Original binary: hex/dscRPC/packet/PacketManager
package hex.dscRPC.packet;

import hex.dscRPC.packet.codec.PacketCodec;
import hex.dscRPC.packet.impl.frame.IncomingFramePacket;
import hex.dscRPC.packet.impl.frame.OutgoingFramePacket;
import hex.dscRPC.socket.SystemSocket;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

// $VF: Compiled from s
public class PacketManager {
   private final PacketCodec codec;
   private final PacketHandler packetHandler;
   private Thread packetReadingThread;
   private final Map<String, Consumer<IncomingFramePacket<?>>> responseConsumers;
   private final SystemSocket systemSocket;
   private static final String бЪв = "бЪв";

   public PacketManager(PacketHandler var1, SystemSocket var2) {
      this.codec = PacketCodec.from(var2);
      this.packetHandler = var1;
      this.packetReadingThread = null;
      this.responseConsumers = new HashMap<>();
      this.systemSocket = var2;
   }

   public void stopReadingIncomingPackets() {
      if (this.packetReadingThread != null) {
         this.packetReadingThread.interrupt();
         this.packetReadingThread = null;
      }
   }

   private void readPackets() {
      while (this.systemSocket.isConnected()) {
         if (Thread.currentThread().isInterrupted()) {
            return;
         }

         Packet var1;
         try {
            var1 = this.codec.read();
         } catch (Exception sx) {
            continue;
         }

         if (var1 == null) {
            this.packetHandler.handleEOF();
            return;
         }

         try {
            if (!this.notifyResponseConsumerOfPacket(var1)) {
               this.packetHandler.handlePacket(var1);
            }
         } catch (Exception var3) {
         }
      }
   }

   private boolean notifyResponseConsumerOfPacket(Packet var1) {
      if (!(var1 instanceof IncomingFramePacket var2)) {
         return false;
      } else {
         String sx = var2.uniqueId();
         if (sx == null) {
            return false;
         }

         var sxx = this.responseConsumers.remove(sx);
         if (sxx == null) {
            return false;
         }

         sxx.accept(var2);
         return true;
      }
   }

   public void startReadingIncomingPackets() {
      this.stopReadingIncomingPackets();
      this.packetReadingThread = new Thread(this::readPackets, бЪв);
      this.packetReadingThread.setDaemon(true);
      this.packetReadingThread.start();
   }

   public void sendPacket(OutgoingFramePacket<?> var1, Consumer<IncomingFramePacket<?>> var2) {
      String var3 = "jdiscordipc-packet-" + UUID.randomUUID();
      var1.setUniqueId(var3);
      this.responseConsumers.put(var3, var2);
      this.sendPacket(var1);
   }


   public void sendPacket(Packet var1) {
      try {
         this.codec.write(var1);
      } catch (IOException var3) {
      }
   }
}
