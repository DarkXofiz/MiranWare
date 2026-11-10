// Original binary: sg/ec/x6xZxqk8MdAQzj7z
package sg.ec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.PendingWriteQueue;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

// $VF: Compiled from s
final class SocksHandshakeHandler extends ChannelDuplexHandler {
   private static final long field25290 = 10000L;
   private final ProxyConfig field25291;
   private final InetSocketAddress field25292;
   private final Promise<Void> field25293;
   private ChannelPromise field25294;
   private InetSocketAddress field25295;
   private SocksHandshakeHandler.Nested320 field25296;
   private PendingWriteQueue field25297;
   private boolean field25298;
   private ByteBuf field25299;
   private Future<?> field25300;
   private static final String field25301 = "SOCKS tunnel handshake failed";
   private static final String field25302 = "Disconnected during SOCKS handshake";
   private static final long field25303 = 10000L;
   private static final String field25304 = "SOCKS5 credentials are too long";
   private static final String field25305 = "Missing destination address for SOCKS5";
   private static final int field25306 = 65535;
   private static final String field25307 = "Missing destination address for SOCKS4";
   private static final int field25308 = 65535;
   private static final String field25309 = "SOCKS handshake timeout";

   public void channelActive(ChannelHandlerContext var1) throws Exception {
      this.scheduleHandshakeTimeout(var1);
      if (this.field25291.method03901() == ProxyConfig.Nested114.SOCKS5) {
         this.sendSocks5MethodRequest(var1);
         this.field25296 = SocksHandshakeHandler.Nested320.SOCKS5_METHOD;
      } else {
         this.sendSocks4ConnectRequest(var1);
         this.field25296 = SocksHandshakeHandler.Nested320.SOCKS4_CONNECT;
      }
   }

   private void releaseHandshakeBuffer() {
      if (this.field25299 != null) {
         this.field25299.release();
         this.field25299 = null;
      }
   }

   private boolean processSocks5AuthResponse(ChannelHandlerContext var1) {
      if (!this.readable(2)) {
         return false;
      } else {
         int var2 = this.readUnsignedByte();
         int var3 = this.readUnsignedByte();
         if (var2 == 1 && var3 == 0) {
            this.sendSocks5ConnectRequest(var1);
            this.field25296 = SocksHandshakeHandler.Nested320.SOCKS5_CONNECT;
            return true;
         } else {
            this.failHandshake(var1, new IOException("SOCKS5 authentication failed with status: " + var3));
            return false;
         }
      }
   }

   private boolean processSocks5ConnectResponse(ChannelHandlerContext var1) {
      if (!this.readable(5)) {
         return false;
      }

      int var2 = this.field25299.readerIndex();
      short var3 = this.field25299.getUnsignedByte(var2);
      short var4 = this.field25299.getUnsignedByte(var2 + 1);
      short var5 = this.field25299.getUnsignedByte(var2 + 3);
      int var6;
      if (var5 == 1) {
         var6 = 10;
      } else if (var5 == 4) {
         var6 = 22;
      } else {
         if (var5 != 3) {
            this.failHandshake(var1, new IOException("Unsupported SOCKS5 address type: " + var5));
            return false;
         }

         if (!this.readable(5)) {
            return false;
         }

         short var7 = this.field25299.getUnsignedByte(var2 + 4);
         var6 = 7 + var7;
      }

      if (!this.readable(var6)) {
         return false;
      } else {
         this.field25299.skipBytes(var6);
         if (var3 == 5 && var4 == 0) {
            this.completeHandshake(var1);
            return false;
         } else {
            this.failHandshake(var1, new IOException("SOCKS5 connect failed with reply code: " + var4));
            return false;
         }
      }
   }

   private int readUnsignedByte() {
      return this.field25299.readUnsignedByte();
   }

   private void appendHandshakeData(ChannelHandlerContext var1, ByteBuf var2) {
      if (this.field25299 == null) {
         this.field25299 = var1.alloc().buffer(var2.readableBytes());
      }

      this.field25299.writeBytes(var2, var2.readerIndex(), var2.readableBytes());
   }

