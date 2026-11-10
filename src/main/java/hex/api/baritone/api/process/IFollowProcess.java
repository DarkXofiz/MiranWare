// Original binary: hex/api/baritone/api/process/IFollowProcess
package hex.api.baritone.api.process;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public interface IFollowProcess extends IBaritoneProcess {
   default void cancel() {
      this.onLostControl();
   }

   List<Entity> following();

   Predicate<Entity> currentFilter();

   void follow(Predicate<Entity> var1);

   void pickup(Predicate<ItemStack> var1);
}
