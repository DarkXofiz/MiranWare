// Original binary: hex/api/baritone/api/selection/ISelection
package hex.api.baritone.api.selection;

import hex.api.baritone.api.utils.BetterBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.AABB;

// $VF: Compiled from s
public interface ISelection {
   Vec3i size();

   ISelection contract(Direction var1, int var2);

   AABB aabb();

   BetterBlockPos min();

   BetterBlockPos pos1();

   BetterBlockPos pos2();

   BetterBlockPos max();

   ISelection shift(Direction var1, int var2);

   ISelection expand(Direction var1, int var2);
}
