// Original binary: sg/ec/0Fh8zyHS7NUu6t6E
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class CategoryTab extends GuiComponent {
   private static final float field00080 = 0.15F;
   private final ClickGuiScreen field00081;
   private final ModuleCategory field00082;
   private final SmoothAnimation field00083 = new SmoothAnimation();
   private static final float field00084 = 15.0F;
   private static final float field00085 = 15.0F;
   private static final double field00086 = 0.15F;

   public CategoryTab(ClickGuiScreen var1, ModuleCategory var2) {
      this.field00081 = var1;
      this.field00082 = var2;
      this.method09781(field00084);
      this.method09786(field00085);
   }

   public SmoothAnimation method00037() {
      return this.field00083;
   }

   public ModuleCategory method00038() {
      return this.field00082;
   }

   public boolean method00039(double var1, double var3, int var5) {
      if (var5 == 0 && this.method09787(var1, var3)) {
         this.field00081.method09988(this.field00082);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
   }

   public ClickGuiScreen method00041() {
      return this.field00081;
   }

   @Override
   public void method00042(GuiGraphics var1, int var2, int var3, float var4) {
      this.field00083.method06162();
      this.field00083.method06156(this.method09787(var2, var3) ? 1.0 : 0.0, field00086, true);
      ClickGuiDecorationRenderer.method08404(var1, this.method09780(), this.method09782(), this.field00082.method00307(), this.field00083.method06173(), var4);
   }
}
