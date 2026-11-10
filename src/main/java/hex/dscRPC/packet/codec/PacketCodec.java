// Original binary: hex/dscRPC/packet/codec/PacketCodec
package hex.dscRPC.packet.codec;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import hex.dscRPC.packet.Packet;
import hex.dscRPC.packet.PacketOpcode;
import hex.dscRPC.packet.impl.ClosePacket;
import hex.dscRPC.packet.impl.PingPacket;
import hex.dscRPC.packet.impl.PongPacket;
import hex.dscRPC.packet.impl.frame.IncomingFramePacket;
import hex.dscRPC.socket.SystemSocket;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

// $VF: Compiled from s
public class PacketCodec {
   private static final int HEADER_SIZE_BYTES = 8;
   private final ByteBuffer headerBuffer = ByteBuffer.allocate(8);
   private final JsonMapper jsonMapper;
   private final PacketCodec.ReadFunction readFunction;
   private final PacketCodec.WriteFunction writeFunction;

   public void write(Packet var1) throws IOException {
      byte[] var2 = this.jsonMapper.writeValueAsBytes(var1);
      ByteBuffer sx = ByteBuffer.allocate(8 + var2.length);
      sx.order(ByteOrder.LITTLE_ENDIAN);
      sx.putInt(var1.opcode().ordinal());
      sx.putInt(var2.length);
      sx.order(ByteOrder.BIG_ENDIAN);
      sx.put(var2);
      this.writeFunction.write(sx);
   }

   public Packet read() throws IOException {
      if (!this.readFunction.readFully(this.headerBuffer)) {
         return null;
      }

      int var1 = this.headerBuffer.getInt();
      int sx = this.headerBuffer.getInt();
      this.headerBuffer.clear();
      PacketOpcode[] sxx = PacketOpcode.values();
      if (var1 >= 1 && var1 < sxx.length) {
         PacketOpcode sxxx = sxx[var1];
         ByteBuffer sxxxx = ByteBuffer.allocate(sx);
         if (!this.readFunction.readFully(sxxxx)) {
            return null;
         }

         String sxxxxx = StandardCharsets.UTF_8.decode(sxxxx).toString();
         switch (sxxx) {
            case FRAME:
               return this.jsonMapper.readValue(sxxxxx, IncomingFramePacket.class);
            case CLOSE:
               return this.jsonMapper.readValue(sxxxxx, ClosePacket.class);
            case PING:
               return this.jsonMapper.readValue(sxxxxx, PingPacket.class);
            case PONG:
               return this.jsonMapper.readValue(sxxxxx, PongPacket.class);
            default:
               throw new IllegalStateException("Unsupported packet opcode " + sxxx);
         }
      } else {
         return null;
      }
   }

   public PacketCodec(PacketCodec.ReadFunction var1, PacketCodec.WriteFunction var2) {
      this.headerBuffer.order(ByteOrder.LITTLE_ENDIAN);
      this.jsonMapper = JsonMapper.builder()
         .enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
         .disable(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES,
            DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES
         )
         .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
         .defaultPropertyInclusion(Value.construct(Include.NON_NULL, Include.NON_NULL))
         .visibility(PropertyAccessor.FIELD, Visibility.NONE)
         .visibility(PropertyAccessor.GETTER, Visibility.NONE)
         .visibility(PropertyAccessor.IS_GETTER, Visibility.NONE)
         .visibility(PropertyAccessor.SETTER, Visibility.NONE)
         .build();
      this.readFunction = var1;
      this.writeFunction = var2;
   }

   public static PacketCodec from(SystemSocket var0) {
      return new PacketCodec(var0::readFully, var0::write);
   }

   // $VF: Compiled from s
   public interface ReadFunction {
      boolean readFully(ByteBuffer var1) throws IOException;
   }

   // $VF: Compiled from s
   public interface WriteFunction {
      void write(ByteBuffer var1) throws IOException;
   }
}
