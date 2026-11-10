// Original binary: sg/ec/TciTg9GtEbaVpFzD
package sg.ec;

import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public class EntityVisibilityEvent extends Event {
   public static final EntityVisibilityEvent field12028 = new EntityVisibilityEvent();
   private Entity field12029;
   private boolean field12030;

   public void method05668(Entity var1) {
      this.field12029 = var1;
   }

   public Entity method05669() {
      return this.field12029;
   }

   public boolean method05670() {
      return this.field12030;
   }

   public boolean method05671(Entity var1, boolean var2) {
      if (!this.method05698()) {
         return var2;
      }

      this.field12030 = true;
      this.field12029 = var1;
      super.method03208();
      return !this.method05694() ? var2 : var2 && this.field12030;
   }

   public void method05672(boolean var1) {
      this.field12030 = var1;
   }
}
