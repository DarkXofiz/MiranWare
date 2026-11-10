// Original binary: sg/ec/U0BsFPhp1Yb1k0uc
package sg.ec;

import hex.script.api.Script;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// $VF: Compiled from s
public final class ScriptDirectoryWatcher {
   static final String field12104 = "scripts";
   private static final long field12105 = 0;
   private final File field12106;
   private final List<String> field12107;
   private final Set<String> field12108;
   private int field12109;
   private int field12110;
   private int field12111;
   private final ScriptCompiler field12112;
   private final ScriptCompiler field12113;
   private final ElapsedTimer field12114;
   private ScriptClassLoader field12115;
   private long field12116;
   private long field12117;
   private static final String field12118 = "scripts";
   private static final double field12119 = 1000.0;
   private static final long field12120 = 1125899906842597L;
   private static final long field12121 = 31L;
   private static final long field12122 = 31L;
   private static final long field12123 = 31L;

   public int method05734() {
      return this.field12110;
   }

   public Set<String> method05735() {
      return this.field12108;
   }

   private List<ScriptSourceLoader> method05736(List<File> var1) {
      ArrayList var2 = new ArrayList();
      HashSet var3 = new HashSet();

      for (File var5 : var1) {
         ScriptSourceLoader var6 = ScriptSourceLoader.method08395(var5, this.field12107);
         if (var6 != null) {
            if (!var3.add(var6.method08400())) {
               this.field12107.add(var5.getName() + ": имя " + var6.method08400() + " уже занято");
               var6.method08392();
            } else {
               var2.add(var6);
            }
         }
      }

      return var2;
   }

   public File method05737() {
      return this.field12106;
   }

   private Script method05738(String var1) {
      Class var2;
      try {
         var2 = Class.forName(var1, false, this.field12115);
      } catch (Throwable var6) {
         this.field12107.add(var1 + ": не загружается — " + this.method05747(var6));
         return null;
      }

      if (!Script.class.isAssignableFrom(var2)) {
         var var7 = var2.getSuperclass();
         if (var7 != null && var7.getName().equals(Script.class.getName())) {
            this.field12107.add(var1 + ": SDK загружен дважды — " + Script.class.getName() + " приехал не из клиента");
         }

         return null;
      } else {
         if (Modifier.isAbstract(var2.getModifiers())) {
            return null;
         }

         try {
            var var3 = var2.getDeclaredConstructor();
            var3.setAccessible(true);
            return (Script)var3.newInstance();
         } catch (NoSuchMethodException var4) {
            this.field12107.add(var1 + ": нужен конструктор без аргументов");
         } catch (Throwable var5) {
            this.field12107.add(var1 + ": упал конструктор — " + this.method05747(var5));
         }

         return null;
      }
   }

   public int method05739() {
      return this.field12109;
   }

   private void method05740(List<ScriptSourceLoader> var1) {
      this.field12108.clear();
      this.field12108.addAll(ScriptMixinManager.method08298(var1));
      ArrayList var2 = new ArrayList();

      for (ScriptSourceLoader var4 : var1) {
         if (this.field12108.contains(var4.method08400()) && !var4.method08402(ScriptSourceType.MIXIN).isEmpty()) {
            var2.add(var4);
         }
      }

      if (!var2.isEmpty()) {
         this.field12113.method11730(var2);
         this.field12107.addAll(this.field12113.method11727());
         ScriptMixinManager.method08300(this.field12113, this.field12107);
      }
   }

   List<Script> method05741() {
      this.field12107.clear();
      this.method05748();
      this.method05745();
      var var1 = ScriptSourceLoader.method08399(this.field12106);
      this.field12116 = this.method05746(var1);
      this.field12117 = this.field12116;
      var var2 = this.method05736(var1);
      this.field12109 = var2.size();
      this.field12110 = 0;

      for (ScriptSourceLoader var4 : var2) {
         this.field12110 = this.field12110 + var4.method08402(ScriptSourceType.CODE).size();
      }

      this.method05740(var2);
      ScriptLifecycle.method03296(var2);
      ScriptManager.method01297(var2);
      this.field12112.method11730(var2);
      this.field12107.addAll(this.field12112.method11727());
      var var10 = this.field12112.method11737().keySet();
      this.field12111 = var10.size();
      if (var10.isEmpty()) {
         return List.of();
      }

      this.field12115 = new ScriptClassLoader(ScriptDirectoryWatcher.class.getClassLoader(), new HashSet<>(var10), this.field12112::method11734);
      ArrayList var11 = new ArrayList();

      for (ScriptSourceLoader var6 : var2) {
         for (String var8 : this.method05742(var6.method08393())) {
            Script var9 = this.method05738(var8);
            if (var9 != null) {
               ScriptLifecycle.method03297(var9, var6);
               var11.add(var9);
            }
         }
      }

      return var11;
   }

   private List<String> method05742(Set<String> var1) {
      ArrayList var2 = new ArrayList(var1);
      var2.sort(Comparator.naturalOrder());
      return var2;
   }

   public ScriptDirectoryWatcher() {
      this.field12106 = new File(ClientEnvironment.field07577, field12118);
      this.field12107 = new ArrayList<>();
      this.field12108 = new LinkedHashSet<>();
      this.field12112 = new ScriptCompiler(this.field12106, ScriptSourceType.CODE);
      this.field12113 = new ScriptCompiler(this.field12106, ScriptSourceType.MIXIN);
      this.field12114 = new ElapsedTimer();
   }

   public List<String> method05743() {
      return this.field12107;
   }

   public int method05744() {
      return this.field12111;
   }

   void method05745() {
      ScriptLifecycle.method03295();
      if (this.field12115 != null) {
         try {
            this.field12115.close();
         } catch (IOException var2) {
         }

         this.field12115 = null;
      }
   }

   private long method05746(List<File> var1) {
      long var2 = field12120;

      for (File var5 : var1) {
         var2 = var2 * field12121 + var5.getName().hashCode();
         var2 = var2 * field12122 + var5.lastModified();
         var2 = var2 * field12123 + var5.length();
      }

      return var2;
   }

   private String method05747(Throwable var1) {
      Throwable var2 = var1.getCause() == null ? var1 : var1.getCause();
      String var3 = var2.getMessage();
      return var2.getClass().getSimpleName() + (var3 == null ? "" : ": " + var3);
   }

   void method05748() {
      if (!this.field12106.exists()) {
         this.field12106.mkdirs();
      }
   }

   boolean method05749() {
      if (!this.field12114.method04698(field12119)) {
         return false;
      }

      long var1 = this.method05746(ScriptSourceLoader.method08399(this.field12106));
      boolean var3 = var1 == this.field12117;
      this.field12117 = var1;
      return var3 && var1 != this.field12116;
   }
}
