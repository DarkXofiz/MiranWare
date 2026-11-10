// Original binary: sg/ec/y2HQaPg3t3aj8GY3
package sg.ec;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.ToIntFunction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.component.ItemContainerContents;

// $VF: Compiled from s
public final class AutoBuyItemMatcher implements MinecraftAccess {
   private static final float field26368 = 100.0F;
   private static final String field26369 = "продавец в чёрном списке";
   private static final String field26370 = "прочность %.1f%% ниже минимальной %.1f%% (%s)";
   private static final String field26371 = "достигнут лимит тотемов в инвентаре";

   private static boolean method11529(ItemStack var0, ToIntFunction<Item> var1) {
      int var2 = AutoBuySettings.field19624.method08554();
      return var2 > 0 && var0.getItem() == Items.TOTEM_OF_UNDYING ? var1.applyAsInt(Items.TOTEM_OF_UNDYING) < var2 : true;
   }

   private static String method11530(AutoBuyServer var0, AutoBuyItem var1, ItemStack var2, Long var3) {
      String var4 = var1.method10673();
      if (!var1.method10672()) {
         return "выключен в списке (" + var4 + ")";
      }

      if (var1.method10682() <= 0) {
         return "не задана максимальная цена (" + var4 + ")";
      }

      String var5 = var1.method10705(var2);
      if (var5 != null) {
         return var5 + " (" + var4 + ")";
      }

      if (!var1.method10726(var2)) {
         return String.format(Locale.ROOT, field26370, AutoBuyItem.method10679(var2), var1.method10733(), var4);
      }

      if (!method11529(var2, AutoBuyItemMatcher::method11532)) {
         return field26371;
      }

      if (var3 == null) {
         return "не удалось прочитать цену лота (" + var4 + ")";
      }

      if (method11534(var0, var3, CoinBalanceReader.method00045())) {
         return "цена " + var3 + "$ выше баланса " + CoinBalanceReader.method00045() + "$ (" + var4 + ")";
      }

      if (var1.method10735()) {
         long var8 = method11538(var0, var2);
         if (var8 <= 0L) {
            return "содержимое не имеет ценности (" + var4 + ")";
         } else {
            return var3 > var8 ? "цена " + var3 + "$ выше ценности содержимого " + var8 + "$ (" + var4 + ")" : null;
         }
      } else {
         long var6 = var3 / Math.max(1, var2.getCount());
         if (var6 >= var1.method10682()) {
            return "цена за штуку " + var6 + "$ не ниже лимита " + var1.method10682() + "$ (" + var4 + ")";
         } else if (var6 <= var1.method10699()) {
            return "цена за штуку " + var6 + "$ ниже порога " + var1.method10699() + "$ (" + var4 + ")";
         } else if (AutoBuySettings.field19624.method08552() && !method11545(var1, var6)) {
            return var1.method10731() <= 0
               ? "режим окупа: рыночная цена не просканирована (" + var4 + ")"
               : "режим окупа: нужно не дороже " + method11546(var1) + "$ за штуку (" + var4 + ")";
         } else {
            return null;
         }
      }
   }

   public static boolean method11531(ItemStack var0) {
      return BlockedSellerRegistry.field08823.method03969() ? false : BlockedSellerRegistry.field08823.method03970(AuctionItemText.method04155(var0));
   }

