// Original binary: sg/mx/Z9svFsWSu6L0WzDZ
package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.NameTagRenderEvent;
import sg.ec.EntityRenderStateAccess;
import sg.ec.EntityGlowRenderer;

// $VF: Compiled from s
@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin_1238<T extends Entity, S extends EntityRenderState> {
   @Inject(
      method = "extractRenderState(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/client/renderer/entity/state/EntityRenderState;F)V",
      at = @At("HEAD")
   )
   private void captureEntity(T var1, S var2, float var3, CallbackInfo var4) {
      ((EntityRenderStateAccess)var2).setHexEntity(var1);
   }

   @Inject(method = "submit", at = @At("HEAD"), cancellable = true)
   private void renderName(S var1, PoseStack var2, SubmitNodeCollector var3, CameraRenderState var4, CallbackInfo var5) {
      NameTagRenderEvent.field05154.method02159(((EntityRenderStateAccess)var1).getHexEntity(), var5);
   }

   @Inject(
      method = "extractRenderState(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/client/renderer/entity/state/EntityRenderState;F)V",
      at = @At("RETURN")
   )
   private void entityGlow(T var1, S var2, float var3, CallbackInfo var4) {
      var2.outlineColor = EntityGlowRenderer.method07048(var1, var2.outlineColor, var3);
   }
}
