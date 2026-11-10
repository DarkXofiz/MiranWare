// Original binary: sg/mx/4MdEQbTR7LhkQ5j9
package sg.mx;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.CobwebCollisionEvent;

// $VF: Compiled from s
@Mixin(WebBlock.class)
public class WebBlockMixin {
   @Inject(method = "entityInside", at = @At("HEAD"), cancellable = true)
   public void onEntityCollision(BlockState var1, Level var2, BlockPos var3, Entity var4, InsideBlockEffectApplier var5, boolean var6, CallbackInfo var7) {
      CobwebCollisionEvent.field27868.method11722(var3, var4, var7);
   }
}
