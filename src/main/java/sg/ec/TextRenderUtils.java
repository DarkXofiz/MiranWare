// Original binary: sg/ec/3FniCPi2DdEo2HL7
package sg.ec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;

// $VF: Compiled from s
public final class TextRenderUtils {
   private static final float field01548 = 0.35F;
   private static final String field01549 = " ";
   private static final String field01550 = " ";
   private static final float field01551 = 0.35F;
   private static final double field01552 = 2000.0;
   private static final float field01553 = 0.5F;
   private static final int field01554 = 16777215;
   private static final float field01555 = 0.5F;
   private static final float field01556 = 0.5F;
   private static final float field01557 = 0.5F;
   private static final float field01558 = 0.5F;
   private static final float field01559 = 0.5F;
   private static final float field01560 = 0.5F;
   private static final float field01561 = 0.5F;
   private static final int field01562 = 16777215;
   private static final int field01563 = 16777215;
   private static final String field01564 = "**:**";
   private static final long field01565 = 1000L;
   private static final long field01566 = 86400L;
   private static final long field01567 = 3600L;
   private static final long field01568 = 60L;
   private static final String field01569 = "This is a utility class and cannot be instantiated";

   public static void method00666(
      GuiGraphics var0,
      SmoothAnimation var1,
      FontRenderer var2,
      String var3,
      float var4,
      float var5,
      float var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      float var13 = var2.method09478(var3, var8, var9);
      var13 = Math.max(0.0F, var13);
      if (var13 <= var6 + field01551) {
         var1.method06157(0.0);
         var2.method09490(var0, var3, var4, var5, var7, var8, var9);
      } else {
         float sx = Math.max(var10, 1.0F);
         float sxx = var13 + sx;
         float sxxx = Math.max(var11, 1.0F);
         boolean sxxxx = var1.method06162();
         boolean sxxxxx = var1.method06160() == var1.method06161() && var1.method06161() == 0.0;
         if (!sxxxx) {
            if (sxxxxx) {
               var1.method06157(-sxx);
               var1.method06158(0.0, sxx / sxxx, Easings.field19394);
            } else {
               var1.method06157(0.0);
               var1.method06172(0.0);
               var1.method06175(0.0);
               var1.method06154(field01552);
               var1.method06163(System.currentTimeMillis());
               var1.method06147(Easings.field19394);
               var1.method06162();
               sxxxxx = true;
            }
         }

         float sxxxxxx = var1.method06173();
         float sxxxxxxx = sxxxxx ? var4 : var4 - sxxxxxx;
         method00676(var0, var2, var3, sxxxxxxx, var5, var7, var8, var9, var4, var6, var12);
         if (!sxxxxx) {
            float sxxxxxxxx = sxxxxxxx - sxx;
            method00676(var0, var2, var3, sxxxxxxxx, var5, var7, var8, var9, var4, var6, var12);
         }
      }
   }

   public static String method00667(MobEffectInstance var0, float var1) {
      if (!var0.isInfiniteDuration() && var0.getDuration() <= 32000) {
         int var2 = Mth.floor(var0.getDuration() * var1);
         return method00680(var2);
      } else {
         return field01564;
      }
   }

   private TextRenderUtils() {
      throw new UnsupportedOperationException(field01569);
   }

