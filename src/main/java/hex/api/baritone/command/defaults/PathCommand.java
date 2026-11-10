// Original binary: hex/api/baritone/command/defaults/PathCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.process.ICustomGoalProcess;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class PathCommand extends Command {
   private static final String field00046 = "field00046";
   private static final String field00047 = "field00047";
   private static final String field00048 = "field00048";
   private static final String field00049 = "field00049";
   private static final String field00050 = "field00050";
   private static final String field00051 = "field00051";
   private static final String field00052 = "field00052";


   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      ICustomGoalProcess var3 = this.baritone.getCustomGoalProcess();
      var2.requireMax(0);
      if (var3.getGoal() == null) {
         this.logDirect(field00047);
      } else {
         BaritoneAPI.getProvider().getWorldScanner().repack(this.ctx);
         var3.path();
         this.logDirect(field00048);
      }
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(field00050, "", field00051, field00052);
   }

   @Override
   public String getShortDesc() {
      return field00049;
   }

   public PathCommand(IBaritone var1) {
      super(var1, field00046);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      return Stream.empty();
   }
}