   private static int method11532(Item var0) {
      if (mc.player == null) {
         return 0;
      }

      Inventory var1 = mc.player.getInventory();
      int var2 = 0;

      for (int var3 = 0; var3 < var1.getContainerSize(); var3++) {
         ItemStack var4 = var1.getItem(var3);
         if (var4 != null && !var4.isEmpty() && var4.getItem() == var0) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   public static boolean method11533(AutoBuyServer var0, AutoBuyItem var1, ItemStack var2, long var3, Long var5) {
      if (method11534(var0, var3, var5)) {
         return false;
      } else if (var1.method10735()) {
         long var8 = method11538(var0, var2);
         return var8 > 0L && var3 <= var8;
      } else {
         long var6 = var3 / Math.max(1, var2.getCount());
         return var1.method10723(var6) && method11545(var1, var6);
      }
   }

   private static boolean method11534(AutoBuyServer var0, long var1, Long var3) {
      return var0 == AutoBuyServer.FUN_TIME && var3 != null && var1 > var3;
   }

   public static Optional<AutoBuyItem> method11535(AutoBuyServer var0, ItemStack var1, ToIntFunction<Item> var2) {
      if (var1 != null && !var1.isEmpty() && !method11531(var1)) {
         for (AutoBuyItem var4 : AutoBuyItemRegistry.INSTANCE.method10993(var0, var1.getItem())) {
            if (var4.method10706() && var4.method10721(var1) && var4.method10726(var1) && method11529(var1, var2)) {
               return Optional.of(var4);
            }
         }

         return Optional.empty();
      } else {
         return Optional.empty();
      }
   }

   private static long method11536(AutoBuyServer var0, ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         for (AutoBuyItem var3 : AutoBuyItemRegistry.INSTANCE.method10993(var0, var1.getItem())) {
            if (var3.method10706() && !var3.method10735() && var3.method10721(var1)) {
               return (long)var3.method10682() * Math.max(1, var1.getCount());
            }
         }

         return 0L;
      } else {
         return 0L;
      }
   }

   public static boolean method11537(AutoBuyServer var0, Item var1) {
      return !AutoBuyItemRegistry.INSTANCE.method10993(var0, var1).isEmpty();
   }

   public static long method11538(AutoBuyServer var0, ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         long var2 = 0L;
         ItemContainerContents var4 = var1.get(DataComponents.CONTAINER);
         if (var4 != null) {
            var2 += var4.nonEmptyStream().mapToLong(var1x -> method11536(var0, var1x)).sum();
         }

         BundleContents var5 = var1.get(DataComponents.BUNDLE_CONTENTS);
         if (var5 != null) {
            var2 += java.util.stream.StreamSupport.stream(var5.items().spliterator(), false).mapToLong(var1x -> method11536(var0, var1x)).sum();
         }

         return var2;
      } else {
         return 0L;
      }
   }

   public static long method11540(AutoBuyServer var0, AutoBuyItem var1, ItemStack var2) {
      return var1.method10735() ? method11538(var0, var2) : (long)var1.method10682() * Math.max(1, var2.getCount());
   }

   private AutoBuyItemMatcher() {
   }

   public static long method11541(AutoBuyItem var0, ItemStack var1) {
      return (long)var0.method10731() * Math.max(1, var1.getCount());
   }

   public static String method11542(AutoBuyServer var0, ItemStack var1, Long var2) {
      if (var1 != null && !var1.isEmpty()) {
         var var3 = AutoBuyItemRegistry.INSTANCE.method10993(var0, var1.getItem());
         if (var3.isEmpty()) {
            return null;
         }

         if (method11531(var1)) {
            return field26369;
         }

         for (AutoBuyItem var5 : var3) {
            String var6 = method11530(var0, var5, var1, var2);
            if (var6 != null) {
               return var6;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public static boolean method11544(AutoBuyServer var0, AutoBuyItem var1, ItemStack var2, long var3) {
      return method11533(var0, var1, var2, var3, CoinBalanceReader.method00045());
   }

   private static boolean method11545(AutoBuyItem var0, long var1) {
      AutoBuySettings var3 = AutoBuySettings.field19624;
      return !var3.method08552() ? true : var0.method10731() > 0 && var1 <= method11546(var0);
   }

   public static long method11546(AutoBuyItem var0) {
      float var1 = 1.0F - AutoBuySettings.field19624.method08538() / field26368;
      return Math.max(1L, Math.round(var0.method10731() * var1));
   }

   public static Optional<AutoBuyItem> method11547(AutoBuyServer var0, ItemStack var1) {
      return method11535(var0, var1, AutoBuyItemMatcher::method11532);
   }
}
