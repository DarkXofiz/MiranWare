// Original binary: sg/ec/943wimMDVo5BUO2S
package sg.ec;

import hex.script.api.Hook;
import hex.script.api.HookHandler;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

// $VF: Compiled from s
final class ScriptHookDispatcher {
   private final Map<String, List<ScriptHookDispatcher.Nested58>> field05162 = new ConcurrentHashMap<>();

   void method02166(Object var1, String var2, HookHandler var3) {
      if (var1 != null && var2 != null && var3 != null) {
         this.field05162.computeIfAbsent(var2, var0 -> new CopyOnWriteArrayList<>()).add(new ScriptHookDispatcher.Nested58(var1, var3));
      }
   }

   Hook method02168(String var1, Object[] var2) {
      var var3 = var1 == null ? null : this.field05162.get(var1);
      if (var3 != null && !var3.isEmpty()) {
         Hook var4 = new Hook(var1, var2);

         for (ScriptHookDispatcher.Nested58 var6 : var3) {
            ScriptSourceLoader var7 = ScriptLifecycle.method03294(var6.owner());

            try {
               var6.handler().handle(var4);
            } catch (Throwable var12) {
               ScriptRuntime.INSTANCE.method06226(var6.owner(), var12);
            } finally {
               ScriptLifecycle.method03293(var7);
            }
         }

         return var4;
      } else {
         return Hook.NONE;
      }
   }

   boolean method02169(String var1) {
      var var2 = var1 == null ? null : this.field05162.get(var1);
      return var2 != null && !var2.isEmpty();
   }

   void method02170(Object var1) {
      for (var var3 : this.field05162.values()) {
         var3.removeIf(var1x -> var1x.owner() == var1);
      }
   }

   // $VF: Compiled from s
   private record Nested58(Object owner, HookHandler handler) {
   }
}
