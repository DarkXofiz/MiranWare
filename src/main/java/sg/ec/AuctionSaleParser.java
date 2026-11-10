// Original binary: sg/ec/OD8alP8JEG6vhG4X
package sg.ec;

// $VF: Compiled from s
public final class AuctionSaleParser {
   private static final String field10487 = UnicodeTextNormalizer.method09496(AuctionSaleParser.field10490);
   private static final String field10488 = UnicodeTextNormalizer.method09496(AuctionSaleParser.field10491);
   private static final String field10489 = UnicodeTextNormalizer.method09496(AuctionSaleParser.field10492);
   private static final String field10490 = "купил";
   private static final String field10491 = "у вас";
   private static final String field10492 = " за ";

   public static AuctionSaleParser.Nested139 method04756(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         String var1 = UnicodeTextNormalizer.method09496(var0);
         int sx = var1.indexOf(field10487);
         int sxx = var1.indexOf(field10488);
         if (sx >= 0 && sxx >= 0) {
            int sxxx = var1.lastIndexOf(field10489);
            int sxxxx = Math.max(method04758(var1, sx + field10487.length()), sxx + field10488.length());
            if (sxxx <= sxxxx) {
               return null;
            }

            String sxxxxx = var0.substring(sxxxx, sxxx).trim();
            if (sxxxxx.isEmpty()) {
               return null;
            }

            Long sxxxxxx = AuctionPriceParser.method09582(var0, sxxx + field10489.length());
            String sxxxxxxx = sxx < sx ? "" : method04757(var0.substring(0, sx));
            return new AuctionSaleParser.Nested139(sxxxxxxx, sxxxxx, sxxxxxx == null ? 0L : sxxxxxx);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private static String method04757(String var0) {
      String var1 = var0.trim();
      int var2 = var1.lastIndexOf(32);
      return var2 < 0 ? var1 : var1.substring(var2 + 1);
   }

   private static int method04758(String var0, int var1) {
      int var2 = var1;

      while (var2 < var0.length() && Character.isLetter(var0.charAt(var2))) {
         var2++;
      }

      return var2;
   }

   private AuctionSaleParser() {
   }

   public static boolean method04759(String var0) {
      return method04756(var0) != null;
   }

   // $VF: Compiled from s
   public record Nested139(String buyer, String item, long price) {
   }
}
