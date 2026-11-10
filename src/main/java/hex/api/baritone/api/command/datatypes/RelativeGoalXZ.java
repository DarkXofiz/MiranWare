// Original binary: hex/api/baritone/api/command/datatypes/RelativeGoalXZ
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.stream.Stream;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public enum RelativeGoalXZ implements IDatatypePost<GoalXZ, BetterBlockPos> {
   INSTANCE;

   public GoalXZ apply(IDatatypeContext var1, BetterBlockPos var2) throws CommandException {
      if (var2 == null) {
         var2 = BetterBlockPos.ORIGIN;
      }

      IArgConsumer var3 = var1.getConsumer();
      return new GoalXZ(
         Mth.floor(var3.getDatatypePost(RelativeCoordinate.INSTANCE, (double)var2.x)),
         Mth.floor(var3.getDatatypePost(RelativeCoordinate.INSTANCE, (double)var2.z))
      );
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) {
      IArgConsumer var2 = var1.getConsumer();
      return var2.hasAtMost(2) ? var2.tabCompleteDatatype(RelativeCoordinate.INSTANCE) : Stream.empty();
   }
}
