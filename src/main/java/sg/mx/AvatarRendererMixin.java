// Original binary: sg/mx/5vPRNAa8Q0Aeg6Ti
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.NameTagRenderEvent;
import sg.ec.EntityRenderStateAccess;
import sg.ec.HeldItemRenderHooks;

// $VF: Compiled from s
@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererMixin {
   @Inject(
      method = "submitNameDisplay(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
      at = @At("HEAD"),
      cancellable = true
   )
   private void hexRenderName(AvatarRenderState var1, PoseStack var2, SubmitNodeCollector var3, CameraRenderState var4, CallbackInfo var5) {
      NameTagRenderEvent.field05154.method02159(((EntityRenderStateAccess)var1).getHexEntity(), var5);
   }

   @WrapOperation(
      method = "renderHand",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/SubmitNodeCollector;submitModelPart(Lnet/minecraft/client/model/geom/ModelPart;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;IILnet/minecraft/client/renderer/texture/UvMapping;)V"
      )
   )
   private void hexRenderTransparentHand(
      SubmitNodeCollector var1, ModelPart var2, PoseStack var3, RenderType var4, int var5, int var6, @Nullable net.minecraft.client.renderer.texture.UvMapping var7, Operation<Void> hex$original) {
      var1.submitModelPart(var2, var3, var4, var5, var6, var7, HeldItemRenderHooks.method05666(-1), 0);
   }
}
