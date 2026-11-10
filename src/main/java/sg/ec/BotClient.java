// Original binary: sg/ec/0bzF8nEAlTlIHFuS
package sg.ec;

import com.mojang.brigadier.CommandDispatcher;
import hex.api.baritone.BaritoneProvider;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.behavior.IPathingBehavior;
import hex.api.baritone.api.event.events.PlayerUpdateEvent;
import hex.api.baritone.api.event.events.SprintStateEvent;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.event.events.WorldEvent;
import hex.api.baritone.api.event.events.type.EventState;
import hex.api.baritone.api.utils.IInputOverrideHandler;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.behavior.PathingBehavior;
import hex.api.baritone.pathing.path.PathExecutor;
import io.netty.channel.Channel;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.gui.components.ChatComponent.State;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.LastSeenMessagesTracker;
import net.minecraft.network.chat.MessageSignatureCache;
import net.minecraft.network.chat.LastSeenMessages.Update;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundPongPacket;
import net.minecraft.network.protocol.game.ServerboundChatCommandPacket;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket;
import net.minecraft.network.protocol.game.ServerboundClientTickEndPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerLoadedPacket;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket.Action;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Pos;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.PosRot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Rot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.StatusOnly;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import sg.mx.ConnectionMixin_1310;
import sg.mx.LocalPlayerMixin_1170;

// $VF: Compiled from s
public final class BotClient implements MinecraftAccess {
   private static final int field00117 = 100;
   private static final int field00118 = 0;
   private static final int field00119 = 0;
   private static final int field00120 = 0;
   private static final int field00121 = 0;
   private static final double field00122 = 0;
   private static final int field00123 = 0;
   private static final int field00124 = 0;
   private static final long field00125 = 0;
   private static final int field00126 = 0;
   private static final int field00127 = 0;
   private static final int field00128 = 0;
   private final AutoBuyBotState field00129;
   private final BotPlayerState field00130 = new BotPlayerState();
   private final BotWorldState field00131 = new BotWorldState();
   private final BotInputController field00132 = new BotInputController(this);
   private volatile IBaritone field00133;
   private volatile Object field00134;
   private final BotInteractionController field00135 = new BotInteractionController(this);
   private final BotContainerController field00136 = new BotContainerController(this);
   private volatile BotConnectionState field00137 = BotConnectionState.IDLE;
   private volatile String field00138 = "";
   private static final int field00139 = 0;
   private static final long field00140 = 0;
   private static final long field00141 = 0;
   private static final long field00142 = 0;
   private volatile boolean field00143;
   private volatile boolean field00144;
   private volatile int field00145;
   private volatile long field00146;
   private volatile Connection field00147;
   private volatile Channel field00148;
   private volatile long field00149;
   private volatile State field00150;
   private volatile int field00151;
   private volatile LastSeenMessagesTracker field00152 = new LastSeenMessagesTracker(20);
   private volatile MessageSignatureCache field00153 = MessageSignatureCache.createDefault();
   private volatile CommandDispatcher<ClientSuggestionProvider> field00154;
   private final ConcurrentLinkedQueue<Packet<?>> field00155 = new ConcurrentLinkedQueue<>();
   private final ConcurrentLinkedQueue<Packet<?>> field00156 = new ConcurrentLinkedQueue<>();
   private final Map<Identifier, byte[]> field00157 = new ConcurrentHashMap<>();
   private final AtomicBoolean field00158 = new AtomicBoolean();
   private final AtomicBoolean field00159 = new AtomicBoolean();
   private final AtomicInteger field00160 = new AtomicInteger();
   private final ArrayDeque<Component> field00161 = new ArrayDeque<>();
   private int field00162;
   private double field00163;
   private double field00164;
   private double field00165;
   private float field00166;
   private float field00167;
   private boolean field00168 = true;
   private boolean field00169;
   private boolean field00170;
   private volatile boolean field00171;
   private int field00172;
   private volatile long field00173;
   private volatile long field00174;
   private volatile long field00175;
   private volatile long field00176;
   private volatile int field00177;
   private final AtomicInteger field00178;
   private volatile boolean field00179;
   private int field00180;
   private volatile boolean field00181;
   private int field00182;
   private volatile int field00183;
   private long field00184;
   private long field00185;
   private double field00186;
   private double field00187;
   private double field00188;
   private static final long field00189 = Long.MIN_VALUE;
   private static final String field00190 = "QUEUE";
   private static final String field00191 = "LOCAL";
   private static final String field00192 = "отключение по запросу пользователя";
   private static final String field00193 = "Отключён вручную";
   private static final String field00194 = "LOCAL";
   private static final String field00195 = "принудительный стоп";
   private static final String field00196 = "SOCKET";
   private static final String field00197 = "SOCKET";
   private static final String field00198 = "Отменено";
   private static final long field00199 = 48L;
   private static final String field00200 = "TICK";
   private static final String field00201 = "WARDEN";
   private static final String field00202 = "AUTOBUY";
   private static final String field00203 = "BARITONE";
   private static final String field00204 = "TICK";
   private static final String field00205 = "PHYSICS";
   private static final String field00206 = "физика";
   private static final String field00207 = "PHYSICS";
   private static final String field00208 = "BARITONE";
   private static final String field00209 = "CAD";
   private static final String field00210 = "gap=%dмс ticked=%b drop=%d spr=%b ms=%.5f pos=%.3f/%.3f/%.3f d=%.4f/%.4f/%.4f dm=%.4f/%.4f/%.4f grnd=%b yaw=%.2f pitch=%.2f in=%s%s%s%s%s%s%s";
   private static final String field00211 = "F";
   private static final String field00212 = "B";
   private static final String field00213 = "L";
   private static final String field00214 = "R";
   private static final String field00215 = "J";
   private static final String field00216 = "S";
   private static final String field00217 = "P";
   private static final String field00218 = "LOADED";
   private static final double field00219 = 2.0E-4;
   private static final String field00220 = "QUEUE";
   private static final String field00221 = "QUEUE";
   private static final double field00222 = 1.62;
   private static final double field00223 = 90.0;
   private static final String field00224 = "CLOSE";
   private static final String field00225 = "TAKEOVER";
   private static final String field00226 = "сессия принята ботом";
   private static final long field00227 = Long.MIN_VALUE;
   private static final long field00228 = 3000L;
   private static final long field00229 = 120000L;
   private static final String field00230 = "TRANSFER";
   private static final String field00231 = "KEEPALIVE";
   private static final long field00232 = -1L;
   private static final String field00233 = "CHAT";
   private static final long field00234 = 60000L;
   private static final String field00235 = "причина неизвестна";
   private static final String field00236 = "AFTER";
   private static final String field00237 = "переподключение включено";
   private static final String field00238 = "переподключения не будет";
   private static final String field00239 = "Заменено новой сессией";
   private static final String field00240 = "Принудительный стоп";

