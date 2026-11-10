// Original binary: sg/ec/psff24J6tKB7yasg
package sg.ec;

import java.util.Locale;
import java.util.Optional;
import net.minecraft.client.multiplayer.ChunkBatchSizeCalculator;
import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.LastSeenMessagesTracker;
import net.minecraft.network.chat.MessageSignature;
import net.minecraft.network.chat.MessageSignatureCache;
import net.minecraft.network.chat.SignedMessageBody;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundDisconnectPacket;
import net.minecraft.network.protocol.common.ClientboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ClientboundPingPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.network.protocol.common.ClientboundStoreCookiePacket;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import net.minecraft.network.protocol.common.ClientboundUpdateTagsPacket;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ServerboundPongPacket;
import net.minecraft.network.protocol.configuration.ConfigurationProtocols;
import net.minecraft.network.protocol.cookie.ClientboundCookieRequestPacket;
import net.minecraft.network.protocol.cookie.ServerboundCookieResponsePacket;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.network.protocol.game.ClientboundBlockChangedAckPacket;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundBossEventPacket;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.ClientboundChangeDifficultyPacket;
import net.minecraft.network.protocol.game.ClientboundChunkBatchFinishedPacket;
import net.minecraft.network.protocol.game.ClientboundChunkBatchStartPacket;
import net.minecraft.network.protocol.game.ClientboundCommandsPacket;
import net.minecraft.network.protocol.game.ClientboundContainerClosePacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundCooldownPacket;
import net.minecraft.network.protocol.game.ClientboundDeleteChatPacket;
import net.minecraft.network.protocol.game.ClientboundDisguisedChatPacket;
import net.minecraft.network.protocol.game.ClientboundEntityPositionSyncPacket;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundLightUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundMoveVehiclePacket;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerChatPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerCombatKillPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoRemovePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerRotationPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookSettingsPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundResetScorePacket;
import net.minecraft.network.protocol.game.ClientboundRespawnPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.network.protocol.game.ClientboundSectionBlocksUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSelectAdvancementsTabPacket;
import net.minecraft.network.protocol.game.ClientboundServerDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderCenterPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderLerpSizePacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderWarningDelayPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderWarningDistancePacket;
import net.minecraft.network.protocol.game.ClientboundSetCameraPacket;
import net.minecraft.network.protocol.game.ClientboundSetChunkCacheCenterPacket;
import net.minecraft.network.protocol.game.ClientboundSetChunkCacheRadiusPacket;
import net.minecraft.network.protocol.game.ClientboundSetCursorItemPacket;
import net.minecraft.network.protocol.game.ClientboundSetDefaultSpawnPositionPacket;
import net.minecraft.network.protocol.game.ClientboundSetDisplayObjectivePacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.network.protocol.game.ClientboundSetExperiencePacket;
import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.network.protocol.game.ClientboundSetHeldSlotPacket;
import net.minecraft.network.protocol.game.ClientboundSetObjectivePacket;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerInventoryPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket;
import net.minecraft.network.protocol.game.ClientboundSetScorePacket;
import net.minecraft.network.protocol.game.ClientboundSetSimulationDistancePacket;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;
import net.minecraft.network.protocol.game.ClientboundSoundEntityPacket;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.network.protocol.game.ClientboundStartConfigurationPacket;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.network.protocol.game.ClientboundTabListPacket;
import net.minecraft.network.protocol.game.ClientboundTakeItemEntityPacket;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.network.protocol.game.ClientboundTickingStatePacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateRecipesPacket;
import net.minecraft.network.protocol.game.ServerboundAcceptTeleportationPacket;
import net.minecraft.network.protocol.game.ServerboundChatAckPacket;
import net.minecraft.network.protocol.game.ServerboundChunkBatchReceivedPacket;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket;
import net.minecraft.network.protocol.game.ServerboundConfigurationAcknowledgedPacket;
import net.minecraft.network.protocol.game.ServerboundMoveVehiclePacket;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket.Action;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.PosRot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Rot;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.phys.Vec3;
import sg.mx.ClientboundMoveEntityPacketMixin;
import sg.mx.ClientboundRotateHeadPacketMixin;

