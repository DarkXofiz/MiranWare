// Original binary: sg/ec/MIZezDPx6UveEHRH
package sg.ec;

import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class NumberSettingComponent extends SettingComponent<NumberSetting<?>> {
   private final SmoothAnimation field10045 = new SmoothAnimation();
   private final SmoothAnimation field10046 = new SmoothAnimation();
   private boolean field10047;
   private static final float field10048 = 4.0F;
   private static final float field10049 = 25.0F;
   private static final float field10050 = 7.0F;
   private static final float field10051 = 6.5F;
   private static final float field10052 = 7.0F;
   private static final float field10053 = 6.5F;
   private static final double field10054 = 0.25;
   private static final double field10055 = 0.25;
   private static final float field10056 = 4.25F;
   private static final float field10057 = 10.0F;
   private static final float field10058 = 3.0F;
   private static final float field10059 = 0.5F;
   private static final float field10060 = 3.0F;
   private static final float field10061 = 6.0F;
   private static final float field10062 = 3.0F;
   private static final float field10063 = 3.0F;
   private static final float field10064 = 0.5F;
   private static final float field10065 = 1.5F;
   private static final float field10066 = 1.5F;
   private static final float field10067 = 3.75F;
   private static final float field10068 = 3.75F;
   private static final float field10069 = 1.5F;
   private static final float field10070 = 7.5F;
   private static final float field10071 = 7.5F;
   private static final float field10072 = 2.7F;
   private static final float field10073 = 0.99F;
   private static final float field10074 = 0.99F;
   private static final double field10075 = 100.0;
   private static final double field10076 = 100.0;

   public NumberSettingComponent(NumberSetting<?> var1) {
      super(var1);
      this.field10045
         .method06155(
            this.method09784()
               * (this.method10977().method03022().floatValue() - this.method10977().method10836().floatValue())
               / (this.method10977().method10842().floatValue() - this.method10977().method10836().floatValue())
         );
      this.field10046.method06175(this.method10977().method03022().floatValue());
   }

   @Override
   public void method03443() {
      FontRenderer var1 = Fonts.field00110;
      float var2 = field10050;
      float var3 = field10051;
      float var4 = this.method04528(var1, var3);
      var var5 = TextRenderUtils.method00677(this.method10977().method03024(), this.method09784() - var4, var1, var2);
      this.method09786(this.method04530(var5, var1, var2));
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (this.method10977().method03019() && !(this.method10979().method06173() < field10073)) {
         if (var5 == 0 && GuiHitTestUtils.method05609(var1, var3, this.method09780(), this.method09782(), this.method09784(), this.method09785())) {
            this.field10047 = true;
         }
      }
   }

   public boolean method04527(double var1, double var3, double var5) {
      if (var5 == 0.0) {
         return false;
      }

      if (!ContainerHelper.method03214()) {
         return false;
      }

      if (this.method10977().method03019() && !(this.method10979().method06173() < field10074)) {
         if (!GuiHitTestUtils.method05609(var1, var3, this.method09780(), this.method09782(), this.method09784(), this.method09785())) {
            return false;
         }

         float var7 = this.method10977().method10841().floatValue();
         if (var7 <= 0.0F) {
            var7 = 1.0F;
         }

         float var8 = this.method10977().method03022().floatValue();
         float var9 = this.method04534(var8, Math.signum(var5), var7);
         this.method10977().method10837(var9);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void method02632(double var1, double var3, int var5) {
      if (this.field10047 && var5 == 0) {
         this.method04531(var1);
      }

      this.field10047 = false;
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      if (this.field10047) {
         if (this.method04529() && this.method04532()) {
            this.method04531(var2);
         } else {
            this.field10047 = false;
         }
      }

      FontRenderer var5 = Fonts.field00110;
      float var6 = field10052;
      float var7 = field10053;
      this.field10045.method06162();
      this.field10046.method06162();
      this.field10045
         .method06168(
            this.method09784()
               * (this.method10977().method03022().floatValue() - this.method10977().method10836().floatValue())
               / (this.method10977().method10842().floatValue() - this.method10977().method10836().floatValue()),
            field10054,
            Easings.field19400,
            true
         );
      this.field10046.method06168(this.method10977().method03022().floatValue(), field10055, Easings.field19397, true);
      String var8 = this.method04533(this.field10046.method06173());
      float var9 = var5.method09486(var8, var7);
      float var10 = this.method04528(var5, var7);
      var var11 = TextRenderUtils.method00677(this.method10977().method03024(), this.method09784() - var10, var5, var6);
      float var12 = 0.0F;

      for (String var14 : var11) {
         var5.method09480(
            var1,
            var14,
            this.method09780(),
            this.method09782() + field10056 + var12,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22109.method11676(), this.method09790()),
            var6
         );
         var12 += var5.method09485(var6);
      }

      float var21 = 2.0F;
      float var22 = var9 + var21 * 2.0F;
      float var15 = field10057;
      float var16 = this.method09780() + this.method09784() - var22;
      float var17 = this.method09782() + field10058;
      RoundedRectRenderer.method01272(
         var1,
         var16,
         var17,
         var22,
         var15,
         2.0F,
         1.0F,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22123.method11676(), this.method09790())
      );
      GuiShapeRenderer.method09703(
         var1,
         var16,
         var17,
         var22,
         var15,
         2.0F,
         field10059,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), this.method09790())
      );
      var5.method09473(
         var1,
         var8,
         var16 + var22 / 2.0F,
         var17 + var15 / 2.0F - var5.method09485(var7) / 2.0F,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22109.method11676(), this.method09790()),
         var7
      );
      float var18 = field10060;
      float var19 = this.method09782() + this.method09785() - field10061;
      float var20 = Mth.clamp(this.field10045.method06173(), field10062, this.method09784() - field10063);
      GuiShapeRenderer.method09703(
         var1,
         this.method09780(),
         var19,
         this.method09784(),
         var18,
         2.0F,
         field10064,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), this.method09790())
      );
      RoundedRectRenderer.method01272(
         var1,
         this.method09780(),
         var19,
         this.method09784(),
         var18,
         field10065,
         1.0F,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22123.method11676(), this.method09790())
      );
      RoundedRectRenderer.method01272(
         var1,
         this.method09780(),
         var19,
         var20,
         var18,
         field10066,
         1.0F,
         ColorUtils.method04611(
            ThemeManager.INSTANCE.method09611().field22111.method11676(), this.method09790() * this.method10979().method06173()
         )
      );
      GuiRenderBatch.method05190(var1.guiRenderState);
      RoundedRectRenderer.method01272(
         var1,
         this.method09780() + var20 - field10067,
         var19 - field10068 + field10069,
         field10070,
         field10071,
         field10072,
         1.0F,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22112.method11676(), this.method09790())
      );
   }

   private float method04528(FontRenderer var1, float var2) {
      float var3 = var1.method09486(this.method04533(this.method10977().method10836().floatValue()), var2);
      float var4 = var1.method09486(this.method04533(this.method10977().method10842().floatValue()), var2);
      float var5 = var1.method09486(this.method04533(this.method10977().method03022().floatValue()), var2);
      return Math.max(Math.max(var3, var4), var5) + field10048;
   }

   private boolean method04529() {
      return mc.getWindow() == null ? false : InputCompat.isMouseDown(0);
   }

   private float method04530(List<String> var1, FontRenderer var2, float var3) {
      float var4 = Math.max(0, var1.size() - 1);
      return field10049 + var4 * (var2.method09485(var3) / 2.0F);
   }

   private void method04531(double var1) {
      float var3 = this.method10977().method10836().floatValue();
      float var4 = this.method10977().method10842().floatValue();
      this.method10977()
         .method10837(
            (float)Mth.clamp(
               GuiHitTestUtils.method05606(
                  (var1 - this.method09780()) / this.method09784() * (var4 - var3) + var3, this.method10977().method10841().floatValue()
               ),
               var3,
               var4
            )
         );
   }

   private boolean method04532() {
      return ClientScreenManager.INSTANCE.method08316() || mc.gui.screen() != null;
   }

   private String method04533(float var1) {
      return GuiHitTestUtils.method05606(var1, this.method10977().method10841().floatValue()) + "";
   }

   private float method04534(float var1, double var2, float var4) {
      double var5 = var1 + (float)(var2 * var4);
      double var7 = (float)Math.round(var5 / var4) * var4;
      float var9 = (float)(Math.round(var7 * field10075) / field10076);
      return this.method10977().method10840()
         ? var9
         : Mth.clamp(var9, this.method10977().method10836().floatValue(), this.method10977().method10842().floatValue());
   }
}
