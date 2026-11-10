// Original binary: sg/mx/EjlTriqbXa3syvLB
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.particle.Particle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.PackedLightCacheHooks;
import sg.ec.PackedLightCacheAccess;

// $VF: Compiled from s
@Mixin(Particle.class)
public class ParticleMixin implements PackedLightCacheAccess {
   private int hex$cachedLight;

   @Override
   public int hex$light() {
      return this.hex$cachedLight;
   }

   @Override
   public void hex$light(int var1) {
      this.hex$cachedLight = var1;
   }

   @Inject(method = "tick", at = @At("HEAD"))
   private void hex$invalidateLight(CallbackInfo var1) {
      PackedLightCacheHooks.method03206(this);
   }

   @WrapMethod(method = "getLightCoords(F)I")
   private int hex$cacheLightCoords(float var1, Operation<Integer> var2) {
      return PackedLightCacheHooks.method03207(this, var1, var2);
   }
}
