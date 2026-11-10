// Original binary: sg/ec/lJlsEx5camtfUaK1
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToLongFunction;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;

// $VF: Compiled from s
public final class GuiRenderStateHooks {
   private static final int field21253 = 24;
   private static final long field21254 = 0;
   private static final long field21255 = 0;
   private static final GuiRenderStateHooks.Nested258 field21256 = new GuiRenderStateHooks.Nested258(null);
   private static final GuiRenderStateHooks.Nested258 field21257 = new GuiRenderStateHooks.Nested258(var0 -> ((RenderPipeline)var0).getSortKey());
   private static final GuiRenderStateHooks.Nested258 field21258 = new GuiRenderStateHooks.Nested258(
      var0 -> var0 == null ? GuiRenderStateHooks.field21275 : ((TextureSetup)var0).getSortKey()
   );
   private static GuiElementRenderState[] field21259 = new GuiElementRenderState[256];
   private static long[] field21260 = new long[256];
   private static long[] field21261 = new long[256];
   private static int[] field21262 = new int[256];
   private static int[] field21263 = new int[256];
   private static int[] field21264 = new int[256];
   private static int[] field21265 = new int[256];
   private static int[] field21266 = new int[256];
   private static long[] field21267 = new long[32];
   private static int[] field21268 = new int[32];
   private static int[] field21269 = new int[32];
   private static int[] field21270 = new int[32];
   private static int[] field21271 = new int[32];
   private static int[] field21272 = new int[32];
   private static final long field21273 = Long.MIN_VALUE;
   private static final long field21274 = 16777215L;
   private static final long field21275 = -2147483649L;

   private static void method09337(List<GuiElementRenderState> var0, int var1) {
      int var2 = 0;

      while (var2 < var1) {
         field21262[var2] = var2++;
      }

      int[] sx = field21262;
      int[] sxx = field21263;

      for (int sxxx = 1; sxxx < var1; sxxx <<= 1) {
         for (int sxxxx = 0; sxxxx < var1; sxxxx += sxxx << 1) {
            method09346(sx, sxx, sxxxx, Math.min(sxxxx + sxxx, var1), Math.min(sxxxx + (sxxx << 1), var1));
         }

         int[] sxxxx = sx;
         sx = sxx;
         sxx = sxxxx;
      }

      for (int sxxx = 0; sxxx < var1; sxxx++) {
         var0.set(sxxx, field21259[sx[sxxx]]);
      }
   }

   private static int method09339(int var0, int var1) {
      int var2 = Math.max(var0, 1);

      while (var2 < var1) {
         var2 <<= 1;
      }

      return var2;
   }

   private static int[] method09340(GuiRenderStateHooks.Nested258 var0, int[] var1) {
      int var2 = var0.method09357();
      var1 = method09347(var1, var2);
      field21267 = method09342(field21267, var2);

      for (int var3 = 0; var3 < var2; var3++) {
         field21267[var3] = var0.method09358(var3) << 24 | var3;
      }

      Arrays.sort(field21267, 0, var2);
      int var10 = -1;
      long var4 = 0L;

      for (int var6 = 0; var6 < var2; var6++) {
         long var7 = field21267[var6] >> 24;
         if (var10 < 0 || var7 != var4) {
            var10++;
            var4 = var7;
         }

         var1[(int)(field21267[var6] & field21274)] = var10;
      }

      var0.method09355(var10 + 1);
      return var1;
   }

   private static void method09341(List<GuiElementRenderState> var0, int var1, int var2) {
      long var3 = (1L << var2) - 1L;

      for (int var5 = 0; var5 < var1; var5++) {
         field21261[var5] = field21260[var5] << var2 | var5;
      }

      Arrays.sort(field21261, 0, var1);

      for (int var6 = 0; var6 < var1; var6++) {
         var0.set(var6, field21259[(int)(field21261[var6] & var3)]);
      }
   }

   private static long[] method09342(long[] var0, int var1) {
      return var0.length >= var1 ? var0 : new long[method09339(var0.length, var1)];
   }

