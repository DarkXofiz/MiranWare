// Original binary: sg/ec/0LzaNKeNNbGsbzz8
package sg.ec;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

// $VF: Compiled from s
public final class CompressedFrameCodec {
   private static final byte[] field00103 = new byte[]{72, 90, 67, 49};
   private static final int field00104 = 5242880;
   private static final int field00105 = 5242880;
   private static final int field00106 = 5242880;

   public static byte[] method00057(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         Deflater var1 = new Deflater(9);
         var1.setInput(var0);
         var1.finish();
         ByteArrayOutputStream sx = new ByteArrayOutputStream(Math.max(16, var0.length / 2));
         sx.write(field00103, 0, field00103.length);
         byte[] sxx = new byte[4096];

         while (!var1.finished()) {
            int sxxx = var1.deflate(sxx);
            sx.write(sxx, 0, sxxx);
         }

         var1.end();
         byte[] sxxx = sx.toByteArray();
         return sxxx.length < var0.length + field00103.length ? sxxx : var0;
      } else {
         return var0;
      }
   }

   private CompressedFrameCodec() {
   }

   public static byte[] method00058(byte[] var0) {
      if (var0 != null && var0.length >= field00103.length) {
         for (int var1 = 0; var1 < field00103.length; var1++) {
            if (var0[var1] != field00103[var1]) {
               return var0;
            }
         }

         Inflater var11 = new Inflater();
         var11.setInput(var0, field00103.length, var0.length - field00103.length);
         ByteArrayOutputStream var2 = new ByteArrayOutputStream(Math.min(field00105, Math.max(16, var0.length * 3)));
         byte[] var3 = new byte[4096];

         try {
            while (!var11.finished()) {
               int var4 = var11.inflate(var3);
               if (var4 == 0 && (var11.finished() || var11.needsInput())) {
                  break;
               }

               if (var2.size() + var4 > field00106) {
                  return var0;
               }

               var2.write(var3, 0, var4);
            }
         } catch (DataFormatException var9) {
            return var0;
         } finally {
            var11.end();
         }

         return var2.toByteArray();
      } else {
         return var0;
      }
   }
}
