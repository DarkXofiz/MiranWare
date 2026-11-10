// Original binary: hex/api/baritone/cache/FasterWorldScanner
package hex.api.baritone.cache;

import hex.api.baritone.api.cache.ICachedWorld;
import hex.api.baritone.api.cache.IWorldScanner;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.BlockOptionalMeta;
import hex.api.baritone.api.utils.BlockOptionalMetaLookup;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.utils.accessor.IPalettedContainer;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.BitStorage;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.chunk.GlobalPalette;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.Palette;
import net.minecraft.world.level.chunk.PalettedContainer;
import net.minecraft.world.level.chunk.SingleValuePalette;

// $VF: Compiled from s
public enum FasterWorldScanner implements IWorldScanner {
   INSTANCE;

   private static final BlockState[] PALETTE_REGISTRY_SENTINEL = new BlockState[0];

   @Override
   public List<BlockPos> scanChunkRadius(IPlayerContext var1, BlockOptionalMetaLookup var2, int var3, int var4, int var5) {
      assert var1.world() != null;
      if (var5 < 0) {
         throw new IllegalArgumentException("chunkRange must be >= 0");
      } else {
         return this.scanChunksInternal(var1, var2, getChunkRange(var1.playerFeet().x >> 4, var1.playerFeet().z >> 4, var5), var3);
      }
   }

   @Override
   public List<BlockPos> scanChunk(IPlayerContext var1, BlockOptionalMetaLookup var2, ChunkPos var3, int var4, int var5) {
      var var6 = this.scanChunkInternal(var1, var2, var3);
      if (var4 >= 0) {
         var6 = var6.limit(var4);
      }

      return var6.collect(Collectors.toList());
   }

   @Override
   public int repack(IPlayerContext var1) {
      return this.repack(var1, 40);
   }

   @Override
   public int repack(IPlayerContext var1, int var2) {
      ChunkSource var3 = var1.world().getChunkSource();
      ICachedWorld sx = var1.worldData().getCachedWorld();
      BetterBlockPos sxx = var1.playerFeet();
      int sxxx = sxx.getX() >> 4;
      int sxxxx = sxx.getZ() >> 4;
      int sxxxxx = sxxx - var2;
      int sxxxxxx = sxxxx - var2;
      int sxxxxxxx = sxxx + var2;
      int sxxxxxxxx = sxxxx + var2;
      int sxxxxxxxxx = 0;

      for (int sxxxxxxxxxx = sxxxxx; sxxxxxxxxxx <= sxxxxxxx; sxxxxxxxxxx++) {
         for (int sxxxxxxxxxxx = sxxxxxx; sxxxxxxxxxxx <= sxxxxxxxx; sxxxxxxxxxxx++) {
            LevelChunk sxxxxxxxxxxxx = var3.getChunk(sxxxxxxxxxx, sxxxxxxxxxxx, false);
            if (sxxxxxxxxxxxx != null && !sxxxxxxxxxxxx.isEmpty()) {
               sxxxxxxxxx++;
               sx.queueForPacking(sxxxxxxxxxxxx);
            }
         }
      }

      return sxxxxxxxxx;
   }

   public static List<ChunkPos> getChunkRange(int var0, int var1, int var2) {
      List var3 = new ArrayList<>();
      var3.add(new ChunkPos(var0, var1));

      for (int sx = 1; sx < var2; sx++) {
         for (int sxx = 0; sxx <= sx; sxx++) {
            var3.add(new ChunkPos(var0 - sxx, var1 - sx));
            if (sxx != 0) {
               var3.add(new ChunkPos(var0 + sxx, var1 - sx));
               var3.add(new ChunkPos(var0 - sxx, var1 + sx));
            }

            var3.add(new ChunkPos(var0 + sxx, var1 + sx));
            if (sxx != sx) {
               var3.add(new ChunkPos(var0 - sx, var1 - sxx));
               var3.add(new ChunkPos(var0 + sx, var1 - sxx));
               if (sxx != 0) {
                  var3.add(new ChunkPos(var0 - sx, var1 + sxx));
                  var3.add(new ChunkPos(var0 + sx, var1 + sxx));
               }
            }
         }
      }

      return var3;
   }

   private List<BlockPos> scanChunksInternal(IPlayerContext var1, BlockOptionalMetaLookup var2, List<ChunkPos> var3, int var4) {
      assert var1.world() != null;

      try {
         var var5 = var3.parallelStream().flatMap(var3x -> this.scanChunkInternal(var1, var2, var3x));
         if (var4 >= 0) {
            var5 = var5.limit(var4);
         }

         return var5.collect(Collectors.toList());
      } catch (Exception var6) {
         throw var6;
      }
   }

   private Stream<BlockPos> scanChunkInternal(IPlayerContext var1, BlockOptionalMetaLookup var2, ChunkPos var3) {
      ChunkSource var4 = var1.world().getChunkSource();
      if (!var4.hasChunk(var3.x(), var3.z())) {
         return Stream.empty();
      }

      long sx = (long)var3.x() << 4;
      long sxx = (long)var3.z() << 4;
      int sxxx = var1.playerFeet().y - var1.world().getMinY() >> 4;
      return this.collectChunkSections(var2, var4.getChunk(var3.x(), var3.z(), false), sx, sxx, sxxx).stream();
   }

