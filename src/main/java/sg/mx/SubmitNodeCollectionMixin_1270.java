// Original binary: sg/mx/jNDpJouxHfjpituf
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import net.minecraft.client.renderer.SubmitNodeCollection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.PoseStackPool;

// $VF: Compiled from s
@Mixin(SubmitNodeCollection.class)
public class SubmitNodeCollectionMixin_1270 {
   @WrapOperation(
      method = "submitItem",
      at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack$Pose;copy()Lcom/mojang/blaze3d/vertex/PoseStack$Pose;")
   )
   private Pose hex$pooledItemPose(Pose var1, Operation<Pose> hex$original) {
      return PoseStackPool.field02228.method00970(var1);
   }

   @WrapOperation(
      method = "submitModel",
      at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack$Pose;copy()Lcom/mojang/blaze3d/vertex/PoseStack$Pose;")
   )
   private Pose hex$pooledModelPose(Pose var1, Operation<Pose> hex$original) {
      return PoseStackPool.field02228.method00970(var1);
   }
}
