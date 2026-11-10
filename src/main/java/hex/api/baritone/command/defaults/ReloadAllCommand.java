// Original binary: hex/api/baritone/command/defaults/ReloadAllCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ReloadAllCommand extends Command {
   private static final String А诶Х = "А诶Х";
   private static final String А诶Ш = "А诶Ш";
   private static final String А诶а = "А诶а";
   private static final String А诶7 = "А诶7";
   private static final String А诶У = "А诶У";
   private static final String А诶0 = "А诶0";

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      this.ctx.worldData().getCachedWorld().reloadAllFromDisk();
      this.logDirect(А诶Ш);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   public ReloadAllCommand(IBaritone var1) {
      super(var1, А诶Х);
   }


   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(А诶7, "", А诶У, А诶0);
   }

   @Override
   public String getShortDesc() {
      return А诶а;
   }
}
