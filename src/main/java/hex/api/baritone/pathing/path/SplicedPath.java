// Original binary: hex/api/baritone/pathing/path/SplicedPath
package hex.api.baritone.pathing.path;

import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.movement.IMovement;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.utils.pathing.PathBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

// $VF: Compiled from s
public class SplicedPath extends PathBase {
   private final List<BetterBlockPos> path;
   private final List<IMovement> movements;
   private final int numNodes;
   private final Goal goal;
   private static final String 诶х衣 = "诶х衣";


   @Override
   public Goal getGoal() {
      return this.goal;
   }

   public static Optional<SplicedPath> trySplice(IPath var0, IPath var1, boolean var2) {
      if (var1 != null && var0 != null) {
         if (!var0.getDest().equals(var1.getSrc())) {
            return Optional.empty();
         }

         var var3 = new HashSet<>(var1.positions());
         int sx = -1;

         for (int sxx = 0; sxx < var0.length() - 1; sxx++) {
            if (var3.contains(var0.positions().get(sxx))) {
               sx = sxx;
               break;
            }
         }

         if (sx != -1) {
            if (!var2) {
               return Optional.empty();
            }
         } else {
            sx = var0.length() - 1;
         }

         int sxx = var1.positions().indexOf(var0.positions().get(sx));
         if (!var2 && sxx != 0) {
            throw new IllegalStateException(诶х衣);
         }

         List sxxx = new ArrayList<>();
         List sxxxx = new ArrayList<>();
         sxxx.addAll(var0.positions().subList(0, sx + 1));
         sxxxx.addAll(var0.movements().subList(0, sx));
         sxxx.addAll(var1.positions().subList(sxx + 1, var1.length()));
         sxxxx.addAll(var1.movements().subList(sxx, var1.length() - 1));
         return Optional.of(new SplicedPath(sxxx, sxxxx, var0.getNumNodesConsidered() + var1.getNumNodesConsidered(), var0.getGoal()));
      } else {
         return Optional.empty();
      }
   }

   @Override
   public List<IMovement> movements() {
      return Collections.unmodifiableList(this.movements);
   }

   private SplicedPath(List<BetterBlockPos> var1, List<IMovement> var2, int var3, Goal var4) {
      this.path = var1;
      this.movements = var2;
      this.numNodes = var3;
      this.goal = var4;
      this.sanityCheck();
   }

   @Override
   public int getNumNodesConsidered() {
      return this.numNodes;
   }

   @Override
   public int length() {
      return this.path.size();
   }

   @Override
   public List<BetterBlockPos> positions() {
      return Collections.unmodifiableList(this.path);
   }
}
