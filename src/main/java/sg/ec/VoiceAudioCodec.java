// Original binary: sg/ec/khXPNnsyo1RKwKJv
package sg.ec;

// $VF: Compiled from s
public final class VoiceAudioCodec {
   public static final int field20821 = 360;
   public static final int field20822 = 0;
   public static final int field20823 = 0;
   public static final int field20824 = 0;
   public static final int field20825 = 0;
   public static final int field20826 = 0;
   public static final int field20827 = 0;
   private static final int[] field20828 = new int[]{
      8000, 11025, 12000, 16000, 22050, 24000, 32000, VoiceAudioCodec.field20839, VoiceAudioCodec.field20840
   };
   private static final int[] field20829 = new int[]{
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      16,
      17,
      19,
      21,
      23,
      25,
      28,
      31,
      34,
      37,
      41,
      45,
      50,
      55,
      60,
      66,
      73,
      80,
      88,
      97,
      107,
      118,
      130,
      143,
      157,
      173,
      190,
      209,
      230,
      253,
      279,
      307,
      337,
      371,
      408,
      449,
      494,
      544,
      598,
      658,
      724,
      796,
      876,
      963,
      1060,
      1166,
      1282,
      1411,
      1552,
      1707,
      1878,
      2066,
      2272,
      2499,
      2749,
      3024,
      3327,
      3660,
      4026,
      4428,
      4871,
      5358,
      5894,
      6484,
      7132,
      7845,
      8630,
      9493,
      10442,
      11487,
      12635,
      13899,
      15289,
      16818,
      18500,
      20350,
      22385,
      24623,
      27086,
      29794,
      32767
   };
   private static final int[] field20830 = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
   private static final int field20831 = 48000;
   private static final long field20832 = 64L;
   private static final long field20833 = 64L;
   private static final double field20834 = 0.72;
   private static final double field20835 = 255.0;
   private static final double field20836 = 32767.0;
   private static final float field20837 = 32767.0F;
   private static final String field20838 = "This is a utility class and cannot be instantiated";
   private static final int field20839 = 44100;
   private static final int field20840 = 48000;

   public static short[] method09187(byte[] var0, int var1, int var2, int var3, int var4) {
      int var5 = var0 == null ? 0 : (var0.length - var1) / method09199(var3);
      int sx = Math.max(0, Math.min(var2, var5));
      int sxx = Math.min(var4 <= 0 ? sx * 505 : var4, sx * 505);
      short[] sxxx = new short[Math.max(0, sxx) * var3];
      if (sxxx.length == 0) {
         return sxxx;
      }

      for (int sxxxx = 0; sxxxx < var3; sxxxx++) {
         for (int sxxxxx = 0; sxxxxx < sx; sxxxxx++) {
            int sxxxxxx = var1 + (sxxxxx * var3 + sxxxx) * 256;
            int sxxxxxxx = (short)(var0[sxxxxxx] & 0xFF | (var0[sxxxxxx + 1] & 255) << 8);
            int sxxxxxxxx = method09190(var0[sxxxxxx + 2] & 255);
            int sxxxxxxxxx = sxxxxx * 505;
            if (sxxxxxxxxx < sxx) {
               sxxx[sxxxxxxxxx * var3 + sxxxx] = (short)sxxxxxxx;
            }

            int sxxxxxxxxxx = sxxxxxx + 4;

            for (int sxxxxxxxxxxx = 1; sxxxxxxxxxxx < 505; sxxxxxxxxxxx++) {
               int sxxxxxxxxxxxx = sxxxxxxxxxxx - 1;
               int sxxxxxxxxxxxxx = var0[sxxxxxxxxxx + (sxxxxxxxxxxxx >> 1)] & 255;
               int sxxxxxxxxxxxxxx = (sxxxxxxxxxxxx & 1) == 0 ? sxxxxxxxxxxxxx & 15 : sxxxxxxxxxxxxx >> 4;
               int sxxxxxxxxxxxxxxx = field20829[sxxxxxxxx];
               int sxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxx >> 3;
               if ((sxxxxxxxxxxxxxx & 4) != 0) {
                  sxxxxxxxxxxxxxxxx += sxxxxxxxxxxxxxxx;
               }

               if ((sxxxxxxxxxxxxxx & 2) != 0) {
                  sxxxxxxxxxxxxxxxx += sxxxxxxxxxxxxxxx >> 1;
               }

               if ((sxxxxxxxxxxxxxx & 1) != 0) {
                  sxxxxxxxxxxxxxxxx += sxxxxxxxxxxxxxxx >> 2;
               }

               sxxxxxxx = method09196((sxxxxxxxxxxxxxx & 8) != 0 ? sxxxxxxx - sxxxxxxxxxxxxxxxx : sxxxxxxx + sxxxxxxxxxxxxxxxx);
               sxxxxxxxx = method09190(sxxxxxxxx + field20830[sxxxxxxxxxxxxxx]);
               if (sxxxxxxxxx + sxxxxxxxxxxx < sxx) {
                  sxxx[(sxxxxxxxxx + sxxxxxxxxxxx) * var3 + sxxxx] = (short)sxxxxxxx;
               }
            }
         }
      }

      return sxxx;
   }

