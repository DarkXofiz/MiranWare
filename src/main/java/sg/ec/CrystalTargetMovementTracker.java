// Original binary: sg/ec/HcNDdzh5MYWZD1uk
package sg.ec;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class CrystalTargetMovementTracker {
   private static final int field08569 = 10;
   private final Vec3[] field08570 = new Vec3[10];
   private Entity field08571;
   private int field08572;
   private int field08573;

   public void method03799(Entity var1) {
      if (var1 != this.field08571) {
         this.field08571 = var1;
         this.field08572 = 0;
         this.field08573 = 0;
      }

      this.field08570[this.field08572] = var1.position();
      this.field08572 = (this.field08572 + 1) % 10;
      if (this.field08573 < 10) {
         this.field08573++;
      }
   }

   public boolean method03800(Entity var1) {
      return var1 == this.field08571;
   }

   public float method03801() {
      if (this.field08573 < 2) {
         return 0.0F;
      }

      Vec3 var1 = this.field08570[(this.field08572 - 1 + 10) % 10];
      Vec3 var2 = this.field08570[(this.field08572 - this.field08573 + 10) % 10];
      return (float)(var1.distanceTo(var2) / (this.field08573 - 1));
   }

   public void method03802() {
      this.field08571 = null;
      this.field08572 = 0;
      this.field08573 = 0;
   }
}
