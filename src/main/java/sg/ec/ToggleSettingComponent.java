// Original binary: sg/ec/17BDJkMB16Yp74Ev
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ToggleSettingComponent extends SettingComponent<ToggleSetting> {
   private final SmoothAnimation field00515 = new SmoothAnimation();
   private final FontRenderer field00516 = Fonts.field00110;
   private final FloatingWindow field00517;
   private final float field00518;
   private final GuiBounds field00519 = new GuiBounds();
   private final BindingStateRenderer field00520 = (var1x, var2x) -> ToggleSwitchRenderer.method03323(
      var1x, var2x, this.method10977().field13573.method03377(), this.method09790()
   );
   private static final float field00521 = 15.0F;
   private static final float field00522 = 7.0F;
   private static final float field00523 = 15.333333F;
   private static final float field00524 = 9.333333F;
   private static final float field00525 = 25.0F;
   private static final float field00526 = 10.0F;
   private static final String field00527 = "Bind";
   private static final String field00528 = "modules.binding";

   @Override
   public void method00250(int var1, int var2, int var3) {
      super.method00250(var1, var2, var3);
   }

   @Override
   public boolean method00251(double var1, double var3, int var5) {
      return this.field00519.method02799(var1, var3) ? false : super.method00251(var1, var3, var5);
   }

   public ToggleSettingComponent(ToggleSetting var1, FloatingWindow var2) {
      super(var1);
      this.field00517 = var2;
      this.method09786(field00521);
      this.method10977().field13573.method03374(var1.method05999() ? 1.0 : 0.0);
      this.field00515.method06157(0.0);
      this.field00518 = field00522;
   }

   public float method00252() {
      return this.field00518;
   }

   public SmoothAnimation method00253() {
      return this.field00515;
   }

   public FloatingWindow method00254() {
      return this.field00517;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (this.field00519.method02799(var1, var3)) {
         if (var5 == 0) {
            this.method10977().field13573.method03375(!this.method10977().method05999() ? 1.0 : 0.0);
            this.method10977().method05996();
         } else {
            if (var5 == 2) {
               this.method00258((float)var1, (float)var3);
            }
         }
      }
   }

   public FontRenderer method00255() {
      return this.field00516;
   }

   public BindingStateRenderer method00256() {
      return this.field00520;
   }

   public GuiBounds method00257() {
      return this.field00519;
   }

   private void method00258(float var1, float var2) {
      if (this.field00517 != null && this.field00517.method09580() != null) {
         KeyBindSetting var3 = new KeyBindSetting(field00527).method03017(new KeyBinding()).method03014(this.method10977().method05997());
         this.field00517.method09580().method09652(new ToggleBindingWindow(field00528, var3), var1, var2);
      }
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      this.method10977().method05998().method03375(this.method10977().method03022() ? 1.0 : 0.0);
      this.field00519.method02803(field00523);
      this.field00519.method02798(field00524);
      this.field00519.method02801(this.method09780() + this.method09784() - this.field00519.method02804());
      this.field00519.method02806(this.method09782() + this.method09785() / 2.0F - this.field00519.method02802() / 2.0F);
      float var5 = Math.max(1.0F, this.method09784() - this.field00519.method02804() - 2.0F);
      this.field00520.method11276(var1, this.field00519);
      TextRenderUtils.method00666(
         var1,
         this.field00515,
         this.field00516,
         this.method10977().method03024(),
         this.method09780(),
         this.method09782() + this.method09785() / 2.0F - this.field00516.method09485(this.field00518) / 2.0F,
         var5,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11679(), this.method09790()),
         this.field00518,
         0.0F,
         1.0F,
         field00525,
         field00526
      );
   }
}
