// Original binary: sg/ec/DoBiffFbbuQfeKEm
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class PurchaseHistory {
   public static final PurchaseHistory field06969 = new PurchaseHistory();
   private static final int field06970 = 100;
   private final List<PurchaseHistory.Nested87> field06971 = new ArrayList<>();
   private ItemStack field06972 = ItemStack.EMPTY;
   private String field06973 = "";
   private long field06974;
   private long field06975;
   private AutoBuyServer field06976 = AutoBuyServer.HOLY_WORLD;
   private long field06977;
   private int field06978;

   public long method03135() {
      return this.field06977;
   }

   public synchronized PurchaseHistory.Nested87 method03136(ItemStack var1, long var2, long var4, long var6, String var8, AutoBuyServer var9) {
      PurchaseHistory.Nested87 var10 = new PurchaseHistory.Nested87(
         var1.copy(), var1.getHoverName().getString(), Math.max(0L, var2), var4, var6, var8 == null ? "" : var8.trim(), System.currentTimeMillis(), var9
      );
      this.field06971.add(0, var10);

      while (this.field06971.size() > 100) {
         this.field06971.remove(this.field06971.size() - 1);
      }

      this.field06977 = this.field06977 + var10.paidPrice();
      this.field06978++;
      return var10;
   }

   public synchronized boolean method03137() {
      return !this.field06972.isEmpty();
   }

   private PurchaseHistory() {
   }

   public int method03138() {
      return this.field06978;
   }

   public synchronized List<PurchaseHistory.Nested87> method03139() {
      return List.copyOf(this.field06971);
   }

   public synchronized PurchaseHistory.Nested87 method03140(long var1, String var3) {
      if (this.field06972.isEmpty()) {
         return null;
      }

      String var4 = var3 != null && !var3.isBlank() ? var3.trim() : this.field06973;
      PurchaseHistory.Nested87 var5 = this.method03136(this.field06972, var1, this.field06974, this.field06975, var4, this.field06976);
      this.method03146();
      return var5;
   }

   public synchronized void method03141(ItemStack var1, String var2, long var3, long var5) {
      if (var1 != null && !var1.isEmpty()) {
         this.field06972 = var1.copy();
         this.field06973 = var2 == null ? "" : var2.trim();
         this.field06974 = Math.max(0L, var3);
         this.field06975 = Math.max(0L, var5);
         this.field06976 = AutoBuyItemRegistry.INSTANCE.method10998();
      } else {
         this.method03146();
      }
   }

   public synchronized List<PurchaseHistory.Nested87> method03142(AutoBuyServer var1) {
      ArrayList var2 = new ArrayList();

      for (PurchaseHistory.Nested87 var4 : this.field06971) {
         if (var4.server() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public synchronized void method03143(List<PurchaseHistory.Nested87> var1) {
      this.field06971.clear();
      this.field06977 = 0L;
      this.field06978 = 0;
      if (var1 != null) {
         for (PurchaseHistory.Nested87 var3 : var1) {
            if (var3 != null && !var3.stack().isEmpty() && this.field06971.size() < 100) {
               this.field06971.add(var3);
               this.field06977 = this.field06977 + var3.paidPrice();
               this.field06978++;
            }
         }
      }
   }

   public synchronized boolean method03144(PurchaseHistory.Nested87 var1) {
      if (var1 != null && this.field06971.remove(var1)) {
         this.field06977 = Math.max(0L, this.field06977 - var1.paidPrice());
         this.field06978 = Math.max(0, this.field06978 - 1);
         return true;
      } else {
         return false;
      }
   }

   public synchronized void method03145() {
      this.field06971.clear();
      this.field06977 = 0L;
      this.field06978 = 0;
   }

   public synchronized void method03146() {
      this.field06972 = ItemStack.EMPTY;
      this.field06973 = "";
      this.field06974 = 0L;
      this.field06975 = 0L;
   }

   // $VF: Compiled from s
   public record Nested87(
      ItemStack stack, String name, long paidPrice, long priceCeiling, long marketPrice, String seller, long timestamp, AutoBuyServer server
   ) {
      public long profit() {
         return Math.max(0L, this.reference() - this.paidPrice);
      }

      public float payback() {
         return this.paidPrice > 0L && this.reference() > 0L ? (float)this.reference() / (float)this.paidPrice : 0.0F;
      }

      public long reference() {
         return this.marketPrice > 0L ? this.marketPrice : this.priceCeiling;
      }

      public boolean hasMarketPrice() {
         return this.marketPrice > 0L;
      }
   }
}
