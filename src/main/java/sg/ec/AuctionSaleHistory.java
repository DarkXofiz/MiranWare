// Original binary: sg/ec/FOLZ7T1OA9YVMJKE
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AuctionSaleHistory {
   public static final AuctionSaleHistory field07563 = new AuctionSaleHistory();
   private static final int field07564 = 100;
   private final List<AuctionSaleHistory.Nested94> field07565 = new ArrayList<>();
   private long field07566;

   public synchronized void method03353(List<AuctionSaleHistory.Nested94> var1) {
      this.field07565.clear();
      this.field07566 = 0L;
      if (var1 != null) {
         for (AuctionSaleHistory.Nested94 var3 : var1) {
            if (var3 != null && !var3.stack().isEmpty() && this.field07565.size() < 100) {
               this.field07565.add(var3);
               if (var3.isSold()) {
                  this.field07566 = this.field07566 + var3.askPrice();
               }
            }
         }
      }
   }

   public synchronized AuctionSaleHistory.Nested94 method03354(AuctionSaleParser.Nested139 var1) {
      if (var1 == null) {
         return null;
      }

      int var2 = this.method03361(var1.item());
      if (var2 < 0) {
         return null;
      }

      AuctionSaleHistory.Nested94 var3 = this.field07565.get(var2);
      long var4 = var1.price() > 0L ? var1.price() : var3.askPrice();
      AuctionSaleHistory.Nested94 var6 = new AuctionSaleHistory.Nested94(
         var3.stack(), var3.name(), var4, var3.paidPrice(), var1.buyer(), var3.listedAtMs(), System.currentTimeMillis(), var3.server()
      );
      this.field07565.set(var2, var6);
      this.field07566 += var4;
      return var6;
   }

   private AuctionSaleHistory() {
   }

   public synchronized void method03355() {
      this.field07565.clear();
      this.field07566 = 0L;
   }

   public synchronized List<AuctionSaleHistory.Nested94> method03356(AutoBuyServer var1) {
      ArrayList var2 = new ArrayList();

      for (AuctionSaleHistory.Nested94 var4 : this.field07565) {
         if (var4.server() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public synchronized List<AuctionSaleHistory.Nested94> method03357() {
      return List.copyOf(this.field07565);
   }

   public long method03358() {
      return this.field07566;
   }

   public synchronized void method03359(ItemStack var1, String var2, long var3, long var5, AutoBuyServer var7) {
      if (var1 != null && !var1.isEmpty()) {
         this.field07565
            .add(
               0,
               new AuctionSaleHistory.Nested94(
                  var1.copy(),
                  var2 == null ? var1.getHoverName().getString() : var2,
                  Math.max(0L, var3),
                  Math.max(0L, var5),
                  "",
                  System.currentTimeMillis(),
                  0L,
                  var7
               )
            );

         while (this.field07565.size() > 100) {
            this.field07565.remove(this.field07565.size() - 1);
         }
      }
   }

   public synchronized boolean method03360(AuctionSaleHistory.Nested94 var1) {
      if (var1 != null && this.field07565.remove(var1)) {
         if (var1.isSold()) {
            this.field07566 = Math.max(0L, this.field07566 - var1.askPrice());
         }

         return true;
      } else {
         return false;
      }
   }

   private int method03361(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);

      for (int var3 = 0; var3 < this.field07565.size(); var3++) {
         AuctionSaleHistory.Nested94 var4 = this.field07565.get(var3);
         if (!var4.isSold()) {
            String var5 = var4.name().toLowerCase(Locale.ROOT);
            if (var2.contains(var5) || var5.contains(var2)) {
               return var3;
            }
         }
      }

      return -1;
   }

   // $VF: Compiled from s
   public record Nested94(ItemStack stack, String name, long askPrice, long paidPrice, String buyer, long listedAtMs, long soldAtMs, AutoBuyServer server) {
      public boolean isSold() {
         return this.soldAtMs > 0L;
      }

      public long profit() {
         return this.isSold() ? this.askPrice - this.paidPrice : 0L;
      }
   }
}
