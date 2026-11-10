// Original binary: sg/ec/A0FW1zxTzXUEY5ul
package sg.ec;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ClientLevel.ClientLevelData;
import net.minecraft.client.multiplayer.prediction.BlockStatePredictionHandler;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkPacketData;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundLightUpdatePacketData;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderCenterPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderLerpSizePacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderWarningDelayPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderWarningDistancePacket;
import net.minecraft.network.protocol.game.CommonPlayerSpawnInfo;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.chunk.DataLayer;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.scores.Scoreboard;
import org.jspecify.annotations.Nullable;
import sg.mx.BlockStatePredictionHandlerMixin;
import sg.mx.ClientLevelMixin_1241;

// $VF: Compiled from s
public final class BotClientLevel extends ClientLevel {
   private final Scoreboard field05962;
   private final ClientPacketListener field05963;
   private final BotEntityTracker field05964 = new BotEntityTracker(this);
   private static final int field05965 = Integer.MAX_VALUE;

   public ClientPacketListener sink() {
      return this.field05963;
   }

   @Override
   public List<AbstractClientPlayer> players() {
      return this.field05964.method07264();
   }

   public void tickBookkeeping() {
      ClientChunkCache var1 = this.getChunkSource();
      var1.getLightEngine().runLightUpdates();
      this.getWorldBorder().tick();
      this.field05964.method07256();
   }

   public void applyBorderCenter(ClientboundSetBorderCenterPacket var1) {
      this.getWorldBorder().setCenter(var1.getNewCenterX(), var1.getNewCenterZ());
   }

   @Override
   public void playSeededSound(Entity var1, Entity var2, Holder<SoundEvent> var3, SoundSource var4, float var5, float var6, long var7) {
   }

   private void readSectionList(int var1, int var2, LevelLightEngine var3, LightLayer var4, BitSet var5, BitSet var6, Iterator<byte[]> var7) {
      for (int var8 = 0; var8 < var3.getLightSectionCount(); var8++) {
         boolean var9 = var5.get(var8);
         if (var9 || var6.get(var8)) {
            int var10 = var3.getMinLightSection() + var8;
            var3.queueSectionData(var4, SectionPos.of(var1, var10, var2), var9 ? new DataLayer((byte[])((byte[])var7.next()).clone()) : new DataLayer());
         }
      }
   }

   @Override
   public List<VoxelShape> getEntityCollisions(@Nullable Entity var1, AABB var2) {
      return this.field05964.method07258(var1, var2);
   }

   @Override
   public void playPlayerSound(SoundEvent var1, SoundSource var2, float var3, float var4) {
   }

   @Override
   public void addAlwaysVisibleParticle(ParticleOptions var1, double var2, double var4, double var6, double var8, double var10, double var12) {
   }

   @Override
   public void playLocalSound(Entity var1, SoundEvent var2, SoundSource var3, float var4, float var5) {
   }

   public BotClientLevel(ClientPacketListener var1, ClientboundLoginPacket var2, CommonPlayerSpawnInfo var3, int var4, int var5, Scoreboard var6) {
      super(
         var1,
         new ClientLevelData(Difficulty.NORMAL, var2.hardcore(), var3.isFlat()),
         var3.dimension(),
         var3.dimensionType(),
         var4,
         var5,
         Minecraft.getInstance().levelRenderer,
         var3.isDebug(),
         var3.seed(),
         var3.seaLevel()
      );
      this.field05962 = var6;
      this.field05963 = var1;
   }

   public int predictBlockRemoval(BlockPos var1, BotLocalPlayer var2, int var3) {
      BlockState var4 = this.getBlockState(var1);
      BlockStatePredictionHandler var5 = ((ClientLevelMixin_1241)(Object)this).predictionHandler();
      ((BlockStatePredictionHandlerMixin)(Object)var5).setCurrentSequence(var3);

      int var6;
      try (BlockStatePredictionHandler var7 = var5.startPredicting()) {
         var6 = var5.currentSequence();
         var5.retainKnownServerState(var1, var4, var2);
      }

      var4.getBlock().playerWillDestroy(this, var1, var4, var2);
      this.setBlock(var1, var4.getFluidState().createLegacyBlock(), 11);
      return var6;
   }

