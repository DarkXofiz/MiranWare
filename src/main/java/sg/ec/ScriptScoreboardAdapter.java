// Original binary: sg/ec/rlBHn3bCFeyO4soE
package sg.ec;

import hex.script.api.Scoreboard;
import hex.script.api.Text;
import java.util.ArrayList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.PlayerTeam;

// $VF: Compiled from s
public final class ScriptScoreboardAdapter implements MinecraftAccess {
   private static final int field23426 = 15;
   private static final String[] field23427 = new String[0];
   private static final Component[] field23428 = new Component[0];
   private static final Text[] field23429 = new Text[0];
   private static final int[] field23430 = new int[0];
   private final Scoreboard field23431 = new Scoreboard(this::method10461, this::method10462, this::method10466, this::method10463);
   private Component field23432;
   private Text field23433;
   private String field23434 = "";
   private String[] field23435 = field23427;
   private Component[] field23436 = field23428;
   private Text[] field23437 = field23429;
   private int[] field23438 = field23430;
   private Objective field23439;
   private boolean field23440 = true;

   private void method10459() {
      Objective var1 = this.method10465();
      if (var1 == null) {
         if (this.field23439 != null) {
            this.method10460();
         }
      } else if (this.field23440 || var1 != this.field23439) {
         this.field23440 = false;
         this.field23439 = var1;
         this.field23432 = var1.getDisplayName();
         String var2 = this.field23432 == null ? "" : StreamerTextHook.method03280(this.field23432.getString());
         if (!var2.equals(this.field23434)) {
            this.field23434 = var2;
            this.field23433 = null;
         }

         net.minecraft.world.scores.Scoreboard var3 = var1.getScoreboard();
         var var4 = new ArrayList<>(var3.listPlayerScores(var1));
         var4.removeIf(PlayerScoreEntry::isHidden);
         var4.sort(ScoreboardCache.field15570);
         int var5 = Math.min(var4.size(), 15);
         if (this.field23435.length != var5) {
            this.field23435 = new String[var5];
            this.field23436 = new Component[var5];
            this.field23437 = new Text[var5];
            this.field23438 = new int[var5];
         }

         for (int var6 = 0; var6 < var5; var6++) {
            PlayerScoreEntry var7 = (PlayerScoreEntry)var4.get(var6);
            PlayerTeam var8 = var3.getPlayersTeam(var7.owner());
            MutableComponent var9 = PlayerTeam.formatNameForTeam(var8, var7.ownerName());
            String var10 = StreamerTextHook.method03280(var9.getString());
            if (!var10.equals(this.field23435[var6])) {
               this.field23435[var6] = var10;
               this.field23437[var6] = null;
            }

            this.field23436[var6] = var9;
            this.field23438[var6] = var7.value();
         }
      }
   }

   private void method10460() {
      this.field23439 = null;
      this.field23432 = null;
      this.field23433 = null;
      this.field23434 = "";
      this.field23435 = field23427;
      this.field23436 = field23428;
      this.field23437 = field23429;
      this.field23438 = field23430;
   }

   private int method10461(int var1, int var2) {
      this.method10459();

      return switch (var1) {
         case 1 -> var2 >= 0 && var2 < this.field23438.length ? this.field23438[var2] : 0;
         case 2 -> this.field23439 == null ? 0 : 1;
         default -> this.field23435.length;
      };
   }

   private String method10462(int var1, int var2) {
      this.method10459();
      if (var1 != 1) {
         return this.field23434;
      } else {
         return var2 >= 0 && var2 < this.field23435.length ? this.field23435[var2] : "";
      }
   }

   private String[] method10463() {
      this.method10459();
      return this.field23435;
   }

   Scoreboard method10464() {
      return this.field23431;
   }

   private Objective method10465() {
      return mc.level == null ? null : ScoreboardTextFormatter.INSTANCE.method05638(mc.level.getScoreboard());
   }

   private Text method10466(int var1, int var2) {
      this.method10459();
      if (var1 != 1) {
         if (this.field23433 == null) {
            this.field23433 = ScriptTextAdapter.method09254(this.field23432);
         }

         return this.field23433;
      } else if (var2 >= 0 && var2 < this.field23437.length) {
         Text var3 = this.field23437[var2];
         if (var3 == null) {
            var3 = ScriptTextAdapter.method09254(this.field23436[var2]);
            this.field23437[var2] = var3;
         }

         return var3;
      } else {
         return Text.empty();
      }
   }

   void method10467() {
      this.field23440 = true;
   }
}
