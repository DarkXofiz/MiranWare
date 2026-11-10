// Original binary: sg/ec/fkmJyqsWOfQjOyBX
package sg.ec;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.impl.launch.FabricLauncherBase;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

// $VF: Compiled from s
public final class ScriptMixinManager {
   public static final String field19149 = "scriptmixin";
   private static final String field19150 = "field19150";
   static final String field19151 = "field19151";
   private static final Map<String, Map<String, String>> field19152 = new HashMap<>();
   private static final List<String> field19153 = new ArrayList<>();
   private static final List<String> field19154 = new ArrayList<>();
   private static boolean field19155;
   private static final String field19156 = "Hex";
   private static final String field19157 = "scripts";
   private static final String field19158 = "scriptmixin";
   private static final String field19159 = ".mixins";
   private static final String field19160 = "This is a utility class and cannot be instantiated";

   private static List<ScriptSourceLoader> method08294(File var0) {
      List<ScriptSourceLoader> var1 = new ArrayList<>();

      for (File sx : ScriptSourceLoader.method08399(var0)) {
         ScriptSourceLoader sxx = ScriptSourceLoader.method08401(sx, field19154);
         if (sxx != null && !sxx.method08402(ScriptSourceType.MIXIN).isEmpty()) {
            var1.add(sxx);
         }
      }

      return var1;
   }

   private static Path method08295(File var0, Map<String, byte[]> var1) throws IOException {
      File var2 = new File(var0, field19159);
      ScriptCompiler.method11729(var2);
      Path var3 = var2.toPath();

      for (var var5 : var1.entrySet()) {
         Path var6 = var3.resolve(((String)var5.getKey()).replace('.', '/') + ".class");
         Files.createDirectories(var6.getParent());
         Files.write(var6, (byte[])var5.getValue());
      }

      return var3;
   }

   public static List<String> method08297() {
      return Collections.unmodifiableList(field19153);
   }

   static Set<String> method08298(List<ScriptSourceLoader> var0) {
      LinkedHashSet var1 = new LinkedHashSet();
      HashSet var2 = new HashSet();

      for (ScriptSourceLoader var4 : var0) {
         var2.add(var4.method08400());
         if (!field19152.getOrDefault(var4.method08400(), Map.of()).equals(var4.method08402(ScriptSourceType.MIXIN))) {
            var1.add(var4.method08400());
         }
      }

      for (String var6 : field19152.keySet()) {
         if (!var2.contains(var6)) {
            var1.add(var6);
         }
      }

      return var1;
   }

   static List<String> method08299() {
      return field19154;
   }

   static Map<String, byte[]> method08300(ScriptCompiler var0, List<String> var1) {
      HashMap<String, Set<String>> var2 = new HashMap<>();

      for (var var4 : var0.method11735().entrySet()) {
         var2.computeIfAbsent((String)var4.getValue(), var0x -> new HashSet<>()).add((String)var4.getKey());
      }

      LinkedHashMap var11 = new LinkedHashMap();
      LinkedHashSet<String> var12 = new LinkedHashSet<>();

      for (var var6 : var0.method11737().entrySet()) {
         String var7 = (String)var6.getKey();
         String var8 = var0.method11735().get(var7);
         if (var8 == null) {
            var1.add("миксин " + var7 + " не удалось отнести к скрипту");
         } else {
            String var9 = "scriptmixin." + var8;
            if (!var7.startsWith(var9 + ".")) {
               var1.add(var8 + ": " + var7 + " должен лежать в пакете " + var9);
            } else if (!method08303((byte[])var6.getValue())) {
               var1.add(var8 + ": " + var7 + " без @Mixin, в mixin/ кладут только миксины");
            } else {
               var var10 = ClassBytecodeRemapper.method01624(var7, (byte[])var6.getValue(), (Set<String>)var2.get(var8), ScriptSourceType.MIXIN);
               if (!var10.isEmpty()) {
                  var1.addAll(var10);
                  var12.add(var8);
               } else {
                  var11.put(var7, (byte[])var6.getValue());
               }
            }
         }
      }

      for (String var14 : (Iterable<String>) (Iterable) var12) {
         var1.add(var14 + ": миксины скрипта не вшиты — нарушение песочницы");
      }

      var11.keySet().removeIf(var2x -> var12.contains(var0.method11735().get(var2x)));
      return var11;
   }

   public static void method08302() {
      if (!field19155) {
         field19155 = true;
         File var0 = FabricLoader.getInstance().getGameDir().resolve(field19156).resolve(field19157).toFile();
         var var1 = method08294(var0);
         if (!var1.isEmpty()) {
            for (ScriptSourceLoader var3 : var1) {
               field19152.put(var3.method08400(), new HashMap<>(var3.method08402(ScriptSourceType.MIXIN)));
            }

            ScriptApiExporter.method03130(var0);
            ScriptCompiler var7 = new ScriptCompiler(var0, ScriptSourceType.MIXIN);
            var7.method11730(var1);
            field19154.addAll(var7.method11727());
            var1.forEach(ScriptSourceLoader::method08392);
            var var8 = method08300(var7, field19154);
            if (!var8.isEmpty()) {
               try {
                  FabricLauncherBase.getLauncher().addToClassPath(method08295(var0, var8));
               } catch (IOException var6) {
                  field19154.add("не удалось выложить классы миксинов — " + var6.getMessage());
                  return;
               }

               for (String var5 : var8.keySet()) {
                  field19153.add(var5.substring(field19158.length() + 1));
               }
            }
         }
      }
   }

   private static boolean method08303(byte[] var0) {
      ScriptMixinManager.Nested234 var1 = new ScriptMixinManager.Nested234();
      new ClassReader(var0).accept(var1, 7);
      return var1.field19161;
   }

   private ScriptMixinManager() {
      throw new UnsupportedOperationException(field19160);
   }

   // $VF: Compiled from s
   private static final class Nested234 extends ClassVisitor {
      private boolean field19161;
      private static final int field19162 = 589824;
      private static final String field19163 = "Lorg/spongepowered/asm/mixin/Mixin;";

      private Nested234() {
         super(field19162);
      }

      public AnnotationVisitor visitAnnotation(String var1, boolean var2) {
         this.field19161 = this.field19161 | field19163.equals(var1);
         return null;
      }
   }
}
