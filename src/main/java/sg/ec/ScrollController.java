// Original binary: sg/ec/5X86I4tE8ptCJhSz
package sg.ec;

// $VF: Compiled from s
public class ScrollController implements MinecraftAccess {
   private float field02413;
   private float field02414;
   private float field02415;
   private float field02416;
   private boolean field02417;
   private boolean field02418;
   private float field02419;
   private final SmoothAnimation field02420;
   private static final float field02421 = 5.0F;
   private static final double field02422 = 0.15F;
   private static final float field02423 = 10.0F;
   private static final double field02424 = 2.0;

   public void method01133(double var1) {
      this.field02416 = (float)var1;
   }

   public void method01134(float var1, float var2) {
      this.field02414 = -var1 + var2;
   }

   public float method01135() {
      return this.field02413;
   }

   public float method01136() {
      return this.field02415;
   }

   public ScrollController() {
      this.field02419 = field02421;
      this.field02420 = new SmoothAnimation();
      this.field02417 = true;
      this.field02418 = true;
   }

   public SmoothAnimation method01137() {
      return this.field02420;
   }

   public boolean method01138() {
      return this.field02417;
   }

   public float method01139() {
      return this.field02419;
   }

   public void method01140(float var1) {
      this.field02413 = var1;
   }

   public float method01141() {
      return this.field02414;
   }

   public void method01142(float var1) {
      this.field02419 = var1;
   }

   public void method01143(float var1) {
      this.field02416 = var1;
   }

   public void method01144() {
      this.field02420.method06157(this.field02415 = this.field02413 = 0.0F);
   }

   public void method01145() {
      this.field02420.method06162();
      this.field02420.method06168(this.field02413, field02422, Easings.field19397, true);
      if (this.field02417) {
         double var1 = this.field02416 * (this.field02419 * field02423);
         double var3 = 0.0;
         this.field02413 = (float)Math.min(
            Math.max(this.field02413 + var1 / field02424, this.field02414 - (var1 == 0.0 ? 0.0 : var3)), var1 == 0.0 ? 0.0 : var3
         );
         this.method01147();
      }

      if (this.field02418) {
         this.method01147();
      }

      this.field02415 = this.field02420.method06173();
   }

   public boolean method01146() {
      return this.field02418;
   }

   private void method01147() {
      this.field02416 = 0.0F;
   }

   public float method01148() {
      return this.field02416;
   }

   public void method01149(float var1) {
      this.field02414 = var1;
   }

   public void method01150(boolean var1) {
      this.field02418 = var1;
   }

   public void method01151(float var1) {
      this.field02415 = var1;
   }

   public void method01152(boolean var1) {
      this.field02417 = var1;
   }
}
