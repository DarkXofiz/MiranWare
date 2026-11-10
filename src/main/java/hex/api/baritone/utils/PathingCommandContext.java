// Original binary: hex/api/baritone/utils/PathingCommandContext
package hex.api.baritone.utils;

import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.pathing.movement.CalculationContext;

// $VF: Compiled from s
public class PathingCommandContext extends PathingCommand {
   public final CalculationContext desiredCalcContext;

   public PathingCommandContext(Goal var1, PathingCommandType var2, CalculationContext var3) {
      super(var1, var2);
      this.desiredCalcContext = var3;
   }
}
