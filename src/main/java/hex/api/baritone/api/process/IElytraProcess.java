// Original binary: hex/api/baritone/api/process/IElytraProcess
package hex.api.baritone.api.process;

import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.List;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public interface IElytraProcess extends IBaritoneProcess {
   void resetState();

   void pathTo(Goal var1);

   boolean isLoaded();

   List<BetterBlockPos> getPath();

   boolean isSafeToCancel();

   void repackChunks();

   void pathTo(BlockPos var1);

   BlockPos currentDestination();
}
