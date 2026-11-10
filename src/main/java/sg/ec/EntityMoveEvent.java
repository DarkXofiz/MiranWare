// Original binary: sg/ec/pELu6jKPsat6lbMz
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class EntityMoveEvent extends Event {
   public static final EntityMoveEvent field22695 = new EntityMoveEvent();
   private Vec3 field22696;

   public Vec3 method10058(Entity var1, Vec3 var2) {
      if (!(var1 instanceof LocalPlayer)) {
         return var2;
      }

      this.field22696 = var2;
      super.method03208();
      return this.field22696;
   }

   public Vec3 method10059() {
      return this.field22696;
   }

   public void method10060(Vec3 var1) {
      this.field22696 = var1;
   }
}
