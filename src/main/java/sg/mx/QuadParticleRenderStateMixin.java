// Original binary: sg/mx/A9lgdI20A1gsHMZl
package sg.mx;

import java.util.Map;
import java.util.function.Function;
import net.minecraft.client.particle.SingleQuadParticle.Layer;
import net.minecraft.client.renderer.state.level.QuadParticleRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// $VF: Compiled from s
@Mixin(QuadParticleRenderState.class)
public class QuadParticleRenderStateMixin {
   @Unique
   private Layer hex$layer;
   @Unique
   private Object hex$storage;

   @Redirect(
      method = "add",
      at = @At(value = "INVOKE", target = "Ljava/util/Map;computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;")
   )
   private Object hex$cachedStorage(Map<Object, Object> var1, Object var2, Function<Object, Object> var3) {
      if (var2 == this.hex$layer) {
         return this.hex$storage;
      }

      Object var4 = var1.computeIfAbsent(var2, var3);
      this.hex$layer = (Layer)var2;
      this.hex$storage = var4;
      return var4;
   }
}
