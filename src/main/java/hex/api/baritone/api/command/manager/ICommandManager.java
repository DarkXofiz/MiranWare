// Original binary: hex/api/baritone/api/command/manager/ICommandManager
package hex.api.baritone.api.command.manager;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.ICommand;
import hex.api.baritone.api.command.argument.ICommandArgument;
import hex.api.baritone.api.command.registry.Registry;
import hex.api.baritone.api.utils.Tuple;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public interface ICommandManager {
   boolean execute(String var1);

   Stream<String> tabComplete(Tuple<String, List<ICommandArgument>> var1);

   IBaritone getBaritone();

   Stream<String> tabComplete(String var1);

   ICommand getCommand(String var1);

   Registry<ICommand> getRegistry();

   boolean execute(Tuple<String, List<ICommandArgument>> var1);
}
