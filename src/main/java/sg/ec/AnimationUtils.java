// Original binary: sg/ec/FOcS8gMZGOJUjZB7
package sg.ec;

// $VF: Compiled from s
public class AnimationUtils {
   private AnimationUtils.Nested95 field07567;
   private long field07568;
   private long field07569;
   private long field07570;
   private double field07571;
   private double field07572;
   private double field07573;
   private boolean field07574;

   public Number method03362() {
      return this.field07573;
   }

   public void method03363() {
      this.field07569 = System.currentTimeMillis();
      this.field07571 = this.field07573;
      this.field07574 = false;
   }

   public AnimationUtils.Nested95 method03364() {
      return this.field07567;
   }

   public boolean method03365() {
      return this.field07574;
   }

   public void method03366(double var1) {
      this.field07571 = var1;
   }

   public void method03367(boolean var1) {
      this.field07574 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = this.method03373();
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = this.method03371();
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      long var7 = this.method03378();
      var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
      long var9 = Double.doubleToLongBits(this.method03380());
      var2 = var2 * 59 + (int)(var9 >>> 32 ^ var9);
      long var11 = Double.doubleToLongBits(this.method03379());
      var2 = var2 * 59 + (int)(var11 >>> 32 ^ var11);
      long var13 = Double.doubleToLongBits(this.method03384());
      var2 = var2 * 59 + (int)(var13 >>> 32 ^ var13);
      var2 = var2 * 59 + (this.method03365() ? 79 : 97);
      AnimationUtils.Nested95 var15 = this.method03364();
      return var2 * 59 + (var15 == null ? 43 : var15.hashCode());
   }

