// Original binary: sg/ec/UyLVFCH0smg6sCYv
package sg.ec;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

// $VF: Compiled from s
public final class ScriptClassLoader extends URLClassLoader {
   private final Set<String> field12682;
   private final Function<String, byte[]> field12683;
   private static final String field12684 = "hex-scripts";
   private static final String field12685 = "; ";

   @Override
   public URL getResource(String var1) {
      return null;
   }

   @Override
   protected Class<?> findClass(String var1) throws ClassNotFoundException {
      byte[] var2 = this.method05928(var1);
      if (var2 == null) {
         throw new ClassNotFoundException(var1);
      } else {
         var var3 = ClassBytecodeRemapper.method01624(var1, var2, this.field12682, ScriptSourceType.CODE);
         if (!var3.isEmpty()) {
            throw new ClassNotFoundException(String.join(field12685, var3));
         } else {
            return this.defineClass(var1, var2, 0, var2.length);
         }
      }
   }

   ScriptClassLoader(ClassLoader var1, Set<String> var2, Function<String, byte[]> var3) {
      super(field12684, new URL[0], var1);
      this.field12682 = var2;
      this.field12683 = var3;
   }

   @Override
   public Enumeration<URL> getResources(String var1) {
      return Collections.emptyEnumeration();
   }

   private Class<?> method05927(String var1) throws ClassNotFoundException {
      String var2 = var1.replace('.', '/');
      if (ScriptClassAccessPolicy.method04730(var2)) {
         return this.getParent().loadClass(var1);
      } else if (this.field12682.contains(var1)) {
         return this.findClass(var1);
      } else if (ScriptClassAccessPolicy.method04732(ScriptSourceType.CODE, var2)) {
         return this.getParent().loadClass(var1);
      } else {
         throw new ClassNotFoundException(var1 + " запрещён в скриптах");
      }
   }

   static {
      registerAsParallelCapable();
   }

   private byte[] method05928(String var1) {
      return this.field12683.apply(var1);
   }

   @Override
   protected Class<?> loadClass(String var1, boolean var2) throws ClassNotFoundException {
      synchronized (this.getClassLoadingLock(var1)) {
         var var4 = this.findLoadedClass(var1);
         if (var4 == null) {
            var4 = this.method05927(var1);
         }

         if (var2) {
            this.resolveClass(var4);
         }

         return var4;
      }
   }
}
