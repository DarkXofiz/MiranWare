// Original binary: sg/ec/OURxNMlQQNiFIb9f
package sg.ec;

import hex.script.api.EventHandler;
import hex.script.api.ScriptEvent;
import hex.script.api.ScriptEvent.CancelOp;
import hex.script.api.ScriptEvent.CancelledOp;
import hex.script.api.event.Event;
import hex.script.api.event.EventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

// $VF: Compiled from s
public final class ScriptEventNames {
   static final String field10562 = "tick";
   static final String field10563 = "field10563";
   static final String field10564 = "field10564";
   static final String field10565 = "field10565";
   static final String field10566 = "field10566";
   static final String field10567 = "field10567";
   static final String field10568 = "field10568";
   static final String field10569 = "field10569";
   static final String field10570 = "field10570";
   static final String field10571 = "field10571";
   static final String field10572 = "field10572";
   static final String field10573 = "field10573";
   static final String field10574 = "field10574";
   static final String field10575 = "field10575";
   static final String field10576 = "field10576";
   static final String field10577 = "field10577";
   static final String field10578 = "field10578";
   static final String field10579 = "field10579";
   static final String field10580 = "field10580";
   static final String field10581 = "field10581";
   static final String field10582 = "field10582";
   static final String field10583 = "field10583";
   static final String field10584 = "field10584";
   static final String field10585 = "field10585";
   static final String field10586 = "field10586";
   static final String field10587 = "field10587";
   static final String field10588 = "field10588";
   static final String field10589 = "field10589";
   static final String field10590 = "field10590";
   static final String field10591 = "field10591";
   private static final String[] field10592 = new String[]{
      ScriptEventNames.field10596,
      ScriptEventNames.field10597,
      ScriptEventNames.field10598,
      ScriptEventNames.field10599,
      ScriptEventNames.field10600,
      ScriptEventNames.field10601,
      ScriptEventNames.field10602,
      ScriptEventNames.field10603,
      ScriptEventNames.field10604,
      ScriptEventNames.field10605,
      ScriptEventNames.field10606,
      ScriptEventNames.field10607,
      ScriptEventNames.field10608,
      ScriptEventNames.field10609,
      ScriptEventNames.field10610,
      ScriptEventNames.field10611,
      ScriptEventNames.field10612,
      ScriptEventNames.field10613,
      ScriptEventNames.field10614,
      ScriptEventNames.field10615,
      ScriptEventNames.field10616,
      ScriptEventNames.field10617,
      ScriptEventNames.field10618,
      ScriptEventNames.field10619,
      ScriptEventNames.field10620,
      ScriptEventNames.field10621,
      ScriptEventNames.field10622,
      ScriptEventNames.field10623,
      ScriptEventNames.field10624,
      ScriptEventNames.field10625
   };
   private final Map<String, List<ScriptEventNames.Nested140>> field10593 = new ConcurrentHashMap<>();
   private final Map<Class<?>, List<ScriptEventNames.Nested143>> field10594 = new ConcurrentHashMap<>();
   private final ThreadLocal<ScriptEventNames.Nested141> field10595 = ThreadLocal.withInitial(ScriptEventNames.Nested141::new);
   private static final String field10596 = "attack";
   private static final String field10597 = "chatReceive";
   private static final String field10598 = "clickSlot";
   private static final String field10599 = "death";
   private static final String field10600 = "destroyBlock";
   private static final String field10601 = "entityVelocity";
   private static final String field10602 = "gameTick";
   private static final String field10603 = "hotbarSelect";
   private static final String field10604 = "input";
   private static final String field10605 = "interactItem";
   private static final String field10606 = "joinWorld";
   private static final String field10607 = "jump";
   private static final String field10608 = "key";
   private static final String field10609 = "keyRelease";
   private static final String field10610 = "motion";
   private static final String field10611 = "mouse";
   private static final String field10612 = "move";
   private static final String field10613 = "newBlock";
   private static final String field10614 = "packetReceive";
   private static final String field10615 = "packetSend";
   private static final String field10616 = "placeBlock";
   private static final String field10617 = "postUpdate";
   private static final String field10618 = "render3d";
   private static final String field10619 = "sendMessage";
   private static final String field10620 = "slotChange";
   private static final String field10621 = "tick";
   private static final String field10622 = "toggleModule";
   private static final String field10623 = "update";
   private static final String field10624 = "useItem";
   private static final String field10625 = "useTotem";

   private void method04781(List<ScriptEventNames.Nested140> var1, Object var2) {
      if (var1 != null) {
         var1.removeIf(var1x -> var1x.field10626 == var2);
      }
   }

