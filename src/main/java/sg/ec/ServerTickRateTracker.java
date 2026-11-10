// Original binary: sg/ec/220VSbKxH9aw4ffj
package sg.ec;

import java.util.Arrays;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public enum ServerTickRateTracker implements MinecraftAccess {
   INSTANCE;

   private final float[] field00722 = new float[20];
   private int field00723 = 0;
   private long field00724 = -1L;
   private float field00725 = 0.0F;

   public void method00346() {
      EventBus.method00263(this);
      Arrays.fill(this.field00722, 0.0F);
   }

   public float method00347() {
      float var1 = 0.0F;
      float var2 = 0.0F;

      for (float var6 : this.field00722) {
         if (var6 > 0.0F) {
            var2 += var6;
            var1++;
         }
      }

      return Mth.clamp(var2 / var1, 0.0F, 20.0F);
   }

   public void method00348() {
      if (this.field00724 != -1L) {
         float var1 = (float)(System.currentTimeMillis() - this.field00724) / 1000.0F;
         float var2 = 20.0F / var1;
         float var3 = Mth.clamp(var2, 0.0F, 20.0F);
         this.field00722[this.field00723 % this.field00722.length] = var3;
         this.field00723++;
         float var4 = 20.0F - var3;
         this.field00725 = this.field00725 * 0.9F + var4 * 0.1F;
      }

      this.field00724 = System.currentTimeMillis();
   }

   @Subscribe
   public void method00349(PacketEvent var1) {
      if (var1.method10897() instanceof ClientboundSetTimePacket) {
         this.method00348();
      }
   }

   public float[] method00350() {
      return this.field00722;
   }

   public int method00351() {
      return this.field00723;
   }

   public long method00352() {
      return this.field00724;
   }

   public float method00353() {
      return this.field00725;
   }
}
