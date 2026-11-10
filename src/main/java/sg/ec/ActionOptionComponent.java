// Original binary: sg/ec/6Vhg9bY7Ka24DA2w
package sg.ec;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class ActionOptionComponent extends GuiComponent {
   private final NamedOption<Runnable> field03528;
   private final SmoothAnimation field03529 = new SmoothAnimation();
   private FontRenderer field03530 = Fonts.field00110;
   private float field03531;
   private boolean field03532;
   private static final float field03533 = 7.0F;
   private static final double field03534 = 0.2F;
   private static final float field03535 = 10.0F;
   private static final float field03536 = 8.0F;

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (var5 == 0 && this.method09787(var1, var3)) {
         this.field03528.method08074().run();
      }
   }

   public ActionOptionComponent(NamedOption<Runnable> var1) {
      this.field03531 = field03533;
      this.field03532 = false;
      this.field03528 = var1;
   }

   public void method01430(FontRenderer var1, float var2, boolean var3) {
      this.field03530 = var1;
      this.field03531 = var2;
      this.field03532 = var3;
   }

   public String method01431() {
      return this.field03528.method08080();
   }

   @Override
   public void method00042(GuiGraphics var1, int var2, int var3, float var4) {
      this.field03529.method06162();
      this.field03529.method06158(this.method09787(var2, var3) ? 1.0 : 0.0, field03534, Easings.field19400);
      int var5 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22114.method11676(), this.method09790());
      int var6 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22113.method11676(), this.method09790());
      int var7 = ColorUtils.method04631(var5, var6, this.field03529.method06173());
      RoundedRectRenderer.method01272(var1, this.method09780(), this.method09782(), this.method09784(), this.method09785(), 2.0F, 1.0F, var7);
      int var8 = ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22109.method11676(), this.method09790());
      List var9 = this.field03532
         ? TextRenderUtils.method00677(
            this.field03528.method08080(), Math.max(field03535, this.method09784() - field03536), this.field03530, this.field03531
         )
         : Collections.singletonList(this.field03528.method08080());
      float var10 = this.field03530.method09485(this.field03531);
      float var11 = var9.size() * var10;
      float var12 = this.method09782() + (this.method09785() - var11) / 2.0F;

      for (String var14 : (Iterable<String>) (Iterable) var9) {
         this.field03530.method09473(var1, var14, this.method09780() + this.method09784() / 2.0F, var12, var8, this.field03531);
         var12 += var10;
      }
   }
}
