// Original binary: sg/ec/mupglY4J0XPTcuZq
package sg.ec;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

// $VF: Compiled from s
public final class AuctionPriceParser {
   public static final String field21789 = "Цена за 1 ед.:";
   private static final char field21790 = ' ';
   private static final char field21791 = ' ';
   private static final char field21792 = ' ';
   private static final char field21793 = ' ';
   private static final char field21794 = ' ';
   private static final String[] field21795 = new String[]{
      UnicodeTextNormalizer.method09496(AuctionPriceParser.field21797),
      UnicodeTextNormalizer.method09496(AuctionPriceParser.field21798),
      UnicodeTextNormalizer.method09496(AuctionPriceParser.field21799),
      UnicodeTextNormalizer.method09496(AuctionPriceParser.field21800)
   };
   private static final String field21796 = "Цена за 1 ед.:";
   private static final String field21797 = "цена:";
   private static final String field21798 = "цена";
   private static final String field21799 = "price:";
   private static final String field21800 = "price";

   private AuctionPriceParser() {
   }

   public static Long method09581(ItemStack var0) {
      Long var1 = method09594(var0);
      return var1 == null ? null : Math.max(1L, var1 / Math.max(1, var0.getCount()));
   }

   public static Long method09582(String var0, int var1) {
      return method09584(var0, var1);
   }

   private static long method09583(StringBuilder var0) {
      Long var1 = method09592(var0);
      var0.setLength(0);
      return var1 == null ? 0L : var1;
   }

   private static Long method09584(String var0, int var1) {
      if (var0 != null && var1 >= 0 && var1 < var0.length()) {
         StringBuilder var2 = new StringBuilder();

         for (int var3 = var1; var3 < var0.length(); var3++) {
            char var4 = var0.charAt(var3);
            if (var4 >= '0' && var4 <= '9') {
               var2.append(var4);
            } else if (!method09585(var4)) {
               if (!var2.isEmpty()) {
                  break;
               }

               if (var4 != '$' && var4 != 164 && !Character.isSpaceChar(var4) && !Character.isWhitespace(var4) && !method09586(var4)) {
                  return null;
               }
            }
         }

         return method09592(var2);
      } else {
         return null;
      }
   }

   private static boolean method09585(char var0) {
      return var0 == ',' || var0 == ' ' || var0 == 160 || var0 == 8239 || var0 == 8201 || var0 == 8207;
   }

   private static boolean method09586(char var0) {
      return var0 == ':' || var0 == 187 || var0 == 9654 || var0 == 8226 || var0 == '-';
   }

   public static Long method09587(ItemStack var0) {
      return method09593(var0, field21796);
   }

   private static Long method09588(String var0, int var1) {
      StringBuilder var2 = new StringBuilder();

      for (int var3 = var1 - 1; var3 >= 0; var3--) {
         char var4 = var0.charAt(var3);
         if (var4 >= '0' && var4 <= '9') {
            var2.insert(0, var4);
         } else if (!method09585(var4) || var2.isEmpty()) {
            break;
         }
      }

      return method09592(var2);
   }

   private static int method09589(String var0) {
      int var1 = var0.indexOf(36);
      return var1 >= 0 ? var1 : var0.indexOf(164);
   }

   private static Long method09590(String var0) {
      long var1 = 0L;
      StringBuilder var3 = new StringBuilder();

      for (int var4 = 0; var4 < var0.length(); var4++) {
         char var5 = var0.charAt(var4);
         if (var5 >= '0' && var5 <= '9') {
            var3.append(var5);
         } else if (!method09585(var5) || var3.isEmpty()) {
            var1 = Math.max(var1, method09583(var3));
         }
      }

      var1 = Math.max(var1, method09583(var3));
      return var1 > 0L ? var1 : null;
   }

   private static Long method09591(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         String var1 = UnicodeTextNormalizer.method09496(var0);

         for (String var5 : field21795) {
            int var6 = var1.indexOf(var5);
            if (var6 >= 0) {
               Long var7 = method09584(var0, var6 + var5.length());
               if (var7 != null) {
                  return var7;
               }
            }
         }

         int var8 = method09589(var0);
         if (var8 < 0) {
            return null;
         }

         Long var9 = method09584(var0, var8 + 1);
         if (var9 != null) {
            return var9;
         }

         Long var10 = method09588(var0, var8);
         return var10 != null ? var10 : method09590(var0);
      } else {
         return null;
      }
   }

   private static Long method09592(StringBuilder var0) {
      if (var0.isEmpty()) {
         return null;
      }

      try {
         long var1 = Long.parseLong(var0.toString());
         return var1 <= 0L ? null : var1;
      } catch (NumberFormatException var3) {
         return null;
      }
   }

   public static Long method09593(ItemStack var0, String var1) {
      String var2 = UnicodeTextNormalizer.method09496(var1);

      for (Component var4 : ItemTooltipUtils.method02658(var0)) {
         String var5 = ItemTooltipUtils.method02659(var4.getString());
         int var6 = UnicodeTextNormalizer.method09496(var5).indexOf(var2);
         if (var6 >= 0) {
            Long var7 = method09584(var5, var6 + var2.length());
            if (var7 != null) {
               return var7;
            }
         }
      }

      return null;
   }

   public static Long method09594(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         Long var1 = null;

         for (Component var3 : ItemTooltipUtils.method02660(var0)) {
            Long var4 = method09591(ItemTooltipUtils.method02659(var3.getString()));
            if (var4 != null && (var1 == null || var4 < var1)) {
               var1 = var4;
            }
         }

         if (var1 != null) {
            return var1;
         }

         Component var5 = var0.getHoverName();
         if (var5 != null) {
            Long var6 = method09591(ItemTooltipUtils.method02659(var5.getString()));
            if (var6 != null) {
               return var6;
            }
         }

         CustomData var7 = var0.get(DataComponents.CUSTOM_DATA);
         return var7 == null ? null : method09591(ItemTooltipUtils.method02659(var7.copyTag().toString()));
      } else {
         return null;
      }
   }
}
