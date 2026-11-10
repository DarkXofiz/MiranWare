// Original binary: hex/api/baritone/pathing/calc/openset/BinaryHeapOpenSet
package hex.api.baritone.pathing.calc.openset;

import hex.api.baritone.pathing.calc.PathNode;
import java.util.Arrays;

// $VF: Compiled from s
public final class BinaryHeapOpenSet implements IOpenSet {
   private static final int INITIAL_CAPACITY = 1024;
   private PathNode[] array;
   private int size = 0;
   private static final String бЯх = "бЯх";

   @Override
   public final void update(PathNode var1) {
      int var2 = var1.heapPosition;
      int sx = var2 >>> 1;
      double sxx = var1.combinedCost;

      for (PathNode sxxx = this.array[sx]; var2 > 1 && sxxx.combinedCost > sxx; sxxx = this.array[sx]) {
         this.array[var2] = sxxx;
         this.array[sx] = var1;
         var1.heapPosition = sx;
         sxxx.heapPosition = var2;
         var2 = sx;
         sx = var2 >>> 1;
      }
   }

   @Override
   public final boolean isEmpty() {
      return this.size == 0;
   }

   public int size() {
      return this.size;
   }

   @Override
   public final void insert(PathNode var1) {
      if (this.size >= this.array.length - 1) {
         this.array = Arrays.copyOf(this.array, this.array.length << 1);
      }

      this.size++;
      var1.heapPosition = this.size;
      this.array[this.size] = var1;
      this.update(var1);
   }


   public BinaryHeapOpenSet() {
      this(1024);
   }

   @Override
   public final PathNode removeLowest() {
      if (this.size == 0) {
         throw new IllegalStateException(бЯх);
      }

      PathNode var1 = this.array[1];
      PathNode sx = this.array[this.size];
      this.array[1] = sx;
      sx.heapPosition = 1;
      this.array[this.size] = null;
      this.size--;
      var1.heapPosition = -1;
      if (this.size < 2) {
         return var1;
      }

      int sxx = 1;
      int sxxx = 2;
      double sxxxx = sx.combinedCost;

      do {
         PathNode sxxxxx = this.array[sxxx];
         double sxxxxxx = sxxxxx.combinedCost;
         if (sxxx < this.size) {
            PathNode sxxxxxxx = this.array[sxxx + 1];
            double sxxxxxxxx = sxxxxxxx.combinedCost;
            if (sxxxxxx > sxxxxxxxx) {
               sxxx++;
               sxxxxxx = sxxxxxxxx;
               sxxxxx = sxxxxxxx;
            }
         }

         if (sxxxx <= sxxxxxx) {
            break;
         }

         this.array[sxx] = sxxxxx;
         this.array[sxxx] = sx;
         sx.heapPosition = sxxx;
         sxxxxx.heapPosition = sxx;
         sxx = sxxx;
      } while ((sxxx <<= 1) <= this.size);

      return var1;
   }

   public BinaryHeapOpenSet(int var1) {
      this.array = new PathNode[var1];
   }
}
