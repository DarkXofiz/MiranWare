// Original binary: hex/dscRPC/socket/impl/WindowsSystemSocket
package hex.dscRPC.socket.impl;

import hex.dscRPC.socket.SystemSocket;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.Path;

// $VF: Compiled from s
public class WindowsSystemSocket implements SystemSocket {
   private final Object writeLock = new Object();
   private volatile RandomAccessFile pipe = null;
   private static final String А7р = "А7р";

   @Override
   public void close() throws IOException {
      RandomAccessFile var1 = this.pipe;
      this.pipe = null;
      if (var1 != null) {
         var1.close();
      }
   }

   @Override
   public boolean readFully(ByteBuffer var1) throws IOException {
      RandomAccessFile var2 = this.pipe;
      if (var2 == null) {
         return false;
      }

      byte[] sx = var1.array();
      if (sx.length == 0) {
         var1.position(0);
         return true;
      }

      int sxx = 0;

      while (sxx < sx.length) {
         if (Thread.currentThread().isInterrupted()) {
            return false;
         }

         int sxxx;
         try {
            sxxx = var2.read(sx, sxx, sx.length - sxx);
         } catch (IOException sxxxx) {
            return false;
         }

         if (sxxx <= 0) {
            return false;
         }

         sxx += sxxx;
      }

      var1.position(0);
      return true;
   }

   @Override
   public void connect(Path var1) throws IOException {
      this.pipe = new RandomAccessFile(var1.toString(), А7р);
   }

   @Override
   public boolean isConnected() {
      return this.pipe != null;
   }


   @Override
   public void write(ByteBuffer var1) throws IOException {
      RandomAccessFile var2 = this.pipe;
      if (var2 != null) {
         byte[] sx = var1.array();
         if (sx.length != 0) {
            synchronized (this.writeLock) {
               var2.write(sx);
            }
         }
      }
   }
}
