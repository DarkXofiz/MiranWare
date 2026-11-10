// Original binary: hex/api/baritone/pathing/movement/movements/MovementDescend
package hex.api.baritone.pathing.movement.movements;

import com.google.common.collect.ImmutableSet;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.movement.MovementState;
import hex.api.baritone.utils.BlockStateInterface;
import hex.api.baritone.utils.pathing.MutableMoveResult;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class MovementDescend extends Movement {
   private int numTicks = 0;
   public boolean forceSafeMode = false;
   private static final double бУш = 0;
   private static final double бУл = 0;
   private static final double бУи = 0;
   private static final double бУщ = 0;
   private static final double б0б = 0;
   private static final double б0А = 0;
   private static final double б0诶 = 0;
   private static final double б0Ы = 0;
   private static final double б0з = 0;
   private static final double б0Р = 0;
   private static final double б0х = 0;
   private static final double б0Ц = 0;
   private static final double б09 = 0;
   private static final double б0Ю = 0;
   private static final double б_0O = 0;
   private static final double б0弟 = 0;
   private static final double б0В = 0;
   private static final double б0ж = 0;
   private static final double б08 = 0;
   private static final double б0Т = 0;
   private static final double б0Й = 0;
   private static final double б0э = 0;
   private static final double б0О = 0;
   private static final double б0И = 0;

   @Override
   public MovementState updateState(MovementState var1) {
      super.updateState(var1);
      if (var1.getStatus() != MovementStatus.RUNNING) {
         return var1;
      }

      BlockPos var2 = this.ctx.playerFeet();
      BlockPos sx = new BlockPos(this.dest.getX() * 2 - this.src.getX(), this.dest.getY(), this.dest.getZ() * 2 - this.src.getZ());
      if (!var2.equals(this.dest) && !var2.equals(sx)
         || !MovementHelper.isLiquid(this.ctx, this.dest) && !(this.ctx.player().position().y - this.dest.getY() < б0Р)) {
         if (this.safeMode()) {
            double sxx = (this.src.getX() + б0х) * б0Ц + (this.dest.getX() + б09) * б0Ю;
            double sxxx = (this.src.getZ() + б_0O) * б0弟 + (this.dest.getZ() + б0В) * б0ж;
            var1.setTarget(
                  new MovementState.MovementTarget(
                     RotationUtils.calcRotationFromVec3d(this.ctx.playerHead(), new Vec3(sxx, this.dest.getY(), sxxx), this.ctx.playerRotations())
                        .withPitch(this.ctx.playerRotations().getPitch()),
                     false
                  )
               )
               .setInput(Input.MOVE_FORWARD, true);
            return var1;
         }

         double sxx = this.ctx.player().position().x - (this.dest.getX() + б08);
         double sxxx = this.ctx.player().position().z - (this.dest.getZ() + б0Т);
         double sxxxx = Math.sqrt(sxx * sxx + sxxx * sxxx);
         double sxxxxx = this.ctx.player().position().x - (this.src.getX() + б0Й);
         double sxxxxxx = this.ctx.player().position().z - (this.src.getZ() + б0э);
         double sxxxxxxx = Math.sqrt(sxxxxx * sxxxxx + sxxxxxx * sxxxxxx);
         var1.setInput(
            Input.SNEAK,
            Baritone.settings().allowWalkOnMagmaBlocks.value
               && this.ctx.world().getBlockState(this.ctx.player().blockPosition().below()).is(Blocks.MAGMA_BLOCK)
         );
         if (!var2.equals(this.dest) || sxxxx > б0О) {
            if (this.numTicks++ < 20 && sxxxxxxx < б0И) {
               MovementHelper.moveTowards(this.ctx, var1, sx);
            } else {
               MovementHelper.moveTowards(this.ctx, var1, this.dest);
            }
         }

         return var1;
      } else {
         return var1.setStatus(MovementStatus.SUCCESS);
      }
   }

   public void forceSafeMode() {
      this.forceSafeMode = true;
   }

   public static void cost(CalculationContext var0, int var1, int var2, int var3, int var4, int var5, MutableMoveResult var6) {
      double var7 = 0.0;
      BlockState sx = var0.get(var4, var2 - 1, var5);
      var7 += MovementHelper.getMiningDurationTicks(var0, var4, var2 - 1, var5, sx, false);
      if (!(var7 >= бУл)) {
         var7 += MovementHelper.getMiningDurationTicks(var0, var4, var2, var5, false);
         if (!(var7 >= бУи)) {
            var7 += MovementHelper.getMiningDurationTicks(var0, var4, var2 + 1, var5, true);
            if (!(var7 >= бУщ)) {
               Block sxx = var0.get(var1, var2 - 1, var3).getBlock();
               if (!MovementHelper.isClimbable(sxx)) {
                  BlockState sxxx = var0.get(var4, var2 - 2, var5);
                  if (!MovementHelper.canWalkOn(var0, var4, var2 - 2, var5, sxxx)) {
                     dynamicFallCost(var0, var1, var2, var3, var4, var5, var7, sxxx, var6);
                  } else if (sx.getBlock() != Blocks.LADDER && sx.getBlock() != Blocks.VINE) {
                     if (!MovementHelper.canUseFrostWalker(var0, sx)) {
                        double sxxxx = б0б;
                        if (sxx == Blocks.SOUL_SAND) {
                           sxxxx *= б0А;
                        }

                        var7 += sxxxx + Math.max(FALL_N_BLOCKS_COST[1], б0诶);
                        var6.x = var4;
                        var6.y = var2 - 1;
                        var6.z = var5;
                        var6.cost = var7;
                     }
                  }
               }
            }
         }
      }
   }

   public MovementDescend(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3) {
      super(var1, var2, var3, new BetterBlockPos[]{var3.above(2), var3.above(), var3}, var3.below());
   }

   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      return ImmutableSet.of(this.src, this.dest.above(), this.dest);
   }

   @Override
   public void reset() {
      super.reset();
      this.numTicks = 0;
      this.forceSafeMode = false;
   }


   public boolean skipToAscend() {
      BlockPos var1 = this.dest.subtract(this.src.below()).offset(this.dest);
      return !MovementHelper.canWalkThrough(this.ctx, new BetterBlockPos(var1))
         && MovementHelper.canWalkThrough(this.ctx, new BetterBlockPos(var1).above())
         && MovementHelper.canWalkThrough(this.ctx, new BetterBlockPos(var1).above(2));
   }

   public static boolean dynamicFallCost(
      CalculationContext var0, int var1, int var2, int var3, int var4, int var5, double var6, BlockState var8, MutableMoveResult var9
   ) {
      if (var6 != 0.0 && var0.get(var4, var2 + 2, var5).getBlock() instanceof FallingBlock) {
         return false;
      }

      if (!MovementHelper.canWalkThrough(var0, var4, var2 - 2, var5, var8)) {
         return false;
      }

      double var10 = 0.0;
      int sx = var2;
      int sxx = 3;

      while (true) {
         int sxxx = var2 - sxx;
         if (sxxx < var0.world.getMinY()) {
            return false;
         }

         boolean sxxxx = sxx >= var0.minFallHeight;
         BlockState sxxxxx = var0.get(var4, sxxx, var5);
         int sxxxxxx = sxx - (var2 - sx);
         double sxxxxxxx = б0Ы + FALL_N_BLOCKS_COST[sxxxxxx] + var6 + var10;
         if (sxxxx && MovementHelper.isWater(sxxxxx)) {
            if (!MovementHelper.canWalkThrough(var0, var4, sxxx, var5, sxxxxx)) {
               return false;
            }

            if (var0.assumeWalkOnWater) {
               return false;
            }

            if (MovementHelper.isFlowing(var4, sxxx, var5, sxxxxx, var0.bsi)) {
               return false;
            }

            if (!MovementHelper.canWalkOn(var0, var4, sxxx - 1, var5)) {
               return false;
            }

            var9.x = var4;
            var9.y = sxxx;
            var9.z = var5;
            var9.cost = sxxxxxxx;
            return false;
         }

         if (sxxxx && var0.allowFallIntoLava && MovementHelper.isLava(sxxxxx)) {
            var9.x = var4;
            var9.y = sxxx;
            var9.z = var5;
            var9.cost = sxxxxxxx;
            return false;
         }

         if (sxxxxxx <= 11 && MovementHelper.isClimbable(sxxxxx.getBlock())) {
            var10 += FALL_N_BLOCKS_COST[sxxxxxx - 1];
            var10 += б0з;
            sx = sxxx;
         } else if (!MovementHelper.canWalkThrough(var0, var4, sxxx, var5, sxxxxx)) {
            if (!MovementHelper.canWalkOn(var0, var4, sxxx, var5, sxxxxx)) {
               return false;
            }

            if (MovementHelper.isBottomSlab(sxxxxx)) {
               return false;
            }

            if (sxxxx && sxxxxxx <= var0.maxFallHeightNoWater + 1) {
               var9.x = var4;
               var9.y = sxxx + 1;
               var9.z = var5;
               var9.cost = sxxxxxxx;
               return false;
            }

            if (sxxxx && var0.hasWaterBucket && sxxxxxx <= var0.maxFallHeightBucket + 1) {
               var9.x = var4;
               var9.y = sxxx + 1;
               var9.z = var5;
               var9.cost = sxxxxxxx + var0.placeBucketCost();
               return true;
            }

            return false;
         }

         sxx++;
      }
   }

   public boolean safeMode() {
      if (this.forceSafeMode) {
         return true;
      }

      BlockPos var1 = this.dest.subtract(this.src.below()).offset(this.dest);
      if (this.skipToAscend()) {
         return true;
      }

      for (int sx = 0; sx <= 2; sx++) {
         if (MovementHelper.avoidWalkingInto(BlockStateInterface.get(this.ctx, var1.above(sx)))) {
            return true;
         }
      }

      return false;
   }

   @Override
   public double calculateCost(CalculationContext var1) {
      MutableMoveResult var2 = new MutableMoveResult();
      cost(var1, this.src.x, this.src.y, this.src.z, this.dest.x, this.dest.z, var2);
      return var2.y != this.dest.y ? бУш : var2.cost;
   }
}
