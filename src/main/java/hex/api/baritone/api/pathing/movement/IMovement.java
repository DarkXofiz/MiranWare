// Original binary: hex/api/baritone/api/pathing/movement/IMovement
package hex.api.baritone.api.pathing.movement;

import hex.api.baritone.api.utils.BetterBlockPos;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public interface IMovement {
   boolean calculatedWhileLoaded();

   double getCost();

   BetterBlockPos getSrc();

   MovementStatus update();

   void resetBlockCache();

   BlockPos getDirection();

   boolean safeToCancel();

   void reset();

   BetterBlockPos getDest();
}
