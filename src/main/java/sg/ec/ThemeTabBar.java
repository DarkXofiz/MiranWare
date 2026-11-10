// Original binary: sg/ec/0kdW9hRwm2C3DlQY
package sg.ec;

import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ThemeTabBar extends GuiComponent {
   private final ModuleContextMenu field00405;
   private final List<ThemeTabComponent> field00406;
   private static final float field00407 = 0.75F;
   private static final float field00408 = 5.0F;
   private static final float field00409 = 12.0F;
   private static final String field00410 = "+";
   private static final float field00411 = 5.0F;
   private static final float field00412 = 125.0F;

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (this.method09787(var1, var3)) {
         ThemeSettings var6 = ThemeManager.INSTANCE.method09615();
         this.field00406.add(new ThemeTabComponent(var6, this.field00405));
         ThemeManager.INSTANCE.method09612(var6);
         this.field00405.method09652(new ThemeEditorWindow(), field00411, GuiScaleUtils.method06754() / 2.0F - field00412);
      }
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      int var5 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), var4 * field00407);
      GuiShapeRenderer.method09703(var1, this.method09780(), this.method09782(), this.method09784(), this.method09785(), field00408, 1.0F, var5);
      FontRenderer var6 = Fonts.field00109;
      float var7 = field00409;
      float var8 = this.method09780() + this.method09784() / 2.0F;
      float var9 = this.method09782() + this.method09785() / 2.0F - var6.method09485(var7) / 2.0F;
      var6.method09473(
         var1, field00410, var8, var9, ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22109.method11676(), var4), var7
      );
   }

   public ThemeTabBar(ModuleContextMenu var1, List<ThemeTabComponent> var2) {
      this.field00405 = var1;
      this.field00406 = var2;
   }
}
