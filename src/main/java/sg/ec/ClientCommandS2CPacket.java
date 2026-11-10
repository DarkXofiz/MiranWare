// Original binary: sg/ec/o0ggVOEshhRuNQCm
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class ClientCommandS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, ClientCommandS2CPacket> {
   public static final String field22061 = "clientCommandS2C";
   private GlobalPlayer field22062;
   private ClientCommandS2CPacket.Nested272 field22063;
   private String field22064;
   private int field22065;
   private List<ClientCommandS2CPacket.Nested273> field22066;
   private boolean field22067;
   private List<String> field22068;
   private static final String field22069 = "clientCommandS2C";

   public List<String> method09747() {
      return this.field22068;
   }

   public ClientCommandS2CPacket() {
      this.field22065 = 30;
      this.field22066 = List.of();
      this.field22067 = true;
      this.field22068 = List.of();
   }

   public ClientCommandS2CPacket.Nested272 method09748() {
      return this.field22063;
   }

   public boolean method09749() {
      return this.field22067;
   }

   public String method09750() {
      return this.field22064;
   }

   public List<ClientCommandS2CPacket.Nested273> method09751() {
      return this.field22066;
   }

   public ClientCommandS2CPacket method09752(VertexBufferData var1) {
      ClientCommandS2CPacket var2 = new ClientCommandS2CPacket();
      var2.field22062 = var1.readPlayer();
      var2.field22063 = ClientCommandS2CPacket.Nested272.valueOf(var1.readString());
      var2.field22064 = var1.readString();
      var2.field22065 = var1.remaining() > 0 ? Math.max(1, var1.readInt()) : 30;
      int var3 = var1.readInt();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < var3; var5++) {
         String var6 = var1.readString();
         String var7 = var1.readString();
         boolean var8 = var1.readBoolean();
         float var9 = var1.readFloat();
         float var10 = var1.readFloat();
         float var11 = var1.readFloat();
         String var12 = var1.remaining() > 0 ? var1.readString() : "";
         String var13 = var1.remaining() > 0 ? var1.readString() : "";
         String var14 = var1.remaining() > 0 ? var1.readString() : "";
         String var15 = var1.remaining() > 0 ? var1.readString() : "";
         var4.add(new ClientCommandS2CPacket.Nested273(var6, var7, var8, var9, var10, var11, var12, var13, var14, var15));
      }

      var2.field22066 = var4;
      var2.field22067 = var1.remaining() > 0 ? var1.readBoolean() : true;
      int var16 = var1.remaining() > 0 ? var1.readInt() : 0;
      var var17 = new ArrayList(Math.max(var16, 0));

      for (int var18 = 0; var18 < var16; var18++) {
         var17.add(var1.readString());
      }

      var2.field22068 = var17;
      return var2;
   }

   public int method09753() {
      return this.field22065;
   }

   public GlobalPlayer method09754() {
      return this.field22062;
   }

   public void method09755(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method04358(this);
   }

   public ClientCommandS2CPacket(GlobalPlayer var1, ClientCommandS2CPacket.Nested272 var2, String var3, int var4, List<ClientCommandS2CPacket.Nested273> var5) {
      this(var1, var2, var3, var4, var5, true, List.of());
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field22062);
      var1.writeString(this.field22063.name());
      var1.writeString(this.field22064 == null ? "" : this.field22064);
      var1.writeInt(Math.max(1, this.field22065));
      List var2 = this.field22066 == null ? List.of() : this.field22066;
      var1.writeInt(var2.size());

      for (ClientCommandS2CPacket.Nested273 var4 : (Iterable<ClientCommandS2CPacket.Nested273>) (Iterable) var2) {
         ClientCommandS2CPacket.Nested273 var5 = var4 == null ? ClientCommandS2CPacket.Nested273.empty() : var4;
         var1.writeString(var5.targetUsername());
         var1.writeString(var5.clientUsername());
         var1.writeBoolean(var5.hasPosition());
         var1.writeFloat(var5.field22070());
         var1.writeFloat(var5.field22071());
         var1.writeFloat(var5.field22072());
         var1.writeString(var5.field22073());
         var1.writeString(var5.sessionId());
         var1.writeString(var5.server());
         var1.writeString(var5.version());
      }

      var1.writeBoolean(this.field22067);
      List var6 = this.field22068 == null ? List.of() : this.field22068;
      var1.writeInt(var6.size());

      for (String var8 : (Iterable<String>) (Iterable) var6) {
         var1.writeString(var8 == null ? "" : var8);
      }
   }

   @Override
   public String method00213() {
      return field22069;
   }

   public ClientCommandS2CPacket(
      GlobalPlayer var1,
      ClientCommandS2CPacket.Nested272 var2,
      String var3,
      int var4,
      List<ClientCommandS2CPacket.Nested273> var5,
      boolean var6,
      List<String> var7
   ) {
      this.field22062 = var1;
      this.field22063 = var2 == null ? ClientCommandS2CPacket.Nested272.USERS : var2;
      this.field22064 = var3 == null ? "" : var3;
      this.field22065 = Math.max(1, var4);
      this.field22066 = var5 == null ? List.of() : new ArrayList<>(var5);
      this.field22067 = var6;
      this.field22068 = var7 == null ? List.of() : new ArrayList<>(var7);
   }

   // $VF: Compiled from s
   public enum Nested272 {
      USERS,
      CLOSE,
      NETWORK_STOP,
      MESSAGE,
      DROP_ALL,
      CURRENT_DROP;
   }

   // $VF: Compiled from s
   public record Nested273(
      String targetUsername,
      String clientUsername,
      boolean hasPosition,
      float field22070,
      float field22071,
      float field22072,
      String field22073,
      String sessionId,
      String server,
      String version
   ) {
      public static ClientCommandS2CPacket.Nested273 empty() {
         return new ClientCommandS2CPacket.Nested273("", "", false, 0.0F, 0.0F, 0.0F, "", "", "", "");
      }

      public Nested273(
         String targetUsername,
         String clientUsername,
         boolean hasPosition,
         float field22070,
         float field22071,
         float field22072,
         String field22073,
         String sessionId,
         String server,
         String version
      ) {
         targetUsername = targetUsername == null ? "" : targetUsername;
         clientUsername = clientUsername == null ? "" : clientUsername;
         field22073 = field22073 == null ? "" : field22073;
         sessionId = sessionId == null ? "" : sessionId;
         server = server == null ? "" : server;
         version = version == null ? "" : version;
         this.targetUsername = targetUsername;
         this.clientUsername = clientUsername;
         this.hasPosition = hasPosition;
         this.field22070 = field22070;
         this.field22071 = field22071;
         this.field22072 = field22072;
         this.field22073 = field22073;
         this.sessionId = sessionId;
         this.server = server;
         this.version = version;
      }
   }

   @Override
   public ClientCommandS2CPacket method00210(VertexBufferData var1) {
      return this.method09752(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method09755(var1, var2);
   }
}
