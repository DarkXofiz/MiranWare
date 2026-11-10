// Original binary: sg/ec/v1N8lZoGO8HjjjRf
package sg.ec;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public final class EntityEyeDistanceUtils {
   public static float method10980(Entity var0, Entity var1) {
      float var2 = var1.getBbWidth() / 2.0F;
      float sx = (float)Mth.clamp(var0.getX() - var1.getX(), -var2, var2);
      float sxx = (float)Mth.clamp(var0.getEyePosition().y() - var1.getY(), 0.0, var1.getBbHeight());
      float sxxx = (float)Mth.clamp(var0.getZ() - var1.getZ(), -var2, var2);
      return (float)var0.getEyePosition().distanceTo(var1.position().add(sx, sxx, sxxx));
   }

   private EntityEyeDistanceUtils() {
   }
}
