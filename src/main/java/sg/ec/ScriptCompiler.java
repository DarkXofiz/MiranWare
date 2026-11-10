// Original binary: sg/ec/zUoOGwaCEARI5ZiM
package sg.ec;

import hex.script.api.Script;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileManager.Location;
import net.fabricmc.loader.impl.launch.FabricLauncherBase;
import org.eclipse.jdt.internal.compiler.tool.EclipseCompiler;

// $VF: Compiled from s
public final class ScriptCompiler {
   private static final String field27870 = "21";
   private static final String field27871 = "field27871";
   private final File field27872;
   private final File field27873;
   private final ScriptSourceType field27874;
   private final List<String> field27875 = new ArrayList<>();
   private final Set<ScriptCompiler.Nested332> field27876 = new HashSet<>();
   private final Map<String, byte[]> field27877 = new LinkedHashMap<>();
   private final Map<String, String> field27878 = new LinkedHashMap<>();
   private String field27879;
   private static final String field27880 = "script-api.jar";
   private static final String field27881 = ".cache";
   private static final String field27882 = "не найден script-api.jar — компиляция невозможна";
   private static final String field27883 = "-source";
   private static final String field27884 = "21";
   private static final String field27885 = "-target";
   private static final String field27886 = "21";
   private static final String field27887 = "-encoding";
   private static final String field27888 = "UTF-8";
   private static final String field27889 = "-nowarn";
   private static final String field27890 = "-proc:none";
   private static final String field27891 = "-classpath";
   private static final String field27892 = "java.class.path";
   private static final String field27893 = "SHA-256";
   private static final String field27894 = "jdt.compiler.useSingleThread";
   private static final String field27895 = "true";

   private void method11725(List<ScriptSourceLoader> var1) {
      if (this.field27874 != ScriptSourceType.MIXIN) {
         for (var var3 : this.field27878.entrySet()) {
            for (ScriptSourceLoader sx : var1) {
               if (sx.method08400().equals(var3.getValue())) {
                  sx.method08396(var3.getKey());
               }
            }
         }
      }
   }

   private void method11726() {
      this.field27877.clear();
      this.field27878.clear();
      this.field27879 = null;
   }

   public List<String> method11727() {
      return this.field27875;
   }

   ScriptCompiler(File var1, ScriptSourceType var2) {
      this.field27872 = var1;
      this.field27874 = var2;
      this.field27873 = ScriptApiExporter.method03131(var1, field27880);
      method11729(new File(var1, field27881));
   }

   private String method11728(List<ScriptCompiler.Nested332> var1) {
      try {
         MessageDigest var2 = MessageDigest.getInstance(field27893);
         var2.update(String.valueOf(30).getBytes(StandardCharsets.UTF_8));
         var var3 = new ArrayList<>(var1);
         var3.sort((var0, var1x) -> var0.method11740().compareTo(var1x.method11740()));

         for (ScriptCompiler.Nested332 var5 : (Iterable<ScriptCompiler.Nested332>) (Iterable) var3) {
            var2.update(var5.method11740().getBytes(StandardCharsets.UTF_8));
            var2.update(var5.field27905.getBytes(StandardCharsets.UTF_8));
         }

         return HexFormat.of().formatHex(var2.digest());
      } catch (Exception var6) {
         return null;
      }
   }

   static {
      System.setProperty(field27894, field27895);
   }

   static void method11729(File var0) {
      File[] var1 = var0.listFiles();
      if (var1 != null) {
         for (File var5 : var1) {
            method11729(var5);
         }
      }

      var0.delete();
   }

