// Original binary: sg/ec/oh8wAEXhcpxwJM7P
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class GlobalsPingC2SPacket implements GlobalPacket<GlobalPacketHandler, GlobalsPingC2SPacket> {
   public static final String field22167 = "globalsPingC2S";
   private String field22168;
   private String field22169;
   private String field22170;
   private String field22171;
   private long field22172;
   private boolean field22173;
   private float field22174;
   private float field22175;
   private float field22176;
   private String field22177 = "";
   private static final String field22178 = "UNKNOWN";
   private static final String field22179 = "UNKNOWN";
   private static final String field22180 = "UNKNOWN";
   private static final String field22181 = "globalsPingC2S";

   public String method09863() {
      return this.field22170;
   }

   public String method09864() {
      return this.field22168;
   }

   public GlobalsPingC2SPacket method09865(VertexBufferData var1) {
      this.field22168 = var1.readString();
      this.field22169 = var1.remaining() > 0 ? var1.readString() : "";
      this.field22170 = var1.remaining() > 0 ? var1.readString() : "";
      this.field22171 = var1.remaining() > 0 ? var1.readString() : field22179;
      this.field22172 = var1.readLong();
      this.field22173 = var1.remaining() > 0 && var1.readBoolean();
      if (this.field22173 && var1.remaining() >= 12) {
         this.field22174 = var1.readFloat();
         this.field22175 = var1.readFloat();
         this.field22176 = var1.readFloat();
      }

      this.field22177 = var1.remaining() > 0 ? var1.readString() : "";
      return this;
   }

   public float method09866() {
      return this.field22176;
   }

   public String method09867() {
      return this.field22177;
   }

   public GlobalsPingC2SPacket(GlobalPlayer var1, long var2, String var4) {
      this.field22168 = var1 != null ? var1.method07590() : "";
      this.field22169 = var1 != null ? var1.method07586() : "";
      this.field22170 = var1 != null ? var1.method07580() : "";
      this.field22171 = var1 != null ? var1.method07584() : field22178;
      this.field22172 = var2;
      this.field22177 = var4 != null ? var4 : "";
      if (var1 != null && var1.method07582() != null) {
         float var5 = var1.method07582().field03984;
         float var6 = var1.method07582().field03985;
         float var7 = var1.method07582().field03986;
         this.field22173 = Float.isFinite(var5) && Float.isFinite(var6) && Float.isFinite(var7);
         if (this.field22173) {
            this.field22174 = var5;
            this.field22175 = var6;
            this.field22176 = var7;
         }
      }
   }

   @Override
   public String method00213() {
      return field22181;
   }

   public float method09868() {
      return this.field22175;
   }

   public String method09869() {
      return this.field22171;
   }

   public GlobalsPingC2SPacket() {
   }

   public float method09870() {
      return this.field22174;
   }

   public long method09871() {
      return this.field22172;
   }

   public String method09872() {
      return this.field22169;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public boolean method09873() {
      return this.field22173;
   }

   public GlobalsPingC2SPacket(GlobalPlayer var1, long var2) {
      this(var1, var2, "");
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writeString(this.field22168 != null ? this.field22168 : "");
      var1.writeString(this.field22169 != null ? this.field22169 : "");
      var1.writeString(this.field22170 != null ? this.field22170 : "");
      var1.writeString(this.field22171 != null ? this.field22171 : field22180);
      var1.writeLong(this.field22172);
      var1.writeBoolean(this.field22173);
      if (this.field22173) {
         var1.writeFloat(this.field22174);
         var1.writeFloat(this.field22175);
         var1.writeFloat(this.field22176);
      }

      var1.writeString(this.field22177 != null ? this.field22177 : "");
   }

   @Override
   public GlobalsPingC2SPacket method00210(VertexBufferData var1) {
      return this.method09865(var1);
   }
}
