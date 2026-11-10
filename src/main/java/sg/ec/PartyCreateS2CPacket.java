// Original binary: sg/ec/hjmDmNkcDaIgsQFy
package sg.ec;

import com.google.gson.Gson;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyCreateS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, PartyCreateS2CPacket> {
   public static final String field19876 = "partyCreateS2C";
   private PartyMember field19877;
   private Party field19878;
   private static final String field19879 = "partyCreateS2C";

   public PartyMember method08681() {
      return this.field19877;
   }

   public void method08682(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method04361(this);
   }

   public PartyCreateS2CPacket(PartyMember var1, Party var2) {
      this.field19877 = var1;
      this.field19878 = var2;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field19877);
      var1.writeFloat(this.field19877.method07582().field03984);
      var1.writeFloat(this.field19877.method07582().field03985);
      var1.writeFloat(this.field19877.method07582().field03986);
      var1.writeString(this.field19878 != null ? new Gson().toJson(this.field19878, Party.class) : "");
   }

   public Party method08683() {
      return this.field19878;
   }

   public PartyCreateS2CPacket() {
   }

   @Override
   public String method00213() {
      return field19879;
   }

   public PartyCreateS2CPacket method08684(VertexBufferData var1) {
      PartyCreateS2CPacket var2 = new PartyCreateS2CPacket();
      var2.field19877 = var1.readPartyPlayer();
      var2.field19877.method07582().field03984 = var1.readFloat();
      var2.field19877.method07582().field03985 = var1.readFloat();
      var2.field19877.method07582().field03986 = var1.readFloat();
      String var3 = var1.readString();
      var2.field19878 = var3.isEmpty() ? null : (Party)new Gson().fromJson(var3, Party.class);
      return var2;
   }

   @Override
   public PartyCreateS2CPacket method00210(VertexBufferData var1) {
      return this.method08684(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method08682(var1, var2);
   }
}
