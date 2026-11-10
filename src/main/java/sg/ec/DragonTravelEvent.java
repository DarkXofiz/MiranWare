// Original binary: sg/ec/cJLrvVMsY2RVp8nk
package sg.ec;

import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class DragonTravelEvent extends Event {
   public static final DragonTravelEvent field17745 = new DragonTravelEvent();
   private Vec3 field17746;

   public Vec3 method07275() {
      return this.field17746;
   }

   public Vec3 method07276(Vec3 var1) {
      this.field17746 = var1;
      super.method03208();
      return this.field17746;
   }

   public void method07277(Vec3 var1) {
      this.field17746 = var1;
   }
}
