// Original binary: hex/api/baritone/pathing/movement/movements/MovementFall
package hex.api.baritone.pathing.movement.movements;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.VecUtils;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.movement.MovementState;
import hex.api.baritone.utils.pathing.MutableMoveResult;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class MovementFall extends Movement {
   private static final ItemStack STACK_BUCKET_WATER = new ItemStack(Items.WATER_BUCKET);
   private static final ItemStack STACK_BUCKET_EMPTY = new ItemStack(Items.BUCKET);
   private static final double б27 = 0;
   private static final float б2У = 0;
   private static final double б20 = 0;
   private static final double б2Г = 0;
   private static final double б2ф = 0;
   private static final double б2Е = 0;
   private static final double б2ч = 1.0;
   private static final double б2衣 = 1.0;
   private static final double б2ц = 0;
   private static final double б2М = 0;
   private static final double б25 = 0;

   @Override
   protected boolean prepared(MovementState var1) {
      if (var1.getStatus() == MovementStatus.WAITING) {
         return true;
      }

      for (int var2 = 0; var2 < 4 && var2 < this.positionsToBreak.length; var2++) {
         if (!MovementHelper.canWalkThrough(this.ctx, this.positionsToBreak[var2])) {
            return super.prepared(var1);
         }
      }

      return true;
   }


   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      Set var1 = new HashSet<>();
      var1.add(this.src);

      for (int sx = this.src.y - this.dest.y; sx >= 0; sx--) {
         var1.add(this.dest.above(sx));
      }

      return var1;
   }

   private boolean willPlaceBucket() {
      CalculationContext var1 = new CalculationContext(this.baritone);
      MutableMoveResult sx = new MutableMoveResult();
      return MovementDescend.dynamicFallCost(
         var1, this.src.x, this.src.y, this.src.z, this.dest.x, this.dest.z, 0.0, var1.get(this.dest.x, this.src.y - 2, this.dest.z), sx
      );
   }

   @Override
   public double calculateCost(CalculationContext var1) {
      MutableMoveResult var2 = new MutableMoveResult();
      MovementDescend.cost(var1, this.src.x, this.src.y, this.src.z, this.dest.x, this.dest.z, var2);
      return var2.y != this.dest.y ? б27 : var2.cost;
   }

   @Override
   public MovementState updateState(MovementState var1) {
      super.updateState(var1);
      if (var1.getStatus() != MovementStatus.RUNNING) {
         return var1;
      }

      BlockPos var2 = this.ctx.playerFeet();
      Rotation sx = RotationUtils.calcRotationFromVec3d(this.ctx.playerHead(), VecUtils.getBlockPosCenter(this.dest), this.ctx.playerRotations());
      Rotation sxx = null;
      BlockState sxxx = this.ctx.world().getBlockState(this.dest);
      Block sxxxx = sxxx.getBlock();
      if (this.ctx.world().getBlockState(this.dest.below()).is(Blocks.MAGMA_BLOCK)
         && MovementHelper.steppingOnBlocks(this.ctx).stream().allMatch(var1x -> MovementHelper.canWalkThrough(this.ctx, var1x))) {
         var1.setInput(Input.SNEAK, true);
      }

      boolean sxxxxx = sxxx.getFluidState().getType() instanceof WaterFluid;
      if (!sxxxxx && this.willPlaceBucket() && !var2.equals(this.dest)) {
         if (!Inventory.isHotbarSlot(this.ctx.player().getInventory().findSlotMatchingItem(STACK_BUCKET_WATER)) || this.ctx.world().dimension() == Level.NETHER
            )
          {
            return var1.setStatus(MovementStatus.UNREACHABLE);
         }

         if (this.ctx.player().position().y - this.dest.getY() < this.ctx.playerController().getBlockReachDistance() && !this.ctx.player().onGround()) {
            this.ctx.player().getInventory().setSelectedSlot(this.ctx.player().getInventory().findSlotMatchingItem(STACK_BUCKET_WATER));
            sxx = new Rotation(sx.getYaw(), б2У);
            if (this.ctx.isLookingAt(this.dest) || this.ctx.isLookingAt(this.dest.below())) {
               var1.setInput(Input.CLICK_RIGHT, true);
            }
         }
      }

      if (sxx != null) {
         var1.setTarget(new MovementState.MovementTarget(sxx, true));
      } else {
         var1.setTarget(new MovementState.MovementTarget(sx, false));
      }

      if (var2.equals(this.dest) && (this.ctx.player().position().y - var2.getY() < б20 || sxxxxx)) {
         if (!sxxxxx) {
            return var1.setStatus(MovementStatus.SUCCESS);
         }

         if (Inventory.isHotbarSlot(this.ctx.player().getInventory().findSlotMatchingItem(STACK_BUCKET_EMPTY))) {
            this.ctx.player().getInventory().setSelectedSlot(this.ctx.player().getInventory().findSlotMatchingItem(STACK_BUCKET_EMPTY));
            if (this.ctx.player().getDeltaMovement().y >= 0.0) {
               return var1.setInput(Input.CLICK_RIGHT, true);
            }

            return var1;
         }

         if (this.ctx.player().getDeltaMovement().y >= 0.0) {
            return var1.setStatus(MovementStatus.SUCCESS);
         }
      }

      Vec3 sxxxxxx = VecUtils.getBlockPosCenter(this.dest);
      if (Math.abs(this.ctx.player().position().x + this.ctx.player().getDeltaMovement().x - sxxxxxx.x) > б2Г
         || Math.abs(this.ctx.player().position().z + this.ctx.player().getDeltaMovement().z - sxxxxxx.z) > б2ф) {
         if (!this.ctx.player().onGround() && Math.abs(this.ctx.player().getDeltaMovement().y) > б2Е) {
            var1.setInput(Input.SNEAK, true);
         }

         var1.setInput(Input.MOVE_FORWARD, true);
      }

      Vec3i sxxxxxxx = Optional.ofNullable(this.avoid()).map(Direction::getUnitVec3i).orElse(null);
      if (sxxxxxxx == null) {
         sxxxxxxx = this.src.subtract(this.dest);
      } else {
         double sxxxxxxxx = Math.abs(sxxxxxxx.getX() * (sxxxxxx.x - sxxxxxxx.getX() / б2ч - this.ctx.player().position().x))
            + Math.abs(sxxxxxxx.getZ() * (sxxxxxx.z - sxxxxxxx.getZ() / б2衣 - this.ctx.player().position().z));
         if (sxxxxxxxx < б2ц) {
            var1.setInput(Input.MOVE_FORWARD, true);
         } else if (!this.ctx.player().onGround()) {
            var1.setInput(Input.SNEAK, false);
         }
      }

      if (sxx == null) {
         Vec3 sxxxxxxxx = new Vec3(sxxxxxx.x + б2М * sxxxxxxx.getX(), sxxxxxx.y, sxxxxxx.z + б25 * sxxxxxxx.getZ());
         var1.setTarget(
            new MovementState.MovementTarget(RotationUtils.calcRotationFromVec3d(this.ctx.playerHead(), sxxxxxxxx, this.ctx.playerRotations()), false)
         );
      }

      return var1;
   }

   private Direction avoid() {
      for (int var1 = 0; var1 < 15; var1++) {
         BlockState sx = this.ctx.world().getBlockState(this.ctx.playerFeet().below(var1));
         if (sx.getBlock() == Blocks.LADDER) {
            return sx.getValue(LadderBlock.FACING);
         }
      }

      return null;
   }

   private static BetterBlockPos[] buildPositionsToBreak(BetterBlockPos var0, BetterBlockPos var1) {
      int var3 = var0.getX() - var1.getX();
      int sx = var0.getZ() - var1.getZ();
      int sxx = Math.abs(var0.getY() - var1.getY());
      BetterBlockPos[] sxxx = new BetterBlockPos[sxx + 2];

      for (int sxxxx = 0; sxxxx < sxxx.length; sxxxx++) {
         sxxx[sxxxx] = new BetterBlockPos(var0.getX() - var3, var0.getY() + 1 - sxxxx, var0.getZ() - sx);
      }

      return sxxx;
   }

   public MovementFall(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3) {
      super(var1, var2, var3, buildPositionsToBreak(var2, var3));
   }

   @Override
   public boolean safeToCancel(MovementState var1) {
      return this.ctx.playerFeet().equals(this.src) || var1.getStatus() != MovementStatus.RUNNING;
   }
}
