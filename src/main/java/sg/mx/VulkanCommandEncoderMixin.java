// Original binary: sg/mx/NDq78R7xUdVPSnDn
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.renderpearl.backend.vulkan.VulkanCommandEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.VulkanSubmitHooks;

// $VF: Compiled from s
@Mixin(VulkanCommandEncoder.class)
public class VulkanCommandEncoderMixin {
   @WrapOperation(method = "submit()V", at = @At(value = "INVOKE", target = "Lcom/mojang/renderpearl/backend/vulkan/VulkanCommandEncoder;awaitSubmitCompletion(JJ)Z"))
   private boolean hex$waitOutStall(VulkanCommandEncoder var1, long var2, long var4, Operation<Boolean> var6) {
      return VulkanSubmitHooks.method03790(var1, var2, var4, var6);
   }
}
