// Original binary: sg/ec/8jNug8zQ8Jbmhq8y
package sg.ec;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class EntityVelocityEvent extends Event {
   public static final EntityVelocityEvent field05097 = new EntityVelocityEvent();
   private Entity field05098;
   private Vec3 field05099;

   public Entity method02128() {
      return this.field05098;
   }

   public void method02129(Vec3 var1) {
      this.field05099 = var1;
   }

   public void method02130(Entity var1) {
      this.field05098 = var1;
   }

   public Vec3 method02131() {
      return this.field05099;
   }

   public Vec3 method02132(Entity var1, Vec3 var2) {
      if (!this.method05698()) {
         return var2;
      }

      this.field05098 = var1;
      this.field05099 = var2;
      super.method03208();
      return this.method05694() ? this.field05099 : var2;
   }
}
