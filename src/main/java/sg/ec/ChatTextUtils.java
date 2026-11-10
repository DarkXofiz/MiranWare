// Original binary: sg/ec/PneC1644Zr7bDEa4
package sg.ec;

import java.util.IllegalFormatException;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.util.FormattedCharSequence;

// $VF: Compiled from s
public final class ChatTextUtils implements MinecraftAccess {
   private static final int field11147 = 2;
   private static final int field11148 = 0;
   private static final String field11149 = "Miran";
   private static final String field11150 = " » ";
   private static final String field11151 = " ";
   private static final String field11152 = " ";
   private static final String field11153 = " » ";
   private static final String field11154 = "Object is null";
   private static final String field11155 = "Miran";
   private static final String field11156 = " » ";
   private static final String field11157 = " » ";
   private static final String field11158 = "Object is null";
   private static final String field11159 = "Object is null";
   private static final int field11160 = Integer.MAX_VALUE;
   private static final String field11161 = "This is a utility class and cannot be instantiated";

   public static void method05075(MutableComponent var0, Object var1, Object... var2) {
      if (!method05084()) {
         if (var1 == null) {
            method05086(field11154);
         } else {
            String var3 = method05094(var1.toString(), var2).replace('&', '§');
            MutableComponent sx = Component.literal(var3);
            MutableComponent sxx = var0.copy();
            MutableComponent sxxx = sxx.append(sx);
            method05092(sxxx);
         }
      }
   }

   public static String method05076(FormattedCharSequence var0) {
      StringBuilder var1 = new StringBuilder();
      var0.accept((var1x, var2, var3) -> {
         var1.append(Character.toChars(var3));
         return true;
      });
      return var1.toString();
   }

   public static MutableComponent method05078(String var0, int var1, int var2, int var3) {
      return method05100(var0, var1, var2, var3, field11160, false);
   }

   public static void method05080(Object var0, Object... var1) {
      InventoryActionManager.INSTANCE.method10470(() -> method05083(var0, var1), 2, false);
   }

   public static void method05081(String var0, String var1, Object var2, Object... var3) {
      method05095(var0, null, var1, var2, var3);
   }

   private static void method05083(Object var0, Object... var1) {
      InventoryActionManager.INSTANCE.method10477(() -> method05091(var0, var1));
   }

   private static boolean method05084() {
      return mc.player == null;
   }

   public static MutableComponent method05085(String var0, int... var1) {
      if (var0 != null && !var0.isEmpty() && var1 != null && var1.length != 0) {
         if (var1.length == 1) {
            int var8 = var1[0];
            return Component.literal(var0).setStyle(Style.EMPTY.withColor(var8));
         }

         MutableComponent var2 = Component.empty();
         int var3 = var0.length();
         int var4 = var1.length;

         for (int var5 = 0; var5 < var3; var5++) {
            float var6 = (float)var5 / Math.max(1, var3 - 1);
            int var7 = method05102(var1, var6, var4);
            var2.append(Component.literal(String.valueOf(var0.charAt(var5))).setStyle(Style.EMPTY.withColor(var7)));
         }

         return var2;
      } else {
         return Component.empty();
      }
   }

   public static void method05086(Object var0, Object... var1) {
      method05101(field11149, var0, var1);
   }

   public static MutableComponent method05088(String var0, int var1, int var2, int var3) {
      return method05100(var0, var1, var2, var3, 10, false);
   }

   private ChatTextUtils() {
      throw new UnsupportedOperationException(field11161);
   }

   public static void method05090(Component var0) {
      if (!method05084()) {
         if (var0 == null) {
            method05086(field11158);
         } else {
            method05092(var0);
         }
      }
   }

   private static void method05091(Object var0, Object... var1) {
      if (!method05084()) {
         if (var0 == null) {
            method05086(field11159);
         } else {
            String var2 = method05094(var0.toString(), var1).replace('§', '&').trim();
            if (!var2.isEmpty()) {
               if (var2.charAt(0) == '/') {
                  String var3 = var2.substring(1).trim();
                  if (!var3.isEmpty()) {
                     mc.player.connection.sendCommand(var3);
                  }
               } else {
                  mc.player.connection.sendChat(var2);
               }
            }
         }
      }
   }

