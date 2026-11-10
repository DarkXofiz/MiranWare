// Original binary: hex/api/baritone/behavior/look/ForkableRandom
package hex.api.baritone.behavior.look;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongSupplier;

// $VF: Compiled from s
public final class ForkableRandom {
   private static final double DOUBLE_UNIT = 1.110223E-16F;
   private final long[] s;
   private static final double УИ = 0;
   private static final long УП = 0;
   private static final long У_ = 0;
   private static final long Ус = 0;


   private ForkableRandom(long[] var1) {
      this.s = var1;
   }

   public ForkableRandom() {
      this(System.nanoTime() ^ System.currentTimeMillis());
   }

   public double nextDouble() {
      return (this.next() >>> 11) * УИ;
   }

   public ForkableRandom(long var1) {
      AtomicLong var3 = new AtomicLong(var1);
      LongSupplier sx = () -> {
         long sxx = var3.addAndGet(УП);
         sxx = (sxx ^ sxx >>> 30) * У_;
         sxx = (sxx ^ sxx >>> 27) * Ус;
         return sxx ^ sxx >>> 31;
      };
      this.s = new long[]{sx.getAsLong(), sx.getAsLong(), sx.getAsLong(), sx.getAsLong()};
   }

   public long next() {
      long var1 = rotl(this.s[0] + this.s[3], 23) + this.s[0];
      long sx = this.s[1] << 17;
      this.s[2] = this.s[2] ^ this.s[0];
      this.s[3] = this.s[3] ^ this.s[1];
      this.s[1] = this.s[1] ^ this.s[2];
      this.s[0] = this.s[0] ^ this.s[3];
      this.s[2] = this.s[2] ^ sx;
      this.s[3] = rotl(this.s[3], 45);
      return var1;
   }

   private static long rotl(long var0, int var2) {
      return var0 << var2 | var0 >>> 64 - var2;
   }

   public ForkableRandom fork() {
      return new ForkableRandom(Arrays.copyOf(this.s, 4));
   }
}
