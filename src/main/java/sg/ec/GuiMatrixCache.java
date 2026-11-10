// Original binary: sg/ec/15GGwPzfEevC9kl9
package sg.ec;

import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;

// $VF: Compiled from s
public final class GuiMatrixCache {
   private static Matrix4f field00513;
   private static Matrix3x2fc field00514;

   public static Matrix4f method00247(Matrix4f var0, Matrix3x2fc var1) {
      if (var1 == field00514) {
         return var0;
      }

      field00514 = var1;
      return var0.identity().mul(var1);
   }

   public static Matrix4f method00248() {
      Matrix4f var0 = field00513;
      if (var0 == null) {
         var0 = new Matrix4f();
         field00513 = var0;
      }

      return var0;
   }

   private GuiMatrixCache() {
   }
}
