// Original binary: sg/ec/6YQHHnSf1Wq9AzUR
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyUpdateC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyUpdateC2SPacket> {
   public static final String field03537 = "partyUpdateC2S";
   private GlobalPlayer field03538;
   private boolean field03539;
   private boolean field03540;
   private static final String field03541 = "UNKNOWN";
   private static final String field03542 = "partyUpdateC2S";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writeString(this.field03538.method07590());
      var1.writeString(this.field03538.method07584() != null ? this.field03538.method07584() : field03541);
      var1.writeBoolean(this.field03539);
      if (this.field03539) {
         var1.writeString(this.field03538.method07586());
         var1.writeString(this.field03538.method07580());
      }

      var1.writeBoolean(this.field03540);
      if (this.field03540) {
         var1.writeFloat(this.field03538.method07582().field03984);
         var1.writeFloat(this.field03538.method07582().field03985);
         var1.writeFloat(this.field03538.method07582().field03986);
      }
   }

   public PartyUpdateC2SPacket method01432(VertexBufferData var1) {
      String var2 = var1.readString();
      String var3 = var1.readString();
      boolean var4 = var1.readBoolean();
      String var5 = "";
      String var6 = "";
      if (var4) {
         var5 = var1.readString();
         var6 = var1.readString();
      }

      boolean var7 = var1.readBoolean();
      GlobalPlayer var8 = new GlobalPlayer(var5, var6, var2, var3);
      if (var7) {
         var8.method07582().field03984 = var1.readFloat();
         var8.method07582().field03985 = var1.readFloat();
         var8.method07582().field03986 = var1.readFloat();
      }

      this.field03538 = var8;
      this.field03539 = var4;
      this.field03540 = var7;
      return this;
   }

   public boolean method01433() {
      if (this.field03538 == null) {
         return false;
      }

      String var1 = this.field03538.method07590();
      if (var1 == null || var1.isEmpty()) {
         return false;
      }

      if (!this.field03539 && !this.field03540) {
         return false;
      }

      if (this.field03539) {
         String var2 = this.field03538.method07586();
         String var3 = this.field03538.method07580();
         if (var2 == null || var2.isEmpty()) {
            return false;
         }

         if (var3 == null || var3.isEmpty()) {
            return false;
         }
      }

      if (!this.field03540) {
         return true;
      }

      float var5 = this.field03538.method07582().field03984;
      float var6 = this.field03538.method07582().field03985;
      float var4 = this.field03538.method07582().field03986;
      return Float.isFinite(var5) && Float.isFinite(var6) && Float.isFinite(var4);
   }

   public GlobalPlayer method01434() {
      return this.field03538;
   }

   public PartyUpdateC2SPacket() {
   }

   @Override
   public String method00213() {
      return field03542;
   }

   public PartyUpdateC2SPacket(GlobalPlayer var1) {
      this(var1, true, true);
   }

   public boolean method01435() {
      return this.field03540;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public PartyUpdateC2SPacket(GlobalPlayer var1, boolean var2, boolean var3) {
      this.field03538 = var1;
      this.field03539 = var2;
      this.field03540 = var3;
   }

   public boolean method01436() {
      return this.field03539;
   }

   @Override
   public PartyUpdateC2SPacket method00210(VertexBufferData var1) {
      return this.method01432(var1);
   }
}
