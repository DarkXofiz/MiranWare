// Original binary: sg/ec/UR5DZDP5qSsulVzY
package sg.ec;

// $VF: Compiled from s
public class KeyBinding {
   private int field12505;
   private KeyBindingMode field12506 = KeyBindingMode.Toggle;
   private boolean field12507 = true;

   public void method05870(KeyBindingMode var1) {
      this.field12506 = var1;
   }

   public KeyBinding() {
      this.field12505 = -1;
   }

   public int method05871() {
      return this.field12505;
   }

   public KeyBinding method05872(int var1) {
      this.field12505 = var1;
      KeyBindingManager.INSTANCE.method11748();
      return this;
   }

   public boolean method05873() {
      return this.field12507;
   }

   public KeyBinding(int var1) {
      this.field12505 = var1;
   }

   public KeyBindingMode method05874() {
      return this.field12506;
   }

   public void method05875(boolean var1) {
      this.field12507 = var1;
   }
}
