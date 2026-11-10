// Original binary: hex/api/baritone/api/utils/Tuple
package hex.api.baritone.api.utils;

// $VF: Compiled from s
public class Tuple<A, B> {
   private A a;
   private B b;

   public A getA() {
      return this.a;
   }

   public B getB() {
      return this.b;
   }

   public void setB(B var1) {
      this.b = var1;
   }

   public Tuple(A var1, B var2) {
      this.a = var1;
      this.b = var2;
   }

   public void setA(A var1) {
      this.a = var1;
   }
}
