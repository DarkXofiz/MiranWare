// Original binary: sg/ec/wmdMmJgcEkzApMR4
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;

// $VF: Compiled from s
public class ItemTransformSequence {
   private final ArrayList<ItemTransform> field25229 = new ArrayList<>();

   public void method11236(int var1, int var2, float var3, float var4, float var5) {
      for (int var6 = var1; var6 <= var2; var6++) {
         this.method11239(var6, new ScaleItemTransform(var3, var4, var5));
      }
   }

   public void method11237(int var1, PoseStack var2) {
      for (int var3 = this.field25229.size() - 1; var3 >= 0; var3--) {
         ItemTransform var4 = this.field25229.get(var3);
         if (var4.field00727 == var1) {
            var4.method00356(var2);
         }
      }
   }

   public void method11238(int var1, int var2, float var3, float var4, float var5, float var6) {
      for (int var7 = var1; var7 <= var2; var7++) {
         this.method11239(var7, new RotateAroundYTransform(var3, var4, var5, var6));
      }
   }

   private void method11239(int var1, ItemTransform var2) {
      var2.field00727 = var1;
      this.field25229.add(var2);
   }

   public void method11240(int var1, int var2, float var3, float var4, float var5, float var6) {
      for (int var7 = var1; var7 <= var2; var7++) {
         this.method11239(var7, new RotateAroundXTransform(var3, var4, var5, var6));
      }
   }

   public void method11241(int var1, int var2, float var3) {
      for (int var4 = var1; var4 <= var2; var4++) {
         this.method11239(var4, new RotateAroundZTransform(var3, 0.0F, 0.0F, 0.0F));
      }
   }

   public void method11242(int var1, int var2, float var3) {
      for (int var4 = var1; var4 <= var2; var4++) {
         this.method11239(var4, new TranslateXTransform(var3));
      }
   }

   public void method11243(int var1, int var2, float var3, float var4, float var5, float var6) {
      for (int var7 = var1; var7 <= var2; var7++) {
         this.method11239(var7, new RotateAroundZTransform(var3, var4, var5, var6));
      }
   }

   public void method11244(int var1, int var2, float var3) {
      for (int var4 = var1; var4 <= var2; var4++) {
         this.method11239(var4, new RotateAroundYTransform(var3, 0.0F, 0.0F, 0.0F));
      }
   }

   public void method11245(int var1, int var2, float var3) {
      for (int var4 = var1; var4 <= var2; var4++) {
         this.method11239(var4, new TranslateYTransform(var3));
      }
   }

   public void method11246() {
      this.field25229.clear();
   }

   public void method11247(int var1, int var2, float var3) {
      for (int var4 = var1; var4 <= var2; var4++) {
         this.method11239(var4, new TranslateZTransform(var3));
      }
   }

   public void method11248(int var1, int var2, float var3) {
      for (int var4 = var1; var4 <= var2; var4++) {
         this.method11239(var4, new RotateAroundXTransform(var3, 0.0F, 0.0F, 0.0F));
      }
   }
}
