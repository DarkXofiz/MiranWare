// Original binary: sg/ec/A8FOCTPyTeeUc1XJ
package sg.ec;

import hex.api.baritone.utils.accessor.IPlayerControllerMP;
import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.components.ChatComponent.State;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.client.multiplayer.LevelLoadTracker;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerData.Type;
import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.client.multiplayer.chat.GuiMessageSource;
import net.minecraft.client.multiplayer.chat.report.ReportEnvironment;
import net.minecraft.client.resources.server.ServerPackManager.PackPromptStatus;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerLoadedPacket;
import net.minecraft.server.ServerLinks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import sg.mx.BlockStatePredictionHandlerMixin;
import sg.mx.ClientLevelMixin_1241;
import sg.mx.ClientPacketListenerMixin;
import sg.mx.ConnectionMixin_1310;
import sg.mx.LocalPlayerMixin_1170;
import sg.mx.MinecraftMixin;
import sg.mx.MultiPlayerGameModeMixin_1233;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public final class BotSessionTransfer implements MinecraftAccess {
   private static final String field05984 = "Сессия не в игре";
   private static final long field05985 = 2500L;
   private static final String field05986 = "Сессия ещё не прогрузилась";
   private static final long field05987 = 2500L;
   private static final String field05988 = "TAGS";

   public static boolean method02472(BotClient var0) {
      if (method02475(var0)) {
         return true;
      }

      if (var0 != null && var0.method00146().method05278()) {
         NotificationManager.method08597(field05986, field05987, NotificationType.ERROR);
      } else {
         NotificationManager.method08597(field05984, field05985, NotificationType.ERROR);
      }

      return false;
   }

   public static void method02473(Connection var0, boolean var1) {
      Channel var2 = ((ConnectionMixin_1310)(Object)var0).getChannel();
      if (var2 != null) {
         var2.config().setAutoRead(!var1);
      }
   }

   private BotSessionTransfer() {
   }

   private static void method02474(BotClient var0, Connection var1) {
      BotWorldState var2 = var0.method00090();
      BotPlayerState var3 = var0.method00070();
      String var4 = var0.method00137().method00486();
      ServerData var5 = new ServerData(var0.method00137().method00491(), var4, Type.OTHER);
      if (var0.method00137().method00489()) {
         mc.prepareForMultiplayer();
      }

      mc.updateReportEnvironment(ReportEnvironment.thirdParty(var4));
      mc.getDownloadedPackSource().configureForServerControl(var1, PackPromptStatus.DECLINED);
      ((BotConnectionAccess)var1).setBotConnection(false);
      BotConnectionAccess.method05260(var1);
      var1.setBandwidthLogger(mc.getDebugOverlay().getBandwidthLogger());
      RegistryDataMerger.method08053();
      RegistryDataMerger.method08066(var2.method07684());
      String.valueOf("реестров " + var2.method07684().size() + ", камень под кирку " + Blocks.STONE.defaultBlockState().is(BlockTags.MINEABLE_WITH_PICKAXE));
      RegistryDataMerger.method08042(var2.method07758());
      CommonListenerCookie var6 = new CommonListenerCookie(
         new LevelLoadTracker(),
         var3.method08012(),
         mc.getTelemetryManager().createWorldSessionManager(false, null, null, var3.method08001()),
         var2.method07758(),
         var2.method07816(),
         var2.method07815(),
         var5,
         null,
         new HashMap<>(),
         method02476(var0),
         Map.of(),
         ServerLinks.EMPTY,
         Map.of(),
         false
      );
      ClientPacketListener var7 = new ClientPacketListener(mc, var1, var6);
      ClientPacketListenerMixin var8 = (ClientPacketListenerMixin)(Object)var7;
      var8.getPlayerInfoMap().putAll(var2.method07793());
      var8.getListedPlayers().addAll(var2.method07698());
      if (var0.method00096() != null) {
         var8.setCommandDispatcher(var0.method00096());
      }

      var2.method07746(method02477(var2.method07716(), var0.method00137().method00489()));
      var2.method07641(mc.packetProcessor(), var7);
      var3.method07957(mc.packetProcessor(), var7);
      double var9 = var3.method08006();
      double var11 = var3.method07981();
      double var13 = var3.method08004();
      float var15 = var3.method08008();
      float var16 = var3.method08003();
      boolean var17 = var3.method07991();
      boolean var18 = var3.method07986();
      double var19 = var3.method07994();
      double var21 = var3.method07947();
      double var23 = var3.method07948();
      ConnectionMixin_1310 var25 = (ConnectionMixin_1310)(Object)var1;
      var25.setDisconnectListener(null);
      var25.setPacketListener(var7);
      ((MinecraftMixin)(Object)mc).setPendingConnection(var1);
      var2.method07742(mc.packetProcessor(), var7);
      var2.method07649();
      mc.packetProcessor().processQueuedPackets();
      var8.setNextChatIndex(var0.method00161());
      var8.setLastSeenMessages(var0.method00083());
      var8.setMessageSignatureCache(var0.method00112());
      if (mc.player == null) {
         mc.gui.setScreen(null);
      } else {
         if (mc.gameMode != null) {
            ((MultiPlayerGameModeMixin_1233)(Object)mc.gameMode).setCarriedIndex(var3.method07987());
            boolean var26 = var0.method00082().method06255() && var0.method00082().method06263() != null;
            IPlayerControllerMP var27 = (IPlayerControllerMP)mc.gameMode;
            MultiPlayerGameModeMixin_1262 var28 = (MultiPlayerGameModeMixin_1262)(Object)mc.gameMode;
            if (var26) {
               var28.setDestroyBlockPos(var0.method00082().method06263());
               var28.setDestroyProgress(var0.method00082().method06261());
               var28.setDestroyingItem(mc.player.getMainHandItem().copy());
            }

            var27.setIsHittingBlock(var26);
         }

         mc.player.snapTo(var9, var11, var13, var15, var16);
         mc.player.setOnGround(var17);
         mc.player.setDeltaMovement(var19, var21, var23);
         LocalPlayerMixin_1170 var29 = (LocalPlayerMixin_1170)(Object)mc.player;
         boolean var30 = var0.method00078();
         var29.setLastX(var30 ? var0.method00092() : var9);
         var29.setLastY(var30 ? var0.method00094() : var11);
         var29.setLastZ(var30 ? var0.method00150() : var13);
         var29.setLastYRot(var30 ? var0.method00097() : var15);
         var29.setLastXRot(var30 ? var0.method00071() : var16);
         var29.setLastOnGround(var30 ? var0.method00163() : var17);
         var29.setLastHorizontalCollision(var30 ? var0.method00120() : var18);
         var29.setPositionReminder(var30 ? var0.method00080() : 0);
         if (mc.level != null) {
            ((BlockStatePredictionHandlerMixin)(Object)((ClientLevelMixin_1241)(Object)mc.level).predictionHandler()).setCurrentSequence(var0.method00082().method06252());
         }

         int var31 = var0.method00070().method07946();
         if (var31 > mc.player.inventoryMenu.getStateId()) {
            mc.player.inventoryMenu.initializeContents(var31, mc.player.inventoryMenu.getItems(), mc.player.inventoryMenu.getCarried());
         }

         var8.setLevelLoadTracker(null);
         var8.markClientLoaded(true);
         var1.send(new ServerboundPlayerLoadedPacket());
         var7.broadcastClientInformation(mc.options.buildPlayerInformation());
         if (mc.gui.screen() != null) {
            mc.gui.setScreen(null);
         }
      }
   }

   public static boolean method02475(BotClient var0) {
      return var0 != null
         && var0.method00146().method05278()
         && var0.method00090().method07683()
         && var0.method00090().method07729()
         && var0.method00070().method08012() != null;
   }

   private static State method02476(BotClient var0) {
      var var1 = new ArrayList<>(mc.gui.hud.getChat().getRecentChat());
      var var2 = var0.method00141();
      if (var2.isEmpty()) {
         return null;
      }

      var var3 = new ArrayList(var2.size());
      int var4 = mc.gui.hud.getGuiTicks();

      for (int var5 = var2.size() - 1; var5 >= 0; var5--) {
         var3.add(new GuiMessage(var4, (Component)var2.get(var5), null, GuiMessageSource.SYSTEM_SERVER, null));
      }

      return new State(var3, var1, List.of());
   }

   private static ClientboundLoginPacket method02477(ClientboundLoginPacket var0, boolean var1) {
      return var0.onlineMode() == var1
         ? var0
         : new ClientboundLoginPacket(
            var0.playerId(),
            var0.hardcore(),
            var0.levels(),
            var0.maxPlayers(),
            var0.chunkRadius(),
            var0.simulationDistance(),
            var0.reducedDebugInfo(),
            var0.showDeathScreen(),
            var0.doLimitedCrafting(),
            var0.commonPlayerSpawnInfo(),
            var1,
            var0.enforcesSecureChat()
         );
   }

   public static void method02478(BotClient var0, Connection var1) {
      try {
         method02474(var0, var1);
      } finally {
         ((MinecraftMixin)(Object)mc).setPendingConnection(null);
         method02473(var1, false);
      }
   }
}
