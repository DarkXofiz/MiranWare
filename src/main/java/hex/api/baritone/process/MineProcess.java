// Original binary: hex/api/baritone/process/MineProcess
package hex.api.baritone.process;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.pathing.goals.GoalComposite;
import hex.api.baritone.api.pathing.goals.GoalRunAway;
import hex.api.baritone.api.pathing.goals.GoalTwoBlocks;
import hex.api.baritone.api.process.IMineProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.BlockOptionalMeta;
import hex.api.baritone.api.utils.BlockOptionalMetaLookup;
import hex.api.baritone.api.utils.BlockUtils;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.cache.CachedChunk;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.utils.BaritoneProcessHelper;
import hex.api.baritone.utils.BlockStateInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class MineProcess extends BaritoneProcessHelper implements IMineProcess {
   private BlockOptionalMetaLookup filter;
   private List<BlockPos> knownOreLocations;
   private List<BlockPos> blacklist;
   private Map<BlockPos, Long> anticipatedDrops;
   private BlockPos branchPoint;
   private GoalRunAway branchPointRunaway;
   private int desiredQuantity;
   private int tickCount;
   private static final double лФ = 0;
   private static final double л3 = 0;
   private static final String лЬ = "лЬ";
   private static final double л1 = 0;
   private static final double ля = 0;

   public MineProcess(Baritone var1) {
      super(var1);
   }

   private boolean internalMiningGoal(BlockPos var1, CalculationContext var2, List<BlockPos> var3) {
      if (var3.contains(var1)) {
         return true;
      }

      BlockState var4 = var2.bsi.get0(var1);
      return Baritone.settings().internalMiningAirException.value && var4.getBlock() instanceof AirBlock
         ? true
         : this.filter.has(var4) && plausibleToBreak(var2, var1);
   }

   private boolean addNearby() {
      var var1 = this.droppedItemsScan();
      this.knownOreLocations.addAll(var1);
      BlockPos sx = this.ctx.playerFeet();
      BlockStateInterface sxx = new BlockStateInterface(this.ctx);
      BlockOptionalMetaLookup sxxx = this.filterFilter();
      if (sxxx == null) {
         return false;
      }

      int sxxxx = 10;
      double sxxxxx = лФ;

      for (int sxxxxxx = sx.getX() - sxxxx; sxxxxxx <= sx.getX() + sxxxx; sxxxxxx++) {
         for (int sxxxxxxx = sx.getY() - sxxxx; sxxxxxxx <= sx.getY() + sxxxx; sxxxxxxx++) {
            for (int sxxxxxxxx = sx.getZ() - sxxxx; sxxxxxxxx <= sx.getZ() + sxxxx; sxxxxxxxx++) {
               if (sxxx.has(sxx.get0(sxxxxxx, sxxxxxxx, sxxxxxxxx))) {
                  BlockPos sxxxxxxxxx = new BlockPos(sxxxxxx, sxxxxxxx, sxxxxxxxx);
                  if (Baritone.settings().legitMineIncludeDiagonals.value && this.knownOreLocations.stream().anyMatch(var1x -> var1x.distSqr(sxxxxxxxxx) <= ля)
                     || RotationUtils.reachable(this.ctx, sxxxxxxxxx, sxxxxx).isPresent()) {
                     this.knownOreLocations.add(sxxxxxxxxx);
                  }
               }
            }
         }
      }

      this.knownOreLocations = prune(
         new CalculationContext(this.baritone), this.knownOreLocations, sxxx, Baritone.settings().mineMaxOreLocationsCount.value, this.blacklist, var1
      );
      return true;
   }

   private void rescan(List<BlockPos> var1, CalculationContext var2) {
      BlockOptionalMetaLookup var3 = this.filterFilter();
      if (var3 != null) {
         if (!Baritone.settings().legitMine.value) {
            var sx = this.droppedItemsScan();
            var sxx = searchWorld(var2, var3, Baritone.settings().mineMaxOreLocationsCount.value, var1, this.blacklist, sx);
            sxx.addAll(sx);
            if (sxx.isEmpty() && !Baritone.settings().exploreForBlocks.value) {
               this.logDirect("No locations for " + var3 + " known, cancelling");
               if (Baritone.settings().notificationOnMineFail.value) {
                  this.logNotification("No locations for " + var3 + " known, cancelling", true);
               }

               this.cancel();
            } else {
               this.knownOreLocations = sxx;
            }
         }
      }
   }

   @Override
   public void mineByName(int var1, String... var2) {
      this.mine(var1, new BlockOptionalMetaLookup(var2));
   }

   private void updateLoucaSystem() {
      var var1 = new HashMap<>(this.anticipatedDrops);
      this.ctx.getSelectedBlock().ifPresent(var2 -> {
         if (this.knownOreLocations.contains(var2)) {
            var1.put(var2, System.currentTimeMillis() + Baritone.settings().mineDropLoiterDurationMSThanksLouca.value);
         }
      });

      for (BlockPos sx : this.anticipatedDrops.keySet()) {
         if (var1.get(sx) < System.currentTimeMillis()) {
            var1.remove(sx);
         }
      }

      this.anticipatedDrops = var1;
   }

   private Goal coalesce(BlockPos var1, List<BlockPos> var2, CalculationContext var3) {
      boolean var4 = !(this.baritone.bsi().get0(var1.above()).getBlock() instanceof FallingBlock);
      if (!Baritone.settings().forceInternalMining.value) {
         return var4 ? new MineProcess.GoalThreeBlocks(var1) : new GoalTwoBlocks(var1);
      } else {
         boolean sx = this.internalMiningGoal(var1.above(), var3, var2);
         boolean sxx = this.internalMiningGoal(var1.below(), var3, var2);
         boolean sxxx = this.internalMiningGoal(var1.below(2), var3, var2);
         if (sx == sxx) {
            return sxxx && var4 ? new MineProcess.GoalThreeBlocks(var1) : new GoalTwoBlocks(var1);
         } else if (sx) {
            return new GoalBlock(var1);
         } else {
            return sxxx && var4 ? new GoalTwoBlocks(var1.below()) : new GoalBlock(var1.below());
         }
      }
   }

   @Override
   public void onLostControl() {
      this.mine(0, (BlockOptionalMetaLookup)null);
   }

   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      if (this.desiredQuantity > 0) {
         int var3 = this.ctx
            .player()
            .getInventory()
            .getNonEquipmentItems()
            .stream()
            .filter(var1x -> this.filter.has(var1x))
            .mapToInt(ItemStack::getCount)
            .sum();
         if (var3 >= this.desiredQuantity) {
            this.logDirect("Have " + var3 + " valid items");
            this.cancel();
            return null;
         }
      }

      if (var1) {
         if (this.knownOreLocations.isEmpty() || !Baritone.settings().blacklistClosestOnFailure.value) {
            this.logDirect("Unable to find any path to " + this.filter + ", canceling mine");
            if (Baritone.settings().notificationOnMineFail.value) {
               this.logNotification("Unable to find any path to " + this.filter + ", canceling mine", true);
            }

            this.cancel();
            return null;
         }

         this.logDirect("Unable to find any path to " + this.filter + ", blacklisting presumably unreachable closest instance...");
         if (Baritone.settings().notificationOnMineFail.value) {
            this.logNotification("Unable to find any path to " + this.filter + ", blacklisting presumably unreachable closest instance...", true);
         }

         this.knownOreLocations.stream().min(Comparator.comparingDouble(this.ctx.playerFeet()::distSqr)).ifPresent(this.blacklist::add);
         this.knownOreLocations.removeIf(this.blacklist::contains);
      }

      this.updateLoucaSystem();
      int var10 = Baritone.settings().mineGoalUpdateInterval.value;
      var sx = new ArrayList<>(this.knownOreLocations);
      if (var10 != 0 && this.tickCount++ % var10 == 0) {
         CalculationContext sxx = new CalculationContext(this.baritone, true);
         Baritone.getExecutor().execute(() -> this.rescan(sx, sxx));
      }

      if (Baritone.settings().legitMine.value && !this.addNearby()) {
         this.cancel();
         return null;
      }

      Optional sxx = sx.stream()
         .filter(var1x -> var1x.getX() == this.ctx.playerFeet().getX() && var1x.getZ() == this.ctx.playerFeet().getZ())
         .filter(var1x -> var1x.getY() >= this.ctx.playerFeet().getY())
         .filter(var1x -> !(BlockStateInterface.get(this.ctx, var1x).getBlock() instanceof AirBlock))
         .min(Comparator.comparingDouble(this.ctx.playerFeet().above()::distSqr));
      this.baritone.getInputOverrideHandler().clearAllKeys();
      if (sxx.isPresent() && this.ctx.player().onGround()) {
         BlockPos sxxx = (BlockPos) sxx.get();
         BlockStateInterface sxxxx = this.baritone.bsi();
         BlockState sxxxxx = sxxxx.get0(sxxx);
         if (!MovementHelper.avoidBreaking(sxxxx, sxxx.getX(), sxxx.getY(), sxxx.getZ(), sxxxxx)) {
            var sxxxxxx = RotationUtils.reachable(this.ctx, sxxx);
            if (sxxxxxx.isPresent() && var2) {
               this.baritone.getLookBehavior().updateTarget(sxxxxxx.get(), true);
               MovementHelper.switchToBestToolFor(this.ctx, this.ctx.world().getBlockState(sxxx));
               if (this.ctx.isLookingAt(sxxx) || this.ctx.playerRotations().isReallyCloseTo(sxxxxxx.get())) {
                  this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_LEFT, true);
               }

               return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            }
         }
      }

      PathingCommand sxxx = this.updateGoal();
      if (sxxx == null) {
         this.cancel();
         return null;
      } else {
         return sxxx;
      }
   }

   @Override
   public String displayName0() {
      return "Mine " + this.filter;
   }

   public static boolean isNextToAir(CalculationContext var0, BlockPos var1) {
      int var2 = Baritone.settings().allowOnlyExposedOresDistance.value;

      for (int sx = -var2; sx <= var2; sx++) {
         for (int sxx = -var2; sxx <= var2; sxx++) {
            for (int sxxx = -var2; sxxx <= var2; sxxx++) {
               if (Math.abs(sx) + Math.abs(sxx) + Math.abs(sxxx) <= var2
                  && MovementHelper.isTransparent(var0.getBlock(var1.getX() + sx, var1.getY() + sxx, var1.getZ() + sxxx))) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static List<BlockPos> searchWorld(
      CalculationContext var0, BlockOptionalMetaLookup var1, int var2, List<BlockPos> var3, List<BlockPos> var4, List<BlockPos> var5
   ) {
      List var6 = new ArrayList<>();
      List sx = new ArrayList<>();

      for (BlockOptionalMeta sxx : var1.blocks()) {
         Block sxxx = sxx.getBlock();
         if (CachedChunk.BLOCKS_TO_KEEP_TRACK_OF.contains(sxxx)) {
            BetterBlockPos sxxxx = var0.baritone.getPlayerContext().playerFeet();
            var6.addAll(
               var0.worldData
                  .getCachedWorld()
                  .getLocationsOf(BlockUtils.blockToString(sxxx), Baritone.settings().maxCachedWorldScanCount.value, sxxxx.x, sxxxx.z, 2)
            );
         } else {
            sx.add(sxxx);
         }
      }

      var6 = prune(var0, var6, var1, var2, var4, var5);
      if (!sx.isEmpty() || Baritone.settings().extendCacheOnThreshold.value && var6.size() < var2) {
         var6.addAll(BaritoneAPI.getProvider().getWorldScanner().scanChunkRadius(var0.getBaritone().getPlayerContext(), var1, var2, 10, 32));
      }

      var6.addAll(var3);
      return prune(var0, var6, var1, var2, var4, var5);
   }

   @Override
   public void mine(int var1, BlockOptionalMetaLookup var2) {
      this.filter = var2;
      if (this.filterFilter() == null) {
         this.filter = null;
      }

      this.desiredQuantity = var1;
      this.knownOreLocations = new ArrayList<>();
      this.blacklist = new ArrayList<>();
      this.branchPoint = null;
      this.branchPointRunaway = null;
      this.anticipatedDrops = new HashMap<>();
      if (var2 != null) {
         this.rescan(new ArrayList<>(), new CalculationContext(this.baritone));
      }
   }

   private PathingCommand updateGoal() {
      BlockOptionalMetaLookup var1 = this.filterFilter();
      if (var1 == null) {
         return null;
      }

      boolean sx = Baritone.settings().legitMine.value;
      var sxx = this.knownOreLocations;
      if (!sxx.isEmpty()) {
         CalculationContext sxxx = new CalculationContext(this.baritone);
         var sxxxx = prune(sxxx, new ArrayList<>(sxx), var1, Baritone.settings().mineMaxOreLocationsCount.value, this.blacklist, this.droppedItemsScan());
         Goal sxxxxx = new GoalComposite(sxxxx.stream().map(var3x -> this.coalesce(var3x, sxxxx, sxxx)).toArray(Goal[]::new));
         this.knownOreLocations = sxxxx;
         return new PathingCommand(sxxxxx, sx ? PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH : PathingCommandType.REVALIDATE_GOAL_AND_PATH);
      }

      if (!sx && !Baritone.settings().exploreForBlocks.value) {
         return null;
      }

      int sxxx = Baritone.settings().legitMineYLevel.value;
      if (this.branchPoint == null) {
         this.branchPoint = this.ctx.playerFeet();
      }

      if (this.branchPointRunaway == null) {
         this.branchPointRunaway = new GoalRunAway(1.0, sxxx, this.branchPoint)         // $VF: Compiled from s
 {
            @Override
            public boolean isInGoal(int var1, int var2, int var3) {
               return false;
            }

            @Override
            public double heuristic() {
               return Double.NEGATIVE_INFINITY;
            }
         };
      }

      return new PathingCommand(this.branchPointRunaway, PathingCommandType.REVALIDATE_GOAL_AND_PATH);
   }

   public List<BlockPos> droppedItemsScan() {
      if (!Baritone.settings().mineScanDroppedItems.value) {
         return Collections.emptyList();
      }

      List var1 = new ArrayList<>();
      if (this.ctx.world() instanceof ClientLevel sx) {
         for (Entity sxx : sx.entitiesForRendering()) {
            if (sxx instanceof ItemEntity sxxx && this.filter.has(sxxx.getItem())) {
               var1.add(sxx.blockPosition());
            }
         }

         var1.addAll(this.anticipatedDrops.keySet());
         return var1;
      } else {
         return var1;
      }
   }

   private BlockOptionalMetaLookup filterFilter() {
      if (this.filter == null) {
         return null;
      }

      if (!Baritone.settings().allowBreak.value) {
         BlockOptionalMetaLookup var1 = new BlockOptionalMetaLookup(
            this.filter
               .blocks()
               .stream()
               .filter(var0 -> Baritone.settings().allowBreakAnyway.value.contains(var0.getBlock()))
               .toArray(BlockOptionalMeta[]::new)
         );
         if (var1.blocks().isEmpty()) {
            this.logDirect(лЬ);
            return null;
         } else {
            return var1;
         }
      } else {
         return this.filter;
      }
   }

   @Override
   public boolean isActive() {
      return this.filter != null;
   }


   public static boolean plausibleToBreak(CalculationContext var0, BlockPos var1) {
      BlockState var2 = var0.bsi.get0(var1);
      if (MovementHelper.getMiningDurationTicks(var0, var1.getX(), var1.getY(), var1.getZ(), var2, true) >= л3) {
         return false;
      } else {
         return MovementHelper.avoidBreaking(var0.bsi, var1.getX(), var1.getY(), var1.getZ(), var2)
            ? false
            : var0.bsi.get0(var1.above()).getBlock() != Blocks.BEDROCK || var0.bsi.get0(var1.below()).getBlock() != Blocks.BEDROCK;
      }
   }

   private static List<BlockPos> prune(
      CalculationContext var0, List<BlockPos> var1, BlockOptionalMetaLookup var2, int var3, List<BlockPos> var4, List<BlockPos> var5
   ) {
      var5.removeIf(var3x -> {
         for (BlockPos loc : var1) {
            if (loc.distSqr(var3x) <= л1 && var2.has(var0.get(loc.getX(), loc.getY(), loc.getZ())) && plausibleToBreak(var0, loc)) {
               return true;
            }
         }

         return false;
      });
      List var6 = var1.stream()
         .distinct()
         .filter(
            var3x -> !var0.bsi.worldContainsLoadedChunk(var3x.getX(), var3x.getZ())
               || var2.has(var0.get(var3x.getX(), var3x.getY(), var3x.getZ()))
               || var5.contains(var3x)
         )
         .filter(var1x -> plausibleToBreak(var0, var1x))
         .filter(var1x -> Baritone.settings().allowOnlyExposedOres.value ? isNextToAir(var0, var1x) : true)
         .filter(var1x -> var1x.getY() >= Baritone.settings().minYLevelWhileMining.value + var0.world.dimensionType().minY())
         .filter(var0x -> var0x.getY() <= Baritone.settings().maxYLevelWhileMining.value)
         .filter(var1x -> !var4.contains(var1x))
         .sorted(Comparator.comparingDouble(var0.getBaritone().getPlayerContext().player().blockPosition()::distSqr))
         .collect(Collectors.toList());
      return var6.size() > var3 ? var6.subList(0, var3) : var6;
   }

   // $VF: Compiled from s
   private static class GoalThreeBlocks extends GoalTwoBlocks {
      private static final int Аlс = 0;
      private static final String АlЛ = "АlЛ";

      @Override
      public double heuristic(int var1, int var2, int var3) {
         int var4 = var1 - this.x;
         int sx = var2 - this.y;
         int sxx = var3 - this.z;
         return GoalBlock.calculate(var4, sx < -1 ? sx + 2 : (sx == -1 ? 0 : sx), sxx);
      }

      public GoalThreeBlocks(BlockPos var1) {
         super(var1);
      }


      @Override
      public boolean isInGoal(int var1, int var2, int var3) {
         return var1 == this.x && (var2 == this.y || var2 == this.y - 1 || var2 == this.y - 2) && var3 == this.z;
      }

      @Override
      public String toString() {
         return String.format(АlЛ, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
      }

      @Override
      public int hashCode() {
         return super.hashCode() * Аlс;
      }

      @Override
      public boolean equals(Object var1) {
         return super.equals(var1);
      }
   }
}
