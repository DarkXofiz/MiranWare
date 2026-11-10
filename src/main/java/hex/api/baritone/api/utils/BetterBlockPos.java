// Original binary: hex/api/baritone/api/utils/BetterBlockPos
package hex.api.baritone.api.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

// $VF: Compiled from s
public final class BetterBlockPos extends BlockPos {
   private static final int NUM_X_BITS = 26;
   private static final int NUM_Z_BITS = 26;
   private static final int NUM_Y_BITS = 12;
   private static final int Y_SHIFT = 26;
   private static final int X_SHIFT = 38;
   private static final long X_MASK = 67108863L;
   private static final long Y_MASK = 4095L;
   private static final long Z_MASK = 67108863L;
   public static final BetterBlockPos ORIGIN = new BetterBlockPos(0, 0, 0);
   public final int x;
   public final int y;
   public final int z;
   private static final long б3ж = 0;
   private static final long б38 = 0;
   private static final long б3Т = 0;
   private static final long б3Й = 0;
   private static final String б3э = "б3э";
   private static final long б3О = 0;
   private static final long б3И = 0;
   private static final long б3П = 0;

   public BetterBlockPos south() {
      return new BetterBlockPos(this.x, this.y, this.z + 1);
   }

   public static BetterBlockPos deserializeFromLong(long var0) {
      int var2 = (int)(var0 << 0 >> 38);
      int sx = (int)(var0 << 26 >> 52);
      int sxx = (int)(var0 << 38 >> 38);
      return new BetterBlockPos(var2, sx, sxx);
   }

   public BetterBlockPos below() {
      return new BetterBlockPos(this.x, this.y - 1, this.z);
   }

   public static long longHash(BetterBlockPos var0) {
      return longHash(var0.x, var0.y, var0.z);
   }

   public BetterBlockPos(BlockPos var1) {
      this(var1.getX(), var1.getY(), var1.getZ());
   }

   public BetterBlockPos north(int var1) {
      return var1 == 0 ? this : new BetterBlockPos(this.x, this.y, this.z - var1);
   }

   public BetterBlockPos relative(Direction var1) {
      Vec3i var2 = var1.getUnitVec3i();
      return new BetterBlockPos(this.x + var2.getX(), this.y + var2.getY(), this.z + var2.getZ());
   }

   public BetterBlockPos east(int var1) {
      return var1 == 0 ? this : new BetterBlockPos(this.x + var1, this.y, this.z);
   }

   public BetterBlockPos(int var1, int var2, int var3) {
      super(var1, var2, var3);
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }

   public static long serializeToLong(int var0, int var1, int var2) {
      return (var0 & б3О) << 38 | (var1 & б3И) << 26 | var2 & б3П;
   }

   public BetterBlockPos(double var1, double var3, double var5) {
      this(Mth.floor(var1), Mth.floor(var3), Mth.floor(var5));
   }

   @NotNull
   @Override
   public String toString() {
      return String.format(б3э, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
   }

   public BetterBlockPos west() {
      return new BetterBlockPos(this.x - 1, this.y, this.z);
   }

   public BetterBlockPos above() {
      return new BetterBlockPos(this.x, this.y + 1, this.z);
   }


   public static long longHash(int var0, int var1, int var2) {
      long var3 = б3ж;
      var3 = б38 * var3 + var0;
      var3 = б3Т * var3 + var1;
      return б3Й * var3 + var2;
   }

   public BetterBlockPos north() {
      return new BetterBlockPos(this.x, this.y, this.z - 1);
   }

   public double distanceSq(BetterBlockPos var1) {
      double var2 = (double)this.x - var1.x;
      double sx = (double)this.y - var1.y;
      double sxx = (double)this.z - var1.z;
      return var2 * var2 + sx * sx + sxx * sxx;
   }

   public BetterBlockPos above(int var1) {
      return var1 == 0 ? this : new BetterBlockPos(this.x, this.y + var1, this.z);
   }

   @Override
   public int hashCode() {
      return (int)longHash(this.x, this.y, this.z);
   }

   public BetterBlockPos relative(Direction var1, int var2) {
      if (var2 == 0) {
         return this;
      }

      Vec3i var3 = var1.getUnitVec3i();
      return new BetterBlockPos(this.x + var3.getX() * var2, this.y + var3.getY() * var2, this.z + var3.getZ() * var2);
   }

   public BetterBlockPos south(int var1) {
      return var1 == 0 ? this : new BetterBlockPos(this.x, this.y, this.z + var1);
   }

   public BetterBlockPos east() {
      return new BetterBlockPos(this.x + 1, this.y, this.z);
   }

   public static BetterBlockPos from(BlockPos var0) {
      return var0 == null ? null : new BetterBlockPos(var0);
   }

   public BetterBlockPos below(int var1) {
      return var1 == 0 ? this : new BetterBlockPos(this.x, this.y - var1, this.z);
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == null) {
         return false;
      } else if (var1 instanceof BetterBlockPos var3) {
         return var3.x == this.x && var3.y == this.y && var3.z == this.z;
      } else {
         BlockPos var2 = (BlockPos)var1;
         return var2.getX() == this.x && var2.getY() == this.y && var2.getZ() == this.z;
      }
   }

   public BetterBlockPos west(int var1) {
      return var1 == 0 ? this : new BetterBlockPos(this.x - var1, this.y, this.z);
   }

   public double distanceTo(BetterBlockPos var1) {
      double var2 = (double)this.x - var1.x;
      double sx = (double)this.y - var1.y;
      double sxx = (double)this.z - var1.z;
      return Math.sqrt(var2 * var2 + sx * sx + sxx * sxx);
   }
}
