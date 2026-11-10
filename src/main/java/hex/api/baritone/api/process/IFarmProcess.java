// Original binary: hex/api/baritone/api/process/IFarmProcess
package hex.api.baritone.api.process;

import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public interface IFarmProcess extends IBaritoneProcess {
   default void farm(int var1) {
      this.farm(var1, null);
   }

   default void farm() {
      this.farm(0, null);
   }

   void farm(int var1, BlockPos var2);
}
