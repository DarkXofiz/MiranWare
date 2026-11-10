// Original binary: sg/ec/94aCZAaJ0X5sgjlT
package sg.ec;

import java.util.HashSet;
import java.util.Set;

// $VF: Compiled from s
public enum StaffManager {
   INSTANCE;

   private final Set<String> field05163 = new HashSet<>();

   public void method02172(String var1) {
      this.field05163.add(var1);
      CustomResourceManager.INSTANCE.method02465("Staff");
   }

   public void method02173(String var1) {
      this.field05163.remove(var1);
      CustomResourceManager.INSTANCE.method02465("Staff");
   }

   public void method02174() {
      this.field05163.clear();
      CustomResourceManager.INSTANCE.method02465("Staff");
   }

   public boolean method02175(String var1) {
      return this.field05163.contains(var1);
   }

   public Set<String> method02176() {
      return this.field05163;
   }
}
