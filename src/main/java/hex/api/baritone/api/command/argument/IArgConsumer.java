// Original binary: hex/api/baritone/api/command/argument/IArgConsumer
package hex.api.baritone.api.command.argument;

import hex.api.baritone.api.command.datatypes.IDatatype;
import hex.api.baritone.api.command.datatypes.IDatatypeFor;
import hex.api.baritone.api.command.datatypes.IDatatypePost;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import hex.api.baritone.api.command.exception.CommandNotEnoughArgumentsException;
import hex.api.baritone.api.command.exception.CommandTooManyArgumentsException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

// $VF: Compiled from s
public interface IArgConsumer {
   ICommandArgument get() throws CommandNotEnoughArgumentsException;

   <T> T getAsOrNull(Class<T> var1) throws CommandNotEnoughArgumentsException;

   String consumedString();

   <T, O> T peekDatatypeOrNull(IDatatypePost<T, O> var1);

   <E extends Enum<?>> E peekEnumOrNull(Class<E> var1) throws CommandNotEnoughArgumentsException;

   String peekString(int var1) throws CommandNotEnoughArgumentsException;

   Deque<ICommandArgument> getConsumed();

   <E extends Enum<?>> E peekEnum(Class<E> var1, int var2) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   <T, D extends IDatatypeFor<T>> T getDatatypeFor(D var1) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   <T, O, D extends IDatatypePost<T, O>> T peekDatatypePostOrDefault(D var1, O var2, T var3);

   <T> T peekAsOrDefault(Class<T> var1, T var2) throws CommandNotEnoughArgumentsException;

   ICommandArgument peek() throws CommandNotEnoughArgumentsException;

   boolean hasAtMostOne();

   boolean hasExactly(int var1);

   void requireMax(int var1) throws CommandTooManyArgumentsException;

   boolean is(Class<?> var1) throws CommandNotEnoughArgumentsException;

   <T> T peekAs(Class<T> var1) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   <T, D extends IDatatypeFor<T>> T getDatatypeForOrDefault(D var1, T var2);

   LinkedList<ICommandArgument> getArgs();

   <T, O, D extends IDatatypePost<T, O>> T getDatatypePostOrDefault(D var1, O var2, T var3);

   <E extends Enum<?>> E getEnum(Class<E> var1) throws CommandInvalidTypeException, CommandNotEnoughArgumentsException;

   ICommandArgument consumed();

   <T, D extends IDatatypeFor<T>> T getDatatypeForOrNull(D var1);

   <T, O, D extends IDatatypePost<T, O>> T peekDatatypePost(D var1, O var2) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   <T, D extends IDatatypeFor<T>> T peekDatatypeFor(Class<D> var1);

   String getString() throws CommandNotEnoughArgumentsException;

   boolean hasExactlyOne();

   <T> T peekAsOrNull(Class<T> var1) throws CommandNotEnoughArgumentsException;

   <T> T peekDatatypeOrNull(IDatatypeFor<T> var1);

   <T, O, D extends IDatatypePost<T, O>> T peekDatatypePostOrNull(D var1, O var2);

   <E extends Enum<?>> E peekEnumOrNull(Class<E> var1, int var2) throws CommandNotEnoughArgumentsException;

   <T, O, D extends IDatatypePost<T, O>> T getDatatypePost(D var1, O var2) throws CommandInvalidTypeException, CommandNotEnoughArgumentsException;

   <T> T peekAs(Class<T> var1, int var2) throws CommandInvalidTypeException, CommandNotEnoughArgumentsException;

   void requireExactly(int var1) throws CommandException;

   <T, O> T peekDatatype(IDatatypePost<T, O> var1) throws CommandInvalidTypeException, CommandNotEnoughArgumentsException;

   <T> T getAs(Class<T> var1) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   <E extends Enum<?>> E getEnumOrDefault(Class<E> var1, E var2) throws CommandNotEnoughArgumentsException;

   <T> T peekAsOrDefault(Class<T> var1, T var2, int var3) throws CommandNotEnoughArgumentsException;

   boolean is(Class<?> var1, int var2) throws CommandNotEnoughArgumentsException;

   <E extends Enum<?>> E getEnumOrNull(Class<E> var1) throws CommandNotEnoughArgumentsException;

   <T, O, D extends IDatatypePost<T, O>> T getDatatypePostOrNull(D var1, O var2);

   boolean has(int var1);

   boolean hasAtMost(int var1);

   <T> T peekAsOrNull(Class<T> var1, int var2) throws CommandNotEnoughArgumentsException;

   ICommandArgument peek(int var1) throws CommandNotEnoughArgumentsException;

   IArgConsumer copy();

   <T, D extends IDatatypeFor<T>> T peekDatatypeForOrDefault(Class<D> var1, T var2);

   <T, D extends IDatatypeFor<T>> T peekDatatypeForOrNull(Class<D> var1);

   <T, O> T peekDatatype(IDatatypePost<T, O> var1, O var2) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   <T extends IDatatype> Stream<String> tabCompleteDatatype(T var1);

   <E extends Enum<?>> E peekEnum(Class<E> var1) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   String rawRest();

   boolean hasAny();

   boolean hasConsumed();

   void requireMin(int var1) throws CommandNotEnoughArgumentsException;

   <T> T getAsOrDefault(Class<T> var1, T var2) throws CommandNotEnoughArgumentsException;

   <T> T peekDatatype(IDatatypeFor<T> var1) throws CommandNotEnoughArgumentsException, CommandInvalidTypeException;

   String peekString() throws CommandNotEnoughArgumentsException;
}
