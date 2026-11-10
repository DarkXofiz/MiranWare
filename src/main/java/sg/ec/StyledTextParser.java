// Original binary: sg/ec/xu2vqjy2LMmIndUb
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;

// $VF: Compiled from s
public final class StyledTextParser {
   private static final String field26327 = "This is a utility class and cannot be instantiated";

   public static List<StyledTextParser.Nested322> method11504(String var0) {
      List var1 = new ArrayList<>();
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder sx = new StringBuilder();
         Style sxx = Style.EMPTY;

         for (int sxxx = 0; sxxx < var0.length(); sxxx++) {
            char sxxxx = var0.charAt(sxxx);
            if ((sxxxx == '&' || sxxxx == 167) && sxxx + 1 < var0.length()) {
               char sxxxxx = var0.charAt(sxxx + 1);
               if (sxxxxx == '#' && sxxx + 8 <= var0.length()) {
                  Integer sxxxxxx = method11505(var0.substring(sxxx + 2, sxxx + 8));
                  if (sxxxxxx != null) {
                     method11506(var1, sx, sxx);
                     sxx = sxx.withColor(TextColor.fromRgb(sxxxxxx));
                     sxxx += 7;
                     continue;
                  }
               }

               ChatFormatting sxxxxxx = ChatFormatting.getByCode(sxxxxx);
               if (sxxxxxx == null) {
                  sx.append(sxxxx);
               } else {
                  method11506(var1, sx, sxx);
                  sxx = sxxxxxx == ChatFormatting.RESET ? Style.EMPTY : sxx.applyFormat(sxxxxxx);
                  sxxx++;
               }
            } else {
               sx.append(sxxxx);
            }
         }

         method11506(var1, sx, sxx);
         return var1;
      } else {
         return var1;
      }
   }

   private static Integer method11505(String var0) {
      try {
         return Integer.parseInt(var0, 16);
      } catch (NumberFormatException var2) {
         return null;
      }
   }

   private StyledTextParser() {
      throw new UnsupportedOperationException(field26327);
   }

   private static void method11506(List<StyledTextParser.Nested322> var0, StringBuilder var1, Style var2) {
      if (!var1.isEmpty()) {
         var0.add(new StyledTextParser.Nested322(var1.toString(), var2));
         var1.setLength(0);
      }
   }

   public static String method11507(String var0) {
      StringBuilder var1 = new StringBuilder();

      for (StyledTextParser.Nested322 var3 : method11504(var0)) {
         var1.append(var3.text());
      }

      return var1.toString();
   }

   public static MutableComponent method11508(String var0) {
      MutableComponent var1 = Component.empty();

      for (StyledTextParser.Nested322 var3 : method11504(var0)) {
         var1.append(Component.literal(var3.text()).setStyle(var3.style()));
      }

      return var1;
   }

   // $VF: Compiled from s
   public record Nested322(String text, Style style) {
      public int color(int var1) {
         TextColor var2 = this.style.getColor();
         return var2 == null ? var1 : 0xFF000000 | var2.getValue();
      }
   }
}
