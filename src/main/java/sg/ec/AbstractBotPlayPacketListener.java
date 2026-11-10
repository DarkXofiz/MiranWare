// Original binary: sg/ec/Fz791iFWQBPEWRiC
package sg.ec;

import net.minecraft.network.protocol.common.ClientboundClearDialogPacket;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.ClientboundCustomReportDetailsPacket;
import net.minecraft.network.protocol.common.ClientboundDisconnectPacket;
import net.minecraft.network.protocol.common.ClientboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ClientboundPingPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPopPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.network.protocol.common.ClientboundServerLinksPacket;
import net.minecraft.network.protocol.common.ClientboundShowDialogPacket;
import net.minecraft.network.protocol.common.ClientboundStoreCookiePacket;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import net.minecraft.network.protocol.common.ClientboundUpdateTagsPacket;
import net.minecraft.network.protocol.cookie.ClientboundCookieRequestPacket;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.network.protocol.game.ClientboundAwardStatsPacket;
import net.minecraft.network.protocol.game.ClientboundBlockChangedAckPacket;
import net.minecraft.network.protocol.game.ClientboundBlockDestructionPacket;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundBlockEventPacket;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundBossEventPacket;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.ClientboundChangeDifficultyPacket;
import net.minecraft.network.protocol.game.ClientboundChunkBatchFinishedPacket;
import net.minecraft.network.protocol.game.ClientboundChunkBatchStartPacket;
import net.minecraft.network.protocol.game.ClientboundChunksBiomesPacket;
import net.minecraft.network.protocol.game.ClientboundClearTitlesPacket;
import net.minecraft.network.protocol.game.ClientboundCommandSuggestionsPacket;
import net.minecraft.network.protocol.game.ClientboundCommandsPacket;
import net.minecraft.network.protocol.game.ClientboundContainerClosePacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetDataPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundCooldownPacket;
import net.minecraft.network.protocol.game.ClientboundCustomChatCompletionsPacket;
import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.network.protocol.game.ClientboundDebugBlockValuePacket;
import net.minecraft.network.protocol.game.ClientboundDebugChunkValuePacket;
import net.minecraft.network.protocol.game.ClientboundDebugEntityValuePacket;
import net.minecraft.network.protocol.game.ClientboundDebugEventPacket;
import net.minecraft.network.protocol.game.ClientboundDebugSamplePacket;
import net.minecraft.network.protocol.game.ClientboundDeleteChatPacket;
import net.minecraft.network.protocol.game.ClientboundDisguisedChatPacket;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.network.protocol.game.ClientboundEntityPositionSyncPacket;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameRuleValuesPacket;
import net.minecraft.network.protocol.game.ClientboundGameTestHighlightPosPacket;
import net.minecraft.network.protocol.game.ClientboundHurtAnimationPacket;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.network.protocol.game.ClientboundLightUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundLowDiskSpaceWarningPacket;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.network.protocol.game.ClientboundMerchantOffersPacket;
import net.minecraft.network.protocol.game.ClientboundMountScreenOpenPacket;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundMoveMinecartPacket;
import net.minecraft.network.protocol.game.ClientboundMoveVehiclePacket;
import net.minecraft.network.protocol.game.ClientboundOpenBookPacket;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.protocol.game.ClientboundOpenSignEditorPacket;
import net.minecraft.network.protocol.game.ClientboundPlaceGhostRecipePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerChatPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerCombatEndPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerCombatEnterPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerCombatKillPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoRemovePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerLookAtPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerRotationPacket;
import net.minecraft.network.protocol.game.ClientboundProjectilePowerPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookRemovePacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookSettingsPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundResetScorePacket;
import net.minecraft.network.protocol.game.ClientboundRespawnPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.network.protocol.game.ClientboundSectionBlocksUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSelectAdvancementsTabPacket;
import net.minecraft.network.protocol.game.ClientboundServerDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
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
import net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.network.protocol.game.ClientboundSoundEntityPacket;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.network.protocol.game.ClientboundStartConfigurationPacket;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.network.protocol.game.ClientboundTabListPacket;
import net.minecraft.network.protocol.game.ClientboundTagQueryPacket;
import net.minecraft.network.protocol.game.ClientboundTakeItemEntityPacket;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.network.protocol.game.ClientboundTestInstanceBlockStatus;
import net.minecraft.network.protocol.game.ClientboundTickingStatePacket;
import net.minecraft.network.protocol.game.ClientboundTickingStepPacket;
import net.minecraft.network.protocol.game.ClientboundTrackedWaypointPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateRecipesPacket;
import net.minecraft.network.protocol.ping.ClientboundPongResponsePacket;

// $VF: Compiled from s
public abstract class AbstractBotPlayPacketListener implements ClientGamePacketListener {
   @Override
   public void handleSetEquipment(ClientboundSetEquipmentPacket var1) {
   }

