// Original binary: hex/api/baritone/selection/Selection
package hex.api.baritone.selection;

import hex.api.baritone.api.selection.ISelection;
import hex.api.baritone.api.utils.BetterBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.AABB;

// $VF: Compiled from s
public class Selection implements ISelection {
   private final BetterBlockPos pos1;
   private final BetterBlockPos pos2;
   private final BetterBlockPos min;
   private final BetterBlockPos max;
   private final Vec3i size;
   private final AABB aabb;
   private static final String б3_ = "б3_";
   private static final String б3с = "б3с";

   @Override
   public String toString() {
      return String.format(б3_, this.pos1, this.pos2);
   }


   public Selection(BetterBlockPos var1, BetterBlockPos var2) {
      this.pos1 = var1;
      this.pos2 = var2;
      this.min = new BetterBlockPos(Math.min(var1.x, var2.x), Math.min(var1.y, var2.y), Math.min(var1.z, var2.z));
      this.max = new BetterBlockPos(Math.max(var1.x, var2.x), Math.max(var1.y, var2.y), Math.max(var1.z, var2.z));
      this.size = new Vec3i(this.max.x - this.min.x + 1, this.max.y - this.min.y + 1, this.max.z - this.min.z + 1);
      this.aabb = new AABB(this.min.x, this.min.y, this.min.z, this.max.x + 1, this.max.y + 1, this.max.z + 1);
   }

   @Override
   public BetterBlockPos pos1() {
      return this.pos1;
   }

   @Override
   public AABB aabb() {
      return this.aabb;
   }

   @Override
   public BetterBlockPos min() {
      return this.min;
   }

   private boolean isPos2(Direction var1) {
      boolean var2 = var1.getAxisDirection().getStep() < 0;
      switch (var1.getAxis()) {
         case X:
            return this.pos2.x > this.pos1.x ^ var2;
         case Y:
            return this.pos2.y > this.pos1.y ^ var2;
         case Z:
            return this.pos2.z > this.pos1.z ^ var2;
         default:
            throw new IllegalStateException(б3с);
      }
   }

   @Override
   public int hashCode() {
      return this.pos1.hashCode() ^ this.pos2.hashCode();
   }

   @Override
   public BetterBlockPos max() {
      return this.max;
   }

   @Override
   public ISelection contract(Direction var1, int var2) {
      return this.isPos2(var1) ? new Selection(this.pos1.relative(var1, var2), this.pos2) : new Selection(this.pos1, this.pos2.relative(var1, var2));
   }

   @Override
   public BetterBlockPos pos2() {
      return this.pos2;
   }

   @Override
   public ISelection expand(Direction var1, int var2) {
      return this.isPos2(var1) ? new Selection(this.pos1, this.pos2.relative(var1, var2)) : new Selection(this.pos1.relative(var1, var2), this.pos2);
   }

   @Override
   public ISelection shift(Direction var1, int var2) {
      return new Selection(this.pos1.relative(var1, var2), this.pos2.relative(var1, var2));
   }

   @Override
   public Vec3i size() {
      return this.size;
   }
}
