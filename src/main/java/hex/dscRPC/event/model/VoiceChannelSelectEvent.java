// Original binary: hex/dscRPC/event/model/VoiceChannelSelectEvent
package hex.dscRPC.event.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// $VF: Compiled from s
public class VoiceChannelSelectEvent implements Event {
   @JsonProperty("channel_id")
   private final String channelId;
   @JsonProperty("guild_id")
   private final String guildId;

   @Override
   public String toString() {
      return "VoiceChannelSelectEvent { channel_id = " + this.channelId + ", guild_id = " + this.guildId + " }";
   }

   @JsonCreator
   public VoiceChannelSelectEvent(@JsonProperty("channel_id") String var1, @JsonProperty("guild_id") String var2) {
      this.channelId = var1;
      this.guildId = var2;
   }
}
