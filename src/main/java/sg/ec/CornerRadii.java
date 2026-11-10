// Original binary: sg/ec/UYy05m1sw7OP99B5
package sg.ec;

// $VF: Compiled from s
public record CornerRadii(float radius1, float radius2, float radius3, float radius4) {
   public static final CornerRadii NO_ROUND = new CornerRadii(0.0F, 0.0F, 0.0F, 0.0F);

   public CornerRadii(float var1) {
      this(var1, var1, var1, var1);
   }

   public CornerRadii(double var1, double var3, double var5, double var7) {
      this((float)var1, (float)var3, (float)var5, (float)var7);
   }

   public CornerRadii(double var1) {
      this(var1, var1, var1, var1);
   }
}
