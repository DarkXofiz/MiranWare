// Original binary: sg/ec/TCzF7N8lUgKx4mTQ
package sg.ec;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetDisplayObjectivePacket;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.ScoreAccess;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.TeamColor;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.criteria.ObjectiveCriteria.RenderType;

// $VF: Compiled from s
public enum ScoreboardTextFormatter implements MinecraftAccess {
   INSTANCE;

   private static final int field11993 = -11710;
   private static final int field11994 = 0;
   private static final int field11995 = 0;
   private static final int field11996 = 0;
   private static final String field11997 = "field11997";
   private static final String field11998 = "field11998";
   private static final String field11999 = "field11999";
   private static final String field12000 = "field12000";
   private static final String field12001 = "field12001";
   private static final String field12002 = "field12002";
   private static final String field12003 = "field12003";
   private static final String field12004 = "field12004";
   private static final String field12005 = "field12005";
   private static final String field12006 = "field12006";
   private volatile Component field12007 = method05628("ГРИФ #6", true, -11710, -2924489);
   private volatile String field12008;
   private volatile boolean field12009;
   private final Map<Integer, Component> field12010 = new ConcurrentHashMap<>(
      Map.ofEntries(
         Map.entry(0, method05629("╔═ ").append(method05630("Профиль:"))),
         Map.entry(1, method05629("║ ").append(method05631("Ник: ", "Protected"))),
         Map.entry(2, method05629("║ ").append(method05631("Ранг: ", "ИГРОК"))),
         Map.entry(3, method05629("║ ").append(method05631("Клан: ", "Без клана"))),
         Map.entry(4, method05629("║ ").append(method05631("Пинг: ", "0"))),
         Map.entry(5, method05629("╠═ ").append(method05628("Сервер:", true, -11710, -2924489))),
         Map.entry(6, method05629("║ ").append(method05631("Баланс: ", "$0"))),
         Map.entry(7, method05629("║ ").append(method05631("Рилликов: ", "0"))),
         Map.entry(8, method05629("║ ").append(method05631("У/С: ", "0/0"))),
         Map.entry(9, method05629("╚═ ").append(method05628("MiranWare", true, -11710, -2924489)))
      )
   );

   public static MutableComponent method05626(String var0, int var1) {
      return method05627(var0, var1, false);
   }

   public static MutableComponent method05627(String var0, int var1, boolean var2) {
      return Component.literal(var0).setStyle(Style.EMPTY.withColor(var1).withBold(var2));
   }

   public static MutableComponent method05628(String var0, boolean var1, int... var2) {
      return ChatTextUtils.method05085(var0, var2).withStyle(var1x -> var1x.withBold(var1));
   }

   public static MutableComponent method05629(String var0) {
      return method05628(var0, false, -5265760);
   }

   public static MutableComponent method05630(String var0) {
      return method05628(var0, true, -11710, -2924489);
   }

   public static MutableComponent method05631(String var0, String var1) {
      return method05627(var0, -1, false).append(method05627(var1, -2059723, false));
   }

   public boolean method05632() {
      return this.field12009;
   }

   public void method05633(Component var1) {
      this.field12007 = var1;
   }

   public void method05634(int var1, Component var2) {
      if (var2 == null) {
         this.field12010.remove(var1);
      } else {
         this.field12010.put(var1, var2);
      }
   }

   public void method05635() {
      if (mc.level == null) {
         this.field12008 = null;
         ScoreboardCache.INSTANCE.method06900(null);
      } else {
         Scoreboard var1 = mc.level.getScoreboard();
         Objective var2 = this.method05637(var1);
         ScoreboardCache.INSTANCE.method06900(var2);
         if (var2 != null && this.method05636()) {
            this.method05639();
            Objective var3 = var1.getObjective("hex.sidebar");
            if (var3 == null) {
               var3 = var1.addObjective("hex.sidebar", ObjectiveCriteria.DUMMY, this.field12007, RenderType.INTEGER, false, null);
            } else {
               var3.setDisplayName(this.field12007);
            }

            var var4 = new ArrayList<>(this.field12010.keySet());
            var4.sort(null);

            for (int var5 = 0; var5 < var4.size(); var5++) {
               int var6 = (Integer)var4.get(var5);
               ScoreAccess var7 = var1.getOrCreatePlayerScore(ScoreHolder.forNameOnly("hex.sb." + var6), var3, true);
               var7.set(var4.size() - 1 - var5);
               var7.display(this.field12010.get(var6));
            }

            for (PlayerScoreEntry var9 : new ArrayList<>(var1.listPlayerScores(var3))) {
               if (!this.field12010.containsKey(method05644(var9.owner()))) {
                  var1.resetSinglePlayerScore(ScoreHolder.forNameOnly(var9.owner()), var3);
               }
            }

            var1.setDisplayObjective(DisplaySlot.SIDEBAR, var3);
            this.field12009 = true;
         } else {
            this.method05643(var1, var2);
         }
      }
   }

