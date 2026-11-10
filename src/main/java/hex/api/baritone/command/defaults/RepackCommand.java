// Original binary: hex/api/baritone/command/defaults/RepackCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class RepackCommand extends Command {
   private static final String б_М = "б_М";
   private static final String б_5 = "б_5";
   private static final String б_Ж = "б_Ж";
   private static final String б_о = "б_о";
   private static final String б_К = "б_К";
   private static final String б_Э = "б_Э";
   private static final String б_Ъ = "б_Ъ";

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(б_К, "", б_Э, б_Ъ);
   }

   @Override
   public String getShortDesc() {
      return б_о;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      this.logDirect(String.format(б_Ж, BaritoneAPI.getProvider().getWorldScanner().repack(this.ctx)));
   }

   public RepackCommand(IBaritone var1) {
      super(var1, б_М, б_5);
   }

}
