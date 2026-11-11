// Original binary: sg/mx/MwmyboJtUstIjKmH
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.resource.GraphicsResourceAllocator;
import com.mojang.blaze3d.resource.ResourceHandle;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LevelTargetBundle;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher.PreparedFrame;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.WorldColorEvent;
import sg.ec.LevelRendererAccess;
import sg.ec.TargetScanRenderer;
import sg.ec.LevelRendererHooks;

// $VF: Compiled from s
@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin implements LevelRendererAccess {
   @Unique
   private Frustum frustum;
   @Unique
   private Matrix4f hexScratchMatrix;
   @Shadow
   @Final
   private SubmitNodeStorage submitNodeStorage;
   @Shadow
   @Final
   private RenderTarget entityOutlineTarget;
   @Shadow
   @Final
   private net.minecraft.client.renderer.state.level.LevelRenderState levelRenderState;

   @Unique
   private Matrix4f hexScratchMatrix() {
      Matrix4f var1 = this.hexScratchMatrix;
      if (var1 == null) {
         var1 = new Matrix4f();
         this.hexScratchMatrix = var1;
      }

      return var1;
   }

   @Override
   public Frustum frustum() {
      return this.frustum;
   }

   @Inject(method = "addSkyPass", at = @At("HEAD"))
   private void hexSkyColor(CallbackInfo var1) {
      net.minecraft.client.renderer.state.level.SkyRenderState var2 = this.levelRenderState.skyRenderState;
      if (var2 != null && var2.skyColor != null) {
         org.joml.Vector3fc var3 = var2.skyColor;
         int var4 = 0xFF000000 | (int)(var3.x() * 255.0F) << 16 | (int)(var3.y() * 255.0F) << 8 | (int)(var3.z() * 255.0F);
         int var5 = WorldColorEvent.field02679.method01252(WorldColorEvent.Nested37.SKY, var4);
         if (var5 != var4) {
            var2.skyColor = new org.joml.Vector3f((var5 >> 16 & 255) / 255.0F, (var5 >> 8 & 255) / 255.0F, (var5 & 255) / 255.0F);
         }
      }
   }

   @Inject(
      method = "render",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/feature/FeatureRenderDispatcher;prepareFrame(Lnet/minecraft/client/renderer/SubmitNodeStorage;)Lnet/minecraft/client/renderer/feature/FeatureRenderDispatcher$PreparedFrame;"
      )
   )
   private void render(
      GraphicsResourceAllocator var1, boolean var2, CameraRenderState var3, GpuBufferSlice var4, Vector4f var5, boolean var6, boolean var7, CallbackInfo var8
   ) {
      this.frustum = var3.cullFrustum;
      TargetScanRenderer.method05986(var3.projectionMatrix);
      LevelRendererHooks.method08951(
         this.submitNodeStorage,
         net.minecraft.client.Minecraft.getInstance().getDeltaTracker(),
         new Matrix4f(com.mojang.blaze3d.systems.RenderSystem.getModelViewStack()),
         this.hexScratchMatrix(),
         this.frustum
      );
   }

   @WrapOperation(
      method = "blitEntityOutline",
      at = @At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/pipeline/RenderTarget;blitAndBlendToTexture(Lcom/mojang/renderpearl/api/textures/GpuTextureView;Lcom/mojang/renderpearl/api/textures/GpuTextureView;)V"
      )
   )
   private void doEntityOutline(RenderTarget var1, GpuTextureView var2, GpuTextureView var3, Operation<Void> hex$original) {
      LevelRendererHooks.method08953(var1, var2, var3);
   }

   @Override
   public RenderTarget hexRawOutlineTarget() {
      return this.entityOutlineTarget;
   }

   @Inject(method = "executeOutline", at = @At("RETURN"))
   private void hexRenderBeforeClear(PreparedFrame var1, CallbackInfo var2) {
      LevelRendererHooks.method08954(var1);
   }
}
