// Original binary: hex/api/baritone/api/command/exception/CommandInvalidArgumentException
package hex.api.baritone.api.command.exception;

import hex.api.baritone.api.command.argument.ICommandArgument;

// $VF: Compiled from s
public abstract class CommandInvalidArgumentException extends CommandErrorMessageException {
   public final ICommandArgument arg;
   private static final String бАЪ = "бАЪ";
   private static final String бАЧ = "бАЧ";

   private static String formatMessage(ICommandArgument var0, String var1) {
      return String.format(бАЪ, var0.getIndex() == -1 ? бАЧ : Integer.toString(var0.getIndex() + 1), var1);
   }

   protected CommandInvalidArgumentException(ICommandArgument var1, String var2) {
      super(formatMessage(var1, var2));
      this.arg = var1;
   }

   protected CommandInvalidArgumentException(ICommandArgument var1, String var2, Throwable var3) {
      super(formatMessage(var1, var2), var3);
      this.arg = var1;
   }

}
