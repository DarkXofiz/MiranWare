// Original binary: hex/api/baritone/utils/pathing/MutableMoveResult
package hex.api.baritone.utils.pathing;


// $VF: Compiled from s
public final class MutableMoveResult {
   public int x;
   public int y;
   public int z;
   public double cost;
   private static final double бПь = 0;

   public final void reset() {
      this.x = 0;
      this.y = 0;
      this.z = 0;
      this.cost = бПь;
   }


   public MutableMoveResult() {
      this.reset();
   }
}
