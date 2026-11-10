// Original binary: hex/api/baritone/command/defaults/ComeCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ComeCommand extends Command {
   private static final String бА7 = "бА7";
   private static final String бАУ = "бАУ";
   private static final String бА0 = "бА0";
   private static final String бАГ = "бАГ";
   private static final String бАф = "бАф";
   private static final String бАЕ = "бАЕ";
   private static final String бАч = "бАч";

   @Override
   public String getShortDesc() {
      return бА0;
   }


   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   public ComeCommand(IBaritone var1) {
      super(var1, бА7);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(бАГ, "", бАф, "", бАЕ, бАч);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      this.baritone.getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.ctx.viewerPos()));
      this.logDirect(бАУ);
   }
}