   public static void method00668(
      GuiGraphics var0, FontRenderer var1, String var2, String var3, float var4, float var5, float var6, int var7, float var8, boolean var9
   ) {
      if (var3 != null && !var3.isEmpty()) {
         float var10 = var1.method09486(var3, var8);
         float var11 = var5 - var10 * field01558;
         float var12 = Mth.clamp(var4, 0.0F, 1.0F);
         FontFace var13 = var1.field21527;
         if (!(var12 >= 1.0F) && var2 != null && !var2.equals(var3) && var13 != null) {
            float var14 = var1.method09485(var8);
            float var15 = var14 + 2.0F;
            float var16 = var9 ? (1.0F - var12) * var15 : -(1.0F - var12) * var15;
            float var17 = var9 ? -var12 * var15 : var12 * var15;
            int var18 = method00674(var7, var12);
            int var19 = method00674(var7, 1.0F - var12);
            int var20 = var2.length();
            int var21 = var3.length();
            var0.enableScissor(
               (int)Math.floor(var11 - 1.0F),
               (int)Math.floor(var6 - field01559),
               (int)Math.ceil(var11 + var10 + 1.0F),
               (int)Math.ceil(var6 + var14 + field01560)
            );
            float var22 = var11;
            boolean var23 = false;
            int var24 = -1;

            for (int var25 = 0; var25 < var21; var25++) {
               char var26 = var3.charAt(var25);
               FontGlyph var27 = var13.method07009(var26);
               if (var27 != null) {
                  if (var23) {
                     var22 += var13.method07013(var24, var26, var8);
                  }

                  int var28 = var20 - var21 + var25;
                  char var29 = var28 >= 0 ? var2.charAt(var28) : '\u0000';
                  if (var29 == var26) {
                     var1.method09480(var0, String.valueOf(var26), var22, var6, var7, var8);
                  } else {
                     var1.method09480(var0, String.valueOf(var26), var22, var6 + var16, var18, var8);
                     if (var29 != 0) {
                        var1.method09480(var0, String.valueOf(var29), var22, var6 + var17, var19, var8);
                     }
                  }

                  var22 += var27.method03699(var8);
                  var24 = var26;
                  var23 = true;
               }
            }

            var0.disableScissor();
         } else {
            var1.method09480(var0, var3, var11, var6, var7, var8);
         }
      }
   }

   public static void method00669(
      GuiGraphics var0, FontRenderer var1, String var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9
   ) {
      if (var2 != null && !var2.isEmpty()) {
         FontFace var10 = var1.field21527;
         if (var10 != null && !(var1.method09478(var2, var7, var8) <= var5)) {
            float var11 = var3 + var5;
            float var12 = Math.max(1.0F, Math.min(var9, var5 * field01561));
            int var13 = var6 >>> 24 & 0xFF;
            int var14 = var6 & field01562;
            float var15 = var3;
            int var16 = -1;
            boolean var17 = false;
            int var18 = var2.length();

            for (int var19 = 0; var19 < var18; var19++) {
               char var20 = var2.charAt(var19);
               FontGlyph var21 = var10.method07009(var20);
               if (var21 != null) {
                  if (var17) {
                     var15 += var8 + var10.method07013(var16, var20, var7);
                  }

                  boolean var22 = var21.method03695();
                  float var23 = var22 ? var15 + var21.method03703(var7) : var15;
                  float var24 = var22 ? var15 + var21.method03697(var7) : var15 + var21.method03699(var7);
                  if (var23 >= var11) {
                     break;
                  }

                  int var25 = method00675(var13, var14, (var11 - var23) / var12);
                  int var26 = method00675(var13, var14, (var11 - var24) / var12);
                  if (var25 >>> 24 != 0 || var26 >>> 24 != 0) {
                     var1.method09482(var0, String.valueOf(var20), var15, var4, new CornerColors(var25, var25, var26, var26), var7, var8);
                  }

                  var15 += var21.method03699(var7);
                  var16 = var20;
                  var17 = true;
               }
            }
         } else {
            var1.method09490(var0, var2, var3, var4, var6, var7, var8);
         }
      }
   }

   public static String method00670(long var0) {
      long var2 = Math.max(0L, var0);
      long var4 = var2 / field01565;
      long var6 = var4 / field01566;
      if (var6 > 0L) {
         return var6 + "d";
      }

      long var8 = var4 / field01567;
      if (var8 > 0L) {
         return var8 + "h";
      }

      long var10 = var4 / field01568;
      return var10 > 0L ? var10 + "m" : var4 + "s";
   }

   public static void method00671(
      GuiGraphics var0, FontRenderer var1, String var2, String var3, float var4, float var5, float var6, float var7, int var8, float var9
   ) {
      float var10 = Mth.clamp(var4, 0.0F, 1.0F);
      if (!(var10 >= 1.0F) && var2 != null && !var2.equals(var3)) {
         float var11 = var1.method09485(var9);
         float var12 = var11 + 2.0F;
         var0.enableScissor((int)Math.floor(var5 - 1.0F), (int)Math.floor(var6 - field01556), (int)Math.ceil(var7), (int)Math.ceil(var6 + var11 + field01557));
         var1.method09480(var0, var2, var5, var6 - var10 * var12, method00674(var8, 1.0F - var10), var9);
         var1.method09480(var0, var3, var5, var6 + (1.0F - var10) * var12, method00674(var8, var10), var9);
         var0.disableScissor();
      } else {
         var1.method09480(var0, var3, var5, var6, var8, var9);
      }
   }

