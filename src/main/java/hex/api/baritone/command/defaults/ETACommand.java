// Original binary: hex/api/baritone/command/defaults/ETACommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.behavior.IPathingBehavior;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.pathing.calc.IPathingControlManager;
import hex.api.baritone.api.process.IBaritoneProcess;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ETACommand extends Command {
   private static final String шв = "шв";
   private static final String шр = "шр";
   private static final String шй = "шй";
   private static final double шк = 1.0;
   private static final double шп = 1.0;
   private static final String ш2 = "ш2";
   private static final String ш西 = "ш西";
   private static final String шт = "шт";
   private static final String шд = "шд";
   private static final String ше = "ше";
   private static final String ш6 = "ш6";

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      IPathingControlManager var3 = this.baritone.getPathingControlManager();
      IBaritoneProcess sx = var3.mostRecentInControl().orElse(null);
      if (sx == null) {
         throw new CommandInvalidStateException(шр);
      }

      IPathingBehavior sxx = this.baritone.getPathingBehavior();
      double sxxx = sxx.ticksRemainingInSegment().orElse(Double.NaN);
      double sxxxx = sxx.estimatedTicksToGoal().orElse(Double.NaN);
      this.logDirect(String.format(шй, sxxx / шк, sxxx, sxxxx / шп, sxxxx));
   }

   @Override
   public String getShortDesc() {
      return ш2;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(ш西, шт, "", шд, "", ше, ш6);
   }

   public ETACommand(IBaritone var1) {
      super(var1, шв);
   }

}