   public static void method09343(List<GuiElementRenderState> var0) {
      int var1 = var0.size();
      if (var1 >= 2) {
         method09345(var1);
         field21256.method09352();
         field21257.method09352();
         field21258.method09352();

         for (int var2 = 0; var2 < var1; var2++) {
            GuiElementRenderState var3 = (GuiElementRenderState)var0.get(var2);
            field21259[var2] = var3;
            field21264[var2] = field21256.method09351(var3.scissorArea());
            field21265[var2] = field21257.method09351(var3.pipeline());
            field21266[var2] = field21258.method09351(var3.textureSetup());
         }

         field21270 = method09350();
         field21271 = method09340(field21257, field21271);
         field21272 = method09340(field21258, field21272);
         long var12 = field21257.method09354();
         long var4 = field21258.method09354();
         boolean var6 = true;
         long var7 = field21273;

         for (int var9 = 0; var9 < var1; var9++) {
            long var10 = (field21270[field21264[var9]] * var12 + field21271[field21265[var9]]) * var4 + field21272[field21266[var9]];
            field21260[var9] = var10;
            var6 &= var10 >= var7;
            var7 = var10;
         }

         if (!var6) {
            int var13 = 64 - Long.numberOfLeadingZeros(var1 - 1);
            long var14 = field21256.method09354() * var12 * var4;
            if (var14 > 0L && var14 <= 1L << 62 - var13) {
               method09341(var0, var1, var13);
            } else {
               method09337(var0, var1);
            }
         }

         Arrays.fill(field21259, 0, var1, null);
      }
   }

   private GuiRenderStateHooks() {
   }

   private static void method09344(int[] var0, int[] var1, int var2, int var3, int var4) {
      int var5 = var2;
      int var6 = var3;
      int var7 = var2;

      while (var5 < var3 && var6 < var4) {
         var1[var7++] = method09349(var0[var5], var0[var6]) <= 0 ? var0[var5++] : var0[var6++];
      }

      while (var5 < var3) {
         var1[var7++] = var0[var5++];
      }

      while (var6 < var4) {
         var1[var7++] = var0[var6++];
      }
   }

   private static void method09345(int var0) {
      if (field21262.length < var0) {
         int var1 = method09339(field21262.length, var0);
         field21259 = new GuiElementRenderState[var1];
         field21260 = new long[var1];
         field21261 = new long[var1];
         field21262 = new int[var1];
         field21263 = new int[var1];
         field21264 = new int[var1];
         field21265 = new int[var1];
         field21266 = new int[var1];
      }
   }

   private static void method09346(int[] var0, int[] var1, int var2, int var3, int var4) {
      int var5 = var2;
      int var6 = var3;
      int var7 = var2;

      while (var5 < var3 && var6 < var4) {
         var1[var7++] = field21260[var0[var5]] <= field21260[var0[var6]] ? var0[var5++] : var0[var6++];
      }

      while (var5 < var3) {
         var1[var7++] = var0[var5++];
      }

      while (var6 < var4) {
         var1[var7++] = var0[var6++];
      }
   }

   private static int[] method09347(int[] var0, int var1) {
      return var0.length >= var1 ? var0 : new int[method09339(var0.length, var1)];
   }

   private static int method09349(int var0, int var1) {
      ScreenRectangle var2 = (ScreenRectangle)field21256.method09353(var0);
      ScreenRectangle var3 = (ScreenRectangle)field21256.method09353(var1);
      if (var2 != null && var3 != null) {
         int var4 = Integer.compare(var2.left(), var3.left());
         if (var4 != 0) {
            return var4;
         }

         var4 = Integer.compare(var2.top(), var3.top());
         if (var4 != 0) {
            return var4;
         }

         var4 = Integer.compare(var2.right(), var3.right());
         return var4 != 0 ? var4 : Integer.compare(var2.bottom(), var3.bottom());
      } else {
         return var2 == var3 ? 0 : (var2 == null ? -1 : 1);
      }
   }

