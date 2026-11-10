// Original binary: sg/ec/xHTafjmkLhBy8gGd
package sg.ec;

import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public class EntityDeathEvent extends Event {
   public static final EntityDeathEvent field25737 = new EntityDeathEvent();
   private Entity field25738;

   public void method11301(Entity var1) {
      this.field25738 = var1;
   }

   public void method11302(Entity var1) {
      this.field25738 = var1;
      super.method03208();
   }

   public Entity method11303() {
      return this.field25738;
   }
}
