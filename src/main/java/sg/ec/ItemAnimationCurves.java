// Original binary: sg/ec/A16duwsW4SgiDv4o
package sg.ec;

// $VF: Compiled from s
final class ItemAnimationCurves {
   private static final double field05966 = 3.0;
   private static final double field05967 = 0.44;
   private static final double field05968 = 3.0;
   private static final double field05969 = 3.0;
   private static final double field05970 = 0.44;
   private static final double field05971 = 3.0;
   private static final double field05972 = 0.94;

   static double method02441(double var0) {
      double var2 = var0 * var0;
      double sx = var2 * var0;
      return field05966 * var0 * (1.0 - var0) * (1.0 - var0) * field05967 + field05968 * var2 * (1.0 - var0) * 1.0 + sx;
   }

   static double method02442(double var0) {
      double var2 = var0 * var0;
      double var4 = var2 * var0;
      return field05969 * var0 * (1.0 - var0) * (1.0 - var0) * field05970 + field05971 * var2 * (1.0 - var0) * field05972 + var4;
   }

   private ItemAnimationCurves() {
   }
}
