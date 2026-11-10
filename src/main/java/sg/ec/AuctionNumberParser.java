// Original binary: sg/ec/Vzw34Zk4fzhkeRZJ
package sg.ec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: Compiled from s
public final class AuctionNumberParser {
   private static final Pattern field12735 = Pattern.compile(AuctionNumberParser.field12740);
   private static final long field12736 = 400L;
   private static final long field12737 = 1000L;
   private static final long field12738 = 400L;
   private static final String field12739 = "This is a utility class and cannot be instantiated";
   private static final String field12740 = "подождите ([0-9]{1,3}) сек";

   private AuctionNumberParser() {
      throw new UnsupportedOperationException(field12739);
   }

   public static long method05959(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         Matcher var1 = field12735.matcher(UnicodeTextNormalizer.method09496(var0));
         return var1.find() ? Long.parseLong(var1.group(1)) * field12737 + field12738 : 0L;
      } else {
         return 0L;
      }
   }
}
