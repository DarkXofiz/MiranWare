// Original binary: sg/ec/7IV22OfDbj5Gtk44
package sg.ec;

// $VF: Compiled from s
public class MutableVector3f {
   public float field03984;
   public float field03985;
   public float field03986;

   public float method01647() {
      return this.field03985;
   }

   public MutableVector3f method01648(float var1, float var2, float var3) {
      this.field03984 *= var1;
      this.field03985 *= var2;
      this.field03986 *= var3;
      return this;
   }

   public float method01649() {
      return (float)Math.sqrt(this.field03984 * this.field03984 + this.field03985 * this.field03985 + this.field03986 * this.field03986);
   }

   public MutableVector3f(float var1, float var2, float var3) {
      this.field03984 = var1;
      this.field03985 = var2;
      this.field03986 = var3;
   }

   public MutableVector3f method01650(float var1, float var2, float var3) {
      this.field03984 += var1;
      this.field03985 += var2;
      this.field03986 += var3;
      return this;
   }

   public float method01651() {
      return this.field03986;
   }

   public MutableVector3f method01652(MutableVector3f var1) {
      this.field03984 = this.field03984 - var1.method01656();
      this.field03985 = this.field03985 - var1.method01647();
      this.field03986 = this.field03986 - var1.method01651();
      return this;
   }

   public float method01653() {
      return (float)Math.sqrt(this.field03984 * this.field03984 + this.field03986 * this.field03986);
   }

   public float method01654() {
      return this.field03984 * this.field03984 + this.field03985 * this.field03985 + this.field03986 * this.field03986;
   }

   public void method01655(float var1) {
      this.field03985 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.method01656());
      var2 = var2 * 59 + Float.floatToIntBits(this.method01647());
      return var2 * 59 + Float.floatToIntBits(this.method01651());
   }

   public float method01656() {
      return this.field03984;
   }

   public MutableVector3f method01657(float var1, float var2, float var3) {
      this.field03984 -= var1;
      this.field03985 -= var2;
      this.field03986 -= var3;
      return this;
   }

   public MutableVector3f method01658(MutableVector3f var1) {
      this.field03984 = this.field03984 + var1.method01656();
      this.field03985 = this.field03985 + var1.method01647();
      this.field03986 = this.field03986 + var1.method01651();
      return this;
   }

   protected boolean method01659(Object var1) {
      return var1 instanceof MutableVector3f;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof MutableVector3f var2)) {
         return false;
      } else if (!var2.method01659(this)) {
         return false;
      } else if (Float.compare(this.method01656(), var2.method01656()) != 0) {
         return false;
      } else {
         return Float.compare(this.method01647(), var2.method01647()) != 0 ? false : Float.compare(this.method01651(), var2.method01651()) == 0;
      }
   }

   public MutableVector3f method01660(MutableVector3f var1) {
      this.field03984 = this.field03984 * var1.method01656();
      this.field03985 = this.field03985 * var1.method01647();
      this.field03986 = this.field03986 * var1.method01651();
      return this;
   }

   @Override
   public String toString() {
      return "Vec3f(x=" + this.method01656() + ", y=" + this.method01647() + ", z=" + this.method01651() + ")";
   }

   public void method01661(float var1) {
      this.field03986 = var1;
   }

   public float method01662() {
      return this.field03984 * this.field03984 + this.field03986 * this.field03986;
   }

   public void method01663(float var1) {
      this.field03984 = var1;
   }

   public MutableVector3f method01664(float var1) {
      this.field03984 *= var1;
      this.field03985 *= var1;
      this.field03986 *= var1;
      return this;
   }
}
