// Original binary: hex/api/baritone/api/command/argument/ICommandArgument
package hex.api.baritone.api.command.argument;

import hex.api.baritone.api.command.exception.CommandInvalidTypeException;

// $VF: Compiled from s
public interface ICommandArgument {
   <T> boolean is(Class<T> var1);

   int getIndex();

   <T> T getAs(Class<T> var1) throws CommandInvalidTypeException;

   <T, S> boolean is(Class<T> var1, Class<S> var2, S var3);

   String getValue();

   <E extends Enum<?>> E getEnum(Class<E> var1) throws CommandInvalidTypeException;

   String getRawRest();

   <T, S> T getAs(Class<T> var1, Class<S> var2, S var3) throws CommandInvalidTypeException;
}
