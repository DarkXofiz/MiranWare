// Original binary: hex/api/baritone/cache/ChunkPacker
package hex.api.baritone.cache;

import hex.api.baritone.api.utils.BlockUtils;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.utils.BlockStateInterface;
import hex.api.baritone.utils.pathing.PathingBlockType;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.PalettedContainer;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class ChunkPacker {
   private ChunkPacker() {
   }

   public static CachedChunk pack(LevelChunk var0) {
      Map<String, List<BlockPos>> var1 = new HashMap<>();
      int sx = var0.getLevel().dimensionType().height();
      BitSet sxx = new BitSet(CachedChunk.size(sx));

      try {
         LevelChunkSection[] sxxx = var0.getSections();

         for (int sxxxx = 0; sxxxx < sx / 16; sxxxx++) {
            LevelChunkSection sxxxxx = sxxx[sxxxx];
            if (sxxxxx != null) {
               PalettedContainer<BlockState> sxxxxxx = sxxxxx.getStates();
               int sxxxxxxx = sxxxx << 4;

               for (int sxxxxxxxx = 0; sxxxxxxxx < 16; sxxxxxxxx++) {
                  int sxxxxxxxxx = sxxxxxxxx | sxxxxxxx;

                  for (int sxxxxxxxxxx = 0; sxxxxxxxxxx < 16; sxxxxxxxxxx++) {
                     for (int sxxxxxxxxxxx = 0; sxxxxxxxxxxx < 16; sxxxxxxxxxxx++) {
                        int sxxxxxxxxxxxx = CachedChunk.getPositionIndex(sxxxxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx);
                        BlockState sxxxxxxxxxxxxx = sxxxxxx.get(sxxxxxxxxxxx, sxxxxxxxx, sxxxxxxxxxx);
                        boolean[] sxxxxxxxxxxxxxx = getPathingBlockType(sxxxxxxxxxxxxx, var0, sxxxxxxxxxxx, sxxxxxxxxx + var0.getMinY(), sxxxxxxxxxx).getBits();
                        sxx.set(sxxxxxxxxxxxx, sxxxxxxxxxxxxxx[0]);
                        sxx.set(sxxxxxxxxxxxx + 1, sxxxxxxxxxxxxxx[1]);
                        Block sxxxxxxxxxxxxxxx = sxxxxxxxxxxxxx.getBlock();
                        if (CachedChunk.BLOCKS_TO_KEEP_TRACK_OF.contains(sxxxxxxxxxxxxxxx)) {
                           String sxxxxxxxxxxxxxxxx = BlockUtils.blockToString(sxxxxxxxxxxxxxxx);
                           var1.computeIfAbsent(sxxxxxxxxxxxxxxxx, var0x -> new ArrayList<>())
                              .add(new BlockPos(sxxxxxxxxxxx, sxxxxxxxxx + var0.getMinY(), sxxxxxxxxxx));
                        }
                     }
                  }
               }
            }
         }
      } catch (Exception var18) {
      }

      BlockState[] sxxx = new BlockState[256];

      for (int sxxxx = 0; sxxxx < 16; sxxxx++) {
         label58:
         for (int sxxxxx = 0; sxxxxx < 16; sxxxxx++) {
            for (int sxxxxxx = sx - 1; sxxxxxx >= 0; sxxxxxx--) {
               int sxxxxxxx = CachedChunk.getPositionIndex(sxxxxx, sxxxxxx, sxxxx);
               if (sxx.get(sxxxxxxx) || sxx.get(sxxxxxxx + 1)) {
                  sxxx[sxxxx << 4 | sxxxxx] = BlockStateInterface.getFromChunk(var0, sxxxxx, sxxxxxx, sxxxx);
                  continue label58;
               }
            }

            sxxx[sxxxx << 4 | sxxxxx] = Blocks.AIR.defaultBlockState();
         }
      }

      return new CachedChunk(var0.getPos().x(), var0.getPos().z(), sx, sxx, sxxx, var1, System.currentTimeMillis());
   }

   public static BlockState pathingTypeToBlock(PathingBlockType var0, DimensionType var1, ResourceKey<Level> var2) {
      switch (var0) {
         case AIR:
            return Blocks.AIR.defaultBlockState();
         case WATER:
            return Blocks.WATER.defaultBlockState();
         case AVOID:
            return Blocks.LAVA.defaultBlockState();
         case SOLID:
            if (var2 == Level.NETHER) {
               return Blocks.NETHERRACK.defaultBlockState();
            } else {
               if (var2 == Level.END) {
                  return Blocks.END_STONE.defaultBlockState();
               }

               return Blocks.STONE.defaultBlockState();
            }
         default:
            return null;
      }
   }

   private static PathingBlockType getPathingBlockType(BlockState var0, LevelChunk var1, int var2, int var3, int var4) {
      Block var5 = var0.getBlock();
      if (MovementHelper.isWater(var0)) {
         if (MovementHelper.possiblyFlowing(var0)) {
            return PathingBlockType.AVOID;
         }

         int sx = var3 - var1.getLevel().dimensionType().minY();
         if ((var2 == 15 || !MovementHelper.possiblyFlowing(BlockStateInterface.getFromChunk(var1, var2 + 1, sx, var4)))
            && (var2 == 0 || !MovementHelper.possiblyFlowing(BlockStateInterface.getFromChunk(var1, var2 - 1, sx, var4)))
            && (var4 == 15 || !MovementHelper.possiblyFlowing(BlockStateInterface.getFromChunk(var1, var2, sx, var4 + 1)))
            && (var4 == 0 || !MovementHelper.possiblyFlowing(BlockStateInterface.getFromChunk(var1, var2, sx, var4 - 1)))) {
            if (var2 != 0 && var2 != 15 && var4 != 0 && var4 != 15) {
               return PathingBlockType.WATER;
            }

            Vec3 sxx = var0.getFluidState().getFlow(var1.getLevel(), new BlockPos(var2 + (var1.getPos().x() << 4), var3, var4 + (var1.getPos().z() << 4)));
            return sxx.x == 0.0 && sxx.z == 0.0 ? PathingBlockType.AVOID : PathingBlockType.WATER;
         } else {
            return PathingBlockType.AVOID;
         }
      } else if (MovementHelper.avoidWalkingInto(var0) || MovementHelper.isBottomSlab(var0)) {
         return PathingBlockType.AVOID;
      } else {
         return !(var5 instanceof AirBlock) && !(var5 instanceof TallGrassBlock) && !(var5 instanceof DoublePlantBlock) && !(var5 instanceof FlowerBlock)
            ? PathingBlockType.SOLID
            : PathingBlockType.AIR;
      }
   }
}
