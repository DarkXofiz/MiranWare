// Original binary: hex/dscRPC/packet/impl/frame/IncomingFramePacket
package hex.dscRPC.packet.impl.frame;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import hex.dscRPC.packet.impl.FramePacket;
import hex.dscRPC.packet.impl.frame.incoming.DispatchEventPacket;
import hex.dscRPC.packet.impl.frame.incoming.SetActivityResponsePacket;

// $VF: Compiled from s
@JsonTypeInfo(use = Id.NAME, include = As.EXISTING_PROPERTY, property = "cmd")
@JsonSubTypes({@Type(value = DispatchEventPacket.class, name = "DISPATCH"), @Type(value = SetActivityResponsePacket.class, name = "SET_ACTIVITY")})
public abstract class IncomingFramePacket<D> extends FramePacket {
   public abstract D data();
}
