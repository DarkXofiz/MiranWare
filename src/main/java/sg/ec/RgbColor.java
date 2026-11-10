// Original binary: sg/ec/6QlD135nELyBCKNm
package sg.ec;

import java.awt.Color;

// $VF: Compiled from s
public record RgbColor(int red, int green, int blue) {
   public int toInt(int var1) {
      return (var1 << 24) + (this.red << 16) + (this.green << 8) + this.blue;
   }

   public int toInt() {
      return -16777216 + (this.red << 16) + (this.green << 8) + this.blue;
   }

   public static RgbColor method01350(String var0) {
      if (!var0.startsWith("#")) {
         return new RgbColor(0, 0, 0);
      }

      Color var1 = Color.decode(var0);
      return new RgbColor(var1.getRed(), var1.getGreen(), var1.getBlue());
   }

   public static int rgbaToInt(int var0, int var1, int var2, float var3) {
      return ((int)(var3 * 255.0F) << 24) + (var0 << 16) + (var1 << 8) + var2;
   }

   public String toHex() {
      return String.format("#%02x%02x%02x", this.red, this.green, this.blue);
   }
}
