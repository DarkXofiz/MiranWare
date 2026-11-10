// Original binary: sg/ec/Zh8MRH5qkA4NUnpA
package sg.ec;

import java.util.function.Supplier;

// $VF: Compiled from s
public class KeyBindingCapture {
   private static final int field15573 = -100;
   private final Supplier<KeyBinding> field15574;
   private boolean field15575;

   public void method06906() {
      this.field15575 = true;
   }

   public boolean method06907(int var1) {
      if (this.field15575 && var1 != 7) {
         this.method06908(-100 + var1);
         return true;
      } else {
         return false;
      }
   }

   private void method06908(int var1) {
      this.field15574.get().method05872(var1);
      this.field15575 = false;
   }

   public boolean method06909(int var1) {
      if (!this.field15575) {
         return false;
      }

      boolean var2 = var1 == 256 || var1 == 261;
      this.method06908(var2 ? -1 : var1);
      return true;
   }

   public boolean method06910() {
      return this.field15575;
   }

   public KeyBindingCapture(KeyBinding var1) {
      this(() -> var1);
   }

   public KeyBindingCapture(KeyBindSetting var1) {
      this(var1::method03022);
   }

   private KeyBindingCapture(Supplier<KeyBinding> var1) {
      this.field15574 = var1;
   }
}
