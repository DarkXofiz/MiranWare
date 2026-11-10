// Original binary: sg/ec/Yh1ghn8beJcNBz5v
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class ModuleSettingsComponent extends GuiComponent {
   private static final float field14830 = 18.285715F;
   private static final float field14831 = 0;
   private static final float field14832 = 0;
   private static final float field14833 = 0;
   private static final float field14834 = 0;
   private static final float field14835 = 0;
   private final ClickGuiScreen field14836;
   private final ToggleableModule field14837;
   private final SmoothAnimation field14838 = new SmoothAnimation();
   private final SmoothAnimation field14839 = new SmoothAnimation();
   private final List<SettingComponent<?>> field14840 = new ArrayList<>();
   private final FloatingWindow field14841;
   private boolean field14842;
   private boolean field14843;
   private int field14844;
   private boolean field14845;
   private float field14846;
   private final GuiBounds field14847;
   private final BindingStateRenderer field14848;
   private final GuiBounds field14849;
   private final BindingStateRenderer field14850;
   private static final String field14851 = "modules.settings";
   private static final float field14852 = 18.285715F;
   private static final double field14853 = 0.05F;
   private static final float field14854 = 7.5F;
   private static final float field14855 = 9.142858F;
   private static final float field14856 = 15.333333F;
   private static final float field14857 = 9.333333F;
   private static final float field14858 = 5.0F;
   private static final float field14859 = 7.0F;
   private static final float field14860 = 7.0F;
   private static final float field14861 = 7.5F;
   private static final float field14862 = 1.5F;
   private static final float field14863 = 5.0F;
   private static final float field14864 = 0.5F;
   private static final String field14865 = "Bind";
   private static final String field14866 = "module.binding";
   private static final float field14867 = 0.001F;
   private static final float field14868 = 0.01F;
   private static final float field14869 = 0.001F;
   private static final float field14870 = 0.01F;
   private static final float field14871 = 0.001F;
   private static final float field14872 = 0.001F;
   private static final float field14873 = 0.01F;
   private static final float field14874 = 0.001F;
   private static final float field14875 = 18.285715F;
   private static final float field14876 = 0.01F;
   private static final double field14877 = 0.25;
   private static final float field14878 = 18.285715F;
   private static final float field14879 = 13.0F;
   private static final float field14880 = 0.01F;
   private static final float field14881 = 2.5F;
   private static final float field14882 = 2.5F;
   private static final float field14883 = 0.001F;
   private static final float field14884 = 0.01F;
   private static final float field14885 = 18.285715F;
   private static final float field14886 = 0.5F;
   private static final float field14887 = 0.2F;
   private static final float field14888 = 2.5F;
   private static final float field14889 = 0.3F;
   private static final float field14890 = 0.01F;
   private static final float field14891 = 6.5F;
   private static final float field14892 = 13.0F;
   private static final float field14893 = 2.5F;
   private static final float field14894 = 2.5F;
   private static final float field14895 = 18.285715F;
   private static final float field14896 = 18.285715F;
   private static final float field14897 = 18.285715F;
   private static final float field14898 = 18.285715F;
   private static final String field14899 = "5";
   private static final float field14900 = 0.1F;

   private float method06599() {
      if (this.field14840.isEmpty()) {
         return 0.0F;
      }

      float var1 = 0.0F;
      float sx = Math.max(0.0F, this.method09784() - field14879);

      for (SettingComponent sxx : this.field14840) {
         if (sxx.method10977().method03019() || !(sxx.method10979().method06173() < field14880)) {
            sxx.method09781(sx);
            sxx.method03443();
            var1 += sxx.method09785() * GuiHitTestUtils.method05621(sxx.method10979().method06173());
         }
      }

      return var1 > 0.0F ? var1 + field14881 + field14882 : 0.0F;
   }

   public int method06600() {
      return this.field14844;
   }

   private void method06601() {
      int var1 = this.field14837.method03932().size();
      if (!this.field14843 || var1 != this.field14844) {
         this.field14840.clear();
         this.field14840.addAll(SettingsWindow.method04679(this.field14837.method03932(), this.field14841));
         this.field14844 = var1;
         this.field14843 = true;
         if (this.field14840.isEmpty()) {
            this.field14842 = false;
         }
      }
   }

   public GuiBounds method06602() {
      return this.field14847;
   }

   @Override
   public void method00250(int var1, int var2, int var3) {
      if (this.field14842 || !(this.field14839.method06173() <= field14871)) {
         for (SettingComponent var5 : this.field14840) {
            var5.method00250(var1, var2, var3);
         }
      }
   }

   public SmoothAnimation method06603() {
      return this.field14839;
   }

   private boolean method06604() {
      if (this.field14843 && !this.field14840.isEmpty()) {
         return true;
      }

      for (Setting var2 : this.field14837.method03932()) {
         if (SettingsWindow.method04684(var2)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void method02632(double var1, double var3, int var5) {
      if (!(this.field14839.method06173() <= field14869)) {
         for (SettingComponent var7 : this.field14840) {
            if (var7.method10977().method03019() || !(var7.method10979().method06173() < field14870)) {
               var7.method02632(var1, var3, var5);
            }
         }
      }
   }

   public BindingStateRenderer method06605() {
      return this.field14848;
   }

   public boolean method06607(double var1, double var3, int var5) {
      if (this.field14847.method02807() && this.field14847.method02799(var1, var3)) {
         this.field14837.method00382();
         return true;
      }

      if (this.method06615(var1, var3) && var5 == 2 && this.field14837.method03936()) {
         KeyBindSetting var8 = new KeyBindSetting(field14865).method03237();
         var8.method03014(this.field14837.method03930());
         this.field14836.method09983().method09652(new BindingSettingsWindow(field14866, var8, this.field14836::method10032), (float)var1, (float)var3);
         return false;
      }

      if (this.field14849.method02807() && this.field14849.method02799(var1, var3)) {
         if (var5 == 0) {
            this.method06601();
            if (!this.field14840.isEmpty()) {
               this.field14842 = !this.field14842;
            }
         }

         return true;
      } else if (this.field14839.method06173() > field14867 && this.method06608(var1, var3)) {
         for (SettingComponent var7 : this.field14840) {
            if ((var7.method10977().method03019() || !(var7.method10979().method06173() < field14868)) && !var7.method00251(var1, var3, var5)) {
               var7.method00040(var1, var3, var5);
            }
         }

         return true;
      } else {
         return true;
      }
   }

   private boolean method06608(double var1, double var3) {
      return GuiHitTestUtils.method05624(
         (int)var1, (int)var3, this.method09780(), this.method09782() + field14897, this.method09784(), Math.max(0.0F, this.method09785() - field14898)
      );
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
   }

   public ModuleSettingsComponent(ClickGuiScreen var1, ToggleableModule var2) {
      this.field14841 = new FloatingWindow(field14851);
      this.field14844 = -1;
      this.field14847 = new GuiBounds();
      this.field14848 = (var1x, var2x) -> ToggleSwitchRenderer.method03323(var1x, var2x, this.field14838.method06173(), this.method09790());
      this.field14849 = new GuiBounds();
      this.field14850 = (var1x, var2x) -> Fonts.field00107
         .method09490(
            var1x,
            field14899,
            var2x.method02809(),
            var2x.method02808(),
            ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22109.method11679(), this.method09790()),
            var2x.method02802(),
            field14900
         );
      this.field14836 = var1;
      this.field14837 = var2;
      this.field14847.method02800(var2.method03928());
      this.field14841.method09577(var1.method09983());
      this.field14849.method02800(!var2.method03932().isEmpty());
      this.method09786(field14852);
   }

   public ToggleableModule method06609() {
      return this.field14837;
   }

   public boolean method06610() {
      return this.field14845;
   }

   private void method06611() {
      if (!this.field14842 && this.field14839.method06173() <= field14874) {
         this.field14846 = 0.0F;
         this.method09786(field14875);
      } else {
         this.method06601();
         this.field14846 = this.method06599();
         if (this.field14842 && this.field14846 <= field14876) {
            this.field14842 = false;
         }

         if (this.field14842 != this.field14845) {
            this.field14839.method06158(this.field14842 ? 1.0 : 0.0, field14877, Easings.field19400);
            this.field14845 = this.field14842;
         }

         this.field14839.method06162();
         this.method09786(field14878 + this.field14846 * this.field14839.method06173());
      }
   }

   private void method06612(GuiGraphics var1, int var2, int var3, float var4) {
      float var5 = GuiHitTestUtils.method05621(this.field14839.method06173());
      float var6 = var5;
      if (!(var5 <= field14883) && !(this.field14846 <= field14884)) {
         float var7 = this.field14846 * var5;
         float var8 = this.method09782() + field14885;
         RoundedRectRenderer.method01272(
            var1,
            this.method09780() + 1.0F,
            var8 - field14886,
            this.method09784() - 2.0F,
            1.0F,
            0.0F,
            0.0F,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), field14887 * this.method09790() * var6)
         );
         var1.enableScissor((int)this.method09780(), (int)var8, (int)(this.method09780() + this.method09784()), (int)(var8 + var7));
         float var9 = 0.0F;
         float var10 = var8 + field14888;
         float var11 = (1.0F - var5) * this.field14846 * field14889;

         for (SettingComponent var13 : this.field14840) {
            if (var13.method10977().method03019() || !(var13.method10979().method06173() < field14890)) {
               float var14 = GuiHitTestUtils.method05621(var13.method10979().method06173());
               var13.method09789(this.method09780() + field14891);
               var13.method09781(this.method09784() - field14892);
               var13.method03443();
               float var15 = var10 + var9;
               var13.method09788(var15 - var11);
               var13.method09783(this.method09790() * var6 * var14);
               var13.method00042(var1, var2, var3, var4);
               var9 += var13.method09785() * var14;
            }
         }

         var1.disableScissor();
         this.field14846 = var9 > 0.0F ? var9 + field14893 + field14894 : 0.0F;
         this.method09786(field14895 + this.field14846 * this.field14839.method06173());
      }
   }

   public boolean method06613() {
      return this.field14843;
   }

   public FloatingWindow method06614() {
      return this.field14841;
   }

   private boolean method06615(double var1, double var3) {
      return GuiHitTestUtils.method05624((int)var1, (int)var3, this.method09780(), this.method09782(), this.method09784(), field14896);
   }

   @Override
   public void method00042(GuiGraphics var1, int var2, int var3, float var4) {
      this.field14849.method02800(this.method06604());
      this.method06611();
      this.field14838.method06162();
      this.field14838.method06168(this.field14837.method03937() ? 1.0 : 0.0, field14853, Easings.field19394, false);
      FontRenderer var5 = Fonts.field00111;
      float var6 = field14854;
      float var7 = this.method09782() + field14855;
      this.field14847.method02803(field14856);
      this.field14847.method02798(field14857);
      this.field14847.method02801(this.method09780() + this.method09784() - this.field14847.method02804() - field14858);
      this.field14847.method02806(var7 - this.field14847.method02802() / 2.0F);
      if (this.field14847.method02807()) {
         this.field14848.method11276(var1, this.field14847);
      }

      this.field14849.method02803(field14859);
      this.field14849.method02798(field14860);
      this.field14849
         .method02801(
            this.method09780()
               + this.method09784()
               - (this.field14847.method02807() ? this.field14847.method02804() : 0.0F)
               - this.field14849.method02804()
               - field14861
         );
      this.field14849.method02806(var7 - this.field14849.method02802() / 2.0F + field14862);
      if (this.field14849.method02807()) {
         this.field14850.method11276(var1, this.field14849);
      }

      this.method06612(var1, var2, var3, var4);
      var5.method09480(
         var1,
         this.field14837.method03925(),
         this.method09780() + field14863,
         var7 - var5.method09485(var6) / 2.0F - field14864,
         ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22109.method11676(), this.method09790()),
         var6
      );
   }

   public boolean method06617(double var1, double var3, double var5) {
      if (!(this.field14839.method06173() <= field14872) && this.method06608(var1, var3)) {
         for (SettingComponent var8 : this.field14840) {
            if ((var8.method10977().method03019() || !(var8.method10979().method06173() < field14873))
               && var8 instanceof NumberSettingComponent var9
               && var9.method04527(var1, var3, var5)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public boolean method06618() {
      return this.field14842;
   }

   public BindingStateRenderer method06619() {
      return this.field14850;
   }

   public GuiBounds method06620() {
      return this.field14849;
   }

   public float method06621() {
      this.method06611();
      return this.method09785();
   }

   @Override
   public void method03946(char var1, int var2) {
      for (SettingComponent var4 : this.field14840) {
         var4.method03946(var1, var2);
      }
   }

   public SmoothAnimation method06622() {
      return this.field14838;
   }

   public ClickGuiScreen method06623() {
      return this.field14836;
   }

   public List<SettingComponent<?>> method06624() {
      return this.field14840;
   }

   public float method06625() {
      return this.field14846;
   }
}