// $VF: Compiled from s
public final class BotPlayPacketListener extends AbstractBotPlayPacketListener {
   private final BotClient field22810;
   private final Connection field22811;
   private final BotPlayerState field22812;
   private final BotWorldState field22813;
   private final ChunkBatchSizeCalculator field22814 = new ChunkBatchSizeCalculator();
   private static final String field22815 = "TELEPORT";
   private static final String field22816 = "id=%d pos=%.2f/%.2f/%.2f (был %.2f/%.2f/%.2f)";
   private static final String field22817 = "MOTION";
   private static final String field22818 = "сервер задал скорость %.3f/%.3f/%.3f";
   private static final double field22819 = 4096.0;
   private static final double field22820 = 4096.0;
   private static final double field22821 = 4096.0;
   private static final double field22822 = 1.0E-5F;
   private static final String field22823 = "KICK-PLAY";

   @Override
   public void handleSelectAdvancementsTab(ClientboundSelectAdvancementsTabPacket var1) {
      this.field22813.method07650(var1);
   }

   @Override
   public void handleBlockEntityData(ClientboundBlockEntityDataPacket var1) {
      this.field22813.method07715(var1);
   }

   @Override
   public void handleMapItemData(ClientboundMapItemDataPacket var1) {
      this.field22813.method07639(var1);
   }

   @Override
   public void handleBossUpdate(ClientboundBossEventPacket var1) {
      this.field22813.method07748(var1);
   }

   @Override
   public void handlePlayerAbilities(ClientboundPlayerAbilitiesPacket var1) {
      this.field22812.method08010(var1);
   }

   @Override
   public void handleSetScore(ClientboundSetScorePacket var1) {
      this.field22813.method07679(var1);
   }

   @Override
   public void handleContainerSetSlot(ClientboundContainerSetSlotPacket var1) {
      this.field22812.method08002(var1);
      this.field22810.method00135().method03051(var1);
   }

   @Override
   public void handleRespawn(ClientboundRespawnPacket var1) {
      String var2 = var1.commonPlayerSpawnInfo().dimension().identifier().toString();
      boolean var3 = !var2.equals(this.field22813.method07752());
      this.field22813.method07711(var1.commonPlayerSpawnInfo());
      if (var3) {
         this.field22813.method07727();
      }

      this.field22813.method07696(var2);
      if (var3) {
         this.field22813.method07638();
      }

      this.field22812.method07966(var1.commonPlayerSpawnInfo().gameType());
      this.field22810.method00081();
   }

   @Override
   public boolean isAcceptingMessages() {
      return this.field22811.isConnected();
   }

   @Override
   public void handleBundlePacket(ClientboundBundlePacket var1) {
      for (Packet var3 : var1.subPackets()) {
         var3.handle(this);
      }
   }

   @Override
   public void handlePlayerInfoUpdate(ClientboundPlayerInfoUpdatePacket var1) {
      this.field22813.method07776(var1);
   }

   @Override
   public void handleTransfer(ClientboundTransferPacket var1) {
      this.field22810.method00122(var1.host(), var1.port());
   }

   @Override
   public void handleSetHealth(ClientboundSetHealthPacket var1) {
      if (var1.getHealth() <= 0.0F) {
      }

      this.field22812.method07968(var1);
      this.field22810.method00147();
   }

   @Override
   public void handleLogin(ClientboundLoginPacket var1) {
      this.field22810.method00152(0);
      this.field22810.method00124(new LastSeenMessagesTracker(20));
      this.field22810.method00073(MessageSignatureCache.createDefault());
      this.field22813.method07706();
      this.field22813.method07746(var1);
      this.field22813.method07711(var1.commonPlayerSpawnInfo());
      this.field22813.method07696(var1.commonPlayerSpawnInfo().dimension().identifier().toString());
      this.field22812.method07956(var1.playerId());
      this.field22812.method07966(var1.commonPlayerSpawnInfo().gameType());
      this.field22813.method07785(this.field22812.method08012());
      this.field22813.method07638();
      this.field22810.method00074(BotConnectionState.PLAYING);
      this.field22810.method00081();
      BotCustomPayloadCache.method09896(this.field22810.method00156(), this.field22811, ConnectionProtocol.PLAY);
   }

   @Override
   public void handleBlockUpdate(ClientboundBlockUpdatePacket var1) {
      this.field22813.method07809(var1);
   }

   @Override
   public void handleSetEquipment(ClientboundSetEquipmentPacket var1) {
      this.field22813.method07662(var1);
   }

