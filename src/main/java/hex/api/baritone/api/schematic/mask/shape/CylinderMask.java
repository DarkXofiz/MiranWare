// Original binary: hex/api/baritone/api/schematic/mask/shape/CylinderMask
package hex.api.baritone.api.schematic.mask.shape;

import hex.api.baritone.api.schematic.mask.AbstractMask;
import hex.api.baritone.api.schematic.mask.StaticMask;
import net.minecraft.core.Direction.Axis;

// $VF: Compiled from s
public final class CylinderMask extends AbstractMask implements StaticMask {
   private final double centerA;
   private final double centerB;
   private final double radiusSqA;
   private final double radiusSqB;
   private final boolean filled;
   private final Axis alignment;
   private static final double field00005 = 1.0;
   private static final double field00006 = 1.0;
   private static final double field00007 = 0;
   private static final double field00008 = 0;

   @Override
   public boolean partOfMask(int var1, int var2, int var3) {
      double var4 = Math.abs(getA(var1, var2, this.alignment) + field00007 - this.centerA);
      double sx = Math.abs(getB(var2, var3, this.alignment) + field00008 - this.centerB);
      return this.outside(var4, sx) ? false : this.filled || this.outside(var4 + 1.0, sx) || this.outside(var4, sx + 1.0);
   }

   private boolean outside(double var1, double var3) {
      return var1 * var1 / this.radiusSqA + var3 * var3 / this.radiusSqB > 1.0;
   }

   public CylinderMask(int var1, int var2, int var3, boolean var4, Axis var5) {
      super(var1, var2, var3);
      this.centerA = getA(var1, var2, var5) / field00005;
      this.centerB = getB(var2, var3, var5) / field00006;
      this.radiusSqA = (this.centerA - 1.0) * (this.centerA - 1.0);
      this.radiusSqB = (this.centerB - 1.0) * (this.centerB - 1.0);
      this.filled = var4;
      this.alignment = var5;
   }

   private static int getA(int var0, int var1, Axis var2) {
      return var2 == Axis.X ? var1 : var0;
   }


   private static int getB(int var0, int var1, Axis var2) {
      return var2 == Axis.Z ? var0 : var1;
   }
}