   public double method00060() {
      return this.field00187;
   }

   public long method00061() {
      return this.field00174;
   }

   private static String method00062(Throwable var0) {
      Throwable var1 = var0.getCause() != null ? var0.getCause() : var0;
      String var2 = var1.getMessage();
      return var2 != null && !var2.isBlank() ? var2 : var1.getClass().getSimpleName();
   }

   public long method00063() {
      return this.field00149;
   }

   public void method00064(State var1) {
      this.field00150 = var1;
   }

   private void method00065() {
      this.field00178.incrementAndGet();
      this.field00160.set(0);
      this.field00159.set(false);
   }

   public void method00066(Component var1) {
      if (var1 != null) {
         synchronized (this.field00161) {
            if (this.field00161.size() >= 100) {
               this.field00161.removeFirst();
            }

            this.field00161.addLast(var1);
         }
      }
   }

   public void method00067() {
      this.method00164(new ServerboundClientCommandPacket(Action.PERFORM_RESPAWN));
   }

   public void method00068(Connection var1) {
      Packet var2;
      while ((var2 = this.field00155.poll()) != null) {
         if (var2 instanceof ServerboundPongPacket && this.field00147 == var1 && var1.isConnected()) {
            var1.send(var2);
         } else {
            String.valueOf("сброшен на реконфиге: " + var2.getClass().getSimpleName());
         }
      }

      this.field00156.clear();
   }

   public boolean method00069() {
      return this.field00143;
   }

   public BotPlayerState method00070() {
      return this.field00130;
   }

   public float method00071() {
      return this.field00167;
   }

   private void method00072() {
      synchronized (this.field00161) {
         this.field00161.clear();
      }
   }

   public void method00073(MessageSignatureCache var1) {
      this.field00153 = var1;
   }

   public void method00074(BotConnectionState var1) {
      this.field00137 = var1;
      if (var1 == BotConnectionState.PLAYING && this.field00149 == 0L) {
         this.field00149 = System.currentTimeMillis();
      }
   }

   public void method00075(String var1) {
      this.field00138 = var1 == null ? "" : var1;
      this.method00074(BotConnectionState.FAILED);
      this.field00143 = false;
   }

   public long method00076() {
      return this.field00146;
   }

   public static boolean method00077(IBaritone var0) {
      if (!(var0.getPathingBehavior() instanceof PathingBehavior var1)) {
         return false;
      } else {
         PathExecutor var3 = var1.getCurrent();
         return var3 != null && var3.isSprintUnsafe();
      }
   }

   public boolean method00078() {
      return this.field00170;
   }

   public BotClient(AutoBuyBotState var1) {
      this.field00173 = field00189;
      this.field00178 = new AtomicInteger();
      this.field00129 = var1;
      this.field00131.method07674(this);
   }

   public double method00079() {
      return this.field00188;
   }

   public int method00080() {
      return this.field00162;
   }

   public void method00081() {
      this.field00181 = false;
      this.field00182 = 0;
   }