   public AnimationUtils(AnimationUtils.Nested95 var1, long var2) {
      this.field07567 = var1;
      this.field07568 = var2;
      this.field07569 = System.currentTimeMillis();
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof AnimationUtils var2)) {
         return false;
      } else {
         if (!var2.method03376(this)) {
            return false;
         }

         if (this.method03373() != var2.method03373()) {
            return false;
         }

         if (this.method03371() != var2.method03371()) {
            return false;
         }

         if (this.method03378() != var2.method03378()) {
            return false;
         }

         if (Double.compare(this.method03380(), var2.method03380()) != 0) {
            return false;
         }

         if (Double.compare(this.method03379(), var2.method03379()) != 0) {
            return false;
         }

         if (Double.compare(this.method03384(), var2.method03384()) != 0) {
            return false;
         }

         if (this.method03365() != var2.method03365()) {
            return false;
         }

         AnimationUtils.Nested95 var3 = this.method03364();
         AnimationUtils.Nested95 var4 = var2.method03364();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   public AnimationUtils(long var1) {
      this(AnimationUtils.Nested95.LINEAR, var1);
   }

   public void method03368(long var1) {
      this.field07568 = var1;
   }

   public void method03369(double var1) {
      this.field07572 = var1;
   }

   public void method03370(long var1) {
      this.field07569 = var1;
   }

   public long method03371() {
      return this.field07569;
   }

   private static double method03372(double var0) {
      return Math.max(0.0, Math.min(1.0, var0));
   }

   public long method03373() {
      return this.field07568;
   }

   public void method03374(double var1) {
      this.field07573 = var1;
   }

   public void method03375(double var1) {
      this.field07570 = System.currentTimeMillis();
      if (this.field07568 <= 0L) {
         this.field07572 = var1;
         this.field07573 = var1;
         this.field07571 = var1;
         this.field07569 = this.field07570;
         this.field07574 = true;
      } else {
         if (Double.compare(this.field07572, var1) != 0) {
            this.field07572 = var1;
            this.method03363();
         }

         double var3 = this.method03385();
         this.field07574 = var3 >= 1.0;
         if (this.field07574) {
            this.field07573 = var1;
         } else {
            boolean var5 = var1 < this.field07571;
            double var6 = this.field07567.method03386(var3, var5);
            this.field07573 = this.field07571 + (var1 - this.field07571) * var6;
         }
      }
   }

   @Override
   public String toString() {
      return "AnimationUtils(easing="
         + this.method03364()
         + ", duration="
         + this.method03373()
         + ", startTime="
         + this.method03371()
         + ", millis="
         + this.method03378()
         + ", startValue="
         + this.method03380()
         + ", destinationValue="
         + this.method03379()
         + ", value="
         + this.method03384()
         + ", finished="
         + this.method03365()
         + ")";
   }

   protected boolean method03376(Object var1) {
      return var1 instanceof AnimationUtils;
   }

   public float method03377() {
      return (float)this.field07573;
   }

   public long method03378() {
      return this.field07570;
   }

   public double method03379() {
      return this.field07572;
   }

   public double method03380() {
      return this.field07571;
   }

   public void method03381(Number var1) {
      if (var1 != null) {
         this.method03375(var1.doubleValue());
      }
   }

   public void method03382(AnimationUtils.Nested95 var1) {
      this.field07567 = var1;
   }

   public void method03383(long var1) {
      this.field07570 = var1;
   }

   public double method03384() {
      return this.field07573;
   }

   public double method03385() {
      return this.field07568 <= 0L ? 1.0 : method03372((double)(System.currentTimeMillis() - this.field07569) / this.field07568);
   }

   // $VF: Compiled from s
   public enum Nested95 {
      LINEAR(Easings.field19394),
      QUAD(Easings.field19395, Easings.field19397),
      CUBIC(Easings.field19399, Easings.field19400),
      QUART(Easings.field19402, Easings.field19403),
      QUINT(Easings.field19405, Easings.field19406),
      SINE(Easings.field19408, Easings.field19409),
      EXPO(Easings.field19417, Easings.field19418),
      CIRC(Easings.field19411, Easings.field19412),
      BACK(Easings.field19420, Easings.field19421),
      ELASTIC(Easings.field19414, Easings.field19415),
      BOUNCE(Easings.field19424, Easings.field19423),
      EASE_IN_QUAD(Easings.field19395),
      EASE_OUT_QUAD(Easings.field19397),
      EASE_IN_OUT_QUAD(Easings.field19398),
      EASE_IN_CUBIC(Easings.field19399),
      EASE_OUT_CUBIC(Easings.field19400),
      EASE_IN_OUT_CUBIC(Easings.field19401),
      EASE_IN_QUART(Easings.field19402),
      EASE_OUT_QUART(Easings.field19403),
      EASE_IN_OUT_QUART(Easings.field19404),
      EASE_IN_QUINT(Easings.field19405),
      EASE_OUT_QUINT(Easings.field19406),
      EASE_IN_OUT_QUINT(Easings.field19407),
      EASE_IN_SINE(Easings.field19408),
      EASE_OUT_SINE(Easings.field19409),
      EASE_IN_OUT_SINE(Easings.field19410),
      EASE_IN_EXPO(Easings.field19417),
      EASE_OUT_EXPO(Easings.field19418),
      EASE_IN_OUT_EXPO(Easings.field19419),
      EASE_IN_CIRC(Easings.field19411),
      EASE_OUT_CIRC(Easings.field19412),
      EASE_IN_OUT_CIRC(Easings.field19413),
      EASE_IN_BACK(Easings.field19420),
      EASE_OUT_BACK(Easings.field19421),
      EASE_IN_OUT_BACK(Easings.field19422),
      EASE_IN_ELASTIC(Easings.field19414),
      EASE_OUT_ELASTIC(Easings.field19415),
      EASE_IN_OUT_ELASTIC(Easings.field19416),
      EASE_IN_BOUNCE(Easings.field19424),
      EASE_OUT_BOUNCE(Easings.field19423),
      EASE_IN_OUT_BOUNCE(Easings.field19425),
      SIGMOID(var0 -> {
         double var2 = 1.0 / (1.0 + Math.exp(-12.0 * (var0 - 0.5)));
         double var4 = 1.0 / (1.0 + Math.exp(6.0));
         double var6 = 1.0 / (1.0 + Math.exp(-6.0));
         return (var2 - var4) / (var6 - var4);
      }),
      SMOOTHSTEP(var0 -> var0 * var0 * (3.0 - 2.0 * var0)),
      SMOOTHERSTEP(var0 -> var0 * var0 * var0 * (var0 * (var0 * 6.0 - 15.0) + 10.0)),
      NOVA_EASING(var0 -> {
         float var2 = 1.3F;
         float var3 = var2 + 1.0F;
         return Math.max(0.0, 1.0 + var3 * Math.pow(var0 - 1.0, 3.0) + var2 * Math.pow(var0 - 1.0, 2.0));
      });

      private final EasingFunction field07575;
      private final EasingFunction field07576;

      Nested95(EasingFunction var3) {
         this(var3, var3);
      }

      Nested95(EasingFunction var3, EasingFunction var4) {
         this.field07575 = var3;
         this.field07576 = var4;
      }

      public double method03386(double var1, boolean var3) {
         double var4 = AnimationUtils.method03372(var1);
         return (var3 ? this.field07576 : this.field07575).method07086(var4);
      }
   }
}
