// Original binary: hex/api/baritone/process/FarmProcess
package hex.api.baritone.process;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.pathing.goals.GoalComposite;
import hex.api.baritone.api.pathing.goals.GoalGetToBlock;
import hex.api.baritone.api.process.IFarmProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.api.selection.ISelection;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.RayTraceUtils;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.utils.BaritoneProcessHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class FarmProcess extends BaritoneProcessHelper implements IFarmProcess {
   private boolean active;
   private List<BlockPos> locations;
   private int tickCount;
   private int range;
   private BlockPos center;
   private static final List<Item> FARMLAND_PLANTABLE = Arrays.asList(
      Items.BEETROOT_SEEDS, Items.MELON_SEEDS, Items.WHEAT_SEEDS, Items.PUMPKIN_SEEDS, Items.POTATO, Items.CARROT
   );
   private static final List<Item> PICKUP_DROPPED = Arrays.asList(
      Items.BEETROOT_SEEDS,
      Items.BEETROOT,
      Items.MELON_SEEDS,
      Items.MELON_SLICE,
      Blocks.MELON.asItem(),
      Items.WHEAT_SEEDS,
      Items.WHEAT,
      Items.PUMPKIN_SEEDS,
      Blocks.PUMPKIN.asItem(),
      Items.POTATO,
      Items.CARROT,
      Items.NETHER_WART,
      Items.COCOA_BEANS,
      Blocks.SUGAR_CANE.asItem(),
      Blocks.BAMBOO.asItem(),
      Blocks.CACTUS.asItem()
   );
   private static final double б5С = 0;
   private static final double б5ъ = 0;
   private static final double б5Б = 0;
   private static final String б5в = "б5в";
   private static final String б5р = "б5р";
   private static final double б5й = 0;
   private static final String б5к = "б5к";
   private static final String б5п = "б5п";
   private static final String б52 = "б52";
   private static final double б5西 = 0;
   private static final double б5т = 0;
   private static final double б5д = 0;

   @Override
   public void farm(int var1, BlockPos var2) {
      if (var2 == null) {
         this.center = this.baritone.getPlayerContext().playerFeet();
      } else {
         this.center = var2;
      }

      this.range = var1;
      this.active = true;
      this.locations = null;
   }

   public FarmProcess(Baritone var1) {
      super(var1);
   }

   private boolean isCocoa(ItemStack var1) {
      return !var1.isEmpty() && var1.getItem().equals(Items.COCOA_BEANS);
   }

   @Override
   public boolean isActive() {
      return this.active;
   }

   private boolean readyForHarvest(Level var1, BlockPos var2, BlockState var3) {
      for (FarmProcess.Harvest var7 : FarmProcess.Harvest.values()) {
         if (var7.block == var3.getBlock()) {
            return var7.readyToHarvest(var1, var2, var3);
         }
      }

      return false;
   }

   private boolean isNetherWart(ItemStack var1) {
      return !var1.isEmpty() && var1.getItem().equals(Items.NETHER_WART);
   }


   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      if (Baritone.settings().mineGoalUpdateInterval.value != 0 && this.tickCount++ % Baritone.settings().mineGoalUpdateInterval.value == 0) {
         ArrayList var3 = new ArrayList<>();

         for (FarmProcess.Harvest sx : FarmProcess.Harvest.values()) {
            var3.add(sx.block);
         }

         if (Baritone.settings().replantCrops.value) {
            var3.add(Blocks.FARMLAND);
            var3.add(Blocks.JUNGLE_LOG);
            if (Baritone.settings().replantNetherWart.value) {
               var3.add(Blocks.SOUL_SAND);
            }
         }

         Baritone.getExecutor()
            .execute(
               () -> this.locations = BaritoneAPI.getProvider()
                  .getWorldScanner()
                  .scanChunkRadius(this.ctx, var3, Baritone.settings().farmMaxScanSize.value, 10, 10)
            );
      }

      if (this.locations == null) {
         return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
      }

      if (Baritone.settings().farmUsingSelection.value) {
         ISelection var19 = this.baritone.getSelectionManager().getLastSelection();
         if (var19 != null) {
            this.locations.removeIf(var1x -> !var19.aabb().contains(var1x.getX() + б5西, var1x.getY() + б5т, var1x.getZ() + б5д));
         }
      }

      List var20 = new ArrayList<>();
      List sx = new ArrayList<>();
      List sxx = new ArrayList<>();
      List sxxx = new ArrayList<>();
      List sxxxx = new ArrayList<>();

      for (BlockPos sxxxxx : this.locations) {
         if (this.range == 0 || !(sxxxxx.distSqr(this.center) > this.range * this.range)) {
            BlockState sxxxxxx = this.ctx.world().getBlockState(sxxxxx);
            boolean sxxxxxxx = this.ctx.world().getBlockState(sxxxxx.above()).getBlock() instanceof AirBlock;
            if (sxxxxxx.getBlock() == Blocks.FARMLAND) {
               if (sxxxxxxx) {
                  sx.add(sxxxxx);
               }
            } else if (sxxxxxx.getBlock() == Blocks.SOUL_SAND) {
               if (sxxxxxxx) {
                  sxxx.add(sxxxxx);
               }
            } else if (sxxxxxx.getBlock() == Blocks.JUNGLE_LOG) {
               for (Direction sxxxxxxxx : Plane.HORIZONTAL) {
                  if (this.ctx.world().getBlockState(sxxxxx.relative(sxxxxxxxx)).getBlock() instanceof AirBlock) {
                     sxxxx.add(sxxxxx);
                     break;
                  }
               }
            } else if (this.readyForHarvest(this.ctx.world(), sxxxxx, sxxxxxx)) {
               var20.add(sxxxxx);
            } else if (sxxxxxx.getBlock() instanceof BonemealableBlock) {
               BonemealableBlock sxxxxxxxx = (BonemealableBlock)sxxxxxx.getBlock();
               if (sxxxxxxxx.isValidBonemealTarget(this.ctx.world(), sxxxxx, sxxxxxx, net.minecraft.world.level.block.BonemealSource.INTERACTION)
                  && sxxxxxxxx.isBonemealSuccess(this.ctx.world(), this.ctx.world().getRandom(), sxxxxx, sxxxxxx, net.minecraft.world.level.block.BonemealSource.INTERACTION)) {
                  sxx.add(sxxxxx);
               }
            }
         }
      }

      this.baritone.getInputOverrideHandler().clearAllKeys();
      BetterBlockPos sxxxxx = this.ctx.playerFeet();
      double sxxxxxx = this.ctx.playerController().getBlockReachDistance();

      for (BlockPos sxxxxxxx : (Iterable<BlockPos>) (Iterable) var20) {
         if (!(sxxxxx.distSqr(sxxxxxxx) > sxxxxxx * sxxxxxx)) {
            var sxxxxxxxx = RotationUtils.reachable(this.ctx, sxxxxxxx);
            if (sxxxxxxxx.isPresent() && var2) {
               this.baritone.getLookBehavior().updateTarget(sxxxxxxxx.get(), true);
               MovementHelper.switchToBestToolFor(this.ctx, this.ctx.world().getBlockState(sxxxxxxx));
               if (this.ctx.isLookingAt(sxxxxxxx)) {
                  this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_LEFT, true);
               }

               return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            }
         }
      }

      var sxxxxxxx = new ArrayList<>(sx);
      sxxxxxxx.addAll(sxxx);

      for (BlockPos sxxxxxxxx : (Iterable<BlockPos>) (Iterable) sxxxxxxx) {
         if (!(sxxxxx.distSqr(sxxxxxxxx) > sxxxxxx * sxxxxxx)) {
            boolean sxxxxxxxxx = sxxx.contains(sxxxxxxxx);
            Optional<Rotation> sxxxxxxxxxx = RotationUtils.reachableOffset(
               this.ctx, sxxxxxxxx, new Vec3(sxxxxxxxx.getX() + б5С, sxxxxxxxx.getY() + 1, sxxxxxxxx.getZ() + б5ъ), sxxxxxx, false
            );
            if (sxxxxxxxxxx.isPresent() && var2 && this.baritone.getInventoryBehavior().throwaway(true, sxxxxxxxxx ? this::isNetherWart : this::isPlantable)) {
               HitResult sxxxxxxxxxxx = RayTraceUtils.rayTraceTowards(this.ctx.player(), sxxxxxxxxxx.get(), sxxxxxx);
               if (sxxxxxxxxxxx instanceof BlockHitResult && ((BlockHitResult)sxxxxxxxxxxx).getDirection() == Direction.UP) {
                  this.baritone.getLookBehavior().updateTarget(sxxxxxxxxxx.get(), true);
                  if (this.ctx.isLookingAt(sxxxxxxxx)) {
                     this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_RIGHT, true);
                  }

                  return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
               }
            }
         }
      }

      for (BlockPos sxxxxxxxx : (Iterable<BlockPos>) (Iterable) sxxxx) {
         if (!(sxxxxx.distSqr(sxxxxxxxx) > sxxxxxx * sxxxxxx)) {
            for (Direction sxxxxxxxxx : Plane.HORIZONTAL) {
               if (this.ctx.world().getBlockState(sxxxxxxxx.relative(sxxxxxxxxx)).getBlock() instanceof AirBlock) {
                  Vec3 sxxxxxxxxxx = Vec3.atCenterOf(sxxxxxxxx).add(Vec3.atLowerCornerOf(sxxxxxxxxx.getUnitVec3i()).scale(б5Б));
                  var sxxxxxxxxxxx = RotationUtils.reachableOffset(this.ctx, sxxxxxxxx, sxxxxxxxxxx, sxxxxxx, false);
                  if (sxxxxxxxxxxx.isPresent() && var2 && this.baritone.getInventoryBehavior().throwaway(true, this::isCocoa)) {
                     HitResult sxxxxxxxxxxxx = RayTraceUtils.rayTraceTowards(this.ctx.player(), sxxxxxxxxxxx.get(), sxxxxxx);
                     if (sxxxxxxxxxxxx instanceof BlockHitResult && ((BlockHitResult)sxxxxxxxxxxxx).getDirection() == sxxxxxxxxx) {
                        this.baritone.getLookBehavior().updateTarget(sxxxxxxxxxxx.get(), true);
                        if (this.ctx.isLookingAt(sxxxxxxxx)) {
                           this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_RIGHT, true);
                        }

                        return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
                     }
                  }
               }
            }
         }
      }

      for (BlockPos sxxxxxxxx : (Iterable<BlockPos>) (Iterable) sxx) {
         if (!(sxxxxx.distSqr(sxxxxxxxx) > sxxxxxx * sxxxxxx)) {
            var sxxxxxxxxx = RotationUtils.reachable(this.ctx, sxxxxxxxx);
            if (sxxxxxxxxx.isPresent() && var2 && this.baritone.getInventoryBehavior().throwaway(true, this::isBoneMeal)) {
               this.baritone.getLookBehavior().updateTarget(sxxxxxxxxx.get(), true);
               if (this.ctx.isLookingAt(sxxxxxxxx)) {
                  this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_RIGHT, true);
               }

               return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            }
         }
      }

      if (var1) {
         this.logDirect(б5в);
         if (Baritone.settings().notificationOnFarmFail.value) {
            this.logNotification(б5р, true);
         }

         this.onLostControl();
         return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
      } else {
         List sxxxxxxxx = new ArrayList<>();

         for (BlockPos sxxxxxxxxx : (Iterable<BlockPos>) (Iterable) var20) {
            sxxxxxxxx.add(new BuilderProcess.GoalBreak(sxxxxxxxxx));
         }

         if (this.baritone.getInventoryBehavior().throwaway(false, this::isPlantable)) {
            for (BlockPos sxxxxxxxxx : (Iterable<BlockPos>) (Iterable) sx) {
               sxxxxxxxx.add(new GoalBlock(sxxxxxxxxx.above()));
            }
         }

         if (this.baritone.getInventoryBehavior().throwaway(false, this::isNetherWart)) {
            for (BlockPos sxxxxxxxxx : (Iterable<BlockPos>) (Iterable) sxxx) {
               sxxxxxxxx.add(new GoalBlock(sxxxxxxxxx.above()));
            }
         }

         if (this.baritone.getInventoryBehavior().throwaway(false, this::isCocoa)) {
            for (BlockPos sxxxxxxxxx : (Iterable<BlockPos>) (Iterable) sxxxx) {
               for (Direction sxxxxxxxxxx : Plane.HORIZONTAL) {
                  if (this.ctx.world().getBlockState(sxxxxxxxxx.relative(sxxxxxxxxxx)).getBlock() instanceof AirBlock) {
                     sxxxxxxxx.add(new GoalGetToBlock(sxxxxxxxxx.relative(sxxxxxxxxxx)));
                  }
               }
            }
         }

         if (this.baritone.getInventoryBehavior().throwaway(false, this::isBoneMeal)) {
            for (BlockPos sxxxxxxxxx : (Iterable<BlockPos>) (Iterable) sxx) {
               sxxxxxxxx.add(new GoalBlock(sxxxxxxxxx));
            }
         }

         for (Entity sxxxxxxxxx : this.ctx.entities()) {
            if (sxxxxxxxxx instanceof ItemEntity && sxxxxxxxxx.onGround()) {
               ItemEntity sxxxxxxxxxx = (ItemEntity)sxxxxxxxxx;
               if (PICKUP_DROPPED.contains(sxxxxxxxxxx.getItem().getItem())) {
                  sxxxxxxxx.add(new GoalBlock(new BetterBlockPos(sxxxxxxxxx.position().x, sxxxxxxxxx.position().y + б5й, sxxxxxxxxx.position().z)));
               }
            }
         }

         if (sxxxxxxxx.isEmpty()) {
            this.logDirect(б5к);
            if (Baritone.settings().notificationOnFarmFail.value) {
               this.logNotification(б5п, true);
            }

            this.onLostControl();
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
         } else {
            return new PathingCommand(new GoalComposite((Goal[]) sxxxxxxxx.toArray(new Goal[0])), PathingCommandType.SET_GOAL_AND_PATH);
         }
      }
   }

   @Override
   public void onLostControl() {
      this.active = false;
   }

   @Override
   public String displayName0() {
      return б52;
   }

   private boolean isBoneMeal(ItemStack var1) {
      return !var1.isEmpty() && var1.getItem().equals(Items.BONE_MEAL);
   }

   private boolean isPlantable(ItemStack var1) {
      return FARMLAND_PLANTABLE.contains(var1.getItem());
   }

   // $VF: Compiled from s
   private enum Harvest {
      WHEAT((CropBlock)Blocks.WHEAT),
      CARROTS((CropBlock)Blocks.CARROTS),
      POTATOES((CropBlock)Blocks.POTATOES),
      BEETROOT((CropBlock)Blocks.BEETROOTS),
      PUMPKIN(Blocks.PUMPKIN, var0 -> true),
      MELON(Blocks.MELON, var0 -> true),
      NETHERWART(Blocks.NETHER_WART, var0 -> var0.getValue(NetherWartBlock.AGE) >= 3),
      COCOA(Blocks.COCOA, var0 -> var0.getValue(CocoaBlock.AGE) >= 2),
      SUGARCANE(Blocks.SUGAR_CANE, null)      // $VF: Compiled from s
 {
         @Override
         public boolean readyToHarvest(Level var1, BlockPos var2, BlockState var3) {
            return Baritone.settings().replantCrops.value ? var1.getBlockState(var2.below()).getBlock() instanceof SugarCaneBlock : true;
         }
      },
      BAMBOO(Blocks.BAMBOO, null)      // $VF: Compiled from s
 {
         @Override
         public boolean readyToHarvest(Level var1, BlockPos var2, BlockState var3) {
            return Baritone.settings().replantCrops.value ? var1.getBlockState(var2.below()).getBlock() instanceof BambooStalkBlock : true;
         }
      },
      CACTUS(Blocks.CACTUS, null)      // $VF: Compiled from s
 {
         @Override
         public boolean readyToHarvest(Level var1, BlockPos var2, BlockState var3) {
            return Baritone.settings().replantCrops.value ? var1.getBlockState(var2.below()).getBlock() instanceof CactusBlock : true;
         }
      };

      public final Block block;
      public final Predicate<BlockState> readyToHarvest;

      Harvest(CropBlock var3) {
         this(var3, var3::isMaxAge);
      }

      Harvest(Block var3, Predicate<BlockState> var4) {
         this.block = var3;
         this.readyToHarvest = var4;
      }

      public boolean readyToHarvest(Level var1, BlockPos var2, BlockState var3) {
         return this.readyToHarvest.test(var3);
      }
   }
}