   @Override
   public void handleSelectAdvancementsTab(ClientboundSelectAdvancementsTabPacket var1) {
   }

   @Override
   public void handleLogin(ClientboundLoginPacket var1) {
   }

   @Override
   public void handleLowDiskSpaceWarning(ClientboundLowDiskSpaceWarningPacket var1) {
   }

   @Override
   public void handleCustomReportDetails(ClientboundCustomReportDetailsPacket var1) {
   }

   @Override
   public void handleSetPlayerTeamPacket(ClientboundSetPlayerTeamPacket var1) {
   }

   @Override
   public void handleDeleteChat(ClientboundDeleteChatPacket var1) {
   }

   @Override
   public void handleEntityEvent(ClientboundEntityEventPacket var1) {
   }

   @Override
   public void handleDebugEvent(ClientboundDebugEventPacket var1) {
   }

   @Override
   public void handlePlayerInfoUpdate(ClientboundPlayerInfoUpdatePacket var1) {
   }

   @Override
   public void handleInitializeBorder(ClientboundInitializeBorderPacket var1) {
   }

   @Override
   public void handleAwardStats(ClientboundAwardStatsPacket var1) {
   }

   @Override
   public void handleSetSimulationDistance(ClientboundSetSimulationDistancePacket var1) {
   }

   @Override
   public void handleClearDialog(ClientboundClearDialogPacket var1) {
   }

   @Override
   public void handleWaypoint(ClientboundTrackedWaypointPacket var1) {
   }

   @Override
   public void handlePongResponse(ClientboundPongResponsePacket var1) {
   }

   @Override
   public void handleContainerClose(ClientboundContainerClosePacket var1) {
   }

   @Override
   public void handleCommandSuggestions(ClientboundCommandSuggestionsPacket var1) {
   }

   @Override
   public void handleForgetLevelChunk(ClientboundForgetLevelChunkPacket var1) {
   }

   @Override
   public void handleHurtAnimation(ClientboundHurtAnimationPacket var1) {
   }

   @Override
   public void handleTagQueryPacket(ClientboundTagQueryPacket var1) {
   }

   @Override
   public void handleBundlePacket(ClientboundBundlePacket var1) {
   }

   @Override
   public void handleChunkBatchStart(ClientboundChunkBatchStartPacket var1) {
   }

   @Override
   public void handleDebugSample(ClientboundDebugSamplePacket var1) {
   }

   @Override
   public void handleRecipeBookAdd(ClientboundRecipeBookAddPacket var1) {
   }

   @Override
   public void handleRotateMob(ClientboundRotateHeadPacket var1) {
   }

   @Override
   public void handlePlayerInfoRemove(ClientboundPlayerInfoRemovePacket var1) {
   }

   @Override
   public void handleChunkBlocksUpdate(ClientboundSectionBlocksUpdatePacket var1) {
   }

   @Override
   public void handleBlockEvent(ClientboundBlockEventPacket var1) {
   }

   @Override
   public void handleSoundEntityEvent(ClientboundSoundEntityPacket var1) {
   }

   @Override
   public void handleMoveEntity(ClientboundMoveEntityPacket var1) {
   }

   @Override
   public void handleSetDisplayObjective(ClientboundSetDisplayObjectivePacket var1) {
   }

   @Override
   public void handleOpenBook(ClientboundOpenBookPacket var1) {
   }

   @Override
   public void handleGameEvent(ClientboundGameEventPacket var1) {
   }

   @Override
   public void handleSetExperience(ClientboundSetExperiencePacket var1) {
   }

   @Override
   public void handleSetCamera(ClientboundSetCameraPacket var1) {
   }

   @Override
   public void handleMountScreenOpen(ClientboundMountScreenOpenPacket var1) {
   }

   @Override
   public void handleUpdateMobEffect(ClientboundUpdateMobEffectPacket var1) {
   }

   @Override
   public void handleCustomChatCompletions(ClientboundCustomChatCompletionsPacket var1) {
   }

   @Override
   public void handleContainerSetSlot(ClientboundContainerSetSlotPacket var1) {
   }

   @Override
   public void handleConfigurationStart(ClientboundStartConfigurationPacket var1) {
   }

   @Override
   public void handleSetEntityPassengersPacket(ClientboundSetPassengersPacket var1) {
   }

   @Override
   public void handleOpenScreen(ClientboundOpenScreenPacket var1) {
   }

   @Override
   public void handleEntityLinkPacket(ClientboundSetEntityLinkPacket var1) {
   }

   @Override
   public void handleTabListCustomisation(ClientboundTabListPacket var1) {
   }

   @Override
   public void handleTitlesClear(ClientboundClearTitlesPacket var1) {
   }

