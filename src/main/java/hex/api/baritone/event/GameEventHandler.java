// Original binary: hex/api/baritone/event/GameEventHandler
package hex.api.baritone.event;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.event.events.BlockChangeEvent;
import hex.api.baritone.api.event.events.BlockInteractEvent;
import hex.api.baritone.api.event.events.ChatEvent;
import hex.api.baritone.api.event.events.ChunkEvent;
import hex.api.baritone.api.event.events.PacketEvent;
import hex.api.baritone.api.event.events.PathEvent;
import hex.api.baritone.api.event.events.PlayerUpdateEvent;
import hex.api.baritone.api.event.events.RenderEvent;
import hex.api.baritone.api.event.events.RotationMoveEvent;
import hex.api.baritone.api.event.events.SprintStateEvent;
import hex.api.baritone.api.event.events.TabCompleteEvent;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.event.events.WorldEvent;
import hex.api.baritone.api.event.events.type.EventState;
import hex.api.baritone.api.event.listener.IEventBus;
import hex.api.baritone.api.event.listener.IGameEventListener;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.api.utils.Pair;
import hex.api.baritone.cache.CachedChunk;
import hex.api.baritone.cache.WorldProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase;
import net.minecraft.world.level.chunk.LevelChunk;

// $VF: Compiled from s
public final class GameEventHandler implements Helper, IEventBus {
   private final Baritone baritone;
   private final List<IGameEventListener> listeners = new CopyOnWriteArrayList<>();

   public GameEventHandler(Baritone var1) {
      this.baritone = var1;
   }

   @Override
   public final void onPlayerUpdate(PlayerUpdateEvent var1) {
      this.listeners.forEach(var1x -> var1x.onPlayerUpdate(var1));
   }

   @Override
   public void onPreTabComplete(TabCompleteEvent var1) {
      this.listeners.forEach(var1x -> var1x.onPreTabComplete(var1));
   }

   @Override
   public void onBlockInteract(BlockInteractEvent var1) {
      this.listeners.forEach(var1x -> var1x.onBlockInteract(var1));
   }

   @Override
   public final void onSendChatMessage(ChatEvent var1) {
      this.listeners.forEach(var1x -> var1x.onSendChatMessage(var1));
   }

   @Override
   public void onPlayerRotationMove(RotationMoveEvent var1) {
      this.listeners.forEach(var1x -> var1x.onPlayerRotationMove(var1));
   }

   @Override
   public void onPlayerSprintState(SprintStateEvent var1) {
      this.listeners.forEach(var1x -> var1x.onPlayerSprintState(var1));
   }

   @Override
   public void onPlayerDeath() {
      this.listeners.forEach(IGameEventListener::onPlayerDeath);
   }

   @Override
   public void onChunkEvent(ChunkEvent var1) {
      EventState var2 = var1.getState();
      ChunkEvent.Type sx = var1.getType();
      Level sxx = this.baritone.getPlayerContext().world();
      boolean sxxx = sxx != null
         && var2 == EventState.PRE
         && sx == ChunkEvent.Type.UNLOAD
         && sxx.getChunkSource().getChunk(var1.getX(), var1.getZ(), null, false) != null;
      if (sxx != null && (var1.isPostPopulate() || sxxx)) {
         this.baritone.getWorldProvider().ifWorldLoaded(var2x -> {
            LevelChunk sxxxx = sxx.getChunk(var1.getX(), var1.getZ());
            var2x.getCachedWorld().queueForPacking(sxxxx);
         });
      }

      this.listeners.forEach(var1x -> var1x.onChunkEvent(var1));
   }

   @Override
   public final void onReceivePacket(PacketEvent var1) {
      this.listeners.forEach(var1x -> var1x.onReceivePacket(var1));
   }

   @Override
   public final void onWorldEvent(WorldEvent var1) {
      WorldProvider var2 = this.baritone.getWorldProvider();
      if (var1.getState() == EventState.POST) {
         var2.closeWorld();
         if (var1.getWorld() != null) {
            var2.initWorld(var1.getWorld());
         }
      }

      this.listeners.forEach(var1x -> var1x.onWorldEvent(var1));
   }

   @Override
   public final void registerEventListener(IGameEventListener var1) {
      this.listeners.add(var1);
   }

   @Override
   public final void onTick(TickEvent var1) {
      this.baritone.resetBsi(var1.getType() == TickEvent.Type.IN);
      this.listeners.forEach(var1x -> var1x.onTick(var1));
   }

   @Override
   public void onBlockChange(BlockChangeEvent var1) {
      if (Baritone.settings().repackOnAnyBlockChange.value) {
         boolean var2 = var1.getBlocks().stream().map(Pair::second).map(BlockStateBase::getBlock).anyMatch(CachedChunk.BLOCKS_TO_KEEP_TRACK_OF::contains);
         if (var2) {
            Level sx = this.baritone.getPlayerContext().world();
            if (sx != null) {
               this.baritone.getWorldProvider().ifWorldLoaded(var2x -> {
                  ChunkPos sxx = var1.getChunkPos();
                  var2x.getCachedWorld().queueForPacking(sx.getChunk(sxx.x(), sxx.z()));
               });
            }
         }
      }

      this.listeners.forEach(var1x -> var1x.onBlockChange(var1));
   }

   @Override
   public void onPathEvent(PathEvent var1) {
      this.listeners.forEach(var1x -> var1x.onPathEvent(var1));
   }

   @Override
   public void onPostTick(TickEvent var1) {
      this.listeners.forEach(var1x -> var1x.onPostTick(var1));
   }

   @Override
   public final void onRenderPass(RenderEvent var1) {
      this.listeners.forEach(var1x -> var1x.onRenderPass(var1));
   }

   @Override
   public final void onSendPacket(PacketEvent var1) {
      this.listeners.forEach(var1x -> var1x.onSendPacket(var1));
   }
}
