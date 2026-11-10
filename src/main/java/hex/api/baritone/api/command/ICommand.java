// Original binary: hex/api/baritone/api/command/ICommand
package hex.api.baritone.api.command;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.utils.Helper;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public interface ICommand extends Helper {
   Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException;

   String getShortDesc();

   void execute(String var1, IArgConsumer var2) throws CommandException;

   List<String> getLongDesc();

   default boolean hiddenFromHelp() {
      return false;
   }

   List<String> getNames();
}
