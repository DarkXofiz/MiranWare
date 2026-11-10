// Original binary: hex/api/baritone/api/process/ICustomGoalProcess
package hex.api.baritone.api.process;

import hex.api.baritone.api.pathing.goals.Goal;

// $VF: Compiled from s
public interface ICustomGoalProcess extends IBaritoneProcess {
   Goal mostRecentGoal();

   void path();

   default void setGoalAndPath(Goal var1) {
      this.setGoal(var1);
      this.path();
   }

   void setGoal(Goal var1);

   Goal getGoal();
}
