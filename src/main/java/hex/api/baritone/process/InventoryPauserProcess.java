// Original binary: hex/api/baritone/process/InventoryPauserProcess
package hex.api.baritone.process;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.utils.BaritoneProcessHelper;

// $VF: Compiled from s
public class InventoryPauserProcess extends BaritoneProcessHelper {
   boolean pauseRequestedLastTick;
   boolean safeToCancelLastTick;
   int ticksOfStationary;
   private static final double бфУ = 0;
   private static final String бф0 = "бф0";
   private static final double бфГ = 0;

   @Override
   public String displayName0() {
      return бф0;
   }

   public InventoryPauserProcess(Baritone var1) {
      super(var1);
   }

   private double motion() {
      return this.ctx.player().getDeltaMovement().multiply(1.0, 0.0, 1.0).length();
   }

   @Override
   public void onLostControl() {
   }

   @Override
   public boolean isActive() {
      return this.ctx.player() != null && this.ctx.world() != null;
   }

   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      this.safeToCancelLastTick = var2;
      if (this.pauseRequestedLastTick) {
         this.pauseRequestedLastTick = false;
         if (this.stationaryNow()) {
            this.ticksOfStationary++;
         }

         return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
      } else {
         this.ticksOfStationary = 0;
         return new PathingCommand(null, PathingCommandType.DEFER);
      }
   }

   public boolean stationaryForInventoryMove() {
      this.pauseRequestedLastTick = true;
      return this.safeToCancelLastTick && this.ticksOfStationary > 1;
   }

   @Override
   public double priority() {
      return бфГ;
   }

   @Override
   public boolean isTemporary() {
      return true;
   }

   private boolean stationaryNow() {
      return this.motion() < бфУ;
   }

}
