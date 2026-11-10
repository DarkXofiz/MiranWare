// Original binary: hex/api/baritone/cache/CachedRegion
package hex.api.baritone.cache;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.cache.ICachedRegion;
import hex.api.baritone.api.utils.BlockUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;

// $VF: Compiled from s
public final class CachedRegion implements ICachedRegion {
   private static final byte CHUNK_NOT_PRESENT = 0;
   private static final byte CHUNK_PRESENT = 1;
   private static final int CACHED_REGION_MAGIC = 456022911;
   private final CachedChunk[][] chunks = new CachedChunk[32][32];
   private final int x;
   private final int z;
   private final DimensionType dimension;
   private final ResourceKey<Level> dimensionId;
   private boolean hasUnsavedChanges;
   private static final int АГк = 0;
   private static final long АГп = 1L;
   private static final int АГ2 = 0;
   private static final int АГ西 = 0;
   private static final String АГт = "АГт";
   private static final int АГд = 0;
   private static final int АГе = 0;
   private static final int АГ6 = 0;
   private static final long АГl = 1L;
   private static final long АГ必 = 0;

   @Override
   public final boolean isCached(int var1, int var2) {
      return this.chunks[var1 >> 4][var2 >> 4] != null;
   }

   CachedRegion(int var1, int var2, DimensionType var3, ResourceKey<Level> var4) {
      this.x = var1;
      this.z = var2;
      this.hasUnsavedChanges = false;
      this.dimension = var3;
      this.dimensionId = var4;
   }

   public final synchronized void save(String var1) {
      if (this.hasUnsavedChanges) {
         this.removeExpired();

         try {
            Path var2 = Paths.get(var1);
            if (!Files.exists(var2)) {
               Files.createDirectories(var2);
            }

            Path sx = getRegionFile(var2, this.x, this.z);
            if (!Files.exists(sx)) {
               Files.createFile(sx);
            }

            try (
               FileOutputStream sxx = new FileOutputStream(sx.toFile());
               GZIPOutputStream sxxx = new GZIPOutputStream(sxx, 16384);
               DataOutputStream sxxxx = new DataOutputStream(sxxx);
            ) {
               sxxxx.writeInt(АГк);

               for (int sxxxxx = 0; sxxxxx < 32; sxxxxx++) {
                  for (int sxxxxxx = 0; sxxxxxx < 32; sxxxxxx++) {
                     CachedChunk sxxxxxxx = this.chunks[sxxxxx][sxxxxxx];
                     if (sxxxxxxx == null) {
                        sxxxx.write(0);
                     } else {
                        sxxxx.write(1);
                        byte[] sxxxxxxxx = sxxxxxxx.toByteArray();
                        sxxxx.write(sxxxxxxxx);
                        sxxxx.write(new byte[sxxxxxxx.sizeInBytes - sxxxxxxxx.length]);
                     }
                  }
               }

               for (int sxxxxx = 0; sxxxxx < 32; sxxxxx++) {
                  for (int sxxxxxx = 0; sxxxxxx < 32; sxxxxxx++) {
                     if (this.chunks[sxxxxx][sxxxxxx] != null) {
                        for (int sxxxxxxx = 0; sxxxxxxx < 256; sxxxxxxx++) {
                           sxxxx.writeUTF(BlockUtils.blockToString(this.chunks[sxxxxx][sxxxxxx].getOverview()[sxxxxxxx].getBlock()));
                        }
                     }
                  }
               }

               for (int sxxxxx = 0; sxxxxx < 32; sxxxxx++) {
                  for (int sxxxxxx = 0; sxxxxxx < 32; sxxxxxx++) {
                     if (this.chunks[sxxxxx][sxxxxxx] != null) {
                        var sxxxxxxx = this.chunks[sxxxxx][sxxxxxx].getRelativeBlocks();
                        sxxxx.writeShort(sxxxxxxx.entrySet().size());

                        for (var sxxxxxxxx : sxxxxxxx.entrySet()) {
                           sxxxx.writeUTF(sxxxxxxxx.getKey());
                           sxxxx.writeShort(sxxxxxxxx.getValue().size());

                           for (BlockPos sxxxxxxxxx : (Iterable<BlockPos>) (Iterable) sxxxxxxxx.getValue()) {
                              sxxxx.writeByte((byte)(sxxxxxxxxx.getZ() << 4 | sxxxxxxxxx.getX()));
                              sxxxx.writeInt(sxxxxxxxxx.getY() - this.dimension.minY());
                           }
                        }
                     }
                  }
               }

               for (int sxxxxx = 0; sxxxxx < 32; sxxxxx++) {
                  for (int sxxxxxx = 0; sxxxxxx < 32; sxxxxxx++) {
                     if (this.chunks[sxxxxx][sxxxxxx] != null) {
                        sxxxx.writeLong(this.chunks[sxxxxx][sxxxxxx].cacheTimestamp);
                     }
                  }
               }
            }

            this.hasUnsavedChanges = false;
         } catch (Exception var20) {
         }
      }
   }

