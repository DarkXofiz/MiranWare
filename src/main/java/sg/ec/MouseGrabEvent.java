// Original binary: sg/ec/IvzJkCZOHXf5l2ng
package sg.ec;

// $VF: Compiled from s
public class MouseGrabEvent extends Event {
   public static final MouseGrabEvent field08821 = new MouseGrabEvent();
   private MouseGrabEvent.Nested115 field08822;

   public boolean method03965(MouseGrabEvent.Nested115 var1) {
      this.field08822 = var1;
      super.method03208();
      return this.method05694();
   }

   public void method03966(MouseGrabEvent.Nested115 var1) {
      this.field08822 = var1;
   }

   public MouseGrabEvent.Nested115 method03967() {
      return this.field08822;
   }

   // $VF: Compiled from s
   public enum Nested115 {
      MOUSE_SCROLL;
   }
}
