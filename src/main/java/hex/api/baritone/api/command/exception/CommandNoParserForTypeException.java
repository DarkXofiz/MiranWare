// Original binary: hex/api/baritone/api/command/exception/CommandNoParserForTypeException
package hex.api.baritone.api.command.exception;


// $VF: Compiled from s
public class CommandNoParserForTypeException extends CommandUnhandledException {
   private static final String бяс = "бяс";

   public CommandNoParserForTypeException(Class<?> var1) {
      super(String.format(бяс, var1.getSimpleName()));
   }

}