   boolean method04782(String var1, sg.ec.Event var2, Object var3, boolean var4) {
      var var5 = this.field10593.get(var1);
      if (var5 != null && !var5.isEmpty()) {
         ScriptEventNames.Nested141 var6 = this.field10595.get();
         ScriptEventNames.Nested142 var7 = var6.method04796();

         try {
            var7.field10635 = var2;
            var7.field10630.set(var1, var3, var4, var7.field10631, var7.field10632);

            for (int var8 = 0; var8 < var5.size(); var8++) {
               ScriptEventNames.Nested140 var9 = (ScriptEventNames.Nested140)var5.get(var8);
               ScriptSourceLoader var10 = ScriptLifecycle.method03294(var9.field10626);

               try {
                  var9.field10627.handle(var7.field10630);
               } catch (Throwable var21) {
                  ScriptRuntime.INSTANCE.method06226(var9.field10626, var21);
                  return var7.method04798();
               } finally {
                  ScriptLifecycle.method03293(var10);
               }
            }

            return var7.method04798();
         } finally {
            var7.field10630.clear();
            var7.field10635 = null;
            var7.field10636 = false;
            var6.method04797();
         }
      } else {
         return false;
      }
   }

   boolean method04783(Object var1, Class<?> var2, EventListener<?> var3) {
      if (var1 != null && var2 != null && var3 != null) {
         this.field10594.computeIfAbsent(var2, var0 -> new CopyOnWriteArrayList<>()).add(new ScriptEventNames.Nested143(var1, var3));
         return true;
      } else {
         return false;
      }
   }

   boolean method04784(String var1, Object var2, boolean var3) {
      return this.method04782(var1, null, var2, var3);
   }

   boolean method04785(Event var1, boolean var2) {
      var var3 = this.field10594.get(var1.getClass());
      if (var3 != null && !var3.isEmpty()) {
         ScriptEventNames.Nested141 var4 = this.field10595.get();
         ScriptEventNames.Nested142 var5 = var4.method04796();

         try {
            var1.bind(var2, var5.field10633, var5.field10634);

            for (int var6 = 0; var6 < var3.size(); var6++) {
               ScriptEventNames.Nested143 var7 = (ScriptEventNames.Nested143)var3.get(var6);
               ScriptSourceLoader var8 = ScriptLifecycle.method03294(var7.field10637);

               try {
                  ((EventListener<Event>)var7.field10638).handle(var1);
               } catch (Throwable var19) {
                  ScriptRuntime.INSTANCE.method06226(var7.field10637, var19);
                  return var5.method04798();
               } finally {
                  ScriptLifecycle.method03293(var8);
               }
            }

            return var5.method04798();
         } finally {
            var1.release();
            var5.field10635 = null;
            var5.field10636 = false;
            var4.method04797();
         }
      } else {
         return false;
      }
   }

   boolean method04786(Class<?> var1) {
      var var2 = this.field10594.get(var1);
      return var2 != null && !var2.isEmpty();
   }

   boolean method04787(Object var1, String var2, EventHandler var3) {
      if (var1 != null && var3 != null && this.method04788(var2)) {
         this.field10593.computeIfAbsent(var2, var0 -> new CopyOnWriteArrayList<>()).add(new ScriptEventNames.Nested140(var1, var3));
         return true;
      } else {
         return false;
      }
   }

   boolean method04788(String var1) {
      for (String var5 : field10592) {
         if (var5.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   boolean method04791(String var1) {
      var var2 = this.field10593.get(var1);
      return var2 != null && !var2.isEmpty();
   }

   void method04792(Object var1) {
      for (var var3 : this.field10593.values()) {
         this.method04781(var3, var1);
      }

      for (var var5 : this.field10594.values()) {
         var5.removeIf(var1x -> var1x.field10637 == var1);
      }
   }

   void method04793(Object var1, String var2) {
      this.method04781(this.field10593.get(var2), var1);
   }

   String[] method04794() {
      return (String[])field10592.clone();
   }

   // $VF: Compiled from s
   private static final class Nested140 {
      private final Object field10626;
      private final EventHandler field10627;

      Nested140(Object var1, EventHandler var2) {
         this.field10626 = var1;
         this.field10627 = var2;
      }
   }

   // $VF: Compiled from s
   private static final class Nested141 {
      private final List<ScriptEventNames.Nested142> field10628 = new ArrayList<>();
      private int field10629;

      private ScriptEventNames.Nested142 method04796() {
         while (this.field10628.size() <= this.field10629) {
            this.field10628.add(new ScriptEventNames.Nested142());
         }

         return this.field10628.get(this.field10629++);
      }

      private void method04797() {
         this.field10629--;
      }
   }

   // $VF: Compiled from s
   private static final class Nested142 {
      private final ScriptEvent field10630 = new ScriptEvent();
      private final CancelOp field10631 = this::method04799;
      private final CancelledOp field10632 = this::method04798;
      private final hex.script.api.event.Event.CancelOp field10633 = this::method04799;
      private final hex.script.api.event.Event.CancelledOp field10634 = this::method04798;
      private sg.ec.Event field10635;
      private boolean field10636;

      private boolean method04798() {
         return this.field10635 == null ? this.field10636 : this.field10635.method05697();
      }

      private void method04799() {
         if (this.field10635 == null) {
            this.field10636 = true;
         } else {
            this.field10635.method05696();
         }
      }
   }

   // $VF: Compiled from s
   private static final class Nested143 {
      private final Object field10637;
      private final EventListener<?> field10638;

      Nested143(Object var1, EventListener<?> var2) {
         this.field10637 = var1;
         this.field10638 = var2;
      }
   }
}
