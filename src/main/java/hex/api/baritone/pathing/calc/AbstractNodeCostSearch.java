// Original binary: hex/api/baritone/pathing/calc/AbstractNodeCostSearch
package hex.api.baritone.pathing.calc;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.calc.IPathFinder;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.api.utils.PathCalculationResult;
import hex.api.baritone.pathing.movement.CalculationContext;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Optional;

// $VF: Compiled from s
public abstract class AbstractNodeCostSearch implements IPathFinder, Helper {
   protected final BetterBlockPos realStart;
   protected final int startX;
   protected final int startY;
   protected final int startZ;
   protected final Goal goal;
   private final CalculationContext context;
   private final Long2ObjectOpenHashMap<PathNode> map;
   protected PathNode startNode;
   protected PathNode mostRecentConsidered;
   protected final PathNode[] bestSoFar;
   private volatile boolean isFinished;
   protected boolean cancelRequested;
   protected static final double[] COEFFICIENTS = new double[]{
      AbstractNodeCostSearch.Ни,
      AbstractNodeCostSearch.Нщ,
      AbstractNodeCostSearch.шб,
      AbstractNodeCostSearch.шА,
      AbstractNodeCostSearch.ш诶,
      AbstractNodeCostSearch.шЫ,
      AbstractNodeCostSearch.шз
   };
   protected static final double MIN_DIST_PATH = 5.0;
   protected static final double MIN_IMPROVEMENT = 0.01;
   private static final String Н必 = "Н必";
   private static final String НЗ = "НЗ";
   private static final String Нн = "Нн";
   private static final double НД = 0;
   private static final double НН = 0;
   private static final String Нш = "Нш";
   private static final String Нл = "Нл";
   private static final double Ни = 0;
   private static final double Нщ = 0;
   private static final double шб = 0;
   private static final double шА = 0;
   private static final double ш诶 = 0;
   private static final double шЫ = 0;
   private static final double шз = 0;

   protected PathNode getNodeAtPosition(int var1, int var2, int var3, long var4) {
      PathNode var6 = (PathNode)this.map.get(var4);
      if (var6 == null) {
         var6 = new PathNode(var1, var2, var3, this.goal);
         this.map.put(var4, var6);
      }

      return var6;
   }

   @Override
   public Optional<IPath> pathToMostRecentNodeConsidered() {
      return Optional.ofNullable(this.mostRecentConsidered).map(var1 -> new Path(this.realStart, this.startNode, var1, 0, this.goal, this.context));
   }

   protected double getDistFromStartSq(PathNode var1) {
      int var2 = var1.x - this.startX;
      int sx = var1.y - this.startY;
      int sxx = var1.z - this.startZ;
      return var2 * var2 + sx * sx + sxx * sxx;
   }

   AbstractNodeCostSearch(BetterBlockPos var1, int var2, int var3, int var4, Goal var5, CalculationContext var6) {
      this.bestSoFar = new PathNode[COEFFICIENTS.length];
      this.realStart = var1;
      this.startX = var2;
      this.startY = var3;
      this.startZ = var4;
      this.goal = var5;
      this.context = var6;
      this.map = new Long2ObjectOpenHashMap(Baritone.settings().pathingMapDefaultSize.value, Baritone.settings().pathingMapLoadFactor.value);
   }

   @Override
   public synchronized PathCalculationResult calculate(long var1, long var3) {
      if (this.isFinished) {
         throw new IllegalStateException(Н必);
      }

      this.cancelRequested = false;

      try {
         IPath var5 = this.calculate0(var1, var3).map(IPath::postProcess).orElse(null);
         if (this.cancelRequested) {
            return new PathCalculationResult(PathCalculationResult.Type.CANCELLATION);
         }

         if (var5 == null) {
            return new PathCalculationResult(PathCalculationResult.Type.FAILURE);
         }

         int sx = var5.length();
         var5 = var5.cutoffAtLoadedChunks(this.context.bsi);
         if (var5.length() < sx) {
            Helper.HELPER.logDebug(НЗ);
            Helper.HELPER.logDebug("Length decreased by " + (sx - var5.length()));
         } else {
            Helper.HELPER.logDebug(Нн);
         }

         sx = var5.length();
         var5 = var5.staticCutoff(this.goal);
         if (var5.length() < sx) {
            Helper.HELPER.logDebug("Static cutoff " + sx + " to " + var5.length());
         }

         return this.goal.isInGoal(var5.getDest())
            ? new PathCalculationResult(PathCalculationResult.Type.SUCCESS_TO_GOAL, var5)
            : new PathCalculationResult(PathCalculationResult.Type.SUCCESS_SEGMENT, var5);
      } catch (Exception var11) {
         Helper.HELPER.logDirect("Pathing exception: " + var11);
         return new PathCalculationResult(PathCalculationResult.Type.EXCEPTION);
      } finally {
         this.isFinished = true;
      }
   }

   public void cancel() {
      this.cancelRequested = true;
   }

   @Override
   public final boolean isFinished() {
      return this.isFinished;
   }

   public BetterBlockPos getStart() {
      return new BetterBlockPos(this.startX, this.startY, this.startZ);
   }

   protected Optional<IPath> bestSoFar(boolean var1, int var2) {
      if (this.startNode == null) {
         return Optional.empty();
      }

      double var3 = 0.0;

      for (int sx = 0; sx < COEFFICIENTS.length; sx++) {
         if (this.bestSoFar[sx] != null) {
            double sxx = this.getDistFromStartSq(this.bestSoFar[sx]);
            if (sxx > var3) {
               var3 = sxx;
            }

            if (sxx > НД) {
               if (var1) {
                  if (COEFFICIENTS[sx] >= НН) {
                  }

                  this.logDebug("A* cost coefficient " + COEFFICIENTS[sx]);
               }

               return Optional.of(new Path(this.realStart, this.startNode, this.bestSoFar[sx], var2, this.goal, this.context));
            }
         }
      }

      if (var1) {
         this.logDebug("Even with a cost coefficient of " + COEFFICIENTS[COEFFICIENTS.length - 1] + ", I couldn't get more than " + Math.sqrt(var3) + " blocks");
         this.logDebug(Нш);
         this.logNotification(Нл, true);
      }

      return Optional.empty();
   }

   protected int mapSize() {
      return this.map.size();
   }

   protected abstract Optional<IPath> calculate0(long var1, long var3);

   @Override
   public Optional<IPath> bestPathSoFar() {
      return this.bestSoFar(false, 0);
   }


   @Override
   public final Goal getGoal() {
      return this.goal;
   }
}
