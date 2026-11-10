// Original binary: sg/ec/tuXCxTNlik5qTw8z
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class NeuroRotationS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, NeuroRotationS2CPacket> {
   public static final String field24184 = "neuroRotationS2C";
   private List<String> field24185;
   private String field24186;
   private byte[] field24187;
   private String field24188;
   private byte[] field24189;
   private static final String field24190 = "neuroRotationS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      List var2 = this.field24185 == null ? List.of() : this.field24185;
      var1.writeInt(var2.size());

      for (String sx : (Iterable<String>) (Iterable) var2) {
         var1.writeString(sx == null ? "" : sx);
      }

      var1.writeString(this.field24186 == null ? "" : this.field24186);
      var1.writeBytes(this.field24187);
      var1.writeString(this.field24188 == null ? "" : this.field24188);
      var1.writeBytes(this.field24189);
   }

   public String method10881() {
      return this.field24186;
   }

   public void method10882(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10037(this);
   }

   public NeuroRotationS2CPacket(List<String> var1, String var2, byte[] var3, String var4, byte[] var5) {
      this.field24185 = var1 == null ? List.of() : new ArrayList<>(var1);
      this.field24186 = var2 == null ? "" : var2;
      this.field24187 = var3 == null ? new byte[0] : var3;
      this.field24188 = var4 == null ? "" : var4;
      this.field24189 = var5 == null ? new byte[0] : var5;
   }

   public byte[] method10883() {
      return this.field24189;
   }

   public byte[] method10884() {
      return this.field24187;
   }

   @Override
   public String method00213() {
      return field24190;
   }

   public NeuroRotationS2CPacket() {
      this.field24185 = List.of();
      this.field24186 = "";
      this.field24187 = new byte[0];
      this.field24188 = "";
      this.field24189 = new byte[0];
   }

   public NeuroRotationS2CPacket method10885(VertexBufferData var1) {
      NeuroRotationS2CPacket var2 = new NeuroRotationS2CPacket();
      int var3 = var1.readInt();
      if (var3 < 0 || var3 > 4096) {
         var3 = 0;
      }

      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < var3; var5++) {
         var4.add(var1.readString());
      }

      var2.field24185 = var4;
      var2.field24186 = var1.readString();
      var2.field24187 = var1.readBytes();
      var2.field24188 = var1.readString();
      var2.field24189 = var1.readBytes();
      return var2;
   }

   public String method10886() {
      return this.field24188;
   }

   public List<String> method10887() {
      return this.field24185;
   }

   @Override
   public NeuroRotationS2CPacket method00210(VertexBufferData var1) {
      return this.method10885(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method10882(var1, var2);
   }
}
