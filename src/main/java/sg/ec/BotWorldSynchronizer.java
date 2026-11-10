// Original binary: sg/ec/LvKvxdLwB3pkybrl
package sg.ec;

import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.gui.components.LerpingBossEvent;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundSetChunkCacheCenterPacket;
import net.minecraft.network.protocol.game.ClientboundSetChunkCacheRadiusPacket;
import net.minecraft.network.protocol.game.ClientboundSetDisplayObjectivePacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.network.protocol.game.ClientboundSetObjectivePacket;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket;
import net.minecraft.network.protocol.game.ClientboundSetScorePacket;
import net.minecraft.network.protocol.game.ClientboundSetSimulationDistancePacket;
import net.minecraft.network.protocol.game.ClientboundTabListPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.CommonPlayerSpawnInfo;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import sg.mx.BossHealthOverlayMixin;
import sg.mx.ClientPacketListenerMixin;
import sg.mx.PlayerTabOverlayMixin_1198;

// $VF: Compiled from s
public final class BotWorldSynchronizer implements MinecraftAccess {
   private static final int field09966 = 24;
   private static final int field09967 = 0;

   private static void method04458(BotWorldState var0) {
      PlayerTabOverlayMixin_1198 var1 = (PlayerTabOverlayMixin_1198)(Object)mc.gui.hud.getTabList();
      if (var1.getTabHeader() != null || var1.getTabFooter() != null) {
         var0.method07655(
            new ClientboundTabListPacket(
               var1.getTabHeader() == null ? Component.empty() : var1.getTabHeader(), var1.getTabFooter() == null ? Component.empty() : var1.getTabFooter()
            )
         );
      }
   }

   private static int method04459(BotWorldState var0, ClientLevel var1, int var2, int var3, int var4) {
      int var5 = 0;

      for (int var6 = var2 - var4; var6 <= var2 + var4; var6++) {
         for (int var7 = var3 - var4; var7 <= var3 + var4; var7++) {
            LevelChunk var8 = var1.getChunkSource().getChunk(var6, var7, ChunkStatus.FULL, false);
            if (var8 != null) {
               var0.method07648(new ClientboundLevelChunkWithLightPacket(var8, var1.getLightEngine(), null, null));
               var5++;
            }
         }
      }

      return var5;
   }

   private static void method04460(BotWorldState var0, ClientLevel var1, LocalPlayer var2) {
      for (Entity var4 : var1.entitiesForRendering()) {
         if (var4 != var2 && !var4.isRemoved()) {
            var0.method07692(
               new ClientboundAddEntityPacket(
                  var4.getId(),
                  var4.getUUID(),
                  var4.getX(),
                  var4.getY(),
                  var4.getZ(),
                  var4.getXRot(),
                  var4.getYRot(),
                  var4.getType(),
                  0,
                  var4.getDeltaMovement(),
                  var4.getYHeadRot()
               )
            );
            method04470(var0, var4);
            method04465(var0, var4);
            method04468(var0, var4);
            if (!var4.getPassengers().isEmpty()) {
               var0.method07814(new ClientboundSetPassengersPacket(var4));
            }
         }
      }
   }

   public static boolean method04461(BotClient var0, ClientPacketListener var1, ClientboundLoginPacket var2) {
      ClientLevel var3 = mc.level;
      LocalPlayer var4 = mc.player;
      if (var3 != null && var4 != null && var2 != null) {
         BotWorldState var5 = var0.method00090();
         var5.method07649();
         var5.method07733(true);
         var5.method07746(var2);
         var5.method07711(method04463(var3, var2));
         var5.method07726(var1.registryAccess());
         var5.method07759(var1.enabledFeatures());
         var5.method07751(var1.serverBrand());
         var5.method07696(var3.dimension().identifier().toString());
         var5.method07785(var1.getLocalGameProfile());
         var0.method00070().method08015(var1.getLocalGameProfile());
         var0.method00070().method08019(var4, mc.gameMode == null ? var0.method00070().method07950() : mc.gameMode.getPlayerMode());
         ClientPacketListenerMixin var6 = (ClientPacketListenerMixin)(Object)var1;
         int var7 = Math.max(var6.getServerChunkRadius(), var2.chunkRadius());
         int var8 = Math.min(Math.max(var7, 2), 24);
         int var9 = Math.min(Math.max(var8, mc.options.getEffectiveRenderDistance()) + 3, 24);
         int var10 = var4.chunkPosition().x();
         int var11 = var4.chunkPosition().z();
         var5.method07773(new ClientboundSetChunkCacheRadiusPacket(var8));
         var5.method07788(new ClientboundSetSimulationDistancePacket(var6.getServerSimulationDistance()));
         var5.method07723(new ClientboundSetChunkCacheCenterPacket(var10, var11));
         int var12 = method04459(var5, var3, var10, var11, var9);
         method04467(var5, var3);
         method04464(var5, var3);
         method04466(var5);
         method04469(var5, var3);
         method04458(var5);
         method04462(var5);
         method04468(var5, var4);
         var5.method07734(((ClientPacketListenerMixin)(Object)var1).getPlayerInfoMap(), ((ClientPacketListenerMixin)(Object)var1).getListedPlayers());
         method04460(var5, var3, var4);
         var5.method07731(new ClientboundGameEventPacket(ClientboundGameEventPacket.LEVEL_CHUNKS_LOAD_START, 0.0F));
         return true;
      } else {
         return false;
      }
   }

