// Original binary: hex/api/baritone/command/defaults/MineCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.ForBlockOptionalMeta;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.utils.BlockOptionalMeta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class MineCommand extends Command {
   private static final String ОЭ = "ОЭ";
   private static final String ОЪ = "ОЪ";
   private static final String ОЧ = "ОЧ";
   private static final String ОЩ = "ОЩ";
   private static final String Ом = "Ом";
   private static final String ОФ = "ОФ";
   private static final String О3 = "О3";
   private static final String ОЬ = "ОЬ";

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(ОЩ, "", Ом, "", ОФ, "", О3, ОЬ);
   }

   @Override
   public String getShortDesc() {
      return ОЧ;
   }

   public MineCommand(IBaritone var1) {
      super(var1, ОЭ);
   }


   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      int var3 = var2.getAsOrDefault(Integer.class, 0);
      var2.requireMin(1);
      List<BlockOptionalMeta> sx = new ArrayList<>();

      while (var2.hasAny()) {
         sx.add(var2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE));
      }

      BaritoneAPI.getProvider().getWorldScanner().repack(this.ctx);
      this.logDirect(String.format(ОЪ, sx.toString()));
      this.baritone.getMineProcess().mine(var3, sx.toArray(new BlockOptionalMeta[0]));
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      var2.getAsOrDefault(Integer.class, 0);

      while (var2.has(2)) {
         var2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE);
      }

      return var2.tabCompleteDatatype(ForBlockOptionalMeta.INSTANCE);
   }
}