   private void completeHandshake(ChannelHandlerContext var1) {
      this.field25296 = SocksHandshakeHandler.Nested320.CONNECTED;
      this.cancelHandshakeTimeout();
      this.field25293.trySuccess(null);
      this.writePending(var1);
      this.flushIfPending(var1);
      ByteBuf var2 = null;
      if (this.field25299 != null && this.field25299.isReadable()) {
         var2 = this.field25299.readRetainedSlice(this.field25299.readableBytes());
      }

      this.releaseHandshakeBuffer();
      var1.pipeline().remove(this);
      if (this.field25294 != null) {
         this.field25294.trySuccess();
      }

      var1.fireChannelActive();
      if (var2 != null) {
         var1.fireChannelRead(var2);
      }
   }

   private boolean processSocks5MethodResponse(ChannelHandlerContext var1) {
      if (!this.readable(2)) {
         return false;
      } else {
         int var2 = this.readUnsignedByte();
         int var3 = this.readUnsignedByte();
         if (var2 != 5) {
            this.failHandshake(var1, new IOException("Invalid SOCKS5 method response version: " + var2));
            return false;
         } else if (var3 == 0) {
            this.sendSocks5ConnectRequest(var1);
            this.field25296 = SocksHandshakeHandler.Nested320.SOCKS5_CONNECT;
            return true;
         } else if (var3 == 2) {
            this.sendSocks5AuthRequest(var1);
            this.field25296 = SocksHandshakeHandler.Nested320.SOCKS5_AUTH;
            return true;
         } else {
            this.failHandshake(var1, new IOException("SOCKS5 proxy rejected authentication method: " + var3));
            return false;
         }
      }
   }

   private void processHandshake(ChannelHandlerContext var1) {
      if (this.field25299 != null) {
         boolean var2 = true;

         while (var2 && this.field25296 != SocksHandshakeHandler.Nested320.CONNECTED && this.field25296 != SocksHandshakeHandler.Nested320.FAILED) {
            var2 = switch (this.field25296) {
               case SOCKS5_METHOD -> this.processSocks5MethodResponse(var1);
               case SOCKS5_AUTH -> this.processSocks5AuthResponse(var1);
               case SOCKS5_CONNECT -> this.processSocks5ConnectResponse(var1);
               case SOCKS4_CONNECT -> this.processSocks4ConnectResponse(var1);
               default -> false;
            };
         }
      }
   }

   private static String normalized(String var0) {
      return var0 == null ? "" : var0;
   }

   private void sendSocks5AuthRequest(ChannelHandlerContext var1) {
      byte[] var2 = normalized(this.field25291.method03899()).getBytes(StandardCharsets.UTF_8);
      byte[] var3 = normalized(this.field25291.method03915()).getBytes(StandardCharsets.UTF_8);
      if (var2.length <= 255 && var3.length <= 255) {
         ByteBuf var4 = var1.alloc().buffer(3 + var2.length + var3.length);
         var4.writeByte(1);
         var4.writeByte(var2.length);
         var4.writeBytes(var2);
         var4.writeByte(var3.length);
         var4.writeBytes(var3);
         var1.writeAndFlush(var4);
      } else {
         this.failHandshake(var1, new IOException(field25304));
      }
   }

   public void channelInactive(ChannelHandlerContext var1) throws Exception {
      if (this.field25296 != SocksHandshakeHandler.Nested320.CONNECTED && this.field25296 != SocksHandshakeHandler.Nested320.FAILED) {
         this.failHandshake(var1, new IOException(field25302));
      } else {
         var1.fireChannelInactive();
      }
   }

   private void writePending(ChannelHandlerContext var1) {
      PendingWriteQueue var2 = this.field25297;
      if (var2 != null) {
         this.field25297 = null;
         var2.removeAndWriteAll();
      }
   }

