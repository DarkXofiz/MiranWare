// Original binary: sg/ec/3FYK6fpDmYIQsRLb
package sg.ec;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

// $VF: Compiled from s
public final class PngEncoder {
   private static final byte[] field01540 = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
   private static final byte[] field01541 = new byte[]{73, 72, 68, 82};
   private static final byte[] field01542 = new byte[]{73, 68, 65, 84};
   private static final byte[] field01543 = new byte[]{73, 69, 78, 68};
   private static final int field01544 = 8;
   private static final int field01545 = 0;
   private static final int field01546 = 0;
   private static final String field01547 = "This is a utility class and cannot be instantiated";

   private PngEncoder() {
      throw new UnsupportedOperationException(field01547);
   }

   public static byte[] method00661(ByteBuffer var0, int var1, int var2) {
      byte[] var3 = new byte[var2 * (1 + var1 * 4)];

      for (int var4 = 0; var4 < var2; var4++) {
         int var5 = var4 * (1 + var1 * 4) + 1;

         for (int var6 = 0; var6 < var1 * 4; var6++) {
            var3[var5 + var6] = var0.get(var4 * var1 * 4 + var6);
         }
      }

      ByteArrayOutputStream var7 = new ByteArrayOutputStream(var3.length / 2 + 128);
      var7.writeBytes(field01540);
      method00663(var7, field01541, method00664(var1, var2));
      method00663(var7, field01542, method00665(var3));
      method00663(var7, field01543, new byte[0]);
      return var7.toByteArray();
   }

   private static void method00662(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)(var2 >>> 24);
      var0[var1 + 1] = (byte)(var2 >>> 16);
      var0[var1 + 2] = (byte)(var2 >>> 8);
      var0[var1 + 3] = (byte)var2;
   }

   private static void method00663(ByteArrayOutputStream var0, byte[] var1, byte[] var2) {
      byte[] var3 = new byte[4];
      method00662(var3, 0, var2.length);
      var0.writeBytes(var3);
      var0.writeBytes(var1);
      var0.writeBytes(var2);
      CRC32 var4 = new CRC32();
      var4.update(var1);
      var4.update(var2);
      byte[] var5 = new byte[4];
      method00662(var5, 0, (int)var4.getValue());
      var0.writeBytes(var5);
   }

   private static byte[] method00664(int var0, int var1) {
      byte[] var2 = new byte[13];
      method00662(var2, 0, var0);
      method00662(var2, 4, var1);
      var2[8] = 8;
      var2[9] = 6;
      return var2;
   }

   private static byte[] method00665(byte[] var0) {
      Deflater var1 = new Deflater(1);

      try {
         var1.setInput(var0);
         var1.finish();
         ByteArrayOutputStream var2 = new ByteArrayOutputStream(var0.length / 2 + 64);
         byte[] var3 = new byte[8192];

         while (!var1.finished()) {
            var2.write(var3, 0, var1.deflate(var3));
         }

         return var2.toByteArray();
      } finally {
         var1.end();
      }
   }
}
