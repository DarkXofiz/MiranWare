// Original binary: sg/ec/vQbM57UyihbTKULb
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class KeyBindSettingComponent extends SettingComponent<KeyBindSetting> {
   private static final float field24641 = 15.0F;
   private static final float field24642 = 0;
   private static final float field24643 = 0;
   private final FontRenderer field24644 = Fonts.field00110;
   private final SmoothAnimation field24645 = new SmoothAnimation();
   private final SmoothAnimation field24646 = new SmoothAnimation();
   private final SmoothAnimation field24647 = new SmoothAnimation();
   private final SmoothAnimation field24648 = new SmoothAnimation();
   private final KeyBindingCapture field24649;
   private final BindingModeSelector field24650;
   private static final float field24651 = 25.0F;
   private static final float field24652 = 15.0F;
   private static final float field24653 = 7.0F;
   private static final float field24654 = 6.0F;
   private static final float field24655 = 7.5F;
   private static final String field24656 = "...";
   private static final double field24657 = 0.15F;
   private static final float field24658 = 5.0F;
   private static final double field24659 = 0.05F;
   private static final float field24660 = 5.0F;
   private static final float field24661 = 0.5F;
   private static final float field24662 = 2.5F;
   private static final float field24663 = 2.5F;
   private static final float field24664 = 3.0F;
   private static final float field24665 = 0.5F;
   private static final float field24666 = 0.01F;
   private static final float field24667 = 3.0F;
   private static final float field24668 = 25.0F;
   private static final float field24669 = 10.0F;
   private static final float field24670 = 3.0F;
   private static final float field24671 = 25.0F;
   private static final float field24672 = 10.0F;
   private static final float field24673 = 1.25F;
   private static final float field24674 = 25.0F;
   private static final float field24675 = 15.0F;
   private static final float field24676 = 15.0F;
   private static final float field24677 = 8.0F;
   private static final float field24678 = 0.999F;
   private static final float field24679 = 15.0F;
   private static final float field24680 = 15.0F;
   private static final float field24681 = 15.0F;
   private static final float field24682 = 10.0F;
   private static final float field24683 = 0.999F;

   @Override
   public void method00250(int var1, int var2, int var3) {
      if (!(this.method09790() < field24683)) {
         this.field24649.method06909(var1);
      }
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (!(this.method09790() < field24678)) {
         if (!this.field24649.method06907(var5)) {
            if (var5 == 0) {
               if (this.method10977().method03238() && this.method11002(var1, var3)) {
                  this.method10977().method03022().method05870(this.field24650.method01907(var1));
               } else if (this.method11005(var1, var3)) {
                  this.field24649.method06906();
               }
            }
         }
      }
   }

   @Override
   public boolean method00251(double var1, double var3, int var5) {
      return this.field24649.method06910() ? false : super.method00251(var1, var3, var5);
   }

   private boolean method11002(double var1, double var3) {
      return var1 >= this.method09780()
         && var1 <= this.method09780() + this.method09784()
         && var3 >= this.method09782() + field24680
         && var3 <= this.method09782() + field24681 + field24682;
   }

   public KeyBindSettingComponent(KeyBindSetting var1) {
      super(var1);
      this.field24649 = new KeyBindingCapture(var1);
      this.field24650 = new BindingModeSelector(var1.method03022().method05874());
      this.method09786(var1.method03238() ? field24651 : field24652);
      this.field24647.method06157(0.0);
      this.field24648.method06157(0.0);
   }

   private void method11003() {
      GuiBounds var1 = this.field24650.method01904();
      var1.method02801(this.method09780());
      var1.method02806(this.method09782() + field24676);
      var1.method02803(this.method09784());
      var1.method02798(field24677);
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      float var5 = field24653;
      float var6 = field24654;
      float var7 = this.method09782() + field24655;
      boolean var8 = this.field24649.method06910();
      String var9 = var8 ? field24656 : KeyboardKey.method00360(this.method10977().method03022().method05871());
      this.field24645.method06162();
      this.field24645.method06158(var8 ? 1.0 : 0.0, field24657, Easings.field19412);
      float var10 = this.field24644.method09486(var9, var6);
      this.field24646.method06162();
      this.field24646.method06156(var10 + field24658, field24659, true);
      float var11 = this.method09784() - this.field24646.method06173() - field24660;
      int var12 = ColorUtils.method04631(
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22110.method11679(), this.method09790()),
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22113.method11679(), this.method09790()),
         this.field24645.method06173()
      );
      int var13 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22109.method11679(), this.method09790());
      RoundedRectRenderer.method01272(
         var1,
         this.method09780() + this.method09784() - this.field24646.method06173() - field24661,
         var7 - (this.field24644.method09485(var6) + field24662) / 2.0F,
         this.field24646.method06173(),
         this.field24644.method09485(var6) + field24663,
         GuiSize.method04763(field24664).method04764(field24665).method04768(),
         1.0F,
         var12
      );
      if (var8 && this.field24645.method06173() > field24666) {
         String var15 = "Binding... " + KeyboardKey.method00360(this.method10977().method03022().method05871());
         TextRenderUtils.method00666(
            var1,
            this.field24648,
            this.field24644,
            var15,
            this.method09780(),
            var7 - this.field24644.method09485(var5) / 2.0F,
            var11,
            ColorUtils.method04611(
               ThemeManager.INSTANCE.method09611().field22108.method11679(), this.method09790() * this.field24645.method06173()
            ),
            var5,
            0.0F,
            field24667,
            field24668,
            field24669
         );
      } else {
         String var14 = this.method10977().method03024();
         TextRenderUtils.method00666(
            var1,
            this.field24647,
            this.field24644,
            var14,
            this.method09780(),
            var7 - this.field24644.method09485(var5) / 2.0F,
            var11,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11679(), this.method09790()),
            var5,
            0.0F,
            field24670,
            field24671,
            field24672
         );
      }

      this.field24644
         .method09480(
            var1,
            var9,
            this.method09780() + this.method09784() - var10 - var6 / 2.0F,
            var7 - (this.field24644.method09485(var6) + 2.0F) / 2.0F + field24673,
            var13,
            var6
         );
      if (this.method10977().method03238()) {
         this.method11003();
         this.field24650.method01908(var1, this.field24644, this.method10977().method03022().method05874(), this.method09790());
         this.method09786(field24674);
      } else {
         this.method09786(field24675);
      }
   }

   public boolean method11004() {
      return this.field24649.method06910();
   }

   private boolean method11005(double var1, double var3) {
      return var1 >= this.method09780()
         && var1 <= this.method09780() + this.method09784()
         && var3 >= this.method09782()
         && var3 <= this.method09782() + field24679;
   }
}