   private void sendSocks4ConnectRequest(ChannelHandlerContext var1) {
      if (this.field25295 == null) {
         this.failHandshake(var1, new IOException(field25307));
      } else {
         int var2 = this.field25295.getPort();
         if (var2 >= 0 && var2 <= field25308) {
            InetAddress var3 = this.field25295.getAddress();
            String var4 = normalized(this.field25291.method03899());
            byte[] var5 = var4.getBytes(StandardCharsets.UTF_8);
            ByteBuf var6 = var1.alloc().buffer();
            var6.writeByte(4);
            var6.writeByte(1);
            var6.writeShort(var2);
            if (var3 instanceof Inet4Address var7) {
               var6.writeBytes(var7.getAddress());
               var6.writeBytes(var5);
               var6.writeByte(0);
            } else {
               String var8 = this.field25295.getHostString();
               byte[] var9 = var8.getBytes(StandardCharsets.US_ASCII);
               if (var9.length == 0) {
                  var6.release();
                  this.failHandshake(var1, new IOException("Invalid SOCKS4 destination host: " + var8));
                  return;
               }

               var6.writeInt(1);
               var6.writeBytes(var5);
               var6.writeByte(0);
               var6.writeBytes(var9);
               var6.writeByte(0);
            }

            var1.writeAndFlush(var6);
         } else {
            this.failHandshake(var1, new IOException("Invalid destination port: " + var2));
         }
      }
   }

   public void write(ChannelHandlerContext var1, Object var2, ChannelPromise var3) throws Exception {
      if (this.field25296 == SocksHandshakeHandler.Nested320.CONNECTED) {
         var1.write(var2, var3);
      } else if (this.field25296 == SocksHandshakeHandler.Nested320.FAILED) {
         var3.tryFailure(new IOException(field25301));
         ReferenceCountUtil.release(var2);
      } else {
         PendingWriteQueue var4 = this.field25297;
         if (var4 == null) {
            this.field25297 = var4 = new PendingWriteQueue(var1);
         }

         var4.add(var2, var3);
      }
   }

