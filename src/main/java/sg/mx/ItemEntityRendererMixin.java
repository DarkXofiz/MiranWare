// Original binary: sg/mx/mwSUvPLQh63uTaxg
package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ItemEntityPhysicsAccess;
import sg.ec.ItemPhysicsRenderer;

// $VF: Compiled from s
@Mixin(ItemEntityRenderer.class)
public abstract class ItemEntityRendererMixin extends EntityRenderer<ItemEntity, ItemEntityRenderState> {
   @Shadow
   @Final
   private RandomSource random;

   protected ItemEntityRendererMixin(Context var1) {
      super(var1);
   }

   @Inject(
      method = "submit(Lnet/minecraft/client/renderer/entity/state/ItemEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
      at = @At("HEAD"),
      cancellable = true,
      require = 1
   )
   private void submit(ItemEntityRenderState var1, PoseStack var2, SubmitNodeCollector var3, CameraRenderState var4, CallbackInfo var5) {
      if (ItemPhysicsRenderer.method06931(var1, var2, var3, var4, this.random)) {
         super.submit(var1, var2, var3, var4);
         var5.cancel();
      }
   }

   @Inject(
      method = "extractRenderState(Lnet/minecraft/world/entity/item/ItemEntity;Lnet/minecraft/client/renderer/entity/state/ItemEntityRenderState;F)V",
      at = @At("TAIL"),
      require = 1
   )
   public void injectExtract(ItemEntity var1, ItemEntityRenderState var2, float var3, CallbackInfo var4) {
      ((ItemEntityPhysicsAccess)var2).extractPhysic(var1);
   }
}
