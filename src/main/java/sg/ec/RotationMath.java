// Original binary: sg/ec/xbagmY3LaCbI8mls
package sg.ec;

// $VF: Compiled from s
public final class RotationMath implements MinecraftAccess {
   private static final double field26009 = 0.15;
   private static final double field26010 = 0.6F;
   private static final double field26011 = 0.2F;
   private static final double field26012 = 3.0;
   private static final double field26013 = 8.0;
   private static final String field26014 = "This is a utility class and cannot be instantiated";

   public static float method11343(float var0) {
      return method11344(var0) * method11345();
   }

   public static float method11344(float var0) {
      return Math.round(var0 / method11345());
   }

   private RotationMath() {
      throw new UnsupportedOperationException(field26014);
   }

   public static float method11345() {
      return (float)(method11346() * field26009);
   }

   public static float method11346() {
      double var0 = mc.options.sensitivity().get();
      return (float)(Math.pow(var0 * field26010 + field26011, field26012) * field26013);
   }
}
