// Original binary: sg/ec/35wrCbrlnERprk0j
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class ToggleBindingWindow extends FloatingWindow {
   private final KeyBindSettingComponent field01114;
   private static final float field01115 = 100.0F;
   private static final float field01116 = 10.0F;
   private static final float field01117 = 0.5F;
   private static final float field01118 = 0.875F;
   private static final float field01119 = 0.75F;
   private static final float field01120 = 0.75F;
   private static final float field01121 = 0.75F;
   private static final float field01122 = 4.0F;
   private static final float field01123 = 2.5F;
   private static final float field01124 = 8.0F;
   private static final float field01125 = 5.0F;

   public ToggleBindingWindow(String var1, KeyBindSetting var2) {
      super(var1);
      this.field01114 = new KeyBindSettingComponent(var2);
      this.method08971(field01115);
      this.method09557(true);
   }

   public KeyBindSettingComponent method00610() {
      return this.field01114;
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      if (var1 == 256 && !this.field01114.method11004()) {
         this.method09580().method09654(this);
      } else {
         this.field01114.method00250(var1, var2, var3);
      }
   }

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method09557(this.method09569());
      GuiRenderBatch.method05183();
      GuiSize var5 = GuiSize.method04763(field01116);
      RoundedRectRenderer.method01275(
         var1,
         this.method09576(),
         this.method09560(),
         this.method09568(),
         this.method09574(),
         var5.method04764(field01117).method04768(),
         1.0F,
         new CornerColors(
            ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22121.method11676(), field01118 * this.method09573().method06173()),
            ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22121.method11676(), field01119 * this.method09573().method06173()),
            ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22121.method11676(), field01120 * this.method09573().method06173()),
            ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22121.method11676(), field01121 * this.method09573().method06173())
         )
      );
      this.field01114.method09789(this.method09576() + field01122);
      this.field01114.method09788(this.method09560() + field01123);
      this.field01114.method09781(this.method09568() - field01124);
      this.field01114.method09783(this.method09573().method06173());
      this.field01114.method00042(var1, var2, var3, var4);
      this.method09561(this.field01114.method09785() + field01125);
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      this.field01114.method00040(var1, var3, var5);
   }
}
