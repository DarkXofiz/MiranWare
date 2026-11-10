// Original binary: hex/api/baritone/api/command/argparser/IArgParser
package hex.api.baritone.api.command.argparser;

import hex.api.baritone.api.command.argument.ICommandArgument;

// $VF: Compiled from s
public interface IArgParser<T> {
   Class<T> getTarget();

   // $VF: Compiled from s
   interface Stated<T, S> extends IArgParser<T> {
      T parseArg(ICommandArgument var1, S var2) throws Exception;

      Class<S> getStateType();
   }

   // $VF: Compiled from s
   interface Stateless<T> extends IArgParser<T> {
      T parseArg(ICommandArgument var1) throws Exception;
   }
}
