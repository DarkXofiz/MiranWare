// Original binary: sg/ec/xabzW0bo0T5I3b0o
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class DiagramWindow extends FloatingWindow {
   private static final float field25912 = 116.0F;
   private static final float field25913 = 0;
   private static final float field25914 = 0;
   private static final float field25915 = 0;
   private static final float field25916 = 0;
   private static final float field25917 = 0;
   private static final float field25918 = 0;
   private final SliderSetting field25919;
   private final FloatingWindow field25920;
   private final SmoothAnimation field25921 = new SmoothAnimation();
   private final SmoothAnimation field25922 = new SmoothAnimation();
   private boolean field25923;
   private float field25924;
   private float field25925;
   private float field25926;
   private float field25927;
   private float field25928;
   private float field25929;
   private float field25930;
   private float field25931;
   private static final String field25932 = "menu.diagrama";
   private static final float field25933 = 116.0F;
   private static final float field25934 = 140.0F;
   private static final float field25935 = 7.0F;
   private static final float field25936 = 7.0F;
   private static final double field25937 = 0.2F;
   private static final double field25938 = 0.2F;
   private static final float field25939 = 0.001F;
   private static final float field25940 = 0.22F;
   private static final float field25941 = 0.95F;
   private static final float field25942 = 0.58F;
   private static final float field25943 = 0.95F;
   private static final float field25944 = 0.65F;
   private static final float field25945 = 0.35F;
   private static final float field25946 = 0.8F;
   private static final float field25947 = 0.35F;
   private static final float field25948 = 6.0F;
   private static final float field25949 = 6.0F;
   private static final float field25950 = 4.0F;
   private static final float field25951 = 4.0F;
   private static final float field25952 = 1.8F;
   private static final float field25953 = 7.0F;
   private static final float field25954 = 6.0F;
   private static final float field25955 = 2.1F;
   private static final float field25956 = 3.6F;
   private static final float field25957 = 4.2F;
   private static final float field25958 = 2.1F;
   private static final float field25959 = 2.1F;
   private static final float field25960 = 4.2F;
   private static final float field25961 = 4.2F;
   private static final float field25962 = 2.1F;
   private static final float field25963 = Float.MAX_VALUE;
   private static final float field25964 = -Float.MAX_VALUE;
   private static final float field25965 = 1.0E-4F;
   private static final float field25966 = 3.0F;
   private static final float field25967 = 3.0F;
   private static final float field25968 = 16.0F;
   private static final float field25969 = 80.0F;
   private static final float field25970 = 8.0F;
   private static final float field25971 = 5.0F;
   private static final float field25972 = 14.0F;
   private static final float field25973 = 8.0F;
   private static final float field25974 = 8.0F;
   private static final double field25975 = 1.0E-4;
   private static final double field25976 = 1.0E-4;
   private static final float field25977 = 360.0F;
   private static final float field25978 = 360.0F;
   private static final float field25979 = 360.0F;
   private static final float field25980 = 15.0F;
   private static final float field25981 = 15.0F;
   private static final float field25982 = 360.0F;
   private static final float field25983 = 5.0F;
   private static final float field25984 = 15.0F;

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method11323();
      if (this.field25923) {
         this.method11324(var2, var3);
      }

      ThemeSettings var5 = ThemeManager.INSTANCE.method09611();
      float sx = this.method09573().method06173();
      float sxx = (float)Math.toRadians(this.field25919.method00358());
      float sxxx = this.field25926 - field25936;
      this.field25921.method06162();
      this.field25922.method06162();
      this.field25921.method06168(this.field25924 + Mth.sin(sxx) * sxxx, field25937, Easings.field19400, true);
      this.field25922.method06168(this.field25925 - Mth.cos(sxx) * sxxx, field25938, Easings.field19400, true);
      float sxxxx = this.field25921.method06173();
      float sxxxxx = this.field25922.method06173();
      float sxxxxxx = sxxxx - this.field25924;
      float sxxxxxxx = sxxxxx - this.field25925;
      float sxxxxxxxx = Mth.sqrt(sxxxxxx * sxxxxxx + sxxxxxxx * sxxxxxxx);
      if (sxxxxxxxx > field25939) {
         sxxxx = this.field25924 + sxxxxxx / sxxxxxxxx * sxxx;
         sxxxxx = this.field25925 + sxxxxxxx / sxxxxxxxx * sxxx;
      }

      int sxxxxxxxxx = ColorUtils.method04611(
         ColorUtils.method04631(var5.field22121.method11676(), var5.field22119.method11676(), field25940), sx * field25941
      );
      int sxxxxxxxxxx = ColorUtils.method04611(
         ColorUtils.method04631(var5.field22121.method11676(), var5.field22120.method11676(), field25942), sx * field25943
      );
      int sxxxxxxxxxxx = ColorUtils.method04611(var5.field22117.method11676(), sx * field25944);
      int sxxxxxxxxxxxx = ColorUtils.method04611(var5.field22117.method11676(), sx);
      int sxxxxxxxxxxxxx = ColorUtils.method04611(
         ColorUtils.method04631(var5.field22120.method11676(), var5.field22121.method11676(), field25945), sx
      );
      int sxxxxxxxxxxxxxx = ColorUtils.method04611(var5.field22110.method11676(), sx * field25946);
      int sxxxxxxxxxxxxxxx = ColorUtils.method04611(var5.field22113.method11676(), sx);
      int sxxxxxxxxxxxxxxxx = ColorUtils.method04605(
         ColorUtils.method04631(var5.field22113.method11676(), ColorUtils.method04604(255, 255, 255), field25947), sx
      );
      int sxxxxxxxxxxxxxxxxx = ColorUtils.method04611(var5.field22109.method11676(), sx);
      GuiRenderBatch.method05183();
      RoundedRectRenderer.method01275(
         var1,
         this.method09576(),
         this.method09560(),
         this.method09568(),
         this.method09574(),
         field25948,
         1.0F,
         new CornerColors(sxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxxx)
      );
      GuiShapeRenderer.method09703(var1, this.method09576(), this.method09560(), this.method09568(), this.method09574(), field25949, 1.0F, sxxxxxxxxxxx);
      float sxxxxxxxxxxxxxxxxxx = this.field25926 * 2.0F;
      RoundedRectRenderer.method01274(var1, this.field25924, this.field25925, sxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxx);
      GuiShapeRenderer.method09703(
         var1,
         this.field25924 - this.field25926,
         this.field25925 - this.field25926,
         sxxxxxxxxxxxxxxxxxx,
         sxxxxxxxxxxxxxxxxxx,
         this.field25926,
         1.0F,
         sxxxxxxxxxxxx
      );

      for (int sxxxxxxxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxxxxxxxx < 4; sxxxxxxxxxxxxxxxxxxx++) {
         float sxxxxxxxxxxxxxxxxxxxx = (float)Math.toRadians(sxxxxxxxxxxxxxxxxxxx * 90);
         float sxxxxxxxxxxxxxxxxxxxxx = this.field25924 + Mth.sin(sxxxxxxxxxxxxxxxxxxxx) * (this.field25926 - field25950);
         float sxxxxxxxxxxxxxxxxxxxxxx = this.field25925 - Mth.cos(sxxxxxxxxxxxxxxxxxxxx) * (this.field25926 - field25951);
         RoundedRectRenderer.method01274(var1, sxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxx, field25952, sxxxxxxxxxxxxxx);
      }

      this.method11322(var1, sx, sxxxxxxxxxxx);
      String sxxxxxxxxxxxxxxxxxxx = Math.round(this.field25919.method00358()) + "°";
      float sxxxxxxxxxxxxxxxxxxxx = field25953;
      Fonts.field00109
         .method09480(
            var1,
            sxxxxxxxxxxxxxxxxxxx,
            this.field25924 - Fonts.field00109.method09486(sxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxx) / 2.0F,
            this.field25931,
            sxxxxxxxxxxxxxxxxx,
            sxxxxxxxxxxxxxxxxxxxx
         );
      GuiRenderBatch.method05183();

      for (int sxxxxxxxxxxxxxxxxxxxxx = 1; sxxxxxxxxxxxxxxxxxxxxx <= 6; sxxxxxxxxxxxxxxxxxxxxx++) {
         float sxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxx / field25954;
         RoundedRectRenderer.method01274(
            var1,
            this.field25924 + (sxxxx - this.field25924) * sxxxxxxxxxxxxxxxxxxxxxx,
            this.field25925 + (sxxxxx - this.field25925) * sxxxxxxxxxxxxxxxxxxxxxx,
            field25955,
            sxxxxxxxxxxxxxxx
         );
      }

      RoundedRectRenderer.method01274(var1, this.field25924, this.field25925, field25956, sxxxxxxxxxxxxxxxxx);
      RoundedRectRenderer.method01274(var1, sxxxx, sxxxxx, field25957, sxxxxxxxxxxxxxxxx);
      GuiShapeRenderer.method09703(var1, sxxxx - field25958, sxxxxx - field25959, field25960, field25961, field25962, 1.0F, sxxxxxxxxxxxx);
   }

   @Override
   public void method06773() {
      super.method06773();
      if (this.field25920 != null) {
         this.field25920.method09565(true);
      }
   }

   @Override
   public void method04220() {
      super.method04220();
      this.method08971(field25933);
      this.method09561(field25934);
      this.method11323();
      float var1 = (float)Math.toRadians(this.field25919.method00358());
      float var2 = this.field25926 - field25935;
      float var3 = this.field25924 + Mth.sin(var1) * var2;
      float var4 = this.field25925 - Mth.cos(var1) * var2;
      this.field25921.method06155(var3);
      this.field25921.method06175(var3);
      this.field25922.method06155(var4);
      this.field25922.method06175(var4);
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      double var6 = Math.hypot(var1 - this.field25924, var3 - this.field25925);
      if (!(var6 > this.field25926 + field25983)) {
         if (var5 == 0) {
            this.field25923 = true;
            this.method11324(var1, var3);
         } else if (var5 == 2) {
            this.field25919.method00869();
         }
      }
   }

   private void method11322(GuiGraphics var1, float var2, int var3) {
      int var4 = ColorUtils.Nested138.method04636();
      int var5 = ColorUtils.Nested138.method04637();
      float var6 = this.field25919.method00359();
      float var7 = this.field25919.method00357();
      float[] var8 = new float[]{0.0F, 0.0F, 1.0F, 1.0F};
      float[] var9 = new float[]{1.0F, 0.0F, 0.0F, 1.0F};
      float[] var10 = new float[4];
      float var11 = field25963;
      float var12 = field25964;

      for (int var13 = 0; var13 < 4; var13++) {
         var10[var13] = var8[var13] * var6 + var9[var13] * var7;
         var11 = Math.min(var11, var10[var13]);
         var12 = Math.max(var12, var10[var13]);
      }

      float var17 = Math.max(field25965, var12 - var11);
      int[] var14 = new int[4];

      for (int var15 = 0; var15 < 4; var15++) {
         float var16 = (var10[var15] - var11) / var17;
         var14[var15] = ColorUtils.method04611(ColorUtils.method04631(var5, var4, var16), var2);
      }

      RoundedRectRenderer.method01275(
         var1,
         this.field25927,
         this.field25928,
         this.field25929,
         this.field25930,
         field25966,
         1.0F,
         new CornerColors(var14[0], var14[1], var14[2], var14[3])
      );
      GuiShapeRenderer.method09703(var1, this.field25927, this.field25928, this.field25929, this.field25930, field25967, 1.0F, var3);
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (var5 != 0.0) {
         float var7 = ContainerHelper.method03211() ? field25984 : 1.0F;
         this.field25919.method03014(this.field25919.method00358() + (float)(var5 * var7));
      }
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      this.field25923 = false;
   }

   public DiagramWindow(SliderSetting var1, FloatingWindow var2) {
      super(field25932);
      this.field25919 = var1;
      this.field25920 = var2;
   }

   private void method11323() {
      float var1 = this.method09568() - field25968;
      float var2 = Math.min(var1, field25969);
      this.field25926 = var2 / 2.0F;
      this.field25924 = this.method09576() + this.method09568() / 2.0F;
      this.field25925 = this.method09560() + field25970 + this.field25926;
      this.field25931 = this.field25925 + this.field25926 + field25971;
      this.field25929 = var1;
      this.field25930 = field25972;
      this.field25927 = this.method09576() + field25973;
      this.field25928 = this.method09560() + this.method09574() - field25974 - this.field25930;
   }

   private void method11324(double var1, double var3) {
      double var5 = var1 - this.field25924;
      double var7 = var3 - this.field25925;
      if (!(Math.abs(var5) < field25975) || !(Math.abs(var7) < field25976)) {
         float var9 = (float)Math.toDegrees(Math.atan2(var5, -var7));
         var9 = (var9 % field25977 + field25978) % field25979;
         if (ContainerHelper.method03211()) {
            var9 = Math.round(var9 / field25980) * field25981 % field25982;
         }

         this.field25919.method03014(var9);
      }
   }
}