   boolean method11730(List<ScriptSourceLoader> var1) {
      this.field27875.clear();
      this.field27876.clear();
      ArrayList var2 = new ArrayList();

      for (ScriptSourceLoader var4 : var1) {
         for (var var6 : var4.method08402(this.field27874).entrySet()) {
            var2.add(new ScriptCompiler.Nested332(var4, this.field27874, (String)var6.getKey(), (String)var6.getValue()));
         }
      }

      if (var2.isEmpty()) {
         this.method11726();
         return true;
      }

      String var8 = this.method11728(var2);
      if (var8 != null && var8.equals(this.field27879) && !this.field27877.isEmpty()) {
         this.method11725(var1);
         return true;
      }

      File var9 = this.method11731();
      if (var9 == null) {
         this.field27875.add(field27882);
         return false;
      }

      this.field27879 = null;
      if (this.method11736(var9, var2)) {
         this.field27879 = var8;
         this.method11725(var1);
         return true;
      }

      ArrayList var10 = new ArrayList();

      for (ScriptCompiler.Nested332 var7 : (Iterable<ScriptCompiler.Nested332>) (Iterable) var2) {
         if (!this.field27876.contains(var7)) {
            var10.add(var7);
         }
      }

      if (!var10.isEmpty() && var10.size() != var2.size()) {
         this.field27875.add("не собрано файлов: " + (var2.size() - var10.size()) + ", остальные загружены");
         if (this.method11736(var9, var10)) {
            this.method11725(var1);
         } else {
            this.method11726();
         }

         return false;
      } else {
         this.method11726();
         return false;
      }
   }

   private File method11731() {
      if (ScriptApiExporter.method03130(this.field27872)) {
         return this.field27873;
      }

      try {
         Path var1 = Path.of(Script.class.getProtectionDomain().getCodeSource().getLocation().toURI());
         if (Files.exists(var1)) {
            return var1.toFile();
         }
      } catch (Throwable var2) {
      }

      return null;
   }

   private void method11733(DiagnosticCollector<JavaFileObject> var1) {
      for (Diagnostic var3 : var1.getDiagnostics()) {
         if (var3.getKind() == Kind.ERROR) {
            JavaFileObject var4 = (JavaFileObject)var3.getSource();
            if (var4 instanceof ScriptCompiler.Nested332 var5) {
               this.field27876.add(var5);
               this.field27875.add(var5.method11740() + ":" + var3.getLineNumber() + " — " + var3.getMessage(Locale.ROOT));
            } else {
               this.field27875.add(var3.getMessage(Locale.ROOT));
            }
         }
      }
   }

   byte[] method11734(String var1) {
      return this.field27877.get(var1);
   }

   Map<String, String> method11735() {
      return this.field27878;
   }

   private boolean method11736(File var1, List<ScriptCompiler.Nested332> var2) {
      this.field27877.clear();
      this.field27878.clear();
      EclipseCompiler var3 = new EclipseCompiler();
      DiagnosticCollector var4 = new DiagnosticCollector();
      StringWriter var5 = new StringWriter();
      IdentityHashMap var6 = new IdentityHashMap();

      for (ScriptCompiler.Nested332 var8 : var2) {
         var6.put(var8, var8.field27903.method08400());
      }

      try (
         StandardJavaFileManager var17 = var3.getStandardFileManager(var4, Locale.ROOT, StandardCharsets.UTF_8);
         ScriptCompiler.Nested330 var18 = new ScriptCompiler.Nested330(var17, this.field27877, this.field27878, var6, var2);
      ) {
         var17.setLocation(StandardLocation.SOURCE_PATH, List.of(this.field27872));
         var var9 = List.of(field27883, field27884, field27885, field27886, field27887, field27888, field27889, field27890, field27891, this.method11738(var1));
         boolean var10 = Boolean.TRUE.equals(var3.getTask(new PrintWriter(var5), var18, var4, var9, null, var2).call());
         this.method11733(var4);
         if (!var10 && this.field27875.isEmpty() && !var5.toString().isBlank()) {
            this.field27875.add(var5.toString().trim());
         }

         return var10;
      } catch (Throwable var16) {
         this.field27875.add("компилятор упал: " + var16);
         return false;
      }
   }

   Map<String, byte[]> method11737() {
      return this.field27877;
   }

