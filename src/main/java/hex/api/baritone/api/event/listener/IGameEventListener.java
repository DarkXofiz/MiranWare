// Original binary: hex/api/baritone/api/event/listener/IGameEventListener
package hex.api.baritone.api.event.listener;

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

// $VF: Compiled from s
public interface IGameEventListener {
   void onRenderPass(RenderEvent var1);

   void onPlayerSprintState(SprintStateEvent var1);

   void onBlockInteract(BlockInteractEvent var1);

   void onReceivePacket(PacketEvent var1);

   void onPlayerDeath();

   void onPostTick(TickEvent var1);

   void onPreTabComplete(TabCompleteEvent var1);

   void onBlockChange(BlockChangeEvent var1);

   void onSendPacket(PacketEvent var1);

   void onSendChatMessage(ChatEvent var1);

   void onPlayerUpdate(PlayerUpdateEvent var1);

   void onWorldEvent(WorldEvent var1);

   void onPlayerRotationMove(RotationMoveEvent var1);

   void onPathEvent(PathEvent var1);

   void onChunkEvent(ChunkEvent var1);

   void onTick(TickEvent var1);
}
