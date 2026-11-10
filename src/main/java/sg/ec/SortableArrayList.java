// Original binary: sg/ec/10YpjiI7tEgU57o7
package sg.ec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

// $VF: Compiled from s
public class SortableArrayList<T> extends ArrayList<T> {
   private static final String field00451 = "keyExtractor cannot be null";
   private static final int field00452 = Integer.MIN_VALUE;
   private static final String field00453 = "keyExtractor cannot be null";
   private static final long field00454 = Long.MIN_VALUE;
   private static final long field00455 = 255L;
   private static final long field00456 = 255L;
   private static final String field00457 = "keyExtractor cannot be null";
   private static final String field00458 = "keyExtractor cannot be null";
   private static final String field00459 = "radixSortLsdStrings does not support null keys";
   private static final int field00460 = 65537;
   private static final String field00461 = "radixSortLsdStrings does not support null elements";
   private static final long field00462 = Long.MAX_VALUE;
   private static final String field00463 = "radixSortLsdIntegers does not support null elements";

   public SortableArrayList(int var1) {
      super(var1);
   }

   public void method00232(ToLongFunction<? super T> var1) {
      if (var1 == null) {
         throw new IllegalArgumentException(field00453);
      }

      if (this.size() >= 2) {
         Object[] var2 = this.toArray();
         int var3 = var2.length;
         long[] var4 = new long[var3];

         for (int var5 = 0; var5 < var3; var5++) {
            T var6 = (T) var2[var5];
            var4[var5] = var1.applyAsLong(var6) ^ field00454;
         }

         Object[] var14 = new Object[var3];
         long[] var15 = new long[var3];
         int[] var7 = new int[256];

         for (byte var8 = 0; var8 < 64; var8 += 8) {
            Arrays.fill(var7, 0);

            for (long var12 : var4) {
               var7[(int)(var12 >>> var8 & field00455)]++;
            }

            for (int var17 = 1; var17 < var7.length; var17++) {
               var7[var17] += var7[var17 - 1];
            }

            for (int var18 = var3 - 1; var18 >= 0; var18--) {
               long var21 = var4[var18];
               int var23 = (int)(var21 >>> var8 & field00456);
               int var13 = --var7[var23];
               var14[var13] = var2[var18];
               var15[var13] = var21;
            }

            Object[] var19 = var2;
            var2 = var14;
            var14 = var19;
            long[] var22 = var4;
            var4 = var15;
            var15 = var22;
         }

         for (int var16 = 0; var16 < var3; var16++) {
            Object var20 = var2[var16];
            this.set(var16, (T)(Object)var20);
         }
      }
   }

   public void method00234(ToDoubleFunction<? super T> var1) {
      if (var1 == null) {
         throw new IllegalArgumentException(field00457);
      }

      this.method00232(var1x -> {
         double var2 = var1.applyAsDouble((T)(Object)var1x);
         long sx = Double.doubleToRawLongBits(var2);
         return sx ^ sx >> 63 & field00462;
      });
   }

   public SortableArrayList(Collection<? extends T> var1) {
      super(var1);
   }

   public void method00235(ToIntFunction<? super T> var1) {
      if (var1 == null) {
         throw new IllegalArgumentException(field00451);
      }

      if (this.size() >= 2) {
         Object[] var2 = this.toArray();
         int var3 = var2.length;
         int[] var4 = new int[var3];

         for (int var5 = 0; var5 < var3; var5++) {
            T var6 = (T) var2[var5];
            var4[var5] = var1.applyAsInt(var6) ^ field00452;
         }

         Object[] var13 = new Object[var3];
         int[] var14 = new int[var3];
         int[] var7 = new int[256];

         for (byte var8 = 0; var8 < 32; var8 += 8) {
            Arrays.fill(var7, 0);

            for (int var12 : var4) {
               var7[var12 >>> var8 & 0xFF]++;
            }

            for (int var16 = 1; var16 < var7.length; var16++) {
               var7[var16] += var7[var16 - 1];
            }

            for (int var17 = var3 - 1; var17 >= 0; var17--) {
               int var20 = var4[var17];
               int var22 = var20 >>> var8 & 0xFF;
               int var23 = --var7[var22];
               var13[var23] = var2[var17];
               var14[var23] = var20;
            }

            Object[] var18 = var2;
            var2 = var13;
            var13 = var18;
            int[] var21 = var4;
            var4 = var14;
            var14 = var21;
         }

         for (int var15 = 0; var15 < var3; var15++) {
            Object var19 = var2[var15];
            this.set(var15, (T)(Object)var19);
         }
      }
   }

   public void method00236() {
      this.method00235(var0 -> {
         if (var0 == null) {
            throw new IllegalStateException(field00463);
         } else if (!(var0 instanceof Integer)) {
            throw new IllegalStateException("radixSortLsdIntegers requires Integer elements, but found: " + var0.getClass().getName());
         } else {
            return (Integer)var0;
         }
      });
   }

   public void method00237(Function<? super T, String> var1) {
      if (var1 == null) {
         throw new IllegalArgumentException(field00458);
      }

      if (this.size() >= 2) {
         Object[] var2 = this.toArray();
         int var3 = var2.length;
         String[] var4 = new String[var3];
         int var5 = 0;

         for (int var6 = 0; var6 < var3; var6++) {
            T var7 = (T) var2[var6];
            String var8 = (String)var1.apply(var7);
            if (var8 == null) {
               throw new IllegalStateException(field00459);
            }

            var4[var6] = var8;
            if (var8.length() > var5) {
               var5 = var8.length();
            }
         }

         if (var5 != 0) {
            Object[] var14 = new Object[var3];
            String[] var15 = new String[var3];
            int[] var16 = new int[field00460];

            for (int var9 = var5 - 1; var9 >= 0; var9--) {
               Arrays.fill(var16, 0);

               for (int var10 = 0; var10 < var3; var10++) {
                  String var11 = var4[var10];
                  int var12 = var9 < var11.length() ? var11.charAt(var9) + 1 : 0;
                  var16[var12]++;
               }

               for (int var18 = 1; var18 < var16.length; var18++) {
                  var16[var18] += var16[var18 - 1];
               }

               for (int var19 = var3 - 1; var19 >= 0; var19--) {
                  String var22 = var4[var19];
                  int var24 = var9 < var22.length() ? var22.charAt(var9) + 1 : 0;
                  int var13 = --var16[var24];
                  var14[var13] = var2[var19];
                  var15[var13] = var22;
               }

               Object[] var20 = var2;
               var2 = var14;
               var14 = var20;
               String[] var23 = var4;
               var4 = var15;
               var15 = var23;
            }

            for (int var17 = 0; var17 < var3; var17++) {
               Object var21 = var2[var17];
               this.set(var17, (T)(Object)var21);
            }
         }
      }
   }

   public SortableArrayList() {
   }

   public void method00238() {
      this.method00237(var0 -> {
         if (var0 == null) {
            throw new IllegalStateException(field00461);
         } else if (!(var0 instanceof String)) {
            throw new IllegalStateException("radixSortLsdStrings requires String elements, but found: " + var0.getClass().getName());
         } else {
            return (String)var0;
         }
      });
   }
}
