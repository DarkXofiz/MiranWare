// Original binary: sg/ec/GSnnsAX95o9id7am
package sg.ec;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ServerboundPongPacket;
import net.minecraft.network.protocol.game.ServerboundChunkBatchReceivedPacket;
import net.minecraft.network.protocol.ping.ServerboundPingRequestPacket;
import net.minecraft.network.protocol.status.ServerboundStatusRequestPacket;

// $VF: Compiled from s
public enum PacketBufferManager implements MinecraftAccess {
   INSTNCE;

   private static final String field07991 = "default";
   private static final String field07992 = "field07992";
   private static final ScheduledExecutorService field07993 = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1 = new Thread(var0, "BlinkUtils-NetworkStop");
      var1.setDaemon(true);
      return var1;
   });
   private final List<PacketBufferManager.Nested105> field07994 = new CopyOnWriteArrayList<>();
   private volatile String field07995 = null;
   private volatile long field07996 = 0L;
   private volatile long field07997 = 0L;

   public void method03599() {
      EventBus.method00263(this);
   }

   @Subscribe
   private void method03600(WorldLoadEvent var1) {
      this.method03601();
   }

   public synchronized void method03601() {
      this.field07995 = null;
      this.field07996 = 0L;
      this.field07994.clear();
   }

   @Subscribe
   private void method03602(PacketEvent var1) {
      if (!this.method03617()) {
         if (this.method03607()) {
            if (!this.method03618(var1.method10897())) {
               if (this.method03614()) {
                  if (this.method03615()) {
                     this.method03610();
                  } else {
                     var1.method05695(true);
                  }
               } else if (var1.method10902() != PacketEvent.Nested316.RECEIVE) {
                  this.field07994.add(new PacketBufferManager.Nested105(var1.method10901(), var1.method10897()));
                  var1.method05695(true);
               }
            }
         }
      }
   }

   public boolean method03603() {
      return this.method03604("default");
   }

   public synchronized boolean method03604(String var1) {
      String var2 = this.method03616(var1);
      if (this.field07995 == null) {
         this.field07995 = var2;
         return true;
      } else {
         return this.field07995.equals(var2);
      }
   }

   public void method03605() {
      this.method03606("default");
   }

   public void method03606(String var1) {
      boolean var2 = "network_stop".equals(this.method03616(var1));
      if (this.method03613(var1)) {
         if (!var2 && !this.field07994.isEmpty() && !this.method03617()) {
            this.field07994.forEach(PacketBufferManager.Nested105::release);
         }

         this.field07994.clear();
      }
   }

   public boolean method03607() {
      return this.field07995 != null;
   }

   public String method03608() {
      return this.field07995;
   }

   public void method03609(long var1) {
      long var3 = Math.max(1L, var1);
      long var5;
      synchronized (this) {
         this.field07995 = "network_stop";
         this.field07994.clear();
         this.field07996 = System.currentTimeMillis() + var3;
         var5 = ++this.field07997;
      }

      field07993.schedule(() -> this.method03612(var5), var3, TimeUnit.MILLISECONDS);
   }

   public void method03610() {
      this.method03612(-1L);
   }

   public boolean method03611() {
      if (!this.method03614()) {
         return false;
      } else if (this.method03615()) {
         this.method03610();
         return false;
      } else {
         return true;
      }
   }

   private void method03612(long var1) {
      synchronized (this) {
         if (this.method03614()) {
            if (var1 < 0L || var1 == this.field07997) {
               this.field07995 = null;
               this.field07996 = 0L;
               this.field07994.clear();
            }
         }
      }
   }

   private synchronized boolean method03613(String var1) {
      String var2 = this.method03616(var1);
      if (this.field07995 != null && this.field07995.equals(var2)) {
         this.field07995 = null;
         if ("network_stop".equals(var2)) {
            this.field07996 = 0L;
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean method03614() {
      return "network_stop".equals(this.field07995);
   }

   private boolean method03615() {
      return this.field07996 > 0L && System.currentTimeMillis() >= this.field07996;
   }

   private String method03616(String var1) {
      String var2 = Objects.requireNonNullElse(var1, "default").trim();
      return var2.isEmpty() ? "default" : var2;
   }

   private boolean method03617() {
      return mc.isLocalServer() ? true : mc.player == null || mc.level == null;
   }

   private boolean method03618(Packet<?> var1) {
      return var1 instanceof ServerboundStatusRequestPacket
         || var1 instanceof ServerboundPingRequestPacket
         || var1 instanceof ServerboundKeepAlivePacket
         || var1 instanceof ServerboundChunkBatchReceivedPacket
         || var1 instanceof ServerboundPongPacket;
   }

   // $VF: Compiled from s
   private record Nested105(Connection connection, Packet<?> packet) {
      private void release() {
         if (this.connection != null && this.connection.isConnected()) {
            if (this.connection instanceof BotConnectionAccess var1) {
               var1.sendPacket(this.packet);
            }
         }
      }
   }
}
