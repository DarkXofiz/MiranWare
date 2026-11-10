// Original binary: sg/ec/hbghSWcb4mOcy1Y0
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ThemeColorComponent extends GuiComponent {
   private final ColorSetting field19863;
   private final FloatingWindow field19864;
   private static final float field19865 = 6.0F;
   private static final float field19866 = 4.0F;
   private static final float field19867 = 7.0F;
   private static final float field19868 = 7.0F;
   private static final float field19869 = 14.0F;
   private static final float field19870 = 8.0F;
   private static final float field19871 = 8.0F;
   private static final float field19872 = 2.5F;
   private static final float field19873 = 15.0F;
   private static final float field19874 = 7.0F;
   private static final float field19875 = 14.0F;

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      Fonts.field00111
         .method09480(
            var1,
            this.field19863.method03024(),
            this.method09780() + field19865,
            this.method09782() + field19866 - Fonts.field00111.method09485(field19867) / 2.0F,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22109.method11676(), this.method09790()),
            field19868
         );
      RoundedRectRenderer.method01272(
         var1,
         this.method09780() + this.method09784() - field19869,
         this.method09782(),
         field19870,
         field19871,
         field19872,
         1.0F,
         ColorUtils.method04611(this.field19863.method11676(), this.method09790())
      );
      this.method09786(field19873);
   }

   public ThemeColorComponent(ColorSetting var1, FloatingWindow var2) {
      this.field19863 = var1;
      this.field19864 = var2;
   }

   public ColorSetting method08679() {
      return this.field19863;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (this.field19864 != null && this.field19864.method09580() != null) {
         if (var5 == 0
            && GuiHitTestUtils.method05609(var1, var3, this.method09780(), this.method09782() - 1.0F, this.method09784(), this.method09785() - field19874)) {
            this.field19864.method09565(false);
            this.field19864
               .method09580()
               .method09652(new ColorPickerWindow(this.field19863, this.field19864), this.method09780() + this.method09784() - field19875, this.method09782());
         }
      }
   }

   public FloatingWindow method08680() {
      return this.field19864;
   }
}
