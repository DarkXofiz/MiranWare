// Original binary: sg/ec/EokAM9s0J3KAuS1V
package sg.ec;

import hex.script.api.Script;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

// $VF: Compiled from s
public final class ScriptLifecycle {
   private static final Map<Script, ScriptSourceLoader> field07217 = new IdentityHashMap<>();
   private static final List<ScriptSourceLoader> field07218 = new ArrayList<>();
   private static ScriptSourceLoader field07219;
   private static final String field07220 = "This is a utility class and cannot be instantiated";

   public static void method03293(ScriptSourceLoader var0) {
      field07219 = var0;
   }

   public static ScriptSourceLoader method03294(Object var0) {
      ScriptSourceLoader var1 = field07219;
      ScriptSourceLoader var2 = method03298(var0);
      if (var2 != null) {
         field07219 = var2;
      }

      return var1;
   }

   static void method03295() {
      field07217.clear();

      for (ScriptSourceLoader var1 : field07218) {
         var1.method08392();
      }

      field07218.clear();
      field07219 = null;
   }

   static void method03296(List<ScriptSourceLoader> var0) {
      field07218.clear();
      field07218.addAll(var0);
   }

   private ScriptLifecycle() {
      throw new UnsupportedOperationException(field07220);
   }

   static void method03297(Script var0, ScriptSourceLoader var1) {
      if (var0 != null && var1 != null) {
         field07217.put(var0, var1);
      }
   }

   public static ScriptSourceLoader method03298(Object var0) {
      return var0 instanceof Script var1 ? field07217.get(var1) : null;
   }

   public static List<ScriptSourceLoader> method03299() {
      return field07218;
   }

   public static ScriptSourceLoader method03300() {
      return field07219;
   }

   public static ScriptSourceLoader method03301(String var0) {
      ScriptSourceLoader var1 = field07219;
      if (var1 != null && var1.method08388(var0)) {
         return var1;
      }

      for (ScriptSourceLoader var3 : field07218) {
         if (var3.method08388(var0)) {
            return var3;
         }
      }

      return var1;
   }
}
