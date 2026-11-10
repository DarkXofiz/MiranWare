// Original binary: hex/dscRPC/packet/impl/frame/incoming/DispatchEventPacket
package hex.dscRPC.packet.impl.frame.incoming;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import hex.dscRPC.event.model.Event;
import hex.dscRPC.event.model.ReadyEvent;
import hex.dscRPC.event.model.VoiceChannelSelectEvent;
import hex.dscRPC.packet.impl.frame.IncomingFramePacket;

// $VF: Compiled from s
public class DispatchEventPacket extends IncomingFramePacket<Event> {
   @JsonSubTypes({@Type(value = ReadyEvent.class, name = "READY"), @Type(value = VoiceChannelSelectEvent.class, name = "VOICE_CHANNEL_SELECT")})
   @JsonProperty("data")
   @JsonTypeInfo(use = Id.NAME, include = As.EXTERNAL_PROPERTY, property = "evt", visible = true)
   protected Event data;

   @Override
   public String toString() {
      return "DispatchEventPacket { event = " + this.data + " }";
   }

   public Event data() {
      return this.data;
   }
}
