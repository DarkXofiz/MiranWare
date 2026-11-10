// Original binary: hex/api/baritone/cache/CachedWorld
package hex.api.baritone.cache;

import com.google.common.cache.CacheBuilder;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.cache.ICachedWorld;
import hex.api.baritone.api.cache.IWorldData;
import hex.api.baritone.api.utils.Helper;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.dimension.DimensionType;

// $VF: Compiled from s
public final class CachedWorld implements Helper, ICachedWorld {
   private static final int REGION_MAX = 58594;
   private Long2ObjectMap<CachedRegion> cachedRegions = new Long2ObjectOpenHashMap();
   private final String directory;
   private final LinkedBlockingQueue<ChunkPos> toPackQueue = new LinkedBlockingQueue<>();
   private final Map<ChunkPos, LevelChunk> toPackMap = CacheBuilder.newBuilder().softValues().<ChunkPos, LevelChunk>build().asMap();
   private final DimensionType dimension;
   private final ResourceKey<Level> dimensionId;
   private static final long Абю = 1000000L;
   private static final long Аб4 = 1000000L;
   private static final double АбС = 1024.0;
   private static final String Абъ = "Deleting cached region from ram";
   private static final long АбБ = 1000000L;
   private static final long Абв = 1000000L;
   private static final long Абр = 4294967295L;
   private static final long Абй = 4294967295L;
   private static final int Абк = 58594;
   private static final int Абп = -58594;
   private static final int Аб2 = 58594;
   private static final int Аб西 = -58594;
   private static final long Абт = 30000L;
   private static final long Абд = 600000L;

   private synchronized void prune() {
      if (Baritone.settings().pruneRegionsFromRAM.value) {
         BlockPos var1 = this.guessPosition();

         for (CachedRegion sx : this.allRegions()) {
            if (sx != null) {
               int sxx = (sx.getX() << 9) + 256 - var1.getX();
               int sxxx = (sx.getZ() << 9) + 256 - var1.getZ();
               double sxxxx = Math.sqrt(sxx * sxx + sxxx * sxxx);
               if (sxxxx > АбС) {
                  this.logDebug(Абъ);
                  this.cachedRegions.remove(this.getRegionID(sx.getX(), sx.getZ()));
               }
            }
         }
      }
   }

   @Override
   public final boolean isCached(int var1, int var2) {
      CachedRegion var3 = this.getRegion(var1 >> 9, var2 >> 9);
      return var3 == null ? false : var3.isCached(var1 & 511, var2 & 511);
   }

   private void updateCachedChunk(CachedChunk var1) {
      CachedRegion var2 = this.getOrCreateRegion(var1.x >> 5, var1.z >> 5);
      var2.updateCachedChunk(var1.x & 31, var1.z & 31, var1);
   }

   @Override
   public final void save() {
      if (!Baritone.settings().chunkCaching.value) {
         this.allRegions().forEach(var0 -> {
            if (var0 != null) {
               var0.removeExpired();
            }
         });
         this.prune();
      } else {
         long var1 = System.nanoTime() / Абю;
         this.allRegions().parallelStream().forEach(var1x -> {
            if (var1x != null) {
               var1x.save(this.directory);
            }
         });
         long sx = System.nanoTime() / Аб4;
         this.prune();
      }
   }

   public final boolean regionLoaded(int var1, int var2) {
      return this.getRegion(var1 >> 9, var2 >> 9) != null;
   }

   private synchronized CachedRegion getOrCreateRegion(int var1, int var2) {
      return (CachedRegion)this.cachedRegions.computeIfAbsent(this.getRegionID(var1, var2), var3 -> {
         CachedRegion var5 = new CachedRegion(var1, var2, this.dimension, this.dimensionId);
         var5.load(this.directory);
         return var5;
      });
   }

   CachedWorld(Path var1, DimensionType var2, ResourceKey<Level> var3) {
      if (!Files.exists(var1)) {
         try {
            Files.createDirectories(var1);
         } catch (IOException var5) {
         }
      }

      this.directory = var1.toString();
      this.dimension = var2;
      this.dimensionId = var3;
      Baritone.getExecutor().execute(new CachedWorld.PackerThread());
      Baritone.getExecutor().execute(() -> {
         try {
            Thread.sleep(Абт);

            while (true) {
               this.save();
               Thread.sleep(Абд);
            }
         } catch (InterruptedException var2x) {
         }
      });
   }

