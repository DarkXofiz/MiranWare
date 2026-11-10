// Original binary: sg/ec/0GtDckXxF2pVJZCO
package sg.ec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;

// $VF: Compiled from s
public final class CoinBalanceReader implements MinecraftAccess {
   private static final String field00087 = "Монет:";
   private static final Pattern field00088 = Pattern.compile(CoinBalanceReader.field00093);
   private static final Pattern field00089 = Pattern.compile(CoinBalanceReader.field00094);
   private static final String field00090 = "Монет:";
   private static final String field00091 = "Монет:";
   private static final String field00092 = "Монет:";
   private static final String field00093 = "[,.\\s  ]";
   private static final String field00094 = "\\d+";

   private static Long method00043(String var0) {
      if (var0 == null) {
         return null;
      }

      Matcher var1 = field00089.matcher(field00088.matcher(var0).replaceAll(""));
      if (!var1.find()) {
         return null;
      }

      try {
         return Long.parseLong(var1.group());
      } catch (NumberFormatException sx) {
         return null;
      }
   }

   private static String method00044(Scoreboard var0, String var1) {
      Objective var2 = var0.getDisplayObjective(DisplaySlot.SIDEBAR);
      if (var2 == null) {
         return null;
      }

      for (PlayerScoreEntry var4 : var0.listPlayerScores(var2)) {
         if (!var4.isHidden()) {
            PlayerTeam var5 = var0.getPlayersTeam(var4.owner());
            MutableComponent var6 = PlayerTeam.formatNameForTeam(var5, var4.ownerName());
            String var7 = StyledTextParser.method11507(var6.getString());
            int var8 = var7.indexOf(var1);
            if (var8 >= 0) {
               return var7.substring(var8 + var1.length());
            }
         }
      }

      return null;
   }

   public static Long method00045() {
      String var0 = ScoreboardTextFormatter.INSTANCE.method05632()
         ? ScoreboardCache.INSTANCE.method06903(field00090)
         : (mc.level == null ? null : method00044(mc.level.getScoreboard(), field00091));
      return method00043(var0);
   }

   private CoinBalanceReader() {
   }

   public static Long method00046(Scoreboard var0) {
      return method00043(method00044(var0, field00092));
   }
}
