// Original binary: sg/ec/Ayb3R22TIL7Pi0vI
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public class ItemSelectionSettingComponent extends SettingComponent<ItemSelectionSetting> {
   @Override
   public void method00040(double var1, double var3, int var5) {
      ItemSelectionSetting.Nested109 var6 = this.method10977().method03682();
      if (var6 != null && this.method09787(var1, var3)) {
         var6.method03688(this.method02633(var1, this.method09780(), this.method09784()), this.method02633(var3, this.method09782(), this.method09785()), var5);
      }
   }

   @Override
   public void method02632(double var1, double var3, int var5) {
      ItemSelectionSetting.Nested109 var6 = this.method10977().method03680();
      if (var6 != null) {
         var6.method03688(this.method02633(var1, this.method09780(), this.method09784()), this.method02633(var3, this.method09782(), this.method09785()), var5);
      }
   }

   @Override
   public void method00042(GuiGraphics var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      this.method09786(this.method10977().method03684());
      ItemSelectionSetting.Nested108 var5 = this.method10977().method03685();
      if (var5 != null) {
         var5.method03687(var1, this.method09780(), this.method09782(), this.method09784(), this.method09785(), var2, var3, this.method09790());
      }
   }

   public ItemSelectionSettingComponent(ItemSelectionSetting var1) {
      super(var1);
      this.method09786(var1.method03684());
   }

   private double method02633(double var1, float var3, float var4) {
      return var4 <= 0.0F ? 0.0 : (var1 - var3) / var4;
   }
}