   @Override
   public void handleSetScore(ClientboundSetScorePacket var1) {
   }

   @Override
   public void handleSetBorderWarningDelay(ClientboundSetBorderWarningDelayPacket var1) {
   }

   @Override
   public void handleUpdateTags(ClientboundUpdateTagsPacket var1) {
   }

   @Override
   public void handleSetBorderLerpSize(ClientboundSetBorderLerpSizePacket var1) {
   }

   @Override
   public void handleGameTestHighlightPos(ClientboundGameTestHighlightPosPacket var1) {
   }

   @Override
   public void setActionBarText(ClientboundSetActionBarTextPacket var1) {
   }

   @Override
   public void handlePing(ClientboundPingPacket var1) {
   }

   @Override
   public void handleBossUpdate(ClientboundBossEventPacket var1) {
   }

   @Override
   public void handleSetEntityData(ClientboundSetEntityDataPacket var1) {
   }

   @Override
   public void handleSetBorderCenter(ClientboundSetBorderCenterPacket var1) {
   }

   @Override
   public void handleBlockUpdate(ClientboundBlockUpdatePacket var1) {
   }

   @Override
   public void handleSetHeldSlot(ClientboundSetHeldSlotPacket var1) {
   }

   @Override
   public void setSubtitleText(ClientboundSetSubtitleTextPacket var1) {
   }

   @Override
   public void handleContainerSetData(ClientboundContainerSetDataPacket var1) {
   }

   @Override
   public void setTitleText(ClientboundSetTitleTextPacket var1) {
   }

   @Override
   public void handleExplosion(ClientboundExplodePacket var1) {
   }

   @Override
   public void handleRespawn(ClientboundRespawnPacket var1) {
   }

   @Override
   public void handlePlaceRecipe(ClientboundPlaceGhostRecipePacket var1) {
   }

   @Override
   public void handlePlayerCombatEnd(ClientboundPlayerCombatEndPacket var1) {
   }

   @Override
   public void handleTeleportEntity(ClientboundTeleportEntityPacket var1) {
   }

   @Override
   public void handleAnimate(ClientboundAnimatePacket var1) {
   }

   @Override
   public void handleLevelChunkWithLight(ClientboundLevelChunkWithLightPacket var1) {
   }

   @Override
   public void handleDisconnect(ClientboundDisconnectPacket var1) {
   }

   @Override
   public void handleDebugBlockValue(ClientboundDebugBlockValuePacket var1) {
   }

   @Override
   public void handleTransfer(ClientboundTransferPacket var1) {
   }

   @Override
   public void handleSetPlayerInventory(ClientboundSetPlayerInventoryPacket var1) {
   }

   @Override
   public void handleMerchantOffers(ClientboundMerchantOffersPacket var1) {
   }

   @Override
   public void handleStoreCookie(ClientboundStoreCookiePacket var1) {
   }

   @Override
   public void handleCustomPayload(ClientboundCustomPayloadPacket var1) {
   }

   @Override
   public void handleRemoveEntities(ClientboundRemoveEntitiesPacket var1) {
   }

   @Override
   public void handleBlockDestruction(ClientboundBlockDestructionPacket var1) {
   }

   @Override
   public void handleAddEntity(ClientboundAddEntityPacket var1) {
   }

   @Override
   public void handleUpdateRecipes(ClientboundUpdateRecipesPacket var1) {
   }

   @Override
   public void handleRotatePlayer(ClientboundPlayerRotationPacket var1) {
   }

   @Override
   public void handleServerLinks(ClientboundServerLinksPacket var1) {
   }

   @Override
   public void setTitlesAnimation(ClientboundSetTitlesAnimationPacket var1) {
   }

   @Override
   public void handleUpdateAttributes(ClientboundUpdateAttributesPacket var1) {
   }

   @Override
   public void handleStopSoundEvent(ClientboundStopSoundPacket var1) {
   }

   @Override
   public void handleRecipeBookSettings(ClientboundRecipeBookSettingsPacket var1) {
   }

   @Override
   public void handleChangeDifficulty(ClientboundChangeDifficultyPacket var1) {
   }

   @Override
   public void handleEntityPositionSync(ClientboundEntityPositionSyncPacket var1) {
   }

   @Override
   public void handleDebugEntityValue(ClientboundDebugEntityValuePacket var1) {
   }

   @Override
   public void handlePlayerAbilities(ClientboundPlayerAbilitiesPacket var1) {
   }

   @Override
   public void handleChunkBatchFinished(ClientboundChunkBatchFinishedPacket var1) {
   }

   @Override
   public void handleBlockChangedAck(ClientboundBlockChangedAckPacket var1) {
   }

   @Override
   public void handleLightUpdatePacket(ClientboundLightUpdatePacket var1) {
   }

   @Override
   public void handleSetBorderSize(ClientboundSetBorderSizePacket var1) {
   }

