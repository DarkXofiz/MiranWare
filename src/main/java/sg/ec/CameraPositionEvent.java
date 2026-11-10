// Original binary: sg/ec/0JZfpTMCE60rEp2h
package sg.ec;

import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class CameraPositionEvent extends Event {
   public static final CameraPositionEvent field00100 = new CameraPositionEvent();
   private Vec3 field00101;

   public void method00053(Vec3 var1) {
      this.field00101 = var1;
   }

   public Vec3 method00054(Vec3 var1) {
      this.field00101 = var1;
      super.method03208();
      return this.field00101;
   }

   public Vec3 method00055() {
      return this.field00101;
   }
}
