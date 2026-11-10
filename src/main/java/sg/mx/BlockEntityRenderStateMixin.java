// Original binary: sg/mx/TaUCMd92JmKk9ydk
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndLightGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.BlockEntityLightCache;

// $VF: Compiled from s
@Mixin(BlockEntityRenderState.class)
public class BlockEntityRenderStateMixin {
   @WrapOperation(
      method = "extractBase",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/util/LightCoordsUtil;getLightCoords(Lnet/minecraft/world/level/BlockAndLightGetter;Lnet/minecraft/core/BlockPos;)I"
      )
   )
   private static int hex$cachedLightCoords(
      BlockAndLightGetter var0, BlockPos var1, Operation<Integer> var2, BlockEntity var3, BlockEntityRenderState var4, CrumblingOverlay var5
   ) {
      return BlockEntityLightCache.method05926(var0, var1, var3);
   }
}
