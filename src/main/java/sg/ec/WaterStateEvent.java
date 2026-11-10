// Original binary: sg/ec/kVG0gVLdVEfstIQU
package sg.ec;

// $VF: Compiled from s
public class WaterStateEvent extends Event {
   public static final WaterStateEvent field20794 = new WaterStateEvent();
   private boolean field20795;

   public boolean method09166(boolean var1) {
      this.field20795 = var1;
      super.method03208();
      return this.method05694() ? this.field20795 : var1;
   }

   public void method09167(boolean var1) {
      this.field20795 = var1;
   }

   public boolean method09168() {
      return this.field20795;
   }
}
