// Original binary: sg/ec/IJd4aNrZM5BHeiJB
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class BooleanSettingComponent extends SettingComponent<BooleanSetting> {
   private final SmoothAnimation field08716 = new SmoothAnimation();
   private final SmoothAnimation field08717 = new SmoothAnimation();
   private final SmoothAnimation field08718 = new SmoothAnimation();
   private final FontRenderer field08719 = Fonts.field00110;
   private final float field08720;
   private final GuiBounds field08721 = new GuiBounds();
   private final BindingStateRenderer field08722 = (var1x, var2) -> ToggleSwitchRenderer.method03323(
      var1x, var2, this.method10977().field10289.method03377(), this.method09790()
   );
   private boolean field08723 = false;
   private static final float field08724 = 11.0F;
   private static final float field08725 = 6.0F;
   private static final double field08726 = 0.05F;
   private static final float field08727 = 12.666667F;
   private static final float field08728 = 7.6666665F;
   private static final float field08729 = 25.0F;
   private static final float field08730 = 10.0F;

   public SmoothAnimation method03869() {
      return this.field08717;
   }

   @Override
   public void method00250(int var1, int var2, int var3) {
      if (this.field08723) {
         if (261 != var1 && 256 != var1) {
            this.method10977().method04704().method05872(var1);
         } else {
            this.method10977().method04704().method05872(-1);
         }

         this.field08723 = false;
      }

      super.method00250(var1, var2, var3);
   }

   public float method03870() {
      return this.field08720;
   }

   public BindingStateRenderer method03871() {
      return this.field08722;
   }

   public FontRenderer method03872() {
      return this.field08719;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (this.field08721.method02799(var1, var3)) {
         if (var5 == 0) {
            this.method10977().field10289.method03375(!this.method10977().method04706() ? 1.0 : 0.0);
            this.method10977().method04705();
         }

         if (var5 == 2) {
            this.field08723 = !this.field08723;
            return;
         }
      }

      if (this.field08723) {
         this.method10977().method04704().method05872(-100 + var5);
         this.field08723 = false;
      }
   }

   public SmoothAnimation method03873() {
      return this.field08718;
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      this.method10977().method04707().method03375(this.method10977().method03022() ? 1.0 : 0.0);
      this.field08716.method06162();
      this.field08716.method06158(this.field08723 ? 1.0 : 0.0, field08726, Easings.field19394);
      this.field08721.method02803(field08727);
      this.field08721.method02798(field08728);
      this.field08721.method02801(this.method09780() + this.method09784() - this.field08721.method02804());
      this.field08721.method02806(this.method09782() + this.method09785() / 2.0F - this.field08721.method02802() / 2.0F);
      float var5 = Math.max(1.0F, this.method09784() - this.field08721.method02804() - 2.0F);
      float var6 = GuiHitTestUtils.method05621(this.field08716.method06173());
      float var7 = 1.0F - var6;
      String var8 = this.method10977().method03024();
      TextRenderUtils.method00666(
         var1,
         this.field08717,
         this.field08719,
         var8,
         this.method09780(),
         this.method09782() + this.method09785() / 2.0F - this.field08719.method09485(this.field08720) / 2.0F,
         var5,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11679(), this.method09790()),
         this.field08720,
         0.0F,
         1.0F,
         field08729,
         field08730
      );
      this.field08722.method11276(var1, this.field08721);
   }

   @Override
   public boolean method00251(double var1, double var3, int var5) {
      return !this.field08723 && !this.field08721.method02799(var1, var3) ? super.method00251(var1, var3, var5) : false;
   }

   public BooleanSettingComponent(BooleanSetting var1) {
      super(var1);
      this.method09786(field08724);
      this.method10977().field10289.method03374(var1.method04706() ? 1.0 : 0.0);
      this.field08716.method06157(0.0);
      this.field08717.method06157(0.0);
      this.field08718.method06157(0.0);
      this.field08720 = field08725;
   }

   public boolean method03875() {
      return this.field08723;
   }

   public GuiBounds method03876() {
      return this.field08721;
   }

   public SmoothAnimation method03877() {
      return this.field08716;
   }
}
