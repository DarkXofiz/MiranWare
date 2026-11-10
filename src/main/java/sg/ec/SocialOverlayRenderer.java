// Original binary: sg/ec/r1k2yylkefM67Bvg
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class SocialOverlayRenderer {
   private static final float field23137 = 172.0F;
   private static final float field23138 = 0;
   private static final float field23139 = 0;
   private static final float field23140 = 0;
   private static final float field23141 = 0;
   private static final long field23142 = 0;
   private static final int field23143 = ColorUtils.method04604(120, 230, 130);
   private static final int field23144 = ColorUtils.method04604(235, 90, 90);
   private final ClickGuiScreen field23145;
   private final Map<Object, AnimationUtils> field23146 = new HashMap<>();
   private final List<Runnable> field23147 = new ArrayList<>();
   private final List<SocialOverlayRenderer.Nested292> field23148 = new ArrayList<>();
   private static final float field23149 = 0.01F;
   private static final float field23150 = 8.0F;
   private static final float field23151 = 172.0F;
   private static final float field23152 = 8.0F;
   private static final float field23153 = 42.0F;
   private static final float field23154 = 172.0F;
   private static final float field23155 = 3.75F;
   private static final float field23156 = 22.0F;
   private static final float field23157 = 172.0F;
   private static final float field23158 = 3.75F;
   private static final float field23159 = 0.96F;
   private static final float field23160 = 172.0F;
   private static final float field23161 = 3.75F;
   private static final float field23162 = 0.4F;
   private static final float field23163 = 8.0F;
   private static final float field23164 = 6.0F;
   private static final float field23165 = 7.0F;
   private static final float field23166 = 156.0F;
   private static final float field23167 = 5.5F;
   private static final float field23168 = 8.0F;
   private static final float field23169 = 6.0F;
   private static final float field23170 = 7.0F;
   private static final float field23171 = 0.9F;
   private static final float field23172 = 5.5F;
   private static final float field23173 = 75.0F;
   private static final float field23174 = 13.0F;
   private static final float field23175 = 7.0F;
   private static final float field23176 = 8.0F;
   private static final float field23177 = 8.0F;
   private static final float field23178 = 6.0F;
   private static final String field23179 = "Принять";
   private static final String field23180 = "Отклонить";
   private static final float field23181 = 6.0F;
   private static final float field23182 = 30.0F;
   private static final float field23183 = 172.0F;
   private static final float field23184 = 3.75F;
   private static final float field23185 = 22.0F;
   private static final float field23186 = 172.0F;
   private static final float field23187 = 3.75F;
   private static final float field23188 = 0.96F;
   private static final float field23189 = 172.0F;
   private static final float field23190 = 3.75F;
   private static final float field23191 = 0.4F;
   private static final float field23192 = 8.0F;
   private static final float field23193 = 6.0F;
   private static final float field23194 = 6.5F;
   private static final float field23195 = 148.0F;
   private static final float field23196 = 5.5F;
   private static final float field23197 = 8.0F;
   private static final float field23198 = 6.0F;
   private static final float field23199 = 6.5F;
   private static final float field23200 = 0.9F;
   private static final float field23201 = 5.5F;
   private static final float field23202 = 172.0F;
   private static final float field23203 = 6.0F;
   private static final float field23204 = 11.0F;
   private static final float field23205 = 6.0F;
   private static final float field23206 = 11.0F;
   private static final float field23207 = 11.0F;
   private static final float field23208 = 1.625F;
   private static final float field23209 = 0.6F;
   private static final float field23210 = 0.8F;
   private static final String field23211 = "X";
   private static final float field23212 = 5.5F;
   private static final float field23213 = 5.5F;
   private static final float field23214 = 6.0F;
   private static final float field23215 = 1.625F;
   private static final float field23216 = 0.7F;
   private static final float field23217 = 0.42F;
   private static final float field23218 = 1.625F;
   private static final float field23219 = 0.5F;
   private static final float field23220 = 0.6F;
   private static final float field23221 = 5.5F;
   private static final float field23222 = 5.5F;
   private static final long field23223 = 150L;

   private float method10277(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, SocialNotificationSounds.Nested169 var7) {
      FontRenderer var8 = Fonts.field00110;
      float sx = field23153;
      GuiClipStack.method00341(var1, var5, var6, field23154, sx, field23155, 1.0F, field23156, var4);
      RoundedRectRenderer.method01272(var1, var5, var6, field23157, sx, field23158, 1.0F, method10279(method10288().field22121.method11676(), field23159 * var4));
      GuiShapeRenderer.method09703(var1, var5, var6, field23160, sx, field23161, 1.0F, method10279(method10288().field22117.method11676(), field23162 * var4));
      var8.method09480(var1, var7.title(), var5 + field23163, var6 + field23164, method10279(method10288().field22109.method11676(), var4), field23165);
      String sxx = "приглашает на сервер" + (var7.server() != null && !var7.server().isBlank() ? " · " + method10291(var7.server()) : "");
      var8.method09480(
         var1,
         method10281(var8, sxx, field23166, field23167),
         var5 + field23168,
         var6 + field23169 + var8.method09485(field23170) + 2.0F,
         method10279(method10288().field22110.method11676(), field23171 * var4),
         field23172
      );
      float sxxx = field23173;
      float sxxxx = field23174;
      float sxxxxx = var6 + sx - sxxxx - field23175;
      SocialOverlayRenderer.Nested292 sxxxxxx = new SocialOverlayRenderer.Nested292(var5 + field23176, sxxxxx, sxxx, sxxxx);
      SocialOverlayRenderer.Nested292 sxxxxxxx = new SocialOverlayRenderer.Nested292(var5 + field23177 + sxxx + field23178, sxxxxx, sxxx, sxxxx);
      this.method10292(var1, sxxxxxx, field23179, this.method10284("acc:" + var7.field11803(), sxxxxxx.has(var2, var3)), field23143, var4);
      this.method10292(var1, sxxxxxxx, field23180, this.method10284("dec:" + var7.field11803(), sxxxxxxx.has(var2, var3)), field23144, var4);
      this.method10286(sxxxxxx, () -> SocialNotificationSounds.method05506(var7));
      this.method10286(sxxxxxxx, () -> SocialNotificationSounds.method05509(var7));
      return var6 + sx + field23181;
   }

   private static int method10279(int var0, float var1) {
      return ColorUtils.method04611(var0, var1);
   }

   public boolean method10280(double var1, double var3, int var5) {
      if (var5 != 0) {
         return false;
      }

      float var6 = (float)var1;
      float var7 = (float)var3;

      for (int var8 = 0; var8 < this.field23148.size(); var8++) {
         if (this.field23148.get(var8).has(var6, var7)) {
            this.field23147.get(var8).run();
            return true;
         }
      }

      return false;
   }

   private static String method10281(FontRenderer var0, String var1, float var2, float var3) {
      if (var1 == null) {
         return "";
      }

      if (var0.method09486(var1, var3) <= var2) {
         return var1;
      }

      StringBuilder var4 = new StringBuilder();

      for (int var5 = 0; var5 < var1.length() && !(var0.method09486(var4.toString() + var1.charAt(var5) + "…", var3) > var2); var5++) {
         var4.append(var1.charAt(var5));
      }

      return var4 + "…";
   }

   private float method10283(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, SocialNotificationSounds.Nested169 var7) {
      FontRenderer var8 = Fonts.field00110;
      float var9 = field23182;
      GuiClipStack.method00341(var1, var5, var6, field23183, var9, field23184, 1.0F, field23185, var4);
      RoundedRectRenderer.method01272(
         var1, var5, var6, field23186, var9, field23187, 1.0F, method10279(method10288().field22121.method11676(), field23188 * var4)
      );
      GuiShapeRenderer.method09703(
         var1, var5, var6, field23189, var9, field23190, 1.0F, method10279(method10288().field22117.method11676(), field23191 * var4)
      );
      var8.method09480(var1, var7.title(), var5 + field23192, var6 + field23193, method10279(method10288().field22109.method11676(), var4), field23194);
      var8.method09480(
         var1,
         method10281(var8, var7.message(), field23195, field23196),
         var5 + field23197,
         var6 + field23198 + var8.method09485(field23199) + 2.0F,
         method10279(method10288().field22110.method11676(), field23200 * var4),
         field23201
      );
      SocialOverlayRenderer.Nested292 var10 = new SocialOverlayRenderer.Nested292(
         var5 + field23202 - field23203 - field23204, var6 + field23205, field23206, field23207
      );
      float var11 = this.method10284("cl:" + var7.field11803(), var10.has(var2, var3));
      RoundedRectRenderer.method01272(
         var1,
         var10.field23224(),
         var10.field23225(),
         var10.field23226(),
         var10.field23227(),
         field23208,
         1.0F,
         method10290(method10279(method10288().field22120.method11676(), field23209 * var4), method10279(field23144, field23210 * var4), var11)
      );
      Fonts.field00109
         .method09473(
            var1,
            field23211,
            var10.field23224() + var10.field23226() / 2.0F,
            var10.field23225() + var10.field23227() / 2.0F - Fonts.field00109.method09485(field23212) / 2.0F,
            method10279(method10290(method10288().field22110.method11676(), method10288().field22109.method11676(), var11), var4),
            field23213
         );
      this.method10286(var10, () -> SocialNotificationSounds.method05512(var7));
      return var6 + var9 + field23214;
   }

   private float method10284(Object var1, boolean var2) {
      AnimationUtils var3 = this.field23146.computeIfAbsent(var1, var0 -> new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field23223));
      var3.method03375(var2 ? 1.0 : 0.0);
      return var3.method03377();
   }

   private void method10286(SocialOverlayRenderer.Nested292 var1, Runnable var2) {
      this.field23148.add(var1);
      this.field23147.add(var2);
   }

   public void method10287(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      this.field23147.clear();
      this.field23148.clear();
      if (!(var4 <= field23149)) {
         var var5 = SocialNotificationSounds.field11793;
         if (!var5.isEmpty()) {
            float var6 = this.field23145.method10033() - field23150 - field23151;
            float var7 = field23152;

            for (SocialNotificationSounds.Nested169 var9 : var5) {
               var7 = var9.interactive()
                  ? this.method10277(var1, var2, var3, var4, var6, var7, var9)
                  : this.method10283(var1, var2, var3, var4, var6, var7, var9);
            }
         }
      }
   }

   private static ThemeSettings method10288() {
      return ThemeManager.INSTANCE.method09611();
   }

   private static int method10290(int var0, int var1, float var2) {
      return ColorUtils.method04631(var0, var1, var2);
   }

   private static String method10291(String var0) {
      if (var0 == null) {
         return "";
      }

      int var1 = var0.indexOf(58);
      return var1 > 0 ? var0.substring(0, var1) : var0;
   }

   public SocialOverlayRenderer(ClickGuiScreen var1) {
      this.field23145 = var1;
   }

   private void method10292(GuiGraphicsExtractor var1, SocialOverlayRenderer.Nested292 var2, String var3, float var4, int var5, float var6) {
      RoundedRectRenderer.method01272(
         var1,
         var2.field23224(),
         var2.field23225(),
         var2.field23226(),
         var2.field23227(),
         field23215,
         1.0F,
         method10290(method10279(method10288().field22120.method11676(), field23216 * var6), method10279(var5, field23217 * var6), var4)
      );
      GuiShapeRenderer.method09703(
         var1,
         var2.field23224(),
         var2.field23225(),
         var2.field23226(),
         var2.field23227(),
         field23218,
         field23219,
         method10279(method10288().field22117.method11676(), field23220 * var6)
      );
      Fonts.field00110
         .method09473(
            var1,
            var3,
            var2.field23224() + var2.field23226() / 2.0F,
            var2.field23225() + var2.field23227() / 2.0F - Fonts.field00110.method09485(field23221) / 2.0F,
            method10279(method10288().field22109.method11676(), var6),
            field23222
         );
   }

   // $VF: Compiled from s
   private record Nested292(float field23224, float field23225, float field23226, float field23227) {
      boolean has(float var1, float var2) {
         return GuiHitTestUtils.method05625(var1, var2, this.field23224, this.field23225, this.field23226, this.field23227);
      }
   }
}