   @Override
   public Scoreboard getScoreboard() {
      return this.field05962;
   }

   @Override
   public void playLocalSound(double var1, double var3, double var5, SoundEvent var7, SoundSource var8, float var9, float var10, boolean var11) {
   }

   @Override
   public void addParticle(ParticleOptions var1, double var2, double var4, double var6, double var8, double var10, double var12) {
   }

   @Override
   public List<Entity> getEntities(@Nullable Entity var1, AABB var2, Predicate<? super Entity> var3) {
      return this.field05964.method07265(var1, var2, var3);
   }

   public void applyBorderWarningDelay(ClientboundSetBorderWarningDelayPacket var1) {
      this.getWorldBorder().setWarningTime(var1.getWarningDelay());
   }

   public void loadChunk(ClientboundLevelChunkWithLightPacket var1) {
      int var2 = var1.getX();
      int var3 = var1.getZ();
      ClientboundLevelChunkPacketData var4 = var1.getChunkData();
      this.getChunkSource().replaceWithPacketData(var2, var3, var4.getReadBuffer(), var4.getHeightmaps(), var4.getBlockEntitiesTagsConsumer(var2, var3));
      this.applyLight(var2, var3, var1.getLightData());
      LevelChunk var5 = this.getChunkSource().getChunk(var2, var3, false);
      if (var5 != null) {
         this.enableChunkLight(var5);
      }
   }

   public void applyBorderLerp(ClientboundSetBorderLerpSizePacket var1) {
      this.getWorldBorder().lerpSizeBetween(var1.getOldSize(), var1.getNewSize(), var1.getLerpTime(), this.getGameTime());
   }

   @Override
   public void syncBlockState(BlockPos var1, BlockState var2, @Nullable Vec3 var3) {
      BlockState var4 = this.getBlockState(var1);
      if (var4 != var2) {
         this.setBlock(var1, var2, 19);
         BotLocalPlayer var5 = this.field05964.method07252();
         if (var5 != null && var3 != null && var5.isColliding(var1, var2)) {
            var5.absSnapTo(var3.x, var3.y, var3.z);
         }
      }
   }

