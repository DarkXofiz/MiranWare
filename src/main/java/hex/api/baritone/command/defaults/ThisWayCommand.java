// Original binary: hex/api/baritone/command/defaults/ThisWayCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ThisWayCommand extends Command {
   private static final String бсч = "бсч";
   private static final String бс衣 = "бс衣";
   private static final String бсц = "бсц";
   private static final String бсМ = "бсМ";
   private static final String бс5 = "бс5";
   private static final String бсЖ = "бсЖ";
   private static final String бсо = "бсо";


   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(бс5, "", бсЖ, бсо);
   }

   public ThisWayCommand(IBaritone var1) {
      super(var1, бсч, бс衣);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   @Override
   public String getShortDesc() {
      return бсМ;
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireExactly(1);
      GoalXZ var3 = GoalXZ.fromDirection(this.ctx.playerFeetAsVec(), this.ctx.player().getYHeadRot(), var2.getAs(Double.class));
      this.baritone.getCustomGoalProcess().setGoal(var3);
      this.logDirect(String.format(бсц, var3));
   }
}
