// Original binary: sg/ec/oiWXNHVAKdqz4z8M
package sg.ec;

// $VF: Compiled from s
public final class EspColorUtils {
   public static final int field22182 = 7;
   public static final int field22183 = 0;
   private static final int field22184 = 0;
   private static final int field22185 = 0;
   private static final int field22186 = 0;
   private static final int field22187 = 0;
   private static final int field22188 = 0;
   private static final int field22189 = 0;
   private static final int field22190 = 16777215;
   private static final int field22191 = 134217728;
   private static final int field22192 = -402653185;

   private static int method09874() {
      return field22192;
   }

   public static int method09875(int var0) {
      int var1 = var0 != 0 ? var0 : method09874();
      return var1 | field22191;
   }

   private EspColorUtils() {
   }

   public static int method09876(int var0, boolean var1, int var2) {
      int var3 = (var1 ? 224 : 160) | var0 & 7;
      return var3 << 24 | var2 & field22190;
   }
}
