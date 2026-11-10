// Original binary: sg/mx/1Z7GC9V5aAcrMjWc
package sg.mx;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.EntityCollisionPolicyEvent;

// $VF: Compiled from s
@Mixin(BlockStateBase.class)
public class BlockBehaviour$BlockStateBaseMixin {
   @Inject(method = "isViewBlocking", at = @At("HEAD"), cancellable = true)
   public void shouldBlockVision(BlockGetter var1, BlockPos var2, net.minecraft.world.phys.AABB var4, CallbackInfoReturnable<Boolean> var3) {
      EntityCollisionPolicyEvent.field06700.method02899(EntityCollisionPolicyEvent.Nested73.BLOCK, var3);
   }
}
