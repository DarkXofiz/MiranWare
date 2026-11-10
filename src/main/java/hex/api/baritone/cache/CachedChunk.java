// Original binary: hex/api/baritone/cache/CachedChunk
package hex.api.baritone.cache;

import com.google.common.collect.ImmutableSet;
import hex.api.baritone.api.utils.BlockUtils;
import hex.api.baritone.utils.pathing.PathingBlockType;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;

// $VF: Compiled from s
public final class CachedChunk {
   public static final ImmutableSet<Block> BLOCKS_TO_KEEP_TRACK_OF = ImmutableSet.of(
      Blocks.ENDER_CHEST,
      Blocks.FURNACE,
      Blocks.CHEST,
      Blocks.TRAPPED_CHEST,
      Blocks.END_PORTAL,
      Blocks.END_PORTAL_FRAME,
      new Block[]{
         Blocks.SPAWNER,
         Blocks.BARRIER,
         Blocks.OBSERVER,
         Blocks.SHULKER_BOX,
         Blocks.NETHER_PORTAL,
         Blocks.HOPPER,
         Blocks.BEACON,
         Blocks.BREWING_STAND,
         Blocks.CREEPER_HEAD,
         Blocks.CREEPER_WALL_HEAD,
         Blocks.DRAGON_HEAD,
         Blocks.DRAGON_WALL_HEAD,
         Blocks.PLAYER_HEAD,
         Blocks.PLAYER_WALL_HEAD,
         Blocks.ZOMBIE_HEAD,
         Blocks.ZOMBIE_WALL_HEAD,
         Blocks.SKELETON_SKULL,
         Blocks.SKELETON_WALL_SKULL,
         Blocks.WITHER_SKELETON_SKULL,
         Blocks.WITHER_SKELETON_WALL_SKULL,
         Blocks.ENCHANTING_TABLE,
         Blocks.ANVIL,
         Blocks.DRAGON_EGG,
         Blocks.JUKEBOX,
         Blocks.END_GATEWAY,
         Blocks.COBWEB,
         Blocks.NETHER_WART,
         Blocks.LADDER,
         Blocks.VINE
      }
   );
   public final int height;
   public final int size;
   public final int sizeInBytes;
   public final int x;
   public final int z;
   private final BitSet data;
   private final Int2ObjectOpenHashMap<String> special;
   private final BlockState[] overview;
   private final int[] heightMap;
   private final Map<String, List<BlockPos>> specialBlockLocations;
   public final long cacheTimestamp;
   private static final String бЧй = "бЧй";

   private final void setSpecial() {
      for (var var2 : this.specialBlockLocations.entrySet()) {
         for (BlockPos sx : (Iterable<BlockPos>) (Iterable) var2.getValue()) {
            this.special.put(getPositionIndex(sx.getX(), sx.getY(), sx.getZ()), var2.getKey());
         }
      }
   }

   public final Map<String, List<BlockPos>> getRelativeBlocks() {
      return this.specialBlockLocations;
   }

   public final byte[] toByteArray() {
      return this.data.toByteArray();
   }

   public static int sizeInBytes(int var0) {
      return var0 / 8;
   }

   private void calculateHeightMap() {
      for (int var1 = 0; var1 < 16; var1++) {
         for (int sx = 0; sx < 16; sx++) {
            int sxx = var1 << 4 | sx;
            this.heightMap[sxx] = 0;

            for (int sxxx = this.height; sxxx >= 0; sxxx--) {
               int sxxxx = getPositionIndex(sx, sxxx, var1);
               if (this.data.get(sxxxx) || this.data.get(sxxxx + 1)) {
                  this.heightMap[sxx] = sxxx;
                  break;
               }
            }
         }
      }
   }

   public final ArrayList<BlockPos> getAbsoluteBlocks(String var1) {
      if (this.specialBlockLocations.get(var1) == null) {
         return null;
      }

      ArrayList var2 = new ArrayList<>();

      for (BlockPos sx : this.specialBlockLocations.get(var1)) {
         var2.add(new BlockPos(sx.getX() + this.x * 16, sx.getY(), sx.getZ() + this.z * 16));
      }

      return var2;
   }

   public final BlockState[] getOverview() {
      return this.overview;
   }

   public final BlockState getBlock(int var1, int var2, int var3, DimensionType var4, ResourceKey<Level> var5) {
      int var6 = getPositionIndex(var1, var2, var3);
      PathingBlockType sx = this.getType(var6);
      int sxx = var3 << 4 | var1;
      if (this.heightMap[sxx] == var2 && sx != PathingBlockType.AVOID) {
         return this.overview[sxx];
      }

      if (this.special != null) {
         String sxxx = (String)this.special.get(var6);
         if (sxxx != null) {
            return BlockUtils.stringToBlockRequired(sxxx).defaultBlockState();
         }
      }

      if (sx == PathingBlockType.SOLID) {
         if (var2 == var4.logicalHeight() - 1 && var4.hasCeiling()) {
            return Blocks.BEDROCK.defaultBlockState();
         }

         if ((var5 == Level.OVERWORLD || var5 == Level.NETHER) && var2 < var4.minY() + 5) {
            return Blocks.OBSIDIAN.defaultBlockState();
         }
      }

      return ChunkPacker.pathingTypeToBlock(sx, var4, var5);
   }

   public static int getPositionIndex(int var0, int var1, int var2) {
      return var0 << 1 | var2 << 5 | var1 << 9;
   }

   private void validateSize(BitSet var1) {
      if (var1.size() > this.size) {
         throw new IllegalArgumentException(бЧй);
      }
   }

   CachedChunk(int var1, int var2, int var3, BitSet var4, BlockState[] var5, Map<String, List<BlockPos>> var6, long var7) {
      this.size = size(var3);
      this.sizeInBytes = sizeInBytes(this.size);
      this.validateSize(var4);
      this.x = var1;
      this.z = var2;
      this.height = var3;
      this.data = var4;
      this.overview = var5;
      this.heightMap = new int[256];
      this.specialBlockLocations = var6;
      this.cacheTimestamp = var7;
      if (var6.isEmpty()) {
         this.special = null;
      } else {
         this.special = new Int2ObjectOpenHashMap();
         this.setSpecial();
      }

      this.calculateHeightMap();
   }


   public static int size(int var0) {
      return 512 * var0;
   }

   private PathingBlockType getType(int var1) {
      return PathingBlockType.fromBits(this.data.get(var1), this.data.get(var1 + 1));
   }
}