   @Override
   public void handleTakeItemEntity(ClientboundTakeItemEntityPacket var1) {
      this.field22813.method07791(new ClientboundRemoveEntitiesPacket(var1.getItemId()));
   }

   @Override
   public void handleEntityLinkPacket(ClientboundSetEntityLinkPacket var1) {
      this.field22813.method07637(var1);
   }

   @Override
   public void handleServerData(ClientboundServerDataPacket var1) {
      this.field22813.method07643(var1);
   }

   @Override
   public void handleChunkBlocksUpdate(ClientboundSectionBlocksUpdatePacket var1) {
      this.field22813.method07709(var1);
   }

   @Override
   public void handlePlayerCombatKill(ClientboundPlayerCombatKillPacket var1) {
      this.field22810.method00140();
   }

   @Override
   public void handleTeleportEntity(ClientboundTeleportEntityPacket var1) {
      this.field22813.method07663(var1.id(), var1.change(), var1.onGround());
   }

   @Override
   public void handleSetHeldSlot(ClientboundSetHeldSlotPacket var1) {
      this.field22812.method07982(var1);
   }

   @Override
   public void handleDeleteChat(ClientboundDeleteChatPacket var1) {
      var var2 = var1.messageSignature().unpack(this.field22810.method00112());
      if (var2.isPresent()) {
         this.field22810.method00083().ignorePending((MessageSignature)var2.get());
      }
   }

   @Override
   public void handleStoreCookie(ClientboundStoreCookiePacket var1) {
      this.field22810.method00134(var1.key(), var1.payload());
   }

   @Override
   public void handleMovePlayer(ClientboundPlayerPositionPacket var1) {
      this.field22810.method00166();
      PositionMoveRotation var2 = PositionMoveRotation.calculateAbsolute(this.field22812.method08027(), var1.change(), var1.relatives());
      String.format(
         Locale.ROOT,
         field22816,
         var1.id(),
         var2.position().x,
         var2.position().y,
         var2.position().z,
         this.field22812.method08006(),
         this.field22812.method07981(),
         this.field22812.method08004()
      );
      this.field22812.method08000(var2, var1.id());
      this.deferOrSend(new ServerboundAcceptTeleportationPacket(var1.id(), var2.position().x, var2.position().y, var2.position().z, var2.yRot(), var2.xRot()));
      this.deferOrSend(new PosRot(var2.position().x, var2.position().y, var2.position().z, var2.yRot(), var2.xRot(), false, false));
      this.field22810.method00093();
   }

   @Override
   public void handleRecipeBookSettings(ClientboundRecipeBookSettingsPacket var1) {
      this.field22813.method07687(var1);
   }

   @Override
   public void handleUpdateAdvancementsPacket(ClientboundUpdateAdvancementsPacket var1) {
      this.field22813.method07702(var1);
   }

   @Override
   public void handleSetSpawn(ClientboundSetDefaultSpawnPositionPacket var1) {
      this.field22813.method07779(var1);
   }

   @Override
   public void handleUpdateRecipes(ClientboundUpdateRecipesPacket var1) {
      this.field22813.method07802(var1);
   }

   @Override
   public void handleSystemChat(ClientboundSystemChatPacket var1) {
      this.field22810.method00114(var1.content());
   }

   @Override
   public void handleContainerContent(ClientboundContainerSetContentPacket var1) {
      this.field22812.method07972(var1);
      this.field22810.method00135().method03038(var1);
   }

   @Override
   public void handleCommands(ClientboundCommandsPacket var1) {
      this.field22813.method07784(var1);
   }

   private void deferOrSend(Packet<?> var1) {
      if (this.field22810.method00128() != this.field22811 || !this.field22810.method00149(var1)) {
         this.field22811.send(var1);
      }
   }

   @Override
   public void handleAddObjective(ClientboundSetObjectivePacket var1) {
      this.field22813.method07771(var1);
   }

   public BotPlayPacketListener(BotClient var1, Connection var2) {
      this.field22810 = var1;
      this.field22811 = var2;
      this.field22812 = var1.method00070();
      this.field22813 = var1.method00090();
   }

   @Override
   public void handleChunkBatchFinished(ClientboundChunkBatchFinishedPacket var1) {
      this.field22814.onBatchFinished(var1.batchSize());
      this.field22811.send(new ServerboundChunkBatchReceivedPacket(this.field22814.getDesiredChunksPerTick()));
   }