   private static int method09188(short[] var0, int var1, int var2, int var3, int var4) {
      return var1 < var2 ? var0[var1 * var3 + var4] : 0;
   }

   public static int method09189(int var0) {
      return Math.max(1, var0 / 5);
   }

   private static int method09190(int var0) {
      return var0 < 0 ? 0 : Math.min(var0, field20829.length - 1);
   }

   public static short method09191(float var0) {
      return method09196(Math.round(var0 * field20837));
   }

   public static int method09192(int var0) {
      return var0 <= 0 ? 0 : (var0 + 505 - 1) / 505;
   }

   public static int method09193(int var0, int var1) {
      return method09192(var0) * method09199(var1);
   }

   public static int method09194(int var0) {
      if (method09195(var0)) {
         return var0;
      }

      for (int var4 : field20828) {
         if (var0 <= var4) {
            return var4;
         }
      }

      return field20831;
   }

   public static boolean method09195(int var0) {
      for (int var4 : field20828) {
         if (var4 == var0) {
            return true;
         }
      }

      return false;
   }

   public static short method09196(int var0) {
      return (short)(var0 < -32768 ? -32768 : Math.min(var0, 32767));
   }

   public static float method09197(short[] var0, int var1, int var2) {
      long var3 = 0L;
      int var5 = 0;

      for (int var6 = Math.max(0, var1); var6 < Math.min(var2, var0.length); var6++) {
         var3 += (long)var0[var6] * var0[var6];
         var5++;
      }

      return var5 == 0 ? 0.0F : (float)Math.sqrt(Math.sqrt((double)var3 / var5) / field20836);
   }

   public static int method09198(int var0) {
      return var0 * 360;
   }

   public static int method09199(int var0) {
      return var0 * 256;
   }

   public static byte[] method09200(short[] var0, int var1, int var2) {
      int var3 = Math.min(var1, var0.length / var2);
      byte[] var4 = new byte[method09193(var3, var2)];

      for (int var5 = 0; var5 < var2; var5++) {
         int var6 = 0;

         for (int var7 = 0; var7 < method09192(var3); var7++) {
            int var8 = var7 * 505;
            int var9 = (var7 * var2 + var5) * 256;
            int var10 = method09188(var0, var8, var3, var2, var5);
            var4[var9] = (byte)var10;
            var4[var9 + 1] = (byte)(var10 >> 8);
            var4[var9 + 2] = (byte)var6;
            int var11 = var9 + 4;

            for (int var12 = 1; var12 < 505; var12++) {
               int var13 = method09188(var0, var8 + var12, var3, var2, var5);
               int var14 = field20829[var6];
               int var15 = var13 - var10;
               byte var16 = 0;
               if (var15 < 0) {
                  var16 = 8;
                  var15 = -var15;
               }

               int var17 = var14 >> 3;
               if (var15 >= var14) {
                  var16 |= 4;
                  var15 -= var14;
                  var17 += var14;
               }

               if (var15 >= var14 >> 1) {
                  var16 |= 2;
                  var15 -= var14 >> 1;
                  var17 += var14 >> 1;
               }

               if (var15 >= var14 >> 2) {
                  var16 |= 1;
                  var17 += var14 >> 2;
               }

               var10 = method09196((var16 & 8) != 0 ? var10 - var17 : var10 + var17);
               var6 = method09190(var6 + field20830[var16]);
               int var18 = var12 - 1;
               int var19 = var11 + (var18 >> 1);
               if ((var18 & 1) == 0) {
                  var4[var19] = (byte)var16;
               } else {
                  var4[var19] |= (byte)(var16 << 4);
               }
            }
         }
      }

      return var4;
   }

   private VoiceAudioCodec() {
      throw new UnsupportedOperationException(field20838);
   }

   public static short[] method09201(byte[] var0, int var1, int var2) {
      return method09187(var0, 0, method09192(var1), var2, var1);
   }

   public static byte[] method09202(short[] var0, int var1, int var2) {
      byte[] var3 = new byte[64];
      if (var0 != null && var1 > 0 && var2 > 0) {
         int var4 = Math.min(var1, var0.length / var2);
         int[] var5 = new int[64];
         int var6 = 0;

         for (int var7 = 0; var7 < 64; var7++) {
            int var8 = (int)((long)var4 * var7 / field20832);
            int var9 = (int)((long)var4 * (var7 + 1) / field20833);
            int var10 = 0;

            for (int var11 = var8; var11 < var9; var11++) {
               for (int var12 = 0; var12 < var2; var12++) {
                  var10 = Math.max(var10, Math.abs(var0[var11 * var2 + var12]));
               }
            }

            var5[var7] = var10;
            var6 = Math.max(var6, var10);
         }

         if (var6 == 0) {
            return var3;
         }

         for (int var13 = 0; var13 < 64; var13++) {
            var3[var13] = (byte)Math.min(255, (int)(Math.pow((double)var5[var13] / var6, field20834) * field20835));
         }

         return var3;
      } else {
         return var3;
      }
   }
}
