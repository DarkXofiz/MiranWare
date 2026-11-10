// Original binary: hex/api/baritone/command/defaults/GoalCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.RelativeCoordinate;
import hex.api.baritone.api.command.datatypes.RelativeGoal;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.process.ICustomGoalProcess;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class GoalCommand extends Command {
   private static final String Акй = "Акй";
   private static final String Акк = "Акк";
   private static final String Акп = "Акп";
   private static final String Ак2 = "Ак2";
   private static final String Ак西 = "Ак西";
   private static final String Акт = "Акт";
   private static final String Акд = "Акд";
   private static final String Аке = "Аке";
   private static final String Ак6 = "Ак6";
   private static final String Акl = "Акl";
   private static final String Ак必 = "Ак必";
   private static final String АкЗ = "АкЗ";
   private static final String Акн = "Акн";
   private static final String АкД = "АкД";
   private static final String АкН = "АкН";
   private static final String Акш = "Акш";
   private static final String Акл = "Акл";
   private static final String Аки = "Аки";
   private static final String Акщ = "Акщ";
   private static final String Апб = "Апб";
   private static final String АпА = "АпА";

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      ICustomGoalProcess var3 = this.baritone.getCustomGoalProcess();
      if (var2.hasAny() && Arrays.asList(Акк, Акп, Ак2).contains(var2.peekString())) {
         var2.requireMax(1);
         if (var3.getGoal() != null) {
            var3.setGoal(null);
            this.logDirect(Ак西);
         } else {
            this.logDirect(Акт);
         }
      } else {
         var2.requireMax(3);
         BetterBlockPos sx = this.ctx.playerFeet();
         Goal sxx = var2.getDatatypePost(RelativeGoal.INSTANCE, sx);
         var3.setGoal(sxx);
         this.logDirect(String.format(Акд, sxx.toString()));
      }
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(АкД, "", АкН, "", Акш, Акл, Аки, Акщ, Апб, АпА);
   }


   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      TabCompleteHelper var3 = new TabCompleteHelper();
      if (var2.hasExactlyOne()) {
         var3.append(Аке, Ак6, Акl, Ак必);
      } else if (var2.hasAtMost(3)) {
         while (var2.has(2) && var2.peekDatatypeOrNull(RelativeCoordinate.INSTANCE) != null) {
            var2.get();
            if (!var2.has(2)) {
               var3.append(АкЗ);
            }
         }
      }

      return var3.filterPrefix(var2.getString()).stream();
   }

   @Override
   public String getShortDesc() {
      return Акн;
   }

   public GoalCommand(IBaritone var1) {
      super(var1, Акй);
   }
}
