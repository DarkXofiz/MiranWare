// Original binary: sg/ec/OigmjJ13gGSqNvQJ
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ModeSettingComponent extends SettingComponent<ModeSetting> {
   private final FontRenderer field10824 = Fonts.field00110;
   private final float field10825;
   private final List<ModeOptionComponent> field10826;
   private static final float field10827 = 7.0F;
   private static final float field10828 = 7.0F;
   private static final float field10829 = 5.0F;
   private static final float field10830 = 5.0F;
   private static final float field10831 = 2.75F;
   private static final float field10832 = 0.5F;
   private static final float field10833 = 0.5F;
   private static final float field10834 = 10.5F;
   private static final float field10835 = 2.5F;
   private static final float field10836 = 7.0F;
   private static final float field10837 = 7.0F;
   private static final float field10838 = 5.0F;
   private static final float field10839 = 5.0F;
   private static final float field10840 = 2.75F;
   private static final float field10841 = 0.5F;
   private static final float field10842 = 0.5F;
   private static final float field10843 = 10.5F;
   private static final float field10844 = 7.0F;
   private static final float field10845 = 6.0F;
   private static final float field10846 = 7.0F;

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      this.method04886();
      this.field10824
         .method09480(
            var1,
            this.method10977().method03024(),
            this.method09780(),
            this.method09782() + field10835,
            ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22108.method11676(), this.method09790()),
            field10836
         );
      float var5 = 0.0F;
      float sx = this.field10824.method09485(field10837) + field10838;

      for (ModeOptionComponent sxx : this.field10826) {
         float sxxx = sxx.method09601().method09486(sxx.method09603(), sxx.method09600()) + field10839;
         sxx.method09786(sxx.method09601().method09485(sxx.method09600()) + field10840);
         if (var5 + sxxx > this.method09784()) {
            var5 = 0.0F;
            sx += sxx.method09785() + field10841;
         }

         sxx.method09789(this.method09780() + var5);
         sxx.method09788(this.method09782() + sx);
         sxx.method09781(sxxx);
         sxx.method09783(this.method09790());
         sxx.method00042(var1, var2, var3, var4);
         var5 += sxxx + field10842;
      }

      this.method09786(field10843 + sx);
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      this.method04886();

      for (ModeOptionComponent var7 : this.field10826) {
         var7.method00040(var1, var3, var5);
      }
   }

   @Override
   public void method03443() {
      this.method04886();
      float var1 = 0.0F;
      float var2 = this.field10824.method09485(field10828) + field10829;

      for (ModeOptionComponent var4 : this.field10826) {
         float var5 = var4.method09601().method09486(var4.method09603(), var4.method09600()) + field10830;
         float var6 = var4.method09601().method09485(var4.method09600()) + field10831;
         var4.method09786(var6);
         if (var1 + var5 > this.method09784()) {
            var1 = 0.0F;
            var2 += var6 + field10832;
         }

         var1 += var5 + field10833;
      }

      this.method09786(field10834 + var2);
   }

   public FontRenderer method04885() {
      return this.field10824;
   }

   private void method04886() {
      var var1 = new ArrayList<>(this.method10977().method05598());
      boolean var2 = var1.size() != this.field10826.size();
      if (!var2) {
         for (int var3 = 0; var3 < var1.size(); var3++) {
            if (!((String)var1.get(var3)).equals(this.field10826.get(var3).method09603())) {
               var2 = true;
               break;
            }
         }
      }

      if (var2) {
         this.field10826.clear();

         for (String var4 : var1) {
            this.field10826.add(new ModeOptionComponent(this.method10977(), var4));
         }
      }
   }

   @Override
   public float method04887() {
      return Math.min(this.method09785(), this.field10824.method09485(field10844) * 2.0F + field10845);
   }

   public float method04888() {
      Objects.requireNonNull(this);
      return field10846;
   }

   public List<ModeOptionComponent> method04889() {
      return this.field10826;
   }

   public ModeSettingComponent(ModeSetting var1) {
      super(var1);
      this.field10825 = field10827;
      this.field10826 = new ArrayList<>();
      this.method04886();
   }
}
