// Original binary: sg/ec/5HBGZGK2faOo5Kwi
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class ScriptsWindow extends FloatingWindow {
   public static final String field02144 = "scripts.menu";
   private static final float field02145 = 0;
   private static final float field02146 = 0;
   private static final float field02147 = 0;
   private static final float field02148 = 0;
   private static final float field02149 = 0;
   private static final float field02150 = 0;
   private static final float field02151 = 0;
   private static final float field02152 = 0;
   private static final float field02153 = 0;
   private static final float field02154 = 0;
   private static final float field02155 = GuiSize.method04763(ScriptsWindow.field02188)
      .method04764(ScriptsWindow.field02189)
      .method04768();
   private final FontRenderer field02156 = GuiThemeStyle.field03544;
   private final List<ScriptsWindow.Nested34> field02157;
   private final List<SmoothAnimation> field02158 = new ArrayList<>();
   private static final String field02159 = "Меню";
   private static final String field02160 = "scripts.menu";
   private static final float field02161 = 14.0F;
   private static final float field02162 = 8.0F;
   private static final float field02163 = 78.0F;
   private static final float field02164 = 16.0F;
   private static final float field02165 = 6.0F;
   private static final float field02166 = 8.0F;
   private static final float field02167 = 8.0F;
   private static final float field02168 = 4.0F;
   private static final float field02169 = 14.0F;
   private static final float field02170 = 4.0F;
   private static final float field02171 = 8.0F;
   private static final float field02172 = 14.0F;
   private static final double field02173 = 0.12F;
   private static final float field02174 = 0.01F;
   private static final float field02175 = 14.0F;
   private static final float field02176 = 0.08F;
   private static final float field02177 = 0.5F;
   private static final float field02178 = 0.5F;
   private static final float field02179 = 8.0F;
   private static final float field02180 = 7.0F;
   private static final float field02181 = 7.0F;
   private static final float field02182 = 16.0F;
   private static final float field02183 = 7.0F;
   private static final float field02184 = 6.0F;
   private static final float field02185 = 6.0F;
   private static final float field02186 = 0.999F;
   private static final double field02187 = 14.0;
   private static final float field02188 = 10.0F;
   private static final float field02189 = 0.5F;

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      float var5 = this.method09573().method06173() * GuiHitTestUtils.method05621(var4);
      GuiRenderBatch.method05183();
      ScrollbarRenderer.method06911(var1, this.method09576() + this.method09568() / 2.0F, this.method09560(), var5);
      WindowFrameRenderer.method03057(var1, this, field02155, var5);

      for (int sx = 0; sx < this.field02157.size(); sx++) {
         this.method00952(var1, this.field02157.get(sx), this.field02158.get(sx), this.method00954(sx), var2, var3, var5);
      }

      var1.pose().popMatrix();
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (var5 == 0 && !(this.method09573().method06173() < field02186)) {
         int var6 = (int)((var3 - this.method00954(0)) / field02187);
         if (var6 >= 0 && var6 < this.field02157.size() && this.method09578(var1, var3)) {
            this.field02157.get(var6).action().run();
            this.method09580().method09654(this);
         }
      }
   }

   private void method00952(GuiGraphics var1, ScriptsWindow.Nested34 var2, SmoothAnimation var3, float var4, int var5, int var6, float var7) {
      float var8 = this.method09576() + field02170;
      float var9 = this.method09568() - field02171;
      var3.method06162();
      var3.method06168(GuiHitTestUtils.method05624(var5, var6, var8, var4, var9, field02172) ? 1.0 : 0.0, field02173, Easings.field19400, true);
      float var10 = var3.method06173();
      if (var10 > field02174) {
         RoundedRectRenderer.method01272(var1, var8, var4, var9, field02175, 2.0F, 1.0F, GuiThemeStyle.method01437(field02176 * var10 * var7));
      }

      int var11 = GuiThemeStyle.method01443(
         GuiThemeStyle.method01440(
            GuiThemeStyle.method01441().field22110.method11676(),
            GuiThemeStyle.method01441().field22109.method11676(),
            field02177 + field02178 * var10
         ),
         var7
      );
      var2.icon().method01190(var1, var8 + field02179, var4 + field02180, field02181, var11);
      this.field02156.method09480(var1, var2.label(), var8 + field02182, var4 + field02183 - this.field02156.method09485(field02184) / 2.0F, var11, field02185);
   }

   public ScriptsWindow(List<ScriptsWindow.Nested34> var1) {
      super(field02159, field02160);
      this.field02157 = var1;

      for (int var2 = 0; var2 < var1.size(); var2++) {
         this.field02158.add(new SmoothAnimation());
      }

      this.method08971(method00953(var1));
      this.method09561(field02161 * var1.size() + field02162);
   }

   private static float method00953(List<ScriptsWindow.Nested34> var0) {
      float var1 = field02163;

      for (ScriptsWindow.Nested34 var3 : var0) {
         var1 = Math.max(var1, field02164 + GuiThemeStyle.field03544.method09486(var3.label(), field02165) + field02166 + field02167);
      }

      return var1;
   }

   private float method00954(int var1) {
      return this.method09560() + field02168 + field02169 * var1;
   }

   // $VF: Compiled from s
   public record Nested34(GuiIcon icon, String label, Runnable action) {
   }
}
