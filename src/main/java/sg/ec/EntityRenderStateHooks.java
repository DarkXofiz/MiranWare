// Original binary: sg/ec/9p2JJWeKoQW0VFV2
package sg.ec;

import java.lang.ref.WeakReference;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public final class EntityRenderStateHooks {
   private EntityRenderStateHooks() {
   }

   public static Entity method02380(WeakReference<Entity> var0) {
      return var0 == null ? null : (Entity)var0.get();
   }

   public static WeakReference<Entity> method02381(Entity var0) {
      return var0 == null ? null : new WeakReference<>(var0);
   }
}
