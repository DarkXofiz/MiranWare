// Original binary: sg/ec/x7iM0shUmwIRzIOW
package sg.ec;

import it.unimi.dsi.fastutil.HashCommon;
import java.util.Arrays;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class CollisionBlockView implements BlockGetter, MinecraftAccess {
   public static final CollisionBlockView field25700 = new CollisionBlockView();
   private static final int field25701 = 8192;
   private static final int field25702 = 0;
   private static final double field25703 = 0;
   private static final double field25704 = 0;
   private final long[] field25705 = new long[8192];
   private final BlockState[] field25706 = new BlockState[8192];
   private int field25707;
   private Object field25708;
   private final long[] field25709;
   private final VoxelShape[] field25710;
   private final int[] field25711;
   private CollisionContext field25712;
   private int field25713;
   private Vec3 field25714;
   private Vec3 field25715;
   private CollisionContext field25716;
   private boolean field25717;
   private static final int field25718 = Integer.MIN_VALUE;
   private static final double field25719 = 1.0E-7;
   private static final double field25720 = 0.001;
   private static final double field25721 = 0.001;
   private static final double field25722 = 0.001;
   private static final double field25723 = 1.0E-7;
   private static final double field25724 = -1.0E-7;
   private static final double field25725 = 1.0E-7;
   private static final double field25726 = -1.0E-7;
   private static final double field25727 = 1.0E-7;
   private static final double field25728 = -1.0E-7;
   private static final double field25729 = -1.0;
   private static final double field25730 = 1.0E-7;
   private static final double field25731 = 1.0E-7;
   private static final double field25732 = 1.0E-7;
   private static final double field25733 = 1.0E-7;
   private static final long field25734 = -7046029254386353131L;
   private static final int field25735 = Integer.MIN_VALUE;

   public void invalidate() {
      Arrays.fill(this.field25706, null);
      this.field25713++;
   }

   @Override
   public int getHeight() {
      return mc.level == null ? 0 : mc.level.getHeight();
   }

   public BlockPos rayBlock(Vec3 var1, Vec3 var2, CollisionContext var3, boolean var4) {
      if (mc.level == null) {
         return null;
      }

      this.refresh();
      if (this.field25712 != var3) {
         this.field25712 = var3;
         this.field25713++;
      }

      this.field25714 = var1;
      this.field25715 = var2;
      this.field25716 = var3;
      this.field25717 = var4;
      return BlockGetter.traverseBlocks(var1, var2, this, CollisionBlockView::firstSolid, var0 -> null);
   }

   @Override
   public int getMinY() {
      return mc.level == null ? 0 : mc.level.getMinY();
   }

   private static boolean insideUnit(double var0) {
      return Mth.floor(Mth.clamp(var0, field25729, 1.0)) == 0;
   }

   public BlockPos rayBlock(Vec3 var1, Vec3 var2, CollisionContext var3) {
      return this.rayBlock(var1, var2, var3, false);
   }

   @Override
   public BlockState getBlockState(BlockPos var1) {
      if (mc.level == null) {
         return Blocks.AIR.defaultBlockState();
      }

      this.refresh();
      long var2 = var1.asLong();
      int var4 = (int)HashCommon.mix(var2) & 8191;
      BlockState var5 = this.field25706[var4];
      if (var5 != null && this.field25705[var4] == var2) {
         return var5;
      }

      BlockState var6 = mc.level.getBlockState(var1);
      this.field25705[var4] = var2;
      this.field25706[var4] = var6;
      return var6;
   }

   private void refresh() {
      int var1 = mc.player == null ? field25735 : mc.player.tickCount;
      if (var1 != this.field25707 || this.field25708 != mc.level) {
         this.field25707 = var1;
         this.field25708 = mc.level;
         this.invalidate();
      }
   }

   @Override
   public FluidState getFluidState(BlockPos var1) {
      return this.getBlockState(var1).getFluidState();
   }

   private CollisionBlockView() {
      this.field25707 = field25718;
      this.field25709 = new long[8192];
      this.field25710 = new VoxelShape[8192];
      this.field25711 = new int[8192];
   }

   @Override
   public BlockEntity getBlockEntity(BlockPos var1) {
      return mc.level == null ? null : mc.level.getBlockEntity(var1);
   }

   private static BlockPos firstSolid(CollisionBlockView var0, BlockPos var1) {
      VoxelShape var2 = var0.collisionShape(var1);
      if (var2.isEmpty()) {
         return null;
      } else if (var2 == Shapes.block()) {
         return var0.hitsCube(var1) ? var1.immutable() : null;
      } else {
         BlockHitResult var3 = var2.clip(var0.field25714, var0.field25715, var1);
         if (var3 == null) {
            return null;
         } else {
            return var0.field25717 && var3.isInside() ? null : var1.immutable();
         }
      }
   }

   private boolean hitsCube(BlockPos var1) {
      Vec3 var2 = this.field25714;
      double var3 = this.field25715.x - var2.x;
      double var5 = this.field25715.y - var2.y;
      double var7 = this.field25715.z - var2.z;
      if (var3 * var3 + var5 * var5 + var7 * var7 < field25719) {
         return false;
      }

      double var9 = var1.getX();
      double var11 = var1.getY();
      double var13 = var1.getZ();
      if (insideUnit(var2.x + var3 * field25720 - var9) && insideUnit(var2.y + var5 * field25721 - var11) && insideUnit(var2.z + var7 * field25722 - var13)) {
         return !this.field25717;
      }

      double var15 = var9 + 1.0;
      double var17 = var11 + 1.0;
      double var19 = var13 + 1.0;
      if (var3 > field25723
         ? !crossesFace(var9, var2.x, var3, var2.y, var5, var11, var17, var2.z, var7, var13, var19)
         : !(var3 < field25724) || !crossesFace(var15, var2.x, var3, var2.y, var5, var11, var17, var2.z, var7, var13, var19)) {
         if (var5 > field25725
            ? !crossesFace(var11, var2.y, var5, var2.z, var7, var13, var19, var2.x, var3, var9, var15)
            : !(var5 < field25726) || !crossesFace(var17, var2.y, var5, var2.z, var7, var13, var19, var2.x, var3, var9, var15)) {
            return var7 > field25727
               ? crossesFace(var13, var2.z, var7, var2.x, var3, var9, var15, var2.y, var5, var11, var17)
               : var7 < field25728 && crossesFace(var19, var2.z, var7, var2.x, var3, var9, var15, var2.y, var5, var11, var17);
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   private VoxelShape collisionShape(BlockPos var1) {
      long var2 = var1.asLong();
      int var4 = (int)HashCommon.mix(var2 ^ field25734) & 8191;
      if (this.field25711[var4] == this.field25713 && this.field25709[var4] == var2 && this.field25710[var4] != null) {
         return this.field25710[var4];
      }

      VoxelShape var5 = this.getBlockState(var1).getCollisionShape(this, var1, this.field25716);
      this.field25709[var4] = var2;
      this.field25710[var4] = var5;
      this.field25711[var4] = this.field25713;
      return var5;
   }

   private static boolean crossesFace(
      double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, double var20
   ) {
      double var22 = (var0 - var2) / var4;
      double var24 = var6 + var22 * var8;
      double var26 = var14 + var22 * var16;
      return 0.0 < var22 && var22 < 1.0 && var10 - field25730 < var24 && var24 < var12 + field25731 && var18 - field25732 < var26 && var26 < var20 + field25733;
   }
}
