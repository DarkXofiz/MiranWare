// Original binary: sg/ec/ZVZZNqK26NiElAP7
package sg.ec;

// $VF: Compiled from s
public class ResourceByteCodec {
   private static final int[] field15532 = new int[]{3, 0, 5, 7, 5};
   private static final byte field15533 = -73;
   private static final byte field15534 = 0;
   private static final byte field15535 = 0;
   private static final byte field15536 = 0;
   private static final byte field15537 = 0;
   private static final int field15538 = 0;
   private static final long field15539 = 0;
   private static final long field15540 = 0;
   private static final long field15541 = 0;
   private static final long field15542 = 255L;
   private static final long field15543 = 255L;
   private static final long field15544 = 7L;
   private static final long field15545 = 255L;
   private static final long field15546 = 255L;
   private static final long field15547 = 7L;
   private static final long field15548 = 255L;
   private static final long field15549 = -7046029254386353131L;
   private static final long field15550 = 81985529216486895L;
   private static final long field15551 = -7046029254386353131L;
   private static final long field15552 = -3335678366873096957L;
   private static final long field15553 = -6510615555426900571L;
   private static final long field15554 = 255L;

   private static long method06873(byte[] var0, int var1) {
      long var2 = 0L;

      for (int sx = 0; sx < 8; sx++) {
         var2 = var2 << 8 | var0[var1 + 5 + sx] & field15548;
      }

      return var2;
   }

   public static byte[] method06874(byte[] var0) {
      return var0 != null && var0.length != 0 ? method06879(var0, 0, var0.length) : var0;
   }

   private static byte[] method06875(byte[] var0) {
      int var1 = var0.length;
      long var2 = method06885(var0);
      int[] var4 = method06883(var2);
      byte[] var5 = new byte[13 + var1];
      method06876(var5, var2);
      long var6 = var2;
      int var8 = method06882(var2);

      for (int var9 = 0; var9 < var1; var9++) {
         var6 = method06877(var6);
         int var10 = (int)(var6 & field15542);
         int var11 = (int)(var6 >>> 8 & field15543);
         int var12 = (int)(var6 >>> 16 & field15544);
         int var13 = var4[var0[var9] & 0xFF];
         var13 = var13 + var11 + (var9 & 0xFF) & 0xFF;
         var13 = method06881(var13, var12);
         var13 ^= var10;
         int var14 = var13 ^ var8 & 0xFF;
         var5[13 + var9] = (byte)var14;
         var8 = var14;
      }

      return var5;
   }

   private static void method06876(byte[] var0, long var1) {
      var0[0] = -73;
      var0[1] = 47;
      var0[2] = -95;
      var0[3] = 92;
      var0[4] = 2;
      var0[5] = (byte)(var1 >>> 56);
      var0[6] = (byte)(var1 >>> 48);
      var0[7] = (byte)(var1 >>> 40);
      var0[8] = (byte)(var1 >>> 32);
      var0[9] = (byte)(var1 >>> 24);
      var0[10] = (byte)(var1 >>> 16);
      var0[11] = (byte)(var1 >>> 8);
      var0[12] = (byte)var1;
   }

   private static long method06877(long var0) {
      var0 ^= var0 << 13;
      var0 ^= var0 >>> 7;
      return var0 ^ var0 << 17;
   }

   public static byte[] method06878(byte[] var0) {
      return var0 != null && var0.length != 0 ? method06875(var0) : var0;
   }

   public static byte[] method06879(byte[] var0, int var1, int var2) {
      if (var0 == null || var2 <= 0) {
         return new byte[0];
      } else {
         return method06884(var0, var1, var2) ? method06886(var0, var1, var2) : method06887(var0, var1, var2, false);
      }
   }

   private static int[] method06880(int[] var0) {
      int[] var1 = new int[256];
      int var2 = 0;

      while (var2 < 256) {
         var1[var0[var2]] = var2++;
      }

      return var1;
   }