   public BotInteractionController method00082() {
      return this.field00135;
   }

   public LastSeenMessagesTracker method00083() {
      return this.field00152;
   }

   public void method00084() {
      this.field00155.clear();
      this.field00156.clear();
   }

   private void method00085() {
      if (this.field00130.method07995()) {
         this.field00163 = this.field00130.method08018();
         this.field00164 = this.field00130.method08017();
         this.field00165 = this.field00130.method08020();
         this.field00166 = this.field00130.method07992();
         this.field00167 = this.field00130.method07976();
         this.field00168 = this.field00130.method07997();
         this.field00169 = this.field00130.method07978();
         this.field00162 = this.field00130.method07949();
      } else {
         this.field00163 = this.field00130.method08006();
         this.field00164 = this.field00130.method07981();
         this.field00165 = this.field00130.method08004();
         this.field00166 = this.field00130.method08008();
         this.field00167 = this.field00130.method08003();
         this.field00168 = this.field00130.method07991();
         this.field00169 = this.field00130.method07986();
         this.field00162 = 0;
      }
   }

   private long method00086() {
      return Math.min(field00228 << Math.min(this.field00145, 6), field00229);
   }

   private void method00087(Connection var1, Connection var2) {
      if (var1 != null && var1 != var2 && var1.isConnected()) {
         Util.ioPool().execute(() -> var1.disconnect(Component.literal(field00239)));
      }
   }

   public long method00088() {
      return this.field00185;
   }

   public BotInputController method00089() {
      return this.field00132;
   }

   public BotWorldState method00090() {
      return this.field00131;
   }

