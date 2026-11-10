// Original binary: sg/ec/yyMpAgYQ9yfUuRjG
package sg.ec;

import java.awt.Color;

// $VF: Compiled from s
public class ColorSetting extends Setting<Color> {
   private float field27813;
   private float field27814;
   private float field27815;
   private float field27816;
   private Color field27817;
   private static final float field27818 = 1.0E-4F;
   private static final float field27819 = 255.0F;

   public float method11664() {
      return this.field27815;
   }

   public ColorSetting(String var1) {
      super(var1);
   }

   private int method11665() {
      if (this.method03022() == null) {
         return 0;
      } else {
         int var1 = this.method03022().getRGB();
         if (this.field27817 == null) {
            return var1;
         } else {
            float var2 = ThemeManager.INSTANCE.method09613();
            if (var2 >= 1.0F) {
               this.field27817 = null;
               return var1;
            } else {
               return ColorUtils.method04631(this.field27817.getRGB(), var1, var2);
            }
         }
      }
   }

   public ColorSetting method11666(float var1) {
      this.field27815 = var1;
      return this;
   }

   public void method11667(float var1) {
      this.field27814 = var1;
   }

   public void method11668(float var1) {
      this.field27816 = var1;
   }

   public ColorSetting method11669(float var1) {
      this.field27813 = var1;
      return this;
   }

   public void method11670(Color var1) {
      this.field27817 = var1;
   }

   public Color method11671() {
      return this.field27817;
   }

   public <S extends Setting<Color>> S method11672(Color var1) {
      if (var1 == null) {
         return super.method03014(var1);
      }

      float[] var2 = Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), null);
      float var3 = var2[1] <= field27818 ? this.field27814 : var2[0];
      this.method11669(var1.getAlpha() / field27819);
      this.method11683(var3);
      this.method11666(var2[1]);
      this.method11674(var2[2]);
      return super.method03014(var1);
   }

   public float method11673() {
      return this.field27814;
   }

   public ColorSetting method11674(float var1) {
      this.field27816 = var1;
      return this;
   }

   public void method11675(float var1) {
      this.field27813 = var1;
   }

   public int method11676() {
      return this.method11665();
   }

   public Color method11677() {
      if (this.method03022() == null) {
         return this.field27817;
      }

      if (this.field27817 == null) {
         return this.method03022();
      }

      float var1 = ThemeManager.INSTANCE.method09613();
      return var1 >= 1.0F ? this.method03022() : new Color(ColorUtils.method04631(this.field27817.getRGB(), this.method03022().getRGB(), var1), true);
   }

   public float method11678() {
      return this.field27816;
   }

   public int method11679() {
      return this.method11665();
   }

   public float method11680() {
      return this.field27813;
   }

   public void method11681(Color var1) {
      this.field27817 = var1;
   }

   public void method11682(float var1) {
      this.field27815 = var1;
   }

   public ColorSetting method11683(float var1) {
      this.field27814 = var1;
      return this;
   }
}
