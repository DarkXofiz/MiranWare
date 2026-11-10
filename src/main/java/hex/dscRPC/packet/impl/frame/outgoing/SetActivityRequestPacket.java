// Original binary: hex/dscRPC/packet/impl/frame/outgoing/SetActivityRequestPacket
package hex.dscRPC.packet.impl.frame.outgoing;

import com.fasterxml.jackson.annotation.JsonProperty;
import hex.dscRPC.activity.model.Activity;
import hex.dscRPC.packet.impl.frame.OutgoingFramePacket;

// $VF: Compiled from s
public class SetActivityRequestPacket extends OutgoingFramePacket<SetActivityRequestPacket.Arguments> {
   private static final String 诶Р3 = "诶Р3";


   public SetActivityRequestPacket(SetActivityRequestPacket.Arguments var1) {
      super(诶Р3, var1);
   }

   // $VF: Compiled from s
   public static class Arguments {
      @JsonProperty("pid")
      private final long processId;
      @JsonProperty("activity")
      private final Activity activity;

      public Arguments(long var1, Activity var3) {
         this.processId = var1;
         this.activity = var3;
      }
   }
}
