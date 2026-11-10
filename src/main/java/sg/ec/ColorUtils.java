// Original binary: sg/ec/MVKRQJxIBba1v9IH
package sg.ec;

import java.awt.Color;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class ColorUtils implements MinecraftAccess {
   public static int field10169 = method04604(255, 255, 255);
   public static int field10170 = method04604(0, 0, 0);
   private static final float field10171 = 255.0F;
   private static final float field10172 = 255.0F;
   private static final int field10173 = 16777215;
   private static final float field10174 = 255.0F;
   private static final float field10175 = 255.0F;
   private static final float field10176 = 255.0F;
   private static final float field10177 = 255.0F;
   private static final int field10178 = -16777216;
   private static final float field10179 = 255.0F;
   private static final float field10180 = 255.0F;
   private static final float field10181 = 255.0F;
   private static final float field10182 = 255.0F;
   private static final float field10183 = 255.0F;
   private static final double field10184 = 0.75;
   private static final double field10185 = 4.0;
   private static final double field10186 = 0.75;
   private static final double field10187 = 4.0;
   private static final int field10188 = 16777215;
   private static final float field10189 = 255.0F;
   private static final float field10190 = 255.0F;
   private static final float field10191 = 255.0F;
   private static final float field10192 = 255.0F;
   private static final long field10193 = 360L;
   private static final float field10194 = 360.0F;
   private static final float field10195 = 360.0F;
   private static final long field10196 = 360L;
   private static final float field10197 = 360.0F;
   private static final float field10198 = 255.0F;
   private static final long field10199 = 360L;
   private static final float field10200 = 360.0F;
   private static final float field10201 = 255.0F;
   private static final long field10202 = 360L;
   private static final float field10203 = 180.0F;
   private static final long field10204 = 360L;
   private static final float field10205 = 180.0F;
   private static final long field10206 = 360L;
   private static final float field10207 = 360.0F;
   private static final String field10208 = "This is a utility class and cannot be instantiated";

   public static int method04583(int var0, int var1, float var2) {
      float var3 = Mth.clamp(var2, 0.0F, 1.0F);
      return method04597(
         Math.round(method04588(var0) + (method04588(var1) - method04588(var0)) * var3),
         Math.round(method04589(var0) + (method04589(var1) - method04589(var0)) * var3),
         Math.round(method04587(var0) + (method04587(var1) - method04587(var0)) * var3),
         Math.round(method04625(var0) + (method04625(var1) - method04625(var0)) * var3)
      );
   }

   public static Color method04584(Color var0, Color var1, double var2) {
      float var4 = Mth.clamp((float)(1.0 - var2), 0.0F, 1.0F);
      return new Color(
         Math.round(var0.getRed() + (var1.getRed() - var0.getRed()) * var4),
         Math.round(var0.getGreen() + (var1.getGreen() - var0.getGreen()) * var4),
         Math.round(var0.getBlue() + (var1.getBlue() - var0.getBlue()) * var4),
         Math.round(var0.getAlpha() + (var1.getAlpha() - var0.getAlpha()) * var4)
      );
   }

   private ColorUtils() {
      throw new UnsupportedOperationException(field10208);
   }

   public static int method04585(int var0, int var1, int... var2) {
      if (var2 != null && var2.length != 0) {
         if (var2.length == 1) {
            return var2[0];
         } else if (var2.length == 2) {
            int var3 = (int)((System.currentTimeMillis() / var0 + var1) % field10202);
            var3 = var3 >= 180 ? 360 - var3 : var3;
            return method04583(var2[0], var2[1], var3 / field10203);
         } else {
            return method04590(var0, var1, var2);
         }
      } else {
         return field10169;
      }
   }

   public static int method04586(float var0, int... var1) {
      int var2 = var1.length;
      float var3 = var0 * (var2 - 1);
      int var4 = (int)var3;
      return var4 >= var2 - 1 ? var1[var2 - 1] : method04627(var1[var4 + 1], var1[var4], var3 - var4);
   }

   public static int method04587(int var0) {
      return var0 & 0xFF;
   }

   public static int method04588(int var0) {
      return var0 >> 16 & 0xFF;
   }

   public static int method04589(int var0) {
      return var0 >> 8 & 0xFF;
   }

   public static int method04590(int var0, int var1, int... var2) {
      int var3 = (int)((System.currentTimeMillis() / var0 + var1) % field10193);
      var3 = (var3 > 180 ? 360 - var3 : var3) + 180;
      int var4 = (int)(var3 / field10194 * var2.length);
      if (var4 == var2.length) {
         var4--;
      }

      int var5 = var2[var4];
      int var6 = var2[var4 == var2.length - 1 ? 0 : var4 + 1];
      return method04627(var5, var6, var3 / field10195 * var2.length - var4);
   }

   public static int method04591(int var0, int var1) {
      return method04597(method04617(var0), method04619(var0), method04607(var0), Math.round(var1 * 255));
   }

   public static int method04592(int var0, int var1, int var2, int var3) {
      return var3 << 24 | var0 << 16 | var1 << 8 | var2;
   }

   public static float[] method04593(int var0) {
      return new float[]{method04588(var0) / field10180, method04589(var0) / field10181, method04587(var0) / field10182, method04625(var0) / field10183};
   }

   public static int method04594(int var0) {
      return method04625(var0);
   }

   public static int method04595(int var0) {
      return method04597(var0, var0, var0, 255);
   }

   public static int method04596(int var0, float var1) {
      return method04618(method04588(var0) * var1, method04589(var0) * var1, method04587(var0) * var1, method04625(var0));
   }

   public static int method04597(int var0, int var1, int var2, int var3) {
      return method04632(var3) << 24 | method04632(var0) << 16 | method04632(var1) << 8 | method04632(var2);
   }

   public static int method04598(float var0, float var1, float var2, float var3) {
      return method04597((int)var0, (int)var1, (int)var2, Math.round(var3 * field10174));
   }

   public static int method04599(int var0, float var1) {
      return method04618(
         method04588(var0) + (255 - method04588(var0)) * var1,
         method04589(var0) + (255 - method04589(var0)) * var1,
         method04587(var0) + (255 - method04587(var0)) * var1,
         method04625(var0)
      );
   }

   public static int method04600(int var0, int var1, float var2, float var3, float var4) {
      int var5 = (int)((System.currentTimeMillis() / var0 + var1) % field10199);
      float var6 = var5 / field10200;
      int var7 = Color.HSBtoRGB(var6, var2, var3);
      return method04597(method04588(var7), method04589(var7), method04587(var7), Math.max(0, Math.min(255, (int)(var4 * field10201))));
   }

   public static int method04601(float var0, float var1, boolean var2) {
      float var3 = var0 / var1;
      var3 = Math.max(0.0F, Math.min(var3, 1.0F));
      int var4 = (int)(field10179 * var3);
      int var5 = 255 - var4;
      return method04604(var2 ? var4 : var5, var2 ? var5 : var4, 0);
   }

   public static int method04602(int var0, int var1, double var2) {
      float var4 = Mth.clamp((float)var2, 0.0F, 1.0F);
      return method04583(var0, var1, var4);
   }

   public static int method04603(int var0, int var1) {
      return method04597(var0, var0, var0, var1);
   }

   public static int method04604(int var0, int var1, int var2) {
      return method04597(var0, var1, var2, 255);
   }

   public static int method04605(int var0, float var1) {
      return method04597(method04617(var0), method04619(var0), method04607(var0), Math.round(var1 * field10172));
   }

   public static Color method04606(int var0, int var1, Color var2) {
      float[] var3 = Color.RGBtoHSB(var2.getRed(), var2.getGreen(), var2.getBlue(), null);
      int var4 = (int)((System.currentTimeMillis() / var0 + var1) % field10206);
      var4 = (var4 > 180 ? 360 - var4 : var4) + 180;
      Color var5 = new Color(Color.HSBtoRGB(var3[0], var3[1], var4 / field10207));
      return new Color(var5.getRed(), var5.getGreen(), var5.getBlue(), Mth.clamp(0, 255, var2.getAlpha()));
   }

   public static int method04607(int var0) {
      return method04587(var0);
   }

   public static int method04608(int var0, int var1, int var2, int var3) {
      int var4 = (int)((System.currentTimeMillis() / var0 + var1) % field10196);
      var4 = (var4 > 180 ? 360 - var4 : var4) + 180;
      float var5 = var4 / field10197 * 2.0F;
      int var6 = (int)var5;
      if (var6 == 2) {
         var6 = 1;
      }

      int var7 = var6 == 0 ? var2 : var3;
      int var8 = var6 == 1 ? var2 : var3;
      return method04627(var7, var8, var5 - var6);
   }

   public static float method04609(int var0) {
      return method04625(var0) / field10171;
   }

   public static int method04610(long var0, int var2, int var3, int var4, int var5) {
      int var6 = (int)((var0 / var2 + var3) % field10204);
      var6 = var6 >= 180 ? 360 - var6 : var6;
      return method04583(var4, var5, var6 / field10205);
   }

   public static int method04611(int var0, float var1) {
      return var0 & field10173 | method04632(Math.round(method04594(var0) * var1)) << 24;
   }

   public static float method04612(int var0) {
      return method04587(var0) / field10177;
   }

   public static int method04613(int var0, int var1, int var2, int var3) {
      return method04610(System.currentTimeMillis(), var0, var1, var2, var3);
   }

   public static int method04614(int var0, int var1, double var2) {
      float var4 = (float)var2;
      int var5 = (int)((var0 >> 24 & 0xFF) + ((var1 >> 24 & 0xFF) - (var0 >> 24 & 0xFF)) * var4);
      int var6 = (int)((var0 >> 16 & 0xFF) + ((var1 >> 16 & 0xFF) - (var0 >> 16 & 0xFF)) * var4);
      int var7 = (int)((var0 >> 8 & 0xFF) + ((var1 >> 8 & 0xFF) - (var0 >> 8 & 0xFF)) * var4);
      int var8 = (int)((var0 & 0xFF) + ((var1 & 0xFF) - (var0 & 0xFF)) * var4);
      return var5 << 24 | var6 << 16 | var7 << 8 | var8;
   }

   public static float method04615(int var0) {
      return method04588(var0) / field10175;
   }

   public static int method04616(int var0, int var1) {
      return Mth.clamp(var1, 0, 255) << 24 | var0 & field10188;
   }

   public static int method04617(int var0) {
      return method04588(var0);
   }

   public static int method04618(float var0, float var1, float var2, float var3) {
      return method04597((int)var0, (int)var1, (int)var2, (int)var3);
   }

   public static int method04619(int var0) {
      return method04589(var0);
   }

   public static Color method04620() {
      return new Color(Color.HSBtoRGB((float)Math.random(), (float)(field10184 + Math.random() / field10185), (float)(field10186 + Math.random() / field10187)));
   }

   public static int method04621(int var0) {
      return method04613(4, var0, ColorUtils.Nested138.method04636(), ColorUtils.Nested138.method04637());
   }

   public static int method04622(String var0) {
      int var1 = Integer.parseInt(var0.substring(1), 16);
      return method04616(var1, 255);
   }

   public static float[] method04623(int var0) {
      return new float[]{(var0 >> 16 & 0xFF) / field10189, (var0 >> 8 & 0xFF) / field10190, (var0 & 0xFF) / field10191, (var0 >> 24 & 0xFF) / field10192};
   }

   public static float[] method04624(int var0) {
      return method04623(var0);
   }

   public static int method04625(int var0) {
      return var0 >> 24 & 0xFF;
   }

   public static int method04626(int var0, float var1) {
      return method04603(var0, Math.round(var1 * field10198));
   }

   public static int method04627(int var0, int var1, float var2) {
      float var3 = var2 < 0.0F ? 0.0F : (var2 > 1.0F ? 1.0F : var2);
      int var4 = (int)((var1 >> 24 & 0xFF) + ((var0 >> 24 & 0xFF) - (var1 >> 24 & 0xFF)) * var3);
      int var5 = (int)((var1 >> 16 & 0xFF) + ((var0 >> 16 & 0xFF) - (var1 >> 16 & 0xFF)) * var3);
      int var6 = (int)((var1 >> 8 & 0xFF) + ((var0 >> 8 & 0xFF) - (var1 >> 8 & 0xFF)) * var3);
      int var7 = (int)((var1 & 0xFF) + ((var0 & 0xFF) - (var1 & 0xFF)) * var3);
      return var4 << 24 | var5 << 16 | var6 << 8 | var7;
   }

   public static int method04628(int var0, float var1) {
      float[] var2 = Color.RGBtoHSB(method04617(var0), method04619(var0), method04607(var0), null);
      var2[1] = Math.max(0.0F, Math.min(1.0F, var2[1] * var1));
      int var3 = Color.HSBtoRGB(var2[0], var2[1], var2[2]);
      return method04597(var3 >> 16 & 0xFF, var3 >> 8 & 0xFF, var3 & 0xFF, method04594(var0));
   }

   public static float method04629(int var0) {
      return method04589(var0) / field10176;
   }

   public static int method04630(int var0, int var1, int var2) {
      return field10178 | var0 << 16 | var1 << 8 | var2;
   }

   public static int method04631(int var0, int var1, float var2) {
      int var3 = (int)((var0 >> 24 & 0xFF) + ((var1 >> 24 & 0xFF) - (var0 >> 24 & 0xFF)) * var2);
      int var4 = (int)((var0 >> 16 & 0xFF) + ((var1 >> 16 & 0xFF) - (var0 >> 16 & 0xFF)) * var2);
      int var5 = (int)((var0 >> 8 & 0xFF) + ((var1 >> 8 & 0xFF) - (var0 >> 8 & 0xFF)) * var2);
      int var6 = (int)((var0 & 0xFF) + ((var1 & 0xFF) - (var0 & 0xFF)) * var2);
      return var3 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   private static int method04632(int var0) {
      return var0 < 0 ? 0 : (var0 > 255 ? 255 : var0);
   }

   // $VF: Compiled from s
   public static final class Nested137 {
      private static final String field10209 = "This is a utility class and cannot be instantiated";

      public static <T extends Number> T method04633(T var0, T var1, double var2) {
         double var4 = var0.doubleValue();
         double sx = var1.doubleValue();
         double sxx = var4 + var2 * (sx - var4);
         if (var0 instanceof Integer) {
            return (T)(Object)(int)Math.round(sxx);
         } else if (var0 instanceof Double) {
            return (T)(Object)sxx;
         } else if (var0 instanceof Float) {
            return (T)(Object)(float)sxx;
         } else if (var0 instanceof Long) {
            return (T)(Object)Math.round(sxx);
         } else if (var0 instanceof Short) {
            return (T)(Object)(short)Math.round(sxx);
         } else if (var0 instanceof Byte) {
            return (T)(Object)(byte)Math.round(sxx);
         } else {
            throw new IllegalArgumentException("Unsupported type: " + var0.getClass().getSimpleName());
         }
      }

      private Nested137() {
         throw new UnsupportedOperationException(field10209);
      }
   }

   // $VF: Compiled from s
   public static class Nested138 {
      private static final int field10210 = Integer.MAX_VALUE;

      public static int method04634(int var0) {
         return ColorUtils.method04621(var0);
      }

      public static int method04635(int var0, float var1) {
         return ColorUtils.method04611(method04634(var0), Math.min(var1, 1.0F));
      }

      public static int method04636() {
         return ThemeManager.INSTANCE.method09611().method09800();
      }

      public static int method04637() {
         return ThemeManager.INSTANCE.method09611().method09809();
      }

      public static int method04638(int var0) {
         return ColorUtils.method04613(field10210, var0, method04636(), method04637());
      }
   }
}