   @Override
   public void handleResetScore(ClientboundResetScorePacket var1) {
   }

   @Override
   public void handleTakeItemEntity(ClientboundTakeItemEntityPacket var1) {
   }

   @Override
   public void handleBlockEntityData(ClientboundBlockEntityDataPacket var1) {
   }

   @Override
   public void handleDamageEvent(ClientboundDamageEventPacket var1) {
   }

   @Override
   public void handleUpdateAdvancementsPacket(ClientboundUpdateAdvancementsPacket var1) {
   }

   @Override
   public void handleGameRuleValues(ClientboundGameRuleValuesPacket var1) {
   }

   @Override
   public void handleMinecartAlongTrack(ClientboundMoveMinecartPacket var1) {
   }

   @Override
   public void handleOpenSignEditor(ClientboundOpenSignEditorPacket var1) {
   }

   @Override
   public void handleTickingState(ClientboundTickingStatePacket var1) {
   }

   @Override
   public void handleSetHealth(ClientboundSetHealthPacket var1) {
   }

   @Override
   public void handleShowDialog(ClientboundShowDialogPacket var1) {
   }

   @Override
   public void handleProjectilePowerPacket(ClientboundProjectilePowerPacket var1) {
   }

   @Override
   public void handleSetChunkCacheCenter(ClientboundSetChunkCacheCenterPacket var1) {
   }

   @Override
   public void handleKeepAlive(ClientboundKeepAlivePacket var1) {
   }

   @Override
   public void handleSetSpawn(ClientboundSetDefaultSpawnPositionPacket var1) {
   }

   @Override
   public void handleChunksBiomes(ClientboundChunksBiomesPacket var1) {
   }

   @Override
   public void handleRequestCookie(ClientboundCookieRequestPacket var1) {
   }

   @Override
   public void handlePlayerCombatEnter(ClientboundPlayerCombatEnterPacket var1) {
   }

   @Override
   public void handleContainerContent(ClientboundContainerSetContentPacket var1) {
   }

   @Override
   public void handleSystemChat(ClientboundSystemChatPacket var1) {
   }

   @Override
   public void handleSetCursorItem(ClientboundSetCursorItemPacket var1) {
   }

   @Override
   public void handleServerData(ClientboundServerDataPacket var1) {
   }

   @Override
   public void handleResourcePackPop(ClientboundResourcePackPopPacket var1) {
   }

   @Override
   public void handleLookAt(ClientboundPlayerLookAtPacket var1) {
   }

   @Override
   public void handleCommands(ClientboundCommandsPacket var1) {
   }

   @Override
   public void handleDebugChunkValue(ClientboundDebugChunkValuePacket var1) {
   }

   @Override
   public void handlePlayerChat(ClientboundPlayerChatPacket var1) {
   }

   @Override
   public void handleSoundEvent(ClientboundSoundPacket var1) {
   }

   @Override
   public void handleItemCooldown(ClientboundCooldownPacket var1) {
   }

   @Override
   public void handleSetChunkCacheRadius(ClientboundSetChunkCacheRadiusPacket var1) {
   }

   @Override
   public void handleAddObjective(ClientboundSetObjectivePacket var1) {
   }

   @Override
   public void handleSetTime(ClientboundSetTimePacket var1) {
   }

   @Override
   public void handleMapItemData(ClientboundMapItemDataPacket var1) {
   }

   @Override
   public void handleMoveVehicle(ClientboundMoveVehiclePacket var1) {
   }

   @Override
   public void handleTestInstanceBlockStatus(ClientboundTestInstanceBlockStatus var1) {
   }

   @Override
   public void handleResourcePackPush(ClientboundResourcePackPushPacket var1) {
   }

   @Override
   public void handleParticleEvent(ClientboundLevelParticlesPacket var1) {
   }

   @Override
   public void handleSetBorderWarningDistance(ClientboundSetBorderWarningDistancePacket var1) {
   }

   @Override
   public void handleSetEntityMotion(ClientboundSetEntityMotionPacket var1) {
   }

   @Override
   public void handleRemoveMobEffect(ClientboundRemoveMobEffectPacket var1) {
   }

   @Override
   public void handlePlayerCombatKill(ClientboundPlayerCombatKillPacket var1) {
   }

   @Override
   public void handleLevelEvent(ClientboundLevelEventPacket var1) {
   }

   @Override
   public void handleMovePlayer(ClientboundPlayerPositionPacket var1) {
   }

   @Override
   public void handleDisguisedChat(ClientboundDisguisedChatPacket var1) {
   }

   @Override
   public void handleTickingStep(ClientboundTickingStepPacket var1) {
   }

   @Override
   public void handleRecipeBookRemove(ClientboundRecipeBookRemovePacket var1) {
   }
}
