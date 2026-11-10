// Original binary: sg/ec/AGVL9hZpwH4ZtN5o
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class FunTimeDataS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, FunTimeDataS2CPacket> {
   public static final String field06002 = "funTimeDataS2C";
   private List<AnarchyServerInfo> field06003;
   private List<FunTimeServerData> field06004;
   private static final String field06005 = "funTimeDataS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writeInt(this.field06003.size());

      for (AnarchyServerInfo var3 : this.field06003) {
         method02500(var1, var3.method11218());
         method02500(var1, var3.method11211());
         method02500(var1, var3.method11222());
         method02500(var1, var3.method11214());
         method02500(var1, var3.method11209());
         method02500(var1, var3.method11208());
         method02500(var1, var3.method11207());
         var1.writeLong(var3.method11206());
         var1.writeLong(var3.method11215());
      }

      var1.writeInt(this.field06004.size());

      for (FunTimeServerData var6 : this.field06004) {
         method02500(var1, var6.method02254());
         method02500(var1, var6.method02251());
         method02500(var1, var6.method02255());
         method02500(var1, var6.method02257());
         method02500(var1, var6.method02243());
         var1.writeLong(var6.method02256());
         var1.writeLong(var6.method02246());
      }

      for (AnarchyServerInfo var7 : this.field06003) {
         var1.writeBoolean(var7.method11228());
         var1.writeInt(var7.method11221());
         var1.writeInt(var7.method11227());
         var1.writeInt(var7.method11224());
         var1.writeLong(var7.method11212());
         var1.writeLong(var7.method11210());
      }
   }

   public FunTimeDataS2CPacket(List<AnarchyServerInfo> var1, List<FunTimeServerData> var2) {
      this.field06003 = var1 != null ? new ArrayList<>(var1) : new ArrayList<>();
      this.field06004 = var2 != null ? new ArrayList<>(var2) : new ArrayList<>();
   }

   private static void method02500(VertexBufferData var0, String var1) {
      var0.writeString(var1 == null ? "" : var1);
   }

   public FunTimeDataS2CPacket method02501(VertexBufferData var1) {
      FunTimeDataS2CPacket var2 = new FunTimeDataS2CPacket();
      int var3 = var1.readInt();
      var2.field06003 = new ArrayList<>();

      for (int var4 = 0; var4 < var3; var4++) {
         AnarchyServerInfo var5 = new AnarchyServerInfo();
         var5.method11216(var1.readString());
         var5.method11217(var1.readString());
         var5.method11233(var1.readString());
         var5.method11229(var1.readString());
         var5.method11234(var1.readString());
         var5.method11220(var1.readString());
         var5.method11232(var1.readString());
         var5.method11205(var1.readLong());
         var5.method11230(var1.readLong());
         var2.field06003.add(var5);
      }

      int var7 = var1.readInt();
      var2.field06004 = new ArrayList<>();

      for (int var8 = 0; var8 < var7; var8++) {
         FunTimeServerData var6 = new FunTimeServerData();
         var6.method02252(var1.readString());
         var6.method02253(var1.readString());
         var6.method02245(var1.readString());
         var6.method02247(var1.readString());
         var6.method02244(var1.readString());
         var6.method02248(var1.readLong());
         var6.method02250(var1.readLong());
         var2.field06004.add(var6);
      }

      if (var1.remaining() > 0) {
         for (AnarchyServerInfo var10 : var2.field06003) {
            var10.method11231(var1.readBoolean());
            var10.method11225(var1.readInt());
            var10.method11219(var1.readInt());
            var10.method11235(var1.readInt());
            var10.method11213(var1.readLong());
            var10.method11226(var1.readLong());
         }
      }

      return var2;
   }

   public List<FunTimeServerData> method02502() {
      return this.field06004;
   }

   public List<AnarchyServerInfo> method02503() {
      return this.field06003;
   }

   @Override
   public String method00213() {
      return field06005;
   }

   public FunTimeDataS2CPacket() {
   }

   public void method02504(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10051(this);
   }

   @Override
   public FunTimeDataS2CPacket method00210(VertexBufferData var1) {
      return this.method02501(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method02504(var1, var2);
   }
}
