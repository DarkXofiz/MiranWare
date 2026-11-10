// Original binary: sg/ec/peUgqwLAhdaCLdbL
package sg.ec;

// $VF: Compiled from s
public enum NamedColor {
   WHITE(16777215),
   GRAY(8421504),
   BLACK(0),
   RED(16711680),
   ORANGE(16744448),
   YELLOW(16776960),
   LIME(8453888),
   GREEN(65280),
   CYAN(65535),
   LIGHT_BLUE(4169983),
   BLUE(255),
   PURPLE(8388863),
   MAGENTA(16711935),
   PINK(16744640),
   BROWN(9132587);

   private final int field22796;

   NamedColor(int var3) {
      this.field22796 = var3;
   }

   public static NamedColor method10138(String var0) {
      for (NamedColor var4 : values()) {
         if (var4.name().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   public int method10139() {
      return this.field22796;
   }
}
