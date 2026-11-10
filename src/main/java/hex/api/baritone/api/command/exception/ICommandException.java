// Original binary: hex/api/baritone/api/command/exception/ICommandException
package hex.api.baritone.api.command.exception;

import hex.api.baritone.api.command.ICommand;
import hex.api.baritone.api.command.argument.ICommandArgument;
import hex.api.baritone.api.utils.Helper;
import java.util.List;
import net.minecraft.ChatFormatting;

// $VF: Compiled from s
public interface ICommandException {
   default void handle(ICommand var1, List<ICommandArgument> var2) {
      Helper.HELPER.logDirect(this.getMessage(), ChatFormatting.RED);
   }

   String getMessage();
}
