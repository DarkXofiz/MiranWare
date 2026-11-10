// Original binary: sg/ec/pSzqWbBTN05w5lH6
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyKickC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyKickC2SPacket> {
   public static final String field22769 = "partyKickC2S";
   private PartyMember field22770;
   private String field22771;
   private PartyMember field22772;
   private String field22773;
   private static final String field22774 = "partyKickC2S";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field22770);
      var1.writePartyPlayer(this.field22772);
      var1.writeString(this.field22771);
      var1.writeString(this.field22773);
   }

   public PartyKickC2SPacket() {
   }

   @Override
   public String method00213() {
      return field22774;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public PartyMember method10099() {
      return this.field22772;
   }

   public PartyKickC2SPacket(PartyMember var1, PartyMember var2, String var3, String var4) {
      this.field22770 = var1;
      this.field22772 = var2;
      this.field22771 = var3;
      this.field22773 = var4;
   }

   public PartyMember method10100() {
      return this.field22770;
   }

   public String method10101() {
      return this.field22773;
   }

   public PartyKickC2SPacket method10102(VertexBufferData var1) {
      this.field22770 = var1.readPartyPlayer();
      this.field22772 = var1.readPartyPlayer();
      this.field22771 = var1.readString();
      this.field22773 = var1.readString();
      return this;
   }

   public String method10103() {
      return this.field22771;
   }

   @Override
   public PartyKickC2SPacket method00210(VertexBufferData var1) {
      return this.method10102(var1);
   }
}
