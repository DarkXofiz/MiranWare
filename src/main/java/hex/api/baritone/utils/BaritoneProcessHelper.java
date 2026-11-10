// Original binary: hex/api/baritone/utils/BaritoneProcessHelper
package hex.api.baritone.utils;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.process.IBaritoneProcess;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.api.utils.IPlayerContext;

// $VF: Compiled from s
public abstract class BaritoneProcessHelper implements IBaritoneProcess, Helper {
   protected final Baritone baritone;
   protected final IPlayerContext ctx;

   public BaritoneProcessHelper(Baritone var1) {
      this.baritone = var1;
      this.ctx = var1.getPlayerContext();
   }

   @Override
   public boolean isTemporary() {
      return false;
   }
}
