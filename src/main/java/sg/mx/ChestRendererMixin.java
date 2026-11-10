// Original binary: sg/mx/j4IwTdf3l0aEZ1Ms
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner.Combiner;
import net.minecraft.world.level.block.DoubleBlockCombiner.NeighborCombineResult;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.ChestPairCache;

// $VF: Compiled from s
@Mixin(ChestRenderer.class)
public class ChestRendererMixin {
   @WrapOperation(
      method = "extractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/level/block/ChestBlock;combine(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Z)Lnet/minecraft/world/level/block/DoubleBlockCombiner$NeighborCombineResult;"
      )
   )
   private NeighborCombineResult<? extends ChestBlockEntity> hex$reuseCombineResult(
      ChestBlock var1,
      BlockState var2,
      Level var3,
      BlockPos var4,
      boolean var5,
      Operation<NeighborCombineResult<? extends ChestBlockEntity>> var6,
      BlockEntity var7,
      ChestRenderState var8,
      float var9,
      Vec3 var10,
      CrumblingOverlay var11
   ) {
      return var5 ? ChestPairCache.method00893(var7, var1, var2, var3, var4) : (NeighborCombineResult)var6.call(new Object[]{var1, var2, var3, var4, var5});
   }

   @WrapOperation(
      method = "extractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/level/block/ChestBlock;opennessCombiner(Lnet/minecraft/world/level/block/entity/LidBlockEntity;)Lnet/minecraft/world/level/block/DoubleBlockCombiner$Combiner;"
      )
   )
   private Combiner<ChestBlockEntity, Float2FloatFunction> hex$reuseOpennessCombiner(
      LidBlockEntity var1, Operation<Combiner<ChestBlockEntity, Float2FloatFunction>> var2
   ) {
      return ChestPairCache.method00895(var1);
   }

   @WrapOperation(
      method = "extractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V",
      at = @At(value = "NEW", target = "()Lnet/minecraft/client/renderer/blockentity/BrightnessCombiner;")
   )
   private BrightnessCombiner<BlockEntity> hex$reuseBrightnessCombiner(Operation<BrightnessCombiner<BlockEntity>> var1) {
      return ChestPairCache.method00896();
   }
}
