// Original binary: hex/api/baritone/command/defaults/TunnelCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalStrictDirection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

// $VF: Compiled from s
public class TunnelCommand extends Command {
   private static final String 诶弟6 = "诶弟6";
   private static final String 诶弟l = "诶弟l";
   private static final String 诶弟必 = "诶弟必";
   private static final String 诶弟З = "诶弟З";
   private static final String 诶弟н = "诶弟н";
   private static final String 诶弟Д = "诶弟Д";
   private static final String 诶弟Н = "诶弟Н";
   private static final String 诶弟ш = "诶弟ш";
   private static final String 诶弟л = "诶弟л";

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(3);
      if (var2.hasExactly(3)) {
         boolean var3 = true;
         int sx = Integer.parseInt(var2.getArgs().get(0).getValue());
         int sxx = Integer.parseInt(var2.getArgs().get(1).getValue());
         int sxxx = Integer.parseInt(var2.getArgs().get(2).getValue());
         if (sxx < 1 || sx < 2 || sxxx < 1 || sx > this.ctx.world().getMaxY()) {
            this.logDirect(诶弟l);
            var3 = false;
         }

         if (var3) {
            sx--;
            sxx--;
            Direction sxxxx = this.ctx.player().getDirection();
            int sxxxxx = sxx % 2 == 0 ? 0 : 1;
            BlockPos sxxxxxx;
            BlockPos sxxxxxxx;
            switch (sxxxx) {
               case EAST:
                  sxxxxxx = new BlockPos(this.ctx.playerFeet().x, this.ctx.playerFeet().y, this.ctx.playerFeet().z - sxx / 2);
                  sxxxxxxx = new BlockPos(this.ctx.playerFeet().x + sxxx, this.ctx.playerFeet().y + sx, this.ctx.playerFeet().z + sxx / 2 + sxxxxx);
                  break;
               case WEST:
                  sxxxxxx = new BlockPos(this.ctx.playerFeet().x, this.ctx.playerFeet().y, this.ctx.playerFeet().z + sxx / 2 + sxxxxx);
                  sxxxxxxx = new BlockPos(this.ctx.playerFeet().x - sxxx, this.ctx.playerFeet().y + sx, this.ctx.playerFeet().z - sxx / 2);
                  break;
               case NORTH:
                  sxxxxxx = new BlockPos(this.ctx.playerFeet().x - sxx / 2, this.ctx.playerFeet().y, this.ctx.playerFeet().z);
                  sxxxxxxx = new BlockPos(this.ctx.playerFeet().x + sxx / 2 + sxxxxx, this.ctx.playerFeet().y + sx, this.ctx.playerFeet().z - sxxx);
                  break;
               case SOUTH:
                  sxxxxxx = new BlockPos(this.ctx.playerFeet().x + sxx / 2 + sxxxxx, this.ctx.playerFeet().y, this.ctx.playerFeet().z);
                  sxxxxxxx = new BlockPos(this.ctx.playerFeet().x - sxx / 2, this.ctx.playerFeet().y + sx, this.ctx.playerFeet().z + sxxx);
                  break;
               default:
                  throw new IllegalStateException("Unexpected value: " + sxxxx);
            }

            this.logDirect(String.format(诶弟必, sx + 1, sxx + 1, sxxx));
            this.baritone.getBuilderProcess().clearArea(sxxxxxx, sxxxxxxx);
         }
      } else {
         Goal var11 = new GoalStrictDirection(this.ctx.playerFeet(), this.ctx.player().getDirection());
         this.baritone.getCustomGoalProcess().setGoalAndPath(var11);
         this.logDirect(String.format(诶弟З, var11.toString()));
      }
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(诶弟Д, "", 诶弟Н, 诶弟ш, 诶弟л);
   }

   public TunnelCommand(IBaritone var1) {
      super(var1, 诶弟6);
   }


   @Override
   public String getShortDesc() {
      return 诶弟н;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }
}
