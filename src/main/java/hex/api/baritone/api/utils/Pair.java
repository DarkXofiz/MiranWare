// Original binary: hex/api/baritone/api/utils/Pair
package hex.api.baritone.api.utils;

import java.util.Objects;

// $VF: Compiled from s
public final class Pair<A, B> {
   private final A a;
   private final B b;

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && var1.getClass() == Pair.class) {
         var var2 = (Pair<?, ?>)var1;
         return Objects.equals(this.a, var2.a) && Objects.equals(this.b, var2.b);
      } else {
         return false;
      }
   }

   public Pair(A var1, B var2) {
      this.a = var1;
      this.b = var2;
   }

   public B second() {
      return this.b;
   }

   public A first() {
      return this.a;
   }

   @Override
   public int hashCode() {
      return 31 * Objects.hashCode(this.a) + Objects.hashCode(this.b);
   }
}
