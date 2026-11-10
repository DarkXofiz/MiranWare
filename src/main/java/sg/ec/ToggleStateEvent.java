// Original binary: sg/ec/YwDmNPyKjbjaHl0K
package sg.ec;

// $VF: Compiled from s
public class ToggleStateEvent extends Event {
   public static final ToggleStateEvent field15044 = new ToggleStateEvent();
   private Object field15045;
   private ToggleStateEvent.Nested198 field15046;
   private ToggleStateEvent.Nested197 field15047;

   public ToggleStateEvent.Nested198 method06761() {
      return this.field15046;
   }

   public void method06762(Object var1) {
      this.field15045 = var1;
   }

   public Object method06763() {
      return this.field15045;
   }

   public void method06764(ToggleStateEvent.Nested197 var1) {
      this.field15047 = var1;
   }

   public void method06765(Object var1, ToggleStateEvent.Nested198 var2, ToggleStateEvent.Nested197 var3) {
      this.field15045 = var1;
      this.field15046 = var2;
      this.field15047 = var3;
      super.method03208();
   }

   public void method06766(ToggleStateEvent.Nested198 var1) {
      this.field15046 = var1;
   }

   public ToggleStateEvent.Nested197 method06767() {
      return this.field15047;
   }

   // $VF: Compiled from s
   public enum Nested197 {
      MODULE,
      CHECKBOX;
   }

   // $VF: Compiled from s
   public enum Nested198 {
      DISABLE,
      ENABLE;
   }
}
