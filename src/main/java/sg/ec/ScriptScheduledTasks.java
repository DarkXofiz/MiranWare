// Original binary: sg/ec/aaBD2pFzlS2WuHtc
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

// $VF: Compiled from s
public final class ScriptScheduledTasks {
   private static final List<ScriptScheduledTasks.Nested203> field15670 = new CopyOnWriteArrayList<>();
   private static final AtomicInteger field15671 = new AtomicInteger();

   private ScriptScheduledTasks() {
   }

   static void method06950() {
      if (!field15670.isEmpty()) {
         long var0 = System.currentTimeMillis();
         ArrayList var2 = null;

         for (int var3 = 0; var3 < field15670.size(); var3++) {
            ScriptScheduledTasks.Nested203 var4 = field15670.get(var3);
            if (var4.field15676 <= var0) {
               if (var2 == null) {
                  var2 = new ArrayList();
               }

               var2.add(var4);
            }
         }

         if (var2 != null) {
            for (ScriptScheduledTasks.Nested203 var14 : (Iterable<ScriptScheduledTasks.Nested203>) (Iterable) var2) {
               if (var14.field15677 > 0) {
                  var14.field15677--;
               }

               boolean var5 = var14.field15677 == 0 || var14.field15674 == 0L;
               if (var5) {
                  field15670.remove(var14);
               } else {
                  var14.field15676 = var0 + var14.field15674;
               }

               ScriptSourceLoader var6 = ScriptLifecycle.method03294(var14.field15673);

               try {
                  var14.field15675.run();
               } catch (Throwable var11) {
                  field15670.remove(var14);
                  ScriptRuntime.INSTANCE.method06226(var14.field15673, var11);
               } finally {
                  ScriptLifecycle.method03293(var6);
               }
            }
         }
      }
   }

   static int method06951(Object var0) {
      int var1 = field15670.size();
      field15670.removeIf(var1x -> var1x.field15673 == var0);
      return var1 - field15670.size();
   }

   static boolean method06952(Object var0, int var1) {
      for (int var2 = 0; var2 < field15670.size(); var2++) {
         ScriptScheduledTasks.Nested203 var3 = field15670.get(var2);
         if (var3.field15672 == var1 && var3.field15673 == var0) {
            field15670.remove(var2);
            return true;
         }
      }

      return false;
   }

   static int method06953(Object var0, long var1, long var3, int var5, Runnable var6) {
      if (var0 != null && var6 != null) {
         ScriptScheduledTasks.Nested203 var7 = new ScriptScheduledTasks.Nested203(
            field15671.incrementAndGet(), var0, System.currentTimeMillis() + Math.max(0L, var1), Math.max(0L, var3), var5, var6
         );
         field15670.add(var7);
         return var7.field15672;
      } else {
         return -1;
      }
   }

   static int method06955() {
      return field15670.size();
   }

   // $VF: Compiled from s
   private static final class Nested203 {
      private final int field15672;
      private final Object field15673;
      private final long field15674;
      private final Runnable field15675;
      private long field15676;
      private int field15677;

      private Nested203(int var1, Object var2, long var3, long var5, int var7, Runnable var8) {
         this.field15672 = var1;
         this.field15673 = var2;
         this.field15676 = var3;
         this.field15674 = var5;
         this.field15677 = var7;
         this.field15675 = var8;
      }
   }
}