   public final synchronized void removeExpired() {
      long var1 = Baritone.settings().cachedChunksExpirySeconds.value;
      if (var1 >= 0L) {
         long sx = System.currentTimeMillis();
         long sxx = sx - var1 * АГ必;

         for (int sxxx = 0; sxxx < 32; sxxx++) {
            for (int sxxxx = 0; sxxxx < 32; sxxxx++) {
               if (this.chunks[sxxx][sxxxx] != null && this.chunks[sxxx][sxxxx].cacheTimestamp < sxx) {
                  this.chunks[sxxx][sxxxx] = null;
               }
            }
         }
      }
   }

   public final synchronized CachedChunk mostRecentlyModified() {
      CachedChunk var1 = null;

      for (int sx = 0; sx < 32; sx++) {
         for (int sxx = 0; sxx < 32; sxx++) {
            if (this.chunks[sx][sxx] != null && (var1 == null || this.chunks[sx][sxx].cacheTimestamp > var1.cacheTimestamp)) {
               var1 = this.chunks[sx][sxx];
            }
         }
      }

      return var1;
   }


   public final synchronized void updateCachedChunk(int var1, int var2, CachedChunk var3) {
      this.chunks[var1][var2] = var3;
      this.hasUnsavedChanges = true;
   }

   public final ArrayList<BlockPos> getLocationsOf(String var1) {
      ArrayList var2 = new ArrayList<>();

      for (int sx = 0; sx < 32; sx++) {
         for (int sxx = 0; sxx < 32; sxx++) {
            if (this.chunks[sx][sxx] != null) {
               var sxxx = this.chunks[sx][sxx].getAbsoluteBlocks(var1);
               if (sxxx != null) {
                  var2.addAll(sxxx);
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final BlockState getBlock(int var1, int var2, int var3) {
      int var4 = var2 - this.dimension.minY();
      CachedChunk sx = this.chunks[var1 >> 4][var3 >> 4];
      return sx != null ? sx.getBlock(var1 & 15, var4, var3 & 15, this.dimension, this.dimensionId) : null;
   }

   @Override
   public final int getZ() {
      return this.z;
   }

   public synchronized void load(String var1) {
      try {
         Path var2 = Paths.get(var1);
         if (!Files.exists(var2)) {
            Files.createDirectories(var2);
         }

         Path sx = getRegionFile(var2, this.x, this.z);
         if (!Files.exists(sx)) {
            return;
         }

         long sxx = System.nanoTime() / АГп;

         try (
            FileInputStream sxxx = new FileInputStream(sx.toFile());
            GZIPInputStream sxxxx = new GZIPInputStream(sxxx, АГ2);
            DataInputStream sxxxxx = new DataInputStream(sxxxx);
         ) {
            int sxxxxxx = sxxxxx.readInt();
            if (sxxxxxx != АГ西) {
               throw new IOException("Bad magic value " + sxxxxxx);
            }

            boolean[][] sxxxxxxx = new boolean[32][32];
            BitSet[][] sxxxxxxxx = new BitSet[32][32];
            Map[][] sxxxxxxxxx = new Map[32][32];
            BlockState[][][] sxxxxxxxxxx = new BlockState[32][32][];
            long[][] sxxxxxxxxxxx = new long[32][32];

            for (int sxxxxxxxxxxxx = 0; sxxxxxxxxxxxx < 32; sxxxxxxxxxxxx++) {
               for (int sxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxx < 32; sxxxxxxxxxxxxx++) {
                  int sxxxxxxxxxxxxxx = sxxxxx.read();
                  switch (sxxxxxxxxxxxxxx) {
                     case 1:
                        byte[] sxxxxxxxxxxxxxxx = new byte[CachedChunk.sizeInBytes(CachedChunk.size(this.dimension.height()))];
                        sxxxxx.readFully(sxxxxxxxxxxxxxxx);
                        sxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx] = BitSet.valueOf(sxxxxxxxxxxxxxxx);
                        sxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx] = new HashMap<>();
                        sxxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx] = new BlockState[256];
                        sxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx] = true;
                        break;
                     case 0:
                     default:
                        throw new IOException(АГт);
                  }
               }
            }

            for (int sxxxxxxxxxxxx = 0; sxxxxxxxxxxxx < 32; sxxxxxxxxxxxx++) {
               for (int sxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxx < 32; sxxxxxxxxxxxxx++) {
                  if (sxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx]) {
                     for (int sxxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxxx < 256; sxxxxxxxxxxxxxx++) {
                        sxxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx][sxxxxxxxxxxxxxx] = BlockUtils.stringToBlockRequired(sxxxxx.readUTF()).defaultBlockState();
                     }
                  }
               }
            }

            for (int sxxxxxxxxxxxx = 0; sxxxxxxxxxxxx < 32; sxxxxxxxxxxxx++) {
               for (int sxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxx < 32; sxxxxxxxxxxxxx++) {
                  if (sxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx]) {
                     int sxxxxxxxxxxxxxx = sxxxxx.readShort() & АГд;

                     for (int sxxxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxxxx < sxxxxxxxxxxxxxx; sxxxxxxxxxxxxxxx++) {
                        String sxxxxxxxxxxxxxxxx = sxxxxx.readUTF();
                        BlockUtils.stringToBlockRequired(sxxxxxxxxxxxxxxxx);
                        List sxxxxxxxxxxxxxxxxx = new ArrayList<>();
                        sxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx].put(sxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxx);
                        int sxxxxxxxxxxxxxxxxxx = sxxxxx.readShort() & АГе;
                        if (sxxxxxxxxxxxxxxxxxx == 0) {
                           sxxxxxxxxxxxxxxxxxx = АГ6;
                        }

                        for (int sxxxxxxxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxxxxxxxx < sxxxxxxxxxxxxxxxxxx; sxxxxxxxxxxxxxxxxxxx++) {
                           byte sxxxxxxxxxxxxxxxxxxxx = sxxxxx.readByte();
                           int sxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxx & 15;
                           int sxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxx >>> 4 & 15;
                           int sxxxxxxxxxxxxxxxxxxxxxxx = sxxxxx.readInt();
                           sxxxxxxxxxxxxxxxxx.add(
                              new BlockPos(sxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxx + this.dimension.minY(), sxxxxxxxxxxxxxxxxxxxxxx)
                           );
                        }
                     }
                  }
               }
            }

