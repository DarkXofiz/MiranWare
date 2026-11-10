// Original binary: sg/ec/gd5OoVtfFhe1V4nY
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

// $VF: Compiled from s
public enum CloudRotationRegistry {
   INSTANCE;

   private final Map<String, CloudRotationRegistry.Nested236> field19588 = new ConcurrentHashMap<>();
   private final Set<String> field19589 = ConcurrentHashMap.newKeySet();

   public void method08496(List<String> var1, String var2, byte[] var3, String var4, byte[] var5) {
      this.method08500(var1);
      if (var2 != null && !var2.isBlank()) {
         CloudRotationRegistry.Nested236 var6 = this.field19588.computeIfAbsent(var2, CloudRotationRegistry.Nested236::new);
         if (var3 != null && var3.length > 0) {
            var6.field19591.method05878(var3);
         }

         if (var5 != null && var5.length > 0) {
            var6.method08509(var4, var5);
         }

         this.method08501(var2x -> {
            if (!var2x.method05598().contains(var2)) {
               var2x.method05601(var2);
               this.field19589.add(var2);
            }
         });
      }
   }

   public AuraRotationStrategy method08497(String var1) {
      CloudRotationRegistry.Nested236 var2 = var1 == null ? null : this.field19588.get(var1);
      if (var2 == null) {
         return null;
      }

      var2.method08506();
      return var2.field19592;
   }

   public OnnxRotationSettingsCodec method08498(String var1) {
      CloudRotationRegistry.Nested236 var2 = var1 == null ? null : this.field19588.get(var1);
      return var2 == null ? null : var2.field19591;
   }

   public boolean method08499(String var1) {
      return var1 != null && this.field19588.containsKey(var1);
   }

   private void method08500(List<String> var1) {
      if (var1 != null) {
         for (String var3 : new ArrayList<>(this.field19588.keySet())) {
            if (!var1.contains(var3)) {
               CloudRotationRegistry.Nested236 var4 = this.field19588.remove(var3);
               if (var4 != null) {
                  var4.field19590.method00708();
               }

               if (this.field19589.remove(var3)) {
                  this.method08501(var1x -> var1x.method05596(var3));
               }
            }
         }
      }
   }

   private void method08501(Consumer<ModeSetting> var1) {
      AttackAura var2 = ModuleManager.INSTANCE.method08219();
      if (var2 != null) {
         var1.accept(var2.method00429());
      }
   }

   // $VF: Compiled from s
   private static final class Nested236 {
      private final OnnxRotationModel field19590 = new OnnxRotationModel();
      private final OnnxRotationSettingsCodec field19591 = new OnnxRotationSettingsCodec();
      private final AuraRotationStrategy field19592;
      private final AtomicReference<CloudRotationRegistry.Nested237> field19593 = new AtomicReference<>();

      public OnnxRotationModel method08504() {
         return this.field19590;
      }

      public OnnxRotationSettingsCodec method08505() {
         return this.field19591;
      }

      private void method08506() {
         CloudRotationRegistry.Nested237 var1 = this.field19593.getAndSet(null);
         if (var1 != null) {
            OnnxRotationSettingsCodec.method05883(var1.name(), var1.bytes(), this::method08504);
         }
      }

      public AtomicReference<CloudRotationRegistry.Nested237> method08507() {
         return this.field19593;
      }

      public AuraRotationStrategy method08508() {
         return this.field19592;
      }

      private Nested236(String var1) {
         this.field19592 = new UniversalAuraRotation(var1, this::method08504);
      }

      private void method08509(String var1, byte[] var2) {
         this.field19593.set(new CloudRotationRegistry.Nested237(var1, var2));
      }
   }

   // $VF: Compiled from s
   private record Nested237(String name, byte[] bytes) {
   }
}
