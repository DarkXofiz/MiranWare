// Original binary: hex/api/baritone/command/defaults/ForceCancelCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.behavior.IPathingBehavior;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ForceCancelCommand extends Command {
   private static final String АВЙ = "АВЙ";
   private static final String АВэ = "АВэ";
   private static final String АВО = "АВО";
   private static final String АВИ = "АВИ";
   private static final String АВП = "АВП";
   private static final String АВ_ = "АВ_";


   public ForceCancelCommand(IBaritone var1) {
      super(var1, АВЙ);
   }

   @Override
   public String getShortDesc() {
      return АВО;
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(АВИ, "", АВП, АВ_);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      IPathingBehavior var3 = this.baritone.getPathingBehavior();
      var3.cancelEverything();
      var3.forceCancel();
      this.logDirect(АВэ);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }
}
