// Original binary: sg/ec/zCrVKHJkso6Y9r1Z
package sg.ec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// $VF: Compiled from s
public final class AutoBuySessionHistory {
   public static final AutoBuySessionHistory field27854 = new AutoBuySessionHistory();
   private static final int field27855 = 200;
   private final Deque<AutoBuySessionHistory.Nested329> field27856 = new ArrayDeque<>();
   private long field27857;

   public boolean method11705() {
      return AutoBuySettings.field19624.method08573();
   }

   public synchronized void method11706() {
      this.field27856.clear();
   }

   public synchronized List<AutoBuySessionHistory.Nested329> method11707(int var1) {
      int var2 = Math.max(0, this.field27856.size() - var1);
      var var3 = new ArrayList(Math.min(var1, this.field27856.size()));
      int var4 = 0;

      for (AutoBuySessionHistory.Nested329 var6 : this.field27856) {
         if (var4++ >= var2) {
            var3.add(var6);
         }
      }

      return var3;
   }

   private AutoBuySessionHistory() {
   }

   public synchronized void method11708(String var1) {
      if (this.method11705() && var1 != null && !var1.isEmpty()) {
         this.field27856.addLast(new AutoBuySessionHistory.Nested329(System.currentTimeMillis() - this.field27857, var1));

         while (this.field27856.size() > 200) {
            this.field27856.removeFirst();
         }
      }
   }

   public synchronized void method11709(long var1) {
      this.field27856.clear();
      this.field27857 = var1;
   }

   // $VF: Compiled from s
   public record Nested329(long sinceStartMs, String text) {
   }
}
