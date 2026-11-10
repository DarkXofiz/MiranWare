// Original binary: sg/ec/frVILj2lQJe2vOES
package sg.ec;

import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public class ItemUseSlowdownEvent extends Event {
   public static final ItemUseSlowdownEvent field19179 = new ItemUseSlowdownEvent();
   private float field19180 = 1.0F;

   public void method08336(float var1) {
      this.field19180 = var1;
   }

   public boolean method08337(boolean var1) {
      this.field19180 = 1.0F;
      super.method03208();
      return this.method05694() ? false : var1;
   }

   public Vec2 method08338(Vec2 var1) {
      return this.field19180 == 1.0F ? var1 : var1.scale(this.field19180);
   }

   public float method08339() {
      return this.field19180;
   }
}
