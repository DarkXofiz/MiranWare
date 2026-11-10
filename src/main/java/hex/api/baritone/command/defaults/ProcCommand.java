// Original binary: hex/api/baritone/command/defaults/ProcCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.pathing.calc.IPathingControlManager;
import hex.api.baritone.api.process.IBaritoneProcess;
import hex.api.baritone.api.process.PathingCommand;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ProcCommand extends Command {
   private static final String АжЭ = "АжЭ";
   private static final String АжЪ = "АжЪ";
   private static final String АжЧ = "АжЧ";
   private static final String АжЩ = "АжЩ";
   private static final String Ажм = "Ажм";
   private static final String АжФ = "АжФ";
   private static final String Аж3 = "Аж3";
   private static final String АжЬ = "АжЬ";
   private static final String Аж1 = "Аж1";

   public ProcCommand(IBaritone var1) {
      super(var1, АжЭ);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      IPathingControlManager var3 = this.baritone.getPathingControlManager();
      IBaritoneProcess sx = var3.mostRecentInControl().orElse(null);
      if (sx == null) {
         throw new CommandInvalidStateException(АжЪ);
      }

      this.logDirect(
         String.format(
            АжЧ,
            sx.getClass().getTypeName(),
            sx.priority(),
            sx.isTemporary(),
            sx.displayName(),
            var3.mostRecentCommand().map(PathingCommand::toString).orElse(АжЩ)
         )
      );
   }


   @Override
   public String getShortDesc() {
      return Ажм;
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(АжФ, "", Аж3, "", АжЬ, Аж1);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }
}