   private static int method06881(int var0, int var1) {
      var0 &= 255;
      return (var0 << var1 | var0 >>> 8 - var1) & 0xFF;
   }

   private static int method06882(long var0) {
      long var2 = method06877(var0 ^ field15553);
      return (int)(var2 & field15554);
   }

   private static int[] method06883(long var0) {
      int[] var2 = new int[256];
      int var3 = 0;

      while (var3 < 256) {
         var2[var3] = var3++;
      }

      long var8 = var0 ^ field15551;
      if (var8 == 0L) {
         var8 = field15552;
      }

      for (int var5 = 255; var5 > 0; var5--) {
         var8 = method06877(var8);
         int var6 = (int)((var8 >>> 11) % (var5 + 1));
         int var7 = var2[var5];
         var2[var5] = var2[var6];
         var2[var6] = var7;
      }

      return var2;
   }

   private static boolean method06884(byte[] var0, int var1, int var2) {
      if (var2 < 13) {
         return false;
      } else if (var1 < 0 || var1 + 13 > var0.length) {
         return false;
      } else if (var0[var1] != -73) {
         return false;
      } else if (var0[var1 + 1] != 47) {
         return false;
      } else if (var0[var1 + 2] != -95) {
         return false;
      } else {
         return var0[var1 + 3] != 92 ? false : var0[var1 + 4] == 2;
      }
   }

   private static long method06885(byte[] var0) {
      long var1 = System.nanoTime();
      var1 ^= (long)System.identityHashCode(var0) << 21;
      var1 ^= var0.length * field15549;
      var1 ^= var1 >>> 33;
      if (var1 == 0L) {
         var1 = field15550;
      }

      return var1;
   }

   private static byte[] method06886(byte[] var0, int var1, int var2) {
      int var3 = var2 - 13;
      if (var3 < 0) {
         return new byte[0];
      }

      long var4 = method06873(var0, var1);
      int[] var6 = method06883(var4);
      int[] var7 = method06880(var6);
      byte[] var8 = new byte[var3];
      long var9 = var4;
      int var11 = method06882(var4);
      int var12 = var1 + 13;

      for (int var13 = 0; var13 < var3; var13++) {
         var9 = method06877(var9);
         int var14 = (int)(var9 & field15545);
         int var15 = (int)(var9 >>> 8 & field15546);
         int var16 = (int)(var9 >>> 16 & field15547);
         int var17 = var0[var12 + var13] & 255;
         int var18 = var17 ^ var11 & 0xFF;
         var11 = var17;
         var18 ^= var14;
         var18 = method06888(var18, var16);
         var18 = var18 - var15 - (var13 & 0xFF) & 0xFF;
         var8[var13] = (byte)var7[var18 & 0xFF];
      }

      return var8;
   }

   private static byte[] method06887(byte[] var0, int var1, int var2, boolean var3) {
      byte[] var4 = new byte[var2];
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;

      for (int var10 = 0; var10 < var2; var10++) {
         int var11 = var5 + var8;
         int var12 = field15532[var7];
         int var13 = var0[var1 + var10] & 255;
         var4[var10] = var3 ? (byte)(var13 + var11 & 0xFF ^ var9 ^ var12) : (byte)((var13 ^ var12 ^ var9) - var11 & 0xFF);
         int var14 = var11 + var6;

         while (var14 >= 7) {
            var14 -= 7;
         }

         var8 += var14;

         while (var8 >= 3) {
            var8 -= 3;
         }

         var9 += var14;
         if (var9 >= 255) {
            var9 -= 255;
         }

         if (++var5 == 10) {
            var5 = 0;
         }

         if (++var6 == 7) {
            var6 = 0;
         }

         if (++var7 == 5) {
            var7 = 0;
         }
      }

      return var4;
   }

   private static int method06888(int var0, int var1) {
      var0 &= 255;
      return (var0 >>> var1 | var0 << 8 - var1) & 0xFF;
   }
}
