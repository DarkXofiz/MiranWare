// Original binary: sg/ec/xKCj2SiSSUc8FG4j
package sg.ec;

import java.awt.Color;
import java.util.Locale;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class ColorPickerWindow extends FloatingWindow {
   private static final float field25741 = 93.0F;
   private static final float field25742 = 0;
   private static final CornerRadii field25743 = new CornerRadii(ColorPickerWindow.field25896);
   private static Integer field25744;
   private final ColorSetting field25745;
   private final FloatingWindow field25746;
   private boolean field25747;
   private boolean field25748;
   private boolean field25749;
   private boolean field25750;
   private final SmoothAnimation field25751 = new SmoothAnimation();
   private final SmoothAnimation field25752 = new SmoothAnimation();
   private final SmoothAnimation field25753 = new SmoothAnimation();
   private static final String field25754 = "menu.colorpicker";
   private static final float field25755 = 93.0F;
   private static final float field25756 = 90.0F;
   private static final float field25757 = 7.0F;
   private static final float field25758 = 11.0F;
   private static final float field25759 = 76.0F;
   private static final float field25760 = 37.0F;
   private static final float field25761 = 10.0F;
   private static final double field25762 = 0.18F;
   private static final float field25763 = 49.0F;
   private static final float field25764 = 76.0F;
   private static final float field25765 = 37.0F;
   private static final float field25766 = 10.0F;
   private static final double field25767 = 0.18F;
   private static final float field25768 = 87.0F;
   private static final float field25769 = 76.0F;
   private static final float field25770 = 10.0F;
   private static final float field25771 = 10.0F;
   private static final double field25772 = 0.18F;
   private static final float field25773 = 7.0F;
   private static final float field25774 = 93.0F;
   private static final float field25775 = 90.0F;
   private static final float field25776 = 10.0F;
   private static final float field25777 = 7.0F;
   private static final float field25778 = 93.0F;
   private static final float field25779 = 90.0F;
   private static final float field25780 = 4.0F;
   private static final float field25781 = 7.0F;
   private static final float field25782 = 93.0F;
   private static final float field25783 = 90.0F;
   private static final float field25784 = 4.0F;
   private static final float field25785 = 11.0F;
   private static final float field25786 = 4.5F;
   private static final float field25787 = 70.0F;
   private static final float field25788 = 70.0F;
   private static final float field25789 = 3.0F;
   private static final float field25790 = 13.0F;
   private static final float field25791 = 75.0F;
   private static final float field25792 = 11.0F;
   private static final float field25793 = 70.0F;
   private static final float field25794 = 6.0F;
   private static final float field25795 = 68.0F;
   private static final float field25796 = 4.0F;
   private static final float field25797 = 70.0F;
   private static final float field25798 = 4.0F;
   private static final float field25799 = 4.0F;
   private static final float field25800 = 1.5F;
   private static final float field25801 = 0.5F;
   private static final float field25802 = 84.0F;
   private static final float field25803 = 5.0F;
   private static final float field25804 = 4.0F;
   private static final float field25805 = 68.0F;
   private static final float field25806 = 68.0F;
   private static final float field25807 = 6.0F;
   private static final float field25808 = 91.0F;
   private static final float field25809 = 5.0F;
   private static final float field25810 = 4.0F;
   private static final float field25811 = 68.0F;
   private static final float field25812 = 68.0F;
   private static final float field25813 = 6.0F;
   private static final String field25814 = "Копировать";
   private static final float field25815 = 11.0F;
   private static final float field25816 = 76.0F;
   private static final float field25817 = 37.0F;
   private static final String field25818 = "Вставить";
   private static final float field25819 = 49.0F;
   private static final float field25820 = 76.0F;
   private static final float field25821 = 37.0F;
   private static final float field25822 = 87.0F;
   private static final float field25823 = 76.0F;
   private static final float field25824 = 10.0F;
   private static final float field25825 = 10.0F;
   private static final float field25826 = 1.5F;
   private static final String field25827 = "9";
   private static final float field25828 = 87.0F;
   private static final float field25829 = 5.5F;
   private static final float field25830 = 76.0F;
   private static final float field25831 = 5.75F;
   private static final float field25832 = 6.0F;
   private static final float field25833 = 6.0F;
   private static final float field25834 = 10.0F;
   private static final float field25835 = 1.5F;
   private static final float field25836 = 6.0F;
   private static final float field25837 = 5.0F;
   private static final float field25838 = 7.0F;
   private static final float field25839 = 87.0F;
   private static final float field25840 = 76.0F;
   private static final float field25841 = 10.0F;
   private static final float field25842 = 10.0F;
   private static final float field25843 = 11.0F;
   private static final float field25844 = 76.0F;
   private static final float field25845 = 37.0F;
   private static final float field25846 = 10.0F;
   private static final float field25847 = 49.0F;
   private static final float field25848 = 76.0F;
   private static final float field25849 = 37.0F;
   private static final float field25850 = 10.0F;
   private static final float field25851 = 11.0F;
   private static final float field25852 = 4.0F;
   private static final float field25853 = 70.0F;
   private static final float field25854 = 70.0F;
   private static final float field25855 = 84.0F;
   private static final float field25856 = 5.0F;
   private static final float field25857 = 6.0F;
   private static final float field25858 = 68.0F;
   private static final float field25859 = 91.0F;
   private static final float field25860 = 5.0F;
   private static final float field25861 = 6.0F;
   private static final float field25862 = 68.0F;
   private static final String field25863 = "Theme";
   private static final float field25864 = 7.0F;
   private static final float field25865 = 13.0F;
   private static final float field25866 = 7.0F;
   private static final float field25867 = 70.0F;
   private static final float field25868 = 70.0F;
   private static final float field25869 = 70.0F;
   private static final float field25870 = 70.0F;
   private static final float field25871 = 5.0F;
   private static final float field25872 = 68.0F;
   private static final float field25873 = 68.0F;
   private static final float field25874 = 0.99999994F;
   private static final float field25875 = 5.0F;
   private static final float field25876 = 68.0F;
   private static final float field25877 = 68.0F;
   private static final float field25878 = 255.0F;
   private static final String field25879 = "#%02X%02X%02X%02X";
   private static final String field25880 = "Theme";
   private static final String field25881 = "Theme";
   private static final float field25882 = 255.0F;
   private static final float field25883 = 255.0F;
   private static final int field25884 = 16777215;
   private static final String field25885 = "Theme";
   private static final long field25886 = -1L;
   private static final long field25887 = 255L;
   private static final long field25888 = 255L;
   private static final long field25889 = 255L;
   private static final long field25890 = 255L;
   private static final long field25891 = 255L;
   private static final long field25892 = 255L;
   private static final long field25893 = 255L;
   private static final long field25894 = 4294967295L;
   private static final long field25895 = -1L;
   private static final float field25896 = 4.0F;

   private void method11310(double var1, double var3) {
      float var5 = this.method09576() - field25864 + field25865;
      float sx = this.method09560() + field25866;
      float sxx = Mth.clamp((float)var1, var5, var5 + field25867);
      float sxxx = Mth.clamp((float)var3, sx, sx + field25868);
      this.field25745.method11682(Mth.clamp((sxx - var5) / field25869, 0.0F, 1.0F));
      this.field25745.method11668(Mth.clamp(1.0F - (sxxx - sx) / field25870, 0.0F, 1.0F));
      this.method11316();
   }

   private void method11311(double var1) {
      float var3 = this.method09560() + field25871;
      this.field25745.method11667(Mth.clamp((Mth.clamp((float)var1, var3, var3 + field25872) - var3) / field25873, 0.0F, field25874));
      this.method11316();
   }

   @Override
   public void method06773() {
      super.method06773();
      this.method09557(false);
      if (this.field25746 != null) {
         this.field25746.method09565(true);
      }
   }

   @Override
   public void method04220() {
      super.method04220();
      this.method08971(field25755);
      this.method09561(field25756);
   }

   private void method11312() {
      String var1 = mc.keyboardHandler.getClipboard();
      if (var1 != null && this.method11317(var1)) {
         CustomResourceManager.INSTANCE.method02465(field25880);
      } else {
         if (field25744 != null) {
            this.field25745.method11672(new Color(field25744, true));
            CustomResourceManager.INSTANCE.method02465(field25881);
         }
      }
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      if ((var3 & 2) != 0 && var1 == 67) {
         this.method11313();
      } else if ((var3 & 2) != 0 && var1 == 86) {
         this.method11312();
      }
   }

   @Override
   public void method00612(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      ThemeSettings var5 = ThemeManager.INSTANCE.method09611();
      float var6 = this.method09573().method06173();
      float var7 = this.method09576() - field25757;
      float var8 = this.method09560();
      if (this.field25747) {
         this.method11310(var2, var3);
      }

      if (this.field25748) {
         this.method11311(var3);
      }

      if (this.field25749) {
         this.method11319(var3);
      }

      this.field25751.method06162();
      this.field25752.method06162();
      this.field25753.method06162();
      this.field25751
         .method06168(
            GuiHitTestUtils.method05624(var2, var3, var7 + field25758, var8 + field25759, field25760, field25761) ? 1.0 : 0.0,
            field25762,
            Easings.field19400,
            true
         );
      this.field25752
         .method06168(
            GuiHitTestUtils.method05624(var2, var3, var7 + field25763, var8 + field25764, field25765, field25766) ? 1.0 : 0.0,
            field25767,
            Easings.field19400,
            true
         );
      this.field25753
         .method06168(
            GuiHitTestUtils.method05624(var2, var3, var7 + field25768, var8 + field25769, field25770, field25771) ? 1.0 : 0.0,
            field25772,
            Easings.field19400,
            true
         );
      int var9 = ColorUtils.method04604(255, 255, 255);
      int var10 = ColorUtils.method04604(0, 0, 0);
      GuiRenderBatch.method05183();
      GuiClipStack.method00344(var1, var7 + field25773, var8, field25774, field25775, field25743, 1.0F, field25776, var6);
      RoundedRectRenderer.method01272(
         var1, var7 + field25777, var8, field25778, field25779, field25780, 1.0F, ColorUtils.method04611(var5.field22122.method11676(), var6)
      );
      GuiShapeRenderer.method09703(
         var1, var7 + field25781, var8, field25782, field25783, field25784, 1.0F, ColorUtils.method04611(var5.field22117.method11676(), var6)
      );
      int var11 = Color.HSBtoRGB(this.field25745.method11673(), 1.0F, 1.0F);
      CornerColors var12 = new CornerColors(
         ColorUtils.method04611(var9, var6),
         ColorUtils.method04611(var10, var6),
         ColorUtils.method04611(var10, var6),
         ColorUtils.method04605(var11, var6)
      );
      RoundedRectRenderer.method01275(var1, var7 + field25785, var8 + field25786, field25787, field25788, field25789, 1.0F, var12);
      float var13 = Math.max(var7 + field25790, Math.min(var7 + field25791, var7 + field25792 + this.field25745.method11664() * field25793));
      float var14 = Math.max(var8 + field25794, Math.min(var8 + field25795, var8 + field25796 + (1.0F - this.field25745.method11678()) * field25797));
      GuiShapeRenderer.method09703(var1, var13, var14, field25798, field25799, field25800, field25801, ColorUtils.method04605(var9, var6));
      float var15 = var7 + field25802;
      float var16 = var8 + field25803;
      GuiTextureRenderer.method10259(
         var1, ClientTextures.INSTANCE.method04568(), var15, var16, field25804, field25805, ColorUtils.method04605(var9, var6)
      );
      GuiRenderBatch.method05183();
      RoundedRectRenderer.method01272(
         var1, var15 - 1.0F, var16 + this.field25745.method11673() * field25806, field25807, 1.0F, 0.0F, 0.0F, ColorUtils.method04605(var9, var6)
      );
      float var17 = var7 + field25808;
      float var18 = var8 + field25809;
      GuiTextureRenderer.method10259(
         var1, ClientTextures.INSTANCE.method04569(), var17, var18, field25810, field25811, ColorUtils.method04605(var9, var6)
      );
      GuiRenderBatch.method05183();
      RoundedRectRenderer.method01272(
         var1,
         var17 - 1.0F,
         var18 + (1.0F - this.field25745.method11680()) * field25812,
         field25813,
         1.0F,
         0.0F,
         0.0F,
         ColorUtils.method04605(var9, var6)
      );
      this.method11314(var1, var5, field25814, var7 + field25815, var8 + field25816, field25817, this.field25751.method06173(), var6);
      this.method11314(var1, var5, field25818, var7 + field25819, var8 + field25820, field25821, this.field25752.method06173(), var6);
      float var19 = Math.max(this.field25753.method06173(), this.field25750 ? 1.0F : 0.0F);
      int var20 = ColorUtils.method04631(var5.field22116.method11676(), var5.field22115.method11676(), var19);
      int var21 = ColorUtils.method04631(var5.field22110.method11676(), var5.field22109.method11676(), var19);
      RoundedRectRenderer.method01272(
         var1, var7 + field25822, var8 + field25823, field25824, field25825, field25826, 1.0F, ColorUtils.method04611(var20, var6)
      );
      Fonts.field00107
         .method09473(
            var1,
            field25827,
            var7 + field25828 + field25829,
            var8 + field25830 + field25831 - Fonts.field00107.method09485(field25832) / 2.0F,
            ColorUtils.method04611(var21, var6),
            field25833
         );
   }

   @Override
   public boolean method06786() {
      return this.field25750;
   }

   private void method11313() {
      int var1 = this.field25745.method11676();
      field25744 = var1;
      mc.keyboardHandler
         .setClipboard(
            String.format(
               Locale.ROOT,
               field25879,
               ColorUtils.method04588(var1),
               ColorUtils.method04589(var1),
               ColorUtils.method04587(var1),
               ColorUtils.method04625(var1)
            )
         );
   }

   private void method11314(GuiGraphicsExtractor var1, ThemeSettings var2, String var3, float var4, float var5, float var6, float var7, float var8) {
      int var9 = ColorUtils.method04631(var2.field22116.method11676(), var2.field22115.method11676(), var7);
      int var10 = ColorUtils.method04631(var2.field22110.method11676(), var2.field22109.method11676(), var7);
      RoundedRectRenderer.method01272(var1, var4, var5, var6, field25834, field25835, 1.0F, ColorUtils.method04611(var9, var8));
      FontRenderer var11 = Fonts.field00111;
      float var12 = field25836;
      var11.method09480(
         var1,
         var3,
         var4 + (var6 - var11.method09486(var3, var12)) / 2.0F,
         var5 + field25837 - var11.method09485(var12) / 2.0F,
         ColorUtils.method04611(var10, var8),
         var12
      );
   }

   private static long method11315(String var0, int var1) {
      StringBuilder var2 = new StringBuilder();

      for (int var3 = 0; var3 < var0.length(); var3++) {
         char var4 = Character.toUpperCase(var0.charAt(var3));
         if (var4 >= '0' && var4 <= '9' || var4 >= 'A' && var4 <= 'F') {
            var2.append(var4);
         }
      }

      if (var2.length() != 6 && var2.length() != 8) {
         return field25886;
      }

      try {
         long var10 = Long.parseLong(var2.toString(), 16);
         int var5;
         int var6;
         int var7;
         int var8;
         if (var2.length() == 6) {
            var5 = (int)(var10 >> 16 & field25887);
            var6 = (int)(var10 >> 8 & field25888);
            var7 = (int)(var10 & field25889);
            var8 = var1;
         } else {
            var5 = (int)(var10 >> 24 & field25890);
            var6 = (int)(var10 >> 16 & field25891);
            var7 = (int)(var10 >> 8 & field25892);
            var8 = (int)(var10 & field25893);
         }

         return (var8 << 24 | var5 << 16 | var6 << 8 | var7) & field25894;
      } catch (NumberFormatException var9) {
         return field25895;
      }
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      if (this.field25747 || this.field25748 || this.field25749) {
         CustomResourceManager.INSTANCE.method02465(field25863);
      }

      this.field25747 = false;
      this.field25748 = false;
      this.field25749 = false;
   }

   public ColorPickerWindow(ColorSetting var1, FloatingWindow var2) {
      super(field25754);
      this.field25745 = var1;
      this.field25746 = var2;
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (var5 == 0) {
         float var6 = this.method09576() - field25838;
         float var7 = this.method09560();
         boolean var8 = GuiHitTestUtils.method05609(var1, var3, var6 + field25839, var7 + field25840, field25841, field25842);
         if (this.field25750) {
            if (!var8) {
               this.method11318();
            }

            this.field25750 = false;
         } else if (var8) {
            this.field25750 = true;
         } else if (GuiHitTestUtils.method05609(var1, var3, var6 + field25843, var7 + field25844, field25845, field25846)) {
            this.method11313();
         } else if (GuiHitTestUtils.method05609(var1, var3, var6 + field25847, var7 + field25848, field25849, field25850)) {
            this.method11312();
         } else if (GuiHitTestUtils.method05609(var1, var3, var6 + field25851, var7 + field25852, field25853, field25854)) {
            this.field25747 = true;
            this.method11310(var1, var3);
         } else if (GuiHitTestUtils.method05609(var1, var3, var6 + field25855 - 1.0F, var7 + field25856, field25857, field25858)) {
            this.field25748 = true;
            this.method11311(var3);
         } else {
            if (GuiHitTestUtils.method05609(var1, var3, var6 + field25859 - 1.0F, var7 + field25860, field25861, field25862)) {
               this.field25749 = true;
               this.method11319(var3);
            }
         }
      }
   }

   private void method11316() {
      int var1 = Color.HSBtoRGB(this.field25745.method11673(), this.field25745.method11664(), this.field25745.method11678());
      int var2 = ColorUtils.method04592(
         ColorUtils.method04588(var1),
         ColorUtils.method04589(var1),
         ColorUtils.method04587(var1),
         Math.round(this.field25745.method11680() * field25878)
      );
      this.field25745.method11672(new Color(var2, true));
   }

   private boolean method11317(String var1) {
      long var2 = method11315(var1, Math.round(this.field25745.method11680() * field25882));
      if (var2 < 0L) {
         return false;
      }

      this.field25745.method11672(new Color((int)var2, true));
      return true;
   }

   private void method11318() {
      PixelReader.method01300((int)mc.mouseHandler.xpos(), (int)mc.mouseHandler.ypos(), this::method11320);
   }

   @Override
   public boolean method01682() {
      return this.field25746 != null && this.field25746.method01682();
   }

   private void method11319(double var1) {
      float var3 = this.method09560() + field25875;
      this.field25745.method11675(Mth.clamp(1.0F - (Mth.clamp((float)var1, var3, var3 + field25876) - var3) / field25877, 0.0F, 1.0F));
      this.method11316();
   }

   private void method11320(int var1) {
      int var2 = Math.round(this.field25745.method11680() * field25883);
      int var3 = var1 & field25884;
      this.field25745.method11672(new Color(var2 << 24 | var3, true));
      CustomResourceManager.INSTANCE.method02465(field25885);
   }
}