   @Override
   public void handleSetCursorItem(ClientboundSetCursorItemPacket var1) {
      this.field22812.method07973(var1);
   }

   @Override
   public void handleTabListCustomisation(ClientboundTabListPacket var1) {
      this.field22813.method07655(var1);
   }

   @Override
   public void handleSetEntityData(ClientboundSetEntityDataPacket var1) {
      if (var1.id() == this.field22812.method07965()) {
         this.field22812.method07975(var1.packedItems());
      } else {
         this.field22813.method07805(var1);
      }
   }

   @Override
   public void handleSetBorderLerpSize(ClientboundSetBorderLerpSizePacket var1) {
      this.field22813.method07710(var1);
   }

   @Override
   public void handleSetTime(ClientboundSetTimePacket var1) {
      this.field22813.method07795(var1);
   }

   @Override
   public void handleExplosion(ClientboundExplodePacket var1) {
      if (var1.playerKnockback().isPresent()) {
         Vec3 var2 = var1.playerKnockback().get();
         this.field22812.method07998(this.field22812.method07994() + var2.x, this.field22812.method07947() + var2.y, this.field22812.method07948() + var2.z);
      }
   }

   @Override
   public void handleUpdateAttributes(ClientboundUpdateAttributesPacket var1) {
      this.field22813.method07770(var1);
   }

   @Override
   public void handleInitializeBorder(ClientboundInitializeBorderPacket var1) {
      this.field22813.method07740(var1);
   }

   @Override
   public void handleChunkBatchStart(ClientboundChunkBatchStartPacket var1) {
      this.field22814.onBatchStart();
   }

   @Override
   public void handleContainerClose(ClientboundContainerClosePacket var1) {
      this.field22810.method00135().method03039(var1.getContainerId());
   }

   @Override
   public void handleRemoveMobEffect(ClientboundRemoveMobEffectPacket var1) {
      this.field22813.method07703(var1);
   }

   @Override
   public void handleResourcePackPush(ClientboundResourcePackPushPacket var1) {
      BotPacketDispatcher.method09320(this.field22810.method00156(), this.field22811, var1.id());
   }

   @Override
   public void handleKeepAlive(ClientboundKeepAlivePacket var1) {
      this.field22811.send(new ServerboundKeepAlivePacket(var1.getId()));
      this.field22810.method00106(var1.getId());
   }

   @Override
   public void handlePlayerChat(ClientboundPlayerChatPacket var1) {
      this.field22810.method00152(var1.globalIndex() + 1);
      LastSeenMessagesTracker var2 = this.field22810.method00083();
      var var3 = var1.body().unpack(this.field22810.method00112());
      if (var3.isPresent()) {
         this.field22810.method00112().push((SignedMessageBody)var3.get(), var1.signature().orElse(null));
         if (var1.signature().isPresent() && var2.addPending(var1.signature().get(), true) && var2.offset() > 64) {
            this.sendChatAcknowledgement();
         }
      }

      this.field22810.method00114(Component.literal(var1.body().content()));
   }

   @Override
   public void onDisconnect(DisconnectionDetails var1) {
      this.field22810.method00119(var1.reason().getString());
   }

   @Override
   public void handleSetChunkCacheCenter(ClientboundSetChunkCacheCenterPacket var1) {
      this.field22813.method07723(var1);
   }

   @Override
   public void handleBlockChangedAck(ClientboundBlockChangedAckPacket var1) {
      BotClientLevel var2 = this.field22813.method07636();
      if (var2 != null) {
         var2.handleBlockChangedAck(var1.sequence());
      }
   }

   @Override
   public void handleRecipeBookAdd(ClientboundRecipeBookAddPacket var1) {
      this.field22813.method07741(var1);
   }

   @Override
   public void handleRotateMob(ClientboundRotateHeadPacket var1) {
      this.field22813.method07640(((ClientboundRotateHeadPacketMixin)(Object)var1).getEntityId(), var1.getYHeadRot());
   }

   @Override
   public void handleRemoveEntities(ClientboundRemoveEntitiesPacket var1) {
      this.field22813.method07791(var1);
   }

   @Override
   public void handleLevelChunkWithLight(ClientboundLevelChunkWithLightPacket var1) {
      this.field22813.method07648(var1);
   }

   @Override
   public void handleDisconnect(ClientboundDisconnectPacket var1) {
      var1.reason().getString();
      this.field22810.method00126(var1.reason().getString());
      this.field22810.method00102(var1.reason().getString());
   }

