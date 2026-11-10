// Original binary: sg/ec/CFyLWFhbwUwttt7R
package sg.ec;

// $VF: Compiled from s
public final class RotationChangeTracker implements MinecraftAccess {
   private static final float field06702 = 2.0F;
   private static final float field06703 = 0;
   private static final int field06704 = 0;
   private static final int field06705 = 0;
   private static float field06706;
   private static int field06707 = -100;
   private static int field06708;
   private static final float field06709 = 0.01F;

   @Subscribe(4)
   private void method02902(PlayerUpdateEvent var1) {
      if (mc.player == null) {
         field06706 = 0.0F;
         field06707 = -100;
      } else {
         int var2 = mc.player.tickCount - field06707;
         if (var2 < 0 || var2 > 1) {
            float sx = RotationMath.method11345();
            if (!(sx <= 0.0F)) {
               for (int sxx = 0; sxx < 4 && method02904(method02905()); sxx++) {
                  field06708 = field06708 % 3 + 1;
                  mc.player.setYRot(mc.player.getYRot() + sx * field06708);
               }
            }
         }
      }
   }

   public RotationChangeTracker() {
      EventBus.method00263(this);
   }

   public static void method02903() {
      if (mc.player != null) {
         field06706 = method02905();
         field06707 = mc.player.tickCount;
      }
   }

   private static boolean method02904(float var0) {
      return var0 > 2.0F && Math.abs(var0 - field06706) < field06709;
   }

   private static float method02905() {
      float var0 = RotationManager.method06563();
      return mc.player != null && !Float.isNaN(var0) ? Math.abs(mc.player.getYRot() - var0) : 0.0F;
   }
}
