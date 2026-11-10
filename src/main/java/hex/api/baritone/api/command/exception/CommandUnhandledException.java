// Original binary: hex/api/baritone/api/command/exception/CommandUnhandledException
package hex.api.baritone.api.command.exception;

import hex.api.baritone.api.command.ICommand;
import hex.api.baritone.api.command.argument.ICommandArgument;
import hex.api.baritone.api.utils.Helper;
import java.util.List;

// $VF: Compiled from s
public class CommandUnhandledException extends RuntimeException implements ICommandException {
   public CommandUnhandledException(Throwable var1) {
      super(var1);
   }

   public CommandUnhandledException(String var1) {
      super(var1);
   }

   @Override
   public void handle(ICommand var1, List<ICommandArgument> var2) {
      Helper.HELPER.logUnhandledException(this);
   }
}
