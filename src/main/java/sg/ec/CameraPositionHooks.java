// Original binary: sg/ec/yHQhJIKnBVO9t3kX
package sg.ec;

import net.minecraft.client.Camera;
import net.minecraft.world.phys.Vec3;
import sg.mx.CameraMixin_1260;

// $VF: Compiled from s
public final class CameraPositionHooks {
   public static boolean method11612(boolean var0) {
      return var0 || ModuleManager.INSTANCE.method08258().method03937();
   }

   private CameraPositionHooks() {
   }

   public static void method11613(Camera var0, double var1, double var3, double var5) {
      Vec3 var7 = CameraPositionEvent.field00100.method00054(new Vec3(var1, var3, var5));
      if (var7 != null) {
         ((CameraMixin_1260)(Object)var0).setPositionAccessor(var7.x, var7.y, var7.z);
      }
   }
}
