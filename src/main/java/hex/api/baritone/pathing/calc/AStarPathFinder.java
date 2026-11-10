// Original binary: hex/api/baritone/pathing/calc/AStarPathFinder
package hex.api.baritone.pathing.calc;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.pathing.calc.openset.BinaryHeapOpenSet;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Moves;
import hex.api.baritone.utils.pathing.BetterWorldBorder;
import hex.api.baritone.utils.pathing.Favoring;
import hex.api.baritone.utils.pathing.MutableMoveResult;
import java.util.Optional;

// $VF: Compiled from s
public final class AStarPathFinder extends AbstractNodeCostSearch {
   private final Favoring favoring;
   private final CalculationContext calcContext;
   private static final double Ач弟 = 0;
   private static final double АчВ = 0;
   private static final String Ачж = "Ачж";
   private static final String Ач8 = "Ач8";
   private static final String АчТ = "АчТ";
   private static final double АчЙ = 0;


   public AStarPathFinder(BetterBlockPos var1, int var2, int var3, int var4, Goal var5, Favoring var6, CalculationContext var7) {
      super(var1, var2, var3, var4, var5, var7);
      this.favoring = var6;
      this.calcContext = var7;
   }

   @Override
   protected Optional<IPath> calculate0(long var1, long var3) {
      int var5 = this.calcContext.world.dimensionType().minY();
      int sx = this.calcContext.world.dimensionType().height();
      this.startNode = this.getNodeAtPosition(this.startX, this.startY, this.startZ, BetterBlockPos.longHash(this.startX, this.startY, this.startZ));
      this.startNode.cost = 0.0;
      this.startNode.combinedCost = this.startNode.estimatedCostToGoal;
      BinaryHeapOpenSet sxx = new BinaryHeapOpenSet();
      sxx.insert(this.startNode);
      double[] sxxx = new double[COEFFICIENTS.length];

      for (int sxxxx = 0; sxxxx < sxxx.length; sxxxx++) {
         sxxx[sxxxx] = this.startNode.estimatedCostToGoal;
         this.bestSoFar[sxxxx] = this.startNode;
      }

      MutableMoveResult sxxxx = new MutableMoveResult();
      BetterWorldBorder sxxxxx = new BetterWorldBorder(this.calcContext.world.getWorldBorder());
      long sxxxxxx = System.currentTimeMillis();
      boolean sxxxxxxx = Baritone.settings().slowPath.value;
      if (sxxxxxxx) {
         this.logDebug("slowPath is on, path timeout will be " + Baritone.settings().slowPathTimeoutMS.value + "ms instead of " + var1 + "ms");
      }

      long sxxxxxxxx = sxxxxxx + (sxxxxxxx ? Baritone.settings().slowPathTimeoutMS.value : var1);
      long sxxxxxxxxx = sxxxxxx + (sxxxxxxx ? Baritone.settings().slowPathTimeoutMS.value : var3);
      boolean sxxxxxxxxxx = true;
      int sxxxxxxxxxxx = 0;
      int sxxxxxxxxxxxx = 0;
      int sxxxxxxxxxxxxx = 0;
      boolean sxxxxxxxxxxxxxx = !this.favoring.isEmpty();
      int sxxxxxxxxxxxxxxx = 64;
      int sxxxxxxxxxxxxxxxx = Baritone.settings().pathingMaxChunkBorderFetch.value;
      double sxxxxxxxxxxxxxxxxx = Baritone.settings().minimumImprovementRepropagation.value ? Ач弟 : 0.0;
      Moves[] sxxxxxxxxxxxxxxxxxx = Moves.values();

      while (!sxx.isEmpty() && sxxxxxxxxxxxxx < sxxxxxxxxxxxxxxxx && !this.cancelRequested) {
         if ((sxxxxxxxxxxx & sxxxxxxxxxxxxxxx - 1) == 0) {
            long sxxxxxxxxxxxxxxxxxxx = System.currentTimeMillis();
            if (sxxxxxxxxxxxxxxxxxxx - sxxxxxxxxx >= 0L || !sxxxxxxxxxx && sxxxxxxxxxxxxxxxxxxx - sxxxxxxxx >= 0L) {
               break;
            }
         }

         if (sxxxxxxx) {
            try {
               Thread.sleep(Baritone.settings().slowPathTimeDelayMS.value);
            } catch (InterruptedException var45) {
            }
         }

         PathNode sxxxxxxxxxxxxxxxxxxx = sxx.removeLowest();
         this.mostRecentConsidered = sxxxxxxxxxxxxxxxxxxx;
         sxxxxxxxxxxx++;
         if (this.goal.isInGoal(sxxxxxxxxxxxxxxxxxxx.x, sxxxxxxxxxxxxxxxxxxx.y, sxxxxxxxxxxxxxxxxxxx.z)) {
            this.logDebug("Took " + (System.currentTimeMillis() - sxxxxxx) + "ms, " + sxxxxxxxxxxxx + " movements considered");
            return Optional.of(new Path(this.realStart, this.startNode, sxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxx, this.goal, this.calcContext));
         }

         for (Moves sxxxxxxxxxxxxxxxxxxxx : sxxxxxxxxxxxxxxxxxx) {
            int sxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxx.x + sxxxxxxxxxxxxxxxxxxxx.xOffset;
            int sxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxx.z + sxxxxxxxxxxxxxxxxxxxx.zOffset;
            if ((sxxxxxxxxxxxxxxxxxxxxx >> 4 != sxxxxxxxxxxxxxxxxxxx.x >> 4 || sxxxxxxxxxxxxxxxxxxxxxx >> 4 != sxxxxxxxxxxxxxxxxxxx.z >> 4)
               && !this.calcContext.isLoaded(sxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxx)) {
               if (!sxxxxxxxxxxxxxxxxxxxx.dynamicXZ) {
                  sxxxxxxxxxxxxx++;
               }
            } else if ((sxxxxxxxxxxxxxxxxxxxx.dynamicXZ || sxxxxx.entirelyContains(sxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxx))
               && sxxxxxxxxxxxxxxxxxxx.y + sxxxxxxxxxxxxxxxxxxxx.yOffset <= sx
               && sxxxxxxxxxxxxxxxxxxx.y + sxxxxxxxxxxxxxxxxxxxx.yOffset >= var5) {
               sxxxx.reset();
               sxxxxxxxxxxxxxxxxxxxx.apply(this.calcContext, sxxxxxxxxxxxxxxxxxxx.x, sxxxxxxxxxxxxxxxxxxx.y, sxxxxxxxxxxxxxxxxxxx.z, sxxxx);
               sxxxxxxxxxxxx++;
               double sxxxxxxxxxxxxxxxxxxxxxxx = sxxxx.cost;
               if (!(sxxxxxxxxxxxxxxxxxxxxxxx >= АчВ)) {
                  if (sxxxxxxxxxxxxxxxxxxxxxxx <= 0.0 || Double.isNaN(sxxxxxxxxxxxxxxxxxxxxxxx)) {
                     throw new IllegalStateException(
                        String.format(
                           Ачж,
                           sxxxxxxxxxxxxxxxxxxxx,
                           SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.x),
                           SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.y),
                           SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.z),
                           sxxxxxxxxxxxxxxxxxxxxxxx
                        )
                     );
                  }

                  if (!sxxxxxxxxxxxxxxxxxxxx.dynamicXZ || sxxxxx.entirelyContains(sxxxx.x, sxxxx.z)) {
                     if (!sxxxxxxxxxxxxxxxxxxxx.dynamicXZ && (sxxxx.x != sxxxxxxxxxxxxxxxxxxxxx || sxxxx.z != sxxxxxxxxxxxxxxxxxxxxxx)) {
                        throw new IllegalStateException(
                           String.format(
                              Ач8,
                              sxxxxxxxxxxxxxxxxxxxx,
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.x),
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.y),
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.z),
                              SettingsUtil.maybeCensor(sxxxx.x),
                              SettingsUtil.maybeCensor(sxxxx.z),
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxxxx),
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxxxxx)
                           )
                        );
                     }

                     if (!sxxxxxxxxxxxxxxxxxxxx.dynamicY && sxxxx.y != sxxxxxxxxxxxxxxxxxxx.y + sxxxxxxxxxxxxxxxxxxxx.yOffset) {
                        throw new IllegalStateException(
                           String.format(
                              АчТ,
                              sxxxxxxxxxxxxxxxxxxxx,
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.x),
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.y),
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.z),
                              SettingsUtil.maybeCensor(sxxxx.y),
                              SettingsUtil.maybeCensor(sxxxxxxxxxxxxxxxxxxx.y + sxxxxxxxxxxxxxxxxxxxx.yOffset)
                           )
                        );
                     }

                     long sxxxxxxxxxxxxxxxxxxxxxxxx = BetterBlockPos.longHash(sxxxx.x, sxxxx.y, sxxxx.z);
                     if (sxxxxxxxxxxxxxx) {
                        sxxxxxxxxxxxxxxxxxxxxxxx *= this.favoring.calculate(sxxxxxxxxxxxxxxxxxxxxxxxx);
                     }

                     PathNode sxxxxxxxxxxxxxxxxxxxxxxxxx = this.getNodeAtPosition(sxxxx.x, sxxxx.y, sxxxx.z, sxxxxxxxxxxxxxxxxxxxxxxxx);
                     double sxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxx.cost + sxxxxxxxxxxxxxxxxxxxxxxx;
                     if (sxxxxxxxxxxxxxxxxxxxxxxxxx.cost - sxxxxxxxxxxxxxxxxxxxxxxxxxx > sxxxxxxxxxxxxxxxxx) {
                        sxxxxxxxxxxxxxxxxxxxxxxxxx.previous = sxxxxxxxxxxxxxxxxxxx;
                        sxxxxxxxxxxxxxxxxxxxxxxxxx.cost = sxxxxxxxxxxxxxxxxxxxxxxxxxx;
                        sxxxxxxxxxxxxxxxxxxxxxxxxx.combinedCost = sxxxxxxxxxxxxxxxxxxxxxxxxxx + sxxxxxxxxxxxxxxxxxxxxxxxxx.estimatedCostToGoal;
                        if (sxxxxxxxxxxxxxxxxxxxxxxxxx.isOpen()) {
                           sxx.update(sxxxxxxxxxxxxxxxxxxxxxxxxx);
                        } else {
                           sxx.insert(sxxxxxxxxxxxxxxxxxxxxxxxxx);
                        }

                        for (int sxxxxxxxxxxxxxxxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxxxxxxxxxxxxxxxx < COEFFICIENTS.length; sxxxxxxxxxxxxxxxxxxxxxxxxxxx++) {
                           double sxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxx.estimatedCostToGoal
                              + sxxxxxxxxxxxxxxxxxxxxxxxxx.cost / COEFFICIENTS[sxxxxxxxxxxxxxxxxxxxxxxxxxxx];
                           if (sxxx[sxxxxxxxxxxxxxxxxxxxxxxxxxxx] - sxxxxxxxxxxxxxxxxxxxxxxxxxxxx > sxxxxxxxxxxxxxxxxx) {
                              sxxx[sxxxxxxxxxxxxxxxxxxxxxxxxxxx] = sxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                              this.bestSoFar[sxxxxxxxxxxxxxxxxxxxxxxxxxxx] = sxxxxxxxxxxxxxxxxxxxxxxxxx;
                              if (sxxxxxxxxxx && this.getDistFromStartSq(sxxxxxxxxxxxxxxxxxxxxxxxxx) > АчЙ) {
                                 sxxxxxxxxxx = false;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (this.cancelRequested) {
         return Optional.empty();
      }

      var sxxxxxxxxxxxxxxxxxxx = this.bestSoFar(true, sxxxxxxxxxxx);
      if (sxxxxxxxxxxxxxxxxxxx.isPresent()) {
         this.logDebug("Took " + (System.currentTimeMillis() - sxxxxxx) + "ms, " + sxxxxxxxxxxxx + " movements considered");
      }

      return sxxxxxxxxxxxxxxxxxxx;
   }
}
