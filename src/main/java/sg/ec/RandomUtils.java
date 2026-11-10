// Original binary: sg/ec/rdWTHq7UAZSmXrDz
package sg.ec;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

// $VF: Compiled from s
public final class RandomUtils {
   private static final long field23402 = -7046029254386353131L;
   private static final SecureRandom field23403 = method10440();
   private static final AtomicLong field23404 = new AtomicLong(method10441(System.nanoTime() ^ System.currentTimeMillis()));
   private static final ThreadLocal<RandomUtils.Nested302> field23405 = ThreadLocal.withInitial(RandomUtils.Nested302::new);
   private static final String field23406 = "bound must be > 0";
   private static final String field23407 = "bound must be greater than origin";
   private static final double field23408 = 1.110223E-16F;
   private static final String field23409 = "bound must be greater than origin";
   private static final String field23410 = "bound must be greater than origin";
   private static final double field23411 = Double.MIN_NORMAL;
   private static final double field23412 = -2.0;
   private static final double field23413 = Math.PI * 2;
   private static final String field23414 = "standardDeviation must be > 0 and arguments must not be NaN";
   private static final String field23415 = "size must be >= 0";
   private static final String field23416 = "target";
   private static final long field23417 = -7046029254386353131L;
   private static final String field23418 = "target";
   private static final long field23419 = -4658895280553007687L;
   private static final long field23420 = -7723592293110705685L;
   private static final String field23421 = "This is a utility class and cannot be instantiated";

   public static double method10437() {
      return (method10455() >>> 11) * field23408;
   }

   public static void method10438(byte[] var0) {
      Objects.requireNonNull(var0, field23418);
      field23403.nextBytes(var0);
   }

   public static int method10439() {
      return (int)method10455();
   }

   private static SecureRandom method10440() {
      try {
         return SecureRandom.getInstanceStrong();
      } catch (NoSuchAlgorithmException var1) {
         return new SecureRandom();
      }
   }

   private static long method10441(long var0) {
      var0 = (var0 ^ var0 >>> 30) * field23419;
      var0 = (var0 ^ var0 >>> 27) * field23420;
      return var0 ^ var0 >>> 31;
   }

   public static float method10442() {
      return (float)method10437();
   }

   public static double method10443(double var0, double var2) {
      if (var2 > 0.0 && !Double.isNaN(var0) && !Double.isNaN(var2)) {
         return var0 + var2 * method10450();
      } else {
         throw new IllegalArgumentException(field23414);
      }
   }

   private RandomUtils() {
      throw new UnsupportedOperationException(field23421);
   }

   public static byte[] method10444(int var0) {
      if (var0 < 0) {
         throw new IllegalArgumentException(field23415);
      }

      byte[] var1 = new byte[var0];
      method10446(var1);
      return var1;
   }

   public static int method10445(int var0, int var1) {
      return (int)method10448(var0, var1);
   }

   public static void method10446(byte[] var0) {
      Objects.requireNonNull(var0, field23416);
      field23403.nextBytes(var0);
      long var1 = method10452();

      for (int var3 = 0; var3 < var0.length; var3++) {
         var1 = method10441(var1 + field23417 + var3);
         var0[var3] ^= (byte)var1;
      }
   }

   public static double method10447(double var0, double var2) {
      if (var0 >= var2) {
         throw new IllegalArgumentException(field23409);
      } else {
         return var0 + (var2 - var0) * method10437();
      }
   }

   public static long method10448(long var0, long var2) {
      if (var0 >= var2) {
         throw new IllegalArgumentException(field23407);
      }

      long var4 = method10455();
      long var6 = var2 - var0;
      long var8 = var6 - 1L;
      if ((var6 & var8) == 0L) {
         var4 = (var4 & var8) + var0;
      } else if (var6 > 0L) {
         var4 += var0;
      } else {
         while (var4 < var0 || var4 >= var2) {
            var4 = method10455();
         }
      }

      return var4;
   }

   public static long method10449(long var0) {
      if (var0 <= 0L) {
         throw new IllegalArgumentException(field23406);
      }

      long var2 = method10455();
      long var4 = var0 - 1L;
      if ((var0 & var4) == 0L) {
         return var2 & var4;
      }

      long var6 = var2 >>> 1;

      while (var6 + var4 - (var2 = var6 % var0) < 0L) {
         var6 = method10455() >>> 1;
      }

      return var2;
   }

   public static double method10450() {
      RandomUtils.Nested302 var0 = field23405.get();
      if (var0.field23422) {
         var0.field23422 = false;
         return var0.field23423;
      }

      double var1;
      do {
         var1 = method10437();
      } while (var1 <= field23411);

      double var3 = method10437();
      double var5 = Math.sqrt(field23412 * Math.log(var1));
      double var7 = field23413 * var3;
      var0.field23423 = var5 * Math.sin(var7);
      var0.field23422 = true;
      return var5 * Math.cos(var7);
   }

   public static boolean method10451() {
      return (method10455() & 1L) == 1L;
   }

   public static long method10452() {
      long var0 = field23404.getAndIncrement();
      long var2 = System.nanoTime();
      long var4 = System.currentTimeMillis();
      long var6 = Thread.currentThread().threadId();
      long var8 = Runtime.getRuntime().freeMemory() << 7 ^ Runtime.getRuntime().totalMemory();
      long var10 = System.identityHashCode(Thread.currentThread());
      return method10441(var0 ^ Long.rotateLeft(var2, 17) ^ Long.rotateLeft(var4, 41) ^ var6 << 32 ^ var8 ^ var10);
   }

   public static int method10453(int var0) {
      return (int)method10449(var0);
   }

   public static float method10454(float var0, float var1) {
      if (var0 >= var1) {
         throw new IllegalArgumentException(field23410);
      } else {
         return var0 + (var1 - var0) * method10442();
      }
   }

   public static long method10455() {
      return method10441(field23403.nextLong() ^ method10452());
   }

   // $VF: Compiled from s
   private static final class Nested302 {
      private boolean field23422;
      private double field23423;
   }
}
