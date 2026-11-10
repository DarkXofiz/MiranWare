// Original binary: hex/api/baritone/behavior/Behavior
package hex.api.baritone.behavior;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.behavior.IBehavior;
import hex.api.baritone.api.utils.IPlayerContext;

// $VF: Compiled from s
public class Behavior implements IBehavior {
   public final Baritone baritone;
   public final IPlayerContext ctx;

   protected Behavior(Baritone var1) {
      this.baritone = var1;
      this.ctx = var1.getPlayerContext();
   }
}
