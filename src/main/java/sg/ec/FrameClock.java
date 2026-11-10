// Original binary: sg/ec/mdfkpsfDeyaHx7JA
package sg.ec;

// $VF: Compiled from s
public final class FrameClock {
   public static final FrameClock field21669 = new FrameClock();
   private static long field21670;

   public static long method09542() {
      return field21670;
   }

   public void method09543() {
      EventBus.method00263(this);
   }

   @Subscribe
   private void method09544(RenderFrameStartEvent var1) {
      field21670++;
   }

   private FrameClock() {
   }
}
