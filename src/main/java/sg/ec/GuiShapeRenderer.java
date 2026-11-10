// Original binary: sg/ec/na1034Xke2zXcAqR
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.util.Mth;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class GuiShapeRenderer {
   private static final String field21973 = "This is a utility class and cannot be instantiated";

   public static void method09699() {
      GuiRenderBatch.method05181();
   }

   public static void method09700(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, float var7, CornerColors var8
   ) {
      method09705(var0, var1, var2, var3, var4, var6, var7, var5, var8);
   }

   public static void method09701(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, int var7) {
      method09705(var0, var1, var2, var3, var4, var6, var6, var5, new CornerColors(var7));
   }

   public static void method09702(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, CornerColors var7
   ) {
      method09705(var0, var1, var2, var3, var4, 1.0F, var6, var5, var7);
   }

   public static void method09703(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      method09705(var0, var1, var2, var3, var4, var6, var6, new CornerRadii(var5), new CornerColors(var7));
   }

   public static void method09704() {
      GuiRenderBatch.method05194();
   }

   private GuiShapeRenderer() {
      throw new UnsupportedOperationException(field21973);
   }

   public static void method09705(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, CornerRadii var7, CornerColors var8
   ) {
      GuiRenderBatch.method05186(
         var0.guiRenderState, new RoundedRectRenderState(var1, var2, var3, var4, var7, var5, var6, var8, var0.scissorStack.peek(), new Matrix3x2f(var0.pose()))
      );
   }

   // $VF: Compiled from s
   public static class Nested268 {
      private static final long field21974 = 360L;
      private static final float field21975 = 180.0F;
      private static final float field21976 = 180.0F;
      private static final float field21977 = -1.0F;
      private static final float field21978 = -1.0F;

      private static void method09706(
         GuiGraphicsExtractor var0,
         float var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         boolean var7,
         boolean var8,
         int var9,
         int var10,
         int var11,
         int var12,
         int var13,
         int var14,
         int var15
      ) {
         if (var3 > var4) {
            float var16 = var3;
            var3 = var4;
            var4 = var16;
         }

         int var34 = (int)var3;
         int sx = (int)var4;
         if (sx > var34) {
            int sxx = sx - var34;
            float[] sxxx = new float[sxx + 1];
            float[] sxxxx = new float[sxx + 1];

            for (int sxxxxx = 0; sxxxxx <= sxx; sxxxxx++) {
               float sxxxxxx = (float)Math.toRadians(var34 + sxxxxx);
               sxxx[sxxxxx] = Mth.cos(sxxxxxx);
               sxxxx[sxxxxx] = Mth.sin(sxxxxxx);
            }

            int[] sxxxxx = null;
            if (var8 || var13 >= 0) {
               sxxxxx = new int[sxx + 1];
               long sxxxxxx = System.currentTimeMillis() / Math.max(1, var12);

               for (int sxxxxxxx = 0; sxxxxxxx <= sxx; sxxxxxxx++) {
                  int sxxxxxxxx = var34 + sxxxxxxx;
                  int sxxxxxxxxx = (int)((sxxxxxx + sxxxxxxxx) % field21974);
                  sxxxxxxxxx = sxxxxxxxxx >= 180 ? 360 - sxxxxxxxxx : sxxxxxxxxx;
                  if (var13 >= 0 && sxxxxxxxx >= var13) {
                     sxxxxx[sxxxxxxx] = ColorUtils.method04583(var14, var15, sxxxxxxxxx / field21975);
                  } else if (var8) {
                     sxxxxx[sxxxxxxx] = ColorUtils.method04583(var10, var11, sxxxxxxxxx / field21976);
                  } else {
                     sxxxxx[sxxxxxxx] = var9;
                  }
               }
            }

            ScreenRectangle sxxxxxx = var0.scissorStack.peek();
            Matrix3x2f sxxxxxxx = new Matrix3x2f(var0.pose());
            if (var7) {
               var sxxxxxxxx = new ArrayList(sxx * 4);

               for (int sxxxxxxxxx = sxx; sxxxxxxxxx > 0; sxxxxxxxxx--) {
                  int sxxxxxxxxxx = sxxxxx != null ? sxxxxx[sxxxxxxxxx] : var9;
                  float sxxxxxxxxxxx = sxxx[sxxxxxxxxx] * var5;
                  float sxxxxxxxxxxxx = sxxxx[sxxxxxxxxx] * var5;
                  float sxxxxxxxxxxxxx = sxxx[sxxxxxxxxx - 1] * var5;
                  float sxxxxxxxxxxxxxx = sxxxx[sxxxxxxxxx - 1] * var5;
                  sxxxxxxxx.add(new WheelSectorRenderState.Nested280(var1, var2, sxxxxxxxxxx));
                  sxxxxxxxx.add(new WheelSectorRenderState.Nested280(var1 + sxxxxxxxxxxx, var2 + sxxxxxxxxxxxx, sxxxxxxxxxx));
                  sxxxxxxxx.add(new WheelSectorRenderState.Nested280(var1 + sxxxxxxxxxxxxx, var2 + sxxxxxxxxxxxxxx, sxxxxxxxxxx));
                  sxxxxxxxx.add(new WheelSectorRenderState.Nested280(var1, var2, sxxxxxxxxxx));
               }

               GuiRenderBatch.method05186(
                  var0.guiRenderState, new WheelSectorRenderState(sxxxxxxxx, var1 - var5, var2 - var5, var5 * 2.0F, var5 * 2.0F, sxxxxxx, sxxxxxxx)
               );
            }

            float sxxxxxxxx = var5 - var6 / 2.0F;
            float sxxxxxxxxx = var5 + var6 / 2.0F;
            var sxxxxxxxxxx = new ArrayList(sxx * 4);

            for (int sxxxxxxxxxxx = sxx; sxxxxxxxxxxx > 0; sxxxxxxxxxxx--) {
               int sxxxxxxxxxxxx = sxxxxx != null ? sxxxxx[sxxxxxxxxxxx] : var9;
               int sxxxxxxxxxxxxx = sxxxxx != null ? sxxxxx[sxxxxxxxxxxx - 1] : var9;
               float sxxxxxxxxxxxxxx = sxxx[sxxxxxxxxxxx];
               float sxxxxxxxxxxxxxxx = sxxxx[sxxxxxxxxxxx];
               float sxxxxxxxxxxxxxxxx = sxxx[sxxxxxxxxxxx - 1];
               float sxxxxxxxxxxxxxxxxx = sxxxx[sxxxxxxxxxxx - 1];
               sxxxxxxxxxx.add(
                  new RoundedBorderRenderState.Nested202(var1 + sxxxxxxxxxxxxxx * sxxxxxxxx, var2 + sxxxxxxxxxxxxxxx * sxxxxxxxx, sxxxxxxxxxxxx, field21977)
               );
               sxxxxxxxxxx.add(new RoundedBorderRenderState.Nested202(var1 + sxxxxxxxxxxxxxx * sxxxxxxxxx, var2 + sxxxxxxxxxxxxxxx * sxxxxxxxxx, sxxxxxxxxxxxx, 1.0F));
               sxxxxxxxxxx.add(
                  new RoundedBorderRenderState.Nested202(var1 + sxxxxxxxxxxxxxxxx * sxxxxxxxxx, var2 + sxxxxxxxxxxxxxxxxx * sxxxxxxxxx, sxxxxxxxxxxxxx, 1.0F)
               );
               sxxxxxxxxxx.add(
                  new RoundedBorderRenderState.Nested202(var1 + sxxxxxxxxxxxxxxxx * sxxxxxxxx, var2 + sxxxxxxxxxxxxxxxxx * sxxxxxxxx, sxxxxxxxxxxxxx, field21978)
               );
            }

            GuiRenderBatch.method05186(
               var0.guiRenderState,
               new RoundedBorderRenderState(sxxxxxxxxxx, var1 - sxxxxxxxxx, var2 - sxxxxxxxxx, sxxxxxxxxx * 2.0F, sxxxxxxxxx * 2.0F, sxxxxxx, sxxxxxxx)
            );
         }
      }

      public static void method09707(
         GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, boolean var7, float var8, int var9
      ) {
         method09706(var0, var1, var2, var3, var4, var5, var6, var7, false, ColorUtils.method04611(var9, var8), 0, 0, 0, -1, 0, 0);
      }

      public static void method09708(
         GuiGraphicsExtractor var0,
         float var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         boolean var7,
         float var8,
         int var9,
         int var10,
         int var11
      ) {
         method09706(
            var0,
            var1,
            var2,
            var3,
            var4,
            var5,
            var6,
            var7,
            true,
            0,
            ColorUtils.method04611(var9, var8),
            ColorUtils.method04611(var10, var8),
            Math.max(1, var11),
            -1,
            0,
            0
         );
      }

      public static void method09709(
         GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, boolean var7, float var8
      ) {
         method09706(
            var0,
            var1,
            var2,
            var3,
            var4,
            var5,
            var6,
            var7,
            true,
            0,
            ColorUtils.method04611(ColorUtils.Nested138.method04636(), var8),
            ColorUtils.method04611(ColorUtils.Nested138.method04637(), var8),
            4,
            -1,
            0,
            0
         );
      }

      public static void method09710(
         GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, boolean var7, float var8, int var9, int var10
      ) {
         method09708(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, 4);
      }

      public static void method09711(
         GuiGraphicsExtractor var0,
         float var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         float var7,
         int var8,
         int var9,
         int var10,
         int var11,
         int var12
      ) {
         float var13 = Math.max(var3, var4);
         int var14 = (int)var13 > (int)var3 ? (int)var3 : -1;
         method09706(
            var0,
            var1,
            var2,
            0.0F,
            var13,
            var5,
            var6,
            false,
            true,
            0,
            ColorUtils.method04611(var8, var7),
            ColorUtils.method04611(var9, var7),
            Math.max(1, var12),
            var14,
            ColorUtils.method04611(var10, var7),
            ColorUtils.method04611(var11, var7)
         );
      }
   }
}
