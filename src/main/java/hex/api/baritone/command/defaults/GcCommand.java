// Original binary: hex/api/baritone/command/defaults/GcCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class GcCommand extends Command {
   private static final String б7ш = "б7ш";
   private static final String б7л = "б7л";
   private static final String б7и = "б7и";
   private static final String б7щ = "б7щ";
   private static final String бУб = "бУб";
   private static final String бУА = "бУА";


   @Override
   public String getShortDesc() {
      return б7и;
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(б7щ, "", бУб, бУА);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      System.gc();
      this.logDirect(б7л);
   }

   public GcCommand(IBaritone var1) {
      super(var1, б7ш);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }
}