   public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
      if (this.field25296 != SocksHandshakeHandler.Nested320.CONNECTED && this.field25296 != SocksHandshakeHandler.Nested320.FAILED) {
         this.failHandshake(var1, var2);
      } else {
         var1.fireExceptionCaught(var2);
      }
   }

   private boolean hasCredentials() {
      return this.field25291.method03918();
   }

   private void sendSocks5MethodRequest(ChannelHandlerContext var1) {
      boolean var2 = this.hasCredentials();
      ByteBuf var3 = var1.alloc().buffer(var2 ? 4 : 3);
      var3.writeByte(5);
      if (var2) {
         var3.writeByte(2);
         var3.writeByte(0);
         var3.writeByte(2);
      } else {
         var3.writeByte(1);
         var3.writeByte(0);
      }

      var1.writeAndFlush(var3);
   }

   private boolean readable(int var1) {
      return this.field25299 != null && this.field25299.readableBytes() >= var1;
   }

   public void channelRead(ChannelHandlerContext var1, Object var2) throws Exception {
      if (this.field25296 == SocksHandshakeHandler.Nested320.CONNECTED) {
         var1.fireChannelRead(var2);
      } else if (var2 instanceof ByteBuf var3) {
         try {
            this.appendHandshakeData(var1, var3);
            this.processHandshake(var1);
         } finally {
            ReferenceCountUtil.release(var2);
         }
      } else {
         var1.fireChannelRead(var2);
      }
   }

   private void failPending(Throwable var1) {
      PendingWriteQueue var2 = this.field25297;
      if (var2 != null) {
         this.field25297 = null;
         var2.removeAndFailAll(var1);
      }
   }

   public void connect(ChannelHandlerContext var1, SocketAddress var2, SocketAddress var3, ChannelPromise var4) throws Exception {
      if (var2 instanceof InetSocketAddress var5) {
         this.field25295 = var5;
         this.field25294 = var4;
         ChannelPromise var6 = var1.newPromise();
         var6.addListener(var1x -> {
            if (!var1x.isSuccess()) {
               var4.tryFailure(var1x.cause());
            }
         });
         var1.connect(this.field25292, var3, var6);
      } else {
         var4.setFailure(new IOException("Unsupported destination socket address: " + var2));
      }
   }

   private void scheduleHandshakeTimeout(ChannelHandlerContext var1) {
      this.cancelHandshakeTimeout();
      this.field25300 = var1.executor().schedule(() -> {
         if (this.field25296 != SocksHandshakeHandler.Nested320.CONNECTED && this.field25296 != SocksHandshakeHandler.Nested320.FAILED) {
            this.failHandshake(var1, new IOException(field25309));
         }
      }, field25303, TimeUnit.MILLISECONDS);
   }

   SocksHandshakeHandler(ProxyConfig var1, InetSocketAddress var2, Promise<Void> var3) {
      this.field25291 = var1;
      this.field25292 = var2;
      this.field25293 = var3;
   }

   public void flush(ChannelHandlerContext var1) throws Exception {
      if (this.field25296 == SocksHandshakeHandler.Nested320.CONNECTED) {
         var1.flush();
      } else {
         if (this.field25296 != SocksHandshakeHandler.Nested320.FAILED) {
            this.field25298 = true;
         }
      }
   }

   private void sendSocks5ConnectRequest(ChannelHandlerContext var1) {
      if (this.field25295 == null) {
         this.failHandshake(var1, new IOException(field25305));
      } else {
         int var2 = this.field25295.getPort();
         if (var2 >= 0 && var2 <= field25306) {
            InetAddress var3 = this.field25295.getAddress();
            String var4 = this.field25295.getHostString();
            ByteBuf var5 = var1.alloc().buffer();
            var5.writeByte(5);
            var5.writeByte(1);
            var5.writeByte(0);
            if (var3 instanceof Inet4Address var6) {
               var5.writeByte(1);
               var5.writeBytes(var6.getAddress());
            } else if (var3 instanceof Inet6Address var7) {
               var5.writeByte(4);
               var5.writeBytes(var7.getAddress());
            } else {
               byte[] var8 = var4.getBytes(StandardCharsets.US_ASCII);
               if (var8.length == 0 || var8.length > 255) {
                  var5.release();
                  this.failHandshake(var1, new IOException("Invalid SOCKS5 destination host: " + var4));
                  return;
               }

               var5.writeByte(3);
               var5.writeByte(var8.length);
               var5.writeBytes(var8);
            }

            var5.writeShort(var2);
            var1.writeAndFlush(var5);
         } else {
            this.failHandshake(var1, new IOException("Invalid destination port: " + var2));
         }
      }
   }

   public void handlerRemoved(ChannelHandlerContext var1) throws Exception {
      this.releaseHandshakeBuffer();
      this.cancelHandshakeTimeout();
      super.handlerRemoved(var1);
   }

   private boolean processSocks4ConnectResponse(ChannelHandlerContext var1) {
      if (!this.readable(8)) {
         return false;
      } else {
         int var2 = this.readUnsignedByte();
         int var3 = this.readUnsignedByte();
         this.field25299.skipBytes(6);
         if (var2 == 0 && var3 == 90) {
            this.completeHandshake(var1);
            return false;
         } else {
            this.failHandshake(var1, new IOException("SOCKS4 connect failed with reply code: " + var3));
            return false;
         }
      }
   }

   private void cancelHandshakeTimeout() {
      var var1 = this.field25300;
      this.field25300 = null;
      if (var1 != null) {
         var1.cancel(false);
      }
   }

   private void failHandshake(ChannelHandlerContext var1, Throwable var2) {
      if (this.field25296 != SocksHandshakeHandler.Nested320.FAILED) {
         this.field25296 = SocksHandshakeHandler.Nested320.FAILED;
         this.cancelHandshakeTimeout();
         this.field25293.tryFailure(var2);
         this.failPending(var2);
         this.releaseHandshakeBuffer();
         if (this.field25294 != null) {
            this.field25294.tryFailure(var2);
         }

         var1.close();
      }
   }

   private void flushIfPending(ChannelHandlerContext var1) {
      if (this.field25298) {
         this.field25298 = false;
         var1.flush();
      }
   }

   // $VF: Compiled from s
   private enum Nested320 {
      SOCKS5_METHOD,
      SOCKS5_AUTH,
      SOCKS5_CONNECT,
      SOCKS4_CONNECT,
      CONNECTED,
      FAILED;
   }
}
