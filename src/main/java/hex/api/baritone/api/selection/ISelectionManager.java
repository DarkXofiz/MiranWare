// Original binary: hex/api/baritone/api/selection/ISelectionManager
package hex.api.baritone.api.selection;

import hex.api.baritone.api.utils.BetterBlockPos;
import net.minecraft.core.Direction;

// $VF: Compiled from s
public interface ISelectionManager {
   ISelection addSelection(BetterBlockPos var1, BetterBlockPos var2);

   ISelection removeSelection(ISelection var1);

   ISelection contract(ISelection var1, Direction var2, int var3);

   ISelection[] getSelections();

   ISelection getOnlySelection();

   ISelection getLastSelection();

   ISelection addSelection(ISelection var1);

   ISelection shift(ISelection var1, Direction var2, int var3);

   ISelection expand(ISelection var1, Direction var2, int var3);

   ISelection[] removeAllSelections();
}
