// Original binary: hex/api/baritone/api/command/datatypes/RelativeGoalYLevel
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.GoalYLevel;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.stream.Stream;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public enum RelativeGoalYLevel implements IDatatypePost<GoalYLevel, BetterBlockPos> {
   INSTANCE;

   public GoalYLevel apply(IDatatypeContext var1, BetterBlockPos var2) throws CommandException {
      if (var2 == null) {
         var2 = BetterBlockPos.ORIGIN;
      }

      return new GoalYLevel(Mth.floor(var1.getConsumer().getDatatypePost(RelativeCoordinate.INSTANCE, (double)var2.y)));
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) {
      IArgConsumer var2 = var1.getConsumer();
      return var2.hasAtMost(1) ? var2.tabCompleteDatatype(RelativeCoordinate.INSTANCE) : Stream.empty();
   }
}