   private static int[] method09350() {
      int var0 = field21256.method09357();
      field21270 = method09347(field21270, var0);
      field21268 = method09347(field21268, var0);
      field21269 = method09347(field21269, var0);
      int var1 = 0;

      while (var1 < var0) {
         field21268[var1] = var1++;
      }

      int[] var5 = field21268;
      int[] var2 = field21269;

      for (byte var3 = 1; var3 < var0; var3 <<= 1) {
         for (int var4 = 0; var4 < var0; var4 += var3 << 1) {
            method09344(var5, var2, var4, Math.min(var4 + var3, var0), Math.min(var4 + (var3 << 1), var0));
         }

         int[] var7 = var5;
         var5 = var2;
         var2 = var7;
      }

      int var6 = -1;

      for (int var8 = 0; var8 < var0; var8++) {
         if (var8 == 0 || method09349(var5[var8 - 1], var5[var8]) != 0) {
            var6++;
         }

         field21270[var5[var8]] = var6;
      }

      field21256.method09355(var6 + 1);
      return field21270;
   }

   // $VF: Compiled from s
   private static final class Nested258 {
      private final ToLongFunction<Object> field21276;
      private int[] field21277 = new int[64];
      private int[] field21278 = new int[64];
      private Object[] field21279 = new Object[32];
      private long[] field21280 = new long[32];
      private int field21281;
      private int field21282;
      private int field21283;
      private Object field21284;
      private int field21285 = -1;
      private static final int field21286 = -1640531535;

      int method09351(Object var1) {
         if (var1 == this.field21284 && this.field21285 >= 0) {
            return this.field21285;
         }

         int var2 = this.field21277.length - 1;

         int sx;
         for (sx = method09359(System.identityHashCode(var1), var2); this.field21278[sx] == this.field21282; sx = sx + 1 & var2) {
            int sxx = this.field21277[sx];
            if (this.field21279[sxx] == var1) {
               this.field21284 = var1;
               this.field21285 = sxx;
               return sxx;
            }
         }

         if (this.field21281 == this.field21279.length) {
            int sxx = this.field21281 << 1;
            this.field21279 = Arrays.copyOf(this.field21279, sxx);
            this.field21280 = Arrays.copyOf(this.field21280, sxx);
         }

         int sxx = this.field21281++;
         this.field21279[sxx] = var1;
         if (this.field21276 != null) {
            this.field21280[sxx] = this.field21276.applyAsLong(var1);
         }

         this.field21277[sx] = sxx;
         this.field21278[sx] = this.field21282;
         if (this.field21281 << 1 > this.field21277.length) {
            this.method09356();
         }

         this.field21284 = var1;
         this.field21285 = sxx;
         return sxx;
      }

      void method09352() {
         Arrays.fill(this.field21279, 0, this.field21281, null);
         this.field21281 = 0;
         this.field21283 = 0;
         this.field21284 = null;
         this.field21285 = -1;
         if (++this.field21282 == 0) {
            Arrays.fill(this.field21278, 0);
            this.field21282 = 1;
         }
      }

      Object method09353(int var1) {
         return this.field21279[var1];
      }

      long method09354() {
         return Math.max(1, this.field21283);
      }

      Nested258(ToLongFunction<Object> var1) {
         this.field21276 = var1;
      }

      void method09355(int var1) {
         this.field21283 = var1;
      }

      private void method09356() {
         this.field21277 = new int[this.field21277.length << 1];
         this.field21278 = new int[this.field21277.length];
         this.field21282 = 1;
         int var1 = this.field21277.length - 1;

         for (int var2 = 0; var2 < this.field21281; var2++) {
            int var3 = method09359(System.identityHashCode(this.field21279[var2]), var1);

            while (this.field21278[var3] == this.field21282) {
               var3 = var3 + 1 & var1;
            }

            this.field21277[var3] = var2;
            this.field21278[var3] = this.field21282;
         }
      }

      int method09357() {
         return this.field21281;
      }

      long method09358(int var1) {
         return this.field21280[var1];
      }

      private static int method09359(int var0, int var1) {
         int var2 = var0 * field21286;
         return (var2 ^ var2 >>> 16) & var1;
      }
   }
}
