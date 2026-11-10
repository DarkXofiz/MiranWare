// Original binary: hex/api/baritone/api/pathing/calc/IPath
package hex.api.baritone.api.pathing.calc;

import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.movement.IMovement;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.HashSet;
import java.util.List;

// $VF: Compiled from s
public interface IPath {
   default int length() {
      return this.positions().size();
   }

   Goal getGoal();

   List<BetterBlockPos> positions();

   default IPath cutoffAtLoadedChunks(Object var1) {
      throw new UnsupportedOperationException();
   }

   List<IMovement> movements();

   default IPath staticCutoff(Goal var1) {
      throw new UnsupportedOperationException();
   }

   int getNumNodesConsidered();

   default BetterBlockPos getSrc() {
      return this.positions().get(0);
   }

   default IPath postProcess() {
      throw new UnsupportedOperationException();
   }

   default void sanityCheck() {
      var var1 = this.positions();
      var sx = this.movements();
      if (!this.getSrc().equals(var1.get(0))) {
         throw new IllegalStateException("Start node does not equal first path element");
      }

      if (!this.getDest().equals(var1.get(var1.size() - 1))) {
         throw new IllegalStateException("End node does not equal last path element");
      }

      if (var1.size() != sx.size() + 1) {
         throw new IllegalStateException("Size of path array is unexpected");
      }

      HashSet sxx = new HashSet<>();

      for (int sxxx = 0; sxxx < var1.size() - 1; sxxx++) {
         BetterBlockPos sxxxx = var1.get(sxxx);
         BetterBlockPos sxxxxx = var1.get(sxxx + 1);
         IMovement sxxxxxx = sx.get(sxxx);
         if (!sxxxx.equals(sxxxxxx.getSrc())) {
            throw new IllegalStateException("Path source is not equal to the movement source");
         }

         if (!sxxxxx.equals(sxxxxxx.getDest())) {
            throw new IllegalStateException("Path destination is not equal to the movement destination");
         }

         if (sxx.contains(sxxxx)) {
            throw new IllegalStateException("Path doubles back on itself, making a loop");
         }

         sxx.add(sxxxx);
      }
   }

   default double ticksRemainingFrom(int var1) {
      double var2 = 0.0;
      var sx = this.movements();

      for (int sxx = var1; sxx < sx.size(); sxx++) {
         var2 += sx.get(sxx).getCost();
      }

      return var2;
   }

   default BetterBlockPos getDest() {
      var var1 = this.positions();
      return var1.get(var1.size() - 1);
   }
}
