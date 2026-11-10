// Original binary: sg/ec/Iv0hEL3GTVbSbLOM
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ModuleCategoryColumn extends GuiComponent {
   private final ClickGuiScreen field08791;
   private final String field08792;
   private final ModuleCategory field08793;
   private final List<ModuleSettingsComponent> field08794 = new ArrayList<>();
   private final List<String> field08795 = new ArrayList<>();
   private final SmoothAnimation field08796 = new SmoothAnimation();
   private String field08797 = "";
   private List<ModuleSettingsComponent> field08798 = List.of();
   private final SmoothAnimation field08799 = new SmoothAnimation();
   private static final double field08800 = 0.15F;
   private static final double field08801 = 0.15F;
   private static final float field08802 = 6.5F;
   private static final float field08803 = 1.25F;
   private static final float field08804 = 7.5F;
   private static final float field08805 = 0.5F;
   private static final float field08806 = 0.025F;
   private static final float field08807 = 0.2F;
   private static final float field08808 = 5.0F;
   private static final float field08809 = 0.2F;
   private static final float field08810 = 6.5F;
   private static final float field08811 = 1.25F;
   private static final float field08812 = 0.2F;
   private static final float field08813 = 0.001F;
   private static final float field08814 = 5.0F;
   private static final float field08815 = 6.5F;
   private static final float field08816 = 1.25F;
   private static final float field08817 = 6.5F;
   private static final float field08818 = 1.25F;
   private static final float field08819 = 6.5F;
   private static final float field08820 = 1.25F;

   public String method03945() {
      return this.field08797;
   }

   @Override
   public void method03946(char var1, int var2) {
      for (ModuleSettingsComponent var4 : this.field08794) {
         var4.method03946(var1, var2);
      }
   }

   private List<ModuleSettingsComponent> method03947() {
      return this.method03955(this.field08791.method09960());
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
   }

   public void method03948(GuiGraphicsExtractor var1, float var2) {
      this.method09783(var2);
      FontRenderer var3 = Fonts.field00109;
      float var4 = field08802;
      float var5 = var3.method09485(var4) + field08803;
      RoundedRectRenderer.method01272(
         var1,
         this.method09780(),
         this.method09782() + var5,
         this.method09784(),
         this.method09785() - var5,
         GuiSize.method04763(field08804).method04764(field08805).method04761(),
         1.0F,
         ColorUtils.method04605(
            ColorUtils.method04583(ThemeManager.INSTANCE.method09611().field22119.method11676(), ColorUtils.field10170, field08806),
            var2 * field08807 * this.method09790()
         )
      );
      GuiShapeRenderer.method09703(
         var1,
         this.method09780(),
         this.method09782() + var5,
         this.method09784(),
         this.method09785() - var5,
         field08808,
         1.0F,
         ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), field08809 * this.method09790())
      );
   }

   public List<ModuleSettingsComponent> method03949() {
      return this.field08798;
   }

   public List<ModuleSettingsComponent> method03950() {
      return this.field08794;
   }

   public ClickGuiScreen method03951() {
      return this.field08791;
   }

   public boolean method03952(String var1) {
      return !this.method03955(var1).isEmpty();
   }

   @Override
   public void method00250(int var1, int var2, int var3) {
      for (ModuleSettingsComponent var6 : this.method03947()) {
         var6.method00250(var1, var2, var3);
      }
   }

   public void method03953() {
      this.field08799.method06166(0.0, field08801);
   }

   public String method03954() {
      return this.field08792;
   }

   @Override
   public void method02632(double var1, double var3, int var5) {
      for (ModuleSettingsComponent var8 : this.method03947()) {
         var8.method02632(var1, var3, var5);
      }
   }

   private List<ModuleSettingsComponent> method03955(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1.equals(this.field08797)) {
            return this.field08798;
         }

         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < this.field08794.size(); var3++) {
            if (this.field08795.get(var3).contains(var1)) {
               var2.add(this.field08794.get(var3));
            }
         }

         this.field08797 = var1;
         this.field08798 = var2;
         return var2;
      } else {
         return this.field08794;
      }
   }

   public List<String> method03956() {
      return this.field08795;
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      this.method09786(this.method03962(this.field08791.method09960()));
      this.method03948(var1, var4);
      this.method03959(var1, var2, var3, var4);
   }

   public void method03957() {
      this.field08799.method06166(1.0, field08800);
   }

   public ModuleCategoryColumn(ClickGuiScreen var1, ModuleSubCategory var2, ModuleCategory var3, List<ToggleableModule> var4) {
      this.field08791 = var1;
      this.field08792 = var2.method11714();
      this.field08793 = var3;

      for (ToggleableModule var6 : var4) {
         ModuleSettingsComponent var7 = new ModuleSettingsComponent(var1, var6);
         this.field08794.add(var7);
         this.field08795.add(TextRenderUtils.method00672(var6.method03925()));
      }
   }

   public boolean method03958(double var1, double var3, double var5) {
      var var7 = this.method03947();
      FontRenderer var8 = Fonts.field00109;
      float var9 = field08819;
      float var10 = var8.method09485(var9) + field08820;

      for (int var11 = 0; var11 < var7.size(); var11++) {
         ModuleSettingsComponent var12 = (ModuleSettingsComponent)var7.get(var11);
         float var13 = this.method09780();
         float var14 = this.method09782() + var10 - (var11 == 0 ? 0 : 1);
         float var15 = this.method09784();
         var12.method09781(var15);
         float var16 = var12.method06621();
         if (GuiHitTestUtils.method05609(var1, var3, var13, var14, var15, var16) && var12.method06617(var1, var3, var5)) {
            return true;
         }

         var10 += var16;
      }

      return false;
   }

   public void method03959(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      this.method09783(var4);
      FontRenderer var5 = Fonts.field00109;
      float var6 = field08810;
      var var7 = this.method03947();
      float var8 = var5.method09485(var6) + field08811;
      float var9 = var8;

      for (int var10 = 0; var10 < var7.size(); var10++) {
         ModuleSettingsComponent var11 = (ModuleSettingsComponent)var7.get(var10);
         var11.method09781(this.method09784());
         float var12 = var11.method06621();
         float var13 = var11.method06603().method06173();
         var11.method09789(this.method09780());
         var11.method09788(this.method09782() + var9 - (var10 == 0 ? 0 : 1));
         var11.method09786(var12);
         var11.method09783(this.method09790() * var4);
         var11.method00042(var1, var2, var3, var4);
         if (var10 != var7.size() - 1) {
            float var14 = GuiHitTestUtils.method05621(1.0F - var13) * field08812 * this.method09790();
            if (var14 <= field08813) {
               var9 += var12;
               continue;
            }

            RoundedRectRenderer.method01272(
               var1,
               var11.method09780() + 1.0F,
               var11.method09782() + var12 - (var10 == 0 ? 1 : 0),
               var11.method09784() - 2.0F,
               1.0F,
               0.0F,
               0.0F,
               ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), var14)
            );
         }

         var9 += var12;
      }

      var5.method09480(
         var1,
         FontFallbackManager.method07179(
            this.field08792.toUpperCase(), ThemeManager.INSTANCE.method09611().method09800(), ThemeManager.INSTANCE.method09611().method09809()
         ),
         this.method09780() + field08814,
         this.method09782(),
         ColorUtils.method04611(-1, this.method09790()),
         var6
      );
      this.method09786(var9);
   }

   public SmoothAnimation method03960() {
      return this.field08799;
   }

   public SmoothAnimation method03961() {
      return this.field08796;
   }

   public float method03962(String var1) {
      FontRenderer var2 = Fonts.field00109;
      float var3 = field08815;
      var var4 = this.method03955(var1);
      float var5 = var2.method09485(var3) + field08816;
      float var6 = 0.0F;

      for (ModuleSettingsComponent var8 : var4) {
         var8.method09781(this.method09784());
         var6 += var8.method06621();
      }

      return var5 + var6;
   }

   public ModuleCategory method03963() {
      return this.field08793;
   }

   public boolean method03964(double var1, double var3, int var5) {
      var var6 = this.method03947();
      FontRenderer var7 = Fonts.field00109;
      float var8 = field08817;
      float var9 = var7.method09485(var8) + field08818;

      for (int var10 = 0; var10 < var6.size(); var10++) {
         ModuleSettingsComponent var11 = (ModuleSettingsComponent)var6.get(var10);
         float var12 = this.method09780();
         float var13 = this.method09782() + var9 - (var10 == 0 ? 0 : 1);
         float var14 = this.method09784();
         var11.method09781(var14);
         float var15 = var11.method06621();
         if (GuiHitTestUtils.method05609(var1, var3, var12, var13, var14, var15) && var11.method06607(var1, var3, var5)) {
            return false;
         }

         var9 += var15;
      }

      return true;
   }
}
