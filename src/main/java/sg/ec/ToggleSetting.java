// Original binary: sg/ec/WIeDdbB8dqAqH9dw
package sg.ec;

// $VF: Compiled from s
public class ToggleSetting extends Setting<Boolean> {
   public AnimationUtils field13573;
   public KeyBinding field13574;
   private static final long field13575 = 150L;

   public void method05996() {
      if (this.method03022() != null) {
         this.method03014(!this.method03022());
         if (this.method03022()) {
            ToggleStateEvent.field15044.method06765(this, ToggleStateEvent.Nested198.ENABLE, ToggleStateEvent.Nested197.CHECKBOX);
         } else {
            ToggleStateEvent.field15044.method06765(this, ToggleStateEvent.Nested198.DISABLE, ToggleStateEvent.Nested197.CHECKBOX);
         }
      }
   }

   public KeyBinding method05997() {
      return this.field13574;
   }

   public AnimationUtils method05998() {
      return this.field13573;
   }

   public boolean method05999() {
      return this.method03022() == null ? false : this.method03022();
   }

   public ToggleSetting(String var1) {
      super(var1);
      this.field13573 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field13575);
      this.field13574 = new KeyBinding(-1);
   }
}
