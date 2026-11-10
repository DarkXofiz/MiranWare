// Original binary: hex/api/baritone/api/cache/IWorldProvider
package hex.api.baritone.api.cache;

import java.util.function.Consumer;

// $VF: Compiled from s
public interface IWorldProvider {
   default void ifWorldLoaded(Consumer<IWorldData> var1) {
      IWorldData var2 = this.getCurrentWorld();
      if (var2 != null) {
         var1.accept(var2);
      }
   }

   IWorldData getCurrentWorld();
}