   public boolean isChunkLoaded(int var1, int var2) {
      return this.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(var1), SectionPos.blockToSectionCoord(var2));
   }

   @Override
   public <T extends Entity> void getEntities(EntityTypeTest<Entity, T> var1, AABB var2, Predicate<? super T> var3, List<? super T> var4, int var5) {
      this.field05964.method07255(var1, var2, var3, var4, var5);
   }

   public BotEntityTracker entityStore() {
      return this.field05964;
   }

   @Override
   public <T extends Entity> List<T> getEntities(EntityTypeTest<Entity, T> var1, AABB var2, Predicate<? super T> var3) {
      ArrayList var4 = new ArrayList();
      this.field05964.method07255(var1, var2, var3, var4, field05965);
      return var4;
   }

   public void createFireworks(double var1, double var3, double var5, double var7, double var9, double var11, List<FireworkExplosion> var13) {
   }

   public void applyBorder(ClientboundInitializeBorderPacket var1) {
      WorldBorder var2 = this.getWorldBorder();
      var2.setCenter(var1.getNewCenterX(), var1.getNewCenterZ());
      long var3 = var1.getLerpTime();
      if (var3 > 0L) {
         var2.lerpSizeBetween(var1.getOldSize(), var1.getNewSize(), var3, this.getGameTime());
      } else {
         var2.setSize(var1.getNewSize());
      }

      var2.setAbsoluteMaxSize(var1.getNewAbsoluteMaxSize());
      var2.setWarningBlocks(var1.getWarningBlocks());
      var2.setWarningTime(var1.getWarningTime());
   }

   @Override
   public void gameEvent(Holder<GameEvent> var1, Vec3 var2, Context var3) {
   }

   @Override
   public @Nullable Entity getEntity(int var1) {
      return this.field05964.method07261(var1);
   }

   @Override
   public void destroyBlockProgress(int var1, BlockPos var2, int var3) {
   }

   public void applyBlock(BlockPos var1, BlockState var2) {
      this.setServerVerifiedBlockState(var1, var2, 19);
   }

   private void enableChunkLight(LevelChunk var1) {
      LevelLightEngine var2 = this.getChunkSource().getLightEngine();
      LevelChunkSection[] var3 = var1.getSections();
      ChunkPos var4 = var1.getPos();

      for (int var5 = 0; var5 < var3.length; var5++) {
         var2.updateSectionStatus(SectionPos.of(var4, this.getSectionYFromSectionIndex(var5)), var3[var5].hasOnlyAir());
      }
   }

   @Override
   public Iterable<Entity> entitiesForRendering() {
      return this.field05964.method07262();
   }

   @Override
   public void addParticle(ParticleOptions var1, boolean var2, boolean var3, double var4, double var6, double var8, double var10, double var12, double var14) {
   }

   @Override
   public void setSectionDirtyWithNeighbors(int var1, int var2, int var3) {
   }

   public void applyLight(int var1, int var2, ClientboundLightUpdatePacketData var3) {
      LevelLightEngine var4 = this.getChunkSource().getLightEngine();
      this.readSectionList(var1, var2, var4, LightLayer.SKY, var3.getSkyYMask(), var3.getEmptySkyYMask(), var3.getSkyUpdates().iterator());
      this.readSectionList(var1, var2, var4, LightLayer.BLOCK, var3.getBlockYMask(), var3.getEmptyBlockYMask(), var3.getBlockUpdates().iterator());
      var4.setLightEnabled(new ChunkPos(var1, var2), true);
   }

   @Override
   public void setBlocksDirty(BlockPos var1, BlockState var2, BlockState var3) {
   }

   @Override
   public void playSeededSound(
      Entity var1, double var2, double var4, double var6, Holder<SoundEvent> var8, SoundSource var9, float var10, float var11, long var12
   ) {
   }

   public void dropChunk(int var1, int var2) {
      ChunkPos var3 = new ChunkPos(var1, var2);
      this.getChunkSource().drop(var3);
      LevelLightEngine var4 = this.getChunkSource().getLightEngine();
      var4.setLightEnabled(var3, false);

      for (int var5 = var4.getMinLightSection(); var5 < var4.getMaxLightSection(); var5++) {
         SectionPos var6 = SectionPos.of(var3, var5);
         var4.queueSectionData(LightLayer.BLOCK, var6, null);
         var4.queueSectionData(LightLayer.SKY, var6, null);
      }

      for (int var7 = this.getMinSectionY(); var7 <= this.getMaxSectionY(); var7++) {
         var4.updateSectionStatus(SectionPos.of(var3, var7), true);
      }
   }

   @Override
   public void levelEvent(Entity var1, int var2, BlockPos var3, int var4) {
   }

   @Override
   public boolean shouldTickDeath(Entity var1) {
      BotLocalPlayer var2 = this.field05964.method07252();
      return var2 != null && var1.chunkPosition().getChessboardDistance(var2.chunkPosition()) <= this.getServerSimulationDistance();
   }

   @Override
   public void addAlwaysVisibleParticle(ParticleOptions var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13) {
   }

   public void applyBorderSize(ClientboundSetBorderSizePacket var1) {
      this.getWorldBorder().setSize(var1.getSize());
   }

   @Override
   public void setSectionRangeDirty(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   @Override
   public void sendBlockUpdated(BlockPos var1, BlockState var2, BlockState var3, int var4) {
   }

   @Override
   public List<Entity> getPushableEntities(Entity var1, AABB var2) {
      return this.field05964.method07251(var1, var2);
   }

   @Override
   public <T extends Entity> boolean hasEntities(EntityTypeTest<Entity, T> var1, AABB var2, Predicate<? super T> var3) {
      var var4 = new ArrayList(1);
      this.field05964.method07255(var1, var2, var3, var4, 1);
      return !var4.isEmpty();
   }

   public void applyBorderWarningDistance(ClientboundSetBorderWarningDistancePacket var1) {
      this.getWorldBorder().setWarningBlocks(var1.getWarningBlocks());
   }
}
