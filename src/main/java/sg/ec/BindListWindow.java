// Original binary: sg/ec/7cLyEm6jUYv7kxup
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class BindListWindow extends FloatingWindow {
   public static final String field04003 = "modules.bindlist";
   public static final float field04004 = 0;
   private static final float field04005 = 0;
   private static final float field04006 = 0;
   private static final float field04007 = 0;
   private static final float field04008 = 0;
   private static final float field04009 = 0;
   private static final float field04010 = 0;
   private static final float field04011 = 0;
   private static final float field04012 = 0;
   private static final float field04013 = 0;
   private static final float field04014 = 0;
   private static final float field04015 = 0;
   private static final float field04016 = 0;
   private static final float field04017 = 0;
   private static final float field04018 = 0;
   private static final float field04019 = 0;
   private static final float field04020 = 0;
   private static final float field04021 = 0;
   private static final float field04022 = 0;
   private static final float field04023 = 0;
   private static final float field04024 = 0;
   private static final float field04025 = GuiSize.method04763(BindListWindow.field04089)
      .method04764(BindListWindow.field04090)
      .method04768();
   private static final int field04026 = 0;
   private static final String field04027 = "field04027";
   private static final String field04028 = "field04028";
   private static final String field04029 = "field04029";
   private static final String field04030 = "field04030";
   private final FontRenderer field04031 = Fonts.field00110;
   private final ScrollController field04032 = new ScrollController();
   private final GuiBounds field04033 = new GuiBounds();
   private final GuiBounds field04034 = new GuiBounds();
   private final List<BindListWindow.Nested50> field04035 = new ArrayList<>();
   private final Map<KeyBinding, SmoothAnimation> field04036 = new HashMap<>();
   private final Map<ToggleSetting, String> field04037 = new HashMap<>();
   private final SmoothAnimation field04038 = new SmoothAnimation();
   private int field04039;
   private KeyBindingCapture field04040;
   private KeyBinding field04041;
   private boolean field04042;
   private float field04043;
   private float field04044;
   private static final String field04045 = "modules.bindlist";
   private static final float field04046 = 145.0F;
   private static final double field04047 = 0.15F;
   private static final float field04048 = 3.0F;
   private static final float field04049 = 0.9F;
   private static final float field04050 = 0.100000024F;
   private static final float field04051 = 16.0F;
   private static final float field04052 = 16.5F;
   private static final float field04053 = 2.5F;
   private static final float field04054 = 16.0F;
   private static final float field04055 = 5.0F;
   private static final float field04056 = 60.0F;
   private static final float field04057 = 185.0F;
   private static final float field04058 = 10.0F;
   private static final float field04059 = 10.0F;
   private static final float field04060 = 5.0F;
   private static final float field04061 = 10.0F;
   private static final float field04062 = 3.0F;
   private static final float field04063 = 16.0F;
   private static final float field04064 = 16.0F;
   private static final float field04065 = 5.0F;
   private static final float field04066 = 5.0F;
   private static final float field04067 = 10.0F;
   private static final float field04068 = 16.5F;
   private static final float field04069 = 16.0F;
   private static final float field04070 = 7.0F;
   private static final float field04071 = 7.0F;
   private static final float field04072 = 7.0F;
   private static final String field04073 = "x";
   private static final int field04074 = -1750963;
   private static final float field04075 = 0.15F;
   private static final float field04076 = 0.5F;
   private static final float field04077 = 2.5F;
   private static final float field04078 = 7.0F;
   private static final float field04079 = 4.0F;
   private static final float field04080 = 7.0F;
   private static final double field04081 = 0.15F;
   private static final String field04082 = "A";
   private static final float field04083 = -1.5F;
   private static final float field04084 = 7.0F;
   private static final float field04085 = 6.5F;
   private static final float field04086 = 7.0F;
   private static final float field04087 = 0.999F;
   private static final float field04088 = 0.999F;
   private static final float field04089 = 10.0F;
   private static final float field04090 = 0.5F;

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method01691();
      this.method09557(this.method09569() && this.field04040 != null);
      this.method01697(var2, var3);
      this.field04038.method06162();
      this.field04038.method06158(this.field04040 != null ? 1.0 : 0.0, field04047, Easings.field19412);
      this.method01694();
      this.method01684();
      float var5 = this.method09573().method06173() * GuiHitTestUtils.method05621(var4);
      GuiRenderBatch.method05183();
      this.method01687(var1, var5);
      WindowFrameRenderer.method03057(var1, this, field04025, var5);
      this.method01695(var1, var5);
      this.method01681(var1, var5);
      var1.pose().popMatrix();
   }

   private void method01681(GuiGraphics var1, float var2) {
      ThemeSettings var3 = ThemeManager.INSTANCE.method09611();
      int var4 = ColorUtils.method04611(
         ColorUtils.method04583(var3.field22121.method11676(), ColorUtils.field10170, field04075), field04076 * var2
      );
      int var5 = ColorUtils.method04611(var3.field22109.method11679(), var2);
      int var6 = ColorUtils.method04611(var3.field22110.method11679(), var2);
      int var7 = ColorUtils.method04611(var3.field22113.method11679(), var2);
      var1.enableScissor(
         (int)this.field04034.method02809(),
         (int)this.field04034.method02808(),
         (int)Math.ceil(this.field04034.method02809() + this.field04034.method02804()),
         (int)Math.ceil(this.field04034.method02808() + this.field04034.method02802())
      );

      for (int var8 = 0; var8 < this.field04039; var8++) {
         BindListWindow.Nested50 var9 = this.field04035.get(var8);
         GuiBounds var10 = var9.field04091;
         RoundedRectRenderer.method01272(var1, var10.method02809(), var10.method02808(), var10.method02804(), var10.method02802(), field04077, 1.0F, var4);
         float var11 = var10.method02808() + (var10.method02802() - this.field04031.method09485(field04078)) / 2.0F;
         this.field04031.method09480(var1, var9.field04095, var10.method02809() + field04079, var11, var5, field04080);
         SmoothAnimation var12 = this.field04036
            .computeIfAbsent(var9.field04097, var0 -> new SmoothAnimation().method06155(var0.method05873() ? 1.0 : 0.0));
         var12.method06162();
         var12.method06158(var9.field04097.method05873() ? 1.0 : 0.0, field04081, Easings.field19412);
         Fonts.field00107
            .method09487(
               var1,
               field04082,
               var9.field04092.method02809() + var9.field04092.method02804() / 2.0F,
               var9.field04092.method02808() + field04083,
               field04084,
               ColorUtils.method04631(var6, var7, var12.method06173())
            );
         float var13 = this.method01690(var9.field04097) ? this.field04038.method06173() : 0.0F;
         KeyLabelRenderer.method02578(
            var1, this.field04031, var9.field04093.method02809(), var9.field04093.method02808(), var9.field04096, field04085, var13, var2
         );
         this.method01688(var1, var9.field04094, field04086, var2);
      }

      var1.disableScissor();
   }

   @Override
   public boolean method01682() {
      return true;
   }

   private boolean method01683(double var1, double var3) {
      return GuiHitTestUtils.method05609(var1, var3, this.method09576(), this.method09560(), this.method09568(), field04051)
         && !this.field04033.method02799(var1, var3);
   }

   private void method01684() {
      float var1 = this.field04039 * field04052 - (this.field04039 > 0 ? field04053 : 0.0F);
      this.method09561(Mth.clamp(field04054 + var1 + field04055, field04056, field04057));
      this.field04033.method02803(field04058);
      this.field04033.method02798(field04059);
      this.field04033.method02801(this.method09576() + this.method09568() - field04060 - field04061);
      this.field04033.method02806(this.method09560() + field04062);
      this.field04034.method02801(this.method09576());
      this.field04034.method02806(this.method09560() + field04063);
      this.field04034.method02803(this.method09568());
      this.field04034.method02798(this.method09574() - field04064 - field04065);
      this.field04032.method01152(var1 > this.field04034.method02802());
      this.field04032.method01145();
      this.field04032.method01134(var1, this.field04034.method02802());
      float var2 = this.method09576() + field04066;
      float var3 = this.method09568() - field04067;
      float var4 = this.field04034.method02808() + this.field04032.method01136();

      for (int var5 = 0; var5 < this.field04039; var5++) {
         this.field04035.get(var5).method01701(this.field04031, var2, var4, var3, this.method01690(this.field04035.get(var5).field04097));
         var4 += field04068;
      }
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (!(this.method09573().method06173() < field04087)) {
         if (this.field04040 == null || !this.field04040.method06907(var5)) {
            if (var5 == 0) {
               if (this.field04033.method02799(var1, var3)) {
                  this.method09580().method09654(this);
               } else if (this.method01683(var1, var3)) {
                  this.field04042 = true;
                  this.field04043 = (float)var1 - this.method09576();
                  this.field04044 = (float)var3 - this.method09560();
               } else if (this.field04034.method02799(var1, var3)) {
                  for (int var6 = 0; var6 < this.field04039; var6++) {
                     BindListWindow.Nested50 var7 = this.field04035.get(var6);
                     if (var7.field04092.method02799(var1, var3)) {
                        var7.field04097.method05875(!var7.field04097.method05873());
                     } else if (var7.field04093.method02799(var1, var3)) {
                        this.method01696(var7.field04097);
                     } else if (var7.field04094.method02799(var1, var3)) {
                        var7.field04097.method05872(-1);
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (this.field04034.method02799(var1, var3)) {
         this.field04032.method01133(var5);
      }
   }

   @Override
   public boolean method01686() {
      return false;
   }

   private void method01687(GuiGraphics var1, float var2) {
      float var3 = var2 * var2 * (field04048 - 2.0F * var2);
      float var4 = field04049 + field04050 * var3;
      float var5 = this.method09576() + this.method09568() / 2.0F;
      var1.pose().pushMatrix();
      var1.pose().translate(var5, this.method09560());
      var1.pose().scale(1.0F, var4);
      var1.pose().translate(-var5, -this.method09560());
   }

   private void method01688(GuiGraphics var1, GuiBounds var2, float var3, float var4) {
      float var5 = var2.method02808() + (var2.method02802() - this.field04031.method09485(var3)) / 2.0F;
      this.field04031
         .method09473(var1, field04073, var2.method02809() + var2.method02804() / 2.0F, var5, ColorUtils.method04611(field04074, var4), var3);
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      if (var5 == 0) {
         this.field04042 = false;
      }
   }

   private boolean method01690(KeyBinding var1) {
      return this.field04040 != null && this.field04041 == var1;
   }

   private void method01691() {
      if (this.field04040 != null && !this.field04040.method06910()) {
         this.field04040 = null;
      }
   }

   private static String method01692(ToggleSetting var0) {
      return var0.method03011() instanceof ToggleableModule var1 ? var1.method03925() + " · " + var0.method03024() : var0.method03024();
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      if (!(this.method09573().method06173() < field04088) && this.field04040 != null) {
         this.field04040.method06909(var1);
      }
   }

   private BindListWindow.Nested50 method01693() {
      if (this.field04039 == this.field04035.size()) {
         this.field04035.add(new BindListWindow.Nested50());
      }

      return this.field04035.get(this.field04039++);
   }

   private void method01694() {
      this.field04039 = 0;

      for (ToggleableModule var2 : KeyBindingManager.INSTANCE.method11746()) {
         this.method01693().method01700(var2.method03925(), var2.method03930());
      }

      for (ToggleSetting var4 : KeyBindingManager.INSTANCE.method11747()) {
         this.method01693().method01700(this.field04037.computeIfAbsent(var4, BindListWindow::method01692), var4.method05997());
      }
   }

   private void method01695(GuiGraphics var1, float var2) {
      ThemeSettings var3 = ThemeManager.INSTANCE.method09611();
      float var4 = this.method09560() + (field04069 - this.field04031.method09485(field04070)) / 2.0F;
      this.field04031
         .method09473(
            var1,
            this.method09566(),
            this.method09576() + this.method09568() / 2.0F,
            var4,
            ColorUtils.method04611(var3.field22108.method11679(), var2),
            field04071
         );
      this.method01688(var1, this.field04033, field04072, var2);
   }

   private void method01696(KeyBinding var1) {
      this.field04041 = var1;
      this.field04040 = new KeyBindingCapture(var1);
      this.field04040.method06906();
   }

   public BindListWindow() {
      super(field04045);
      this.method08971(field04046);
   }

   private void method01697(int var1, int var2) {
      if (this.field04042) {
         this.method09571(Mth.clamp(var1 - this.field04043, 0.0F, GuiScaleUtils.method06753() - this.method09568()));
         this.method09563(Mth.clamp(var2 - this.field04044, 0.0F, GuiScaleUtils.method06754() - this.method09574()));
      }
   }

   @Override
   public boolean method01698() {
      return true;
   }

   // $VF: Compiled from s
   private static final class Nested50 {
      private final GuiBounds field04091 = new GuiBounds();
      private final GuiBounds field04092 = new GuiBounds();
      private final GuiBounds field04093 = new GuiBounds();
      private final GuiBounds field04094 = new GuiBounds();
      private String field04095;
      private String field04096;
      private KeyBinding field04097;
      private static final String field04098 = "...";
      private static final float field04099 = 14.0F;
      private static final float field04100 = 7.0F;
      private static final float field04101 = 4.0F;
      private static final float field04102 = 10.0F;
      private static final float field04103 = 10.0F;
      private static final float field04104 = 10.0F;
      private static final float field04105 = 6.5F;
      private static final float field04106 = 3.0F;
      private static final float field04107 = 6.5F;
      private static final float field04108 = 13.0F;
      private static final float field04109 = 10.0F;
      private static final float field04110 = 10.0F;

      void method01700(String var1, KeyBinding var2) {
         this.field04095 = var1;
         this.field04097 = var2;
      }

      void method01701(FontRenderer var1, float var2, float var3, float var4, boolean var5) {
         this.field04096 = var5 ? field04098 : KeyboardKey.method00360(this.field04097.method05871());
         this.field04091.method02801(var2);
         this.field04091.method02806(var3);
         this.field04091.method02803(var4);
         this.field04091.method02798(field04099);
         float var6 = var3 + field04100;
         float var7 = var2 + var4 - field04101;
         var7 -= field04102;
         method01702(this.field04094, var7, var6, field04103, field04104);
         float var8 = KeyLabelRenderer.method02576(var1, this.field04096, field04105);
         var7 -= field04106 + var8;
         method01702(this.field04093, var7, var6, var8, KeyLabelRenderer.method02577(var1, field04107));
         var7 -= field04108;
         method01702(this.field04092, var7, var6, field04109, field04110);
      }

      private static void method01702(GuiBounds var0, float var1, float var2, float var3, float var4) {
         var0.method02801(var1);
         var0.method02806(var2 - var4 / 2.0F);
         var0.method02803(var3);
         var0.method02798(var4);
      }
   }
}
