// Original binary: sg/ec/Zcm2Xm7Sp5oy7XcV
package sg.ec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;

// $VF: Compiled from s
public enum ScoreboardCache implements MinecraftAccess {
   INSTANCE;

   public static final Comparator<PlayerScoreEntry> field15570 = Comparator.comparingInt(PlayerScoreEntry::value)
      .reversed()
      .thenComparing(PlayerScoreEntry::owner, String.CASE_INSENSITIVE_ORDER);
   private Objective field15571;
   private List<String> field15572;

   public void method06900(Objective var1) {
      this.field15571 = var1;
      this.field15572 = null;
   }

   public String method06901(String var1) {
      return this.field15571 == null ? var1 : StyledTextParser.method11507(this.field15571.getDisplayName().getString());
   }

   public boolean method06902(String var1) {
      for (String var3 : this.method06904()) {
         if (var3.contains(var1)) {
            return true;
         }
      }

      return false;
   }

   public String method06903(String var1) {
      for (String var3 : this.method06904()) {
         int var4 = var3.indexOf(var1);
         if (var4 >= 0) {
            return var3.substring(var4 + var1.length());
         }
      }

      return null;
   }

   public List<String> method06904() {
      if (this.field15572 != null) {
         return this.field15572;
      }

      if (this.field15571 != null && mc.level != null) {
         Scoreboard var1 = mc.level.getScoreboard();
         var var2 = new ArrayList<>(var1.listPlayerScores(this.field15571));
         var2.removeIf(PlayerScoreEntry::isHidden);
         var2.sort(field15570);
         var var3 = new ArrayList(var2.size());

         for (PlayerScoreEntry var5 : var2) {
            PlayerTeam var6 = var1.getPlayersTeam(var5.owner());
            MutableComponent var7 = PlayerTeam.formatNameForTeam(var6, var5.ownerName());
            var3.add(StyledTextParser.method11507(var7.getString()));
         }

         this.field15572 = var3;
         return var3;
      } else {
         this.field15572 = List.of();
         return this.field15572;
      }
   }
}
