// Original binary: hex/dscRPC/socket/SystemSocket
package hex.dscRPC.socket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

// $VF: Compiled from s
public interface SystemSocket {
   void close() throws IOException;

   boolean isConnected();

   boolean readFully(ByteBuffer var1) throws IOException;

   void write(ByteBuffer var1) throws IOException;

   void connect(Path var1) throws IOException;
}
