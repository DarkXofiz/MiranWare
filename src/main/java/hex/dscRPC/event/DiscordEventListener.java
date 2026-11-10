// Original binary: hex/dscRPC/event/DiscordEventListener
package hex.dscRPC.event;

import hex.dscRPC.event.model.Event;
import hex.dscRPC.event.model.ReadyEvent;
import hex.dscRPC.event.model.VoiceChannelSelectEvent;

// $VF: Compiled from s
public interface DiscordEventListener {
   default void onEvent(Event var1) {
      if (var1 instanceof ReadyEvent) {
         this.onReadyEvent((ReadyEvent)var1);
      }

      if (var1 instanceof VoiceChannelSelectEvent) {
         this.onVoiceChannelSelectEvent((VoiceChannelSelectEvent)var1);
      }
   }

   default void onVoiceChannelSelectEvent(VoiceChannelSelectEvent var1) {
   }

   default void onReadyEvent(ReadyEvent var1) {
   }
}
