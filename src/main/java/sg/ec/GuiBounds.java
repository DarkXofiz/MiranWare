// Original binary: sg/ec/BZYSOlaoWkBSjcZ1
package sg.ec;

// $VF: Compiled from s
public class GuiBounds {
   private float field06537;
   private float field06538;
   private float field06539;
   private float field06540;
   private boolean field06541 = true;

   public void method02798(float var1) {
      this.field06540 = var1;
   }

   public boolean method02799(double var1, double var3) {
      return GuiHitTestUtils.method05624((int)var1, (int)var3, this.field06537, this.field06538, this.field06539, this.field06540);
   }

   public void method02800(boolean var1) {
      this.field06541 = var1;
   }

   public void method02801(float var1) {
      this.field06537 = var1;
   }

   public float method02802() {
      return this.field06540;
   }

   public void method02803(float var1) {
      this.field06539 = var1;
   }

   public float method02804() {
      return this.field06539;
   }

   public boolean method02805(int var1, int var2) {
      return GuiHitTestUtils.method05624(var1, var2, this.field06537, this.field06538, this.field06539, this.field06540);
   }

   public void method02806(float var1) {
      this.field06538 = var1;
   }

   public boolean method02807() {
      return this.field06541;
   }

   public float method02808() {
      return this.field06538;
   }

   public float method02809() {
      return this.field06537;
   }
}
