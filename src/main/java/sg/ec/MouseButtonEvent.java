// Original binary: sg/ec/aGo9pNIoNMAFkbJW
package sg.ec;

// $VF: Compiled from s
public class MouseButtonEvent extends Event {
   public static final MouseButtonEvent field15585 = new MouseButtonEvent();
   private double field15586;
   private double field15587;
   private int field15588;
   private InputAction field15589;

   public void method06912(double var1, double var3, int var5, InputAction var6) {
      this.field15586 = var1;
      this.field15587 = var3;
      this.field15588 = var5;
      this.field15589 = var6;
      super.method03208();
   }

   public void method06913(double var1) {
      this.field15586 = var1;
   }

   public int method06914() {
      return this.field15588;
   }

   public double method06915() {
      return this.field15586;
   }

   public void method06916(double var1) {
      this.field15587 = var1;
   }

   public double method06917() {
      return this.field15587;
   }

   public void method06918(InputAction var1) {
      this.field15589 = var1;
   }

   public InputAction method06919() {
      return this.field15589;
   }

   public void method06920(int var1) {
      this.field15588 = var1;
   }
}
