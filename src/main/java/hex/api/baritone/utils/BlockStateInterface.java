// Original binary: hex/api/baritone/utils/BlockStateInterface
package hex.api.baritone.utils;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.cache.CachedRegion;
import hex.api.baritone.cache.WorldData;
import hex.api.baritone.utils.accessor.IClientChunkProvider;
import hex.api.baritone.utils.pathing.BetterWorldBorder;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import sg.ec.BotClientLevel;

// $VF: Compiled from s
public class BlockStateInterface {
   private final ClientChunkCache provider;
   private final WorldData worldData;
   protected final Level world;
   public final MutableBlockPos isPassableBlockPos;
   public final BlockGetter access;
   public final BetterWorldBorder worldBorder;
   private LevelChunk prev = null;
   private CachedRegion prevCached = null;
   private final boolean useTheRealWorld;
   private static final BlockState AIR = Blocks.AIR.defaultBlockState();
   private static final String Алч = "Алч";

   public BlockStateInterface(IPlayerContext var1, boolean var2) {
      this.world = var1.world();
      this.worldBorder = new BetterWorldBorder(this.world.getWorldBorder());
      this.worldData = (WorldData)var1.worldData();
      if (var2) {
         this.provider = ((IClientChunkProvider)this.world.getChunkSource()).createThreadSafeCopy();
      } else {
         this.provider = (ClientChunkCache)this.world.getChunkSource();
      }

      this.useTheRealWorld = !Baritone.settings().pathThroughCachedOnly.value;
      if (!var1.minecraft().isSameThread() && !(this.world instanceof BotClientLevel)) {
         throw new IllegalStateException(Алч);
      }

      this.isPassableBlockPos = new MutableBlockPos();
      this.access = new BlockStateInterfaceAccessWrapper(this);
   }


   public BlockState get0(BlockPos var1) {
      return this.get0(var1.getX(), var1.getY(), var1.getZ());
   }

   public static Block getBlock(IPlayerContext var0, BlockPos var1) {
      return get(var0, var1).getBlock();
   }

   public boolean worldContainsLoadedChunk(int var1, int var2) {
      return this.provider.hasChunk(var1 >> 4, var2 >> 4);
   }

   public boolean isLoaded(int var1, int var2) {
      LevelChunk var3 = this.prev;
      if (var3 != null && var3.getPos().x == var1 >> 4 && var3.getPos().z == var2 >> 4) {
         return true;
      }

      var3 = this.provider.getChunk(var1 >> 4, var2 >> 4, ChunkStatus.FULL, false);
      if (var3 != null && !var3.isEmpty()) {
         this.prev = var3;
         return true;
      }

      CachedRegion sx = this.prevCached;
      if (sx != null && sx.getX() == var1 >> 9 && sx.getZ() == var2 >> 9) {
         return sx.isCached(var1 & 511, var2 & 511);
      }

      if (this.worldData == null) {
         return false;
      }

      sx = this.worldData.cache.getRegion(var1 >> 9, var2 >> 9);
      if (sx == null) {
         return false;
      }

      this.prevCached = sx;
      return sx.isCached(var1 & 511, var2 & 511);
   }

   public BlockStateInterface(IPlayerContext var1) {
      this(var1, false);
   }

   public static BlockState get(IPlayerContext var0, BlockPos var1) {
      return new BlockStateInterface(var0).get0(var1.getX(), var1.getY(), var1.getZ());
   }

   public BlockState get0(int var1, int var2, int var3) {
      var2 -= this.world.dimensionType().minY();
      if (var2 >= 0 && var2 < this.world.dimensionType().height()) {
         if (this.useTheRealWorld) {
            LevelChunk var4 = this.prev;
            if (var4 != null && var4.getPos().x == var1 >> 4 && var4.getPos().z == var3 >> 4) {
               return getFromChunk(var4, var1, var2, var3);
            }

            LevelChunk sx = this.provider.getChunk(var1 >> 4, var3 >> 4, ChunkStatus.FULL, false);
            if (sx != null && !sx.isEmpty()) {
               this.prev = sx;
               return getFromChunk(sx, var1, var2, var3);
            }
         }

         CachedRegion var7 = this.prevCached;
         if (var7 == null || var7.getX() != var1 >> 9 || var7.getZ() != var3 >> 9) {
            if (this.worldData == null) {
               return AIR;
            }

            CachedRegion sx = this.worldData.cache.getRegion(var1 >> 9, var3 >> 9);
            if (sx == null) {
               return AIR;
            }

            this.prevCached = sx;
            var7 = sx;
         }

         BlockState sx = var7.getBlock(var1 & 511, var2 + this.world.dimensionType().minY(), var3 & 511);
         return sx == null ? AIR : sx;
      } else {
         return AIR;
      }
   }

   public static BlockState getFromChunk(LevelChunk var0, int var1, int var2, int var3) {
      LevelChunkSection var4 = var0.getSections()[var2 >> 4];
      return var4.hasOnlyAir() ? AIR : var4.getBlockState(var1 & 15, var2 & 15, var3 & 15);
   }
}
