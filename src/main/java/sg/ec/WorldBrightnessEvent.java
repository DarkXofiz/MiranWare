// Original binary: sg/ec/6ELpzrBC0M3plGfx
package sg.ec;

import org.joml.Vector3f;

// $VF: Compiled from s
public class WorldBrightnessEvent extends Event {
   public static final WorldBrightnessEvent field03023 = new WorldBrightnessEvent();
   private Vector3f field03024;

   public Vector3f method01301() {
      return this.field03024;
   }

   public Vector3f method01302(Vector3f var1) {
      this.field03024 = var1;
      super.method03208();
      return this.field03024;
   }

   public void method01303(Vector3f var1) {
      this.field03024 = var1;
   }
}
