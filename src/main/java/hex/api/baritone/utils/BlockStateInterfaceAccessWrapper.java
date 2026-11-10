// Original binary: hex/api/baritone/utils/BlockStateInterfaceAccessWrapper
package hex.api.baritone.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.Nullable;

// $VF: Compiled from s
public final class BlockStateInterfaceAccessWrapper implements BlockGetter {
   private final BlockStateInterface bsi;

   @Override
   public BlockState getBlockState(BlockPos var1) {
      return this.bsi.get0(var1.getX(), var1.getY(), var1.getZ());
   }

   @Nullable
   @Override
   public BlockEntity getBlockEntity(BlockPos var1) {
      return null;
   }

   @Override
   public int getHeight() {
      return this.bsi.world.getHeight();
   }

   @Override
   public FluidState getFluidState(BlockPos var1) {
      return this.getBlockState(var1).getFluidState();
   }

   @Override
   public int getMinY() {
      return this.bsi.world.getMinY();
   }

   BlockStateInterfaceAccessWrapper(BlockStateInterface var1) {
      this.bsi = var1;
   }
}
