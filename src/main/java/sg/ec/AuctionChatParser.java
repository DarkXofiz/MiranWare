// Original binary: sg/ec/Y9cnazVB7E5Y5bfk
package sg.ec;

// $VF: Compiled from s
public final class AuctionChatParser {
   private static final String field14710 = "▶ Вы купили ";
   private static final String field14711 = "field14711";
   private static final String field14712 = "field14712";
   private static final String field14713 = "field14713";
   private static final String field14714 = "field14714";
   private static final String field14715 = "Невозможно забрать предмет, так как его уже купили";
   private static final String field14716 = "успешно купили";
   private static final String field14717 = " за ";
   private static final String field14718 = "▶ Вы купили ";
   private static final String field14719 = " у ";
   private static final String field14720 = " за ";
   private static final String field14721 = " за ";
   private static final String field14722 = " за ";
   private static final String field14723 = " за ";
   private static final String field14724 = " у ";
   private static final String field14725 = " у ";

   public static long method06523(String var0) {
      int var1 = var0.lastIndexOf(field14721);
      if (var1 < 0) {
         return 0L;
      }

      Long sx = AuctionPriceParser.method09582(var0, var1 + field14722.length());
      return sx == null ? 0L : sx;
   }

   public static boolean method06524(String var0) {
      return var0.startsWith(field14718) && var0.contains(field14719) && var0.contains(field14720);
   }

   public static String method06525(String var0) {
      if (!method06524(var0)) {
         return "";
      }

      int var1 = var0.lastIndexOf(field14723);
      int var2 = var0.lastIndexOf(field14724, var1);
      return var2 < 0 ? "" : var0.substring(var2 + field14725.length(), var1).trim();
   }

   private AuctionChatParser() {
   }

   public static boolean method06526(String var0) {
      return var0.contains(field14715);
   }

   public static boolean method06527(String var0) {
      return method06524(var0) || var0.contains(field14716) && var0.contains(field14717);
   }
}
