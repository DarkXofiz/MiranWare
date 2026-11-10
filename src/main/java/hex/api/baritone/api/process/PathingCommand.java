// Original binary: hex/api/baritone/api/process/PathingCommand
package hex.api.baritone.api.process;

import hex.api.baritone.api.pathing.goals.Goal;
import java.util.Objects;

// $VF: Compiled from s
public class PathingCommand {
   public final Goal goal;
   public final PathingCommandType commandType;

   public PathingCommand(Goal var1, PathingCommandType var2) {
      Objects.requireNonNull(var2);
      this.goal = var1;
      this.commandType = var2;
   }

   @Override
   public String toString() {
      return this.commandType + " " + this.goal;
   }
}
