// Original binary: hex/api/baritone/process/BackfillProcess
package hex.api.baritone.process;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.movement.MovementState;
import hex.api.baritone.pathing.path.PathExecutor;
import hex.api.baritone.utils.BaritoneProcessHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.EmptyLevelChunk;

// $VF: Compiled from s
public final class BackfillProcess extends BaritoneProcessHelper {
   public HashMap<BlockPos, BlockState> blocksToReplace = new HashMap<>();
   private static final String 诶ЦO = "诶ЦO";
   private static final String 诶Ц弟 = "诶Ц弟";
   private static final double 诶ЦВ = 0;

   private boolean partOfCurrentMovement(BlockPos var1) {
      PathExecutor var2 = this.baritone.getPathingBehavior().getCurrent();
      if (var2 != null && !var2.finished() && !var2.failed()) {
         Movement sx = (Movement)var2.getPath().movements().get(var2.getPosition());
         return Arrays.asList(sx.toBreakAll()).contains(var1);
      } else {
         return false;
      }
   }

   @Override
   public boolean isTemporary() {
      return true;
   }

   @Override
   public boolean isActive() {
      if (this.ctx.player() != null && this.ctx.world() != null) {
         if (!Baritone.settings().backfill.value) {
            return false;
         }

         if (Baritone.settings().allowParkour.value) {
            this.logDirect(诶ЦO);
            Baritone.settings().backfill.value = false;
            return false;
         }

         for (BlockPos var2 : new ArrayList<>(this.blocksToReplace.keySet())) {
            if (this.ctx.world().getChunk(var2) instanceof EmptyLevelChunk || this.ctx.world().getBlockState(var2).getBlock() != Blocks.AIR) {
               this.blocksToReplace.remove(var2);
            }
         }

         this.amIBreakingABlockHMMMMMMM();
         this.baritone.getInputOverrideHandler().clearAllKeys();
         return !this.toFillIn().isEmpty();
      } else {
         return false;
      }
   }

   public List<BlockPos> toFillIn() {
      return this.blocksToReplace
         .keySet()
         .stream()
         .filter(var1 -> this.ctx.world().getBlockState(var1).getBlock() == Blocks.AIR)
         .filter(var1 -> this.baritone.getBuilderProcess().placementPlausible(var1, Blocks.DIRT.defaultBlockState()))
         .filter(var1 -> !this.partOfCurrentMovement(var1))
         .sorted(Comparator.comparingDouble(this.ctx.playerFeet()::distSqr).reversed())
         .collect(Collectors.toList());
   }

   @Override
   public void onLostControl() {
      if (this.blocksToReplace != null && !this.blocksToReplace.isEmpty()) {
         this.blocksToReplace.clear();
      }
   }


   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      if (!var2) {
         return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
      }

      this.baritone.getInputOverrideHandler().clearAllKeys();

      for (BlockPos var4 : this.toFillIn()) {
         MovementState sx = new MovementState();
         switch (MovementHelper.attemptToPlaceABlock(sx, this.baritone, var4, false, false)) {
            case NO_OPTION:
               break;
            case READY_TO_PLACE:
               this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_RIGHT, true);
               return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            case ATTEMPTING:
               this.baritone.getLookBehavior().updateTarget(sx.getTarget().getRotation().get(), true);
               return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            default:
               throw new IllegalStateException();
         }
      }

      return new PathingCommand(null, PathingCommandType.DEFER);
   }

   @Override
   public String displayName0() {
      return 诶Ц弟;
   }

   private void amIBreakingABlockHMMMMMMM() {
      if (this.ctx.getSelectedBlock().isPresent() && this.baritone.getPathingBehavior().isPathing()) {
         this.blocksToReplace.put(this.ctx.getSelectedBlock().get(), this.ctx.world().getBlockState(this.ctx.getSelectedBlock().get()));
      }
   }

   @Override
   public double priority() {
      return 诶ЦВ;
   }

   public BackfillProcess(Baritone var1) {
      super(var1);
   }
}
