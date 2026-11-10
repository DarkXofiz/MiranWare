// Original binary: sg/ec/F2V6bpPBPSascdpR
package sg.ec;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import sg.mx.ConnectionMixin_1310;

// $VF: Compiled from s
public enum KeepAliveScheduler implements MinecraftAccess {
   INSTANCE;

   public static final int field07226 = 900;
   private static final int field07227 = 0;
   private final Set<KeepAliveScheduler.Nested92> field07228 = ConcurrentHashMap.newKeySet();
   private volatile long field07229;

   public void method03307(long var1) {
      this.field07229 = Math.min(Math.max(var1, 0L), 900L);
      if (this.field07229 == 0L) {
         this.method03310();
      }
   }

   public boolean method03308(Connection var1, ServerboundKeepAlivePacket var2) {
      long var3 = this.field07229;
      if (var3 > 0L && this.method03313(var1)) {
         KeepAliveScheduler.Nested92 var5 = new KeepAliveScheduler.Nested92(var1, var2);
         this.field07228.add(var5);
         var5.field07233 = ((ConnectionMixin_1310)(Object)var1).getChannel().eventLoop().schedule(() -> this.method03312(var5), var3, TimeUnit.MILLISECONDS);
         return true;
      } else {
         return false;
      }
   }

   public void method03309(Connection var1) {
      for (KeepAliveScheduler.Nested92 var3 : this.field07228) {
         if (var3.field07230 == var1) {
            this.method03312(var3);
         }
      }
   }

   public void method03310() {
      this.field07228.forEach(this::method03312);
   }

   public void method03311(Connection var1) {
      this.field07228.removeIf(var1x -> var1x.field07230 == var1 && var1x.method03316());
   }

   private void method03312(KeepAliveScheduler.Nested92 var1) {
      if (var1.method03316()) {
         this.field07228.remove(var1);
         if (var1.field07230.isConnected()) {
            ((BotConnectionAccess)var1.field07230).sendPacket(var1.field07231);
         }
      }
   }

   private boolean method03313(Connection var1) {
      return !mc.isLocalServer() && mc.player != null && mc.level != null && mc.player.tickCount >= 50 && !((BotConnectionAccess)var1).isBotConnection();
   }

   // $VF: Compiled from s
   private static final class Nested92 {
      private final Connection field07230;
      private final ServerboundKeepAlivePacket field07231;
      private final AtomicBoolean field07232 = new AtomicBoolean(true);
      private volatile ScheduledFuture<?> field07233;

      private Nested92(Connection var1, ServerboundKeepAlivePacket var2) {
         this.field07230 = var1;
         this.field07231 = var2;
      }

      private boolean method03316() {
         if (!this.field07232.compareAndSet(true, false)) {
            return false;
         }

         ScheduledFuture var1 = this.field07233;
         if (var1 != null) {
            var1.cancel(false);
         }

         return true;
      }
   }
}
