// Original binary: hex/api/baritone/utils/BlockPlaceHelper
package hex.api.baritone.utils;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.utils.IPlayerContext;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public class BlockPlaceHelper {
   private static final int BASE_PLACE_DELAY = 1;
   private final IPlayerContext ctx;
   private int rightClickTimer;

   BlockPlaceHelper(IPlayerContext var1) {
      this.ctx = var1;
   }

   public void tick(boolean var1) {
      if (this.rightClickTimer > 0) {
         this.rightClickTimer--;
      } else {
         HitResult var2 = this.ctx.objectMouseOver();
         if (var1 && !this.ctx.player().isHandsBusy() && var2 != null && var2.getType() == Type.BLOCK) {
            this.rightClickTimer = Baritone.settings().rightClickSpeed.value - 1;

            for (InteractionHand sx : InteractionHand.values()) {
               if (this.ctx.playerController().processRightClickBlock(this.ctx.player(), this.ctx.world(), sx, (BlockHitResult)var2)
                  == InteractionResult.SUCCESS) {
                  this.ctx.player().swing(sx, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
                  return;
               }

               if (!this.ctx.player().getItemInHand(sx).isEmpty()
                  && this.ctx.playerController().processRightClick(this.ctx.player(), this.ctx.world(), sx) == InteractionResult.SUCCESS) {
                  return;
               }
            }
         }
      }
   }
}
