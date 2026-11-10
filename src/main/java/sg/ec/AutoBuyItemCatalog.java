// Original binary: sg/ec/R4quLAJWmfzWIT1F
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AutoBuyItemCatalog {
   private static final float field11386 = 100.0F;
   private static final long field11387 = 2147483647L;
   private static final long field11388 = 2147483647L;

   public static boolean method05255(AutoBuyItem var0, ItemStack var1) {
      if (var0.method10721(var1)) {
         return true;
      } else if (!var0.method10739() && var1.getItem() == var0.method10693()) {
         String var2 = var1.getHoverName() == null ? "" : var1.getHoverName().getString();
         return !var2.isEmpty() && var2.toLowerCase(Locale.ROOT).contains(var0.method10673().toLowerCase(Locale.ROOT));
      } else {
         return false;
      }
   }

   public static Long method05256(ItemStack var0) {
      Long var1 = AuctionPriceParser.method09587(var0);
      if (var1 != null && var1 > 0L) {
         return var1;
      }

      Long var2 = AuctionPriceParser.method09581(var0);
      if (var2 != null && var2 > 0L) {
         return var2;
      }

      Long var3 = AuctionLoreParser.method06598(var0);
      return var3 == null ? null : var3 / Math.max(1, var0.getCount());
   }

   public static List<AutoBuyItem> method05257() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = new ArrayList();

      for (AutoBuyItem var3 : AutoBuyItemRegistry.INSTANCE.method10988()) {
         if (!var3.method10735() && var3.method10673() != null && !var3.method10673().isBlank()) {
            (var3.method10672() ? var0 : var1).add(var3);
         }
      }

      return var0.isEmpty() ? var1 : var0;
   }

   private AutoBuyItemCatalog() {
   }

   public static long method05258(AutoBuyItem var0, long var1) {
      float var3 = var0.method10715() ? var0.method10718() : AutoBuySettings.field19624.method08574();
      long var4 = Math.max(1L, Math.round((float)var1 * (var3 / field11386)));
      var0.method10669((int)Math.min(field11387, var4));
      var0.method10674((int)Math.min(field11388, var1));
      AutoBuyItemRegistry.INSTANCE.method10994();
      return var4;
   }
}
