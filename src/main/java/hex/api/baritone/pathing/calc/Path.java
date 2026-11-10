// Original binary: hex/api/baritone/pathing/calc/Path
package hex.api.baritone.pathing.calc;

import com.google.common.collect.Lists;
import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.movement.IMovement;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.Moves;
import hex.api.baritone.pathing.path.CutoffPath;
import hex.api.baritone.utils.pathing.PathBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// $VF: Compiled from s
class Path extends PathBase {
   private final BetterBlockPos start;
   private final BetterBlockPos end;
   private final List<BetterBlockPos> path;
   private final List<Movement> movements;
   private final List<PathNode> nodes;
   private final Goal goal;
   private final int numNodes;
   private final CalculationContext context;
   private volatile boolean verified;
   private static final String бдЬ = "бдЬ";
   private static final String бд1 = "бд1";
   private static final String бдя = "бдя";
   private static final String бдI = "бдI";

   @Override
   public List<IMovement> movements() {
      if (!this.verified) {
         throw new IllegalStateException(бдI);
      } else {
         return Collections.unmodifiableList(this.movements);
      }
   }


   @Override
   public IPath postProcess() {
      if (this.verified) {
         throw new IllegalStateException(бд1);
      }

      this.verified = true;
      boolean var1 = this.assembleMovements();
      this.movements.forEach(var1x -> var1x.checkLoadedChunk(this.context));
      if (var1) {
         CutoffPath sx = new CutoffPath(this, this.movements().size());
         if (sx.movements().size() != this.movements.size()) {
            throw new IllegalStateException(бдя);
         } else {
            return sx;
         }
      } else {
         this.sanityCheck();
         return this;
      }
   }

   @Override
   public Goal getGoal() {
      return this.goal;
   }

   @Override
   public int getNumNodesConsidered() {
      return this.numNodes;
   }

   @Override
   public BetterBlockPos getSrc() {
      return this.start;
   }

   @Override
   public BetterBlockPos getDest() {
      return this.end;
   }

   Path(BetterBlockPos var1, PathNode var2, PathNode var3, int var4, Goal var5, CalculationContext var6) {
      this.end = new BetterBlockPos(var3.x, var3.y, var3.z);
      this.numNodes = var4;
      this.movements = new ArrayList<>();
      this.goal = var5;
      this.context = var6;
      PathNode var7 = var3;
      List sx = new ArrayList<>();
      List sxx = new ArrayList<>();

      while (var7 != null) {
         sxx.add(var7);
         sx.add(new BetterBlockPos(var7.x, var7.y, var7.z));
         var7 = var7.previous;
      }

      BetterBlockPos sxxx = new BetterBlockPos(var2.x, var2.y, var2.z);
      if (!var1.equals(sxxx) && var2.equals(var3)) {
         this.start = var1;
         PathNode sxxxx = new PathNode(var1.x, var1.y, var1.z, var5);
         sxxxx.cost = 0.0;
         sxx.add(sxxxx);
         sx.add(var1);
      } else {
         this.start = sxxx;
      }

      this.path = Lists.reverse(sx);
      this.nodes = Lists.reverse(sxx);
   }

   @Override
   public List<BetterBlockPos> positions() {
      return Collections.unmodifiableList(this.path);
   }

   private boolean assembleMovements() {
      if (!this.path.isEmpty() && this.movements.isEmpty()) {
         for (int var1 = 0; var1 < this.path.size() - 1; var1++) {
            double sx = this.nodes.get(var1 + 1).cost - this.nodes.get(var1).cost;
            Movement sxx = this.runBackwards(this.path.get(var1), this.path.get(var1 + 1), sx);
            if (sxx == null) {
               return true;
            }

            this.movements.add(sxx);
         }

         return false;
      } else {
         throw new IllegalStateException(бдЬ);
      }
   }

   private Movement runBackwards(BetterBlockPos var1, BetterBlockPos var2, double var3) {
      for (Moves var8 : Moves.values()) {
         Movement sx = var8.apply0(this.context, var1);
         if (sx.getDest().equals(var2)) {
            sx.override(Math.min(sx.calculateCost(this.context), var3));
            return sx;
         }
      }

      Helper.HELPER.logDebug("Movement became impossible during calculation " + var1 + " " + var2 + " " + var2.subtract(var1));
      return null;
   }
}
