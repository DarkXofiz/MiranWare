// Original binary: hex/api/baritone/command/defaults/InvertCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalInverted;
import hex.api.baritone.api.process.ICustomGoalProcess;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class InvertCommand extends Command {
   private static final String АчЪ = "АчЪ";
   private static final String АчЧ = "АчЧ";
   private static final String АчЩ = "АчЩ";
   private static final String Ачм = "Ачм";
   private static final String АчФ = "АчФ";
   private static final String Ач3 = "Ач3";
   private static final String АчЬ = "АчЬ";


   public InvertCommand(IBaritone var1) {
      super(var1, АчЪ);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      ICustomGoalProcess var3 = this.baritone.getCustomGoalProcess();
      Goal sx;
      if ((sx = var3.getGoal()) == null) {
         throw new CommandInvalidStateException(АчЧ);
      }

      if (sx instanceof GoalInverted) {
         sx = ((GoalInverted)sx).origin;
      } else {
         sx = new GoalInverted(sx);
      }

      var3.setGoalAndPath(sx);
      this.logDirect(String.format(АчЩ, sx.toString()));
   }

   @Override
   public String getShortDesc() {
      return Ачм;
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(АчФ, "", Ач3, АчЬ);
   }
}
