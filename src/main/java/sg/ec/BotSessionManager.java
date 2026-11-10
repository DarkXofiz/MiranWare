// Original binary: sg/ec/i5EvP4L0IhgOUIA0
package sg.ec;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.utils.InputOverrideHandler;
import hex.api.baritone.utils.accessor.IPlayerControllerMP;
import io.netty.channel.Channel;
import net.minecraft.client.User;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.CommonPlayerSpawnInfo;
import sg.mx.BlockStatePredictionHandlerMixin;
import sg.mx.ClientLevelMixin_1241;
import sg.mx.ClientPacketListenerMixin;
import sg.mx.ConnectionMixin_1310;
import sg.mx.LocalPlayerMixin_1170;
import sg.mx.MinecraftMixin;
import sg.mx.MultiPlayerGameModeMixin_1233;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public enum BotSessionManager implements MinecraftAccess {
   INSTANCE;

   private volatile User field19980;
   private volatile BotClient field19981;
   private volatile BotClient field19982;
   private ClientboundLoginPacket field19983;
   private static final int field19984 = 2;
   private volatile Runnable field19985;
   private volatile boolean field19986;
   private volatile boolean field19987;
   private volatile int field19988;
   private volatile int field19989;

   public User method08730() {
      return this.field19980 != null ? this.field19980 : mc.getUser();
   }

   public void method08731(User var1) {
      if (this.field19980 != null) {
         this.field19980 = var1;
      }
   }

   public boolean method08732() {
      return this.field19982 != null;
   }

   public boolean method08733(BotClient var1) {
      return var1 == null ? false : this.field19982 == var1 || this.field19982 == null && var1 == this.field19981;
   }

   public String method08734() {
      User var1 = mc.getUser();
      return var1 == null ? "" : var1.getName();
   }

   public String method08735() {
      return this.field19982 == null ? this.method08730().getName() : this.field19982.method00137().method00491();
   }

   public boolean method08736() {
      return BotSessionTransfer.method02475(this.field19981);
   }

   public void method08737(ClientboundLoginPacket var1) {
      this.field19983 = var1;
   }

   public void method08738(CommonPlayerSpawnInfo var1) {
      ClientboundLoginPacket var2 = this.field19983;
      if (var2 != null) {
         this.field19983 = new ClientboundLoginPacket(
            var2.playerId(),
            var2.hardcore(),
            var2.levels(),
            var2.maxPlayers(),
            var2.chunkRadius(),
            var2.simulationDistance(),
            var2.reducedDebugInfo(),
            var2.showDeathScreen(),
            var2.doLimitedCrafting(),
            var1,
            var2.onlineMode(),
            var2.enforcesSecureChat()
         );
      }
   }

   public void method08739(BotClient var1) {
      if (var1 != null && var1 != this.field19982 && BotSessionTransfer.method02472(var1)) {
         this.method08743(() -> this.method08740(var1));
      }
   }

   private void method08740(BotClient var1) {
      if (var1 != null && var1 != this.field19982 && BotSessionTransfer.method02475(var1)) {
         boolean var2 = this.field19980 == null;
         if (var2) {
            this.field19980 = mc.getUser();
         }

         if (!this.method08750(var1)) {
            if (var2) {
               this.field19980 = null;
            }
         } else {
            ((MinecraftMixin)(Object)mc).setSession(var1.method00137().method00484());
            this.field19982 = var1;
            NotificationManager.method08597("Ты играешь за " + var1.method00137().method00491(), 3000L, NotificationType.INFO);
         }
      }
   }

   public void method08741() {
      if (BotSessionTransfer.method02475(this.field19981)) {
         this.method08743(this::method08746);
      } else if (this.field19982 != null) {
         this.method08743(this::method08747);
      }
   }

   public boolean method08742(String var1) {
      BotClient var2 = this.field19981;
      if (var2 != null && this.field19982 == null && BotSessionTransfer.method02475(var2)) {
         if (!BotManager.method03087(var1).equals(BotManager.method03087(var2.method00137().method00486()))) {
            return false;
         }

         this.method08743(this::method08746);
         return true;
      } else {
         return false;
      }
   }

   private void method08743(Runnable var1) {
      this.field19985 = var1;
      this.field19987 = mc.player != null;
      this.field19988 = 0;
      this.field19989 = 0;
   }

   public void method08744(PlayerInputEvent var1) {
      if (this.field19987) {
         var1.method11167(0.0F);
         var1.method11158(0.0F);
         var1.method11173(false);
         var1.method11169(false);
         var1.method11174(false);
         this.field19988++;
      }
   }

   public void method08745() {
      Runnable var1 = this.field19985;
      if (var1 != null) {
         if (this.field19987 && mc.player != null && this.field19988 < 1 && this.field19989 < 2) {
            this.field19989++;
         } else {
            this.field19987 = false;
            this.field19989 = 0;
            this.field19985 = null;
            mc.execute(var1);
         }
      }
   }

   private void method08746() {
      User var1 = this.method08730();
      boolean var2 = this.method08750(this.field19981);
      if (!var2 && mc.getConnection() != null) {
         NotificationManager.method08597("Своя сессия не отвечает, остаёшься в боте", 3500L, NotificationType.ERROR);
      } else {
         ((MinecraftMixin)(Object)mc).setSession(var1);
         this.field19980 = null;
         this.field19982 = null;
         if (var2) {
            NotificationManager.method08597("Ты снова " + var1.getName(), 3000L, NotificationType.INFO);
         } else {
            NotificationManager.method08597("Сессия не восстановилась, управление ботом снято", 3500L, NotificationType.ERROR);
         }
      }
   }

   private void method08747() {
      BotClient var1 = this.field19982;
      User var2 = this.method08730();
      this.field19986 = true;

      try {
         this.method08754(null);
      } catch (Throwable var7) {
         NotificationManager.method08597("Не удалось отдать сессию боту: " + var7.getClass().getSimpleName(), 4000L, NotificationType.ERROR);
      } finally {
         this.field19986 = false;
      }

      this.method08759();
      ((MinecraftMixin)(Object)mc).setSession(var2);
      this.field19980 = null;
      this.field19982 = null;
      mc.setScreen(new JoinMultiplayerScreen(TitleScreenHooks.method11006()));
      if (var1 != null) {
         NotificationManager.method08597(var1.method00137().method00491() + " продолжает сам, ты в списке серверов", 3500L, NotificationType.INFO);
      }
   }

   public boolean method08748() {
      return this.field19986 || this.field19985 != null;
   }

   public boolean method08749() {
      return this.field19986;
   }

   private boolean method08750(BotClient var1) {
      this.field19986 = true;
      boolean var2 = false;

      try {
         return this.method08751(var1);
      } finally {
         this.field19986 = false;
         if (!var2 && mc.level == null) {
            mc.setScreen(null);
         }
      }
   }

   private boolean method08751(BotClient var1) {
      Connection var2 = var1.method00128();
      if (var2 != null && var2.isConnected() && var1.method00146() == BotConnectionState.PLAYING) {
         this.method08753(var2, true);
         boolean var3 = false;

         try {
            try {
               this.method08754(var2);
            } catch (Throwable var11) {
               NotificationManager.method08597("Не удалось отложить текущую сессию: " + var11.getClass().getSimpleName(), 4000L, NotificationType.ERROR);
               return false;
            }

            if (var1.method00091() == null) {
               this.method08759();
               NotificationManager.method08597("Соединение сессии потеряно", 2500L, NotificationType.ERROR);
               return false;
            }

            this.method08759();

            try {
               BotSessionTransfer.method02478(var1, var2);
            } catch (Throwable var10) {
               var1.method00075("Захват сорвался: " + var10.getClass().getSimpleName());
               var2.disconnect(Component.literal("Takeover failed"));
               NotificationManager.method08597("Захват сорвался: " + var10.getClass().getSimpleName(), 4000L, NotificationType.ERROR);
               return false;
            }

            var3 = true;
            return true;
         } finally {
            if (!var3) {
               this.method08753(var2, false);
            }
         }
      } else {
         NotificationManager.method08597("Соединение сессии потеряно", 2500L, NotificationType.ERROR);
         return false;
      }
   }

   private void method08752(BotClient var1) {
      if (mc.level != null) {
         var1.method00082().method06253(((BlockStatePredictionHandlerMixin)(Object)((ClientLevelMixin_1241)(Object)mc.level).predictionHandler()).getCurrentSequence());
      }

      if (mc.player != null) {
         LocalPlayerMixin_1170 var2 = (LocalPlayerMixin_1170)(Object)mc.player;
         var1.method00145(
            var2.lastX(),
            var2.lastY(),
            var2.lastZ(),
            var2.lastYRot(),
            var2.lastXRot(),
            var2.lastOnGround(),
            var2.lastHorizontalCollision(),
            var2.positionReminder()
         );
      }
   }

   private void method08753(Connection var1, boolean var2) {
      BotSessionTransfer.method02473(var1, var2);
   }

   private void method08754(Connection var1) {
      ClientPacketListener var2 = mc.getConnection();
      if (var2 != null && var2.getConnection() != var1) {
         Connection var3 = var2.getConnection();
         this.method08753(var3, true);

         try {
            Channel var4 = ((ConnectionMixin_1310)(Object)var3).getChannel();
            if (var4 != null && !var4.eventLoop().inEventLoop()) {
               var4.eventLoop().submit(() -> null).syncUninterruptibly();
            }

            BotClient var5 = this.field19982 != null ? this.field19982 : this.method08756(var2);
            boolean var6 = mc.gameMode != null && (mc.gameMode.isDestroying() || this.method08757(var5));
            BlockPos var7 = var6 ? ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode).getDestroyBlockPos() : null;
            float var8 = var6 ? ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode).getDestroyProgress() : 0.0F;
            int var9 = mc.gameMode == null ? var5.method00070().method07987() : ((MultiPlayerGameModeMixin_1233)(Object)mc.gameMode).getCarriedIndex();
            if (mc.gameMode != null) {
               ((IPlayerControllerMP)mc.gameMode).setIsHittingBlock(false);
               ((IPlayerControllerMP)mc.gameMode).setDestroyDelay(0);
            }

            if (var3.isConnected()) {
               var3.tick();
               mc.packetProcessor().processQueuedPackets();
            }

            var5.method00152(((ClientPacketListenerMixin)(Object)var2).getNextChatIndex());
            var5.method00124(((ClientPacketListenerMixin)(Object)var2).getLastSeenMessages());
            var5.method00073(((ClientPacketListenerMixin)(Object)var2).getMessageSignatureCache());
            var5.method00064(mc.gui.getChat().storeState());
            var5.method00130(((ClientPacketListenerMixin)(Object)var2).getCommandDispatcher());
            boolean var10 = false;

            try {
               if (var3.isConnected()) {
                  var5.method00132(var3);
                  this.method08752(var5);
               }

               var10 = mc.level != null && mc.player != null && var3.isConnected() && BotWorldSynchronizer.method04461(var5, var2, this.field19983);
               var5.method00082().method06254(var6, var7, var8, var9);
            } finally {
               if (var3.isConnected()) {
                  if (!var10) {
                     var5.method00090().method07649();
                     var5.method00070().method07980();
                  }

                  try {
                     var5.method00090().method07638();
                  } catch (Throwable var23) {
                  }
               }

               var2.close();
            }
         } finally {
            this.method08753(var3, false);
         }
      }
   }

   public BotClient method08755() {
      BotClient var1 = this.field19981;
      if (var1 != null) {
         return var1;
      }

      ClientPacketListener var2 = mc.getConnection();
      return var2 != null && mc.player != null ? this.method08756(var2) : null;
   }

   private BotClient method08756(ClientPacketListener var1) {
      if (this.field19981 == null) {
         AutoBuyBotState var2 = AutoBuyBotState.method00476(this.method08730(), BotManager.INSTANCE.method03086());
         this.field19981 = new BotClient(var2);
      } else {
         this.field19981.method00137().method00477(BotManager.INSTANCE.method03086());
      }

      this.field19981.method00070().method07959(var1.getLocalGameProfile().id());
      this.field19981.method00090().method07797(BotRegistrySnapshot.INSTANCE.method03181());
      return this.field19981;
   }

   private boolean method08757(BotClient var1) {
      IBaritone var2 = var1.method00099();
      return var2 != null && var2.getInputOverrideHandler() instanceof InputOverrideHandler var3 && var3.getBlockBreakHelper().isBreaking();
   }

   public void method08758(Connection var1) {
      BotClient var2 = this.field19982;
      if (var2 != null && !this.field19986) {
         if (var1 == null || !((BotConnectionAccess)var1).isBotConnection()) {
            var2.method00074(BotConnectionState.IDLE);
            if (BotSessionTransfer.method02475(this.field19981)) {
               this.method08743(this::method08746);
            } else {
               ((MinecraftMixin)(Object)mc).setSession(this.method08730());
               this.field19980 = null;
               this.field19982 = null;
            }
         }
      }
   }

   private void method08759() {
      mc.player = null;
      ((MinecraftMixin)(Object)mc).setPendingConnection(null);
      mc.disconnectWithProgressScreen(false);
   }

   public User method08760() {
      return this.field19980;
   }

   public BotClient method08761() {
      return this.field19981;
   }

   public BotClient method08762() {
      return this.field19982;
   }
}
