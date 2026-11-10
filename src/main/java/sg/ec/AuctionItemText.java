// Original binary: sg/ec/K8lA5JHvGyXCr59a
package sg.ec;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AuctionItemText {
   private static final String[] field09357 = method04153(
      AuctionItemText.field09358,
      AuctionItemText.field09359,
      AuctionItemText.field09360,
      AuctionItemText.field09361,
      AuctionItemText.field09362,
      AuctionItemText.field09363,
      AuctionItemText.field09364,
      AuctionItemText.field09365,
      AuctionItemText.field09366,
      AuctionItemText.field09367,
      AuctionItemText.field09368,
      AuctionItemText.field09369
   );
   private static final String field09358 = "продавец:";
   private static final String field09359 = "продавец ";
   private static final String field09360 = "продаёт:";
   private static final String field09361 = "продаёт ";
   private static final String field09362 = "продает:";
   private static final String field09363 = "продает ";
   private static final String field09364 = "владелец:";
   private static final String field09365 = "владелец ";
   private static final String field09366 = "выставил:";
   private static final String field09367 = "выставил ";
   private static final String field09368 = "ник:";
   private static final String field09369 = "ник ";

   private static String method04152(String var0) {
      String var1 = var0 == null ? "" : var0.trim();

      while (!var1.isEmpty() && !method04154(var1.charAt(0))) {
         var1 = var1.substring(1).trim();
      }

      int sx = 0;

      while (sx < var1.length() && method04154(var1.charAt(sx))) {
         sx++;
      }

      return sx == 0 ? "" : var1.substring(0, sx);
   }

   private static String[] method04153(String... var0) {
      String[] var1 = new String[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = UnicodeTextNormalizer.method09496(var0[var2]);
      }

      return var1;
   }

   private AuctionItemText() {
   }

   private static boolean method04154(char var0) {
      return Character.isLetterOrDigit(var0) || var0 == '_';
   }

   public static String method04155(ItemStack var0) {
      for (Component var2 : ItemTooltipUtils.method02660(var0)) {
         String var3 = method04156(ItemTooltipUtils.method02659(var2.getString()));
         if (!var3.isEmpty()) {
            return var3;
         }
      }

      return "";
   }

   public static String method04156(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.trim();
         String var2 = UnicodeTextNormalizer.method09496(var1);

         for (String var6 : field09357) {
            int var7 = var2.indexOf(var6);
            if (var7 >= 0) {
               String var8 = method04152(var1.substring(var7 + var6.length()));
               if (!var8.isEmpty()) {
                  return var8;
               }
            }
         }

         return "";
      } else {
         return "";
      }
   }
}
