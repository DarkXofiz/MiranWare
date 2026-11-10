// Original binary: sg/ec/3qDBjADvxMWhSmf5
package sg.ec;

import java.util.Objects;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class MultiToggleOptionComponent extends GuiComponent {
   private final FontRenderer field01758 = Fonts.field00111;
   private final float field01759;
   private final MultiToggleSetting field01760;
   private final NamedOption<Boolean> field01761;
   private final SmoothAnimation field01762;
   private static final float field01763 = 6.0F;
   private static final double field01764 = 0.25;
   private static final float field01765 = 1.5F;
   private static final float field01766 = 1.5F;
   private static final float field01767 = 0.5F;
   private static final float field01768 = 6.0F;
   private static final float field01769 = 6.0F;
   private static final float field01770 = 6.0F;

   public SmoothAnimation method00770() {
      return this.field01762;
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (this.field01761.method08075()) {
         if (GuiHitTestUtils.method05609(var1, var3, this.method09780(), this.method09782(), this.method09784(), this.method09785()) && var5 == 0) {
            boolean var6 = Boolean.TRUE.equals(this.field01761.method08074());
            if (var6 && this.field01760.method04514() <= this.field01760.method04522()) {
               return;
            }

            this.field01760.method04519(this.field01761.method08080(), !var6);
         }
      }
   }

   public MultiToggleOptionComponent(MultiToggleSetting var1, NamedOption<Boolean> var2) {
      this.field01759 = field01763;
      this.field01762 = new SmoothAnimation();
      this.field01760 = var1;
      this.field01761 = var2;
   }

   public float method00771() {
      Objects.requireNonNull(this);
      return field01770;
   }

   public NamedOption<Boolean> method00772() {
      return this.field01761;
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      if (this.field01761.method08075()) {
         this.field01762.method06162();
         this.field01762.method06158(this.field01761.method08074() ? 1.0 : 0.0, field01764, Easings.field19400);
         int var5 = ColorUtils.method04583(
            ThemeManager.INSTANCE.method09611().field22110.method11676(),
            ThemeManager.INSTANCE.method09611().field22109.method11676(),
            this.field01762.method06173()
         );
         RoundedRectRenderer.method01272(
            var1,
            this.method09780(),
            this.method09782(),
            this.method09784(),
            this.method09785(),
            field01765,
            1.0F,
            ColorUtils.method04631(
               ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22116.method11676(), this.method09790()),
               ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22115.method11676(), this.method09790()),
               this.field01762.method06173()
            )
         );
         GuiShapeRenderer.method09703(
            var1,
            this.method09780(),
            this.method09782(),
            this.method09784(),
            this.method09785(),
            field01766,
            field01767,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), this.method09790())
         );
         this.field01758
            .method09473(
               var1,
               this.field01761.method08080(),
               this.method09780() + this.method09784() / 2.0F,
               this.method09782() + this.method09785() / 2.0F - this.field01758.method09485(field01768) / 2.0F,
               ColorUtils.method04605(var5, this.method09790()),
               field01769
            );
      }
   }

   public MultiToggleSetting method00773() {
      return this.field01760;
   }

   public FontRenderer method00774() {
      return this.field01758;
   }
}
