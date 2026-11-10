// Original binary: sg/ec/NYGhBJf3ZpXL32RQ
package sg.ec;

// $VF: Compiled from s
public class BooleanSetting extends Setting<Boolean> {
   public AnimationUtils field10289;
   public KeyBinding field10290;
   private static final long field10291 = 150L;

   public KeyBinding method04704() {
      return this.field10290;
   }

   public void method04705() {
      if (this.method03022() != null) {
         this.method03014(!this.method03022());
      }
   }

   public boolean method04706() {
      return this.method03022() == null ? false : this.method03022();
   }

   public BooleanSetting(String var1) {
      super(var1);
      this.field10289 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field10291);
      this.field10290 = new KeyBinding(-1);
   }

   public AnimationUtils method04707() {
      return this.field10289;
   }
}
