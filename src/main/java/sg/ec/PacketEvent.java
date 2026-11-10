// Original binary: sg/ec/u4WqlGVBe957Hz4h
package sg.ec;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class PacketEvent extends Event {
   public static final PacketEvent field24206 = new PacketEvent();
   private Packet<?> field24207;
   private PacketEvent.Nested316 field24208;
   private Connection field24209;

   public void method10894(Packet<?> var1, PacketEvent.Nested316 var2, CallbackInfo var3, Connection var4) {
      if (this.method10895(var1, var2, var4)) {
         var3.cancel();
      }
   }

   public boolean method10895(Packet<?> var1, PacketEvent.Nested316 var2, Connection var3) {
      return this.method10903(var1, var2, var3) == null;
   }

   public void method10896(Connection var1) {
      this.field24209 = var1;
   }

   public Packet<?> method10897() {
      return this.field24207;
   }

   public void method10898(PacketEvent.Nested316 var1) {
      this.field24208 = var1;
   }

   public boolean method10899() {
      return this.field24208 == PacketEvent.Nested316.SEND;
   }

   public void method10900(Packet<?> var1) {
      this.field24207 = var1;
   }

   public Connection method10901() {
      return this.field24209;
   }

   public PacketEvent.Nested316 method10902() {
      return this.field24208;
   }

   public Packet<?> method10903(Packet<?> var1, PacketEvent.Nested316 var2, Connection var3) {
      PacketEvent var4 = new PacketEvent();
      var4.field24207 = var1;
      var4.field24208 = var2;
      var4.field24209 = var3;
      if (true) {
         var4.method03208();
      }

      return var4.method05694() ? null : var4.field24207;
   }

   public boolean method10904() {
      return this.field24208 == PacketEvent.Nested316.RECEIVE;
   }

   // $VF: Compiled from s
   public enum Nested316 {
      RECEIVE,
      SEND;
   }
}
