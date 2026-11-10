// Original binary: hex/api/baritone/command/defaults/LitematicaCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class LitematicaCommand extends Command {
   private static final String цП = "цП";
   private static final String ц_ = "ц_";
   private static final String цс = "цс";
   private static final String цЛ = "цЛ";
   private static final String ць = "ць";
   private static final String цЯ = "цЯ";

   @Override
   public String getShortDesc() {
      return ц_;
   }


   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(1);
      int var3 = var2.hasAny() ? var2.getAs(Integer.class) - 1 : 0;
      this.baritone.getBuilderProcess().buildOpenLitematic(var3);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(цс, "", цЛ, ць, цЯ);
   }

   public LitematicaCommand(IBaritone var1) {
      super(var1, цП);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }
}
