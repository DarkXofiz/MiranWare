// Original binary: hex/api/baritone/command/defaults/SurfaceCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.world.level.block.AirBlock;

// $VF: Compiled from s
public class SurfaceCommand extends Command {
   private static final String ббВ = "ббВ";
   private static final String ббж = "ббж";
   private static final String бб8 = "бб8";
   private static final String ббТ = "ббТ";
   private static final String ббЙ = "ббЙ";
   private static final String ббэ = "ббэ";
   private static final String ббО = "ббО";
   private static final String ббИ = "ббИ";
   private static final String ббП = "ббП";
   private static final String бб_ = "бб_";
   private static final String ббс = "ббс";


   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      BetterBlockPos var3 = this.ctx.playerFeet();
      int sx = this.ctx.world().getSeaLevel();
      int sxx = this.ctx.world().getHeight();
      if (var3.getY() > sx && this.ctx.world().getBlockState(var3.above()).getBlock() instanceof AirBlock) {
         this.logDirect(бб8);
      } else {
         int sxxx = Math.max(var3.getY(), sx);

         for (int sxxxx = sxxx; sxxxx < sxx; sxxxx++) {
            BetterBlockPos sxxxxx = new BetterBlockPos(var3.getX(), sxxxx, var3.getZ());
            if (!(this.ctx.world().getBlockState(sxxxxx).getBlock() instanceof AirBlock) && sxxxxx.getY() > var3.getY()) {
               Goal sxxxxxx = new GoalBlock(sxxxxx.above());
               this.logDirect(String.format(ббТ, sxxxxxx.toString()));
               this.baritone.getCustomGoalProcess().setGoalAndPath(sxxxxxx);
               return;
            }
         }

         this.logDirect(ббЙ);
      }
   }

   protected SurfaceCommand(IBaritone var1) {
      super(var1, ббВ, ббж);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(ббО, "", ббИ, "", ббП, бб_, ббс);
   }

   @Override
   public String getShortDesc() {
      return ббэ;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }
}