   private String method11738(File var1) {
      LinkedHashSet var2 = new LinkedHashSet();
      var2.add(var1.getAbsolutePath());

      try {
         for (Path var4 : FabricLauncherBase.getLauncher().getClassPath()) {
            if (Files.exists(var4)) {
               var2.add(var4.toAbsolutePath().toString());
            }
         }
      } catch (Throwable var8) {
      }

      String var9 = System.getProperty(field27892);
      if (var9 != null) {
         for (String var7 : var9.split(Pattern.quote(File.pathSeparator))) {
            if (!var7.isBlank() && new File(var7).exists()) {
               var2.add(new File(var7).getAbsolutePath());
            }
         }
      }

      return String.join(File.pathSeparator, var2);
   }

   // $VF: Compiled from s
   private static final class Nested330 extends ForwardingJavaFileManager<StandardJavaFileManager> {
      private final Map<String, byte[]> field27896;
      private final Map<String, String> field27897;
      private final Map<JavaFileObject, String> field27898;
      private final List<ScriptCompiler.Nested332> field27899;

      @Override
      public boolean contains(Location var1, FileObject var2) throws IOException {
         if (var2 instanceof ScriptCompiler.Nested332) {
            return var1 == StandardLocation.SOURCE_PATH;
         }

         try {
            return super.contains(var1, var2);
         } catch (IllegalArgumentException var4) {
            return false;
         }
      }

      @Override
      public JavaFileObject getJavaFileForOutput(Location var1, String var2, javax.tools.JavaFileObject.Kind var3, FileObject var4) {
         String var5 = var2.replace('/', '.');
         String var6 = var4 == null ? null : this.field27898.get(var4);
         if (var6 == null) {
            var6 = this.method11739(var5);
         }

         if (var6 != null) {
            this.field27897.put(var5, var6);
         }

         return new ScriptCompiler.Nested331(var5, this.field27896);
      }

      private String method11739(String var1) {
         String var2 = var1.replace('.', '/');
         int var3 = var2.indexOf(36);
         if (var3 > 0) {
            var2 = var2.substring(0, var3);
         }

         String var4 = var2 + ".java";

         for (ScriptCompiler.Nested332 var6 : this.field27899) {
            if (var6.field27904.equals(var4)) {
               return var6.field27903.method08400();
            }
         }

         return null;
      }

      private Nested330(
         StandardJavaFileManager var1,
         Map<String, byte[]> var2,
         Map<String, String> var3,
         Map<JavaFileObject, String> var4,
         List<ScriptCompiler.Nested332> var5
      ) {
         super(var1);
         this.field27896 = var2;
         this.field27897 = var3;
         this.field27898 = var4;
         this.field27899 = var5;
      }
   }

   // $VF: Compiled from s
   private static final class Nested331 extends SimpleJavaFileObject {
      private final String field27901;
      private final Map<String, byte[]> field27902;

      @Override
      public OutputStream openOutputStream() {
         return new ByteArrayOutputStream()         // $VF: Compiled from s
 {
            @Override
            public void close() {
               Nested331.this.field27902.put(Nested331.this.field27901, this.toByteArray());
            }

            @Override
            public void flush() {
               Nested331.this.field27902.put(Nested331.this.field27901, this.toByteArray());
            }
         };
      }

      private Nested331(String var1, Map<String, byte[]> var2) {
         super(URI.create("script:///" + var1.replace('.', '/') + javax.tools.JavaFileObject.Kind.CLASS.extension), javax.tools.JavaFileObject.Kind.CLASS);
         this.field27901 = var1;
         this.field27902 = var2;
      }
   }

   // $VF: Compiled from s
   private static final class Nested332 extends SimpleJavaFileObject {
      private final ScriptSourceLoader field27903;
      private final String field27904;
      private final String field27905;
      private final String field27906;

      private String method11740() {
         return this.field27906;
      }

      @Override
      public CharSequence getCharContent(boolean var1) {
         return this.field27905;
      }

      private Nested332(ScriptSourceLoader var1, ScriptSourceType var2, String var3, String var4) {
         super(URI.create("script:///" + var1.method08400() + "/" + var3), javax.tools.JavaFileObject.Kind.SOURCE);
         this.field27903 = var1;
         this.field27904 = var3;
         this.field27905 = var4;
         this.field27906 = var1.method08400() + "/" + var2.method02856() + var3;
      }
   }
}