   public static String method00672(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (!Character.isWhitespace(var3)) {
               var1.append(Character.toLowerCase(var3));
            }
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   public static boolean method00673(String var0) {
      if (var0 == null) {
         return false;
      }

      int var1 = var0.length();
      if (var1 >= 1 && var1 <= 16) {
         for (int var2 = 0; var2 < var1; var2++) {
            char var3 = var0.charAt(var2);
            boolean var4 = var3 >= 'a' && var3 <= 'z' || var3 >= 'A' && var3 <= 'Z' || var3 >= '0' && var3 <= '9' || var3 == '_';
            if (!var4) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private static int method00674(int var0, float var1) {
      int var2 = var0 >>> 24 & 0xFF;
      int var3 = Math.max(0, Math.min(255, Math.round(var2 * Mth.clamp(var1, 0.0F, 1.0F))));
      return var3 << 24 | var0 & field01563;
   }

   private static int method00675(int var0, int var1, float var2) {
      int var3 = Math.max(0, Math.min(255, Math.round(var0 * Mth.clamp(var2, 0.0F, 1.0F))));
      return var3 << 24 | var1;
   }

   private static void method00676(
      GuiGraphics var0,
      FontRenderer var1,
      String var2,
      float var3,
      float var4,
      int var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10
   ) {
      FontFace var11 = var1.field21527;
      if (var11 == null) {
         var1.method09490(var0, var2, var3, var4, var5, var6, var7);
      } else {
         float var12 = Math.max(1.0F, Math.min(var10, var9 * field01553));
         float var13 = var8;
         float var14 = var8 + var9;
         int var15 = var5 >>> 24 & 0xFF;
         int var16 = var5 & field01554;
         float var17 = var3;
         int var18 = -1;
         boolean var19 = false;
         int var20 = var2.length();

         for (int var21 = 0; var21 < var20; var21++) {
            char var22 = var2.charAt(var21);
            FontGlyph var23 = var11.field16573.get(Integer.valueOf(var22));
            if (var23 != null) {
               if (var19) {
                  var17 += var7 + var11.method07013(var18, var22, var6);
               }

               float var24;
               float var25;
               if (var23.method03695()) {
                  var24 = var17 + var23.method03703(var6);
                  var25 = var17 + var23.method03697(var6);
               } else {
                  var24 = var17;
                  var25 = var17 + var23.method03699(var6);
               }

               if (var25 > var13 && var24 < var14) {
                  float var26 = (var24 + var25) * field01555;
                  float var27 = Math.min(var26 - var13, var14 - var26);
                  float var28 = Math.max(0.0F, Math.min(1.0F, var27 / var12));
                  if (var28 > 0.0F) {
                     int var29 = Math.max(0, Math.min(255, Math.round(var15 * var28)));
                     if (var29 > 0) {
                        var1.method09490(var0, String.valueOf(var22), var17, var4, var29 << 24 | var16, var6, var7);
                     }
                  }
               }

               var17 += var23.method03699(var6);
               var18 = var22;
               var19 = true;
            }
         }
      }
   }

   public static List<String> method00677(String var0, float var1, FontRenderer var2, float var3) {
      ArrayList var4 = new ArrayList();
      StringBuilder var5 = new StringBuilder();
      String[] var6 = var0.split(field01549);

      for (String var10 : var6) {
         if (var2.method09486(var5 + var10, var3) <= var1) {
            var5.append(var10).append(field01550);
         } else {
            var4.add(var5.toString().trim());
            var5 = new StringBuilder(var10 + " ");
         }
      }

      if (!var5.isEmpty()) {
         var4.add(var5.toString().trim());
      }

      return var4;
   }

   public static String method00678(FontRenderer var0, String var1, float var2, float var3) {
      if (var0.method09486(var1, var3) <= var2) {
         return var1;
      }

      String var4 = "";
      StringBuilder var5 = new StringBuilder();

      for (char var9 : var1.toCharArray()) {
         if (var0.method09486("" + var5 + var4, var3) > var2) {
            break;
         }

         var5.append(var9);
      }

      return var5 + var4;
   }

   private static float method00679(FontRenderer var0, String var1, float var2) {
      return Math.max(0.0F, var0.method09486(var1, var2));
   }

   public static String method00680(int var0) {
      int var1 = var0 / 20;
      int var2 = var1 / 60;
      var1 %= 60;
      return var1 < 10 ? var2 + ":0" + var1 : var2 + ":" + var1;
   }
}