   public Connection method00091() {
      Connection var1 = this.field00147;
      if (var1 != null && this.field00137 == BotConnectionState.PLAYING) {
         this.field00143 = false;
         this.method00074(BotConnectionState.CONTROLLED);
         BotManager.INSTANCE.method03081(this);
         this.method00065();
         Channel var2 = this.field00148;
         if (var2 != null && !var2.eventLoop().inEventLoop()) {
            var2.eventLoop().submit(() -> null).syncUninterruptibly();
         }

         if (this.field00147 == var1 && var1.isConnected()) {
            this.field00132.method10875();
            this.field00136.method03045();
            this.method00121(var1);
            this.method00101(var1);
            this.field00147 = null;
            this.field00148 = null;
            this.field00149 = 0L;
            this.field00158.set(false);
            return var1;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public double method00092() {
      return this.field00163;
   }

   public void method00093() {
      Connection var1 = this.field00147;
      Channel var2 = this.field00148;
      if (var1 != null && var1.isConnected() && var2 != null && var2.eventLoop().inEventLoop()) {
         this.method00121(var1);
      }
   }

   public double method00094() {
      return this.field00164;
   }

   public CommandDispatcher<ClientSuggestionProvider> method00096() {
      return this.field00154;
   }

   public float method00097() {
      return this.field00166;
   }

   public long method00098() {
      return this.field00173;
   }

   public IBaritone method00099() {
      return this == BotSessionManager.INSTANCE.method08761() ? BaritoneAPI.getProvider().getPrimaryBaritone() : this.field00133;
   }

   private void method00100() {
      BotLocalPlayer var1 = this.field00131.method07688();
      if (var1 != null && !var1.isSynced()) {
         var1.setGameType(this.field00130.method07950());
         var1.syncFrom(this.field00130);
         var1.aimFrom(this.field00130);
      }
   }

   private void method00101(Connection var1) {
      Packet var2;
      while (this.field00147 == var1 && (var2 = this.field00156.poll()) != null) {
         var1.send(var2);
      }
   }

   public boolean method00102(String var1) {
      Connection var2 = this.field00147;
      if (var2 != null && this.field00158.compareAndSet(false, true)) {
         this.method00113();
         String.valueOf("разрыв инициирован клиентом: " + var1);
         Util.ioPool().execute(() -> var2.disconnect(Component.literal(var1)));
         return true;
      } else {
         return false;
      }
   }

   public void method00103() {
      this.field00143 = false;
      BotManager.INSTANCE.method03081(this);
      Connection var1 = this.field00147;
      if (var1 == null) {
         this.method00074(BotConnectionState.IDLE);
      } else if (!var1.isConnected() || !this.method00102(field00193)) {
         this.method00131();
      }
   }

   public long method00105() {
      long var1 = this.field00149;
      return var1 == 0L ? 0L : System.currentTimeMillis() - var1;
   }

   public void method00106(long var1) {
      long var3 = this.field00174;
      this.field00174 = System.currentTimeMillis();
      String.valueOf("id=" + var1 + " интервал=" + (var3 == 0L ? field00232 : this.field00174 - var3) + "мс");
      this.field00175 = this.field00174;
      this.field00173 = var1;
   }

   public IBaritone method00107() {
      if (this == BotSessionManager.INSTANCE.method08761()) {
         return BaritoneAPI.getProvider().getPrimaryBaritone();
      }

      IBaritone var1 = this.field00133;
      if (var1 == null) {
         synchronized (this) {
            var1 = this.field00133;
            if (var1 == null) {
               var1 = ((BaritoneProvider)BaritoneAPI.getProvider()).createBaritoneForBot(this);
               this.field00133 = var1;
            }
         }
      }

      return var1;
   }

   public void method00109() {
      Connection var1 = this.field00147;
      if (var1 != null) {
         Channel var2 = this.field00148;
         if (var2 != null) {
            if (!var1.isConnected()) {
               try {
                  var2.eventLoop().execute(() -> {
                     if (this.field00147 == var1 && !var1.isConnected()) {
                        var1.handleDisconnection();
                        if (this.field00147 == var1) {
                           this.method00131();
                        }
                     }
                  });
               } catch (Throwable var4) {
               }
            } else if (this.field00137 != BotConnectionState.PLAYING) {
               try {
                  var2.eventLoop().execute(new BotClient.Nested1(var1));
               } catch (Throwable var5) {
               }
            } else {
               if (this.field00160.get() < 1) {
                  this.field00160.incrementAndGet();
               } else {
                  this.field00183++;
               }

               if (this.field00159.compareAndSet(false, true)) {
                  try {
                     var2.eventLoop().execute(new BotClient.Nested2(this.field00178.get(), var1));
                  } catch (Throwable var6) {
                     this.field00159.set(false);
                  }
               }
            }
         }
      }
   }

   private void method00110() {
      BotLocalPlayer var1 = this.field00131.method07688();
      if (var1 != null) {
         LocalPlayerMixin_1170 var2 = (LocalPlayerMixin_1170)(Object)var1;
         var2.setPositionReminder(this.field00162);
         var2.setLastX(this.field00163);
         var2.setLastY(this.field00164);
         var2.setLastZ(this.field00165);
         var2.setLastYRot(this.field00166);
         var2.setLastXRot(this.field00167);
         var2.setLastOnGround(this.field00168);
         var2.setLastHorizontalCollision(this.field00169);
      }
   }

   private void method00111() {
      this.method00065();
      this.field00147 = null;
      this.field00148 = null;
      this.field00149 = 0L;
      this.field00158.set(false);
      this.field00155.clear();
      this.field00156.clear();
      this.method00081();
      this.field00150 = null;
      this.field00154 = null;
      this.field00171 = false;
      this.field00172 = 0;
      this.field00183 = 0;
      this.field00132.method10875();
      this.field00135.method06245();
      this.field00136.method03045();
      this.field00130.method07980();
      this.field00131.method07649();
      this.field00131.method07712();
      this.method00072();
   }

   public MessageSignatureCache method00112() {
      return this.field00153;
   }

   private void method00113() {
      IBaritone var1 = this.field00133;
      if (var1 != null) {
         this.field00133 = null;

         try {
            var1.getPathingBehavior().cancelEverything();
         } catch (Throwable var3) {
         }

         BaritoneAPI.getProvider().destroyBaritone(var1);
      }
   }

   public void method00114(Component var1) {
      this.method00066(var1);
      if (var1 != null) {
         var1.getString();
         BotTaskManager.INSTANCE.method05436(this, var1);
         BotStatusManager.INSTANCE.method02730(this, var1);
      }
   }

   private void method00115() {
      if (!this.method00153()) {
         IBaritone var1 = this.method00099();
         if (var1 != null) {
            var1.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.POST));
            var1.getGameEventHandler().onPostTick(new TickEvent(EventState.POST, TickEvent.Type.IN, 0));
         }
      }
   }

   public void method00116(float var1, float var2) {
      this.field00130.method07993(var1, var2);
   }

   public void method00117(Entity var1) {
      if (var1 != null) {
         this.method00136(var1.getX(), var1.getEyeY(), var1.getZ());
      }
   }

   public long method00118() {
      return this.field00175;
   }

   public void method00119(String var1) {
      long var2 = System.currentTimeMillis();
      long var4 = this.field00149 == 0L ? 0L : var2 - this.field00149;
      if (var4 < field00234) {
         this.field00145++;
      } else {
         this.field00145 = 0;
      }

      boolean var6 = this.field00145 >= 5;
      boolean var7 = this.field00143 && BotManager.INSTANCE.method03097() && !var6;
      this.field00146 = var2 + this.method00086();
      if (var6) {
         this.field00138 = "не заходит " + this.field00145 + " раз подряд: " + (var1 == null ? field00235 : var1);
         this.field00145 = 0;
      } else {
         this.field00138 = var1 == null ? "" : var1;
      }

      if (!var7) {
         ;
      }

      this.method00111();
      this.method00074(var7 ? BotConnectionState.QUEUED : (this.field00143 ? BotConnectionState.FAILED : BotConnectionState.IDLE));
      if (var7) {
         BotManager.INSTANCE.method03080(this);
      } else {
         this.field00143 = false;
         this.method00113();
      }
   }

   public boolean method00120() {
      return this.field00169;
   }

   private void method00121(Connection var1) {
      Packet var2;
      while (this.field00147 == var1 && (var2 = this.field00155.poll()) != null) {
         var1.send(var2);
      }
   }

   public void method00122(String var1, int var2) {
      String.valueOf(var1 + ":" + var2);
      this.field00129.method00477(var1 + ":" + var2);
      this.field00144 = true;
      this.method00102("Перенос на " + var1);
   }

   public void method00123(Packet<?> var1) {
      Connection var2 = this.field00147;
      if (var2 != null && var2.isConnected()) {
         Channel var3 = this.field00148;
         if (this.field00171 && var3 != null && var3.eventLoop().inEventLoop()) {
            var2.send(var1);
         } else {
            while (this.field00156.size() >= 64) {
               Packet var4 = this.field00156.poll();
               if (var4 != null) {
                  String.valueOf("action вытеснен: " + var4.getClass().getSimpleName());
               }
            }

            this.field00156.add(var1);
         }
      }
   }

   public void method00124(LastSeenMessagesTracker var1) {
      this.field00152 = var1;
   }

   private void method00125() {
      BotFollowManager.INSTANCE.method02189(this);
      if (!this.method00153()) {
         IBaritone var1 = this.method00099();
         if (var1 != null) {
            BotClientLevel var2 = this.field00131.method07636();
            if (var2 != null && var2 != this.field00134) {
               this.field00134 = var2;
               var1.getGameEventHandler().onWorldEvent(new WorldEvent(var2, EventState.POST));
            }

            this.method00100();
            if (var1.getPlayerContext().player() != null && var1.getPlayerContext().world() != null) {
               TickEvent var3 = new TickEvent(EventState.PRE, TickEvent.Type.IN, 0);
               var1.getGameEventHandler().onTick(var3);
               var1.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.PRE));
               this.method00070().method07953(false);
               if (this.method00148()) {
                  IInputOverrideHandler var4 = var1.getInputOverrideHandler();
                  SprintStateEvent var5 = new SprintStateEvent();
                  var1.getGameEventHandler().onPlayerSprintState(var5);
                  boolean var6 = var4.isInputForcedDown(Input.MOVE_FORWARD);
                  this.method00070().method07953(var6);
                  boolean var7 = var4.isInputForcedDown(Input.SNEAK);
                  boolean var8 = var6 && !var7 && !method00077(var1);
                  this.field00132
                     .method10867(
                        var6,
                        !var6 && var4.isInputForcedDown(Input.MOVE_BACK),
                        !var6 && var4.isInputForcedDown(Input.MOVE_LEFT),
                        !var6 && var4.isInputForcedDown(Input.MOVE_RIGHT),
                        var4.isInputForcedDown(Input.JUMP) || BotPathingUtils.method06243(var1, this.field00131.method07688()),
                        var7,
                        Boolean.TRUE.equals(var5.getState()) || var4.isInputForcedDown(Input.SPRINT) || var8
                     );
               }
            }
         }
      }
   }

   public void method00126(String var1) {
      this.field00138 = var1 == null ? "" : var1;
   }

   private void method00127() {
      try {
         BotConnectionFactory.method11718(this);
      } catch (Throwable var2) {
         String.valueOf("ошибка подключения: " + var2.getClass().getSimpleName() + ": " + var2.getMessage());
         this.method00075(method00062(var2));
         if (this.field00147 == null) {
            this.method00111();
         } else {
            this.method00102(method00062(var2));
         }
      }
   }

   public Connection method00128() {
      return this.field00147;
   }

   public boolean method00129() {
      boolean var1 = this.field00144;
      this.field00144 = false;
      return var1;
   }

   public void method00130(CommandDispatcher<ClientSuggestionProvider> var1) {
      this.field00154 = var1;
   }

   public void method00131() {
      this.field00143 = false;
      this.field00138 = "";
      BotManager.INSTANCE.method03081(this);
      this.method00113();
      Connection var1 = this.field00147;
      Channel var2 = this.field00148;
      if (var2 != null) {
         var2.close();
      } else if (var1 != null) {
         Util.ioPool().execute(() -> var1.disconnect(Component.literal(field00240)));
      }

      this.method00111();
      this.method00074(BotConnectionState.IDLE);
   }

   public void method00132(Connection var1) {
      Connection var2 = this.field00147;
      Channel var3 = ((ConnectionMixin_1310)(Object)var1).getChannel();
      KeepAliveScheduler.INSTANCE.method03309(var1);
      ((BotConnectionAccess)var1).setBotConnection(true);
      ConnectionMixin_1310 var4 = (ConnectionMixin_1310)(Object)var1;
      var4.setDisconnectListener(null);
      var4.setPacketListener(new BotPlayPacketListener(this, var1));
      this.field00143 = true;
      this.field00138 = "";
      this.field00158.set(false);
      this.field00155.clear();
      this.field00156.clear();
      this.field00147 = var1;
      this.field00148 = var3;
      this.method00065();
      this.method00087(var2, var1);
      this.field00176 = 0L;
      this.field00177 = 0;
      this.field00179 = true;
      this.field00180 = 0;
      this.field00181 = true;
      this.field00182 = 0;
      this.field00173 = field00227;
      this.field00132.method10875();
      this.field00135.method06245();
      this.field00136.method03045();
      this.method00085();
      this.field00149 = System.currentTimeMillis();
      this.method00074(BotConnectionState.PLAYING);
      this.field00131.method07733(true);
   }

   public int method00133() {
      return this.field00177;
   }

   public void method00134(Identifier var1, byte[] var2) {
      if (var2 == null) {
         this.field00157.remove(var1);
      } else {
         this.field00157.put(var1, var2);
      }
   }

   public BotContainerController method00135() {
      return this.field00136;
   }

   public void method00136(double var1, double var3, double var5) {
      BotLocalPlayer var7 = this.field00131.method07688();
      double var8 = var7 != null ? var7.getEyeY() : this.field00130.method07981() + field00222;
      double var10 = var1 - this.field00130.method08006();
      double var12 = var3 - var8;
      double var14 = var5 - this.field00130.method08004();
      double var16 = Math.sqrt(var10 * var10 + var14 * var14);
      float var18 = (float)(Math.toDegrees(Math.atan2(var14, var10)) - field00223);
      float var19 = (float)(-Math.toDegrees(Math.atan2(var12, var16)));
      float var20 = this.field00130.method08008();
      this.field00130.method07993(var20 + Mth.wrapDegrees(var18 - var20), var19);
   }

   public AutoBuyBotState method00137() {
      return this.field00129;
   }

   private void method00139(Connection var1) {
      if (this.field00130.method07988()) {
         double var2 = this.field00130.method08006();
         double var4 = this.field00130.method07981();
         double var6 = this.field00130.method08004();
         float var8 = this.field00130.method08008();
         float var9 = this.field00130.method08003();
         boolean var10 = this.field00130.method07991();
         boolean var11 = this.field00130.method07986();
         double var12 = var2 - this.field00163;
         double var14 = var4 - this.field00164;
         double var16 = var6 - this.field00165;
         boolean var18 = Mth.lengthSquared(var12, var14, var16) > Mth.square(field00219);
         boolean var19 = var18 || ++this.field00162 >= 20;
         boolean var20 = var8 != this.field00166 || var9 != this.field00167;
         boolean var21 = var10 != this.field00168 || var11 != this.field00169;
         if (var19 && var20) {
            var1.send(new PosRot(var2, var4, var6, var8, var9, var10, var11));
         } else if (var19) {
            var1.send(new Pos(var2, var4, var6, var10, var11));
         } else if (var20) {
            var1.send(new Rot(var8, var9, var10, var11));
         } else {
            if (!var21) {
               return;
            }

            var1.send(new StatusOnly(var10, var11));
         }

         if (var19) {
            this.field00162 = 0;
            this.field00163 = var2;
            this.field00164 = var4;
            this.field00165 = var6;
            this.field00170 = true;
         }

         this.field00166 = var8;
         this.field00167 = var9;
         this.field00168 = var10;
         this.field00169 = var11;
      }
   }

   public void method00140() {
      IBaritone var1 = this.method00099();
      if (var1 != null && this != BotSessionManager.INSTANCE.method08761()) {
         var1.getGameEventHandler().onPlayerDeath();
      }

      if (BotManager.INSTANCE.method03098()) {
         this.method00067();
      }
   }

   public List<Component> method00141() {
      synchronized (this.field00161) {
         return new ArrayList<>(this.field00161);
      }
   }

   public int method00143() {
      return this.field00183;
   }

   public void method00144(String var1) {
      boolean var2 = BotSessionManager.INSTANCE.method08733(this);
      if (var1 != null && !var1.isBlank() && (var2 || this.field00137 == BotConnectionState.PLAYING)) {
         ClientPacketListener var3 = var2 ? mc.getConnection() : this.field00131.method07664();
         if (var3 != null) {
            String var4 = var1.length() > 256 ? var1.substring(0, 256) : var1;
            if (var4.charAt(0) == '/') {
               String var5 = var4.substring(1);
               if (!var5.isBlank()) {
                  if (var2) {
                     var3.sendCommand(var5);
                  } else {
                     this.method00164(new ServerboundChatCommandPacket(var5));
                  }
               }
            } else {
               if (var2) {
                  var3.sendChat(var4);
               } else {
                  this.method00164(new ServerboundChatPacket(var4, Instant.now(), 0L, null, new Update(0, new BitSet(), (byte)0)));
               }
            }
         }
      }
   }

   public void method00145(double var1, double var3, double var5, float var7, float var8, boolean var9, boolean var10, int var11) {
      this.field00160.set(0);
      this.field00162 = var11;
      this.field00170 = true;
      this.field00163 = var1;
      this.field00164 = var3;
      this.field00165 = var5;
      this.field00166 = var7;
      this.field00167 = var8;
      this.field00168 = var9;
      this.field00169 = var10;
   }

   public BotConnectionState method00146() {
      return this.field00137;
   }

   public void method00147() {
      if (this.field00130.method07951() <= 0.0F && BotManager.INSTANCE.method03098()) {
         this.method00067();
      }
   }

   private boolean method00148() {
      if (this.method00153()) {
         return false;
      }

      IBaritone var1 = this.method00099();
      if (var1 == null) {
         return false;
      }

      IPathingBehavior var2 = var1.getPathingBehavior();
      return var2.isPathing() || var2.getGoal() != null || var2.getInProgress().isPresent();
   }

   public boolean method00149(Packet<?> var1) {
      if (this.field00155.size() >= 32) {
         return false;
      }

      this.field00155.add(var1);
      return true;
   }

   public double method00150() {
      return this.field00165;
   }

   public void method00151() {
      if (!this.field00137.method05280() && this.field00137 != BotConnectionState.CONTROLLED) {
         this.field00143 = true;
         this.field00138 = "";
         String.valueOf("подключение запрошено, адрес " + this.field00129.method00486());
         this.method00074(BotConnectionState.QUEUED);
         BotManager.INSTANCE.method03080(this);
      }
   }

   public void method00152(int var1) {
      this.field00151 = var1;
   }

   private boolean method00153() {
      BotSessionManager var1 = BotSessionManager.INSTANCE;
      return this == var1.method08761() && var1.method08762() == null;
   }

   public double method00154() {
      return this.field00186;
   }

   public void method00155(Connection var1, Channel var2) {
      String.valueOf("канал открыт " + var2.remoteAddress());
      Connection var3 = this.field00147;
      this.field00162 = 0;
      this.field00148 = var2;
      this.field00147 = var1;
      this.method00065();
      this.method00087(var3, var1);
      if (!this.field00143) {
         this.method00102(field00198);
      }
   }

   public Channel method00156() {
      return this.field00148;
   }

   private void method00157(Connection var1) {
      if (var1.isConnected()) {
         var1.tick();
         this.method00121(var1);
         if (this.field00137 == BotConnectionState.PLAYING) {
            long var2 = System.currentTimeMillis();
            if (var2 - this.field00184 < field00199) {
               this.field00183++;
            } else {
               this.field00184 = var2;
               this.field00171 = true;
               boolean var4 = false;

               try {
                  this.method00101(var1);

                  try {
                     this.field00135.method06248();
                     this.field00131.method07681();
                  } catch (Throwable var26) {
                     String.valueOf("тик мира сорвался: " + var26);
                  }

                  try {
                     BotTaskManager.INSTANCE.method05440(this);
                  } catch (Throwable var25) {
                     String.valueOf("тик мозга сорвался: " + var25);
                  }

                  try {
                     BotStatusManager.INSTANCE.method02728(this);
                  } catch (Throwable var24) {
                     String.valueOf("тик скупки сорвался: " + var24);
                  }

                  try {
                     this.method00125();
                  } catch (Throwable var23) {
                     String.valueOf("pre сорвался: " + var23);
                  }

                  var4 = this.method00158(var1);
               } catch (Throwable var27) {
                  String.valueOf("тик сорвался: " + var27);
               } finally {
                  this.field00171 = false;
               }

               boolean var5 = false;
               boolean var6 = this.method00148();
               if (this.field00172 > 0) {
                  this.field00172--;
               } else if (var4 && (BotManager.INSTANCE.method03064() || var6)) {
                  try {
                     var5 = MovementInputFormatter.method00503(this);
                  } catch (Throwable var22) {
                     this.field00172 = 20;
                     String.valueOf("физика сорвалась: " + var22.getClass().getSimpleName() + ": " + var22.getMessage());
                     String.valueOf("исключение " + var22.getClass().getSimpleName() + ", пауза 20 тик.");
                  }
               }

               if (!var5) {
                  try {
                     MovementInputFormatter.method00502(this);
                  } catch (Throwable var21) {
                     String.valueOf("инвентарь без физики не применился: " + var21);
                  }
               }

               try {
                  this.method00115();
               } catch (Throwable var20) {
                  String.valueOf("post сорвался: " + var20);
               }

               if (var5) {
                  this.field00179 = false;
                  this.field00180 = 0;
                  this.method00165();
               } else {
                  if (this.field00179 && ++this.field00180 >= 40) {
                     this.field00179 = false;
                  }

                  if (var4 && !this.field00179 && !this.field00131.method07808()) {
                     this.method00139(var1);
                     this.method00110();
                  }
               }

               var1.send(ServerboundClientTickEndPacket.INSTANCE);

               try {
                  BotLocalPlayer var7 = this.field00131.method07688();
                  String.format(
                     Locale.ROOT,
                     field00210,
                     var2 - this.field00185,
                     var5,
                     this.field00183,
                     var7 != null && var7.isSprinting(),
                     var7 == null ? 0.0 : var7.getAttributeValue(Attributes.MOVEMENT_SPEED),
                     this.field00130.method08006(),
                     this.field00130.method07981(),
                     this.field00130.method08004(),
                     this.field00130.method08006() - this.field00186,
                     this.field00130.method07981() - this.field00187,
                     this.field00130.method08004() - this.field00188,
                     this.field00130.method07994(),
                     this.field00130.method07947(),
                     this.field00130.method07948(),
                     this.field00130.method07991(),
                     this.field00130.method08008(),
                     this.field00130.method08003(),
                     this.field00132.method10879() ? field00211 : "",
                     this.field00132.method10869() ? field00212 : "",
                     this.field00132.method10876() ? field00213 : "",
                     this.field00132.method10871() ? field00214 : "",
                     this.field00132.method10872() ? field00215 : "",
                     this.field00132.method10870() ? field00216 : "",
                     this.field00132.method10877() ? field00217 : ""
                  );
               } catch (Throwable var29) {
               }

               this.field00185 = var2;
               this.field00186 = this.field00130.method08006();
               this.field00187 = this.field00130.method07981();
               this.field00188 = this.field00130.method08004();

               try {
                  ;
               } catch (Throwable var19) {
               }

               this.field00176 = var2;
               this.field00177++;
            }
         }
      } else {
         var1.handleDisconnection();
      }
   }

   private boolean method00158(Connection var1) {
      if (this.field00181) {
         return true;
      } else if (++this.field00182 < 25) {
         return false;
      } else if (MovementInputFormatter.method00507(this) || this.field00182 >= 200 && !this.field00131.method07808()) {
         this.field00181 = true;
         String.valueOf("PlayerLoaded после " + this.field00182 + " тиков");
         var1.send(new ServerboundPlayerLoadedPacket());
         return true;
      } else {
         return false;
      }
   }

   public String method00159() {
      return this.field00138;
   }

   public long method00160() {
      return this.field00176;
   }

   public int method00161() {
      return this.field00151;
   }

   public State method00162() {
      return this.field00150;
   }

   public boolean method00163() {
      return this.field00168;
   }

   public void method00164(Packet<?> var1) {
      Connection var2 = this.field00147;
      if (var2 != null && var2.isConnected()) {
         var2.send(var1);
      }
   }

   private void method00165() {
      BotLocalPlayer var1 = this.field00131.method07688();
      if (var1 != null) {
         LocalPlayerMixin_1170 var2 = (LocalPlayerMixin_1170)(Object)var1;
         this.field00162 = var2.positionReminder();
         this.field00170 = true;
         this.field00163 = var2.lastX();
         this.field00164 = var2.lastY();
         this.field00165 = var2.lastZ();
         this.field00166 = var2.lastYRot();
         this.field00167 = var2.lastXRot();
         this.field00168 = var2.lastOnGround();
         this.field00169 = var2.lastHorizontalCollision();
      }
   }

   public void method00166() {
      this.field00175 = System.currentTimeMillis();
   }

   public int method00167() {
      return this.field00145;
   }

   public byte[] method00168(Identifier var1) {
      return this.field00157.get(var1);
   }

   public long method00169() {
      return this.field00184;
   }

   public void method00170() {
      if (!this.field00143) {
         this.method00074(BotConnectionState.IDLE);
      } else if (!this.field00137.method05280() || this.field00137 == BotConnectionState.QUEUED) {
         this.method00074(BotConnectionState.CONNECTING);
         this.field00158.set(false);
         this.field00131.method07733(true);
         Util.ioPool().execute(this::method00127);
      }
   }

   // $VF: Compiled from s
   private final class Nested1 implements Runnable {
      private final Connection field00241;

      private Nested1(Connection var2) {
         this.field00241 = var2;
      }

      @Override
      public void run() {
         if (BotClient.this.field00147 == this.field00241) {
            this.field00241.tick();
            BotClient.this.method00121(this.field00241);
         }
      }
   }

   // $VF: Compiled from s
   private final class Nested2 implements Runnable {
      private final int field00243;
      private final Connection field00244;

      private Nested2(int var2, Connection var3) {
         this.field00243 = var2;
         this.field00244 = var3;
      }

      @Override
      public void run() {
         try {
            for (int var1 = 0;
               var1 < 1
                  && BotClient.this.field00160.get() > 0
                  && BotClient.this.field00178.get() == this.field00243
                  && BotClient.this.field00147 == this.field00244;
               var1++
            ) {
               BotClient.this.field00160.decrementAndGet();
               BotClient.this.method00157(this.field00244);
            }
         } finally {
            BotClient.this.field00159.set(false);
         }
      }
   }
}
