// Original binary: sg/ec/Yx8NGhXUYqPFeYdP
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class ThemeEditorWindow extends FloatingWindow {
   private static final CornerRadii field15050 = new CornerRadii(ThemeEditorWindow.field15212, 2.0F, ThemeEditorWindow.field15213, 0.0F);
   private final List<ThemeColorComponent> field15051 = new ArrayList<>();
   private final Map<String, SmoothAnimation> field15052 = new HashMap<>();
   private final SmoothAnimation field15053 = new SmoothAnimation();
   private final TextInputWidget field15054;
   private float field15055;
   private float field15056;
   private long field15057;
   private boolean field15058;
   private boolean field15059;
   private float field15060;
   private float field15061;
   private int field15062;
   private final SmoothAnimation field15063;
   private static final String field15064 = "menu.theme";
   private static final float field15065 = 6.5F;
   private static final String field15066 = "Название";
   private static final float field15067 = 3.0F;
   private static final float field15068 = 120.0F;
   private static final float field15069 = 275.0F;
   private static final double field15070 = 0.25;
   private static final float field15071 = 66.0F;
   private static final float field15072 = 10.0F;
   private static final float field15073 = 8.0F;
   private static final float field15074 = 8.0F;
   private static final String field15075 = "Theme Editor";
   private static final float field15076 = 13.0F;
   private static final float field15077 = 13.0F;
   private static final float field15078 = 13.0F;
   private static final String field15079 = "Theme Editor";
   private static final float field15080 = 13.0F;
   private static final float field15081 = 6.0F;
   private static final float field15082 = 25.0F;
   private static final float field15083 = 75.0F;
   private static final float field15084 = 12.0F;
   private static final float field15085 = 2.5F;
   private static final float field15086 = 2.5F;
   private static final float field15087 = 0.5F;
   private static final float field15088 = 84.0F;
   private static final float field15089 = 25.0F;
   private static final float field15090 = 30.0F;
   private static final float field15091 = 12.0F;
   private static final float field15092 = 360.0F;
   private static final float field15093 = 2.5F;
   private static final float field15094 = 0.5F;
   private static final float field15095 = 6.0F;
   private static final String field15096 = "Создать";
   private static final String field15097 = "Создать";
   private static final float field15098 = 44.5F;
   private static final float field15099 = 40.0F;
   private static final float field15100 = 66.0F;
   private static final float field15101 = 2.5F;
   private static final float field15102 = 5.0F;
   private static final float field15103 = 15.0F;
   private static final float field15104 = 16.0F;
   private static final float field15105 = 40.0F;
   private static final float field15106 = 4.0F;
   private static final float field15107 = 40.0F;
   private static final float field15108 = 40.0F;
   private static final float field15109 = 66.0F;
   private static final float field15110 = 3.5F;
   private static final float field15111 = 2.5F;
   private static final float field15112 = 3.5F;
   private static final float field15113 = 5.5F;
   private static final float field15114 = 4.0F;
   private static final float field15115 = 20.0F;
   private static final float field15116 = 66.0F;
   private static final float field15117 = 66.0F;
   private static final float field15118 = 4.0F;
   private static final float field15119 = 41.0F;
   private static final float field15120 = 1.5F;
   private static final float field15121 = 6.0F;
   private static final float field15122 = 20.5F;
   private static final float field15123 = 10.0F;
   private static final float field15124 = 4.0F;
   private static final float field15125 = 10.0F;
   private static final float field15126 = 4.5F;
   private static final float field15127 = 4.5F;
   private static final float field15128 = 9.0F;
   private static final float field15129 = 9.0F;
   private static final float field15130 = 4.5F;
   private static final float field15131 = 4.5F;
   private static final float field15132 = 9.0F;
   private static final float field15133 = 9.0F;
   private static final float field15134 = 3.0F;
   private static final float field15135 = 2.475F;
   private static final float field15136 = 2.475F;
   private static final float field15137 = 4.95F;
   private static final float field15138 = 4.95F;
   private static final float field15139 = 1.475F;
   private static final double field15140 = 0.15F;
   private static final float field15141 = 0.01F;
   private static final float field15142 = 6.0F;
   private static final String field15143 = "Miran";
   private static final float field15144 = 4.5F;
   private static final float field15145 = 4.5F;
   private static final float field15146 = 12.0F;
   private static final float field15147 = 4.0F;
   private static final float field15148 = 4.0F;
   private static final float field15149 = 16.0F;
   private static final float field15150 = 8.0F;
   private static final float field15151 = 4.0F;
   private static final float field15152 = 4.0F;
   private static final float field15153 = 16.0F;
   private static final float field15154 = 0.5F;
   private static final float field15155 = 6.5F;
   private static final double field15156 = 0.12F;
   private static final float field15157 = 0.02F;
   private static final float field15158 = 0.01F;
   private static final float field15159 = 4.0F;
   private static final float field15160 = 52.0F;
   private static final float field15161 = 28.0F;
   private static final float field15162 = 8.0F;
   private static final float field15163 = 4.0F;
   private static final float field15164 = 4.0F;
   private static final float field15165 = 0.5F;
   private static final float field15166 = 3.0F;
   private static final float field15167 = 3.5F;
   private static final float field15168 = 8.0F;
   private static final float field15169 = 8.0F;
   private static final float field15170 = 13.5F;
   private static final float field15171 = 48.0F;
   private static final float field15172 = 1.5F;
   private static final float field15173 = 3.5F;
   private static final float field15174 = 16.5F;
   private static final float field15175 = 8.0F;
   private static final float field15176 = 8.0F;
   private static final String field15177 = "Удалить";
   private static final float field15178 = 12.5F;
   private static final float field15179 = 6.5F;
   private static final float field15180 = 6.0F;
   private static final String field15181 = "Копировать";
   private static final float field15182 = 13.0F;
   private static final float field15183 = 19.5F;
   private static final float field15184 = 6.0F;
   private static final float field15185 = 4.0F;
   private static final float field15186 = 52.0F;
   private static final float field15187 = 14.0F;
   private static final float field15188 = 18.0F;
   private static final float field15189 = 52.0F;
   private static final float field15190 = 14.0F;
   private static final float field15191 = 6.0F;
   private static final float field15192 = 18.5F;
   private static final float field15193 = 10.0F;
   private static final float field15194 = 4.0F;
   private static final float field15195 = 10.0F;
   private static final float field15196 = 4.5F;
   private static final float field15197 = 4.5F;
   private static final float field15198 = 9.0F;
   private static final float field15199 = 9.0F;
   private static final float field15200 = 4.5F;
   private static final float field15201 = 40.0F;
   private static final float field15202 = 26.0F;
   private static final float field15203 = 84.0F;
   private static final float field15204 = 25.0F;
   private static final float field15205 = 30.0F;
   private static final float field15206 = 12.0F;
   private static final String field15207 = "Theme";
   private static final String field15208 = "Theme";
   private static final String field15209 = "Theme";
   private static final float field15210 = 66.0F;
   private static final double field15211 = 20.0;
   private static final float field15212 = 8.0F;
   private static final float field15213 = 4.0F;

   private void method06771() {
      String var1 = this.field15054.method06672();
      if (!var1.isEmpty()) {
         this.field15057 = System.currentTimeMillis();
         ThemeSettings sx = ThemeManager.INSTANCE.method09611();
         ThemeSettings sxx = ThemeManager.INSTANCE.method09615();
         ThemeManager.INSTANCE.method09616(sxx, var1);
         this.method06777(sx, sxx);
         ThemeManager.INSTANCE.method09612(sxx);
         this.field15055 = 0.0F;
         this.method06784();
         this.field15054.method06702();
         this.method09557(false);
         CustomResourceManager.INSTANCE.method02465(field15207);
      }
   }

   private void method06772(GuiGraphics var1, ThemeSettings var2, float var3) {
      if (this.field15058) {
         this.field15063.method06162();
         this.field15063.method06168(this.field15059 ? 0.0 : 1.0, field15156, Easings.field19400, true);
         float var4 = var3 * this.field15063.method06173();
         if (this.field15059 && this.field15063.method06173() < field15157) {
            this.field15058 = false;
            this.field15059 = false;
            this.field15062 = -1;
         } else if (!(var4 <= field15158)) {
            GuiRenderBatch.method05183();
            float var5 = this.field15060;
            float var6 = this.field15061 + field15159;
            float var7 = field15160;
            float var8 = field15161;
            GuiClipStack.method00341(var1, var5, var6, var7, var8, field15050.radius3(), 1.0F, field15162, var4);
            RoundedRectRenderer.method01272(var1, var5, var6, var7, var8, field15163, 1.0F, ColorUtils.method04611(var2.field22122.method11676(), var4));
            GuiShapeRenderer.method09703(
               var1, var5, var6, var7, var8, field15164, field15165, ColorUtils.method04611(var2.field22117.method11676(), var4)
            );
            int var9 = ColorUtils.method04611(var2.field22109.method11676(), var4);
            GuiTextureRenderer.method10259(var1, ClientTextures.INSTANCE.method04566(), var5 + field15166, var6 + field15167, field15168, field15169, var9);
            RoundedRectRenderer.method01272(
               var1, var5 + 2.0F, var6 + field15170, field15171, 1.0F, field15172, 1.0F, ColorUtils.method04611(var2.field22118.method11676(), var4)
            );
            GuiTextureRenderer.method10259(var1, ClientTextures.INSTANCE.method04567(), var5 + field15173, var6 + field15174, field15175, field15176, var9);
            var6 -= 2.0F;
            Fonts.field00110
               .method09480(
                  var1, field15177, var5 + field15178, var6 + field15179, ColorUtils.method04611(var2.field22109.method11676(), var4), field15180
               );
            Fonts.field00110
               .method09480(
                  var1, field15181, var5 + field15182, var6 + field15183, ColorUtils.method04611(var2.field22109.method11676(), var4), field15184
               );
         }
      }
   }

   @Override
   public void method06773() {
      super.method06773();
      this.field15054.method06702();
      this.method09557(false);
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      float var6 = this.method09576();
      float var7 = this.method09560();
      float var8 = this.method09568();
      float var9 = this.method09574();
      if (var5 == 0 && !this.method06785(var1, var3)) {
         this.field15054.method06703(var1, var3, var5);
         this.method09557(this.field15054.method06726());
      }

      if (this.field15058) {
         if (var5 == 0) {
            if (GuiHitTestUtils.method05609(var1, var3, this.field15060, this.field15061 + field15185, field15186, field15187)) {
               this.method06783(this.field15062);
            } else if (GuiHitTestUtils.method05609(var1, var3, this.field15060, this.field15061 + field15188, field15189, field15190)) {
               this.method06782(this.field15062);
            }

            this.method06781();
            return;
         }

         if (var5 == 1) {
            this.method06781();
            return;
         }
      }

      if (this.method06785(var1, var3) && var5 == 0) {
         this.method06771();
      } else {
         var var10 = ThemeManager.INSTANCE.method09636();
         float var11 = var6 + field15191;
         float var12 = var7 + var9 - field15192;

         for (int var13 = 0; var13 < var10.size() && var13 < 22; var13++) {
            ThemeSettings var14 = (ThemeSettings)var10.get(var13);
            float var15 = var11 + field15193 * (var13 % 11) + field15194;
            float var16 = var12 + (var13 >= 11 ? field15195 : 0.0F);
            if (GuiHitTestUtils.method05609(var1, var3, var15 - field15196, var16 - field15197, field15198, field15199)) {
               if (var5 == 0) {
                  ThemeManager.INSTANCE.method09612(var14);
                  this.field15055 = 0.0F;
                  this.method06784();
               } else if (var5 == 1 && !ThemeManager.INSTANCE.method09614(var14)) {
                  this.field15058 = true;
                  this.field15059 = false;
                  this.field15063.method06157(0.0);
                  this.field15060 = var15 + 2.0F;
                  this.field15061 = var16 - field15200 - 1.0F;
                  this.field15062 = var13;
               }

               return;
            }
         }

         float var17 = var7 + field15201;
         float var18 = var7 + var9 - field15202;
         if (!ThemeManager.INSTANCE.method09614(ThemeManager.INSTANCE.method09611()) && var3 >= var17 && var3 <= var18) {
            for (ThemeColorComponent var20 : this.field15051) {
               if (var20.method09782() + var20.method09785() > var17 && var20.method09782() < var18) {
                  var20.method00040(var1, var3, var5);
               }
            }
         }
      }
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (GuiHitTestUtils.method05609(var1, var3, this.method09576(), this.method09560(), this.method09568(), this.method09574())) {
         float var7 = this.method09574() - field15210;
         if (!(this.field15056 <= var7)) {
            this.field15055 = Mth.clamp((float)(this.field15055 + var5 * field15211), -this.field15056 + var7, 0.0F);
         }
      }
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      this.field15054.method06733(var1);
      this.method09557(this.field15054.method06726());
   }

   private void method06775(GuiGraphics var1, ThemeSettings var2, float var3) {
      float var4 = this.method09576() + field15088;
      float var5 = this.method09560() + field15089;
      float var6 = field15090;
      float var7 = field15091;
      float var8 = 0.0F;
      if (this.field15057 != 0L) {
         float var9 = (float)(System.currentTimeMillis() - this.field15057) / field15092;
         if (var9 >= 1.0F) {
            this.field15057 = 0L;
         } else {
            var8 = 1.0F - Math.abs(2.0F * var9 - 1.0F);
         }
      }

      int var14 = ColorUtils.method04631(var2.field22116.method11676(), var2.field22115.method11676(), var8);
      RoundedRectRenderer.method01272(var1, var4, var5, var6, var7, 2.0F, 1.0F, ColorUtils.method04611(var14, var3));
      GuiShapeRenderer.method09703(var1, var4, var5, var6, var7, field15093, field15094, ColorUtils.method04611(var2.field22117.method11676(), var3));
      FontRenderer var10 = Fonts.field00111;
      float var11 = field15095;
      float var12 = var10.method09486(field15096, var11);
      int var13 = ColorUtils.method04631(var2.field22110.method11676(), var2.field22109.method11676(), var8);
      var10.method09480(
         var1,
         field15097,
         var4 + (var6 - var12) / 2.0F,
         var5 + var7 / 2.0F - var10.method09485(var11) / 2.0F,
         ColorUtils.method04611(var13, var3),
         var11
      );
   }

   public ThemeEditorWindow() {
      super(field15064);
      this.field15054 = new TextInputWidget().method06678(Fonts.field00111, field15065);
      this.field15062 = -1;
      this.field15063 = new SmoothAnimation();
      this.field15054.method06717(field15066);
      this.field15054.method06669(50);
      this.field15054.method06734(field15067);
      this.field15054.method06689(this::method06778);
      this.field15054.method06705(this::method06778);
      this.method06784();
      this.method08971(field15068);
      this.method09561(field15069);
   }

   private void method06776(GuiGraphics var1, ThemeSettings var2, ThemeSettings var3, float var4, float var5, float var6) {
      FontRenderer var7 = Fonts.field00111;
      float var8 = field15142;
      String var9 = var3.method09815();
      String var10 = "Автор: " + (ThemeManager.INSTANCE.method09614(var3) ? field15143 : var3.method09817());
      float var11 = var7.method09486(var9, var8);
      float var12 = var7.method09486(var10, var8);
      float var13 = Math.max(var11, var12);
      float var14 = var4 - field15144 + 2.0F;
      float var15 = var5 - field15145 - field15146;
      GuiClipStack.method00341(var1, var14 - 2.0F, var15 - field15147, var13 + field15148, field15149, field15050.radius2(), 1.0F, field15150, var6);
      RoundedRectRenderer.method01272(
         var1,
         var14 - 2.0F,
         var15 - field15151,
         var13 + field15152,
         field15153,
         2.0F,
         1.0F,
         ColorUtils.method04611(var2.field22126.method11676(), var6)
      );
      int var16 = ColorUtils.method04611(var2.field22109.method11676(), var6);
      var15 -= 2.0F;
      var7.method09480(var1, var9, var14, var15 - field15154, var16, var8);
      var7.method09480(var1, var10, var14, var15 + field15155, var16, var8);
   }

   private void method06777(ThemeSettings var1, ThemeSettings var2) {
      var var3 = var1.method03026();
      var var4 = var2.method03026();
      int var5 = Math.min(var3.size(), var4.size());

      for (int var6 = 0; var6 < var5; var6++) {
         if (var3.get(var6) instanceof ColorSetting var7 && var4.get(var6) instanceof ColorSetting var8) {
            var8.method11672(var7.method03022());
         }
      }
   }

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      ThemeSettings var5 = ThemeManager.INSTANCE.method09611();
      float var6 = this.method09573().method06173();
      float var7 = this.method09576();
      float var8 = this.method09560();
      float var9 = this.method09568();
      float var10 = this.method09574();
      this.field15053.method06162();
      this.field15053.method06168(this.field15055, field15070, Easings.field19400, true);
      float var11 = this.field15053.method06173();
      float var12 = var10 - field15071;
      if (this.field15056 > var12) {
         this.field15055 = Mth.clamp(this.field15055, -this.field15056 + var12, 0.0F);
         var11 = Mth.clamp(var11, -this.field15056 + var12, 0.0F);
      } else {
         var11 = 0.0F;
         this.field15055 = 0.0F;
      }

      GuiRenderBatch.method05183();
      GuiClipStack.method00341(var1, var7, var8, var9, var10, field15050.radius1(), 1.0F, field15072, var6);
      RoundedRectRenderer.method01272(var1, var7, var8, var9, var10, field15073, 1.0F, ColorUtils.method04611(var5.field22122.method11676(), var6));
      GuiShapeRenderer.method09703(var1, var7, var8, var9, var10, field15074, 1.0F, ColorUtils.method04611(var5.field22117.method11676(), var6));
      FontRenderer var13 = Fonts.field00111;
      float var14 = var13.method09486(field15075, field15076);
      float var15 = var13.method09485(field15077);
      float var16 = var7 + (var9 - var14) / 2.0F;
      float var17 = var8 - var15 / 2.0F + field15078;
      var13.method09480(var1, field15079, var16, var17, ColorUtils.method04611(var5.field22108.method11676(), var6), field15080);
      this.method06779(var1, var2, var6, var5);
      this.method06775(var1, var5, var6);
      this.method06787(var1, var2, var3, var5, var6, var11, var12);
      this.method06780(var1, var2, var3, var5, var6);
      this.method06772(var1, var5, var6);
   }

   private void method06778() {
      this.field15054.method06722();
      this.method09557(false);
   }

   private void method06779(GuiGraphics var1, int var2, float var3, ThemeSettings var4) {
      float var5 = this.method09576() + field15081;
      float var6 = this.method09560() + field15082;
      float var7 = field15083;
      float var8 = field15084;
      RoundedRectRenderer.method01272(var1, var5, var6, var7, var8, field15085, 1.0F, ColorUtils.method04611(var4.field22116.method11676(), var3));
      GuiShapeRenderer.method09703(var1, var5, var6, var7, var8, field15086, field15087, ColorUtils.method04611(var4.field22117.method11676(), var3));
      this.field15054
         .method06700(var5, var6, var7, var8)
         .method06725(
            var1,
            var2,
            ColorUtils.method04611(var4.field22109.method11676(), var3),
            ColorUtils.method04611(var4.field22110.method11676(), var3),
            TextInputWidget.method06677(var3)
         );
   }

   private void method06780(GuiGraphics var1, int var2, int var3, ThemeSettings var4, float var5) {
      var var6 = ThemeManager.INSTANCE.method09636();
      ThemeSettings var7 = ThemeManager.INSTANCE.method09611();
      float var8 = this.method09576() + field15121;
      float var9 = this.method09560() + this.method09574() - field15122;
      ThemeSettings var10 = null;
      float var11 = 0.0F;
      float var12 = 0.0F;
      float var13 = 0.0F;

      for (int var14 = 0; var14 < var6.size() && var14 < 22; var14++) {
         ThemeSettings var15 = (ThemeSettings)var6.get(var14);
         float var16 = var8 + field15123 * (var14 % 11) + field15124;
         float var17 = var9 + 2.0F + (var14 >= 11 ? field15125 : 0.0F);
         boolean var18 = GuiHitTestUtils.method05624(var2, var3, var16 - field15126, var17 - field15127, field15128, field15129);
         RoundedRectRenderer.method01272(
            var1,
            var16 - field15130,
            var17 - field15131,
            field15132,
            field15133,
            field15134,
            1.0F,
            ColorUtils.method04611(var15.field22125.method11676(), var5)
         );
         if (var15 == var7) {
            RoundedRectRenderer.method01272(
               var1,
               var16 - field15135,
               var17 - field15136,
               field15137,
               field15138,
               field15139,
               1.0F,
               ColorUtils.method04611(ColorUtils.method04604(0, 0, 0), var5)
            );
         }

         SmoothAnimation var19 = this.field15052.computeIfAbsent(var15.method09815(), var0 -> new SmoothAnimation());
         var19.method06162();
         var19.method06168(var18 ? 1.0 : 0.0, field15140, Easings.field19400, true);
         float var20 = var19.method06173() * var5;
         if (var20 > var13) {
            var13 = var20;
            var10 = var15;
            var11 = var16;
            var12 = var17;
         }
      }

      if (var10 != null && var13 > field15141) {
         GuiRenderBatch.method05183();
         this.method06776(var1, var4, var10, var11, var12, var13);
      }
   }

   private void method06781() {
      this.field15059 = true;
   }

   @Override
   public boolean method01686() {
      return false;
   }

   @Override
   public boolean method01682() {
      return true;
   }

   @Override
   public void method01898(char var1, int var2) {
      this.field15054.method06730(var1);
   }

   private void method06782(int var1) {
      var var2 = ThemeManager.INSTANCE.method09636();
      if (var1 >= 0 && var1 < var2.size()) {
         ThemeSettings var3 = (ThemeSettings)var2.get(var1);
         ThemeSettings var4 = ThemeManager.INSTANCE.method09615();
         ThemeManager.INSTANCE.method09616(var4, var3.method09815() + " копия");
         this.method06777(var3, var4);
         this.method06784();
         CustomResourceManager.INSTANCE.method02465(field15208);
      }
   }

   private void method06783(int var1) {
      var var2 = ThemeManager.INSTANCE.method09636();
      if (var1 >= 0 && var1 < var2.size()) {
         ThemeSettings var3 = (ThemeSettings)var2.get(var1);
         if (!ThemeManager.INSTANCE.method09614(var3)) {
            boolean var4 = ThemeManager.INSTANCE.method09611() == var3;
            ThemeManager.INSTANCE.method09617(var3);
            if (var4 && !ThemeManager.INSTANCE.method09636().isEmpty()) {
               ThemeManager.INSTANCE.method09612(ThemeManager.INSTANCE.method09636().getFirst());
            }

            this.field15055 = 0.0F;
            this.method06784();
            CustomResourceManager.INSTANCE.method02465(field15209);
         }
      }
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      super.method01689(var1, var3, var5);
      this.field15054.method06673(var1, var3, var5);
   }

   private void method06784() {
      this.field15051.clear();

      for (Setting var2 : ThemeManager.INSTANCE.method09611().method03026()) {
         if (var2 instanceof ColorSetting var3) {
            this.field15051.add(new ThemeColorComponent(var3, this));
         }
      }
   }

   private boolean method06785(double var1, double var3) {
      return GuiHitTestUtils.method05609(var1, var3, this.method09576() + field15203, this.method09560() + field15204, field15205, field15206);
   }

   @Override
   public boolean method06786() {
      return this.field15058;
   }

   private void method06787(GuiGraphics var1, int var2, int var3, ThemeSettings var4, float var5, float var6, float var7) {
      float var8 = this.method09576();
      float var9 = this.method09560();
      float var10 = this.method09568();
      float var11 = this.method09574();
      float var12 = var9 + field15098;
      float var13 = var9 + field15099;
      float var14 = var13 + var11 - field15100;

      for (ThemeColorComponent var16 : this.field15051) {
         var16.method09789(var8 + field15101);
         var16.method09788(var12 + var6);
         var16.method09781(var10 - field15102);
         var16.method09786(field15103);
         var12 += field15104;
      }

      this.field15056 = var12 - (var9 + field15105) - field15106;
      var1.enableScissor((int)var8, (int)(var9 + field15107), (int)(var8 + var10), (int)(var9 + field15108 + var11 - field15109));

      for (ThemeColorComponent var21 : this.field15051) {
         float var17 = var21.method09782() - field15110;
         float var18 = var17 + var21.method09785();
         if (!(var18 <= var13) && !(var17 >= var14)) {
            RoundedRectRenderer.method01272(
               var1,
               var21.method09780() + field15111,
               var21.method09782() - field15112,
               var21.method09784() - field15113,
               var21.method09785(),
               field15114,
               1.0F,
               ColorUtils.method04611(var4.field22120.method11676(), var5)
            );
            var21.method09783(var5);
            var21.method00042(var1, var2, var3, var5);
         }
      }

      var1.disableScissor();
      if (this.field15056 > var7) {
         float var20 = Math.max(field15115, var7 / this.field15056 * var11 - field15116);
         float var22 = -var6 / (this.field15056 - var7) * (var11 - field15117 - var20);
         RoundedRectRenderer.method01272(
            var1,
            var8 + var10 - field15118,
            var9 + field15119 + var22,
            2.0F,
            var20 - field15120,
            1.0F,
            1.0F,
            ColorUtils.method04611(var4.field22124.method11676(), var5)
         );
      }
   }
}
