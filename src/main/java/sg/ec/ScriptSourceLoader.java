// Original binary: sg/ec/g2wNUHJ3fhnYUSDW
package sg.ec;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

// $VF: Compiled from s
public final class ScriptSourceLoader {
   private static final String field19340 = ".jar";
   private static final String field19341 = "field19341";
   private static final String field19342 = "field19342";
   private static final long field19343 = 0;
   private final String field19344;
   private final File field19345;
   private final Map<ScriptSourceType, Map<String, String>> field19346 = new EnumMap<>(ScriptSourceType.class);
   private final Map<String, byte[]> field19347 = new LinkedHashMap<>();
   private final Set<String> field19348 = new LinkedHashSet<>();
   private static final String field19349 = ".jar";
   private static final String field19350 = ".java";
   private static final String field19351 = "resources/";
   private static final long field19352 = 33554432L;
   private static final String field19353 = "resources/";
   private static final String field19354 = "/";
   private static final String field19355 = "/";
   private static final String field19356 = "script";

   private static ScriptSourceLoader method08386(File var0, boolean var1, List<String> var2) {
      ScriptSourceLoader var3 = new ScriptSourceLoader(method08390(var0), var0);

      try (JarFile sx = new JarFile(var0)) {
         for (JarEntry sxx : sx.stream().toList()) {
            var3.method08389(sx, sxx, var1, var2);
         }

         return var3;
      } catch (IOException sx) {
         var2.add(var0.getName() + ": не читается — " + sx.getMessage());
         return null;
      }
   }

   private static String method08387(String var0) {
      String var1 = var0.replace('\\', '/');

      while (var1.startsWith(field19354)) {
         var1 = var1.substring(1);
      }

      while (var1.endsWith(field19355)) {
         var1 = var1.substring(0, var1.length() - 1);
      }

      return var1;
   }

   boolean method08388(String var1) {
      return this.field19347.containsKey(var1);
   }

   private void method08389(JarFile var1, JarEntry var2, boolean var3, List<String> var4) {
      if (!var2.isDirectory()) {
         String var5 = var2.getName().replace('\\', '/');
         ScriptSourceType var6 = var5.endsWith(field19350) ? ScriptSourceType.method02857(var5) : null;
         boolean var7 = var3 ? var6 == ScriptSourceType.MIXIN : var6 != null || var5.startsWith(field19351);
         if (var7) {
            if (var2.getSize() > field19352) {
               var4.add(this.field19345.getName() + ": слишком большой файл " + var5);
            } else {
               byte[] var8;
               try (InputStream var9 = var1.getInputStream(var2)) {
                  var8 = var9.readAllBytes();
               } catch (IOException var14) {
                  var4.add(this.field19345.getName() + ": не читается " + var5 + " — " + var14.getMessage());
                  return;
               }

               if (var6 != null) {
                  this.field19346.get(var6).put(var5.substring(var6.method02856().length()), new String(var8, StandardCharsets.UTF_8));
               } else {
                  this.field19347.put(var5.substring(field19353.length()), var8);
               }
            }
         }
      }
   }

   private static String method08390(File var0) {
      String var1 = var0.getName();
      int var2 = var1.lastIndexOf(46);
      if (var2 > 0) {
         var1 = var1.substring(0, var2);
      }

      StringBuilder var3 = new StringBuilder(var1.length());

      for (int var4 = 0; var4 < var1.length(); var4++) {
         char var5 = Character.toLowerCase(var1.charAt(var4));
         var3.append(!Character.isLetterOrDigit(var5) && var5 != '_' ? '_' : var5);
      }

      return var3.isEmpty() ? field19356 : var3.toString();
   }

   List<String> method08391(String var1) {
      String var2 = var1 != null && !var1.isEmpty() ? method08387(var1) + "/" : "";
      ArrayList var3 = new ArrayList();

      for (String var5 : this.field19347.keySet()) {
         if (var5.startsWith(var2)) {
            String var6 = var5.substring(var2.length());
            if (!var6.isEmpty() && var6.indexOf(47) < 0) {
               var3.add(var6);
            }
         }
      }

      return var3;
   }

   void method08392() {
      this.field19348.clear();

      for (var var2 : this.field19346.values()) {
         var2.clear();
      }

      this.field19347.clear();
   }

   Set<String> method08393() {
      return this.field19348;
   }

   Set<String> method08394() {
      return this.field19347.keySet();
   }

   static ScriptSourceLoader method08395(File var0, List<String> var1) {
      ScriptSourceLoader var2 = method08386(var0, false, var1);
      if (var2 != null && var2.method08402(ScriptSourceType.CODE).isEmpty()) {
         var1.add(var0.getName() + ": нет исходников в " + ScriptSourceType.CODE.method02856());
         var2.method08392();
         return null;
      } else {
         return var2;
      }
   }

   private ScriptSourceLoader(String var1, File var2) {
      this.field19344 = var1;
      this.field19345 = var2;

      for (ScriptSourceType var6 : ScriptSourceType.values()) {
         this.field19346.put(var6, new LinkedHashMap<>());
      }
   }

   void method08396(String var1) {
      this.field19348.add(var1);
   }

   byte[] method08397(String var1) {
      byte[] var2 = this.field19347.get(var1);
      return var2 == null ? null : (byte[])var2.clone();
   }

   boolean method08398(Class<?> var1) {
      return this.field19348.contains(var1.getName());
   }

   static List<File> method08399(File var0) {
      File[] var1 = var0.listFiles();
      if (var1 == null) {
         return List.of();
      }

      ArrayList var2 = new ArrayList();

      for (File var6 : var1) {
         if (var6.isFile() && var6.getName().toLowerCase().endsWith(field19349)) {
            var2.add(var6);
         }
      }

      var2.sort(Comparator.comparing(File::getName));
      return var2;
   }

   public String method08400() {
      return this.field19344;
   }

   static ScriptSourceLoader method08401(File var0, List<String> var1) {
      return method08386(var0, true, var1);
   }

   Map<String, String> method08402(ScriptSourceType var1) {
      return this.field19346.get(var1);
   }

   public File method08403() {
      return this.field19345;
   }
}
