// Original binary: sg/mx/nx0LQib2oUTsJz2P
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.InvisibleEntityRenderEvent;
import sg.ec.LivingEntityRendererHooks;

// $VF: Compiled from s
@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin_1290<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>>
   extends EntityRenderer<T, S>
   implements RenderLayerParent<S, M> {
   private static final String field28039 = "field28039";

   @Shadow
   private static float solveBodyRot(LivingEntity var0, float var1, float var2) {
      throw new UnsupportedOperationException(field28039);
   }

   protected LivingEntityRendererMixin_1290(Context var1) {
      super(var1);
   }

   @Inject(
      method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V",
      at = @At("HEAD")
   )
   private void updateRenderStateEntity(LivingEntity var1, S var2, float var3, CallbackInfo var4) {
      InvisibleEntityRenderEvent.field06162.method02603(var1);
   }

   @Inject(
      method = "submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
      at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V", ordinal = 0)
   )
   private void hexRenderChinaHat(S var1, PoseStack var2, SubmitNodeCollector var3, CameraRenderState var4, CallbackInfo var5) {
      LivingEntityRendererHooks.method10657(var1, var2, var3, this.getModel());
   }

   @ModifyArg(
      method = "submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;getRenderType(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;ZZZ)Lnet/minecraft/client/renderer/rendertype/RenderType;"
      ),
      index = 1
   )
   private boolean render1(boolean var1, @Local(argsOnly = true) S var2) {
      return LivingEntityRendererHooks.method10658(var2, var1);
   }

   @ModifyArg(
      method = "submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/SubmitNodeCollector;submitModel(Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;IIILnet/minecraft/client/renderer/texture/UvMapping;I)V"
      ),
      index = 6
   )
   private int render(int var1, @Local(argsOnly = true) S var2) {
      return LivingEntityRendererHooks.method10659(var2, var1);
   }

   @WrapOperation(
      method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getXRot(F)F")
   )
   private float updateRenderStatePitch(LivingEntity var1, float var2, Operation<Float> hex$original) {
      return LivingEntityRendererHooks.method10655(var1, var2);
   }

   @WrapOperation(
      method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;solveBodyRot(Lnet/minecraft/world/entity/LivingEntity;FF)F"
      )
   )
   private float updateRenderStateYawBody(LivingEntity var1, float var2, float var3, Operation<Float> hex$original) {
      return LivingEntityRendererHooks.method10654(var1, var3, solveBodyRot(var1, var2, var3));
   }

   @WrapOperation(
      method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;wrapDegrees(F)F")
   )
   private float updateRenderStateYawHead(float var1, Operation<Float> hex$original, @Local(argsOnly = true) float var2,@Local(argsOnly = true) T var3) {
      return LivingEntityRendererHooks.method10656(var3, var2, var1);
   }

}
