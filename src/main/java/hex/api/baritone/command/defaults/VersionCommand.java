// Original binary: hex/api/baritone/command/defaults/VersionCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class VersionCommand extends Command {
   private static final String Аl4 = "Аl4";
   private static final String АlС = "АlС";
   private static final String Аlъ = "Аlъ";
   private static final String АlБ = "АlБ";
   private static final String Аlв = "Аlв";
   private static final String Аlр = "Аlр";
   private static final String Аlй = "Аlй";

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(Аlв, "", Аlр, Аlй);
   }

   @Override
   public String getShortDesc() {
      return АlБ;
   }


   public VersionCommand(IBaritone var1) {
      super(var1, Аl4);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      String var3 = this.getClass().getPackage().getImplementationVersion();
      if (var3 == null) {
         throw new CommandInvalidStateException(АlС);
      }

      this.logDirect(String.format(Аlъ, var3));
   }
}
