// Original binary: sg/ec/Txe60Mb7Pd23nKDo
package sg.ec;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public final class ConnectionHooks {
   private final ThreadLocal<Packet<?>> field12066 = new ThreadLocal<>();
   private volatile boolean field12067 = false;

   public void method05699(boolean var1) {
      this.field12067 = var1;
      this.field12066.remove();
   }

   private static void method05701(Connection var0, Packet<?> var1) {
      if (var1 instanceof ServerboundCustomPayloadPacket var2) {
         BotCustomPayloadCache.method09898(var0, var2);
      }
   }

   public void method05702(Connection var1) {
      if (!this.field12067) {
         Connection var2 = BotConnectionAccess.method05259();
         if (var2 == var1) {
            BotConnectionAccess.method05260(null);
         }
      }
   }

   public void method05703(Connection var1, Packet<?> var2, CallbackInfo var3) {
      if (this.field12067) {
         try {
            boolean var10001 = false;
            var10001 = false;
         } catch (Throwable var5) {
         }
      } else {
         try {
            ;
         } catch (Throwable var6) {
         }

         if (var2 instanceof ClientboundBundlePacket var4) {
            var4.subPackets().forEach(var2x -> PacketEvent.field24206.method10894((Packet<?>)var2x, PacketEvent.Nested316.RECEIVE, var3, var1));
         } else {
            PacketEvent.field24206.method10894(var2, PacketEvent.Nested316.RECEIVE, var3, var1);
         }
      }
   }

   public void method05704(Connection var1, Packet<?> var2, CallbackInfo var3) {
      if (this.field12067) {
         try {
            boolean var10001 = true;
            var10001 = true;
         } catch (Throwable var5) {
         }
      } else if (this.field12066.get() == var2) {
         this.field12066.remove();
      } else {
         PacketEvent.field24206.method10894(var2, PacketEvent.Nested316.SEND, var3, var1);
         if (!var3.isCancelled()) {
            method05701(var1, var2);
         }
      }
   }

   public void method05705(Connection var1, Packet<?> var2) {
      this.field12066.set(var2);

      try {
         var1.send(var2);
      } finally {
         this.field12066.remove();
      }
   }

   public boolean method05706() {
      return this.field12067;
   }

   public void method05707(Connection var1) {
      if (!this.field12067) {
         BotConnectionAccess.method05260(var1);
      }
   }
}
