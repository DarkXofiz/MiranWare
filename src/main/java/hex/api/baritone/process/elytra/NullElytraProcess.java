// Original binary: hex/api/baritone/process/elytra/NullElytraProcess
package hex.api.baritone.process.elytra;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.process.IElytraProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.utils.BaritoneProcessHelper;
import java.util.Collections;
import java.util.List;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public final class NullElytraProcess extends BaritoneProcessHelper implements IElytraProcess {
   private static final String бЧУ = "бЧУ";
   private static final String бЧ0 = "бЧ0";
   private static final String бЧГ = "бЧГ";
   private static final String бЧф = "бЧф";
   private static final String бЧЕ = "бЧЕ";

   @Override
   public void resetState() {
   }


   @Override
   public void onLostControl() {
   }

   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      throw new UnsupportedOperationException(бЧф);
   }

   @Override
   public String displayName0() {
      return бЧЕ;
   }

   @Override
   public void repackChunks() {
      throw new UnsupportedOperationException(бЧУ);
   }

   @Override
   public boolean isActive() {
      return false;
   }

   @Override
   public boolean isLoaded() {
      return false;
   }

   public NullElytraProcess(Baritone var1) {
      super(var1);
   }

   @Override
   public List<BetterBlockPos> getPath() {
      return Collections.emptyList();
   }

   @Override
   public BlockPos currentDestination() {
      return null;
   }

   @Override
   public void pathTo(BlockPos var1) {
      throw new UnsupportedOperationException(бЧ0);
   }

   @Override
   public void pathTo(Goal var1) {
      throw new UnsupportedOperationException(бЧГ);
   }

   @Override
   public boolean isSafeToCancel() {
      return true;
   }
}
