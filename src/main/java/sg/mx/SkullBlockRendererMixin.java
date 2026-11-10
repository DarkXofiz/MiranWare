// Original binary: sg/mx/G8TfCbXFEqdPjz9r
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.Function;
import net.minecraft.client.renderer.PlayerSkinRenderCache;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.blockentity.state.SkullBlockRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.level.block.SkullBlock.Type;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.SkullTextureAccess;
import sg.ec.SkullBlockRendererHooks;
import sg.ec.SkullTextureAtlas;

// $VF: Compiled from s
@Mixin(SkullBlockRenderer.class)
public class SkullBlockRendererMixin {
   @Shadow
   @Final
   private PlayerSkinRenderCache playerSkinRenderCache;
   @Unique
   private int hex$slot;

   @WrapMethod(method = "resolveSkullRenderType")
   private RenderType hex$cachedSkullRenderType(Type var1, SkullBlockEntity var2, Operation<RenderType> var3) {
      this.hex$slot = SkullBlockRendererHooks.method10662(var1, var2, this.playerSkinRenderCache);
      return SkullBlockRendererHooks.method10660(this.hex$slot, var1, var2, this.playerSkinRenderCache, var3);
   }

   @Inject(
      method = "extractRenderState(Lnet/minecraft/world/level/block/entity/SkullBlockEntity;Lnet/minecraft/client/renderer/blockentity/state/SkullBlockRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V",
      at = @At("TAIL")
   )
   private void hex$storeAtlasSlot(SkullBlockEntity var1, SkullBlockRenderState var2, float var3, Vec3 var4, CrumblingOverlay var5, CallbackInfo var6) {
      ((SkullTextureAccess)var2).hex$headSlot(this.hex$slot);
   }

   @Inject(method = "submit", at = @At("HEAD"))
   private void hex$readAtlasSlot(SkullBlockRenderState var1, PoseStack var2, SubmitNodeCollector var3, CameraRenderState var4, CallbackInfo var5) {
      this.hex$slot = ((SkullTextureAccess)var1).hex$headSlot();
   }

   @WrapOperation(method = "submit", at = @At(value = "INVOKE", target = "Ljava/util/function/Function;apply(Ljava/lang/Object;)Ljava/lang/Object;"))
   private Object hex$atlasModel(Function<Object, Object> var1, Object var2, Operation<Object> var3) {
      return this.hex$slot > 0 ? SkullTextureAtlas.INSTANCE.method11602(this.hex$slot - 1) : var3.call(new Object[]{var1, var2});
   }
}
