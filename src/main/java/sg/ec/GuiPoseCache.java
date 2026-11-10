// Original binary: sg/ec/0LrR5NDeRs2fBo5G
package sg.ec;

import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class GuiPoseCache {
   private static Matrix3x2f field00102;

   public static Matrix3x2f method00056(Matrix3x2f var0) {
      Matrix3x2f var1 = field00102;
      if (var1 != null && var1.equals(var0)) {
         return var1;
      }

      Matrix3x2f sx = new Matrix3x2f(var0);
      field00102 = sx;
      return sx;
   }

   private GuiPoseCache() {
   }
}
