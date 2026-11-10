// Original binary: sg/ec/9ITgv5OZPI1romum
package sg.ec;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// $VF: Compiled from s
final class BotAuctionPresenceTracker {
   private final Set<String> field05173 = ConcurrentHashMap.newKeySet();
   private long field05174;
   private int field05175;

   void method02196(List<BotClient> var1, long var2) {
      AutoBuySettings var4 = AutoBuySettings.field19624;
      int sx = var4.method08548();
      Set<String> sxx = ConcurrentHashMap.newKeySet();
      if (sx > 0 && sx < var1.size()) {
         long sxxx = var4.method08539();
         if (this.field05174 == 0L) {
            this.field05174 = var2;
         }

         if (sxxx > 0L && var2 - this.field05174 >= sxxx) {
            this.field05175 = (this.field05175 + sx) % var1.size();
            this.field05174 = var2;
         }

         for (int sxxxx = 0; sxxxx < sx; sxxxx++) {
            sxx.add(var1.get((this.field05175 + sxxxx) % var1.size()).method00137().method00497());
         }

         this.method02197(sxx);
      } else {
         for (BotClient sxxx : var1) {
            sxx.add(sxxx.method00137().method00497());
         }

         this.method02197(sxx);
      }
   }

   private void method02197(Set<String> var1) {
      this.field05173.retainAll(var1);
      this.field05173.addAll(var1);
   }

   boolean method02198(BotClient var1) {
      return this.field05173.contains(var1.method00137().method00497());
   }
}
