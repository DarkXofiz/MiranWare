// Original binary: sg/ec/US8DeluMZoGOlRHd
package sg.ec;

// $VF: Compiled from s
public class KeyInputEvent extends Event {
   public static final KeyInputEvent field12526 = new KeyInputEvent();
   private int field12527;
   private InputAction field12528;

   public InputAction method05884() {
      return this.field12528;
   }

   public void method05885(int var1) {
      this.field12527 = var1;
   }

   public void method05886(int var1, InputAction var2) {
      this.field12527 = var1;
      this.field12528 = var2;
      super.method03208();
   }

   public int method05887() {
      return this.field12527;
   }

   public void method05888(InputAction var1) {
      this.field12528 = var1;
   }
}
