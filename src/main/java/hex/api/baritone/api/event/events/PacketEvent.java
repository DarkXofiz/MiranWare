// Original binary: hex/api/baritone/api/event/events/PacketEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.event.events.type.EventState;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;

// $VF: Compiled from s
public final class PacketEvent {
   private final Connection networkManager;
   private final EventState state;
   private final Packet<?> packet;

   public final EventState getState() {
      return this.state;
   }

   public final Packet<?> getPacket() {
      return this.packet;
   }

   public final Connection getNetworkManager() {
      return this.networkManager;
   }

   public PacketEvent(Connection var1, EventState var2, Packet<?> var3) {
      this.networkManager = var1;
      this.state = var2;
      this.packet = var3;
   }

   public final <T extends Packet<?>> T cast() {
      return (T)(Object)this.packet;
   }
}
