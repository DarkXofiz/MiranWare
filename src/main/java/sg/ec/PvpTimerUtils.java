// Original binary: sg/ec/Xx1g0pVuuCYkaJ2G
package sg.ec;

import java.util.Collection;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.gui.components.LerpingBossEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.BossEvent;
import sg.mx.BossHealthOverlayMixin;
import sg.mx.PlayerTabOverlayMixin_1198;

// $VF: Compiled from s
public final class PvpTimerUtils implements MinecraftAccess {
   private static final String field14686 = "Анархия-";
   private static final Pattern field14687 = Pattern.compile(PvpTimerUtils.field14697);
   private static final Pattern field14688 = Pattern.compile(PvpTimerUtils.field14698);
   private static final String field14689 = "Анархия-";
   private static final String field14690 = "Анархия-";
   private static final String field14691 = "pvp";
   private static final String field14692 = "пвп";
   private static final String field14693 = "дуэль";
   private static final String field14694 = "pvp";
   private static final String field14695 = "пвп";
   private static final String field14696 = "This is a utility class and cannot be instantiated";
   private static final String field14697 = "(\\d+):(\\d+)";
   private static final String field14698 = "(\\d+)";

   public static int method06496(Collection<? extends BossEvent> var0) {
      for (BossEvent var2 : var0) {
         String sx = var2.getName().getString().toLowerCase(Locale.ROOT);
         if (sx.contains(field14694) || sx.contains(field14695)) {
            Matcher sxx = field14687.matcher(sx);
            if (sxx.find()) {
               return Integer.parseInt(sxx.group(1)) * 60 + Integer.parseInt(sxx.group(2));
            }

            Matcher sxxx = field14688.matcher(sx);
            if (sxxx.find()) {
               return Integer.parseInt(sxxx.group(1));
            }
         }
      }

      return -1;
   }

   public static boolean method06497() {
      return method06501(method06502());
   }

   public static int method06498(String var0) {
      int var1 = var0.indexOf(field14689);
      if (var1 < 0) {
         return -1;
      }

      int var2 = var1 + field14690.length();
      int var3 = var2;

      while (var3 < var0.length() && Character.isDigit(var0.charAt(var3))) {
         var3++;
      }

      return var3 == var2 ? -1 : Integer.parseInt(var0.substring(var2, var3));
   }

   private PvpTimerUtils() {
      throw new UnsupportedOperationException(field14696);
   }

   public static int method06499() {
      return method06498(method06503());
   }

   public static int method06500() {
      return method06496(method06502());
   }

   public static boolean method06501(Collection<? extends BossEvent> var0) {
      for (BossEvent var2 : var0) {
         String var3 = var2.getName().getString().toLowerCase(Locale.ROOT);
         if (var3.contains(field14691) || var3.contains(field14692) || var3.contains(field14693)) {
            return true;
         }
      }

      return false;
   }

   private static Collection<LerpingBossEvent> method06502() {
      return ((BossHealthOverlayMixin)(Object)mc.gui.getBossOverlay()).events().values();
   }

   public static String method06503() {
      if (mc.player != null && mc.player.connection != null) {
         Component var0 = ((PlayerTabOverlayMixin_1198)(Object)mc.gui.getTabList()).getTabHeader();
         return var0 == null ? "" : var0.getString();
      } else {
         return "";
      }
   }
}
