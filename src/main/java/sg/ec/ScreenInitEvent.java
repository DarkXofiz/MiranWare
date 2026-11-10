// Original binary: sg/ec/YwahGuNKWecH8eVA
package sg.ec;

import net.minecraft.client.gui.screens.Screen;

// $VF: Compiled from s
public class ScreenInitEvent extends Event {
   public static final ScreenInitEvent field15048 = new ScreenInitEvent();
   private Screen field15049;

   public Screen method06768() {
      return this.field15049;
   }

   public void method06769(Screen var1) {
      this.field15049 = var1;
   }

   public void method06770(Screen var1) {
      this.field15049 = var1;
      super.method03208();
   }
}
