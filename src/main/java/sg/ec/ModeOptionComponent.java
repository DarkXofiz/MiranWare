// Original binary: sg/ec/n2MoUJODL8zX5PF1
package sg.ec;

import java.util.Objects;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ModeOptionComponent extends GuiComponent {
   private final FontRenderer field21826 = Fonts.field00111;
   private final float field21827;
   private final ModeSetting field21828;
   private final String field21829;
   private final SmoothAnimation field21830;
   private static final float field21831 = 6.0F;
   private static final double field21832 = 0.25;
   private static final float field21833 = 1.5F;
   private static final float field21834 = 1.5F;
   private static final float field21835 = 0.5F;
   private static final float field21836 = 6.0F;
   private static final float field21837 = 6.0F;
   private static final float field21838 = 6.0F;

   public ModeOptionComponent(ModeSetting var1, String var2) {
      this.field21827 = field21831;
      this.field21830 = new SmoothAnimation();
      this.field21828 = var1;
      this.field21829 = var2;
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      this.field21830.method06162();
      this.field21830.method06158(this.field21828.method05600(this.field21829) ? 1.0 : 0.0, field21832, Easings.field19400);
      int var5 = ColorUtils.method04583(
         ThemeManager.INSTANCE.method09611().field22110.method11676(),
         ThemeManager.INSTANCE.method09611().field22109.method11676(),
         this.field21830.method06173()
      );
      RoundedRectRenderer.method01272(
         var1,
         this.method09780(),
         this.method09782(),
         this.method09784(),
         this.method09785(),
         field21833,
         1.0F,
         ColorUtils.method04631(
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22116.method11676(), this.method09790()),
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22115.method11676(), this.method09790()),
            this.field21830.method06173()
         )
      );
      GuiShapeRenderer.method09703(
         var1,
         this.method09780(),
         this.method09782(),
         this.method09784(),
         this.method09785(),
         field21834,
         field21835,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), this.method09790())
      );
      this.field21826
         .method09473(
            var1,
            this.field21829,
            this.method09780() + this.method09784() / 2.0F,
            this.method09782() + this.method09785() / 2.0F - this.field21826.method09485(field21836) / 2.0F,
            ColorUtils.method04605(var5, this.method09790()),
            field21837
         );
   }

   public SmoothAnimation method09599() {
      return this.field21830;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (GuiHitTestUtils.method05609(var1, var3, this.method09780(), this.method09782(), this.method09784(), this.method09785()) && var5 == 0) {
         this.field21828.method05603(this.field21829);
      }
   }

   public float method09600() {
      Objects.requireNonNull(this);
      return field21838;
   }

   public FontRenderer method09601() {
      return this.field21826;
   }

   public ModeSetting method09602() {
      return this.field21828;
   }

   public String method09603() {
      return this.field21829;
   }
}
