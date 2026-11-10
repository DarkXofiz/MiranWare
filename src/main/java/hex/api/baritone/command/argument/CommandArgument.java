// Original binary: hex/api/baritone/command/argument/CommandArgument
package hex.api.baritone.command.argument;

import hex.api.baritone.api.command.argument.ICommandArgument;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import hex.api.baritone.command.argparser.ArgParserManager;
import java.util.stream.Stream;

// $VF: Compiled from s
class CommandArgument implements ICommandArgument {
   private final int index;
   private final String value;
   private final String rawRest;

   @Override
   public <T> boolean is(Class<T> var1) {
      try {
         this.getAs(var1);
         return true;
      } catch (Throwable var3) {
         return false;
      }
   }

   CommandArgument(int var1, String var2, String var3) {
      this.index = var1;
      this.value = var2;
      this.rawRest = var3;
   }

   @Override
   public String getRawRest() {
      return this.rawRest;
   }

   @Override
   public <T, S> boolean is(Class<T> var1, Class<S> var2, S var3) {
      try {
         this.getAs(var1, var2, var3);
         return true;
      } catch (Throwable var5) {
         return false;
      }
   }

   @Override
   public String getValue() {
      return this.value;
   }

   @Override
   public <E extends Enum<?>> E getEnum(Class<E> var1) throws CommandInvalidTypeException {
      return Stream.of(var1.getEnumConstants())
         .filter(var1x -> var1x.name().equalsIgnoreCase(this.value))
         .findFirst()
         .orElseThrow(() -> new CommandInvalidTypeException(this, var1.getSimpleName()));
   }

   @Override
   public <T> T getAs(Class<T> var1) throws CommandInvalidTypeException {
      return ArgParserManager.INSTANCE.parseStateless(var1, this);
   }

   @Override
   public <T, S> T getAs(Class<T> var1, Class<S> var2, S var3) throws CommandInvalidTypeException {
      return ArgParserManager.INSTANCE.parseStated(var1, var2, this, var3);
   }

   @Override
   public int getIndex() {
      return this.index;
   }
}
