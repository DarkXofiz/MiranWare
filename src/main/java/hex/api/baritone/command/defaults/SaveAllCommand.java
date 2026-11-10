// Original binary: hex/api/baritone/command/defaults/SaveAllCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class SaveAllCommand extends Command {
   private static final String Афб = "Афб";
   private static final String АфА = "АфА";
   private static final String Аф诶 = "Аф诶";
   private static final String АфЫ = "АфЫ";
   private static final String Афз = "Афз";
   private static final String АфР = "АфР";

   @Override
   public String getShortDesc() {
      return Аф诶;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }


   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      this.ctx.worldData().getCachedWorld().save();
      this.logDirect(АфА);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(АфЫ, "", Афз, АфР);
   }

   public SaveAllCommand(IBaritone var1) {
      super(var1, Афб);
   }
}
