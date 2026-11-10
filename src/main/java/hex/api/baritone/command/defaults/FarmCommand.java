// Original binary: hex/api/baritone/command/defaults/FarmCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.cache.IWaypoint;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.ForWaypoints;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class FarmCommand extends Command {
   private static final String Иф = "Иф";
   private static final String ИЕ = "ИЕ";
   private static final String Ич = "Ич";
   private static final String И衣 = "И衣";
   private static final String Иц = "Иц";
   private static final String ИМ = "ИМ";
   private static final String И5 = "И5";
   private static final String ИЖ = "ИЖ";
   private static final String Ио = "Ио";
   private static final String ИК = "ИК";

   @Override
   public String getShortDesc() {
      return Иц;
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(2);
      int var3 = 0;
      BetterBlockPos sx = null;
      if (var2.has(1)) {
         var3 = var2.getAs(Integer.class);
      }

      if (var2.has(1)) {
         IWaypoint[] sxx = var2.getDatatypeFor(ForWaypoints.INSTANCE);
         IWaypoint sxxx = null;
         switch (sxx.length) {
            case 0:
               throw new CommandInvalidStateException(ИЕ);
            case 1:
               sxxx = sxx[0];
               sx = sxxx.getLocation();
               break;
            default:
               throw new CommandInvalidStateException(Ич);
         }
      }

      this.baritone.getFarmProcess().farm(var3, sx);
      this.logDirect(И衣);
   }


   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   public FarmCommand(IBaritone var1) {
      super(var1, Иф);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(ИМ, "", И5, ИЖ, Ио, ИК);
   }
}
