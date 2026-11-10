// Original binary: sg/ec/YeGqbAAMj9fPk5Ay
package sg.ec;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AuctionLoreParser {
   private static final Pattern field14826 = Pattern.compile(AuctionLoreParser.field14829);
   private static final String field14827 = ",";
   private static final String field14828 = ", ";
   private static final String field14829 = "\\$\\s*.*?(\\d{1,3}(?:,\\d{3})*).*?\\?\\s*.*?:\\s*([A-Za-z0-9_]{3,16})";

   private AuctionLoreParser() {
   }

   private static Matcher method06596(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         var var1 = ItemTooltipUtils.method02660(var0);
         if (var1.isEmpty()) {
            return null;
         }

         StringBuilder var2 = new StringBuilder();

         for (Component var4 : var1) {
            if (!var2.isEmpty()) {
               var2.append(field14828);
            }

            var2.append(ItemTooltipUtils.method02659(var4.getString()));
         }

         Matcher var5 = field14826.matcher(var2);
         return var5.find() ? var5 : null;
      } else {
         return null;
      }
   }

   public static String method06597(ItemStack var0) {
      Matcher var1 = method06596(var0);
      return var1 == null ? null : var1.group(2);
   }

   public static Long method06598(ItemStack var0) {
      Matcher var1 = method06596(var0);
      if (var1 == null) {
         return null;
      }

      try {
         long var2 = Long.parseLong(var1.group(1).replace(field14827, ""));
         return var2 > 0L ? var2 : null;
      } catch (NumberFormatException var4) {
         return null;
      }
   }
}