   private boolean method05636() {
      ScoreboardCache var1 = ScoreboardCache.INSTANCE;
      return (var1.method06902("ReallyWorld.ru") || var1.method06902("mc.ReallyWorld.me"))
         && var1.method06902("Ранг: ")
         && !var1.method06902("До окончания PVP");
   }

   private Objective method05637(Scoreboard var1) {
      Objective var2 = this.method05638(var1);
      if (var2 != null && !"hex.sidebar".equals(var2.getName())) {
         this.field12008 = var2.getName();
         return var2;
      } else {
         return this.field12008 == null ? null : var1.getObjective(this.field12008);
      }
   }

   public Objective method05638(Scoreboard var1) {
      if (mc.player != null) {
         PlayerTeam var2 = var1.getPlayersTeam(mc.player.getScoreboardName());
         if (var2 != null) {
            var var3 = var2.getColor();
            if (var3.isPresent()) {
               Objective var4 = var1.getDisplayObjective(((TeamColor)var3.get()).displaySlot());
               if (var4 != null) {
                  return var4;
               }
            }
         }
      }

      return var1.getDisplayObjective(DisplaySlot.SIDEBAR);
   }

   private void method05639() {
      this.method05633(method05628(ScoreboardCache.INSTANCE.method06901("ГРИФ #999"), true, -11710, -2924489));
      this.method05640(1, "Ник: ", "Protected");
      this.method05640(2, "Ранг: ", "Игрок");
      this.method05640(3, "Клан: ", "Без клана");
      this.method05640(4, "Пинг: ", "0");
      this.method05640(6, "Баланс: ", "0");
      this.method05640(7, "Рилликов: ", "0");
      this.method05640(8, "У/С: ", "0/0");
   }

   private void method05640(int var1, String var2, String var3) {
      String var4 = ScoreboardCache.INSTANCE.method06903(var2);
      this.method05634(var1, method05629("║ ").append(method05631(var2, var4 == null ? var3 : var4)));
   }

   public boolean method05641(Packet<?> var1) {
      if (var1 instanceof ClientboundSetDisplayObjectivePacket var2 && var2.getSlot() == DisplaySlot.SIDEBAR) {
         this.field12008 = var2.getObjectiveName();
         return this.field12009;
      } else {
         return false;
      }
   }

   public void method05642() {
      if (mc.level != null) {
         Scoreboard var1 = mc.level.getScoreboard();
         this.method05643(var1, this.field12008 == null ? null : var1.getObjective(this.field12008));
      }

      this.field12008 = null;
      ScoreboardCache.INSTANCE.method06900(null);
   }

   private void method05643(Scoreboard var1, Objective var2) {
      this.field12009 = false;
      Objective var3 = var1.getObjective("hex.sidebar");
      if (var3 != null) {
         var1.removeObjective(var3);
         if (var2 != null && var2 != var3) {
            var1.setDisplayObjective(DisplaySlot.SIDEBAR, var2);
         }
      }
   }

   private static int method05644(String var0) {
      if (var0.startsWith("hex.sb.") && var0.length() != "hex.sb.".length()) {
         int var1 = 0;

         for (int var2 = "hex.sb.".length(); var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (var3 < '0' || var3 > '9') {
               return -1;
            }

            var1 = var1 * 10 + (var3 - '0');
         }

         return var1;
      } else {
         return -1;
      }
   }
}
