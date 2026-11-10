// Original binary: hex/api/baritone/HexBaritone
package hex.api.baritone;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.event.events.BlockChangeEvent;
import hex.api.baritone.api.event.events.ChatEvent;
import hex.api.baritone.api.event.events.ChunkEvent;
import hex.api.baritone.api.event.events.PacketEvent;
import hex.api.baritone.api.event.events.PlayerUpdateEvent;
import hex.api.baritone.api.event.events.RenderEvent;
import hex.api.baritone.api.event.events.SprintStateEvent;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.event.events.WorldEvent;
import hex.api.baritone.api.event.events.type.EventState;
import hex.api.baritone.api.utils.Pair;
import hex.api.baritone.utils.IRenderer;
import java.util.List;
import java.util.function.BiFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import sg.ec.BotClient;
import sg.ec.EventBus;
import sg.ec.Subscribe;
import sg.ec.Render3DEvent;
import sg.ec.PostTickEvent;
import sg.ec.CanSprintEvent;
import sg.ec.BlockUpdateEvent;
import sg.ec.MinecraftAccess;
import sg.ec.BotSessionManager;
import sg.ec.WorldLoadEvent;
import sg.ec.ChunkDataEvent;
import sg.ec.EntityDeathEvent;
import sg.ec.ChatSendEvent;

// $VF: Compiled from s
public final class HexBaritone implements MinecraftAccess {
   public static final HexBaritone INSTANCE = new HexBaritone();
   private boolean started;

   @Subscribe
   private void onSendMessage(ChatSendEvent var1) {
      IBaritone var2 = active();
      if (var2 != null) {
         ChatEvent sx = new ChatEvent(var1.method11711());
         var2.getGameEventHandler().onSendChatMessage(sx);
         if (sx.isCancelled()) {
            var1.method05696();
         }
      }
   }

   @Subscribe
   private void onGameTick(sg.ec.TickEvent var1) {
      IBaritone var2 = activeIfPresent();
      if (var2 != null) {
         TickEvent.Type sx = tickType(var2);
         if (sx != null) {
            var sxx = TickEvent.createNextProvider();
            var2.getGameEventHandler().onTick(sxx.apply(EventState.PRE, sx));
         }
      }
   }

   @Subscribe
   private void onNewBlock(BlockUpdateEvent var1) {
      if (var1.method06654() != null && var1.method06658() != null) {
         IBaritone var2 = activeIfPresent();
         if (var2 != null) {
            ChunkPos sx = new ChunkPos(var1.method06654().getX() >> 4, var1.method06654().getZ() >> 4);
            var sxx = List.of(new Pair<>(var1.method06654(), var1.method06658()));
            var2.getGameEventHandler().onBlockChange(new BlockChangeEvent(sx, sxx));
         }
      }
   }

   private static IBaritone activeIfPresent() {
      BotClient var0 = BotSessionManager.INSTANCE.method08762();
      return var0 != null ? var0.method00107() : BaritoneAPI.getProvider().getPrimaryBaritone();
   }

   @Subscribe
   private void onGamePostTick(PostTickEvent var1) {
      IBaritone var2 = activeIfPresent();
      if (var2 != null) {
         TickEvent.Type sx = tickType(var2);
         if (sx != null) {
            var sxx = TickEvent.createNextProvider();
            var2.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.POST));
            var2.getGameEventHandler().onPostTick(sxx.apply(EventState.POST, sx));
         }
      }
   }

   private static IBaritone active() {
      BotClient var0 = BotSessionManager.INSTANCE.method08762();
      return var0 != null ? var0.method00107() : BaritoneAPI.getProvider().getPrimaryBaritone();
   }

   private static TickEvent.Type tickType(IBaritone var0) {
      if (var0.getPlayerContext().player() != null && var0.getPlayerContext().world() != null) {
         return TickEvent.Type.IN;
      } else {
         return !BotSessionManager.INSTANCE.method08748() && BotSessionManager.INSTANCE.method08762() == null ? TickEvent.Type.OUT : null;
      }
   }

   @Subscribe
   private void onChunk(ChunkDataEvent var1) {
      IBaritone var2 = activeIfPresent();
      if (var2 != null) {
         var2.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.POST, ChunkEvent.Type.POPULATE_FULL, var1.method10524(), var1.method10526()));
      }
   }

   @Subscribe
   private void onJoinWorld(WorldLoadEvent var1) {
      IBaritone var2 = activeIfPresent();
      if (var2 != null) {
         var2.getGameEventHandler().onWorldEvent(new WorldEvent(mc.level, EventState.POST));
      }
   }

   @Subscribe
   private void onUpdate(sg.ec.PlayerUpdateEvent var1) {
      IBaritone var2 = activeIfPresent();
      if (var2 != null) {
         var2.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.PRE));
      }
   }

   @Subscribe
   private void onPacket(sg.ec.PacketEvent var1) {
      if (var1.method10897() != null) {
         IBaritone var2 = activeIfPresent();
         if (var2 != null) {
            if (var1.method10899()) {
               var2.getGameEventHandler().onSendPacket(new PacketEvent(var1.method10901(), EventState.PRE, var1.method10897()));
            } else {
               var2.getGameEventHandler().onReceivePacket(new PacketEvent(var1.method10901(), EventState.PRE, var1.method10897()));
            }
         }
      }
   }

   @Subscribe
   private void onDeath(EntityDeathEvent var1) {
      Entity var2 = var1.method11303();
      if (var2 == mc.player) {
         IBaritone sx = activeIfPresent();
         if (sx != null) {
            sx.getGameEventHandler().onPlayerDeath();
         }
      }
   }

   private HexBaritone() {
   }

   @Subscribe
   private void onSprint(CanSprintEvent var1) {
      IBaritone var2 = activeIfPresent();
      if (var2 != null) {
         SprintStateEvent sx = new SprintStateEvent();
         var2.getGameEventHandler().onPlayerSprintState(sx);
         if (sx.getState() != null) {
            var1.method04669(sx.getState());
         }
      }
   }

   @Subscribe
   private void onRender3D(Render3DEvent var1) {
      IBaritone var2 = activeIfPresent();
      if (var2 != null) {
         IRenderer.setProvider(var1.method00985());
         float sx = var1.method00984().getGameTimeDeltaPartialTick(false);
         var2.getGameEventHandler().onRenderPass(new RenderEvent(sx, var1.method00996(), var1.method00992()));
      }
   }

   public void onInit() {
      if (!this.started) {
         this.started = true;
         EventBus.method00263(this);
         BaritoneAPI.getProvider().getPrimaryBaritone();
      }
   }
}
