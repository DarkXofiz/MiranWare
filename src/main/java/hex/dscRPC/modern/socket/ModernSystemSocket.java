// Original binary: hex/dscRPC/modern/socket/ModernSystemSocket
package hex.dscRPC.modern.socket;

import hex.dscRPC.socket.SystemSocket;
import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;

// $VF: Compiled from s
public class ModernSystemSocket implements SystemSocket {
   private final SocketChannel socketChannel;

   @Override
   public void write(ByteBuffer var1) throws IOException {
      if (this.socketChannel.isConnected()) {
         var1.position(0);
         this.socketChannel.write(var1);
      }
   }

   @Override
   public void close() throws IOException {
      this.socketChannel.close();
   }

   @Override
   public void connect(Path var1) throws IOException {
      UnixDomainSocketAddress var2 = UnixDomainSocketAddress.of(var1);
      this.socketChannel.connect(var2);
   }

   public ModernSystemSocket() {
      try {
         this.socketChannel = SocketChannel.open(StandardProtocolFamily.UNIX);
      } catch (IOException var2) {
         throw new RuntimeException(var2);
      }
   }

   @Override
   public boolean readFully(ByteBuffer var1) throws IOException {
      while (var1.hasRemaining()) {
         if (!this.socketChannel.isConnected()) {
            return false;
         }

         if (this.socketChannel.read(var1) == -1) {
            return false;
         }
      }

      var1.position(0);
      return true;
   }

   @Override
   public boolean isConnected() {
      return this.socketChannel.isConnected();
   }
}
