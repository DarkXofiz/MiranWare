// Original binary: sg/ec/2lpmf69DdXxDrrR5
package sg.ec;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// $VF: Compiled from s
public class PacketRegistryEntry<V extends GlobalPacketHandler> {
   private final Map<String, Supplier<? extends GlobalPacket<V, ?>>> field01107 = new HashMap<>();

   public byte[] method00594(GlobalPacket<?, ?> var1) {
      int var2 = Math.max(2048, var1.method00558());
      int sx = 0;

      while (sx < 6) {
         try {
            VertexBufferData sxx = new VertexBufferData(var2);
            sxx.writeString(var1.method00213());
            var1.method00209(sxx);
            sxx.flip();
            byte[] sxxx = new byte[sxx.remaining()];
            sxx.getByteBuffer().get(sxxx);
            return sxxx;
         } catch (BufferOverflowException sxx) {
            var2 *= 4;
            sx++;
         } catch (Exception sxx) {
            return null;
         }
      }

      return null;
   }

   public <T extends GlobalPacket<V, T>> void method00595(String var1, Supplier<T> var2) {
      this.field01107.put(var1, var2);
   }

   public static <T extends GlobalPacketHandler> PacketRegistryEntry<T> method00596() {
      return new PacketRegistryEntry<>();
   }

   private PacketRegistryEntry() {
   }

   public <T extends GlobalPacket<V, T>> T method00597(String var1) {
      var var2 = this.field01107.get(var1);
      return (T)(Object)(var2 == null ? null : var2.get());
   }

   public GlobalPacket<V, ?> method00598(byte[] var1) {
      try {
         if (var1 != null && var1.length != 0) {
            VertexBufferData var2 = new VertexBufferData(ByteBuffer.wrap(var1));
            String var3 = var2.readString();
            GlobalPacket var4 = this.method00597(var3);
            return var4 == null ? null : var4.method00210(var2);
         } else {
            return null;
         }
      } catch (Exception var5) {
         return null;
      }
   }
}
