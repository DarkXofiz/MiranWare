// Original binary: sg/ec/t0VDngeIe6Zr6erA
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class BindingSettingsWindow extends FloatingWindow {
   private static final float field23773 = 5.0F;
   private static final float field23774 = 0;
   private static final float field23775 = 0;
   private static final float field23776 = 0;
   private static final float field23777 = 0;
   private static final float field23778 = 0;
   private static final float field23779 = 0;
   private static final float field23780 = 0;
   private static final float field23781 = 0;
   private static final float field23782 = GuiSize.method04763(BindingSettingsWindow.field23830)
      .method04764(BindingSettingsWindow.field23831)
      .method04768();
   private static final String field23783 = "field23783";
   private static final String field23784 = "field23784";
   private static final String field23785 = "field23785";
   private static final String field23786 = "field23786";
   private final FontRenderer field23787 = Fonts.field00110;
   private final KeyBindSetting field23788;
   private final KeyBindingCapture field23789;
   private final Runnable field23790;
   private final SmoothAnimation field23791 = new SmoothAnimation();
   private final SmoothAnimation field23792 = new SmoothAnimation();
   private final SmoothAnimation field23793 = new SmoothAnimation();
   private final BindingModeSelector field23794;
   private final GuiBounds field23795 = new GuiBounds();
   private final GuiBounds field23796 = new GuiBounds();
   private final GuiBounds field23797 = new GuiBounds();
   private static final float field23798 = 100.0F;
   private static final double field23799 = 0.15F;
   private static final double field23800 = 0.15F;
   private static final double field23801 = 0.2F;
   private static final float field23802 = 5.0F;
   private static final float field23803 = 10.0F;
   private static final float field23804 = 5.0F;
   private static final float field23805 = 11.0F;
   private static final float field23806 = 14.0F;
   private static final float field23807 = 15.333333F;
   private static final float field23808 = 15.333333F;
   private static final float field23809 = 9.333333F;
   private static final float field23810 = 12.333333F;
   private static final float field23811 = 10.0F;
   private static final float field23812 = 13.0F;
   private static final float field23813 = 10.0F;
   private static final float field23814 = 10.0F;
   private static final float field23815 = 5.0F;
   private static final float field23816 = 7.0F;
   private static final String field23817 = "Key:";
   private static final float field23818 = 7.0F;
   private static final String field23819 = "...";
   private static final float field23820 = 7.0F;
   private static final float field23821 = 7.0F;
   private static final float field23822 = 7.0F;
   private static final float field23823 = 7.0F;
   private static final String field23824 = "Visible";
   private static final float field23825 = 5.0F;
   private static final float field23826 = 7.0F;
   private static final String field23827 = "open bind list";
   private static final float field23828 = 0.999F;
   private static final float field23829 = 0.999F;
   private static final float field23830 = 10.0F;
   private static final float field23831 = 0.5F;

   private static void method10778(GuiBounds var0, float var1, float var2, float var3, float var4) {
      var0.method02801(var1);
      var0.method02806(var2);
      var0.method02803(var3);
      var0.method02798(var4);
   }

   public Runnable method10779() {
      return this.field23790;
   }

   public BindingSettingsWindow(String var1, KeyBindSetting var2, Runnable var3) {
      super(var1);
      this.field23788 = var2;
      this.field23790 = var3;
      this.field23789 = new KeyBindingCapture(var2);
      this.field23794 = new BindingModeSelector(this.method10789().method05874());
      this.field23791.method06155(this.method10789().method05873() ? 1.0 : 0.0);
      this.method08971(field23798);
      this.method09557(true);
   }

   public KeyBindingCapture method10780() {
      return this.field23789;
   }

   public SmoothAnimation method10781() {
      return this.field23791;
   }

   public BindingModeSelector method10782() {
      return this.field23794;
   }

   public FontRenderer method10783() {
      return this.field23787;
   }

   private void method10784() {
      float var1 = this.method09576() + field23802;
      float var2 = this.method09568() - field23803;
      float var3 = this.method09560() + field23804;
      method10778(this.field23795, var1, var3, var2, field23805);
      var3 += field23806;
      method10778(this.field23796, var1 + var2 - field23807, var3, field23808, field23809);
      var3 += field23810;
      method10778(this.field23794.method01904(), var1, var3, var2, field23811);
      var3 += field23812;
      method10778(this.field23797, var1, var3, var2, field23813);
      var3 += field23814;
      this.method09561(var3 - this.method09560() + field23815);
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (!(this.method09573().method06173() < field23828)) {
         if (!this.field23789.method06907(var5)) {
            if (var5 == 0) {
               if (this.field23795.method02799(var1, var3)) {
                  this.field23789.method06906();
               } else if (this.field23796.method02799(var1, var3)) {
                  this.method10789().method05875(!this.method10789().method05873());
               } else if (this.field23794.method01905(var1, var3)) {
                  this.method10789().method05870(this.field23794.method01907(var1));
               } else if (this.field23797.method02799(var1, var3)) {
                  this.method10793();
               }
            }
         }
      }
   }

   public KeyBindSetting method10785() {
      return this.field23788;
   }

   public GuiBounds method10786() {
      return this.field23796;
   }

   private void method10787(GuiGraphics var1, float var2) {
      int var3 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11679(), var2);
      float var4 = this.field23796.method02808() + (this.field23796.method02802() - this.field23787.method09485(field23823)) / 2.0F;
      this.field23787.method09480(var1, field23824, this.method09576() + field23825, var4, var3, field23826);
      ToggleSwitchRenderer.method03323(var1, this.field23796, this.field23791.method06173(), var2);
   }

   public SmoothAnimation method10788() {
      return this.field23793;
   }

   private KeyBinding method10789() {
      return this.field23788.method03022();
   }

   public SmoothAnimation method10790() {
      return this.field23792;
   }

   public GuiBounds method10791() {
      return this.field23795;
   }

   private void method10792(int var1, int var2) {
      this.field23791.method06162();
      this.field23791.method06158(this.method10789().method05873() ? 1.0 : 0.0, field23799, Easings.field19412);
      this.field23792.method06162();
      this.field23792.method06158(this.field23789.method06910() ? 1.0 : 0.0, field23800, Easings.field19412);
      this.field23793.method06162();
      this.field23793.method06158(this.field23797.method02805(var1, var2) ? 1.0 : 0.0, field23801, Easings.field19400);
   }

   private void method10793() {
      this.field23790.run();
      this.method09580().method09654(this);
   }

   private void method10794(GuiGraphics var1, float var2) {
      GuiBounds var3 = this.field23797;
      KeyBadgeRenderer.method03191(
         var1, var3.method02809(), var3.method02808(), var3.method02804(), var3.method02802(), field23827, this.field23793.method06173(), var2
      );
   }

   private void method10795(GuiGraphics var1) {
      WindowFrameRenderer.method03056(var1, this, field23782);
   }

   private void method10796(GuiGraphics var1, float var2) {
      ThemeSettings var3 = ThemeManager.INSTANCE.method09611();
      float var4 = this.field23795.method02808() + (this.field23795.method02802() - this.field23787.method09485(field23816)) / 2.0F;
      this.field23787
         .method09480(var1, field23817, this.field23795.method02809(), var4, ColorUtils.method04611(var3.field22108.method11679(), var2), field23818);
      String var5 = this.field23789.method06910() ? field23819 : KeyboardKey.method00360(this.method10789().method05871());
      float var6 = this.field23795.method02809() + this.field23795.method02804() - KeyLabelRenderer.method02576(this.field23787, var5, field23820);
      float var7 = this.field23795.method02808() + (this.field23795.method02802() - KeyLabelRenderer.method02577(this.field23787, field23821)) / 2.0F;
      KeyLabelRenderer.method02578(var1, this.field23787, var6, var7, var5, field23822, this.field23792.method06173(), var2);
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      if (!(this.method09573().method06173() < field23829)) {
         if (!this.field23789.method06909(var1)) {
            if (var1 == 256) {
               this.method09580().method09654(this);
            }
         }
      }
   }

   public GuiBounds method10797() {
      return this.field23797;
   }

   @Override
   public void method00612(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method09557(this.method09569());
      this.method10792(var2, var3);
      this.method10784();
      GuiRenderBatch.method05183();
      this.method10795(var1);
      float var5 = this.method09573().method06173();
      this.method10796(var1, var5);
      this.method10787(var1, var5);
      this.field23794.method01908(var1, this.field23787, this.method10789().method05874(), var5);
      this.method10794(var1, var5);
   }
}
