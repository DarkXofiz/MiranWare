// Original binary: sg/ec/8L7HFRTBY5sJ5lBD
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import net.minecraft.util.FormattedCharSequence;

// $VF: Compiled from s
public final class FormattedTextCache {
   private static final int field04579 = 2048;
   private static final Long2ObjectLinkedOpenHashMap<FormattedCharSequence> field04580 = new Long2ObjectLinkedOpenHashMap();

   private FormattedTextCache() {
   }

   public static synchronized FormattedCharSequence method01891(long var0) {
      return (FormattedCharSequence)field04580.getAndMoveToFirst(var0);
   }

   public static synchronized void method01892() {
      field04580.clear();
   }

   public static synchronized void method01893(long var0, FormattedCharSequence var2) {
      if (field04580.size() >= 2048) {
         field04580.removeLast();
      }

      field04580.putAndMoveToFirst(var0, var2);
   }
}
