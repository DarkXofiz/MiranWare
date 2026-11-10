// Original binary: sg/ec/UJaY4C61yOWYP17P
package sg.ec;

import java.awt.Color;

// $VF: Compiled from s
public record CornerColors(int color1, int color2, int color3, int color4) {
   public static final CornerColors TRANSPARENT = new CornerColors(0, 0, 0, 0);
   public static final CornerColors WHITE = new CornerColors(-1, -1, -1, -1);

   public CornerColors(int var1) {
      this(var1, var1, var1, var1);
   }

   public CornerColors(Color var1) {
      this(var1, var1, var1, var1);
   }

   public CornerColors(Color var1, Color var2, Color var3, Color var4) {
      this(var1.getRGB(), var2.getRGB(), var3.getRGB(), var4.getRGB());
   }
}
