// Original binary: hex/api/baritone/command/defaults/ClickCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ClickCommand extends Command {
   private static final String 诶Ыу = "诶Ыу";
   private static final String 诶Ыг = "诶Ыг";
   private static final String 诶Ыю = "诶Ыю";
   private static final String 诶Ы4 = "诶Ы4";
   private static final String 诶ЫС = "诶ЫС";
   private static final String 诶Ыъ = "诶Ыъ";

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(诶Ы4, "", 诶ЫС, 诶Ыъ);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      this.baritone.openClick();
      this.logDirect(诶Ыг);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   public ClickCommand(IBaritone var1) {
      super(var1, 诶Ыу);
   }

   @Override
   public String getShortDesc() {
      return 诶Ыю;
   }

}