   private boolean isRegionInWorld(int var1, int var2) {
      return var1 <= Абк && var1 >= Абп && var2 <= Аб2 && var2 >= Аб西;
   }

   @Override
   public final void reloadAllFromDisk() {
      long var1 = System.nanoTime() / АбБ;
      this.allRegions().forEach(var1x -> {
         if (var1x != null) {
            var1x.load(this.directory);
         }
      });
      long sx = System.nanoTime() / Абв;
   }

   public void tryLoadFromDisk(int var1, int var2) {
      this.getOrCreateRegion(var1, var2);
   }

   public final synchronized CachedRegion getRegion(int var1, int var2) {
      return (CachedRegion)this.cachedRegions.get(this.getRegionID(var1, var2));
   }

   @Override
   public final ArrayList<BlockPos> getLocationsOf(String var1, int var2, int var3, int var4, int var5) {
      ArrayList var6 = new ArrayList<>();
      int sx = var3 >> 9;
      int sxx = var4 >> 9;

      for (int sxxx = 0; sxxx <= var5; sxxx++) {
         for (int sxxxx = -sxxx; sxxxx <= sxxx; sxxxx++) {
            for (int sxxxxx = -sxxx; sxxxxx <= sxxx; sxxxxx++) {
               int sxxxxxx = sxxxx * sxxxx + sxxxxx * sxxxxx;
               if (sxxxxxx == sxxx) {
                  int sxxxxxxx = sxxxx + sx;
                  int sxxxxxxxx = sxxxxx + sxx;
                  CachedRegion sxxxxxxxxx = this.getOrCreateRegion(sxxxxxxx, sxxxxxxxx);
                  if (sxxxxxxxxx != null) {
                     var6.addAll(sxxxxxxxxx.getLocationsOf(var1));
                  }
               }
            }
         }

         if (var6.size() >= var2) {
            return var6;
         }
      }

      return var6;
   }


   private long getRegionID(int var1, int var2) {
      return !this.isRegionInWorld(var1, var2) ? 0L : var1 & Абр | (var2 & Абй) << 32;
   }

   @Override
   public final void queueForPacking(LevelChunk var1) {
      if (this.toPackMap.put(var1.getPos(), var1) == null) {
         this.toPackQueue.add(var1.getPos());
      }
   }

   private BlockPos guessPosition() {
      for (IBaritone var2 : BaritoneAPI.getProvider().getAllBaritones()) {
         IWorldData sx = var2.getWorldProvider().getCurrentWorld();
         if (sx != null && sx.getCachedWorld() == this && var2.getPlayerContext().player() != null) {
            return var2.getPlayerContext().playerFeet();
         }
      }

      CachedChunk var5 = null;

      for (CachedRegion sx : this.allRegions()) {
         if (sx != null) {
            CachedChunk sxx = sx.mostRecentlyModified();
            if (sxx != null && (var5 == null || var5.cacheTimestamp < sxx.cacheTimestamp)) {
               var5 = sxx;
            }
         }
      }

      return var5 == null ? new BlockPos(0, 0, 0) : new BlockPos((var5.x << 4) + 8, 0, (var5.z << 4) + 8);
   }

   private synchronized List<CachedRegion> allRegions() {
      return new ArrayList<>(this.cachedRegions.values());
   }

   // $VF: Compiled from s
   private class PackerThread implements Runnable {
      @Override
      public void run() {
         while (true) {
            try {
               ChunkPos var1 = CachedWorld.this.toPackQueue.take();
               LevelChunk sx = CachedWorld.this.toPackMap.remove(var1);
               if (CachedWorld.this.toPackQueue.size() <= Baritone.settings().chunkPackerQueueMaxSize.value) {
                  CachedChunk sxx = ChunkPacker.pack(sx);
                  CachedWorld.this.updateCachedChunk(sxx);
               }
            } catch (InterruptedException var4) {
               return;
            } catch (Throwable var5) {
            }
         }
      }
   }
}
