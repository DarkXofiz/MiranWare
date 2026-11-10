// Original binary: sg/ec/AoFMxIaVED0R3hE8
package sg.ec;

import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public class InvisibleEntityRenderEvent extends Event {
   public static final InvisibleEntityRenderEvent field06162 = new InvisibleEntityRenderEvent();
   private Entity field06163;
   private int field06164;

   public void method02603(Entity var1) {
      this.field06163 = var1;
   }

   public int method02604() {
      return this.field06164;
   }

   public void method02605(Entity var1) {
      this.field06163 = var1;
   }

   public boolean method02606(boolean var1, boolean var2) {
      if (!var2) {
         return var1;
      }

      super.method03208();
      return this.method05694() ? true : var1;
   }

   public void method02607(int var1) {
      this.field06164 = var1;
   }

   public Entity method02608() {
      return this.field06163;
   }

   public int method02609(int var1, boolean var2) {
      if (!var2) {
         return var1;
      }

      this.field06164 = var1;
      super.method03208();
      return this.method05694() ? this.field06164 : var1;
   }
}
