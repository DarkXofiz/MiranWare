// Original binary: sg/mx/G3vicJCEV3ZQLrrl
package sg.mx;

import net.minecraft.client.renderer.culling.Frustum;
import org.joml.FrustumIntersection;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.FrustumHooks;

// $VF: Compiled from s
@Mixin(Frustum.class)
public class FrustumMixin {
   @Shadow
   @Final
   private FrustumIntersection intersection;
   @Shadow
   private double camX;
   @Shadow
   private double camY;
   @Shadow
   private double camZ;

   @Redirect(method = "isVisible", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/culling/Frustum;cubeInFrustum(DDDDDD)I"))
   private int hex$testAab(Frustum var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      return FrustumHooks.method10821(this.intersection, this.camX, this.camY, this.camZ, var2, var4, var6, var8, var10, var12);
   }
}
