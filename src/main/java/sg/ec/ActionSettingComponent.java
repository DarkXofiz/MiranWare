// Original binary: sg/ec/IJDYf7qgHkTwqCLA
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class ActionSettingComponent extends SettingComponent<ActionSetting> {
   private final FontRenderer field08692 = Fonts.field00110;
   private final FontRenderer field08693 = Fonts.field00111;
   private final float field08694;
   private final float field08695;
   private final SmoothAnimation field08696;
   private final SmoothAnimation field08697;
   private final GuiBounds field08698;
   private static final float field08699 = 7.0F;
   private static final float field08700 = 7.5F;
   private static final float field08701 = 9.0F;
   private static final float field08702 = 9.0F;
   private static final float field08703 = 7.0F;
   private static final float field08704 = 7.5F;
   private static final float field08705 = 2.75F;
   private static final float field08706 = 3.0F;
   private static final float field08707 = 7.5F;
   private static final float field08708 = 2.75F;
   private static final double field08709 = 0.2F;
   private static final float field08710 = 1.5F;
   private static final float field08711 = 1.5F;
   private static final float field08712 = 0.5F;
   private static final float field08713 = 0.25F;
   private static final float field08714 = 7.5F;
   private static final float field08715 = 7.5F;

   @Override
   public void method03443() {
      if (this.field08692 != null && this.field08693 != null) {
         float var1 = this.field08692.method09485(field08703);
         float sx = this.field08693.method09485(field08704) + field08705;
         this.method09786(Math.max(var1, sx) + field08706);
      } else {
         this.method09786(field08702);
      }
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (var5 == 0 && this.field08698.method02799(var1, var3)) {
         this.method10977().method02151();
      }
   }

   @Override
   public void method00042(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      if (this.field08692 != null && this.field08693 != null) {
         this.field08697.method06162();
         float var5 = this.field08693.method09485(field08707) + field08708;
         this.field08698.method02801(this.method09780());
         this.field08698.method02806(this.method09782());
         this.field08698.method02803(this.method09784());
         this.field08698.method02798(var5);
         this.field08698.method02806(this.method09782() + this.method09785() / 2.0F - var5 / 2.0F);
         this.field08697.method06158(this.field08698.method02805(var2, var3) ? 1.0 : 0.0, field08709, Easings.field19400);
         int var6 = ColorUtils.method04631(
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22116.method11676(), this.method09790()),
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22115.method11676(), this.method09790()),
            this.field08697.method06173()
         );
         int var7 = ColorUtils.method04605(
            ColorUtils.method04583(
               ThemeManager.INSTANCE.method09611().field22110.method11676(),
               ThemeManager.INSTANCE.method09611().field22109.method11676(),
               this.field08697.method06173()
            ),
            this.method09790()
         );
         RoundedRectRenderer.method01272(
            var1,
            this.field08698.method02809(),
            this.field08698.method02808(),
            this.field08698.method02804(),
            this.field08698.method02802(),
            field08710,
            1.0F,
            var6
         );
         GuiShapeRenderer.method09703(
            var1,
            this.field08698.method02809(),
            this.field08698.method02808(),
            this.field08698.method02804(),
            this.field08698.method02802(),
            field08711,
            field08712,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), this.method09790())
         );
         this.field08693
            .method09473(
               var1,
               this.method10977().method03024(),
               this.field08698.method02809() + this.field08698.method02804() / 2.0F - field08713,
               this.field08698.method02808() + this.field08698.method02802() / 2.0F - this.field08693.method09485(field08714) / 2.0F,
               var7,
               field08715
            );
      }
   }

   public ActionSettingComponent(ActionSetting var1) {
      super(var1);
      this.field08694 = field08699;
      this.field08695 = field08700;
      this.field08696 = new SmoothAnimation();
      this.field08697 = new SmoothAnimation();
      this.field08698 = new GuiBounds();
      this.method09786(field08701);
   }
}
