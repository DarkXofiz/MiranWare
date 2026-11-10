// Original binary: sg/mx/ciyKzy9B0JF4QuJg
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import java.util.List;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.PreparedRenderType.Texture;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import sg.ec.HandRenderPipelines;

// $VF: Compiled from s
@Mixin(RenderType.class)
public abstract class RenderTypeMixin {
   @Shadow
   public abstract RenderPipeline pipeline();

   @ModifyArg(
      method = "prepare",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/rendertype/PreparedRenderType;<init>(Ljava/lang/String;Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;Lnet/minecraft/client/renderer/oit/OitPipelineSet;Lcom/mojang/renderpearl/api/buffers/GpuBufferSlice;Lcom/mojang/blaze3d/systems/ScissorState;Ljava/util/List;)V"
      ),
      index = 1
   )
   private RenderPipeline hexGlossPipeline(RenderPipeline var1) {
      return HandRenderPipelines.method04739(var1);
   }


   @ModifyArg(
      method = "prepare",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/rendertype/PreparedRenderType;<init>(Ljava/lang/String;Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;Lnet/minecraft/client/renderer/oit/OitPipelineSet;Lcom/mojang/renderpearl/api/buffers/GpuBufferSlice;Lcom/mojang/blaze3d/systems/ScissorState;Ljava/util/List;)V"
      ),
      index = 5
   )
   private List<Texture> hexBlurTextures(List<Texture> var1) {
      return HandRenderPipelines.method04747(var1, this.pipeline());
   }

   @ModifyExpressionValue(
      method = "writeDynamicTransforms",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/rendertype/TextureTransform;createMatrix()Lorg/joml/Matrix4f;")
   )
   private Matrix4f hexGlossTextureMatrix(Matrix4f var1) {
      return HandRenderPipelines.method04736(var1, this.pipeline());
   }
}
