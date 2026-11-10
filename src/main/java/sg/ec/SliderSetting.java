// Original binary: sg/ec/28x9ce7xS8WO9EHZ
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
public class SliderSetting extends Setting<Float> {
   private static final float field00737 = 360.0F;
   private static final float field00738 = 360.0F;
   private static final float field00739 = 360.0F;

   public float method00357() {
      return Mth.cos((float)Math.toRadians(this.method00358()));
   }

   public float method00358() {
      Float var1 = this.method03022();
      float var2 = var1 == null ? 0.0F : var1;
      return (var2 % field00737 + field00738) % field00739;
   }

   public float method00359() {
      return Mth.sin((float)Math.toRadians(this.method00358()));
   }

   public SliderSetting(String var1) {
      super(var1);
   }
}
