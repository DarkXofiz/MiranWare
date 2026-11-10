// Original binary: sg/ec/Dxy5C0KbBOy1ir7a
package sg.ec;

import net.minecraft.world.level.material.FogType;

// $VF: Compiled from s
public final class FogRenderHooks {
   public static FogType method03189(FogType var0) {
      if (var0 == FogType.WATER) {
         return VisualRemovalEvent.field19883.method08692(var0, VisualRemovalEvent.Nested242.WATER_FOG);
      } else {
         return var0 == FogType.LAVA ? VisualRemovalEvent.field19883.method08692(var0, VisualRemovalEvent.Nested242.LAVA_FOG) : var0;
      }
   }

   public static float method03190(float var0) {
      return VisualRemovalEvent.field19883.method08697(VisualRemovalEvent.Nested242.NIGHT_VISION_FOG) ? 0.0F : var0;
   }

   private FogRenderHooks() {
   }
}
