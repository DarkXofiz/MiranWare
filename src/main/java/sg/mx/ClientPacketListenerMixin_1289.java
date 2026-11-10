// Original binary: sg/mx/nd5bXv2hv4WL5XvO
package sg.mx;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;
import net.minecraft.network.TickablePacketListener;
import net.minecraft.network.protocol.common.ClientboundUpdateTagsPacket;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookRemovePacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookSettingsPacket;
import net.minecraft.network.protocol.game.ClientboundRespawnPacket;
import net.minecraft.network.protocol.game.ClientboundSelectAdvancementsTabPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetHeldSlotPacket;
import net.minecraft.network.protocol.game.ClientboundStartConfigurationPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateRecipesPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.BotRegistrySnapshot;
import sg.ec.KeepAliveScheduler;
import sg.ec.ClientPacketListenerHooks;
import sg.ec.ModuleManager;
import sg.ec.BotSessionManager;
import sg.ec.ServerHeldSlotEvent;
import sg.ec.EntityStatusPacketEvent;
import sg.ec.ChunkDataEvent;
import sg.ec.ChatSendEvent;

// $VF: Compiled from s
@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin_1289 extends ClientCommonPacketListenerImpl implements ClientGamePacketListener, TickablePacketListener {
   private static final String field28038 = ".";

   protected ClientPacketListenerMixin_1289(Minecraft var1, Connection var2, CommonListenerCookie var3) {
      super(var1, var2, var3);
   }

   @Inject(
      method = "handleEntityEvent",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/game/ClientboundEntityEventPacket;getEventId()B", ordinal = 0),
      cancellable = true
   )
   public void onEntityStatus(ClientboundEntityEventPacket var1, CallbackInfo var2) {
      EntityStatusPacketEvent.field21957.method09672(var1, var2);
   }

   @Inject(method = "handleSetHeldSlot", at = @At("HEAD"), cancellable = true)
   public void onSetHeldSlot(ClientboundSetHeldSlotPacket var1, CallbackInfo var2) {
      ServerHeldSlotEvent.field21251.method09335(var1.slot(), var2);
   }

   @Inject(method = "sendChat", at = @At("HEAD"), cancellable = true)
   public void sendChatMessage(String var1, CallbackInfo var2) {
      ChatSendEvent.field27858.method11713(var1, var2);
   }

   @Inject(method = "sendUnattendedCommand", at = @At("HEAD"), cancellable = true)
   public void sendUnattendedCommand(String var1, Screen var2, CallbackInfo var3) {
      if (var1.startsWith(field28038)) {
         ChatSendEvent.field27858.method11713(var1, var3);
      }
   }

   @ModifyVariable(method = "sendChat", at = @At(value = "INVOKE", target = "Ljava/time/Instant;now()Ljava/time/Instant;", ordinal = 0), argsOnly = true)
   public String sendChatMessage1(String var1) {
      return ChatSendEvent.field27858.method11711();
   }

   @Inject(
      method = "handleMoveEntity",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;moveOrInterpolateTo(Lnet/minecraft/world/entity/PositionPath;FF)V")
   )
   public void onEntity(ClientboundMoveEntityPacket var1, CallbackInfo var2, @Local Entity var3, @Local net.minecraft.world.entity.PositionPath var4) {
      ClientPacketListenerHooks.method05245(var1, var3, var4.endPosition());
   }

   @Inject(method = "handleSetEntityData", at = @At("TAIL"))
   private void onSetEntityData(ClientboundSetEntityDataPacket var1, CallbackInfo var2) {
      LocalPlayer var3 = this.minecraft.player;
      if (var3 != null && var1.id() == var3.getId()) {
         ModuleManager.INSTANCE.method08222().method02970(var3, var1.packedItems());
      }
   }

   @Inject(method = "handleLevelChunkWithLight", at = @At("RETURN"))
   private void onChunkData(ClientboundLevelChunkWithLightPacket var1, CallbackInfo var2) {
      ChunkDataEvent.field23495.method10523(var1.x(), var1.z());
   }

   @Inject(method = "handleConfigurationStart", at = @At("HEAD"))
   private void onConfigurationStart(ClientboundStartConfigurationPacket var1, CallbackInfo var2) {
      KeepAliveScheduler.INSTANCE.method03309(this.connection);
   }

   @Inject(method = "handleLogin", at = @At("RETURN"))
   private void onLogin(ClientboundLoginPacket var1, CallbackInfo var2) {
      KeepAliveScheduler.INSTANCE.method03309(this.connection);
      BotSessionManager.INSTANCE.method08737(var1);
      BotRegistrySnapshot.INSTANCE.method03175();
   }

   @Inject(method = "handleUpdateTags", at = @At("RETURN"))
   private void onUpdateTags(ClientboundUpdateTagsPacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03167(var1.tags());
   }

   @Inject(method = "handleUpdateRecipes", at = @At("RETURN"))
   private void onUpdateRecipes(ClientboundUpdateRecipesPacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03168(var1);
   }

   @Inject(method = "handleRecipeBookAdd", at = @At("RETURN"))
   private void onRecipeBookAdd(ClientboundRecipeBookAddPacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03169(var1);
   }

   @Inject(method = "handleRecipeBookRemove", at = @At("RETURN"))
   private void onRecipeBookRemove(ClientboundRecipeBookRemovePacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03170(var1);
   }

   @Inject(method = "handleRecipeBookSettings", at = @At("RETURN"))
   private void onRecipeBookSettings(ClientboundRecipeBookSettingsPacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03171(var1);
   }

   @Inject(method = "handleUpdateAdvancementsPacket", at = @At("RETURN"))
   private void onUpdateAdvancements(ClientboundUpdateAdvancementsPacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03172(var1);
   }

   @Inject(method = "handleSelectAdvancementsTab", at = @At("RETURN"))
   private void onSelectAdvancementsTab(ClientboundSelectAdvancementsTabPacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03173(var1);
   }

   @Inject(method = "handleRespawn", at = @At("RETURN"))
   private void onRespawn(ClientboundRespawnPacket var1, CallbackInfo var2) {
      BotSessionManager.INSTANCE.method08738(var1.commonPlayerSpawnInfo());
   }

}
