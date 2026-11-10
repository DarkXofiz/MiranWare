// Original binary: hex/api/baritone/api/command/datatypes/RelativeGoal
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import hex.api.baritone.api.pathing.goals.GoalYLevel;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.stream.Stream;

// $VF: Compiled from s
public enum RelativeGoal implements IDatatypePost<Goal, BetterBlockPos> {
   INSTANCE;

   public Goal apply(IDatatypeContext var1, BetterBlockPos var2) throws CommandException {
      if (var2 == null) {
         var2 = BetterBlockPos.ORIGIN;
      }

      IArgConsumer var3 = var1.getConsumer();
      GoalBlock sx = var3.peekDatatypePostOrNull(RelativeGoalBlock.INSTANCE, var2);
      if (sx != null) {
         return sx;
      }

      GoalXZ sxx = var3.peekDatatypePostOrNull(RelativeGoalXZ.INSTANCE, var2);
      if (sxx != null) {
         return sxx;
      }

      GoalYLevel sxxx = var3.peekDatatypePostOrNull(RelativeGoalYLevel.INSTANCE, var2);
      return sxxx != null ? sxxx : new GoalBlock(var2);
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) {
      return var1.getConsumer().tabCompleteDatatype(RelativeCoordinate.INSTANCE);
   }
}
