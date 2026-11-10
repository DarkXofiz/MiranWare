// Original binary: sg/ec/T8VTco6owrqR5dhs
package sg.ec;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// $VF: Compiled from s
public class ModeSetting extends Setting<String> {
   private final List<String> field11988 = new CopyOnWriteArrayList<>();

   public ModeSetting method05596(String var1) {
      if (var1 != null && this.field11988.remove(var1)) {
         if (var1.equals(this.method03022())) {
            this.method00870(this.field11988.isEmpty() ? null : this.field11988.get(0));
         }

         return this;
      } else {
         return this;
      }
   }

   public ModeSetting method05597(String... var1) {
      if (var1 == null) {
         return this;
      }

      Arrays.stream(var1).forEach(this::method05601);
      return this;
   }

   public ModeSetting(String var1) {
      super(var1);
   }

   public List<String> method05598() {
      return this.field11988;
   }

   public boolean method05600(String var1) {
      return this.method03022() == null ? false : this.method03022().equals(var1);
   }

   public ModeSetting method05601(String var1) {
      if (var1 != null && !var1.isBlank() && !this.field11988.contains(var1)) {
         this.field11988.add(var1);
         if (this.method03022() == null) {
            this.method00870(var1);
         }

         return this;
      } else {
         return this;
      }
   }

   public <S extends Setting<String>> S method05603(String var1) {
      if (var1 == null) {
         return (S)this;
      }

      this.field11988.stream().filter(var1x -> var1x.equals(var1)).findFirst().ifPresent(var1x -> this.method00870(var1x));
      return (S)this;
   }
}
