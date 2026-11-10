// Original binary: sg/ec/wU2cnBeZ0OKqoy2o
package sg.ec;

// $VF: Compiled from s
public final class ChatChannelFormatter {
   private static final String field25190 = "Global";
   private static final String field25191 = "IRC";
   private static final String field25192 = "Party";
   private static final String field25193 = "PM";
   private static final String field25194 = "Global";
   private static final String field25195 = "#FFFFFF";
   private static final String field25196 = "#3B82F6";
   private static final String field25197 = "#22C55E";
   private static final String field25198 = "#FFD700";
   private static final String field25199 = "#FFFFFF";
   private static final String field25200 = "0x";
   private static final String field25201 = "0X";

   private ChatChannelFormatter() {
   }

   public static String method11200(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.trim();
         if (var1.isEmpty()) {
            return "";
         } else {
            return !var1.startsWith(field25200) && !var1.startsWith(field25201) ? var1 : "#" + var1.substring(2);
         }
      }
   }

   public static String method11201(ChatChannel var0) {
      if (var0 == null) {
         return field25190;
      }

      return switch (var0) {
         case IRC -> field25191;
         case PARTY -> field25192;
         case PERSONAL -> field25193;
         case GLOBAL -> field25194;
      };
   }

   public static String method11202(ChatChannel var0) {
      if (var0 == null) {
         return field25195;
      }

      return switch (var0) {
         case IRC -> field25196;
         case PARTY -> field25197;
         case PERSONAL -> field25198;
         case GLOBAL -> field25199;
      };
   }
}
