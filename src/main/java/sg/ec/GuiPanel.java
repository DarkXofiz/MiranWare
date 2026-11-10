// Original binary: sg/ec/qPz7rDwu1KT7SKqH
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.IntFunction;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public abstract class GuiPanel implements MinecraftAccess {
   protected static final float field22842 = 6.0F;
   protected static final float field22843 = 0;
   protected static final float field22844 = 0;
   protected static final float field22845 = 0;
   protected static final float field22846 = 0;
   protected static final float field22847 = 0;
   protected static final float field22848 = 0;
   protected static final float field22849 = 0;
   protected static final float field22850 = 0;
   protected static final float field22851 = 0;
   protected static final float field22852 = 0;
   protected static final float field22853 = 0;
   protected static final float field22854 = 0;
   protected static final float field22855 = 0;
   protected static final float field22856 = 0;
   protected static final float field22857 = 0;
   protected static final float field22858 = 0;
   protected static final float field22859 = 0;
   protected static final float field22860 = 0;
   protected static final float field22861 = 0;
   protected static final long field22862 = 0;
   protected static final float field22863 = 0;
   protected static final long field22864 = 0;
   protected static final long field22865 = 0;
   protected static final long field22866 = 0;
   protected static final long field22867 = 0;
   protected static final long field22868 = 0;
   protected static final long field22869 = 0;
   protected static final int field22870 = ColorUtils.method04604(235, 90, 90);
   protected static final int field22871 = ColorUtils.method04604(120, 230, 130);
   protected static final int field22872 = ColorUtils.method04604(240, 180, 80);
   private final Map<Object, AnimationUtils> field22873 = new HashMap<>();
   protected final Map<String, GuiPanel.Nested291> field22874 = new LinkedHashMap<>();
   protected final GuiPanel.Nested284 field22875 = new GuiPanel.Nested284();
   protected final AnimationUtils field22876;
   protected final AnimationUtils field22877;
   protected final AnimationUtils field22878;
   protected boolean field22879;
   protected float field22880;
   protected float field22881;
   protected boolean field22882;
   protected GuiPanel.Nested283[] field22883;
   protected final List<GuiPanel.Nested283> field22884;
   protected final List<Runnable> field22885;
   protected Object field22886;
   private static final long field22887 = 150L;
   private static final long field22888 = 260L;
   private static final long field22889 = 260L;
   private static final float field22890 = 0.025F;
   private static final float field22891 = 31.0F;
   private static final float field22892 = 5.0F;
   private static final float field22893 = 26.0F;
   private static final float field22894 = 31.0F;
   private static final float field22895 = 5.0F;
   private static final float field22896 = 26.0F;
   private static final float field22897 = 0.02F;
   private static final float field22898 = 3.0F;
   private static final float field22899 = 26.0F;
   private static final float field22900 = 3.0F;
   private static final float field22901 = 0.02F;
   private static final float field22902 = 18.0F;
   private static final float field22903 = 6.5F;
   private static final float field22904 = 10.0F;
   private static final float field22905 = 16.0F;
   private static final float field22906 = 4.5F;
   private static final float field22907 = 0.5F;
   private static final float field22908 = 1.5F;
   private static final float field22909 = 1.5F;
   private static final float field22910 = 3.0F;
   private static final float field22911 = 3.0F;
   private static final float field22912 = 3.5F;
   private static final float field22913 = 0.92F;
   private static final float field22914 = 0.3F;
   private static final float field22915 = 0.65F;
   private static final float field22916 = 0.35F;
   private static final float field22917 = 45.0F;
   private static final float field22918 = 45.0F;
   private static final float field22919 = 6.0F;
   private static final float field22920 = 6.0F;
   private static final float field22921 = 0.001F;
   private static final float field22922 = 6.5F;
   private static final float field22923 = 12.0F;
   private static final float field22924 = 4.0F;
   private static final float field22925 = 8.0F;
   private static final float field22926 = 0.3F;
   private static final float field22927 = 0.6F;
   private static final float field22928 = 0.4F;
   private static final float field22929 = 0.01F;
   private static final float field22930 = 5.5F;
   private static final float field22931 = 4.0F;
   private static final float field22932 = 12.0F;
   private static final float field22933 = 6.0F;
   private static final float field22934 = 19.0F;
   private static final float field22935 = 3.0F;
   private static final float field22936 = 3.0F;
   private static final float field22937 = 13.0F;
   private static final float field22938 = 0.5F;
   private static final float field22939 = 4.0F;
   private static final float field22940 = 6.5F;
   private static final float field22941 = 0.96F;
   private static final float field22942 = 6.5F;
   private static final float field22943 = 0.5F;
   private static final float field22944 = 4.0F;
   private static final float field22945 = 0.5F;
   private static final float field22946 = 0.2F;
   private static final float field22947 = 0.4F;
   private static final float field22948 = 4.0F;
   private static final float field22949 = 0.5F;
   private static final float field22950 = 0.5F;
   private static final float field22951 = 6.5F;
   private static final float field22952 = 0.28F;
   private static final float field22953 = 0.01F;
   private static final float field22954 = 6.5F;
   private static final float field22955 = 0.05F;
   private static final float field22956 = 6.5F;
   private static final float field22957 = 0.3F;
   private static final float field22958 = 0.5F;
   private static final float field22959 = 0.22F;
   private static final float field22960 = 0.1F;
   private static final float field22961 = 4.0F;
   private static final float field22962 = 0.7F;
   private static final float field22963 = 0.32F;
   private static final float field22964 = 5.5F;
   private static final float field22965 = 0.35F;
   private static final float field22966 = 0.65F;
   private static final float field22967 = 5.5F;
   private static final float field22968 = 4.0F;
   private static final float field22969 = 0.65F;
   private static final float field22970 = 4.0F;
   private static final float field22971 = 0.5F;
   private static final float field22972 = 0.6F;
   private static final String field22973 = "<";
   private static final String field22974 = ">";
   private static final float field22975 = 5.5F;
   private static final float field22976 = 5.5F;
   private static final float field22977 = 4.0F;
   private static final float field22978 = 0.35F;
   private static final float field22979 = 5.5F;
   private static final float field22980 = 5.5F;
   private static final float field22981 = 4.0F;
   private static final float field22982 = 0.65F;
   private static final float field22983 = 0.8F;
   private static final String field22984 = "X";
   private static final float field22985 = 6.0F;
   private static final float field22986 = 6.0F;
   private static final float field22987 = 1.8F;
   private static final float field22988 = 3.0F;
   private static final float field22989 = 5.0F;
   private static final float field22990 = 5.0F;
   private static final float field22991 = 0.35F;
   private static final float field22992 = 0.8F;
   private static final float field22993 = 5.5F;
   private static final float field22994 = 4.0F;
   private static final float field22995 = 5.0F;
   private static final float field22996 = 2.75F;
   private static final float field22997 = 1.5F;
   private static final float field22998 = 0.8F;
   private static final float field22999 = 7.0F;
   private static final float field23000 = 0.7F;
   private static final float field23001 = 7.0F;
   private static final float field23002 = 0.001F;
   private static final float field23003 = 0.02F;
   private static final long field23004 = 150L;

   protected static int method10162() {
      return method10221().field22120.method11676();
   }

   private void method10163(GuiGraphics var1, GuiPanel.Nested283 var2, String var3, float var4, float var5) {
      FontRenderer var6 = Fonts.field00110;
      RoundedRectRenderer.method01272(
         var1,
         var2.field23010(),
         var2.field23011(),
         var2.field23012(),
         var2.field23013(),
         field22977,
         1.0F,
         method10227(method10198(), field22978 * var5 * var4)
      );
      var6.method09473(
         var1,
         var3,
         var2.field23010() + var2.field23012() / 2.0F,
         var2.field23011() + var2.field23013() / 2.0F - var6.method09485(field22979) / 2.0F,
         method10227(method10188(method10213(), method10175(), var4), var5),
         field22980
      );
   }

   protected void method10164(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, Object var7, String var8, boolean var9) {
      float var10 = this.method10168(var7, var9);
      if (!(var10 <= field23002)) {
         this.method10218(var1, var2 * var10, var3, var4, var5, var6, var8);
      }
   }

   public GuiPanel() {
      this.field22876 = method10166(field22887);
      this.field22877 = method10166(field22888);
      this.field22878 = method10166(field22889);
      this.field22882 = true;
      this.field22883 = new GuiPanel.Nested283[0];
      this.field22884 = new ArrayList<>();
      this.field22885 = new ArrayList<>();
   }

   protected void method02351(int var1) {
   }

   protected static AnimationUtils method10166(long var0) {
      return new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, var0);
   }

   protected float method10167(GuiGraphics var1, float var2, float var3, float var4, GuiIcon var5, String var6, float var7, float var8) {
      return GuiPanelRenderer.method00764(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   protected float method10168(Object var1, boolean var2) {
      AnimationUtils var3 = this.field22873.computeIfAbsent(var1, var0 -> method10166(field23004));
      var3.method03375(var2 ? 1.0 : 0.0);
      return var3.method03377();
   }

   protected void method10169(GuiGraphics var1, GuiPanel.Nested283 var2, float var3, float var4) {
      RoundedRectRenderer.method01272(
         var1,
         var2.field23010(),
         var2.field23011(),
         var2.field23012(),
         var2.field23013(),
         field22981,
         1.0F,
         method10188(method10227(method10162(), field22982 * var4), method10227(field22870, field22983 * var4), var3)
      );
      Fonts.field00109
         .method09473(
            var1,
            field22984,
            var2.field23010() + var2.field23012() / 2.0F,
            var2.field23011() + var2.field23013() / 2.0F - Fonts.field00109.method09485(field22985) / 2.0F,
            method10227(method10188(method10213(), method10175(), var3), var4),
            field22986
         );
   }

   protected void method10170(
      String var1,
      int var2,
      IntFunction<String> var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      boolean var10,
      GuiPanel.Nested286 var11
   ) {
      for (int var12 = 0; var12 < var2; var12++) {
         GuiPanel.Nested291 var13 = this.field22874.computeIfAbsent(var1 + (String)var3.apply(var12), var0 -> new GuiPanel.Nested291());
         var13.field23076 = true;
         float var14 = var12 * field22894;
         if (!var13.field23075) {
            method10205(var13.field23068, var14);
            var13.field23075 = true;
         }

         if (var10) {
            method10205(var13.field23068, var14);
            method10205(var13.field23069, 1.0F);
         } else {
            var13.field23068.method03375(var14);
            var13.field23069.method03375(1.0);
         }

         float var15 = var13.field23069.method03377();
         float var16 = var4 + var13.field23068.method03377() + (1.0F - var15) * field22895;
         var13.field23077 = var16;
         if (var16 + field22896 >= var5 && var16 <= var6) {
            var11.method10239(var9 * var15, var7, var16, var8, var13, var12);
         }
      }
   }

   protected boolean method10171(String var1) {
      for (var var3 : this.field22874.entrySet()) {
         if (((String)var3.getKey()).startsWith(var1)
            && !((GuiPanel.Nested291)var3.getValue()).field23076
            && ((GuiPanel.Nested291)var3.getValue()).field23069.method03377() > field22901) {
            return true;
         }
      }

      return false;
   }

   protected final void method10172(int var1, int var2) {
      this.field22881 = this.field22876.method03377();
      this.field22875.method10231(var1, var2);
      this.method10196();
   }

   protected static GuiPanel.Nested287 method10174(final BooleanSupplier var0, final Consumer<Boolean> var1) {
      return new GuiPanel.Nested287()      // $VF: Compiled from s
 {
         @Override
         public boolean method10240() {
            return var0.getAsBoolean();
         }

         @Override
         public void method10241(boolean var1x) {
            var1.accept(var1x);
         }
      };
   }

   protected static int method10175() {
      return method10221().field22109.method11676();
   }

   protected static float method10176(String var0) {
      return GuiPanelRenderer.method00766(var0);
   }

   protected void method10178(GuiGraphics var1, GuiPanel.Nested283 var2, float var3, float var4, float var5) {
      GuiPanelRenderer.method00761(var1, var2.field23010() + var2.field23012() / 2.0F, var2.field23011() + var2.field23013() / 2.0F, var4, var3, var5);
   }

   protected static boolean method10179(GuiPanel.Nested283 var0, float var1, float var2) {
      return var0 != null && var0.has(var1, var2);
   }

   protected void method10180(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      int var8 = ColorUtils.method04631(
         ColorUtils.method04611(method10221().field22114.method11679(), var7),
         ColorUtils.method04611(method10221().field22113.method11679(), var7),
         var6
      );
      RoundedRectRenderer.method01272(var1, var2, var3, var4, var5, var5 * field22991, field22992, var8);
      float var9 = field22993;
      RoundedRectRenderer.method01272(
         var1,
         var2 + 2.0F + (var4 - field22994 - field22995) * var6,
         var3 + var5 / 2.0F - field22996,
         var9,
         var9,
         field22997,
         field22998,
         ColorUtils.method04611(method10221().field22109.method11679(), var7)
      );
   }

   protected final boolean method10181(double var1) {
      this.field22880 = this.field22880 + (float)var1 * field22902;
      return true;
   }

   protected static void method10182(AnimationUtils var0) {
      method10205(var0, 0.0F);
   }

   protected void method10183(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6) {
      RoundedRectRenderer.method01272(var1, var3, var4, var5, var6, field22956, 1.0F, method10227(method10186(), field22957 * var2));
   }

   protected final int method10184(float var1, float var2) {
      for (int var3 = 0; var3 < this.field22883.length; var3++) {
         if (method10179(this.field22883[var3], var1, var2)) {
            return var3;
         }
      }

      return -1;
   }

   protected void method10185(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6) {
      for (GuiPanel.Nested291 var8 : this.field22874.values()) {
         if (!var8.field23076 && var8.field23078 != null) {
            var8.field23069.method03375(0.0);
            float var9 = var8.field23069.method03377();
            if (!(var9 <= field22897)) {
               float var10 = var8.field23077 - (1.0F - var9) * field22898;
               if (!(var10 + field22899 < var5) && !(var10 > var6)) {
                  boolean var11 = this.field22882;
                  this.field22882 = false;
                  var8.field23078.method10242(var1, var2 * var9, var3, var10, var4, (1.0F - var9) * field22900);
                  this.field22882 = var11;
               }
            }
         }
      }
   }

   protected static int method10186() {
      return ColorUtils.method04583(method10187(), ColorUtils.field10170, field22890);
   }

   protected static int method10187() {
      return method10221().field22119.method11676();
   }

   protected static int method10188(int var0, int var1, float var2) {
      return ColorUtils.method04631(var0, var1, var2);
   }

   protected static float method10189(List<GuiPanel.Nested288> var0) {
      float var1 = 0.0F;

      for (GuiPanel.Nested288 var3 : var0) {
         var1 += var3.method10230() + field22989;
      }

      return var1;
   }

   protected void method10190(GuiGraphics var1, GuiPanel.Nested283 var2, String var3, float var4, int var5, float var6) {
      FontRenderer var7 = Fonts.field00110;
      float var8 = Math.min(field22961, var2.field23013() / 2.0F);
      RoundedRectRenderer.method01272(
         var1,
         var2.field23010(),
         var2.field23011(),
         var2.field23012(),
         var2.field23013(),
         var8,
         1.0F,
         method10188(method10227(method10162(), field22962 * var6), method10227(var5, field22963 * var6), var4)
      );
      var7.method09473(
         var1,
         var3,
         var2.field23010() + var2.field23012() / 2.0F,
         var2.field23011() + var2.field23013() / 2.0F - var7.method09485(field22964) / 2.0F,
         method10227(method10188(method10213(), method10175(), field22965 + field22966 * var4), var6),
         field22967
      );
   }

   protected void method10191(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6) {
      RoundedRectRenderer.method01272(var1, var2, var3, var4, var5, field22940, 1.0F, method10227(method10221().field22121.method11676(), field22941 * var6));
      GuiShapeRenderer.method09703(var1, var2, var3, var4, var5, field22942, 1.0F, method10227(method10223(), field22943 * var6));
   }

   protected boolean method10192(
      GuiGraphics var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      String[] var9,
      int var10,
      String var11,
      AnimationUtils var12,
      AnimationUtils var13,
      boolean var14,
      GuiPanel.Nested283[] var15,
      boolean[] var16
   ) {
      FontRenderer var17 = Fonts.field00110;
      float var18 = field22922;
      float var19 = field22923;
      float var20 = var19 * (var9.length - 1);

      for (String var24 : var9) {
         var20 += var17.method09486(var24, var18);
      }

      float var31 = var5 + var7 / 2.0F - var20 / 2.0F;
      float var32 = var6 + var8 / 2.0F - var17.method09485(var18) / 2.0F;
      float var33 = var31;
      float var34 = 0.0F;

      for (int var25 = 0; var25 < var9.length; var25++) {
         float var26 = var17.method09486(var9[var25], var18);
         GuiPanel.Nested283 var27 = new GuiPanel.Nested283(var31 - field22924, var6, var26 + field22925, var8);
         boolean var28 = var16 != null && var25 < var16.length && var16[var25];
         var15[var25] = var28 ? null : var27;
         if (var28) {
            var17.method09480(var1, var9[var25], var31, var32, method10227(method10213(), field22926 * var4), var18);
         } else {
            boolean var29 = var25 == var10;
            float var30 = this.method10168(var11 + var25, var29 || var27.has(var2, var3));
            var17.method09480(
               var1, var9[var25], var31, var32, method10227(method10188(method10213(), method10175(), var30), (field22927 + field22928 * var30) * var4), var18
            );
            if (var29) {
               var33 = var31;
               var34 = var26;
            }
         }

         var31 += var26 + var19;
      }

      if (!var14) {
         method10205(var12, var33);
         method10205(var13, var34);
      }

      var12.method03375(var33);
      var13.method03375(var34);
      this.method10210(var1, var12.method03377(), var32 + var17.method09485(var18) + 2.0F, var13.method03377(), var4);
      return true;
   }

   protected void method10193(
      GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, List<GuiPanel.Nested288> var9
   ) {
      float var10 = var7 + var8;

      for (GuiPanel.Nested288 var12 : var9) {
         var12.method10229(var1, var2, var3, var4, var5, var6, var10);
         var10 += var12.method10230() + field22990;
      }
   }

   protected void method10194(
      GuiGraphics var1, float var2, float var3, float var4, GuiPanel.Nested290 var5, String[] var6, float var7, float var8, boolean var9
   ) {
      var5.field23020.method03375(var9 ? 1.0 : 0.0);
      float var10 = var5.field23020.method03377();
      if (var10 <= field22929) {
         var5.field23023 = new GuiPanel.Nested283[0];
      } else {
         FontRenderer var11 = Fonts.field00110;
         float var12 = field22930;
         float[] var13 = new float[var6.length];
         float var14 = field22931 * (var6.length - 1);

         for (int var15 = 0; var15 < var6.length; var15++) {
            var13[var15] = var11.method09486(var6[var15], var12) + field22932;
            var14 += var13[var15];
         }

         float var29 = var14 + field22933;
         float var16 = field22934;
         float var17 = var8 + 1.0F;
         float var18 = var7 - var29 / 2.0F;
         float var19 = var17 - var16;
         var5.field23024 = var18;
         var5.field23025 = var19;
         var5.field23026 = var29;
         var5.field23027 = var16;
         float var20 = var4 * var10;
         GuiPanel.Nested283[] var21 = new GuiPanel.Nested283[var6.length];
         GuiRenderBatch.method05183();
         var1.pose().pushMatrix();
         var1.pose().translate(var7, var19);
         var1.pose().scale(var10, var10);
         var1.pose().translate(-var7, -var19);
         this.method10191(var1, var18, var19, var29, var16, var20);
         float var22 = var18 + field22935;
         float var23 = var19 + field22936;

         for (int var24 = 0; var24 < var6.length; var24++) {
            GuiPanel.Nested283 var25 = new GuiPanel.Nested283(var22, var23, var13[var24], field22937);
            var21[var24] = var25;
            boolean var26 = var24 == var5.field23022;
            float var27 = var5.method10250("h" + var24, var26 || var10 > field22938 && var25.has(var2, var3));
            float var28 = var5.method10250("a" + var24, var26);
            this.method10217(var1, var11, var25, var6[var24], var12, var27, var28, var20);
            var22 += var13[var24] + field22939;
         }

         var1.pose().popMatrix();
         GuiRenderBatch.method05184();
         var5.field23023 = var21;
      }
   }

   protected void method10195(
      GuiGraphics var1, GuiPanel.Nested283 var2, String var3, float var4, float var5, float var6, Runnable var7, Runnable var8
   ) {
      this.method10212(var1, var2, var3, var4, var5, var6, var7, var8, null);
   }

   protected final void method10196() {
      this.field22880 = 0.0F;
      method10182(this.field22876);
   }

   protected void method10197(GuiGraphics var1, GuiPanel.Nested283 var2, float var3, float var4) {
      float var5 = field22987;
      float var6 = 2.0F;
      float var7 = var5 * field22988 + var6 * 2.0F;
      float var8 = var2.field23010() + var2.field23012() / 2.0F - var7 / 2.0F;
      float var9 = var2.field23011() + var2.field23013() / 2.0F - var5 / 2.0F;
      int var10 = method10227(method10188(method10213(), method10175(), var3), var4);

      for (int var11 = 0; var11 < 3; var11++) {
         RoundedRectRenderer.method01272(var1, var8 + var11 * (var5 + var6), var9, var5, var5, var5 / 2.0F, 1.0F, var10);
      }
   }

   protected static int method10198() {
      return method10221().field22113.method11676();
   }

   protected GuiPanel.Nested288 method10199(final String var1) {
      return new GuiPanel.Nested288()      // $VF: Compiled from s
 {
         private static final float field23006 = 18.199999F;
         private static final float field23007 = 6.0F;
         private static final float field23008 = 0.85F;
         private static final float field23009 = 6.0F;

         @Override
         public void method10229(GuiGraphics var1x, float var2, float var3, float var4, float var5, float var6, float var7) {
            Fonts.field00110
               .method09480(
                  var1x, var1, var5 + 1.0F, var7 + field23007, GuiPanel.method10227(GuiPanel.method10213(), field23008 * var4), field23009
               );
         }

         @Override
         public float method10230() {
            return field23006;
         }
      };
   }

   protected final void method10200(
      GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, String[] var9, int var10
   ) {
      this.method10216(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, null);
   }

   protected static float method10201(AnimationUtils var0, boolean var1) {
      var0.method03375(var1 ? 1.0 : 0.0);
      return var0.method03377();
   }

   protected void method10202(
      String var1,
      int var2,
      IntFunction<String> var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      boolean var10,
      GuiPanel.Nested286 var11
   ) {
      this.method10214(var1, var2, var3, var4, var5, var6, 0.0F, var7, var8, var9, var10, var11);
   }

   protected final void method10203() {
      this.method10196();
      this.field22874.clear();
      this.field22879 = false;
   }

   protected float method10204(GuiGraphics var1, float var2, float var3, float var4, GuiIcon var5, String var6, int var7, float var8) {
      return GuiPanelRenderer.method00769(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   protected static void method10205(AnimationUtils var0, float var1) {
      var0.method03374(var1);
      var0.method03369(var1);
      var0.method03363();
   }

   protected void method10206(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      RoundedRectRenderer.method01272(var1, var3, var4, var5, var6, field22951, 1.0F, method10227(method10186(), field22952 * var2));
      if (var7 > field22953) {
         RoundedRectRenderer.method01272(var1, var3, var4, var5, var6, field22954, 1.0F, method10227(method10175(), field22955 * var7 * var2));
      }
   }

   protected GuiPanel.Nested288 method10207(
      final String var1,
      final double var2,
      final double var4,
      final double var6,
      final DoubleSupplier var8,
      final DoubleConsumer var9,
      final DoubleFunction<String> var10
   ) {
      return new GuiPanel.Nested288()      // $VF: Compiled from s
 {
         private static final float field23052 = 26.0F;
         private static final float field23053 = 26.0F;
         private static final float field23054 = 66.0F;
         private static final float field23055 = 3.0F;
         private static final float field23056 = 6.5F;
         private static final float field23057 = 6.5F;
         private static final float field23058 = 6.0F;
         private static final float field23059 = 6.0F;
         private static final float field23060 = 6.0F;
         private static final float field23061 = 0.9F;
         private static final float field23062 = 6.0F;
         private static final float field23063 = 0.7F;
         private static final float field23064 = 0.9F;
         private static final float field23065 = 3.0F;
         private static final float field23066 = 3.0F;
         private static final float field23067 = 6.0F;

         @Override
         public void method10229(GuiGraphics var1x, float var2x, float var3, float var4x, float var5, float var6x, float var7) {
            FontRenderer var8x = Fonts.field00110;
            float var9x = field23053;
            float var10x = field23054;
            float var11 = field23055;
            float var12 = var5 + var6x - 1.0F - var10x;
            float var13 = var7 + var9x / 2.0F - var11 / 2.0F;
            if (GuiPanel.this.field22882 && var1.equals(GuiPanel.this.field22886)) {
               double var14 = var2 + (var4 - var2) * GuiHitTestUtils.method05621((var2x - var12) / var10x);
               var9.accept(Math.round(var14 / var6) * var6);
            }

            double var18 = var8.getAsDouble();
            float var16 = GuiHitTestUtils.method05621((float)((var18 - var2) / (var4 - var2)));
            var8x.method09480(
               var1x,
               var1,
               var5 + 1.0F,
               var7 + var9x / 2.0F - var8x.method09485(field23056) / 2.0F,
               GuiPanel.method10227(GuiPanel.method10175(), var4x),
               field23057
            );
            String var17 = (String)var10.apply(var18);
            var8x.method09480(
               var1x,
               var17,
               var12 - field23058 - var8x.method09486(var17, field23059),
               var7 + var9x / 2.0F - var8x.method09485(field23060) / 2.0F,
               GuiPanel.method10227(GuiPanel.method10213(), field23061 * var4x),
               field23062
            );
            RoundedRectRenderer.method01272(
               var1x, var12, var13, var10x, var11, var11 / 2.0F, 1.0F, GuiPanel.method10227(GuiPanel.method10162(), field23063 * var4x)
            );
            RoundedRectRenderer.method01272(
               var1x,
               var12,
               var13,
               var10x * var16,
               var11,
               var11 / 2.0F,
               1.0F,
               GuiPanel.method10227(GuiPanel.method10198(), field23064 * var4x)
            );
            RoundedRectRenderer.method01274(
               var1x, var12 + var10x * var16, var13 + var11 / 2.0F, field23065, GuiPanel.method10227(GuiPanel.method10175(), var4x)
            );
            GuiPanel.this.method10225(
               new GuiPanel.Nested283(var12 - field23066, var7, var10x + field23067, var9x), () -> GuiPanel.this.field22886 = var1
            );
         }

         @Override
         public float method10230() {
            return field23052;
         }
      };
   }

   protected GuiPanel.Nested288 method10209(final String var1, final GuiPanel.Nested287 var2) {
      return new GuiPanel.Nested288()      // $VF: Compiled from s
 {
         private static final float field23036 = 26.0F;
         private static final float field23037 = 26.0F;
         private static final float field23038 = 6.5F;
         private static final float field23039 = 6.5F;
         private static final float field23040 = 15.333333F;
         private static final float field23041 = 9.333333F;
         private static final float field23042 = 4.0F;
         private static final float field23043 = 5.0F;

         @Override
         public float method10230() {
            return field23036;
         }

         @Override
         public void method10229(GuiGraphics var1x, float var2x, float var3, float var4, float var5, float var6, float var7) {
            FontRenderer var8 = Fonts.field00110;
            float var9 = field23037;
            var8.method09480(
               var1x,
               var1,
               var5 + 1.0F,
               var7 + var9 / 2.0F - var8.method09485(field23038) / 2.0F,
               GuiPanel.method10227(GuiPanel.method10175(), var4),
               field23039
            );
            float var10 = field23040;
            float var11 = field23041;
            float var12 = var5 + var6 - 1.0F - var10;
            float var13 = var7 + var9 / 2.0F - var11 / 2.0F;
            GuiPanel.this.method10180(var1x, var12, var13, var10, var11, GuiPanel.this.method10168("sw:" + var1, var2.method10240()), var4);
            GuiPanel.this.method10225(
               new GuiPanel.Nested283(var12 - field23042, var7, var10 + field23043, var9), () -> var2.method10241(!var2.method10240())
            );
         }
      };
   }

   protected void method10210(GuiGraphics var1, float var2, float var3, float var4, float var5) {
      if (!(var4 <= 0.0F)) {
         int var6 = method10227(method10198(), var5);
         int var7 = method10227(method10198(), 0.0F);
         float var8 = var4 / 2.0F;
         float var9 = field22960;
         RoundedRectRenderer.method01275(var1, var2, var3, var8 + var9, 1.0F, 0.0F, 0.0F, new CornerColors(var7, var7, var6, var6));
         RoundedRectRenderer.method01275(var1, var2 + var8 - var9, var3, var4 - var8 + var9, 1.0F, 0.0F, 0.0F, new CornerColors(var6, var6, var7, var7));
      }
   }

   protected final void method10211(
      GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, int var7, float var8, GuiPanel.Nested285 var9
   ) {
      if (this.field22875.method10235()) {
         this.method02351(var7);
      }

      boolean var10 = this.field22875.method10232();
      float var11 = this.field22875.method10234();
      int var12 = this.field22875.method10236();
      float var13 = var10 ? -var12 * field22917 * var11 : 0.0F;
      float var14 = var10 ? var12 * field22918 * (1.0F - var11) : 0.0F;
      float var15 = var10 ? var2 * (1.0F - var11) : 0.0F;
      float var16 = var10 ? var2 * var11 : var2;
      var1.enableScissor((int)(var3 - field22919), (int)var5, (int)(var3 + var4 + field22920), (int)var6);

      for (GuiPanel.Nested291 var18 : this.field22874.values()) {
         var18.field23076 = false;
      }

      if (var10 && var15 > field22921) {
         this.field22882 = false;
         var1.pose().pushMatrix();
         var1.pose().translate(var13, 0.0F);
         var9.method10238(var15, this.field22881, true, this.field22875.method10233());
         var1.pose().popMatrix();
      }

      this.field22882 = true;
      var1.pose().pushMatrix();
      var1.pose().translate(var14, 0.0F);
      var9.method10238(var16, var8, var10, var7);
      var1.pose().popMatrix();
      this.method10185(var1, var16, var3, var4, var5, var6);
      this.method10215();
      var1.disableScissor();
   }

   protected void method10212(
      GuiGraphics var1,
      GuiPanel.Nested283 var2,
      String var3,
      float var4,
      float var5,
      float var6,
      Runnable var7,
      Runnable var8,
      Runnable var9
   ) {
      FontRenderer var10 = Fonts.field00110;
      float var11 = var2.field23013();
      GuiPanel.Nested283 var12 = new GuiPanel.Nested283(var2.field23010(), var2.field23011(), var11, var2.field23013());
      GuiPanel.Nested283 var13 = new GuiPanel.Nested283(
         var2.field23010() + var2.field23012() - var11, var2.field23011(), var11, var2.field23013()
      );
      RoundedRectRenderer.method01272(
         var1, var2.field23010(), var2.field23011(), var2.field23012(), var2.field23013(), field22968, 1.0F, method10227(method10162(), field22969 * var6)
      );
      GuiShapeRenderer.method09703(
         var1,
         var2.field23010(),
         var2.field23011(),
         var2.field23012(),
         var2.field23013(),
         field22970,
         field22971,
         method10227(method10223(), field22972 * var6)
      );
      this.method10163(var1, var12, field22973, this.method10168(var2.field23010() + ":prev", var12.has(var4, var5)), var6);
      this.method10163(var1, var13, field22974, this.method10168(var2.field23010() + ":next", var13.has(var4, var5)), var6);
      var10.method09473(
         var1,
         var3,
         var2.field23010() + var2.field23012() / 2.0F,
         var2.field23011() + var2.field23013() / 2.0F - var10.method09485(field22975) / 2.0F,
         method10227(method10175(), var6),
         field22976
      );
      this.method10225(var12, var7);
      this.method10225(var13, var8);
      if (var9 != null) {
         this.method10225(
            new GuiPanel.Nested283(var2.field23010() + var11, var2.field23011(), var2.field23012() - var11 * 2.0F, var2.field23013()), var9
         );
      }
   }

   protected static int method10213() {
      return method10221().field22110.method11676();
   }

   protected void method10214(
      String var1,
      int var2,
      IntFunction<String> var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      boolean var11,
      GuiPanel.Nested286 var12
   ) {
      for (int var13 = 0; var13 < var2; var13++) {
         GuiPanel.Nested291 var14 = this.field22874.computeIfAbsent(var1 + (String)var3.apply(var13), var0 -> new GuiPanel.Nested291());
         var14.field23076 = true;
         float var15 = var7 + var13 * field22891;
         if (!var14.field23075) {
            method10205(var14.field23068, var15);
            var14.field23075 = true;
         }

         if (var11) {
            method10205(var14.field23068, var15);
            method10205(var14.field23069, 1.0F);
         } else {
            var14.field23068.method03375(var15);
            var14.field23069.method03375(1.0);
         }

         float var16 = var14.field23069.method03377();
         float var17 = var4 + var6 + var14.field23068.method03377() + (1.0F - var16) * field22892;
         var14.field23077 = var17;
         if (var17 + field22893 >= var4 && var17 <= var5) {
            var12.method10239(var10 * var16, var8, var17, var9, var14, var13);
         }
      }
   }

   protected void method10215() {
      this.field22874.entrySet().removeIf(var0 -> !var0.getValue().field23076 && var0.getValue().field23069.method03377() <= field23003);
   }

   protected final void method10216(
      GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, String[] var9, int var10, boolean[] var11
   ) {
      if (this.field22883.length != var9.length) {
         this.field22883 = new GuiPanel.Nested283[var9.length];
      }

      this.field22879 = this.method10219(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   protected void method10217(
      GuiGraphics var1, FontRenderer var2, GuiPanel.Nested283 var3, String var4, float var5, float var6, float var7, float var8
   ) {
      RoundedRectRenderer.method01272(
         var1,
         var3.field23010(),
         var3.field23011(),
         var3.field23012(),
         var3.field23013(),
         field22944,
         1.0F,
         method10188(method10227(method10162(), (field22945 + field22946 * var6) * var8), method10227(method10198(), field22947 * var8), var7)
      );
      GuiShapeRenderer.method09703(
         var1,
         var3.field23010(),
         var3.field23011(),
         var3.field23012(),
         var3.field23013(),
         field22948,
         field22949,
         method10227(method10223(), field22950 * var8)
      );
      var2.method09473(
         var1,
         var4,
         var3.field23010() + var3.field23012() / 2.0F,
         var3.field23011() + var3.field23013() / 2.0F - var2.method09485(var5) / 2.0F,
         method10227(method10188(method10213(), method10175(), Math.max(var6, var7)), var8),
         var5
      );
   }

   protected void method10218(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, String var7) {
      Fonts.field00110
         .method09473(
            var1,
            var7,
            var3 + var5 / 2.0F,
            var4 + var6 / 2.0F - Fonts.field00110.method09485(field22999) / 2.0F,
            method10227(method10213(), field23000 * var2),
            field23001
         );
   }

   protected boolean method10219(
      GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, String[] var9, int var10, boolean[] var11
   ) {
      FontRenderer var12 = Fonts.field00110;
      float var13 = field22903;
      float var14 = field22904;
      float var15 = Math.min(var8, field22905);
      float var16 = var6 + (var8 - var15) / 2.0F;
      float var17 = 0.0F;

      for (String var21 : var9) {
         var17 += var12.method09486(var21, var13) + var14 * 2.0F;
      }

      float var28 = var5 + var7 / 2.0F - var17 / 2.0F;
      RoundedRectRenderer.method01272(var1, var28, var16, var17, var15, field22906, 1.0F, method10227(method10162(), field22907 * var4));
      float var29 = var28;
      float var30 = 0.0F;
      float var31 = var28;

      for (int var22 = 0; var22 < var9.length; var22++) {
         float var23 = var12.method09486(var9[var22], var13) + var14 * 2.0F;
         boolean var24 = var11 != null && var22 < var11.length && var11[var22];
         this.field22883[var22] = var24 ? null : new GuiPanel.Nested283(var31, var16, var23, var15);
         if (!var24 && var22 == var10) {
            var29 = var31;
            var30 = var23;
         }

         var31 += var23;
      }

      if (!this.field22879) {
         method10205(this.field22877, var29);
         method10205(this.field22878, var30);
      }

      this.field22877.method03375(var29);
      this.field22878.method03375(var30);
      if (var30 > 0.0F) {
         RoundedRectRenderer.method01272(
            var1,
            this.field22877.method03377() + field22908,
            var16 + field22909,
            this.field22878.method03377() - field22910,
            var15 - field22911,
            field22912,
            1.0F,
            method10227(method10187(), field22913 * var4)
         );
      }

      var31 = var28;

      for (int var33 = 0; var33 < var9.length; var33++) {
         float var34 = var12.method09486(var9[var33], var13) + var14 * 2.0F;
         boolean var35 = var11 != null && var33 < var11.length && var11[var33];
         float var25 = var16 + var15 / 2.0F - var12.method09485(var13) / 2.0F;
         if (var35) {
            var12.method09473(var1, var9[var33], var31 + var34 / 2.0F, var25, method10227(method10213(), field22914 * var4), var13);
         } else {
            boolean var26 = var33 == var10;
            float var27 = this.method10168("tab:" + var33, var26 || this.field22883[var33].has(var2, var3));
            var12.method09473(
               var1,
               var9[var33],
               var31 + var34 / 2.0F,
               var25,
               method10227(method10188(method10213(), method10175(), var27), (field22915 + field22916 * var27) * var4),
               var13
            );
         }

         var31 += var34;
      }

      return true;
   }

   protected final boolean method10220(float var1, float var2) {
      for (int var3 = 0; var3 < this.field22884.size(); var3++) {
         if (method10179(this.field22884.get(var3), var1, var2)) {
            this.field22885.get(var3).run();
            return true;
         }
      }

      return false;
   }

   protected static ThemeSettings method10221() {
      return ThemeManager.INSTANCE.method09611();
   }

   protected final void method10222() {
      this.field22884.clear();
      this.field22885.clear();
   }

   protected static int method10223() {
      return method10221().field22117.method11676();
   }

   protected void method10224(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      GuiPanelRenderer.method00765(var1, var3, var4, var5, var6, var7, var2);
   }

   protected final void method10225(GuiPanel.Nested283 var1, Runnable var2) {
      if (this.field22882) {
         this.field22884.add(var1);
         this.field22885.add(var2);
      }
   }

   protected final float method10226(float var1, float var2) {
      float var3 = Math.max(0.0F, var1 - var2);
      this.field22880 = GuiHitTestUtils.method05615(-var3, 0.0F, this.field22880);
      this.field22876.method03375(this.field22880);
      return this.field22876.method03377();
   }

   protected static int method10227(int var0, float var1) {
      return ColorUtils.method04611(var0, var1);
   }

   protected void method10228(GuiGraphics var1, float var2, float var3, float var4, float var5) {
      RoundedRectRenderer.method01272(var1, var3, var4, var5, field22958, 0.0F, 0.0F, method10227(method10223(), field22959 * var2));
   }

   // $VF: Compiled from s
   public record Nested283(float field23010, float field23011, float field23012, float field23013) {
      public boolean has(float var1, float var2) {
         return GuiHitTestUtils.method05625(var1, var2, this.field23010, this.field23011, this.field23012, this.field23013);
      }
   }

   // $VF: Compiled from s
   public static final class Nested284 {
      private final AnimationUtils field23014;
      private int field23015;
      private int field23016;
      private boolean field23017;
      private static final long field23018 = 300L;
      private static final float field23019 = 0.999F;

      public void method10231(int var1, int var2) {
         if (var1 != var2) {
            this.field23015 = var1;
            this.field23016 = Integer.signum(var2 - var1);
            if (this.field23016 == 0) {
               this.field23016 = 1;
            }

            GuiPanel.method10205(this.field23014, 0.0F);
            this.field23017 = true;
         }
      }

      public boolean method10232() {
         return this.field23017;
      }

      public Nested284() {
         this.field23014 = GuiPanel.method10166(field23018);
         this.field23016 = 1;
      }

      public int method10233() {
         return this.field23015;
      }

      public float method10234() {
         return GuiHitTestUtils.method05621(this.field23014.method03377());
      }

      public boolean method10235() {
         if (!this.field23017) {
            return false;
         } else {
            this.field23014.method03375(1.0);
            if (this.field23014.method03377() >= field23019) {
               this.field23017 = false;
               return true;
            } else {
               return false;
            }
         }
      }

      public int method10236() {
         return this.field23016;
      }

      public void method10237(int var1, int var2, int var3) {
         if (var2 != var3) {
            this.field23015 = var1;
            this.field23016 = Integer.signum(var3 - var2);
            if (this.field23016 == 0) {
               this.field23016 = 1;
            }

            GuiPanel.method10205(this.field23014, 0.0F);
            this.field23017 = true;
         }
      }
   }

   // $VF: Compiled from s
   @FunctionalInterface
   protected interface Nested285 {
      void method10238(float var1, float var2, boolean var3, int var4);
   }

   // $VF: Compiled from s
   protected interface Nested286 {
      void method10239(float var1, float var2, float var3, float var4, GuiPanel.Nested291 var5, int var6);
   }

   // $VF: Compiled from s
   protected interface Nested287 {
      boolean method10240();

      void method10241(boolean var1);
   }

   // $VF: Compiled from s
   protected interface Nested288 {
      void method10229(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7);

      float method10230();
   }

   // $VF: Compiled from s
   protected interface Nested289 {
      void method10242(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6);
   }

   // $VF: Compiled from s
   public static final class Nested290 {
      private final AnimationUtils field23020;
      private final Map<Object, AnimationUtils> field23021;
      private int field23022;
      private GuiPanel.Nested283[] field23023;
      private float field23024;
      private float field23025;
      private float field23026;
      private float field23027;
      private static final long field23028 = 150L;
      private static final float field23029 = 0.01F;
      private static final float field23030 = 0.01F;
      private static final float field23031 = 0.5F;
      private static final long field23032 = 150L;

      public Nested290() {
         this.field23020 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field23028);
         this.field23021 = new HashMap<>();
         this.field23023 = new GuiPanel.Nested283[0];
      }

      public int method10244(float var1, float var2) {
         if (this.field23020.method03377() < field23031) {
            return -1;
         }

         for (int var3 = 0; var3 < this.field23023.length; var3++) {
            if (this.field23023[var3] != null && this.field23023[var3].has(var1, var2)) {
               return var3;
            }
         }

         return -1;
      }

      public float method10245() {
         return this.field23020.method03377();
      }

      public int method10246() {
         return this.field23022;
      }

      public boolean method10247(int var1) {
         if (var1 >= 0 && var1 != this.field23022) {
            this.field23022 = var1;
            return true;
         } else {
            return false;
         }
      }

      public boolean method10248(float var1, float var2, float var3) {
         if (this.field23020.method03377() <= field23030) {
            return false;
         }

         float var4 = Math.min(var3, this.field23025);
         return GuiHitTestUtils.method05625(var1, var2, this.field23024, var4, this.field23026, this.field23025 + this.field23027 - var4);
      }

      public boolean method10249(float var1, float var2) {
         return this.field23020.method03377() > field23029
            && GuiHitTestUtils.method05625(var1, var2, this.field23024, this.field23025, this.field23026, this.field23027);
      }

      private float method10250(Object var1, boolean var2) {
         AnimationUtils var3 = this.field23021.computeIfAbsent(var1, var0 -> GuiPanel.method10166(field23032));
         var3.method03375(var2 ? 1.0 : 0.0);
         return var3.method03377();
      }
   }

   // $VF: Compiled from s
   public static final class Nested291 {
      public final AnimationUtils field23068;
      public final AnimationUtils field23069;
      public final AnimationUtils field23070;
      public final AnimationUtils field23071;
      public final AnimationUtils field23072;
      public final AnimationUtils field23073;
      public final AnimationUtils field23074;
      public boolean field23075;
      public boolean field23076;
      public float field23077;
      public GuiPanel.Nested289 field23078;
      private static final long field23079 = 300L;
      private static final long field23080 = 220L;
      private static final long field23081 = 150L;
      private static final long field23082 = 150L;
      private static final long field23083 = 150L;
      private static final long field23084 = 150L;
      private static final long field23085 = 150L;

      public Nested291() {
         this.field23068 = GuiPanel.method10166(field23079);
         this.field23069 = GuiPanel.method10166(field23080);
         this.field23070 = GuiPanel.method10166(field23081);
         this.field23071 = GuiPanel.method10166(field23082);
         this.field23072 = GuiPanel.method10166(field23083);
         this.field23073 = GuiPanel.method10166(field23084);
         this.field23074 = GuiPanel.method10166(field23085);
      }
   }
}
