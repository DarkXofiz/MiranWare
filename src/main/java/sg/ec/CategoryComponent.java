// Original binary: sg/ec/n1tu7djxSdKgQlEG
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class CategoryComponent extends GuiComponent {
   private static final float field21801 = 8.5F;
   private static final CornerRadii field21802 = new CornerRadii(CategoryComponent.field21825);
   private final ClickGuiScreen field21803;
   private final ModuleCategory field21804;
   private final SmoothAnimation field21805 = new SmoothAnimation();
   private static final float field21806 = 7.5F;
   private static final double field21807 = 0.15F;
   private static final float field21808 = 7.5F;
   private static final float field21809 = 0.5F;
   private static final float field21810 = 0.025F;
   private static final float field21811 = 0.2F;
   private static final float field21812 = 0.25F;
   private static final float field21813 = 0.2F;
   private static final float field21814 = 0.25F;
   private static final float field21815 = 0.2F;
   private static final float field21816 = 0.2F;
   private static final float field21817 = 0.25F;
   private static final float field21818 = 0.2F;
   private static final float field21819 = 8.0F;
   private static final float field21820 = 0.5F;
   private static final float field21821 = 8.5F;
   private static final String field21822 = "CategoryKey";
   private static final float field21823 = 15.0F;
   private static final float field21824 = 0.5F;
   private static final float field21825 = 4.0F;

   public boolean method09595(double var1, double var3, int var5) {
      if (GuiHitTestUtils.method05624((int)var1, (int)var3, this.method09780(), this.method09782(), this.method09784(), this.method09785()) && var5 == 0) {
         this.field21803.method09967(this.field21804);
         return true;
      } else {
         return false;
      }
   }

   public ClickGuiScreen method09596() {
      return this.field21803;
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      FontRenderer var5 = Fonts.field00109;
      float var6 = field21806;
      this.field21805.method06162();
      this.field21805.method06168(this.field21803.method09939().equals(this.field21804) ? var4 : 0.0, field21807, Easings.field19394, true);
      RoundedRectRenderer.method01272(
         var1,
         this.method09780(),
         this.method09782(),
         this.method09784(),
         this.method09785(),
         GuiSize.method04763(field21808).method04764(field21809).method04761(),
         1.0F,
         ColorUtils.method04605(
            ColorUtils.method04583(ThemeManager.INSTANCE.method09611().field22104.method11676(), ColorUtils.field10170, field21810),
            var4 * field21811 * this.field21805.method06173()
         )
      );
      GuiShapeRenderer.method09700(
         var1,
         this.method09780(),
         this.method09782(),
         this.method09784(),
         this.method09785(),
         field21802,
         field21812,
         1.0F,
         new CornerColors(
            ColorUtils.method04605(
               ThemeManager.INSTANCE.method09611().field22117.method11676(), this.field21805.method06173() * field21813 * var4
            ),
            ColorUtils.method04605(
               ColorUtils.method04583(ThemeManager.INSTANCE.method09611().field22117.method11676(), ColorUtils.field10170, field21814),
               this.field21805.method06173() * field21815 * var4
            ),
            ColorUtils.method04605(
               ThemeManager.INSTANCE.method09611().field22117.method11676(), this.field21805.method06173() * field21816 * var4
            ),
            ColorUtils.method04605(
               ColorUtils.method04583(ThemeManager.INSTANCE.method09611().field22117.method11676(), ColorUtils.field10170, field21817),
               this.field21805.method06173() * field21818 * var4
            )
         )
      );
      Fonts.field00107
         .method09487(
            var1,
            this.field21804.method00307(),
            this.method09780() + field21819,
            this.method09782() + field21820,
            field21821,
            ColorUtils.method04611(
               ColorUtils.method04631(
                  ThemeManager.INSTANCE.method09611().field22110.method11676(),
                  ThemeManager.INSTANCE.method09611().field22109.method11676(),
                  this.field21805.method06173()
               ),
               var4
            )
         );
      var5.method09480(
         var1,
         FontFallbackManager.method07177(
            field21822,
            this.field21804.name(),
            ColorUtils.method04631(
               ThemeManager.INSTANCE.method09611().field22110.method11676(),
               ThemeManager.INSTANCE.method09611().method09800(),
               this.field21805.method06173()
            ),
            ColorUtils.method04631(
               ThemeManager.INSTANCE.method09611().field22110.method11676(),
               ThemeManager.INSTANCE.method09611().method09809(),
               this.field21805.method06173()
            )
         ),
         this.method09780() + field21823,
         this.method09782() - field21824 + this.method09785() / 2.0F - var5.method09485(var6) / 2.0F,
         ColorUtils.method04611(-1, var4),
         var6
      );
   }

   public SmoothAnimation method09597() {
      return this.field21805;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
   }

   public CategoryComponent(ClickGuiScreen var1, ModuleCategory var2) {
      this.field21803 = var1;
      this.field21804 = var2;
   }

   public ModuleCategory method09598() {
      return this.field21804;
   }
}
