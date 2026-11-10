// Original binary: sg/ec/onQTvUiSLnOrNztQ
package sg.ec;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

// $VF: Compiled from s
final class ScriptSourcePaths {
   private static final String field22254 = "resources/";
   private static final String field22255 = "field22255";
   private static final String field22256 = "field22256";
   private static final String field22257 = "/";
   private static final String field22258 = "resources/";
   private static final String field22259 = ".java";
   private static final String field22260 = "resources/";

   private static void method09893(File var0, Map<String, byte[]> var1) throws IOException {
      try (JarFile var2 = new JarFile(var0)) {
         for (JarEntry sx : var2.stream().toList()) {
            if (!sx.isDirectory()) {
               try (InputStream sxx = var2.getInputStream(sx)) {
                  var1.put(sx.getName().replace('\\', '/'), sxx.readAllBytes());
               }
            }
         }
      }
   }

   private ScriptSourcePaths() {
   }

   static String method09894(String var0) {
      String var1 = var0.replace('\\', '/');

      while (var1.startsWith(field22257)) {
         var1 = var1.substring(1);
      }

      return ScriptSourceType.method02857(var1) == null && !var1.startsWith(field22258)
         ? (var1.endsWith(field22259) ? ScriptSourceType.CODE.method02856() : field22260) + var1
         : var1;
   }

   static List<String> method09895(File var0, Map<String, String> var1, Collection<String> var2) throws IOException {
      LinkedHashMap var3 = new LinkedHashMap();
      if (var0.isFile()) {
         method09893(var0, var3);
      }

      for (String var5 : var2) {
         var3.remove(method09894(var5));
      }

      for (var var12 : var1.entrySet()) {
         var3.put(method09894((String)var12.getKey()), ((String)var12.getValue()).getBytes(StandardCharsets.UTF_8));
      }

      File var11 = new File(var0.getParentFile(), var0.getName() + ".tmp");

      try (JarOutputStream var13 = new JarOutputStream(Files.newOutputStream(var11.toPath()))) {
         for (java.util.Map.Entry var7 : (java.util.Set<java.util.Map.Entry>) var3.entrySet()) {
            var13.putNextEntry(new ZipEntry((String)var7.getKey()));
            var13.write((byte[])var7.getValue());
            var13.closeEntry();
         }
      }

      Files.move(var11.toPath(), var0.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
      return new ArrayList<>(var3.keySet());
   }
}
