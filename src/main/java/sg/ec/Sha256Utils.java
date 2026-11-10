// Original binary: sg/ec/YkmGQiELbXquLFh9
package sg.ec;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// $VF: Compiled from s
public final class Sha256Utils {
   private static final String field14955 = "SHA-256";

   public static byte[] method06659(List<StoredContentInfo> var0) {
      List var1 = new ArrayList<>();
      if (var0 != null) {
         for (StoredContentInfo sx : var0) {
            if (sx != null && sx.category() != null) {
               var1.add(sx);
            }
         }
      }

      var1.sort(Comparator.<StoredContentInfo, String>comparing(var0x -> var0x.category().name()).thenComparing(StoredContentInfo::name));
      StringBuilder sx = new StringBuilder();

      for (StoredContentInfo sxx : (Iterable<StoredContentInfo>) (Iterable) var1) {
         String sxxx = sxx.category().name();
         String sxxxx = sxx.name();
         sx.append(sxxx.length()).append(':').append(sxxx);
         sx.append(sxxxx.length()).append(':').append(sxxxx);
         sx.append(sxx.size()).append(';');
      }

      try {
         return MessageDigest.getInstance(field14955).digest(sx.toString().getBytes(StandardCharsets.UTF_8));
      } catch (Exception sxx) {
         return new byte[0];
      }
   }

   private Sha256Utils() {
   }
}
