// Original binary: hex/api/baritone/utils/pathing/PathBase
package hex.api.baritone.utils.pathing;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.pathing.path.CutoffPath;
import hex.api.baritone.utils.BlockStateInterface;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public abstract class PathBase implements IPath {
   public PathBase cutoffAtLoadedChunks(Object var1) {
      if (!Baritone.settings().cutoffAtLoadBoundary.value) {
         return this;
      }

      BlockStateInterface var2 = (BlockStateInterface)var1;

      for (int sx = 0; sx < this.positions().size(); sx++) {
         BlockPos sxx = this.positions().get(sx);
         if (!var2.worldContainsLoadedChunk(sxx.getX(), sxx.getZ())) {
            return new CutoffPath(this, sx);
         }
      }

      return this;
   }

   public PathBase staticCutoff(Goal var1) {
      int var2 = BaritoneAPI.getSettings().pathCutoffMinimumLength.value;
      if (this.length() < var2) {
         return this;
      } else if (var1 != null && !var1.isInGoal(this.getDest())) {
         double sx = BaritoneAPI.getSettings().pathCutoffFactor.value;
         int sxx = (int)((this.length() - var2) * sx) + var2 - 1;
         return new CutoffPath(this, sxx);
      } else {
         return this;
      }
   }
}