   private List<BlockPos> collectChunkSections(BlockOptionalMetaLookup var1, LevelChunk var2, long var3, long var5, int var7) {
      List var8 = new ArrayList<>();
      int sx = var2.getMinY();
      LevelChunkSection[] sxx = var2.getSections();
      int sxxx = sxx.length;
      int sxxxx = var7 - 1;

      for (int sxxxxx = var7; sxxxx >= 0 || sxxxxx < sxxx; sxxxx--) {
         if (sxxxxx < sxxx) {
            this.visitSection(var1, sxx[sxxxxx], var8, var3, sx + sxxxxx * 16, var5);
         }

         if (sxxxx >= 0) {
            this.visitSection(var1, sxx[sxxxx], var8, var3, sx + sxxxx * 16, var5);
         }

         sxxxxx++;
      }

      return var8;
   }

   private void visitSection(BlockOptionalMetaLookup var1, LevelChunkSection var2, List<BlockPos> var3, long var4, int var6, long var7) {
      if (var2 != null && !var2.hasOnlyAir()) {
         PalettedContainer<BlockState> var9 = var2.getStates();
         if (((IPalettedContainer)var9).getStorage() != null) {
            Palette<BlockState> sx = ((IPalettedContainer)var9).getPalette();
            if (sx instanceof SingleValuePalette) {
               if (var1.has(sx.valueFor(0))) {
                  for (int sxx = 0; sxx < 16; sxx++) {
                     for (int sxxx = 0; sxxx < 16; sxxx++) {
                        for (int sxxxx = 0; sxxxx < 16; sxxxx++) {
                           var3.add(new BlockPos((int)var4 + sxx, var6 + sxxx, (int)var7 + sxxxx));
                        }
                     }
                  }
               }
            } else {
               boolean[] sxx = this.getIncludedFilterIndices(var1, sx);
               if (sxx.length != 0) {
                  BitStorage sxxx = ((IPalettedContainer)var2.getStates()).getStorage();
                  long[] sxxxx = sxxx.getRaw();
                  int sxxxxx = sxxx.getSize();
                  int sxxxxxx = sxxx.getBits();
                  long sxxxxxxx = (1L << sxxxxxx) - 1L;
                  int sxxxxxxxx = 0;

                  for (int sxxxxxxxxx = 0; sxxxxxxxx < sxxxx.length && sxxxxxxxxx < sxxxxx; sxxxxxxxx++) {
                     long sxxxxxxxxxx = sxxxx[sxxxxxxxx];

                     for (int sxxxxxxxxxxx = 0; sxxxxxxxxxxx <= 64 - sxxxxxx && sxxxxxxxxx < sxxxxx; sxxxxxxxxx++) {
                        int sxxxxxxxxxxxx = (int)(sxxxxxxxxxx >> sxxxxxxxxxxx & sxxxxxxx);
                        if (sxx[sxxxxxxxxxxxx]) {
                           var3.add(new BlockPos((int)var4 + (sxxxxxxxxx & 0xFF & 15), var6 + (sxxxxxxxxx >> 8), (int)var7 + ((sxxxxxxxxx & 0xFF) >> 4)));
                        }

                        sxxxxxxxxxxx += sxxxxxx;
                     }
                  }
               }
            }
         }
      }
   }

   private boolean[] getIncludedFilterIndices(BlockOptionalMetaLookup var1, Palette<BlockState> var2) {
      boolean var3 = false;
      BlockState[] sx = getPalette(var2);
      if (sx == PALETTE_REGISTRY_SENTINEL) {
         return this.getIncludedFilterIndicesFromRegistry(var1);
      }

      int sxx = sx.length;
      boolean[] sxxx = new boolean[sxx];

      for (int sxxxx = 0; sxxxx < sxx; sxxxx++) {
         BlockState sxxxxx = sx[sxxxx];
         if (var1.has(sxxxxx)) {
            sxxx[sxxxx] = true;
            var3 = true;
         } else {
            sxxx[sxxxx] = false;
         }
      }

      return !var3 ? new boolean[0] : sxxx;
   }

   private boolean[] getIncludedFilterIndicesFromRegistry(BlockOptionalMetaLookup var1) {
      boolean[] var2 = new boolean[Block.BLOCK_STATE_REGISTRY.size()];

      for (BlockOptionalMeta sx : var1.blocks()) {
         for (BlockState sxx : sx.getAllBlockStates()) {
            var2[Block.BLOCK_STATE_REGISTRY.getId(sxx)] = true;
         }
      }

      return var2;
   }

   private static BlockState[] getPalette(Palette<BlockState> var0) {
      if (var0 instanceof GlobalPalette) {
         return PALETTE_REGISTRY_SENTINEL;
      }

      FriendlyByteBuf var1 = new FriendlyByteBuf(Unpooled.buffer());
      var0.write(var1, Block.BLOCK_STATE_REGISTRY);
      int sx = var1.readVarInt();
      BlockState[] sxx = new BlockState[sx];

      for (int sxxx = 0; sxxx < sx; sxxx++) {
         BlockState sxxxx = Block.BLOCK_STATE_REGISTRY.byId(var1.readVarInt());
         assert sxxxx != null;
         sxx[sxxx] = sxxxx;
      }

      return sxx;
   }
}
