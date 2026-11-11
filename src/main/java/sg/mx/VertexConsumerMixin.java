// Original binary: sg/mx/758czDynHGTfb3XU
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.VertexConsumerHooks;

// $VF: Compiled from s
@Mixin(VertexConsumer.class)
public interface VertexConsumerMixin {
   @WrapOperation(method = "putBakedQuad", at = @At(value = "NEW", target = "org/joml/Vector3f", ordinal = 0))
   private Vector3f hex$reuseBakedQuadNormal(Operation<Vector3f> hex$original) {
      return VertexConsumerHooks.field16900;
   }

   @WrapOperation(method = "putBakedQuad", at = @At(value = "NEW", target = "org/joml/Vector3f", ordinal = 1))
   private Vector3f hex$reuseBakedQuadPosition(Operation<Vector3f> hex$original) {
      return VertexConsumerHooks.field16901;
   }
}
