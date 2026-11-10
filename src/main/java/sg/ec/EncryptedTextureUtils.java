// Original binary: sg/ec/jC57natZmn63Pmc6
package sg.ec;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

// $VF: Compiled from s
public final class EncryptedTextureUtils {
   public static final String field20368 = ".crypt";
   private static final byte[] field20369 = new byte[]{72, 88, 84, 88, 1};
   private static final String field20370 = "Source texture bytes are empty";
   private static final String field20371 = "Encrypted texture bytes are empty";
   private static final String field20372 = ".crypt";
   private static final String field20373 = ".crypt";
   private static final String field20374 = "This is a utility class and cannot be instantiated";

   private EncryptedTextureUtils() {
      throw new UnsupportedOperationException(field20374);
   }

   public static InputStream method08943(InputStream var0) throws IOException {
      if (var0 == null) {
         return null;
      }

      PushbackInputStream var1 = new PushbackInputStream(var0, field20369.length);
      byte[] var2 = new byte[field20369.length];
      int var3 = var1.readNBytes(var2, 0, var2.length);
      if (var3 == field20369.length && method08948(var2)) {
         byte[] var4;
         try (PushbackInputStream var5 = var1) {
            var4 = var5.readAllBytes();
         }

         return new ByteArrayInputStream(ResourceByteCodec.method06874(var4));
      } else {
         if (var3 > 0) {
            var1.unread(var2, 0, var3);
         }

         return var1;
      }
   }

   public static byte[] method08944(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         int var1 = method08948(var0) ? field20369.length : 0;
         return ResourceByteCodec.method06879(var0, var1, var0.length - var1);
      } else {
         throw new IllegalArgumentException(field20371);
      }
   }

   public static boolean method08945(String var0) {
      return var0 != null && var0.toLowerCase(Locale.ROOT).endsWith(field20372);
   }

   public static Path method08946(Path var0, Path var1) throws IOException {
      byte[] var2 = Files.readAllBytes(var0);
      byte[] var3 = method08950(var2);
      Path var4 = var1.getParent();
      if (var4 != null) {
         Files.createDirectories(var4);
      }

      Files.write(var1, var3);
      return var1;
   }

   public static Path method08947(Path var0) throws IOException {
      return method08946(var0, method08949(var0));
   }

   public static boolean method08948(byte[] var0) {
      if (var0 != null && var0.length >= field20369.length) {
         for (int var1 = 0; var1 < field20369.length; var1++) {
            if (var0[var1] != field20369[var1]) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static Path method08949(Path var0) {
      String var1 = var0.getFileName().toString();
      if (var1.endsWith(field20373)) {
         return var0.resolveSibling(var1);
      }

      int var2 = var1.lastIndexOf(46);
      if (var2 > 0) {
         var1 = var1.substring(0, var2) + ".crypt";
      } else {
         var1 = var1 + ".crypt";
      }

      return var0.resolveSibling(var1);
   }

   public static byte[] method08950(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         byte[] var1 = ResourceByteCodec.method06878(var0);
         byte[] var2 = new byte[field20369.length + var1.length];
         System.arraycopy(field20369, 0, var2, 0, field20369.length);
         System.arraycopy(var1, 0, var2, field20369.length, var1.length);
         return var2;
      } else {
         throw new IllegalArgumentException(field20370);
      }
   }
}