   private static void method05092(Component var0) {
      if (!mc.isSameThread()) {
         mc.execute(() -> method05092(var0));
      } else {
         ChatMessagePolicy.method04008(var0);
         mc.gui.getChat().addClientSystemMessage(var0);
      }
   }

   public static void method05093(Object var0, Runnable var1, Object... var2) {
      int var3 = ThreadLocalRandom.current().nextInt(2, 4);
      InventoryActionManager.INSTANCE.method10470(() -> {
         if (!method05084() && var1 != null) {
            var1.run();
         }
      }, 2, false).method07542(var3, true).method07534(() -> method05083(var0, var2), 2, false);
   }

   private static String method05094(String var0, Object... var1) {
      if (var1 != null && var1.length != 0) {
         try {
            return var0.formatted(var1);
         } catch (IllegalFormatException var3) {
            return var0;
         }
      } else {
         return var0;
      }
   }

   public static void method05095(String var0, Component var1, String var2, Object var3, Object... var4) {
      String var5 = method05094(var2, var4).replace('&', '§');
      MutableComponent var6 = method05100(var0, ColorUtils.Nested138.method04636(), ColorUtils.Nested138.method04637(), 35, 10, true)
         .append(field11151);
      if (var1 != null) {
         var6.append(var1).append(field11152);
      }

      method05075(
         var6.append(var5)
            .append(Component.literal(field11153).withStyle(ChatFormatting.DARK_GRAY))
            .append(Component.literal("").withStyle(ChatFormatting.RESET)),
         var3,
         var4
      );
   }

   public static void method05096(String var0, Component var1) {
      if (!method05084()) {
         MutableComponent var2 = method05100(var0, ColorUtils.Nested138.method04636(), ColorUtils.Nested138.method04637(), 35, 10, true)
            .append(Component.literal(field11157).withStyle(ChatFormatting.DARK_GRAY));
         method05092(var2.append(var1));
      }
   }

   public static MutableComponent method05097(String var0, int var1, int var2, int var3, int var4) {
      return method05100(var0, var1, var2, var3, var4, false);
   }

   public static void method05098(Component var0) {
      if (!method05084()) {
         method05092(
            method05100(field11155, ColorUtils.Nested138.method04636(), ColorUtils.Nested138.method04637(), 35, 10, true)
               .withStyle(ChatFormatting.BOLD)
               .append(Component.literal(field11156).withStyle(ChatFormatting.DARK_GRAY))
               .append(var0)
               .withStyle(ChatFormatting.RESET)
         );
      }
   }

   public static MutableComponent method05100(String var0, int var1, int var2, int var3, int var4, boolean var5) {
      MutableComponent var6 = Component.literal("");

      for (int var7 = 0; var7 < var0.length(); var7++) {
         char var8 = var0.charAt(var7);
         MutableComponent var9 = Component.literal(String.valueOf(var8));
         int var10 = ColorUtils.method04613(var4, var7 * var3, var1, var2);
         Style var11 = Style.EMPTY.withColor(TextColor.fromRgb(var10)).withBold(var5);
         var9.setStyle(var11);
         var6.append(var9);
      }

      return var6;
   }

   public static void method05101(String var0, Object var1, Object... var2) {
      method05075(
         method05100(var0, ColorUtils.Nested138.method04636(), ColorUtils.Nested138.method04637(), 35, 10, true)
            .append(Component.literal(field11150).withStyle(ChatFormatting.DARK_GRAY))
            .append(Component.literal("").withStyle(ChatFormatting.RESET)),
         var1,
         var2
      );
   }

   private static int method05102(int[] var0, float var1, int var2) {
      return ColorUtils.method04586(var1, var0);
   }
}
