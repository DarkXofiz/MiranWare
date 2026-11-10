// Original binary: sg/ec/OfXyFwQTOqBt2dwt
package sg.ec;

import hex.script.api.Tab;
import hex.script.api.TabEntry;
import hex.script.api.Text;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameType;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import sg.mx.PlayerTabOverlayMixin_1198;

// $VF: Compiled from s
public final class ScriptTabAdapter implements MinecraftAccess {
   private static final TabEntry[] field10654 = new TabEntry[0];
   private static final String[] field10655 = new String[0];
   private static final Comparator<TabEntry> field10656 = Comparator.comparing(TabEntry::name, String.CASE_INSENSITIVE_ORDER);
   private final Tab field10657 = new Tab(this::method04825, this::method04820, this::method04818, this::method04816, this::method04824, this::method04819);
   private TabEntry[] field10658 = field10654;
   private String[] field10659 = field10655;
   private int field10660 = -1;
   private int field10661;
   private int field10662 = -1;
   private int field10663;

   private Scoreboard method04814() {
      return mc.level == null ? null : mc.level.getScoreboard();
   }

   private String method04815(Component var1) {
      return var1 == null ? "" : var1.getString();
   }

   private String[] method04816(int var1, String var2) {
      Scoreboard var3 = this.method04814();
      if (var3 == null) {
         this.field10659 = field10655;
         this.field10662 = -1;
         return field10655;
      }

      if (var1 != 1) {
         return this.method04817(var3);
      }

      PlayerTeam var4 = var3.getPlayerTeam(var2);
      if (var4 == null) {
         return field10655;
      }

      var var5 = var4.getPlayers();
      return var5.isEmpty() ? field10655 : var5.toArray(new String[0]);
   }

   private String[] method04817(Scoreboard var1) {
      var var2 = var1.getPlayerTeams();
      int var3 = var2.size();
      int var4 = 1;

      for (PlayerTeam var6 : var2) {
         var4 = 31 * var4 + var6.getName().hashCode();
      }

      if (var3 == this.field10662 && var4 == this.field10663) {
         return this.field10659;
      }

      String[] var9 = new String[var3];
      int var10 = 0;

      for (PlayerTeam var8 : var2) {
         if (var10 == var9.length) {
            break;
         }

         var9[var10++] = var8.getName();
      }

      if (var10 < var9.length) {
         var9 = Arrays.copyOf(var9, var10);
      }

      Arrays.sort(var9);
      this.field10659 = var9;
      this.field10662 = var3;
      this.field10663 = var4;
      return var9;
   }

   private int method04818() {
      ClientPacketListener var1 = mc.getConnection();
      return var1 == null ? 0 : var1.getOnlinePlayers().size();
   }

   private Text method04819(int var1, String var2) {
      Scoreboard var3 = this.method04814();
      PlayerTeam var4 = var3 == null ? null : var3.getPlayerTeam(var2);
      return var4 == null ? Text.empty() : ScriptTextAdapter.method09251(var1 == 1 ? var4.getPlayerSuffix() : var4.getPlayerPrefix());
   }

   private TabEntry method04820(String var1) {
      for (TabEntry var5 : this.method04825()) {
         if (var5.is(var1)) {
            return var5;
         }
      }

      return null;
   }

   private int method04821(Collection<PlayerInfo> var1, Collection<PlayerInfo> var2, Scoreboard var3) {
      int var4 = 1;

      for (PlayerInfo var6 : var1) {
         GameType var7 = var6.getGameMode();
         var4 = 31 * var4 + var6.getProfile().id().hashCode();
         var4 = 31 * var4 + var6.getLatency();
         var4 = 31 * var4 + (var7 == null ? -1 : var7.getId());
         var4 = 31 * var4 + System.identityHashCode(var6.getTabListDisplayName());
         var4 = 31 * var4 + (var2.contains(var6) ? 1 : 0);
         PlayerTeam var8 = this.method04823(var3, var6.getProfile().name());
         if (var8 != null) {
            var4 = 31 * var4 + var8.getName().hashCode();
            var4 = 31 * var4 + System.identityHashCode(var8.getPlayerPrefix());
            var4 = 31 * var4 + System.identityHashCode(var8.getPlayerSuffix());
         }
      }

      return var4;
   }

   Tab method04822() {
      return this.field10657;
   }

   private PlayerTeam method04823(Scoreboard var1, String var2) {
      return var1 != null && var2 != null && !var2.isEmpty() ? var1.getPlayersTeam(var2) : null;
   }

   private String method04824(int var1, String var2) {
      if (var1 >= 2) {
         Scoreboard var5 = this.method04814();
         PlayerTeam var4 = var5 == null ? null : var5.getPlayerTeam(var2);
         if (var4 == null) {
            return "";
         }

         return switch (var1) {
            case 2 -> this.method04815(var4.getPlayerPrefix());
            case 3 -> this.method04815(var4.getPlayerSuffix());
            default -> this.method04815(var4.getDisplayName());
         };
      } else if (mc.gui != null && mc.getConnection() != null) {
         PlayerTabOverlayMixin_1198 var3 = (PlayerTabOverlayMixin_1198)(Object)mc.gui.getTabList();
         return this.method04815(var1 == 1 ? var3.getTabFooter() : var3.getTabHeader());
      } else {
         return "";
      }
   }

   private TabEntry[] method04825() {
      ClientPacketListener var1 = mc.getConnection();
      if (var1 == null) {
         this.field10658 = field10654;
         this.field10660 = -1;
         return field10654;
      }

      var var2 = var1.getOnlinePlayers();
      var var3 = var1.getListedOnlinePlayers();
      Scoreboard var4 = this.method04814();
      int var5 = var2.size();
      int var6 = this.method04821(var2, var3, var4);
      if (var5 == this.field10660 && var6 == this.field10661) {
         return this.field10658;
      }

      TabEntry[] var7 = new TabEntry[var5];
      int var8 = 0;

      for (PlayerInfo var10 : var2) {
         if (var8 == var7.length) {
            break;
         }

         var7[var8++] = this.method04826(var10, var3, var4);
      }

      if (var8 < var7.length) {
         var7 = Arrays.copyOf(var7, var8);
      }

      Arrays.sort(var7, field10656);
      this.field10658 = var7;
      this.field10660 = var5;
      this.field10661 = var6;
      return var7;
   }

   private TabEntry method04826(PlayerInfo var1, Collection<PlayerInfo> var2, Scoreboard var3) {
      String var4 = var1.getProfile().name();
      if (var4 == null) {
         var4 = "";
      }

      PlayerTeam var5 = this.method04823(var3, var4);
      String var6 = var5 == null ? "" : this.method04815(var5.getPlayerPrefix());
      String var7 = var5 == null ? "" : this.method04815(var5.getPlayerSuffix());
      Component var8 = var1.getTabListDisplayName();
      GameType var9 = var1.getGameMode();
      TabEntry var10 = new TabEntry();
      var10.set(
         var4,
         var1.getProfile().id().toString(),
         var8 == null ? var6 + var4 + var7 : var8.getString(),
         var1.getLatency(),
         var9 == null ? -1 : var9.getId(),
         var5 == null ? "" : var5.getName(),
         var6,
         var7,
         this.method04827(var1),
         var2.contains(var1)
      );
      return var10;
   }

   private String method04827(PlayerInfo var1) {
      try {
         return String.valueOf(var1.getSkin().body().texturePath());
      } catch (Throwable var3) {
         return "";
      }
   }
}
