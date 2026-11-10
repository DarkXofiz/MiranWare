// Original binary: hex/api/baritone/api/command/exception/CommandException
package hex.api.baritone.api.command.exception;

// $VF: Compiled from s
public abstract class CommandException extends Exception implements ICommandException {
   protected CommandException(String var1) {
      super(var1);
   }

   protected CommandException(String var1, Throwable var2) {
      super(var1, var2);
   }
}
