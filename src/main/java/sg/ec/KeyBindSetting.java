// Original binary: sg/ec/EPgW74AELblqgmCc
package sg.ec;

// $VF: Compiled from s
public class KeyBindSetting extends Setting<KeyBinding> {
   private boolean field07083;

   public KeyBindSetting method03237() {
      this.field07083 = true;
      return this;
   }

   @Override
   public void method00869() {
      if (this.method03022() != null) {
         this.method03022().method05872(-1);
      }
   }

   public KeyBindSetting(String var1) {
      super(var1);
   }

   public boolean method03238() {
      return this.field07083;
   }
}
