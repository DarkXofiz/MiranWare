// Original binary: sg/mx/oihxAnm122W6zGtX
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.renderpearl.backend.vulkan.VulkanGpuSurface;
import java.nio.IntBuffer;
import org.lwjgl.vulkan.VkDevice;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.VulkanSubmitHooks;

// $VF: Compiled from s
@Mixin(VulkanGpuSurface.class)
public class VulkanGpuSurfaceMixin {
   @WrapOperation(
      method = "acquireNextTexture()V",
      at = @At(value = "INVOKE", target = "Lorg/lwjgl/vulkan/KHRSwapchain;vkAcquireNextImageKHR(Lorg/lwjgl/vulkan/VkDevice;JJJJLjava/nio/IntBuffer;)I")
   )
   private int hex$waitOutAcquireStall(VkDevice var1, long var2, long var4, long var6, long var8, IntBuffer var10, Operation<Integer> var11) {
      return VulkanSubmitHooks.method03789(var1, var2, var4, var6, var8, var10, var11);
   }
}
