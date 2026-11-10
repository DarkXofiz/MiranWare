// Original binary: sg/mx/6GANHrn54ybgUKON
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.particle.SingleQuadParticle;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.IdentityQuaternion;

// $VF: Compiled from s
@Mixin(SingleQuadParticle.class)
public class SingleQuadParticleMixin {
   @WrapOperation(
      method = "extract(Lnet/minecraft/client/renderer/state/level/QuadParticleRenderState;Lnet/minecraft/client/Camera;F)V",
      at = @At(value = "NEW", target = "()Lorg/joml/Quaternionf;")
   )
   private Quaternionf hex$reuseScratchRotation(Operation<Quaternionf> var1) {
      return IdentityQuaternion.method03103();
   }
}
