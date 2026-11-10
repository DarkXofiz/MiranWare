// Original binary: hex/api/baritone/process/CustomGoalProcess
package hex.api.baritone.process;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.process.ICustomGoalProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.utils.BaritoneProcessHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public final class CustomGoalProcess extends BaritoneProcessHelper implements ICustomGoalProcess {
   private Goal goal;
   private Goal mostRecentGoal;
   private CustomGoalProcess.State state;
   private static final String Агк = "Агк";
   private static final String Агп = "Агп";

   @Override
   public Goal getGoal() {
      return this.goal;
   }

   @Override
   public void onLostControl() {
      this.state = CustomGoalProcess.State.NONE;
      this.goal = null;
   }


   public CustomGoalProcess(Baritone var1) {
      super(var1);
   }

   @Override
   public String displayName0() {
      return "Custom Goal " + this.goal;
   }

   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      switch (this.state) {
         case GOAL_SET:
            return new PathingCommand(this.goal, PathingCommandType.CANCEL_AND_SET_GOAL);
         case PATH_REQUESTED:
            PathingCommand var3 = new PathingCommand(this.goal, PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH);
            this.state = CustomGoalProcess.State.EXECUTING;
            return var3;
         case EXECUTING:
            if (var1) {
               this.onLostControl();
               return new PathingCommand(this.goal, PathingCommandType.CANCEL_AND_SET_GOAL);
            } else {
               if (this.goal == null || this.goal.isInGoal(this.ctx.playerFeet()) && this.goal.isInGoal(this.baritone.getPathingBehavior().pathStart())) {
                  this.onLostControl();
                  if (Baritone.settings().disconnectOnArrival.value && this.ctx.world() instanceof ClientLevel sx) {
                     sx.disconnect(Component.literal(Агк));
                  }

                  if (Baritone.settings().notificationOnPathComplete.value) {
                     this.logNotification(Агп, false);
                  }

                  return new PathingCommand(this.goal, PathingCommandType.CANCEL_AND_SET_GOAL);
               }

               return new PathingCommand(this.goal, PathingCommandType.SET_GOAL_AND_PATH);
            }
         default:
            throw new IllegalStateException("Unexpected state " + this.state);
      }
   }

   @Override
   public void setGoal(Goal var1) {
      this.goal = var1;
      this.mostRecentGoal = var1;
      if (this.baritone.getElytraProcess().isActive()) {
         try {
            this.baritone.getElytraProcess().pathTo(var1);
         } catch (IllegalArgumentException var3) {
            this.logDirect("Failed to update elytra goal because: " + var3.getMessage(), ChatFormatting.RED);
         }
      }

      if (this.state == CustomGoalProcess.State.NONE) {
         this.state = CustomGoalProcess.State.GOAL_SET;
      }

      if (this.state == CustomGoalProcess.State.EXECUTING) {
         this.state = CustomGoalProcess.State.PATH_REQUESTED;
      }
   }

   @Override
   public Goal mostRecentGoal() {
      return this.mostRecentGoal;
   }

   @Override
   public boolean isActive() {
      return this.state != CustomGoalProcess.State.NONE;
   }

   @Override
   public void path() {
      this.state = CustomGoalProcess.State.PATH_REQUESTED;
   }

   // $VF: Compiled from s
   protected enum State {
      NONE,
      GOAL_SET,
      PATH_REQUESTED,
      EXECUTING;
   }
}
