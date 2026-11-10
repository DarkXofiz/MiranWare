// Original binary: hex/api/baritone/command/defaults/ExploreCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.RelativeGoalXZ;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ExploreCommand extends Command {
   private static final String бОж = "бОж";
   private static final String бО8 = "бО8";
   private static final String бОТ = "бОТ";
   private static final String бОЙ = "бОЙ";
   private static final String бОэ = "бОэ";
   private static final String бОО = "бОО";
   private static final String бОИ = "бОИ";

   @Override
   public String getShortDesc() {
      return бОТ;
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(бОЙ, "", бОэ, бОО, бОИ);
   }

   public ExploreCommand(IBaritone var1) {
      super(var1, бОж);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      if (var2.hasAny()) {
         var2.requireExactly(2);
      } else {
         var2.requireMax(0);
      }

      GoalXZ var3 = var2.hasAny() ? var2.getDatatypePost(RelativeGoalXZ.INSTANCE, this.ctx.playerFeet()) : new GoalXZ(this.ctx.playerFeet());
      this.baritone.getExploreProcess().explore(var3.getX(), var3.getZ());
      this.logDirect(String.format(бО8, var3.toString()));
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return var2.hasAtMost(2) ? var2.tabCompleteDatatype(RelativeGoalXZ.INSTANCE) : Stream.empty();
   }

}
