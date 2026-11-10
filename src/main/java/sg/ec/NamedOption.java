// Original binary: sg/ec/fMH3pSkD8M6kuhxv
package sg.ec;

import java.util.function.Supplier;

// $VF: Compiled from s
public class NamedOption<T> {
   private final String field18916;
   private final T field18917;
   private T field18918;
   private Supplier<Boolean> field18919 = () -> true;

   public T method08070() {
      return this.field18917;
   }

   public void method08071(Supplier<Boolean> var1) {
      this.field18919 = var1;
   }

   public void method08073(T var1) {
      this.field18918 = (T)(Object)var1;
   }

   public T method08074() {
      return this.field18918;
   }

   public boolean method08075() {
      return this.field18919.get();
   }

   public NamedOption<T> method08076(Supplier<Boolean> var1) {
      if (var1 != null) {
         this.field18919 = var1;
      }

      return this;
   }

   public static <R> NamedOption<R> method08077(String var0, R var1) {
      return (NamedOption<R>)(new NamedOption<>(var0, var1));
   }

   private NamedOption(String var1, T var2) {
      this.field18916 = var1;
      this.field18917 = (T)(Object)var2;
      this.field18918 = (T)(Object)var2;
   }

   public void method08078() {
      this.field18918 = this.field18917;
   }

   public Supplier<Boolean> method08079() {
      return this.field18919;
   }

   public String method08080() {
      return this.field18916;
   }
}