   private static void method04462(BotWorldState var0) {
      var0.method07802(BotRegistrySnapshot.INSTANCE.method03177());
      var0.method07741(BotRegistrySnapshot.INSTANCE.method03174());
      var0.method07687(BotRegistrySnapshot.INSTANCE.method03178());
      var0.method07702(BotRegistrySnapshot.INSTANCE.method03179());
      var0.method07650(BotRegistrySnapshot.INSTANCE.method03180());
   }

   private static CommonPlayerSpawnInfo method04463(ClientLevel var0, ClientboundLoginPacket var1) {
      CommonPlayerSpawnInfo var2 = var1.commonPlayerSpawnInfo();
      return var2.dimension().equals(var0.dimension())
         ? var2
         : new CommonPlayerSpawnInfo(
            var0.dimensionTypeRegistration(),
            var0.dimension(),
            var2.seed(),
            var2.gameType(),
            var2.previousGameType(),
            var2.isDebug(),
            var2.isFlat(),
            var2.lastDeathLocation(),
            var2.portalCooldown(),
            var0.getSeaLevel()
         );
   }

   private static void method04464(BotWorldState var0, ClientLevel var1) {
      Scoreboard var2 = var1.getScoreboard();

      for (Objective var4 : var2.getObjectives()) {
         var0.method07771(new ClientboundSetObjectivePacket(var4, 0));

         for (PlayerScoreEntry var6 : var2.listPlayerScores(var4)) {
            var0.method07679(
               new ClientboundSetScorePacket(
                  var6.owner(), var4.getName(), var6.value(), Optional.ofNullable(var6.display()), Optional.ofNullable(var6.numberFormatOverride())
               )
            );
         }
      }

      for (DisplaySlot var11 : DisplaySlot.values()) {
         Objective var7 = var2.getDisplayObjective(var11);
         if (var7 != null) {
            var0.method07690(new ClientboundSetDisplayObjectivePacket(var11, var7));
         }
      }
   }

   private static void method04465(BotWorldState var0, Entity var1) {
      if (var1 instanceof LivingEntity var2) {
         ArrayList var3 = new ArrayList();

         for (EquipmentSlot var7 : EquipmentSlot.values()) {
            ItemStack var8 = var2.getItemBySlot(var7);
            if (!var8.isEmpty()) {
               var3.add(Pair.of(var7, var8.copy()));
            }
         }

         if (!var3.isEmpty()) {
            var0.method07662(new ClientboundSetEquipmentPacket(var1.getId(), var3));
         }
      }
   }

   private static void method04466(BotWorldState var0) {
      for (LerpingBossEvent var2 : ((BossHealthOverlayMixin)(Object)mc.gui.hud.getBossOverlay()).events().values()) {
         var0.method07761(var2);
      }
   }

   private static void method04467(BotWorldState var0, ClientLevel var1) {
      for (PlayerTeam var3 : var1.getScoreboard().getPlayerTeams()) {
         var0.method07738(ClientboundSetPlayerTeamPacket.createAddOrModifyPacket(var3, true));
      }
   }

   private BotWorldSynchronizer() {
   }

   private static void method04468(BotWorldState var0, Entity var1) {
      if (var1 instanceof LivingEntity var2) {
         var0.method07770(new ClientboundUpdateAttributesPacket(var2.getId(), var2.getAttributes().getSyncableAttributes()));

         for (MobEffectInstance var4 : var2.getActiveEffects()) {
            var0.method07768(new ClientboundUpdateMobEffectPacket(var2.getId(), var4, false));
         }
      }
   }

   private static void method04469(BotWorldState var0, ClientLevel var1) {
      var0.method07740(new ClientboundInitializeBorderPacket(var1.getWorldBorder()));
   }

   private static void method04470(BotWorldState var0, Entity var1) {
      var var2 = var1.getEntityData().getNonDefaultValues();
      if (var2 != null && !var2.isEmpty()) {
         var0.method07805(new ClientboundSetEntityDataPacket(var1.getId(), var2));
      }
   }
}
