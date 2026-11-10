// Original binary: sg/ec/c0a92rIwM0t7cTi9
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class TextureLoader {
   private static final String field17496 = TextureLoader.field17507.toLowerCase(Locale.ROOT);
   private static final String field17497 = "dynamic/crypto/";
   private static final Map<String, Identifier> field17498 = new ConcurrentHashMap<>();
   private static final Map<String, Identifier> field17499 = new ConcurrentHashMap<>();
   private static final String field17500 = "Identifier is null";
   private static final String field17501 = "Texture file path is null";
   private static final String field17502 = "dynamic/crypto/";
   private static final String field17503 = "missing/file_texture";
   private static final String field17504 = "missing/file_texture";
   private static final String field17505 = "-";
   private static final String field17506 = "This is a utility class and cannot be instantiated";
   private static final String field17507 = "Hex";

   public static Identifier method07204(Identifier var0) {
      if (var0 == null) {
         throw new IllegalArgumentException(field17500);
      }

      String var1 = "resource:" + var0;
      Identifier sx = field17498.get(var1);
      if (sx != null) {
         return sx;
      }

      Identifier sxx = method07219(var0);
      if (!method07217(var0, sxx)) {
         return sxx;
      }

      field17498.put(var1, sxx);
      return sxx;
   }

   private TextureLoader() {
      throw new UnsupportedOperationException(field17506);
   }

   private static Identifier method07206(Identifier var0) {
      Minecraft var1 = Minecraft.getInstance();
      if (var1 == null) {
         return var0;
      }

      try (InputStream var2 = var1.getResourceManager().getResource(var0).orElseThrow(() -> new IOException("Texture resource not found: " + var0)).open()) {
         byte[] var3 = var2.readAllBytes();
         byte[] var4 = EncryptedTextureUtils.method08948(var3) ? EncryptedTextureUtils.method08944(var3) : var3;
         return method07207(var1, var4, var0.toString());
      } catch (Exception var8) {
         return var0;
      }
   }

   private static Identifier method07207(Minecraft var0, byte[] var1, String var2) throws IOException {
      NativeImage var3 = NativeImage.read(new ByteArrayInputStream(var1));
      String var4 = UUID.nameUUIDFromBytes(var2.getBytes(StandardCharsets.UTF_8)).toString().replace(field17505, "");
      Identifier var5 = Identifier.fromNamespaceAndPath(field17496, "dynamic/crypto/" + var4);
      String var6 = "gif_texture_" + var2;
      DynamicTexture var7 = new DynamicTexture(() -> var6, var3);
      var0.getTextureManager().register(var5, var7);
      return var5;
   }

   private static Identifier method07208(Identifier var0) {
      Minecraft var1 = Minecraft.getInstance();
      if (var1 == null) {
         return null;
      }

      String var2 = var0.getNamespace();
      String var3 = var0.getPath();
      Identifier var4 = Identifier.fromNamespaceAndPath(var2, var3 + ".crypt");
      if (var1.getResourceManager().getResource(var4).isPresent()) {
         return var4;
      }

      int var5 = var3.lastIndexOf(46);
      if (var5 > 0) {
         Identifier var6 = Identifier.fromNamespaceAndPath(var2, var3.substring(0, var5) + ".crypt");
         if (var1.getResourceManager().getResource(var6).isPresent()) {
            return var6;
         }
      }

      return null;
   }

   public static Identifier method07209(String var0) {
      return method07216(Path.of(var0));
   }

   private static boolean method07210(Identifier var0) {
      Minecraft var1 = Minecraft.getInstance();
      return var1 == null ? false : var1.getResourceManager().getResource(var0).isPresent();
   }

   public static void method07211() {
      Minecraft var0 = Minecraft.getInstance();
      if (var0 != null) {
         method07215(var0, field17498.values());
         method07215(var0, field17499.values());
      }

      field17498.clear();
      field17499.clear();
   }

   private static Identifier method07213(Path var0) {
      Minecraft var1 = Minecraft.getInstance();
      if (var1 == null) {
         return Identifier.fromNamespaceAndPath(field17496, field17503);
      }

      try {
         byte[] var2 = Files.readAllBytes(var0);
         byte[] var3 = EncryptedTextureUtils.method08945(var0.getFileName().toString()) ? EncryptedTextureUtils.method08944(var2) : var2;
         return method07207(var1, var3, var0.toString());
      } catch (Exception var4) {
         return Identifier.fromNamespaceAndPath(field17496, field17504);
      }
   }

   private static void method07215(Minecraft var0, Collection<Identifier> var1) {
      for (Identifier var3 : var1) {
         if (var3 != null && field17496.equals(var3.getNamespace()) && var3.getPath().startsWith(field17502)) {
            var0.getTextureManager().release(var3);
         }
      }
   }

   public static Identifier method07216(Path var0) {
      if (var0 == null) {
         throw new IllegalArgumentException(field17501);
      }

      Path var1 = var0.toAbsolutePath().normalize();
      String var2 = "file:" + var1;
      return field17499.computeIfAbsent(var2, var1x -> method07213(var1));
   }

   private static boolean method07217(Identifier var0, Identifier var1) {
      return !var1.equals(var0) ? true : method07210(var0);
   }

   public static Identifier method07218(String var0, String var1) {
      return method07204(Identifier.fromNamespaceAndPath(var0.toLowerCase(Locale.ROOT), var1));
   }

   private static Identifier method07219(Identifier var0) {
      if (EncryptedTextureUtils.method08945(var0.getPath())) {
         return method07206(var0);
      } else {
         Identifier var1 = method07208(var0);
         if (var1 != null) {
            return method07206(var1);
         } else {
            return method07210(var0) ? method07206(var0) : var0;
         }
      }
   }

   public static Identifier method07220(String var0) {
      try {
         Path var1 = Path.of(var0);
         if (Files.exists(var1)) {
            return method07216(var1);
         }
      } catch (InvalidPathException var2) {
      }

      Identifier var3 = Identifier.tryParse(var0);
      return var3 != null ? method07204(var3) : method07218(field17496, var0);
   }
}
