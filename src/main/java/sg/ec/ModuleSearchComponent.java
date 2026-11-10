// Original binary: sg/ec/dn5V53Cjo4P11eLp
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ModuleSearchComponent extends GuiComponent {
   private final ClickGuiScreen field18427;
   private final SmoothAnimation field18428 = new SmoothAnimation();
   private final TextInputWidget field18429;
   private static final float field18430 = 8.0F;
   private static final String field18431 = "Поиск";
   private static final float field18432 = 8.0F;
   private static final double field18433 = 0.15F;
   private static final float field18434 = 255.0F;
   private static final float field18435 = 3.0F;
   private static final float field18436 = 1.25F;
   private static final String field18437 = "F";
   private static final float field18438 = 5.0F;
   private static final String field18439 = "F";
   private static final float field18440 = 0.2F;
   private static final float field18441 = 0.5F;
   private static final float field18442 = 0.2F;

   @Override
   public void method00250(int var1, int var2, int var3) {
      this.field18429.method06733(var1);
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      this.field18429.method06703(var1, var3, var5);
   }

   public ModuleSearchComponent(ClickGuiScreen var1) {
      this.field18429 = new TextInputWidget().method06678(Fonts.field00111, field18430);
      this.field18427 = var1;
      this.field18429.method06669(16);
      this.field18429.method06717(field18431);
   }

   public void method07525(boolean var1) {
      this.field18429.method06724(var1);
   }

   @Override
   public void method02632(double var1, double var3, int var5) {
      this.field18429.method06673(var1, var3, var5);
   }

   public TextInputWidget method07526() {
      return this.field18429;
   }

   public ClickGuiScreen method07527() {
      return this.field18427;
   }

   public void method07528() {
      this.field18429.method06702();
   }

   public boolean method07529() {
      return this.field18429.method06726();
   }

   public void method07530(char var1) {
      this.field18429.method06730(var1);
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      FontRenderer var5 = Fonts.field00111;
      float var6 = field18432;
      this.field18428.method06162();
      this.field18428.method06168(this.field18429.method06726() ? var4 : 0.0, field18433, Easings.field19400, true);
      int var7 = ColorUtils.method04631(
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22120.method11679(), this.method09790()),
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22119.method11679(), this.method09790()),
         this.field18428.method06173()
      );
      int var8 = ColorUtils.method04631(
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22110.method11679(), this.method09790()),
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22109.method11676(), this.method09790()),
         this.field18428.method06173()
      );
      int var9 = ColorUtils.method04611(
         ThemeManager.INSTANCE.method09611().field22110.method11679(),
         ColorUtils.method04594(ThemeManager.INSTANCE.method09611().field22110.method11679()) / field18434 * this.method09790()
      );
      RoundedRectRenderer.method01272(
         var1,
         this.method09780(),
         this.method09782(),
         this.method09784(),
         this.method09785(),
         GuiSize.method04763(field18435).method04764(field18436).method04761(),
         1.0F,
         var7
      );
      Fonts.field00107
         .method09490(
            var1,
            field18437,
            this.method09780() + this.method09784() - field18438 - Fonts.field00107.method09478(field18439, var6, field18440),
            this.method09782() + this.method09785() / 2.0F - Fonts.field00107.method09485(var6) / 2.0F + field18441,
            var9,
            var6,
            field18442
         );
      this.field18429
         .method06700(this.method09780(), this.method09782(), this.method09784(), this.method09785())
         .method06678(var5, var6)
         .method06725(var1, var2, var8, var9, TextInputWidget.method06677(this.method09790()));
   }

   @Override
   public void method07531() {
      this.field18429.method06722();
      super.method07531();
   }

   public String method07532() {
      return this.field18429.method06687();
   }

   public SmoothAnimation method07533() {
      return this.field18428;
   }
}
