// Original binary: sg/ec/mj7ApH4uIcYcaDeY
package sg.ec;

import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;

// $VF: Compiled from s
public final class AutoBuyAuctionRefresh implements MinecraftAccess {
   private static final long field21741 = 45L;
   private static final long field21742 = 0;
   private static final long field21743 = 0;
   private static final long field21744 = 0;
   private static final long field21745 = 0;
   private static final int field21746 = 0;
   private static final float field21747 = 0;
   private static final float field21748 = 0;
   private long field21749;
   private long field21750;
   private long field21751;
   private long field21752;
   private static final long field21753 = 50L;
   private static final long field21754 = 50L;
   private static final long field21755 = 50L;
   private static final long field21756 = 5000L;
   private static final long field21757 = 2L;
   private static final long field21758 = 50L;
   private static final double field21759 = 20.0;
   private static final long field21760 = 45L;
   private static final long field21761 = 1000L;
   private static final float field21762 = 0.6F;
   private static final float field21763 = 0.35F;
   private static final long field21764 = 45L;
   private static final long field21765 = 2000L;

   private static long method09551() {
      if (mc.player != null && mc.getConnection() != null) {
         PlayerInfo var0 = mc.getConnection().getPlayerInfo(mc.player.getUUID());
         return var0 == null ? 0L : Math.clamp(var0.getLatency(), 0L, field21765);
      } else {
         return 0L;
      }
   }

   public AutoBuyAuctionRefresh() {
      this.field21751 = field21753;
   }

   public boolean method09552(long var1) {
      if (var1 < this.field21752) {
         return false;
      }

      long var3 = method09551();
      long var5 = Math.max(this.field21751, Math.max(field21755, var3));
      this.field21752 = this.method09554(var1, var1 + var5, var3);
      return true;
   }

   public void method09553() {
      this.field21752 = 0L;
   }

   private long method09554(long var1, long var3, long var5) {
      long var7 = this.field21749;
      if (var7 != 0L && this.field21751 > 0L && var1 - var7 <= field21756) {
         long var9 = Math.floorDiv(var3 + var5 - var7 + this.field21751 / field21757, this.field21751);
         long var11 = var7 + var9 * this.field21751 - var5;
         long var13 = var1 + Math.max(field21758, this.field21751);
         if (var11 < var13) {
            var11 += Math.floorDiv(var13 - var11 + this.field21751 - 1L, this.field21751) * this.field21751;
         }

         return var11;
      } else {
         return var3;
      }
   }

   public void method09555(ClientboundSetTimePacket var1) {
      if (var1 != null) {
         long var2 = System.currentTimeMillis();
         this.field21750 = this.field21749;
         this.field21749 = var2;
         if (this.field21750 != 0L) {
            long var4 = Math.round((var2 - this.field21750) / field21759);
            if (var4 >= field21760 && var4 <= field21761) {
               float var6 = var4 > this.field21751 ? field21762 : field21763;
               this.field21751 = Math.max(field21764, Math.round((float)this.field21751 + (float)(var4 - this.field21751) * var6));
            }
         }
      }
   }

   public void method09556() {
      this.field21749 = 0L;
      this.field21750 = 0L;
      this.field21751 = field21754;
      this.field21752 = 0L;
   }
}
