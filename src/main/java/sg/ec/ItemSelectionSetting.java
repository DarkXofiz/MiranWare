// Original binary: sg/ec/Gfl81bYOibVzR5gB
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ItemSelectionSetting extends Setting<Object> {
   private float field08155;
   private ItemSelectionSetting.Nested108 field08156;
   private ItemSelectionSetting.Nested109 field08157;
   private ItemSelectionSetting.Nested109 field08158;
   private static final float field08159 = 15.0F;

   public void method03675(float var1) {
      this.field08155 = var1;
   }

   public ItemSelectionSetting method03676(ItemSelectionSetting.Nested108 var1) {
      this.field08156 = var1;
      return this;
   }

   public ItemSelectionSetting method03677(ItemSelectionSetting.Nested109 var1) {
      this.field08158 = var1;
      return this;
   }

   @Override
   public void method00869() {
   }

   public void method03678(ItemSelectionSetting.Nested109 var1) {
      this.field08157 = var1;
   }

   public ItemSelectionSetting method03679(ItemSelectionSetting.Nested109 var1) {
      this.field08157 = var1;
      return this;
   }

   public ItemSelectionSetting.Nested109 method03680() {
      return this.field08158;
   }

   public void method03681(ItemSelectionSetting.Nested109 var1) {
      this.field08158 = var1;
   }

   public ItemSelectionSetting.Nested109 method03682() {
      return this.field08157;
   }

   public ItemSelectionSetting method03683(float var1) {
      this.field08155 = Math.max(1.0F, var1);
      return this;
   }

   public float method03684() {
      return this.field08155;
   }

   public ItemSelectionSetting.Nested108 method03685() {
      return this.field08156;
   }

   public ItemSelectionSetting(String var1) {
      super(var1);
      this.field08155 = field08159;
   }

   public void method03686(ItemSelectionSetting.Nested108 var1) {
      this.field08156 = var1;
   }

   // $VF: Compiled from s
   public interface Nested108 {
      void method03687(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8);
   }

   // $VF: Compiled from s
   public interface Nested109 {
      boolean method03688(double var1, double var3, int var5);
   }
}
