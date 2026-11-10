// Original binary: sg/ec/uz9cGZtmohYdno5L
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public abstract class SettingComponent<T extends Setting<?>> extends GuiComponent {
   private final T field24628;
   private final SmoothAnimation field24629 = new SmoothAnimation();
   private static final double field24630 = 0.15F;

   public T method10977() {
      return this.field24628;
   }

   public SettingComponent(T var1) {
      this.field24628 = (T)(Object)var1;
      float var2 = var1.method03019() ? 1.0F : 0.0F;
      this.field24629.method06155(var2);
      this.field24629.method06175(var2);
   }

   public float method10978() {
      return 0.0F;
   }

   public SmoothAnimation method10979() {
      return this.field24629;
   }

   public boolean method00251(double var1, double var3, int var5) {
      if (var5 == 2 && this.method09787(var1, var3)) {
         this.field24628.method00869();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void method00042(GuiGraphics var1, int var2, int var3, float var4) {
      this.field24629.method06162();
      this.field24629.method06168(this.field24628.method03019() ? 1.0 : 0.0, field24630, Easings.field19400, false);
   }

   public float method04887() {
      return this.method09785();
   }

   public void method03443() {
   }
}