            for (int sxxxxxxxxxxxx = 0; sxxxxxxxxxxxx < 32; sxxxxxxxxxxxx++) {
               for (int sxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxx < 32; sxxxxxxxxxxxxx++) {
                  if (sxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx]) {
                     sxxxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx] = sxxxxx.readLong();
                  }
               }
            }

            for (int sxxxxxxxxxxxx = 0; sxxxxxxxxxxxx < 32; sxxxxxxxxxxxx++) {
               for (int sxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxx < 32; sxxxxxxxxxxxxx++) {
                  if (sxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx]) {
                     int sxxxxxxxxxxxxxx = this.x;
                     int sxxxxxxxxxxxxxxx = this.z;
                     int sxxxxxxxxxxxxxxxx = sxxxxxxxxxxxx + 32 * sxxxxxxxxxxxxxx;
                     int sxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxx + 32 * sxxxxxxxxxxxxxxx;
                     this.chunks[sxxxxxxxxxxxx][sxxxxxxxxxxxxx] = new CachedChunk(
                        sxxxxxxxxxxxxxxxx,
                        sxxxxxxxxxxxxxxxxx,
                        this.dimension.height(),
                        sxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx],
                        sxxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx],
                        sxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx],
                        sxxxxxxxxxxx[sxxxxxxxxxxxx][sxxxxxxxxxxxxx]
                     );
                  }
               }
            }
         }

         this.removeExpired();
         this.hasUnsavedChanges = false;
         long var34 = System.nanoTime() / АГl;
      } catch (Exception var33) {
      }
   }

   @Override
   public final int getX() {
      return this.x;
   }

   private static Path getRegionFile(Path var0, int var1, int var2) {
      return Paths.get(var0.toString(), "r." + var1 + "." + var2 + ".bcr");
   }
}