   @Override
   public void handleSetExperience(ClientboundSetExperiencePacket var1) {
      this.field22812.method07985(var1);
   }

   @Override
   public void handleAddEntity(ClientboundAddEntityPacket var1) {
      this.field22813.method07692(var1);
   }

   @Override
   public void handleUpdateTags(ClientboundUpdateTagsPacket var1) {
      this.field22813.method07797(var1.tags());
      RegistryDataMerger.method08047(this.field22813.method07758(), var1.tags());
   }

   @Override
   public void handleSetBorderCenter(ClientboundSetBorderCenterPacket var1) {
      this.field22813.method07775(var1);
   }

   @Override
   public void handleSoundEntityEvent(ClientboundSoundEntityPacket var1) {
      BotTaskManager.INSTANCE.method05433(this.field22810, var1.getSound().value());
   }

   private void sendChatAcknowledgement() {
      int var1 = this.field22810.method00083().getAndClearOffset();
      if (var1 > 0) {
         this.field22811.send(new ServerboundChatAckPacket(var1));
      }
   }

   @Override
   public void handleSetBorderSize(ClientboundSetBorderSizePacket var1) {
      this.field22813.method07721(var1);
   }

   @Override
   public void handleSetEntityPassengersPacket(ClientboundSetPassengersPacket var1) {
      this.field22813.method07814(var1);
   }

   @Override
   public void handleConfigurationStart(ClientboundStartConfigurationPacket var1) {
      this.field22810.method00074(BotConnectionState.CONFIGURING);
      this.field22810.method00135().method03045();
      this.field22810.method00068(this.field22811);
      this.field22811.setupInboundProtocol(ConfigurationProtocols.CLIENTBOUND, new BotConfigurationPacketListener(this.field22810, this.field22811));
      this.field22811.send(ServerboundConfigurationAcknowledgedPacket.INSTANCE);
      this.field22811.setupOutboundProtocol(ConfigurationProtocols.SERVERBOUND);
   }

   @Override
   public void handleRotatePlayer(ClientboundPlayerRotationPacket var1) {
      this.field22812.method07983(var1.yRot(), var1.relativeY(), var1.xRot(), var1.relativeX());
      this.deferOrSend(new Rot(this.field22812.method08008(), this.field22812.method08003(), false, false));
      this.field22810.method00093();
   }

   @Override
   public void handleSetPlayerInventory(ClientboundSetPlayerInventoryPacket var1) {
      this.field22812.method08022(var1);
   }

   @Override
   public void handleUpdateMobEffect(ClientboundUpdateMobEffectPacket var1) {
      this.field22813.method07768(var1);
   }

   @Override
   public void handleResetScore(ClientboundResetScorePacket var1) {
      this.field22813.method07704(var1);
   }

   @Override
   public void handleMoveEntity(ClientboundMoveEntityPacket var1) {
      this.field22813
         .method07720(
            ((ClientboundMoveEntityPacketMixin)(Object)var1).getEntityId(),
            hexDelta(var1, 0) / field22819,
            hexDelta(var1, 1) / field22820,
            hexDelta(var1, 2) / field22821,
            var1.hasPosition(),
            var1.getYRot(),
            var1.getXRot(),
            var1.hasRotation(),
            var1.isOnGround()
         );
   }

   @Override
   public void handleEntityPositionSync(ClientboundEntityPositionSyncPacket var1) {
      this.field22813.method07663(var1.id(), new net.minecraft.world.entity.PositionMoveRotation(var1.position().endPosition(), net.minecraft.world.phys.Vec3.ZERO, var1.yRot(), var1.xRot()), var1.onGround());
   }

   @Override
   public void handleSetBorderWarningDelay(ClientboundSetBorderWarningDelayPacket var1) {
      this.field22813.method07787(var1);
   }

   @Override
   public void handleSetDisplayObjective(ClientboundSetDisplayObjectivePacket var1) {
      this.field22813.method07690(var1);
   }

   @Override
   public void handleRequestCookie(ClientboundCookieRequestPacket var1) {
      this.field22811.send(new ServerboundCookieResponsePacket(var1.key(), this.field22810.method00168(var1.key())));
   }

   @Override
   public void handleDisguisedChat(ClientboundDisguisedChatPacket var1) {
      this.field22810.method00114(var1.message());
   }

