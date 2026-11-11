// Original binary: sg/mx/yZ96tJCQgUK5BEJM
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.renderpearl.backend.vulkan.VulkanRenderPass;
import java.util.HashMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.VulkanRenderPassHooks;

// $VF: Compiled from s
@Mixin(VulkanRenderPass.class)
public class VulkanRenderPassMixin {
   @WrapOperation(method = "<init>", at = @At(value = "NEW", target = "java/util/HashMap", ordinal = 0))
   private static HashMap hex$reuseUniforms(Operation<HashMap> hex$original) {
      return VulkanRenderPassHooks.method08029();
   }

   @WrapOperation(method = "<init>", at = @At(value = "NEW", target = "java/util/HashMap", ordinal = 1))
   private static HashMap hex$reuseTextures(Operation<HashMap> hex$original) {
      return VulkanRenderPassHooks.method08028();
   }
}
