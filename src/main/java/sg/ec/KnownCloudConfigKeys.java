// Original binary: sg/ec/Ds4IR1AKJaEFUFre
package sg.ec;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// $VF: Compiled from s
public enum KnownCloudConfigKeys {
   INSTANCE;

   private final Set<String> field06989 = ConcurrentHashMap.newKeySet();

   public void method03165(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.field06989.add(var1);
      }
   }

   public boolean method03166(String var1) {
      return var1 != null && this.field06989.contains(var1);
   }
}