   @Override
   public void handlePing(ClientboundPingPacket var1) {
      this.field22810.method00166();
      this.deferOrSend(new ServerboundPongPacket(var1.getId()));
   }

   @Override
   public void handleSetEntityMotion(ClientboundSetEntityMotionPacket var1) {
      if (var1.id() == this.field22812.method07965()) {
         String.format(Locale.ROOT, field22818, var1.movement().x, var1.movement().y, var1.movement().z);
         this.field22812.method07998(var1.movement().x, var1.movement().y, var1.movement().z);
      }
   }

   @Override
   public void handlePlayerInfoRemove(ClientboundPlayerInfoRemovePacket var1) {
      this.field22813.method07798(var1);
   }

   @Override
   public void handleSetSimulationDistance(ClientboundSetSimulationDistancePacket var1) {
      this.field22813.method07788(var1);
   }

   @Override
   public void handleSetPlayerTeamPacket(ClientboundSetPlayerTeamPacket var1) {
      this.field22813.method07738(var1);
   }

   @Override
   public void handleTickingState(ClientboundTickingStatePacket var1) {
      this.field22813.method07757(var1);
   }

   @Override
   public void handleGameEvent(ClientboundGameEventPacket var1) {
      this.field22813.method07731(var1);
      if (var1.getEvent() == ClientboundGameEventPacket.WIN_GAME) {
         this.field22811.send(new ServerboundClientCommandPacket(Action.PERFORM_RESPAWN));
      }
   }

   @Override
   public void handleOpenScreen(ClientboundOpenScreenPacket var1) {
      this.field22810.method00135().method03047(var1);
   }

   @Override
   public void handleChangeDifficulty(ClientboundChangeDifficultyPacket var1) {
      this.field22813.method07803(var1);
   }

   @Override
   public void handleSetCamera(ClientboundSetCameraPacket var1) {
      this.field22813.method07750(var1);
   }

   @Override
   public void handleForgetLevelChunk(ClientboundForgetLevelChunkPacket var1) {
      this.field22813.method07804(var1);
   }

   @Override
   public void handleAnimate(ClientboundAnimatePacket var1) {
      if (var1.getId() == this.field22812.method07965()) {
         if (var1.getAction() == 0) {
            this.field22810.method00082().method06265(InteractionHand.MAIN_HAND);
         } else if (var1.getAction() == 3) {
            this.field22810.method00082().method06265(InteractionHand.OFF_HAND);
         }
      }
   }

   @Override
   public void handleSetBorderWarningDistance(ClientboundSetBorderWarningDistancePacket var1) {
      this.field22813.method07682(var1);
   }

   @Override
   public void handleSoundEvent(ClientboundSoundPacket var1) {
      BotTaskManager.INSTANCE.method05433(this.field22810, var1.getSound().value());
   }

   @Override
   public void handleSetChunkCacheRadius(ClientboundSetChunkCacheRadiusPacket var1) {
      this.field22813.method07773(var1);
   }

   @Override
   public void handleLightUpdatePacket(ClientboundLightUpdatePacket var1) {
      this.field22813.method07673(var1);
   }

   @Override
   public void handleItemCooldown(ClientboundCooldownPacket var1) {
      this.field22813.method07694(var1);
   }

   @Override
   public void handleMoveVehicle(ClientboundMoveVehiclePacket var1) {
      BotLocalPlayer var2 = this.field22813.method07688();
      if (var2 != null) {
         Entity var3 = var2.getRootVehicle();
         if (var3 != var2 && var3.isLocalInstanceAuthoritative()) {
            Vec3 var4 = var1.movingTo().position();
            Vec3 var5 = var3.getClientPosition();
            if (var4.distanceTo(var5) > field22822) {
               if (var3.isInterpolating()) {
                  var3.getInterpolation().cancel();
               }

               var3.absSnapTo(var4.x(), var4.y(), var4.z(), var1.movingTo().yRot(), var1.movingTo().xRot());
            }

            this.field22811.send(ServerboundMoveVehiclePacket.fromEntity(var3));
         }
      }
   }

   private static double hexDelta(ClientboundMoveEntityPacket packet, int axis) {
      if (packet.getPositionDelta() instanceof net.minecraft.network.protocol.game.VecDelta.Linear linear) {
         return axis == 0 ? linear.xa() : axis == 1 ? linear.ya() : linear.za();
      }
      return 0.0;
   }
}
