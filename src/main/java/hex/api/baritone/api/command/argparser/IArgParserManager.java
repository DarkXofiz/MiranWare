// Original binary: hex/api/baritone/api/command/argparser/IArgParserManager
package hex.api.baritone.api.command.argparser;

import hex.api.baritone.api.command.argument.ICommandArgument;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import hex.api.baritone.api.command.registry.Registry;

// $VF: Compiled from s
public interface IArgParserManager {
   <T> T parseStateless(Class<T> var1, ICommandArgument var2) throws CommandInvalidTypeException;

   Registry<IArgParser> getRegistry();

   <T> IArgParser.Stateless<T> getParserStateless(Class<T> var1);

   <T, S> IArgParser.Stated<T, S> getParserStated(Class<T> var1, Class<S> var2);

   <T, S> T parseStated(Class<T> var1, Class<S> var2, ICommandArgument var3, S var4) throws CommandInvalidTypeException;
}
